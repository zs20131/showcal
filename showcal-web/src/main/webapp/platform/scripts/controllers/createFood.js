/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.createFood", []);
    app.controller("CreateFoodIndexController", ["$scope", "$http", "FoundationService","ThermalControlService", "dialogService",
        function ($scope, $http,FoundationService,ThermalControlService, dialogService) {
            $scope.createFoodResult = [];
            $scope.$emit('navShow', 3);
            $scope.food={};
            var thisParameter={};
            ThermalControlService.getFoodCategoryAllList(thisParameter).success(function(data){
                if(data.errors === null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }else{
                    $scope.foodCategoryList = data.result;
                }
            });
            $scope.attachmentRequest = {};
            $scope.newId = {};
            $scope.attachment = {
                businessType: "EMPLOYEE",
                businessCategory: "COMMON",
                list: []
            };
            /* 用于存放附件的ID */
            $scope.attachmentRequest = {ids: []};
            for (var i = 0; i < $scope.attachment.list.length; i++) {
                $scope.attachmentRequest.ids.push($scope.attachment.list[i].id);
            }
            FoundationService.apiFoundationIdGet().success(function (data) {
                if (null == data.errors || 0 < data.errors.length)
                    dialogService.tip(data.errors);
                else {
                    $scope.newId = data.id;
                    $scope.attachment.businessId=$scope.newId;
                }
            });
            /**
             *图片保存的功能
             */
            $scope.showPicture = function () {
                var fileId = document.getElementById("pictureFile");
                fileId.onchange = function () {
                    var fileList = document.getElementById("pictureFile").files;
                    var file = fileList[0];
                    var fileReader = new FileReader();
                    fileReader.readAsDataURL(file);
                    //头像上传
                    FoundationService.uploadLogo(file).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.food.pictureUrl = data.url;
                            console.log(  $scope.food.pictureUrl);
                        }
                    });
                };
            };
            $scope.doSave = function() {
               // $scope.food = foodItem;
                $scope.food.isActive = true;
                $scope.food.id = $scope.newId;
                ThermalControlService.createFood($scope.food).success(function(data){
                    if(data.errors === null ||
                        data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        //返回id
                        $scope.food.id = data.id;
                        dialogService.tip([{"message": "保存成功！"}],"/platform/food/food");
                        /*//清空数据
                        $scope.food={};
                        window.location.reload();*/
                    }
                }) ;
            };



        }
    ]);
    //创建食物
   /* app.controller("CreateFoodIndexController", ["$scope", "$http","ThermalControlService","dialogService",
        function ($scope, $http, ThermalControlService,dialogService) {



            /!**
             *图片保存的功能
             *!/
            /!*   $scope.showPicture=function(){
             var fileId=document.getElementById("pictureFile");
             fileId.onchange=function(){
             var fileList = document.getElementById("pictureFile").files;
             var file = fileList[0];
             var fileReader = new FileReader();
             fileReader.readAsDataURL(file);
             //头像上传
             ThermalControlService.uploadLogo(file).success(function(data){
             if(data.errors === null || data.errors.length > 0){
             dialogService.tip(data.errors);
             }else{
             $scope.user.avatarurl = data.url;
             $scope.user.avatarId = data.id;
             }
             });
             };
             };*!/


            /!*   $scope.doSave = function () {
             console.log($scope.user);
             if($scope.user.birthday instanceof  Date){
             $scope.user.birthday = $scope.user.birthday.format('yyyy-MM-dd');
             }
             ThermalControlService.createSysUser($scope.user).success(function (data) {
             if (data.errors === null || data.errors.length > 0) {
             dialogService.tip(data.errors);
             } else {
             dialogService.tip([{"message":"食物创建成功！" }],"/platform/food");
             }
             })
             }*!/
        }
    ]);*/
})();