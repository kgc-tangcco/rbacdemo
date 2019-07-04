package cn.kgc.tangcco.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
   //数据源
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	//获取数据源
	public static DataSource getDataSource(){
		return dataSource;
	}
	//获取数据连接对象
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	} 
	//释放资源
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (stmt!=null) {
				stmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
