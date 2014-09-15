<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html ng-app>
<head>
	<title>Home</title>
	<script type="text/javascript" src="resources/jquery.min.js"></script>
	<script type="text/javascript" src="resources/angular.min.js"></script>
	<meta http-equiv="pragma" content="no-cache" />
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div ng-controller="UserController">
<div ng-repeat="user in data.content">
        <span>{{user.id}}</span>
        <input ng-model="user.username" />
        <input ng-model="user.nickname" />
        <input ng-model="user.email" />
        <button ng-click="remove($index)" class="{{$index}}">Remove</button>
</div>
<div>
	<button></button>{{data.number}}/{{data.totalPages}}
</div>
</div>
 <script>
    function UserController($scope, $http) {
    	$http.get(
    				"user/searchPage", 
    				{params:{"page.page":4}}
    	).success(function(data) {
    		$scope.data = data;
    		console.log(data)
    	});
    	 $scope.remove = function(index){
             $scope.items.splice(index, 1);
         }
    }
    </script>
</html>
