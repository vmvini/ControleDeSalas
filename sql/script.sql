--DATABASE NAME : controleDeSala
--DATABASE OWNER: postgres
--password: 123456
CREATE TABLE usertype (
    id integer NOT NULL,
    nome character varying(45) NOT NULL
);
ALTER TABLE ONLY usertype
    ADD CONSTRAINT usertype_pkey PRIMARY KEY (id);
	
INSERT INTO usertype (id, nome) VALUES (2, 'ASSISTANT');
INSERT INTO usertype (id, nome) VALUES (3, 'ADMIN');
INSERT INTO usertype (id, nome) VALUES (1, 'TEACHER');

CREATE TABLE usuario (
    login character varying(45) NOT NULL,
    password character varying(45) NOT NULL,
    email character varying(45) NOT NULL,
    unidadeacademica character varying(45),
    matricula character varying(45) NOT NULL,
    tipo integer NOT NULL
);

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (matricula);
	
ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_tipo_fkey FOREIGN KEY (tipo) REFERENCES usertype(id) ON UPDATE CASCADE ON DELETE CASCADE;

	


