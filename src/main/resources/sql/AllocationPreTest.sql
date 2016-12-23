DROP TABLE IF EXISTS TLD_ALLOC_HDR;
DROP SEQUENCE IF EXISTS ALLOCATION_HEADER_SEQ;
DROP TABLE IF EXISTS TLD_ALLOC_DTL;
DROP SEQUENCE IF EXISTS ALLOCATION_DETAIL_SEQ;


 
CREATE SEQUENCE ALLOCATION_HEADER_SEQ
 	START WITH     10025
 	INCREMENT BY   1
 	NOCACHE
 	NOCYCLE;
 	
CREATE SEQUENCE ALLOCATION_DETAIL_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 

 	
CREATE TABLE TLD_ALLOC_HDR (
 	ALLOC_ID NUMBER NOT NULL,
 	LAST_UPD_SYSUSR_ID VARCHAR(255),
 	LAST_UPD_TS TIMESTAMP,
 	ALLOC_DT DATE,
 	PO_NBR VARCHAR(255),
 	PO_CRT_DT DATE,
 	PO_TYP_CD INT,
 	MVNDR_NBR INT,
 	EXPCTD_ARVL_DT DATE,
 	TSLD_NBR VARCHAR(255),
 	BOL_NBR VARCHAR(255),
 	TLD_ALLOC_STAT_CD INT,
 	DEPARTMENT_NBR INT,
 	CONSTRAINT PK_ALLOC_ID_HDR PRIMARY KEY(ALLOC_ID)
 	
);

     
CREATE TABLE TLD_ALLOC_DTL 
( 
ID NUMBER NOT NULL, 
ALLOC_ID NUMBER NOT NULL,
SKU_NBR VARCHAR(255),
SKU_SUB_TYP_CD INT,
DC_NBR INT,
LAST_UPD_SYSUSR_ID VARCHAR(255),
LAST_UPD_TS TIMESTAMP,
TRANSLD_NBR VARCHAR(255),
EXPCTD_ARVL_DT DATE,
ASN_PO_SHIP_QTY INT,
BUY_UOM_QTY DECIMAL(10,6),
BUY_PK_UOI_CD INT,
CONTN_NBR VARCHAR(255),
ALLOC_QTY INT,
CONSTRAINT PK_ID_DTL PRIMARY KEY(ID),
CONSTRAINT FK_ALLOC_ID_DTL
     FOREIGN KEY (ALLOC_ID)
     REFERENCES TLD_ALLOC_HDR (ALLOC_ID)
);


 	
