--
-- PostgreSQL database dump
--

-- Dumped from database version 12.4
-- Dumped by pg_dump version 12.4

-- Started on 2020-10-20 21:13:05


--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

--CREATE SCHEMA public;


--ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2998 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = 'DATA';

SET default_table_access_method = heap;

--
-- TOC entry 207 (class 1259 OID 16682)
-- Name: Empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Empleado" (
    id_empleado integer NOT NULL,
    id_tienda integer NOT NULL,
    pnombre character varying(30) NOT NULL,
    snombre character varying(30),
    tnombre character varying(30),
    papelli character varying(30) NOT NULL,
    sapelli character varying(30),
    capelli character varying(30),
    id_estado integer NOT NULL,
    fec_alta date NOT NULL,
    "fec_Baja" date
);


ALTER TABLE public."Empleado" OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16680)
-- Name: Empleado_id_empleado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Empleado_id_empleado_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Empleado_id_empleado_seq" OWNER TO postgres;

--
-- TOC entry 3000 (class 0 OID 0)
-- Dependencies: 206
-- Name: Empleado_id_empleado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Empleado_id_empleado_seq" OWNED BY public."Empleado".id_empleado;


--
-- TOC entry 212 (class 1259 OID 16703)
-- Name: Estado_Empleado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Estado_Empleado" (
    id_estado integer NOT NULL,
    des_estado character varying(30) NOT NULL
);


ALTER TABLE public."Estado_Empleado" OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16701)
-- Name: Estado_Empleado_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Estado_Empleado_id_estado_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Estado_Empleado_id_estado_seq" OWNER TO postgres;

--
-- TOC entry 3002 (class 0 OID 0)
-- Dependencies: 211
-- Name: Estado_Empleado_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Estado_Empleado_id_estado_seq" OWNED BY public."Estado_Empleado".id_estado;


--
-- TOC entry 210 (class 1259 OID 16696)
-- Name: Inventario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Inventario" (
    id_tienda integer NOT NULL,
    id_producto integer NOT NULL,
    saldo numeric(12,2) NOT NULL
);


ALTER TABLE public."Inventario" OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 16737)
-- Name: Menu; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Menu" (
    id_menu integer NOT NULL,
    descripcion character varying(255) NOT NULL,
    id_menu_padre integer NOT NULL,
    url character varying(255) NOT NULL
);


ALTER TABLE public."Menu" OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16754)
-- Name: Menu_Rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Menu_Rol" (
    id_menu integer NOT NULL,
    id_rol integer NOT NULL
);


ALTER TABLE public."Menu_Rol" OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16735)
-- Name: Menu_id_menu_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Menu_id_menu_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Menu_id_menu_seq" OWNER TO postgres;

--
-- TOC entry 3006 (class 0 OID 0)
-- Dependencies: 219
-- Name: Menu_id_menu_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Menu_id_menu_seq" OWNED BY public."Menu".id_menu;


--
-- TOC entry 214 (class 1259 OID 16714)
-- Name: Periodo_Contable; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Periodo_Contable" (
    anio integer NOT NULL,
    id_periodo integer NOT NULL,
    "fec_Inicio" date NOT NULL,
    "fec_Fin" date NOT NULL,
    cerrado integer NOT NULL
);


ALTER TABLE public."Periodo_Contable" OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16666)
-- Name: Producto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Producto" (
    id_producto integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    "paraVenta" integer NOT NULL,
    "esProducido" integer NOT NULL
);


ALTER TABLE public."Producto" OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16664)
-- Name: Producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Producto_id_producto_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Producto_id_producto_seq" OWNER TO postgres;

--
-- TOC entry 3009 (class 0 OID 0)
-- Dependencies: 202
-- Name: Producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Producto_id_producto_seq" OWNED BY public."Producto".id_producto;


--
-- TOC entry 228 (class 1259 OID 16828)
-- Name: Proveedor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Proveedor" (
    id_proveedor integer NOT NULL,
    nombre character varying(255)
);


ALTER TABLE public."Proveedor" OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16826)
-- Name: Proveedor_id_proveedor_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Proveedor_id_proveedor_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Proveedor_id_proveedor_seq" OWNER TO postgres;

