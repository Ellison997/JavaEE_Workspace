-----------�������д����
--1.����һ�����ݿ�
create database MyDatavasesOne;
--2.ɾ�����ݿ�
drop database MyDatavasesOne;

--3���������ݿ��ʱ�������ļ�ѡ��
create database MydatabaseOne
on primary
(
--�����������ļ���ѡ��
name='MydatabaseOne',
filename='C:\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Mydatabase.mdf',		--�������ļ���ʵ�ʱ���·��
size=5MB,
maxsize=150MB,
filegrowth=20%
)
log on
(
--������־�ļ���ѡ��
name='MydatabaseOne_log',--��־�ļ����߼�����
filename='C:\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\MydatabaseOne_log.ldf',
size=5MB,		--��־�ļ��ĳ�ʼ��С
filegrowth=20%
)



--�����ݿ��д�����
--�����뻷���л���MyDatabaseOne��
use MyDatabaseOne
GO

create table Departments
(
AutoID int identity(1,1) primary key,
DepartmentName nvarchar(50) not null
) 

create table TblStudent(	tSId int identity(1,1) primary key,	tSName nvarchar(50) not null,	tSGender nchar(1),	tSAddress nvarchar(500),	tSAge int,	tSBirthday datetime,	tSCardId varchar(18),	tSClassId int)
insert into TblStudent(tSName,tSgender,tsage)values('ʯ��','Ů',15)
insert into TblStudent(TSName,tsgender,tsaddress,tsage,tsbirthday,tscardId,tsclassid)values('����','Ů','�����к�����',16,'1998-5-5','123456789654123697',1)
insert into TblStudentvalues('������12','��','�����к�����',17,'1997-5-5','123456789654123698',1)

create table TblTeacher
(
tTId int identity(1,1) primary key,
tTName  nvarchar(50) not null,
tTGender bit,
tTSalary money,
tTAge int,
tTBirthday datetime
)
--�����༶��
create table TbClass
(
tClassId int identity(1,1) primary key,
tClassName nvarchar(50)
)

--��༶���в���һ������
--insert into ��������1����2����3��values(ֵ1��ֵ2��ֵ3)
--1���Զ�����С�Ĭ�Ͼͻ��Զ����������Բ���Ҫ��Ĭ�������Ҳ�������Զ�����в���ֵ��
insert into TbClass
(tClassName) values('��������')
go

--�������е������У����Զ���ŵ��У���Ҫ����ֵ����ô����ʡ��������ͬʱ
--����Ҫ��֤˳��Ҫ���е�˳��һ��

--���ʦ���в���һ������
insert into TblTeacher(tTName,tTGender,tTAge,tTBirthday)
values
(N'�ﴺ��',12,18,'1997-08-01')

--��SQL����е�ֱ��д�ַ����У�����������ģ�һ��Ҫ���ַ���ǰ���N

select * from TbClass

select *from TblTeacher

select *from TblStudent


--�򿪺͹رղ�ѯ������ڣ�Ctrl +R
--������䣺
--update ���� set ����=��ֵ����2=��ֵ��.....where ����
--update ��䣬�������where ��������ô��ʾ�����б��е����ݽ����޸ģ�����һ��Ҫ��where����
select* from TblTeacher 
--��С�ڶ�ʮ�Ľ�ʦ�Ա�ĳ�Ů��
update TblTeacher set tTGender='Ů' where tTAge<20

--ɾ���������
--delete from ����where...
--delete ����������where������ʾ�ѱ��е��������ݶ�ɾ������where�����󣬻ᰴ��where��������ɾ��

--ɾ��TblTeacher���е��������ݡ��Զ���Ų�û�лָ���Ĭ�ϣ���Ȼ�������


select *from TblStudent

insert into TblStudent
values('�ﴺ��','��','ɽ��ʡ�����н�������������������Ľ�2��һ��','17096832922',21,'1997-08-08','4684453443',1)
--ɾ�������Ա�ΪŮ�Ĳ�������С�ڶ�ʮ���
delete from TblStudent where tSGender='��' and tSAge<20

