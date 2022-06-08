<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String error = (String) request.getAttribute("error");
    String str = new String("");
%>
<form method="post" action="${pageContext.request.contextPath}/student/list">
    <div>
        <label>班级名</label>
        <input name="cname" value="">
    </div>
    <div>
        <label>学生名</label>
        <input name="sname" value="">
    </div>
    <div>
        <button type="submit">查找</button>
    </div>
</form>
<table>
    <tr >
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>班级</th>
    </tr>
    <c:if test="${error!=null}">
        ${error}
    </c:if>
    <div>
        <button><a href="${pageContext.request.contextPath}/jsp/studentAdd.jsp" >添加学生</a></button>
    </div>
<c:forEach var="student" items="${studentList}" varStatus="status">
    <tr>
        <td>
            <span>${student.sname}</span>
        </td>
        <td>
            <span>
                <c:if test="${student.gender==0}">
                    男
                </c:if>
                <c:if test="${student.gender==1}">
                    女
                </c:if>
            </span>
        </td>
        <td>
            <span>${student.age}</span>
        </td>
        <td>
            <span>${student.cname}</span>
        </td>
        <td>
                 <span>
                <c:if test="${student.photo.trim()!=null||student.photo==''}">
                    <a href="${pageContext.request.contextPath}/upload/${student.photo}">查看照片</a>
                </c:if>
                <c:if test="${student.photo==null&&student.photo!=''}">
<%--                     <form method="post" action="${pageContext.request.contextPath}/student/addPhoto" enctype="multipart/form-data">--%>
<%--                         <input name="headURL" type="file" />--%>
<%--                         <input name="id" value="${student.id}" type="hidden">--%>
<%--                         <button type="submit">上传</button>--%>
<%--                     </form>--%>
                    <a href="${pageContext.request.contextPath}/student/to-upload/${student.id}">添加照片</a>
                </c:if>
            </span>
        </td>
        <td>
            <span><a href="${pageContext.request.contextPath}/student/to-modStudent/${student.id}">修改</a></span>
        </td>
        <td>
            <span><a href="${pageContext.request.contextPath}/student/delStudent/${student.id}">删除</a></span>
        </td>
    </tr>
</c:forEach>
</table>