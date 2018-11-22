create database QDU
go

use  QDU





create table [User](
UserId int primary key,
UserPassword nvarchar(15),
UserName nvarchar(10),
UserGender nchar(1),
UserAge int,
UserMobile nvarchar(11)
)
go

insert into [User] values
(001,'123456','Tom',N'男',18,'1314645'),
(002,'123456','john',N'男',20,'1876678'),
(003,'123456','lily',N'女',16,'1897656'),
(004,'123456','sam',N'男',5,'1768936'),
(005,'123456','amy',N'女',30,'1897')
go





create table Manager(
ManagerNo int primary key,
ManagerPassword nvarchar(20),
ManagerName nvarchar(10),
ManagerGender nvarchar(1),
ManagerMobile nchar(11)
)
go

insert into Manager values
(001,'admin','李老师',N'女','88866688866'),
(002,'admin','john',N'男','18765678'),
(003,'admin','lily',N'女','189763456'),
(004,'admin','sam',N'男','17675436'),
(005,'admin','amy',N'女','18909797')
go






select * from [User]

select * from Manager



