CREATE DATABASE IF NOT EXISTS poms;
USE poms;

CREATE TABLE Cancellation
	(
		Cancel_id int  AUTO_INCREMENT primary key, 
        Date_time DATETIME null, 
        Reason VARCHAR(50),
        order_id INT ,
        customer_id INT,
        
        FOREIGN KEY (order_id) REFERENCES (orders.order_id), 
        FOREIGN KEY(customer_id) REFERENCES (customer.customer_id )
	);