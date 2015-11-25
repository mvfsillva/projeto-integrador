--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5beta2
-- Dumped by pg_dump version 9.5beta2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE person (
    id_person integer NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE person OWNER TO postgres;

--
-- Name: sq_person_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_person_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_person_id OWNER TO postgres;

--
-- Name: sq_user_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sq_user_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sq_user_id OWNER TO postgres;

--
-- Name: system_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE system_user (
    id_address integer NOT NULL,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE system_user OWNER TO postgres;

--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY person (id_person, name) FROM stdin;
\.


--
-- Name: sq_person_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_person_id', 2, true);


--
-- Name: sq_user_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sq_user_id', 2, true);


--
-- Data for Name: system_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY system_user (id_address, password, username) FROM stdin;
\.


--
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id_person);


--
-- Name: system_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY system_user
    ADD CONSTRAINT system_user_pkey PRIMARY KEY (id_address);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

