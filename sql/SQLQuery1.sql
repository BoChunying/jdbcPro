/*
insert into student(Sno,Sname,Ssex,Sbirth,Sage,Sclass,Smajor)
values('1503018','小孩','男','19960509','21','30001','00003');
update student set cnum = bnum+1 where cno = '30001'
*/
/*
select student.*,major.mname from student,major where Sno = '1501011' 
and student.smajor = major.mno;

select student.*,major.mname from student,major where Sname = '明明' 
and student.smajor = major.mno;

select student.*,major.mname from student,major where major.mname = '计算机'
and student.smajor = major.mno;
*/

/*
insert into studentcourse(sno,cno,scgrade)
values('1502021','4','65');
*/
/*
select student.Sname,course.cname,course.credit,majorcourse.mctype,majorcourse.term,studentcourse.scgrade
from student,course,majorcourse,studentcourse
where student.Sname = '明明' and student.Sno = studentcourse.sno
 and studentcourse.cno = course.cno and studentcourse.cno = majorcourse.cno
 and student.Smajor = majorcourse.mno;

select SUM(studentcourse.scgrade*course.credit)/SUM(course.credit)
from student,course,majorcourse,studentcourse
where student.Sname = '明明' and student.Sno = studentcourse.sno
 and studentcourse.cno = course.cno and studentcourse.cno = majorcourse.cno
 and student.Smajor = majorcourse.mno and majorcourse.mctype='1';

select SUM(studentcourse.scgrade*course.credit)/SUM(course.credit)
from student,course,majorcourse,studentcourse
where student.Sname = '明明' and student.Sno = studentcourse.sno
 and studentcourse.cno = course.cno and studentcourse.cno = majorcourse.cno
 and student.Smajor = majorcourse.mno;
*/
/*
select distinct student.Sname,teacher.tname
from student,teacher,studentcourse,teach 
where student.Sno=studentcourse.sno and studentcourse.cno=teach.tcno
 and teach.tclass=student.Sclass and student.Sname='明明' and teach.ttno=teacher.tno
*/
/*
select student.Sname
from student,course,majorcourse,studentcourse
where student.Sno = studentcourse.sno
 and studentcourse.cno = course.cno and studentcourse.cno = majorcourse.cno
 and student.Smajor = majorcourse.mno and studentcourse.scgrade<60
 group by student.Sname
 having SUM(credit)>12
;
*/
 

