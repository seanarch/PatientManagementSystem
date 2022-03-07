CREATE DATABASE  IF NOT EXISTS `pmsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pmsdb`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: pmsdb
-- ------------------------------------------------------
-- Server version	5.7.32-log

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
-- Table structure for table `abdomen`
--

DROP TABLE IF EXISTS `abdomen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abdomen` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `assess`
--

DROP TABLE IF EXISTS `assess`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assess` (
  `WtID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `ECOG` int(11) DEFAULT NULL,
  `Swallowing` int(11) DEFAULT NULL,
  `Breathing` int(11) DEFAULT NULL,
  PRIMARY KEY (`WtID`),
  KEY `ULI_assess` (`ULI`),
  KEY `ECOG_fk` (`ECOG`),
  KEY `Swallowing_fk` (`Swallowing`),
  KEY `Breathing_fk` (`Breathing`),
  CONSTRAINT `Breathing_fk` FOREIGN KEY (`Breathing`) REFERENCES `mrcdyspnoeascale` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ECOG_fk` FOREIGN KEY (`ECOG`) REFERENCES `ecogperformancestatusscale` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Swallowing_fk` FOREIGN KEY (`Swallowing`) REFERENCES `mellowscore` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_assess` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `bodylocation`
--

DROP TABLE IF EXISTS `bodylocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bodylocation` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `breath`
--

DROP TABLE IF EXISTS `breath`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `breath` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `cardiac`
--

DROP TABLE IF EXISTS `cardiac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cardiac` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `centralnervoussystem`
--

DROP TABLE IF EXISTS `centralnervoussystem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `centralnervoussystem` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `childpugh`
--

DROP TABLE IF EXISTS `childpugh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `childpugh` (
  `CPID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `Total Bili (umol/l)` int(11) DEFAULT NULL,
  `Serum Alb (g/l)` int(11) DEFAULT NULL,
  `PT INR` double DEFAULT NULL,
  `Ascites` varchar(45) DEFAULT NULL,
  `Hepatic Ench` varchar(45) DEFAULT NULL,
  `Child Pugh Score` int(11) DEFAULT NULL,
  `Child Pugh` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`CPID`),
  KEY `ULI_childPugh` (`ULI`),
  CONSTRAINT `ULI_childPugh` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `consider`
--

DROP TABLE IF EXISTS `consider`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consider` (
  `ConID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Consider` int(11) DEFAULT NULL,
  `Detail` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`ConID`),
  KEY `ULI_consider` (`ULI`),
  KEY `Consider_consider` (`Consider`),
  CONSTRAINT `Consider_consider` FOREIGN KEY (`Consider`) REFERENCES `typeofconsideration` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_consider` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `death`
--

