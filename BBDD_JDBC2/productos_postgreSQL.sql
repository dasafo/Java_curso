CREATE TABLE productos (
    codigoarticulo varchar(5) PRIMARY KEY,
    seccion varchar(20),
    nombrearticulo varchar(50),
    precio numeric(10,2),
    fecha date,
    importado boolean,
    paisdeorigen varchar(20)
);

INSERT INTO productos (codigoarticulo, seccion, nombrearticulo, precio, fecha, importado, paisdeorigen) VALUES
('AR01', 'FERRETERÍA', 'DESTORNILLADOR', 6.63, '2000-10-22', FALSE, 'ESPAÑA'),
('AR02', 'CONFECCIÓN', 'TRAJE CABALLERO', 284.58, '2002-03-11', TRUE, 'ITALIA'),
('AR03', 'JUGUETERÍA', 'COCHE TELEDIRIGIDO', 159.45, '2002-05-26', TRUE, 'MARRUECOS'),
('AR04', 'DEPORTES', 'RAQUETA TENIS', 93.47, '2000-03-20', TRUE, 'USA'),
('AR06', 'DEPORTES', 'MANCUERNAS', 60.00, '2000-09-13', TRUE, 'USA'),
('AR07', 'CONFECCIÓN', 'SERRUCHO', 30.20, '2001-03-23', TRUE, 'FRANCIA'),
('AR08', 'JUGUETERÍA', 'CORREPASILLOS', 103.34, '2000-04-11', TRUE, 'JAPÓN'),
('AR09', 'CONFECCIÓN', 'PANTALÓN SEÑORA', 174.23, '2000-01-10', TRUE, 'MARRUECOS'),
('AR10', 'JUGUETERÍA', 'CONSOLA VIDEO', 442.54, '2002-09-24', TRUE, 'USA'),
('AR11', 'CERÁMICA', 'TUBOS', 168.43, '2000-02-04', TRUE, 'CHINA'),
('AR12', 'FERRETERÍA', 'LLAVE INGLESA', 24.40, '2001-05-23', TRUE, 'USA'),
('AR13', 'CONFECCIÓN', 'CAMISA CABALLERO', 67.13, '2002-08-11', FALSE, 'ESPAÑA'),
('AR14', 'JUGUETERÍA', 'TREN ELÉCTRICO', 1505.38, '2001-07-03', TRUE, 'JAPÓN'),
('AR15', 'CERÁMICA', 'PLATO DECORATIVO', 54.09, '2000-06-07', TRUE, 'CHINA'),
('AR16', 'FERRETERÍA', 'ALICATES', 6.74, '2000-04-17', TRUE, 'ITALIA'),
('AR17', 'JUGUETERÍA', 'MUÑECA ANDADORA', 105.06, '2001-01-04', FALSE, 'ESPAÑA'),
('AR18', 'DEPORTES', 'PISTOLA OLÍMPICA', 46.73, '2001-02-02', TRUE, 'SUECIA'),
('AR19', 'CONFECCIÓN', 'BLUSA SRA.', 101.06, '2000-03-18', TRUE, 'CHINA'),
('AR20', 'CERÁMICA', 'JUEGO DE TE', 43.27, '2001-01-15', TRUE, 'CHINA'),
('AR21', 'CERÁMICA', 'CENICERO', 19.75, '2001-07-02', TRUE, 'JAPÓN'),
('AR22', 'FERRETERÍA', 'MARTILLO', 11.40, '2001-09-04', FALSE, 'ESPAÑA'),
('AR23', 'CONFECCIÓN', 'CAZADORA PIEL', 522.69, '2001-07-10', TRUE, 'ITALIA'),
('AR24', 'DEPORTES', 'BALÓN RUGBY', 111.64, '2000-11-11', TRUE, 'USA'),
('AR25', 'DEPORTES', 'BALÓN BALONCESTO', 75.27, '2001-06-25', TRUE, 'JAPÓN'),
('AR26', 'JUGUETERÍA', 'FUERTE DE SOLDADOS', 143.70, '2000-11-25', TRUE, 'JAPÓN'),
('AR27', 'CONFECCIÓN', 'ABRIGO CABALLERO', 500000.00, '2002-04-05', TRUE, 'ITALIA'),
('AR28', 'DEPORTES', 'BALÓN FÚTBOL', 43.91, '2002-07-04', FALSE, 'ESPAÑA'),
('AR29', 'CONFECCIÓN', 'ABRIGO SRA', 360.07, '2001-05-03', TRUE, 'MARRUECOS'),
('AR30', 'FERRETERÍA', 'DESTORNILLADOR', 9.06, '2002-02-20', TRUE, 'FRANCIA'),
('AR31', 'JUGUETERÍA', 'PISTOLA CON SONIDOS', 57.25, '2001-04-15', FALSE, 'ESPAÑA'),
('AR32', 'DEPORTES', 'CRONÓMETRO', 439.18, '2002-01-03', TRUE, 'USA'),
('AR33', 'CERÁMICA', 'MACETA', 29.04, '2000-02-23', FALSE, 'ESPAÑA'),
('AR34', 'OFICINA', 'PIE DE LÁMPARA', 39.76, '2001-05-27', TRUE, 'TURQUÍA'),
('AR35', 'FERRETERÍA', 'LIMA GRANDE', 22.07, '2002-08-10', FALSE, 'ESPAÑA'),
('AR36', 'FERRETERÍA', 'JUEGO DE BROCAS', 15.10, '2002-07-04', TRUE, 'TAIWÁN'),
('AR37', 'CONFECCIÓN', 'CINTURÓN DE PIEL', 4.33, '2002-05-12', FALSE, 'ESPAÑA'),
('AR38', 'DEPORTES', 'CAÑA DE PESCA', 270.00, '2000-02-14', TRUE, 'USA'),
('AR39', 'CERÁMICA', 'JARRA CHINA', 127.77, '2002-09-02', TRUE, 'CHINA'),
('AR40', 'DEPORTES', 'BOTA ALPINISMO', 144.00, '2002-05-05', FALSE, 'ESPAÑA'),
('AR41', 'DEPORTES', 'PALAS DE PING PONG', 21.60, '2002-02-02', FALSE, 'ESPAÑA');
