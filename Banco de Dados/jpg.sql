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
  `medico` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `mensagem` text,
  `data` date DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `medico` (`medico`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividades`
--

LOCK TABLES `atividades` WRITE;
/*!40000 ALTER TABLE `atividades` DISABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
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
  `medico` int(11) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `mensagem` text NOT NULL,
  `data` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `medico` (`medico`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noticias`
--

LOCK TABLES `noticias` WRITE;
/*!40000 ALTER TABLE `noticias` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paciente` (
  `cpf` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `data_nascimento` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `cep` varchar(10) NOT NULL,
  `telefone` int(11) NOT NULL,
  `outro_contato` varchar(40) DEFAULT NULL,
  `sexo` enum('M','F') DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `triagem`
--

DROP TABLE IF EXISTS `triagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `triagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_medico` int(11) NOT NULL,
  `cpf_paciente` int(11) NOT NULL,
  `alteracao_paladar` enum('S','N') NOT NULL,
  `disturbios_gastrintestinais` enum('S','N') NOT NULL,
  `falta_ar` enum('S','N') NOT NULL,
  `tosse` enum('S','N') NOT NULL,
  `febre` enum('S','N') NOT NULL,
  `dor_garganta` enum('S','N') NOT NULL,
  `dificuldade_respirar` enum('S','N') NOT NULL,
  `perda_olfato` enum('S','N') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cpf_paciente` (`cpf_paciente`),
  KEY `id_medico` (`id_medico`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `triagem`
--

LOCK TABLES `triagem` WRITE;
/*!40000 ALTER TABLE `triagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `triagem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-19 19:14:52
