//�������ݿ⣬���������ݿ��ļ�,һ��������־�ļ�
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

//����ǰ���ݿ��л�Ϊָ�������ݿ�
USE TIANCHUNLE
GO

//Ϊ���ݿ����һ���µ��ļ���
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

//�鿴���ݿ������Ϣ
EXEC sp_helpdb TIANCHUNLE
GO

//�鿴���ݿⵥ�û�״̬��������
EXEC sp_dboption TIANCHUNLE,single
GO

//ɾ�����ݿ�
DROP DATABASE TIANCHUNLE
GO
use tcl
Go


--��ѯ���ݱ�Customers
SELECT *FROM Customers
GO

--��ѯ����������Ϣ
SELECT CustomerID,Name,Sex FROM Customers
GO 

--��ѯ������Ϣ����ʹ��������ʾ�б���
SELECT �ͻ����=CustomerID,Name AS ����,Sex �Ա�
FROM Customers
GO

--��ѯ����Ϣ��ɾ���ظ���¼
SELECT DISTINCT GoodsName FROM Orders
GO

--��ѯ����ǰ������¼
SELECT TOP 5*FROM Orders
GO

--����һ����Customer��ṹ��ͬ�Ŀհ�newtable
SELECT *INTO newtable FROM Customers WHERE 1=2
GO
SELECT *FROM newtable
GO

--ʹ�ñȽ��������ѯ
SELECT *FROM Orders WHERE Quantity>20
GO

--��ѯ����10��100֮�������
SELECT *FROM Orders WHERE Quantity BETWEEN 10 AND 100
GO

--��ѯ����������Ʒ����Ϣ
SELECT *FROM Goods WHERE GoodsName IN('pen','desk','book')
GO

--��ѯ��Ʒ���Ƶڶ����ַ�Ϊe�Ļ�Ʒ��Ϣ
SELECT *FROM Goods WHERE GoodsName LIKE '_e%'
GO

--�����ǿ���Ϣ
SELECT *FROM Goods WHERE Provider IS NOT NULL
GO

--��ѯ��������Ů�ͻ��Ŀͻ���Ϣ
SELECT *FROM Customers
WHERE Sex='Ů' AND Address LIKE '%����%'
GO

SELECT *FROM Orders order BY GoodsName,OrderTime DESC
GO