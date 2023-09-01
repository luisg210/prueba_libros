CREATE TABLE autor(
id SERIAL PRIMARY KEY NOT NULL,
nombre VARCHAR(50) NOT NULL,
fecha_nacimiento VARCHAR(10) NOT NULL,
pais VARCHAR(50)
);
INSERT INTO autor(nombre, fecha_nacimiento, pais) VALUES 
('Gabriel Garcia Marquez', '1927', 'Colombia'),
('Jorge Luis Borges', '1899', 'Argentina'),
('Mario Vargas Losa', '1936', 'Peru'),
('Pablo Neruda', '1904', 'Chile'),
('Octavio Paz', '1914', 'Mexico');
SELECT * FROM autor;

CREATE TABLE categoria(
id SERIAL PRIMARY KEY NOT NULL,
nombre VARCHAR(50) NOT NULL,
archivo VARCHAR(50)
);
INSERT INTO categoria(nombre) VALUES 
('Novela'),
('Poesia'),
('Teatro'),
('Ensayo'),
('Bibliografia'),
('Autobiografia'),
('Cuento'),
('Fabula'),
('Leyenda'),
('Cronica');
SELECT * FROM categoria;

CREATE TABLE libro(
id SERIAL PRIMARY KEY NOT NULL,
nombre VARCHAR(50) NOT NULL,
id_autor INT REFERENCES autor(id), 
id_categoria INT REFERENCES categoria(id),
precio DECIMAL(10, 2) NOT NULL,
estado CHAR NOT NULL --d = disponible, n = no disponible
);
SELECT * FROM libro;
