/**
 * Created by Administrator on 2015/9/22.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.usertag", []);
    //index
    app.controller("UserTagIndexController", ["$scope", "$http", "$modal", "PlatformService", "dialogService",
        function ($scope, $http, $modal, PlatformService, dialogService) {
            $scope.$emit('navShow', 1);
            $scope.query = {};
            $scope.search = function(){
                PlatformService.getSettingUserTagAllList($scope.query).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.usertags = data.result;
                        $scope.usertags.totalCount = data.totalCount;
                    }
                });
            }
            $scope.search();
            //树编辑
            $scope.edit = function (tree) {
                $scope.usertag = {};
                //复制
                angular.extend($scope.usertag, tree);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "treeEidt.html",
                    controller: TreeEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.usertag;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    $scope.search();
                });
            };

            //新建树节点
            $scope.addTree = function (tree) {

                $scope.usertag = {};
                if (tree != null) {
                    $scope.usertag = {
                        parentusertag: usertag.name,
                        parentId: usertag.id
                    };
                } else {
                    $scope.usertag = {
                        parentusertag: "",
                        parentId: ""
                    };
                }
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "treeEidt.html",
                    controller: TreeEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.usertag;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    $scope.search()
                });
            };
            $scope.delete = function (tree) {
                var dialogDefaults = {
                    size: "sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除该标签吗？",
                    type: "delete",
                    callback: function () {
                        PlatformService.deleteSettingUserTag({id: tree.id}).success(function (data) {
                            if (data.errors === null || data.errors.length > 0) {
                                dialogService.tip(data.errors);
                            } else {
                                $scope.search();
                                dialogService.tip([
                                    {"message": "删除成功！" }
                                ]);
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);
            };
        }]);

    var TreeEidt = ["$scope", "$modalInstance", "items", "PlatformService", "dialogService",
        function ($scope, $modalInstance, items, PlatformService, dialogService) {
            $scope.$emit('navShow', 3);
            // console.log($scope);    $scope.org = items;
            $scope.usertag = items;
            if ($scope.usertag.id == null) {
                if ($scope.usertag.parentId == "") {
                    $scope.usertag.title = "增加用户标签";
                } else {
                    $scope.usertag.title = $scope.usertag.parentusertag + "新增子组织";
                }

            } else {
                $scope.usertag.title = "编辑用户标签";
            }
            $scope.doSave = function () {
                $scope.usertag.tagRgb=document.getElementById("nowColor").value;
                console.log($scope.usertag);
                if ($scope.usertag.id == null) {
                    //新建
                    PlatformService.createSettingUserTag($scope.usertag).success(function (data) {
                        $scope.validateForm.$errors = [];
                        if (data.errors === null || data.errors.length > 0) {
                            for(var i=0;i<data.errors.length;i++){
                                $scope.validateForm.$errors.push(data.errors[i].message);
                            }
                        } else {
                            //返回id
                            $scope.usertag.id = data.id;
                            dialogService.tip([
                                {"message": "保存成功！"}
                            ]);
                            //关闭
                            $modalInstance.close($scope.usertag);
                            //清空数据
                            $scope.usertag = {};

                            if(document.getElementById("colorBoard")){
                                document.body.removeChild(document.getElementById("colorBoard"));
                            }
                        }
                    });
                } else {
                    //编辑
                    $scope.usertag.tagRgb=document.getElementById("nowColor").value;
                    PlatformService.updateSettingUserTag($scope.usertag).success(function (data) {
                        $scope.validateForm.$errors = [];
                        if (data.errors === null || data.errors.length > 0) {
                            for(var i=0;i<data.errors.length;i++){
                                $scope.validateForm.$errors.push(data.errors[i].message);
                            }
                        } else {
                            dialogService.tip([
                                {"message": "保存成功！"}
                            ]);
                            //关闭
                            $modalInstance.close($scope.usertag);
                            //清空数据
                            $scope.usertag = {};

                            if(document.getElementById("colorBoard")){
                                document.body.removeChild(document.getElementById("colorBoard"));
                            }
                        }
                    });
                }

            };
            $scope.clean = function () {
                $scope.usertag = {};
                $modalInstance.dismiss('cancel');
                if(document.getElementById("colorBoard")){
                    document.body.removeChild(document.getElementById("colorBoard"));
                }
            };

            $scope.closeAlert = function (index, form) {
                form.splice(index, 1);
            };
        }];

})();