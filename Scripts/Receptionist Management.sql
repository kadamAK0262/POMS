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
    Address VARCHAR(50)
	admin_id int not null,
    foreign key(admin_id) references admin_reg(admin_id));
    

INSERT INTO
 Receptionist (Receptionist_Id,
 Receptionist_name,
 Designation,
 Gender, 
 Shift_time, 
 Contact_no, Address,admin_id)
 
 VALUES
 (1, "Akshay Kadam",
 "Counter_receptionist", 
 "Male",  "MORNING 09:00AM-06:00PM", 9122546582, "kopargaon",1);
 select *from receptionist;
 