--ɾ�����е���������
delete from Biao		--������һ���ɾ ɾ���鷳����

truecate table Biao

--���ȷʵҪɾ�����е��������ݽ���ʹ��truecate
--truecate ���ص㣺		1��truecate��䲻�ܸ�where�������޷�����������ɾ����ֻ��ɾ��ȫ����䣩
--2��ͬʱ�Զ���Żָ�����ʼֵ
--3��ʹ��truecateɾ�����е�����Ҫ��deleteЧ�ʸߵĶ�
--4��truecateɾ����䣬������delete ������

----------JAVAEE Hibernate ���߹���ϵͳ���ݿ�------------
create database Shopping;

use Shopping
go

--�������ݿ��category
create table category
(
id int primary key identity(1,1),
name varchar(40) not null
)
go

create table product
(
id int primary key identity(1,1),
sortid int not null,
name varchar(50) not null,
price float not null,
saleprice float not null,
descript nchar(500) not null,
contents nchar(2000) null,
saledate date not null,
salecount int null,
image varchar(50) null
)
go

--�������ݿ��user
create table users
(
id int primary key identity(1,1),
username varchar(20) not null,
password varchar(20) not null,
realname varchar(20) null,
tel varchar(20) null,
address varchar(100) null,
zip varchar(6) NULL,
email varchar(50) null 
)
go
-- �������ݿ��orders
create table orders
(
id int primary key identity(1,1),
orderno varchar(50) not null,
userid int not null,		--���ûд
realname varchar(20) not null,
address varchar(100) not null,
zip varchar(6) not null
tel varchar(20) null,
payment varchar(20) null,
email varchar(50) null,
memo varchar(2000) null,
price float null,			--����ʶ
time varchar(20) null,
tag int null
)
go

--�������ݿ�shopcarr
create table shopcart
(
id int primary key identity(1,1),
orderid int not null,		--���ж���
productid int not null,
count int not null,
price int not null
)
go
create table adminuser
(
id int primary key identity(1,1),
username varchar(20) not null,
password varchar(20) not null
)


----------------------------------------------------------
--ͨ��t-sql���������Լ��
------------------------------------------------------------
--�½�һ�ű�Ա����Ϣ��
create table Employees
(
	EmpId int identity(1,1),
	EmpName varchar(50),
	EmpGender char(2),
	EmpAge int,
	EmpEmail varchar(100),
	EmpAddress varchar(500)
)


create table Department
(
	DepId int identity(1,1) ,
	DepName varchar(50)
)

drop table Department

select *from Employees
select *from Department

--===============�ֶ�����Լ��-----------------
--�ֶ�ɾ��һ�У�ɾ��EmpAddress�У�
alter table Employees drop column EmpAddress
--�ֶ�����һ�У�����һ��EmpAddr varchar(200)��
alter table Employees add EmpAddr varchar(200)
--�޸�EmpEmail ����������Ϊvarchar(200)
alter table Employees alter column EmpEmail varchar(200)
--ΪEmpId����һ������Լ��
alter table Employees add constraint PK_Employees_EmpId primary key(EmpId)
--�ǿ�Լ����ΪEmpName ����һ���ǿ�Լ�����޸��У�
alter table Employees alter column EmpName varchar(50) not null

--ΪEmpName ����һ��ΨһԼ��
alter table Employees add constraint UQ_Employees_EmpName unique(EmpName)

--Ϊ�Ա�����һ��Ĭ��Լ����Ĭ��Ϊ��
alter table Employees add constraint DF_Employees_EmpGender Default('��') for EmpGender

--Ϊ�Ա�����һ�����Լ����ֻ�����к�Ů
alter table Employees add constraint CK_Employees_EmpGender check(EmpGender='��' or EmpGender='Ů')

