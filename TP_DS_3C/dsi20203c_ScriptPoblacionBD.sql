INSERT INTO `Usuario` (`id_usuario`, `apellido`, `contrasenia`, `correoElectronico`, `dni`, `nombre`, `tipoDni`, `id_localidad`) VALUES
(6, 'Toniolo', 'utn', 'mateojustotoniolo@gmail.com', 42561194, 'Mateo', 0, NULL);

INSERT INTO `Deporte` (`id_deporte`, `nombre`) VALUES
(10, 'Basquet'),
(20, 'Futbol'),
(30, 'Rugby'),
(40, 'Tenis');
INSERT INTO `Fixture` (`id_fixture`) VALUES
(1),
(2);
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

INSERT INTO `Lugar` (`codigo`, `descripcion`, `nombre`, `id_usuario`) VALUES
(1, 'Este lugar pertenece al Usuario 6', 'Cancha Norte', 6),
(2, 'Este Lugar pertenece al Usuario 6', 'Cancha Sur', 6);

INSERT INTO `Lugar_Deporte` (`Lugar_codigo`, `deportes_id_deporte`) VALUES
(1, 10),
(1, 20),
(1, 30),
(2, 20),
(2, 30),
(2, 40);

INSERT INTO `Competencia` (`id_competencia`, `cant_sets`, `estado`, `modalidad`, `nombre`, `puntuacion`, `reglamento`, `tantosXAusencia`, `id_deporte`, `id_fixture`, `id_usuario`) VALUES
(1, 0, 'CREADA', 'ELIMINACION_DOBLE', 'COMPETENCIA ELIMINACIÓN DOBLE', 2, 'reglamento de la competencia de eliminación doble', 9, 20, NULL, 6),
(2, 0, 'CREADA', 'LIGA', 'COMPETENCIA EJEMPLO LIGA', 1, '', 8, 30, 2, 6);
INSERT INTO `Competencia_Eliminacion_Doble` (`id_competencia`) VALUES
(1);
INSERT INTO `Competencia_Liga` (`empate`, `puntos_por_empate`, `puntos_por_ganar`, `puntos_por_presentarse`, `id_competencia`) VALUES
(b'1', 1, 3, 0, 2);
INSERT INTO `ItemLugar` (`id_item`, `disponibilidad`, `codigo_lugar`, `id_competencia`) VALUES
(1, 8, 2, 1),
(2, 7, 2, 2),
(3, 7, 1, 2);
INSERT INTO `Participante` (`id_Participante`, `email`, `nombre`, `id_competencia`) VALUES
(1, 'Mateojustotoniolo@Gmail.com', 'Mateo Toniolo', 1),
(3, 'emiliomusso@gmail.com', 'Emilio Musso', 1),
(4, 'matiasstorti@gmail.com', 'Matias Storti', 2),
(5, 'jmonti@hotmail.com', 'Josias Montivero', 2),
(6, 'part2@hotmail.com', 'Participante 2', 2),
(9, 'Emiliomusso@.', 'Emilio Musso', 2);