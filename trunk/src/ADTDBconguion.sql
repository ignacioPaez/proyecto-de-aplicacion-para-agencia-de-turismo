SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `Agencia_de_Turismo_DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `Agencia_de_Turismo_DB` ;

-- -----------------------------------------------------
-- Table `Agencia_de_Turismo_DB`.`Cliente`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agencia_de_Turismo_DB`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `apellido` VARCHAR(45) NULL ,
  `usuario` VARCHAR(45) NULL ,
  `pass` VARCHAR(45) NULL ,
  `fechaNacimiento` DATE NULL ,
  `nacionalidad` VARCHAR(45) NULL ,
  PRIMARY KEY (`idCliente`) ,
  UNIQUE INDEX `usuario_UNIQUE` (`usuario` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agencia_de_Turismo_DB`.`Proveedor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agencia_de_Turismo_DB`.`Proveedor` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT ,
  `razonSocial` VARCHAR(45) NULL ,
  `usuario` VARCHAR(45) NULL ,
  `pass` VARCHAR(45) NULL ,
  PRIMARY KEY (`idProveedor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agencia_de_Turismo_DB`.`Servicio`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agencia_de_Turismo_DB`.`Servicio` (
  `idServicio` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  `costo` FLOAT NULL ,
  `disponibilidad` INT NULL ,
  `Proveedor_idProveedor` INT NOT NULL ,
  `comision` VARCHAR(45) NULL ,
  PRIMARY KEY (`idServicio`, `Proveedor_idProveedor`) ,
  INDEX `fk_Servicio_Proveedor` (`Proveedor_idProveedor` ASC) ,
  CONSTRAINT `fk_Servicio_Proveedor`
    FOREIGN KEY (`Proveedor_idProveedor` )
    REFERENCES `Agencia_de_Turismo_DB`.`Proveedor` (`idProveedor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agencia_de_Turismo_DB`.`Factura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agencia_de_Turismo_DB`.`Factura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT ,
  `fechaEmicion` VARCHAR(45) NULL ,
  `Cliente_idCliente` INT NOT NULL ,
  PRIMARY KEY (`idFactura`) ,
  INDEX `fk_Factura_Cliente1` (`Cliente_idCliente` ASC) ,
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`Cliente_idCliente` )
    REFERENCES `Agencia_de_Turismo_DB`.`Cliente` (`idCliente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Agencia_de_Turismo_DB`.`LineaFactura`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Agencia_de_Turismo_DB`.`LineaFactura` (
  `idLineaFactura` INT NOT NULL AUTO_INCREMENT ,
  `precio` VARCHAR(45) NULL ,
  `Factura_idFactura` INT NOT NULL ,
  `Servicio_idServicio` INT NOT NULL ,
  `Servicio_Proveedor_idProveedor` INT NOT NULL ,
  PRIMARY KEY (`idLineaFactura`, `Factura_idFactura`) ,
  INDEX `fk_LineaFactura_Factura1` (`Factura_idFactura` ASC) ,
  INDEX `fk_LineaFactura_Servicio1` (`Servicio_idServicio` ASC, `Servicio_Proveedor_idProveedor` ASC) ,
  CONSTRAINT `fk_LineaFactura_Factura1`
    FOREIGN KEY (`Factura_idFactura` )
    REFERENCES `Agencia_de_Turismo_DB`.`Factura` (`idFactura` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LineaFactura_Servicio1`
    FOREIGN KEY (`Servicio_idServicio` , `Servicio_Proveedor_idProveedor` )
    REFERENCES `Agencia_de_Turismo_DB`.`Servicio` (`idServicio` , `Proveedor_idProveedor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;