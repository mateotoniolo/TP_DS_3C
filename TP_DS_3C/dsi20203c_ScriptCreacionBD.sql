- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 208.113.158.158
-- Generation Time: Dec 14, 2020 at 04:08 PM
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
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Ingreso_Usuario`
--

CREATE TABLE `Auditoria_Ingreso_Usuario` (
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Modificacion_Participante`
--

CREATE TABLE `Auditoria_Modificacion_Participante` (
  `fechaModificacion` date NOT NULL,
  `horaModificacion` time NOT NULL,
  `correo_Anterior` varchar(255) DEFAULT NULL,
  `id_Anterior` int(11) DEFAULT NULL,
  `nombre_Anterior` varchar(255) DEFAULT NULL
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
  `hora` time DEFAULT NULL
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
-- Table structure for table `Auditoria_Resultado_Sets_Auditoria_Set`
--

CREATE TABLE `Auditoria_Resultado_Sets_Auditoria_Set` (
  `AuditoriaResultadoSets_id_auditoria` int(11) NOT NULL,
  `listaSets_id_auditoriaSet` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Auditoria_Set`
--

CREATE TABLE `Auditoria_Set` (
  `id_auditoriaSet` int(11) NOT NULL,
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL
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
  `id_fixture` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Competencia_Auditoria_Baja_Competencia`
--

CREATE TABLE `Competencia_Auditoria_Baja_Competencia` (
  `Competencia_id_competencia` int(11) NOT NULL,
  `historialBajaCompetencia_fecha` date NOT NULL,
  `historialBajaCompetencia_hora` time NOT NULL
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
-- Table structure for table `Competencia_Liga_EstadisticaTabla`
--

CREATE TABLE `Competencia_Liga_EstadisticaTabla` (
  `CompetenciaLiga_id_competencia` int(11) NOT NULL,
  `estadisticas_id_estadistica` int(11) NOT NULL
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
-- Table structure for table `EstadisticaTabla_Participante`
--

CREATE TABLE `EstadisticaTabla_Participante` (
  `EstadisticaTabla_id_estadistica` int(11) NOT NULL,
  `participantes_id_Participante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Fecha`
--

CREATE TABLE `Fecha` (
  `id_fecha` int(11) NOT NULL,
  `id_fixture` int(11) NOT NULL,
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
  `Fecha_id_fixture` int(11) NOT NULL,
  `listaPartidos_id_fecha` int(11) NOT NULL,
  `listaPartidos_id_fixture` int(11) NOT NULL,
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
  `Fechas_id_fecha` int(11) NOT NULL,
  `Fechas_id_fixture` int(11) NOT NULL
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
-- Table structure for table `Localidad`
--

CREATE TABLE `Localidad` (
  `id_localidad` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  `id_provincia` int(11) NOT NULL
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
-- Table structure for table `Participante_Auditoria_Modificacion_Participante`
--

CREATE TABLE `Participante_Auditoria_Modificacion_Participante` (
  `Participante_id_Participante` int(11) NOT NULL,
  `historialCambios_fechaModificacion` date NOT NULL,
  `historialCambios_horaModificacion` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Partido`
--

CREATE TABLE `Partido` (
  `id_partido` int(11) NOT NULL,
  `id_fecha` int(11) NOT NULL,
  `id_fixture` int(11) NOT NULL,
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
  `id_pais` int(11) NOT NULL,
  `id_provincia` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
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
-- Table structure for table `Resultado_Auditoria_Modificacion_Resultado`
--

CREATE TABLE `Resultado_Auditoria_Modificacion_Resultado` (
  `Resultado_id_resultado` int(11) NOT NULL,
  `historialCambios_id_auditoria` int(11) NOT NULL
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
-- Table structure for table `Resultado_Sets_SetJuego`
--

CREATE TABLE `Resultado_Sets_SetJuego` (
  `ResultadoSets_id_resultado` int(11) NOT NULL,
  `listaSets_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SetJuego`
--

CREATE TABLE `SetJuego` (
  `id` int(11) NOT NULL,
  `tantosA` int(11) DEFAULT NULL,
  `tantosB` int(11) DEFAULT NULL
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
  `id_localidad` int(11) NOT NULL,
  `id_pais` int(11) NOT NULL,
  `id_provincia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario_Auditoria_Ingreso_Usuario`
--

CREATE TABLE `Usuario_Auditoria_Ingreso_Usuario` (
  `Usuario_id_usuario` int(11) NOT NULL,
  `historialIngresos_fecha` date NOT NULL,
  `historialIngresos_hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario_Competencia`
--

CREATE TABLE `Usuario_Competencia` (
  `Usuario_id_usuario` int(11) NOT NULL,
  `competencias_id_competencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario_Lugar`
--

CREATE TABLE `Usuario_Lugar` (
  `Usuario_id_usuario` int(11) NOT NULL,
  `lugares_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auditoria_Baja_Competencia`
--
ALTER TABLE `Auditoria_Baja_Competencia`
  ADD PRIMARY KEY (`fecha`,`hora`);

--
-- Indexes for table `Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Auditoria_Ingreso_Usuario`
  ADD PRIMARY KEY (`fecha`,`hora`);

--
-- Indexes for table `Auditoria_Modificacion_Participante`
--
ALTER TABLE `Auditoria_Modificacion_Participante`
  ADD PRIMARY KEY (`fechaModificacion`,`horaModificacion`);

--
-- Indexes for table `Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Auditoria_Modificacion_Resultado`
  ADD PRIMARY KEY (`id_auditoria`);

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
-- Indexes for table `Auditoria_Resultado_Sets_Auditoria_Set`
--
ALTER TABLE `Auditoria_Resultado_Sets_Auditoria_Set`
  ADD UNIQUE KEY `UK_e3f8mpvyw5tp92pn3ixvns00m` (`listaSets_id_auditoriaSet`),
  ADD KEY `FKjwq42hwhd72p1is4mi205booc` (`AuditoriaResultadoSets_id_auditoria`);

--
-- Indexes for table `Auditoria_Set`
--
ALTER TABLE `Auditoria_Set`
  ADD PRIMARY KEY (`id_auditoriaSet`);

--
-- Indexes for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD PRIMARY KEY (`id_competencia`),
  ADD KEY `FKfddycbloyohqy9ibpwibne0t` (`id_deporte`),
  ADD KEY `FK4ts6fy1ibr20xwd8tujmmsfvo` (`id_fixture`),
  ADD KEY `FKf13xhhqh5ymd35l3c7qg6ujh9` (`id_usuario`);

--
-- Indexes for table `Competencia_Auditoria_Baja_Competencia`
--
ALTER TABLE `Competencia_Auditoria_Baja_Competencia`
  ADD UNIQUE KEY `UK_412wnwmv0yw2xsq1bvf52h8if` (`historialBajaCompetencia_fecha`,`historialBajaCompetencia_hora`),
  ADD KEY `FKsp2db1qnn95pcxr34b86lq4a9` (`Competencia_id_competencia`);

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
-- Indexes for table `Competencia_Liga_EstadisticaTabla`
--
ALTER TABLE `Competencia_Liga_EstadisticaTabla`
  ADD UNIQUE KEY `UK_4fh0of8giy4nmwr9je5ba81j7` (`estadisticas_id_estadistica`),
  ADD KEY `FKo2mb7rfxamdpxkgy8v858mhox` (`CompetenciaLiga_id_competencia`);

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
-- Indexes for table `EstadisticaTabla_Participante`
--
ALTER TABLE `EstadisticaTabla_Participante`
  ADD UNIQUE KEY `UK_snburmx3hi1rmbwxxssnael11` (`participantes_id_Participante`),
  ADD KEY `FKg992yanqkolrbrktnptd1307y` (`EstadisticaTabla_id_estadistica`);

--
-- Indexes for table `Fecha`
--
ALTER TABLE `Fecha`
  ADD PRIMARY KEY (`id_fecha`,`id_fixture`),
  ADD KEY `FK22mivh918g5oixxam1m3hldn8` (`id_fixture`);

--
-- Indexes for table `Fecha_Partido`
--
ALTER TABLE `Fecha_Partido`
  ADD UNIQUE KEY `UK_dgpt4jstuhifqa6asis4qoxxp` (`listaPartidos_id_fecha`,`listaPartidos_id_fixture`,`listaPartidos_id_partido`),
  ADD KEY `FKc15me77bbq83fo04dr63mlx3m` (`Fecha_id_fecha`,`Fecha_id_fixture`);

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
  ADD UNIQUE KEY `UK_srwifi5k5hfqnljb7dumtthr1` (`Fechas_id_fecha`,`Fechas_id_fixture`),
  ADD KEY `FK6k0kel9s5ini9bsad08dkws1s` (`Fixture_id_fixture`);

--
-- Indexes for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD PRIMARY KEY (`id_item`),
  ADD KEY `FK2wcl8nscovi6qvxu3td4efh8h` (`codigo_lugar`),
  ADD KEY `FKgfoidg1ewry480dtjub4q5odd` (`id_competencia`);

--
-- Indexes for table `Localidad`
--
ALTER TABLE `Localidad`
  ADD PRIMARY KEY (`id_localidad`,`id_pais`,`id_provincia`),
  ADD KEY `FKmatyv8aufopkaaf21p70aimt0` (`id_pais`,`id_provincia`);

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
  ADD UNIQUE KEY `UK_bkf1y47saoaymqgwd94w2g64s` (`deportes_id_deporte`),
  ADD KEY `FKcw5vcc93hgire5x1csbdf79y` (`Lugar_codigo`);

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
-- Indexes for table `Participante_Auditoria_Modificacion_Participante`
--
ALTER TABLE `Participante_Auditoria_Modificacion_Participante`
  ADD UNIQUE KEY `UK_5ampqp9k73xjxluqr5vwintrh` (`historialCambios_fechaModificacion`,`historialCambios_horaModificacion`),
  ADD KEY `FKsxbwmuyf3mo1iu030ud8k4par` (`Participante_id_Participante`);

--
-- Indexes for table `Partido`
--
ALTER TABLE `Partido`
  ADD PRIMARY KEY (`id_fecha`,`id_fixture`,`id_partido`),
  ADD KEY `FKrysfg8pilcrd22vpvbig5q5ll` (`id_lugar`),
  ADD KEY `FKfnah9n0kacspprf6bqif8lme2` (`id_Local`),
  ADD KEY `FKqe66gg24bd3v0teu1gmuio7sp` (`id_visitante`),
  ADD KEY `FK776618l24uhoesvcgkn0l90q9` (`id_resultado`);

--
-- Indexes for table `Provincia`
--
ALTER TABLE `Provincia`
  ADD PRIMARY KEY (`id_pais`,`id_provincia`);

--
-- Indexes for table `Resultado`
--
ALTER TABLE `Resultado`
  ADD PRIMARY KEY (`id_resultado`);

--
-- Indexes for table `Resultado_Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Resultado_Auditoria_Modificacion_Resultado`
  ADD UNIQUE KEY `UK_bbv2cyiiq1elgg0natuoa0kq9` (`historialCambios_id_auditoria`),
  ADD KEY `FKafahhps068rmjnhfre68pqqmx` (`Resultado_id_resultado`);

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
-- Indexes for table `Resultado_Sets_SetJuego`
--
ALTER TABLE `Resultado_Sets_SetJuego`
  ADD UNIQUE KEY `UK_hca21004kbqwgqfyt1h1g6a5p` (`listaSets_id`),
  ADD KEY `FKivjcar1mntetijbsumjs3j0ea` (`ResultadoSets_id_resultado`);

--
-- Indexes for table `SetJuego`
--
ALTER TABLE `SetJuego`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FK1ohild83xuh2ragc6jkx54f60` (`id_localidad`,`id_pais`,`id_provincia`);

--
-- Indexes for table `Usuario_Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Usuario_Auditoria_Ingreso_Usuario`
  ADD UNIQUE KEY `UK_7duifag9gsun9hh7mpb6hiy60` (`historialIngresos_fecha`,`historialIngresos_hora`),
  ADD KEY `FKpokomoukvklgr7rq5qf22f22m` (`Usuario_id_usuario`);

--
-- Indexes for table `Usuario_Competencia`
--
ALTER TABLE `Usuario_Competencia`
  ADD UNIQUE KEY `UK_i4d79vtnuy4v6qnpepng6sxvs` (`competencias_id_competencia`),
  ADD KEY `FKgw69qdavsfh630ikynvalt9ld` (`Usuario_id_usuario`);

--
-- Indexes for table `Usuario_Lugar`
--
ALTER TABLE `Usuario_Lugar`
  ADD UNIQUE KEY `UK_9yo7vcepny79bq42li3p3n1qp` (`lugares_codigo`),
  ADD KEY `FKlgu5voo6cdyp3uk8amc0g0bxa` (`Usuario_id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

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
  MODIFY `id_fecha` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Fixture`
--
ALTER TABLE `Fixture`
  MODIFY `id_fixture` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  MODIFY `id_item` int(11) NOT NULL AUTO_INCREMENT;

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
  MODIFY `id_fecha` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Provincia`
--
ALTER TABLE `Provincia`
  MODIFY `id_pais` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Resultado`
--
ALTER TABLE `Resultado`
  MODIFY `id_resultado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SetJuego`
--
ALTER TABLE `SetJuego`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Usuario`
--
ALTER TABLE `Usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

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
-- Constraints for table `Auditoria_Resultado_Sets_Auditoria_Set`
--
ALTER TABLE `Auditoria_Resultado_Sets_Auditoria_Set`
  ADD CONSTRAINT `FKi4e8y9h21do22rbqrvur4d7le` FOREIGN KEY (`listaSets_id_auditoriaSet`) REFERENCES `Auditoria_Set` (`id_auditoriaSet`),
  ADD CONSTRAINT `FKjwq42hwhd72p1is4mi205booc` FOREIGN KEY (`AuditoriaResultadoSets_id_auditoria`) REFERENCES `Auditoria_Resultado_Sets` (`id_auditoria`);

--
-- Constraints for table `Competencia`
--
ALTER TABLE `Competencia`
  ADD CONSTRAINT `FK4ts6fy1ibr20xwd8tujmmsfvo` FOREIGN KEY (`id_fixture`) REFERENCES `Fixture` (`id_fixture`),
  ADD CONSTRAINT `FKf13xhhqh5ymd35l3c7qg6ujh9` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  ADD CONSTRAINT `FKfddycbloyohqy9ibpwibne0t` FOREIGN KEY (`id_deporte`) REFERENCES `Deporte` (`id_deporte`);

--
-- Constraints for table `Competencia_Auditoria_Baja_Competencia`
--
ALTER TABLE `Competencia_Auditoria_Baja_Competencia`
  ADD CONSTRAINT `FKcbl1asyq56baq6a8rgulqjpn` FOREIGN KEY (`historialBajaCompetencia_fecha`,`historialBajaCompetencia_hora`) REFERENCES `Auditoria_Baja_Competencia` (`fecha`, `hora`),
  ADD CONSTRAINT `FKsp2db1qnn95pcxr34b86lq4a9` FOREIGN KEY (`Competencia_id_competencia`) REFERENCES `Competencia` (`id_competencia`);

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
-- Constraints for table `Competencia_Liga_EstadisticaTabla`
--
ALTER TABLE `Competencia_Liga_EstadisticaTabla`
  ADD CONSTRAINT `FKa7k2dpu2pv7k3vf3xddjh4618` FOREIGN KEY (`estadisticas_id_estadistica`) REFERENCES `EstadisticaTabla` (`id_estadistica`),
  ADD CONSTRAINT `FKo2mb7rfxamdpxkgy8v858mhox` FOREIGN KEY (`CompetenciaLiga_id_competencia`) REFERENCES `Competencia_Liga` (`id_competencia`);

--
-- Constraints for table `Competencia_Participante`
--
ALTER TABLE `Competencia_Participante`
  ADD CONSTRAINT `FKbm1r66l2fdy4m8ca4chj6obny` FOREIGN KEY (`Competencia_id_competencia`) REFERENCES `Competencia` (`id_competencia`),
  ADD CONSTRAINT `FKd156k2swal6dxhoj56kv58h12` FOREIGN KEY (`Participantes_id_Participante`) REFERENCES `Participante` (`id_Participante`);

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
-- Constraints for table `EstadisticaTabla_Participante`
--
ALTER TABLE `EstadisticaTabla_Participante`
  ADD CONSTRAINT `FKc1iefgpbttnkvu7ab2v7u56di` FOREIGN KEY (`participantes_id_Participante`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKg992yanqkolrbrktnptd1307y` FOREIGN KEY (`EstadisticaTabla_id_estadistica`) REFERENCES `EstadisticaTabla` (`id_estadistica`);

--
-- Constraints for table `Fecha`
--
ALTER TABLE `Fecha`
  ADD CONSTRAINT `FK22mivh918g5oixxam1m3hldn8` FOREIGN KEY (`id_fixture`) REFERENCES `Fixture` (`id_fixture`);

--
-- Constraints for table `Fecha_Partido`
--
ALTER TABLE `Fecha_Partido`
  ADD CONSTRAINT `FKc15me77bbq83fo04dr63mlx3m` FOREIGN KEY (`Fecha_id_fecha`,`Fecha_id_fixture`) REFERENCES `Fecha` (`id_fecha`, `id_fixture`),
  ADD CONSTRAINT `FKtqm51apfcy0jum0c5pfxda5r7` FOREIGN KEY (`listaPartidos_id_fecha`,`listaPartidos_id_fixture`,`listaPartidos_id_partido`) REFERENCES `Partido` (`id_fecha`, `id_fixture`, `id_partido`);

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
  ADD CONSTRAINT `FKmt3yh08mr6wngkm2chq8dfxeq` FOREIGN KEY (`Fechas_id_fecha`,`Fechas_id_fixture`) REFERENCES `Fecha` (`id_fecha`, `id_fixture`);

--
-- Constraints for table `ItemLugar`
--
ALTER TABLE `ItemLugar`
  ADD CONSTRAINT `FK2wcl8nscovi6qvxu3td4efh8h` FOREIGN KEY (`codigo_lugar`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKgfoidg1ewry480dtjub4q5odd` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Localidad`
--
ALTER TABLE `Localidad`
  ADD CONSTRAINT `FKmatyv8aufopkaaf21p70aimt0` FOREIGN KEY (`id_pais`,`id_provincia`) REFERENCES `Provincia` (`id_pais`, `id_provincia`);

--
-- Constraints for table `Lugar`
--
ALTER TABLE `Lugar`
  ADD CONSTRAINT `FKjcx1fvrfkphflkdat983oqibs` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario` (`id_usuario`);

--
-- Constraints for table `Lugar_Deporte`
--
ALTER TABLE `Lugar_Deporte`
  ADD CONSTRAINT `FKcw5vcc93hgire5x1csbdf79y` FOREIGN KEY (`Lugar_codigo`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKn5kdgq0he65era83vypnt9ab0` FOREIGN KEY (`deportes_id_deporte`) REFERENCES `Deporte` (`id_deporte`);

--
-- Constraints for table `Participante`
--
ALTER TABLE `Participante`
  ADD CONSTRAINT `FKcgu5pdh0mgqyoep0o3qmnp1e7` FOREIGN KEY (`id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Participante_Auditoria_Modificacion_Participante`
--
ALTER TABLE `Participante_Auditoria_Modificacion_Participante`
  ADD CONSTRAINT `FKfwfdimytjo9vrhstvo382gbyr` FOREIGN KEY (`historialCambios_fechaModificacion`,`historialCambios_horaModificacion`) REFERENCES `Auditoria_Modificacion_Participante` (`fechaModificacion`, `horaModificacion`),
  ADD CONSTRAINT `FKsxbwmuyf3mo1iu030ud8k4par` FOREIGN KEY (`Participante_id_Participante`) REFERENCES `Participante` (`id_Participante`);

--
-- Constraints for table `Partido`
--
ALTER TABLE `Partido`
  ADD CONSTRAINT `FK776618l24uhoesvcgkn0l90q9` FOREIGN KEY (`id_resultado`) REFERENCES `Resultado` (`id_resultado`),
  ADD CONSTRAINT `FKfnah9n0kacspprf6bqif8lme2` FOREIGN KEY (`id_Local`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKqe66gg24bd3v0teu1gmuio7sp` FOREIGN KEY (`id_visitante`) REFERENCES `Participante` (`id_Participante`),
  ADD CONSTRAINT `FKrysfg8pilcrd22vpvbig5q5ll` FOREIGN KEY (`id_lugar`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKsju2vykxh3ftxruxv0vrhtklt` FOREIGN KEY (`id_fecha`,`id_fixture`) REFERENCES `Fecha` (`id_fecha`, `id_fixture`);

--
-- Constraints for table `Provincia`
--
ALTER TABLE `Provincia`
  ADD CONSTRAINT `FKjnx8iv0tbse2c1td4f2jh71x` FOREIGN KEY (`id_pais`) REFERENCES `Pais` (`id_pais`);

--
-- Constraints for table `Resultado_Auditoria_Modificacion_Resultado`
--
ALTER TABLE `Resultado_Auditoria_Modificacion_Resultado`
  ADD CONSTRAINT `FK3ui4u4u4d69sr6yrm0j4xq7c2` FOREIGN KEY (`historialCambios_id_auditoria`) REFERENCES `Auditoria_Modificacion_Resultado` (`id_auditoria`),
  ADD CONSTRAINT `FKafahhps068rmjnhfre68pqqmx` FOREIGN KEY (`Resultado_id_resultado`) REFERENCES `Resultado` (`id_resultado`);

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
-- Constraints for table `Resultado_Sets_SetJuego`
--
ALTER TABLE `Resultado_Sets_SetJuego`
  ADD CONSTRAINT `FKivjcar1mntetijbsumjs3j0ea` FOREIGN KEY (`ResultadoSets_id_resultado`) REFERENCES `Resultado_Sets` (`id_resultado`),
  ADD CONSTRAINT `FKr5c89vu73cp1y3pyax5j4frya` FOREIGN KEY (`listaSets_id`) REFERENCES `SetJuego` (`id`);

--
-- Constraints for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FK1ohild83xuh2ragc6jkx54f60` FOREIGN KEY (`id_localidad`,`id_pais`,`id_provincia`) REFERENCES `Localidad` (`id_localidad`, `id_pais`, `id_provincia`);

--
-- Constraints for table `Usuario_Auditoria_Ingreso_Usuario`
--
ALTER TABLE `Usuario_Auditoria_Ingreso_Usuario`
  ADD CONSTRAINT `FK21qdm61olsgu33enm3ck2akk4` FOREIGN KEY (`historialIngresos_fecha`,`historialIngresos_hora`) REFERENCES `Auditoria_Ingreso_Usuario` (`fecha`, `hora`),
  ADD CONSTRAINT `FKpokomoukvklgr7rq5qf22f22m` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `Usuario` (`id_usuario`);

--
-- Constraints for table `Usuario_Competencia`
--
ALTER TABLE `Usuario_Competencia`
  ADD CONSTRAINT `FKgw69qdavsfh630ikynvalt9ld` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `Usuario` (`id_usuario`),
  ADD CONSTRAINT `FKkh7tydvj9wffel3t8gk5jecs1` FOREIGN KEY (`competencias_id_competencia`) REFERENCES `Competencia` (`id_competencia`);

--
-- Constraints for table `Usuario_Lugar`
--
ALTER TABLE `Usuario_Lugar`
  ADD CONSTRAINT `FK3tg228ubt5q3dbyfwdt5ob793` FOREIGN KEY (`lugares_codigo`) REFERENCES `Lugar` (`codigo`),
  ADD CONSTRAINT `FKlgu5voo6cdyp3uk8amc0g0bxa` FOREIGN KEY (`Usuario_id_usuario`) REFERENCES `Usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

