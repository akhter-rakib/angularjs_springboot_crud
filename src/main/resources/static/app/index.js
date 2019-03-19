var app = angular.module('myApp', []);
app.controller('StudentController', ['$http', '$scope', function ($http, $scope) {
    var self = this;
    self.success = null;
    self.error = null;

    self.studentModel = {id: null, name: '', roll: '', className: ''};
    self.saveStudent = saveStudent;
    self.studentList = [];
    self.studentList = studentList;
    self.update = update;
    self.removeStudent = removeStudent;
    self.reset = reset;
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
        console.log("What " + student)
        $http.post('/saveStudent', student).success(function (d) {
            self.success = 'Unit name successfully added in system !!!!';
            self.error = null;
            studentList();
            reset();
        }).error(function (data, status, headers) {
            console.log(status);
            if (status === 409) {
            }
        });
    };

    function update(id) {
        console.log("Edited Id = " + id);
        $http.get('/getStudent/' + id).success(function (d) {
            self.studentModel = d;
        }).error(function (data, status) {

        });
    };

    function removeStudent(id) {
        console.log("Deleted Id = " + id);
        $http.get('/deleteStudent/' + id).success(function (d) {
            studentList();
            reset();
        }).error(function (data, status) {

        });
    }

    function reset() {
        self.studentModel = {id: null, name: '', roll: '', className: ''};
    }

}]);