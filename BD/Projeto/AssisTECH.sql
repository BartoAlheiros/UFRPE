USE assistech;

CREATE TABLE UNIDADE_DE_SUPORTE(
CNPJ VARCHAR(14), 
estado VARCHAR(10),
uf VARCHAR(2), 
endereco VARCHAR(30), 
nome VARCHAR(15), 
matriz VARCHAR(20),
primary key(CNPJ) );

alter table unidade_de_suporte 
change estado Estado VARCHAR(10),
change uf UF VARCHAR(2), 
change endereco Endereço VARCHAR(30), 
change nome Nome VARCHAR(15), 
change matriz Matriz VARCHAR(20);

#tentando resolver o problema de não conseguir adicionar CNPJ como chave estrangeira de empresa
alter table unidade_de_suporte change CNPJ CNPJ INTEGER(14);
alter table unidade_de_suporte add RazãoSocial VARCHAR(20);
alter table unidade_de_suporte change RazãoSocial RazaoSocial VARCHAR(20);

ALTER TABLE unidade_de_suporte
CHANGE COLUMN RazaoSocial RazaoSocial VARCHAR(20) NOT NULL ,
DROP PRIMARY KEY,
ADD PRIMARY KEY (RazaoSocial);

#ajeitando as besteiras que fiz nas linhas de cima
ALTER TABLE unidade_de_suporte drop primary key;
ALTER TABLE unidade_de_suporte add primary key(CNPJ);
#adicionando constraint...
ALTER TABLE unidade_de_suporte drop primary key;
ALTER TABLE unidade_de_suporte add constraint unidade_sup_cnpj_pk primary key(CNPJ);

CREATE TABLE empresa(
CNPJ INTEGER(14),
RazaoSocial VARCHAR(20),
Endereço VARCHAR(30),
Fone VARCHAR(15),
CONSTRAINT empresa_cnpj_pk primary key(CNPJ)
);

ALTER TABLE empresa
ADD CONSTRAINT CNPJ_empresa_fk
  FOREIGN KEY (CNPJ)
  REFERENCES unidade_de_suporte(CNPJ)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
#agora há um caminho entre empresa e unidade_de_suporte e vice-versa
CREATE TABLE contrato(
COD VARCHAR(5),
DataInicio DATE,
DataFim DATE,
StatusContrato ENUM('Aberto', 'Finalizado'),
ID_Documento VARCHAR(10),
ID_Tipo_Contrato VARCHAR(5),
CONSTRAINT contrato_pk primary key(cod, ID_Documento, ID_Tipo_Contrato)
);

ALTER TABLE contrato
	ADD CONSTRAINT contrato_ID_Documento_fk foreign key(ID_Documento) references documento(ID_Documento) ON DELETE CASCADE ON UPDATE CASCADE,
	ADD CONSTRAINT contrato_ID_Tipo_Contrato_fk foreign key(ID_Tipo_Contrato) references tipo_contrato(ID_Tipo_Contrato) ON DELETE CASCADE ON UPDATE CASCADE;


CREATE TABLE documento(
ID_Documento VARCHAR(10),
Tipo VARCHAR(30),
Título VARCHAR(50),
Data_De_Criação DATE,
Arquivo VARCHAR(6),
Versão VARCHAR(4),
CONSTRAINT documento_pk primary key(ID_Documento)
);

CREATE TABLE tipo_contrato(
ID_Tipo_Contrato varchar(5),
Descrição Varchar(30),
CONSTRAINT tipo_contrato_pk primary key(ID_Tipo_Contrato)
);

CREATE TABLE equipamento(
