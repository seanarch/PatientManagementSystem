CREATE TABLE PT_ID (
	Lastname VARCHAR(45) NOT NULL,
	Firstname VARCHAR(45) NOT NULL,
	Sex CHAR(1) NOT NULL,
	Birthday DATE  NOT NULL,
	ULI INT NOT NULL,
	TG  VARCHAR(45),
	Location VARCHAR(45));
	
DROP TABLE PT_ID;
	

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Dervis', 'John', 'M','24-FEB-1972', '732917261', 'GI', 'RRDC');

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Finch', 'Adam', 'M', '05-MAY-1998', '940733349', 'HN' , 'RRDC');

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Huey', 'Linda', 'F', '17-JULY-1977', '673972108', 'Lung', 'RRDC' );

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Dosi', 'Serena', 'F', '31-DEC-1980', '182560549', 'HPB', 'Inpatient');

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Manabdha', 'Abraham', 'M', '29-FEB-2000', '384266529', 'GU', 'TBCC' );

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Martzen', 'Jane', 'F', '01-AUG-1997', '181641135', 'Sarcoma', 'Inpatient' );

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Iimura','Joe', 'F', '11-MAR-1978', '841180517', 'Breast', 'HXH' );

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location)  
VALUES ('Brigandi', 'Sam', 'M', '26-SEP-1976', '287809466', 'HPB', 'HXH');

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Grassini', 'Jay', 'M', '08-APR-1969', '557194155', 'GU', 'HXH');

INSERT INTO PT_ID ( Lastname, Firstname, Sex, Birthday, ULI, TG, Location) 
VALUES ('Haskell', 'Sarah', 'F', '12-NOV-1999', '857376351', 'HN', 'RRDC');

