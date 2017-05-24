-----------在这里编写代码
--1.创建一个数据库
create database MyDatavasesOne;
--2.删除数据库
drop database MyDatavasesOne;

--3、创建数据库的时候设置文件选项
create database MydatabaseOne
on primary
(
--配置主数据文件的选项
name='MydatabaseOne',
filename='C:\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\Mydatabase.mdf',		--主数据文件的实际保存路径
size=5MB,
maxsize=150MB,
filegrowth=20%
)
log on
(
--配置日志文件的选项
name='MydatabaseOne_log',--日志文件的逻辑名称
filename='C:\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\MydatabaseOne_log.ldf',
size=5MB,		--日志文件的初始大小
filegrowth=20%
)



--在数据库中创建表
--将代码环境切换到MyDatabaseOne下
use MyDatabaseOne
GO

create table Departments
(
AutoID int identity(1,1) primary key,
DepartmentName nvarchar(50) not null
) 

create table TblStudent(	tSId int identity(1,1) primary key,	tSName nvarchar(50) not null,	tSGender nchar(1),	tSAddress nvarchar(500),	tSAge int,	tSBirthday datetime,	tSCardId varchar(18),	tSClassId int)
insert into TblStudent(tSName,tSgender,tsage)values('石蓉','女',15)
insert into TblStudent(TSName,tsgender,tsaddress,tsage,tsbirthday,tscardId,tsclassid)values('熊丽','女','北京市海淀区',16,'1998-5-5','123456789654123697',1)
insert into TblStudentvalues('刘天龙12','男','北京市海淀区',17,'1997-5-5','123456789654123698',1)

create table TblTeacher
(
tTId int identity(1,1) primary key,
tTName  nvarchar(50) not null,
tTGender bit,
tTSalary money,
tTAge int,
tTBirthday datetime
)
--创建班级表
create table TbClass
(
tClassId int identity(1,1) primary key,
tClassName nvarchar(50)
)

--想班级表中插入一条数据
--insert into 表名（列1，列2，列3）values(值1，值2，值3)
--1、自动编号列。默认就会自动增长，所以不需要（默认情况下也不能向自动编号列插入值）
insert into TbClass
(tClassName) values('高三三班')
go

--如果向表中的所有列（除自动编号的列）都要插入值，那么可以省略列名，同时
--必须要保证顺序要与列的顺序一致

--向教师表中插入一条数据
insert into TblTeacher(tTName,tTGender,tTAge,tTBirthday)
values
(N'田春乐',12,18,'1997-08-01')

--在SQL语句中的直接写字符串中，如果包含中文，一定要在字符串前面加N

select * from TbClass

select *from TblTeacher

select *from TblStudent


--打开和关闭查询结果窗口：Ctrl +R
--更新语句：
--update 表名 set ；列=新值，列2=新值，.....where 条件
--update 语句，如果不加where 条件，那么表示对所有表中的数据进行修改，所以一定要加where条件
select* from TblTeacher 
--把小于二十的教师性别改成女的
update TblTeacher set tTGender='女' where tTAge<20

--删除数据语句
--delete from 表名where...
--delete 语句如果不加where条件表示把表中的所有数据都删除。加where条件后，会按照where条件进行删除

--删除TblTeacher表中的所有数据。自动编号并没有恢复到默认，仍然继续编号


select *from TblStudent

insert into TblStudent
values('田春乐','男','山东省济宁市金乡县马庙镇马庙村中心街2巷一号','17096832922',21,'1997-08-08','4684453443',1)
--删除所有性别为女的并且年龄小于二十岁的
delete from TblStudent where tSGender='男' and tSAge<20

--删除表中的所有数据
delete from Biao		--，，，一般别删 删了麻烦大了

truecate table Biao

--如果确实要删除表中的所有数据建议使用truecate
--truecate 的特点：		1：truecate语句不能跟where条件（无法根据条件来删除，只能删除全部语句）
--2：同时自动编号恢复到初始值
--3：使用truecate删除表中的数据要比delete效率高的多
--4：truecate删除语句，不触发delete 触发器

----------JAVAEE Hibernate 在线购物系统数据库------------
create database Shopping;

use Shopping
go

--创建数据库表：category
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

