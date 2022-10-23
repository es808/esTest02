<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="c" class="com.sist.vo.CustomerVO"/>
	<jsp:useBean id="dao" class="com.sist.dao.CustomerDAO"/>
	<jsp:setProperty property="*" name="c"/>
	<%
		int re=dao.insertCustomer(c);
		if(re==1){
			%>
			<script type="text/javascript">
				alert("회원가입을 축하합니다.");
			</script>
			<%
		}else{
			%>
			<script type="text/javascript">
				alert("다시 시도해주세요.");
			</script>
			<%
		}
	%>
</body>
</html>