CREATE DATABASE  IF NOT EXISTS `res_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `res_db`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: res_db
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `appsettings`
--

DROP TABLE IF EXISTS `appsettings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appsettings` (
  `ORG_NAME` varchar(50) DEFAULT NULL,
  `ORG_PHONE` varchar(50) DEFAULT NULL,
  `ORG_EMAIL` varchar(50) DEFAULT NULL,
  `ORG_ADDRESS` varchar(150) DEFAULT NULL,
  `ORG_OPENDAYS` varchar(200) DEFAULT NULL,
  `ORG_TIMINGS` varchar(50) DEFAULT NULL,
  `ORG_TABLENO` int(10) DEFAULT NULL,
  `ORG_AUTOASSIGN` varchar(10) DEFAULT NULL,
  `ORG_USERNAME` varchar(30) DEFAULT NULL,
  `ORG_PASSWORD` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appsettings`
--

LOCK TABLES `appsettings` WRITE;
/*!40000 ALTER TABLE `appsettings` DISABLE KEYS */;
INSERT INTO `appsettings` VALUES ('Dine Hill Restaurant','9082101880','contact@dinehill.com','2011, Hillside Rd, Storrs, CT','Monday/Tuesday/Wednesday/Thursday/Friday/Saturday/Sunday','9:00AM - 10:00PM',10,NULL,'admin@admin.com','password');
/*!40000 ALTER TABLE `appsettings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  `PARTYSIZE` int(10) DEFAULT NULL,
  `SPECIALNEED` varchar(100) DEFAULT NULL,
  `DATE` varchar(50) DEFAULT NULL,
  `TIME` varchar(50) DEFAULT NULL,
  `CONFNO` varchar(50) DEFAULT NULL,
  `TABLENO` int(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'Steve','Ballmer','steve@microsoft.com','8763456235',25,'Office Party','2015-03-04T05:00:00.000Z','1970-01-01T05:12:00.000Z','v6h5e',1),(2,'Steve','Jobs','stevej@apple.com','8855437648',30,'Apple iPhone meet','2015-03-03T05:00:00.000Z','1970-01-01T19:02:00.000Z','3cQ4V',2),(3,'Priyanka','Sharma','pk@gmail.com','9082101890',30,'Friends meet','2015-04-04T04:00:00.000Z','1970-01-01T21:04:00.000Z','KS8Gg',3),(4,'Anubhav','Mathur','mathuranubhav@gmail.com','9082101660',30,'Hello','2015-03-05T05:00:00.000Z','1970-01-01T21:04:00.000Z','3onLX',4),(5,'John','Smith','john@smith.com','9082101550',45,'Promotion Party','2015-08-07T04:00:00.000Z','1970-01-02T02:00:00.000Z','gG8sM',5),(6,'Michael','Schumacher','mike@abc.com','9876543210',30,'Brand Promotions','2015-04-30T04:00:00.000Z','1970-01-02T02:09:00.000Z','hZbaK',6),(7,'Bill','Gates','billgates@microsoft.com','9897969594',90,'Windows 10 Launch Party','2015-10-10T04:00:00.000Z','1970-01-01T15:10:00.000Z','2KTNd',7),(8,'Satya','Nadella','satya@microsoft.com','9872345768',50,'Microsoft CEO Party','2015-05-01T04:00:00.000Z','1970-01-02T02:09:00.000Z','4kTnD',8),(9,'Sundar','Pichai','sundar@google.com','9871237654',30,'Google Party','2015-06-01T04:00:00.000Z','1970-01-02T02:11:00.000Z','5Ghfl',9),(10,'Ratan','Tata','ratan@tata.com','4569871234',35,'Tata Conference','2015-07-01T04:00:00.000Z','1970-01-02T02:12:00.000Z','7Gfhk',10);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-26  7:08:51
CREATE DATABASE  IF NOT EXISTS `emp_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `emp_db`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: emp_db
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `ADDRESS1` varchar(50) DEFAULT NULL,
  `ADDRESS2` varchar(50) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `ZIP` int(11) DEFAULT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  `STATE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1011 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1001,'PENELOPE','GUINESS','PENELOPE.GUINESS@abc.com','28 MySQL Boulevard','','Palo Alto',94301,'2830338429','California'),(1002,'NICK','WAHLBERG','NICK.WAHLBERG@abc.com','23 Workhaven Lane','','Richmond',23294,'8386352866','Virginia'),(1003,'ED','CHASE','ED.CHASE@abc.com','1411 Lillydale Drive','','Seattle',98101,'4484771904','Washington'),(1004,'JENNIFER','DAVIS','JENNIFER.DAVIS@abc.com','1913 Hanoi Way','','Chicago',60007,'7058140035','Illinois'),(1005,'JOHNNY','LOLLOBRIGIDA','JOHNNY.LOLLOBRIGIDA@abc.com','1121 Loja Avenue','','Dallas',75001,'1065564866','Texas'),(1006,'BETTE','NICHOLSON','BETTE.NICHOLSON@abc.com','692 Joliet Street','','Salt Lake City',84044,'8604526264','Utah'),(1007,'GRACE','MOSTEL','GRACE.MOSTEL@abc.com','53 Idfu Parkway','','Columbus',43002,'7165712203','Ohio'),(1008,'MATTHEW','JOHANSSON','MATTHEW.JOHANSSON@abc.com','478 Joliet Way','','Denver',80012,'6572822859','Colorado'),(1009,'JOE','SWANK','JOE.SWANK@abc.com','613 Korolev Drive','','Phoenix',85003,'3806575226','Arizona'),(1010,'CHRISTIAN','GABLE','CHRISTIAN.GABLE@abc.com','1531 Sal Drive','','Miami',33109,'6488569361','Florida');
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

-- Dump completed on 2015-08-26  7:08:55
