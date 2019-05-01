'use strict'

var app=angular.module('employeeRegApp',['ngRoute']);

app.config(['$routeProvider','$locationProvider', function ($routeProvider,$locationProvider) {
	$locationProvider.hashPrefix('');
    $routeProvider.when('/register', {
        templateUrl: 'views/employeeRegistration.html',
        controller:'EmployeeCtrl'
    });
   /* $routeProvider.otherwise({redirectTo: '/'});*/
}]);


app.controller('EmployeeCtrl',['$http',function($http){
	var self=this;
	self.employee={};
	self.items=[];
	var fetchEmployees=function(){
		return $http.get('/rest/api/employees').then(
				function(response){
					self.items=response.data;
				},function(errResponse){
					console.error('Error while fetching employees');
				});
	};
	fetchEmployees();
	self.register=function(){
		$http.post('/rest/api/registerEmployee',self.employee)
			.then(fetchEmployees)
			.then(function(response){
				self.employee={};
			},function(errResponse){
				console.error(errResponse)
			});
	}
}]);