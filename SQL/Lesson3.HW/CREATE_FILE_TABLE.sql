CREATE TABLE FILES
(
    ID      NUMBER PRIMARY KEY,
    NAME    NVARCHAR2(10),
    FORMAT  NVARCHAR2(5),
    FILE_SIZE    NUMBER,
    STORAGE NUMBER,
    CONSTRAINT STORAGE_FK FOREIGN KEY (STORAGE) REFERENCES STORAGE (ID)
);

CREATE TABLE STORAGE
(
    ID               NUMBER PRIMARY KEY,
    FORMAT_SUPPORTED CLOB,
    STORAGE_COUNTRY  NVARCHAR2(50),
    MAX_SIZE         NUMBER
);

CREATE SEQUENCE STORAGE_SEQ MINVALUE 1 MAXVALUE 10000 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE FILE_SEQ MINVALUE 1 MAXVALUE 10000 START WITH 1 INCREMENT BY 1;
