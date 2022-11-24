PGDMP     .    (            
    z            etiya-odev1sql    15.1    15.1 W    {           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            |           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            }           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ~           1262    16537    etiya-odev1sql    DATABASE     �   CREATE DATABASE "etiya-odev1sql" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United Kingdom.1252';
     DROP DATABASE "etiya-odev1sql";
                postgres    false            �            1259    16590    address    TABLE     �   CREATE TABLE public.address (
    id integer NOT NULL,
    addresstitleid integer NOT NULL,
    cityid integer NOT NULL,
    street character varying NOT NULL,
    customerid integer NOT NULL
);
    DROP TABLE public.address;
       public         heap    postgres    false            �            1259    16589    address_id_seq    SEQUENCE     �   ALTER TABLE public.address ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.address_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    228            �            1259    16598    addresstitle    TABLE     c   CREATE TABLE public.addresstitle (
    id integer NOT NULL,
    name character varying NOT NULL
);
     DROP TABLE public.addresstitle;
       public         heap    postgres    false            �            1259    16597    addresstitle_id_seq    SEQUENCE     �   ALTER TABLE public.addresstitle ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.addresstitle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    230            �            1259    16634    cargo    TABLE     \   CREATE TABLE public.cargo (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.cargo;
       public         heap    postgres    false            �            1259    16633    cargo_id_seq    SEQUENCE     �   ALTER TABLE public.cargo ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.cargo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    240            �            1259    16552 
   categories    TABLE     a   CREATE TABLE public.categories (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.categories;
       public         heap    postgres    false            �            1259    16574    categories_id_seq    SEQUENCE     �   ALTER TABLE public.categories ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    216            �            1259    16606    city    TABLE     [   CREATE TABLE public.city (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.city;
       public         heap    postgres    false            �            1259    16605    city_id_seq    SEQUENCE     �   ALTER TABLE public.city ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    232            �            1259    16538    colors    TABLE     ]   CREATE TABLE public.colors (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.colors;
       public         heap    postgres    false            �            1259    16573    colors_id_seq    SEQUENCE     �   ALTER TABLE public.colors ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.colors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �            1259    16576    colorsizerelations    TABLE        CREATE TABLE public.colorsizerelations (
    id integer NOT NULL,
    colorid integer NOT NULL,
    sizeid integer NOT NULL
);
 &   DROP TABLE public.colorsizerelations;
       public         heap    postgres    false            �            1259    16575    colorsizerelations_id_seq    SEQUENCE     �   ALTER TABLE public.colorsizerelations ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.colorsizerelations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    224            �            1259    16582 	   customers    TABLE     �   CREATE TABLE public.customers (
    id integer NOT NULL,
    firstname character varying NOT NULL,
    lastname character varying NOT NULL,
    phonenumber character varying NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    16581    customers_id_seq    SEQUENCE     �   ALTER TABLE public.customers ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.customers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    226            �            1259    16628 	   moneytype    TABLE     `   CREATE TABLE public.moneytype (
    id integer NOT NULL,
    name character varying NOT NULL
);
    DROP TABLE public.moneytype;
       public         heap    postgres    false            �            1259    16627    moneytype_id_seq    SEQUENCE     �   ALTER TABLE public.moneytype ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.moneytype_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    238            �            1259    16614    orders    TABLE     �   CREATE TABLE public.orders (
    id integer NOT NULL,
    date date NOT NULL,
    customerid integer NOT NULL,
    addressid integer NOT NULL,
    paymentid integer NOT NULL,
    cargoid integer NOT NULL
);
    DROP TABLE public.orders;
       public         heap    postgres    false            �            1259    16613    orders_id_seq    SEQUENCE     �   ALTER TABLE public.orders ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    234            �            1259    16620    payment    TABLE     R   CREATE TABLE public.payment (
    id integer NOT NULL,
    moneytypeid integer
);
    DROP TABLE public.payment;
       public         heap    postgres    false            �            1259    16619    payment_id_seq    SEQUENCE     �   ALTER TABLE public.payment ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.payment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    236            �            1259    16567    productcategories    TABLE     �   CREATE TABLE public.productcategories (
    id integer NOT NULL,
    categoryid integer NOT NULL,
    productid integer NOT NULL
);
 %   DROP TABLE public.productcategories;
       public         heap    postgres    false            �            1259    16566    productcategories_id_seq    SEQUENCE     �   ALTER TABLE public.productcategories ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.productcategories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    219            �            1259    16559    products    TABLE     �   CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying NOT NULL,
    unitprice money NOT NULL,
    stock integer NOT NULL,
    colorsizeid integer NOT NULL
);
    DROP TABLE public.products;
       public         heap    postgres    false            �            1259    16572    products_id_seq    SEQUENCE     �   ALTER TABLE public.products ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    217            �            1259    16545    size    TABLE     R   CREATE TABLE public.size (
    id integer NOT NULL,
    name character varying
);
    DROP TABLE public.size;
       public         heap    postgres    false            �            1259    16718    size_id_seq    SEQUENCE     �   ALTER TABLE public.size ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.size_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    215            k          0    16590    address 
   TABLE DATA           Q   COPY public.address (id, addresstitleid, cityid, street, customerid) FROM stdin;
    public          postgres    false    228   �`       m          0    16598    addresstitle 
   TABLE DATA           0   COPY public.addresstitle (id, name) FROM stdin;
    public          postgres    false    230   Pa       w          0    16634    cargo 
   TABLE DATA           )   COPY public.cargo (id, name) FROM stdin;
    public          postgres    false    240   �a       _          0    16552 
   categories 
   TABLE DATA           .   COPY public.categories (id, name) FROM stdin;
    public          postgres    false    216   �a       o          0    16606    city 
   TABLE DATA           (   COPY public.city (id, name) FROM stdin;
    public          postgres    false    232   (b       ]          0    16538    colors 
   TABLE DATA           *   COPY public.colors (id, name) FROM stdin;
    public          postgres    false    214   xb       g          0    16576    colorsizerelations 
   TABLE DATA           A   COPY public.colorsizerelations (id, colorid, sizeid) FROM stdin;
    public          postgres    false    224   �b       i          0    16582 	   customers 
   TABLE DATA           I   COPY public.customers (id, firstname, lastname, phonenumber) FROM stdin;
    public          postgres    false    226   �b       u          0    16628 	   moneytype 
   TABLE DATA           -   COPY public.moneytype (id, name) FROM stdin;
    public          postgres    false    238   �c       q          0    16614    orders 
   TABLE DATA           U   COPY public.orders (id, date, customerid, addressid, paymentid, cargoid) FROM stdin;
    public          postgres    false    234   �c       s          0    16620    payment 
   TABLE DATA           2   COPY public.payment (id, moneytypeid) FROM stdin;
    public          postgres    false    236   :d       b          0    16567    productcategories 
   TABLE DATA           F   COPY public.productcategories (id, categoryid, productid) FROM stdin;
    public          postgres    false    219   fd       `          0    16559    products 
   TABLE DATA           K   COPY public.products (id, name, unitprice, stock, colorsizeid) FROM stdin;
    public          postgres    false    217   �d       ^          0    16545    size 
   TABLE DATA           (   COPY public.size (id, name) FROM stdin;
    public          postgres    false    215   �d                  0    0    address_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.address_id_seq', 5, true);
          public          postgres    false    227            �           0    0    addresstitle_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.addresstitle_id_seq', 7, true);
          public          postgres    false    229            �           0    0    cargo_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.cargo_id_seq', 6, true);
          public          postgres    false    239            �           0    0    categories_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.categories_id_seq', 5, true);
          public          postgres    false    222            �           0    0    city_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.city_id_seq', 6, true);
          public          postgres    false    231            �           0    0    colors_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.colors_id_seq', 6, true);
          public          postgres    false    221            �           0    0    colorsizerelations_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.colorsizerelations_id_seq', 5, true);
          public          postgres    false    223            �           0    0    customers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.customers_id_seq', 6, true);
          public          postgres    false    225            �           0    0    moneytype_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.moneytype_id_seq', 5, true);
          public          postgres    false    237            �           0    0    orders_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.orders_id_seq', 11, true);
          public          postgres    false    233            �           0    0    payment_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.payment_id_seq', 5, true);
          public          postgres    false    235            �           0    0    productcategories_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.productcategories_id_seq', 1, false);
          public          postgres    false    218            �           0    0    products_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.products_id_seq', 3, true);
          public          postgres    false    220            �           0    0    size_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.size_id_seq', 4, true);
          public          postgres    false    241            �           2606    16596    address address_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.address
    ADD CONSTRAINT address_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.address DROP CONSTRAINT address_pkey;
       public            postgres    false    228            �           2606    16604    addresstitle addresstitle_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.addresstitle
    ADD CONSTRAINT addresstitle_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.addresstitle DROP CONSTRAINT addresstitle_pkey;
       public            postgres    false    230            �           2606    16640    cargo cargo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public            postgres    false    240            �           2606    16558    categories categories_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.categories DROP CONSTRAINT categories_pkey;
       public            postgres    false    216            �           2606    16612    city city_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.city
    ADD CONSTRAINT city_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.city DROP CONSTRAINT city_pkey;
       public            postgres    false    232            �           2606    16544    colors colors_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.colors
    ADD CONSTRAINT colors_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.colors DROP CONSTRAINT colors_pkey;
       public            postgres    false    214            �           2606    16580 *   colorsizerelations colorsizerelations_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT colorsizerelations_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.colorsizerelations DROP CONSTRAINT colorsizerelations_pkey;
       public            postgres    false    224            �           2606    16588    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    226            �           2606    16632    moneytype moneytype_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.moneytype
    ADD CONSTRAINT moneytype_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.moneytype DROP CONSTRAINT moneytype_pkey;
       public            postgres    false    238            �           2606    16618    orders orders_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.orders DROP CONSTRAINT orders_pkey;
       public            postgres    false    234            �           2606    16626    payment payment_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.payment
    ADD CONSTRAINT payment_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.payment DROP CONSTRAINT payment_pkey;
       public            postgres    false    236            �           2606    16571 (   productcategories productcategories_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT productcategories_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.productcategories DROP CONSTRAINT productcategories_pkey;
       public            postgres    false    219            �           2606    16565    products products_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.products DROP CONSTRAINT products_pkey;
       public            postgres    false    217            �           2606    16551    size size_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.size
    ADD CONSTRAINT size_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.size DROP CONSTRAINT size_pkey;
       public            postgres    false    215            �           2606    16696    orders addressid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "addressid-fk" FOREIGN KEY (addressid) REFERENCES public.address(id) NOT VALID;
 ?   ALTER TABLE ONLY public.orders DROP CONSTRAINT "addressid-fk";
       public          postgres    false    3253    234    228            �           2606    16671    address addresstitleid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.address
    ADD CONSTRAINT "addresstitleid-fk" FOREIGN KEY (addresstitleid) REFERENCES public.addresstitle(id) NOT VALID;
 E   ALTER TABLE ONLY public.address DROP CONSTRAINT "addresstitleid-fk";
       public          postgres    false    230    228    3255            �           2606    16706    orders cargoid-fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "cargoid-fk" FOREIGN KEY (cargoid) REFERENCES public.cargo(id) NOT VALID;
 =   ALTER TABLE ONLY public.orders DROP CONSTRAINT "cargoid-fk";
       public          postgres    false    234    240    3265            �           2606    16656    productcategories categoryid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT "categoryid-fk" FOREIGN KEY (categoryid) REFERENCES public.categories(id) NOT VALID;
 K   ALTER TABLE ONLY public.productcategories DROP CONSTRAINT "categoryid-fk";
       public          postgres    false    3243    219    216            �           2606    16676    address cityif-fk    FK CONSTRAINT     z   ALTER TABLE ONLY public.address
    ADD CONSTRAINT "cityif-fk" FOREIGN KEY (cityid) REFERENCES public.city(id) NOT VALID;
 =   ALTER TABLE ONLY public.address DROP CONSTRAINT "cityif-fk";
       public          postgres    false    3257    232    228            �           2606    16641    colorsizerelations colorid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT "colorid-fk" FOREIGN KEY (colorid) REFERENCES public.colors(id) NOT VALID;
 I   ALTER TABLE ONLY public.colorsizerelations DROP CONSTRAINT "colorid-fk";
       public          postgres    false    3239    224    214            �           2606    16666    products colorsizeid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.products
    ADD CONSTRAINT "colorsizeid-fk" FOREIGN KEY (colorsizeid) REFERENCES public.colorsizerelations(id) NOT VALID;
 C   ALTER TABLE ONLY public.products DROP CONSTRAINT "colorsizeid-fk";
       public          postgres    false    224    3249    217            �           2606    16681    address customerid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.address
    ADD CONSTRAINT "customerid-fk" FOREIGN KEY (customerid) REFERENCES public.customers(id) NOT VALID;
 A   ALTER TABLE ONLY public.address DROP CONSTRAINT "customerid-fk";
       public          postgres    false    228    3251    226            �           2606    16691    orders customerid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "customerid-fk" FOREIGN KEY (customerid) REFERENCES public.customers(id) NOT VALID;
 @   ALTER TABLE ONLY public.orders DROP CONSTRAINT "customerid-fk";
       public          postgres    false    226    3251    234            �           2606    16713    payment moneytypeid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.payment
    ADD CONSTRAINT "moneytypeid-fk" FOREIGN KEY (moneytypeid) REFERENCES public.moneytype(id) NOT VALID;
 B   ALTER TABLE ONLY public.payment DROP CONSTRAINT "moneytypeid-fk";
       public          postgres    false    238    3263    236            �           2606    16701    orders paymentid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.orders
    ADD CONSTRAINT "paymentid-fk" FOREIGN KEY (paymentid) REFERENCES public.payment(id) NOT VALID;
 ?   ALTER TABLE ONLY public.orders DROP CONSTRAINT "paymentid-fk";
       public          postgres    false    234    3261    236            �           2606    16661    productcategories productid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.productcategories
    ADD CONSTRAINT "productid-fk" FOREIGN KEY (productid) REFERENCES public.products(id) NOT VALID;
 J   ALTER TABLE ONLY public.productcategories DROP CONSTRAINT "productid-fk";
       public          postgres    false    3245    219    217            �           2606    16719    colorsizerelations sizeid-fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.colorsizerelations
    ADD CONSTRAINT "sizeid-fk" FOREIGN KEY (sizeid) REFERENCES public.size(id) NOT VALID;
 H   ALTER TABLE ONLY public.colorsizerelations DROP CONSTRAINT "sizeid-fk";
       public          postgres    false    224    215    3241            k   G   x�3�4�4�L�L�OO)�4�2�4�'�%'fsq�p�q�p&�&f$��grs�r��$"�L�b���� ��      m   /   x�3����M�2��OK�LN�2�2Ks��9��3��s�b����  ��      w   8   x�3�,-(�2�,-*�L��2���K�2�,()�2�LO-�,�2�L,J,����� R�      _   A   x�3�,.��M-�2�,��+2�9��KJ�s�s�K22�ҹL8K���L9K�RR��S��b���� G��      o   @   x�3�L*-*N�2�̬��,�2�L��N,J�2��,.I�K*��2���ϫL�2ʕ$� Y1z\\\ t      ]   ;   x�3�L���/�2�,JM�2�L�)M�2�L/JM��2�,(-*�I�2�'&gs��qqq ��u      g   (   x�3�4�4�2�4�4�2�M�L8M8�L9��"1z\\\ K�-      i   �   x�-��
�0Dϻ_�/��lz��(�I��e+	69�(��m���c�ia�Ejs~�q�|�������̌k8�S2�.�q����"!�f_�&�J~H��ٹ����EA��!�M'#�@���R8HM2�L7��W���*�      u   =   x�3�L.�,(��2�,H�,H̉��2���d�$'�p�p&'gp�r�d&g��p��qqq �T1      q   F   x�E���0Cѳ�K*lH�����(�4B�<}n8�!���`"Q�0��є���W��v>)���B�H~�W�      s      x�3���2� �D���=... WMY      b      x������ � �      `      x������ � �      ^   *   x�3�,�M���2��MM�,��2��I,JO�2ᬀ0b���� ��
�     