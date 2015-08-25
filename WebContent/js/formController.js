//(function() {
//	
//
//	angular.module('RRS').controller('FormCtrl', FormController);
//
//	FormController.$inject = ['$http'];
//	
//	function FormController($http) {
//		var fctrl = this;
//
////		fctrl.getAllEmp = function () {
////			$http({
////				method: 'GET',
////				url: '../../api/reservations/all'
////			}).success(function(data){
////				console.log(data);
////				mainVm.people=data;
////			}).error(function(error){
////				console.log(error);
////			});
////		};
//		
//		
////		fctrl.getEmp = function () {
////			
////			if(fctrl.empId)
////			{
////				$http({
////					method: 'GET',
////					url: '../../api/reservations/get/' + fctrl.empId
////				}).success(function(data){
////					console.log(data);
////				}).error(function(error){
////					console.log(error);
////				});
////			}
////		};
//		
////		fctrl.addEmp = function () {
////			console.log(fctrl.newRes)
////			$http({
////				method: 'POST',
////				url: '../api/reservations/add',
////				data: fctrl.newRes
////			}).success(function(data){
////				console.log(data);
////				fctrl.newRes = null;
////			}).error(function(error){
////				console.log(error);
////			});
////		}
//		
//		
////		fctrl.delEmp = function () {
////			console.log(fctrl.delRes)
////			$http({
////				method: 'POST',
////				url: '../api/reservations/delete',
////				data: fctrl.delRes
////			}).success(function(data){
////				console.log(data);
////				fctrl.delRes = null;
////			}).error(function(error){
////				console.log(error);
////			});
////		}		
//	}
//})();