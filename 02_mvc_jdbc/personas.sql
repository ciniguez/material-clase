CREATE TABLE `PERSONA` (
  `id` int NOT NULL,
  `nombre` varchar(56) NOT NULL,
  `clave` varchar(56) NOT NULL
) ENGINE=InnoDB;

INSERT INTO `PERSONA` (`id`, `nombre`, `clave`) VALUES
(1, 'Carlos', 'carlos123'),
(3, 'Pedro', 'pedro123');

ALTER TABLE `PERSONA`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `PERSONA`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;
