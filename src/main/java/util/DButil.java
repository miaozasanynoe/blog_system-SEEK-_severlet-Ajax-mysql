package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * util工具类
 * @author yangchaoyi
 *
 */
public class DButil {
	
	 //声明Connection对象
    Connection con;
    //驱动程序名
    static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名mydata
    String url = "jdbc:mysql://119.27.167.223:3306/shixun";
    //MySQL配置时的用户名
    String user = "root";
    //MySQL配置时的密码
    String password = "wuruofeng920205";
    //1、执行静态方法,加载数据库驱动
    static {
        try {
            System.out.println("正在加载数据库驱动...");
            Class.forName(driver);
            System.out.println("已加载数据库驱动！！！\n");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //2、创建数据库连接的方法
    public Connection getConnection() {
        try {
            System.out.println("正在连接到数据库...");
            con = DriverManager.getConnection(url,user,password);
            System.out.println("已连接到MySQL数据库！！！\n");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //3、关闭数据库连接，释放JDBC资源的方法
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                System.out.println("准备释放jdbc资源，断开数据库连接...");
                System.out.println("connection.close();");

                connection.close();//立即释放jdbc资源，而不是等自动释放

                System.out.println("已断开数据库连接并且释放了jdbc资源\n");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}


