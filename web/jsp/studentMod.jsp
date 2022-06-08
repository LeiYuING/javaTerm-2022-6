<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="post" action="${pageContext.request.contextPath}/student/modStudent">
        <input name="id" value="${id}" type="hidden"/>
        <label>
            姓名:
        </label>
        <input name="sname" value="">
        <label>
            性别:
        </label>
        女:<input type="radio" name="gender" value="1">
        男:<input type="radio" name="gender" value="0">
        <label>
            年龄:
        </label>
        <input name="age" value="">
        <label>
            班级:
        </label>
        <input name="cname" value="">
        <button type="submit">提交</button>
    </form>
</div>