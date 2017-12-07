package Studmm;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;

public class Stu {
    public static void main(String[] args) {
       new MyFrame("123");
    }
       
}



class MyFrame extends Frame
{
	CardLayout c = null;
	Panel pp = null;
	TextField num1,courseText1,bicourseText1,scourseText1,beteachText1,badText1,stText1,gradeText1;
	TextArea num2,courseText2,bicourseText2,scourseText2,beteachText2,badText2,stText22,gradeText22;
	TextField num11,stText2,stText3,stText4,stText5,stText6,stText7;
	TextArea num22;
	TextField num111,gradeText2,gradeText3;
	TextArea num222;
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public MyFrame(String s)
	{
		super(s);
		
		 String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mydatabase;";
	        String sql1 = "select * from course;";
//	        String sql2 = "FROM S-CLASS;";
	        
	        try {
	            //1.反射加载驱动程序类
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        } catch (ClassNotFoundException e) {
	            System.out.println("未发现类..");
	        }
	        
	        try {
	            //2.通过驱动类DriverManager获取与数据库的连接
	        	conn = DriverManager.getConnection(url, "sa", "741963bcy");
	            stmt = conn.createStatement();
	        } catch (SQLException e) {
	            System.out.println("无法连接数据库..");
	        }
	    
		
		
		setLayout(new BorderLayout());
		this.setBounds(400, 150, 400, 400);
		this.setBackground(new Color(100,100,200));
		this.addWindowListener(new myWindowMonitor()); 
		
		c = new CardLayout();
		pp =new Panel(c);
		Panel p = new Panel(new GridLayout(1,2));
		//setLayout(new GridLayout(1,2));
		
		Label one = new Label("查询");
		Label two = new Label("录入");
		
		Panel p1 = new Panel(new FlowLayout()); 
		p1.add(one);
		Panel p2 = new Panel(new FlowLayout());
		p2.add(two);
		
		Button b1 = new Button("学号查询学生基本信息");
		b1.addActionListener(new mymonitor1(this));
		p1.add(b1);
		
		Button bb1 = new Button("姓名查询学生基本信息");
		bb1.addActionListener(new mymonitorm1(this));
		p1.add(bb1);
		
		Button bbb1 = new Button("专业查询学生基本信息");
		bbb1.addActionListener(new mymonitormm1(this));
		p1.add(bbb1);
		
		Button b2 = new Button("学生所修课程");
		b2.addActionListener(new mymonitor2(this));
		p1.add(b2);
		
		Button b3 = new Button("必修课平均成绩");
		b3.addActionListener(new mymonitor3(this));
		p1.add(b3);
		
		Button b4 = new Button("所有课平均成绩");
		b4.addActionListener(new mymonitor4(this));
		p1.add(b4);
		
		Button b5 = new Button("被教过的老师");
		b5.addActionListener(new mymonitor5(this));
		p1.add(b5);
		
		Button b6 = new Button("即将开出的学生");
		b6.addActionListener(new mymonitor6(this));
		p1.add(b6);
		
		Button b7 = new Button("录入学生信息");
		b7.addActionListener(new mymonitor7(this));
		p2.add(b7);
		
		Button b8 = new Button("录入学生成绩");
		b8.addActionListener(new mymonitor8(this));
		p2.add(b8);
		
		Button b9 = new Button("back");
		b9.addActionListener(new mymonitor9(this));
		add(b9,BorderLayout.SOUTH);
		
		p.add(p1);
		p.add(p2);
		
		pp.add(p);///main
		
		Panel p11 = new Panel(new GridLayout(1,2));
		Panel p111 = new Panel();
		Panel p112 = new Panel();
		Label l11 = new Label("输入学号");
		num1 = new TextField(10);
		num2 = new TextArea(5,20);
		p111.add(l11);
		p111.add(num1);
		p112.add(num2);
		Button b11 = new Button("查询");
		b11.addActionListener(new mymonitor11(this));
		p111.add(b11);
		
		p11.add(p111);
		p11.add(p112);
		pp.add(p11,"123");
		// an xue hao cha xun
		Panel pp11 = new Panel(new GridLayout(1,2));
		Panel pp111 = new Panel();
		Panel pp112 = new Panel();
		Label ll11 = new Label("输入姓名");
		num11 = new TextField(10);
		num22 = new TextArea(5,20);
		pp111.add(ll11);
		pp111.add(num11);
		pp112.add(num22);
		Button bb11 = new Button("查询");
		bb11.addActionListener(new mymonitor111(this));
		pp111.add(bb11);
		
		pp11.add(pp111);
		pp11.add(pp112);
		pp.add(pp11,"1234");
		// anxingming 查询
		Panel myp = new Panel(new GridLayout(1,2));
		Panel myp1 = new Panel();
		Panel myp2 = new Panel();
		Label myl = new Label("输入专业");
		num111 = new TextField(10);
		num222 = new TextArea(5,20);
		myp1.add(myl);
		myp1.add(num111);
		myp2.add(num222);
		Button zhuanye = new Button("查询");
		zhuanye.addActionListener(new mymonitor1111(this));
		myp1.add(zhuanye);
		myp.add(myp1);
		myp.add(myp2);
		
		pp.add(myp,"12345");
		// an zhuanye 查询
		Panel course = new Panel(new GridLayout(1,2));
		Panel course1 = new Panel();
		Panel course2 = new Panel();
		Label courseLabel = new Label("输入学生姓名");
		course1.add(courseLabel);
		courseText1 = new TextField(10);
		courseText2 = new TextArea(5,20);
		course1.add(courseText1);
		course2.add(courseText2);
		Button courseButton = new Button("查询");
		courseButton.addActionListener(new courseMonitor(this));
		course1.add(courseButton);
		
		course.add(course1);
		course.add(course2);
		pp.add(course,"course");
		// cha cun suo xiu ke cheng 
		Panel bicourse = new Panel(new GridLayout(1,2));
		Panel bicourse1 = new Panel();
		Panel bicourse2 = new Panel();
		Label bicourseLabel = new Label("输入学生姓名");
		bicourse1.add(bicourseLabel);
		bicourseText1 = new TextField(10);
		bicourseText2 = new TextArea(5,20);
		bicourse1.add(bicourseText1);
		bicourse2.add(bicourseText2);
		Button bicourseButton = new Button("查询");
		bicourseButton.addActionListener(new bicourseMonitor(this));
		bicourse1.add(bicourseButton);
		
		bicourse.add(bicourse1);
		bicourse.add(bicourse2);
		pp.add(bicourse,"bicourse");
		//bixiuke ping ju chengji 
		Panel scourse = new Panel(new GridLayout(1,2));
		Panel scourse1 = new Panel();
		Panel scourse2 = new Panel();
		Label scourseLabel = new Label("输入学生姓名");
		scourse1.add(scourseLabel);
		scourseText1 = new TextField(10);
		scourseText2 = new TextArea(5,20);
		scourse1.add(scourseText1);
		scourse2.add(scourseText2);
		Button scourseButton = new Button("查询");
		scourseButton.addActionListener(new scourseMonitor(this));
		scourse1.add(scourseButton);
		
		scourse.add(scourse1);
		scourse.add(scourse2);
		pp.add(scourse,"scourse");
		//suoyouke pingjuunn fen 
		Panel beteach = new Panel(new GridLayout(1,2));
		Panel beteach1 = new Panel();
		Panel beteach2 = new Panel();
		Label beteachLabel = new Label("输入学生姓名");
		beteach1.add(beteachLabel);
		beteachText1 = new TextField(10);
		beteachText2 = new TextArea(5,20);
		beteach1.add(beteachText1);
		beteach2.add(beteachText2);
		Button beteachButton = new Button("查询");
		beteachButton.addActionListener(new beteachMonitor(this));
		beteach1.add(beteachButton);
		
		beteach.add(beteach1);
		beteach.add(beteach2);
		pp.add(beteach,"beteach");
		
		//beijiao guo de laoshi
		Panel bad = new Panel(new GridLayout(1,2));
		Panel bad1 = new Panel();
		Panel bad2 = new Panel();
		Label badLabel = new Label("即将被开除的学生");
		bad1.add(badLabel);
		badText1 = new TextField(10);
		badText2 = new TextArea(5,20);
//		bad1.add(badText1);
		bad2.add(badText2);
		Button badButton = new Button("查询");
		badButton.addActionListener(new badMonitor(this));
		bad1.add(badButton);
		
		bad.add(bad1);
		bad.add(bad2);
		pp.add(bad,"bad");
		
		//jijiang bei kaichu de xuesh 
		Panel st = new Panel(new GridLayout(8,2));
		Label stLabel1 = new Label("学号");
		st.add(stLabel1);
		stText1 = new TextField(5);
		st.add(stText1);
		Label stLabel2 = new Label("姓名");
		st.add(stLabel2);
		stText2 = new TextField(5);
		st.add(stText2);
		Label stLabel3 = new Label("性别");
		st.add(stLabel3);
		stText3 = new TextField(5);
		st.add(stText3);
		Label stLabel4 = new Label("出生年月");
		st.add(stLabel4);
		stText4 = new TextField(5);
		st.add(stText4);
		Label stLabel5 = new Label("年龄");
		st.add(stLabel5);
		stText5 = new TextField(5);
		st.add(stText5);
		Label stLabel6 = new Label("班级");
		st.add(stLabel6);
		stText6 = new TextField(5);
		st.add(stText6);
		Label stLabel7 = new Label("专业");
		st.add(stLabel7);
		stText7 = new TextField(5);
		st.add(stText7);
		
		
		stText22 = new TextArea(1,10);
		st.add(stText22);
		Button stButton = new Button("录入");
		stButton.addActionListener(new stMonitor(this));
		st.add(stButton);
		
		pp.add(st,"st");
		
		//luru xuesh xinxi
		Panel grade = new Panel(new GridLayout(8,2));
		Label gradeLabel1 = new Label("学号");
		grade.add(gradeLabel1);
		gradeText1 = new TextField(5);
		grade.add(gradeText1);
		Label gradeLabel2 = new Label("课程");
		grade.add(gradeLabel2);
		gradeText2 = new TextField(5);
		grade.add(gradeText2);
		Label gradeLabel3 = new Label("分数");
		grade.add(gradeLabel3);
		gradeText3 = new TextField(5);
		grade.add(gradeText3);
		
		
		gradeText22 = new TextArea(1,10);
		grade.add(gradeText22);
		Button gradeButton = new Button("录入");
		gradeButton.addActionListener(new gradeMonitor(this));
		grade.add(gradeButton);
		pp.add(grade,"grade");
		//luru chengji
		
		add(pp);
		setVisible(true);
	}
	
