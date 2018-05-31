<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update</title>
</head>
<body>
<center>
        <h1>修改页面</h1>
    <form action="/updateUser" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="userId" value="${user.userId}">
        姓名:<input type="text" name="userName" value="${user.userName}"/>
        <br/>
        年龄:<input type="text" name="userAge" value="${user.userAge}"/>
        <br/>
        性别:
            <#if user.userSex == 1>
             <input type="radio" name="userSex" value="${user.userSex}" checked/>男
                 <input type="radio" name="userSex" value="${user.userSex}" />女
                 <#elseif user.userSex ==2>
             <input type="radio" name="userSex" value="${user.userSex}" />男
                     <input type="radio" name="userSex" value="${user.userSex}" checked />女
            </#if>
        <br/>
        住址:<input type="text" name="userAddress" value="${user.userAddress}">
        <br/>
        生日:<input type="text" name="userBir" value="${user.userBir}">
        <br/>
        <input type="submit"/>
    </form>
</center>
</body>
</html>