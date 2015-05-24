SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `lecoib` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `lecoib` ;

-- -----------------------------------------------------
-- Table `lecoib`.`GrupoTrabajo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`GrupoTrabajo` (
  `idGrupo` INT NOT NULL AUTO_INCREMENT,
  `nombreGrupo` VARCHAR(45) NULL,
  PRIMARY KEY (`idGrupo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nombreCat` VARCHAR(45) NULL,
  `sueldoBasico` FLOAT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Turno` (
  `idTurno` INT NOT NULL AUTO_INCREMENT,
  `turno` VARCHAR(2) NULL,
  `horaInicio` VARCHAR(5) NULL,
  `horaFin` VARCHAR(5) NULL,
  `cupos` INT NULL,
  PRIMARY KEY (`idTurno`),
  UNIQUE INDEX `turno_UNIQUE` (`turno` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `dni` INT NULL,
  `fechaIngreso` DATETIME NULL,
  `email` VARCHAR(45) NULL,
  `idCategoria` INT NULL,
  `idGrupo` INT NULL,
  `idTurno` INT NULL,
  PRIMARY KEY (`idEmpleado`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  INDEX `fk_Empleado_1_idx` (`idGrupo` ASC),
  INDEX `fk_Empleado_2_idx` (`idCategoria` ASC),
  INDEX `fk_Empleado_3_idx` (`idTurno` ASC),
  CONSTRAINT `fk_Empleado_1`
    FOREIGN KEY (`idGrupo`)
    REFERENCES `lecoib`.`GrupoTrabajo` (`idGrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_2`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `lecoib`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Empleado_3`
    FOREIGN KEY (`idTurno`)
    REFERENCES `lecoib`.`Turno` (`idTurno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Jornada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Jornada` (
  `idJornada` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NULL,
  `idEmpleado` INT NULL,
  `idTurno` INT NULL,
  PRIMARY KEY (`idJornada`),
  INDEX `fk_Jornada_1_idx` (`idTurno` ASC),
  INDEX `fk_Jornada_2_idx` (`idEmpleado` ASC),
  CONSTRAINT `fk_Jornada_1`
    FOREIGN KEY (`idTurno`)
    REFERENCES `lecoib`.`Turno` (`idTurno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jornada_2`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Solicitud` (
  `idSolicitud` INT NOT NULL AUTO_INCREMENT,
  `estado` BIT NULL,
  `idJornadaTitular` INT NOT NULL,
  `idJornadaReemplazante` INT NOT NULL,
  `idAutoriza` INT NULL,
  `confirmaReemplazante` BIT NULL,
  PRIMARY KEY (`idSolicitud`),
  INDEX `fk_Solicitud_1_idx` (`idJornadaTitular` ASC),
  INDEX `fk_Solicitud_2_idx` (`idAutoriza` ASC),
  INDEX `fk_Solicitud_3_idx` (`idJornadaReemplazante` ASC),
  CONSTRAINT `fk_Solicitud_1`
    FOREIGN KEY (`idJornadaTitular`)
    REFERENCES `lecoib`.`Jornada` (`idJornada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_2`
    FOREIGN KEY (`idAutoriza`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Solicitud_3`
    FOREIGN KEY (`idJornadaReemplazante`)
    REFERENCES `lecoib`.`Jornada` (`idJornada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombreUsr` VARCHAR(8) NULL,
  `clave` VARCHAR(8) NULL,
  `ultimoCambioClave` DATETIME NULL,
  `ultimaSesion` DATETIME NULL,
  `bajaLogica` BIT NULL,
  `privilegio` INT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `fk_Usuario_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`Ficha`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`Ficha` (
  `idFicha` INT NOT NULL AUTO_INCREMENT,
  `diaHora` DATETIME NULL,
  `entradaSalida` BIT NULL,
  `idEmpleado` INT NULL,
  PRIMARY KEY (`idFicha`),
  INDEX `fk_Ficha_1_idx` (`idEmpleado` ASC),
  CONSTRAINT `fk_Ficha_1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lecoib`.`BalanceMensual`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lecoib`.`BalanceMensual` (
  `idBalanceMensual` INT NOT NULL AUTO_INCREMENT,
  `horasTrabajadas` INT NULL,
  `mesAnio` DATETIME NULL,
  `idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idBalanceMensual`),
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC),
  UNIQUE INDEX `mesAnio_UNIQUE` (`mesAnio` ASC),
  CONSTRAINT `fk_BalanceMensual_1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