--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 227
-- Name: Proveedor_id_proveedor_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Proveedor_id_proveedor_seq" OWNED BY public."Proveedor".id_proveedor;


--
-- TOC entry 217 (class 1259 OID 16727)
-- Name: Receta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Receta" (
    id_producto_salida integer NOT NULL
);


ALTER TABLE public."Receta" OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16732)
-- Name: Receta_Detalle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Receta_Detalle" (
    id_producto_salida integer NOT NULL,
    id_producto_entrada integer NOT NULL,
    cantidad numeric(12,2) NOT NULL
);


ALTER TABLE public."Receta_Detalle" OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 16748)
-- Name: Rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Rol" (
    id_rol integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    activo integer NOT NULL
);


ALTER TABLE public."Rol" OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16746)
-- Name: Rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Rol_id_rol_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Rol_id_rol_seq" OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 221
-- Name: Rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Rol_id_rol_seq" OWNED BY public."Rol".id_rol;


--
-- TOC entry 205 (class 1259 OID 16674)
-- Name: Tienda; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Tienda" (
    id_tienda integer NOT NULL,
    dir_tienda character varying(50) NOT NULL,
    tel_tienda character varying(50) NOT NULL
);


ALTER TABLE public."Tienda" OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16672)
-- Name: Tienda_id_tienda_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Tienda_id_tienda_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Tienda_id_tienda_seq" OWNER TO postgres;

--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 204
-- Name: Tienda_id_tienda_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Tienda_id_tienda_seq" OWNED BY public."Tienda".id_tienda;


--
-- TOC entry 230 (class 1259 OID 16841)
-- Name: Tipo_Documento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Tipo_Documento" (
    id_tipo_docto integer NOT NULL,
    descripcion character varying(100)
);


ALTER TABLE public."Tipo_Documento" OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16839)
-- Name: Tipo_Documento_id_tipo_docto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Tipo_Documento_id_tipo_docto_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Tipo_Documento_id_tipo_docto_seq" OWNER TO postgres;

--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 229
-- Name: Tipo_Documento_id_tipo_docto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Tipo_Documento_id_tipo_docto_seq" OWNED BY public."Tipo_Documento".id_tipo_docto;


--
-- TOC entry 216 (class 1259 OID 16721)
-- Name: Tipo_Transaccion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Tipo_Transaccion" (
    id_tipo integer NOT NULL,
    descripcion character varying(100) NOT NULL,
    factor integer NOT NULL
);


ALTER TABLE public."Tipo_Transaccion" OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16690)
-- Name: Transaccion_Inventario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Transaccion_Inventario" (
    id_transaccion integer NOT NULL,
    id_empleado integer NOT NULL,
    id_tienda integer NOT NULL,
    id_tipo integer NOT NULL,
    anio integer NOT NULL,
    id_periodo integer NOT NULL,
    fec_transa date NOT NULL,
    transaccion_origen integer NOT NULL,
    id_proveedor integer,
    id_tipo_docto integer,
    docto_referencia character varying(100)
);


ALTER TABLE public."Transaccion_Inventario" OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16709)
-- Name: Transaccion_Inventario_Det; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Transaccion_Inventario_Det" (
    id_transaccion integer NOT NULL,
    id_linea integer NOT NULL,
    id_producto integer NOT NULL,
    unidades numeric(12,2) NOT NULL,
    costo_unitario numeric(12,2) NOT NULL,
    costo_total numeric(12,2) NOT NULL
);


ALTER TABLE public."Transaccion_Inventario_Det" OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16688)
-- Name: Transaccion_Inventario_id_transaccion_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Transaccion_Inventario_id_transaccion_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Transaccion_Inventario_id_transaccion_seq" OWNER TO postgres;

--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 208
-- Name: Transaccion_Inventario_id_transaccion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Transaccion_Inventario_id_transaccion_seq" OWNED BY public."Transaccion_Inventario".id_transaccion;


--
-- TOC entry 225 (class 1259 OID 16759)
-- Name: Usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Usuario" (
    id_usuario integer NOT NULL,
    usuario character varying(255) NOT NULL,
    contrasenia character varying(255) NOT NULL,
    id_empleado integer NOT NULL
);


ALTER TABLE public."Usuario" OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 16768)
-- Name: Usuario_Rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Usuario_Rol" (
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL
);


