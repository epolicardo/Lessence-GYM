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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
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
  `paseLibre` int(11) DEFAULT NULL,
  `socio` int(11) DEFAULT NULL,
  `relacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRelacion`),
  KEY `FK_csc8lkqvo5bt4wo6xk11waj1v` (`socio`),
  KEY `FK_lsdynq0km513v2y06jilypicj` (`relacion`),
  CONSTRAINT `FK_csc8lkqvo5bt4wo6xk11waj1v` FOREIGN KEY (`socio`) REFERENCES `socios` (`idSocio`),
  CONSTRAINT `FK_lsdynq0km513v2y06jilypicj` FOREIGN KEY (`relacion`) REFERENCES `relaciones` (`idRelacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades_socios_turnos`
--

LOCK TABLES `actividades_socios_turnos` WRITE;
/*!40000 ALTER TABLE `actividades_socios_turnos` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja_diaria`
--

LOCK TABLES `caja_diaria` WRITE;
/*!40000 ALTER TABLE `caja_diaria` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotas_registros`
--

LOCK TABLES `cuotas_registros` WRITE;
/*!40000 ALTER TABLE `cuotas_registros` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias`
--

LOCK TABLES `dias` WRITE;
/*!40000 ALTER TABLE `dias` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilios`
--

LOCK TABLES `domicilios` WRITE;
/*!40000 ALTER TABLE `domicilios` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_civil`
--

LOCK TABLES `estado_civil` WRITE;
/*!40000 ALTER TABLE `estado_civil` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formas_pago`
--

LOCK TABLES `formas_pago` WRITE;
/*!40000 ALTER TABLE `formas_pago` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gastos`
--

LOCK TABLES `gastos` WRITE;
/*!40000 ALTER TABLE `gastos` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
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
  PRIMARY KEY (`idParametro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
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
  CONSTRAINT `FK_p4xkvwuocbu8hu7b31yydi57m` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`),
  CONSTRAINT `FK_cbcq765e57yhl3tt328506gd2` FOREIGN KEY (`persona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesores`
--

LOCK TABLES `profesores` WRITE;
/*!40000 ALTER TABLE `profesores` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
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
  CONSTRAINT `FK_bovmw3ud2sx2ldajcdvwpff7a` FOREIGN KEY (`relacion`) REFERENCES `relaciones` (`idRelacion`),
  CONSTRAINT `FK_9qwoks0e9p32f5jcypk637kr` FOREIGN KEY (`socio`) REFERENCES `socios` (`idSocio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registroasistencias`
--

LOCK TABLES `registroasistencias` WRITE;
/*!40000 ALTER TABLE `registroasistencias` DISABLE KEYS */;
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
  CONSTRAINT `FK_sg1ugpb8dluv25wc9mg33jtx` FOREIGN KEY (`profesor`) REFERENCES `profesores` (`idProfesor`),
  CONSTRAINT `FK_jqdjeccamexj2w0ryecd9ie76` FOREIGN KEY (`horario`) REFERENCES `horarios` (`idHorario`),
  CONSTRAINT `FK_kvd92cl97ji7q2vr4s37k2y8c` FOREIGN KEY (`actividad`) REFERENCES `actividades` (`idActividad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relaciones`
--

LOCK TABLES `relaciones` WRITE;
/*!40000 ALTER TABLE `relaciones` DISABLE KEYS */;
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
  `ciclo` int(11) DEFAULT NULL,
  `persona` int(11) DEFAULT NULL,
  `idEstado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSocio`),
  KEY `FK_97f5s3cx252lu2uyxp64lbno8` (`persona`),
  KEY `FK_eq8b2qg7vll1uqr5hvn9b43it` (`idEstado`),
  CONSTRAINT `FK_eq8b2qg7vll1uqr5hvn9b43it` FOREIGN KEY (`idEstado`) REFERENCES `estados` (`idEstado`),
  CONSTRAINT `FK_97f5s3cx252lu2uyxp64lbno8` FOREIGN KEY (`persona`) REFERENCES `personas` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socios`
--

LOCK TABLES `socios` WRITE;
/*!40000 ALTER TABLE `socios` DISABLE KEYS */;
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

-- Dump completed on 2016-09-06 23:36:32
