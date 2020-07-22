-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: petshop
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `buy`
--

DROP TABLE IF EXISTS `buy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `product_id` int NOT NULL,
  `rendered` varchar(40) NOT NULL,
  `note` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `price` double(6,2) NOT NULL,
  `discount` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `buy_ibfk_1` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `buy_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buy`
--

LOCK TABLES `buy` WRITE;
/*!40000 ALTER TABLE `buy` DISABLE KEYS */;
/*!40000 ALTER TABLE `buy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `cpf` int NOT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `cellphone` int DEFAULT NULL,
  `gender` enum('m','f','b') DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  `pet` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `role` varchar(100) DEFAULT NULL,
  `salary` double(6,2) DEFAULT NULL,
  `cpf` int DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `cellphone` int DEFAULT NULL,
  `gender` char(3) DEFAULT NULL,
  `dateofbirth` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `breed` varchar(20) NOT NULL,
  `animal_tipe` varchar(20) NOT NULL,
  `owner` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `owner` (`owner`),
  CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `client` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(60) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `quantity` int NOT NULL,
  `provider` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `provider` (`provider`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`provider`) REFERENCES `provider` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'ração de cachorro',20.00,50,NULL),(2,'lacinho',10.00,200,NULL),(3,'ração de gato',30.00,100,NULL),(4,'semente de girassol',15.00,20,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provider`
--

DROP TABLE IF EXISTS `provider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provider` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provider`
--

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;
/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-22 15:15:49
