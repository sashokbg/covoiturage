
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `schedule`.`GENDER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`GENDER` (
  `id` INT NOT NULL,
  `gender` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`USER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`USER` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `gender_id` INT NOT NULL,
  `firstName` VARCHAR(64) NULL,
  `lastName` VARCHAR(64) NULL,
  `birthDay` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_Gender_idx` (`gender_id` ASC),
  CONSTRAINT `fk_User_Gender`
    FOREIGN KEY (`gender_id`)
    REFERENCES `schedule`.`GENDER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`PROJECT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`PROJECT` (
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
    REFERENCES `schedule`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`TASK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`TASK` (
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
    REFERENCES `schedule`.`PROJECT` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`ROLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`ROLES` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`PROJECT_USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`PROJECT_USERS` (
  `Project_id` INT NOT NULL,
  `User_id` INT NOT NULL,
  PRIMARY KEY (`Project_id`, `User_id`),
  INDEX `fk_Project_has_User_User1_idx` (`User_id` ASC),
  INDEX `fk_Project_has_User_Project1_idx` (`Project_id` ASC),
  CONSTRAINT `fk_Project_has_User_Project1`
    FOREIGN KEY (`Project_id`)
    REFERENCES `schedule`.`PROJECT` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Project_has_User_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `schedule`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `schedule`.`USER_ROLES`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `schedule`.`USER_ROLES` (
  `User_id` INT NOT NULL,
  `Role_id` INT NOT NULL,
  PRIMARY KEY (`User_id`, `Role_id`),
  INDEX `fk_User_has_Role_Role1_idx` (`Role_id` ASC),
  INDEX `fk_User_has_Role_User1_idx` (`User_id` ASC),
  CONSTRAINT `fk_User_has_Role_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `schedule`.`USER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Role_Role1`
    FOREIGN KEY (`Role_id`)
    REFERENCES `schedule`.`ROLES` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
