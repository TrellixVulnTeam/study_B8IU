<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String dongValue = request.getParameter("dong");

Connection con = DBConnect.getCon();

Statement stmt = con.createStatement();

String sql = "select * from ziptb where dong like '" + dongValue + "%'";

ResultSet rs = stmt.executeQuery(sql);
%>
[
<%
	int i = 0;
	while (rs.next()) {
		if (i > 0) out.print(",");
		String zipcode = rs.getString("zipcode");
		String addr = rs.getString("sido") + " " + rs.getString("gugun") + " " + rs.getString("dong");
		String bungi = rs.getString("bunji");
%>
		{
			"zipcode" : "<%= zipcode %>",
			"addr" : "<%= addr %>",
<%
	if (bungi != null) {
%>
			"bungi" : "<%= bungi %>"
<%
	} else {
%>
			"bungi" : ""
<%
	}
%>
		}
<%
		i++;
	}
%>
]