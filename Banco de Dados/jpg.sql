-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: jpg
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atividades`
--

DROP TABLE IF EXISTS `atividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `atividades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) CHARACTER SET latin1 NOT NULL,
  `titulo` varchar(50) CHARACTER SET latin1 NOT NULL,
  `mensagem` text CHARACTER SET latin1 NOT NULL,
  `data` date NOT NULL,
  `status` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades`
--

LOCK TABLES `atividades` WRITE;
/*!40000 ALTER TABLE `atividades` DISABLE KEYS */;
INSERT INTO `atividades` VALUES (18,'admin2020','Realizar testes no sistma','Relatar a ausência de bugs no sistema JPG','2020-11-27','A fazer'),(11,'miguel','Projeto Integrador 3','Finalizar o Marco 3 do projeto.','2020-11-20','Em andamento'),(17,'miguel','Projeto Integrador 3','Hospedar projeto na nuvem.','2020-11-27','Em andamento'),(16,'miguel','Projeto Integrador 3','Documentar o cód. fonte completo ','2020-11-12','Em andamento');
/*!40000 ALTER TABLE `atividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `medicos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `crm` varchar(10) NOT NULL,
  `especializacao` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES (1,'Miguel','miguel castro do nascimento','miguel@jpg.com','aaaaaa','348784/sp','Cardiologista Geral'),(2,'admin2020','administrador','admin@ti.com','aaaaaa','0000000/sp','administrador do sistema'),(3,'adminadmin','admin','admin@ti.com','aaaaaa','dwadwadawd','admin');
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noticias`
--

DROP TABLE IF EXISTS `noticias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `mensagem` text NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `medico` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
INSERT INTO `noticias` VALUES (1,'miguel','Reunião - JPG','Reunião com todos os Sócios e Colaboradores as 10hrs.','2020-11-19'),(2,'admin2020',' Atualização do sistema','O sistema JPG irá passar por uma atulaização em 10/11 - 00:00 ás 06:00.','2020-11-25'),(3,'miguel','xfxdfxdf','dxfxdfdxf','2020-11-25');
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `triagens`
--

DROP TABLE IF EXISTS `triagens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `triagens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(12) CHARACTER SET latin1 NOT NULL,
  `nome` varchar(40) CHARACTER SET latin1 NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(40) CHARACTER SET latin1 NOT NULL,
  `cep` varchar(6) CHARACTER SET latin1 NOT NULL,
  `estado` varchar(40) CHARACTER SET latin1 NOT NULL,
  `contato1` varchar(40) CHARACTER SET latin1 NOT NULL,
  `contato2` varchar(40) CHARACTER SET latin1 NOT NULL,
  `sexo` varchar(20) CHARACTER SET latin1 NOT NULL,
  `febre` varchar(5) CHARACTER SET latin1 NOT NULL,
  `tosse_seca` varchar(5) CHARACTER SET latin1 NOT NULL,
  `cansaco` varchar(5) CHARACTER SET latin1 NOT NULL,
  `falta_ar` varchar(5) CHARACTER SET latin1 NOT NULL,
  `pressao_peito` varchar(5) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf_UNIQUE` (`cpf`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `triagens`
--

LOCK TABLES `triagens` WRITE;
/*!40000 ALTER TABLE `triagens` DISABLE KEYS */;
INSERT INTO `triagens` VALUES (2,'168168468486','Miguel Castro','2020-11-12','teste@te.com','464866','São Paulo','4516516516468','','masculino','Sim','Não','Sim','Sim','Não');
/*!40000 ALTER TABLE `triagens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-18 16:15:38
