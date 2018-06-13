create table clinic 
(
clinic_ID integer, 
street_adress varchar(255),
city varchar(255),
country varchar(255),
postal_code varchar(255),
PRIMARY KEY (clinic_ID)
);

create table person
(
person_ID integer,
clinic_ID integer,
name varchar(255),
date_of_birth varchar(255),
phone_number integer,
street_adress varchar(255),
city varchar(255),
country varchar(255),
postal_code varchar(255),
PRIMARY KEY (person_ID),
FOREIGN KEY (clinic_ID) REFERENCES clinic(clinic_ID)
);

create table patient 
(
patient_ID integer,
person_ID integer,
insur_provider varchar(255),
PRIMARY KEY (patient_ID),
FOREIGN KEY (person_ID) REFERENCES person(person_ID)
);

create table employee 
(
employee_ID integer,
person_ID integer,
salary decimal(20,2),
date_hired varchar(255),
schedule varchar(255),
PRIMARY KEY (employee_ID),
FOREIGN KEY (person_ID) REFERENCES person(person_ID)
);

create table dentist 
(
dentist_ID integer,
employee_ID integer,
dental_certification varchar(255),
PRIMARY KEY (dentist_ID),
FOREIGN KEY (employee_ID) REFERENCES employee(employee_ID)
);

create table receptionist 
(
receptionist_ID integer,
employee_ID integer,
receptionist_certification varchar(255),
PRIMARY KEY (receptionist_ID),
FOREIGN KEY (employee_ID) REFERENCES employee(employee_ID)
);

create table treatment
(
treatment_ID integer,
patient_ID integer,
dentist_ID integer,
treatment varchar(255),
date_of_treatment varchar(255),
time_of_treatment varchar(255),
PRIMARY KEY (treatment_ID),
FOREIGN KEY (patient_ID) REFERENCES patient(patient_ID),
FOREIGN KEY (dentist_ID) REFERENCES dentist(dentist_ID)
);


create table supplier 
(
supplier_ID integer,
clinic_ID integer,
company_name varchar(255), 
street_adress varchar(255),
city varchar(255),
country varchar(255),
postal_code varchar(255),
PRIMARY KEY (supplier_ID),
FOREIGN KEY (clinic_ID) REFERENCES clinic(clinic_ID)
);

create table product 
(
productID varchar(255), 
supplier_ID integer,
name varchar(255),
quantity INTEGER,
PRIMARY KEY (productID),
FOREIGN KEY (supplier_ID) REFERENCES supplier(supplier_ID)
);