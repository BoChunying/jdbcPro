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
            //1.反射加载驱动程序类
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("未发现类..");
        }
        
        try {
            //2.通过驱动类DriverManager获取与数据库的连接
        	conn = DriverManager.getConnection(url, "sa", "741963bcy");
        } catch (SQLException e) {
            System.out.println("无法连接数据库..");
        }
        
        try {
             // 建立Statement对象
            stmt = conn.createStatement();
            /**
             * Statement createStatement() 创建一个 Statement 对象来将 SQL 语句发送到数据库。
             */
            // 执行数据库查询语句
            rs = stmt.executeQuery(sql1);
//          rs = stmt.executeQuery(sql1);
            /**
             * ResultSet executeQuery(String sql) throws SQLException 执行给定的 SQL
             * 语句，该语句返回单个 ResultSet 对象
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
            System.out.println("数据库连接失败!");
        }
    }
}