INSERT INTO `retos` (`id`, `nombre`, `id_pregunta_actual`) VALUES (1, 'Prueba', NULL);

INSERT INTO `preguntas` (`id`, `cuestion`, `reto`, `tiempo_respuesta`) VALUES
(1, 'Año del Descubrimiento de América', 1, 10),
(2, 'Descartes era...', 1, 10),
(3, 'Austria pertenece a...', 1, 15);

INSERT INTO `opciones` (`id`, `correcta`, `respuesta`, `pregunta`) VALUES
(1, 0, '1560', 1),
(2, 1, '1492', 1),
(3, 0, '1023', 1),
(4, 0, 'Astronauta', 2),
(5, 0, 'Físico', 2),
(6, 0, 'Novelista', 2),
(7, 1, 'Filósofo', 2),
(8, 1, 'Europa', 3),
(9, 0, 'Oceanía', 3);