ALTER TABLE public."Usuario_Rol" OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 16757)
-- Name: Usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Usuario_id_usuario_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Usuario_id_usuario_seq" OWNER TO postgres;

--
-- TOC entry 3026 (class 0 OID 0)
-- Dependencies: 224
-- Name: Usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Usuario_id_usuario_seq" OWNED BY public."Usuario".id_usuario;


--
-- TOC entry 215 (class 1259 OID 16719)
-- Name: tipo_transaccion_id_tipo_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_transaccion_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_transaccion_id_tipo_seq OWNER TO postgres;

--
-- TOC entry 3027 (class 0 OID 0)
-- Dependencies: 215
-- Name: tipo_transaccion_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_transaccion_id_tipo_seq OWNED BY public."Tipo_Transaccion".id_tipo;


--
-- TOC entry 2780 (class 2604 OID 16685)
-- Name: Empleado id_empleado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Empleado" ALTER COLUMN id_empleado SET DEFAULT nextval('public."Empleado_id_empleado_seq"'::regclass);


--
-- TOC entry 2782 (class 2604 OID 16706)
-- Name: Estado_Empleado id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estado_Empleado" ALTER COLUMN id_estado SET DEFAULT nextval('public."Estado_Empleado_id_estado_seq"'::regclass);


--
-- TOC entry 2784 (class 2604 OID 16740)
-- Name: Menu id_menu; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu" ALTER COLUMN id_menu SET DEFAULT nextval('public."Menu_id_menu_seq"'::regclass);


--
-- TOC entry 2778 (class 2604 OID 16669)
-- Name: Producto id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Producto" ALTER COLUMN id_producto SET DEFAULT nextval('public."Producto_id_producto_seq"'::regclass);


--
-- TOC entry 2787 (class 2604 OID 16831)
-- Name: Proveedor id_proveedor; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Proveedor" ALTER COLUMN id_proveedor SET DEFAULT nextval('public."Proveedor_id_proveedor_seq"'::regclass);


--
-- TOC entry 2785 (class 2604 OID 16751)
-- Name: Rol id_rol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Rol" ALTER COLUMN id_rol SET DEFAULT nextval('public."Rol_id_rol_seq"'::regclass);


--
-- TOC entry 2779 (class 2604 OID 16677)
-- Name: Tienda id_tienda; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tienda" ALTER COLUMN id_tienda SET DEFAULT nextval('public."Tienda_id_tienda_seq"'::regclass);


--
-- TOC entry 2788 (class 2604 OID 16844)
-- Name: Tipo_Documento id_tipo_docto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tipo_Documento" ALTER COLUMN id_tipo_docto SET DEFAULT nextval('public."Tipo_Documento_id_tipo_docto_seq"'::regclass);


--
-- TOC entry 2783 (class 2604 OID 16724)
-- Name: Tipo_Transaccion id_tipo; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tipo_Transaccion" ALTER COLUMN id_tipo SET DEFAULT nextval('public.tipo_transaccion_id_tipo_seq'::regclass);


--
-- TOC entry 2781 (class 2604 OID 16693)
-- Name: Transaccion_Inventario id_transaccion; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario" ALTER COLUMN id_transaccion SET DEFAULT nextval('public."Transaccion_Inventario_id_transaccion_seq"'::regclass);


--
-- TOC entry 2786 (class 2604 OID 16762)
-- Name: Usuario id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario" ALTER COLUMN id_usuario SET DEFAULT nextval('public."Usuario_id_usuario_seq"'::regclass);


--
-- TOC entry 2969 (class 0 OID 16682)
-- Dependencies: 207
-- Data for Name: Empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Empleado" (id_empleado, id_tienda, pnombre, snombre, tnombre, papelli, sapelli, capelli, id_estado, fec_alta, "fec_Baja") FROM stdin;
2	1	VICTOR	\N	\N	DUBÓN	\N	\N	1	2020-10-19	\N
3	1	SELVIN	\N	\N	CASTELLANOS	\N	\N	1	2020-10-19	\N
4	1	GARI	\N	\N	MENDOZA	\N	\N	1	2020-10-19	\N
5	1	ELIZABETH	\N	\N	MEJIA	\N	\N	1	2020-10-19	\N
\.