--Ϊ��������һ�����Լ�������������0~120��֮�䣬��������
alter table Employees add constraint CK_Employees_EmpAge check(EmpAge>=0 and EmpAge<=120)

--����һ�����ű�Ȼ��Ϊemployee������һ��DepId��
alter table Employees add EmpDepId int not null

use MyDatabaseOne
--ΪDepartment �������������������ǣ�DepId;
alter table Department add constraint PK_Department_DepId primary key(DepId)

--�������Լ��
alter table Employees add constraint FK_Employees_Department foreign key(EmpDepId)references Department(DepId)

------------------------------------------------------------------
--ɾ��Լ��
ALTER TABLE Employees DROP CONSTRAINT 
FK_Employees_Department,CK_Employees_EmpAge

--ͨ��һ���������Ӷ���Լ��-----------
alter table Employees Add
constraint FK_Employees_Department foreign key(EmpId) references Department(DepId),
constraint CK_Employees_EmpAge check(EmpAge>=0 and EmpAge<=120)

--�������ͬʱ����Լ��=====

use MyDatabaseOne
drop table Employees
drop table Department

create table Employees
(
EmpId int identity(1,1) primary key,
EmpName varchar(50) not null unique check(len(EmpName)>2),
EmpGender char(2) default('��'),
EmpAge int check(EmpAge>0 and EmpAge<120),
EmpEmail varchar(100) unique,
EmpAddress varchar(500) not null,
EmpDepId int foreign key references Department(DepId) on delete cascade
)
create table Department
(
DepId int identity(1,1) primary key,
DepName varchar(50) not null unique
)


------���ݼ�������ѯ-----------------

use Itcast2014
go

--*��ʾ������
--��ѯ�����û�м�where������ʾ��ѯ������

select
* from TblStudent

--ֻ��ѯ���еĲ�����
select tsid,tsname,tsAddress from TblStudent

--��������ֻ��ѯ���еĲ����У�ͨ��where����ɸѡ��������ʾ��

select * from TblStudent where tsAge>21

--Ϊ��ѯ������е��������
select tsid as ѧ�����,tsname as ѧ������,tsgender as ѧ���Ա�,tsAddress as ��ͥסַ from TblStudent

select 
		tsid '(ѧ�� ���)',
		tsname ѧ������,
		tsgender ѧ���Ա�
from TblStudent

select 
		ѧ����� =tsid,
		ѧ������ =tsname,
		�Ա�=tsgender,
		���='��'		--Ҳ��������
from TblStudent

--������˵select�������fromһ��ʹ�ã����Ե���ʹ��select

select 
ϵͳ�ĵ�ǰʱ��=getDate()

select 
	�Ҷ���='��',
	���ö�='�ٵȻ��',
	���Ƕ�='һ��Է�ȥ'
	
--===============����==========================
--order by ����  desc,asc
--�������䣬��������
select * from TblStudent order by tsAge desc		--��������

--����������������
select * from TblStudent order by tsAge asc --��������

select * from TblStudent order by tsAge --Ĭ������

--��ѯ��ѧ�ɼ���ߵ�ǰ5��
select top 5 *from TblScore order by tMath desc

--��ȡ��ѧ�ɼ���͵�ǰ���
select top 5 *from TblScore order by tMath

--���top������Ĳ���һ�����ֶ���һ����һ��Ҫ�ã�������������
select top(2*3) *from TblScore order by tMath desc

--percent �ٷֱ�  ���ѯ����������
select top 35 percent *from TblScore order by tMath asc


--�ۺϺ���Ĭ�ϰ��������е����ݵ���һ�飬Ȼ��Ž��е�ͳ��
select *from NewPerson

--ͳ�Ƴ�������������ܺ�
select sum(age) as �����ܺ� from NewPerson

--ͳ�Ƶ�ǰ����һ���ж�������¼  count:����
select count(*) as ������ from NewPerson
--����ƽ������
select avg(age*1.0) from NewPerson

select ƽ������=
		(select sum(age) as �����ܺ� from NewPerson)*1.0/
		(select count(*) as ������ from NewPerson)


