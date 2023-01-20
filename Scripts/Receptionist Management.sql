USE poms_rev;
Drop table Receptionist;
CREATE TABLE IF NOT EXISTS Receptionist
(
	Receptionist_Id INT AUTO_INCREMENT PRIMARY KEY ,
	Receptionist_name VARCHAR(50),
    Designation VARCHAR(50),
    Gender VARCHAR(20),
    Shift_time VARCHAR(50),
    Contact_no BIGINT,
    Address VARCHAR(50));
    

INSERT INTO
 Receptionist (Receptionist_Id,
 Receptionist_name,
 Designation,
 Gender, 
 Shift_time, 
 Contact_no, Address)
 
 VALUES
 (1, "Akshay Kadam",
 "Counter_receptionist", 
 "Male",  "MORNING 09:00AM-06:00PM", 9122546582, "kopargaon");
 select *from receptionist;
 