DROP TABLE IF EXISTS `death`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `death` (
  `DeathID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `Detail` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`DeathID`),
  KEY `ULI_death` (`ULI`),
  CONSTRAINT `ULI_death` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `decision`
--

DROP TABLE IF EXISTS `decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `decision` (
  `DecID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Decision` int(11) DEFAULT NULL,
  `Detail` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`DecID`),
  KEY `ULI_decision` (`ULI`),
  KEY `decision_fk` (`Decision`),
  CONSTRAINT `ULI_decision` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `decision_fk` FOREIGN KEY (`Decision`) REFERENCES `typeofdecision` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `diagnosis`
--

DROP TABLE IF EXISTS `diagnosis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosis` (
  `Bx ID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Nodes +ve` varchar(100) DEFAULT NULL,
  `OR Date` date DEFAULT NULL,
  `Location` int(11) DEFAULT NULL,
  `OR` int(11) DEFAULT NULL,
  `Size Primary (mm)` int(11) DEFAULT NULL,
  `Pathology` int(11) DEFAULT NULL,
  `Grade` varchar(100) DEFAULT NULL,
  `Margin` varchar(200) DEFAULT NULL,
  `LVSI` tinyint(4) DEFAULT NULL,
  `Peri Neural` tinyint(4) DEFAULT NULL,
  `T` varchar(100) DEFAULT NULL,
  `Nodes Taken` varchar(100) DEFAULT NULL,
  `N` varchar(100) DEFAULT NULL,
  `M` varchar(100) DEFAULT NULL,
  `Staining +ve IHC` varchar(200) DEFAULT NULL,
  `Stage` varchar(100) DEFAULT NULL,
  `Recur` int(11) DEFAULT NULL,
  `Site of First Met` varchar(500) DEFAULT NULL,
  `Today` date DEFAULT NULL,
  PRIMARY KEY (`Bx ID`),
  KEY `OR_fk` (`OR`),
  KEY `Location_dx_fk` (`Location`),
  KEY `Path_fk` (`Pathology`),
  KEY `Recur_fk` (`Recur`),
  KEY `ULI_dx_idx` (`ULI`),
  CONSTRAINT `Location_dx_fk` FOREIGN KEY (`Location`) REFERENCES `bodylocation` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `OR_fk` FOREIGN KEY (`OR`) REFERENCES `typeofbiopsy` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Path_fk` FOREIGN KEY (`Pathology`) REFERENCES `typeofpathology` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recur_fk` FOREIGN KEY (`Recur`) REFERENCES `typeofrecure` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_dx` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `diagnosticimaging`
--

DROP TABLE IF EXISTS `diagnosticimaging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosticimaging` (
  `DI` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `DateDI` date DEFAULT NULL,
  `TypeDI` int(11) DEFAULT NULL,
  `Finding` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`DI`),
  KEY `ULI_di` (`ULI`),
  KEY `DI_fk` (`TypeDI`),
  CONSTRAINT `DI_fk` FOREIGN KEY (`TypeDI`) REFERENCES `typeofdiagnosticimaging` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_di` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `ecogperformancestatusscale`
--

DROP TABLE IF EXISTS `ecogperformancestatusscale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ecogperformancestatusscale` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `Exam` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `CNS` int(11) DEFAULT NULL,
  `Lung` int(11) DEFAULT NULL,
  `HN` int(11) DEFAULT NULL,
  `Oral` int(11) DEFAULT NULL,
  `Cardiac` int(11) DEFAULT NULL,
  `MSK` int(11) DEFAULT NULL,
  `Peripheral` int(11) DEFAULT NULL,
  `Abdo` int(11) DEFAULT NULL,
  `ABNORMAL` varchar(2000) DEFAULT NULL,
  `Supine` int(11) DEFAULT NULL,
  `Breath` int(11) DEFAULT NULL,
  PRIMARY KEY (`Exam`),
  KEY `ULI_exam` (`ULI`),
  KEY `CNS_fk` (`CNS`),
  KEY `Lung_fk` (`Lung`),
  KEY `HN_fk` (`HN`),
  KEY `Oral_fk` (`Oral`),
  KEY `Cardiac_fk` (`Cardiac`),
  KEY `MSK_fk` (`MSK`),
  KEY `Peripheral_fk` (`Peripheral`),
  KEY `Abdo_fk` (`Abdo`),
  KEY `Supine_exam_fk` (`Supine`),
  KEY `Breath_fk` (`Breath`),
  CONSTRAINT `Abdo_fk` FOREIGN KEY (`Abdo`) REFERENCES `abdomen` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Breath_fk` FOREIGN KEY (`Breath`) REFERENCES `breath` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `CNS_fk` FOREIGN KEY (`CNS`) REFERENCES `centralnervoussystem` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Cardiac_fk` FOREIGN KEY (`Cardiac`) REFERENCES `cardiac` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `HN_fk` FOREIGN KEY (`HN`) REFERENCES `headandneck` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Lung_fk` FOREIGN KEY (`Lung`) REFERENCES `lung` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MSK_fk` FOREIGN KEY (`MSK`) REFERENCES `musculoskeletal` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Oral_fk` FOREIGN KEY (`Oral`) REFERENCES `oral` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Peripheral_fk` FOREIGN KEY (`Peripheral`) REFERENCES `skin` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Supine_exam_fk` FOREIGN KEY (`Supine`) REFERENCES `supine` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_exam` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `followup`
--

DROP TABLE IF EXISTS `followup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `followup` (
  `FU RT` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `Type FU` int(11) DEFAULT NULL,
  `Clinical Response` int(11) DEFAULT NULL,
  `Pneumonitis` int(11) DEFAULT NULL,
  `Upper GI` int(11) DEFAULT NULL,
  `Skin Reaction` int(11) DEFAULT NULL,
  `Lower GI` int(11) DEFAULT NULL,
  `GU` int(11) DEFAULT NULL,
  `Heme` int(11) DEFAULT NULL,
  `Hepatic` int(11) DEFAULT NULL,
  `Other Toxicity` varchar(45) DEFAULT NULL,
  `Other Tox Detail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`FU RT`),
  KEY `ULI_fu` (`ULI`),
  KEY `Clinical Response_fk` (`Clinical Response`),
  KEY `UpperGI_fu__fk` (`Upper GI`),
  KEY `SkinReaction_fu_fk` (`Skin Reaction`),
  KEY `LowerGI_fu_fk` (`Lower GI`),
  KEY `GU_fu_fk` (`GU`),
  KEY `Heme_fu_fk` (`Heme`),
  KEY `Hep_fu_fk` (`Hepatic`),
  KEY `TypeFU_fk` (`Type FU`),
  KEY `Pneumonitis_fu_fk_idx` (`Pneumonitis`),
  CONSTRAINT `Clinical Response_fk` FOREIGN KEY (`Clinical Response`) REFERENCES `zrtresponse` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `GU_fu_fk` FOREIGN KEY (`GU`) REFERENCES `zrtgu` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Heme_fu_fk` FOREIGN KEY (`Heme`) REFERENCES `zrtheme` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Hep_fu_fk` FOREIGN KEY (`Hepatic`) REFERENCES `zrthep` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LowerGI_fu_fk` FOREIGN KEY (`Lower GI`) REFERENCES `zrtlgi` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Pneumonitis_fu_fk` FOREIGN KEY (`Pneumonitis`) REFERENCES `zrtlung` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SkinReaction_fu_fk` FOREIGN KEY (`Skin Reaction`) REFERENCES `zrtskin` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TypeFU_fk` FOREIGN KEY (`Type FU`) REFERENCES `zfu` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_fu` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UpperGI_fu__fk` FOREIGN KEY (`Upper GI`) REFERENCES `zrtugi` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `goalofcare`
--

DROP TABLE IF EXISTS `goalofcare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goalofcare` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `headandneck`
--

DROP TABLE IF EXISTS `headandneck`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `headandneck` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `historyofpresentillness`
--

DROP TABLE IF EXISTS `historyofpresentillness`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historyofpresentillness` (
  `ID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Descriptor` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ULI_hpi` (`ULI`),
  KEY `Descript_fk` (`Descriptor`),
  CONSTRAINT `Descript_fk` FOREIGN KEY (`Descriptor`) REFERENCES `typeofhistoryofpresentillness` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_hpi` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `lung`
--

DROP TABLE IF EXISTS `lung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lung` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `management`
--

DROP TABLE IF EXISTS `management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `management` (
  `MNG` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `Intervention` int(11) DEFAULT NULL,
  `Detail` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`MNG`),
  KEY `ULI_mng` (`ULI`),
  KEY `Intervention_fk` (`Intervention`),
  CONSTRAINT `Intervention_fk` FOREIGN KEY (`Intervention`) REFERENCES `typeofmanagement` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_mng` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `mellowscore`
--

DROP TABLE IF EXISTS `mellowscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mellowscore` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(60) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `mrcdyspnoeascale`
--

DROP TABLE IF EXISTS `mrcdyspnoeascale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mrcdyspnoeascale` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(60) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `musculoskeletal`
--

DROP TABLE IF EXISTS `musculoskeletal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `musculoskeletal` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;



--
-- Table structure for table `newpatientconsult`
--

DROP TABLE IF EXISTS `newpatientconsult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newpatientconsult` (
  `Bx ID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Bx ID`),
  KEY `ULI_npCons` (`ULI`),
  CONSTRAINT `ULI_npCons` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `oral`
--

DROP TABLE IF EXISTS `oral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oral` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `pasthistory`
--

DROP TABLE IF EXISTS `pasthistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pasthistory` (
  `PHx` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `FhxDetail` varchar(500) DEFAULT NULL,
  `SmokingPackYears` int(11) DEFAULT NULL,
  `SmokeQuit` varchar(45) DEFAULT NULL,
  `AttendedFamily` tinyint(4) DEFAULT NULL,
  `LacksSocialSupport` tinyint(4) DEFAULT NULL,
  `LanguageBarrier` tinyint(4) DEFAULT NULL,
  `FinancialChallenge` tinyint(4) DEFAULT NULL,
  `PsychosocialChallenge` tinyint(4) DEFAULT NULL,
  `GOC designation` int(11) DEFAULT NULL,
  `ETOH/week` varchar(45) DEFAULT NULL,
  `Detail` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`PHx`),
  KEY `ULI_phx` (`ULI`),
  KEY `GOC_fk` (`GOC designation`),
  CONSTRAINT `GOC_fk` FOREIGN KEY (`GOC designation`) REFERENCES `goalofcare` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_phx` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `pastmedicalhistory`
--

DROP TABLE IF EXISTS `pastmedicalhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pastmedicalhistory` (
  `PMhx` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Dx` varchar(8000) DEFAULT NULL,
  `Gen_Dx` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`PMhx`),
  KEY `ULI_pmhx` (`ULI`),
  CONSTRAINT `ULI_pmhx` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `patientinformation`
