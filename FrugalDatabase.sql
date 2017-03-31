-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema frugaldb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `frugaldb` ;

-- -----------------------------------------------------
-- Schema frugaldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `frugaldb` DEFAULT CHARACTER SET utf8 ;
USE `frugaldb` ;

-- -----------------------------------------------------
-- Table `family`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `family` ;

CREATE TABLE IF NOT EXISTS `family` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `name_UNIQUE` ON `family` (`name` ASC);


-- -----------------------------------------------------
-- Table `member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `member` ;

CREATE TABLE IF NOT EXISTS `member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `familyId` INT NOT NULL,
  `admin` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_member_family`
    FOREIGN KEY (`familyId`)
    REFERENCES `family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `member` (`username` ASC);

CREATE INDEX `fk_member_family_idx` ON `member` (`familyId` ASC);


-- -----------------------------------------------------
-- Table `bill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bill` ;

CREATE TABLE IF NOT EXISTS `bill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `dateDue` DATE NOT NULL,
  `paid` TINYINT(1) NOT NULL,
  `datePaid` DATE NULL,
  `familyId` INT NULL,
  `memberId` INT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_bill_family1`
    FOREIGN KEY (`familyId`)
    REFERENCES `family` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bill_member1`
    FOREIGN KEY (`memberId`)
    REFERENCES `member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_bill_family1_idx` ON `bill` (`familyId` ASC);

CREATE INDEX `fk_bill_member1_idx` ON `bill` (`memberId` ASC);


-- -----------------------------------------------------
-- Table `account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `account` ;

CREATE TABLE IF NOT EXISTS `account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bankAccount` DOUBLE NOT NULL,
  `frugalSum` DOUBLE NOT NULL,
  `memberId` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_account_member1`
    FOREIGN KEY (`memberId`)
    REFERENCES `member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_account_member1_idx` ON `account` (`memberId` ASC);


-- -----------------------------------------------------
-- Table `income`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `income` ;

CREATE TABLE IF NOT EXISTS `income` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `date` DATE NOT NULL,
  `amount` DOUBLE NOT NULL,
  `accountId` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_income_account1`
    FOREIGN KEY (`accountId`)
    REFERENCES `account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_income_account1_idx` ON `income` (`accountId` ASC);


-- -----------------------------------------------------
-- Table `billResponsibility`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `billResponsibility` ;

CREATE TABLE IF NOT EXISTS `billResponsibility` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `percent` INT NOT NULL,
  `member_id` INT NOT NULL,
  `billId` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_billResponsibility_member1`
    FOREIGN KEY (`member_id`)
    REFERENCES `member` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_billResponsibility_bill1`
    FOREIGN KEY (`billId`)
    REFERENCES `bill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_billResponsibility_member1_idx` ON `billResponsibility` (`member_id` ASC);

CREATE INDEX `fk_billResponsibility_bill1_idx` ON `billResponsibility` (`billId` ASC);

SET SQL_MODE = '';
GRANT USAGE ON *.* TO student@localhost;
 DROP USER student@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'student'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `family`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `family` (`id`, `name`) VALUES (1, 'Waldorf');
INSERT INTO `family` (`id`, `name`) VALUES (2, 'Blacksmith');
INSERT INTO `family` (`id`, `name`) VALUES (3, 'Field');
INSERT INTO `family` (`id`, `name`) VALUES (4, 'Lancaster');
INSERT INTO `family` (`id`, `name`) VALUES (5, 'Prince');
INSERT INTO `family` (`id`, `name`) VALUES (6, 'Peterson');

COMMIT;


