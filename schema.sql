 
CREATE TABLE employee (
	employee_id INT NOT NULL AUTO_INCREMENT, 
	email varchar(255), first_name varchar(255), last_name varchar(255) ,
	PRIMARY KEY(employee_id)
);

CREATE TABLE project (
	project_id INT NOT NULL AUTO_INCREMENT, 
	description varchar(255), name varchar(255), stage varchar(255),
	PRIMARY KEY(project_id)
);

CREATE TABLE project_employee (
	project_id bigint not null, employee_id bigint not null
);
 


UPDATE user_accounts
SET enabled = 'Yes'
WHERE user_id = 1;


CREATE TABLE user_accounts(
	id INT NOT NULL AUTO_INCREMENT,
	email varchar(255) NOT NULL,
	username varchar(255) NOT NULL UNIQUE,
	password varchar(255) NOT NULL,
	enabled boolean not null,
	PRIMARY KEY(id)
);

CREATE TABLE authorities ( 
	username varchar(255) NOT NULL,
	role varchar(255) NOT NULL,  
	CONSTRAINT fk_authorities_user_accounts FOREIGN KEY(username) REFERENCES user_accounts(username)
	 
);

INSERT INTO authorities
(username, role)
VALUES
('root', 'USER');

INSERT INTO authorities
(username, role)
VALUES
('Admin', 'ADMIN');

 
