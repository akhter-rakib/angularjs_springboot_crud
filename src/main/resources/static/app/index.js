var app = angular.module('myApp', []);
app.controller('StudentController', ['$http', '$scope', function ($http, $scope) {
    var self = this;
    self.success = null;
    self.error = null;

    self.studentModel = {id: null, name: '', roll: '', className: ''};
    self.saveStudent = saveStudent;
    self.studentList = [];
    self.studentList = studentList;
    studentList();

    function studentList() {
        $http.get('/studentList').success(function (d) {
            console.log(d);
            self.studentList = d;
        }).error(function (data, status, headers) {
            console.log(data);
        });
    };

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