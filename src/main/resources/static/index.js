angular.module('app', []).controller('indexController', function ($scope, $http){
    const contextPath = 'http://127.0.0.1:8189/app';

    $scope.loadProduct = function (){
        $http.get(contextPath + '/product/all')
            .then(function (response){
                $scope.productList = response.data;
            });
    };


    $scope.changeCost = function (productId, delta){
        $http({
            url: contextPath + '/product/change_cost',
            method: 'GET',
            params: {
                productId : productId,
                delta : delta
            }
        }).then(function (response){
            $scope.loadProduct();
        });
    };

    $scope.deleteProduct = function (productId){
        $http.get(contextPath + '/product/delete/' + productId)
            .then(function (response){
            $scope.loadProduct();
        });
    }

    $scope.loadProduct();

});