--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2022-11-28 09:56:28

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 228 (class 1259 OID 16590)
-- Name: address; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.address (
    id integer NOT NULL,
    addresstitleid integer NOT NULL,
    cityid integer NOT NULL,
    street character varying NOT NULL,
    customerid integer NOT NULL
);


ALTER TABLE public.address OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16589)
-- Name: address_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.address ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 230 (class 1259 OID 16598)
-- Name: addresstitle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.addresstitle (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.addresstitle OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16597)
-- Name: addresstitle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.addresstitle ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.addresstitle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 240 (class 1259 OID 16634)
-- Name: cargo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cargo (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.cargo OWNER TO postgres;

--
-- TOC entry 239 (class 1259 OID 16633)
-- Name: cargo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.cargo ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cargo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 16552)
-- Name: categories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.categories OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16574)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.categories ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 232 (class 1259 OID 16606)
-- Name: city; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.city OWNER TO postgres;

--
-- TOC entry 231 (class 1259 OID 16605)
-- Name: city_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.city ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 214 (class 1259 OID 16538)
-- Name: colors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colors (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.colors OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16573)
-- Name: colors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.colors ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.colors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 16576)
-- Name: colorsizerelations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.colorsizerelations (
    id integer NOT NULL,
    colorid integer NOT NULL,
    sizeid integer NOT NULL
);


ALTER TABLE public.colorsizerelations OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16575)
-- Name: colorsizerelations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.colorsizerelations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.colorsizerelations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16582)
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    id integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    phonenumber character varying NOT NULL
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16581)
-- Name: customers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.customers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 238 (class 1259 OID 16628)
-- Name: moneytype; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.moneytype (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE public.moneytype OWNER TO postgres;

--
-- TOC entry 237 (class 1259 OID 16627)
-- Name: moneytype_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.moneytype ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.moneytype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 234 (class 1259 OID 16614)
-- Name: orders; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.orders (
    id integer NOT NULL,
    date date NOT NULL,
    customerid integer NOT NULL,
    addressid integer NOT NULL,
    paymentid integer NOT NULL,
    cargoid integer NOT NULL,
    productid integer
);


ALTER TABLE public.orders OWNER TO postgres;

--
-- TOC entry 233 (class 1259 OID 16613)
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 236 (class 1259 OID 16620)
-- Name: payment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.payment (
    id integer NOT NULL,
    moneytypeid integer
);


ALTER TABLE public.payment OWNER TO postgres;

--
-- TOC entry 235 (class 1259 OID 16619)
-- Name: payment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.payment ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 219 (class 1259 OID 16567)
-- Name: productcategories; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.productcategories (
    id integer NOT NULL,
    categoryid integer NOT NULL,
    productid integer NOT NULL
);


ALTER TABLE public.productcategories OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16566)
-- Name: productcategories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.productcategories ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.productcategories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 217 (class 1259 OID 16559)
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying NOT NULL,
    unitprice money NOT NULL,
    stock integer NOT NULL,
    colorsizeid integer NOT NULL
);


ALTER TABLE public.products OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16572)
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 215 (class 1259 OID 16545)
-- Name: size; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.size (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE public.size OWNER TO postgres;

--
-- TOC entry 241 (class 1259 OID 16718)
-- Name: size_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.size ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3436 (class 0 OID 16590)
-- Dependencies: 228
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (2, 1, 3, 'aydogdu', 1);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (3, 2, 1, 'sancak', 2);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (4, 6, 4, 'bmahallesi', 3);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (5, 7, 2, 'amahallesi', 4);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (6, 2, 1, 'barcelonamah', 5);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (7, 2, 4, 'barcelonamah', 6);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (8, 1, 4, 'barcelonamah', 7);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (10, 1, 4, 'madridmah', 9);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (11, 2, 3, 'madridmah', 10);
INSERT INTO public.address (id, addresstitleid, cityid, street, customerid) OVERRIDING SYSTEM VALUE VALUES (9, 1, 4, 'madridmah', 9);


--
-- TOC entry 3438 (class 0 OID 16598)
-- Dependencies: 230
-- Data for Name: addresstitle; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.addresstitle (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'home');
INSERT INTO public.addresstitle (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'office');
INSERT INTO public.addresstitle (id, name) OVERRIDING SYSTEM VALUE VALUES (6, 'hospital');
INSERT INTO public.addresstitle (id, name) OVERRIDING SYSTEM VALUE VALUES (7, 'school');


--
-- TOC entry 3448 (class 0 OID 16634)
-- Dependencies: 240
-- Data for Name: cargo; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'ups');
INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'yurtici');
INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'mng');
INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'ptt');
INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (5, 'getir');
INSERT INTO public.cargo (id, name) OVERRIDING SYSTEM VALUE VALUES (6, 'aras');


