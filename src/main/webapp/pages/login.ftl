<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Please input your names, seperator with '-' char.</title>
</head>
<body>
<#include "./header.ftl"/>
<form action="greeting" method="POST">
    Names:
    <input type="text" name="username"/><br>
    Password:
    <input type="password" name="user.password"/><br>
    <input type="submit" value="submit"/>
</form>
<!--use include to include another ftl file content in this file.-->
<#include "./footer.ftl"/>
</body>
</html>