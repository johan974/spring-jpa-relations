# Oracle tables creation

CREATE TABLE johan_supplier ( 
  supplier_id numeric(10) not null,
  supplier_name varchar2(50) not null,
  contact_name varchar2(50),
  CONSTRAINT supplier_pk PRIMARY KEY (supplier_id)
);

CREATE TABLE johan_products
( product_id numeric(10) not null,
  prod_supplier_id numeric(10) not null,
  CONSTRAINT fk_supplier
    FOREIGN KEY (prod_supplier_id)
    REFERENCES johan_supplier(supplier_id)
);

SELECT s.supplier_id, s.supplier_name, p.product_id, p.prod_supplier_id 
FROM   johan_supplier s, johan_products p 
WHERE  p.prod_supplier_id = s.supplier_id;

# Oracle shared foreign key

CREATE TABLE johan_shared_supplier ( 
  supplier_shared_id numeric(10) not null,
  supplier_shared_name varchar2(50) not null,
  contact_shared_name varchar2(50),
  CONSTRAINT supplier_shared_pk PRIMARY KEY (supplier_shared_id)
);

CREATE TABLE johan_shared_products
( shared_supplier_id numeric(10),
  prod_supplier_name varchar2(50),
  CONSTRAINT fk_shared_supplier
    FOREIGN KEY (shared_supplier_id)
    REFERENCES johan_shared_supplier(supplier_shared_id)
);

