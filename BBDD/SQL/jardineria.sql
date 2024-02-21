
CREATE TABLE oficina (
  codigo_oficina VARCHAR(10) NOT NULL,
  ciudad VARCHAR(30) NOT NULL,
  pais VARCHAR(50) NOT NULL,
  region VARCHAR(50) DEFAULT NULL,
  codigo_postal VARCHAR(10) NOT NULL,
  telefono VARCHAR(20) NOT NULL,
  linea_direccion1 VARCHAR(50) NOT NULL,
  linea_direccion2 VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (codigo_oficina)
);

CREATE TABLE empleado (
  codigo_empleado INTEGER NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  apellido1 VARCHAR(50) NOT NULL,
  apellido2 VARCHAR(50) DEFAULT NULL,
  extension VARCHAR(10) NOT NULL,
  email VARCHAR(100) NOT NULL,
  codigo_oficina VARCHAR(10) NOT NULL,
  codigo_jefe INTEGER DEFAULT NULL,
  puesto VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (codigo_empleado),
  FOREIGN KEY (codigo_oficina) REFERENCES oficina (codigo_oficina),
  FOREIGN KEY (codigo_jefe) REFERENCES empleado (codigo_empleado)
);

CREATE TABLE gama_producto (
  gama VARCHAR(50) NOT NULL,
  descripcion_texto VARCHAR(250),
  descripcion_html VARCHAR(250),
  imagen VARCHAR(256),
  PRIMARY KEY (gama)
);

CREATE TABLE cliente (
  codigo_cliente INTEGER NOT NULL,
  nombre_cliente VARCHAR(50) NOT NULL,
  nombre_contacto VARCHAR(30) DEFAULT NULL,
  apellido_contacto VARCHAR(30) DEFAULT NULL,
  telefono VARCHAR(15) NOT NULL,
  fax VARCHAR(15) NOT NULL,
  linea_direccion1 VARCHAR(50) NOT NULL,
  linea_direccion2 VARCHAR(50) DEFAULT NULL,
  ciudad VARCHAR(50) NOT NULL,
  region VARCHAR(50) DEFAULT NULL,
  pais VARCHAR(50) DEFAULT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  codigo_empleado_rep_ventas INTEGER DEFAULT NULL,
  limite_credito NUMERIC(15,2) DEFAULT NULL,
  PRIMARY KEY (codigo_cliente),
  FOREIGN KEY (codigo_empleado_rep_ventas) REFERENCES empleado (codigo_empleado)
);

CREATE TABLE pedido (
  codigo_pedido INTEGER NOT NULL,
  fecha_pedido date NOT NULL,
  fecha_esperada date NOT NULL,
  fecha_entrega date DEFAULT NULL,
  estado VARCHAR(15) NOT NULL,
  comentarios VARCHAR(250),
  codigo_cliente INTEGER NOT NULL,
  PRIMARY KEY (codigo_pedido),
  FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente)
);

CREATE TABLE producto (
  codigo_producto VARCHAR(15) NOT NULL,
  nombre VARCHAR(70) NOT NULL,
  gama VARCHAR(50) NOT NULL,
  dimensiones VARCHAR(25) NULL,
  proveedor VARCHAR(50) DEFAULT NULL,
  descripcion VARCHAR(2000) NULL,
  cantidad_en_stock SMALLINT NOT NULL,
  precio_venta NUMERIC(15,2) NOT NULL,
  precio_proveedor NUMERIC(15,2) DEFAULT NULL,
  PRIMARY KEY (codigo_producto),
  FOREIGN KEY (gama) REFERENCES gama_producto (gama)
);

CREATE TABLE detalle_pedido (
  codigo_pedido INTEGER NOT NULL,
  codigo_producto VARCHAR(15) NOT NULL,
  cantidad INTEGER NOT NULL,
  precio_unidad NUMERIC(15,2) NOT NULL,
  numero_linea SMALLINT NOT NULL,
  PRIMARY KEY (codigo_pedido, codigo_producto),
  FOREIGN KEY (codigo_pedido) REFERENCES pedido (codigo_pedido),
  FOREIGN KEY (codigo_producto) REFERENCES producto (codigo_producto)
);

CREATE TABLE pago (
  codigo_cliente INTEGER NOT NULL,
  forma_pago VARCHAR(40) NOT NULL,
  id_transaccion VARCHAR(50) NOT NULL,
  fecha_pago date NOT NULL,
  total NUMERIC(15,2) NOT NULL,
  PRIMARY KEY (codigo_cliente, id_transaccion),
  FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo_cliente)
);

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
-- Datos
INSERT INTO oficina VALUES ('BCN-ES','Barcelona','Espa�a','Barcelona','08019','+34 93 3561182','Avenida Diagonal, 38','3A escalera Derecha');
INSERT INTO oficina VALUES ('BOS-USA','Boston','EEUU','MA','02108','+1 215 837 0825','1550 Court Place','Suite 102');
INSERT INTO oficina VALUES ('LON-UK','Londres','Inglaterra','EMEA','EC2N 1HN','+44 20 78772041','52 Old Broad Street','Ground Floor');
INSERT INTO oficina VALUES ('MAD-ES','Madrid','Espa�a','Madrid','28032','+34 91 7514487','Bulevar Indalecio Prieto, 32','');
INSERT INTO oficina VALUES ('PAR-FR','Paris','Francia','EMEA','75017','+33 14 723 4404','29 Rue Jouffroy d''abbans','');
INSERT INTO oficina VALUES ('SFC-USA','San Francisco','EEUU','CA','94080','+1 650 219 4782','100 Market Street','Suite 300');
INSERT INTO oficina VALUES ('SYD-AU','Sydney','Australia','APAC','NSW 2010','+61 2 9264 2451','5-11 Wentworth Avenue','Floor #2');
INSERT INTO oficina VALUES ('TAL-ES','Talavera de la Reina','Espa�a','Castilla-LaMancha','45632','+34 925 867231','Francisco Aguirre, 32','5� piso (exterior)');
INSERT INTO oficina VALUES ('TOK-JP','Tokyo','Jap�n','Chiyoda-Ku','102-8578','+81 33 224 5000','4-1 Kioicho','');

INSERT INTO empleado VALUES (1,'Marcos','Maga�a','Perez','3897','marcos@jardineria.es','TAL-ES',NULL,'Director General');
INSERT INTO empleado VALUES (2,'Ruben','L�pez','Martinez','2899','rlopez@jardineria.es','TAL-ES',1,'Subdirector Marketing');
INSERT INTO empleado VALUES (3,'Alberto','Soria','Carrasco','2837','asoria@jardineria.es','TAL-ES',2,'Subdirector Ventas');
INSERT INTO empleado VALUES (4,'Maria','Sol�s','Jerez','2847','msolis@jardineria.es','TAL-ES',2,'Secretaria');
INSERT INTO empleado VALUES (5,'Felipe','Rosas','Marquez','2844','frosas@jardineria.es','TAL-ES',3,'Representante Ventas');
INSERT INTO empleado VALUES (6,'Juan Carlos','Ortiz','Serrano','2845','cortiz@jardineria.es','TAL-ES',3,'Representante Ventas');
INSERT INTO empleado VALUES (7,'Carlos','Soria','Jimenez','2444','csoria@jardineria.es','MAD-ES',3,'Director Oficina');
INSERT INTO empleado VALUES (8,'Mariano','L�pez','Murcia','2442','mlopez@jardineria.es','MAD-ES',7,'Representante Ventas');
INSERT INTO empleado VALUES (9,'Lucio','Campoamor','Mart�n','2442','lcampoamor@jardineria.es','MAD-ES',7,'Representante Ventas');
INSERT INTO empleado VALUES (10,'Hilario','Rodriguez','Huertas','2444','hrodriguez@jardineria.es','MAD-ES',7,'Representante Ventas');
INSERT INTO empleado VALUES (11,'Emmanuel','Maga�a','Perez','2518','manu@jardineria.es','BCN-ES',3,'Director Oficina');
INSERT INTO empleado VALUES (12,'Jos� Manuel','Martinez','De la Osa','2519','jmmart@hotmail.es','BCN-ES',11,'Representante Ventas');
INSERT INTO empleado VALUES (13,'David','Palma','Aceituno','2519','dpalma@jardineria.es','BCN-ES',11,'Representante Ventas');
INSERT INTO empleado VALUES (14,'Oscar','Palma','Aceituno','2519','opalma@jardineria.es','BCN-ES',11,'Representante Ventas');
INSERT INTO empleado VALUES (15,'Francois','Fignon','','9981','ffignon@gardening.com','PAR-FR',3,'Director Oficina');
INSERT INTO empleado VALUES (16,'Lionel','Narvaez','','9982','lnarvaez@gardening.com','PAR-FR',15,'Representante Ventas');
INSERT INTO empleado VALUES (17,'Laurent','Serra','','9982','lserra@gardening.com','PAR-FR',15,'Representante Ventas');
INSERT INTO empleado VALUES (18,'Michael','Bolton','','7454','mbolton@gardening.com','SFC-USA',3,'Director Oficina');
INSERT INTO empleado VALUES (19,'Walter Santiago','Sanchez','Lopez','7454','wssanchez@gardening.com','SFC-USA',18,'Representante Ventas');
INSERT INTO empleado VALUES (20,'Hilary','Washington','','7565','hwashington@gardening.com','BOS-USA',3,'Director Oficina');
INSERT INTO empleado VALUES (21,'Marcus','Paxton','','7565','mpaxton@gardening.com','BOS-USA',20,'Representante Ventas');
INSERT INTO empleado VALUES (22,'Lorena','Paxton','','7665','lpaxton@gardening.com','BOS-USA',20,'Representante Ventas');
INSERT INTO empleado VALUES (23,'Nei','Nishikori','','8734','nnishikori@gardening.com','TOK-JP',3,'Director Oficina');
INSERT INTO empleado VALUES (24,'Narumi','Riko','','8734','nriko@gardening.com','TOK-JP',23,'Representante Ventas');
INSERT INTO empleado VALUES (25,'Takuma','Nomura','','8735','tnomura@gardening.com','TOK-JP',23,'Representante Ventas');
INSERT INTO empleado VALUES (26,'Amy','Johnson','','3321','ajohnson@gardening.com','LON-UK',3,'Director Oficina');
INSERT INTO empleado VALUES (27,'Larry','Westfalls','','3322','lwestfalls@gardening.com','LON-UK',26,'Representante Ventas');
INSERT INTO empleado VALUES (28,'John','Walton','','3322','jwalton@gardening.com','LON-UK',26,'Representante Ventas');
INSERT INTO empleado VALUES (29,'Kevin','Fallmer','','3210','kfalmer@gardening.com','SYD-AU',3,'Director Oficina');
INSERT INTO empleado VALUES (30,'Julian','Bellinelli','','3211','jbellinelli@gardening.com','SYD-AU',29,'Representante Ventas');
INSERT INTO empleado VALUES (31,'Mariko','Kishi','','3211','mkishi@gardening.com','SYD-AU',29,'Representante Ventas');

INSERT INTO gama_producto VALUES ('Herbaceas','Plantas para jardin decorativas',NULL,NULL);
INSERT INTO gama_producto VALUES ('Herramientas','Herramientas para todo tipo de acci�n',NULL,NULL);
INSERT INTO gama_producto VALUES ('Arom�ticas','Plantas arom�ticas',NULL,NULL);
INSERT INTO gama_producto VALUES ('Frutales','�rboles peque�os de producci�n frutal',NULL,NULL);
INSERT INTO gama_producto VALUES ('Ornamentales','Plantas vistosas para la decoraci�n del jard�n',NULL,NULL);

