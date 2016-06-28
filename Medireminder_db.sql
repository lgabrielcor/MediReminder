CREATE TABLE 'propiedades' (
	'nombre'	TEXT,
	'valor'	BLOB
);
CREATE TABLE "historial_dosis" (
	'id'	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	'id_dosis'	NUMERIC,
	'fecha_dosis_timestamp_utc'	NUMERIC,
	'fecha_dosis_aplicada_timestamp_utc'	INTEGER,
	'cumplida'	TEXT,
	'visible'	INTEGER
);
CREATE TABLE "dosis" (
	'id'	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	'medicamento'	INTEGER,
	'frecuencia'	INTEGER,
	'medida_tiempo'	TEXT,
	'dosificacion'	TEXT,
	'terminada'	NUMERIC,
	'foto'	BLOB,
	'visible'	INTEGER
);

