var app = angular.module('myApp', []);
app.controller('UserController', function($scope, $http) {
	$scope.clients = [];
	
	var getClients = function () {
		$http.get('/rest-example/clients').then(function(response) {
			$scope.clients = response.data;
			$scope.reset();
		}, function(){});
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
	}
	
	$scope.edit = function(client) {
		$scope.client = client;
	}
	
	$scope.remove = function(client) {
		$http.delete('/rest-example/clients/' + client.id).then(getClients, function(){});
	}
	
	$scope.reset = function() {
		$scope.client = { id: null, name: null }
	}
	
	$scope.reset();
	getClients();
	
});