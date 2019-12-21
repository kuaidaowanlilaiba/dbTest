package test2.com.db;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static BasicDataSource getSource()
    {
    	BasicDataSource basicDataSource=new BasicDataSource();
    	basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/how2java");
    	basicDataSource.setUsername("root");
    	basicDataSource.setPassword("mysql");    	
        System.out.println( basicDataSource);
        return basicDataSource;
    }
    
    public static void main(String[] args) throws SQLException {
		BasicDataSource basicDataSource=App.getSource();
		QueryRunner queryRunner=new QueryRunner(basicDataSource);
		List<Object[]> result=queryRunner.query("select * from hero", new ArrayListHandler());
		for (Object[] objects : result) {
			for (Object object : objects) {
				System.out.print(object+"  ");

			}
			System.out.println();

		}
		System.out.println("++++++");
		
		QueryRunner queryRunner1=new QueryRunner(JDBCUtil.getSource());
		List<Object[]> result1=queryRunner1.query("select * from hero", new ArrayListHandler());
		for (Object[] objects : result1) {
			for (Object object : objects) {
				System.out.print(object+"  ");

			}
			System.out.println();

		}
	}
}




class JDBCUtil{
	
	
	
	static BasicDataSource basicDataSource=new BasicDataSource();
	
	static{
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
    	basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/how2java");
    	basicDataSource.setUsername("root");
    	basicDataSource.setPassword("mysql"); 
	}
	
	public static DataSource getSource(){
		return basicDataSource;
	}
}
