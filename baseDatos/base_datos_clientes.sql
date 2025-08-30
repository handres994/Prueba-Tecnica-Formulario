CREATE DATABASE registro_clientes;
USE registro_clientes;

CREATE TABLE Tipo_Identificacion (
    Id_Identificacion INT PRIMARY KEY,
    Tipo VARCHAR(50) NOT NULL
);

CREATE TABLE Pais (
    Id_Pais INT PRIMARY KEY,
    Pais VARCHAR(100) NOT NULL
);

CREATE TABLE Departamento (
    Id_Departamento INT PRIMARY KEY,
    Departamento VARCHAR(100) NOT NULL,
    Id_Pais INT NOT NULL,
    FOREIGN KEY (Id_Pais) REFERENCES Pais(Id_Pais)
);

CREATE TABLE Ciudad (
    Id_Ciudad INT PRIMARY KEY,
    Ciudad VARCHAR(100) NOT NULL,
    Id_Departamento INT NOT NULL,
    FOREIGN KEY (Id_Departamento) REFERENCES Departamento(Id_Departamento)
);

CREATE TABLE Cliente (
	Id_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Numero_Identificacion VARCHAR(30) NOT NULL,
    Tipo_Identificacion INT NOT NULL,
    Nombres VARCHAR(100) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    Direccion VARCHAR(200) NOT NULL,
    Ciudad INT NOT NULL,
    Departamento INT NOT NULL,
    Pais INT NOT NULL,
    FOREIGN KEY (Tipo_Identificacion) REFERENCES Tipo_Identificacion(Id_Identificacion),
    FOREIGN KEY (Ciudad) REFERENCES Ciudad(Id_Ciudad),
    FOREIGN KEY (Departamento) REFERENCES Departamento(Id_Departamento),
    FOREIGN KEY (Pais) REFERENCES Pais(Id_Pais),
    UNIQUE (Tipo_Identificacion, Numero_Identificacion)
);

CREATE TABLE Marca (
    Id_Marca INT PRIMARY KEY,
    Marca VARCHAR(100) NOT NULL
);

CREATE TABLE Clientes_PorMarca (
    Cliente INT NOT NULL,
    Marca INT NOT NULL,
    PRIMARY KEY (Cliente, Marca),
    FOREIGN KEY (Cliente) REFERENCES Cliente(Id_Cliente),
    FOREIGN KEY (Marca) REFERENCES Marca(Id_Marca)
);

INSERT INTO Tipo_Identificacion (Id_Identificacion, Tipo) VALUES
(1, 'Cédula de ciudadanía'),
(2, 'Cédula de extranjería'),
(3, 'Pasaporte');

INSERT INTO Pais (Id_Pais, Pais) VALUES
(1, 'Colombia'),
(2, 'Puerto Rico'),
(3, 'Panamá'),
(4, 'Costa Rica'),
(5, 'Guatemala'),
(6, 'Ecuador'),
(7, 'Perú'),
(8, 'Estados Unidos');

INSERT INTO Departamento (Id_Departamento, Departamento, Id_Pais) VALUES
-- Colombia (Id_Pais = 1)
(101, 'Antioquia', 1),
(102, 'Atlántico', 1),
(103, 'Bolívar', 1),
(104, 'Boyacá', 1),
(105, 'Caldas', 1),
(106, 'Caquetá', 1),
(107, 'Cesar', 1),
(108, 'Cundinamarca', 1),
(109, 'Huila', 1),
(110, 'Meta', 1),
(111, 'Norte de Santander', 1),
(112, 'Quindío', 1),
(113, 'Risaralda', 1),
(114, 'Santander', 1),
(115, 'Tolima', 1),
(116, 'Valle del Cauca', 1),
(117, 'Nariño', 1),
(118, 'Córdoba', 1),
-- Puerto Rico (Id_Pais = 2)
(201, 'Puerto Rico', 2),
-- Panamá (Id_Pais = 3)
(301, 'Panamá', 3),
-- Costa Rica (Id_Pais = 4)
(401, 'San José', 4),
-- Guatemala (Id_Pais = 5)
(501, 'Guatemala', 5),
-- Ecuador (Id_Pais = 6)
(601, 'Pichincha', 6),
-- Perú (Id_Pais = 7)
(701, 'Lima Metropolitana', 7),
-- Estados Unidos (Id_Pais = 8)
(801, 'Texas', 8);

INSERT INTO Ciudad (Id_Ciudad, Ciudad, Id_Departamento) VALUES
-- Colombia
(1001, 'Medellín', 101),
(1002, 'Rionegro', 101),
(1003, 'Barranquilla', 102),
(1004, 'Cartagena', 103),
(1005, 'Tunja', 104),
(1006, 'Manizales', 105),
(1007, 'Florencia', 106),
(1008, 'Valledupar', 107),
(1009, 'Bogotá', 108),
(1010, 'Neiva', 109),
(1011, 'Villavicencio', 110),
(1012, 'Acacías', 110),
(1013, 'Cúcuta', 111),
(1014, 'Armenia', 112),
(1015, 'Pereira', 113),
(1016, 'Bucaramanga', 114),
(1017, 'Barrancabermeja', 114),
(1018, 'Ibagué', 115),
(1019, 'Cali', 116),
(1020, 'Palmira', 116),
(1021, 'Pasto', 117),
(1022, 'Montería', 118),
-- Puerto Rico
(2001, 'San Juan', 201),
(2002, 'Carolina', 201),
(2003, 'Ponce', 201),
(2004, 'Caguas', 201),
(2005, 'Bayamón', 201),
(2006, 'Barceloneta', 201),
-- Panamá
(3001, 'Ciudad de Panamá', 301),
-- Costa Rica
(4001, 'San José', 401),
-- Guatemala
(5001, 'Ciudad de Guatemala', 501),
-- Ecuador
(6001, 'Quito', 601),
-- Perú
(7001, 'Lima', 701),
-- Estados Unidos
(8001, 'Houston', 801);

INSERT INTO Marca (Id_Marca, Marca) VALUES
(1, 'Americanino'),
(2, 'American Eagle'),
(3, 'Chevignon'),
(4, 'Esprit'),
(5, 'Naf Naf'),
(6, 'Rifle');





