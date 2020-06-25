--Create table devices
CREATE TABLE devices(
    id serial NOT NULL,
    registry_date timestamp without time zone,
    date_last_alter timestamp without time zone,
    date_activation timestamp without time zone,
    device character varying(255),
    token character varying(255) NOT NULL UNIQUE ,
    local character varying(255),
    status integer,
    CONSTRAINT devices_pkey PRIMARY KEY (id)
);

-- TODO: create table measure
CREATE TABLE measures(
    id serial NOT NULL,
    registry_date timestamp without time zone,
    tensao float8,
    corrente float8,
    energia float8,
    potencia float8,
    angulo float8,
    devices_id bigint NOT NULL,
    CONSTRAINT measures_pkey PRIMARY KEY (id),
    CONSTRAINT measures_fkey FOREIGN KEY (devices_id) REFERENCES devices(id)
);
