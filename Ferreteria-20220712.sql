CREATE DATABASE  IF NOT EXISTS `ferreteria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ferreteria`;
-- MySQL dump 10.13  Distrib 8.0.29, for macos12 (x86_64)
--
-- Host: localhost    Database: ferreteria
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tornillos`
--

DROP TABLE IF EXISTS `tornillos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tornillos` (
  `idtornillos` int NOT NULL AUTO_INCREMENT,
  `codigoSku` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `pesoUnidad` int DEFAULT '0',
  `precio` double NOT NULL,
  `stock` int NOT NULL,
  `bajaLogica` smallint DEFAULT '0',
  PRIMARY KEY (`idtornillos`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tornillos`
--

LOCK TABLES `tornillos` WRITE;
/*!40000 ALTER TABLE `tornillos` DISABLE KEYS */;
INSERT INTO `tornillos` VALUES (4,'TA38','Torn Allen 3/8',10,1.25,140,0),(5,'TA114','Torn Allen 1 1/4',15,1.75,250,0),(6,'TCR38','Torn Cabeza Redonda 3/8',1,2,300,0),(7,'TCF214','Torn Cabeza Frezada 2 1/4',24,3.9,300,0),(19,'TCF38','Torn Cabeza Frezada 3/8',17,2.5,100,0),(21,'TA38d','Prueba D',2,3,100,1),(22,'ta114d','dfdf',3,4,5,1);
/*!40000 ALTER TABLE `tornillos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-13  3:35:48
