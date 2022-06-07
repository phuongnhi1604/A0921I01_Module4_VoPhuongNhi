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

insert into attach_service values(1,'110000','Karaoke','Trong',5),(2,'120000','Massage','Trong',7);

DELIMITER $$
CREATE PROCEDURE get_all_customer_use_service()
BEGIN
    select cus.customer_id,cus.customer_name,cus.customer_birthday,cus.customer_gender,cus.customer_id_card,cus.customer_phone,cus.customer_email,cus.customer_address,atsv.attach_service_name,sv.service_name
	from ((((customer as cus left join contract as ct on cus.customer_id=ct.customer_id)
	join service sv on sv.service_id = ct.service_id)
	left join contract_detail as ctde on ct.contract_id=ctde.contract_id)
	left join attach_service atsv on atsv.attach_service_id = ctde.attach_service_id
	);
END;

call get_all_customer_use_service();