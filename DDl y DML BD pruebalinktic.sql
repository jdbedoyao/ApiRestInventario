-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-07-2025 a las 10:19:21
-- Versión del servidor: 8.0.40
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebalinktic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE `inventario` (
  `id` bigint NOT NULL COMMENT 'id unico del inventario',
  `producto_id` bigint NOT NULL DEFAULT '0' COMMENT 'id del producto originario de la tbl producto',
  `cantidad` bigint NOT NULL DEFAULT '0' COMMENT 'Cantidad en stock del Producto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`id`, `producto_id`, `cantidad`) VALUES
(1, 1, 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint NOT NULL COMMENT 'id unico del producto',
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `precio` bigint NOT NULL DEFAULT '0' COMMENT 'Precio del Producto',
  `descripcion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `precio`, `descripcion`) VALUES
(1, 'Huevos caja 30 unidades', 16000, 'Caja de huevos AAA'),
(2, 'Salsa de Tomata Fruco 300 gr', 10000, 'Salsa de tomate fruco 300 gr en envase de aluminio'),
(3, 'Aceite de Coco orgánico Taeq 450 ml', 23000, 'Aceite de coco orgánico Taeq con volumen de 450 ml envase de vidrio'),
(4, 'Colcafé cafe granulado 50 gr', 12000, 'Cafe granulado instantaneo Colcafé 50 gr en envase de vidrio');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `inventario`
--
ALTER TABLE `inventario`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id unico del inventario', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id unico del producto', AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