--
-- TOC entry 3424 (class 0 OID 16552)
-- Dependencies: 216
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'summer');
INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'winter');
INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'bottomclothing');
INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'tops');
INSERT INTO public.categories (id, name) OVERRIDING SYSTEM VALUE VALUES (5, 'underwear');


--
-- TOC entry 3440 (class 0 OID 16606)
-- Dependencies: 232
-- Data for Name: city; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'bursa');
INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'izmir');
INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'ankara');
INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'istanbul');
INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (5, 'konya');
INSERT INTO public.city (id, name) OVERRIDING SYSTEM VALUE VALUES (6, 'antalya');


--
-- TOC entry 3422 (class 0 OID 16538)
-- Dependencies: 214
-- Data for Name: colors; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'yellow');
INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'red');
INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'blue');
INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'green');
INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (5, 'purple');
INSERT INTO public.colors (id, name) OVERRIDING SYSTEM VALUE VALUES (6, 'black');


--
-- TOC entry 3432 (class 0 OID 16576)
-- Dependencies: 224
-- Data for Name: colorsizerelations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.colorsizerelations (id, colorid, sizeid) OVERRIDING SYSTEM VALUE VALUES (1, 2, 2);
INSERT INTO public.colorsizerelations (id, colorid, sizeid) OVERRIDING SYSTEM VALUE VALUES (2, 1, 3);
INSERT INTO public.colorsizerelations (id, colorid, sizeid) OVERRIDING SYSTEM VALUE VALUES (3, 2, 4);
INSERT INTO public.colorsizerelations (id, colorid, sizeid) OVERRIDING SYSTEM VALUE VALUES (4, 4, 1);
INSERT INTO public.colorsizerelations (id, colorid, sizeid) OVERRIDING SYSTEM VALUE VALUES (5, 3, 3);


--
-- TOC entry 3434 (class 0 OID 16582)
-- Dependencies: 226
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (1, 'Berat Kubilay', 'Artvin', '555666777');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (2, 'Hakan', 'Cetin', '555879846');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (3, 'Ibrahim Ethem', 'Sancar', '555477889');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (4, 'Ahmet', 'Mehmet', '575757575');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (5, 'Ali', 'Veli', '585757574');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (6, 'Ayse', 'Fatma', '555587515');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (7, 'Cristiano ', 'Ronaldo Suwii', '777777454');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (8, 'Lionel ', 'Messi', '101010149');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (9, 'Volkan', 'Demirel', '457575759');
INSERT INTO public.customers (id, firstname, lastname, phonenumber) OVERRIDING SYSTEM VALUE VALUES (10, 'Arda', 'Turan', '473737344');


