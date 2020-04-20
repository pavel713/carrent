-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: prokat
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `model` varchar(45) NOT NULL,
  `color` varchar(45) NOT NULL,
  `rented` tinyint(4) DEFAULT NULL,
  `plate_num` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (1,'BMW ','Black',NULL,'0001AA7',2010,80),(2,'Mercedes_benz ','Gray',NULL,'0002XX7',2015,200),(3,'Mazda ','Red',NULL,'0003CC7',2015,60),(4,'Audi','Green',NULL,'0004QQ7',2019,90),(5,'Volkswagen','White',NULL,'0005BG7',20,200),(6,'BMW','Yellow',0,'0006EE7',2015,150),(7,'Skoda','Yellow',NULL,'0007EE7',2015,150),(8,'Audi','Yellow',NULL,'0010CP7',2015,85),(9,'Renault','Yellow',NULL,'0008EE7',2015,150),(10,'Mazda','Gray',NULL,'0101DD7',2016,80),(13,'Buick','Yellow',NULL,'0010XX7',2010,110),(14,'BMW','Black',NULL,'0001XX7',2017,200),(15,'BMW','Black',NULL,'0010XX7',2020,300);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` int(45) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `passport` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` int(12) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Name_UNIQUE` (`name`),
  UNIQUE KEY `passport_UNIQUE` (`passport`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  KEY `fk_client_contract1_idx` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Alex','MP1254789','MINSK KOLASA 4',293156292,'123456'),(6,'Ivan','PP1112235','MINSK KOLASA 4',445559988,'123345'),(7,'LARISA IVANOVA','PP5559964','GOMEL RDUZHNAYA 1',296043451,'qwerty123');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contract`
--

DROP TABLE IF EXISTS `contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_begin` date NOT NULL,
  `date_end` date NOT NULL,
  `client_id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `employee` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `date_begin_UNIQUE` (`date_begin`),
  UNIQUE KEY `date_end_UNIQUE` (`date_end`),
  UNIQUE KEY `client_id_UNIQUE` (`client_id`),
  UNIQUE KEY `employee_UNIQUE` (`employee`),
  KEY `car_fk_idx` (`car_id`),
  CONSTRAINT `car_fk` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contract`
--

LOCK TABLES `contract` WRITE;
/*!40000 ALTER TABLE `contract` DISABLE KEYS */;
INSERT INTO `contract` VALUES (1,'2020-04-01','2020-04-05',1,1,1);
/*!40000 ALTER TABLE `contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damage`
--

DROP TABLE IF EXISTS `damage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `damage` (
  `id` int(11) NOT NULL,
  `contract_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `result` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contract_number_idx` (`contract_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `contract_number` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damage`
--

LOCK TABLES `damage` WRITE;
/*!40000 ALTER TABLE `damage` DISABLE KEYS */;
/*!40000 ALTER TABLE `damage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` int(45) NOT NULL,
  KEY `emp_fk_idx` (`id`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`id`) REFERENCES `contract` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Pasha',291112233);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-20 19:19:58
