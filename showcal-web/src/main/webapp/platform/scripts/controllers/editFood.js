/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.editFood", []);
    app.controller("EditFoodIndexController", ["$scope", "$http","FoundationService","$location","toolsService", "ThermalControlService", "dialogService",
        function ($scope, $http,FoundationService,$location,toolsService, ThermalControlService, dialogService) {
            $scope.createFoodResult = [];
            $scope.$emit('navShow', 3);

            $scope.foodGet = {
                id:toolsService.parameter("id", $location.absUrl()),
                address:{}
            };
            $scope.attachmentRequest = {};
            $scope.newId = {};
            $scope.attachment = {
                businessType: "EMPLOYEE",
                businessCategory: "COMMON",
                businessId:toolsService.parameter("id", $location.absUrl()),
                list: []
            };
            /* 用于存放附件的ID */
            $scope.attachmentRequest = {ids: []};
            for (var i = 0; i < $scope.attachment.list.length; i++) {
                $scope.attachmentRequest.ids.push($scope.attachment.list[i].id);
            }

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
                        }
                    });
                };
            };
            ThermalControlService.getFood({id:$scope.foodGet.id}).success(function(data){
                if(data.errors === null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }else{
                    $scope.food = data.food;
                }
            });

            $scope.doSave = function() {
                // $scope.food = foodItem;
                $scope.food.isActive = true;
                ThermalControlService.updateFood($scope.food).success(function(data){
                    if(data.errors === null ||
                        data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        //返回id
                        $scope.food.id = data.id;
                        dialogService.tip([{"message": "保存成功！"}],"/platform/food/food");
                    }
                }) ;
            };



        }
    ]);
})();