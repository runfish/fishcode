-- 创建Bas_Dptlist
create table Bas_DptList(DptID INTEGER primary key autoincrement
, DptCode varchar(20)
,DptName varchar(20) not null
,DptBriefName varchar(20)
,DptClass varchar(20)
,DptType varchar(20)
,ViewOrder varchar(20) not null);

--创建Bas_userinfo
CREATE TABLE [Bas_userinfo] (
  [Userid] INTEGER PRIMARY KEY AUTOINCREMENT, 
  [LogonName] varchar(20) NOT NULL, 
  [Username] varchar(20) NOT NULL, 
  [Password] varchar(20), 
  [Dptid] integer NOT NULL CONSTRAINT [fk_deptid] REFERENCES [Bas_DptList]([DptID]), 
  [Sex] varchar(1), 
  [Birthday] date NOT NULL, 
  [Bphone] varchar(30), 
  [Headship] varchar(20), 
  [note] varchar);
--创建Info_prjvalues 
CREATE TABLE [Info_prjvalues] (
  [Prjid] INTEGER PRIMARY KEY AUTOINCREMENT, 
  [PrjCode] varchar(20) NOT NULL, 
  [Dptid] int NOT NULL CONSTRAINT [fk_info_dept] REFERENCES [Bas_DptList], 
  [Userid] int NOT NULL CONSTRAINT [fk_info_user] REFERENCES [Bas_userinfo]([Userid]), 
  [Creatdate] date NOT NULL, 
  [Amount] float, 
  [note] varchar);
