USE assistech;

#TABELA UNIDADE DE SUPORTE
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

#TABELA EMPRESA
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

#TABELA CONTRATO
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
    
#Adicionando a coluna código equipamento à tabela contrato.
ALTER TABLE contrato ADD Cod_Equipamento VARCHAR(8);
#atualizando a chave primária de contrato.
ALTER TABLE contrato DROP PRIMARY KEY; #dropando a chave primária de contrato(cod, ID_Documento, ID_Tipo_Contrato)
#renomeando a coluna COD para COD_Contrato
ALTER TABLE contrato change COD COD_Contrato VARCHAR(5);
ALTER TABLE contrato ADD PRIMARY KEY(COD_Contrato, ID_Documento, ID_Tipo_Contrato, Cod_Equipamento);
#adicionando chave estrangeira Cod_Equipamento a contrato 
ALTER TABLE contrato  
	ADD CONSTRAINT contrato_equipamento_fk foreign key(Cod_Equipamento) references equipamento(Cod_Equipamento);

#adicionando chave estrangeira ID_Documento a contrato. RODAR QUANDO PEGAR O CÓDIGO DE LUCAS    
ALTER TABLE contrato
	ADD CONSTRAINT contrato_documento_fk foreign key(ID_Documento) references documento(ID_Documento) ON DELETE CASCADE ON UPDATE CASCADE;

#TABELA DOCUMENTO
CREATE TABLE documento(
ID_Documento VARCHAR(10),
Tipo VARCHAR(30),
Título VARCHAR(50),
Data_De_Criação DATE,
Arquivo VARCHAR(6),
Versão VARCHAR(4),
CONSTRAINT documento_pk primary key(ID_Documento)
);

#TABELA TIPO_CONTRATO
CREATE TABLE tipo_contrato(
ID_Tipo_Contrato varchar(5),
Descrição Varchar(30),
CONSTRAINT tipo_contrato_pk primary key(ID_Tipo_Contrato)
);

#TABELA EQUIPAMENTO
CREATE TABLE equipamento(
Cod_Equipamento VARCHAR(8),
StatusEquip ENUM('Bom', 'Regular', 'Ruim'),
FabricanteEquip VARCHAR(30),
HistoricoEquip VARCHAR(40),
DescricaoEquip VARCHAR(50),
SetorEquip VARCHAR(20),
DataEntradaEquip DATE,
CONSTRAINT equipamento_pk primary key(Cod_Equipamento)
);