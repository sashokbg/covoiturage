-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema schedule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `schedule` DEFAULT CHARACTER SET utf8 ;
USE `schedule` ;

-- -----------------------------------------------------
-- Table `schedule`.`Gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`Gender` (
  `id` INT NOT NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gender_id` INT NOT NULL,
  `firstName` VARCHAR(64) NULL,
  `lastName` VARCHAR(64) NULL,
  `birthDay` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_Gender_idx` (`gender_id` ASC),
  CONSTRAINT `fk_User_Gender`
    FOREIGN KEY (`gender_id`)
    REFERENCES `schedule`.`Gender` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`Project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`Project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NULL,
  `start` DATETIME NULL,
  `end` DATETIME NULL,
  `creator_id` INT NOT NULL,
  `code` VARCHAR(8) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Project_User1_idx` (`creator_id` ASC),
  CONSTRAINT `fk_Project_User1`
    FOREIGN KEY (`creator_id`)
    REFERENCES `schedule`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`Task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Project_id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Description` VARCHAR(256) NULL,
  `start` VARCHAR(45) NULL,
  `end` VARCHAR(45) NULL,
  `mandays` FLOAT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Task_Project1_idx` (`Project_id` ASC),
  CONSTRAINT `fk_Task_Project1`
    FOREIGN KEY (`Project_id`)
    REFERENCES `schedule`.`Project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`Role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`Project_Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`Project_Users` (
  `Project_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`Project_id`, `User_id`),
  INDEX `fk_Project_has_User_User1_idx` (`User_id` ASC),
  INDEX `fk_Project_has_User_Project1_idx` (`Project_id` ASC),
  CONSTRAINT `fk_Project_has_User_Project1`
    FOREIGN KEY (`Project_id`)
    REFERENCES `schedule`.`Project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Project_has_User_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `schedule`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`User_Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`User_Roles` (
  `User_id` INT NOT NULL,
  `Role_id` INT NOT NULL,
  PRIMARY KEY (`User_id`, `Role_id`),
  INDEX `fk_User_has_Role_Role1_idx` (`Role_id` ASC),
  INDEX `fk_User_has_Role_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_User_has_Role_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `schedule`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`Role_id`)
    REFERENCES `schedule`.`Role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