--创建数据库表user
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
-- 创建数据库表orders
create table orders
(
id int primary key identity(1,1),
orderno varchar(50) not null,
userid int not null,		--外键没写
realname varchar(20) not null,
address varchar(100) not null,
zip varchar(6) not null
tel varchar(20) null,
payment varchar(20) null,
email varchar(50) null,
memo varchar(2000) null,
price float null,			--不认识
time varchar(20) null,
tag int null
)
go

--创建数据库shopcarr
create table shopcart
(
id int primary key identity(1,1),
orderid int not null,		--还有东西
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
--通过t-sql语句来创建约束
------------------------------------------------------------
--新建一张表：员工信息表
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

--===============手动增加约束-----------------
--手动删除一列（删除EmpAddress列）
alter table Employees drop column EmpAddress
--手动增加一列（增加一列EmpAddr varchar(200)）
alter table Employees add EmpAddr varchar(200)
--修改EmpEmail 的数据类型为varchar(200)
alter table Employees alter column EmpEmail varchar(200)
--为EmpId增加一个主键约束
alter table Employees add constraint PK_Employees_EmpId primary key(EmpId)
--非空约束，为EmpName 增加一个非空约束（修改列）
alter table Employees alter column EmpName varchar(50) not null

--为EmpName 增加一个唯一约束
alter table Employees add constraint UQ_Employees_EmpName unique(EmpName)

--为性别增加一个默认约束，默认为男
alter table Employees add constraint DF_Employees_EmpGender Default('男') for EmpGender

--为性别增加一个检查约束，只允许男和女
alter table Employees add constraint CK_Employees_EmpGender check(EmpGender='男' or EmpGender='女')

--为年龄增加一个检查约束：年龄必须在0~120岁之间，含岁与岁
alter table Employees add constraint CK_Employees_EmpAge check(EmpAge>=0 and EmpAge<=120)

--创建一个部门表。然后为employee表增加一个DepId列
alter table Employees add EmpDepId int not null

use MyDatabaseOne
--为Department 表设置主键，主键列是：DepId;
alter table Department add constraint PK_Department_DepId primary key(DepId)

--增加外键约束
alter table Employees add constraint FK_Employees_Department foreign key(EmpDepId)references Department(DepId)

------------------------------------------------------------------
--删除约束
ALTER TABLE Employees DROP CONSTRAINT 
FK_Employees_Department,CK_Employees_EmpAge

--通过一条代码增加多条约束-----------
alter table Employees Add
constraint FK_Employees_Department foreign key(EmpId) references Department(DepId),
constraint CK_Employees_EmpAge check(EmpAge>=0 and EmpAge<=120)

--创建表的同时创建约束=====

use MyDatabaseOne
drop table Employees
drop table Department

create table Employees
(
EmpId int identity(1,1) primary key,
EmpName varchar(50) not null unique check(len(EmpName)>2),
EmpGender char(2) default('男'),
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


------数据检索，查询-----------------

use Itcast2014
go

--*显示所有列
--查询语句中没有加where条件表示查询所有行

select
* from TblStudent

--只查询表中的部分列
select tsid,tsname,tsAddress from TblStudent

--根据条件只查询表中的部分行（通过where条件筛选部分行显示）

select * from TblStudent where tsAge>21

--为查询结果集中的列起别名
select tsid as 学生编号,tsname as 学生姓名,tsgender as 学生性别,tsAddress as 家庭住址 from TblStudent

select 
		tsid '(学生 编号)',
		tsname 学生姓名,
		tsgender 学生性别
from TblStudent

select 
		学生编号 =tsid,
		学生姓名 =tsname,
		性别=tsgender,
		婚否='否'		--也可以这样
from TblStudent

--并不是说select必须配合from一起使用，可以单独使用select

select 
系统的当前时间=getDate()

select 
	我饿了='吃',
	懒得动='再等会吧',
	还是饿='一会吃饭去'
	
--===============排序==========================
--order by 列名  desc,asc
--按照年龄，降序排列
select * from TblStudent order by tsAge desc		--降序排列

--按照年龄升序排列
select * from TblStudent order by tsAge asc --升序排列

select * from TblStudent order by tsAge --默认升序

--查询数学成绩最高的前5名
select top 5 *from TblScore order by tMath desc

--获取数学成绩最低的前五个
select top 5 *from TblScore order by tMath

--如果top后面跟的不是一个数字而是一个表达，一定要用（）把它括起来
select top(2*3) *from TblScore order by tMath desc

--percent 百分比  会查询出四条数据
select top 35 percent *from TblScore order by tMath asc


--聚合函数默认把整个表中的数据当成一组，然后才进行的统计
select *from NewPerson

--统计出所有人年龄的总和
select sum(age) as 年龄总和 from NewPerson

--统计当前表中一共有多少条记录  count:计算
select count(*) as 总数据 from NewPerson
--计算平均年龄
select avg(age*1.0) from NewPerson

select 平均年龄=
		(select sum(age) as 年龄总和 from NewPerson)*1.0/
		(select count(*) as 总数据 from NewPerson)


--计算年龄最大的
select max(age) as 最大年龄 from NewPerson

--年龄最小的

select min(age) as 最小年龄 from NewPerson
--计算平均值 avg
select avg(age*1.0) as 平均年龄 from NewPerson

--=====================聚合函数的一些其他问题===============--
--1:聚合函数不统计空值
select * from TblStudent

select count(tsAge) from TblStudent

select avg(tsAge) from TblStudent		--avg()也是不统计空值的

select sum(tsAge) from TblStudent --sum()对于null值认为是0

--2：如果使用聚合函数的时候 没有手动group by分组，那么聚合函数就会把 整个表中的数据作为一组来使用

--带条件查询
--select 列
--from表
--where 条件
--查询没有及格的学生（假设：数学或英语，只要有一门没有及格就是没有及格）的学号
select *from TblScore

select tsid from TblScore where tEnglish<60 or tMath<60

--查询年龄在20~30岁之间的男学生（包含20和30）
select *from MyStudent
select * from MyStudent where FAge>=20 and FAge<=30 and FGender='男' 

select *from MyStudent where FAge between 20 and 30 and FGender='男'


--Between...and... 在...之间...（闭区间，包含两个端点值）
--查询math 成绩在80~90之间的所有学生
select *from TblScore where tMath between 80 and 90

-------------------
select *from TblStudent
--查询出所有班级id为3,4,5的那些学生

select *from TblStudent where tSClassId=3 or tSClassId=4 or tSClassId=5
select * from TblStudent where tSClassId in(3,4,5)			--in写法

--对于in 或者 or 查询，如果查询的条件是连续的几个数字。最好使用>= ，<=或者between...and 不要使用or 或者in .提高效率
select *from tblStudent where tSClassId>=3 and tSClassId<=5

select *from TblClass

----------------------------------------------------------
--模糊查询
--通配符：_,%,[],^

--姓张，三个字的
select *from MyStudent where FName like '张__' 

--%匹配任意多个任意字符

select *from MyStudent where FName like '张%'

select *from MyStudent where FName like '张%' and len(fname)=4

--[]表示筛选范围

select * from TblStudent where TsName  like '张[0-9]妹'

select * from TblStudent

--批量修改
update TblStudent set TsName=replace(TsName,'（女）','妹')

--自己定义一个转义符      ESCAPE ''

select *from TblStudent where tsname like '%/_%' ESCAPE '/'

---------------空值处理------------------
--查询所有年龄为null 的同学信息
--null值无法使用=或<> 来进行比较
--unknown		未知数，未知的

判断空值必须使用is null 或者is not null

select * from TblStudent where tSAge is null

--查询出生日期不为空的
select * from TblStudent where tSBirthday is not null

--任何值与null 进行计算 ，得到的结果还是null
select 23+null


-- 通过orber by 语句进行排序
--1,降序 order by 列名 desc
--2:升序 order by 列名 asc 或者 order by 列名
--3：order by 语句必须一定要放在SQL语句的最后
--4：根据多列进行排序
--5：可以按照表达式进行排序

select
	*,平均分=(tEnglish+tMath)*1.0/2
	from TblScore
	order by 平均分 desc
select * from TblScore order by (tEnglish+tMath)*1.0/2 desc


--现根据英语成绩排序，再根据数学成绩排序（先按照英语成绩排序，当英语成绩相同时再按照数学成绩进行排序）

select * from TblSCore order by tEnglish desc,tmath desc









































