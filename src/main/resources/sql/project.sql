use project;

drop table user;
drop table car_info;
drop table carCondition;


create table user(
	id		varchar(10)	not null primary key,
    passwd	varchar(24) not null,
	mname	varchar(20) not null,
	phone   varchar(14) not null,
	email 	varchar(50) not null,
    license  varchar(20) NOT NULL,
    carnumber varchar(8) not null
    );

alter TABLE user add FOREIGN KEY(carnumber)
REFERENCES car_info(carnumber);
    
insert into user (id, passwd, mname, phone, email, license,carnumber)
values ('user1', '1234','김길동','010-0000-0000', 'mail1@mail.com', '13-11-123456-78','12가1234');

    
select * from user;

create table car_info(
carnumber varchar(8) not null, 
carname varchar(100) not null,
carimage varchar(100) null, 	
carseate varchar(4) not null,
carpoint varchar(8) not null,
	primary KEY(carnumber)
);


insert into car_info(carname, carimage, carseate, carnumber, carpoint)
values('k5', 'k5.jpg', '4인승','12가1234', '서울 동작구');

select * from car_info;

create table carCondition(
	wheel int (5),
    windows int (5),
    bumper int (5),
    sideMirror int (5),
    cardoor int (5),
	airconditioner varchar(2), 
    safetyBelt varchar (2),
    bluetooth varchar (2),
    rearSensor varchar(2),
    rearCamera varchar(2),
    sunroof varchar(2),
    blackbox varchar(2),
    chargeState varchar(2),
    carnumber varchar(8)
);

alter TABLE carCondition add FOREIGN KEY(carnumber)
REFERENCES car_info(carnumber);

insert into carCondition(wheel, windows, bumper, sideMirror, cardoor, airconditioner, safetyBelt, bluetooth, rearSensor, rearCamera, sunroof, blackbox,chargeState,carnumber)
values(1,2,3,1,2,'있다', '없다', '없다', '없다', '없다', '없다', '없다','3', '12가1234');

select * from carCondition;

select *
from car_info a
join carcondition b
on a.carnumber = b.carnumber
join user c
on b.carnumber = c.carnumber;


select a.carnumber , a.carname ,a.carimage , a.carseate , a.carpoint ,
c.mname	, c.email ,c.id	,c.phone 
from car_info a
join carcondition b
on a.carnumber = b.carnumber
join user c
on b.carnumber = c.carnumber;


select a.carnumber , a.carname ,a.carimage , a.carseate ,b.wheel,
b.windows,b.bumper,b.sideMirror ,b.cardoor ,b.airconditioner ,b.safetyBelt ,
b.bluetooth ,b.rearSensor ,b.rearCamera ,b.sunroof ,b.blackbox ,b.chargeState 
from car_info a
join carcondition b
on a.carnumber = b.carnumber
join user c
on b.carnumber = c.carnumber;


-- create table carImpormation(
-- caryear varchar(10) not null,						-- 차 년도
-- carType varchar(10) not null,						-- 차종
-- kilometer varchar(50) not null,						-- 키로수
-- PRIMARY KEY(carlicenseplate)
-- );