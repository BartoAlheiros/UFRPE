#Lista 2. 2aVA
#José Bartolomeu Alheiros Dias Neto

USE company;

SELECT * from department;

#Criando a tabela dept_sal. Que realaciona todos os números de departamento
#com o total do salário dos empregados do mesmo.
CREATE TABLE dept_sal as
	SELECT dnumber,
    0 as totalsalary from department;
    
SELECT * from dept_sal;    

#Criando um stored procedure updateSalary, para atualizar os salários na tabela dept_sal     
delimiter //
create procedure updateSalary(IN param1 int)
begin
	update dept_sal
    set totalsalary = (select sum(salary) from employee where dno = param1)
    where dnumber = param1;
end; //

#chamando o procedimento para atualizar o campo totalsalary de cada departamento
call updateSalary(5);

DROP procedure if exists updateSalary;

#exemplo updateSalary com cursor
delimiter //
create procedure updateSalary()
begin
		declare done int default 0;
        declare current_dnum int;
        declare dnumcur cursor for select dnumber for deptsal;
        
