-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-04-2026 a las 13:39:38
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `temporada_futbol`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `TxertatuLendakaria` (`p_lizena` VARCHAR(50), `p_taldea` INT)   BEGIN
DECLARE v_dago INT DEFAULT 0;

SELECT COUNT(*)
INTO v_dago
FROM tbpresidentea p
WHERE p.IzenaP = p_lizena;

IF v_dago = 0 THEN
INSERT INTO tbpresidentea (IzenaP, taldeID)
VALUES (p_lizena, p_taldea);

SELECT CONCAT('Emaitza: ', p_lizena, ' lendakaria ondo txertatu da.') AS Mezua;
ELSE
SELECT CONCAT('Emaitza: ', p_lizena, ' jada existitzen da.') AS Mezua;
END IF;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbarbitroa`
--

CREATE TABLE `tbarbitroa` (
  `arbitroaId` int(11) NOT NULL,
  `izenaA` varchar(50) DEFAULT NULL,
  `passwordA` varchar(12) DEFAULT NULL,
  `Adina` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbarbitroa`
--

INSERT INTO `tbarbitroa` (`arbitroaId`, `izenaA`, `passwordA`, `Adina`) VALUES
(1, 'MATEU LAHOZ, ANTONIO', NULL, 25),
(2, 'COLLINA, PIERLUIGI', NULL, 48),
(3, 'ITURRALDE, EDUARDO', NULL, 22),
(4, 'DEL CERRO GRANDE, CARLOS', NULL, 30),
(5, ' BRYCH FELIX', NULL, 50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbdenboraldia`
--

CREATE TABLE `tbdenboraldia` (
  `denboraldiaID` int(11) NOT NULL,
  `Izena` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbdenboraldia`
--

INSERT INTO `tbdenboraldia` (`denboraldiaID`, `Izena`) VALUES
(1, '2025/2026'),
(2, '2024/2025'),
(3, '2026/2027');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbgola`
--

CREATE TABLE `tbgola` (
  `golakID` int(11) NOT NULL,
  `partiduaId` int(11) DEFAULT NULL,
  `denboraldiaID` int(11) DEFAULT NULL,
  `jardunaldiaID` int(11) DEFAULT NULL,
  `jokalariId` int(11) DEFAULT NULL,
  `minutua` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbgola`
--

INSERT INTO `tbgola` (`golakID`, `partiduaId`, `denboraldiaID`, `jardunaldiaID`, `jokalariId`, `minutua`) VALUES
(1, 1, 1, 3, 107, 10),
(2, 1, 1, 3, 117, 90),
(3, 1, 1, 3, 144, 85),
(4, 2, 1, 3, 8, 25),
(5, 2, 1, 3, 10, 45),
(6, 2, 1, 3, 11, 85),
(7, 2, 1, 3, 8, 90),
(9, 3, 1, 3, 26, 10),
(10, 3, 1, 3, 65, 50),
(11, 4, 1, 4, 134, 10),
(12, 4, 1, 4, 37, 45),
(13, 4, 1, 4, 26, 80),
(14, 5, 1, 4, 8, 14),
(15, 5, 1, 4, 8, 30),
(16, 5, 1, 4, 10, 45),
(18, 7, 1, 5, 115, 10),
(19, 7, 1, 5, 120, 50),
(20, 7, 1, 5, 110, 85),
(21, 7, 1, 5, 127, 15),
(22, 7, 1, 5, 140, 70),
(23, 8, 1, 5, 51, 45),
(24, 9, 1, 5, 15, 10),
(27, 9, 1, 5, 26, 25),
(28, 9, 1, 5, 26, 90),
(29, 10, 1, 6, 150, 65),
(30, 10, 1, 6, 140, 85),
(31, 11, 1, 6, 30, 50),
(32, 11, 1, 6, 49, 75),
(33, 11, 1, 6, 103, 65),
(34, 12, 1, 6, 75, 35),
(35, 12, 1, 6, 73, 45),
(36, 12, 1, 6, 60, 70),
(37, 12, 1, 6, 77, 25),
(38, 13, 1, 7, 150, 10),
(39, 13, 1, 7, 144, 80),
(40, 14, 1, 7, 80, 20),
(41, 14, 1, 7, 26, 30),
(42, 14, 1, 7, 30, 40),
(43, 15, 1, 7, 101, 20),
(44, 15, 1, 7, 10, 40),
(45, 17, 1, 8, 83, 60),
(46, 17, 1, 8, 99, 75),
(47, 18, 1, 8, 65, 15),
(50, 21, 1, 9, 78, 55),
(51, 23, 1, 10, 144, 45),
(52, 23, 1, 10, 104, 25),
(53, 24, 1, 10, 26, 10),
(54, 24, 1, 10, 35, 25),
(57, 26, 1, 11, 101, 25),
(58, 27, 1, 11, 75, 55),
(59, 28, 1, 12, 89, 30),
(60, 28, 1, 12, 89, 45),
(61, 28, 1, 12, 55, 15),
(62, 29, 1, 12, 26, 15),
(63, 29, 1, 12, 26, 45),
(65, 30, 1, 12, 10, 95),
(67, 35, 2, 14, 61, 13),
(68, 38, 2, 15, 111, 15),
(69, 43, 2, 17, 61, 13),
(70, 46, 2, 18, 131, 16),
(71, 51, 2, 19, 111, 15),
(72, 52, 2, 20, 131, 16),
(73, 57, 2, 21, 81, 14),
(74, 31, 2, 13, 113, 15),
(76, 33, 2, 13, 28, 12),
(77, 34, 2, 14, 132, 16),
(78, 36, 2, 14, 82, 14),
(79, 37, 2, 15, 84, 14),
(81, 40, 2, 16, 133, 16),
(82, 41, 2, 16, 29, 12),
(83, 42, 2, 16, 64, 13),
(84, 44, 2, 17, 82, 14),
(85, 45, 2, 17, 112, 15),
(86, 47, 2, 18, 83, 14),
(87, 48, 2, 18, 62, 13),
(88, 49, 2, 19, 28, 12),
(90, 53, 2, 20, 62, 13),
(91, 54, 2, 20, 29, 12),
(93, 56, 2, 21, 112, 15),
(94, 58, 2, 22, 133, 16),
(95, 59, 2, 22, 29, 12),
(105, 31, 2, 13, 113, 15),
(107, 33, 2, 13, 28, 12),
(108, 34, 2, 14, 132, 16),
(109, 36, 2, 14, 82, 14),
(110, 37, 2, 15, 84, 14),
(112, 40, 2, 16, 133, 16),
(113, 41, 2, 16, 29, 12),
(114, 42, 2, 16, 64, 13),
(115, 44, 2, 17, 82, 14),
(116, 45, 2, 17, 112, 15),
(117, 47, 2, 18, 83, 14),
(118, 48, 2, 18, 62, 13),
(119, 49, 2, 19, 28, 12),
(121, 53, 2, 20, 62, 13),
(122, 54, 2, 20, 29, 12),
(124, 56, 2, 21, 112, 15),
(125, 58, 2, 22, 133, 16),
(126, 59, 2, 22, 29, 12),
(136, 31, 2, 13, 113, 50),
(138, 37, 2, 15, 84, 40),
(140, 40, 2, 16, 133, 60),
(141, 41, 2, 16, 29, 20),
(142, 42, 2, 16, 64, 30),
(143, 47, 2, 18, 83, 40),
(144, 54, 2, 20, 29, 20),
(145, 58, 2, 22, 133, 60),
(146, 59, 2, 22, 29, 20),
(152, 37, 2, 15, 84, 40),
(154, 42, 2, 16, 64, 30),
(159, 34, 2, 14, 27, 14),
(161, 37, 2, 15, 131, 42),
(162, 39, 2, 15, 27, 14),
(163, 43, 2, 17, 131, 42),
(164, 44, 2, 17, 27, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbjardunaldia`
--

CREATE TABLE `tbjardunaldia` (
  `jardunaldiaID` int(11) NOT NULL,
  `denboraldiaID` int(11) DEFAULT NULL,
  `dataJ` date DEFAULT NULL,
  `zbkJ` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbjardunaldia`
--

INSERT INTO `tbjardunaldia` (`jardunaldiaID`, `denboraldiaID`, `dataJ`, `zbkJ`) VALUES
(3, 1, '2025-12-06', '1'),
(4, 1, '2025-12-13', '2'),
(5, 1, '2025-12-20', '3'),
(6, 1, '2025-12-27', '4'),
(7, 1, '2026-01-03', '5'),
(8, 1, '2026-01-10', '6'),
(9, 1, '2026-01-17', '7'),
(10, 1, '2026-01-24', '8'),
(11, 1, '2026-01-31', '9'),
(12, 1, '2026-02-07', '10'),
(13, 2, '2024-12-07', '1'),
(14, 2, '2024-12-14', '2'),
(15, 2, '2024-12-21', '3'),
(16, 2, '2024-12-28', '4'),
(17, 2, '2025-01-04', '5'),
(18, 2, '2025-01-11', '6'),
(19, 2, '2025-01-18', '7'),
(20, 2, '2025-01-25', '8'),
(21, 2, '2025-02-01', '9'),
(22, 2, '2025-02-08', '10'),
(28, 3, '2026-12-05', '1'),
(29, 3, '2026-12-12', '2'),
(30, 3, '2026-12-19', '3'),
(31, 3, '2026-12-26', '4'),
(32, 3, '2027-01-02', '5'),
(33, 3, '2027-01-09', '6'),
(34, 3, '2027-01-16', '7'),
(35, 3, '2027-01-23', '8'),
(36, 3, '2027-01-30', '9'),
(37, 3, '2027-02-06', '10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbjokalaria`
--

CREATE TABLE `tbjokalaria` (
  `jokalariId` int(11) NOT NULL,
  `izena` varchar(50) DEFAULT NULL,
  `taldeID` int(11) DEFAULT NULL,
  `zbkJo` varchar(5) DEFAULT NULL,
  `adina` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbjokalaria`
--

INSERT INTO `tbjokalaria` (`jokalariId`, `izena`, `taldeID`, `zbkJo`, `adina`) VALUES
(1, 'Perez Aitzol', 1, '8', 20),
(2, 'Arrugaeta Mikel', 1, '05', 35),
(3, 'Gonzalez Mikel', 1, '10', 19),
(4, 'Ruiz Unai', 1, '01', 28),
(5, 'Martinez Ander', 1, '02', 31),
(6, 'Lopez Iker', 1, '03', 24),
(7, 'Fernandez Asier', 1, '04', 24),
(8, 'Etxeberria Jon', 1, '06', 18),
(9, 'Garmendia Aitor', 1, '07', 27),
(10, 'Salazar Eneko', 1, '09', 33),
(11, 'Urrutia Markel', 1, '11', 21),
(12, 'Aguirre Julen', 1, '12', 29),
(13, 'Arrieta Beñat', 1, '13', 36),
(14, 'Madariaga Xab', 1, '14', 25),
(15, 'Otxoa Iñaki', 1, '15', 34),
(16, 'Zubizarreta Peio', 1, '16', 20),
(17, 'Mendez Gaizka', 1, '17', 38),
(18, 'Rivas Alex', 1, '18', 26),
(19, 'Sola Mikel', 1, '19', 30),
(20, 'Nuñez Adrian', 1, '20', 23),
(21, 'Ortiz Pablo', 1, '21', 32),
(22, 'Roman Sergio', 1, '22', 39),
(23, 'Cano David', 1, '23', 18),
(24, 'Prieto Oscar', 1, '24', 27),
(25, 'Velasco Dani', 5, '25', 35),
(26, 'Esteban Iñigo', 2, '07', 24),
(27, 'Benito Aritz', 2, '14', 31),
(28, 'Bilbao Aimar', 2, '20', 22),
(29, 'Torres Unai', 2, '01', 28),
(30, 'Alonso Iker', 2, '02', 40),
(31, 'Vega Jon', 2, '03', 19),
(32, 'Crespo Ander', 2, '04', 34),
(33, 'Gil Asier', 2, '05', 26),
(34, 'Molina Aitor', 2, '06', 29),
(35, 'Rubio Eneko', 2, '08', 37),
(36, 'Suarez Beñat', 2, '09', 21),
(37, 'Leon Markel', 2, '10', 33),
(38, 'Iglesias Julen', 2, '11', 25),
(39, 'Pardo Xabi', 2, '12', 30),
(40, 'Ramos Iñaki', 2, '13', 18),
(41, 'Herrero Peio', 2, '15', 36),
(42, 'Bravo Gaizka', 2, '16', 24),
(43, 'Calvo Alex', 2, '17', 27),
(44, 'Soto Mikel', 2, '18', 32),
(45, 'Fuentes Adrian', 2, '19', 39),
(46, 'Ortiz Peio', 2, '21', 22),
(47, 'Fuentes Aitzol', 2, '22', 28),
(48, 'Rey Alex', 2, '23', 35),
(49, 'Navarro Iker', 2, '24', 20),
(50, 'Lozano Dani', 2, '25', 31),
(51, 'Garcia Oier', 3, '04', 26),
(52, 'Ibáñez Pablo', 3, '18', 34),
(53, 'Perez Jon', 3, '25', 23),
(54, 'Varela Unai', 3, '01', 29),
(55, 'Merino Iker', 3, '02', 38),
(56, 'Sierra Jon', 3, '03', 21),
(57, 'Blanco Ander', 3, '05', 30),
(58, 'Marcos Asier', 3, '06', 25),
(59, 'Roldan Aitor', 3, '07', 33),
(60, 'Campos Eneko', 3, '08', 18),
(61, 'Vidal Beñat', 3, '09', 40),
(62, 'Pastor Markel', 3, '10', 27),
(63, 'Luque Julen', 3, '11', 36),
(64, 'Galan Xabi', 3, '12', 24),
(65, 'Cano Iñaki', 3, '13', 31),
(66, 'Mora Peio', 3, '14', 22),
(67, 'Ordoñez Gaizka', 3, '15', 28),
(68, 'Plaza Alex', 3, '16', 34),
(69, 'Valero Mikel', 3, '17', 19),
(70, 'Hidalgo Adrian', 3, '19', 32),
(71, 'Santos Pablo', 3, '20', 26),
(72, 'Cabrera Sergio', 3, '21', 35),
(73, 'Duran David', 3, '22', 23),
(74, 'Soler Oscar', 3, '23', 29),
(75, 'Miranda Dani', 3, '24', 37),
(76, 'Echevarria Unai', 4, '01', 21),
(77, 'Arana Iker', 4, '02', 30),
(78, 'Bilbao Jon', 4, '03', 25),
(79, 'Lasa Ander', 4, '04', 33),
(80, 'Zuloaga Asier', 4, '05', 18),
(81, 'Arostegui Aitor', 4, '06', 39),
(82, 'Altuna Eneko', 4, '07', 27),
(83, 'Iriondo Beñat', 4, '08', 34),
(84, 'Larrea Markel', 4, '09', 24),
(85, 'Eguren Julen', 4, '10', 31),
(86, 'Zabala Xabi', 4, '11', 22),
(87, 'Arregi Iñaki', 4, '12', 28),
(88, 'Murua Peio', 4, '13', 36),
(89, 'Mendizabal Gaizka', 4, '14', 20),
(90, 'Iturralde Alex', 4, '15', 32),
(91, 'Olaizola Mikel', 4, '16', 26),
(92, 'Gurrutxaga Adrian', 4, '17', 35),
(93, 'Aramburu Pablo', 4, '18', 23),
(94, 'Lertxundi Sergio', 4, '19', 29),
(95, 'Ugalde David', 4, '20', 38),
(96, 'Etxarri Oscar', 4, '21', 21),
(97, 'Izagirre Dani', 4, '22', 30),
(98, 'Zubia Ander', 4, '23', 25),
(99, 'Aldazabal Unai', 4, '24', 33),
(101, 'Ruiz Unai', 5, '01', 40),
(102, 'Martinez Iker', 5, '02', 27),
(103, 'Lopez Jon', 5, '03', 34),
(104, 'Fernandez Ander', 5, '04', 24),
(105, 'Perez Asier', 5, '05', 31),
(106, 'Gomez Aitor', 5, '06', 22),
(107, 'Sanchez Eneko', 5, '07', 28),
(108, 'Diaz Beñat', 5, '08', 36),
(109, 'Moreno Markel', 5, '09', 19),
(110, 'Muñoz Julen', 5, '10', 32),
(111, 'Alvarez Xabi', 5, '11', 26),
(112, 'Romero Iñaki', 5, '12', 35),
(113, 'Navarro Peio', 5, '13', 23),
(114, 'Torres Gaizka', 5, '14', 29),
(115, 'Dominguez Alex', 5, '15', 37),
(116, 'Vazquez Mikel', 5, '16', 21),
(117, 'Ramos Adrian', 5, '17', 30),
(118, 'Gil Pablo', 5, '18', 25),
(119, 'Serrano Sergio', 5, '19', 33),
(120, 'Blanco David', 5, '20', 18),
(121, 'Castro Oscar', 5, '21', 39),
(122, 'Molina Dani', 5, '22', 27),
(123, 'Ortega Ander', 5, '23', 34),
(124, 'Cruz Unai', 5, '24', 24),
(125, 'Iglesias Iker', 5, '25', 31),
(126, 'Aguirre Unai', 6, '01', 22),
(127, 'Salazar Iker', 6, '02', 28),
(128, 'Urrutia Jon', 6, '03', 36),
(129, 'Arrieta Ander', 6, '04', 20),
(130, 'Madariaga Asier', 6, '05', 32),
(131, 'Otxoa Aitor', 6, '06', 26),
(132, 'Zubizarreta Eneko', 6, '07', 35),
(133, 'Mendez Beñat', 6, '08', 23),
(134, 'Rivas Markel', 6, '09', 29),
(135, 'Sola Julen', 6, '10', 38),
(136, 'Nuñez Xabi', 6, '11', 21),
(137, 'Ortiz Iñaki', 6, '12', 30),
(138, 'Roman Peio', 6, '13', 25),
(139, 'Cano Gaizka', 6, '14', 33),
(140, 'Prieto Alex', 6, '15', 18),
(141, 'Velasco Mikel', 6, '16', 30),
(142, 'Fuentes Adrian', 6, '17', 27),
(143, 'Nieto Pablo', 6, '18', 34),
(144, 'Rey Sergio', 6, '19', 24),
(145, 'Lozano David', 6, '20', 31),
(146, 'Bravo Oscar', 6, '21', 22),
(147, 'Calvo Dani', 6, '22', 28),
(148, 'Soto Ander', 6, '23', 36),
(149, 'Leon Unai', 6, '24', 20),
(150, 'Pardo Iker', 5, '25', 32),
(151, 'Simon Unai', 7, '1', 28),
(152, 'Lekue Iker', 7, '2', 32),
(153, 'Vivian Dani', 7, '3', 26),
(154, 'Alvarez Yeray', 7, '4', 30),
(155, 'Martinez Inigo', 7, '5', 33),
(156, 'Vesga Mikel', 7, '6', 32),
(157, 'Berenguer Alex', 7, '7', 29),
(158, 'Sancet Oihan', 7, '8', 25),
(159, 'Williams Inaki', 7, '9', 30),
(160, 'Muniain Iker', 7, '10', 32),
(162, 'Guruzeta Gorka', 7, '12', 28),
(165, 'Nunez Unai', 7, '15', 28),
(167, 'Berchiche Yuri', 7, '17', 34),
(168, 'Marcos Oscar', 7, '18', 36),
(169, 'Morcillo Jon', 7, '19', 26),
(170, 'Villalibre Asier', 7, '20', 27),
(171, 'Herrera Ander', 7, '21', 35),
(172, 'Gorosabel Andoni', 7, '22', 28),
(173, 'Nolaskoain Peru', 7, '23', 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbpartidua`
--

CREATE TABLE `tbpartidua` (
  `partiduaId` int(11) NOT NULL,
  `denboraldiaID` int(11) DEFAULT NULL,
  `jardunaldiaID` int(11) DEFAULT NULL,
  `taldeLokalID` int(11) DEFAULT NULL,
  `taldeKanpokoID` int(11) DEFAULT NULL,
  `golLokal` int(11) DEFAULT NULL,
  `golKanpoko` int(11) DEFAULT NULL,
  `arbitroaId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbpartidua`
--

INSERT INTO `tbpartidua` (`partiduaId`, `denboraldiaID`, `jardunaldiaID`, `taldeLokalID`, `taldeKanpokoID`, `golLokal`, `golKanpoko`, `arbitroaId`) VALUES
(1, 1, 3, 5, 6, 2, 1, 1),
(2, 1, 3, 1, 4, 4, 1, 2),
(3, 1, 3, 2, 3, 1, 1, 3),
(4, 1, 4, 6, 2, 1, 2, 4),
(5, 1, 4, 3, 1, 0, 3, 1),
(6, 1, 4, 4, 5, 1, 0, 2),
(7, 1, 5, 4, 6, 3, 2, 3),
(8, 1, 5, 5, 3, 0, 1, 4),
(9, 1, 5, 1, 2, 3, 2, 1),
(10, 1, 6, 6, 1, 2, 0, 2),
(11, 1, 6, 2, 5, 2, 1, 3),
(12, 1, 6, 3, 4, 3, 1, 4),
(13, 1, 7, 3, 6, 0, 2, 1),
(14, 1, 7, 4, 2, 1, 2, 2),
(15, 1, 7, 5, 1, 1, 1, 3),
(16, 1, 8, 6, 5, 0, 0, 4),
(17, 1, 8, 4, 1, 2, 0, 1),
(18, 1, 8, 3, 2, 1, 0, 2),
(19, 1, 9, 2, 6, 1, 0, 3),
(20, 1, 9, 1, 3, 1, 0, 4),
(21, 1, 9, 5, 4, 0, 1, 1),
(22, 1, 10, 6, 4, 0, 0, 2),
(23, 1, 10, 3, 5, 1, 1, 3),
(24, 1, 10, 2, 1, 2, 1, 4),
(25, 1, 11, 1, 6, 1, 0, 1),
(26, 1, 11, 5, 2, 1, 0, 2),
(27, 1, 11, 4, 3, 0, 1, 3),
(28, 1, 12, 6, 3, 2, 1, 4),
(29, 1, 12, 2, 4, 2, 0, 1),
(30, 1, 12, 1, 5, 2, 0, 2),
(31, 2, 13, 5, 6, 3, 0, 1),
(32, 2, 13, 1, 4, 5, 0, 2),
(33, 2, 13, 2, 3, 2, 0, 3),
(34, 2, 14, 6, 2, 2, 1, 5),
(35, 2, 14, 3, 1, 1, 2, 1),
(36, 2, 14, 4, 5, 2, 0, 2),
(37, 2, 15, 4, 6, 4, 1, 3),
(38, 2, 15, 5, 3, 1, 0, 5),
(39, 2, 15, 1, 2, 4, 1, 1),
(40, 2, 16, 6, 1, 3, 0, 2),
(41, 2, 16, 2, 5, 3, 0, 3),
(42, 2, 16, 3, 4, 4, 0, 5),
(43, 2, 17, 3, 6, 1, 1, 1),
(44, 2, 17, 4, 2, 2, 1, 2),
(45, 2, 17, 5, 1, 2, 0, 3),
(46, 2, 18, 6, 5, 1, 0, 5),
(47, 2, 18, 4, 1, 3, 0, 1),
(48, 2, 18, 3, 2, 2, 0, 2),
(49, 2, 19, 2, 6, 2, 0, 3),
(50, 2, 19, 1, 3, 2, 0, 5),
(51, 2, 19, 5, 4, 1, 0, 1),
(52, 2, 20, 6, 4, 1, 0, 2),
(53, 2, 20, 3, 5, 2, 0, 3),
(54, 2, 20, 2, 1, 3, 0, 5),
(55, 2, 21, 1, 6, 2, 0, 1),
(56, 2, 21, 5, 2, 2, 0, 2),
(57, 2, 21, 4, 3, 1, 0, 3),
(58, 2, 22, 6, 3, 3, 0, 5),
(59, 2, 22, 2, 4, 3, 0, 1),
(60, 2, 22, 1, 5, 3, 0, 2),
(62, 3, 28, 6, 5, 0, 0, NULL),
(63, 3, 28, 4, 1, 0, 0, NULL),
(64, 3, 28, 3, 2, 0, 0, NULL),
(65, 3, 29, 2, 6, 0, 0, NULL),
(66, 3, 29, 1, 3, 0, 0, NULL),
(67, 3, 29, 5, 4, 0, 0, NULL),
(68, 3, 30, 6, 4, 0, 0, NULL),
(69, 3, 30, 3, 5, 0, 0, NULL),
(70, 3, 30, 2, 1, 0, 0, NULL),
(71, 3, 31, 1, 6, 0, 0, NULL),
(72, 3, 31, 5, 2, 0, 0, NULL),
(73, 3, 31, 4, 3, 0, 0, NULL),
(74, 3, 32, 6, 3, 0, 0, NULL),
(75, 3, 32, 2, 4, 0, 0, NULL),
(76, 3, 32, 1, 5, 0, 0, NULL),
(77, 3, 33, 5, 6, 0, 0, NULL),
(78, 3, 33, 1, 4, 0, 0, NULL),
(79, 3, 33, 2, 3, 0, 0, NULL),
(80, 3, 34, 6, 2, 0, 0, NULL),
(81, 3, 34, 3, 1, 0, 0, NULL),
(82, 3, 34, 4, 5, 0, 0, NULL),
(83, 3, 35, 4, 6, 0, 0, NULL),
(84, 3, 35, 5, 3, 0, 0, NULL),
(85, 3, 35, 1, 2, 0, 0, NULL),
(86, 3, 36, 6, 1, 0, 0, NULL),
(87, 3, 36, 2, 5, 0, 0, NULL),
(88, 3, 36, 3, 4, 0, 0, NULL),
(89, 3, 37, 3, 6, 0, 0, NULL),
(90, 3, 37, 4, 2, 0, 0, NULL),
(91, 3, 37, 5, 1, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbpresidentea`
--

CREATE TABLE `tbpresidentea` (
  `presidenteID` int(11) NOT NULL,
  `IzenaP` varchar(50) DEFAULT NULL,
  `taldeID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbpresidentea`
--

INSERT INTO `tbpresidentea` (`presidenteID`, `IzenaP`, `taldeID`) VALUES
(1, 'LUIS JUAN', 1),
(2, 'IÑAKI SANTIAGO', 2),
(3, 'PACHECO GERVASIO ', 3),
(4, 'IGNACIO JUAN', 4),
(5, 'MARTEL PABLO', 5),
(6, 'FERNANDEZ ALFONSO', 6),
(7, 'URIARTE JON', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbtaldea`
--

CREATE TABLE `tbtaldea` (
  `taldeID` int(11) NOT NULL,
  `izenaT` varchar(50) DEFAULT NULL,
  `zelaiaT` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbtaldea`
--

INSERT INTO `tbtaldea` (`taldeID`, `izenaT`, `zelaiaT`) VALUES
(1, 'LA MERCED', 'ARTXANDAKO ZELAIA'),
(2, 'MORAZA', 'ARTXANDAKO ZELAIA'),
(3, 'SANTUTXU FC', 'ESTADIO MAIONA'),
(4, 'CD BASKONIA', 'ARTUNDUAGA'),
(5, 'CD ARIZ', 'SOLOARTE FUTBOL ZELAIA'),
(6, 'SD HUMORE ONA', 'MEATZETA USANSOLO'),
(7, 'ATHLETIC CLUB', 'SAN MAMES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `terabiltzailea_prog`
--

CREATE TABLE `terabiltzailea_prog` (
  `erabitzaile_izena` varchar(100) NOT NULL,
  `pasahitza` varchar(5) DEFAULT NULL,
  `izena` varchar(100) DEFAULT NULL,
  `abizena` varchar(100) DEFAULT NULL,
  `gmail` varchar(100) DEFAULT NULL,
  `mota` varchar(50) NOT NULL DEFAULT 'erabiltzaile'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `terabiltzailea_prog`
--

INSERT INTO `terabiltzailea_prog` (`erabitzaile_izena`, `pasahitza`, `izena`, `abizena`, `gmail`, `mota`) VALUES
('Administratzailea0.2', '1234A', 'Admin', 'Adm', 'Admin@gmail.com', 'Admin'),
('Epailea26', '1234E', 'Epailea', 'Epa', 'Epailea@gmail.com', 'Epaile'),
('M.pg', '1234M', 'Markel', 'Perez', 'Markel@gmail.com', 'Erabiltzailea');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vligaklasifikazioa`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vligaklasifikazioa` (
`taldeID` int(11)
,`izenat` varchar(50)
,`TPG` decimal(32,0)
,`TPE` decimal(32,0)
,`TPP` decimal(32,0)
,`TGOL` decimal(33,0)
,`TPTS` decimal(32,0)
,`NumPART` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vligaklasifikazioa01`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vligaklasifikazioa01` (
`taldeID` int(11)
,`izenat` varchar(50)
,`TPG` decimal(32,0)
,`TPE` decimal(32,0)
,`TPP` decimal(32,0)
,`TGOL` decimal(33,0)
,`TPTS` decimal(32,0)
,`NumPART` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vligaklasifikazioa02`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vligaklasifikazioa02` (
`taldeID` int(11)
,`izenat` varchar(50)
,`TPG` decimal(32,0)
,`TPE` decimal(32,0)
,`TPP` decimal(32,0)
,`TGOL` decimal(33,0)
,`TPTS` decimal(32,0)
,`NumPART` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vligaklasifikazioa03`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vligaklasifikazioa03` (
`taldeID` int(11)
,`izenat` varchar(50)
,`TPG` decimal(32,0)
,`TPE` decimal(32,0)
,`TPP` decimal(32,0)
,`TGOL` decimal(33,0)
,`TPTS` decimal(32,0)
,`NumPART` bigint(21)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vpartiduenemaitza`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vpartiduenemaitza` (
`partiduaId` int(11)
,`izenaT` varchar(50)
,`taldeLokalID` int(11)
,`taldeKanpokoID` int(11)
,`LOCAL` varchar(50)
,`GOLLOCAL` int(11)
,`KANPOKO` varchar(50)
,`GOLKANPOKO` int(11)
,`PG` int(1)
,`PE` int(1)
,`PP` int(1)
,`PTS` int(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vpartiduenemaitza01`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vpartiduenemaitza01` (
`partiduaId` int(11)
,`denboraldiaID` int(11)
,`izenaT` varchar(50)
,`taldeLokalID` int(11)
,`taldeKanpokoID` int(11)
,`LOCAL` varchar(50)
,`GOLLOCAL` int(11)
,`KANPOKO` varchar(50)
,`GOLKANPOKO` int(11)
,`PG` int(1)
,`PE` int(1)
,`PP` int(1)
,`PTS` int(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vpartiduenemaitza02`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vpartiduenemaitza02` (
`partiduaId` int(11)
,`denboraldiaID` int(11)
,`izenaT` varchar(50)
,`taldeLokalID` int(11)
,`taldeKanpokoID` int(11)
,`LOCAL` varchar(50)
,`GOLLOCAL` int(11)
,`KANPOKO` varchar(50)
,`GOLKANPOKO` int(11)
,`PG` int(1)
,`PE` int(1)
,`PP` int(1)
,`PTS` int(1)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vpartiduenemaitza03`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vpartiduenemaitza03` (
`partiduaId` int(11)
,`denboraldiaID` int(11)
,`izenaT` varchar(50)
,`taldeLokalID` int(11)
,`taldeKanpokoID` int(11)
,`LOCAL` varchar(50)
,`GOLLOCAL` int(11)
,`KANPOKO` varchar(50)
,`GOLKANPOKO` int(11)
,`PG` int(1)
,`PE` int(1)
,`PP` int(1)
,`PTS` int(1)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vligaklasifikazioa`
--
DROP TABLE IF EXISTS `vligaklasifikazioa`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vligaklasifikazioa`  AS SELECT `tal`.`taldeID` AS `taldeID`, `vis`.`izenaT` AS `izenat`, sum(`vis`.`PG`) AS `TPG`, sum(`vis`.`PE`) AS `TPE`, sum(`vis`.`PP`) AS `TPP`, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) AS `TGOL`, sum(`vis`.`PTS`) AS `TPTS`, count(0) AS `NumPART` FROM (`vpartiduenemaitza` `vis` join `tbtaldea` `tal` on(`vis`.`izenaT` = `tal`.`izenaT`)) GROUP BY `vis`.`izenaT` ORDER BY sum(`vis`.`PTS`) DESC, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) DESC, sum(`vis`.`PG`) DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vligaklasifikazioa01`
--
DROP TABLE IF EXISTS `vligaklasifikazioa01`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vligaklasifikazioa01`  AS SELECT `tal`.`taldeID` AS `taldeID`, `vis`.`izenaT` AS `izenat`, sum(`vis`.`PG`) AS `TPG`, sum(`vis`.`PE`) AS `TPE`, sum(`vis`.`PP`) AS `TPP`, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) AS `TGOL`, sum(`vis`.`PTS`) AS `TPTS`, count(0) AS `NumPART` FROM (`vpartiduenemaitza01` `vis` join `tbtaldea` `tal` on(`vis`.`izenaT` = `tal`.`izenaT`)) GROUP BY `vis`.`izenaT` ORDER BY sum(`vis`.`PTS`) DESC, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) DESC, sum(`vis`.`PG`) DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vligaklasifikazioa02`
--
DROP TABLE IF EXISTS `vligaklasifikazioa02`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vligaklasifikazioa02`  AS SELECT `tal`.`taldeID` AS `taldeID`, `vis`.`izenaT` AS `izenat`, sum(`vis`.`PG`) AS `TPG`, sum(`vis`.`PE`) AS `TPE`, sum(`vis`.`PP`) AS `TPP`, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) AS `TGOL`, sum(`vis`.`PTS`) AS `TPTS`, count(0) AS `NumPART` FROM (`vpartiduenemaitza02` `vis` join `tbtaldea` `tal` on(`vis`.`izenaT` = `tal`.`izenaT`)) GROUP BY `vis`.`izenaT` ORDER BY sum(`vis`.`PTS`) DESC, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) DESC, sum(`vis`.`PG`) DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vligaklasifikazioa03`
--
DROP TABLE IF EXISTS `vligaklasifikazioa03`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vligaklasifikazioa03`  AS SELECT `tal`.`taldeID` AS `taldeID`, `vis`.`izenaT` AS `izenat`, sum(`vis`.`PG`) AS `TPG`, sum(`vis`.`PE`) AS `TPE`, sum(`vis`.`PP`) AS `TPP`, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) AS `TGOL`, sum(`vis`.`PTS`) AS `TPTS`, count(0) AS `NumPART` FROM (`vpartiduenemaitza03` `vis` join `tbtaldea` `tal` on(`vis`.`izenaT` = `tal`.`izenaT`)) GROUP BY `vis`.`izenaT` ORDER BY sum(`vis`.`PTS`) DESC, sum(`vis`.`GOLLOCAL` + `vis`.`GOLKANPOKO`) DESC, sum(`vis`.`PG`) DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vpartiduenemaitza`
--
DROP TABLE IF EXISTS `vpartiduenemaitza`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpartiduenemaitza`  AS SELECT `par`.`partiduaId` AS `partiduaId`, `tald`.`izenaT` AS `izenaT`, `par`.`taldeLokalID` AS `taldeLokalID`, `par`.`taldeKanpokoID` AS `taldeKanpokoID`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END AS `LOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `par`.`golLokal` ELSE 0 END AS `GOLLOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `tald`.`izenaT` END AS `KANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `par`.`golKanpoko` ELSE 0 END AS `GOLKANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PG`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` = `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PE`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` < `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` > `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PP`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 3 WHEN `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PTS` FROM (`tbtaldea` `tald` join `tbpartidua` `par` on(`tald`.`taldeID` in (`par`.`taldeLokalID`,`par`.`taldeKanpokoID`))) WHERE `par`.`denboraldiaID` = 1 AND `par`.`golLokal` is not null ORDER BY `par`.`partiduaId` ASC, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vpartiduenemaitza01`
--
DROP TABLE IF EXISTS `vpartiduenemaitza01`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpartiduenemaitza01`  AS SELECT `par`.`partiduaId` AS `partiduaId`, `par`.`denboraldiaID` AS `denboraldiaID`, `tald`.`izenaT` AS `izenaT`, `par`.`taldeLokalID` AS `taldeLokalID`, `par`.`taldeKanpokoID` AS `taldeKanpokoID`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END AS `LOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `par`.`golLokal` ELSE 0 END AS `GOLLOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `tald`.`izenaT` END AS `KANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `par`.`golKanpoko` ELSE 0 END AS `GOLKANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PG`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` = `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PE`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` < `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` > `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PP`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 3 WHEN `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PTS` FROM (`tbtaldea` `tald` join `tbpartidua` `par` on(`tald`.`taldeID` in (`par`.`taldeLokalID`,`par`.`taldeKanpokoID`))) WHERE `par`.`denboraldiaID` = 1 AND `par`.`golLokal` is not null ORDER BY `par`.`partiduaId` ASC, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vpartiduenemaitza02`
--
DROP TABLE IF EXISTS `vpartiduenemaitza02`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpartiduenemaitza02`  AS SELECT `par`.`partiduaId` AS `partiduaId`, `par`.`denboraldiaID` AS `denboraldiaID`, `tald`.`izenaT` AS `izenaT`, `par`.`taldeLokalID` AS `taldeLokalID`, `par`.`taldeKanpokoID` AS `taldeKanpokoID`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END AS `LOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `par`.`golLokal` ELSE 0 END AS `GOLLOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `tald`.`izenaT` END AS `KANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `par`.`golKanpoko` ELSE 0 END AS `GOLKANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PG`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` = `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PE`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` < `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` > `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PP`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 3 WHEN `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PTS` FROM (`tbtaldea` `tald` join `tbpartidua` `par` on(`tald`.`taldeID` in (`par`.`taldeLokalID`,`par`.`taldeKanpokoID`))) WHERE `par`.`denboraldiaID` = 2 AND `par`.`golLokal` is not null ORDER BY `par`.`partiduaId` ASC, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END DESC ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vpartiduenemaitza03`
--
DROP TABLE IF EXISTS `vpartiduenemaitza03`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vpartiduenemaitza03`  AS SELECT `par`.`partiduaId` AS `partiduaId`, `par`.`denboraldiaID` AS `denboraldiaID`, `tald`.`izenaT` AS `izenaT`, `par`.`taldeLokalID` AS `taldeLokalID`, `par`.`taldeKanpokoID` AS `taldeKanpokoID`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END AS `LOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `par`.`golLokal` ELSE 0 END AS `GOLLOCAL`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `tald`.`izenaT` END AS `KANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeKanpokoID` THEN `par`.`golKanpoko` ELSE 0 END AS `GOLKANPOKO`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PG`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` = `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PE`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` < `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` > `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PP`, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` AND `par`.`golLokal` > `par`.`golKanpoko` OR `tald`.`taldeID` = `par`.`taldeKanpokoID` AND `par`.`golLokal` < `par`.`golKanpoko` THEN 3 WHEN `par`.`golLokal` = `par`.`golKanpoko` THEN 1 ELSE 0 END AS `PTS` FROM (`tbtaldea` `tald` join `tbpartidua` `par` on(`tald`.`taldeID` in (`par`.`taldeLokalID`,`par`.`taldeKanpokoID`))) WHERE `par`.`denboraldiaID` = 3 AND `par`.`golLokal` is not null ORDER BY `par`.`partiduaId` ASC, CASE WHEN `tald`.`taldeID` = `par`.`taldeLokalID` THEN `tald`.`izenaT` END DESC ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbarbitroa`
--
ALTER TABLE `tbarbitroa`
  ADD PRIMARY KEY (`arbitroaId`);

--
-- Indices de la tabla `tbdenboraldia`
--
ALTER TABLE `tbdenboraldia`
  ADD PRIMARY KEY (`denboraldiaID`);

--
-- Indices de la tabla `tbgola`
--
ALTER TABLE `tbgola`
  ADD PRIMARY KEY (`golakID`),
  ADD KEY `fk_tbGola_tbDenboraldia` (`denboraldiaID`),
  ADD KEY `fk_tbGola_tbJardunaldia` (`jardunaldiaID`),
  ADD KEY `fk_tbGola_tbPartidua` (`partiduaId`),
  ADD KEY `fk_tbGola_tbJokalaria` (`jokalariId`);

--
-- Indices de la tabla `tbjardunaldia`
--
ALTER TABLE `tbjardunaldia`
  ADD PRIMARY KEY (`jardunaldiaID`),
  ADD KEY `FK_tbjardunaldia_tbdenboraldia` (`denboraldiaID`);

--
-- Indices de la tabla `tbjokalaria`
--
ALTER TABLE `tbjokalaria`
  ADD PRIMARY KEY (`jokalariId`),
  ADD KEY `fk_tbJokalaria` (`taldeID`);

--
-- Indices de la tabla `tbpartidua`
--
ALTER TABLE `tbpartidua`
  ADD PRIMARY KEY (`partiduaId`),
  ADD KEY `fk_tbPartidua_tbDenboraldia` (`denboraldiaID`),
  ADD KEY `fk_tbPartidua_tbJardunaldia` (`jardunaldiaID`),
  ADD KEY `fk_tbPartidua_tbTaldeaL` (`taldeLokalID`),
  ADD KEY `fk_tbPartidua_tbTaldeaK` (`taldeKanpokoID`),
  ADD KEY `fk_tbPartidua_tbArbitroa` (`arbitroaId`);

--
-- Indices de la tabla `tbpresidentea`
--
ALTER TABLE `tbpresidentea`
  ADD PRIMARY KEY (`presidenteID`),
  ADD UNIQUE KEY `IzenaP` (`IzenaP`),
  ADD KEY `fk_presidentea_taldea` (`taldeID`);

--
-- Indices de la tabla `tbtaldea`
--
ALTER TABLE `tbtaldea`
  ADD PRIMARY KEY (`taldeID`);

--
-- Indices de la tabla `terabiltzailea_prog`
--
ALTER TABLE `terabiltzailea_prog`
  ADD PRIMARY KEY (`erabitzaile_izena`),
  ADD UNIQUE KEY `gmail` (`gmail`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbarbitroa`
--
ALTER TABLE `tbarbitroa`
  MODIFY `arbitroaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tbdenboraldia`
--
ALTER TABLE `tbdenboraldia`
  MODIFY `denboraldiaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tbgola`
--
ALTER TABLE `tbgola`
  MODIFY `golakID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=180;

--
-- AUTO_INCREMENT de la tabla `tbjardunaldia`
--
ALTER TABLE `tbjardunaldia`
  MODIFY `jardunaldiaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `tbjokalaria`
--
ALTER TABLE `tbjokalaria`
  MODIFY `jokalariId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=281;

--
-- AUTO_INCREMENT de la tabla `tbpartidua`
--
ALTER TABLE `tbpartidua`
  MODIFY `partiduaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=93;

--
-- AUTO_INCREMENT de la tabla `tbpresidentea`
--
ALTER TABLE `tbpresidentea`
  MODIFY `presidenteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tbtaldea`
--
ALTER TABLE `tbtaldea`
  MODIFY `taldeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbgola`
--
ALTER TABLE `tbgola`
  ADD CONSTRAINT `fk_tbGola_tbDenboraldia` FOREIGN KEY (`denboraldiaID`) REFERENCES `tbdenboraldia` (`denboraldiaID`),
  ADD CONSTRAINT `fk_tbGola_tbJardunaldia` FOREIGN KEY (`jardunaldiaID`) REFERENCES `tbjardunaldia` (`jardunaldiaID`),
  ADD CONSTRAINT `fk_tbGola_tbJokalaria` FOREIGN KEY (`jokalariId`) REFERENCES `tbjokalaria` (`jokalariId`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_tbGola_tbPartidua` FOREIGN KEY (`partiduaId`) REFERENCES `tbpartidua` (`partiduaId`);

--
-- Filtros para la tabla `tbjardunaldia`
--
ALTER TABLE `tbjardunaldia`
  ADD CONSTRAINT `FK_tbjardunaldia_tbdenboraldia` FOREIGN KEY (`denboraldiaID`) REFERENCES `tbdenboraldia` (`denboraldiaID`);

--
-- Filtros para la tabla `tbjokalaria`
--
ALTER TABLE `tbjokalaria`
  ADD CONSTRAINT `fk_tbJokalaria` FOREIGN KEY (`taldeID`) REFERENCES `tbtaldea` (`taldeID`);

--
-- Filtros para la tabla `tbpartidua`
--
ALTER TABLE `tbpartidua`
  ADD CONSTRAINT `fk_tbPartidua_tbArbitroa` FOREIGN KEY (`arbitroaId`) REFERENCES `tbarbitroa` (`arbitroaId`),
  ADD CONSTRAINT `fk_tbPartidua_tbDenboraldia` FOREIGN KEY (`denboraldiaID`) REFERENCES `tbdenboraldia` (`denboraldiaID`),
  ADD CONSTRAINT `fk_tbPartidua_tbJardunaldia` FOREIGN KEY (`jardunaldiaID`) REFERENCES `tbjardunaldia` (`jardunaldiaID`),
  ADD CONSTRAINT `fk_tbPartidua_tbTaldeaK` FOREIGN KEY (`taldeKanpokoID`) REFERENCES `tbtaldea` (`taldeID`),
  ADD CONSTRAINT `fk_tbPartidua_tbTaldeaL` FOREIGN KEY (`taldeLokalID`) REFERENCES `tbtaldea` (`taldeID`);

--
-- Filtros para la tabla `tbpresidentea`
--
ALTER TABLE `tbpresidentea`
  ADD CONSTRAINT `fk_presidentea_taldea` FOREIGN KEY (`taldeID`) REFERENCES `tbtaldea` (`taldeID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
