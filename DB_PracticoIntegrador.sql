-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: practicointegrador
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `pronosticos`
--

DROP TABLE IF EXISTS `pronosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pronosticos` (
  `ID_Jugada` int(11) NOT NULL AUTO_INCREMENT,
  `Ronda` int(11) DEFAULT NULL,
  `Jugador` varchar(45) DEFAULT NULL,
  ` Equipo_1` varchar(45) DEFAULT NULL,
  `GanaLocal` tinyint(4) DEFAULT NULL,
  `Empata` tinyint(4) DEFAULT NULL,
  `GanaVisita` tinyint(4) DEFAULT NULL,
  `Equipo2` varchar(45) DEFAULT NULL,
  `ID_Jugador` int(11) DEFAULT NULL,
  `ID_Partido` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Jugada`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronosticos`
--

LOCK TABLES `pronosticos` WRITE;
/*!40000 ALTER TABLE `pronosticos` DISABLE KEYS */;
INSERT INTO `pronosticos` VALUES (1,1,'Pablo','ARG',1,0,0,'ARA',1,1),(2,1,'Pablo','MEX',0,1,0,'POL',1,2),(3,2,'Pablo','ARG',1,0,0,'MEX',1,3),(4,2,'Pablo','POL',0,0,1,'ARA',1,4),(5,3,'Pablo','POL',0,0,1,'ARG',1,5),(6,3,'Pablo','ARA',0,0,1,'MEX',1,6),(7,1,'Messi','ARG',1,0,0,'ARA',2,1),(8,1,'Messi','MEX',1,0,0,'POL',2,2),(9,2,'Messi','ARG',1,0,0,'MEX',2,3),(10,2,'Messi','POL',0,1,0,'ARA',2,4),(11,3,'Messi','POL',1,0,0,'ARG',2,5),(12,3,'Messi','ARA',0,1,0,'MEX',2,6),(13,1,'Scaloni','ARG',0,0,1,'ARA',3,1),(14,1,'Scaloni','MEX',0,1,0,'POL',3,2),(15,2,'Scaloni','ARG',1,0,0,'MEX',3,3),(16,2,'Scaloni','POL',1,0,0,'ARA',3,4),(17,3,'Scaloni','POL',0,0,1,'ARG',3,5),(18,3,'Scaloni','ARA',0,0,1,'MEX',3,6);
/*!40000 ALTER TABLE `pronosticos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-26 19:57:13
