-- MySQL Script generated by MySQL Workbench
-- Thu May 16 10:13:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema club_deportivo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema club_deportivo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `club_deportivo` DEFAULT CHARACTER SET utf8 ;
USE `club_deportivo` ;

-- -----------------------------------------------------
-- Table `club_deportivo`.`tutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`tutor` (
  `id_tutor` INT NOT NULL AUTO_INCREMENT,
  `rut_tutor` VARCHAR(13) NOT NULL,
  `nombre_tutor` VARCHAR(60) NOT NULL,
  `apellido_tutor` VARCHAR(60) NOT NULL,
  `apellido_paterno` VARCHAR(60) NOT NULL,
  `telefono_tutorn` INT NULL,
  `f_nacimiento` DATE NULL,
  `direccion_tutor` VARCHAR(100) NOT NULL,
  `email_tutor` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_tutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`cuotas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`cuotas` (
  `id_cuotas` INT NOT NULL AUTO_INCREMENT,
  `f_de_pago` DATE NOT NULL,
  `mes` INT NULL,
  `anio` INT NULL,
  PRIMARY KEY (`id_cuotas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`sociocategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`sociocategoria` (
  `id_sociocategoria` INT NOT NULL AUTO_INCREMENT,
  `id_socio` INT NOT NULL,
  `id_categoria` INT NOT NULL,
  PRIMARY KEY (`id_sociocategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`socio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`socio` (
  `id_socio` INT NOT NULL AUTO_INCREMENT,
  `rut_socio` VARCHAR(13) NOT NULL,
  `nombre_socio` VARCHAR(60) NOT NULL,
  `apellido_materno` VARCHAR(60) NOT NULL,
  `apellido_paterno` VARCHAR(60) NOT NULL,
  `telefono_socio` INT NOT NULL,
  `direccion_socio` VARCHAR(100) NOT NULL,
  `f_nacimiento` DATE NOT NULL,
  `email_socio` VARCHAR(60) NOT NULL,
  `genero_socio` VARCHAR(15) NOT NULL,
  `cuotas_id_cuotas` INT NOT NULL,
  `tutor_id_tutor` INT NOT NULL,
  `sociocategoria_id_sociocategoria` INT NOT NULL,
  PRIMARY KEY (`id_socio`, `cuotas_id_cuotas`, `tutor_id_tutor`, `sociocategoria_id_sociocategoria`),
  INDEX `fk_Socio_cuotas1_idx` (`cuotas_id_cuotas` ASC) VISIBLE,
  INDEX `fk_Socio_tutor1_idx` (`tutor_id_tutor` ASC) VISIBLE,
  INDEX `fk_socio_sociocategoria1_idx` (`sociocategoria_id_sociocategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Socio_cuotas1`
    FOREIGN KEY (`cuotas_id_cuotas`)
    REFERENCES `club_deportivo`.`cuotas` (`id_cuotas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_tutor1`
    FOREIGN KEY (`tutor_id_tutor`)
    REFERENCES `club_deportivo`.`tutor` (`id_tutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_socio_sociocategoria1`
    FOREIGN KEY (`sociocategoria_id_sociocategoria`)
    REFERENCES `club_deportivo`.`sociocategoria` (`id_sociocategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`categoria_deporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`categoria_deporte` (
  `id_catdep` INT NOT NULL AUTO_INCREMENT,
  `id_categoria` INT NOT NULL,
  `id_deporte` INT NOT NULL,
  PRIMARY KEY (`id_catdep`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`categoria` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(60) NOT NULL,
  `descripcion_categoria` VARCHAR(60) NOT NULL,
  `edad_max` INT NOT NULL,
  `genero_categoria` VARCHAR(15) NOT NULL,
  `sociocategoria_id_sociocategoria` INT NOT NULL,
  `categoria_deporte_id_catdep` INT NOT NULL,
  PRIMARY KEY (`id_categoria`, `sociocategoria_id_sociocategoria`, `categoria_deporte_id_catdep`),
  INDEX `fk_categoria_sociocategoria1_idx` (`sociocategoria_id_sociocategoria` ASC) VISIBLE,
  INDEX `fk_categoria_categoria_deporte1_idx` (`categoria_deporte_id_catdep` ASC) VISIBLE,
  CONSTRAINT `fk_categoria_sociocategoria1`
    FOREIGN KEY (`sociocategoria_id_sociocategoria`)
    REFERENCES `club_deportivo`.`sociocategoria` (`id_sociocategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_categoria_categoria_deporte1`
    FOREIGN KEY (`categoria_deporte_id_catdep`)
    REFERENCES `club_deportivo`.`categoria_deporte` (`id_catdep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`deporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`deporte` (
  `id_deporte` INT NOT NULL AUTO_INCREMENT,
  `nombre_deporte` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `categoria_deporte_id_catdep` INT NOT NULL,
  PRIMARY KEY (`id_deporte`, `categoria_deporte_id_catdep`),
  INDEX `fk_deporte_categoria_deporte1_idx` (`categoria_deporte_id_catdep` ASC) VISIBLE,
  CONSTRAINT `fk_deporte_categoria_deporte1`
    FOREIGN KEY (`categoria_deporte_id_catdep`)
    REFERENCES `club_deportivo`.`categoria_deporte` (`id_catdep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `club_deportivo`.`recursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `club_deportivo`.`recursos` (
  `id_recursos` INT NOT NULL AUTO_INCREMENT,
  `nombre_recursos` VARCHAR(60) NOT NULL,
  `cantidad_recurso` INT NULL,
  `descripcion_recurso` VARCHAR(100) NULL,
  `deporte_id_deporte` INT NOT NULL,
  `deporte_categoria_deporte_id_catdep` INT NOT NULL,
  PRIMARY KEY (`id_recursos`, `deporte_id_deporte`, `deporte_categoria_deporte_id_catdep`),
  INDEX `fk_recursos_deporte1_idx` (`deporte_id_deporte` ASC, `deporte_categoria_deporte_id_catdep` ASC) VISIBLE,
  CONSTRAINT `fk_recursos_deporte1`
    FOREIGN KEY (`deporte_id_deporte` , `deporte_categoria_deporte_id_catdep`)
    REFERENCES `club_deportivo`.`deporte` (`id_deporte` , `categoria_deporte_id_catdep`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;