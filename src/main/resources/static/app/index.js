var app = angular.module('myApp', []);
app.controller('StudentController', ['$http', '$scope', function ($http, $scope) {
    var self = this;
    self.studentModel = {id: null, name: '', roll: '', className: ''};
    self.saveStudent = saveStudent;
    self.success = null;
    self.error = null;

    function saveStudent(student) {
        $http.post('/saveStudent', student).success(function (d) {
            self.success = 'Unit name successfully added in system !!!!';
            self.error = null;
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {

            }
        });
    }
}]);