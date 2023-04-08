IF OBJECT_ID('dbo.class_table', 'U') IS NOT NULL 
  DROP TABLE dbo.class_table; 

create table class_table (
       classId int identity not null,
        classCode varchar(255),
        className varchar(255),
        primary key (classId)
);

IF OBJECT_ID('dbo.Student_table', 'U') IS NOT NULL 
  DROP TABLE dbo.Student_table; 

create table Student_table (
       id int identity not null,
        name varchar(255),
        score int,
        FK_classEntity_id int,
        primary key (id)
);


INSERT INTO class_table 
(classCode, className) 
VALUES 
('EEIT127', 'Java全方位網路程式設計班'), 
('EEIT133', 'Java全方位網路程式設計班'),  
('EEIT145', 'Java全方位網路程式設計班');

INSERT INTO Student_table 
(name, score) 
VALUES 
('EEIT127', 'Java全方位網路程式設計班'), 
('EEIT133', 'Java全方位網路程式設計班'),  
('EEIT145', 'Java全方位網路程式設計班');

