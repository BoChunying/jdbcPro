package jdbcPro;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=mydatabase;";
        String sql1 = "select * from course;";
//        String sql2 = "FROM S-CLASS;";
        
        try {
            //1.�����������������
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("δ������..");
        }
        
        try {
            //2.ͨ��������DriverManager��ȡ�����ݿ������
        	conn = DriverManager.getConnection(url, "sa", "741963bcy");
        } catch (SQLException e) {
            System.out.println("�޷��������ݿ�..");
        }
        
        try {
             // ����Statement����
            stmt = conn.createStatement();
            /**
             * Statement createStatement() ����һ�� Statement �������� SQL ��䷢�͵����ݿ⡣
             */
            // ִ�����ݿ��ѯ���
            rs = stmt.executeQuery(sql1);
//          rs = stmt.executeQuery(sql1);
            /**
             * ResultSet executeQuery(String sql) throws SQLException ִ�и����� SQL
             * ��䣬����䷵�ص��� ResultSet ����
             */
            while (rs.next()) {
                String name = rs.getString("cno");
                String age = rs.getString("cname");
                System.out.println("\tSame:" + name + "\tSage:" + age);
            }
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("���ݿ�����ʧ��!");
        }
    }
}