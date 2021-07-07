-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-07-2021 a las 02:36:22
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `municipalidad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `num_legajo` int(11) NOT NULL,
  `nombre_apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimineto` date DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `sueldo_basico` double DEFAULT NULL,
  `codigo_proyecto` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_legajo`),
  KEY `codigo_proyecto` (`codigo_proyecto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`num_legajo`, `nombre_apellido`, `fecha_nacimineto`, `dni`, `sueldo_basico`, `codigo_proyecto`) VALUES
(2, 'Noeli Mamaní', '2000-09-10', 42377039, 2500, 2),
(1, 'Juan Alvarez', '1997-08-07', 39985424, 900, 2),
(3, 'Alvaro Martinez', '1997-11-12', 39989747, 1500, 1),
(4, 'Melani Mendez', '1995-04-07', 38478025, 3000, 1),
(5, 'Jose Cala', '1998-03-28', 40287456, 1200, 2),
(6, 'Pamela Torrez', '1994-06-26', 37854039, 3200, 3),
(7, 'Pedro Cardozo', '1996-03-04', 39526450, 2700, 3),
(8, 'Marcos Monteros', '1995-05-16', 38456271, 1700, 3),
(9, 'Micaela Midana', '1997-09-24', 40985725, 2456, 3),
(10, 'Ana Mendez', '1997-08-01', 40388754, 3502, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
CREATE TABLE IF NOT EXISTS `proyecto` (
  `codigo_proyecto` int(11) NOT NULL,
  `nombre_proyecto` varchar(50) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_finalizacion` date DEFAULT NULL,
  `monto_prosupuestado` double DEFAULT NULL,
  PRIMARY KEY (`codigo_proyecto`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`codigo_proyecto`, `nombre_proyecto`, `fecha_inicio`, `fecha_finalizacion`, `monto_prosupuestado`) VALUES
(1, 'Municipio', '2021-08-08', '2022-08-08', 12000),
(2, 'Terminal', '2021-06-04', '2022-06-04', 15000),
(3, 'Unju', '2021-01-01', '2021-03-01', 20000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
