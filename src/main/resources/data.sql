insert into user (full_Name,email,password,blood_group,address,phone) values ('khalil','k@k.com','$2y$12$h.VUYBaEDD7faU8TizI71ewgX/3qOlzrQ4dBku6IyoJaDuYobM9CG','B+','johar town, lahore','123456789');
insert into user (full_Name,email,password,blood_group,address,phone) values ('abdul ahad','a@a.com','$2y$12$sH6x7QjA4OFu9Hc4/n/oKeL27zIwJGjiD.DrTfy5J8z0nzk5nr.Ye','A-','wapda town','987654321');

insert into role values (1,'ROLE_ADMIN');
insert into role values (2,'ROLE_USER');

insert into user_role values (1,1);
insert into user_role values (2,2);

/*insert into permission values (1,'write');
insert into permission values (2,'read');

insert into role_permission values (1,1);
insert into role_permission values (2,2);*/
