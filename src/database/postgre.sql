CREATE SEQUENCE users_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
  
CREATE TABLE users (
  id bigint NOT NULL DEFAULT nextval('users_id_seq'::regclass),
  username varchar(50) NOT NULL UNIQUE,
  password varchar(255) NOT NULL,
  firstname varchar(255) NOT NULL,
  lastname varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  enabled varchar(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
);

CREATE SEQUENCE authorities_id_seq
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 0
  CACHE 1;
  
CREATE TABLE authorities (
  id bigint NOT NULL DEFAULT nextval('authorities_id_seq'::regclass),
  user_id bigint NOT NULL,
  authority varchar(50) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_authorities_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO users VALUES (1,'ROOT','21232f297a57a5a743894a0e4a801fc3','ROOT','','ROOT@ROOT',1),(2,'anishekm','21232f297a57a5a743894a0e4a801fc3','Aneesh','Antony','aneesh.antony@tatacommunications.com',0);
INSERT INTO authorities VALUES (1,2,'ROLE_USER'),(2,1,'ROLE_ADMIN'),(3,1,'ROLE_USER');