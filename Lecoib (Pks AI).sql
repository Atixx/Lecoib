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
  `baja` BIT DEFAULT 0,
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
  `idUsuario` INT NOT NULL,
  `nombreUsr` VARCHAR(8) NULL,
  `clave` VARCHAR(8) NULL,
  `ultimoCambioClave` DATETIME NULL,
  `ultimaSesion` DATETIME NULL,
  `bajaLogica` BIT DEFAULT 0,
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
  `mesAnio` DATE NULL,
  `idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idBalanceMensual`),
  UNIQUE INDEX `idEmpleado_UNIQUE` (`idEmpleado` ASC, `mesAnio` ASC),
  CONSTRAINT `fk_BalanceMensual_1`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `lecoib`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- DATA INSERT
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `lecoib`.`Categoria` -Supervisor y Agente
-- -----------------------------------------------------
INSERT INTO `lecoib`.`Categoria` (`nombreCat`, `sueldoBasico`) VALUES ('Supervisor', '10000');
INSERT INTO `lecoib`.`Categoria` (`nombreCat`, `sueldoBasico`) VALUES ('Agente', '8000');
-- -----------------------------------------------------
-- Table `lecoib`.`GrupoTrabajo` - 3 Grupos
-- -----------------------------------------------------
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('PrimerGrupo');
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('SegundoGrupo');
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('TercerGrupo');
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('CuartoGrupo');
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('QuintoGrupo');
INSERT INTO `lecoib`.`GrupoTrabajo` (`nombreGrupo`) VALUES ('SextoGrupo');
-- -----------------------------------------------------
-- Table `lecoib`.`Turno`. MAñana, TArde y NOche
-- -----------------------------------------------------
INSERT INTO `lecoib`.`Turno` (`turno`, `horaInicio`, `horaFin`, `cupos`) VALUES ('MA', '06:00', '14:00', '2');
INSERT INTO `lecoib`.`Turno` (`turno`, `horaInicio`, `horaFin`, `cupos`) VALUES ('TA', '14:00', '22:00', '2');
INSERT INTO `lecoib`.`Turno` (`turno`, `horaInicio`, `horaFin`, `cupos`) VALUES ('NO', '22:00', '06:00', '2');
-- -----------------------------------------------------
-- Table `lecoib`.`Empleado`. Varios.
-- -----------------------------------------------------
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Colombo', 'Maximiliano', '33333333', '20150101', 'mcolombo87@gmail.com', '2', '2', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Bascu', 'Sebastian', '33333336', '20140301', 'sebas.bascu@gmail.com', '2', '2', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Levy', 'Maor', '33333332', '20140601', 'levym10@gmail.com', '2', '1', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Irione', 'Araceli', '33333331', '20150201', 'irione.a.91@gmail.com', '2', '1', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Sanchez', 'Juan', '11111112', '20130701', 'none@none.com', '2', '3', '3');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Perez', 'Marcelo', '11111111', '20130301', 'none@none.com', '2', '3', '3');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Romero', 'Veronica', '22222221', '20120101', 'none@none,com', '1', '1', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Gonzalez', 'Juan', '44444445', '20140101', 'none@none.com', '1', '2', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Martinez', 'Mariano', '11111118', '20150101', 'none@none.com', '1', '3', '3');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Sabina', 'Miriam', '12322223', '20140101', 'none@none.com', '2', '4', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Zulani', 'Jose', '19322223', '20140101', 'none@none.com', '2', '4', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Miliani', 'Roberto', '12722223', '20140101', 'none@none.com', '2', '5', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Hilkins', 'Martin', '12762223', '20140101', 'none@none.com', '2', '5', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Gonzalez', 'Carlos', '12322993', '20140101', 'none@none.com', '2', '6', '3');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Sullvert', 'Patricio', '12322923', '20140101', 'none@none.com', '2', '6', '3');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Danilo', 'Esteban', '12331223', '20140101', 'none@none.com', '1', '4', '1');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Stein', 'Estella', '12321123', '20140101', 'none@none.com', '1', '5', '2');
INSERT INTO `lecoib`.`Empleado` (`apellido`, `nombre`, `dni`, `fechaIngreso`, `email`, `idCategoria`, `idGrupo`, `idTurno`) VALUES ('Maverick', 'Juan', '12322529', '20140101', 'none@none.com', '1', '6', '3');

-- -----------------------------------------------------
-- Table `lecoib`.`Usuario` Solo 1 como supervisor.
-- -----------------------------------------------------
INSERT INTO `lecoib`.`Usuario` (`idUsuario`, `nombreUsr`, `clave`, `privilegio`) VALUES ('1', 'maxi', '1234', '2');
INSERT INTO `lecoib`.`Usuario` (`idUsuario`, `nombreUsr`, `clave`, `privilegio`) VALUES ('2', 'seba', '1234', '2');
INSERT INTO `lecoib`.`Usuario` (`idUsuario`, `nombreUsr`, `clave`, `privilegio`) VALUES ('3', 'maor', '1234', '2');
INSERT INTO `lecoib`.`Usuario` (`idUsuario`, `nombreUsr`, `clave`, `privilegio`) VALUES ('4', 'arac', '1234', '2');
INSERT INTO `lecoib`.`Usuario` (`idUsuario`, `nombreUsr`, `clave`, `privilegio`) VALUES ('7', 'supe', '1234', '1');
-- -----------------------------------------------------
-- Table `lecoib`.`Ficha`. Solo para Empleados "Maxi" y "Maor"
-- -----------------------------------------------------
-- Maxi
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-20 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-20 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-21 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-21 23:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-22 13:51:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-22 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-23 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-23 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-24 12:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-24 23:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-25 13:51:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-25 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-26 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-26 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-27 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-27 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-28 13:51:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-28 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-29 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-29 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-30 14:00:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-30 22:10:12', 0, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-31 13:51:02', 1, '1');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-31 22:10:12', 0, '1');
-- Maor
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-20 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-20 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-21 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-21 15:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-22 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-22 17:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-23 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-23 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-24 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-24 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-25 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-25 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-26 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-26 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-27 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-27 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-28 08:31:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-28 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-29 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-29 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-30 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-30 14:10:00', 0, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-31 06:00:00', 1, '3');
INSERT INTO `lecoib`.`Ficha` (`diaHora`, `entradaSalida`, `idEmpleado`) VALUES ('2015-05-31 14:10:00', 0, '3');
