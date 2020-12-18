INSERT INTO `Usuario` (`id_usuario`, `apellido`, `contrasenia`, `correoElectronico`, `dni`, `nombre`, `tipoDni`, `id_localidad`) VALUES
(6, 'Toniolo', 'utn', 'mateojustotoniolo@gmail.com', 42561194, 'Mateo', 0, NULL);

INSERT INTO `Deporte` (`id_deporte`, `nombre`) VALUES
(10, 'Basquet'),
(20, 'Futbol'),
(30, 'Rugby'),
(40, 'Tenis');


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

