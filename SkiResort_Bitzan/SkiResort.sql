CREATE DATABASE  IF NOT EXISTS `skiresortmonitor` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `skiresortmonitor`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: skiresortmonitor
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `skiresort`
--

DROP TABLE IF EXISTS `skiresort`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skiresort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skiresort`
--

LOCK TABLES `skiresort` WRITE;
/*!40000 ALTER TABLE `skiresort` DISABLE KEYS */;
INSERT INTO `skiresort` VALUES (1,'Ankogel-Mallnitz'),(2,'Bad Kleinkirchheim'),(3,'Dreilaendereck'),(4,'Emberger Alm'),(5,'Falkert');
/*!40000 ALTER TABLE `skiresort` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snowdata`
--

DROP TABLE IF EXISTS `snowdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snowdata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `depth` int(11) NOT NULL,
  `lcldate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `skiresort_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_snowdata_skiresort_idx` (`skiresort_id`),
  CONSTRAINT `fk_snowdata_skiresort` FOREIGN KEY (`skiresort_id`) REFERENCES `skiresort` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snowdata`
--

LOCK TABLES `snowdata` WRITE;
/*!40000 ALTER TABLE `snowdata` DISABLE KEYS */;
INSERT INTO `snowdata` VALUES (1,200,'2019-02-11 23:00:00',1),(2,150,'2019-02-11 23:00:00',2),(3,170,'2019-02-11 23:00:00',3),(4,50,'2019-02-11 23:00:00',4),(5,110,'2019-02-11 23:00:00',5);
/*!40000 ALTER TABLE `snowdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11 15:27:52