--������������
select max(age) as ������� from NewPerson

--������С��

select min(age) as ��С���� from NewPerson
--����ƽ��ֵ avg
select avg(age*1.0) as ƽ������ from NewPerson

--=====================�ۺϺ�����һЩ��������===============--
--1:�ۺϺ�����ͳ�ƿ�ֵ
select * from TblStudent

select count(tsAge) from TblStudent

select avg(tsAge) from TblStudent		--avg()Ҳ�ǲ�ͳ�ƿ�ֵ��

select sum(tsAge) from TblStudent --sum()����nullֵ��Ϊ��0

--2�����ʹ�þۺϺ�����ʱ�� û���ֶ�group by���飬��ô�ۺϺ����ͻ�� �������е�������Ϊһ����ʹ��

--��������ѯ
--select ��
--from��
--where ����
--��ѯû�м����ѧ�������裺��ѧ��Ӣ�ֻҪ��һ��û�м������û�м��񣩵�ѧ��
select *from TblScore

select tsid from TblScore where tEnglish<60 or tMath<60

--��ѯ������20~30��֮�����ѧ��������20��30��
select *from MyStudent
select * from MyStudent where FAge>=20 and FAge<=30 and FGender='��' 

select *from MyStudent where FAge between 20 and 30 and FGender='��'


--Between...and... ��...֮��...�������䣬���������˵�ֵ��
--��ѯmath �ɼ���80~90֮�������ѧ��
select *from TblScore where tMath between 80 and 90

-------------------
select *from TblStudent
--��ѯ�����а༶idΪ3,4,5����Щѧ��

select *from TblStudent where tSClassId=3 or tSClassId=4 or tSClassId=5
select * from TblStudent where tSClassId in(3,4,5)			--inд��

--����in ���� or ��ѯ�������ѯ�������������ļ������֡����ʹ��>= ��<=����between...and ��Ҫʹ��or ����in .���Ч��
select *from tblStudent where tSClassId>=3 and tSClassId<=5

select *from TblClass

----------------------------------------------------------
--ģ����ѯ
--ͨ�����_,%,[],^

--���ţ������ֵ�
select *from MyStudent where FName like '��__' 

--%ƥ�������������ַ�

select *from MyStudent where FName like '��%'

select *from MyStudent where FName like '��%' and len(fname)=4

--[]��ʾɸѡ��Χ

select * from TblStudent where TsName  like '��[0-9]��'

select * from TblStudent

--�����޸�
update TblStudent set TsName=replace(TsName,'��Ů��','��')

--�Լ�����һ��ת���      ESCAPE ''

select *from TblStudent where tsname like '%/_%' ESCAPE '/'

---------------��ֵ����------------------
--��ѯ��������Ϊnull ��ͬѧ��Ϣ
--nullֵ�޷�ʹ��=��<> �����бȽ�
--unknown		δ֪����δ֪��

�жϿ�ֵ����ʹ��is null ����is not null

select * from TblStudent where tSAge is null

--��ѯ�������ڲ�Ϊ�յ�
select * from TblStudent where tSBirthday is not null

--�κ�ֵ��null ���м��� ���õ��Ľ������null
select 23+null


-- ͨ��orber by ����������
--1,���� order by ���� desc
--2:���� order by ���� asc ���� order by ����
--3��order by ������һ��Ҫ����SQL�������
--4�����ݶ��н�������
--5�����԰��ձ��ʽ��������

select
	*,ƽ����=(tEnglish+tMath)*1.0/2
	from TblScore
	order by ƽ���� desc
select * from TblScore order by (tEnglish+tMath)*1.0/2 desc


--�ָ���Ӣ��ɼ������ٸ�����ѧ�ɼ������Ȱ���Ӣ��ɼ����򣬵�Ӣ��ɼ���ͬʱ�ٰ�����ѧ�ɼ���������

select * from TblSCore order by tEnglish desc,tmath desc









































