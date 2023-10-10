CREATE TABLE `exames` (
  `id` INT NOT NULL,
  `doc_crm` varchar(10) DEFAULT NULL,
  `doc_num` varchar(11) DEFAULT NULL,
  `nome_exame` varchar(255) DEFAULT NULL,
  `permission` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `medico` (
  `id` INT NOT NULL,
  `doc_crm` varchar(255) DEFAULT NULL,
  `doc_name` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

CREATE TABLE `paciente` (
  `id` INT NOT NULL,
  `doc_name` varchar(255) DEFAULT NULL,
  `doc_num` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 