INSERT INTO cliente VALUES (1,'GoldFish Garden','Daniel G','GoldFish','5556901745','5556901746','False Street 52 2 A',NULL,'San Francisco',NULL,'USA','24006',19,3000);
INSERT INTO cliente VALUES (3,'Gardening Associates','Anne','Wright','5557410345','5557410346','Wall-e Avenue',NULL,'Miami','Miami','USA','24010',19,6000);
INSERT INTO cliente VALUES (4,'Gerudo Valley','Link','Flaute','5552323129','5552323128','Oaks Avenue n�22',NULL,'New York',NULL,'USA','85495',22,12000);
INSERT INTO cliente VALUES (5,'Tendo Garden','Akane','Tendo','55591233210','55591233211','Null Street n�69',NULL,'Miami',NULL,'USA','696969',22,600000);
INSERT INTO cliente VALUES (6,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','Spain','28945',8,154310);
INSERT INTO cliente VALUES (7,'Beragua','Jose','Bermejo','654987321','916549872','C/pintor segundo','Getafe','Madrid','Madrid','Spain','28942',11,20000);
INSERT INTO cliente VALUES (8,'Club Golf Puerta del hierro','Paco','Lopez','62456810','919535678','C/sinesio delgado','Madrid','Madrid','Madrid','Spain','28930',11,40000);
INSERT INTO cliente VALUES (9,'Naturagua','Guillermo','Rengifo','689234750','916428956','C/majadahonda','Boadilla','Madrid','Madrid','Spain','28947',11,32000);
INSERT INTO cliente VALUES (10,'DaraDistribuciones','David','Serrano','675598001','916421756','C/azores','Fuenlabrada','Madrid','Madrid','Spain','28946',11,50000);
INSERT INTO cliente VALUES (11,'Madrile�a de riegos','Jose','Taca�o','655983045','916689215','C/Laga�as','Fuenlabrada','Madrid','Madrid','Spain','28943',11,20000);
INSERT INTO cliente VALUES (12,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','Spain','28945',8,154310);
INSERT INTO cliente VALUES (13,'Camunas Jardines S.L.','Pedro','Camunas','34914873241','34914871541','C/Virgenes 45','C/Princesas 2 1�B','San Lorenzo del Escorial','Madrid','Spain','28145',8,16481);
INSERT INTO cliente VALUES (14,'Dardena S.A.','Juan','Rodriguez','34912453217','34912484764','C/Nueva York 74',NULL,'Madrid','Madrid','Spain','28003',8,321000);
INSERT INTO cliente VALUES (15,'Jardin de Flores','Javier','Villar','654865643','914538776','C/ O�a 34',NULL,'Madrid','Madrid','Spain','28950',30,40000);
INSERT INTO cliente VALUES (16,'Flores Marivi','Maria','Rodriguez','666555444','912458657','C/Leganes24',NULL,'Fuenlabrada','Madrid','Spain','28945',5,1500);
INSERT INTO cliente VALUES (17,'Flowers, S.A','Beatriz','Fernandez','698754159','978453216','C/Luis Salquillo4',NULL,'Montornes del valles','Barcelona','Spain','24586',5,3500);
INSERT INTO cliente VALUES (18,'Naturajardin','Victoria','Cruz','612343529','916548735','Plaza Magall�n 15',NULL,'Madrid','Madrid','Spain','28011',30,5050);
INSERT INTO cliente VALUES (19,'Golf S.A.','Luis','Martinez','916458762','912354475','C/Estancado',NULL,'Santa cruz de Tenerife','Islas Canarias','Spain','38297',12,30000);
INSERT INTO cliente VALUES (20,'Americh Golf Management SL','Mario','Suarez','964493072','964493063','C/Letardo',NULL,'Barcelona','Catalu�a','Spain','12320',12,20000);
INSERT INTO cliente VALUES (21,'Aloha','Cristian','Rodrigez','916485852','914489898','C/Roman 3',NULL,'Canarias','Canarias','Spain','35488',12,50000);
INSERT INTO cliente VALUES (22,'El Prat','Francisco','Camacho','916882323','916493211','Avenida Tibidabo',NULL,'Barcelona','Catalu�a','Spain','12320',12,30000);
INSERT INTO cliente VALUES (23,'Sotogrande','Maria','Santillana','915576622','914825645','C/Paseo del Parque',NULL,'Sotogrande','Cadiz','Spain','11310',12,60000);
INSERT INTO cliente VALUES (24,'Vivero Humanes','Federico','Gomez','654987690','916040875','C/Miguel Echegaray 54',NULL,'Humanes','Madrid','Spain','28970',30,7430);
INSERT INTO cliente VALUES (25,'Fuenla City','Tony','Mu�oz Mena','675842139','915483754','C/Callo 52',NULL,'Fuenlabrada','Madrid','Spain','28574',5,4500);
INSERT INTO cliente VALUES (26,'Jardines y Mansiones Cactus SL','Eva Mar�a','S�nchez','916877445','914477777','Pol�gono Industrial Maspalomas, N�52','M�stoles','Madrid','Madrid','Spain','29874',9,76000);
INSERT INTO cliente VALUES (27,'Jardiner�as Mat�as SL','Mat�as','San Mart�n','916544147','917897474','C/Francisco Arce, N�44','Bustarviejo','Madrid','Madrid','Spain','37845',9,100500);
INSERT INTO cliente VALUES (28,'Agrojardin','Benito','Lopez','675432926','916549264','C/Mar Caspio 43',NULL,'Getafe','Madrid','Spain','28904',30,8040);
INSERT INTO cliente VALUES (29,'Top Campo','Joseluis','Sanchez','685746512','974315924','C/Ibiza 32',NULL,'Humanes','Madrid','Spain','28574',5,5500);
INSERT INTO cliente VALUES (30,'Jardineria Sara','Sara','Marquez','675124537','912475843','C/Lima 1',NULL,'Fuenlabrada','Madrid','Spain','27584',5,7500);
INSERT INTO cliente VALUES (31,'Campohermoso','Luis','Jimenez','645925376','916159116','C/Peru 78',NULL,'Fuenlabrada','Madrid','Spain','28945',30,3250);
INSERT INTO cliente VALUES (32,'france telecom','Fraçois','Toulou','(33)5120578961','(33)5120578961','6 place d Alleray 15ème',NULL,'Paris',NULL,'France','75010',16,10000);
INSERT INTO cliente VALUES (33,'Mus�e du Louvre','Pierre','Delacroux','(33)0140205050','(33)0140205442','Quai du Louvre',NULL,'Paris',NULL,'France','75058',16,30000);
INSERT INTO cliente VALUES (35,'Tutifruti S.A','Jacob','Jones','2 9261-2433','2 9283-1695','level 24, St. Martins Tower.-31 Market St.',NULL,'Sydney','Nueva Gales del Sur','Australia','2000',31,10000);
INSERT INTO cliente VALUES (36,'Flores S.L.','Antonio','Romero','654352981','685249700','Avenida Espa�a',NULL,'Madrid','Fuenlabrada','Spain','29643',18,6000);
INSERT INTO cliente VALUES (37,'The Magic Garden','Richard','Mcain','926523468','9364875882','Lihgting Park',NULL,'London','London','United Kingdom','65930',18,10000);
INSERT INTO cliente VALUES (38,'El Jardin Viviente S.L','Justin','Smith','2 8005-7161','2 8005-7162','176 Cumberland Street The rocks',NULL,'Sydney','Nueva Gales del Sur','Australia','2003',31,8000);

INSERT INTO pedido VALUES (1,'2006-01-17','2006-01-19','2006-01-19','Entregado','Pagado a plazos',5);
INSERT INTO pedido VALUES (2,'2007-10-23','2007-10-28','2007-10-26','Entregado','La entrega llego antes de lo esperado',5);
INSERT INTO pedido VALUES (3,'2008-06-20','2008-06-25',NULL,'Rechazado','Limite de credito superado',5);
INSERT INTO pedido VALUES (4,'2009-01-20','2009-01-26',NULL,'Pendiente',NULL,5);
INSERT INTO pedido VALUES (8,'2008-11-09','2008-11-14','2008-11-14','Entregado','El cliente paga la mitad con tarjeta y la otra mitad con efectivo, se le realizan dos facturas',1);
INSERT INTO pedido VALUES (9,'2008-12-22','2008-12-27','2008-12-28','Entregado','El cliente comprueba la integridad del paquete, todo correcto',1);
INSERT INTO pedido VALUES (10,'2009-01-15','2009-01-20',NULL,'Pendiente','El cliente llama para confirmar la fecha - Esperando al proveedor',3);
INSERT INTO pedido VALUES (11,'2009-01-20','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 16:00h a 22:00h',1);
INSERT INTO pedido VALUES (12,'2009-01-22','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 9:00h a 13:00h',1);
INSERT INTO pedido VALUES (13,'2009-01-12','2009-01-14','2009-01-15','Entregado',NULL,7);
INSERT INTO pedido VALUES (14,'2009-01-02','2009-01-02',null,'Rechazado','mal pago',7);
INSERT INTO pedido VALUES (15,'2009-01-09','2009-01-12','2009-01-11','Entregado',NULL,7);
INSERT INTO pedido VALUES (16,'2009-01-06','2009-01-07','2009-01-15','Entregado',NULL,7);
INSERT INTO pedido VALUES (17,'2009-01-08','2009-01-09','2009-01-11','Entregado','mal estado',7);
INSERT INTO pedido VALUES (18,'2009-01-05','2009-01-06','2009-01-07','Entregado',NULL,9);
INSERT INTO pedido VALUES (19,'2009-01-18','2009-02-12',NULL,'Pendiente','entregar en murcia',9);
INSERT INTO pedido VALUES (20,'2009-01-20','2009-02-15',NULL,'Pendiente',NULL,9);
INSERT INTO pedido VALUES (21,'2009-01-09','2009-01-09','2009-01-09','Rechazado','mal pago',9);
INSERT INTO pedido VALUES (22,'2009-01-11','2009-01-11','2009-01-13','Entregado',NULL,9);
INSERT INTO pedido VALUES (23,'2008-12-30','2009-01-10',NULL,'Rechazado','El pedido fue anulado por el cliente',5);
INSERT INTO pedido VALUES (24,'2008-07-14','2008-07-31','2008-07-25','Entregado',NULL,14);
INSERT INTO pedido VALUES (25,'2009-02-02','2009-02-08',NULL,'Rechazado','El cliente carece de saldo en la cuenta asociada',1);
INSERT INTO pedido VALUES (26,'2009-02-06','2009-02-12',NULL,'Rechazado','El cliente anula la operacion para adquirir mas producto',3);
INSERT INTO pedido VALUES (27,'2009-02-07','2009-02-13',NULL,'Entregado','El pedido aparece como entregado pero no sabemos en que fecha',3);
INSERT INTO pedido VALUES (28,'2009-02-10','2009-02-17','2009-02-20','Entregado','El cliente se queja bastante de la espera asociada al producto',3);
INSERT INTO pedido VALUES (29,'2008-08-01','2008-09-01','2008-09-01','Rechazado','El cliente no est� conforme con el pedido',14);
INSERT INTO pedido VALUES (30,'2008-08-03','2008-09-03','2008-08-31','Entregado',NULL,13);
INSERT INTO pedido VALUES (31,'2008-09-04','2008-09-30','2008-10-04','Rechazado','El cliente ha rechazado por llegar 5 dias tarde',13);
INSERT INTO pedido VALUES (32,'2007-01-07','2007-01-19','2007-01-27','Entregado','Entrega tardia, el cliente puso reclamacion',4);
INSERT INTO pedido VALUES (33,'2007-05-20','2007-05-28',NULL,'Rechazado','El pedido fue anulado por el cliente',4);
INSERT INTO pedido VALUES (34,'2007-06-20','2008-06-28','2008-06-28','Entregado','Pagado a plazos',4);
INSERT INTO pedido VALUES (35,'2008-03-10','2009-03-20',NULL,'Rechazado','Limite de credito superado',4);
INSERT INTO pedido VALUES (36,'2008-10-15','2008-12-15','2008-12-10','Entregado',NULL,14);
INSERT INTO pedido VALUES (37,'2008-11-03','2009-11-13',NULL,'Pendiente','El pedido nunca llego a su destino',4);
INSERT INTO pedido VALUES (38,'2009-03-05','2009-03-06','2009-03-07','Entregado',NULL,19);
INSERT INTO pedido VALUES (39,'2009-03-06','2009-03-07','2009-03-09','Pendiente',NULL,19);
INSERT INTO pedido VALUES (40,'2009-03-09','2009-03-10','2009-03-13','Rechazado',NULL,19);
INSERT INTO pedido VALUES (41,'2009-03-12','2009-03-13','2009-03-13','Entregado',NULL,19);
INSERT INTO pedido VALUES (42,'2009-03-22','2009-03-23','2009-03-27','Entregado',NULL,19);
INSERT INTO pedido VALUES (43,'2009-03-25','2009-03-26','2009-03-28','Pendiente',NULL,23);
INSERT INTO pedido VALUES (44,'2009-03-26','2009-03-27','2009-03-30','Pendiente',NULL,23);
INSERT INTO pedido VALUES (45,'2009-04-01','2009-03-04','2009-03-07','Entregado',NULL,23);
INSERT INTO pedido VALUES (46,'2009-04-03','2009-03-04','2009-03-05','Rechazado',NULL,23);
INSERT INTO pedido VALUES (47,'2009-04-15','2009-03-17','2009-03-17','Entregado',NULL,23);
INSERT INTO pedido VALUES (48,'2008-03-17','2008-03-30','2008-03-29','Entregado','Seg�n el Cliente, el pedido lleg� defectuoso',26);
INSERT INTO pedido VALUES (49,'2008-07-12','2008-07-22','2008-07-30','Entregado','El pedido lleg� 1 d�a tarde, pero no hubo queja por parte de la empresa compradora',26);
INSERT INTO pedido VALUES (50,'2008-03-17','2008-08-09',NULL,'Pendiente','Al parecer, el pedido se ha extraviado a la altura de Sotalbo (�vila)',26);
INSERT INTO pedido VALUES (51,'2008-10-01','2008-10-14','2008-10-14','Entregado','Todo se entreg� a tiempo y en perfecto estado, a pesar del p�simo estado de las carreteras.',26);
INSERT INTO pedido VALUES (52,'2008-12-07','2008-12-21',NULL,'Pendiente','El transportista ha llamado a Eva Mar�a para indicarle que el pedido llegar� m�s tarde de lo esperado.',26);
INSERT INTO pedido VALUES (53,'2008-10-15','2008-11-15','2008-11-09','Entregado','El pedido llega 6 dias antes',13);
INSERT INTO pedido VALUES (54,'2009-01-11','2009-02-11',NULL,'Pendiente',NULL,14);
INSERT INTO pedido VALUES (55,'2008-12-10','2009-01-10','2009-01-11','Entregado','Retrasado 1 dia por problemas de transporte',14);
INSERT INTO pedido VALUES (56,'2008-12-19','2009-01-20',NULL,'Rechazado','El cliente a anulado el pedido el dia 2009-01-10',13);
INSERT INTO pedido VALUES (57,'2009-01-05','2009-02-05',NULL,'Pendiente',NULL,13);
INSERT INTO pedido VALUES (58,'2009-01-24','2009-01-31','2009-01-30','Entregado','Todo correcto',3);
INSERT INTO pedido VALUES (59,'2008-11-09','2008-11-14','2008-11-14','Entregado','El cliente paga la mitad con tarjeta y la otra mitad con efectivo, se le realizan dos facturas',1);
INSERT INTO pedido VALUES (60,'2008-12-22','2008-12-27','2008-12-28','Entregado','El cliente comprueba la integridad del paquete, todo correcto',1);
INSERT INTO pedido VALUES (61,'2009-01-15','2009-01-20',NULL,'Pendiente','El cliente llama para confirmar la fecha - Esperando al proveedor',3);
INSERT INTO pedido VALUES (62,'2009-01-20','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 16:00h a 22:00h',1);
INSERT INTO pedido VALUES (63,'2009-01-22','2009-01-27',NULL,'Pendiente','El cliente requiere que el pedido se le entregue de 9:00h a 13:00h',1);
INSERT INTO pedido VALUES (64,'2009-01-24','2009-01-31','2009-01-30','Entregado','Todo correcto',1);
INSERT INTO pedido VALUES (65,'2009-02-02','2009-02-08',NULL,'Rechazado','El cliente carece de saldo en la cuenta asociada',1);
INSERT INTO pedido VALUES (66,'2009-02-06','2009-02-12',NULL,'Rechazado','El cliente anula la operacion para adquirir mas producto',3);
INSERT INTO pedido VALUES (67,'2009-02-07','2009-02-13',NULL,'Entregado','El pedido aparece como entregado pero no sabemos en que fecha',3);
INSERT INTO pedido VALUES (68,'2009-02-10','2009-02-17','2009-02-20','Entregado','El cliente se queja bastante de la espera asociada al producto',3);
INSERT INTO pedido VALUES (74,'2009-01-14','2009-01-22',NULL,'Rechazado','El pedido no llego el dia que queria el cliente por fallo del transporte',15);
INSERT INTO pedido VALUES (75,'2009-01-11','2009-01-13','2009-01-13','Entregado','El pedido llego perfectamente',15);
INSERT INTO pedido VALUES (76,'2008-11-15','2008-11-23','2008-11-23','Entregado',NULL,15);
INSERT INTO pedido VALUES (77,'2009-01-03','2009-01-08',NULL,'Pendiente','El pedido no pudo ser entregado por problemas meteorologicos',15);
INSERT INTO pedido VALUES (78,'2008-12-15','2008-12-17','2008-12-17','Entregado','Fue entregado, pero faltaba mercancia que sera entregada otro dia',15);
INSERT INTO pedido VALUES (79,'2009-01-12','2009-01-13','2009-01-13','Entregado',NULL,28);
INSERT INTO pedido VALUES (80,'2009-01-25','2009-01-26',NULL,'Pendiente','No termin� el pago',28);
INSERT INTO pedido VALUES (81,'2009-01-18','2009-01-24',NULL,'Rechazado','Los producto estaban en mal estado',28);
INSERT INTO pedido VALUES (82,'2009-01-20','2009-01-29','2009-01-29','Entregado','El pedido llego un poco mas tarde de la hora fijada',28);
INSERT INTO pedido VALUES (83,'2009-01-24','2009-01-28',NULL,'Entregado',NULL,28);
INSERT INTO pedido VALUES (89,'2007-10-05','2007-12-13','2007-12-10','Entregado','La entrega se realizo dias antes de la fecha esperada por lo que el cliente quedo satisfecho',35);
INSERT INTO pedido VALUES (90,'2009-02-07','2008-02-17',NULL,'Pendiente','Debido a la nevada ca�da en la sierra, el pedido no podr� llegar hasta el d�a ',27);
INSERT INTO pedido VALUES (91,'2009-03-18','2009-03-29','2009-03-27','Entregado','Todo se entreg� a su debido tiempo, incluso con un d�a de antelaci�n',27);
INSERT INTO pedido VALUES (92,'2009-04-19','2009-04-30','2009-05-03','Entregado','El pedido se entreg� tarde debido a la festividad celebrada en Espa�a durante esas fechas',27);
INSERT INTO pedido VALUES (93,'2009-05-03','2009-05-30','2009-05-17','Entregado','El pedido se entreg� antes de lo esperado.',27);
INSERT INTO pedido VALUES (94,'2009-10-18','2009-11-01',NULL,'Pendiente','El pedido est� en camino.',27);
INSERT INTO pedido VALUES (95,'2008-01-04','2008-01-19','2008-01-19','Entregado',NULL,35);
INSERT INTO pedido VALUES (96,'2008-03-20','2008-04-12','2008-04-13','Entregado','La entrega se retraso un dia',35);
INSERT INTO pedido VALUES (97,'2008-10-08','2008-11-25','2008-11-25','Entregado',NULL,35);
INSERT INTO pedido VALUES (98,'2009-01-08','2009-02-13',NULL,'Pendiente',NULL,35);
INSERT INTO pedido VALUES (99,'2009-02-15','2009-02-27',NULL,'Pendiente',NULL,16);
INSERT INTO pedido VALUES (100,'2009-01-10','2009-01-15','2009-01-15','Entregado','El pedido llego perfectamente',16);
INSERT INTO pedido VALUES (101,'2009-03-07','2009-03-27',NULL,'Rechazado','El pedido fue rechazado por el cliente',16);
INSERT INTO pedido VALUES (102,'2008-12-28','2009-01-08','2009-01-08','Entregado','Pago pendiente',16);
INSERT INTO pedido VALUES (103,'2009-01-15','2009-01-20','2009-01-24','Pendiente',NULL,30);
INSERT INTO pedido VALUES (104,'2009-03-02','2009-03-06','2009-03-06','Entregado',NULL,30);
INSERT INTO pedido VALUES (105,'2009-02-14','2009-02-20',NULL,'Rechazado','el producto ha sido rechazado por la pesima calidad',30);
INSERT INTO pedido VALUES (106,'2009-05-13','2009-05-15','2009-05-20','Pendiente',NULL,30);
INSERT INTO pedido VALUES (107,'2009-04-06','2009-04-10','2009-04-10','Entregado',NULL,30);
INSERT INTO pedido VALUES (108,'2009-04-09','2009-04-15','2009-04-15','Entregado',NULL,16);
INSERT INTO pedido VALUES (109,'2006-05-25','2006-07-28','2006-07-28','Entregado',NULL,38);
INSERT INTO pedido VALUES (110,'2007-03-19','2007-04-24','2007-04-24','Entregado',NULL,38);
INSERT INTO pedido VALUES (111,'2008-03-05','2008-03-30','2008-03-30','Entregado',NULL,36);
INSERT INTO pedido VALUES (112,'2009-03-05','2009-04-06','2009-05-07','Pendiente',NULL,36);
INSERT INTO pedido VALUES (113,'2008-10-28','2008-11-09','2009-01-09','Rechazado','El producto ha sido rechazado por la tardanza de el envio',36);
INSERT INTO pedido VALUES (114,'2009-01-15','2009-01-29','2009-01-31','Entregado','El envio llego dos dias m�s tarde debido al mal tiempo',36);
INSERT INTO pedido VALUES (115,'2008-11-29','2009-01-26','2009-02-27','Pendiente',NULL,36);
INSERT INTO pedido VALUES (116,'2008-06-28','2008-08-01','2008-08-01','Entregado',NULL,38);
INSERT INTO pedido VALUES (117,'2008-08-25','2008-10-01',NULL,'Rechazado','El pedido ha sido rechazado por la acumulacion de pago pendientes del cliente',38);
INSERT INTO pedido VALUES (118,'2009-02-15','2009-02-27',NULL,'Pendiente',NULL,16);
INSERT INTO pedido VALUES (119,'2009-01-10','2009-01-15','2009-01-15','Entregado','El pedido llego perfectamente',16);
INSERT INTO pedido VALUES (120,'2009-03-07','2009-03-27',NULL,'Rechazado','El pedido fue rechazado por el cliente',16);
INSERT INTO pedido VALUES (121,'2008-12-28','2009-01-08','2009-01-08','Entregado','Pago pendiente',16);
INSERT INTO pedido VALUES (122,'2009-04-09','2009-04-15','2009-04-15','Entregado',NULL,16);
INSERT INTO pedido VALUES (123,'2009-01-15','2009-01-20','2009-01-24','Pendiente',NULL,30);
INSERT INTO pedido VALUES (124,'2009-03-02','2009-03-06','2009-03-06','Entregado',NULL,30);
INSERT INTO pedido VALUES (125,'2009-02-14','2009-02-20',NULL,'Rechazado','el producto ha sido rechazado por la pesima calidad',30);
INSERT INTO pedido VALUES (126,'2009-05-13','2009-05-15','2009-05-20','Pendiente',NULL,30);
INSERT INTO pedido VALUES (127,'2009-04-06','2009-04-10','2009-04-10','Entregado',NULL,30);
INSERT INTO pedido VALUES (128,'2008-11-10','2008-12-10','2008-12-29','Rechazado','El pedido ha sido rechazado por el cliente por el retraso en la entrega',38);

INSERT INTO producto VALUES ('11679','Sierra de Poda 400MM','Herramientas','0,258','HiperGarden Tools','Gracias a la poda se consigue manipular un poco la naturaleza, d�ndole la forma que m�s nos guste. Este trabajo b�sico de jardiner�a tambi�n facilita que las plantas crezcan de un modo m�s equilibrado, y que las flores y los frutos vuelvan cada a�o con regularidad. Lo mejor es dar forma cuando los ejemplares son j�venes, de modo que exijan pocos cuidados cuando sean adultos. Adem�s de saber cu�ndo y c�mo hay que podar, tener unas herramientas adecuadas para esta labor es tambi�n de vital importancia.',15,14,11);
INSERT INTO producto VALUES ('21636','Pala','Herramientas','0,156','HiperGarden Tools','Palas de acero con cresta de corte en la punta para cortar bien el terreno. Buena penetraci�n en tierras muy compactas.',15,14,13);
INSERT INTO producto VALUES ('22225','Rastrillo de Jard�n','Herramientas','1,064','HiperGarden Tools','Fabuloso rastillo que le ayudar� a eliminar piedras, hojas, ramas y otros elementos inc�modos en su jard�n.',15,12,11);
INSERT INTO producto VALUES ('30310','Azad�n','Herramientas','0,168','HiperGarden Tools','Longitud:24cm. Herramienta fabricada en acero y pintura epoxi,alargando su durabilidad y preveniendo la corrosi�n.Dise�o pensado para el ahorro de trabajo.',15,12,11);
INSERT INTO producto VALUES ('AR-001','Ajedrea','Arom�ticas','15-20','Murcia Seasons','Planta arom�tica que fresca se utiliza para condimentar carnes y ensaladas, y seca, para pastas, sopas y guisantes',140,1,0);
INSERT INTO producto VALUES ('AR-002','Lav�ndula Dentata','Arom�ticas','15-20','Murcia Seasons','Espliego de jard�n, Alhucema rizada, Alhucema dentada, Cantueso rizado. Familia: Lamiaceae.Origen: Espa�a y Portugal. Mata de unos 60 cm de alto. Las hojas son arom�ticas, dentadas y de color verde gris�ceas.  Produce compactas espigas de flores peque�as, ligeramente arom�ticas, tubulares,de color azulado y con br�cteas p�rpuras.  Frutos: nuececillas alargadas encerradas en el tubo del c�liz.  Se utiliza en jardineria y no en perfumeria como otros cantuesos, espliegos y lavandas.  Tiene propiedades aromatizantes y calmantes. Adecuadas para la formaci�n de setos bajos. Se dice que su aroma ahuyenta pulgones y otros insectos perjudiciales para las plantas vecinas.',140,1,0);
INSERT INTO producto VALUES ('AR-003','Mejorana','Arom�ticas','15-20','Murcia Seasons','Origanum majorana. No hay que confundirlo con el or�gano. Su sabor se parece m�s al tomillo, pero es m�s dulce y arom�tico.Se usan las hojas frescas o secas, picadas, machacadas o en polvo, en sopas, rellenos, quiches y tartas, tortillas, platos con papas y, como aderezo, en ramilletes de hierbas.El sabor delicado de la mejorana se elimina durante la cocci�n, de manera que es mejor agregarla cuando el plato est� en su punto o en aqu�llos que apenas necesitan cocci�n.',140,1,0);
INSERT INTO producto VALUES ('AR-004','Melissa ','Arom�ticas','15-20','Murcia Seasons','Es una planta perenne (dura varios a�os) conocida por el agradable y caracter�stico olor a lim�n que desprenden en verano. Nunca debe faltar en la huerta o jard�n por su agradable aroma y por los variados usos que tiene: planta olorosa, condimentaria y medicinal. Su cultivo es muy f�cil. Le va bien un suelo ligero, con buen drenaje y riego sin exceso. A pleno sol o por lo menos 5 horas de sol por d�a. Cada a�o, su abonado mineral correspondiente.En oto�o, la melisa pierde el agradable olor a lim�n que desprende en verano sus flores azules y blancas. En este momento se debe cortar a unos 20 cm. del suelo. Brotar� de forma densa en primavera.',140,1,0);
INSERT INTO producto VALUES ('AR-005','Mentha Sativa','Arom�ticas','15-20','Murcia Seasons','�Qui�n no conoce la Hierbabuena? Se trata de una plantita muy arom�tica, agradable y cultivada extensamente por toda Espa�a. Es hierba perenne (por tanto vive varios a�os, no es anual). Puedes cultivarla en maceta o plantarla en la tierra del jard�n o en un rinc�n del huerto. Lo m�s importante es que cuente con bastante agua. En primavera debes aportar fertilizantes minerales. Vive mejor en semisombra que a pleno sol.Si ves orugas o los agujeros en hojas consecuencia de su ataque, ret�ralas una a una a mano; no uses insecticidas qu�micos.',140,1,0);
INSERT INTO producto VALUES ('AR-006','Petrosilium Hortense (Peregil)','Arom�ticas','15-20','Murcia Seasons','Nombre cient�fico o latino: Petroselinum hortense, Petroselinum crispum. Nombre com�n o vulgar: Perejil, Perejil rizado Familia: Umbelliferae (Umbel�feras). Origen: el origen del perejil se encuentra en el Mediterraneo. Esta naturalizada en casi toda Europa. Se utiliza como condimento y para adorno, pero tambi�n en ensaladas. Se suele regalar en las fruter�as y verduler�as.El perejil lo hay de 2 tipos: de hojas planas y de hojas rizadas.',140,1,0);
INSERT INTO producto VALUES ('AR-007','Salvia Mix','Arom�ticas','15-20','Murcia Seasons','La Salvia es un peque�o arbusto que llega hasta el metro de alto.Tiene una vida breve, de unos pocos a�os.En el jard�n, como otras arom�ticas, queda muy bien en una rocalla o para hacer una bordura perfumada a cada lado de un camino de Salvia. Abona despu�s de cada corte y recorta el arbusto una vez pase la floraci�n.',140,1,0);
INSERT INTO producto VALUES ('AR-008','Thymus Citriodra (Tomillo lim�n)','Arom�ticas','15-20','Murcia Seasons','Nombre com�n o vulgar: Tomillo, Tremoncillo Familia: Labiatae (Labiadas).Origen: Regi�n mediterr�nea.Arbustillo bajo, de 15 a 40 cm de altura. Las hojas son muy peque�as, de unos 6 mm de longitud; seg�n la variedad pueden ser verdes, verdes gris�ceas, amarillas, o jaspeadas. Las flores aparecen de mediados de primavera hasta bien entrada la �poca estival y se presentan en racimos terminales que habitualmente son de color violeta o p�rpura aunque tambi�n pueden ser blancas. Esta planta despide un intenso y t�pico aroma, que se incrementa con el roce. El tomillo resulta de gran belleza cuando est� en flor. El tomillo atrae a avispas y abejas. En jardiner�a se usa como manchas, para hacer borduras, para aromatizar el ambiente, llenar huecos, cubrir rocas, para jardines en miniatura, etc. Arranque las flores y hojas secas del tallo y a�ad�los a un popurri, introd�zcalos en saquitos de hierbas o en la almohada.Tambi�n puede usar las ramas secas con flores para a�adir aroma y textura a cestos abiertos.',140,1,0);
INSERT INTO producto VALUES ('AR-009','Thymus Vulgaris','Arom�ticas','15-20','Murcia Seasons','Nombre com�n o vulgar: Tomillo, Tremoncillo Familia: Labiatae (Labiadas). Origen: Regi�n mediterr�nea. Arbustillo bajo, de 15 a 40 cm de altura. Las hojas son muy peque�as, de unos 6 mm de longitud; seg�n la variedad pueden ser verdes, verdes gris�ceas, amarillas, o jaspeadas. Las flores aparecen de mediados de primavera hasta bien entrada la �poca estival y se presentan en racimos terminales que habitualmente son de color violeta o p�rpura aunque tambi�n pueden ser blancas. Esta planta despide un intenso y t�pico aroma, que se incrementa con el roce. El tomillo resulta de gran belleza cuando est� en flor. El tomillo atrae a avispas y abejas.\r\n En jardiner�a se usa como manchas, para hacer borduras, para aromatizar el ambiente, llenar huecos, cubrir rocas, para jardines en miniatura, etc. Arranque las flores y hojas secas del tallo y a�ad�los a un popurri, introd�zcalos en saquitos de hierbas o en la almohada. Tambi�n puede usar las ramas secas con flores para a�adir aroma y textura a cestos abiertos.',140,1,0);
INSERT INTO producto VALUES ('AR-010','Santolina Chamaecyparys','Arom�ticas','15-20','Murcia Seasons','',140,1,0);
INSERT INTO producto VALUES ('FR-1','Expositor C�tricos Mix','Frutales','100-120','Frutales Talavera S.A','',15,7,5);
INSERT INTO producto VALUES ('FR-10','Limonero 2 a�os injerto','Frutales','','NaranjasValencianas.com','El limonero, pertenece al grupo de los c�tricos, teniendo su origen hace unos 20 millones de a�os en el sudeste asi�tico. Fue introducido por los �rabes en el �rea mediterr�nea entre los a�os 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selecci�n natural mediante hibridaciones espont�neas como a las producidas por el hombre, en este caso buscando las necesidades del mercado.',15,7,5);
INSERT INTO producto VALUES ('FR-100','Nectarina','Frutales','8/10','Frutales Talavera S.A','Se trata de un �rbol derivado por mutaci�n de los melocotoneros comunes, y los �nicos caracteres diferenciales son la ausencia de tomentosidad en la piel del fruto. La planta, si se deja crecer libremente, adopta un porte globoso con unas dimensiones medias de 4-6 metros',50,11,8);
INSERT INTO producto VALUES ('FR-101','Nogal','Frutales','8/10','Frutales Talavera S.A','',50,13,10);
INSERT INTO producto VALUES ('FR-102','Olea-Olivos','Frutales','8/10','Frutales Talavera S.A','Existen dos hip�tesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, L�bano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y m�s tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterr�neas espa�olas coinciden con el dominio romano, aunque fueron posteriormente los �rabes los que impulsaron su cultivo en Andaluc�a, convirtiendo a Espa�a en el primer pa�s productor de aceite de oliva a nivel mundial.',50,18,14);
INSERT INTO producto VALUES ('FR-103','Olea-Olivos','Frutales','10/12','Frutales Talavera S.A','Existen dos hip�tesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, L�bano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y m�s tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterr�neas espa�olas coinciden con el dominio romano, aunque fueron posteriormente los �rabes los que impulsaron su cultivo en Andaluc�a, convirtiendo a Espa�a en el primer pa�s productor de aceite de oliva a nivel mundial.',50,25,20);
INSERT INTO producto VALUES ('FR-104','Olea-Olivos','Frutales','12/4','Frutales Talavera S.A','Existen dos hip�tesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, L�bano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y m�s tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterr�neas espa�olas coinciden con el dominio romano, aunque fueron posteriormente los �rabes los que impulsaron su cultivo en Andaluc�a, convirtiendo a Espa�a en el primer pa�s productor de aceite de oliva a nivel mundial.',50,49,39);
INSERT INTO producto VALUES ('FR-105','Olea-Olivos','Frutales','14/16','Frutales Talavera S.A','Existen dos hip�tesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, L�bano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y m�s tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterr�neas espa�olas coinciden con el dominio romano, aunque fueron posteriormente los �rabes los que impulsaron su cultivo en Andaluc�a, convirtiendo a Espa�a en el primer pa�s productor de aceite de oliva a nivel mundial.',50,70,56);
INSERT INTO producto VALUES ('FR-106','Peral','Frutales','8/10','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',50,11,8);
INSERT INTO producto VALUES ('FR-107','Peral','Frutales','10/12','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',50,22,17);
INSERT INTO producto VALUES ('FR-108','Peral','Frutales','12/14','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',50,32,25);
INSERT INTO producto VALUES ('FR-11','Limonero 30/40','Frutales','','NaranjasValencianas.com','El limonero, pertenece al grupo de los c�tricos, teniendo su origen hace unos 20 millones de a�os en el sudeste asi�tico. Fue introducido por los �rabes en el �rea mediterr�nea entre los a�os 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selecci�n natural mediante hibridaciones espont�neas como a las producidas por el',15,100,80);
INSERT INTO producto VALUES ('FR-12','Kunquat ','Frutales','','NaranjasValencianas.com','su nombre cient�fico se origina en honor a un hoticultor escoc�s que recolect� espec�menes en China, (\"Fortunella\"), Robert Fortune (1812-1880), y \"margarita\", del lat�n margaritus-a-um = perla, en alusi�n a sus peque�os y brillantes frutos. Se trata de un arbusto o �rbol peque�o de 2-3 m de altura, inerme o con escasas espinas.Hojas lanceoladas de 4-8 (-15) cm de longitud, con el �pice redondeado y la base cuneada.Tienen el margen crenulado en su mitad superior, el haz verde brillante y el env�s m�s p�lido.Pec�olo ligeramente marginado.Flores perfumadas solitarias o agrupadas en inflorescencias axilares, blancas.El fruto es lo m�s caracter�stico, es el m�s peque�o de todos los c�tricos y el �nico cuya c�scara se puede comer.Frutos peque�os, con semillas, de corteza fina, dulce, arom�tica y comestible, y de pulpa naranja amarillenta y ligeramente �cida.Sus frutos son muy peque�os y tienen un car�cter principalmente ornamental.',15,21,16);
INSERT INTO producto VALUES ('FR-13','Kunquat  EXTRA con FRUTA','Frutales','150-170','NaranjasValencianas.com','su nombre cient�fico se origina en honor a un hoticultor escoc�s que recolect� espec�menes en China, (\"Fortunella\"), Robert Fortune (1812-1880), y \"margarita\", del lat�n margaritus-a-um = perla, en alusi�n a sus peque�os y brillantes frutos. Se trata de un arbusto o �rbol peque�o de 2-3 m de altura, inerme o con escasas espinas.Hojas lanceoladas de 4-8 (-15) cm de longitud, con el �pice redondeado y la base cuneada.Tienen el margen crenulado en su mitad superior, el haz verde brillante y el env�s m�s p�lido.Pec�olo ligeramente marginado.Flores perfumadas solitarias o agrupadas en inflorescencias axilares, blancas.El fruto es lo m�s caracter�stico, es el m�s peque�o de todos los c�tricos y el �nico cuya c�scara se puede comer.Frutos peque�os, con semillas, de corteza fina, dulce, arom�tica y comestible, y de pulpa naranja amarillenta y ligeramente �cida.Sus frutos son muy peque�os y tienen un car�cter principalmente ornamental.',15,57,45);
INSERT INTO producto VALUES ('FR-14','Calamondin Mini','Frutales','','Frutales Talavera S.A','Se trata de un peque�o arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son peque�as, el�pticas de 5-10 cm de longitud, con los pec�olos estrechamente alados.Posee 1 o 2 flores en situaci�n axilar, al final de las ramillas.Sus frutos son muy peque�os (3-3,5 cm de di�metro), con pocas semillas, esf�ricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y f�cilmente separable de la pulpa, que es dulce, �cida y comestible..',15,10,8);
INSERT INTO producto VALUES ('FR-15','Calamondin Copa ','Frutales','','Frutales Talavera S.A','Se trata de un peque�o arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son peque�as, el�pticas de 5-10 cm de longitud, con los pec�olos estrechamente alados.Posee 1 o 2 flores en situaci�n axilar, al final de las ramillas.Sus frutos son muy peque�os (3-3,5 cm de di�metro), con pocas semillas, esf�ricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y f�cilmente separable de la pulpa, que es dulce, �cida y comestible..',15,25,20);
INSERT INTO producto VALUES ('FR-16','Calamondin Copa EXTRA Con FRUTA','Frutales','100-120','Frutales Talavera S.A','Se trata de un peque�o arbolito de copa densa, con tendencia a la verticalidad, inerme o con cortas espinas. Sus hojas son peque�as, el�pticas de 5-10 cm de longitud, con los pec�olos estrechamente alados.Posee 1 o 2 flores en situaci�n axilar, al final de las ramillas.Sus frutos son muy peque�os (3-3,5 cm de di�metro), con pocas semillas, esf�ricos u ovales, con la zona apical aplanada; corteza de color naranja-rojizo, muy fina y f�cilmente separable de la pulpa, que es dulce, �cida y comestible..',15,45,36);
INSERT INTO producto VALUES ('FR-17','Rosal bajo 1ª -En maceta-inicio brotaci�n','Frutales','','Frutales Talavera S.A','',15,2,1);
INSERT INTO producto VALUES ('FR-18','ROSAL TREPADOR','Frutales','','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES ('FR-19','Camelia Blanco, Chrysler Rojo, Soraya Naranja, ','Frutales','','NaranjasValencianas.com','',350,4,3);
INSERT INTO producto VALUES ('FR-2','Naranjo -Plant�n joven 1 a�o injerto','Frutales','','NaranjasValencianas.com','El naranjo es un �rbol peque�o, que no supera los 3-5 metros de altura, con una copa compacta, c�nica, transformada en es�rica gracias a la poda. Su tronco es de color gris y liso, y las hojas son perennes, cori�ceas, de un verde intenso y brillante, con forma oval o el�ptico-lanceolada. Poseen, en el caso del naranjo amargo, un t�pico peciolo alado en forma de coraz�n, que en el naranjo dulce es m�s estrecho y menos patente.',15,6,4);
INSERT INTO producto VALUES ('FR-20','Landora Amarillo, Rose Gaujard bicolor blanco-rojo','Frutales','','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES ('FR-21','Kordes Perfect bicolor rojo-amarillo, Roundelay rojo fuerte','Frutales','','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES ('FR-22','Pitimini rojo','Frutales','','Frutales Talavera S.A','',350,4,3);
INSERT INTO producto VALUES ('FR-23','Rosal copa ','Frutales','','Frutales Talavera S.A','',400,8,6);
INSERT INTO producto VALUES ('FR-24','Albaricoquero Corbato','Frutales','','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES ('FR-25','Albaricoquero Moniqui','Frutales','','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES ('FR-26','Albaricoquero Kurrot','Frutales','','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',400,8,6);
INSERT INTO producto VALUES ('FR-27','Cerezo Burlat','Frutales','','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES ('FR-28','Cerezo Picota','Frutales','','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES ('FR-29','Cerezo Napole�n','Frutales','','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',400,8,6);
INSERT INTO producto VALUES ('FR-3','Naranjo 2 a�os injerto','Frutales','','NaranjasValencianas.com','El naranjo es un �rbol peque�o, que no supera los 3-5 metros de altura, con una copa compacta, c�nica, transformada en es�rica gracias a la poda. Su tronco es de color gris y liso, y las hojas son perennes, cori�ceas, de un verde intenso y brillante, con forma oval o el�ptico-lanceolada. Poseen, en el caso del naranjo amargo, un t�pico peciolo alado en forma de coraz�n, que en el naranjo dulce es m�s estrecho y menos patente.',15,7,5);
INSERT INTO producto VALUES ('FR-30','Ciruelo R. Claudia Verde   ','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-31','Ciruelo Santa Rosa','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-32','Ciruelo Golden Japan','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-33','Ciruelo Friar','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-34','Ciruelo Reina C. De Ollins','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-35','Ciruelo Claudia Negra','Frutales','','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',400,8,6);
INSERT INTO producto VALUES ('FR-36','Granado Mollar de Elche','Frutales','','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',400,9,7);
INSERT INTO producto VALUES ('FR-37','Higuera Napolitana','Frutales','','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',400,9,7);
INSERT INTO producto VALUES ('FR-38','Higuera Verdal','Frutales','','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',400,9,7);
INSERT INTO producto VALUES ('FR-39','Higuera Breva','Frutales','','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',400,9,7);
INSERT INTO producto VALUES ('FR-4','Naranjo calibre 8/10','Frutales','','NaranjasValencianas.com','El naranjo es un �rbol peque�o, que no supera los 3-5 metros de altura, con una copa compacta, c�nica, transformada en es�rica gracias a la poda. Su tronco es de color gris y liso, y las hojas son perennes, cori�ceas, de un verde intenso y brillante, con forma oval o el�ptico-lanceolada. Poseen, en el caso del naranjo amargo, un t�pico peciolo alado en forma de coraz�n, que en el naranjo dulce es m�s estrecho y menos patente.',15,29,23);
INSERT INTO producto VALUES ('FR-40','Manzano Starking Delicious','Frutales','','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',400,8,6);
INSERT INTO producto VALUES ('FR-41','Manzano Reineta','Frutales','','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',400,8,6);
INSERT INTO producto VALUES ('FR-42','Manzano Golden Delicious','Frutales','','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',400,8,6);
INSERT INTO producto VALUES ('FR-43','Membrillero Gigante de Wranja','Frutales','','Frutales Talavera S.A','',400,8,6);
INSERT INTO producto VALUES ('FR-44','Melocotonero Spring Crest','Frutales','','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',400,8,6);
INSERT INTO producto VALUES ('FR-45','Melocotonero Amarillo de Agosto','Frutales','','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',400,8,6);
INSERT INTO producto VALUES ('FR-46','Melocotonero Federica','Frutales','','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',400,8,6);
INSERT INTO producto VALUES ('FR-47','Melocotonero Paraguayo','Frutales','','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',400,8,6);
INSERT INTO producto VALUES ('FR-48','Nogal Com�n','Frutales','','Frutales Talavera S.A','',400,9,7);
INSERT INTO producto VALUES ('FR-49','Parra Uva de Mesa','Frutales','','Frutales Talavera S.A','',400,8,6);
INSERT INTO producto VALUES ('FR-5','Mandarino -Plant�n joven','Frutales','','Frutales Talavera S.A','',15,6,4);
INSERT INTO producto VALUES ('FR-50','Peral Castell','Frutales','','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',400,8,6);
INSERT INTO producto VALUES ('FR-51','Peral Williams','Frutales','','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',400,8,6);
INSERT INTO producto VALUES ('FR-52','Peral Conference','Frutales','','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',400,8,6);
INSERT INTO producto VALUES ('FR-53','Peral Blanq. de Aranjuez','Frutales','','Frutales Talavera S.A','�rbol piramidal, redondeado en su juventud, luego oval, que llega hasta 20 metros de altura y por t�rmino medio vive 65 a�os.Tronco alto, grueso, de corteza agrietada, gris, de la cual se destacan con frecuencia placas lenticulares.Las ramas se insertan formando �ngulo agudo con el tronco (45�), de corteza lisa, primero verde y luego gris-viol�cea, con numerosas lenticelas.',400,8,6);
INSERT INTO producto VALUES ('FR-54','N�spero Tanaca','Frutales','','Frutales Talavera S.A','Aunque originario del Sudeste de China, el n�spero lleg� a Europa procedente de Jap�n en el siglo XVIII como �rbol ornamental. En el siglo XIX se inici� el consumo de los frutos en toda el �rea mediterr�nea, donde se adapt� muy bien a las zonas de cultivo de los c�tricos.El cultivo intensivo comenz� a desarrollarse a finales de los a�os 60 y principios de los 70, cuando comenzaron a implantarse las variedades y t�cnicas de cultivo actualmente utilizadas.',400,9,7);
INSERT INTO producto VALUES ('FR-55','Olivo Cipresino','Frutales','','Frutales Talavera S.A','Existen dos hip�tesis sobre el origen del olivo, una que postula que proviene de las costas de Siria, L�bano e Israel y otra que considera que lo considera originario de Asia menor. La llegada a Europa probablemente tuvo lugar de mano de los Fenicios, en transito por Chipre, Creta, e Islas del Mar Egeo, pasando a Grecia y m�s tarde a Italia. Los primeros indicios de la presencia del olivo en las costas mediterr�neas espa�olas coinciden con el dominio romano, aunque fueron posteriormente los �rabes los que impulsaron su cultivo en Andaluc�a, convirtiendo a Espa�a en el primer pa�s productor de aceite de oliva a nivel mundial.',400,8,6);
INSERT INTO producto VALUES ('FR-56','Nectarina','Frutales','','Frutales Talavera S.A','',400,8,6);
INSERT INTO producto VALUES ('FR-57','Kaki Rojo Brillante','Frutales','','NaranjasValencianas.com','De crecimiento algo lento los primeros a�os, llega a alcanzar hasta doce metros de altura o m�s, aunque en cultivo se prefiere algo m�s bajo (5-6). Tronco corto y copa extendida. Ramifica muy poco debido a la dominancia apical. Porte m�s o menos piramidal, aunque con la edad se hace m�s globoso.',400,9,7);
INSERT INTO producto VALUES ('FR-58','Albaricoquero','Frutales','8/10','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',200,11,8);
INSERT INTO producto VALUES ('FR-59','Albaricoquero','Frutales','10/12','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',200,22,17);
INSERT INTO producto VALUES ('FR-6','Mandarino 2 a�os injerto','Frutales','','Frutales Talavera S.A','',15,7,5);
INSERT INTO producto VALUES ('FR-60','Albaricoquero','Frutales','12/14','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',200,32,25);
INSERT INTO producto VALUES ('FR-61','Albaricoquero','Frutales','14/16','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',200,49,39);
INSERT INTO producto VALUES ('FR-62','Albaricoquero','Frutales','16/18','Melocotones de Cieza S.A.','�rbol que puede pasar de los 6 m de altura, en la regi�n mediterr�nea con ramas formando una copa redondeada. La corteza del tronco es pardo-viol�cea, agrietada; las ramas son rojizas y extendidas cuando j�venes y las ramas secundarias son cortas, divergentes y escasas. Las yemas latentes son frecuentes especialmente sobre las ramas viejas.',200,70,56);
INSERT INTO producto VALUES ('FR-63','Cerezo','Frutales','8/10','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',300,11,8);
INSERT INTO producto VALUES ('FR-64','Cerezo','Frutales','10/12','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',15,22,17);
INSERT INTO producto VALUES ('FR-65','Cerezo','Frutales','12/14','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',200,32,25);
INSERT INTO producto VALUES ('FR-66','Cerezo','Frutales','14/16','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',50,49,39);
INSERT INTO producto VALUES ('FR-67','Cerezo','Frutales','16/18','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',50,70,56);
INSERT INTO producto VALUES ('FR-68','Cerezo','Frutales','18/20','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',50,80,64);
INSERT INTO producto VALUES ('FR-69','Cerezo','Frutales','20/25','Jerte Distribuciones S.L.','Las principales especies de cerezo cultivadas en el mundo son el cerezo dulce (Prunus avium), el guindo (P. cerasus) y el cerezo \"Duke\", h�brido de los anteriores. Ambas especies son naturales del sureste de Europa y oeste de Asia. El cerezo dulce tuvo su origen probablemente en el mar Negro y en el mar Caspio, difundi�ndose despu�s hacia Europa y Asia, llevado por los p�jaros y las migraciones humanas. Fue uno de los frutales m�s apreciados por los griegos y con el Imperio Romano se extendi� a regiones muy diversas. En la actualidad, el cerezo se encuentra difundido por numerosas regiones y pa�ses del mundo con clima templado',50,91,72);
INSERT INTO producto VALUES ('FR-7','Mandarino calibre 8/10','Frutales','','Frutales Talavera S.A','',15,29,23);
INSERT INTO producto VALUES ('FR-70','Ciruelo','Frutales','8/10','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',50,11,8);
INSERT INTO producto VALUES ('FR-71','Ciruelo','Frutales','10/12','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',50,22,17);
INSERT INTO producto VALUES ('FR-72','Ciruelo','Frutales','12/14','Frutales Talavera S.A','�rbol de tama�o mediano que alcanza una altura m�xima de 5-6 m. Tronco de corteza pardo-azulada, brillante, lisa o agrietada longitudinalmente. Produce ramas alternas, peque�as, delgadas, unas veces lisas, glabras y otras pubescentes y vellosas',50,32,25);
INSERT INTO producto VALUES ('FR-73','Granado','Frutales','8/10','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',50,13,10);
INSERT INTO producto VALUES ('FR-74','Granado','Frutales','10/12','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',50,22,17);
INSERT INTO producto VALUES ('FR-75','Granado','Frutales','12/14','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',50,32,25);
INSERT INTO producto VALUES ('FR-76','Granado','Frutales','14/16','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',50,49,39);
INSERT INTO producto VALUES ('FR-77','Granado','Frutales','16/18','Frutales Talavera S.A','peque�o �rbol caducifolio, a veces con porte arbustivo, de 3 a 6 m de altura, con el tronco retorcido. Madera dura y corteza escamosa de color gris�ceo. Las ramitas j�venes son m�s o menos cuadrangulares o angostas y de cuatro alas, posteriormente se vuelven redondas con corteza de color caf� gris�ceo, la mayor�a de las ramas, pero especialmente las peque�as ramitas axilares, son en forma de espina o terminan en una espina aguda; la copa es extendida.',50,70,56);
INSERT INTO producto VALUES ('FR-78','Higuera','Frutales','8/10','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,15,12);
INSERT INTO producto VALUES ('FR-79','Higuera','Frutales','10/12','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,22,17);
INSERT INTO producto VALUES ('FR-8','Limonero -Plant�n joven','Frutales','','NaranjasValencianas.com','El limonero, pertenece al grupo de los c�tricos, teniendo su origen hace unos 20 millones de a�os en el sudeste asi�tico. Fue introducido por los �rabes en el �rea mediterr�nea entre los a�os 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selecci�n natural mediante hibridaciones espont�neas como a las producidas por el',15,6,4);
INSERT INTO producto VALUES ('FR-80','Higuera','Frutales','12/14','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,32,25);
INSERT INTO producto VALUES ('FR-81','Higuera','Frutales','14/16','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,49,39);
INSERT INTO producto VALUES ('FR-82','Higuera','Frutales','16/18','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,70,56);
INSERT INTO producto VALUES ('FR-83','Higuera','Frutales','18/20','Frutales Talavera S.A','La higuera (Ficus carica L.) es un �rbol t�pico de secano en los pa�ses mediterr�neos. Su rusticidad y su f�cil multiplicaci�n hacen de la higuera un frutal muy apropiado para el cultivo extensivo.. Siempre ha sido considerado como �rbol que no requiere cuidado alguno una vez plantado y arraigado, limit�ndose el hombre a recoger de �l los frutos cuando maduran, unos para consumo en fresco y otros para conserva. Las �nicas higueras con cuidados culturales esmerados, en muchas comarcas, son las brevales, por el inter�s econ�mico de su primera cosecha, la de brevas.',50,80,64);
INSERT INTO producto VALUES ('FR-84','Kaki','Frutales','8/10','NaranjasValencianas.com','De crecimiento algo lento los primeros a�os, llega a alcanzar hasta doce metros de altura o m�s, aunque en cultivo se prefiere algo m�s bajo (5-6). Tronco corto y copa extendida. Ramifica muy poco debido a la dominancia apical. Porte m�s o menos piramidal, aunque con la edad se hace m�s globoso.',50,13,10);
INSERT INTO producto VALUES ('FR-85','Kaki','Frutales','16/18','NaranjasValencianas.com','De crecimiento algo lento los primeros a�os, llega a alcanzar hasta doce metros de altura o m�s, aunque en cultivo se prefiere algo m�s bajo (5-6). Tronco corto y copa extendida. Ramifica muy poco debido a la dominancia apical. Porte m�s o menos piramidal, aunque con la edad se hace m�s globoso.',50,70,56);
INSERT INTO producto VALUES ('FR-86','Manzano','Frutales','8/10','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',50,11,8);
INSERT INTO producto VALUES ('FR-87','Manzano','Frutales','10/12','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',50,22,17);
INSERT INTO producto VALUES ('FR-88','Manzano','Frutales','12/14','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',50,32,25);
INSERT INTO producto VALUES ('FR-89','Manzano','Frutales','14/16','Frutales Talavera S.A','alcanza como m�ximo 10 m. de altura y tiene una copa globosa. Tronco derecho que normalmente alcanza de 2 a 2,5 m. de altura, con corteza cubierta de lenticelas, lisa, adherida, de color ceniciento verdoso sobre los ramos y escamosa y gris parda sobre las partes viejas del �rbol. Tiene una vida de unos 60-80 a�os. Las ramas se insertan en �ngulo abierto sobre el tallo, de color verde oscuro, a veces tendiendo a negruzco o viol�ceo. Los brotes j�venes terminan con frecuencia en una espina',50,49,39);
INSERT INTO producto VALUES ('FR-9','Limonero calibre 8/10','Frutales','','NaranjasValencianas.com','El limonero, pertenece al grupo de los c�tricos, teniendo su origen hace unos 20 millones de a�os en el sudeste asi�tico. Fue introducido por los �rabes en el �rea mediterr�nea entre los a�os 1.000 a 1.200, habiendo experimentando numerosas modificaciones debidas tanto a la selecci�n natural mediante hibridaciones espont�neas como a las producidas por el',15,29,23);
INSERT INTO producto VALUES ('FR-90','N�spero','Frutales','16/18','Frutales Talavera S.A','Aunque originario del Sudeste de China, el n�spero lleg� a Europa procedente de Jap�n en el siglo XVIII como �rbol ornamental. En el siglo XIX se inici� el consumo de los frutos en toda el �rea mediterr�nea, donde se adapt� muy bien a las zonas de cultivo de los c�tricos.El cultivo intensivo comenz� a desarrollarse a finales de los a�os 60 y principios de los 70, cuando comenzaron a implantarse las variedades y t�cnicas de cultivo actualmente utilizadas.',50,70,56);
INSERT INTO producto VALUES ('FR-91','N�spero','Frutales','18/20','Frutales Talavera S.A','Aunque originario del Sudeste de China, el n�spero lleg� a Europa procedente de Jap�n en el siglo XVIII como �rbol ornamental. En el siglo XIX se inici� el consumo de los frutos en toda el �rea mediterr�nea, donde se adapt� muy bien a las zonas de cultivo de los c�tricos.El cultivo intensivo comenz� a desarrollarse a finales de los a�os 60 y principios de los 70, cuando comenzaron a implantarse las variedades y t�cnicas de cultivo actualmente utilizadas.',50,80,64);
INSERT INTO producto VALUES ('FR-92','Melocotonero','Frutales','8/10','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',50,11,8);
INSERT INTO producto VALUES ('FR-93','Melocotonero','Frutales','10/12','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',50,22,17);
INSERT INTO producto VALUES ('FR-94','Melocotonero','Frutales','12/14','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',50,32,25);
INSERT INTO producto VALUES ('FR-95','Melocotonero','Frutales','14/16','Melocotones de Cieza S.A.','�rbol caducifolio de porte bajo con corteza lisa, de color ceniciento. Sus hojas son alargadas con el margen ligeramente aserrado, de color verde brillante, algo m�s claras por el env�s. El melocotonero est� muy arraigado en la cultura asi�tica.\r\nEn Jap�n, el noble heroe Momotaro, una especie de Cid japon�s, naci� del interior de un enorme melocot�n que flotaba r�o abajo.\r\nEn China se piensa que comer melocot�n confiere longevidad al ser humano, ya que formaba parte de la dieta de sus dioses inmortales.',50,49,39);
INSERT INTO producto VALUES ('FR-96','Membrillero','Frutales','8/10','Frutales Talavera S.A','arbolito caducifolio de 4-6 m de altura con el tronco tortuoso y la corteza lisa, gris�cea, que se desprende en escamas con la edad. Copa irregular, con ramas inermes, flexuosas, parduzcas, punteadas. Ramillas j�venes tomentosas',50,11,8);
INSERT INTO producto VALUES ('FR-97','Membrillero','Frutales','10/12','Frutales Talavera S.A','arbolito caducifolio de 4-6 m de altura con el tronco tortuoso y la corteza lisa, gris�cea, que se desprende en escamas con la edad. Copa irregular, con ramas inermes, flexuosas, parduzcas, punteadas. Ramillas j�venes tomentosas',50,22,17);
INSERT INTO producto VALUES ('FR-98','Membrillero','Frutales','12/14','Frutales Talavera S.A','arbolito caducifolio de 4-6 m de altura con el tronco tortuoso y la corteza lisa, gris�cea, que se desprende en escamas con la edad. Copa irregular, con ramas inermes, flexuosas, parduzcas, punteadas. Ramillas j�venes tomentosas',50,32,25);
INSERT INTO producto VALUES ('FR-99','Membrillero','Frutales','14/16','Frutales Talavera S.A','arbolito caducifolio de 4-6 m de altura con el tronco tortuoso y la corteza lisa, gris�cea, que se desprende en escamas con la edad. Copa irregular, con ramas inermes, flexuosas, parduzcas, punteadas. Ramillas j�venes tomentosas',50,49,39);
INSERT INTO producto VALUES ('OR-001','Arbustos Mix Maceta','Ornamentales','40-60','Valencia Garden Service','',25,5,4);
INSERT INTO producto VALUES ('OR-100','Mimosa Injerto CLASICA Dealbata ','Ornamentales','100-110','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,12,9);
INSERT INTO producto VALUES ('OR-101','Expositor Mimosa Semilla Mix','Ornamentales','170-200','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,6,4);
INSERT INTO producto VALUES ('OR-102','Mimosa Semilla Bayleyana  ','Ornamentales','170-200','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,6,4);
INSERT INTO producto VALUES ('OR-103','Mimosa Semilla Bayleyana   ','Ornamentales','200-225','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,10,8);
INSERT INTO producto VALUES ('OR-104','Mimosa Semilla Cyanophylla    ','Ornamentales','200-225','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,10,8);
INSERT INTO producto VALUES ('OR-105','Mimosa Semilla Espectabilis  ','Ornamentales','160-170','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,6,4);
INSERT INTO producto VALUES ('OR-106','Mimosa Semilla Longifolia   ','Ornamentales','200-225','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,10,8);
INSERT INTO producto VALUES ('OR-107','Mimosa Semilla Floribunda 4 estaciones','Ornamentales','120-140','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,6,4);
INSERT INTO producto VALUES ('OR-108','Abelia Floribunda','Ornamentales','35-45','Viveros EL OASIS','',100,5,4);
INSERT INTO producto VALUES ('OR-109','Callistemom (Mix)','Ornamentales','35-45','Viveros EL OASIS','Limpitatubos. arbolito de 6-7 m de altura. Ramas flexibles y colgantes (de ah� lo de \"llor�n\")..',100,5,4);
INSERT INTO producto VALUES ('OR-110','Callistemom (Mix)','Ornamentales','40-60','Viveros EL OASIS','Limpitatubos. arbolito de 6-7 m de altura. Ramas flexibles y colgantes (de ah� lo de \"llor�n\")..',100,2,1);
INSERT INTO producto VALUES ('OR-111','Corylus Avellana \"Contorta\"','Ornamentales','35-45','Viveros EL OASIS','',100,5,4);
INSERT INTO producto VALUES ('OR-112','Escallonia (Mix)','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-113','Evonimus Emerald Gayeti','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-114','Evonimus Pulchellus','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-115','Forsytia Intermedia \"Lynwood\"','Ornamentales','35-45','Viveros EL OASIS','',120,7,5);
INSERT INTO producto VALUES ('OR-116','Hibiscus Syriacus  \"Diana\" -Blanco Puro','Ornamentales','35-45','Viveros EL OASIS','Por su capacidad de soportar podas, pueden ser f�cilmente moldeadas como bons�i en el transcurso de pocos a�os. Flores de muchos colores seg�n la variedad, desde el blanco puro al rojo intenso, del amarillo al anaranjado. La flor apenas dura 1 d�a, pero continuamente aparecen nuevas y la floraci�n se prolonga durante todo el periodo de crecimiento vegetativo.',120,7,5);
INSERT INTO producto VALUES ('OR-117','Hibiscus Syriacus  \"Helene\" -Blanco-C.rojo','Ornamentales','35-45','Viveros EL OASIS','Por su capacidad de soportar podas, pueden ser f�cilmente moldeadas como bons�i en el transcurso de pocos a�os. Flores de muchos colores seg�n la variedad, desde el blanco puro al rojo intenso, del amarillo al anaranjado. La flor apenas dura 1 d�a, pero continuamente aparecen nuevas y la floraci�n se prolonga durante todo el periodo de crecimiento vegetativo.',120,7,5);
INSERT INTO producto VALUES ('OR-118','Hibiscus Syriacus \"Pink Giant\" Rosa','Ornamentales','35-45','Viveros EL OASIS','Por su capacidad de soportar podas, pueden ser f�cilmente moldeadas como bons�i en el transcurso de pocos a�os. Flores de muchos colores seg�n la variedad, desde el blanco puro al rojo intenso, del amarillo al anaranjado. La flor apenas dura 1 d�a, pero continuamente aparecen nuevas y la floraci�n se prolonga durante todo el periodo de crecimiento vegetativo.',120,7,5);
INSERT INTO producto VALUES ('OR-119','Laurus Nobilis Arbusto - Ramificado Bajo','Ornamentales','40-50','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-120','Lonicera Nitida ','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-121','Lonicera Nitida \"Maigrum\"','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-122','Lonicera Pileata','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-123','Philadelphus \"Virginal\"','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-124','Prunus pisardii  ','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-125','Viburnum Tinus \"Eve Price\"','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-126','Weigelia \"Bristol Ruby\"','Ornamentales','35-45','Viveros EL OASIS','',120,5,4);
INSERT INTO producto VALUES ('OR-127','Camelia japonica','Ornamentales','40-60','Viveros EL OASIS','Arbusto excepcional por su floraci�n oto�al, invernal o primaveral. Flores: Las flores son solitarias, aparecen en el �pice de cada rama, y son con una corola simple o doble, y comprendiendo varios colores. Suelen medir unos 7-12 cm de di� metro y tienen 5 s�palos y 5 p�talos. Estambres numerosos unidos en la mitad o en 2/3 de su longitud.',50,7,5);
INSERT INTO producto VALUES ('OR-128','Camelia japonica ejemplar','Ornamentales','200-250','Viveros EL OASIS','Arbusto excepcional por su floraci�n oto�al, invernal o primaveral. Flores: Las flores son solitarias, aparecen en el �pice de cada rama, y son con una corola simple o doble, y comprendiendo varios colores. Suelen medir unos 7-12 cm de di� metro y tienen 5 s�palos y 5 p�talos. Estambres numerosos unidos en la mitad o en 2/3 de su longitud.',50,98,78);
INSERT INTO producto VALUES ('OR-129','Camelia japonica ejemplar','Ornamentales','250-300','Viveros EL OASIS','Arbusto excepcional por su floraci�n oto�al, invernal o primaveral. Flores: Las flores son solitarias, aparecen en el �pice de cada rama, y son con una corola simple o doble, y comprendiendo varios colores. Suelen medir unos 7-12 cm de di� metro y tienen 5 s�palos y 5 p�talos. Estambres numerosos unidos en la mitad o en 2/3 de su longitud.',50,110,88);
INSERT INTO producto VALUES ('OR-130','Callistemom COPA','Ornamentales','110/120','Viveros EL OASIS','Limpitatubos. arbolito de 6-7 m de altura. Ramas flexibles y colgantes (de ah� lo de \"llor�n\")..',50,18,14);
INSERT INTO producto VALUES ('OR-131','Leptospermum formado PIRAMIDE','Ornamentales','80-100','Viveros EL OASIS','',50,18,14);
INSERT INTO producto VALUES ('OR-132','Leptospermum COPA','Ornamentales','110/120','Viveros EL OASIS','',50,18,14);
INSERT INTO producto VALUES ('OR-133','Nerium oleander-CALIDAD \"GARDEN\"','Ornamentales','40-45','Viveros EL OASIS','',50,2,1);
INSERT INTO producto VALUES ('OR-134','Nerium Oleander Arbusto GRANDE','Ornamentales','160-200','Viveros EL OASIS','',100,38,30);
INSERT INTO producto VALUES ('OR-135','Nerium oleander COPA  Calibre 6/8','Ornamentales','50-60','Viveros EL OASIS','',100,5,4);
INSERT INTO producto VALUES ('OR-136','Nerium oleander ARBOL Calibre 8/10','Ornamentales','225-250','Viveros EL OASIS','',100,18,14);
INSERT INTO producto VALUES ('OR-137','ROSAL TREPADOR','Ornamentales','','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-138','Camelia Blanco, Chrysler Rojo, Soraya Naranja, ','Ornamentales','','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-139','Landora Amarillo, Rose Gaujard bicolor blanco-rojo','Ornamentales','','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-140','Kordes Perfect bicolor rojo-amarillo, Roundelay rojo fuerte','Ornamentales','','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-141','Pitimini rojo','Ornamentales','','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-142','Solanum Jazminoide','Ornamentales','150-160','Viveros EL OASIS','',100,2,1);
INSERT INTO producto VALUES ('OR-143','Wisteria Sinensis  azul, rosa, blanca','Ornamentales','','Viveros EL OASIS','',100,9,7);
INSERT INTO producto VALUES ('OR-144','Wisteria Sinensis INJERTADAS DECÓ','Ornamentales','140-150','Viveros EL OASIS','',100,12,9);
INSERT INTO producto VALUES ('OR-145','Bougamvillea Sanderiana Tutor','Ornamentales','80-100','Viveros EL OASIS','',100,2,1);
INSERT INTO producto VALUES ('OR-146','Bougamvillea Sanderiana Tutor','Ornamentales','125-150','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-147','Bougamvillea Sanderiana Tutor','Ornamentales','180-200','Viveros EL OASIS','',100,7,5);
INSERT INTO producto VALUES ('OR-148','Bougamvillea Sanderiana Espaldera','Ornamentales','45-50','Viveros EL OASIS','',100,7,5);
INSERT INTO producto VALUES ('OR-149','Bougamvillea Sanderiana Espaldera','Ornamentales','140-150','Viveros EL OASIS','',100,17,13);
INSERT INTO producto VALUES ('OR-150','Bougamvillea roja, naranja','Ornamentales','110-130','Viveros EL OASIS','',100,2,1);
INSERT INTO producto VALUES ('OR-151','Bougamvillea Sanderiana, 3 tut. piramide','Ornamentales','','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-152','Expositor �rboles clima continental','Ornamentales','170-200','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-153','Expositor �rboles clima mediterr�neo','Ornamentales','170-200','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-154','Expositor �rboles borde del mar','Ornamentales','170-200','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-155','Acer Negundo  ','Ornamentales','200-225','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-156','Acer platanoides  ','Ornamentales','200-225','Viveros EL OASIS','',100,10,8);
INSERT INTO producto VALUES ('OR-157','Acer Pseudoplatanus ','Ornamentales','200-225','Viveros EL OASIS','',100,10,8);
INSERT INTO producto VALUES ('OR-158','Brachychiton Acerifolius  ','Ornamentales','200-225','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-159','Brachychiton Discolor  ','Ornamentales','200-225','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-160','Brachychiton Rupestris','Ornamentales','170-200','Viveros EL OASIS','',100,10,8);
INSERT INTO producto VALUES ('OR-161','Cassia Corimbosa  ','Ornamentales','200-225','Viveros EL OASIS','',100,6,4);
INSERT INTO producto VALUES ('OR-162','Cassia Corimbosa ','Ornamentales','200-225','Viveros EL OASIS','',100,10,8);
INSERT INTO producto VALUES ('OR-163','Chitalpa Summer Bells   ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-164','Erytrina Kafra','Ornamentales','170-180','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-165','Erytrina Kafra','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-166','Eucalyptus Citriodora  ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-167','Eucalyptus Ficifolia  ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-168','Eucalyptus Ficifolia   ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-169','Hibiscus Syriacus  Var. Injertadas 1 Tallo ','Ornamentales','170-200','Viveros EL OASIS','',80,12,9);
INSERT INTO producto VALUES ('OR-170','Lagunaria Patersonii  ','Ornamentales','140-150','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-171','Lagunaria Patersonii   ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-172','Lagunaria patersonii  calibre 8/10','Ornamentales','200-225','Viveros EL OASIS','',80,18,14);
INSERT INTO producto VALUES ('OR-173','Morus Alba  ','Ornamentales','200-225','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-174','Morus Alba  calibre 8/10','Ornamentales','200-225','Viveros EL OASIS','',80,18,14);
INSERT INTO producto VALUES ('OR-175','Platanus Acerifolia   ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-176','Prunus pisardii  ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-177','Robinia Pseudoacacia Casque Rouge   ','Ornamentales','200-225','Viveros EL OASIS','',80,15,12);
INSERT INTO producto VALUES ('OR-178','Salix Babylonica  Pendula  ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-179','Sesbania Punicea   ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-180','Tamarix  Ramosissima Pink Cascade   ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-181','Tamarix  Ramosissima Pink Cascade   ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-182','Tecoma Stands   ','Ornamentales','200-225','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-183','Tecoma Stands  ','Ornamentales','200-225','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-184','Tipuana Tipu  ','Ornamentales','170-200','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-185','Pleioblastus distichus-Bamb� enano','Ornamentales','15-20','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-186','Sasa palmata ','Ornamentales','20-30','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-187','Sasa palmata ','Ornamentales','40-45','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-188','Sasa palmata ','Ornamentales','50-60','Viveros EL OASIS','',80,25,20);
INSERT INTO producto VALUES ('OR-189','Phylostachys aurea','Ornamentales','180-200','Viveros EL OASIS','',80,22,17);
INSERT INTO producto VALUES ('OR-190','Phylostachys aurea','Ornamentales','250-300','Viveros EL OASIS','',80,32,25);
INSERT INTO producto VALUES ('OR-191','Phylostachys Bambusa Spectabilis','Ornamentales','180-200','Viveros EL OASIS','',80,24,19);
INSERT INTO producto VALUES ('OR-192','Phylostachys biseti','Ornamentales','160-170','Viveros EL OASIS','',80,22,17);
INSERT INTO producto VALUES ('OR-193','Phylostachys biseti','Ornamentales','160-180','Viveros EL OASIS','',80,20,16);
INSERT INTO producto VALUES ('OR-194','Pseudosasa japonica (Metake)','Ornamentales','225-250','Viveros EL OASIS','',80,20,16);
INSERT INTO producto VALUES ('OR-195','Pseudosasa japonica (Metake) ','Ornamentales','30-40','Viveros EL OASIS','',80,6,4);
INSERT INTO producto VALUES ('OR-196','Cedrus Deodara ','Ornamentales','80-100','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-197','Cedrus Deodara \"Feeling Blue\" Novedad','Ornamentales','rastrero','Viveros EL OASIS','',80,12,9);
INSERT INTO producto VALUES ('OR-198','Juniperus chinensis \"Blue Alps\"','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-199','Juniperus Chinensis Stricta','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-200','Juniperus horizontalis Wiltonii','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-201','Juniperus squamata \"Blue Star\"','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-202','Juniperus x media Phitzeriana verde','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-203','Pinus Canariensis','Ornamentales','80-100','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-204','Pinus Halepensis','Ornamentales','160-180','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-205','Pinus Pinea -Pino Pi�onero','Ornamentales','70-80','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-206','Thuja Esmeralda ','Ornamentales','80-100','Viveros EL OASIS','',80,5,4);
INSERT INTO producto VALUES ('OR-207','Tuja Occidentalis Woodwardii','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-208','Tuja orientalis \"Aurea nana\"','Ornamentales','20-30','Viveros EL OASIS','',80,4,3);
INSERT INTO producto VALUES ('OR-209','Archontophoenix Cunninghamiana','Ornamentales','80 - 100','Viveros EL OASIS','',80,10,8);
INSERT INTO producto VALUES ('OR-210','Beucarnea Recurvata','Ornamentales','130  - 150','Viveros EL OASIS','',2,39,31);
INSERT INTO producto VALUES ('OR-211','Beucarnea Recurvata','Ornamentales','180 - 200','Viveros EL OASIS','',5,59,47);
INSERT INTO producto VALUES ('OR-212','Bismarckia Nobilis','Ornamentales','200 - 220','Viveros EL OASIS','',4,217,173);
INSERT INTO producto VALUES ('OR-213','Bismarckia Nobilis','Ornamentales','240 - 260','Viveros EL OASIS','',4,266,212);
INSERT INTO producto VALUES ('OR-214','Brahea Armata','Ornamentales','45 - 60','Viveros EL OASIS','',0,10,8);
INSERT INTO producto VALUES ('OR-215','Brahea Armata','Ornamentales','120 - 140','Viveros EL OASIS','',100,112,89);
INSERT INTO producto VALUES ('OR-216','Brahea Edulis','Ornamentales','80 - 100','Viveros EL OASIS','',100,19,15);
INSERT INTO producto VALUES ('OR-217','Brahea Edulis','Ornamentales','140 - 160','Viveros EL OASIS','',100,64,51);
INSERT INTO producto VALUES ('OR-218','Butia Capitata','Ornamentales','70 - 90','Viveros EL OASIS','',100,25,20);
INSERT INTO producto VALUES ('OR-219','Butia Capitata','Ornamentales','90 - 110','Viveros EL OASIS','',100,29,23);
INSERT INTO producto VALUES ('OR-220','Butia Capitata','Ornamentales','90 - 120','Viveros EL OASIS','',100,36,28);
INSERT INTO producto VALUES ('OR-221','Butia Capitata','Ornamentales','85 - 105','Viveros EL OASIS','',100,59,47);
INSERT INTO producto VALUES ('OR-222','Butia Capitata','Ornamentales','130 - 150','Viveros EL OASIS','',100,87,69);
INSERT INTO producto VALUES ('OR-223','Chamaerops Humilis','Ornamentales','40 - 45','Viveros EL OASIS','',100,4,3);
INSERT INTO producto VALUES ('OR-224','Chamaerops Humilis','Ornamentales','50 - 60','Viveros EL OASIS','',100,7,5);
INSERT INTO producto VALUES ('OR-225','Chamaerops Humilis','Ornamentales','70 - 90','Viveros EL OASIS','',100,10,8);
INSERT INTO producto VALUES ('OR-226','Chamaerops Humilis','Ornamentales','115 - 130','Viveros EL OASIS','',100,38,30);
INSERT INTO producto VALUES ('OR-227','Chamaerops Humilis','Ornamentales','130 - 150','Viveros EL OASIS','',100,64,51);
INSERT INTO producto VALUES ('OR-228','Chamaerops Humilis \"Cerifera\"','Ornamentales','70 - 80','Viveros EL OASIS','',100,32,25);
INSERT INTO producto VALUES ('OR-229','Chrysalidocarpus Lutescens -ARECA','Ornamentales','130 - 150','Viveros EL OASIS','',100,22,17);
INSERT INTO producto VALUES ('OR-230','Cordyline Australis -DRACAENA','Ornamentales','190 - 210','Viveros EL OASIS','',100,38,30);
INSERT INTO producto VALUES ('OR-231','Cycas Revoluta','Ornamentales','55 - 65','Viveros EL OASIS','',100,15,12);
INSERT INTO producto VALUES ('OR-232','Cycas Revoluta','Ornamentales','80 - 90','Viveros EL OASIS','',100,34,27);
INSERT INTO producto VALUES ('OR-233','Dracaena Drago','Ornamentales','60 - 70','Viveros EL OASIS','',1,13,10);
INSERT INTO producto VALUES ('OR-234','Dracaena Drago','Ornamentales','130 - 150','Viveros EL OASIS','',2,64,51);
INSERT INTO producto VALUES ('OR-235','Dracaena Drago','Ornamentales','150 - 175','Viveros EL OASIS','',2,92,73);
INSERT INTO producto VALUES ('OR-236','Jubaea Chilensis','Ornamentales','','Viveros EL OASIS','',100,49,39);
INSERT INTO producto VALUES ('OR-237','Livistonia Australis','Ornamentales','100 - 125','Viveros EL OASIS','',50,19,15);
INSERT INTO producto VALUES ('OR-238','Livistonia Decipiens','Ornamentales','90 - 110','Viveros EL OASIS','',50,19,15);
INSERT INTO producto VALUES ('OR-239','Livistonia Decipiens','Ornamentales','180 - 200','Viveros EL OASIS','',50,49,39);
INSERT INTO producto VALUES ('OR-240','Phoenix Canariensis','Ornamentales','110 - 130','Viveros EL OASIS','',50,6,4);
INSERT INTO producto VALUES ('OR-241','Phoenix Canariensis','Ornamentales','180 - 200','Viveros EL OASIS','',50,19,15);
INSERT INTO producto VALUES ('OR-242','Rhaphis Excelsa','Ornamentales','80 - 100','Viveros EL OASIS','',50,21,16);
INSERT INTO producto VALUES ('OR-243','Rhaphis Humilis','Ornamentales','150- 170','Viveros EL OASIS','',50,64,51);
INSERT INTO producto VALUES ('OR-244','Sabal Minor','Ornamentales','60 - 75','Viveros EL OASIS','',50,11,8);
INSERT INTO producto VALUES ('OR-245','Sabal Minor','Ornamentales','120 - 140','Viveros EL OASIS','',50,34,27);
INSERT INTO producto VALUES ('OR-246','Trachycarpus Fortunei','Ornamentales','90 - 105','Viveros EL OASIS','',50,18,14);
INSERT INTO producto VALUES ('OR-247','Trachycarpus Fortunei','Ornamentales','250-300','Viveros EL OASIS','',2,462,369);
INSERT INTO producto VALUES ('OR-248','Washingtonia Robusta','Ornamentales','60 - 70','Viveros EL OASIS','',15,3,2);
INSERT INTO producto VALUES ('OR-249','Washingtonia Robusta','Ornamentales','130 - 150','Viveros EL OASIS','',15,5,4);
INSERT INTO producto VALUES ('OR-250','Yucca Jewel','Ornamentales','80 - 105','Viveros EL OASIS','',15,10,8);
INSERT INTO producto VALUES ('OR-251','Zamia Furfuracaea','Ornamentales','90 - 110','Viveros EL OASIS','',15,168,134);
INSERT INTO producto VALUES ('OR-99','Mimosa DEALBATA Gaulois Astier  ','Ornamentales','200-225','Viveros EL OASIS','Acacia dealbata. Nombre com�n o vulgar: Mimosa fina, Mimosa, Mimosa com�n, Mimosa plateada, Aromo franc�s. Familia: Mimosaceae. Origen: Australia, Sureste, (N. G. del Sur y Victoria). Arbol de follaje persistente muy usado en parques por su atractiva floraci�n amarilla hacia fines del invierno. Altura: de 3 a 10 metros generalmente. Crecimiento r�pido. Follaje perenne de tonos plateados, muy ornamental. Sus hojas son de textura fina, de color verde y sus flores amarillas que aparecen en racimos grandes. Florece de Enero a Marzo (Hemisferio Norte). Legumbre de 5-9 cm de longitud, recta o ligeramente curvada, con los bordes algo constre�idos entre las semillas, que se disponen en el fruto longitudinalmente...',100,14,11);

INSERT INTO detalle_pedido VALUES (1,'FR-67',10,70,3);
INSERT INTO detalle_pedido VALUES (1,'OR-127',40,4,1);
INSERT INTO detalle_pedido VALUES (1,'OR-141',25,4,2);
INSERT INTO detalle_pedido VALUES (1,'OR-241',15,19,4);
INSERT INTO detalle_pedido VALUES (1,'OR-99',23,14,5);
INSERT INTO detalle_pedido VALUES (2,'FR-4',3,29,6);
INSERT INTO detalle_pedido VALUES (2,'FR-40',7,8,7);
INSERT INTO detalle_pedido VALUES (2,'OR-140',50,4,3);
INSERT INTO detalle_pedido VALUES (2,'OR-141',20,5,2);
INSERT INTO detalle_pedido VALUES (2,'OR-159',12,6,5);
INSERT INTO detalle_pedido VALUES (2,'OR-227',67,64,1);
INSERT INTO detalle_pedido VALUES (2,'OR-247',5,462,4);
INSERT INTO detalle_pedido VALUES (3,'FR-48',120,9,6);
INSERT INTO detalle_pedido VALUES (3,'OR-122',32,5,4);
INSERT INTO detalle_pedido VALUES (3,'OR-123',11,5,5);
INSERT INTO detalle_pedido VALUES (3,'OR-213',30,266,1);
INSERT INTO detalle_pedido VALUES (3,'OR-217',15,65,2);
INSERT INTO detalle_pedido VALUES (3,'OR-218',24,25,3);
INSERT INTO detalle_pedido VALUES (4,'FR-31',12,8,7);
INSERT INTO detalle_pedido VALUES (4,'FR-34',42,8,6);
INSERT INTO detalle_pedido VALUES (4,'FR-40',42,9,8);
INSERT INTO detalle_pedido VALUES (4,'OR-152',3,6,5);
INSERT INTO detalle_pedido VALUES (4,'OR-155',4,6,3);
INSERT INTO detalle_pedido VALUES (4,'OR-156',17,9,4);
INSERT INTO detalle_pedido VALUES (4,'OR-157',38,10,2);
INSERT INTO detalle_pedido VALUES (4,'OR-222',21,59,1);
INSERT INTO detalle_pedido VALUES (8,'FR-106',3,11,1);
INSERT INTO detalle_pedido VALUES (8,'FR-108',1,32,2);
INSERT INTO detalle_pedido VALUES (8,'FR-11',10,100,3);
INSERT INTO detalle_pedido VALUES (9,'AR-001',80,1,3);


INSERT INTO detalle_pedido VALUES (9,'AR-008',450,1,2);


INSERT INTO detalle_pedido VALUES (9,'FR-106',80,8,1);
INSERT INTO detalle_pedido VALUES (9,'FR-69',15,91,2);
INSERT INTO detalle_pedido VALUES (10,'FR-82',5,70,2);
INSERT INTO detalle_pedido VALUES (10,'FR-91',30,75,1);
INSERT INTO detalle_pedido VALUES (10,'OR-234',5,64,3);
INSERT INTO detalle_pedido VALUES (11,'AR-006',180,1,3);
INSERT INTO detalle_pedido VALUES (11,'OR-247',80,8,1);


INSERT INTO detalle_pedido VALUES (12,'AR-009',290,1,1);


INSERT INTO detalle_pedido VALUES (13,'11679',5,14,1);
INSERT INTO detalle_pedido VALUES (13,'21636',12,14,2);
INSERT INTO detalle_pedido VALUES (13,'FR-11',5,100,3);
INSERT INTO detalle_pedido VALUES (14,'FR-100',8,11,2);
INSERT INTO detalle_pedido VALUES (14,'FR-13',13,57,1);
INSERT INTO detalle_pedido VALUES (15,'FR-84',4,13,3);
INSERT INTO detalle_pedido VALUES (15,'OR-101',2,6,2);
INSERT INTO detalle_pedido VALUES (15,'OR-156',6,10,1);
INSERT INTO detalle_pedido VALUES (15,'OR-203',9,10,4);
INSERT INTO detalle_pedido VALUES (16,'30310',12,12,1);
INSERT INTO detalle_pedido VALUES (16,'FR-36',10,9,2);
INSERT INTO detalle_pedido VALUES (17,'11679',5,14,1);
INSERT INTO detalle_pedido VALUES (17,'22225',5,12,3);
INSERT INTO detalle_pedido VALUES (17,'FR-37',5,9,2);
INSERT INTO detalle_pedido VALUES (17,'FR-64',5,22,4);
INSERT INTO detalle_pedido VALUES (17,'OR-136',5,18,5);
INSERT INTO detalle_pedido VALUES (18,'22225',4,12,2);
INSERT INTO detalle_pedido VALUES (18,'FR-22',2,4,1);
INSERT INTO detalle_pedido VALUES (18,'OR-159',10,6,3);
INSERT INTO detalle_pedido VALUES (19,'30310',9,12,5);
INSERT INTO detalle_pedido VALUES (19,'FR-23',6,8,4);
INSERT INTO detalle_pedido VALUES (19,'FR-75',1,32,2);
INSERT INTO detalle_pedido VALUES (19,'FR-84',5,13,1);
INSERT INTO detalle_pedido VALUES (19,'OR-208',20,4,3);
INSERT INTO detalle_pedido VALUES (20,'11679',14,14,1);
INSERT INTO detalle_pedido VALUES (20,'30310',8,12,2);
INSERT INTO detalle_pedido VALUES (21,'21636',5,14,3);
INSERT INTO detalle_pedido VALUES (21,'FR-18',22,4,1);
INSERT INTO detalle_pedido VALUES (21,'FR-53',3,8,2);
INSERT INTO detalle_pedido VALUES (22,'OR-240',1,6,1);
INSERT INTO detalle_pedido VALUES (23,'AR-002',110,1,4);
INSERT INTO detalle_pedido VALUES (23,'FR-107',50,22,3);
INSERT INTO detalle_pedido VALUES (23,'FR-85',4,70,2);
INSERT INTO detalle_pedido VALUES (23,'OR-249',30,5,1);
INSERT INTO detalle_pedido VALUES (24,'22225',3,15,1);
INSERT INTO detalle_pedido VALUES (24,'FR-1',4,7,4);
INSERT INTO detalle_pedido VALUES (24,'FR-23',2,7,2);
INSERT INTO detalle_pedido VALUES (24,'OR-241',10,20,3);
INSERT INTO detalle_pedido VALUES (25,'FR-77',15,69,1);
INSERT INTO detalle_pedido VALUES (25,'FR-9',4,30,3);
INSERT INTO detalle_pedido VALUES (25,'FR-94',10,30,2);
INSERT INTO detalle_pedido VALUES (26,'FR-15',9,25,3);
INSERT INTO detalle_pedido VALUES (26,'OR-188',4,25,1);
INSERT INTO detalle_pedido VALUES (26,'OR-218',14,25,2);
INSERT INTO detalle_pedido VALUES (27,'OR-101',22,6,2);
INSERT INTO detalle_pedido VALUES (27,'OR-102',22,6,3);
INSERT INTO detalle_pedido VALUES (27,'OR-186',40,6,1);
INSERT INTO detalle_pedido VALUES (28,'FR-11',8,99,3);
INSERT INTO detalle_pedido VALUES (28,'OR-213',3,266,2);
INSERT INTO detalle_pedido VALUES (28,'OR-247',1,462,1);
INSERT INTO detalle_pedido VALUES (29,'FR-82',4,70,4);
INSERT INTO detalle_pedido VALUES (29,'FR-9',4,28,1);
INSERT INTO detalle_pedido VALUES (29,'FR-94',20,31,5);
INSERT INTO detalle_pedido VALUES (29,'OR-129',2,111,2);
INSERT INTO detalle_pedido VALUES (29,'OR-160',10,9,3);
INSERT INTO detalle_pedido VALUES (30,'AR-004',10,1,6);
INSERT INTO detalle_pedido VALUES (30,'FR-108',2,32,2);
INSERT INTO detalle_pedido VALUES (30,'FR-12',2,19,3);
INSERT INTO detalle_pedido VALUES (30,'FR-72',4,31,5);
INSERT INTO detalle_pedido VALUES (30,'FR-89',10,45,1);
INSERT INTO detalle_pedido VALUES (30,'OR-120',5,5,4);


INSERT INTO detalle_pedido VALUES (31,'AR-009',25,2,3);


INSERT INTO detalle_pedido VALUES (31,'FR-102',1,20,1);
INSERT INTO detalle_pedido VALUES (31,'FR-4',6,29,2);
INSERT INTO detalle_pedido VALUES (32,'11679',1,14,4);
INSERT INTO detalle_pedido VALUES (32,'21636',4,15,5);
INSERT INTO detalle_pedido VALUES (32,'22225',1,15,3);
INSERT INTO detalle_pedido VALUES (32,'OR-128',29,100,2);
INSERT INTO detalle_pedido VALUES (32,'OR-193',5,20,1);
INSERT INTO detalle_pedido VALUES (33,'FR-17',423,2,4);
INSERT INTO detalle_pedido VALUES (33,'FR-29',120,8,3);
INSERT INTO detalle_pedido VALUES (33,'OR-214',212,10,2);
INSERT INTO detalle_pedido VALUES (33,'OR-247',150,462,1);
INSERT INTO detalle_pedido VALUES (34,'FR-3',56,7,4);
INSERT INTO detalle_pedido VALUES (34,'FR-7',12,29,3);
INSERT INTO detalle_pedido VALUES (34,'OR-172',20,18,1);
INSERT INTO detalle_pedido VALUES (34,'OR-174',24,18,2);
INSERT INTO detalle_pedido VALUES (35,'21636',12,14,4);
INSERT INTO detalle_pedido VALUES (35,'FR-47',55,8,3);
INSERT INTO detalle_pedido VALUES (35,'OR-165',3,10,2);
INSERT INTO detalle_pedido VALUES (35,'OR-181',36,10,1);
INSERT INTO detalle_pedido VALUES (35,'OR-225',72,10,5);
INSERT INTO detalle_pedido VALUES (36,'30310',4,12,2);
INSERT INTO detalle_pedido VALUES (36,'FR-1',2,7,3);
INSERT INTO detalle_pedido VALUES (36,'OR-147',6,7,4);
INSERT INTO detalle_pedido VALUES (36,'OR-203',1,12,5);
INSERT INTO detalle_pedido VALUES (36,'OR-99',15,13,1);
INSERT INTO detalle_pedido VALUES (37,'FR-105',4,70,1);
INSERT INTO detalle_pedido VALUES (37,'FR-57',203,8,2);
INSERT INTO detalle_pedido VALUES (37,'OR-176',38,10,3);
INSERT INTO detalle_pedido VALUES (38,'11679',5,14,1);
INSERT INTO detalle_pedido VALUES (38,'21636',2,14,2);
INSERT INTO detalle_pedido VALUES (39,'22225',3,12,1);
INSERT INTO detalle_pedido VALUES (39,'30310',6,12,2);
INSERT INTO detalle_pedido VALUES (40,'AR-001',4,1,1);
INSERT INTO detalle_pedido VALUES (40,'AR-002',8,1,2);
INSERT INTO detalle_pedido VALUES (41,'AR-003',5,1,1);
INSERT INTO detalle_pedido VALUES (41,'AR-004',5,1,2);
INSERT INTO detalle_pedido VALUES (42,'AR-005',3,1,1);
INSERT INTO detalle_pedido VALUES (42,'AR-006',1,1,2);
INSERT INTO detalle_pedido VALUES (43,'AR-007',9,1,1);



INSERT INTO detalle_pedido VALUES (44,'AR-008',5,1,1);


INSERT INTO detalle_pedido VALUES (45,'AR-009',6,1,1);


INSERT INTO detalle_pedido VALUES (45,'AR-010',4,1,2);
INSERT INTO detalle_pedido VALUES (46,'FR-1',4,7,1);
INSERT INTO detalle_pedido VALUES (46,'FR-10',8,7,2);
INSERT INTO detalle_pedido VALUES (47,'FR-100',9,11,1);
INSERT INTO detalle_pedido VALUES (47,'FR-101',5,13,2);
INSERT INTO detalle_pedido VALUES (48,'FR-102',1,18,1);
INSERT INTO detalle_pedido VALUES (48,'FR-103',1,25,2);
INSERT INTO detalle_pedido VALUES (48,'OR-234',50,64,1);
INSERT INTO detalle_pedido VALUES (48,'OR-236',45,49,2);
INSERT INTO detalle_pedido VALUES (48,'OR-237',50,19,3);
INSERT INTO detalle_pedido VALUES (49,'OR-204',50,10,1);
INSERT INTO detalle_pedido VALUES (49,'OR-205',10,10,2);
INSERT INTO detalle_pedido VALUES (49,'OR-206',5,5,3);
INSERT INTO detalle_pedido VALUES (50,'OR-225',12,10,1);
INSERT INTO detalle_pedido VALUES (50,'OR-226',15,38,2);
INSERT INTO detalle_pedido VALUES (50,'OR-227',44,64,3);
INSERT INTO detalle_pedido VALUES (51,'OR-209',50,10,1);
INSERT INTO detalle_pedido VALUES (51,'OR-210',80,39,2);
INSERT INTO detalle_pedido VALUES (51,'OR-211',70,59,3);
INSERT INTO detalle_pedido VALUES (53,'FR-2',1,7,1);
INSERT INTO detalle_pedido VALUES (53,'FR-85',1,70,3);
INSERT INTO detalle_pedido VALUES (53,'FR-86',2,11,2);
INSERT INTO detalle_pedido VALUES (53,'OR-116',6,7,4);
INSERT INTO detalle_pedido VALUES (54,'11679',3,14,3);
INSERT INTO detalle_pedido VALUES (54,'FR-100',45,10,2);
INSERT INTO detalle_pedido VALUES (54,'FR-18',5,4,1);
INSERT INTO detalle_pedido VALUES (54,'FR-79',3,22,4);
INSERT INTO detalle_pedido VALUES (54,'OR-116',8,7,6);
INSERT INTO detalle_pedido VALUES (54,'OR-123',3,5,5);
INSERT INTO detalle_pedido VALUES (54,'OR-168',2,10,7);
INSERT INTO detalle_pedido VALUES (55,'OR-115',9,7,1);
INSERT INTO detalle_pedido VALUES (55,'OR-213',2,266,2);
INSERT INTO detalle_pedido VALUES (55,'OR-227',6,64,5);
INSERT INTO detalle_pedido VALUES (55,'OR-243',2,64,4);
INSERT INTO detalle_pedido VALUES (55,'OR-247',1,462,3);
INSERT INTO detalle_pedido VALUES (56,'OR-129',1,115,5);
INSERT INTO detalle_pedido VALUES (56,'OR-130',10,18,6);
INSERT INTO detalle_pedido VALUES (56,'OR-179',1,6,3);
INSERT INTO detalle_pedido VALUES (56,'OR-196',3,10,4);
INSERT INTO detalle_pedido VALUES (56,'OR-207',4,4,2);
INSERT INTO detalle_pedido VALUES (56,'OR-250',3,10,1);
INSERT INTO detalle_pedido VALUES (57,'FR-69',6,91,4);
INSERT INTO detalle_pedido VALUES (57,'FR-81',3,49,3);
INSERT INTO detalle_pedido VALUES (57,'FR-84',2,13,1);
INSERT INTO detalle_pedido VALUES (57,'FR-94',6,9,2);
INSERT INTO detalle_pedido VALUES (58,'OR-102',65,18,3);
INSERT INTO detalle_pedido VALUES (58,'OR-139',80,4,1);
INSERT INTO detalle_pedido VALUES (58,'OR-172',69,15,2);
INSERT INTO detalle_pedido VALUES (58,'OR-177',150,15,4);
INSERT INTO detalle_pedido VALUES (74,'FR-67',15,70,1);
INSERT INTO detalle_pedido VALUES (74,'OR-227',34,64,2);
INSERT INTO detalle_pedido VALUES (74,'OR-247',42,8,3);
INSERT INTO detalle_pedido VALUES (75,'AR-006',60,1,2);
INSERT INTO detalle_pedido VALUES (75,'FR-87',24,22,3);
INSERT INTO detalle_pedido VALUES (75,'OR-157',46,10,1);


INSERT INTO detalle_pedido VALUES (76,'AR-009',250,1,5);


INSERT INTO detalle_pedido VALUES (76,'FR-79',40,22,3);
INSERT INTO detalle_pedido VALUES (76,'FR-87',24,22,4);
INSERT INTO detalle_pedido VALUES (76,'FR-94',35,9,1);
INSERT INTO detalle_pedido VALUES (76,'OR-196',25,10,2);
INSERT INTO detalle_pedido VALUES (77,'22225',34,12,2);
INSERT INTO detalle_pedido VALUES (77,'30310',15,12,1);
INSERT INTO detalle_pedido VALUES (78,'FR-53',25,8,2);
INSERT INTO detalle_pedido VALUES (78,'FR-85',56,70,3);
INSERT INTO detalle_pedido VALUES (78,'OR-157',42,10,4);
INSERT INTO detalle_pedido VALUES (78,'OR-208',30,4,1);
INSERT INTO detalle_pedido VALUES (79,'OR-240',50,6,1);
INSERT INTO detalle_pedido VALUES (80,'FR-11',40,100,3);
INSERT INTO detalle_pedido VALUES (80,'FR-36',47,9,2);
INSERT INTO detalle_pedido VALUES (80,'OR-136',75,18,1);
INSERT INTO detalle_pedido VALUES (81,'OR-208',30,4,1);
INSERT INTO detalle_pedido VALUES (82,'OR-227',34,64,1);
INSERT INTO detalle_pedido VALUES (83,'OR-208',30,4,1);
INSERT INTO detalle_pedido VALUES (89,'FR-108',3,32,2);
INSERT INTO detalle_pedido VALUES (89,'FR-3',15,7,6);
INSERT INTO detalle_pedido VALUES (89,'FR-42',12,8,4);
INSERT INTO detalle_pedido VALUES (89,'FR-66',5,49,1);
INSERT INTO detalle_pedido VALUES (89,'FR-87',4,22,3);
INSERT INTO detalle_pedido VALUES (89,'OR-157',8,10,5);
INSERT INTO detalle_pedido VALUES (90,'AR-001',19,1,1);
INSERT INTO detalle_pedido VALUES (90,'AR-002',10,1,2);
INSERT INTO detalle_pedido VALUES (90,'AR-003',12,1,3);
INSERT INTO detalle_pedido VALUES (91,'FR-100',52,11,1);
INSERT INTO detalle_pedido VALUES (91,'FR-101',14,13,2);
INSERT INTO detalle_pedido VALUES (91,'FR-102',35,18,3);
INSERT INTO detalle_pedido VALUES (92,'FR-108',12,23,1);
INSERT INTO detalle_pedido VALUES (92,'FR-11',20,100,2);
INSERT INTO detalle_pedido VALUES (92,'FR-12',30,21,3);
INSERT INTO detalle_pedido VALUES (93,'FR-54',25,9,1);
INSERT INTO detalle_pedido VALUES (93,'FR-58',51,11,2);
INSERT INTO detalle_pedido VALUES (93,'FR-60',3,32,3);
INSERT INTO detalle_pedido VALUES (94,'11679',12,14,1);
INSERT INTO detalle_pedido VALUES (94,'FR-11',33,100,3);
INSERT INTO detalle_pedido VALUES (94,'FR-4',79,29,2);
INSERT INTO detalle_pedido VALUES (95,'FR-10',9,7,2);
INSERT INTO detalle_pedido VALUES (95,'FR-75',6,32,1);
INSERT INTO detalle_pedido VALUES (95,'FR-82',5,70,3);
INSERT INTO detalle_pedido VALUES (96,'FR-43',6,8,1);
INSERT INTO detalle_pedido VALUES (96,'FR-6',16,7,4);
INSERT INTO detalle_pedido VALUES (96,'FR-71',10,22,3);
INSERT INTO detalle_pedido VALUES (96,'FR-90',4,70,2);
INSERT INTO detalle_pedido VALUES (97,'FR-41',12,8,1);
INSERT INTO detalle_pedido VALUES (97,'FR-54',14,9,2);
INSERT INTO detalle_pedido VALUES (97,'OR-156',10,10,3);
INSERT INTO detalle_pedido VALUES (98,'FR-33',14,8,4);
INSERT INTO detalle_pedido VALUES (98,'FR-56',16,8,3);
INSERT INTO detalle_pedido VALUES (98,'FR-60',8,32,1);
INSERT INTO detalle_pedido VALUES (98,'FR-8',18,6,5);
INSERT INTO detalle_pedido VALUES (98,'FR-85',6,70,2);
INSERT INTO detalle_pedido VALUES (99,'OR-157',15,10,2);
INSERT INTO detalle_pedido VALUES (99,'OR-227',30,64,1);
INSERT INTO detalle_pedido VALUES (100,'FR-87',20,22,1);
INSERT INTO detalle_pedido VALUES (100,'FR-94',40,9,2);
INSERT INTO detalle_pedido VALUES (101,'AR-006',50,1,1);



INSERT INTO detalle_pedido VALUES (101,'AR-009',159,1,2);



INSERT INTO detalle_pedido VALUES (102,'22225',32,12,2);
INSERT INTO detalle_pedido VALUES (102,'30310',23,12,1);
INSERT INTO detalle_pedido VALUES (103,'FR-53',12,8,2);
INSERT INTO detalle_pedido VALUES (103,'OR-208',52,4,1);
INSERT INTO detalle_pedido VALUES (104,'FR-85',9,70,1);
INSERT INTO detalle_pedido VALUES (104,'OR-157',113,10,2);
INSERT INTO detalle_pedido VALUES (105,'OR-227',21,64,2);
INSERT INTO detalle_pedido VALUES (105,'OR-240',27,6,1);


INSERT INTO detalle_pedido VALUES (106,'AR-009',231,1,1);



INSERT INTO detalle_pedido VALUES (106,'OR-136',47,18,2);
INSERT INTO detalle_pedido VALUES (107,'30310',143,12,2);
INSERT INTO detalle_pedido VALUES (107,'FR-11',15,100,1);
INSERT INTO detalle_pedido VALUES (108,'FR-53',53,8,1);
INSERT INTO detalle_pedido VALUES (108,'OR-208',59,4,2);
INSERT INTO detalle_pedido VALUES (109,'FR-22',8,4,5);
INSERT INTO detalle_pedido VALUES (109,'FR-36',12,9,3);
INSERT INTO detalle_pedido VALUES (109,'FR-45',14,8,4);
INSERT INTO detalle_pedido VALUES (109,'OR-104',20,10,1);
INSERT INTO detalle_pedido VALUES (109,'OR-119',10,5,2);
INSERT INTO detalle_pedido VALUES (109,'OR-125',3,5,6);
INSERT INTO detalle_pedido VALUES (109,'OR-130',2,18,7);
INSERT INTO detalle_pedido VALUES (110,'AR-010',6,1,3);
INSERT INTO detalle_pedido VALUES (110,'FR-1',14,7,1);
INSERT INTO detalle_pedido VALUES (110,'FR-16',1,45,2);
INSERT INTO detalle_pedido VALUES (116,'21636',5,14,1);
INSERT INTO detalle_pedido VALUES (116,'AR-001',32,1,2);
INSERT INTO detalle_pedido VALUES (116,'AR-005',18,1,5);
INSERT INTO detalle_pedido VALUES (116,'FR-33',13,8,3);
INSERT INTO detalle_pedido VALUES (116,'OR-200',10,4,4);
INSERT INTO detalle_pedido VALUES (117,'FR-78',2,15,1);
INSERT INTO detalle_pedido VALUES (117,'FR-80',1,32,3);
INSERT INTO detalle_pedido VALUES (117,'OR-146',17,4,2);
INSERT INTO detalle_pedido VALUES (117,'OR-179',4,6,4);
INSERT INTO detalle_pedido VALUES (128,'AR-004',15,1,1);
INSERT INTO detalle_pedido VALUES (128,'OR-150',18,2,2);
INSERT INTO detalle_pedido VALUES (52,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (59,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (60,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (61,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (62,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (63,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (64,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (65,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (66,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (67,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (68,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (111,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (112,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (113,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (114,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (115,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (118,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (119,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (120,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (121,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (122,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (123,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (124,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (125,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (126,'FR-67',10,70,1);
INSERT INTO detalle_pedido VALUES (127,'FR-67',10,70,1);

INSERT INTO pago VALUES (1,'PayPal','ak-std-000001','2008-11-10',2000);
INSERT INTO pago VALUES (1,'PayPal','ak-std-000002','2008-12-10',2000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000003','2009-01-16',5000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000004','2009-02-16',5000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000005','2009-02-19',926);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000006','2007-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000007','2007-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000008','2007-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000009','2007-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000010','2007-01-08',1849);
INSERT INTO pago VALUES (5,'Transferencia','ak-std-000011','2006-01-18',23794);
INSERT INTO pago VALUES (7,'Cheque','ak-std-000012','2009-01-13',2390);
INSERT INTO pago VALUES (9,'PayPal','ak-std-000013','2009-01-06',929);
INSERT INTO pago VALUES (13,'PayPal','ak-std-000014','2008-08-04',2246);
INSERT INTO pago VALUES (14,'PayPal','ak-std-000015','2008-07-15',4160);
INSERT INTO pago VALUES (15,'PayPal','ak-std-000016','2009-01-15',2081);
INSERT INTO pago VALUES (15,'PayPal','ak-std-000035','2009-02-15',10000);
INSERT INTO pago VALUES (16,'PayPal','ak-std-000017','2009-02-16',4399);
INSERT INTO pago VALUES (19,'PayPal','ak-std-000018','2009-03-06',232);
INSERT INTO pago VALUES (23,'PayPal','ak-std-000019','2009-03-26',272);
INSERT INTO pago VALUES (26,'PayPal','ak-std-000020','2008-03-18',18846);
INSERT INTO pago VALUES (27,'PayPal','ak-std-000021','2009-02-08',10972);
INSERT INTO pago VALUES (28,'PayPal','ak-std-000022','2009-01-13',8489);
INSERT INTO pago VALUES (30,'PayPal','ak-std-000024','2009-01-16',7863);
INSERT INTO pago VALUES (35,'PayPal','ak-std-000025','2007-10-06',3321);
INSERT INTO pago VALUES (38,'PayPal','ak-std-000026','2006-05-26',1171);


/*1. Muestra la ciudad y el codigo postal de las oficinas de Espa�a.*/
select * from oficina where pais = 'Espa�a';
/*2. Obtener el nombre y apellidos del jefe de la empresa.*/
select nombre || ' ' || apellido1 || ' ' || apellido2 from empleado where puesto = 'Director General';
/*3. Mostrar el nombre y cargo de los empleados que no sean directores de oficina.*/
select nombre, puesto from empleado where puesto != 'Director Oficina';
/*4. Muestra el n�mero de empleados que hay en la empresa.*/
select count(codigo_empleado) from empleado;
/*5. Muestra el n�mero de clientes norteamericanos.*/
select count(codigo_cliente) from cliente where pais in ('USA','MEXICO','CANADA');
/*6. N�mero de clientes de cada pa�s.*/
select count(codigo_cliente) || ' ' ||pais from cliente group by pais;
/*7. Muestra el nombre del cliente y el nombre de su representante de ventas (si lo tiene).*/
select cliente.nombre_cliente || ', representante: ' || empleado.nombre from cliente join empleado on cliente.codigo_cliente = empleado.codigo_empleado;
/*8. Nombre de los clientes que hayan hecho un pago en 2007*/
select distinct cliente.nombre_cliente from pago join cliente on pago.codigo_cliente = cliente.codigo_cliente where pago.fecha_pago between (select to_date('1/1/2007','dd/mm/yyyy') from dual) and (select to_date('31/12/2007','dd/mm/yyyy') from dual);
/*9. Los posibles estados de un pedido.*/
select distinct(estado) from pedido;
/*10. Muestra el n�mero de pedido, el nombre del cliente, la fecha de entrega y la fecha requerida  de los pedidos que no han sido entregados a tiempo.*/
select pedido.codigo_pedido , cliente.nombre_cliente, pedido.fecha_entrega, pedido.fecha_esperada from pedido join cliente on pedido.codigo_cliente = cliente.codigo_cliente where pedido.fecha_entrega is not null and pedido.fecha_esperada <  pedido.fecha_entrega;
/*11. Muestra el c�digo, nombre y gama de los productos que nunca se han pedido (detalle pedidos).*/
select codigo_producto, nombre, gama from producto where codigo_producto not in (select distinct codigo_producto from detalle_pedido) ;
/*12. Muestra el nombre y apellidos de los empleados que trabajan en Barcelona.*/
select nombre, apellido1, apellido2 from empleado where codigo_oficina like 'BCN%';
/*13. Muestra el c�digo y la cantidad de veces que se ha pedido un producto al menos una vez.*/
select codigo_producto || ' : ' || count(codigo_producto) from detalle_pedido group by codigo_producto order by codigo_producto;
/*14. Muestra el nombre de los clientes de Miami que han realizado alg�n pedido.*/
select nombre_cliente from cliente where ciudad = 'Miami' and codigo_cliente in (select codigo_cliente from cliente);
/*15. Mostrar el precio final de cada pedido.*/
select detalle_pedido.codigo_pedido, sum(producto.precio_venta) || '�' from detalle_pedido join producto on detalle_pedido.codigo_producto = producto.codigo_producto group by detalle_pedido.codigo_pedido;
/*16. Mostrar lo que ha pagado cada cliente.*/
select * from cliente;
select * from pago;
select cliente.nombre_cliente, sum(pago.total)||' �' from cliente join pago on cliente.codigo_cliente = pago.codigo_cliente group by nombre_cliente;
/*17. Mostrar el numero de productos de cada gama*/
/*18. Mostrar el codigo de los pedidos donde se haya vendido el producto de la gama �Arom�ticas� mas caro.*/
/*19. Mostrar el codigo de los pedidos donde se hayan vendido mas de 6 productos.*/
/*20. Mostrar el codigo de los pedidos donde el precio del pedido sea superior a la media de todos los pedidos.*/
/*21. Mostrar los datos de un empleado (nombre, apellidos, ciudad de la oficina) y lo mismo para su jefe (en la misma fila).*/
/*22. Mostrar el codigo de pedido y su total en euros.*/
/*23. Mostrar la informaci�n del pedido (codigo, fechapedido, fechaesperada, fechaentrega, nombre cliente y total en euros) ordenado por total de forma descendente.*/
/*24. Devolverme la gama de productos mas vendida.*/
/*25. Devolverme la gama de productos mas vendida.*/
/*26. Muestra el pais(cliente) donde menos pedidos se hacen.*/