package com.restaurant.util;
import java.io.FileInputStream;
import com.restaurant.properties.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.*;

public class PropertyUtil {


	    private static Connection con ;


	    private PropertyUtil() {
	      // private constructor //
	    }

	    public static Connection getConnection() throws SQLException{
	    	Properties prop = new Properties();
	    	InputStream input = null;

	        if(con==null){
	            try {
	            	
					input = new FileInputStream("config.properties");
					prop.load(input);
	                String host = prop.getProperty("database");
	                String username = prop.getProperty("dbuser");
	                String password = prop.getProperty("dbpassword");
	                con = DriverManager.getConnection( host, username, password );
	                System.out.println("Connection established");
	            }  
	            catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	            catch (IOException exe) {
					exe.printStackTrace();
				}
	            catch (SQLException ex) {
	                
	            }
	            finally
	            {
	            	con.close();
	            }
	        }

	        return con;
	    }
}