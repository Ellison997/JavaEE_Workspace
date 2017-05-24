//创建数据库，包括主数据库文件,一个事务日志文件
CREATE DATABASE TIANCHUNLE
ON PRIMARY
(NAME =TAINCHUNLE_DATA,
FILENAME='C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\TIANCHUNLE_DATA.MDF',
SIZE=10MB,
MAXSIZE=100MB,
FILEGROWTH=28MB
)
LOG ON
(
NAME =TIANCHUNLE_LOG,
FILENAME='C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\TIANCHUNLE_LOG.LDF',
MAXSIZE=100MB,
FILEGROWTH=1MB)
GO

//将当前数据库切换为指定的数据库
USE TIANCHUNLE
GO

//为数据库添加一个新的文件组
ALTER DATABASE TIANCHUNLE
ADD FILEGROUP newfilegroup
GO

ALTER DATABASE TIANCHUNLE
ADD FILE
(NAME=TIAN_ADD,
FILENAME='C:\Program Files\Microsoft SQL Server\MSSQL10.SQLEXPRESS\MSSQL\DATA\TIAN_ADD.NDF',
SIZE=3MB,
MAXSIZE=UNLIMITED,
FILEGROWTH=10MB
)
GO

//查看数据库相关信息
EXEC sp_helpdb TIANCHUNLE
GO

//查看数据库单用户状态设置内容
EXEC sp_dboption TIANCHUNLE,single
GO

//删除数据库
DROP DATABASE TIANCHUNLE
GO
use tcl
Go


--查询数据表Customers
SELECT *FROM Customers
GO

--查询表中三列信息
SELECT CustomerID,Name,Sex FROM Customers
GO 

--查询三列信息，并使用中文显示列标题
SELECT 客户编号=CustomerID,Name AS 姓名,Sex 性别
FROM Customers
GO

--查询列信息，删除重复记录
SELECT DISTINCT GoodsName FROM Orders
GO

--查询表中前五条记录
SELECT TOP 5*FROM Orders
GO

--创建一个与Customer表结构相同的空白newtable
SELECT *INTO newtable FROM Customers WHERE 1=2
GO
SELECT *FROM newtable
GO

--使用比较运算符查询
SELECT *FROM Orders WHERE Quantity>20
GO

--查询表中10到100之间的数据
SELECT *FROM Orders WHERE Quantity BETWEEN 10 AND 100
GO

--查询表中三种商品的信息
SELECT *FROM Goods WHERE GoodsName IN('pen','desk','book')
GO

--查询货品名称第二个字符为e的货品信息
SELECT *FROM Goods WHERE GoodsName LIKE '_e%'
GO

--检索非空信息
SELECT *FROM Goods WHERE Provider IS NOT NULL
GO

--查询表中重庆女客户的客户信息
SELECT *FROM Customers
WHERE Sex='女' AND Address LIKE '%重庆%'
GO

SELECT *FROM Orders order BY GoodsName,OrderTime DESC
GO