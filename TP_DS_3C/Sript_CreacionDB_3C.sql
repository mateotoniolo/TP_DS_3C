-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 208.113.158.158
-- Generation Time: Dec 17, 2020 at 09:13 PM
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
-- Table structure for table `Auditoria_Baja_Competencia`
--

CREATE TABLE `Auditoria_Baja_Competencia` (
  `id_auditoria` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Ingreso_Usuario`
--

CREATE TABLE `Auditoria_Ingreso_Usuario` (
  `id_auditoria` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Modificacion_Participante`
--

CREATE TABLE `Auditoria_Modificacion_Participante` (
  `id_auditoria` int(11) NOT NULL,
  `correo_Anterior` varchar(255) DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  `horaModificacion` time DEFAULT NULL,
  `id_Anterior` int(11) DEFAULT NULL,
  `nombre_Anterior` varchar(255) DEFAULT NULL,
  `id_participante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Modificacion_Resultado`
--

CREATE TABLE `Auditoria_Modificacion_Resultado` (
  `id_auditoria` int(11) NOT NULL,
  `aPresente` bit(1) DEFAULT NULL,
  `bPresente` bit(1) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `id_participante` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Resultado_Puntuacion`
--

CREATE TABLE `Auditoria_Resultado_Puntuacion` (
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL,
  `id_auditoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Resultado_Puntuacion_Final`
--

CREATE TABLE `Auditoria_Resultado_Puntuacion_Final` (
  `empate` bit(1) DEFAULT NULL,
  `ganaA` bit(1) DEFAULT NULL,
  `ganaB` bit(1) DEFAULT NULL,
  `id_auditoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Resultado_Sets`
--

CREATE TABLE `Auditoria_Resultado_Sets` (
  `setsA` int(11) DEFAULT NULL,
  `setsB` int(11) DEFAULT NULL,
  `id_auditoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Set`
--

CREATE TABLE `Auditoria_Set` (
  `id_auditoriaSet` int(11) NOT NULL,
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL,
  `id_auditoriaResultado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `idfixture` int(11) DEFAULT NULL,
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
-- Table structure for table `Deporte`
--

CREATE TABLE `Deporte` (
  `id_deporte` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Estadisitica_Equipo_Puntuacion`
--

CREATE TABLE `Estadisitica_Equipo_Puntuacion` (
  `diferencia` double DEFAULT NULL,
  `tantosAFavor` double DEFAULT NULL,
  `tantosEnContra` double DEFAULT NULL,
  `id_estadistica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Estadisitica_Equipo_Puntuacion_Final`
--

CREATE TABLE `Estadisitica_Equipo_Puntuacion_Final` (
  `id_estadistica` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `EstadisticaTabla`
--

CREATE TABLE `EstadisticaTabla` (
  `id_estadistica` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `partidosEmpatados` int(11) DEFAULT NULL,
  `partidosGanados` int(11) DEFAULT NULL,
  `partidosPerdidos` int(11) DEFAULT NULL,
  `posicion` int(11) DEFAULT NULL,
  `id_competencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fecha`
--

CREATE TABLE `Fecha` (
  `idfecha` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `rondaGanadores` bit(1) DEFAULT NULL,
  `rondaPerdedores` bit(1) DEFAULT NULL,
  `fixture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fixture`
--

CREATE TABLE `Fixture` (
  `idfixture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ItemLugar`
--

CREATE TABLE `ItemLugar` (
  `disponibilidad` int(11) DEFAULT NULL,
  `competencia` int(11) NOT NULL,
  `codigo_lugar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Localidad`
--

CREATE TABLE `Localidad` (
  `id_localidad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `provincia_id_provincia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Lugar`
--

CREATE TABLE `Lugar` (
  `codigo` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
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
-- Table structure for table `Pais`
--

CREATE TABLE `Pais` (
  `id_pais` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Participante`
--

CREATE TABLE `Participante` (
  `id_Participante` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_competencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Partido`
--

CREATE TABLE `Partido` (
  `idpartido` int(11) NOT NULL,
  `partido_ganador` int(11) DEFAULT NULL,
  `partido_perdedor` int(11) DEFAULT NULL,
  `fecha_idfecha` int(11) NOT NULL,
  `id_lugar` int(11) DEFAULT NULL,
  `id_Local` int(11) DEFAULT NULL,
  `id_visitante` int(11) DEFAULT NULL,
  `id_resultado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Provincia`
--

CREATE TABLE `Provincia` (
  `id_provincia` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_pais` int(11) NOT NULL
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
-- Table structure for table `SetJuego`
--

CREATE TABLE `SetJuego` (
  `id` int(11) NOT NULL,
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL,
  `resultado_id_resultado` int(11) NOT NULL
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
  `nombre` varchar(255) DEFAULT NULL,
  `tipoDni` int(11) DEFAULT NULL,
  `id_localidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auditoria_Baja_Competencia`
--
ALTER TABLE `Auditoria_Baja_Competencia`
  ADD PRIMARY KEY (`id_auditoria`);

--
-- Indexes for table `Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Auditoria_Ingreso_Usuario`
  ADD PRIMARY KEY (`id_auditoria`),
  ADD KEY `FK41yd6yavmwhaoi861hiu2g95i` (`id_usuario`);

--
-- Indexes for table `Auditoria_Modificacion_Participante`
--
ALTER TABLE `Auditoria_Modificacion_Participante`
  ADD PRIMARY KEY (`id_auditoria`),
  ADD KEY `FK3nadbyuqquiyuak50sebdquw8` (`id_participante`);

--
-- Indexes for table `Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Auditoria_Modificacion_Resultado`
  ADD PRIMARY KEY (`id_auditoria`),
  ADD KEY `FKbxlef0dmoy7lup5ydhlawhan6` (`id_participante`);

--
-- Indexes for table `Auditoria_Resultado_Puntuacion`
--
ALTER TABLE `Auditoria_Resultado_Puntuacion`
  ADD PRIMARY KEY (`id_auditoria`);

--
-- Indexes for table `Auditoria_Resultado_Puntuacion_Final`
--
ALTER TABLE `Auditoria_Resultado_Puntuacion_Final`
  ADD PRIMARY KEY (`id_auditoria`);

--
-- Indexes for table `Auditoria_Resultado_Sets`
--
ALTER TABLE `Auditoria_Resultado_Sets`
  ADD PRIMARY KEY (`id_auditoria`);

--
-- Indexes for table `Auditoria_Set`
--
ALTER TABLE `Auditoria_Set`
  ADD PRIMARY KEY (`id_auditoriaSet`),
  ADD KEY `FK6pcjp1vb9mxu7jnv4uo0grgxh` (`id_auditoriaResultado`);

--
-- Indexes for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD PRIMARY KEY (`id_competencia`),
  ADD KEY `FKfddycbloyohqy9ibpwibne0t` (`id_deporte`),
  ADD KEY `FKjh4033qh0wgies3k3hg148k1l` (`idfixture`),
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
-- Indexes for table `Competencia_Liga`
--
ALTER TABLE `Competencia_Liga`
  ADD PRIMARY KEY (`id_competencia`);

--
-- Indexes for table `Deporte`
--
ALTER TABLE `Deporte`
  ADD PRIMARY KEY (`id_deporte`);

--
-- Indexes for table `Estadisitica_Equipo_Puntuacion`
--
ALTER TABLE `Estadisitica_Equipo_Puntuacion`
  ADD PRIMARY KEY (`id_estadistica`);

--
-- Indexes for table `Estadisitica_Equipo_Puntuacion_Final`
--
ALTER TABLE `Estadisitica_Equipo_Puntuacion_Final`
  ADD PRIMARY KEY (`id_estadistica`);

--
-- Indexes for table `EstadisticaTabla`
--
ALTER TABLE `EstadisticaTabla`
  ADD PRIMARY KEY (`id_estadistica`),
  ADD KEY `FK8qexkgs1p7d3ydj9x0njn0cr0` (`id_competencia`);

--
-- Indexes for table `Fecha`
--
ALTER TABLE `Fecha`
  ADD PRIMARY KEY (`idfecha`,`fixture`),
  ADD KEY `FKlx9dd4vjn19yue6b0t25llknf` (`fixture`);

--
-- Indexes for table `Fixture`
--
ALTER TABLE `Fixture`
  ADD PRIMARY KEY (`idfixture`);

--
-- Indexes for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD PRIMARY KEY (`competencia`,`codigo_lugar`),
  ADD KEY `UK_q510ynoaw3hbub3187upq44o` (`codigo_lugar`) USING BTREE;

--
-- Indexes for table `Localidad`
--
ALTER TABLE `Localidad`
  ADD PRIMARY KEY (`id_localidad`,`provincia_id_provincia`),
  ADD KEY `FKf8uibl8ose2ibp6pps8jsqpqi` (`provincia_id_provincia`);

--
-- Indexes for table `Lugar`
--
ALTER TABLE `Lugar`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKjcx1fvrfkphflkdat983oqibs` (`id_usuario`);

--
-- Indexes for table `Lugar_Deporte`
--
ALTER TABLE `Lugar_Deporte`
  ADD PRIMARY KEY (`Lugar_codigo`,`deportes_id_deporte`),
  ADD KEY `FKn5kdgq0he65era83vypnt9ab0` (`deportes_id_deporte`);

--
-- Indexes for table `Pais`
--
ALTER TABLE `Pais`
  ADD PRIMARY KEY (`id_pais`);

--
-- Indexes for table `Participante`
--
ALTER TABLE `Participante`
  ADD PRIMARY KEY (`id_Participante`),
  ADD KEY `FKcgu5pdh0mgqyoep0o3qmnp1e7` (`id_competencia`);

--
-- Indexes for table `Partido`
--
ALTER TABLE `Partido`
  ADD PRIMARY KEY (`idpartido`,`fecha_idfecha`),
  ADD KEY `FK9puoigehs5hp4wp0qvljjl580` (`partido_ganador`),
  ADD KEY `FKafhx4rdoscb04oaxsabtyywu2` (`partido_perdedor`),
  ADD KEY `FKrysfg8pilcrd22vpvbig5q5ll` (`id_lugar`),
  ADD KEY `FKfnah9n0kacspprf6bqif8lme2` (`id_Local`),
  ADD KEY `FKqe66gg24bd3v0teu1gmuio7sp` (`id_visitante`),
  ADD KEY `FK776618l24uhoesvcgkn0l90q9` (`id_resultado`),
  ADD KEY `FK1vgalimcs35k4iaqgmq6lqt3r` (`fecha_idfecha`);

--
-- Indexes for table `Provincia`
--
ALTER TABLE `Provincia`
  ADD PRIMARY KEY (`id_provincia`,`id_pais`),
  ADD KEY `FKjnx8iv0tbse2c1td4f2jh71x` (`id_pais`);

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
-- Indexes for table `SetJuego`
--
ALTER TABLE `SetJuego`
  ADD PRIMARY KEY (`resultado_id_resultado`,`id`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FKtdfti95m2bohskhx8p8mhwnii` (`id_localidad`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Auditoria_Baja_Competencia`
--
ALTER TABLE `Auditoria_Baja_Competencia`
  MODIFY `id_auditoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Auditoria_Ingreso_Usuario`
  MODIFY `id_auditoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Auditoria_Modificacion_Participante`
--
ALTER TABLE `Auditoria_Modificacion_Participante`
  MODIFY `id_auditoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Auditoria_Modificacion_Resultado`
  MODIFY `id_auditoria` int(11) NOT NULL AUTO_INCREMENT;

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
-- AUTO_INCREMENT for table `EstadisticaTabla`
--
ALTER TABLE `EstadisticaTabla`
  MODIFY `id_estadistica` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Fecha`
--
ALTER TABLE `Fecha`
  MODIFY `idfecha` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Fixture`
--
ALTER TABLE `Fixture`
  MODIFY `idfixture` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Localidad`
--
ALTER TABLE `Localidad`
  MODIFY `id_localidad` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Lugar`
--
ALTER TABLE `Lugar`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Pais`
--
ALTER TABLE `Pais`
  MODIFY `id_pais` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Participante`
--
ALTER TABLE `Participante`
  MODIFY `id_Participante` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Partido`
--
ALTER TABLE `Partido`
  MODIFY `idpartido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Provincia`
--
ALTER TABLE `Provincia`
  MODIFY `id_provincia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Resultado`
--
ALTER TABLE `Resultado`
  MODIFY `id_resultado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SetJuego`
--
ALTER TABLE `SetJuego`
  MODIFY `resultado_id_resultado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Auditoria_Ingreso_Usuario`
  ADD CONSTRAINT `FK41yd6yavmwhaoi861hiu2g95i` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`);

--
-- Constraints for table `Auditoria_Modificacion_Participante`
--
ALTER TABLE `Auditoria_Modificacion_Participante`
  ADD CONSTRAINT `FK3nadbyuqquiyuak50sebdquw8` FOREIGN KEY (`id_participante`) REFERENCES `Participante` (`id_Participante`);

--
-- Constraints for table `Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Auditoria_Modificacion_Resultado`
  ADD CONSTRAINT `FKbxlef0dmoy7lup5ydhlawhan6` FOREIGN KEY (`id_participante`) REFERENCES `Resultado` (`id_resultado`);

--
-- Constraints for table `Auditoria_Resultado_Puntuacion`
--
ALTER TABLE `Auditoria_Resultado_Puntuacion`
  ADD CONSTRAINT `FKo8064se5gaw7feh051jgsfcd7` FOREIGN KEY (`id_auditoria`) REFERENCES `Auditoria_Modificacion_Resultado` (`id_auditoria`);

--
-- Constraints for table `Auditoria_Resultado_Puntuacion_Final`
--
ALTER TABLE `Auditoria_Resultado_Puntuacion_Final`
  ADD CONSTRAINT `FKar14bsnd51edrxyvs1wha0b0d` FOREIGN KEY (`id_auditoria`) REFERENCES `Auditoria_Modificacion_Resultado` (`id_auditoria`);

--
-- Constraints for table `Auditoria_Resultado_Sets`
--
ALTER TABLE `Auditoria_Resultado_Sets`
  ADD CONSTRAINT `FKjbebntc2fgg0v3fvb1wnk8s8q` FOREIGN KEY (`id_auditoria`) REFERENCES `Auditoria_Modificacion_Resultado` (`id_auditoria`);

--
-- Constraints for table `Auditoria_Set`
--
ALTER TABLE `Auditoria_Set`
  ADD CONSTRAINT `FK6pcjp1vb9mxu7jnv4uo0grgxh` FOREIGN KEY (`id_auditoriaResultado`) REFERENCES `Auditoria_Resultado_Sets` (`id_auditoria`);

--
-- Constraints for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD CONSTRAINT `FKf13xhhqh5ymd35l3c7qg6ujh9` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  ADD CONSTRAINT `FKfddycbloyohqy9ibpwibne0t` FOREIGN KEY (`id_deporte`) REFERENCES `Deporte` (`id_deporte`),
  ADD CONSTRAINT `FKjh4033qh0wgies3k3hg148k1l` FOREIGN KEY (`idfixture`) REFERENCES `Fixture` (`idfixture`);

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
-- Constraints for table `Competencia_Liga`
--
ALTER TABLE `Competencia_Liga`
  ADD CONSTRAINT `FK1lqob34qgdnw9ksoqlci6gj43` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Estadisitica_Equipo_Puntuacion`
--
ALTER TABLE `Estadisitica_Equipo_Puntuacion`
  ADD CONSTRAINT `FKp0qbinmt2mss0w8dg66ih4rgd` FOREIGN KEY (`id_estadistica`) REFERENCES `EstadisticaTabla` (`id_estadistica`);

--
-- Constraints for table `Estadisitica_Equipo_Puntuacion_Final`
--
ALTER TABLE `Estadisitica_Equipo_Puntuacion_Final`
  ADD CONSTRAINT `FKe9brkt92xy3higjxy2420nti6` FOREIGN KEY (`id_estadistica`) REFERENCES `EstadisticaTabla` (`id_estadistica`);

--
-- Constraints for table `EstadisticaTabla`
--
ALTER TABLE `EstadisticaTabla`
  ADD CONSTRAINT `FK8qexkgs1p7d3ydj9x0njn0cr0` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia_Liga` (`id_competencia`);

--
-- Constraints for table `Fecha`
--
ALTER TABLE `Fecha`
  ADD CONSTRAINT `FKlx9dd4vjn19yue6b0t25llknf` FOREIGN KEY (`fixture`) REFERENCES `Fixture` (`idfixture`),
  ADD CONSTRAINT `fk_fixture` FOREIGN KEY (`fixture`) REFERENCES `Fixture` (`idfixture`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD CONSTRAINT `FK2wcl8nscovi6qvxu3td4efh8h` FOREIGN KEY (`codigo_lugar`) REFERENCES `Lugar` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKmf0icshplg3q6fio69jxo71oa` FOREIGN KEY (`competencia`) REFERENCES `Competencia` (`id_competencia`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Localidad`
--
ALTER TABLE `Localidad`
  ADD CONSTRAINT `FK_Provincia` FOREIGN KEY (`provincia_id_provincia`) REFERENCES `Provincia` (`id_provincia`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKf8uibl8ose2ibp6pps8jsqpqi` FOREIGN KEY (`provincia_id_provincia`) REFERENCES `Provincia` (`id_provincia`);

--
-- Constraints for table `Lugar`
--
ALTER TABLE `Lugar`
  ADD CONSTRAINT `FKjcx1fvrfkphflkdat983oqibs` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`);

--
-- Constraints for table `Lugar_Deporte`
--
ALTER TABLE `Lugar_Deporte`
  ADD CONSTRAINT `FKcw5vcc93hgire5x1csbdf79y` FOREIGN KEY (`Lugar_codigo`) REFERENCES `Lugar` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKn5kdgq0he65era83vypnt9ab0` FOREIGN KEY (`deportes_id_deporte`) REFERENCES `Deporte` (`id_deporte`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Participante`
--
ALTER TABLE `Participante`
  ADD CONSTRAINT `FKcgu5pdh0mgqyoep0o3qmnp1e7` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Partido`
--
ALTER TABLE `Partido`
  ADD CONSTRAINT `FK1vgalimcs35k4iaqgmq6lqt3r` FOREIGN KEY (`fecha_idfecha`) REFERENCES `Fecha` (`idfecha`),
  ADD CONSTRAINT `FK776618l24uhoesvcgkn0l90q9` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`),
  ADD CONSTRAINT `FK9puoigehs5hp4wp0qvljjl580` FOREIGN KEY (`partido_ganador`) REFERENCES `Partido` (`idpartido`),
  ADD CONSTRAINT `FKafhx4rdoscb04oaxsabtyywu2` FOREIGN KEY (`partido_perdedor`) REFERENCES `Partido` (`idpartido`),
  ADD CONSTRAINT `FKfnah9n0kacspprf6bqif8lme2` FOREIGN KEY (`id_Local`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKqe66gg24bd3v0teu1gmuio7sp` FOREIGN KEY (`id_visitante`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKrysfg8pilcrd22vpvbig5q5ll` FOREIGN KEY (`id_lugar`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `fk_fecha` FOREIGN KEY (`fecha_idfecha`) REFERENCES `Fecha` (`idfecha`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Provincia`
--
ALTER TABLE `Provincia`
  ADD CONSTRAINT `FK_pais` FOREIGN KEY (`id_pais`) REFERENCES `Pais` (`id_pais`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FKjnx8iv0tbse2c1td4f2jh71x` FOREIGN KEY (`id_pais`) REFERENCES `Pais` (`id_pais`);

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
-- Constraints for table `SetJuego`
--
ALTER TABLE `SetJuego`
  ADD CONSTRAINT `FKals1xsuftqqicvmq2wlfmi91r` FOREIGN KEY (`resultado_id_resultado`) REFERENCES `Resultado_Sets` (`id_resultado`),
  ADD CONSTRAINT `Fk_resultado` FOREIGN KEY (`resultado_id_resultado`) REFERENCES `Resultado_Sets` (`id_resultado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FKtdfti95m2bohskhx8p8mhwnii` FOREIGN KEY (`id_localidad`) REFERENCES `Localidad` (`id_localidad`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
