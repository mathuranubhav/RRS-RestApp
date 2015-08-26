(function() {


//Create the module

        angular.module('RRS', ['ngRoute','ngMessages']).config(moduleConfig);

//Fetch Modules
        angular.module('RRS').controller('MainController', MainControllerfn);

//Routing Config
        function moduleConfig($routeProvider) {
            $routeProvider
                .when('/addform', {
                    templateUrl: 'dynamic/addform.html',
                    controller: 'AddFormCtrl',
                    controllerAs: 'addformctrl'
                })
                .when('/adminlogin', {
                    templateUrl: 'dynamic/adminlogin.html',
                    controller: 'AdminLoginCtrl',
                    controllerAs: 'adminloginctrl'
                })                
                
                .when('/reservations', {
                    templateUrl: 'dynamic/adminpanel/reservations.html',
                    controller: 'ResCtrl',
                    controllerAs: 'resctrl'
                })
                .when('/seating', {
                    templateUrl: 'dynamic/adminpanel/seating.html',
                    controller: 'SeatingCtrl',
                    controllerAs: 'sctrl'
                })
                .when('/profile', {
                    templateUrl: 'dynamic/adminpanel/profile.html',
                    controller: 'ProfileCtrl',
                    controllerAs: 'pctrl',
                })
                .when('/appsettings', {
                    templateUrl: 'dynamic/adminpanel/appsettings.html',
                    controller: 'AppCtrl',
                    controllerAs: 'appctrl'
                })
                .when('/contacts', {
                    templateUrl: 'dynamic/contacts.html',
                    controller: 'ContactsCtrl',
                    controllerAs: 'contactsctrl'
                })
                .when('/admin', {
                    templateUrl: 'dynamic/adminpanel/adminpanel.html',
                    controller: 'AdminCtrl',
                    controllerAs: 'adminctrl'
                })
                .when('/addedit', {
                    templateUrl: 'dynamic/addedit.html',
                    controller: 'AddEditCtrl',
                    controllerAs: 'AddEditctrl'
                })                
                .otherwise({
                    redirectTo: 'dynamic/addedit.html'
                });
        }
        
//Define Controllers
        MainControllerfn.$inject= ['$http'] 
        function MainControllerfn($http) {
            var mainVm = this;
            
//            mainVm.appSettings.orgName = "Dine Hill Restaurant"; //Organization name goes here
//            mainVm.appSettings.orgTableNo = 10;	// No of Tables in the organisation
//            mainVm.appSettings.orgAutoAssign = 1; // Boolean (0 or 1) value for table auto assign on/off 
//            mainVm.appSettings.orgPhone = "999-999-9999";
//            mainVm.appSettings.orgEmail = "dinehill@gmail.com";
//            mainVm.appSettings.orgAddress = "690, Leonard Hill, Washington D.C.- 06268";
//            mainVm.appSettings.orgOpenDays = "Mondays, Tuesdays, Wednesdays, Thursdays, Fridays, Saturndays, Sundays";
//            mainVm.appSettings.orgOpenTimings = "9:00AM - 9:00PM";

 //Get all reservations
    		mainVm.getAllReservations = function () {
    			$http({
    				method: 'GET',
    				url: '../api/reservations/all'
    			}).success(function(data){
    				console.log(data);
    				mainVm.people=data.payload;
    				console.log(mainVm.people)
    			}).error(function(error){
    				console.log(error);
    			});
    		};
        	mainVm.getAllReservations(); //Function Call

//Get all AppSettings all reservations
    		mainVm.getAppSettings = function () {
    			$http({
    				method: 'GET',
    				url: '../api/settings/all'
    			}).success(function(data){
    				console.log("Executing GET App Settings")
    				console.log(data);
    				mainVm.appSettings=data.payload[0];
    				console.log(mainVm.appSettings.orgName)
    				console.log("Executed GET App Settings")    				
    			}).error(function(error){
    				console.log(error);
    			});
    		};
        	mainVm.getAppSettings(); //Function Call         	
        	
    		
//Adding a reservation
            mainVm.addReservation = function () {
            	if(mainVm.people.length==0)
            		{mainVm.newReservation.id=1;}
            	else 
            		{mainVm.newReservation.id= mainVm.people.length + 1;}
            	
                mainVm.newReservation.confNo = genconf(); // Generating Confirmation No Function and setting its value
                mainVm.newReservation.tableNo = gentable(); // Generating Table No. No Function and setting its value                
                mainVm.people.push(mainVm.newReservation);          	
                //Sending data
    			$http({
    				method: 'POST',
    				url: '../api/reservations/add',
    				data: mainVm.newReservation
    			}).success(function(data){
    				console.log(data);
    				mainVm.newReservation = null;
    			}).error(function(error){
    				console.log(error);
    			});
            	mainVm.newReservation = null;          //Erasing field    	
            	};
            	           	
    		             
//Deleting the reservations
            mainVm.deleteReservation = function (position, delRes) {

            	console.log(position);
            	console.log(delRes);
            	$http({
    				method: 'POST',
    				url: '../api/reservations/delete',
    				data: delRes
    			}).success(function(data){
    				console.log(data);
    				delRes = null;
    			}).error(function(error){
    				console.log(error);
    			});
                mainVm.people.splice(position, 1); // Removing the element from Angular Array            	
            	};
            	
//Edit Reservations
                mainVm.editReservation = function (position, editRes) {
                	mainVm.editedReservation=editRes;
            	};
            	
            	mainVm.editReservation2 = function (){
                	
            		console.log("Function Executed")
            		for (var key in mainVm.people) { //Loads people keys for Comparison
                		if (mainVm.people.hasOwnProperty(key)) { //If people has value for keys
                			if(mainVm.people[key].id==mainVm.editedReservation.id) // Checks ID
                			{
                				console.log("Inside loop")
                				console.log(mainVm.people[key]=mainVm.editedReservation)  //Copies edited reservation into corresponding reservation.
                			}
             			
                		}
                	}
           			$http({
        				method: 'POST',
        				url: '../api/reservations/update',
        				data: mainVm.editedReservation
        			}).success(function(data){
        				console.log(data);
        			}).error(function(error){
        				console.log(error);
        			});

           			mainVm.editedReservation=null; // Clears the editedReservation for data privacy.           			
            		
            		
            	};
            	mainVm.findReservation = function (confno){
            		for (var key in mainVm.people) { //Loads people keys for Comparison
                		if (mainVm.people.hasOwnProperty(key)) { //If people has value for keys
                			if(mainVm.people[key].confNo==mainVm.editedReservation.confNo) // Checks ID
                			{
                				console.log("Inside loop")
          				
                				console.log(mainVm.editedReservation=mainVm.people[key]);  //Copies reservation into corresponding Buffer array.
                			}
             			
                		}
                	}            		
            		
            	}
       	
     	
           	
            	
            	
//Change Settings Function
            mainVm.changeSettings = function () {
//            	console.log("Function Called");
//            	console.log("New Settings Array"+mainVm.newSettings)
//            	console.log("App Settings array"+mainVm.appSettings)
            	//Function to Compare the two arrays and check if there are any changes between them,
            	// If change, assign new value to appSettings, else ignore.
            	
            	for (var key in mainVm.appSettings) { //Loads appSettings keys for Comparison
            		if (mainVm.appSettings.hasOwnProperty(key)) { //If assSettings has value for keys
            			if(mainVm.newSettings[key]!=null) // If there are changes, then value of newSettings will not be null
            			{
            				mainVm.appSettings[key]=mainVm.newSettings[key]// Therefore assign the changes to appSettings array.
            			}
         			
            		}
            	}           	
       	
            	          	            	
       			$http({
    				method: 'POST',
    				url: '../api/settings/update',
    				data: mainVm.appSettings
    			}).success(function(data){
    				console.log(data);
    			}).error(function(error){
    				console.log(error);
    			});

            };

          //Admin Login Function
            
            mainVm.adminLogin = function () {
            	console.log("Function called");
            	if(mainVm.admin.username==mainVm.appSettings.orgUsername && mainVm.admin.password==mainVm.appSettings.orgPassword)
            	{
                	window.location = "#/admin"; 
                	mainVm.admin=null;
            	}
            	else{
            		window.alert('Wrong username or password');
            		
            	}
            }            
//Generate Random Confirmation code

          
    		function genconf()
    		{
    		    var text = "";
    		    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    		    for( var i=0; i < 5; i++ )
    		        text += possible.charAt(Math.floor(Math.random() * possible.length));

    		    return text;
    		}
    		

    		
    		function gentable() // Currently this function generates table no.  
    		{
    			return Math.floor((Math.random() * mainVm.appSettings.orgTableNo) + 1) //Randomly Generates Table Number between 1-10
    			
    			//TO DO  : Check Date, time, duration, table availability and assign table No accordingly
    			//If Table Available then return table no
    			//If Table not available then return 'WL' for Waitlist 
    		}
    		mainVm.confCheck = function()
    		{
    			console.log("Conf No is: " + mainVm.editedReservation.confNo);
    		}
    		
    		mainVm.convertDate = function (input)
    		{
    			d= new Date(input);
    			return d.toDateString();
    		}
    		mainVm.convertTime = function (input)
    		{
    			t= new Date(input);
    			return t.toTimeString();
    		}
    		mainVm.getTimes=function(){
    			 return new Array(mainVm.appSettings.orgTableNo);
//    			arr=new Array ();
//    			var j=1;
//    			var i=1;
//    			while(i<mainVm.appSettings.orgTableNo){  //Cycles through all the 1->Table No's
//    				while(j<mainVm.people.length) //Cycles through People
//   			     	{
//    					if(mainVm.people[j].tableNo==i)
//							{arr[i]=(i,"Occupied")}
//    				    else{arr[i]=(i,"Empty")}
//					    j++
//   			     	}
//    				i++
//    			}
//    			console.log(arr)
    		};
        }
	}
)();