-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 208.113.158.158
-- Generation Time: Dec 11, 2020 at 12:44 PM
-- Server version: 5.7.29-log
-- PHP Version: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dsi20203c`
--

-- --------------------------------------------------------

--
-- Table structure for table `Competencia`
--

CREATE TABLE `Competencia` (
  `id_competencia` int(11) NOT NULL,
  `cant_sets` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `modalidad` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `puntuacion` int(11) DEFAULT NULL,
  `reglamento` varchar(255) DEFAULT NULL,
  `tantosXAusencia` double DEFAULT NULL,
  `id_deporte` int(11) DEFAULT NULL,
  `id_fixture` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_Eliminacion_Directa`
--

CREATE TABLE `Competencia_Eliminacion_Directa` (
  `id_competencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_Eliminacion_Doble`
--

CREATE TABLE `Competencia_Eliminacion_Doble` (
  `id_competencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_ItemLugar`
--

CREATE TABLE `Competencia_ItemLugar` (
  `Competencia_id_competencia` int(11) NOT NULL,
  `Lugares_id_item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_Liga`
--

CREATE TABLE `Competencia_Liga` (
  `empate` bit(1) DEFAULT NULL,
  `puntos_por_empate` double DEFAULT NULL,
  `puntos_por_ganar` double DEFAULT NULL,
  `puntos_por_presentarse` double DEFAULT NULL,
  `id_competencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_Participante`
--

CREATE TABLE `Competencia_Participante` (
  `Competencia_id_competencia` int(11) NOT NULL,
  `Participantes_id_Participante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Deporte`
--

CREATE TABLE `Deporte` (
  `id_deporte` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fecha`
--

CREATE TABLE `Fecha` (
  `id_fecha` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `rondaGanadores` bit(1) DEFAULT NULL,
  `rondaPerdedores` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fecha_Partido`
--

CREATE TABLE `Fecha_Partido` (
  `Fecha_id_fecha` int(11) NOT NULL,
  `listaPartidos_id_partido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fixture`
--

CREATE TABLE `Fixture` (
  `id_fixture` int(11) NOT NULL,
  `id_competencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fixture_Fecha`
--

CREATE TABLE `Fixture_Fecha` (
  `Fixture_id_fixture` int(11) NOT NULL,
  `Fechas_id_fecha` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `ItemLugar`
--

CREATE TABLE `ItemLugar` (
  `id_item` int(11) NOT NULL,
  `disponibilidad` int(11) DEFAULT NULL,
  `codigo_lugar` int(11) DEFAULT NULL,
  `id_competencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Lugar`
--

CREATE TABLE `Lugar` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Lugar_Deporte`
--

CREATE TABLE `Lugar_Deporte` (
  `Lugar_codigo` int(11) NOT NULL,
  `deportes_id_deporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Participante`
--

CREATE TABLE `Participante` (
  `id_Participante` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Partido`
--

CREATE TABLE `Partido` (
  `id_partido` int(11) NOT NULL,
  `id_lugar` int(11) DEFAULT NULL,
  `id_Local` int(11) DEFAULT NULL,
  `id_visitante` int(11) DEFAULT NULL,
  `id_resultado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Resultado`
--

CREATE TABLE `Resultado` (
  `id_resultado` int(11) NOT NULL,
  `aPresente` bit(1) DEFAULT NULL,
  `bPresente` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Resultado_Puntuacion`
--

CREATE TABLE `Resultado_Puntuacion` (
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL,
  `id_resultado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Resultado_Puntuacion_Final`
--

CREATE TABLE `Resultado_Puntuacion_Final` (
  `empate` bit(1) DEFAULT NULL,
  `ganaA` bit(1) DEFAULT NULL,
  `ganaB` bit(1) DEFAULT NULL,
  `id_resultado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Resultado_Sets`
--

CREATE TABLE `Resultado_Sets` (
  `setsA` int(11) DEFAULT NULL,
  `setsB` int(11) DEFAULT NULL,
  `id_resultado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario`
--

CREATE TABLE `Usuario` (
  `id_usuario` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `correoElectronico` varchar(255) DEFAULT NULL,
  `dni` double DEFAULT NULL,
  `id_localidad` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipoDni` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario_Competencia`
--

CREATE TABLE `Usuario_Competencia` (
  `Usuario_id_usuario` int(11) NOT NULL,
  `competencias_id_competencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD PRIMARY KEY (`id_competencia`),
  ADD KEY `FKfddycbloyohqy9ibpwibne0t` (`id_deporte`),
  ADD KEY `FK4ts6fy1ibr20xwd8tujmmsfvo` (`id_fixture`),
  ADD KEY `FKf13xhhqh5ymd35l3c7qg6ujh9` (`id_usuario`);

--
-- Indexes for table `Competencia_Eliminacion_Directa`
--
ALTER TABLE `Competencia_Eliminacion_Directa`
  ADD PRIMARY KEY (`id_competencia`);

--
-- Indexes for table `Competencia_Eliminacion_Doble`
--
ALTER TABLE `Competencia_Eliminacion_Doble`
  ADD PRIMARY KEY (`id_competencia`);

--
-- Indexes for table `Competencia_ItemLugar`
--
ALTER TABLE `Competencia_ItemLugar`
  ADD UNIQUE KEY `UK_pknyhn5ct8d4mhi75kekoxk7y` (`Lugares_id_item`),
  ADD KEY `FKod0g8i22rkgbajjjjv622ce1o` (`Competencia_id_competencia`);

--
-- Indexes for table `Competencia_Liga`
--
ALTER TABLE `Competencia_Liga`
  ADD PRIMARY KEY (`id_competencia`);

--
-- Indexes for table `Competencia_Participante`
--
ALTER TABLE `Competencia_Participante`
  ADD UNIQUE KEY `UK_8o9650mgbswflt08jstw56dvl` (`Participantes_id_Participante`),
  ADD KEY `FKbm1r66l2fdy4m8ca4chj6obny` (`Competencia_id_competencia`);

--
-- Indexes for table `Deporte`
--
ALTER TABLE `Deporte`
  ADD PRIMARY KEY (`id_deporte`);

--
-- Indexes for table `Fecha`
--
ALTER TABLE `Fecha`
  ADD PRIMARY KEY (`id_fecha`);

--
-- Indexes for table `Fecha_Partido`
--
ALTER TABLE `Fecha_Partido`
  ADD UNIQUE KEY `UK_q539f16eppwoavh5ms25c1qmb` (`listaPartidos_id_partido`),
  ADD KEY `FK2kkice6pcr404mru2lkdbvvsi` (`Fecha_id_fecha`);

--
-- Indexes for table `Fixture`
--
ALTER TABLE `Fixture`
  ADD PRIMARY KEY (`id_fixture`),
  ADD KEY `FK2dqh2kcplgrxwx7dt6u55olr1` (`id_competencia`);

--
-- Indexes for table `Fixture_Fecha`
--
ALTER TABLE `Fixture_Fecha`
  ADD UNIQUE KEY `UK_acoc1aw83fastd197p21hv4xu` (`Fechas_id_fecha`),
  ADD KEY `FK6k0kel9s5ini9bsad08dkws1s` (`Fixture_id_fixture`);

--
-- Indexes for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `FK2wcl8nscovi6qvxu3td4efh8h` (`codigo_lugar`),
  ADD KEY `FKgfoidg1ewry480dtjub4q5odd` (`id_competencia`);

--
-- Indexes for table `Lugar`
--
ALTER TABLE `Lugar`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `Lugar_Deporte`
--
ALTER TABLE `Lugar_Deporte`
  ADD UNIQUE KEY `UK_bkf1y47saoaymqgwd94w2g64s` (`deportes_id_deporte`),
  ADD KEY `FKcw5vcc93hgire5x1csbdf79y` (`Lugar_codigo`);

--
-- Indexes for table `Participante`
--
ALTER TABLE `Participante`
  ADD PRIMARY KEY (`id_Participante`);

--
-- Indexes for table `Partido`
--
ALTER TABLE `Partido`
  ADD PRIMARY KEY (`id_partido`),
  ADD KEY `FKrysfg8pilcrd22vpvbig5q5ll` (`id_lugar`),
  ADD KEY `FKfnah9n0kacspprf6bqif8lme2` (`id_Local`),
  ADD KEY `FKqe66gg24bd3v0teu1gmuio7sp` (`id_visitante`),
  ADD KEY `FK776618l24uhoesvcgkn0l90q9` (`id_resultado`);

--
-- Indexes for table `Resultado`
--
ALTER TABLE `Resultado`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indexes for table `Resultado_Puntuacion`
--
ALTER TABLE `Resultado_Puntuacion`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indexes for table `Resultado_Puntuacion_Final`
--
ALTER TABLE `Resultado_Puntuacion_Final`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indexes for table `Resultado_Sets`
--
ALTER TABLE `Resultado_Sets`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indexes for table `Usuario_Competencia`
--
ALTER TABLE `Usuario_Competencia`
  ADD UNIQUE KEY `UK_i4d79vtnuy4v6qnpepng6sxvs` (`competencias_id_competencia`),
  ADD KEY `FKgw69qdavsfh630ikynvalt9ld` (`Usuario_id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Competencia`
--
ALTER TABLE `Competencia`
  MODIFY `id_competencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Deporte`
--
ALTER TABLE `Deporte`
  MODIFY `id_deporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Lugar`
--
ALTER TABLE `Lugar`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Participante`
--
ALTER TABLE `Participante`
  MODIFY `id_Participante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD CONSTRAINT `FK4ts6fy1ibr20xwd8tujmmsfvo` FOREIGN KEY (`id_fixture`) REFERENCES `Fixture` (`id_fixture`),
  ADD CONSTRAINT `FKf13xhhqh5ymd35l3c7qg6ujh9` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  ADD CONSTRAINT `FKfddycbloyohqy9ibpwibne0t` FOREIGN KEY (`id_deporte`) REFERENCES `Deporte` (`id_deporte`);

--
-- Constraints for table `Competencia_Eliminacion_Directa`
--
ALTER TABLE `Competencia_Eliminacion_Directa`
  ADD CONSTRAINT `FK49mi9grfc9lmi7gmkm8vaogyf` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Competencia_Eliminacion_Doble`
--
ALTER TABLE `Competencia_Eliminacion_Doble`
  ADD CONSTRAINT `FK4dge1g3fffuwn5twax3m8a29e` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Competencia_ItemLugar`
--
ALTER TABLE `Competencia_ItemLugar`
  ADD CONSTRAINT `FK6h0kecdlbdb01hcq1y9roqvb4` FOREIGN KEY (`Lugares_id_item`) REFERENCES `ItemLugar` (`id_item`),
  ADD CONSTRAINT `FKod0g8i22rkgbajjjjv622ce1o` FOREIGN KEY (`Competencia_id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Competencia_Liga`
--
ALTER TABLE `Competencia_Liga`
  ADD CONSTRAINT `FK1lqob34qgdnw9ksoqlci6gj43` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Competencia_Participante`
--
ALTER TABLE `Competencia_Participante`
  ADD CONSTRAINT `FKbm1r66l2fdy4m8ca4chj6obny` FOREIGN KEY (`Competencia_id_competencia`) REFERENCES `Competencia` (`id_competencia`),
  ADD CONSTRAINT `FKd156k2swal6dxhoj56kv58h12` FOREIGN KEY (`Participantes_id_Participante`) REFERENCES `Participante` (`id_Participante`);

--
-- Constraints for table `Fecha_Partido`
--
ALTER TABLE `Fecha_Partido`
  ADD CONSTRAINT `FK2kkice6pcr404mru2lkdbvvsi` FOREIGN KEY (`Fecha_id_fecha`) REFERENCES `Fecha` (`id_fecha`),
  ADD CONSTRAINT `FK50f0xlawswh18lt79u17k10hr` FOREIGN KEY (`listaPartidos_id_partido`) REFERENCES `Partido` (`id_partido`);

--
-- Constraints for table `Fixture`
--
ALTER TABLE `Fixture`
  ADD CONSTRAINT `FK2dqh2kcplgrxwx7dt6u55olr1` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Fixture_Fecha`
--
ALTER TABLE `Fixture_Fecha`
  ADD CONSTRAINT `FK6k0kel9s5ini9bsad08dkws1s` FOREIGN KEY (`Fixture_id_fixture`) REFERENCES `Fixture` (`id_fixture`),
  ADD CONSTRAINT `FKoukljs6y8nr4t2m3663689mql` FOREIGN KEY (`Fechas_id_fecha`) REFERENCES `Fecha` (`id_fecha`);

--
-- Constraints for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD CONSTRAINT `FK2wcl8nscovi6qvxu3td4efh8h` FOREIGN KEY (`codigo_lugar`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKgfoidg1ewry480dtjub4q5odd` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Lugar_Deporte`
--
ALTER TABLE `Lugar_Deporte`
  ADD CONSTRAINT `FKcw5vcc93hgire5x1csbdf79y` FOREIGN KEY (`Lugar_codigo`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKn5kdgq0he65era83vypnt9ab0` FOREIGN KEY (`deportes_id_deporte`) REFERENCES `Deporte` (`id_deporte`);

--
-- Constraints for table `Partido`
--
ALTER TABLE `Partido`
  ADD CONSTRAINT `FK776618l24uhoesvcgkn0l90q9` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`),
  ADD CONSTRAINT `FKfnah9n0kacspprf6bqif8lme2` FOREIGN KEY (`id_Local`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKqe66gg24bd3v0teu1gmuio7sp` FOREIGN KEY (`id_visitante`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKrysfg8pilcrd22vpvbig5q5ll` FOREIGN KEY (`id_lugar`) REFERENCES `Lugar` (`codigo`);

--
-- Constraints for table `Resultado_Puntuacion`
--
ALTER TABLE `Resultado_Puntuacion`
  ADD CONSTRAINT `FKefv6l6sgnsokb7awmvi5yslj4` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`);

--
-- Constraints for table `Resultado_Puntuacion_Final`
--
ALTER TABLE `Resultado_Puntuacion_Final`
  ADD CONSTRAINT `FKroxa2itdhaor4smajng0tbqbc` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`);

--
-- Constraints for table `Resultado_Sets`
--
ALTER TABLE `Resultado_Sets`
  ADD CONSTRAINT `FKr83tg2j7qlwu1rcerp2udfw6l` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`);

--
-- Constraints for table `Usuario_Competencia`
--
ALTER TABLE `Usuario_Competencia`
  ADD CONSTRAINT `FKgw69qdavsfh630ikynvalt9ld` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  ADD CONSTRAINT `FKkh7tydvj9wffel3t8gk5jecs1` FOREIGN KEY (`competencias_id_competencia`) REFERENCES `Competencia` (`id_competencia`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