--
-- TOC entry 2974 (class 0 OID 16703)
-- Dependencies: 212
-- Data for Name: Estado_Empleado; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Estado_Empleado" (id_estado, des_estado) FROM stdin;
1	ACTIVO
2	BAJA
\.


--
-- TOC entry 2972 (class 0 OID 16696)
-- Dependencies: 210
-- Data for Name: Inventario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Inventario" (id_tienda, id_producto, saldo) FROM stdin;
\.


--
-- TOC entry 2982 (class 0 OID 16737)
-- Dependencies: 220
-- Data for Name: Menu; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Menu" (id_menu, descripcion, id_menu_padre, url) FROM stdin;
\.


--
-- TOC entry 2985 (class 0 OID 16754)
-- Dependencies: 223
-- Data for Name: Menu_Rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Menu_Rol" (id_menu, id_rol) FROM stdin;
\.


--
-- TOC entry 2976 (class 0 OID 16714)
-- Dependencies: 214
-- Data for Name: Periodo_Contable; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Periodo_Contable" (anio, id_periodo, "fec_Inicio", "fec_Fin", cerrado) FROM stdin;
\.


--
-- TOC entry 2965 (class 0 OID 16666)
-- Dependencies: 203
-- Data for Name: Producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Producto" (id_producto, descripcion, "paraVenta", "esProducido") FROM stdin;
\.


--
-- TOC entry 2990 (class 0 OID 16828)
-- Dependencies: 228
-- Data for Name: Proveedor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Proveedor" (id_proveedor, nombre) FROM stdin;
\.


--
-- TOC entry 2979 (class 0 OID 16727)
-- Dependencies: 217
-- Data for Name: Receta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Receta" (id_producto_salida) FROM stdin;
\.


--
-- TOC entry 2980 (class 0 OID 16732)
-- Dependencies: 218
-- Data for Name: Receta_Detalle; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Receta_Detalle" (id_producto_salida, id_producto_entrada, cantidad) FROM stdin;
\.


--
-- TOC entry 2984 (class 0 OID 16748)
-- Dependencies: 222
-- Data for Name: Rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Rol" (id_rol, descripcion, activo) FROM stdin;
\.


--
-- TOC entry 2967 (class 0 OID 16674)
-- Dependencies: 205
-- Data for Name: Tienda; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Tienda" (id_tienda, dir_tienda, tel_tienda) FROM stdin;
1	3RA. CALLE 8VA. AVENIDA ZONA 9	1234-5678
\.


--
-- TOC entry 2992 (class 0 OID 16841)
-- Dependencies: 230
-- Data for Name: Tipo_Documento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Tipo_Documento" (id_tipo_docto, descripcion) FROM stdin;
1	FACTURA
\.


--
-- TOC entry 2978 (class 0 OID 16721)
-- Dependencies: 216
-- Data for Name: Tipo_Transaccion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Tipo_Transaccion" (id_tipo, descripcion, factor) FROM stdin;
1	COMPRA	1
2	VENTA	-1
\.


--
-- TOC entry 2971 (class 0 OID 16690)
-- Dependencies: 209
-- Data for Name: Transaccion_Inventario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Transaccion_Inventario" (id_transaccion, id_empleado, id_tienda, id_tipo, anio, id_periodo, fec_transa, transaccion_origen, id_proveedor, id_tipo_docto, docto_referencia) FROM stdin;
\.


--
-- TOC entry 2975 (class 0 OID 16709)
-- Dependencies: 213
-- Data for Name: Transaccion_Inventario_Det; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Transaccion_Inventario_Det" (id_transaccion, id_linea, id_producto, unidades, costo_unitario, costo_total) FROM stdin;
\.


--
-- TOC entry 2987 (class 0 OID 16759)
-- Dependencies: 225
-- Data for Name: Usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Usuario" (id_usuario, usuario, contrasenia, id_empleado) FROM stdin;
\.


--
-- TOC entry 2988 (class 0 OID 16768)
-- Dependencies: 226
-- Data for Name: Usuario_Rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Usuario_Rol" (id_usuario, id_rol) FROM stdin;
\.


--
-- TOC entry 3028 (class 0 OID 0)
-- Dependencies: 206
-- Name: Empleado_id_empleado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Empleado_id_empleado_seq"', 5, true);


