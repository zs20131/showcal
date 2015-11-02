/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.showcal.repository", []);
    app.controller("RepositoryIndexController", ["$scope", "$http", "$modal" , "ShowcalService", "PlatformService", "dialogService",
        function ($scope, $http, $modal, ShowcalService, PlatformService, dialogService) {
            $scope.$emit('navShow', 3);
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10
            };

            $scope.startDate = false;
            $scope.endDate = false;

            //弹出式日历触发函数
            $scope.openStartDate = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.startDate = true;
            };
            //弹出式日历触发函数
            $scope.openEndDate = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.endDate = true;
            };

            var thisParameter = {};
            PlatformService.getSettingQuestionTagAllList(thisParameter).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.questionTagList = data.result;
                    for (var i = 0; i < $scope.questionTagList.length; i++) {
                        if($scope.repository){
                            if ($scope.questionTagList[i].id == $scope.repository.id) {
                                $scope.questionTagList.splice(i, 1);
                                break;
                            }
                        }
                    }
                }
            });
            PlatformService.getSettingKeywordAllList(thisParameter).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.keywordList = data.result;
                    for (var i = 0; i < $scope.keywordList.length; i++) {
                        if($scope.repository){
                            if ($scope.keywordList[i].id == $scope.repository.id) {
                                $scope.keywordList.splice(i, 1);
                                break;
                            }
                        }
                    }
                }
            });

            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                $scope.vm.tageIds = [];
                $scope.vm.keywords = [];
                if($scope.vm.tagObj){
                    $scope.vm.tageIds.push($scope.vm.tagObj);
                }
                if($scope.vm.keywordObj){
                    $scope.vm.keywords.push($scope.vm.keywordObj);
                }
                ShowcalService.getSystemRepository($scope.vm).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.sysRepository = data.result;
                        $scope.sysTotalCount = data.totalCount;
                    }
                });
                ShowcalService.getMyRepository($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.myRepository = data.result;
                        $scope.mytotalCount = data.totalCount;
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

                if ($scope.vm.startDate instanceof Date) {
                    $scope.vm.startDate = $scope.vm.startDate.format("yyyy-MM-dd");
                }
                if ($scope.vm.endDate instanceof Date) {
                    $scope.vm.endDate = $scope.vm.endDate.format("yyyy-MM-dd");
                }

                $scope.getList();
            };
            $scope.doSearch();

            //新增
            $scope.addRepository = function (repository) {
                $scope.repository = {};
                //复制
                angular.extend($scope.repository, repository);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "repositoryEidt.html",
                    controller: TreeEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.repository;
                        }
                    }
                });
            };

            //编辑
            $scope.edit = function (repository) {
                $scope.repository = {};
                //复制
                angular.extend($scope.repository, repository);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "repositoryEidt.html",
                    controller: TreeEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.repository;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            };

            //删除
            $scope.delete = function (repository) {
                var dialogDefaults = {
                    size: "sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除这条知识吗？",
                    type: "delete",
                    callback: function () {
                        ShowcalService.deleteRepository({id: repository.id}).success(function (data) {
                            if (data.errors === null || data.errors.length > 0) {
                                dialogService.tip(data.errors);
                            } else {
                                dialogService.tip([
                                    {"message": "删除成功！" }
                                ]);
                                window.location.reload();
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);
            };

            // 发布
            $scope.active = function(repository){
                ShowcalService.activeRepository({id:repository.id}).success(function(data){
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([
                            {"message": "发布成功！" }
                        ],"index.htm");
                    }
                });
            };

            // 取消发布
            $scope.inactive = function(repository){
                ShowcalService.inactiveRepository({id:repository.id}).success(function(data){
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([
                            {"message": "取消发布成功！" }
                        ],"index.htm");
                    }
                });
            };

            var TreeEidt = ["$scope", "$modalInstance", "items", "ServiceService", "PlatformService", "dialogService",
                function ($scope, $modalInstance, items, ServiceService, PlatformService, dialogService) {
                    $scope.$emit('navShow', 1);
                    $scope.repository = items;
                    // $scope.repository.title = "新增知识库";

                    var thisParameter = {};
                    PlatformService.getSettingQuestionTagAllList(thisParameter).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.questionTagList = data.result;
                            for (var i = 0; i < $scope.questionTagList.length; i++) {
                                if($scope.repository){
                                    if ($scope.questionTagList[i].id == $scope.repository.id) {
                                        $scope.questionTagList.splice(i, 1);
                                        break;
                                    }
                                }
                            }
                        }
                    });
                    PlatformService.getSettingKeywordAllList(thisParameter).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.keywordList = data.result;
                            for (var i = 0; i < $scope.keywordList.length; i++) {
                                if($scope.repository){
                                    if ($scope.keywordList[i].id == $scope.repository.id) {
                                        $scope.keywordList.splice(i, 1);
                                        break;
                                    }
                                }
                            }
                        }
                    });

                    $scope.doSave = function () {
                        $scope.repository.type = "SHOWCAL";
                        if ($scope.repository.id == null) {

                            //新建
                            ServiceService.createRepository($scope.repository).success(function (data) {
                                if (data.errors === null ||
                                    data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    //返回id
                                    $scope.repository.id = data.id;
                                    dialogService.tip([
                                        {"message": "保存成功！"}
                                    ]);
                                    //关闭
                                    $modalInstance.close($scope.repository);
                                    //清空数据
                                    $scope.repository = {};
                                    window.location.reload();
                                }
                            });
                        } else {
                            //编辑
                            ServiceService.updateRepository($scope.repository).success(function (data) {

                                if (data.errors === null || data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    dialogService.tip([
                                        {"message": "保存成功！"}
                                    ]);
                                    //关闭
                                    $modalInstance.close($scope.repository);
                                    //清空数据
                                    $scope.repository = {};
                                }
                            });
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

    // 批量导入数据
    app.controller("MyRepositoryImportController", ["$scope", "$http","$modal", "ServiceService", "dialogService",
        function ($scope, $http, $modal, ServiceService, dialogService) {
            $scope.$emit('navShow', 1);
            $scope.errorOpen = function (errors,url) {
                $scope.result={};
                $scope.result.errors=errors;
                $scope.result.url=url;
                var modalInstance = $modal.open({
                    templateUrl: "errors.html",
                    controller: ErrorCtrl,
                    resolve: {
                        items: function () {
                            return  $scope.result;
                        }
                    }
                });
                modalInstance.result.then(function () {
                }, function () {
                });
            };
            $scope.upFileClick=function(){
                var upImportFileId=document.getElementById("upImportFileId");
                upImportFileId.onchange=function(){
                    var upImportFile;
                    var upImportFileList =upImportFileId.files;
                    var upImportFilename;
                    if(upImportFileList){
                        upImportFile = upImportFileList[0];
                        upImportFilename=upImportFile.name;
                    }else{
                        upImportFilename =upImportFileId.value;
                    }
                    var str =upImportFilename.substr(upImportFilename.indexOf(".")+1);
                    if(!(str=="xls" || str=="xlsx" || str=="et")){
                        $("#upImportFile").val("");
                        dialogService.tip([{"message":"请上传Excel支持的文件(xls,xlsx,et等)！" }]);
                    }else{
                        $("#upImportFile").val(upImportFilename);
                    }
                };

            };
            // 上传
            $scope.upFileSave=function(){
                var file = document.getElementById("upImportFileId").files[0];
                console.log(file);
                if(!file){
                    dialogService.tip([{"message": "请上传文件！"}]);
                    return;
                }
                ServiceService.apiMyRepositoryImport(file).success(function(data){
                    if(data.errors == null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        dialogService.tip([{"message": "导入成功！"}]);
                    }
                });
            };

            // 下载模版
            $scope.downloadTemplate=function(){
                ServiceService.apiMyRepositoryOutputTemplate().success(function(data){
                    if(data.errors == null || data.errors.length > 0){
                        //$scope.errorOpen(data.errors,data.url);
                    }else{
                        window.open(data.url,"_self");
                    }
                });
            };
        }]);

    var ErrorCtrl =["$scope","$modalInstance","items",
        function ($scope, $modalInstance,items) {
            $scope.errors=items.errors;
            $scope.url=items.url;
            $scope.download=function(){
                window.open($scope.url,"_self");
                $modalInstance.dismiss('cancel');
            };
            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
            //关闭错误
            $scope.closeAlert = function (index,form) {
                form.splice(index,1);
            };
        }];

})();