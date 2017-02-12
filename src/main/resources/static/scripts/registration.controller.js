angular.module('App', [])
    .controller('RegistrationController', controller);

controller.$inject = ['$scope', '$http'];
function controller($scope, $http) {

    $scope.register = function () {
        $http.post('/register/user', {
            "name": $scope.username,
            "password": $scope.password,
            "phoneNumber": $scope.phoneNumber,
            "birthDay": $scope.birthDay,
            "birthMonth": $scope.birthMonth,
            "birthYear": $scope.birthYear,
            "monthlySalary": $scope.monthlySalary,
            "liabilities": $scope.liabilities
        })
            .then(function (r) {
                $scope.registerMessage = r.data.message;
                if ($scope.registerMessage === 'Success') {

                };
            })
            .catch(function (e) {
                console.log(e)
            });
    }


}