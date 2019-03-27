DROP DATABASE IF EXISTS internetshop;

CREATE DATABASE internetshop;

USE internetshop;

create table role(
id INTEGER PRIMARY KEY,
name VARCHAR(50)
);

CREATE TABLE users (
  id       INTEGER PRIMARY KEY  AUTO_INCREMENT,
  surname     VARCHAR(40),
  email    VARCHAR(30) NOT NULL UNIQUE,
  password VARCHAR(50) NOT NULL,
  isBlock VARCHAR(50) NOT NULL,
  role_idrole INT,
  FOREIGN KEY (role_idrole) REFERENCES role(id)
ON DELETE CASCADE
ON UPDATE CASCADE
 	
);

create table orders(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
status VARCHAR(50),
details VARCHAR (200),
users_idusers INT,
FOREIGN KEY (users_idusers) REFERENCES users(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

create table product(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50),
category VARCHAR(50),
size VARCHAR(50),
color VARCHAR(50),
price VARCHAR(50),
isNew VARCHAR (50)
);

create table product_has_order(
id INTEGER PRIMARY KEY AUTO_INCREMENT,
product_idproduct INT NOT NULL,
order_idorder INT NOT NULL,
FOREIGN KEY (product_idproduct) REFERENCES product(id)
ON DELETE CASCADE
ON UPDATE CASCADE,
FOREIGN KEY (order_idorder) REFERENCES orders(id)
ON DELETE CASCADE
ON UPDATE CASCADE
);


/*
 select users.id, users.surname, users.email, users.password, users.getIsBlock,role.id from users join role on role.id=users.id where users.id=1;
*/
insert into role values(1,'ADMIN');
insert into role values (2,'USER');

insert into users values(1,'Ivanov','erklareb@gmail.com','111111','false',1);
insert into users values(2,'Kutepov','kutepov@gmail.com','222222','false',2);
insert into users values(3,'fffff','fffff@gmail.com','222222','false',2);
insert into users values(4,'rrrrrr','rrrrr@gmail.com','222222','false',2);
insert into users values(5,'tttttt','ttttt@gmail.com','222222','false',2);
insert into users values(6,'mmmmmmm','mmmmm@gmail.com','222222','false',2);

insert into product VALUES (1,"Soma Fix Mega","Mounting foam","10x10","black","109.90",'false');
insert into product VALUES (2,"Moment Montaj","Mounting foam","10x10","black","109.90",'false');
insert into product VALUES (3,"Ceresit","Mounting foam","10x10","black","109.90",'false');
insert into product VALUES (4,"PC","Cement","10x10","white","70.56",'false');
insert into product VALUES (5,"CRH","Cement","10x10","red","66",'false');
insert into product VALUES (6,"ADANA","Cement","10x10","blue","75.96",'false');
insert into product VALUES (7,"Atem Zarina","Tile","20x30","white","30.90",'false');
insert into product VALUES (8,"Atem Vera","Tile","20x30","silver","19.90",'false');
insert into product VALUES (9,"Cifre","Tile","25x50","white","47.90",'false');
insert into product VALUES (10,"Cifre","Tile","25x50","white","47.90",'false');
insert into product VALUES (11,"Cifre","Tile","25x50","white","47.90",'false');
insert into product values(12,'NPN','door','700x2000','brown','514.50','true');
insert into product values(13,'TTT','door','600x1500','brown','514.50','true');
insert into product values(14,'Classic','door','300x1200','brown','514.50','true');



select * from role;
select * from users;
select * from product;
select * from orders;

