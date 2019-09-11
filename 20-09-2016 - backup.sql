-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gym
-- ------------------------------------------------------
-- Server version	5.5.44

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `idActividad` int(11) NOT NULL AUTO_INCREMENT,
  `actividad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idActividad`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,'Spinning'),(2,'Zumba'),(3,'Musculación'),(4,'Cross Funcional'),(5,'INDOOR BIKE'),(6,'AEROTRAINING'),(7,'GAP'),(8,'INDOOR-CROSS'),(9,'ACROBACIA EN TELAS');
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividades_socios_turnos`
--

DROP TABLE IF EXISTS `actividades_socios_turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades_socios_turnos` (
  `idRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `pases` int(11) DEFAULT NULL,
  `socio` int(11) DEFAULT NULL,
  `relacion` int(11) DEFAULT NULL,
  `paseLibre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRelacion`),
  KEY `FK_csc8lkqvo5bt4wo6xk11waj1v` (`socio`),
  KEY `FK_lsdynq0km513v2y06jilypicj` (`relacion`),
  CONSTRAINT `FK_csc8lkqvo5bt4wo6xk11waj1v` FOREIGN KEY (`socio`) REFERENCES `socios` (`idSocio`),
  CONSTRAINT `FK_lsdynq0km513v2y06jilypicj` FOREIGN KEY (`relacion`) REFERENCES `relaciones` (`idRelacion`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_socios_turnos`
--

LOCK TABLES `actividades_socios_turnos` WRITE;
/*!40000 ALTER TABLE `actividades_socios_turnos` DISABLE KEYS */;
INSERT INTO `actividades_socios_turnos` VALUES (1,1,3,23,0),(2,-1,9,23,1),(3,6,2,1,0),(4,0,2,15,0),(5,8,2,4,0),(6,0,30,23,1),(7,0,33,23,1),(8,4,34,2,0),(9,4,34,22,0),(10,0,29,23,1),(11,1,35,23,0),(12,8,1,2,0),(13,6,1,18,0),(14,8,1,20,0),(15,8,1,8,0),(16,8,36,18,0),(17,8,36,20,0),(18,0,36,24,0),(19,12,53,3,0),(20,12,53,7,0),(21,0,61,23,1),(22,8,71,4,0),(23,8,67,4,0),(24,8,67,6,0),(25,8,67,23,0),(26,8,68,4,0),(27,8,68,6,0),(28,8,68,23,0),(29,8,38,11,0),(30,0,38,10,0),(31,0,23,23,1),(32,8,7,44,0),(33,0,24,44,0);
/*!40000 ALTER TABLE `actividades_socios_turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja_diaria`
--

DROP TABLE IF EXISTS `caja_diaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja_diaria` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `debe` float DEFAULT NULL,
  `haber` float DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  `idFormaPago` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `FK_42ne3epj5ot8ux97unoqpsq5c` (`idFormaPago`),
  CONSTRAINT `FK_42ne3epj5ot8ux97unoqpsq5c` FOREIGN KEY (`idFormaPago`) REFERENCES `formas_pago` (`idFormaPago`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja_diaria`
--

LOCK TABLES `caja_diaria` WRITE;
/*!40000 ALTER TABLE `caja_diaria` DISABLE KEYS */;
INSERT INTO `caja_diaria` VALUES (1,'2016-08-31 22:16:56',1,'Apertura de Caja',0,0,0,1),(2,'2016-08-31 22:25:42',5,'30303030 - cuotas',0,300,300,1),(3,'2016-08-31 22:30:32',8,'Diferencia de Arqueo',0,0,300,1),(4,'2016-08-31 22:30:32',9,'Cierre de Caja',0,0,300,1),(5,'2016-08-31 23:14:31',1,'Apertura de Caja',0,0,300,1),(6,'2016-08-18 23:14:18',5,'30303030 - CUOTA',0,999,1299,1),(7,'2016-08-04 03:00:00',5,'30303030 - CUOTA',0,99,1398,1),(8,'2016-09-01 20:31:38',5,'30303030 - SEPTIEMBRE COMBO ZUMBA INDOOR',0,350,1748,1),(9,'2016-09-01 20:38:55',4,'aGUA',200,0,1548,1),(10,'2016-09-01 20:44:07',8,'Diferencia de Arqueo',0,1912,3460,1),(11,'2016-09-01 20:44:07',9,'Cierre de Caja',0,0,3460,1),(12,'2016-09-01 20:44:39',1,'Apertura de Caja',0,0,3460,1),(13,'2016-09-01 20:45:07',8,'Diferencia de Arqueo',-3460,0,0,1),(14,'2016-09-01 20:45:07',9,'Cierre de Caja',0,0,0,1),(15,'2016-09-01 20:59:58',1,'Apertura de Caja',0,0,0,1),(16,'2016-09-01 20:49:34',5,'30303030 - CUOTA SEPON',0,350,350,1),(17,'2016-09-01 21:03:42',2,'CAMBIO',0,100,450,1),(18,'2016-09-01 03:00:00',4,'CEC',150,0,300,1),(19,'2016-09-01 21:10:37',8,'Diferencia de Arqueo',0,150,450,1),(20,'2016-09-01 21:10:37',9,'Cierre de Caja',0,0,450,1),(21,'2016-09-01 21:11:25',1,'Apertura de Caja',0,0,450,1),(22,'2016-09-06 20:48:06',5,'33269525 - asignacion de pases',0,0,450,1),(23,'2016-09-05 03:00:00',5,'29476388 - musculacion libre',0,350,800,1),(24,'2016-09-05 03:00:00',5,'25208265 - COMBINADO X 8',0,330,1130,1),(25,'2016-08-03 21:59:23',5,'43607610 - MES DE AGOSTO',0,350,1480,1),(26,'2016-08-23 13:11:36',5,'23764250 - Cuota pase Libre Agosto',0,430,1910,1),(27,'2016-09-06 03:00:00',3,'retiro cuota picone',430,0,1480,1),(28,'2016-09-06 13:40:01',8,'Diferencia de Arqueo',-1353,0,127,1),(29,'2016-09-06 13:40:01',9,'Cierre de Caja',0,0,127,1),(30,'2016-09-06 13:41:35',1,'Apertura de Caja',0,0,127,1),(31,'2016-09-01 21:38:52',5,'38003202 - CUOTA SEPTIEMBRE',0,400,527,1),(32,'2016-09-01 03:00:00',5,'37094897 - CUOTA DE SEPTIEMBRE',0,380,907,1),(33,'2016-09-05 03:00:00',5,'27545759 - CUOTA DE SEPTIEMBRE',0,350,1257,1),(34,'2016-09-06 03:00:00',5,'33269525 - CUOTA DE SEPTIEMBRE',0,350,1607,1),(35,'2016-09-06 03:00:00',5,'38105803 - CUOTA DE SEPTIEMRE',0,350,1957,1),(36,'2016-09-06 12:44:24',5,'29606574 - cuota de septiembre',0,330,2287,1),(37,'2016-09-06 03:00:00',5,'17768245 - cuota de septiembre mecanico',0,430,2717,1),(38,'2016-09-06 13:00:40',5,'17485042 - cuota de septiembre mecanico',0,480,3197,1),(39,'2016-08-01 13:11:46',5,'39497376 - cuota de agosto',0,330,3527,1),(40,'2016-09-07 13:27:43',5,'38329299 - cuota de septiembre',0,350,3877,1),(41,'2016-08-05 13:37:10',5,'37523834 - cuota de agosto',0,350,4227,1),(42,'2016-09-02 14:00:13',5,'25753567 - cuota de septiembre',0,350,4577,1),(43,'2016-09-08 23:49:14',5,'43605007 - llollo',0,300,4877,1),(44,'2016-09-08 23:50:47',5,'15632714 - llkjyhiu',0,300,5177,1),(45,'2016-09-09 00:02:21',5,'37438354 - cuota septiembre',0,300,5477,1),(46,'2016-09-09 00:14:24',5,'15632714 - cuota',0,123,5600,1),(47,'2016-09-09 22:29:23',5,'15632714 - ',0,100,5700,1),(48,'2016-09-09 03:00:00',5,'25451991 - asd',0,100,5800,1),(49,'2016-09-09 23:23:22',5,'22564139 - asdasd',0,100,5900,1),(50,'2016-09-10 01:16:07',5,'39494961 - asdasd',0,300,6200,1),(51,'2016-09-14 23:39:39',5,'47907408 - sdfsf',0,100,6300,1),(52,'2016-09-14 23:41:22',5,'37438354 - zxczx',0,300,6600,1),(53,'2016-09-15 13:00:53',5,'27171852 - cuota',0,300,6900,1);
/*!40000 ALTER TABLE `caja_diaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuotas_registros`
--

DROP TABLE IF EXISTS `cuotas_registros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuotas_registros` (
  `idRegistro` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `idSocio` int(11) DEFAULT NULL,
  `idFormaPago` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRegistro`),
  KEY `FK_i5ft4h1u8xmc48moou7l3d3o6` (`idSocio`),
  KEY `FK_cwadv5rbclh57sh0s6m6i59ro` (`idFormaPago`),
  CONSTRAINT `FK_cwadv5rbclh57sh0s6m6i59ro` FOREIGN KEY (`idFormaPago`) REFERENCES `formas_pago` (`idFormaPago`),
  CONSTRAINT `FK_i5ft4h1u8xmc48moou7l3d3o6` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotas_registros`
--

LOCK TABLES `cuotas_registros` WRITE;
/*!40000 ALTER TABLE `cuotas_registros` DISABLE KEYS */;
INSERT INTO `cuotas_registros` VALUES (1,'2016-09-05 03:00:00',350,'musculacion libre',33,1),(2,'2016-09-05 03:00:00',330,'COMBINADO X 8',34,1),(3,'2016-08-03 21:59:23',350,'MES DE AGOSTO',29,1),(4,'2016-08-23 13:11:36',430,'Cuota pase Libre Agosto',1,1),(5,'2016-09-01 21:38:52',400,'CUOTA SEPTIEMBRE',36,1),(6,'2016-09-01 03:00:00',380,'CUOTA DE SEPTIEMBRE',53,1),(7,'2016-09-05 03:00:00',350,'CUOTA DE SEPTIEMBRE',56,1),(8,'2016-09-06 03:00:00',350,'CUOTA DE SEPTIEMBRE',30,1),(9,'2016-09-06 03:00:00',350,'CUOTA DE SEPTIEMRE',61,1),(10,'2016-09-06 12:44:24',330,'cuota de septiembre',71,1),(11,'2016-09-06 03:00:00',430,'cuota de septiembre mecanico',67,1),(12,'2016-09-06 13:00:40',480,'cuota de septiembre mecanico',68,1),(13,'2016-08-01 13:11:46',330,'cuota de agosto',38,1),(14,'2016-09-07 13:27:43',350,'cuota de septiembre',78,1),(15,'2016-08-05 13:37:10',350,'cuota de agosto',66,1),(16,'2016-09-02 14:00:13',350,'cuota de septiembre',14,1),(17,'2016-09-08 23:49:14',300,'llollo',12,1),(18,'2016-09-08 23:50:47',300,'llkjyhiu',14,1),(19,'2016-09-09 00:02:21',300,'cuota septiembre',19,1),(20,'2016-09-09 00:14:24',123,'cuota',14,1),(21,'2016-09-09 22:29:23',100,'',14,1),(22,'2016-09-09 03:00:00',100,'asd',20,1),(23,'2016-09-09 23:23:22',100,'asdasd',79,1),(24,'2016-09-10 01:16:07',300,'asdasd',26,1),(25,'2016-09-14 23:39:39',100,'sdfsf',10,1),(26,'2016-09-14 23:41:22',300,'zxczx',19,1),(27,'2016-09-15 13:00:53',300,'cuota',7,1);
/*!40000 ALTER TABLE `cuotas_registros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dias`
--

DROP TABLE IF EXISTS `dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dias` (
  `idDia` int(11) NOT NULL AUTO_INCREMENT,
  `dia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idDia`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias`
--

LOCK TABLES `dias` WRITE;
/*!40000 ALTER TABLE `dias` DISABLE KEYS */;
INSERT INTO `dias` VALUES (1,'Domingo'),(2,'Lunes'),(3,'Martes'),(4,'Miércoles'),(5,'Jueves'),(6,'Viernes'),(7,'Sábado');
/*!40000 ALTER TABLE `dias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilios`
--

DROP TABLE IF EXISTS `domicilios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilios` (
  `idDomicilio` int(11) NOT NULL AUTO_INCREMENT,
  `Calle` varchar(255) DEFAULT NULL,
  `Nro` varchar(255) DEFAULT NULL,
  `Piso` varchar(255) DEFAULT NULL,
  `Dpto` varchar(255) DEFAULT NULL,
  `Barrio` varchar(255) DEFAULT NULL,
  `codigoPostal` varchar(255) DEFAULT NULL,
  `idLocalidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idDomicilio`),
  KEY `FK_cdvgb8r5hco7dq86ntwpmrkrg` (`idLocalidad`),
  CONSTRAINT `FK_cdvgb8r5hco7dq86ntwpmrkrg` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilios`
--

LOCK TABLES `domicilios` WRITE;
/*!40000 ALTER TABLE `domicilios` DISABLE KEYS */;
INSERT INTO `domicilios` VALUES (1,'ARMANDO RUTILLI','503','','','NUEVO RIO CEBALLOS','jTextField1',6),(2,'VIGO','760','','','MAIPU','jTextField1',6),(3,'','760','','','Centro','jTextField1',6),(4,'','760','','','VILLA LOS ALTOS','jTextField1',6),(5,'Lamadrid','760','','','AGUA DE ORO','jTextField1',6),(6,'Lamadrid','760','','','ÑU PORA','jTextField1',6),(7,'AMUCHASTEGUI ','118','','','LA QUEBRADA','5111',2),(8,'AMUCHASTEGUI','118','','','LA QUEBRADA','5111',2),(9,'rio negro','23','','','','5111',2),(10,'MARTA FERRI ','238','','','NUEVO RIO CEBALLOS','5111',1),(11,'AV SAN MARTIN ','7710','','','CENTRO','5111',1),(12,'LOS ROBLES','1647','','','RIO CEBALLOS','5111',1),(13,'SALTA','111','','','CENTRO','5111',1),(14,'ITALLA','65','','','RIO CEBALLO9S','5111',1),(15,'CACEROS','45','','','RIO CEBALLOS','5111',2),(16,'RUTA E53 KM 17 MZA23 LOTE 13','','','','VILLA CATALINA','5111',1),(18,'ND','1','','','ND','5111',2),(19,'AV SARMIENTO ESQUINA NEUQUEN','','','','SALSIPUEDES','5111',3),(20,'AV. SARMIENTO ESQUINA','10','10','10','SALSIPUEDES','5111',3),(21,'aristoteles','531','0','0','rio ceballos','5111',2),(22,'TEHUELCHES ','141','0','0','PIZARRO','5111',2),(23,'atahualpa yupanqui','298','','','nd','5111',2),(24,'ND','0','0','0','ND','5112',3),(25,'av san martin','7710','0','0','rio ceballos','5111',2),(26,'ciudad de rosario','100','0','0','rio ceballos','5111',2),(27,'don orione','180','0','0','rio ceallos','5111',2),(28,'ruta e-53 km 40','0','0','0','rio ceballos','5111',2),(29,'av sarmiento esquina neuquen s/n','0','0','0','rio ceballos','5111',2),(30,'juan jose paso ','117','0','0','rio ceballos','5111',2),(31,'marta ferri','238','0','0','rio ceballos','5111',2),(32,'echeverria ','67','0','0','rio ceballos','5111',2),(33,'ortiz de ocampo','812','0','0','rio ceballos','5111',2),(34,'a','0','0','0','rio ceballos','5111',2),(35,'buenos aires','88','0','0','rio ceballos','5111',2),(36,'ruta e-53 km 17 villa catalina','0','0','0','a','5111',2),(37,'ruta e-53','km.17','','','villa catalina','5111',2),(38,'GOYA ESQ ECHEVERRIA','0','','','NO DIJO','5111',2),(39,'los nogales','1755','','','nd','5111',2),(40,'AURELIO COLOMBA','344','0','0','BELLA VISTA','5111',2),(41,'VIRGEN DE ITATI','179','0','0','PARQUE LUJAN','5111',2),(42,'MUYICA LAINEZ','57','0','0','RIO CEBALLOS','5111',2),(43,'LOS ROBLES','1329','0','0','RIO CEBALLOS','5111',2),(44,'RAWSON','95','0','0','RIO CEBALLOS','5111',2),(45,'BUENOS AIRES','88','0','0','RIO CEBALLOS','5111',2),(46,'MARCONI','0','0','0','AGUA DE ORO','0',4),(47,'FLUMIN','101','0','0','SALSIPUEDES','0',NULL),(48,'FOVONIES','516','0','0','RIO CEBALLOS','5111',NULL),(49,'UTE 24 MZA 21','0','0','0','VILLA CATALINA','',NULL),(50,'LLONARDO DA VINA','0','0','0','RIO CEBALLOS','5111',NULL),(51,'ATAHUALPA YUPANQUI Y DEAN FUNES ','586','0','0','RIO CEBALLOS','5111',NULL),(52,'SARMIENTO','522','0','0','RIO CEBALLOS','5111',NULL),(53,'R. FOURNIER','0','0','0','RIO CEBALLOS','5111',2),(54,'FOURNIER','545','0','0','RIO CEBALLOS','5111',2),(55,'MOSCONI','261','0','0','RIO CEBALLOS','5111',2),(56,'SAAVEDRA','223','0','0','RIO CEBALLOS','5111',NULL),(57,'AV. 12 DE OCTUBRE','1567','0','0','RIO CEBALLOS','5111',2),(58,'PJE URQUIZA ','54','0','0','LA QUEBRADA','5111',2),(59,'JUAREZ CELMAN ','69','0','0','PARQUE ATALAYA','5111',2),(60,'FLORIDA','35','0','0','RIO CEBALLOS','5111',2),(61,'PELMON S/N LOTE 78','0','0','0','RIO CEBALLOS','5111',2),(62,'SAN MARTIN','3705','0','0','RIO CEBALLOS','5111',2),(63,'BENITO LYNCH S/N ','0','0','0','SALSIPUEDES','0',3),(64,'9 DE JULIO S/N','0','0','0','RIO CEBALLOS','5111',2),(65,'BARRIO LOS BASCO','0','0','0','LOS BASCO','5111',2),(66,'URQUIZA','54','0','0','LA QUEBRADA','5111',2),(67,'12 DE OCTUBRE','256','0','0','RIO CEBALLOS','5111',2),(68,'JOSE MARTI','100','0','0','PARQUE ATALAYA','5111',2),(69,'MUJICA','56','0','0','RIO CEBALOS','5111',2),(70,'LOR ROBLES','1329','0','0','VILLA LOS ALTOS','5111',2),(71,'SAAVEDRA','223','0','0','RIO CEBALLOS','5111',2),(72,'QUISQUIZACATE','135','0','0','CANTEGRIL','5111',2),(73,'FLORIDA','94','0','0','RIO CEBALLOS','5111',2),(74,'QUISQUIZACATE','343','0','0','RIO CEBALLOS','5111',2),(75,'CATAMARCA','143','0','0','RIO CEBALLOS','5111',2),(76,'AV SAN MARTIN','372','0','0','RIO CEBALLOS','5111',2),(77,'AV. SAN MARTIN','372','0','0','BARRIO LOZA','5111',2),(78,'BENITO MOULE','180','0','0','BARRIO SARMIENTO','5111',2),(79,'SUYAY','70','0','0','ÑU PORA','5111',2),(80,'BELGRANO ','25','0','0','rio ceballos','5111',2),(81,'ernesto negrette','320','0','0','salsipuedes','5111',3),(82,'san martin ','4346','0','0','centro','5111',2),(83,'atahualpa yupanqui','298','0','0','agua del peñon','5111',2),(84,'pacheco de melo','185','0','0','rio ceballos','5111',2),(85,'pilco mayo','0','0','0','rio ceballos','5111',2),(86,'ameghino','59','0','0','rio ceballos','5111',2),(87,'diaguitas','252','','','los vascos','5111',2),(88,'diaguitas','252','','','los vascos','5111',2);
/*!40000 ALTER TABLE `domicilios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_civil`
--

DROP TABLE IF EXISTS `estado_civil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_civil` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `estadoCivil` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
INSERT INTO `estado_civil` VALUES (1,'Soltero'),(2,'Casado'),(3,'Viudo'),(4,'Divorciado'),(5,'ND');
/*!40000 ALTER TABLE `estado_civil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formas_pago`
--

DROP TABLE IF EXISTS `formas_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formas_pago` (
  `idFormaPago` int(11) NOT NULL AUTO_INCREMENT,
  `formaPago` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idFormaPago`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formas_pago`
--

LOCK TABLES `formas_pago` WRITE;
/*!40000 ALTER TABLE `formas_pago` DISABLE KEYS */;
INSERT INTO `formas_pago` VALUES (1,'Contado'),(2,'Débito'),(3,'Crédito'),(4,'Cheques');
/*!40000 ALTER TABLE `formas_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gastos`
--

DROP TABLE IF EXISTS `gastos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gastos` (
  `idGasto` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `concepto` varchar(255) DEFAULT NULL,
  `importe` float DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idGasto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
INSERT INTO `gastos` VALUES (1,'2016-09-01 20:38:55','aGUA',200,0),(2,'2016-09-01 03:00:00','CEC',150,0),(3,'2016-09-06 03:00:00','retiro cuota picone',430,0);
/*!40000 ALTER TABLE `gastos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horarios` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `horario` varchar(255) DEFAULT NULL,
  `idDia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idHorario`),
  KEY `FK_8w8porjhwagj0erqf3dj6t9a4` (`idDia`),
  CONSTRAINT `FK_8w8porjhwagj0erqf3dj6t9a4` FOREIGN KEY (`idDia`) REFERENCES `dias` (`idDia`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'Lunes - 8:00 - 9:00',2),(2,'Lunes - 8:30 - 9:30',2),(3,'Lunes - 15:00 - 16:00',2),(4,'Lunes - 18:00 - 19:00',2),(5,'Lunes - 19:00 - 20:00',2),(6,'Lunes - 20:00 - 21:00',2),(7,'Lunes - 21:00 - 22:00',2),(8,'Martes - 8:30 - 9:30',3),(9,'Martes - 15:00 - 16:00',3),(10,'Martes - 19:00 - 20:00',3),(11,'Martes - 20:00 - 21:00',3),(12,'Martes - 21:00 - 22:00',3),(13,'Miércoles - 8:30 - 9:30',4),(14,'Miércoles - 18:00 - 19:00',4),(15,'Miércoles - 19:00 - 20:00',4),(16,'Miércoles - 20:00 - 21:00',4),(17,'Miércoles - 21:00 - 22:00',4),(18,'Jueves - 21:00 - 22:00',5),(19,'Jueves - 20:00 - 21:00',5),(20,'Jueves - 19:00 - 20:00',5),(21,'Jueves - 18:00 - 19:00',5),(22,'Jueves - 19:00 - 20:00',5),(23,'Jueves - 15:00 - 16:00',5),(24,'Jueves - 8:30 - 9:30',5),(25,'Viernes - 8:30 - 9:30',6),(26,'Viernes - 15:00 - 16:00',6),(27,'Viernes - 18:00 - 19:00',6),(28,'Viernes - 19:00 - 20:00',6),(29,'Viernes - 20:00 - 21:00',6),(30,'Viernes - 21:00 - 22:00',6),(31,'Pase Libre',1),(32,'Lunes - 16:00 - 16:00',2),(33,'Viernes - 16:00 - 15:00',6),(34,'Lunes - 9:30 - 10:30',2),(35,'Lunes - 10:00 - 11:00',2),(36,'Lunes - 10:30 - 11:30',2),(37,'Martes - 8:00 - 9:00',3),(38,'Martes - 9:00 - 10:00',3),(39,'Martes - 10:00 - 11:00',3),(40,'Miércoles - 8:00 - 9:00',4),(41,'Miércoles - 9:00 - 10:00',4),(42,'Miércoles - 10:00 - 11:00',4),(43,'Jueves - 8:00 - 9:00',5),(44,'Jueves - 9:00 - 10:00',5),(45,'Jueves - 10:00 - 11:00',5),(46,'Viernes - 8:00 - 9:00',6),(47,'Viernes - 9:00 - 10:00',6),(48,'Viernes - 10:00 - 11:00',6),(49,'Sábado - 10:00 - 11:00',7),(50,'Sábado - 11:00 - 12:00',7),(51,'Lunes a Viernes  - 8:30 - 11:00',1),(52,'Lunes a Viernes - 15:00 a 22:00',1);
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `Localidad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'Córdoba'),(2,'Río Ceballos'),(3,'Salsipuedes'),(4,'Agua de Oro'),(5,'Mendiolaza'),(6,'Candonga');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `pais` varchar(255) DEFAULT NULL,
  `codigoPais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `idParametro` int(11) NOT NULL AUTO_INCREMENT,
  `parametro` varchar(255) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `valorString` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idParametro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (1,'estadoCaja',0,'1'),(2,'cantidadMovimientos',0,'1'),(3,'mysqldump',1,'C:\\Users\\Emiliano\\wamp64\\bin\\mysql\\mysql5.7.9\\bin\\mysqldump.exe'),(4,'razonSocial',1,'L\'Essence'),(5,'logotipo',0,NULL);
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `DNI` varchar(255) DEFAULT NULL,
  `Telefono` varchar(255) DEFAULT NULL,
  `Celular` varchar(255) DEFAULT NULL,
  `CorreoElectronico` varchar(255) DEFAULT NULL,
  `FechaNacimiento` datetime DEFAULT NULL,
  `Hijos` int(11) DEFAULT NULL,
  `Sexo` int(11) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `idEstado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `FK_fsx3fyd0gd21td4h9e9dc1on7` (`idEstado`),
  CONSTRAINT `FK_fsx3fyd0gd21td4h9e9dc1on7` FOREIGN KEY (`idEstado`) REFERENCES `estado_civil` (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'SUSI','ALANIZ','28653438','','03543-63180','','2016-08-31 19:11:46',1,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(2,'SANTIAGO','ABUD','30303030','','3513720659','','2016-08-31 19:11:44',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(3,'RAMIRO','MAIO','20202020','','03543519247','','2016-08-31 19:11:52',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(4,'ALEJANDRA','CACERES','18181818','3513416192','3513416192','','2016-08-31 19:11:50',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(5,'DAVID','OYOLA','19091919','3513416192','3513416192','','2016-08-31 19:11:48',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(6,'BENJAMIN','VALENTE','33333333','3513416192','3513416192','','2016-08-31 19:11:49',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(7,'CYNTHIA VALERIA','PICONE','23764250','03543-450428','0351-2366105','C.PICONE@LIVE.COM.AR','1974-08-08 00:00:00',1,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(8,'MELINA AYLEN ','CALDERON','39497132','03543-455191','3518179692','MELICALD@HOTMAIL.COM','1996-01-22 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(9,'LUCIANO','MARTINEZ','29549473','03543-453177','03543-15513719','LUCIANO ARIELMARTINEZ@GMAIL.COM','1982-08-24 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(10,'MIGUEL','VENANZONI','17160201','03543-453506','0351-156318194','MIGUELVENANZONI@PINTURASMICAM-P.COM.AR','1965-06-04 00:00:00',3,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(11,'NOELIA','REMEDI','28647840','03543-153381','0351-153751002','NOELIAREMEDI@HOTMAIL.COM','1981-02-21 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(12,'JULIETA','STIMOLO','40662141','','0351-153931169','STIMOLOJULIETA@GMAIL.COM','1997-08-28 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(13,'PABLO','NEGRINI','27171852','','03543-15573347','','1979-02-11 00:00:00',2,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(14,'RAMIRO PEDRO','GONZALEZ','37872408','03543-452951','03543-15582832','','1993-12-14 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(15,'VERONICA','SCIZA','30734995','03543-156093965','03543-15600397','','1984-03-27 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(16,'CATALINA','AGUERO','47907408','0351-153572727','0351-156373536','','2007-05-09 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(18,'NATALIA','BARRIENTOS LIBERMAN','43605007','ND','NATUBARLIBER7@GMAIL.COM','ND','2001-09-02 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',2),(19,'MATIAS IVAN ','AQUINO CABRAL','37615935','03543493068','0354315519545','AQUINOMATIAS.CBA@GMAIL.COM','1993-05-10 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(21,'ERIKA','KLAPPENBACH','15632714','3543632714','','eriphoto78769@gmail.com','1969-08-07 04:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(22,'LOURDES SELENA','ORTEGA','40416395','03515721509','3513759683','LULY_RENATEAMO@HOTMAIL.COM','1997-09-15 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',4),(25,'MORENA','AGUIRRE','37438354','3543450051','3543640124','aaguirremorenaa@gmail.com','1994-02-03 00:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(26,'DAVID','RAVIOLA','25451991','03543453391','0351153751001','davidraviola@hotmail.com','1977-01-09 03:00:00',0,1,'jar:file:/H:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(27,'AGUSTIN ALEJANDRO','POGGIO','39954216','03543475706','3513759683','alejopo_12@hotmail.com','1996-09-25 03:00:00',0,1,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(28,'MARIA SOL','FERRER','12345678','0354315556529','0354315321','solferrer2015@hotmail.com','0097-09-19 00:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(29,'CECILIA','RENARD','25753567','0351156061429','0351153791980','cecilia_renard@hotmail.com','0077-10-12 00:00:00',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(30,'MATIAS IVAN','AQUINO CABRAL','37615935','03543493068','0354315519549','aquinomatias.cba@gmail.com','0093-05-10 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(31,'VICTORIA','BARRIENTOS','44694797','451402','3543626194','luz.viki@hotmail.com','2003-03-24 00:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(32,'CAMILA','VENANZONI','39494961','0351152044161','0351156157200','venanzonicami@gmail.com','1996-01-28 03:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(33,'ESTELA','ESCALANTE','14478614','454695','3513049753','tartadeestela@yahoo.com.ar','0061-11-25 00:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',5),(34,'VIOLETA','MAZZONI','45488486','0351155950547','666666','1111@hotmail.com','2004-04-16 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(35,'AGUISTIN','NEGRETTE','43607610','3543517644','3513910816','aa@hotmail.com','2001-10-12 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(36,'CINTIA','SANTANDER','33269525','15626073','000000','cs.negra@gmail.com','1987-10-10 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(37,'MARIA FERNANDA','TURUCHETTI','24241824','555555','0351156373536','qqqq@hotmail.com','0075-01-19 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(38,'DANIELA','CÓRDOBA','37999037','3543459766','351267366','dani.cordoba@outlook.com','1993-09-08 03:00:00',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(39,'ZAIDA','ELHAIBE','29476388','03543-15559433','0351-153477150','zaiturka@gmail.com','1982-05-13 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(40,'MOIRA S.','FEDELICH','25208265','nd','3543692426','fedelichmoira@gmail.com','1976-04-25 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(41,'VERONICA','YORIO','23966464','03514659629','','veronicayorioproducciones@live.com.ar','2016-09-06 09:56:58',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(42,'NATALIA','PALMA','38003202','0351-153190245','0351-156138714','NATIPALMA7@GMAIL.COM','1994-01-07 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(43,'MARIA EUGENIA','MARTIN','33938548','03543459082','3543632843','MEMARTIN90@GMAIL.COM','0089-04-06 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(44,'ANA CAROLINA','MARTIN','39497376','03543450450','0351152099411','ANACAROLINAMAR@LOVE.COM','1996-05-10 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(45,'GABRIELA','VERGARA','28270875','455716','15625272','GABYJVERGARA@HOTMAIL.COM','1980-08-05 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(46,'MAURICIO','SANTANDER','34868637','03543450120','3513840249','MAURETE886@GMAIL.COM','0089-12-16 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(47,'MIGUEL','AGUIRRE','26508990','03525493970','0','0','0078-05-11 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(48,'BELEN','ZAVALA','29606316','3543477462','35168339743','0','0082-07-01 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(49,'LUCIANO','AVILA','35667201','3543517652','15519984','0','0090-09-05 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(50,'PABLO','MELONI','29203139','3513076374','0','LICMELONI@HOTMAIL.COM.AR','0082-01-09 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(51,'BENJAMIN','AROGON','35963437','03543453795','0351153198085','BENJAMIN_AROGON@HOTMAIL.COM','0091-06-18 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(52,'CARLA','ACOSTA AGUERO','35667314','454145','0354315579671','ACOSTACARLA@HOTMAIL.COM','0091-02-20 00:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(53,'LUCIANO','MIHALEC','26720871','3543583068','0','LUCIATRINILUNA@GMAIL.COM','0098-07-07 00:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',5),(54,'NICOLAS','BUDOVSKI','39814903','03543452669','0354315623025','NICOBUDOVSKI@HOTMAIL.COM','0096-11-08 03:00:00',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(55,'FEDERICO','BUDOVSKI','33355798','0','0354315651526','FEDEBUDO@HOTMAIL.COM','0098-05-16 03:00:00',0,1,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',1),(56,'MARIA AGUSTINA','FENOSI','39735113','03543452424','0354315618229','MAGUSTINAFENOSI@GMAIL.COM','0096-11-14 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(57,'LUCAS','BULACIO','39175875','0','0354315639942','LUCAS_BURLA@HOTMAIL.COM','0096-01-16 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(58,'RODOLFO','CORVECHER','36428964','03543454527','3543558107','RODO_22_RV@HOTMAIL.COM','1992-03-13 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(59,'MARIA BELEN','GIRAUDO','37094897','03543452935','0354315553674','BELU.GIRAUDO@HOTMAIL.COM','0092-11-12 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(60,'TATIANA BELEN','CESTARE','40124646','03543450709','3543580544','TATI40CESTARE@HOTMAIL.COM','0097-02-22 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(61,'SOLANGE','BOETSCH','24280824','03543451335','0351156173718','SOLANGEBOETS@HOTMAIL.COM','0074-11-04 03:00:00',0,0,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(62,'LUCAS','VILLALBA','27545759','0','0351156799649','VILLALBALUCAS@HOTMAIL.COM','1979-08-11 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(63,'JUAN','SPINZANTI','37440064','03543450682','3543654729','JUAN_SARPADO2006@HOTMAIL.COM','0093-10-24 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(64,'GISEL DAYANA','SANCHEZ','36985821','3517692723','3543693969','GIISEL.D.SANCHEZ821@HOTMAIL.COM','0092-07-12 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(65,'YAMILA FLORENCIA','TESTA','38987494','493119 ','0351156769969','FLORCHIS_@HOTMAIL.COM','0095-07-05 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(66,'JUAN CARLOS','NIETO','32426969','0','0354315602185','0','0016-04-05 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(67,'MAXIMILIANO','GIRAUDO','38105803','452935','0351158054906','MAXIMILIANO.GIRAUDO@HOTMAIL.COM','0094-02-13 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(68,'GERMAN EZEQUIEL','CARBALLO','36124126','0351152308669','0','0','0090-10-21 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(69,'LUCIANO ARIEL','PEREZ ARGUELLO','28113852','0351156189586','0351152454603','LAPA7117@GMAIL.COM','0080-04-18 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(70,'GLORIA','OLMEDO','13494617','455393','1555973','0','0057-12-12 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(71,'MIRIAM','MARTIN','13683293','450450','0','0','1957-06-20 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',2),(72,'BRUNO','BULACIO','37523834','4554661','0354315576330','BRUNO_BULACIO@HOTMAIL.COM','1993-09-15 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(73,'ALEJANDRA MARIA','MATLEGA','17768245','035435451786','450550','0','1966-09-05 04:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',2),(74,'JOSE MARIA','ALBANESE','17485042','451786','0351155510391','0','1966-02-01 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(75,'JOSE GABRIEL','ACTIS DANA','38161106','03543452149','0351153470635','ACTISGABRIEL@GMAIL.COM','1994-07-27 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(76,'LUCAS','MONTOYA','32426840','451485','0354315550869','LUCASMONTOYA@HOTMAIL.COM','1986-08-13 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(77,'MARIA LAURA','ORDOÑEZ','29606574','452131','0354315515789','M.LAURAORDOÑEZ@LIVE.COM.AR','1982-07-21 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',2),(78,'JULIETA NATALIA','PERA','33701016','03543453504','0','PICKU_@HOTMAIL.COM','1988-04-12 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(79,'PATRICIA MABEL','VEGA','2457499','0','0351152482547','0','1975-08-02 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(80,'ROCIO AZUL','BENITEZ','40518196','03543450498','3543626439','ROBENITEZLALALA@LIVE.COM.AR','1997-08-06 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(81,'VALENTINA','CASTILLO','40135597','450569','15692495','vale__castillo@hotmail.com','1998-01-28 03:00:00',0,2,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(82,'OSVALDO JOSE','NEGRETTE','28708327','03543452858','0351153910816','0','1981-03-25 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(83,'HERNAN ALBERTO','MARTINEZ','22452890','451671','0351155518874','hernanalbertomartinez@gmail.com','1971-11-28 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(84,'EMILIANO','FERREYRA','38329299','03543454552','3543510816','emixferre@gmail.com','1994-05-24 03:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(85,'LAURA','QUERUZ CHEMES','22564139','455233','0351155520768','0','1972-02-06 03:00:00',0,1,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',1),(86,'LIDIA MERCEDES','GRUDE','16654626','450816','15535386','mercedesgrude@hotmail.com','1964-10-02 04:00:00',0,1,'jar:file:/C:/GymMaven/target/GymMaven-1.0-SNAPSHOT.jar!/recursos/Lessence.png',1),(87,'FLORENCIA NADIN','BARRERA ','36986532','455835','0','0','1992-12-11 02:00:00',0,2,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',1),(88,'EMILIANO','POLICARDO','30782195','353535635','3513416192','emi@asdsa,com','1984-12-17 00:00:00',0,1,'file:/C:/Users/Emiliano/Documents/NetBeansProjects/Clonados/GymMaven/target/classes/recursos/Lessence.png',1);
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas_domicilios`
--

DROP TABLE IF EXISTS `personas_domicilios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas_domicilios` (
  `idDomicilio` int(11) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `ORDEN` int(11) NOT NULL,
  PRIMARY KEY (`idPersona`,`ORDEN`),
  KEY `FK_hbugn8tttyh90iyw2uum40oli` (`idDomicilio`),
  CONSTRAINT `FK_hbugn8tttyh90iyw2uum40oli` FOREIGN KEY (`idDomicilio`) REFERENCES `domicilios` (`idDomicilio`),
  CONSTRAINT `FK_pypo5d6sxrhisk8w4rwdn1y8s` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas_domicilios`
--

LOCK TABLES `personas_domicilios` WRITE;
/*!40000 ALTER TABLE `personas_domicilios` DISABLE KEYS */;
INSERT INTO `personas_domicilios` VALUES (1,1,0),(2,2,0),(3,3,0),(4,4,0),(5,5,0),(6,6,0),(7,7,0),(7,7,1),(8,8,0),(9,9,0),(10,10,0),(11,11,0),(12,12,0),(13,13,0),(14,14,0),(15,15,0),(15,15,1),(16,16,0),(18,18,0),(18,18,1),(19,19,0),(21,21,0),(21,21,1),(21,21,2),(21,21,3),(21,21,4),(21,21,5),(22,22,0),(24,25,0),(24,25,1),(24,25,2),(24,25,3),(25,26,0),(25,26,1),(25,26,2),(26,27,0),(26,27,1),(26,27,2),(26,27,3),(26,27,4),(27,28,0),(27,28,1),(27,28,2),(27,28,3),(27,28,4),(28,29,0),(29,30,0),(30,31,0),(30,31,1),(30,31,2),(31,32,0),(31,32,1),(31,32,2),(32,33,0),(32,33,1),(33,34,0),(34,35,0),(35,36,0),(36,37,0),(37,38,0),(38,39,0),(39,40,0),(40,41,0),(41,42,0),(42,43,0),(43,44,0),(44,45,0),(45,46,0),(46,47,0),(47,48,0),(48,49,0),(49,50,0),(50,51,0),(51,52,0),(52,53,0),(53,54,0),(54,55,0),(54,55,1),(55,56,0),(56,57,0),(57,58,0),(58,59,0),(59,60,0),(60,61,0),(61,62,0),(62,63,0),(63,64,0),(64,65,0),(65,66,0),(66,67,0),(67,68,0),(68,69,0),(69,70,0),(70,71,0),(71,72,0),(72,73,0),(73,74,0),(74,75,0),(75,76,0),(76,77,0),(77,78,0),(78,79,0),(79,80,0),(80,81,0),(81,82,0),(82,83,0),(83,84,0),(84,85,0),(84,85,1),(85,86,0),(86,87,0),(88,88,0);
/*!40000 ALTER TABLE `personas_domicilios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores`
--

DROP TABLE IF EXISTS `profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAlta` datetime DEFAULT NULL,
  `documento1` varchar(255) DEFAULT NULL,
  `documento2` varchar(255) DEFAULT NULL,
  `persona` int(11) DEFAULT NULL,
  `idEstado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProfesor`),
  KEY `FK_cbcq765e57yhl3tt328506gd2` (`persona`),
  KEY `FK_p4xkvwuocbu8hu7b31yydi57m` (`idEstado`),
  CONSTRAINT `FK_cbcq765e57yhl3tt328506gd2` FOREIGN KEY (`persona`) REFERENCES `personas` (`idPersona`),
  CONSTRAINT `FK_p4xkvwuocbu8hu7b31yydi57m` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
INSERT INTO `profesores` VALUES (1,'2016-08-31 19:13:43','1','1',1,1),(2,'2016-08-31 19:13:44','','',2,1),(3,'2016-08-31 19:13:46','','',3,1),(4,'2016-08-31 19:13:47','','',4,1),(5,'2016-08-31 19:13:48','','',5,1),(6,'2016-08-31 19:13:49','','',6,1);
/*!40000 ALTER TABLE `profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesores_actividades`
--

DROP TABLE IF EXISTS `profesores_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesores_actividades` (
  `idActividad` int(11) NOT NULL,
  `idProfesor` int(11) NOT NULL,
  `Orden` int(11) NOT NULL,
  KEY `FK_sxxw1s501qlq5mhdpktotos8c` (`idProfesor`),
  KEY `FK_1cwlxi965m2ncqs44lhgecrn0` (`idActividad`),
  CONSTRAINT `FK_1cwlxi965m2ncqs44lhgecrn0` FOREIGN KEY (`idActividad`) REFERENCES `actividades` (`idActividad`),
  CONSTRAINT `FK_sxxw1s501qlq5mhdpktotos8c` FOREIGN KEY (`idProfesor`) REFERENCES `profesores` (`idProfesor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores_actividades`
--

LOCK TABLES `profesores_actividades` WRITE;
/*!40000 ALTER TABLE `profesores_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesores_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Córdoba');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registroasistencias`
--

DROP TABLE IF EXISTS `registroasistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registroasistencias` (
  `idRegistroAsistencia` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `socio` int(11) DEFAULT NULL,
  `relacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRegistroAsistencia`),
  KEY `FK_9qwoks0e9p32f5jcypk637kr` (`socio`),
  KEY `FK_bovmw3ud2sx2ldajcdvwpff7a` (`relacion`),
  CONSTRAINT `FK_9qwoks0e9p32f5jcypk637kr` FOREIGN KEY (`socio`) REFERENCES `socios` (`idSocio`),
  CONSTRAINT `FK_bovmw3ud2sx2ldajcdvwpff7a` FOREIGN KEY (`relacion`) REFERENCES `relaciones` (`idRelacion`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroasistencias`
--

LOCK TABLES `registroasistencias` WRITE;
/*!40000 ALTER TABLE `registroasistencias` DISABLE KEYS */;
INSERT INTO `registroasistencias` VALUES (1,'2016-09-20 15:24:11',2,1),(5,'2016-09-20 18:25:11',2,1),(6,'2016-09-20 19:24:11',2,1),(7,'2016-09-20 20:24:11',2,1),(8,'2016-09-20 20:29:11',2,1),(9,'2016-09-20 21:10:10',2,1),(10,'2016-09-20 21:24:11',2,1);
/*!40000 ALTER TABLE `registroasistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relaciones`
--

DROP TABLE IF EXISTS `relaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relaciones` (
  `idRelacion` int(11) NOT NULL AUTO_INCREMENT,
  `actividad` int(11) DEFAULT NULL,
  `horario` int(11) DEFAULT NULL,
  `profesor` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRelacion`),
  KEY `FK_kvd92cl97ji7q2vr4s37k2y8c` (`actividad`),
  KEY `FK_jqdjeccamexj2w0ryecd9ie76` (`horario`),
  KEY `FK_sg1ugpb8dluv25wc9mg33jtx` (`profesor`),
  CONSTRAINT `FK_jqdjeccamexj2w0ryecd9ie76` FOREIGN KEY (`horario`) REFERENCES `horarios` (`idHorario`),
  CONSTRAINT `FK_kvd92cl97ji7q2vr4s37k2y8c` FOREIGN KEY (`actividad`) REFERENCES `actividades` (`idActividad`),
  CONSTRAINT `FK_sg1ugpb8dluv25wc9mg33jtx` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`idProfesor`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relaciones`
--

LOCK TABLES `relaciones` WRITE;
/*!40000 ALTER TABLE `relaciones` DISABLE KEYS */;
INSERT INTO `relaciones` VALUES (1,5,6,3),(2,5,3,1),(3,5,11,5),(4,5,12,5),(5,5,19,5),(6,5,18,5),(7,5,29,1),(8,5,26,1),(9,6,27,4),(10,7,14,4),(11,6,4,4),(12,8,5,1),(13,8,15,1),(14,8,28,1),(15,2,19,6),(16,2,11,6),(17,4,8,1),(18,4,9,1),(19,4,10,1),(20,4,23,1),(21,4,20,1),(22,4,24,1),(23,3,31,2),(24,3,3,1),(25,3,26,1),(26,3,1,1),(27,3,34,1),(28,3,35,1),(29,3,8,1),(30,3,37,1),(31,3,38,1),(32,3,39,1),(33,3,40,1),(34,3,41,1),(35,3,42,1),(36,3,43,1),(37,3,44,1),(38,3,45,1),(39,3,46,1),(40,3,47,1),(41,3,48,1),(42,3,49,1),(43,3,50,1),(44,3,51,2),(45,3,52,2);
/*!40000 ALTER TABLE `relaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socios`
--

DROP TABLE IF EXISTS `socios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socios` (
  `idSocio` int(11) NOT NULL AUTO_INCREMENT,
  `fechaAlta` datetime DEFAULT NULL,
  `aptoFisico` varchar(255) DEFAULT NULL,
  `decJurada` varchar(255) DEFAULT NULL,
  `primerVencimiento` datetime DEFAULT NULL,
  `segundoVencimiento` datetime DEFAULT NULL,
  `idEstado` int(11) DEFAULT NULL,
  `persona` int(11) DEFAULT NULL,
  `ciclo` int(11) DEFAULT NULL,
  `situacion` int(11) DEFAULT '1',
  PRIMARY KEY (`idSocio`),
  KEY `FK_eq8b2qg7vll1uqr5hvn9b43it` (`idEstado`),
  KEY `FK_97f5s3cx252lu2uyxp64lbno8` (`persona`),
  CONSTRAINT `FK_97f5s3cx252lu2uyxp64lbno8` FOREIGN KEY (`persona`) REFERENCES `personas` (`idPersona`),
  CONSTRAINT `FK_eq8b2qg7vll1uqr5hvn9b43it` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socios`
--

LOCK TABLES `socios` WRITE;
/*!40000 ALTER TABLE `socios` DISABLE KEYS */;
INSERT INTO `socios` VALUES (1,'2016-08-22 11:01:20','apto','certificado','2016-10-21 11:01:20','2016-10-31 11:01:20',2,7,1,1),(2,'2016-08-22 00:00:00','','','2016-09-21 00:00:00','2016-10-01 00:00:00',1,8,1,1),(3,'2016-08-29 00:00:00','','','2016-09-28 00:00:00','2016-10-08 00:00:00',1,9,1,1),(4,'2016-08-22 00:00:00','','','2016-09-21 00:00:00','2016-10-01 00:00:00',1,10,1,1),(5,'2016-08-26 00:00:00','º','','2016-09-25 00:00:00','2016-10-05 00:00:00',1,11,1,1),(6,'2016-08-17 00:00:00','','','2016-09-16 00:00:00','2016-09-26 00:00:00',2,12,1,1),(7,'2016-08-16 00:00:00','','','2016-10-15 00:00:00','2016-10-18 00:00:00',1,13,1,1),(8,'2016-08-16 00:00:00','','','2016-09-15 00:00:00','2016-09-25 00:00:00',2,14,1,1),(9,'2016-08-16 00:00:00','apto','certificado','2016-09-15 00:00:00','2016-09-25 00:00:00',2,15,1,1),(10,'2016-08-13 00:00:00','','','2016-10-12 00:00:00','2016-10-15 00:00:00',1,16,1,1),(12,'2016-08-09 03:00:00','apto','certificado','2016-10-08 03:00:00','2016-10-11 03:00:00',1,18,1,1),(13,'2016-08-30 03:00:00','','','2016-09-29 03:00:00','2016-10-09 03:00:00',1,19,1,1),(14,'2016-01-18 03:00:00','apto','certificado','2016-10-17 03:00:00','2016-10-27 03:00:00',1,21,1,1),(15,'2016-09-01 03:00:00','','','2016-10-01 03:00:00','2016-10-11 03:00:00',1,22,1,1),(17,'2016-09-16 03:00:00','C:\\Documents and Settings\\Administrador\\Mis documentos\\Mis imágenes\\tai chi.jpg','C:\\Documents and Settings\\Administrador\\Escritorio\\Susana\\DSC_0646.JPG','2016-10-16 03:00:00','2016-10-26 03:00:00',1,5,1,1),(19,'2016-07-12 00:00:00','apto','certificado','2016-10-11 03:00:00','2016-10-14 03:00:00',1,25,1,1),(20,'2016-08-25 03:00:00','apto','certificado','2016-09-24 03:00:00','2016-10-04 03:00:00',1,26,1,1),(21,'2016-07-03 03:00:00','apto','certificado','2016-10-04 00:41:08','2016-10-14 00:41:08',1,27,1,1),(22,'0016-07-28 00:00:00','apto','certificado','2016-09-28 00:53:18','2016-10-08 00:53:18',1,28,1,1),(23,'0016-09-02 00:00:00','a','a','2016-10-02 00:00:00','0016-10-12 00:00:00',1,29,1,1),(24,'0016-08-30 00:00:00','a','a','2016-09-29 00:00:00','0016-10-09 00:00:00',1,30,1,1),(25,'2016-08-08 03:00:00','apto','certificado','2016-10-07 03:00:00','2016-10-17 03:00:00',1,31,1,1),(26,'2016-08-08 03:00:00','apto','certificado','2016-10-07 03:00:00','2016-10-10 03:00:00',1,32,1,1),(27,'2016-08-09 00:00:00','apto','certificado','2016-09-07 03:00:00','2016-09-17 03:00:00',2,33,1,1),(28,'0016-08-06 00:00:00','a','a','0016-09-05 00:00:00','0016-09-15 00:00:00',2,34,1,0),(29,'0016-08-03 00:00:00','a','a','0016-09-02 00:00:00','0016-09-12 00:00:00',2,35,1,0),(30,'0016-08-02 00:00:00','a','a','0016-10-06 00:00:00','0016-10-09 00:00:00',2,36,1,0),(31,'0016-08-02 00:00:00','a','a','0016-09-01 00:00:00','0016-09-11 00:00:00',2,37,1,0),(32,'2016-08-02 03:00:00','-','-','2016-09-06 03:00:00','2016-09-11 03:00:00',2,38,1,1),(33,'2016-09-05 03:00:00','no tiene','aun presento','2016-10-05 03:00:00','2016-10-15 03:00:00',1,39,1,1),(34,'2016-09-05 03:00:00','pendiente','pendienteº','2016-10-05 03:00:00','2016-10-15 03:00:00',1,40,1,1),(35,'2016-09-05 03:00:00','EN CARPETA','NO PRESENTO','2016-10-05 03:00:00','2016-10-15 03:00:00',1,41,1,1),(36,'2016-08-02 03:00:00','EN CARPETA','NO','2016-10-01 03:00:00','2016-10-04 03:00:00',1,42,1,1),(37,'2016-08-01 00:00:00','EN CARPETA','NO','2016-08-31 00:00:00','2016-09-10 00:00:00',2,43,1,1),(38,'2016-08-01 00:00:00','EN CARPETA','NO','2016-08-31 00:00:00','2016-09-10 00:00:00',2,44,1,1),(39,'2016-08-01 00:00:00','EN CARPETA','NO','2016-08-31 00:00:00','2016-09-10 00:00:00',2,45,1,1),(40,'2016-07-19 00:00:00','EN CARPETA','NO','2016-08-18 00:00:00','2016-08-28 00:00:00',2,46,1,1),(41,'0016-06-27 00:00:00','CARPETA','NO','0016-07-27 00:00:00','0016-08-06 00:00:00',2,47,1,0),(42,'0016-07-21 00:00:00','CARPETA','NO','0016-08-20 00:00:00','0016-08-30 00:00:00',2,48,1,0),(43,'0016-03-26 00:00:00','CARPETA','NO','0016-04-25 00:00:00','0016-05-05 00:00:00',2,49,1,0),(44,'2016-07-02 00:00:00','CARPETA','NO','2016-09-01 00:00:00','2016-08-11 00:00:00',2,50,1,1),(45,'2016-07-26 00:00:00','CARPETA','NO','2016-08-25 00:00:00','2016-09-04 00:00:00',2,51,1,1),(46,'0016-07-26 00:00:00','CARPETA','NO','0016-08-25 00:00:00','0016-09-04 00:00:00',2,52,1,0),(47,'0016-07-12 00:00:00','CARPETA','NO','0016-08-11 00:00:00','0016-08-21 00:00:00',2,53,1,0),(48,'0016-07-11 03:00:00','CARPETA','NO','0016-08-10 03:00:00','0016-08-20 03:00:00',2,54,1,0),(49,'0016-07-11 03:00:00','apto','certificado','0016-08-10 03:00:00','0016-08-20 03:00:00',2,55,1,0),(50,'0016-07-11 03:00:00','CARPETA','NO','0016-08-10 03:00:00','0016-08-20 03:00:00',2,56,1,0),(51,'0016-07-11 03:00:00','CARPETA','NO','0016-07-11 03:00:00','0016-07-21 03:00:00',2,57,1,0),(52,'2016-07-11 03:00:00','CARPETA','NO','2016-08-10 03:00:00','2016-08-20 03:00:00',2,58,1,1),(53,'0016-06-28 03:00:00','CARPETA','NO','0016-08-27 03:00:00','0016-08-30 03:00:00',2,59,1,0),(54,'0016-06-21 03:00:00','CARPETA','NO','0016-07-21 03:00:00','0016-07-31 03:00:00',2,60,1,0),(55,'0016-11-11 03:00:00','CARPETA','NO','0016-11-11 03:00:00','0016-11-21 03:00:00',2,61,1,0),(56,'0016-09-05 03:00:00','CARPETA','NO','0016-10-05 03:00:00','0016-10-15 03:00:00',2,62,1,0),(57,'0016-06-11 03:00:00','CARPETA','NO','0016-07-11 03:00:00','0016-07-21 03:00:00',2,63,1,0),(58,'0016-07-07 03:00:00','CARPETA','NO','0016-08-06 03:00:00','0016-08-16 03:00:00',2,64,1,0),(59,'0016-07-07 03:00:00','CARPETA','NO','0016-08-06 03:00:00','0016-08-16 03:00:00',2,65,1,0),(60,'0016-08-26 03:00:00','CARPETA','NO','0016-09-25 03:00:00','0016-10-05 03:00:00',2,66,1,0),(61,'0016-09-06 03:00:00','CARPETA','NO','0016-10-06 03:00:00','0016-10-16 03:00:00',2,67,1,0),(62,'0016-07-06 03:00:00','CARPETA','NO','0016-08-05 03:00:00','0016-08-15 03:00:00',2,68,1,0),(63,'0016-07-05 03:00:00','CARPETA','NO','0016-08-04 03:00:00','0016-08-14 03:00:00',2,69,1,0),(64,'0016-08-02 03:00:00','CARPETA','NO','0016-09-01 03:00:00','0016-09-11 03:00:00',2,70,1,0),(65,'2016-07-21 03:00:00','CARPETA','NO','2016-08-20 03:00:00','2016-08-30 03:00:00',2,71,1,1),(66,'2016-07-04 03:00:00','CARPETA','NO','2016-08-03 03:00:00','2016-08-13 03:00:00',2,72,1,1),(67,'2013-03-06 03:00:00','CARPETA','SI','2013-05-05 03:00:00','2013-05-08 03:00:00',2,73,1,0),(68,'2011-11-03 03:00:00','CARPETA','NO','2012-01-02 03:00:00','2012-01-05 03:00:00',2,74,1,0),(69,'2016-07-04 03:00:00','CARPETA','NO','2016-08-03 03:00:00','2016-08-13 03:00:00',2,75,1,1),(70,'2016-07-04 03:00:00','CARPETA','NO','2016-08-03 03:00:00','2016-08-13 03:00:00',2,76,1,1),(71,'2016-03-01 03:00:00','CARPETA','NO','2016-04-30 03:00:00','2016-05-03 03:00:00',2,77,1,0),(72,'2016-09-06 03:00:00','CARPETA','NO','2016-10-06 03:00:00','2016-10-16 03:00:00',1,78,1,1),(73,'2013-04-16 03:00:00','CARPETA','NO','2013-05-16 03:00:00','2013-05-26 03:00:00',2,79,1,0),(74,'2016-07-01 03:00:00','CARPETA','NO','2016-07-31 03:00:00','2016-08-10 03:00:00',2,80,1,0),(75,'2014-01-06 03:00:00','carpeta','no','2014-02-05 03:00:00','2014-02-15 03:00:00',2,81,1,0),(76,'2015-11-17 03:00:00','carpeta','no','2016-12-17 03:00:00','2015-12-27 03:00:00',2,82,1,1),(77,'2016-09-01 03:00:00','carpeta','no','2016-10-01 03:00:00','2016-10-11 03:00:00',1,83,1,1),(78,'2016-09-07 03:00:00','carpeta','no','2016-10-07 03:00:00','2016-10-17 03:00:00',1,84,1,1),(79,'2009-03-01 02:00:00','apto','certificado','2016-09-30 03:00:00','2009-05-03 03:00:00',1,85,1,1),(80,'2011-11-08 03:00:00','carpeta','no','2016-09-08 03:00:00','2011-12-18 03:00:00',2,86,1,1),(81,'2012-06-26 03:00:00','apto','certificado','2016-09-26 03:00:00','2012-08-05 03:00:00',1,87,1,1),(82,'2016-09-15 00:00:00','apto','certificado','2016-10-15 00:00:00','2016-10-25 00:00:00',1,82,1,1),(83,'2016-09-15 00:00:00','apto','certificado','2013-10-15 00:00:00','2016-10-25 00:00:00',2,88,1,0);
/*!40000 ALTER TABLE `socios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socios_actividades`
--

DROP TABLE IF EXISTS `socios_actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socios_actividades` (
  `idSocio` int(11) NOT NULL,
  `idActividad` int(11) NOT NULL,
  `ORDEN` int(11) NOT NULL,
  KEY `FK_o8salpc0tv6de8lnty19nciui` (`idActividad`),
  KEY `FK_d7hub7day4w8q902nfanpmf3g` (`idSocio`),
  CONSTRAINT `FK_d7hub7day4w8q902nfanpmf3g` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`idSocio`),
  CONSTRAINT `FK_o8salpc0tv6de8lnty19nciui` FOREIGN KEY (`idActividad`) REFERENCES `actividades` (`idActividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socios_actividades`
--

LOCK TABLES `socios_actividades` WRITE;
/*!40000 ALTER TABLE `socios_actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `socios_actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turnos`
--

DROP TABLE IF EXISTS `turnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turnos` (
  `idTurno` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idTurno`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turnos`
--

LOCK TABLES `turnos` WRITE;
/*!40000 ALTER TABLE `turnos` DISABLE KEYS */;
/*!40000 ALTER TABLE `turnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-20 22:58:26
