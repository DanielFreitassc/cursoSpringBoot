CREATE TABLE IF NOT EXISTS public.person
(
    id bigint NOT NULL DEFAULT nextval('person_id_seq'::regclass),
    address character varying(100) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    gender character varying(6) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(80) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT person_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.person
    OWNER to postgres;
