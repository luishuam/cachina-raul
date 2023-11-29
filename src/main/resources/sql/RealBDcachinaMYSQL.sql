-- Eliminar base de datos si existe
DROP DATABASE IF EXISTS cachina_7814;

-- Crear base de datos
CREATE DATABASE cachina_7814;

-- Usar la base de datos recién creada
USE cachina_7814;
-- Creación de la tabla PRODUCTO
DROP TABLE IF EXISTS cachina_7814.producto;
CREATE TABLE cachina_7814.producto (
    id INT auto_increment,
    nombre_prod VARCHAR(30) NOT NULL,
    descripcion_prod VARCHAR(120) NOT NULL,
    fecha_obtencion date NOT NULL,
    precio DECIMAL(10, 2) DEFAULT '0.00' NOT NULL,
	stock int NOT NULL,
    estado_prod BIT NOT NULL,
	CONSTRAINT productos_pk PRIMARY KEY (id),
	CONSTRAINT productos_check CHECK (stock>=0)
);

-- Creación de la tabla Proveedor
DROP TABLE IF EXISTS cachina_7814.proveedor;

CREATE TABLE cachina_7814.proveedor(
	id INT NOT NULL auto_increment,
    nombre_prove VARCHAR(50) NOT NULL,
    descripcion_prove VARCHAR(255) NOT NULL,
    dni_prove CHAR(8) UNIQUE NOT NULL,
	categoria VARCHAR(60) NOT NULL,
    estado_prove BIT NOT NULL,
	CONSTRAINT prove_pk PRIMARY KEY (id)
);

-- Creación de la tabla ""


-- Insercion de data a tabla producto
INSERT INTO `cachina_7814`.`producto`
(`nombre_prod`,
`descripcion_prod`,
`fecha_obtencion`,
`precio`,
`stock`,
`estado_prod`)
VALUES
('Celulares','Celulares rotos','2022-01-18',66.25,4,1),
('TV CRT','Televisores CRT del 1988','2022-11-18',100.25,55,1), 
('TV moderno','Televisores plasma','2023-05-10',145,22,1), 
('Computadoras','Ordenadores sovieticos','2021-07-07',5.50,5,1), 
('Autos','autos chatarra','2023-11-01',400,50,1), 
('Relojes','gran variedad de relojes antiguos, de cuerda, con carga manual.','2023-10-28',15,50,1),
('Camiones','camiones quemados','2023-03-09',500.50,50,1), 
('Joyas y chatarra','objetos de valor rotos','2023-11-11',60,60,1),
('Discos de musica','discos de vinilo, de época de todos los géneros musicales','2023-09-17',9.90,45,1), 
('Decoraciones','cosas esotericas y bellas','2023-08-02',88,88,1) 
;

-- Insercion de data a tabla proveedor

INSERT INTO `cachina_7814`.`proveedor`
(`nombre_prove`,
`descripcion_prove`,
`dni_prove`,
`categoria`,
`estado_prove`)
VALUES
('Carlos Hidalgo','trabaja para nosostros desde el inicio de la empresa','45218966','Recolector de chatarra',1),
('Juan de la Valle','se dedica a comprar basura electronica y es tacaño','77896215','Recolector de basura electronica',1),
('Hana Yomeguri','se dedica a recopilar albumes en vinilo y nos lo vende','25478964','Recolectora de Albumes musicales',1),
('Hina Misora','Nos trae mucho papel a reciclar','98742563','Recolectora de mangas',1),
('Maria Del Barrio','Nos trae ropa del siglo 20','78214536','Recolectora de ropa',1),
('Valentino Garavani','nos trae utensilios de cocina de cualquier epoca','78214530','Recolector de menaje',1),
('Maria Gonzales Tosi','nos trae ropa militar vieja para vender','78214532','Recolectora de ropa militar',1),
('Mario De la torre','Nos da juguetes viejos y que nadie quiere, tambien figuras','78214539','Recolector de juguetes',1),
('Melania Holzhauser','desde botellas hasta trozos de plastico nos vende','78214111','Recolectora de plasticos',1),
('Marco de Aguas','muchas peliculas viejas','78214537','Recolector de DVD',1)
;

select * from producto;
SELECT * FROM proveedor;
