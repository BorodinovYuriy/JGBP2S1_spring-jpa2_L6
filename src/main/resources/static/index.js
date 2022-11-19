angular.module('app',[]).controller('indexController', function($scope, $http){
    const contextPath = 'http://localhost:8180';
/*запрос списка продуктов*/
    $scope.fillTable = function() {
        $http.get(contextPath + '/products')
            .then(function(response) {
            $scope.ProductList = response.data;
            });
    }
/*удаление продукта*/
    $scope.deleteProductById = function(productId){
            $http.post(contextPath + '/products/delete/' + productId)
            .then(function(response) {
                $scope.fillTable();
            });
    }
/*добавление продукта*/
    $scope.submitCreateNewProduct = function(){
    /*alert("Отправка!"+ $scope.newProduct);*/
                $http.post(contextPath + '/products/add/', $scope.newProduct)
                    .then(function(response) {
                    $scope.fillTable();
                });
        }
    $scope.fillTable();
});
