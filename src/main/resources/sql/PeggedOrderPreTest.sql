CREATE TABLE VIRT_PEG_ORD 
( 
VIRT_PEG_ORD_ID NUMBER(10) PRIMARY KEY, 
SRC_LOC_NBR CHAR(4), 
SRC_LOC_TYP_CD CHAR(4), 
DEST_LOC_NBR CHAR(4), 
DEST_LOC_TYP_CD CHAR(4),
DEST_DUE_DT DATE,
MVNDR_NBR NUMBER(10),
MER_DEPT_NBR NUMBER(5),
SKU_NBR NUMBER(10),
PEG_ORD_QTY NUMBER(18,6),
INB_ORD_NBR VARCHAR(20),
PRNT_PEG_ORD_ID NUMBER(10),
PEG_ORD_WRK_ID NUMBER(10),
SOQ_REF_ID NUMBER(10),
PEG_ORD_STAT_CD NUMBER(5),
PRCSD_FLG CHAR(1),
BUY_UOM_QTY NUMBER(5),
PEG_TYP_CD NUMBER(5) ,
PEG_ORD_RSN_TYP_CD NUMBER(5),
SKU_SUB_TYP_CD NUMBER(5),
BOL_NBR VARCHAR(30),
PORT_EXPCTD_ARVL_TS TIMESTAMP

);


INSERT INTO VIRT_PEG_ORD (VIRT_PEG_ORD_ID, SRC_LOC_NBR, SRC_LOC_TYP_CD, DEST_LOC_NBR, DEST_LOC_TYP_CD, DEST_DUE_DT,MVNDR_NBR ,
MER_DEPT_NBR ,
SKU_NBR ,
PEG_ORD_QTY ,
INB_ORD_NBR ,
PRNT_PEG_ORD_ID ,
PEG_ORD_WRK_ID ,
SOQ_REF_ID ,
PEG_ORD_STAT_CD ,
PRCSD_FLG ,
BUY_UOM_QTY ,
PEG_TYP_CD ,
PEG_ORD_RSN_TYP_CD ,
SKU_SUB_TYP_CD ,
BOL_NBR ,
PORT_EXPCTD_ARVL_TS)
VALUES ('68742','5621','DC','5086','DC','2015-10-25','52847','25','1000014724','12','58158922','68741','18722','90000147','10','N',null,null,0,null,null,null);






