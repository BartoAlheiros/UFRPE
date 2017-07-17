USE UNIVERSIDADE;

#1
SELECT matricula_pessoa, nome
FROM pessoa
WHERE sexo = 'M'
ORDER BY nome;

#2
SELECT matricula_pessoa, nome
FROM pessoa, professor
WHERE sexo = 'M' AND matricula_pessoa = matricula_professor
ORDER BY nome;

#3
SELECT ministra.codigo_disciplina, max(ministra.ano_semestre)
FROM professor, pessoa, ministra, turma, disciplina
WHERE professor.matricula_professor = ministra.matricula_professor
		AND ministra.codigo_disciplina = turma.codigo_disciplina
		AND pessoa.matricula_pessoa = professor.matricula_professor
		AND pessoa.nome = 'Sirenio Arruda';

#4
SELECT m.codigo_disciplina, max(m.ano_semestre)
FROM 
	professor prof JOIN pessoa p 
		ON prof.matricula_professor = p.matricula_pessoa
	JOIN ministra m
		ON prof.matricula_professor = m.matricula_professor
	JOIN turma t
		ON t.codigo_disciplina = m.codigo_disciplina
WHERE p.nome = 'Sirenio Arruda';   							

#5
SELECT p.nome, d.codigo_disciplina
FROM 
	disciplina d JOIN turma t 
		ON d.codigo_disciplina = t.codigo_disciplina
    JOIN monitoria m
		ON m.codigo_disciplina = t.codigo_disciplina
    JOIN aluno a
		ON a.matricula_aluno = m.matricula_aluno
     JOIN pessoa p
		ON p.matricula_pessoa = a.matricula_aluno
GROUP BY(d.codigo_disciplina)
HAVING d.codigo_disciplina <= 3;  

#6
SELECT p.nome as pessoa, p2.nome as lider
FROM 
	professor prof JOIN pessoa p 
		ON prof.matricula_professor = p.matricula_pessoa
    JOIN professor lider
		ON lider.matricula_lider = prof.matricula_lider
    JOIN pessoa p2
		ON lider.matricula_lider = p2.matricula_pessoa
GROUP BY(p.nome);

#7
SELECT p.nome as nome_aluno, a.matricula_aluno as matricula, t.ano_semestre as semestre, proj.codigo_projeto
FROM 
	aluno a JOIN pessoa p 
		ON a.matricula_aluno = p.matricula_pessoa
	JOIN aluno_turma t
		ON t.matricula_aluno = a.matricula_aluno
    JOIN projeto proj
		ON proj.codigo_projeto = t.codigo_projeto
    ;

#8
SELECT p.matricula_pessoa as matricula, p.nome as nome_professor, prof.data_admissao 
FROM
	professor prof JOIN pessoa p
		ON prof.matricula_professor = p.matricula_pessoa
WHERE prof.data_admissao < '1995' OR prof.data_admissao > '2005';
