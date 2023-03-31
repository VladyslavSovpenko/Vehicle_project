<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vehicle`s list</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>

<body>
<h2>All vehicles!</h2>

<br><br>

<h4>Information about vehicle:</h4>

<form action="/vehicles/edit/${vehicle.id}" method="put">

    <#list images as img>
    <img src="/images/${img.id}" height="60px"/><br><br>
    </#list>

    <br><br>
    ID:<input type="text"     placeholder="id" value="${vehicle.id}" disabled name="name"><br><br>
    Model:<input type="text"  placeholder="model" value="${vehicle.name}" name="name"><br><br>
    Engine:<input type="text" placeholder="engine" value="${vehicle.engine}" name="engine"><br><br>
    Year:<input type="text"   placeholder="year" value="${vehicle.year}" name="year"><br><br>
    Owner:<input type="text"  placeholder="owner`s name" value="${vehicle.owner.name}" name="owner"><br><br>
    <input type="submit" value="Edit">
</form>

    <form action="/vehicles/delete/${vehicle.id}" method="post">
        <input type="submit" value="Delete">
    </form>

<div class="row">
    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group me-2" role="group" aria-label="Second group">
            <a href="/resident/new" type="button" class="btn btn-primary">New record</a>
        </div>
    </div>

</body>

</html>