--
-- TOC entry 3446 (class 0 OID 16628)
-- Dependencies: 238
-- Data for Name: moneytype; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.moneytype (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'crypto');
INSERT INTO public.moneytype (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'paypal
');
INSERT INTO public.moneytype (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'creditcard');
INSERT INTO public.moneytype (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'cash');
INSERT INTO public.moneytype (id, name) OVERRIDING SYSTEM VALUE VALUES (5, 'ticket');


--
-- TOC entry 3442 (class 0 OID 16614)
-- Dependencies: 234
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (6, '2022-11-24', 1, 2, 1, 3, 4);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (8, '2022-11-23', 3, 4, 5, 2, 4);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (9, '2022-11-20', 4, 3, 2, 1, 5);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (10, '2022-11-18', 4, 3, 3, 5, 5);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (11, '2022-11-19', 2, 2, 4, 4, 6);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (12, '2022-11-25', 6, 9, 3, 5, 7);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (13, '2022-11-25', 7, 2, 1, 4, 9);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (14, '2022-11-25', 8, 5, 2, 3, 8);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (15, '2022-11-25', 9, 9, 4, 2, 8);
INSERT INTO public.orders (id, date, customerid, addressid, paymentid, cargoid, productid) OVERRIDING SYSTEM VALUE VALUES (16, '2022-11-25', 10, 11, 4, 1, 4);


--
-- TOC entry 3444 (class 0 OID 16620)
-- Dependencies: 236
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.payment (id, moneytypeid) OVERRIDING SYSTEM VALUE VALUES (1, 4);
INSERT INTO public.payment (id, moneytypeid) OVERRIDING SYSTEM VALUE VALUES (2, 2);
INSERT INTO public.payment (id, moneytypeid) OVERRIDING SYSTEM VALUE VALUES (3, 3);
INSERT INTO public.payment (id, moneytypeid) OVERRIDING SYSTEM VALUE VALUES (4, 4);
INSERT INTO public.payment (id, moneytypeid) OVERRIDING SYSTEM VALUE VALUES (5, 4);


--
-- TOC entry 3427 (class 0 OID 16567)
-- Dependencies: 219
-- Data for Name: productcategories; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (6, 1, 4);
INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (7, 4, 5);
INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (8, 2, 6);
INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (9, 3, 4);
INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (10, 3, 7);
INSERT INTO public.productcategories (id, categoryid, productid) OVERRIDING SYSTEM VALUE VALUES (11, 2, 8);


--
-- TOC entry 3425 (class 0 OID 16559)
-- Dependencies: 217
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (4, 'tshirt', '£50.00', 65, 2);
INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (5, 'jean', '£15.00', 25, 4);
INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (6, 'coat', '£75.00', 56, 3);
INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (7, 'short', '£115.00', 35, 1);
INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (8, 'boxer', '£25.00', 90, 1);
INSERT INTO public.products (id, name, unitprice, stock, colorsizeid) OVERRIDING SYSTEM VALUE VALUES (9, 'sweat', '£85.00', 65, 5);


--
-- TOC entry 3423 (class 0 OID 16545)
-- Dependencies: 215
-- Data for Name: size; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.size (id, name) OVERRIDING SYSTEM VALUE VALUES (1, 'small');
INSERT INTO public.size (id, name) OVERRIDING SYSTEM VALUE VALUES (2, 'medium');
INSERT INTO public.size (id, name) OVERRIDING SYSTEM VALUE VALUES (3, 'large');
INSERT INTO public.size (id, name) OVERRIDING SYSTEM VALUE VALUES (4, 'xlarge');


--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 227
-- Name: address_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.address_id_seq', 11, true);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 229
-- Name: addresstitle_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.addresstitle_id_seq', 7, true);


--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 239
-- Name: cargo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cargo_id_seq', 6, true);


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 222
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categories_id_seq', 5, true);


--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 231
-- Name: city_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.city_id_seq', 6, true);


--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 221
-- Name: colors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.colors_id_seq', 6, true);


--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 223
-- Name: colorsizerelations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.colorsizerelations_id_seq', 5, true);


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 225
-- Name: customers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_id_seq', 11, true);


--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 237
-- Name: moneytype_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.moneytype_id_seq', 5, true);


--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 233
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.orders_id_seq', 16, true);


--
-- TOC entry 3465 (class 0 OID 0)
-- Dependencies: 235
-- Name: payment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.payment_id_seq', 5, true);


--
-- TOC entry 3466 (class 0 OID 0)
-- Dependencies: 218
-- Name: productcategories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.productcategories_id_seq', 11, true);


--
-- TOC entry 3467 (class 0 OID 0)
-- Dependencies: 220
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 10, true);


--
-- TOC entry 3468 (class 0 OID 0)
-- Dependencies: 241
-- Name: size_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.size_id_seq', 4, true);


--
-- TOC entry 3253 (class 2606 OID 16596)
-- Name: address address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);


--
-- TOC entry 3255 (class 2606 OID 16604)
-- Name: addresstitle addresstitle_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.addresstitle
    ADD CONSTRAINT addresstitle_pkey PRIMARY KEY (id);


--
-- TOC entry 3265 (class 2606 OID 16640)
-- Name: cargo cargo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);


--
-- TOC entry 3243 (class 2606 OID 16558)
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- TOC entry 3257 (class 2606 OID 16612)
-- Name: city city_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);


