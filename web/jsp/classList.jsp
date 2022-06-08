<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String error = (String) request.getAttribute("error");
%>

    <div>
        <button><a href="${pageContext.request.contextPath}/jsp/classAdd.jsp" >添加班级</a></button>
    </div>
<table>
    <tr >
        <th>班级名称</th>
        <th>班级人数</th>
    </tr>
    <c:if test="${error!=null}">
        ${error}
    </c:if>
    <c:forEach var="classes" items="${classList}" varStatus="status">
        <tr>
            <td>
                <span>${classes.className}</span>
            </td>
            <td>
                <span>${classes.ssum}</span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/class/to-modClass/${classes.id}">修改</a></span>
            </td>
            <td>
                <span><a href="${pageContext.request.contextPath}/class/delClass/${classes.id}">删除</a></span>
            </td>
        </tr>
    </c:forEach>
</table>