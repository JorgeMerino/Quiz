INSERT INTO `retos` (`id`, `nombre`, `disponible`, `id_pregunta_actual`) VALUES (1, 'Prueba', 0, NULL);

INSERT INTO `preguntas` (`id`, `cuestion`, `reto`) VALUES
(1, 'Año del Descubrimiento de América', 1),
(2, 'Descartes era...', 1),
(3, 'Austria pertenece a...', 1);

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