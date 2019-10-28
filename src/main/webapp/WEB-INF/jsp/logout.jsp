<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Logout Page</title>
</head>
<body>

<form action="logout" method="post">

    <input type="submit" value="logout" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

</body>
</html>