-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2022 a las 20:31:17
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdfederacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metales`
--

DROP TABLE IF EXISTS `metales`;
CREATE TABLE IF NOT EXISTS `metales` (
  `idMetal` int(11) NOT NULL AUTO_INCREMENT,
  `idTipoMetal` int(11) NOT NULL,
  `pureza` int(11) NOT NULL,
  `es_oro` tinyint(1) NOT NULL,
  `es_plata` tinyint(1) NOT NULL,
  `es_bronce` tinyint(1) NOT NULL,
  PRIMARY KEY (`idMetal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

--
-- Estructura de tabla para la tabla `participantes`
--

DROP TABLE IF EXISTS `participantes`;
CREATE TABLE IF NOT EXISTS `participantes` (
  `id` int(11) NOT NULL,
  `dorsal` int(11) NOT NULL,
  `calle` char(1) NOT NULL,
  `tiempo` date NOT NULL,
  `penalizacion` tinyint(1) NOT NULL DEFAULT 0,
  `otros` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE IF NOT EXISTS `resultados` (
  `id` int(11) NOT NULL,
  `oro` int(11) NOT NULL,
  `plata` int(11) NOT NULL,
  `bronce` int(11) NOT NULL,
  `definitivo` tinyint(1) NOT NULL,
  `fechahora` int(11) NOT NULL,
  `participanteOro` int(11) DEFAULT NULL,
  `participantePlata` int(11) DEFAULT NULL,
  `participanteBronce` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;