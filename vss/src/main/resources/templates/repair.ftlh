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

<form action="/vehicles" method="get">
   Search by model <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>

<table border="1">

    <tr>
        <th>Id</th>
        <th>Date</th>
        <th>Cost</th>
        <th>Vehicle_id</th>
        <th>Commentary</th>
        <th></th>
    </tr>

    <#list repairs as repair>
        <tr>
            <td>${repair.id}</td>
            <td>${repair.date}</td>
            <td>${repair.cost}</td>
            <td>${repair.vehicle_id}</td>
            <td>${repair.commentary}</td>
            <td>
                        <a href="/repair/edit/${repair.id}">Edit</a>
            </td>
        </tr>
    </#list>

</table>

<form action="/repair/create" method="post">
    Model:<input type="text" name="name"><br><br>
    Engine:<input type="text" name="engine"><br><br>
    Year:<input type="text" name="year"><br><br>
    <input type="submit" value="ADD">
</form>

<div class="row">
        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
            <div class="btn-group me-2" role="group" aria-label="Second group">
            <a href="/repair/new" type="button" class="btn btn-primary">New repair</a>
        </div>
</div>


</body>

</html>