--

DROP TABLE IF EXISTS `patientinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patientinformation` (
  `Lastname` varchar(45) DEFAULT NULL,
  `Firstname` varchar(45) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `ULI` bigint(20) NOT NULL,
  `Print` tinyint(4) DEFAULT NULL,
  `TG` varchar(45) DEFAULT NULL,
  `Location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ULI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `pulmonaryfunctiontests`
--

DROP TABLE IF EXISTS `pulmonaryfunctiontests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pulmonaryfunctiontests` (
  `PFT` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `FVC` double DEFAULT NULL,
  `FVC%` int(11) DEFAULT NULL,
  `FEV1` double DEFAULT NULL,
  `FEV1%` int(11) DEFAULT NULL,
  `Ratio` int(11) DEFAULT NULL,
  `DLCO` int(11) DEFAULT NULL,
  PRIMARY KEY (`PFT`),
  KEY `ULI_pft` (`ULI`),
  CONSTRAINT `ULI_pft` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `radiationtherapy`
--

DROP TABLE IF EXISTS `radiationtherapy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `radiationtherapy` (
  `RT` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `DateRTStart` date DEFAULT NULL,
  `DateRTEnd` date DEFAULT NULL,
  `TypeRT` int(11) DEFAULT NULL,
  `Location` int(11) DEFAULT NULL,
  `RTDose` double DEFAULT NULL,
  `Fraction` int(11) DEFAULT NULL,
  `Planning` int(11) DEFAULT NULL,
  `AnatDetail` varchar(1000) DEFAULT NULL,
  `General` varchar(1000) DEFAULT NULL,
  `Pneumonitis` int(11) DEFAULT NULL,
  `UpperGI` int(11) DEFAULT NULL,
  `SkinReaction` int(11) DEFAULT NULL,
  `LowerGI` int(11) DEFAULT NULL,
  `GU` int(11) DEFAULT NULL,
  `Heme` int(11) DEFAULT NULL,
  `Hepatic` int(11) DEFAULT NULL,
  `Other Toxicity` varchar(500) DEFAULT NULL,
  `Other Toxicity Detail` varchar(500) DEFAULT NULL,
  `Details` varchar(500) DEFAULT NULL,
  `NG` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`RT`),
  KEY `ULI_rt` (`ULI`),
  KEY `TypeRT_fk` (`TypeRT`),
  KEY `Planning_fk` (`Planning`),
  KEY `Pneumonitis_fk` (`Pneumonitis`),
  KEY `Location_rt_fk` (`Location`),
  KEY `UpperGI_rt_fk` (`UpperGI`),
  KEY `SkinReaction_rt_fk` (`SkinReaction`),
  KEY `LowerGI_rt_fk` (`LowerGI`),
  KEY `Heme_rt_fk` (`Heme`),
  KEY `Hepatic_rt_fk` (`Hepatic`),
  KEY `GU_fk_idx` (`GU`),
  CONSTRAINT `GU_rt_fk` FOREIGN KEY (`GU`) REFERENCES `zrtgu` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Heme_rt_fk` FOREIGN KEY (`Heme`) REFERENCES `zrtheme` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Hepatic_rt_fk` FOREIGN KEY (`Hepatic`) REFERENCES `zrthep` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Location_rt_fk` FOREIGN KEY (`Location`) REFERENCES `bodylocation` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LowerGI_rt_fk` FOREIGN KEY (`LowerGI`) REFERENCES `zrtlgi` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Planning_fk` FOREIGN KEY (`Planning`) REFERENCES `zrtplan` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Pneumonitis_fk` FOREIGN KEY (`Pneumonitis`) REFERENCES `zrtlung` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `SkinReaction_rt_fk` FOREIGN KEY (`SkinReaction`) REFERENCES `zrtskin` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `TypeRT_fk` FOREIGN KEY (`TypeRT`) REFERENCES `typeofradiationtherapy` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_rt` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `UpperGI_rt_fk` FOREIGN KEY (`UpperGI`) REFERENCES `zrtugi` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `reviewofsystems`
--

DROP TABLE IF EXISTS `reviewofsystems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviewofsystems` (
  `ROS` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Date` date DEFAULT NULL,
  `Fevers / Chills` tinyint(4) DEFAULT NULL,
  `BADLs` tinyint(4) DEFAULT NULL,
  `IADLs` tinyint(4) DEFAULT NULL,
  `Appetite Loss` tinyint(4) DEFAULT NULL,
  `Difficulty Chewing` tinyint(4) DEFAULT NULL,
  `Abdominal Pain` tinyint(4) DEFAULT NULL,
  `NauseaVomiting` tinyint(4) DEFAULT NULL,
  `Heartburn` tinyint(4) DEFAULT NULL,
  `Constipation` tinyint(4) DEFAULT NULL,
  `Hemetemesis` tinyint(4) DEFAULT NULL,
  `Melena` tinyint(4) DEFAULT NULL,
  `RectalBleed` tinyint(4) DEFAULT NULL,
  `Nocturea` tinyint(4) DEFAULT NULL,
  `Hesitancy` tinyint(4) DEFAULT NULL,
  `Hematurea` tinyint(4) DEFAULT NULL,
  `Pneumaturea` tinyint(4) DEFAULT NULL,
  `Back BoneJointPain` tinyint(4) DEFAULT NULL,
  `SOB` tinyint(4) DEFAULT NULL,
  `Cough` tinyint(4) DEFAULT NULL,
  `Hemoptisis` tinyint(4) DEFAULT NULL,
  `Wheeze` tinyint(4) DEFAULT NULL,
  `ChestPain` tinyint(4) DEFAULT NULL,
  `Headaches` tinyint(4) DEFAULT NULL,
  `VisionChanges` tinyint(4) DEFAULT NULL,
  `Hearing` tinyint(4) DEFAULT NULL,
  `SpeechChanges` tinyint(4) DEFAULT NULL,
  `FocalWeakness` tinyint(4) DEFAULT NULL,
  `ED` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ROS`),
  KEY `ULI_ros` (`ULI`),
  CONSTRAINT `ULI_ros` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `skin`
--

DROP TABLE IF EXISTS `skin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skin` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `supine`
--

DROP TABLE IF EXISTS `supine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supine` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(200) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `symptom`
--

DROP TABLE IF EXISTS `symptom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `symptom` (
  `SxID` int(11) NOT NULL,
  `ULI` bigint(20) NOT NULL,
  `Symptom` int(11) DEFAULT NULL,
  `Detail` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`SxID`),
  KEY `Symptom_fk` (`Symptom`),
  KEY `ULI_symptom` (`ULI`),
  CONSTRAINT `Symptom_fk` FOREIGN KEY (`Symptom`) REFERENCES `typeofsymptom` (`TypeID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ULI_symptom` FOREIGN KEY (`ULI`) REFERENCES `patientinformation` (`ULI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofbiopsy`
--

DROP TABLE IF EXISTS `typeofbiopsy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofbiopsy` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofconsideration`
--

DROP TABLE IF EXISTS `typeofconsideration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofconsideration` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofdecision`
--

DROP TABLE IF EXISTS `typeofdecision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofdecision` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofdiagnosticimaging`
--

DROP TABLE IF EXISTS `typeofdiagnosticimaging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofdiagnosticimaging` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofhistoryofpresentillness`
--

DROP TABLE IF EXISTS `typeofhistoryofpresentillness`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofhistoryofpresentillness` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofmanagement`
--

DROP TABLE IF EXISTS `typeofmanagement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofmanagement` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofpathology`
--

DROP TABLE IF EXISTS `typeofpathology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofpathology` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofradiationtherapy`
--

DROP TABLE IF EXISTS `typeofradiationtherapy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofradiationtherapy` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofrecure`
--

DROP TABLE IF EXISTS `typeofrecure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofrecure` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `typeofsymptom`
--

DROP TABLE IF EXISTS `typeofsymptom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typeofsymptom` (
  `TypeID` int(11) NOT NULL,
  `Decription` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zfu`
--

DROP TABLE IF EXISTS `zfu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zfu` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(1000) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtgu`
--

DROP TABLE IF EXISTS `zrtgu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtgu` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtheme`
--

DROP TABLE IF EXISTS `zrtheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtheme` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrthep`
--

DROP TABLE IF EXISTS `zrthep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrthep` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtlgi`
--

DROP TABLE IF EXISTS `zrtlgi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtlgi` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtlung`
--

DROP TABLE IF EXISTS `zrtlung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtlung` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtplan`
--

DROP TABLE IF EXISTS `zrtplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtplan` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtresponse`
--

DROP TABLE IF EXISTS `zrtresponse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtresponse` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(500) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtskin`
--

DROP TABLE IF EXISTS `zrtskin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtskin` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `zrtugi`
--

DROP TABLE IF EXISTS `zrtugi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zrtugi` (
  `TypeID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-06 10:18:51
