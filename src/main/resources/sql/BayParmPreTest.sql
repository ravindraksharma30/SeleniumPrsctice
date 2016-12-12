CREATE TABLE TLALLOC_BAYPARM_STG 
( 
sequencenumber NUMBER PRIMARY KEY, 
uploadid int, 
locationid varchar(255), 
productcode varchar(255), 
bay_parm_val NUMBER(10,4),
activeflag varchar(255)
);



INSERT INTO TLALLOC_BAYPARM_STG (sequencenumber, uploadid, locationid, productcode, bay_parm_val, activeflag)
VALUES ('10','10','5068','cd','5','Y');


