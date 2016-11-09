var app = angular.module('myApp', []);
app.controller('UserController', function($scope, $http) {
	$scope.clients = [];
	
	var getClients = function () {
		$http.get('/rest-example/clients').then(function(response) {
			$scope.clients = response.data;
			reset();
		}, function(){});
	}
	
	var reset = function() {
		$scope.client = { id: null, name: null }
	}
	
	var insertClient = function() {
		$http.post('/rest-example/clients', $scope.client).then(getClients, function(){});
	}
	
	var updateClient = function() {
		$http.put('/rest-example/clients/' + $scope.client.id, $scope.client).then(getClients, function(){});
	}
	
	$scope.save = function() {
		if($scope.client.id === null)
			insertClient();
		else
			updateClient();
		
		$('#modalForm').modal('hide');
	}
	
	$scope.edit = function(client) {
		$scope.client = client;
		$('#modalForm').modal('show');
	}
	
	$scope.add = function(client) {
		reset();
		$('#modalForm').modal('show');
	}
	
	$scope.remove = function(client) {
		$http.delete('/rest-example/clients/' + client.id).then(getClients, function(){});
	}
	
	reset();
	getClients();
	
});