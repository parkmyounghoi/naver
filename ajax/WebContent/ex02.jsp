<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
	String result = "";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		conn = DriverManager
			.getConnection("jdbc:sqlserver://192.168.0.200:1433;database=mh_20200611",
							"sa",
							"8765432!");
	
		pstmt = conn.prepareStatement("select * from freeboard");
		rs = pstmt.executeQuery();
		while(rs.next()){
			result += ( "<br/> title = "+rs.getString("title") 
							+ " content = "+rs.getString("content")+"<br/>" ); 
		}
		out.println(result);
	}catch(Exception e){
		e.printStackTrace();	
	}
%>



