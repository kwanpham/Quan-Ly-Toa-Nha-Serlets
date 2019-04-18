set search_path to estatespring122018;

insert into role(code,name) values('MANAGER','Quản trị hệ thống');
insert into role(code,name) values('STAFF','Nhân viên');

insert into users(username,password,fullname,status)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn a',1);
insert into users(username,password,fullname,status)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn b',1);
insert into users(username,password,fullname,status)
values('nguyenvanc','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn c',1);
insert into users(username,password,fullname,status)
values('nguyenvand','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn d',1);

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,2);
INSERT INTO user_role(user_id,role_id) VALUES (4,2);

insert into district (name , code) values ('Quận 1' , 'quan_1');
insert into district (name , code) values ('Quận 2' , 'quan_2');
insert into district (name , code) values ('Quận 3' , 'quan_3');
insert into district (name , code) values ('Quận Tân Bình' , 'quan_tan_binh');