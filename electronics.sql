CREATE TABLE user(
username varchar(40) primary key,
password varchar(40) NOT NULL,
enabled int default 0,
role varchar(40) NOT NULL);

CREATE TABLE customer(
cid varchar(40) primary key,
name varchar(40) NOT NULL,
contact bigint NOT NULL,
email varchar(40) NOT NULL,
house_no int,
locality varchar(40),
city varchar(40),
foreign key (cid) references user(username));

CREATE TABLE partner(
pid varchar(40) primary key,
name varchar(40) NOT NULL,
firm varchar(40),
contact bigint NOT NULL,
email varchar(40) NOT NULL,
foreign key (pid) references user(username));

CREATE TABLE otp(
code varchar(40) primary key,
username varchar(40) NOT NULL,
foreign key (username) references user(username));

CREATE TABLE category(
name varchar(40) primary key,
description varchar(100) NOT NULL);

CREATE TABLE product(
productid int auto_increment primary key,
name varchar(40) NOT NULL,
brand varchar(40) NOT NULL,
price int NOT NULL,
category varchar(40) NOT NULL,
photo varchar(500),
foreign key (category) references category(name));

CREATE TABLE cart(
customerid varchar(40) NOT NULL,
productid int NOT NULL,
quantity int,
primary key (customerid, productid),
foreign key (customerid) references customer(cid),
foreign key (productid) references product(productid));

CREATE TABLE invoice(
id int primary key,
DateOfIssue datetime DEFAULT CURRENT_TIMESTAMP,
paymentmethod varchar(40) default "Payment on receipt",
customerid varchar(40) NOT NULL,
foreign key (customerid) references customer(cid));

CREATE TABLE orders(
orderid int NOT NULL,
productid int NOT NULL,
quantity int NOT NULL,
primary key (orderid, productid),
foreign key (orderid) references invoice(id),
foreign key (productid) references product(productid));

CREATE TABLE partnerproposal(
partnerid varchar(40) NOT NULL,
productid int NOT NULL,
price int NOT NULL,
status varchar(40) default "pending",
primary key (partnerid, productid),
foreign key (partnerid) references partner(pid),
foreign key (productid) references product(productid));

CREATE TABLE feedback(
feedbackid int auto_increment primary key,
username varchar(40) NOT NULL,
rating int NOT NULL,
description varchar(100),
foreign key (username) references user(username));

INSERT into user(username, password, enabled, role)
values('admin','123',1,'ROLE_ADMIN');

INSERT INTO category(name, description)
values ('Laptop','Brand new Laptops');

INSERT INTO category(name, description)
values ('Phone','With new features');

INSERT INTO product(name, brand, price, category, photo)
values ('Macbook','Apple',100000,'Laptop','/resources/images/products/products-1.jpg');

INSERT INTO product(name, brand, price, category, photo)
values ('F1','Xiaomi',20000,'Phone','/resources/images/products/products-6.jpg');

INSERT INTO product(name, brand, price, category, photo)
values ('Chromebook','HP',50000,'Laptop','/resources/images/products/products-2.jpg');

INSERT INTO product(name, brand, price, category, photo)
values ('J5','Samsung',15000,'Phone','/resources/images/products/products-5.jpg');


