<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
    <form method="post" action="${pageContext.request.contextPath}/class/modClass">
        <input name="id" value="${id}" type="hidden"/>
        <label>
            班级名:
        </label>
        <input name="className" value="">
        <button type="submit">提交</button>
    </form>
</div>