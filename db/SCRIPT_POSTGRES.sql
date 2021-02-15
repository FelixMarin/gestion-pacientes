CREATE SEQUENCE SALUD.usuario_id_seq;

CREATE TABLE SALUD.usuario( 
	id BIGINT NOT NULL DEFAULT nextval('SALUD.usuario_id_seq'),
	nombre CHARACTER(150) NOT NULL,
	apellidos CHARACTER(150) NOT NULL,
	login CHARACTER(50) NOT NULL,
	tipo_usuario CHARACTER(2) not null,
	clave CHARACTER(10) NOT NULL,	
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Juan','Perez Lopez', 'jupelo','0000','M',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Jose','Mano Jumez', 'jomaju','0000','P',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Jesus','Jimenez Lomo', 'jijilo','0000','P',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Rui','Guirao Mena', 'rugume','0000','P',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Pere','Ondoño Pla', 'peonpa','0000','P',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Maria','Jimeno Pardo', 'majipa','0000','M',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Rosa','Martinez Lada', 'romala','0000','M',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'Vlad','Gonzalez Neira', 'vagone','0000','M',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.USUARIO (id,nombre,apellidos,login,clave,tipo_usuario,fecha_creacion,fecha_modificacion)VALUES(DEFAULT,'felix','marin ramirez', 'femara','0000','F',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);



CREATE SEQUENCE SALUD.medico_id_seq;

CREATE TABLE SALUD.medico(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.medico_id_seq'),
	id_usuario BIGINT NOT NULL,
	num_colegiado CHARACTER(50) NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT fk_medico_usuario FOREIGN KEY (id_usuario) REFERENCES SALUD.usuario(id),
	CONSTRAINT medico_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.MEDICO (id,id_usuario,num_colegiado,fecha_creacion,fecha_modificacion) VALUES(DEFAULT,'1','323354379',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.MEDICO (id,id_usuario,num_colegiado,fecha_creacion,fecha_modificacion) VALUES(DEFAULT,'6','233456776',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.MEDICO (id,id_usuario,num_colegiado,fecha_creacion,fecha_modificacion) VALUES(DEFAULT,'7','654568799',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.MEDICO (id,id_usuario,num_colegiado,fecha_creacion,fecha_modificacion) VALUES(DEFAULT,'8','433223456',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


CREATE SEQUENCE SALUD.paciente_id_seq;

CREATE TABLE SALUD.paciente(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.paciente_id_seq'),
	id_usuario BIGINT NOT NULL,
	id_medico_asignado BIGINT NOT NULL,
	nnss CHARACTER(50) NOT NULL,
	num_tarjeta CHARACTER(15) NOT NULL,
	observaciones TEXT,
	telefono CHARACTER(20),
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT fk_paciente_usuario FOREIGN KEY (id_usuario) REFERENCES SALUD.usuario(id),
	CONSTRAINT fk_medico FOREIGN KEY (id_medico_asignado) REFERENCES SALUD.medico(id),
	CONSTRAINT paciente_pk PRIMARY KEY (id),
	CONSTRAINT un_paciente UNIQUE (id)
);

INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'1','1','123456789','665676555','','65544556',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'2','1','433345556','787687687','','65445875',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'3','1','345543345','432454544','','69876765',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'4','2','343145432','345543543','','67878987',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'5','3','435444435','344555334','','63444456',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'6','4','445666554','987876654','','67899898',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'7','4','234556644','987876654','','67899898',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'8','4','433456674','987876654','','67899898',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.PACIENTE VALUES(DEFAULT,'9','4','967665432','987876654','','67899898',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.rol_funcional_id_seq;

CREATE TABLE SALUD.rol_funcional(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.rol_funcional_id_seq'),
	descripcion TEXT NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT rol_funcional_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.rol_funcional VALUES(DEFAULT,'DESACTIVADO',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.rol_funcional VALUES(DEFAULT,'ACTIVADO',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.funcional_id_seq;

CREATE TABLE SALUD.funcional(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.funcional_id_seq'),
	id_usuario BIGINT NOT NULL,
	id_rol BIGINT NOT NULL,
	clave TEXT NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT fk_funcional_usuario FOREIGN KEY (id_usuario) REFERENCES SALUD.usuario(id),
	CONSTRAINT fk_funcional_rol FOREIGN KEY (id_rol) REFERENCES SALUD.rol_funcional(id),
	CONSTRAINT funcional_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.funcional VALUES(DEFAULT,'9','2','0000',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE TABLE SALUD.medico_paciente(
	id_medico BIGINT NOT NULL,
	id_paciente BIGINT NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT medico_paciente_pk PRIMARY KEY (id_medico, id_paciente),
	CONSTRAINT fk_mp_paciente FOREIGN KEY (id_paciente) REFERENCES SALUD.paciente(id),
	CONSTRAINT fk_mp_medico FOREIGN KEY (id_medico) REFERENCES SALUD.medico(id)
);

INSERT INTO SALUD.medico_paciente VALUES('1','1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_paciente VALUES('2','6',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_paciente VALUES('3','7',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_paciente VALUES('4','8',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.historial_paciente_id_seq;

CREATE TABLE SALUD.historial_paciente(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.historial_paciente_id_seq'),
	id_paciente BIGINT NOT NULL UNIQUE,
	historial TEXT NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT fk_historial_paciente FOREIGN KEY (id_paciente) REFERENCES SALUD.paciente(id),
	CONSTRAINT historial_paciente_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'1','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'2','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'3','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'4','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'5','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'6','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'7','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'8','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.historial_paciente VALUES(DEFAULT,'9','diagnostico de prueba',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.estado_cita_id_seq;

CREATE TABLE SALUD.estado_cita(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.estado_cita_id_seq'),
	nombre TEXT not null,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT estado_cita_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.estado_cita VALUES(DEFAULT,'ACTIVO',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.estado_cita VALUES(DEFAULT,'CERRADO',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.estado_cita VALUES(DEFAULT,'CANCELADO',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.cita_id_seq;

CREATE TABLE SALUD.cita( 
	id BIGINT NOT NULL DEFAULT nextval('SALUD.cita_id_seq'),
	id_paciente BIGINT NOT NULL,
	id_medico BIGINT NOT NULL,
	id_historial BIGINT NOT NULL,
	id_estado BIGINT NOT NULL,
	motivo_cita TEXT NOT NULL,
	fecha_hora_cita date NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT cita_pk PRIMARY KEY (id),
	CONSTRAINT fk_paciente_cita FOREIGN KEY (id_paciente) REFERENCES SALUD.paciente(id),
	CONSTRAINT fk_medico_cita FOREIGN KEY (id_medico) REFERENCES SALUD.medico(id),
	CONSTRAINT fk_historial FOREIGN KEY (id_historial) REFERENCES SALUD.historial_paciente(id),
	CONSTRAINT fk_estado FOREIGN KEY (id_estado) REFERENCES SALUD.estado_cita(id)
);

INSERT INTO SALUD.CITA VALUES(DEFAULT,'1','1','1','2','Resfriado',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'2','2','1','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'3','3','2','2','Insuficiencia',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'4','4','3','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'5','1','4','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'6','2','5','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'7','3','6','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'8','4','7','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.CITA VALUES(DEFAULT,'9','1','8','2','Catarro',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.diagnostico_id_seq;

CREATE TABLE SALUD.diagnostico(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.diagnostico_id_seq'),
	id_paciente BIGINT NOT NULL,
	id_historial BIGINT NOT NULL,
	id_cita BIGINT NOT NULL,
	valoracion_especialista TEXT NOT NULL,
	enfermedad TEXT NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,	
	CONSTRAINT diagnostico_pk PRIMARY KEY (id),
	CONSTRAINT fk_diagnostico_paciente FOREIGN KEY (id_paciente) REFERENCES SALUD.paciente(id),
	CONSTRAINT fk_historial_paciente FOREIGN KEY (id_historial) REFERENCES SALUD.historial_paciente(id),
	CONSTRAINT fk_diagnostico_cita FOREIGN KEY (id_cita) REFERENCES SALUD.cita(id)
);

INSERT INTO SALUD.diagnostico values(DEFAULT,'1','1','1','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'2','2','2','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'3','3','3','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'4','4','4','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'5','5','5','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'6','6','6','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'7','7','7','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'8','8','8','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.diagnostico values(DEFAULT,'9','9','9','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
--INSERT INTO SALUD.diagnostico values(DEFAULT,'10','10','Cuadro vírico acompañado de tos','Resfriado común',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


CREATE TABLE SALUD.estado_medicacion

CREATE SEQUENCE SALUD.medicacion_id_seq;

CREATE TABLE SALUD.medicacion(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.medicacion_id_seq'),
	id_paciente BIGINT NOT NULL,
	id_diagnostico BIGINT NOT NULL,
	nombre TEXT NOT NULL,
	frecuencia INT NOT NULL,
	cantidad INT NOT NULL,
	fec_ini date NOT NULL,
	alergico TEXT DEFAULT,
	CHECK ((alergico = 'N') OR (alergico = 'S'))
	fec_fin date NOT NULL,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT medicacion_pk PRIMARY KEY (id),
	CONSTRAINT fk_medicacion_paciente FOREIGN KEY (id) REFERENCES SALUD.paciente(id),
	CONSTRAINT fk_medicacion_diagnostico FOREIGN KEY (id_diagnostico) REFERENCES SALUD.diagnostico(id)
);

INSERT INTO SALUD.medicacion values(DEFAULT,'1','3','Paracetamol 500mg','3','1',NOW(), NOW() + '20 minutes',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medicacion values(DEFAULT,'1','3','Ibuprofeno 1500mg','3','1',NOW(), NOW() + '10 days',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

CREATE SEQUENCE SALUD.horario_id_seq;

CREATE TABLE SALUD.horario(
	id BIGINT DEFAULT nextval('SALUD.horario_id_seq'),
	hor_lun_ini date,
	hor_lun_fin date,
	hor_mar_ini date,
	hor_mar_fin date,
	hor_mie_ini date,
	hor_mie_fin date,
	hor_jue_ini date,
	hor_jue_fin date,
	hor_vie_ini date,
	hor_vie_fin date,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT horario_pk PRIMARY KEY (id)	
);

INSERT INTO SALUD.horario values(DEFAULT,
	TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('15:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('15:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('15:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('15:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('08:00:00', 'HH24:MI:SS'),
	TO_TIMESTAMP('15:00:00', 'HH24:MI:SS'),
	CURRENT_TIMESTAMP,CURRENT_TIMESTAMP
);

CREATE SEQUENCE SALUD.especialidad_id_seq;

CREATE TABLE SALUD.especialidad(
	id BIGINT NOT NULL DEFAULT nextval('SALUD.especialidad_id_seq'),
	nombre CHARACTER(100),
    fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (id)
);

INSERT INTO SALUD.especialidad values(DEFAULT,'Doctor en atención primaria',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.especialidad values(DEFAULT,'CARDIOLOGIA',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.especialidad values(DEFAULT,'UROLOGIA',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.especialidad values(DEFAULT,'ENDOCRINOLOGIA',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);


CREATE SEQUENCE SALUD.medico_especialidad_id_seq;

CREATE TABLE SALUD.medico_especialidad(
	id BIGINT NOT NULL UNIQUE DEFAULT nextval('SALUD.medico_especialidad_id_seq'), 
	id_medico BIGINT not null UNIQUE,
	id_especialidad BIGINT not null,
	id_horario BIGINT not null,
	fecha_creacion date NOT NULL,
	fecha_modificacion date NOT NULL,
	CONSTRAINT medico_especialidad_pk PRIMARY KEY (id),
	CONSTRAINT fk_medico_medico_especialidad FOREIGN KEY (id_medico) REFERENCES SALUD.medico(id),
	CONSTRAINT fk_horario_medico_especialidad FOREIGN KEY (id_horario) REFERENCES SALUD.horario(id),
	CONSTRAINT fk_especialidad_medico_especialidad FOREIGN KEY (id_especialidad) REFERENCES SALUD.especialidad(id)
);

INSERT INTO SALUD.medico_especialidad values(DEFAULT,'1','1','1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_especialidad values(DEFAULT,'2','2','1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_especialidad values(DEFAULT,'3','3','1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);
INSERT INTO SALUD.medico_especialidad values(DEFAULT,'4','4','1',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP);

GRANT CONNECT ON DATABASE salud TO salud;
GRANT USAGE ON SCHEMA salud TO salud;
GRANT SELECT, INSERT, UPDATE ON ALL TABLES IN SCHEMA salud TO salud;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA salud TO salud;

GRANT SELECT ON salud.cita TO salud;
GRANT SELECT ON SALUD.medico_especialidad TO salud;
GRANT SELECT ON SALUD.especialidad TO salud;
GRANT SELECT ON SALUD.horario TO salud;
GRANT SELECT ON SALUD.historial_paciente TO salud;
GRANT SELECT ON SALUD.estado_cita TO salud;
GRANT SELECT ON salud.diagnostico TO salud;
GRANT SELECT ON salud.medico TO salud;
GRANT SELECT ON salud.medico_paciente TO salud;
GRANT SELECT ON salud.paciente TO salud;
GRANT SELECT ON salud.usuario TO salud;
GRANT SELECT ON salud.historial_paciente TO salud;
GRANT SELECT ON SALUD.funcional TO salud;
GRANT SELECT ON SALUD.rol_funcional TO salud;
GRANT SELECT ON salud.usuario TO salud;


CREATE USER readonly WITH ENCRYPTED PASSWORD 'readonly';
ALTER USER readonly WITH PASSWORD '0000';
GRANT USAGE ON SCHEMA salud to readonly; 
ALTER DEFAULT PRIVILEGES IN SCHEMA salud GRANT SELECT ON TABLES TO readonly; 