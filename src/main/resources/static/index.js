angular.module('app', []).controller('indexController', function ($scope, $http){
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProduct = function (){
        $http.get(contextPath + '/product/all')
            .then(function (response){
                $scope.productList = response.data;
            })
    };

    $scope.loadProduct();

});