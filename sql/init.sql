-- Inicializar la base de datos
CREATE DATABASE IF NOT EXISTS librorepositorymysql
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;

USE librorepositorymysql;

CREATE TABLE IF NOT EXISTS libro (
  id VARCHAR(50) PRIMARY KEY,
  titulo VARCHAR(200) NOT NULL,
  autor VARCHAR(150) NOT NULL,
  precio DOUBLE NOT NULL,
  stock INT NOT NULL
);

DELETE FROM libro;

INSERT INTO libro (id, titulo, autor, precio, stock)
VALUES
('1', 'Don Quijote de la Mancha', 'Miguel de Cervantes', 19.99, 10),
('2', 'Cien años de soledad', 'Gabriel García Márquez', 15.50, 7),
('3', 'El principito', 'Antoine de Saint-Exupéry', 12.00, 15);