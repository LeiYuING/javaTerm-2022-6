<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js">
    </script>
    <script>
        $(document).ready(function () {

            $('#up').click(
                function (){
                    var files = $('input[name="headURL"]').prop('files');//获取到文件列表
                    if (files.length == 0){
                        alert('文件不能为空')
                        return false
                    }else {
                        alert("提交成功")
                    }
                }
            )
        })
    </script>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/student/addPhoto" enctype="multipart/form-data">
    <input id="url" name="headURL" type="file" value="请上传照片"/>
    <input name="id" value="${id}" type="hidden"/>
    <input type="submit"  id="up" value="上传"/>
</form>
</body>
