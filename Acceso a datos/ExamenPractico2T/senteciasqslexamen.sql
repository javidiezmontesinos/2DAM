CREATE DATABASE IF NOT EXISTS hospitalApp;

USE hospitalApp;

CREATE TABLE pacientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    ciudad VARCHAR(255),
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    edad INT,
    historial TEXT
);

CREATE TABLE medicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    especialidad VARCHAR(255)
);

CREATE TABLE citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_paciente INT,
    id_medico INT,
    fecha DATE,
    hora TIME,
    FOREIGN KEY (id_paciente) REFERENCES pacientes(id),
    FOREIGN KEY (id_medico) REFERENCES medicos(id)
);

-- Insertar datos en la tabla pacientes
INSERT INTO pacientes (nombre, apellidos, ciudad, direccion, telefono, edad, historial)
VALUES ('Ana', 'López', 'Ciudad B', 'Calle 456', '987654321', 28, 'Historial de Ana López'),
       ('Pedro', 'Gómez', 'Ciudad C', 'Avenida 789', '654987321', 45, 'Historial de Pedro Gómez'),
       ('María', 'Sánchez', 'Ciudad A', 'Plaza 789', '321654987', 32, 'Historial de María Sánchez');

-- Insertar datos en la tabla medicos
INSERT INTO medicos (nombre, apellidos, especialidad)
VALUES ('Javier', 'Pérez', 'Cirugía General'),
       ('Laura', 'Rodríguez', 'Ginecología'),
       ('Carlos', 'Fernández', 'Cardiología');

-- Insertar datos en la tabla citas
INSERT INTO citas (id_paciente, id_medico, fecha, hora)
VALUES (2, 1, '2024-02-09', '11:00:00'),
       (3, 2, '2024-02-10', '14:30:00'),
       (1, 3, '2024-02-11', '09:45:00');

