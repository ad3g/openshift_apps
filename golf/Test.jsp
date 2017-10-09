<!DOCTYPE html>
<html>
<head>
 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      
    <title>Insert Products</title>
     
    <!-- include material design CSS -->
    <link rel="stylesheet" href="css/materialize.min.css" />
     
    <!-- include material design icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
     
     <!-- custom CSS -->
<style>
.width-30-pct{
    width:30%;
}
 
.text-align-center{
    text-align:center;
}
 
.margin-bottom-1em{
    margin-bottom:1em;
}
</style>
     
     
</head>
<body>
 
<!-- page content and controls will be here -->


<!-- page end here -->
 
<!-- include jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- material design js -->
<script src="js/materialize.min.js"></script>
 
<!-- include angular js -->
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
 
<script>
// angular js codes will be here
 
// jquery codes will be here

</script>
 

<!-- used for searching the current list -->
<input type="text" ng-model="search" class="form-control" placeholder="Search product..." />
 
<!-- table that shows product record list -->
<table class="hoverable bordered">
 
    <thead>
        <tr>
            <th class="text-align-center">ID</th>
            <th class="width-30-pct">Name</th>
            <th class="width-30-pct">Description</th>
            <th class="text-align-center">Price</th>
            <th class="text-align-center">Action</th>
        </tr>
    </thead>
 
    <tbody ng-init="getAll()">
        <tr ng-repeat="d in names | filter:search">
            <td class="text-align-center">{{ d.id }}</td>
            <td>{{ d.name }}</td>
            <td>{{ d.description }}</td>
            <td class="text-align-center">{{ d.price }}</td>
            <td>
                <a ng-click="readOne(d.id)" class="waves-effect waves-light btn margin-bottom-1em"><i class="material-icons left">edit</i>Edit</a>
                <a ng-click="deleteProduct(d.id)" class="waves-effect waves-light btn margin-bottom-1em"><i class="material-icons left">delete</i>Delete</a>
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>