<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <script src="../jquery-1.11.3.min.js" ></script>
</head>
<body>
<center>
        <h1>查询页面</h1>
        <a href="/toAddPage">新增</a>
        <table border="1">
            <tr>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>住址</td>
                <td>生日</td>
                <td>操作</td>
            </tr>
            <#list list as item>
                <tr>
                    <td>${item.userId}</td>
                    <td>${item.userName}</td>
                    <td>${item.userAge}</td>
                    <td>
                        <#if item.userSex == 1>
                            男
                            <#elseif item.userSex == 2>
                            女
                        </#if>
                    </td>
                    <td>${item.userAddress}</td>
                    <td>
                        <font color="red"> ${item.userBir?string('yyyy­MM­dd')} </font><br>
                    </td>
                    <td>
                        <a href=javascript:del(${item.userId})>删除</a>
                        <a href="/toUpdatePage/${item.userId}">修改</a>
                    </td>
                </tr>
            </#list>
        </table>
</center>
        <#--<form method="post" id="f">
            <input type="hidden" name="_method" value="DELETE"/>
        </form>-->
        <form method="post" id="formId">
            <input type="hidden" name="_method" value="DELETE">
        </form>
        <script>
            function del(id){
                $("#formId").prop("action","/user/"+id);
                $("#formId").submit();
            }
        </script>
</body>
</html>