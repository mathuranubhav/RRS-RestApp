//This Controller Manages the Routing between Pages 

(function(){

    angular.module('RRS').controller('ContactCtrl', ContactController);

    function ContactController ($routeParams) {
        var contactctrl = this;

        contactctrl.params = $routeParams;
        console.log('Contact Controller');
    }
})();
(function(){

    angular.module('RRS').controller('AdminCtrl', AdminController);

    function AdminController ($routeParams) {
        var adminctrl = this;

        adminctrl.params = $routeParams;
        console.log('Admin Controller');
    }
})();
(function(){

    angular.module('RRS').controller('AddEditCtrl', AddEditController);

    function AddEditController ($routeParams) {
        var addeditctrl = this;

        addeditctrl.params = $routeParams;
        console.log('Add Edit Controller');
    }
})();
(function(){

    angular.module('RRS').controller('AdminLoginCtrl', AdminLoginController);

    function AdminLoginController ($routeParams) {
        var adminloginctrl = this;

        adminloginctrl.params = $routeParams;
        console.log('Admin Login controller');
    }
})();
(function(){

    angular.module('RRS').controller('AddFormCtrl', AddFormController);

    function AddFormController ($routeParams) {
        var addformctrl = this;

        addformctrl.params = $routeParams;
        console.log('Add Form Login controller');
    }
})();
(function(){

    angular.module('RRS').controller('ResCtrl', ResController);

    function ResController ($routeParams) {
        var resctrl = this;

        resctrl.params = $routeParams;
        console.log('Reservations controller');
    }
})();
(function(){

    angular.module('RRS').controller('SeatingCtrl', SeatingController);

    function SeatingController ($routeParams) {
        var seatctrl = this;

        seatctrl.params = $routeParams;
        console.log('Seating controller');
    }
})();
(function(){

    angular.module('RRS').controller('ProfileCtrl', ProfileController);

    function ProfileController ($routeParams) {
        var profilectrl = this;

        profilectrl.params = $routeParams;
        console.log('Profile controller');
    }
})();
(function(){

    angular.module('RRS').controller('AppCtrl', AppController);

    function AppController ($routeParams) {
        var appctrl = this;

        appctrl.params = $routeParams;
        console.log('App controller');
    }
})();

//
//(function() {
//
//    angular.module('RRS').controller('LoginCtrl', LoginController);
//
//    function LoginController($location) {
//        var lctrl = this;
//
//        lctrl.goToHome = function() {
//
//            //var queryStr = {
//            //    firstName: 'Praveen',
//            //    lastName: 'Salitra',
//            //    address: '1232,Main St, Chicago, IL 60566'
//            //};
//
//            //$location.path('/profile').search(queryStr);
//        };
//    }
//})();
//
//(function() {
//
//    angular.module('RRS').controller('ProfileCtrl', ProfileController);
//
//    function ProfileController($routeParams, $http, userData, userPicData) {
//        var pctrl = this;
//        console.log('Profile controller');
//
//        pctrl.user = userData.data;
//        pctrl.user.imgUrl = userPicData.data.url;
//        console.log('user');
//    }
//})();