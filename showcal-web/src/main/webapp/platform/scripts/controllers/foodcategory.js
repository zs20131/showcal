/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.foodCategory",[]);
    app.controller("foodCategoryIndexController", ["$scope", "$http","$modal" ,"ThermalControlService", "dialogService",
        function ($scope,$http,$modal,ThermalControlService, dialogService) {
            $scope.$emit('navShow',3);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                sourceTypes: ["SHOWCAL", "PLADMIN"]
            };




            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                ThermalControlService.getFoodCategoryAllList($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.foodCategoryResult = data.result;
                        $scope.vm.foodCategoryTotalCount = data.totalCount;
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip(msg);
                    }
                });
            };
            /**
             * 页面初始化加载数据
             */
            $scope.doSearch = function () {
                $scope.vm.pageNumber = 1;
                $scope.getList();
            };
            $scope.doSearch();

            //新增
            $scope.addFoodCategory = function (foodCategory) {
                $scope.foodCategory={};

                //复制
                angular.extend($scope.foodCategory ,foodCategory);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "foodCategoryEidt.html",
                    controller:SettingEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.foodCategory;
                        }
                    }
                });
            };

            //编辑
            $scope.edit = function (foodCategory) {
                $scope.foodCategory={};
                //复制
                angular.extend($scope.foodCategory ,foodCategory);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "foodCategoryEidt.html",
                    controller:SettingEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.foodCategory;
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();
                });
            };

            //删除
            $scope.delete = function(foodCategory) {
                var dialogDefaults = {
                    size:"sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除这个食物吗？",
                    type:"delete",
                    callback: function () {
                        ThermalControlService.deleteFoodCategory({id:foodCategory.id}).success(function(data){
                            if(data.errors === null || data.errors.length > 0){
                                dialogService.tip(data.errors);
                            }else{
                                dialogService.tip([{"message":"删除成功！" }]);
                                window.location.reload();
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);
            };


            var SettingEidt = ["$scope","$modalInstance","items","ThermalControlService","dialogService",
                function ($scope, $modalInstance, items,ThermalControlService,dialogService) {
                    $scope.$emit('navShow',2);
                    $scope.foodCategory = items;
                    // $scope.foodCategory.title = "新增知识库";

                    $scope.doSave = function() {
                        if($scope.foodCategory.id == null){
                            //新建
                            ThermalControlService.createFoodCategory($scope.foodCategory).success(function(data){
                                if(data.errors === null ||
                                    data.errors.length > 0){
                                    dialogService.tip(data.errors);
                                }else{
                                    //返回id
                                    $scope.foodCategory.id = data.id;
                                    dialogService.tip([{"message": "保存成功！"}]);
                                    //关闭
                                    $modalInstance.close($scope.foodCategory);
                                    //清空数据
                                    $scope.foodCategory={};
                                    window.location.reload();
                                }
                            }) ;
                        } else {
                            //编辑
                            ThermalControlService.updateFoodCategory($scope.foodCategory).success(function(data){

                                if(data.errors === null || data.errors.length > 0){
                                    dialogService.tip(data.errors);
                                }else{
                                    dialogService.tip([{"message": "保存成功！"}]);
                                    //关闭
                                    $modalInstance.close($scope.foodCategory);
                                    //清空数据
                                    $scope.foodCategory={};
                                }
                            }) ;
                        }
                    };

                    $scope.clean = function () {
                        $scope.disease = {};
                        $modalInstance.dismiss('cancel');
                    };
                }
            ];



        }
    ]);

})();