--Create table devices
CREATE TABLE devices(
    id serial NOT NULL,
    created_at timestamp without time zone DEFAULT now(),
    altered_at timestamp without time zone,
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
    created_at timestamp without time zone DEFAULT now(),
    altered_at timestamp without time zone,
    voltage double precision DEFAULT 0,
    current double precision DEFAULT 0,
    energy double precision DEFAULT 0,
    power double precision DEFAULT 0,
    angle double precision DEFAULT 0,
    devices_id bigint NOT NULL,
    CONSTRAINT measures_pkey PRIMARY KEY (id),
    CONSTRAINT measures_fkey FOREIGN KEY (devices_id) REFERENCES devices(id)
);