--
-- TOC entry 3029 (class 0 OID 0)
-- Dependencies: 211
-- Name: Estado_Empleado_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Estado_Empleado_id_estado_seq"', 2, true);


--
-- TOC entry 3030 (class 0 OID 0)
-- Dependencies: 219
-- Name: Menu_id_menu_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Menu_id_menu_seq"', 1, false);


--
-- TOC entry 3031 (class 0 OID 0)
-- Dependencies: 202
-- Name: Producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Producto_id_producto_seq"', 1, false);


--
-- TOC entry 3032 (class 0 OID 0)
-- Dependencies: 227
-- Name: Proveedor_id_proveedor_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Proveedor_id_proveedor_seq"', 1, false);


--
-- TOC entry 3033 (class 0 OID 0)
-- Dependencies: 221
-- Name: Rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Rol_id_rol_seq"', 1, false);


--
-- TOC entry 3034 (class 0 OID 0)
-- Dependencies: 204
-- Name: Tienda_id_tienda_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Tienda_id_tienda_seq"', 1, true);


--
-- TOC entry 3035 (class 0 OID 0)
-- Dependencies: 229
-- Name: Tipo_Documento_id_tipo_docto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Tipo_Documento_id_tipo_docto_seq"', 1, true);


--
-- TOC entry 3036 (class 0 OID 0)
-- Dependencies: 208
-- Name: Transaccion_Inventario_id_transaccion_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Transaccion_Inventario_id_transaccion_seq"', 1, false);


--
-- TOC entry 3037 (class 0 OID 0)
-- Dependencies: 224
-- Name: Usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Usuario_id_usuario_seq"', 1, false);


--
-- TOC entry 3038 (class 0 OID 0)
-- Dependencies: 215
-- Name: tipo_transaccion_id_tipo_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_transaccion_id_tipo_seq', 2, true);


--
-- TOC entry 2810 (class 2606 OID 16745)
-- Name: Menu Menu_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu"
    ADD CONSTRAINT "Menu_pkey" PRIMARY KEY (id_menu);


--
-- TOC entry 2812 (class 2606 OID 16753)
-- Name: Rol Rol_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Rol"
    ADD CONSTRAINT "Rol_pkey" PRIMARY KEY (id_rol);


--
-- TOC entry 2814 (class 2606 OID 16767)
-- Name: Usuario Usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "Usuario_pkey" PRIMARY KEY (id_usuario);


--
-- TOC entry 2794 (class 2606 OID 16687)
-- Name: Empleado empleado_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Empleado"
    ADD CONSTRAINT "empleado_PK" PRIMARY KEY (id_empleado);


--
-- TOC entry 2800 (class 2606 OID 16708)
-- Name: Estado_Empleado estado_empleado_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Estado_Empleado"
    ADD CONSTRAINT "estado_empleado_PK" PRIMARY KEY (id_estado);


--
-- TOC entry 2798 (class 2606 OID 16700)
-- Name: Inventario inventario_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Inventario"
    ADD CONSTRAINT "inventario_PK" PRIMARY KEY (id_tienda, id_producto);


--
-- TOC entry 2804 (class 2606 OID 16718)
-- Name: Periodo_Contable periodo_contable_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Periodo_Contable"
    ADD CONSTRAINT "periodo_contable_PK" PRIMARY KEY (anio, id_periodo);


--
-- TOC entry 2790 (class 2606 OID 16671)
-- Name: Producto producto_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Producto"
    ADD CONSTRAINT "producto_PK" PRIMARY KEY (id_producto);


--
-- TOC entry 2816 (class 2606 OID 16833)
-- Name: Proveedor proveedor_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Proveedor"
    ADD CONSTRAINT "proveedor_PK" PRIMARY KEY (id_proveedor);


--
-- TOC entry 2808 (class 2606 OID 16731)
-- Name: Receta receta_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Receta"
    ADD CONSTRAINT "receta_PK" PRIMARY KEY (id_producto_salida);


--
-- TOC entry 2792 (class 2606 OID 16679)
-- Name: Tienda tienda_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tienda"
    ADD CONSTRAINT "tienda_PK" PRIMARY KEY (id_tienda);