--
-- TOC entry 3239 (class 2606 OID 16544)
-- Name: colors colors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colors
    ADD CONSTRAINT colors_pkey PRIMARY KEY (id);


--
-- TOC entry 3249 (class 2606 OID 16580)
-- Name: colorsizerelations colorsizerelations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT colorsizerelations_pkey PRIMARY KEY (id);


--
-- TOC entry 3251 (class 2606 OID 16588)
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- TOC entry 3263 (class 2606 OID 16632)
-- Name: moneytype moneytype_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.moneytype
    ADD CONSTRAINT moneytype_pkey PRIMARY KEY (id);


--
-- TOC entry 3259 (class 2606 OID 16618)
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- TOC entry 3261 (class 2606 OID 16626)
-- Name: payment payment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);


--
-- TOC entry 3247 (class 2606 OID 16571)
-- Name: productcategories productcategories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT productcategories_pkey PRIMARY KEY (id);


--
-- TOC entry 3245 (class 2606 OID 16565)
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- TOC entry 3241 (class 2606 OID 16551)
-- Name: size size_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.size
    ADD CONSTRAINT size_pkey PRIMARY KEY (id);


--
-- TOC entry 3274 (class 2606 OID 16696)
-- Name: orders addressid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "addressid-fk" FOREIGN KEY (addressid) REFERENCES public.address(id) NOT VALID;


--
-- TOC entry 3271 (class 2606 OID 16671)
-- Name: address addresstitleid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT "addresstitleid-fk" FOREIGN KEY (addresstitleid) REFERENCES public.addresstitle(id) NOT VALID;


--
-- TOC entry 3275 (class 2606 OID 16706)
-- Name: orders cargoid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "cargoid-fk" FOREIGN KEY (cargoid) REFERENCES public.cargo(id) NOT VALID;


--
-- TOC entry 3267 (class 2606 OID 16656)
-- Name: productcategories categoryid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT "categoryid-fk" FOREIGN KEY (categoryid) REFERENCES public.categories(id) NOT VALID;


--
-- TOC entry 3272 (class 2606 OID 16676)
-- Name: address cityif-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT "cityif-fk" FOREIGN KEY (cityid) REFERENCES public.city(id) NOT VALID;


--
-- TOC entry 3269 (class 2606 OID 16641)
-- Name: colorsizerelations colorid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT "colorid-fk" FOREIGN KEY (colorid) REFERENCES public.colors(id) NOT VALID;


--
-- TOC entry 3266 (class 2606 OID 16666)
-- Name: products colorsizeid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT "colorsizeid-fk" FOREIGN KEY (colorsizeid) REFERENCES public.colorsizerelations(id) NOT VALID;


--
-- TOC entry 3273 (class 2606 OID 16681)
-- Name: address customerid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.address
    ADD CONSTRAINT "customerid-fk" FOREIGN KEY (customerid) REFERENCES public.customers(id) NOT VALID;


--
-- TOC entry 3276 (class 2606 OID 16691)
-- Name: orders customerid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "customerid-fk" FOREIGN KEY (customerid) REFERENCES public.customers(id) NOT VALID;


--
-- TOC entry 3279 (class 2606 OID 16713)
-- Name: payment moneytypeid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.payment
    ADD CONSTRAINT "moneytypeid-fk" FOREIGN KEY (moneytypeid) REFERENCES public.moneytype(id) NOT VALID;


--
-- TOC entry 3277 (class 2606 OID 16701)
-- Name: orders paymentid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "paymentid-fk" FOREIGN KEY (paymentid) REFERENCES public.payment(id) NOT VALID;


--
-- TOC entry 3268 (class 2606 OID 16661)
-- Name: productcategories productid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT "productid-fk" FOREIGN KEY (productid) REFERENCES public.products(id) NOT VALID;


--
-- TOC entry 3278 (class 2606 OID 16725)
-- Name: orders productid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "productid-fk" FOREIGN KEY (productid) REFERENCES public.products(id) NOT VALID;


--
-- TOC entry 3270 (class 2606 OID 16719)
-- Name: colorsizerelations sizeid-fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT "sizeid-fk" FOREIGN KEY (sizeid) REFERENCES public.size(id) NOT VALID;


-- Completed on 2022-11-28 09:56:28

--
-- PostgreSQL database dump complete
--