	class myWindowMonitor extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			setVisible(false);
			System.exit(0);
		}
	}
}
class gradeMonitor implements ActionListener
{
	MyFrame f = null;
	
	public gradeMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s1 = f.gradeText1.getText();
		String s2 = f.gradeText2.getText();
		int s5 = Integer.parseInt(f.gradeText3.getText());

//		System.out.println(s1+s2+s3+s4+s5+s6+s7);
		 try {
	            int n = f.stmt.executeUpdate("insert into studentcourse(sno,cno,scgrade) values('"+s1
	            		+ "','"+s2
	            		+ "','"+s5
	            		+ "')");
	            if(n != 0)
	            	f.gradeText22.setText("成功");
	            else
	            	f.gradeText22.setText("失败");
	            
	            
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class stMonitor implements ActionListener
{
	MyFrame f = null;
	
	public stMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s1 = f.stText1.getText();
		String s2 = f.stText2.getText();
		String s3 = f.stText3.getText();
		String s4 = f.stText4.getText();
		int s5 = Integer.parseInt(f.stText5.getText());
		String s6 = f.stText6.getText();
		String s7 = f.stText7.getText();
//		System.out.println(s1+s2+s3+s4+s5+s6+s7);
		 try {
	            int n = f.stmt.executeUpdate("insert into student(Sno,Sname,Ssex,Sbirth,Sage,Sclass,Smajor) "
	            				+ "values('"+s1
	            				+ "','"+s2
	            				+ "','"+s3
	            				+ "','"+s4
	            				+ "','"+s5
	            				+ "','"+s6
	            				+ "','"+s7
	            				+ "'); update class set cnum = cnum+1 where cno = '"+s6
	            				+ "'");
	            if(n != 0)
	            	f.stText22.setText("成功");
	            else
	            	f.stText22.setText("失败");
	            
	            
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class badMonitor implements ActionListener
{
	MyFrame f = null;
	
	public badMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.badText1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select student.Sname from student,course,majorcourse,studentcourse "
	            				+ "where student.Sno = studentcourse.sno and "
	            				+ "studentcourse.cno = course.cno and "
	            				+ "studentcourse.cno = majorcourse.cno  and "
	            				+ "student.Smajor = majorcourse.mno and "
	            				+ "studentcourse.scgrade<60 group by student.Sname having SUM(credit)>12");
	            String x = "姓名          \n";
	            f.badText2.setText(x);
	            while (f.rs.next()) {
	                String sname = f.rs.getString("sname");
	                f.badText2.append(sname+"\n");
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class beteachMonitor implements ActionListener
{
	MyFrame f = null;
	
	public beteachMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.beteachText1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select distinct student.Sname,teacher.tname "
	            				+ "from student,teacher,studentcourse,teach "
	            				+ "where student.Sno=studentcourse.sno and "
	            				+ "studentcourse.cno=teach.tcno and "
	            				+ "teach.tclass=student.Sclass and student.Sname='"+s
	            				+ "' and teach.ttno=teacher.tno");
	            String x = "姓名             老师\n";
	            f.beteachText2.setText(x);
	            while (f.rs.next()) {
	                String sname = f.rs.getString("sname");
	                String tname = f.rs.getString("tname");
	                f.beteachText2.append(sname+tname+"\n");
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class bicourseMonitor implements ActionListener
{
	MyFrame f = null;
	
	public bicourseMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.bicourseText1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select SUM(studentcourse.scgrade*course.credit)/SUM(course.credit) "
	            				+ "from student,course,majorcourse,studentcourse "
	            				+ "where student.Sname = '"+s
	            				+ "' and student.Sno = studentcourse.sno and studentcourse.cno = "
	            				+ "course.cno and studentcourse.cno = majorcourse.cno and "
	            				+ "student.Smajor = majorcourse.mno and majorcourse.mctype='1'");
	            String x = "必修课平均分\n";
	            f.bicourseText2.setText(x);
	            while (f.rs.next()) {
	                int name = f.rs.getInt(1);
	                f.bicourseText2.append(name+"\n");
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class scourseMonitor implements ActionListener
{
	MyFrame f = null;
	
	public scourseMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.scourseText1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select SUM(studentcourse.scgrade*course.credit)/SUM(course.credit) "
	            				+ "from student,course,majorcourse,studentcourse "
	            				+ "where student.Sname = '"+s
	            				+ "' and student.Sno = studentcourse.sno and studentcourse.cno = "
	            				+ "course.cno and studentcourse.cno = majorcourse.cno and "
	            				+ "student.Smajor = majorcourse.mno ");
	            String x = "所有课平均分\n";
	            f.scourseText2.setText(x);
	            while (f.rs.next()) {
	            	int name = f.rs.getInt(1);
	                f.scourseText2.append(name+"\n");
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class courseMonitor implements ActionListener
{
	MyFrame f = null;
	
	public courseMonitor(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.courseText1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select student.Sname,course.cname,course.credit,majorcourse.mctype,majorcourse.term,"
	            				+ "studentcourse.scgrade"+" from student,course,majorcourse,studentcourse"+
	            				" where student.Sname = '"+s+"' and student.Sno = studentcourse.sno"+
	            				" and studentcourse.cno = course.cno and studentcourse.cno = majorcourse.cno"+
	            				" and student.Smajor = majorcourse.mno");
	            String x = "姓名              课程名              学分   类型 学期 成绩\n";
	            f.courseText2.setText(x);
	            while (f.rs.next()) {
	                String name = f.rs.getString("sname");
	                String thecourse = f.rs.getString("cname");
	                int credit = f.rs.getInt("credit");
	                String thetype = f.rs.getString("mctype");
	                String term = f.rs.getString("term");
	                String grade = f.rs.getString("scgrade");
	               
	                String y = "   ";
	                f.courseText2.append(name+thecourse+y+credit+y+thetype+y+term+y+grade+"\n");
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class mymonitor11 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor11(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.num1.getText();
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select student.*,major.mname from student,major where Sno ="
	            + s +" and student.smajor = major.mno");
	            while (f.rs.next()) {
	                String name = f.rs.getString("sname");
	                String Sno = f.rs.getString("Sno");
	                String sex = f.rs.getString("Ssex");
	                String birth = f.rs.getString("Sbirth");
	                int age = f.rs.getInt("Sage");
	                String theclass = f.rs.getString("Sclass");
	                String major = f.rs.getString("mname");
	                String x = "学号       姓名              性别   出生年月     年龄    班级    专业\n";
	                String y = "   ";
	                f.num2.setText(x+Sno+name+sex+y+birth+age+y+theclass+major);
	            } 
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class mymonitor111 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor111(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.num11.getText();
//		System.out.println(s);
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select student.*,major.mname from student,major where sname = '"
	         +s+"' and student.smajor = major.mno");
//	            System.out.println(s);
	            while (f.rs.next()) {
	                String name = f.rs.getString("Sname");
	                String Sno = f.rs.getString("Sno");
	                String sex = f.rs.getString("Ssex");
	                String birth = f.rs.getString("Sbirth");
	                int age = f.rs.getInt("Sage");
	                String theclass = f.rs.getString("Sclass");
	                String major = f.rs.getString("mname");
	                String x = "学号       姓名              性别   出生年月     年龄    班级    专业\n";
	                String y = "   ";
	                f.num22.setText(x+Sno+name+sex+y+birth+age+y+theclass+major);
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}
class mymonitor1111 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor1111(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{	
		String s = f.num111.getText();
//		System.out.println(s);
		 try {
	            f.rs = f.stmt.executeQuery
	            		("select student.*,major.mname from student,major where major.mname = '"
	         +s+"' and student.smajor = major.mno");
	            String x = "学号       姓名              性别   出生年月     年龄    班级    专业\n";
	            f.num222.setText(x);
	            while (f.rs.next()) {
	                String name = f.rs.getString("Sname");
	                String Sno = f.rs.getString("Sno");
	                String sex = f.rs.getString("Ssex");
	                String birth = f.rs.getString("Sbirth");
	                int age = f.rs.getInt("Sage");
	                String theclass = f.rs.getString("Sclass");
	                String major = f.rs.getString("mname");
	                String y = "   ";
	                f.num222.append(Sno+name+sex+y+birth+age+y+theclass+major+'\n');
	            }
	        } catch (SQLException x) {
	            x.printStackTrace();
	            System.out.println("数据库连接失败!");
	        }
	}
}

class mymonitor2 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor2(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"course");
		f.courseText1.setText("");
		f.courseText2.setText("");
	}
}
class mymonitor3 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor3(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"bicourse");
		f.bicourseText1.setText("");
		f.bicourseText2.setText("");
	}
}
class mymonitor4 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor4(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{

		f.c.show(f.pp,"scourse");
		f.scourseText1.setText("");
		f.scourseText2.setText("");
	}
}

class mymonitor5 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor5(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"beteach");
		f.beteachText1.setText("");
		f.beteachText2.setText("");
	}
}
class mymonitor6 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor6(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"bad");
		f.badText1.setText("");
		f.badText2.setText("");
	}
}
class mymonitor7 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor7(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"st");
		f.stText1.setText("");
		f.stText22.setText("");
		f.stText2.setText("");
		f.stText3.setText("");
		f.stText4.setText("");
		f.stText5.setText("");
		f.stText6.setText("");
		f.stText7.setText("");
		
	}
}
class mymonitor8 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor8(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"grade");
		f.gradeText1.setText("");
		f.gradeText22.setText("");
		f.gradeText2.setText("");
		f.gradeText3.setText("");
	}
}
class mymonitor9 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor9(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.first(f.pp);
		//new level2(f);
	}
}

class mymonitor1 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitor1(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"123");
		f.num1.setText("");
		f.num2.setText("");
	}
}
class mymonitorm1 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitorm1(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"1234");
		f.num11.setText("");
		f.num22.setText("");
	}
}
class mymonitormm1 implements ActionListener
{
	MyFrame f = null;
	
	public mymonitormm1(MyFrame f)
	{
		this.f = f;
	}
	public void actionPerformed(ActionEvent e)
	{
		f.c.show(f.pp,"12345");
		f.num111.setText("");
		f.num222.setText("");
	}
}
