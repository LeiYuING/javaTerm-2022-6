<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<form method="post" action="${pageContext.request.contextPath}/class/addClass">
    <label>
        班级名称:
    </label>
    <input name="className" value="">
    <button type="submit">提交</button>
</form>