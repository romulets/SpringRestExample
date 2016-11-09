<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" href="/rest-example/resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="/rest-example/resources/styles/main.css" />

<script src="/rest-example/resources/scripts/angular.min.js"></script>
<script src="/rest-example/resources/scripts/main.js"></script>

</head>

<body ng-app="myApp"
	  ng-controller="UserController">
	<nav class="navbar navbar-fixed-top navbar-dark bg-inverse">
	      <a class="navbar-brand" href="/rest-example">Spring Rest Example</a>
	      <ul class="nav navbar-nav">
	      </ul>
    </nav>

	<div class="container">
		
		<h2>Clients</h2>

		<hr />
			
		<div class="col-md-6">
			<div class="card">
				<div ng-if="client.id === null" class="card-header">
					Adding new client
				</div>
				<div ng-if="client.id !== null" class="card-header">
					Editing Client {{ client.id }} - {{ client.name }}
				</div>
				
				<div class="card-block">
					<div class="form-group">
						<label for="name">Client Name:</label>
						<input type="text" id="name" class="form-control form-control-sm" ng-model="client.name"/>
					</div>
					
					<button class="btn btn-default" ng-click="save();">Save</button>
					<button class="btn btn-warning" ng-click="reset();">Reset Form</button>
				</div>
			</div>			
		</div>
			
		<div class="col-md-6">
			
			<div class="card">
				
				<div class="card-header">
					Clients list
				</div>
				
				<div class="card-block">
					<div class="form-group">
						<label for="search">Search clients:</label>
						<input type="text" id="search" class="form-control form-control-sm" ng-model="searchText"/>
					</div>
						
					<table class="table table-bordered">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<tr ng-repeat="client in clients | filter:searchText"> 
							<td>{{ client.id }}</td>
							<td>{{ client.name }}</td>
							<td><button class="btn btn-info btn-sm btn-block" ng-click="edit(client);">Edit</button></td>
							<td><button class="btn btn-danger btn-sm btn-block" ng-click="remove(client);">Delete</button></td>
						</tr>
					</table>
				</div>
				</div>
				
			</div>				
		
		</div>	
</body>

</html>