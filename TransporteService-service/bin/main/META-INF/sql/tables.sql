create table Escuela_Alumnos (
	matricula INTEGER not null primary key,
	nombre VARCHAR(75) null,
	apellido VARCHAR(75) null,
	grupoId INTEGER
);

create table Escuela_Edificio (
	edificioId INTEGER not null primary key,
	nombre VARCHAR(75) null
);

create table Escuela_Grupos (
	grupoId INTEGER not null primary key,
	nombre VARCHAR(75) null
);