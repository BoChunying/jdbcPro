CREATE TABLE major
(
mno char(10) PRIMARY KEY,
mname char(20) unique,
);

CREATE TABLE class
(
cno char(10) PRIMARY KEY,
cnum smallint,
cmajor char(10) references major(mno),
);

CREATE TABLE student
(
Sno char(11) PRIMARY KEY,
Sname char(20) not null,
Ssex char(2) check (Ssex in ('ÄÐ','Å®') ),
Sbirth char(10),
Sage smallint,
Sclass char(10) references class(cno),
Smajor char(10) references major(mno),
);

CREATE TABLE course
(
cno char(10) PRIMARY KEY,
cname char(20) unique not null,
credit smallint,
);

CREATE TABLE sc
(
sno char(11) references student(Sno),
cno char(10) references course(cno),
scgrade smallint,
);

CREATE TABLE mc
(
mno char(10) references major(mno),
cno char(10) references course(cno),
term smallint check( term <= 8),
mctype smallint check ( mctype in (-1,0,1)),
);

CREATE TABLE teacher
(
tno char(11) PRIMARY KEY,
tname char(20) not null,
tsex char(2) check (tsex in ('ÄÐ','Å®') ),
tage smallint,
tmajor char(10) references major(mno),
);


CREATE TABLE teach
(
ttno char(11) references teacher(tno),
tcno char(10) references course(cno),
tclass char(10) references class(cno),
);