/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.sportSetting",[]);
    app.controller("sportSettingIndexController", ["$scope", "$http","$modal" ,"ThermalControlService","FoundationService", "dialogService",
        function ($scope,$http,$modal,ThermalControlService,FoundationService,dialogService) {
            $scope.$emit('navShow',2);
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
                ThermalControlService.getSportSettingAllList( $scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.settingResult = data.result;
                        $scope.vm.settingTotalCount = data.totalCount;
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
            $scope.addSportSetting = function (sportSetting) {
                $scope.sportSetting={};

                //复制
                angular.extend($scope.sportSetting ,sportSetting);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportSettingEidt.html",
                    controller:SettingEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.sportSetting;
                        }
                    }
                });
            };

            //编辑
            $scope.edit = function (sportSetting) {
                $scope.sportSetting={};
                //复制
                angular.extend($scope.sportSetting ,sportSetting);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportSettingEidt.html",
                    controller:SettingEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.sportSetting;
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();
                });
            };

            //删除
            $scope.delete = function(sportSetting) {
                var dialogDefaults = {
                    size:"sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除这条数据吗？",
                    type:"delete",
                    callback: function () {
                        ThermalControlService.deleteSportSetting({id:sportSetting.id}).success(function(data){
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
                    $scope.sportSetting = items;
                    // $scope.sportSetting.title = "新增知识库";

                    $scope.sportSettingTypes = [
                        {sqlSave:'TEXT',name:'文字'},
                        {sqlSave:'PICTURE', name:'图片'},
                        {sqlSave:'VIDEO', name:'视频'},
                        {sqlSave:'URL', name:'链接'}
                    ];

                    $scope.attachmentRequest = {};
                    $scope.newId = {};
                    $scope.attachment = {
                        businessType: "EMPLOYEE",
                        businessCategory: "COMMON",
                        list: []
                    };
                    if( $scope.sportSetting.id==null){
                        FoundationService.apiFoundationIdGet().success(function (data) {
                            if (null == data.errors || 0 < data.errors.length)
                                dialogService.tip(data.errors);
                            else {
                                $scope.newId = data.id;
                                $scope.attachment.businessId=$scope.newId;
                            }
                        });
                    }
                    else{
                        $scope.attachment.businessId=$scope.sportSetting.id;
                    }
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
                                    $scope.sportSetting.cover = data.id;
                                    $scope.sportSetting.url = data.url;
                                }
                            });
                        };
                    };

                    $scope.doSave = function() {
                        if($scope.sportSetting.id == null){
                            //新建
                            $scope.sportSetting.id= $scope.newId;
                            ThermalControlService.createSportSetting($scope.sportSetting).success(function(data){
                                $scope.validateForm.$errors =[];
                                if(data.errors === null || data.errors.length > 0){
                                    for(var i=0;i<data.errors.length;i++){
                                        $scope.validateForm.$errors.push(data.errors[i].message);
                                    }
                                    $scope.sportSetting.id=null;
                                }else{
                                    //返回id
                                    $scope.sportSetting.id = data.id;
                                    dialogService.tip([{"message": "保存成功！"}]);
                                    //关闭
                                    $modalInstance.close($scope.sportSetting);
                                    //清空数据
                                    $scope.sportSetting={};
                                    window.location.reload();
                                }
                            }) ;
                        } else {
                            //编辑
                            ThermalControlService.updateSportSetting($scope.sportSetting).success(function(data){
                                $scope.validateForm.$errors =[];
                                if(data.errors === null || data.errors.length > 0){
                                    for(var i=0;i<data.errors.length;i++){
                                        $scope.validateForm.$errors.push(data.errors[i].message);
                                    }
                                }else{
                                    dialogService.tip([{"message": "保存成功！"}]);
                                    //关闭
                                    $modalInstance.close($scope.sportSetting);
                                    //清空数据
                                    $scope.sportSetting={};
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
    app.controller("SportSettingImportController", ["$scope", "$http", "$modal" ,  "$location","toolsService","ThermalControlService", "dialogService", function ($scope, $http, $modal, $location, toolsService,ThermalControlService, dialogService) {
        $scope.$emit('navShow',2);
        $scope.tabShow = toolsService.parameter("tabShow", $location.absUrl());
        $scope.errorOpen = function (errors, url) {
            $scope.result = {};
            $scope.result.errors = errors;
            $scope.result.url = url;
            var modalInstance = $modal.open({
                templateUrl: "errors.html",
                controller: ErrorController,
                resolve: {
                    items: function () {
                        return $scope.result;
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
        $scope.upFileSave = function () {
            var file = document.getElementById("upImportFileId").files[0];
            ThermalControlService.apiSportSettingImport(file).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    if (data.errors.length > 10) {
                        data.errors = data.errors.slice(0, 9);
                    }
                    $scope.errorOpen(data.errors, data.url);
                } else {
                    dialogService.tip([
                        {"message": "导入成功！"}
                    ], "setting");
                }
            });
        };
        $scope.downloadTemplate = function () {
            ThermalControlService.apiSportSettingTemplate().success(function (data) {
                if (data.errors == null || data.errors.length > 0) {
                    $scope.errorOpen(data.errors, data.url);
                } else {
                    window.open(data.url, "_self");
                }
            });
        };
    }
    ]);
    var ErrorController = ["$scope", "$modalInstance", "items",
        function ($scope, $modalInstance, items) {
            //$scope.$emit('navShow', 3);
            $scope.errors = items.errors;
            $scope.url = items.url;
            $scope.download = function () {
                window.open($scope.url, "_self");
                $modalInstance.dismiss('cancel');
            };
            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
            //关闭错误
            $scope.closeAlert = function (index, form) {
                form.splice(index, 1);
            };
        }];
})();