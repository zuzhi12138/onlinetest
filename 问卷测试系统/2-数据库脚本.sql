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
('C001',N'ë��',4,N'ģ��1'),
('C002',N'��ѧ',6,N'ģ��2'),
('C003',N'Java����',4,N'ģ��3'),
('C004',N'Servlet/JSP',6,N'ģ��1'),
('C005',N'JSF���',2,N'ģ��2'),
('C006',N'��������',2,N'ģ��3'),
('C007',N'English',3,N'ģ��1'),
('C008',N'������',3,N'ģ��2'),
('C009',N'��ѧ',3,N'ģ��3'),
('C010',N'����',3,N'ģ��1'),
('C011',N'����',3,N'ģ��2')
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
(1,N'JSF��Ҫ����������ɣ�����һ���ǹ���ǿ���API��������һ����ʲô��',N'���1',N'���2',N'һ�װ�������ҳ��Ԫ�ز������Զ����JSP��ǩ��',N'���4','C',20,'C005'),
(2,N'JSF��ɲ����е�JSP��ǩ�������',N'�ÿ�',N'����',N'����',N'��JSPҳ������ʾJSF�Ľ���','D',20,'C005'),
(3,N'JSF��ɲ�����API����������',N'��ʾUI������������״̬�������¼���',N'����',N'�ÿ�',N'�ÿ�1','A',20,'C005'),
(4,N'����ʵѵ��ҿ���',N'����',N'�϶�����',N'���벻��',N'���϶���','D',20,'C005'),
(5,N'������ʦ����',N'��',N'�ǳ���',N'�ر��',N'���϶���ȷ','D',20,'C005')

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
(001,'123456','Tom',N'��',18,'13146498715'),
(002,'123456','john',N'��',20,'18765425678'),
(003,'123456','lily',N'Ů',16,'18976543456'),
(004,'123456','sam',N'��',5,'17689075436'),
(005,'123456','amy',N'Ů',30,'18909752897')
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
(001,'Tom','C001',N'ë��'),
(001,'Tom','C005',N'JSF���'),
(001,'Tom','C007','English'),
(003,'Lily','C005',N'JSF���')



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

create table TestApplication(
StudentId int foreign key references Student(StudentId),
StudentName nvarchar(10),
CourseId char(4) foreign key references Course(CourseId),
CourseName nvarchar(20),
Application nvarchar(10)
)
insert into TestApplication values
(001,'Tom','C005',N'JSF���',N'��׼'),
(001,'Tom','C009','��ѧ',N'�ܾ�'),
(003,'Lily','C005',N'JSF���',N'δ����'),
(004,'sam','C005',N'JSF���',N'δ����')






select * from Course
select * from Question
select * from Student
select * from StudentCourse
select * from Grade
select * from Manager
select * from TestApplication


