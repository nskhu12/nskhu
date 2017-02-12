angular.module('App', [])
    .controller('ProfileController', controller);

controller.$inject = ['$scope', '$http'];
function controller($scope, $http) {
    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.username = r.data.name;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.password = r.data.password;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.phoneNumber = r.data.phoneNumber;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.monthlySalary = r.data.monthlySalary;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.liabilities = r.data.liabilities;
        })
        .catch(function (e) {
            console.log(e)
        })

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.birthDay = r.data.birthDay;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.birthMonth = r.data.birthMonth;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/user')
        .then(function (r) {
            $scope.userData = r.data;
            $scope.birthYear = r.data.birthYear;
        })
        .catch(function (e) {
            console.log(e)
        });

    $http.get('/profile/creditlimit')
        .then(function (r) {
            $scope.userLimit = r.data.message;
        })
        .catch(function (e) {
            console.log(e)
        });


    $scope.saveUsername = function () {
        $http.post('/profile/user/change/to/' + $scope.username)
            .then(function (r) {
                $scope.usernameMessage = r.data.message;
                if ($scope.usernameMessage === 'Success') {
                    $scope.userData.name = $scope.username
                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }

    $scope.savePassword = function () {
        $http.post('/profile/password/change/to/' + $scope.password)
            .then(function (r) {
                $scope.passwordMessage = r.data.message;
                if ($scope.passwordMessage === 'Success') {
                    $scope.userData.password = $scope.password
                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }

    $scope.savePhoneNumber = function () {
        $http.post('/profile/phoneNumber/change/to/' + $scope.phoneNumber)
            .then(function (r) {
                $scope.phoneNumberMessage = r.data.message;
                if ($scope.phoneNumberMessage === 'Success') {
                    $scope.userData.phoneNumber = $scope.phoneNumber
                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }

    $scope.saveMonthlySalary = function () {
        $http.post('/profile/monthlySalary/change/to/' + $scope.monthlySalary)
            .then(function (r) {
                $scope.monthlySalaryMessage = r.data.message;
                if ($scope.monthlySalaryMessage === 'Success') {
                    $scope.userData.monthlySalary = $scope.monthlySalary
                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }

    $scope.saveLiabilities = function () {
        $http.post('/profile/liabilities/change/to/' + $scope.liabilities)
            .then(function (r) {
                $scope.liabilitiesMessage = r.data.message;
                if ($scope.liabilitiesMessage === 'Success') {
                    $scope.userData.liabilities = $scope.liabilities
                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }

    $scope.saveBirthdate = function () {
        $http.post('/profile/birthdate', {
            "name": $scope.username,
            "birthDay": $scope.birthDay,
            "birthMonth": $scope.birthMonth,
            "birthYear": $scope.birthYear
        })
            .then(function (r) {
                $scope.birthdateMessage = r.data.message;
                if ($scope.liabilitiesMessage === 'Success') {

                }
            })
            .catch(function (e) {
                console.log(e)
            });
    }
}