-- -----------------------------------------------------
-- Data for table `member`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (1, 'JohnWaldorf', 'password', 'John', 'Waldorf', 1, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (2, 'SarahWaldorf', 'password', 'Sarah', 'Waldorf', 1, 0);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (3, 'MaryBlacksmith', 'password', 'Mary', 'Blacksmith', 2, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (4, 'KyleBlacksmith', 'password', 'Kyle', 'Blacksmith', 2, 0);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (5, 'RyanField', 'password', 'Ryan', 'Field', 3, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (6, 'HelgaField', 'password', 'Helga', 'Field', 3, 0);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (7, 'PrinceLancaster', 'password', 'Prince', 'Lancaster', 4, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (8, 'SheelaLancaster', 'password', 'Sheela', 'Lancaster', 4, 0);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (9, 'DanielPrince', 'password', 'Daniel', 'Prince', 5, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (10, 'JessicaPrince', 'password', 'JessicaPrince', 'Prince', 5, 0);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (11, 'StephanPeterson', 'password', 'Stephan', 'Peterson', 6, 1);
INSERT INTO `member` (`id`, `username`, `password`, `fName`, `lName`, `familyId`, `admin`) VALUES (12, 'KellyPetterson', 'password', 'Kelly', 'Petterson', 6, 0);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bill`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (1, 'Mortgage', 1200, '2017-05-23', 0, NULL, 1, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (2, 'Water', 123, '2017-05-23', 0, NULL, 1, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (3, 'Vehicle', 345, '2017-05-23', 0, NULL, NULL, 1);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (4, 'Phone', 56, '2017-05-23', 0, NULL, NULL, 2);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (5, 'Mortgage', 1256.34, '2017-05-23', 0, NULL, 2, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (6, 'Water', 145.33, '2017-05-23', 0, NULL, 2, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (7, 'Vehicle', 345.45, '2017-05-23', 0, NULL, NULL, 3);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (8, 'Phone', 23.54, '2017-05-23', 0, NULL, NULL, 4);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (9, 'Mortgage', 346.33, '2017-05-23', 0, NULL, 3, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (10, 'Water', 321.55, '2017-05-23', 0, NULL, 3, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (11, 'Vehicle', 213.45, '2017-05-23', 0, NULL, NULL, 5);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (12, 'Phone', 34.55, '2017-05-23', 0, NULL, NULL, 6);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (13, 'Mortgage', 2345.22, '2017-05-23', 0, NULL, 4, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (14, 'Water', 123.55, '2017-05-23', 0, NULL, 4, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (15, 'Vehicle', 345.22, '2017-05-23', 0, NULL, NULL, 7);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (16, 'Phone', 23.55, '2017-05-23', 0, NULL, NULL, 8);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (17, 'Mortgage', 2345.22, '2017-05-23', 0, NULL, 5, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (18, 'Water', 123.00, '2017-05-23', 0, NULL, 5, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (19, 'Vehicle', 123.44, '2017-05-23', 0, NULL, NULL, 9);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (20, 'Phone', 34.55, '2017-05-23', 0, NULL, NULL, 10);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (21, 'Mortgage', 1456.33, '2017-05-23', 0, NULL, 6, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (22, 'Water', 234.12, '2017-05-23', 0, NULL, 6, NULL);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (23, 'Vehicle', 123.44, '2017-05-23', 0, NULL, NULL, 11);
INSERT INTO `bill` (`id`, `name`, `amount`, `dateDue`, `paid`, `datePaid`, `familyId`, `memberId`) VALUES (24, 'Phone', 12.44, '2017-05-23', 0, NULL, NULL, 12);

COMMIT;


-- -----------------------------------------------------
-- Data for table `account`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (1, 25000, 1000, 1);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (2, 12000, 2000, 2);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (3, 23000, 300, 3);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (4, 12000, 600, 4);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (5, 45000, 100, 5);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (6, 234000, 1200, 6);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (7, 67000, 2300, 7);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (8, 23000, 500, 8);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (9, 76000, 1200, 9);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (10, 43000, 3400, 10);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (11, 32000, 1000, 11);
INSERT INTO `account` (`id`, `bankAccount`, `frugalSum`, `memberId`) VALUES (12, 87000, 670, 12);

COMMIT;


-- -----------------------------------------------------
-- Data for table `income`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (1, 'paycheck', '2017-02-24', 1200, 1);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (2, 'paycheck', '2017-02-24', 2300, 2);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (3, 'paycheck', '2017-02-24', 1000, 3);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (4, 'paycheck', '2017-02-24', 4300, 4);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (5, 'paycheck', '2017-02-24', 2200, 5);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (6, 'paycheck', '2017-02-24', 2500.00, 6);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (7, 'paycheck', '2017-02-24', 1200, 7);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (8, 'paycheck', '2017-02-24', 2300, 8);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (9, 'paycheck', '2017-02-24', 4300, 9);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (10, 'paycheck', '2017-02-24', 5400, 10);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (11, 'paycheck', '2017-02-24', 1200, 11);
INSERT INTO `income` (`id`, `name`, `date`, `amount`, `accountId`) VALUES (12, 'paycheck', '2017-02-24', 1200, 12);

COMMIT;


-- -----------------------------------------------------
-- Data for table `billResponsibility`
-- -----------------------------------------------------
START TRANSACTION;
USE `frugaldb`;
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (1, 25, 1, 1);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (2, 75, 2, 1);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (3, 50, 1, 2);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (4, 50, 2, 2);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (5, 10, 3, 5);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (6, 90, 4, 5);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (7, 25, 3, 6);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (8, 75, 4, 6);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (9, 30, 5, 9);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (10, 70, 6, 9);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (11, 60, 5, 10);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (12, 40, 6, 10);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (13, 50, 7, 13);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (14, 50, 8, 13);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (15, 20, 7, 14);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (16, 80, 8, 14);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (17, 45, 9, 17);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (18, 55, 10, 17);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (19, 65, 9, 18);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (20, 35, 10, 18);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (21, 10, 11, 21);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (22, 90, 12, 21);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (23, 23, 11, 22);
INSERT INTO `billResponsibility` (`id`, `percent`, `member_id`, `billId`) VALUES (24, 77, 12, 22);

COMMIT;

