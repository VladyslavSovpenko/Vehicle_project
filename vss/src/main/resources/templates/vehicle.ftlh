<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Vehicle`s list</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>

<body>
<h2>All vehicles!</h2>
<a href="/login"> Log in</a>

<br><br>

<form action="/vehicles" method="get">
   Search by model <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>

<table border="1">

    <tr>
        <th>Id</th>
        <th>Model</th>
        <th>Engine</th>
        <th>Year</th>
        <th>Owner</th>
        <th></th>
    </tr>

    <#list vehicles as vehicle>
        <tr>
            <td>${vehicle.id}</td>
            <td>${vehicle.name}</td>
            <td>${vehicle.engine}</td>
            <td>${vehicle.year}</td>
            <td>${vehicle.owner.name}</td>
            <td>
                        <a href="/vehicles/edit/${vehicle.id}">Edit</a>
            </td>
        </tr>
    </#list>

</table>

<form action="/vehicles/create" method="post" enctype="multipart/form-data">
    Model:<input type="text" name="name"><br><br>
    Engine:<input type="text" name="engine"><br><br>
    Year:<input type="text" name="year"><br><br>
    First image:    <input type="file" name="file1"><br><br>
    Second image:   <input type="file" name="file2"><br><br>
    Third image:    <input type="file" name="file3"><br><br>
    <input type="submit" value="ADD"/>
</form>

<div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
            <a href="/resident/new" type="button" class="btn btn-primary">New record</a>
        </div>
</div>
</body>
</html>
