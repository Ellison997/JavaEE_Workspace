<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String user = "";
	Object oUser = session.getAttribute("user");
	//System.out.print(oUser);
	if (oUser != null) {
		user = (String) oUser;

	} else {
		request.getRequestDispatcher("login.jsp").forward(request,
				response);
	}
%>