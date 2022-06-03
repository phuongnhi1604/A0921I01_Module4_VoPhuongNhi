use furama;

insert into customer_type (`customer_type_id`, `customer_type_name`) values(1,'Diamond'),(2,'Platinium'),
(3,'Gold'),(4,'Silver'),(5,'Member');

insert into customer(customer_address,customer_birthday,customer_code,customer_email,customer_gender,customer_id_card,customer_name,
customer_phone,customer_type_id) values('Da Nang','2001-12-12','KH100','nhi@gmail.com',0,'231231231','nhi','0231231',1);

select * FROM customer where customer_name like '%n%' and customer_type_id =1;

insert into user_role value(1,'admin');
insert into `role` value(1,'admin');
insert into `user` value('admin','123');
insert into division value(1,'ke toan');
insert into position value(1,'thu ki');
insert into education_degree value(1,'dai hoc');
insert into employee value(1,'Da nang','2001-12-12','nhi@gmail.com','1232352362','nhi','0901242359',12324,1,1,1,'admin');

insert into service_type value(1,'villa');
insert into rent_type value(1,1221,'ngay');
