<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" href="/rest-example/resources/styles/bootstrap.min.css" />
<link rel="stylesheet" href="/rest-example/resources/styles/main.css" />


<script src="/rest-example/resources/scripts/jquery.min.js"></script>
<script src="/rest-example/resources/scripts/bootstrap.min.js"></script>
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
		
		<h2>Clients <button class="btn btn-success btn-sm" ng-click="add();">New Client</button></h2>
		<hr />
			
		<div class="col-md-12">
			
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
		
		<div class="modal fade" id="modalForm">
		  	<div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			        <h4 ng-if="client.id === null" class="modal-title">Adding new client</h4>
			        <h4 ng-if="client.id !== null" class="modal-title">Editing Client {{ client.id }} - {{ client.name }}</h4>
			      </div>
			      <div class="modal-body">
			        <div class="card-block">
								<div class="form-group">
									<label for="name">Client Name:</label>
									<input type="text" id="name" class="form-control" ng-model="client.name"/>
								</div>
							</div>
			      </div>
			      <div class="modal-footer">
			      <button class="btn btn-success" ng-click="save();">Save</button>
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->	
</body>

</html>