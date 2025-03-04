package db;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


public class SqlEx {
			
			
		    static {
		        try {
		            Class.forName("oracle.jdbc.driver.OracleDriver");
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		    }

		    public static void main(String[] args) throws NoSuchElementException{
		        // 인터페이스 객체 선언
		        Connection con = null;
		        Statement stmt = null;
		        ResultSet rs = null;
		       
		        // connection 연결
		        try {
		            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:system", "hr", "hr"); 

		            // sql문 전송, 실행
		            stmt = con.createStatement();
		            //메뉴출력
		           
		           
		            //단어전체 검색
		            String sql = "select * from WORDTABLE";

		            rs = stmt.executeQuery(sql); 
		            

		            System.out.println("select * from WORDTABLE;");
		            while (rs.next()) { 
		               // int employee_id = rs.getInt("employee_id");
		               // int salary = rs.getInt("salary");
		                //String first_name = rs.getString("first_name");
		               // String last_name = rs.getString("last_name");
		                String ENGWORD = rs.getString("ENGWORD");
		                String KRWORD = rs.getString("KRWORD");
		                String INIDATE = rs.getString("INIDATE");

		               // System.out.println(employee_id + " " + first_name + " " + last_name+ " " +salary);
		               
		               
		                System.out.println(ENGWORD + " " + KRWORD + " " + INIDATE);
		            } 
		            /*
		            try {
		            	
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}*/
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } finally { // 객체 close. 
		            if (rs != null) { // ResultSet이 null이 아닌 경우에 실행
		                try {
		                    rs.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		            if (stmt != null) { // Statement이 null이 아닌 경우에 실행
		                try { 
		                    stmt.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		            if (con != null) { // Connection이 null이 아닌 경우에 실행
		                try {
		                    con.close();
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
		   
	}

