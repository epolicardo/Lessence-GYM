package com.lessence.gymmaven.clases;


public class CrearBase {

    public void CrearBase(String Usuario, String Clave) {

        String GrantUsuarioLogin = "grant select, update, insert, create on usuarios.* to 'Login'@'localhost' identified by 'login';";
        String GrantUsuarioAsistentes = "grant select, update, insert, create on usuarios.* to 'asistentes'@'%' identified by 'asistentes';";
        String GrantGymAsistentes = "grant select, update, insert on gym2.* to 'asistentes'@'%' identified by 'asistentes';";
        String GrantUsuario = "grant select, update, insert, create on gym2.* to 'Login'@'localhost' identified by 'login';";
        String InsertarUsuarioLogin = "INSERT INTO usuarios.usuarios values ('gym2', 'Login', 'Login', '1', 'Login', 'login')";
       
        
        String InsertarUsuarioAsistentes = "INSERT INTO usuarios.usuarios values ('gym2', 'asistentes', 'asistentes', '2', 'asistentes', 'asistentes')";
        String CrearBaseDatosGym = "CREATE SCHEMA IF NOT EXISTS gym2";
        //String CrearBaseDatosMovimientos = "CREATE SCHEMA IF NOT EXISTS movimientos";
        //String CrearBaseDatosCuentasCorrientes = "CREATE SCHEMA IF NOT EXISTS cuentasCorrientes";

        String UsarBase = "use gym2";

        String CrearTablaGym_Ventas = "CREATE TABLE IF NOT EXISTS `gym2`.`ventas` ("
                + "`idVenta` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + "`idCliente` int(10) unsigned NOT NULL,"
                + "`idNroComprobante` int(10) unsigned NOT NULL,"
                + "`TotalArticulos` double NOT NULL,"
                + "`ImporteTotal` decimal(10,2) NOT NULL,"
                + "`Fecha` datetime NOT NULL,"
                + "`FormaVenta` int(2) unsigned NOT NULL,"
                + "`Descuentos` decimal(10,2) DEFAULT NULL,"
                + "`Impuestos` decimal(10,2) DEFAULT NULL,"
                + "`idTipoComprobante` int(2) unsigned NOT NULL,"
                + "PRIMARY KEY (`idVenta`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_DetalleVentas = "CREATE TABLE IF NOT EXISTS `gym2`.`detalle_ventas` ("
                + "`idDetalle` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + " `idVenta` int(11) NOT NULL,"
                + " `Producto` varchar(45) NOT NULL,"
                + " `Cantidad` varchar(45) NOT NULL,"
                + " `Precio` decimal(10,2) NOT NULL,"
                + " PRIMARY KEY (`idDetalle`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_Presupuestos = "CREATE TABLE IF NOT EXISTS `gym2`.`presupuestos` ("
                + "`idVenta` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + "`idCliente` int(10) unsigned NOT NULL,"
                + "`idNroComprobante` int(10) unsigned NOT NULL,"
                + "`TotalArticulos` double NOT NULL,"
                + "`ImporteTotal` decimal(10,2) NOT NULL,"
                + "`Fecha` datetime NOT NULL,"
                + "`FormaVenta` int(2) unsigned NOT NULL,"
                + "`Descuentos` decimal(10,2) DEFAULT NULL,"
                + "`Impuestos` decimal(10,2) DEFAULT NULL,"
                + "PRIMARY KEY (`idVenta`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_DetallePresupuestos = "CREATE TABLE IF NOT EXISTS `gym2`.`detalle_presupuestos` ("
                + "`idDetalle` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + " `idVenta` int(11) NOT NULL,"
                + " `Producto` varchar(45) NOT NULL,"
                + " `Cantidad` varchar(45) NOT NULL,"
                + " `Precio` decimal(10,2) NOT NULL,"
                + " PRIMARY KEY (`idDetalle`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_Compras = "CREATE TABLE IF NOT EXISTS `gym2`.`compras` ("
                + "`idCompra` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + "`idProveedor` int(10) unsigned NOT NULL,"
                + "`idNroComprobante` int(10) unsigned NOT NULL,"
                + "`TotalArticulos` double NOT NULL,"
                + "`ImporteTotal` decimal(10,2) NOT NULL,"
                + "`Fecha` datetime NOT NULL,"
                + "`Condicion` int(2) unsigned NOT NULL,"
                + "`Descuentos` decimal(10,2) DEFAULT NULL,"
                + "`Impuestos` decimal(10,2) DEFAULT NULL,"
                + "PRIMARY KEY (`idCompra`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_DetalleCompras = "CREATE TABLE IF NOT EXISTS `Gym`.`detalle_compras` ("
                + "`idDetalle` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + " `idCompra` int(10) NOT NULL,"
                + " `Producto` varchar(45) NOT NULL,"
                + " `Cantidad` varchar(45) NOT NULL,"
                + " `IdRomaneo` int(10) NOT NULL,"
                + " `Precio` decimal(10,2)NOT NULL,"
                + " `PrecioAnterior` decimal(10,2) NOT NULL,"
                + " PRIMARY KEY (`idDetalle`)"
                + ") ENGINE=InnoDB;";

        // TODO Añadir deposito de destino a las operaciones de compra
        String CrearTablaGym_Productos = "CREATE TABLE IF NOT EXISTS `Gym`.`productos`"
                + "(`idProducto` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`Producto` VARCHAR(45) NOT NULL,"
                + "`Descripcion` VARCHAR(120) NOT NULL,"
                + "`idProveedor` INTEGER UNSIGNED NOT NULL, "
                + "`IdFamilia` INTEGER UNSIGNED NOT NULL,"
                + "`PrecioCosto` DECIMAL (10,2) NOT NULL, "
                + "`PrecioVenta` DECIMAL (10,2) NOT NULL,"
                + "`idDeposito` INTEGER UNSIGNED NOT NULL, "
                + "`Disponible` DECIMAL (10,2) NOT NULL,"
                + "PRIMARY KEY (`idProducto`)) ENGINE = InnoDB;";

        String CrearTablaGym_Proveedores = "CREATE TABLE IF NOT EXISTS `Gym`.`proveedores` "
                + "(`idProveedor` INTEGER UNSIGNED NOT NULL,"
                + "`Proveedor` VARCHAR(60) NOT NULL, `Calle` VARCHAR(45) NOT NULL, "
                + "`Nro` VARCHAR(6) NOT NULL,`Piso` VARCHAR(3) NOT NULL,`Dpto`VARCHAR(3) NOT NULL,"
                + "`idLocalidad` INTEGER NOT NULL,`CodAreaTel` VARCHAR(6) NOT NULL,"
                + "`Telefono` VARCHAR(12) NOT NULL,`CodAreaCel`VARCHAR(6) NOT NULL,`TelefonoCel` VARCHAR(12) NOT NULL,"
                + "`Email` VARCHAR(150) NOT NULL, `PaginaWeb` VARCHAR(100) NOT NULL,"
                + "`Representante`VARCHAR(45) NOT NULL,PRIMARY KEY(`idProveedor`))"
                + "ENGINE = InnoDB;";

        String CrearTablaGym_Clientes = "CREATE TABLE IF NOT EXISTS `Gym`.`clientes`"
                + "(`idCliente`INTEGER NOT NULL,"
                + "`Nombre`VARCHAR(45) NOT NULL,`Apellido`VARCHAR(45) NOT NULL,"
                + "`Calle`VARCHAR(45) NOT NULL,`Nro`VARCHAR(6) NOT NULL,`Piso`VARCHAR(3) NOT NULL,`Dpto`VARCHAR(3) NOT NULL,"
                + "`idLocalidad`INTEGER NOT NULL,`CodAreaTel`VARCHAR(6) NOT NULL,`Telefono`VARCHAR(12) NOT NULL,`CodAreaCel`VARCHAR(6) NOT NULL,"
                + "`TelefonoCel`VARCHAR(12) NOT NULL,`Email`VARCHAR(150) NOT NULL,`DeudaMaxima`DECIMAL(10,2) "
                + "NOT NULL DEFAULT '0',PRIMARY KEY(`idCliente`))ENGINE = InnoDB;";

        String CrearTablaGym_Cheques = "CREATE TABLE  IF NOT EXISTS `Gym`.`cheques` ("
                + "  `idCheque` int(10) unsigned NOT NULL,"
                + "  `idCliente` int(10) unsigned NOT NULL,"
                + "  `idBanco` int(10) unsigned NOT NULL,"
                + "  `Plaza` varchar(60) NOT NULL,"
                + "  `FechaCobro` datetime NOT NULL,"
                + "  `Importe` decimal(10,2) NOT NULL"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_Bancos = "CREATE TABLE IF NOT EXISTS `Gym`.`bancos` ("
                + "  `idBanco` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + "  `Banco` varchar(45) NOT NULL,"
                + "  PRIMARY KEY (`idBanco`)) ENGINE=InnoDB;";

        String CrearTablaGym_Familias = "CREATE TABLE IF NOT EXISTS `Gym`.`familias` ("
                + "`idfamilia` INTEGER UNSIGNED NOT NULL DEFAULT NULL AUTO_INCREMENT,"
                + "`Familia` VARCHAR(45) NOT NULL,"
                + "PRIMARY KEY (`idfamilia`)"
                + ") ENGINE = InnoDB;";

        String CrearTablaGym_Gastos = "CREATE TABLE IF NOT EXISTS `Gym`.`gastos` ("
                + "`idgasto` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`Fecha` DATETIME NOT NULL,"
                + "`Concepto` VARCHAR(120) NOT NULL,"
                + "`Importe` DECIMAL(10,2) NOT NULL,"
                + "`Tipo` INTEGER UNSIGNED NOT NULL,"
                + "PRIMARY KEY (`idgasto`)"
                + ")ENGINE = InnoDB;";

        String CrearTablaGym_DetalleRomaneo = "CREATE TABLE IF NOT EXISTS `Gym`.`detalle_romaneo` ("
                + "`idDetalle` int(10) unsigned NOT NULL AUTO_INCREMENT,"
                + " `idProducto` varchar(10) NOT NULL,"
                + " `Cantidad` varchar(6) NOT NULL,"
                + " `Alto` varchar(6) NOT NULL,"
                + " `Ancho` varchar(6) NOT NULL,"
                + " `Largo` varchar(6) NOT NULL,"
                + " PRIMARY KEY (`idDetalle`)"
                + ") ENGINE=InnoDB;";

        String CrearTablaGym_Comprobantes = "CREATE TABLE IF NOT EXISTS `Gym`.`comprobantes` ("
                + "`idComprobante` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`UltimoEmitido` VARCHAR(20) NOT NULL DEFAULT '0',"
                + " PRIMARY KEY (`idComprobante`))ENGINE = InnoDB;";

        //TODO Añadir el primer registro en 0 ya que si no lo hace, no incrementa los comprobantes
        String CrearTablaGym_Forma_venta = "CREATE TABLE IF NOT EXISTS `Gym`.`formaventa` ("
                + "`idFormaVenta` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`FormaVenta` VARCHAR(30) NOT NULL,"
                + " PRIMARY KEY (`idFormaVenta`))ENGINE = InnoDB;";

        String CrearTablaGym_Forma_pago = "CREATE TABLE IF NOT EXISTS `Gym`.`formapago` ("
                + "`idFormaPago` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`FormaPago` VARCHAR(30) NOT NULL,"
                + " PRIMARY KEY (`idFormaPago`))ENGINE = InnoDB;";
        //TODO Añadir formas de venta a la tabla o permitir en las configuraciones crearlas.

        String CrearTablaGym_Stock = "CREATE TABLE IF NOT EXISTS `Gym`.`stock` ("
                + "`idProducto` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,"
                + "`idDeposito` INTEGER UNSIGNED NOT NULL,"
                + "`Cantidad` DECIMAL(10,2) NOT NULL,"
                + "PRIMARY KEY (`idProducto`))"
                + "ENGINE = InnoDB;";

        String TablaActividades = "CREATE TABLE If Not Exists `actividades` "
                + "(`idActividades` INT(11) NOT NULL AUTO_INCREMENT,"
                + "`Denominacion` VARCHAR(45) NULL DEFAULT NULL,"
                + "PRIMARY KEY (`idActividades`))"
                + " COLLATE='latin1_swedish_ci' ENGINE=InnoDB AUTO_INCREMENT=1;";

        String TablaSocios = "CREATE TABLE If Not Exists `socios` (\n"
                + "	`idSocios` INT(11) NOT NULL AUTO_INCREMENT,\n"
                + "	`idPersonas` INT(11) NOT NULL,\n"
                + "	`FechaAlta` DATETIME NULL DEFAULT NULL,\n"
                + "	`idEstados` INT(11) NULL DEFAULT NULL,\n"
                + "	`AptoFisico` VARCHAR(200) NULL DEFAULT NULL,\n"
                + "	`CertificadoMedico` VARCHAR(200) NULL DEFAULT NULL,\n"
                + "	`Foto` VARCHAR(200) NULL DEFAULT NULL,\n"
                + "	PRIMARY KEY (`idSocios`)\n"
                + ")\n"
                + "COLLATE='latin1_swedish_ci'\n"
                + "ENGINE=InnoDB\n"
                + "AUTO_INCREMENT=1\n"
                + ";";

        String TablaPersonas = "CREATE TABLE if not exists `personas` (\n"
                + "  `idPersonas` int(11) NOT NULL,\n"
                + "  `Apellido` varchar(20) DEFAULT NULL,\n"
                + "  `Nombre` varchar(45) DEFAULT NULL,\n"
                + "  `FechaNacimiento` date DEFAULT NULL,\n"
                + "  `Sexo` int(11) DEFAULT NULL,\n"
                + "  `EstadoCivil` int(11) DEFAULT NULL,\n"
                + "  `Hijos` int(11) DEFAULT NULL,\n"
                + "  `Calle` varchar(100) DEFAULT NULL,\n"
                + "  `Nro` varchar(5) DEFAULT NULL,\n"
                + "  `Piso` varchar(2) DEFAULT NULL,\n"
                + "  `Dpto` varchar(4) DEFAULT NULL,\n"
                + "  `Barrio` varchar(45) DEFAULT NULL,\n"
                + "  `idLocalidad` int(11) DEFAULT NULL,\n"
                + "  `Telefono` varchar(13) DEFAULT NULL,\n"
                + "  `idEmpCelular` int(11) unsigned DEFAULT NULL,\n"
                + "  `Celular` varchar(15) DEFAULT NULL,\n"
                + "  `CorreoElectronico` varchar(150) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idPersonas`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

        String TablaDias = "CREATE TABLE If Not Exists `dias` (\n"
                + "	`iddias` INT(11) NOT NULL,\n"
                + "	`Dias` VARCHAR(45) NULL DEFAULT NULL,\n"
                + "	PRIMARY KEY (`iddias`)\n"
                + ")\n"
                + "COLLATE='latin1_swedish_ci'\n"
                + "ENGINE=InnoDB\n"
                + ";";

        String InsertaDias = "INSERT INTO `gym2`.`dias`(`iddias`,`Dias`)\n"
                + "VALUES\n"
                + "(1, 'Domingo'),\n"
                + "(2, 'Lunes'),\n"
                + "(3, 'Martes'),\n"
                + "(4, 'Miércoles'),\n"
                + "(5, 'Jueves'),\n"
                + "(6, 'Viernes'),\n"
                + "(7, 'Sábado');";

        String TablaAsistenciasControl = "CREATE TABLE If Not Exists `asistencias_control` (\n"
                + "  `idControl` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `idSocios` int(11) NOT NULL,\n"
                + "  `CreditosDisponibles` int(11) DEFAULT NULL,\n"
                + "  `idActividades` int(11) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idControl`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaAsistenciasRegistro = "CREATE TABLE If Not Exists `asistencias_registro` (\n"
                + "  `idAsistencias` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `Fecha` datetime DEFAULT NULL,\n"
                + "  `idAsistentes` int(11) NOT NULL,\n"
                + "  `idActividades` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idAsistencias`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1\n"
                + "";

        String TablaChequesRegistro = "CREATE TABLE If Not Exists `cheques_registro` (\n"
                + "  `idChequeRegistro` int(10) unsigned NOT NULL,\n"
                + "  `idCheques` varchar(45) NOT NULL,\n"
                + "  `idCliente` int(10) unsigned NOT NULL,\n"
                + "  `idBanco` int(10) unsigned NOT NULL,\n"
                + "  `idPlaza` varchar(60) NOT NULL,\n"
                + "  `FechaCobro` datetime NOT NULL,\n"
                + "  `Importe` decimal(10,2) NOT NULL,\n"
                + "  PRIMARY KEY (`idChequeRegistro`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

        String TablaCelularesEmpresas = "CREATE TABLE If Not Exists `empresascelulares` (\n"
                + "  `idEmpCelular` int(11) NOT NULL,\n"
                + "  `Denominacion` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idEmpCelular`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1\n"
                + "";
        String TablaEstadoCivil = "CREATE TABLE IF NOT EXISTS `estadocivil` (\n"
                + "  `idEstadoCivil` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `Denominacion` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idEstadoCivil`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String SQLInsertaEstadoCivil = "INSERT INTO gym2.estadocivil (idEstadoCivil, Denominacion) VALUES (1,'Soltero'), (2,'Casado'),('3','Divorciado'), ('4','Viudo'), ('5','No especificado');";

        String TablaEstados = "CREATE TABLE If Not Exists `estados` (\n"
                + "  `idestados` int(11) NOT NULL,\n"
                + "  `estados` varchar(20) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idestados`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";

        String TablaFormaPago = "CREATE TABLE If Not Exists `formapago` (\n"
                + "  `idFormaPago` int(10) unsigned NOT NULL AUTO_INCREMENT,\n"
                + "  `FormaPago` varchar(30) NOT NULL,\n"
                + "  PRIMARY KEY (`idFormaPago`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaHorarios = "CREATE TABLE IF NOT EXISTS `horarios` (\n"
                + "  `idhorarios` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `Horarios` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idhorarios`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1";
        String TablaLocalidades = "CREATE TABLE If Not Exists `localidades` (\n"
                + "  `idLocalidades` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `Localidades` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idLocalidades`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaMedidas = "CREATE TABLE If Not Exists `medidas` (\n"
                + "  `idMedidas` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `idSocios` int(11) DEFAULT NULL,\n"
                + "  `Fecha` date DEFAULT NULL,\n"
                + "  `Alto` int(11) DEFAULT NULL,\n"
                + "  `Peso` float DEFAULT NULL,\n"
                + "  `Pecho` decimal(2,0) DEFAULT NULL,\n"
                + "  `Abdomen` decimal(2,0) DEFAULT NULL,\n"
                + "  `Cintura` decimal(2,0) DEFAULT NULL,\n"
                + "  `BrazoIzq` decimal(2,0) DEFAULT NULL,\n"
                + "  `BrazoDer` decimal(2,0) DEFAULT NULL,\n"
                + "  `MusloIzq` decimal(2,0) DEFAULT NULL,\n"
                + "  `MusloDer` decimal(2,0) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idMedidas`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaProfesores = "CREATE TABLE IF NOT EXISTS `profesores` (\n"
                + "  `idProfesores` int(6) NOT NULL AUTO_INCREMENT,\n"
                + "  `idPersonas` int(6) NOT NULL,\n"
                + "  `FechaAlta` datetime DEFAULT NULL,\n"
                + "  `Documento1` varchar(200) DEFAULT NULL,\n"
                + "  `Documento2` varchar(200) DEFAULT NULL,\n"
                + "  `Imagen` varchar(200) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idProfesores`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaPagosRegistros = "CREATE TABLE IF NOT EXISTS `pagos_registro` (\n"
                + "  `idRegistro_Pagos` int(6) NOT NULL AUTO_INCREMENT,\n"
                + "  `idSocios` int(6) DEFAULT NULL,\n"
                + "  `Fecha` datetime DEFAULT NULL,\n"
                + "  `Importe` decimal(10,2) DEFAULT NULL,\n"
                + "  `idFormaPago` int(11) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idRegistro_Pagos`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaRelacionSARP = "CREATE TABLE IF NOT EXISTS `relacion_s_a_t_p` (\n"
                + "  `idrelacion_socio_actividad` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `idSocios` int(11) NOT NULL,\n"
                + "  `idActividades` int(11) NOT NULL,\n"
                + "  `idDias` int(11) NOT NULL,\n"
                + "  `idHorarios` int(11) DEFAULT NULL,\n"
                + "  `idProfesores` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idrelacion_socio_actividad`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        String TablaRelacionPADH = "CREATE TABLE IF NOT EXISTS `relacion_p_a_d_h` (\n"
                + "  `idrelacion_p_a_h_d` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `idProfesores` int(11) DEFAULT NULL,\n"
                + "  `idActividades` int(11) DEFAULT NULL,\n"
                + "  `idDias` int(11) DEFAULT NULL,\n"
                + "  `idHorarios` int(11) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idrelacion_p_a_h_d`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1";

        /*
         Generar Tablas para:
         * Presupuestos
         * Recibos
         * Notas de crédito
         * Notas de débito
         * Romaneos cant al an la

         */
//        Logueo.Conexion(Usuario, Clave);
//        //Logueo.Ejecutar(CrearBaseDatosUsuarios);
//        Logueo.Ejecutar("use Usuarios");
//      //  Logueo.Ejecutar(CreartablaUsuarios);
//        Logueo.Ejecutar(InsertarUsuarioLogin);
//        Logueo.Ejecutar(InsertarUsuarioAsistentes);
//
//        Logueo.Ejecutar(GrantUsuarioLogin);
//        Logueo.Ejecutar(GrantUsuarioAsistentes);
//        Logueo.Ejecutar(CrearBaseDatosGym);
//        Logueo.Ejecutar("use gym2");
//        Logueo.Ejecutar(GrantGymAsistentes);
//        Logueo.Ejecutar(GrantUsuario);
//
//        Logueo.Ejecutar(TablaActividades);
//        Logueo.Ejecutar(TablaLocalidades);
//        Logueo.Ejecutar(CrearTablaGym_Bancos);
//        Logueo.Ejecutar(TablaSocios);
//        Logueo.Ejecutar(TablaPersonas);
//        Logueo.Ejecutar(TablaDias);
//        Logueo.Ejecutar(InsertaDias);
//        Logueo.Ejecutar(TablaAsistenciasControl);
//        Logueo.Ejecutar(TablaAsistenciasRegistro);
//        Logueo.Ejecutar(TablaChequesRegistro);
//        Logueo.Ejecutar(TablaCelularesEmpresas);
//        Logueo.Ejecutar(TablaEstadoCivil);
//        Logueo.Ejecutar(SQLInsertaEstadoCivil);
//        Logueo.Ejecutar(TablaEstados);
//        Logueo.Ejecutar(TablaFormaPago);
//        Logueo.Ejecutar(TablaHorarios);
//        Logueo.Ejecutar(TablaMedidas);
//        Logueo.Ejecutar(TablaProfesores);
//        Logueo.Ejecutar(TablaPagosRegistros);
//        Logueo.Ejecutar(TablaRelacionSARP);
//        Logueo.Ejecutar(TablaRelacionPADH);
//
//        //TODO Consultar si existe la base antes de ejecutar todo, para ganar velocidad
//        //TODO Eliminar el usuario Login al no usarlo
//        // Logueo.Ejecutar(CrearBaseDatosMovimientos);
//        //  Logueo.Ejecutar(CrearBaseDatosCuentasCorrientes);
//        //Logueo.Ejecutar(CrearTablaSocios);
        // Logueo.Ejecutar(CrearTablaGym_Ventas);
        //Logueo.Ejecutar(CrearTablaGym_DetalleVentas);
        //Logueo.Ejecutar(CrearTablaGym_Compras);
        // Logueo.Ejecutar(CrearTablaGym_DetalleCompras);
        // Logueo.Ejecutar(CrearTablaGym_Productos);
        // Logueo.Ejecutar(CrearTablaGym_Proveedores);
        // Logueo.Ejecutar(CrearTablaGym_Clientes);
        //  Logueo.Ejecutar(CrearTablaGym_Cheques);
        // Logueo.Ejecutar(CrearTablaGym_Familias);
        //  Logueo.Ejecutar(CrearTablaGym_Gastos);
        // Logueo.Ejecutar(CrearTablaGym_DetalleRomaneo);
        //  Logueo.Ejecutar(CrearTablaGym_Comprobantes);
        // Logueo.Ejecutar(CrearTablaGym_Forma_venta);
        // Logueo.Ejecutar(CrearTablaGym_Forma_pago);
        // Logueo.Ejecutar(CrearTablaGym_Stock);*/
//Logueo.Ejecutar(Base);
//        Logueo.CerrarConexionDB();

    }
}
