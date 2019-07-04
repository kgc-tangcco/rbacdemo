package cn.kgc.tangcco.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
   //����Դ
	private static DataSource dataSource;
	static{
		dataSource=new ComboPooledDataSource();
	}
	//��ȡ����Դ
	public static DataSource getDataSource(){
		return dataSource;
	}
	//��ȡ�������Ӷ���
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	} 
	//�ͷ���Դ
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
