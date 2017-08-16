angular.module('ngBoilerplate.account', ['ui.router'])
.config(function($stateProvider) {
	$stateProvider.state('login', {
		url:'/login',
		views: {
			'main': {
				templateUrl:'account/login.tpl.html',
				controller: "LoginCtrl"
			}
		},
		data : {pageTitle : "Login"}
	})
	.state('register', {
		url:'/register',
		views: {
			'main': {
				templateUrl:'account/register.tpl.html',
				controller: 'RegisterCtrl'
			}
		},
		data : {pageTitle : "Registeration"}
	});
})
.factory('sessionService', function() {
	var session = {};
	session.login = function(data) {
		alert('User logged in with credentials ' + data.name + ' and  ' + data.password);
		localStorage.setItem("session", data);
	};
	session.logout = function() {
		localStorage.removeItem("session");
	};
	session.isLoggedIn = function() {
		return localStorage.getItem("session") !== null;
	};
	return session;
})
.controller("LoginCtrl", function($scope, sessionService, $state) {
	$scope.login = function() {
//		alert('user logged in with '+ $scope.account.name + ' and ' + $scope.account.password);
		sessionService.login($scope.account);
		$state.go("home");
	};
})
.controller("RegisterCtrl", function($scope, sessionService, $state) {
	$scope.register = function() {
//		alert('user registered with '+ $scope.account.name + ' and ' + $scope.account.password);
		sessionService.login($scope.account);
		$state.go("home");
	};
});