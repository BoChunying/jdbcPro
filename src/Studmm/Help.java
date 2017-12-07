package Studmm;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Help {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class myPanel
{
//	myPanel
	public Panel mPanel(TextField t1,TextArea t2)
	{
		Panel p1= null;
		Panel course = new Panel(new GridLayout(1,2));
		Panel course1 = new Panel();
		Panel course2 = new Panel();
		Label courseLabel = new Label("输入学生姓名");
		course1.add(courseLabel);
		t1 = new TextField(10);
		t2 = new TextArea(5,20);
		course1.add(t1);
		course2.add(t2);
		course.add(course1);
		course.add(course2);		
		return course;
	}
}