--
-- TOC entry 2818 (class 2606 OID 16846)
-- Name: Tipo_Documento tipo_documento_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tipo_Documento"
    ADD CONSTRAINT "tipo_documento_PK" PRIMARY KEY (id_tipo_docto);


--
-- TOC entry 2806 (class 2606 OID 16726)
-- Name: Tipo_Transaccion tipo_transaccion_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Tipo_Transaccion"
    ADD CONSTRAINT "tipo_transaccion_PK" PRIMARY KEY (id_tipo);


--
-- TOC entry 2796 (class 2606 OID 16695)
-- Name: Transaccion_Inventario transaccion_inventario_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "transaccion_inventario_PK" PRIMARY KEY (id_transaccion);


--
-- TOC entry 2802 (class 2606 OID 16713)
-- Name: Transaccion_Inventario_Det transaccion_inventario_det_PK; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario_Det"
    ADD CONSTRAINT "transaccion_inventario_det_PK" PRIMARY KEY (id_transaccion, id_linea);


--
-- TOC entry 2825 (class 2606 OID 16867)
-- Name: Transaccion_Inventario empleado_transaccion_inventario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "empleado_transaccion_inventario_FK" FOREIGN KEY (id_empleado) REFERENCES public."Empleado"(id_empleado);


--
-- TOC entry 2835 (class 2606 OID 16791)
-- Name: Usuario empleado_usuario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario"
    ADD CONSTRAINT "empleado_usuario_FK" FOREIGN KEY (id_empleado) REFERENCES public."Empleado"(id_empleado);


--
-- TOC entry 2820 (class 2606 OID 16786)
-- Name: Empleado estado_empleado_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Empleado"
    ADD CONSTRAINT "estado_empleado_FK" FOREIGN KEY (id_estado) REFERENCES public."Estado_Empleado"(id_estado);


--
-- TOC entry 2834 (class 2606 OID 16806)
-- Name: Menu_Rol menu_rol_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu_Rol"
    ADD CONSTRAINT "menu_rol_FK" FOREIGN KEY (id_menu) REFERENCES public."Menu"(id_menu);


--
-- TOC entry 2823 (class 2606 OID 16852)
-- Name: Transaccion_Inventario periodo_transaccion_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "periodo_transaccion_FK" FOREIGN KEY (anio, id_periodo) REFERENCES public."Periodo_Contable"(anio, id_periodo);


--
-- TOC entry 2827 (class 2606 OID 16771)
-- Name: Inventario producto_inventario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Inventario"
    ADD CONSTRAINT "producto_inventario_FK" FOREIGN KEY (id_producto) REFERENCES public."Producto"(id_producto);


--
-- TOC entry 2821 (class 2606 OID 16834)
-- Name: Transaccion_Inventario proveedor_transaccion_inventario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "proveedor_transaccion_inventario_FK" FOREIGN KEY (id_proveedor) REFERENCES public."Proveedor"(id_proveedor);


--
-- TOC entry 2832 (class 2606 OID 16821)
-- Name: Receta_Detalle receta_detalle_producto_entrada_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Receta_Detalle"
    ADD CONSTRAINT "receta_detalle_producto_entrada_FK" FOREIGN KEY (id_producto_entrada) REFERENCES public."Producto"(id_producto);


--
-- TOC entry 2831 (class 2606 OID 16816)
-- Name: Receta_Detalle receta_detalle_producto_salida_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Receta_Detalle"
    ADD CONSTRAINT "receta_detalle_producto_salida_FK" FOREIGN KEY (id_producto_salida) REFERENCES public."Receta"(id_producto_salida);


--
-- TOC entry 2830 (class 2606 OID 16811)
-- Name: Receta receta_producto_salida_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Receta"
    ADD CONSTRAINT "receta_producto_salida_FK" FOREIGN KEY (id_producto_salida) REFERENCES public."Producto"(id_producto);


--
-- TOC entry 2833 (class 2606 OID 16801)
-- Name: Menu_Rol rol_menu_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Menu_Rol"
    ADD CONSTRAINT "rol_menu_FK" FOREIGN KEY (id_rol) REFERENCES public."Rol"(id_rol);


