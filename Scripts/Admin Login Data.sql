USE poms_rev;
DROP TABLE admin_reg;
CREATE TABLE admin_reg(
admin_id int primary key auto_increment,
admin_name varchar(25),
admin_email varchar(40),
admin_phone bigint,
admin_dob varchar(25),
admin_password varchar(25)
);

INSERT INTO admin_reg ( admin_name, admin_email,
 admin_phone, admin_dob, admin_password
)

VALUES(" Akshay Kadam", "akshay@gmail.com",
 521456879,"31/08/2001","revature");
 
 SELECT * FROM admin_reg;
