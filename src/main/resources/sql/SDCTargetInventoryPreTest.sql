DROP TABLE IF EXISTS TLALLOC_SDCINV_STG;

CREATE TABLE TLALLOC_SDCINV_STG 
( 
SEQUENCENUMBER NUMBER PRIMARY KEY, 
UPLOADID INT, 
LOCATIONID VARCHAR(255), 
PRODUCTCODE VARCHAR(255), 
TGT_INV_QTY DECIMAL(10,3), 
ACTIVEFLAG VARCHAR(255)
);



INSERT INTO TLALLOC_SDCINV_STG (SEQUENCENUMBER, UPLOADID, LOCATIONID, PRODUCTCODE, TGT_INV_QTY, ACTIVEFLAG)
VALUES (651,1514,'0551','5965',10.000,'Y');

INSERT INTO TLALLOC_SDCINV_STG (SEQUENCENUMBER, UPLOADID, LOCATIONID, PRODUCTCODE, TGT_INV_QTY, ACTIVEFLAG)
VALUES (652,1514,'0551','5965',10.000,'N');