--
-- TOC entry 2837 (class 2606 OID 16887)
-- Name: Usuario_Rol rol_usuario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario_Rol"
    ADD CONSTRAINT "rol_usuario_FK" FOREIGN KEY (id_rol) REFERENCES public."Rol"(id_rol);


--
-- TOC entry 2819 (class 2606 OID 16781)
-- Name: Empleado tienda_empleado_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Empleado"
    ADD CONSTRAINT "tienda_empleado_FK" FOREIGN KEY (id_tienda) REFERENCES public."Tienda"(id_tienda);


--
-- TOC entry 2828 (class 2606 OID 16776)
-- Name: Inventario tienda_inventario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Inventario"
    ADD CONSTRAINT "tienda_inventario_FK" FOREIGN KEY (id_tienda) REFERENCES public."Tienda"(id_tienda);


--
-- TOC entry 2822 (class 2606 OID 16847)
-- Name: Transaccion_Inventario tipo_documento_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "tipo_documento_FK" FOREIGN KEY (id_tipo_docto) REFERENCES public."Tipo_Documento"(id_tipo_docto);


--
-- TOC entry 2824 (class 2606 OID 16857)
-- Name: Transaccion_Inventario tipo_transaccion_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "tipo_transaccion_FK" FOREIGN KEY (id_tipo) REFERENCES public."Tipo_Transaccion"(id_tipo);


--
-- TOC entry 2829 (class 2606 OID 16862)
-- Name: Transaccion_Inventario_Det transaccion_inventario_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario_Det"
    ADD CONSTRAINT "transaccion_inventario_FK" FOREIGN KEY (id_transaccion) REFERENCES public."Transaccion_Inventario"(id_transaccion);


--
-- TOC entry 2826 (class 2606 OID 16892)
-- Name: Transaccion_Inventario transaccion_inventario_origen_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Transaccion_Inventario"
    ADD CONSTRAINT "transaccion_inventario_origen_FK" FOREIGN KEY (transaccion_origen) REFERENCES public."Transaccion_Inventario"(id_transaccion);


--
-- TOC entry 2836 (class 2606 OID 16882)
-- Name: Usuario_Rol usuario_id_rol_FK; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Usuario_Rol"
    ADD CONSTRAINT "usuario_id_rol_FK" FOREIGN KEY (id_usuario) REFERENCES public."Usuario"(id_usuario);


--
-- TOC entry 2999 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE "Empleado"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Empleado" TO desaweb;


--
-- TOC entry 3001 (class 0 OID 0)
-- Dependencies: 212
-- Name: TABLE "Estado_Empleado"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Estado_Empleado" TO desaweb;


--
-- TOC entry 3003 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE "Inventario"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Inventario" TO desaweb;


--
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 220
-- Name: TABLE "Menu"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Menu" TO desaweb;


--
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 223
-- Name: TABLE "Menu_Rol"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Menu_Rol" TO desaweb;


--
-- TOC entry 3007 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE "Periodo_Contable"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Periodo_Contable" TO desaweb;


--
-- TOC entry 3008 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE "Producto"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Producto" TO desaweb;


--
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 228
-- Name: TABLE "Proveedor"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Proveedor" TO desaweb;


--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE "Receta"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Receta" TO desaweb;


--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 218
-- Name: TABLE "Receta_Detalle"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Receta_Detalle" TO desaweb;


--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 222
-- Name: TABLE "Rol"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Rol" TO desaweb;


--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE "Tienda"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Tienda" TO desaweb;


--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 230
-- Name: TABLE "Tipo_Documento"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Tipo_Documento" TO desaweb;


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 216
-- Name: TABLE "Tipo_Transaccion"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Tipo_Transaccion" TO desaweb;


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE "Transaccion_Inventario"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Transaccion_Inventario" TO desaweb;


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE "Transaccion_Inventario_Det"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Transaccion_Inventario_Det" TO desaweb;


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 225
-- Name: TABLE "Usuario"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Usuario" TO desaweb;


--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 226
-- Name: TABLE "Usuario_Rol"; Type: ACL; Schema: public; Owner: postgres
--

GRANT SELECT,INSERT,DELETE,UPDATE ON TABLE public."Usuario_Rol" TO desaweb;


-- Completed on 2020-10-20 21:13:13

--
-- PostgreSQL database dump complete
--

