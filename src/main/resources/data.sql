-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema default_schema
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pmsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pmsdb` ;

-- -----------------------------------------------------
-- Schema pmsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pmsdb` DEFAULT CHARACTER SET utf8 ;
USE `pmsdb` ;

-- -----------------------------------------------------
-- Table `pmsdb`.`_PT ID`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`_PT ID` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`_PT ID` (
  `LastName` VARCHAR(45) NULL DEFAULT NULL,
  `ULI` INT NOT NULL,
  `Print` TINYINT NULL DEFAULT NULL,
  `TG` VARCHAR(45) NULL DEFAULT NULL,
  `Location` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ULI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zECOG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zECOG` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zECOG` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zMellow`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zMellow` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zMellow` (
  `Disphagia ID` INT NOT NULL,
  `Mellow Score` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`Disphagia ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zMRC`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zMRC` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zMRC` (
  `MRC ID` INT NOT NULL,
  `MRC` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`MRC ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Assess`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Assess` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Assess` (
  `WtID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `ECOG` INT NULL DEFAULT NULL,
  `Swallowing` INT NULL DEFAULT NULL,
  `Breathing` INT NULL DEFAULT NULL,
  PRIMARY KEY (`WtID`),
  INDEX `ULI_assess` (`ULI` ASC),
  INDEX `ECOG_fk` (`ECOG` ASC),
  INDEX `Swallowing_fk` (`Swallowing` ASC),
  INDEX `Breathing_fk` (`Breathing` ASC),
  CONSTRAINT `ULI_assess`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ECOG_fk`
    FOREIGN KEY (`ECOG`)
    REFERENCES `pmsdb`.`zECOG` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Swallowing_fk`
    FOREIGN KEY (`Swallowing`)
    REFERENCES `pmsdb`.`zMellow` (`Disphagia ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Breathing_fk`
    FOREIGN KEY (`Breathing`)
    REFERENCES `pmsdb`.`zMRC` (`MRC ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`ChildPugh`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`ChildPugh` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`ChildPugh` (
  `CPID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `Total Bili (umol/l)` INT NULL DEFAULT NULL,
  `Serum Alb (g/l)` INT NULL DEFAULT NULL,
  `PT INR` DOUBLE NULL DEFAULT NULL,
  `Ascites` VARCHAR(45) NULL DEFAULT NULL,
  `Hepatic Ench` VARCHAR(45) NULL DEFAULT NULL,
  `Child Pugh Score` INT NULL DEFAULT NULL,
  `Child Pugh` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`CPID`),
  INDEX `ULI_childPugh` (`ULI` ASC),
  CONSTRAINT `ULI_childPugh`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zConsider`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zConsider` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zConsider` (
  `Consider ID` INT NOT NULL,
  `ConsID` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Consider ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Consider`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Consider` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Consider` (
  `ConID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Consider` INT NULL DEFAULT NULL,
  `Detail` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`ConID`),
  INDEX `ULI_consider` (`ULI` ASC),
  INDEX `Consider_consider` (`Consider` ASC),
  CONSTRAINT `ULI_consider`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Consider_consider`
    FOREIGN KEY (`Consider`)
    REFERENCES `pmsdb`.`zConsider` (`Consider ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zDI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zDI` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zDI` (
  `Field1` INT NOT NULL,
  `Type of Investigation` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Field1`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`DI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`DI` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`DI` (
  `DI` INT NOT NULL,
  `ULI` INT NOT NULL,
  `DateDI` DATE NULL DEFAULT NULL,
  `TypeDI` INT NULL DEFAULT NULL,
  `Finding` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`DI`),
  INDEX `ULI_di` (`ULI` ASC),
  INDEX `DI_fk` (`TypeDI` ASC),
  CONSTRAINT `ULI_di`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `DI_fk`
    FOREIGN KEY (`TypeDI`)
    REFERENCES `pmsdb`.`zDI` (`Field1`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Death`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Death` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Death` (
  `DeathID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `Detail` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`DeathID`),
  INDEX `ULI_death` (`ULI` ASC),
  CONSTRAINT `ULI_death`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zDecide`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zDecide` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zDecide` (
  `Decide ID` INT NOT NULL,
  `ConsID` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Decide ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Decision`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Decision` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Decision` (
  `DecID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Decision` INT NULL DEFAULT NULL,
  `Detail` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`DecID`),
  INDEX `ULI_decision` (`ULI` ASC),
  INDEX `decision_fk` (`Decision` ASC),
  CONSTRAINT `ULI_decision`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `decision_fk`
    FOREIGN KEY (`Decision`)
    REFERENCES `pmsdb`.`zDecide` (`Decide ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zBx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zBx` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zBx` (
  `Bx ID` INT NOT NULL,
  `BX` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Bx ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zLocation`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zLocation` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zLocation` (
  `Location ID` INT NOT NULL,
  `Table` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Location ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPath`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPath` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPath` (
  `Path ID` INT NOT NULL,
  `Pathology` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`Path ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRecur`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRecur` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRecur` (
  `Recur ID` INT NOT NULL,
  `zRecur` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Recur ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Dx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Dx` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Dx` (
  `Bx ID` INT NOT NULL,
  `Nodes +ve` VARCHAR(10) NULL DEFAULT NULL,
  `ULI` INT NOT NULL,
  `OR Date` DATE NULL DEFAULT NULL,
  `Location` INT NULL DEFAULT NULL,
  `OR` INT NULL DEFAULT NULL,
  `Size Primary (mm)` INT NULL DEFAULT NULL,
  `Pathology` INT NULL DEFAULT NULL,
  `Grade` VARCHAR(10) NULL DEFAULT NULL,
  `Margin` VARCHAR(20) NULL DEFAULT NULL,
  `LVSI` TINYINT NULL DEFAULT NULL,
  `Peri Neural` TINYINT NULL DEFAULT NULL,
  `T` VARCHAR(5) NULL DEFAULT NULL,
  `Nodes Taken` VARCHAR(5) NULL DEFAULT NULL,
  `N` VARCHAR(5) NULL DEFAULT NULL,
  `M` VARCHAR(5) NULL DEFAULT NULL,
  `Staining +ve IHC` VARCHAR(20) NULL DEFAULT NULL,
  `Stage` VARCHAR(5) NULL DEFAULT NULL,
  `Recur` INT NULL DEFAULT NULL,
  `Site of First Met` VARCHAR(20) NULL DEFAULT NULL,
  `Today''s Date` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Bx ID`),
  INDEX `OR_fk` (`OR` ASC),
  INDEX `Location_dx_fk` (`Location` ASC),
  INDEX `Path_fk` (`Pathology` ASC),
  INDEX `Recur_fk` (`Recur` ASC),
  INDEX `ULI_dx_idx` (`ULI` ASC),
  CONSTRAINT `OR_fk`
    FOREIGN KEY (`OR`)
    REFERENCES `pmsdb`.`zBx` (`Bx ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Location_dx_fk`
    FOREIGN KEY (`Location`)
    REFERENCES `pmsdb`.`zLocation` (`Location ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Path_fk`
    FOREIGN KEY (`Pathology`)
    REFERENCES `pmsdb`.`zPath` (`Path ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Recur_fk`
    FOREIGN KEY (`Recur`)
    REFERENCES `pmsdb`.`zRecur` (`Recur ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ULI_dx`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-CNS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-CNS` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-CNS` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(59) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-Lung`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-Lung` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-Lung` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(77) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-HN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-HN` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-HN` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(79) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-Oral`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-Oral` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-Oral` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-Cardiac`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-Cardiac` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-Cardiac` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-MSK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-MSK` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-MSK` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(65) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPx-Skin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPx-Skin` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPx-Skin` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(70) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zPX-Abdo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zPX-Abdo` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zPX-Abdo` (
  `ECOG ID` INT NOT NULL,
  `ECOG` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`ECOG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zSupine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zSupine` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zSupine` (
  `SetupID` INT NOT NULL,
  `Setup` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`SetupID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zBreath`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zBreath` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zBreath` (
  `BreathID` INT NOT NULL,
  `Breath` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`BreathID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Exam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Exam` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Exam` (
  `Exam` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `CNS` INT NULL DEFAULT NULL,
  `Lung` INT NULL DEFAULT NULL,
  `HN` INT NULL DEFAULT NULL,
  `Oral` INT NULL DEFAULT NULL,
  `Cardiac` INT NULL DEFAULT NULL,
  `MSK` INT NULL DEFAULT NULL,
  `Peripheral` INT NULL DEFAULT NULL,
  `Abdo` INT NULL DEFAULT NULL,
  `ABNORMAL` VARCHAR(100) NULL DEFAULT NULL,
  `Supine` INT NULL DEFAULT NULL,
  `Breath` INT NULL DEFAULT NULL,
  PRIMARY KEY (`Exam`),
  INDEX `ULI_exam` (`ULI` ASC),
  INDEX `CNS_fk` (`CNS` ASC),
  INDEX `Lung_fk` (`Lung` ASC),
  INDEX `HN_fk` (`HN` ASC),
  INDEX `Oral_fk` (`Oral` ASC),
  INDEX `Cardiac_fk` (`Cardiac` ASC),
  INDEX `MSK_fk` (`MSK` ASC),
  INDEX `Peripheral_fk` (`Peripheral` ASC),
  INDEX `Abdo_fk` (`Abdo` ASC),
  INDEX `Supine_fk` (`Supine` ASC),
  INDEX `Breath_fk` (`Breath` ASC),
  CONSTRAINT `ULI_exam`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `CNS_fk`
    FOREIGN KEY (`CNS`)
    REFERENCES `pmsdb`.`zPx-CNS` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Lung_fk`
    FOREIGN KEY (`Lung`)
    REFERENCES `pmsdb`.`zPx-Lung` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `HN_fk`
    FOREIGN KEY (`HN`)
    REFERENCES `pmsdb`.`zPx-HN` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Oral_fk`
    FOREIGN KEY (`Oral`)
    REFERENCES `pmsdb`.`zPx-Oral` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Cardiac_fk`
    FOREIGN KEY (`Cardiac`)
    REFERENCES `pmsdb`.`zPx-Cardiac` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `MSK_fk`
    FOREIGN KEY (`MSK`)
    REFERENCES `pmsdb`.`zPx-MSK` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Peripheral_fk`
    FOREIGN KEY (`Peripheral`)
    REFERENCES `pmsdb`.`zPx-Skin` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Abdo_fk`
    FOREIGN KEY (`Abdo`)
    REFERENCES `pmsdb`.`zPX-Abdo` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Supine_fk`
    FOREIGN KEY (`Supine`)
    REFERENCES `pmsdb`.`zSupine` (`SetupID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Breath_fk`
    FOREIGN KEY (`Breath`)
    REFERENCES `pmsdb`.`zBreath` (`BreathID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zFU`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zFU` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zFU` (
  `FU` INT NOT NULL,
  `Reason` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`FU`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zResponse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zResponse` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zResponse` (
  `Response ID` INT NOT NULL,
  `Response` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Response ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTUGI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTUGI` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTUGI` (
  `RT` INT NOT NULL,
  `UGI` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTSkin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTSkin` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTSkin` (
  `Skin` INT NOT NULL,
  `RTOG` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Skin`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTLGI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTLGI` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTLGI` (
  `RT` INT NOT NULL,
  `UGI` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTGU`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTGU` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTGU` (
  `RT` INT NOT NULL,
  `GU` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTHeme`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTHeme` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTHeme` (
  `Chemo` INT NOT NULL,
  `Chemo Tox` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`Chemo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTHep`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTHep` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTHep` (
  `RT` INT NOT NULL,
  `Hep` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`FU`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`FU` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`FU` (
  `FU RT` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `Type FU:` INT NULL DEFAULT NULL,
  `Clinical Response` INT NULL DEFAULT NULL,
  `Pneumonitis` INT NULL DEFAULT NULL,
  `Upper GI` INT NULL DEFAULT NULL,
  `Skin Reaction` INT NULL DEFAULT NULL,
  `Lower GI` INT NULL DEFAULT NULL,
  `GU` INT NULL DEFAULT NULL,
  `Heme` INT NULL DEFAULT NULL,
  `Hepatic` INT NULL DEFAULT NULL,
  `Other Toxicity` VARCHAR(45) NULL DEFAULT NULL,
  `Other Tox Detail` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`FU RT`),
  INDEX `ULI_fu` (`ULI` ASC),
  INDEX `Clinical Response_fk` (`Clinical Response` ASC),
  INDEX `Pneumonitis_fu_fk` (`Pneumonitis` ASC),
  INDEX `UpperGI_fu__fk` (`Upper GI` ASC),
  INDEX `SkinReaction_fu_fk` (`Skin Reaction` ASC),
  INDEX `LowerGI_fu_fk` (`Lower GI` ASC),
  INDEX `GU_fu_fk` (`GU` ASC),
  INDEX `Heme_fu_fk` (`Heme` ASC),
  INDEX `Hep_fu_fk` (`Hepatic` ASC),
  INDEX `TypeFU_fk` (`Type FU:` ASC),
  CONSTRAINT `ULI_fu`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Clinical Response_fk`
    FOREIGN KEY (`Clinical Response`)
    REFERENCES `pmsdb`.`zResponse` (`Response ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Pneumonitis_fu_fk`
    FOREIGN KEY (`Pneumonitis`)
    REFERENCES `pmsdb`.`zPx-Lung` (`ECOG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UpperGI_fu__fk`
    FOREIGN KEY (`Upper GI`)
    REFERENCES `pmsdb`.`zRTUGI` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SkinReaction_fu_fk`
    FOREIGN KEY (`Skin Reaction`)
    REFERENCES `pmsdb`.`zRTSkin` (`Skin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `LowerGI_fu_fk`
    FOREIGN KEY (`Lower GI`)
    REFERENCES `pmsdb`.`zRTLGI` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GU_fu_fk`
    FOREIGN KEY (`GU`)
    REFERENCES `pmsdb`.`zRTGU` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Heme_fu_fk`
    FOREIGN KEY (`Heme`)
    REFERENCES `pmsdb`.`zRTHeme` (`Chemo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Hep_fu_fk`
    FOREIGN KEY (`Hepatic`)
    REFERENCES `pmsdb`.`zRTHep` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TypeFU_fk`
    FOREIGN KEY (`Type FU:`)
    REFERENCES `pmsdb`.`zFU` (`FU`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zDescript`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zDescript` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zDescript` (
  `Descript ID` INT NOT NULL,
  `ID` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`Descript ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`HPI`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`HPI` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`HPI` (
  `ID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Descriptor` INT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `ULI_hpi` (`ULI` ASC),
  INDEX `Descript_fk` (`Descriptor` ASC),
  CONSTRAINT `ULI_hpi`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Descript_fk`
    FOREIGN KEY (`Descriptor`)
    REFERENCES `pmsdb`.`zDescript` (`Descript ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zMNG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zMNG` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zMNG` (
  `MNG ID` INT NOT NULL,
  `Managment` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`MNG ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`MNG`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`MNG` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`MNG` (
  `MNG` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `Intervention` INT NULL DEFAULT NULL,
  `Detail` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`MNG`),
  INDEX `ULI_mng` (`ULI` ASC),
  INDEX `Intervention_fk` (`Intervention` ASC),
  CONSTRAINT `ULI_mng`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Intervention_fk`
    FOREIGN KEY (`Intervention`)
    REFERENCES `pmsdb`.`zMNG` (`MNG ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`NP Cons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`NP Cons` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`NP Cons` (
  `Bx ID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `New Consult` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`Bx ID`),
  INDEX `ULI_npCons` (`ULI` ASC),
  CONSTRAINT `ULI_npCons`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`PFT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`PFT` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`PFT` (
  `PFT` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `FVC` DOUBLE NULL DEFAULT NULL,
  `FVC%` INT NULL DEFAULT NULL,
  `FEV1` DOUBLE NULL DEFAULT NULL,
  `FEV1%` INT NULL DEFAULT NULL,
  `Ratio` INT NULL DEFAULT NULL,
  `DLCO` INT NULL DEFAULT NULL,
  PRIMARY KEY (`PFT`),
  INDEX `ULI_pft` (`ULI` ASC),
  CONSTRAINT `ULI_pft`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zGOC`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zGOC` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zGOC` (
  `GOC ID` INT NOT NULL,
  `GOC des` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`GOC ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`PHx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`PHx` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`PHx` (
  `PHXID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `FhxDetail` VARCHAR(45) NULL DEFAULT NULL,
  `SmokingPackYears` INT NULL DEFAULT NULL,
  `SmokeQuit` INT NULL DEFAULT NULL,
  `AttendedFamily` TINYINT NULL DEFAULT NULL,
  `LacksSocialSupport` TINYINT NULL DEFAULT NULL,
  `LanguageBarrier` TINYINT NULL DEFAULT NULL,
  `FinanchialChallenge` TINYINT NULL DEFAULT NULL,
  `PsychosocialChallenge` TINYINT NULL DEFAULT NULL,
  `GOC designation` INT NULL DEFAULT NULL,
  `ETOH/week` VARCHAR(45) NULL DEFAULT NULL,
  `Detail` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`PHXID`),
  INDEX `ULI_phx` (`ULI` ASC),
  INDEX `GOC_fk` (`GOC designation` ASC),
  CONSTRAINT `ULI_phx`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GOC_fk`
    FOREIGN KEY (`GOC designation`)
    REFERENCES `pmsdb`.`zGOC` (`GOC ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`PMhx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`PMhx` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`PMhx` (
  `PMhx` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Dx` VARCHAR(200) NULL DEFAULT NULL,
  `Gen_Dx` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`PMhx`),
  INDEX `ULI_pmhx` (`ULI` ASC),
  CONSTRAINT `ULI_pmhx`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`ROS`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`ROS` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`ROS` (
  `ROS` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Date` DATE NULL DEFAULT NULL,
  `Fevers / Chills` TINYINT NULL DEFAULT NULL,
  `BADLs` TINYINT NULL DEFAULT NULL,
  `IADLs` TINYINT NULL DEFAULT NULL,
  `Appetite Loss` TINYINT NULL DEFAULT NULL,
  `Difficulty Chewing` TINYINT NULL DEFAULT NULL,
  `Abdominal Pain` TINYINT NULL DEFAULT NULL,
  `NauseaVomiting` TINYINT NULL DEFAULT NULL,
  `Heartburn` TINYINT NULL DEFAULT NULL,
  `Constipation` TINYINT NULL DEFAULT NULL,
  `Hemetemesis` TINYINT NULL DEFAULT NULL,
  `Melena` TINYINT NULL DEFAULT NULL,
  `RectalBleed` TINYINT NULL DEFAULT NULL,
  `Nocturea` TINYINT NULL DEFAULT NULL,
  `Hesitancy` TINYINT NULL DEFAULT NULL,
  `Hematurea` TINYINT NULL DEFAULT NULL,
  `Pneumaturea` TINYINT NULL DEFAULT NULL,
  `Back BoneJointPain` TINYINT NULL DEFAULT NULL,
  `SOB` TINYINT NULL DEFAULT NULL,
  `Cough` TINYINT NULL DEFAULT NULL,
  `Hemoptisis` TINYINT NULL DEFAULT NULL,
  `Wheeze` TINYINT NULL DEFAULT NULL,
  `ChestPain` TINYINT NULL DEFAULT NULL,
  `Headaches` TINYINT NULL DEFAULT NULL,
  `VisionChanges` TINYINT NULL DEFAULT NULL,
  `Hearing` TINYINT NULL DEFAULT NULL,
  `SpeechChanges` TINYINT NULL DEFAULT NULL,
  `FocalWeakness` TINYINT NULL DEFAULT NULL,
  `ED` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`ROS`),
  INDEX `ULI_ros` (`ULI` ASC),
  CONSTRAINT `ULI_ros`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zSx`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zSx` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zSx` (
  `Sx ID` INT NOT NULL,
  `Sx` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`Sx ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Symptom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Symptom` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Symptom` (
  `SxID` INT NOT NULL,
  `ULI` INT NOT NULL,
  `Symptom` INT NULL DEFAULT NULL,
  `Detail` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`SxID`),
  INDEX `Symptom_fk` (`Symptom` ASC),
  INDEX `ULI_symptom` (`ULI` ASC),
  CONSTRAINT `Symptom_fk`
    FOREIGN KEY (`Symptom`)
    REFERENCES `pmsdb`.`zSx` (`Sx ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ULI_symptom`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Table1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Table1` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Table1` (
  `DI` INT NOT NULL,
  `ULI` INT NOT NULL,
  `DateDI` DATE NULL DEFAULT NULL,
  `Finding` VARCHAR(200) NULL DEFAULT NULL,
  `Table2_ID` INT NULL DEFAULT NULL,
  PRIMARY KEY (`DI`),
  INDEX `ULI_table1` (`ULI` ASC),
  CONSTRAINT `ULI_table1`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`Table2`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`Table2` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`Table2` (
  `ID` INT NOT NULL,
  `TypeDI` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRT` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRT` (
  `RT` INT NOT NULL,
  `Type RT` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTLung`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTLung` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTLung` (
  `RT` INT NOT NULL,
  `Lung` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`zRTPlan`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`zRTPlan` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`zRTPlan` (
  `RT` INT NOT NULL,
  `Plan` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`RT`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `pmsdb`.`RT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pmsdb`.`RT` ;

CREATE TABLE IF NOT EXISTS `pmsdb`.`RT` (
  `RT` INT NOT NULL,
  `ULI` INT NOT NULL,
  `DateRTStart` DATE NULL DEFAULT NULL,
  `DateRTEnd` DATE NULL DEFAULT NULL,
  `TypeRT` INT NULL DEFAULT NULL,
  `Location` INT NULL DEFAULT NULL,
  `RTDose` DOUBLE NULL DEFAULT NULL,
  `Fraction` INT NULL DEFAULT NULL,
  `Planning` INT NULL DEFAULT NULL,
  `AnatDetail` VARCHAR(45) NULL DEFAULT NULL,
  `General` VARCHAR(45) NULL DEFAULT NULL,
  `Pneumonitis` INT NULL DEFAULT NULL,
  `UpperGI` INT NULL DEFAULT NULL,
  `SkinReaction` INT NULL DEFAULT NULL,
  `LowerGI` INT NULL DEFAULT NULL,
  `GU` INT NULL DEFAULT NULL,
  `Heme` INT NULL DEFAULT NULL,
  `Hepatic` INT NULL DEFAULT NULL,
  `Other Toxicity` VARCHAR(100) NULL DEFAULT NULL,
  `Other Toxicity Detail` VARCHAR(100) NULL DEFAULT NULL,
  `Details` VARCHAR(200) NULL DEFAULT NULL,
  `NG` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`RT`),
  INDEX `ULI_rt` (`ULI` ASC),
  INDEX `TypeRT_fk` (`TypeRT` ASC),
  INDEX `Planning_fk` (`Planning` ASC),
  INDEX `Pneumonitis_fk` (`Pneumonitis` ASC),
  INDEX `Location_rt_fk` (`Location` ASC),
  INDEX `UpperGI_rt_fk` (`UpperGI` ASC),
  INDEX `SkinReaction_rt_fk` (`SkinReaction` ASC),
  INDEX `LowerGI_rt_fk` (`LowerGI` ASC),
  INDEX `Heme_rt_fk` (`Heme` ASC),
  INDEX `Hepatic_rt_fk` (`Hepatic` ASC),
  INDEX `GU_fk_idx` (`GU` ASC),
  CONSTRAINT `ULI_rt`
    FOREIGN KEY (`ULI`)
    REFERENCES `pmsdb`.`_PT ID` (`ULI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `TypeRT_fk`
    FOREIGN KEY (`TypeRT`)
    REFERENCES `pmsdb`.`zRT` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Planning_fk`
    FOREIGN KEY (`Planning`)
    REFERENCES `pmsdb`.`zRTPlan` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Pneumonitis_fk`
    FOREIGN KEY (`Pneumonitis`)
    REFERENCES `pmsdb`.`zRTLung` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Location_rt_fk`
    FOREIGN KEY (`Location`)
    REFERENCES `pmsdb`.`zLocation` (`Location ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `UpperGI_rt_fk`
    FOREIGN KEY (`UpperGI`)
    REFERENCES `pmsdb`.`zRTUGI` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `SkinReaction_rt_fk`
    FOREIGN KEY (`SkinReaction`)
    REFERENCES `pmsdb`.`zRTSkin` (`Skin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `LowerGI_rt_fk`
    FOREIGN KEY (`LowerGI`)
    REFERENCES `pmsdb`.`zRTLGI` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `GU_rt_fk`
    FOREIGN KEY (`GU`)
    REFERENCES `pmsdb`.`zRTGU` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Heme_rt_fk`
    FOREIGN KEY (`Heme`)
    REFERENCES `pmsdb`.`zRTHeme` (`Chemo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `Hepatic_rt_fk`
    FOREIGN KEY (`Hepatic`)
    REFERENCES `pmsdb`.`zRTHep` (`RT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `_PT ID` VALUES ("Dervis", 100447161, 0, "Lung", "Inpatient");
INSERT INTO `_PT ID` VALUES ("Finch", 101042770, 0, "Breast", "Inpatient");
INSERT INTO `_PT ID` VALUES ("Huey", 101357180, 0, "GI", "HXH");
INSERT INTO `_PT ID` VALUES ("Dosi", 101748411, 0, "CNS", "TBCC");
INSERT INTO `_PT ID` VALUES ("Manabdhar", 102404210, 0, "Lung", "Inpatient");
INSERT INTO `_PT ID` VALUES ("Martzen", 102430300, 0, "GI", "HXH");
INSERT INTO `_PT ID` VALUES ("Iimura", 102867310, 0, "HPB", "HXH");
INSERT INTO `_PT ID` VALUES ("Haskell", 103161800, 0, "GI", "TBCC");
INSERT INTO `_PT ID` VALUES ("Brigandi", 103654610, 0, "Lung", "HXH");
INSERT INTO `_PT ID` VALUES ("Grassini", 104406680, 0, "Lymphoma", "TBCC");