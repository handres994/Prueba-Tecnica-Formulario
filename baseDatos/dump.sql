CREATE DATABASE  IF NOT EXISTS `registro_clientes` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `registro_clientes`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: registro_clientes
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `Id_Ciudad` int NOT NULL,
  `Ciudad` varchar(100) NOT NULL,
  `Id_Departamento` int NOT NULL,
  PRIMARY KEY (`Id_Ciudad`),
  KEY `Id_Departamento` (`Id_Departamento`),
  CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`Id_Departamento`) REFERENCES `departamento` (`Id_Departamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1001,'Medellín',101),(1002,'Rionegro',101),(1003,'Barranquilla',102),(1004,'Cartagena',103),(1005,'Tunja',104),(1006,'Manizales',105),(1007,'Florencia',106),(1008,'Valledupar',107),(1009,'Bogotá',108),(1010,'Neiva',109),(1011,'Villavicencio',110),(1012,'Acacías',110),(1013,'Cúcuta',111),(1014,'Armenia',112),(1015,'Pereira',113),(1016,'Bucaramanga',114),(1017,'Barrancabermeja',114),(1018,'Ibagué',115),(1019,'Cali',116),(1020,'Palmira',116),(1021,'Pasto',117),(1022,'Montería',118),(2001,'San Juan',201),(2002,'Carolina',201),(2003,'Ponce',201),(2004,'Caguas',201),(2005,'Bayamón',201),(2006,'Barceloneta',201),(3001,'Ciudad de Panamá',301),(4001,'San José',401),(5001,'Ciudad de Guatemala',501),(6001,'Quito',601),(7001,'Lima',701),(8001,'Houston',801);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Id_Cliente` int NOT NULL AUTO_INCREMENT,
  `Numero_Identificacion` varchar(30) NOT NULL,
  `Tipo_Identificacion` int NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Fecha_Nacimiento` date NOT NULL,
  `Direccion` varchar(200) NOT NULL,
  `Ciudad` int NOT NULL,
  `Departamento` int NOT NULL,
  `Pais` int NOT NULL,
  PRIMARY KEY (`Id_Cliente`),
  UNIQUE KEY `Tipo_Identificacion` (`Tipo_Identificacion`,`Numero_Identificacion`),
  UNIQUE KEY `UKc7qtm7sx3nkp1q654aggcu1gs` (`Tipo_Identificacion`,`Numero_Identificacion`),
  KEY `Ciudad` (`Ciudad`),
  KEY `Departamento` (`Departamento`),
  KEY `Pais` (`Pais`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`Tipo_Identificacion`) REFERENCES `tipo_identificacion` (`Id_Identificacion`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`Ciudad`) REFERENCES `ciudad` (`Id_Ciudad`),
  CONSTRAINT `cliente_ibfk_3` FOREIGN KEY (`Departamento`) REFERENCES `departamento` (`Id_Departamento`),
  CONSTRAINT `cliente_ibfk_4` FOREIGN KEY (`Pais`) REFERENCES `pais` (`Id_Pais`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (12,'1234567891',1,'Rafael','Sanchez','2008-07-08','cll 123 # 5 6',1002,101,1),(13,'1014253064',1,'Harold','Mejia','2025-08-29','cll 65 12345',1001,101,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_por_marca`
--

DROP TABLE IF EXISTS `clientes_por_marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_por_marca` (
  `cliente` int NOT NULL,
  `marca` int NOT NULL,
  PRIMARY KEY (`cliente`,`marca`),
  KEY `FKk9uq9fjwcxyks9petaxnyr2wr` (`marca`),
  CONSTRAINT `FKaw91qe9ohges9lej48rpss7t0` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`Id_Cliente`),
  CONSTRAINT `FKk9uq9fjwcxyks9petaxnyr2wr` FOREIGN KEY (`marca`) REFERENCES `marca` (`Id_Marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_por_marca`
--

LOCK TABLES `clientes_por_marca` WRITE;
/*!40000 ALTER TABLE `clientes_por_marca` DISABLE KEYS */;
INSERT INTO `clientes_por_marca` VALUES (1,1),(4,1),(5,2),(1,3),(13,3),(1,4),(11,6),(12,6);
/*!40000 ALTER TABLE `clientes_por_marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_pormarca`
--

DROP TABLE IF EXISTS `clientes_pormarca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_pormarca` (
  `Cliente` int NOT NULL,
  `Marca` int NOT NULL,
  PRIMARY KEY (`Cliente`,`Marca`),
  KEY `Marca` (`Marca`),
  CONSTRAINT `clientes_pormarca_ibfk_1` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`Id_Cliente`),
  CONSTRAINT `clientes_pormarca_ibfk_2` FOREIGN KEY (`Marca`) REFERENCES `marca` (`Id_Marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_pormarca`
--

LOCK TABLES `clientes_pormarca` WRITE;
/*!40000 ALTER TABLE `clientes_pormarca` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes_pormarca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `Id_Departamento` int NOT NULL,
  `Departamento` varchar(100) NOT NULL,
  `Id_Pais` int NOT NULL,
  PRIMARY KEY (`Id_Departamento`),
  KEY `Id_Pais` (`Id_Pais`),
  CONSTRAINT `departamento_ibfk_1` FOREIGN KEY (`Id_Pais`) REFERENCES `pais` (`Id_Pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (101,'Antioquia',1),(102,'Atlántico',1),(103,'Bolívar',1),(104,'Boyacá',1),(105,'Caldas',1),(106,'Caquetá',1),(107,'Cesar',1),(108,'Cundinamarca',1),(109,'Huila',1),(110,'Meta',1),(111,'Norte de Santander',1),(112,'Quindío',1),(113,'Risaralda',1),(114,'Santander',1),(115,'Tolima',1),(116,'Valle del Cauca',1),(117,'Nariño',1),(118,'Córdoba',1),(201,'Puerto Rico',2),(301,'Panamá',3),(401,'San José',4),(501,'Guatemala',5),(601,'Pichincha',6),(701,'Lima Metropolitana',7),(801,'Texas',8);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marca` (
  `Id_Marca` int NOT NULL,
  `Marca` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_Marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Americanino'),(2,'American Eagle'),(3,'Chevignon'),(4,'Esprit'),(5,'Naf Naf'),(6,'Rifle');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `Id_Pais` int NOT NULL,
  `Pais` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_Pais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Colombia'),(2,'Puerto Rico'),(3,'Panamá'),(4,'Costa Rica'),(5,'Guatemala'),(6,'Ecuador'),(7,'Perú'),(8,'Estados Unidos');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_identificacion`
--

DROP TABLE IF EXISTS `tipo_identificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_identificacion` (
  `Id_Identificacion` int NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_Identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_identificacion`
--

LOCK TABLES `tipo_identificacion` WRITE;
/*!40000 ALTER TABLE `tipo_identificacion` DISABLE KEYS */;
INSERT INTO `tipo_identificacion` VALUES (1,'Cédula de ciudadanía'),(2,'Cédula de extranjería'),(3,'Pasaporte');
/*!40000 ALTER TABLE `tipo_identificacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-29 22:25:34
