
CREATE TABLE task(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(100) NOT NULL,description VARCHAR(100) NOT NULL,STATUS VARCHAR(10) NOT NULL, created_date DATE,modified_date DATE,assigned_to INT,
CONSTRAINT assigned_to_fk FOREIGN KEY(assigned_to) REFERENCES user_account(id));

INSERT INTO task(NAME,description,STATUS,created_date,modified_date,assigned_to) VALUES('Install JDK','install jdk8 32 bit','Pending',NOW(),NOW(),5);
