-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-02-2025 a las 10:25:09
-- Versión del servidor: 11.6.2-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aquinovendemoscruzcampo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(3) NOT NULL,
  `denominacion` varchar(100) DEFAULT NULL,
  `formato` varchar(100) DEFAULT NULL,
  `tamano` varchar(100) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `marca` varchar(50) DEFAULT NULL,
  `fecha_consumo` date DEFAULT NULL,
  `alergias` varchar(40) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `observaciones` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `denominacion`, `formato`, `tamano`, `tipo`, `precio`, `marca`, `fecha_consumo`, `alergias`, `foto`, `observaciones`) VALUES
(1, 'lager', 'tercio', '750ml', 'botellin', 2.5, 'estrella galicia', '2030-11-12', 'ninguna', '[value-9]', 'ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(3) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `edad` int(3) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `perfil` varchar(50) NOT NULL,
  `carrito` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`carrito`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `correo`, `edad`, `contraseña`, `perfil`, `carrito`) VALUES
(1, 'juanspiner89@gmail.com', 19, '1234', 'admin', '{\"productosCarrito\": []}'),
(2, 'usuario1@gmail.com', 25, '1234', 'usuario', '{\"productosCarrito\": []}'),
(11, 'anitacorreo@gmail.com', 21, '1234', 'usuario', '{\"productosCarrito\": []}'),
(12, 'usuario2@gmail.com', 14, '1234', 'usuario', '{\"productosCarrito\": []}');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
