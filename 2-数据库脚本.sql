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
(001,'123456','Tom',N'��',18,'13146498715'),
(002,'123456','john',N'��',20,'18765425678'),
(003,'123456','lily',N'Ů',16,'18976543456'),
(004,'123456','sam',N'��',5,'17689075436'),
(005,'123456','amy',N'Ů',30,'18909752897')
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
(001,'admin','����ʦ',N'Ů','88866688866'),
(002,'admin','john',N'��','18765425678'),
(003,'admin','lily',N'Ů','18976543456'),
(004,'admin','sam',N'��','17689075436'),
(005,'admin','amy',N'Ů','18909752897')
go






select * from [User]

select * from Manager



