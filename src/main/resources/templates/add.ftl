<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add</title>
</head>
<body>
    <center>
        <h1>新增页面</h1>
        <form action="/addUser" method="post">
            姓名:<input type="text" name="userName"/>
            <br/>
            年龄:<input type="text" name="userAge"/>
            <br/>
            性别:<input type="radio" name="userSex" value="1"/>男
                 <input type="radio" name="userSex" value="2"/>女
            <br/>
            住址:<input type="text" name="userAddress">
            <br/>
            生日:<input type="text" name="userBir">
            <br/>
            <input type="submit"/>
        </form>
    </center>
</body>
</html>