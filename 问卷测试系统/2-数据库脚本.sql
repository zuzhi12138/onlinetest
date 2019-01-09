create database QDU
go

use  QDU
go

create table Course(
CourseId char(4) primary key,
CourseName nvarchar(20),
Credit int,
Cmodule nvarchar(20)
)
go

insert into Course values
('C001',N'毛概',4,N'模块1'),
('C002',N'数学',6,N'模块2'),
('C003',N'Java入门',4,N'模块3'),
('C004',N'Servlet/JSP',6,N'模块1'),
('C005',N'JSF框架',2,N'模块2'),
('C006',N'形势政策',2,N'模块3'),
('C007',N'English',3,N'模块1'),
('C008',N'文言文',3,N'模块2'),
('C009',N'化学',3,N'模块3'),
('C010',N'物理',3,N'模块1'),
('C011',N'生物',3,N'模块2')
go


create table Question(
QuestionId int,
QuestionDesc nvarchar(50),
AnswerA nvarchar(30),
AnswerB nvarchar(30),
AnswerC nvarchar(30),
AnswerD nvarchar(30),
AnswerKey char(1),
Credit int,
CourseId char(4) foreign key references Course(CourseId),
primary key(QuestionId,CourseId)
)
go

insert into Question values
(1,N'JSF主要由两部分组成，其中一个是功能强大的API函数，另一个是什么？',N'框架1',N'框架2',N'一套包含各种页面元素并允许自定义的JSP标签库',N'框架4','C',20,'C005'),
(2,N'JSF组成部分中的JSP标签库的作用',N'好看',N'美观',N'处理',N'在JSP页面中显示JSF的界面','D',20,'C005'),
(3,N'JSF组成部分中API函数的作用',N'表示UI组件、管理组件状态，处理事件等',N'美观',N'好看',N'好看1','A',20,'C005'),
(4,N'我们实训会挂科吗',N'不会',N'肯定不会',N'必须不会',N'以上都对','D',20,'C005'),
(5,N'咱们老师好吗',N'好',N'非常好',N'特别好',N'以上都正确','D',20,'C005')

go


create table Student(
StudentId int primary key,
StudentPassword nvarchar(15),
StudentName nvarchar(10),
StudentGender nchar(1),
StudentAge int,
StudentMobile nvarchar(11)
)
go

insert into Student values
(001,'123456','Tom',N'男',18,'13146498715'),
(002,'123456','john',N'男',20,'18765425678'),
(003,'123456','lily',N'女',16,'18976543456'),
(004,'123456','sam',N'男',5,'17689075436'),
(005,'123456','amy',N'女',30,'18909752897')
go

create table Grade(
StudentId int foreign key references Student(StudentId),
CourseId char(4) foreign key references Course(CourseId),
StudentGrade int,
FinishDate nvarchar(50),
primary key(StudentId,CourseId)
)
go
insert into Grade values
(002,'C005',60,'2018-12-26')


create table StudentCourse(
StudentId int foreign key references Student(StudentId),
StudentName nvarchar(10),
CourseId char(4) foreign key references Course(CourseId),
CourseName nvarchar(20)
)
go
insert into StudentCourse values
(001,'Tom','C001',N'毛概'),
(001,'Tom','C005',N'JSF框架'),
(001,'Tom','C007','English'),
(003,'Lily','C005',N'JSF框架')



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
(002,'admin','john',N'男','18765425678'),
(003,'admin','lily',N'女','18976543456'),
(004,'admin','sam',N'男','17689075436'),
(005,'admin','amy',N'女','18909752897')
go

create table TestApplication(
StudentId int foreign key references Student(StudentId),
StudentName nvarchar(10),
CourseId char(4) foreign key references Course(CourseId),
CourseName nvarchar(20),
Application nvarchar(10)
)
insert into TestApplication values
(001,'Tom','C005',N'JSF框架',N'批准'),
(001,'Tom','C009','化学',N'拒绝'),
(003,'Lily','C005',N'JSF框架',N'未处理'),
(004,'sam','C005',N'JSF框架',N'未处理')






select * from Course
select * from Question
select * from Student
select * from StudentCourse
select * from Grade
select * from Manager
select * from TestApplication


