-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema AccountingSystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema AccountingSystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `AccountingSystem` DEFAULT CHARACTER SET utf8 ;
USE `AccountingSystem` ;

-- -----------------------------------------------------
-- Table `AccountingSystem`.`House`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AccountingSystem`.`House` (
  `idHouse` INT NOT NULL AUTO_INCREMENT,
  `numberOfHouse` INT NULL,
  `countOfFloors` INT NULL,
  `elevatorSpeed` DOUBLE NULL,
  `maxElevatorLoad` INT NULL,
  `maxCountOfCars` INT NULL,
  PRIMARY KEY (`idHouse`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AccountingSystem`.`Floor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AccountingSystem`.`Floor` (
  `idFloor` INT NOT NULL AUTO_INCREMENT,
  `houseID` INT NOT NULL,
  `numberOfFloor` INT NULL,
  PRIMARY KEY (`idFloor`),
  INDEX `fk_Floor_House_idx` (`houseID` ASC) VISIBLE,
  CONSTRAINT `fk_Floor_House`
    FOREIGN KEY (`houseID`)
    REFERENCES `AccountingSystem`.`House` (`idHouse`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `AccountingSystem`.`Flat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `AccountingSystem`.`Flat` (
  `idFlat` INT NOT NULL AUTO_INCREMENT,
  `floorID` INT NOT NULL,
  `numberOfFlat` INT NULL,
  `countOfHumans` INT NULL,
  `countOfRooms` INT NULL,
  `suare` DOUBLE NULL,
  `price` DOUBLE NULL,
  `maxDepthOfSwimPool` DOUBLE NULL,
  `volumeOfSwimPool` DOUBLE NULL,
  `terraceSquare` DOUBLE NULL,
  PRIMARY KEY (`idFlat`),
  INDEX `fk_Flat_Floor1_idx` (`floorID` ASC) VISIBLE,
  CONSTRAINT `fk_Flat_Floor1`
    FOREIGN KEY (`floorID`)
    REFERENCES `AccountingSystem`.`Floor` (`idFloor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
