/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.sportscheme", []);
    app.controller("sportSchemeIndexController", ["$scope", "$http", "$modal" , "ThermalControlService", "dialogService",
        function ($scope, $http, $modal, ThermalControlService, dialogService) {
            $scope.$emit('navShow', 2);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 20,
                sourceTypes: ["SHOWCAL", "PLADMIN"]
            };
            $scope.headResult = [];
            $scope.isInjuryJoins = [
                {name: '是'},
                {name: '否'}
            ];
            $scope.defaultJoin = '是';
            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                ThermalControlService.findSportHead($scope.vm).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.headResult = data.result;
                        $scope.vm.headTotalCount = data.totalCount;
                        for(var i=0 ;i< $scope.headResult.length;i++){
                            $scope.headResult[i].showColor="";
                        }
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
            $scope.addSportHead = function (sportHead) {
                $scope.sportHead = {};

                //复制
                angular.extend($scope.sportHead, sportHead);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportHeadEidt.html",
                    controller: HeadEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.sportHead;
                        }
                    }
                });
            };

            //编辑
            $scope.edit = function (sportHead) {
                $scope.sportHead = {};
                //复制
                angular.extend($scope.sportHead, sportHead);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportHeadEidt.html",
                    controller: HeadEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.sportHead;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            };
            $scope.selectHead = {};
            $scope.showLine = function (head,index) {
                for(var i=0 ;i< $scope.headResult.length;i++){
                    $scope.headResult[i].showColor="";
                }
                $scope.headResult[index].showColor = "border:#449d44 2px solid";
                $scope.selectHead = head;
                ThermalControlService.getSportLineAllList({headId: head.id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.sportlines = data.result;
                        $scope.vm.linetotalCount = data.totalCount;
                    }
                });
            };
            /**
             * 编辑行信息
             * @param line
             */
            $scope.editline = function (line) {
                if(!$scope.selectHead){
                    dialogService.tip([
                        {"message": "请选择运动方案，添加明细！" }
                    ]);
                }
                $scope.sportline = {};
                //复制
                angular.extend($scope.sportline, line);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportStepEdit.html",
                    controller: sportlineEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return [$scope.selectHead, $scope.sportline];
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            }
            $scope.createline = function(){
                console.log($scope.selectHead);
                if($scope.selectHead.id==null){
                    dialogService.tip([
                        {"message": "请选择运动方案，添加明细！" }
                    ]);
                    return false;
                }
                $scope.sportline = {};
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportStepEdit.html",
                    controller: sportlineEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return [$scope.selectHead, $scope.sportline];
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            }
            /**
             * 删除行信息
             * @param lineId
             */
            $scope.deleteline = function (lineId) {
                var dialogDefaults = {
                    size: "sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除运动方案步骤吗？",
                    type: "delete",
                    callback: function () {
                        ThermalControlService.deleteSportLine({id: lineId}).success(function (data) {
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
            }

            //删除
            $scope.delete = function (sportHead) {
                var dialogDefaults = {
                    size: "sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除这个方案吗？",
                    type: "delete",
                    callback: function () {
                        ThermalControlService.deleteSportHead({id: sportHead.id}).success(function (data) {
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
            /**
             * 行编辑选择框
             * @type {*[]}
             */
            var sportlineEidt = ["$scope", "$modalInstance", "items", "ThermalControlService", "dialogService",
                function ($scope, $modalInstance, items, ThermalControlService, dialogService) {
                    $scope.$emit('navShow', 2);
                    $scope.sporthead = items[0];
                    $scope.sportline = items[1];
                    $scope.sportline.title = '运动方案 ' + $scope.sporthead.name;
                    $scope.vm = {};
                    //获取设置信息
                    ThermalControlService.getSportSettingAllList({pageSize: 0}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.sportsettings = data.result;
                        }
                    });

                    $scope.dolineSave = function () {
                        if ($scope.sportline.id == null) {
                            //新建Setting
                            $scope.sportline.headId=items[0].id;
                            ThermalControlService.createSportLine($scope.sportline).success(function (data) {
                                if (data.errors === null ||
                                    data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    ThermalControlService.getSportLineAllList({headId: $scope.sporthead.id}).success(function (data) {
                                        if (data.errors === null || data.errors.length > 0) {
                                            dialogService.tip(data.errors);
                                        } else {
                                            $scope.sportlines = data.result;
                                            $scope.vm.linetotalCount = data.totalCount;
                                        }
                                        //关闭
                                        $modalInstance.close($scope.sportHead);
                                    });
                                }
                            });

                        } else {
                            //编辑
                            ThermalControlService.updateSportLine($scope.sportline).success(function (data) {
                                if (data.errors === null || data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    //检查方案总时长并更新
                                    ThermalControlService.getSportLineAllList({headId: $scope.sporthead.id}).success(function (data) {
                                        if (data.errors === null || data.errors.length > 0) {
                                            dialogService.tip(data.errors);
                                        } else {
                                            $scope.sportlines = data.result;
                                            $scope.vm.linetotalCount = data.totalCount;

                                        }
                                        //关闭
                                        $modalInstance.close($scope.sportHead);
                                    });
                                }
                            });
                        }
                    }

                    $scope.clean = function () {
                        $scope.disease = {};
                        $modalInstance.dismiss('cancel');
                    };
                }]


            var HeadEidt = ["$scope", "$modalInstance", "items", "ThermalControlService", "dialogService",
                function ($scope, $modalInstance, items, ThermalControlService, dialogService) {
                    $scope.$emit('navShow', 2);
                    $scope.sportHead = items;

                    $scope.sportIntensities = [
                        {id: 'LOW', name: '低'},
                        {id: 'MIDDLE', name: '中'},
                        {id: 'HEIGHT', name: '高'}
                    ];

                    $scope.sportPlaces = [
                        {id: 'HOME', name: '住所'},
                        {id: 'OUTDOORS', name: '户外'},
                        {id: 'GYM', name: '健身房'}
                    ];

                    $scope.sportTimes = [
                        {id: 15, name: '15分钟'},
                        {id: 30, name: '30分钟'},
                        {id: 45, name: '45分钟'},
                        {id: 60, name: '60分钟'}
                    ];

                    // $scope.sportHead.title = "新增知识库";
                    $scope.couldJoin = [
                        {value: 'true', name: '是'},
                        {value: 'false', name: '否'}
                    ];
                    $scope.doSave = function () {
                        if ($scope.sportHead.id == null) {
                            //新建
                            ThermalControlService.createSportHead($scope.sportHead).success(function (data) {
                                if (data.errors === null ||
                                    data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    //返回id
                                    $scope.sportHead.id = data.id;
                                    dialogService.tip([
                                        {"message": "保存成功！"}
                                    ]);
                                    //关闭
                                    $modalInstance.close($scope.sportHead);
                                    //清空数据
                                    $scope.sportHead = {};
                                    window.location.reload();
                                }
                            });
                        } else {
                            //编辑
                            ThermalControlService.updateSportHead($scope.sportHead).success(function (data) {

                                if (data.errors === null || data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    dialogService.tip([
                                        {"message": "保存成功！"}
                                    ]);
                                    //关闭
                                    $modalInstance.close($scope.sportHead);
                                    //清空数据
                                    $scope.sportHead = {};
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


    //sportstep
    app.controller("sportsStepController", ["$scope", "$http", "$modal" , "$location", "ThermalControlService", "dialogService", "toolsService",
        function ($scope, $http, $modal, $location, ThermalControlService, dialogService, toolsService) {
            $scope.$emit('navShow', 2);
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                sourceTypes: ["SHOWCAL", "PLADMIN"]
            };
            $scope.headId = toolsService.parameter("id", $location.absUrl());
            $scope.getList = function () {
                ThermalControlService.getSportLineAllList({headId: $scope.headId}).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.lineResult = data.result;
                        $scope.vm.lineTotalCount = data.totalCount;
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip(msg);
                    }
                });
            };
            $scope.getList();
            //新增具体步骤
            $scope.addSportLine = function () {
                $scope.sportLine = {
                    headId: $scope.headId,
                    title: "新增运动步骤"
                };
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportStepEdit.html",
                    controller: LineEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.sportLine;
                        }
                    }
                });
            };

            //编辑Line
            $scope.editLine = function (sportLine) {
                $scope.sportLine = {};
                //复制
                angular.extend($scope.sportLine, sportLine);
                $scope.sportLine.title = "编辑运动步骤";
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "sportStepEdit.html",
                    controller: LineEidt,
                    size: "",
                    resolve: {
                        items: function () {
                            return $scope.sportLine;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            };

            //删除Line
            $scope.deleteLine = function (sportLine) {
                var dialogDefaults = {
                    size: "sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除这个步骤吗？",
                    type: "delete",
                    callback: function () {
                        ThermalControlService.deleteSportLine({id: sportLine.id}).success(function (data) {
                            if (data.errors === null || data.errors.length > 0) {
                                dialogService.tip(data.errors);
                            } else {
                                dialogService.tip([
                                    {"message": "删除成功！" }
                                ]);
                                var headId = {headId: sportLine.headId};
                                var totalTime = 0;
                                ThermalControlService.getSportLineAllList(headId).success(function (allLineData) {
                                    if (allLineData.errors === null || allLineData.errors.length > 0) {
                                        dialogService.tip(allLineData.errors);
                                    } else {
                                        var allLineList = allLineData.result;

                                        for (var i = 0; i < allLineList.length; i++) {
                                            totalTime += allLineList[i].time;
                                        }
                                        $scope.totalTime = totalTime;
                                        var headInfo = {id: allLineData.result[0].headId, totalTime: totalTime};
                                        ThermalControlService.updateSportHead(headInfo).success(function (isSuccessResult) {
                                            if (isSuccessResult.errors === null || isSuccessResult.errors.length > 0) {
                                                dialogService.tip(isSuccessResult.errors);
                                            } else {
                                                dialogService.tip([
                                                    {"message": "保存成功！"}
                                                ]);
                                                //关闭
                                                $modalInstance.close($scope.sportLine);
                                                //清空数据
                                                $scope.sportLine = {};
                                                $scope.totalTime = 0;
                                            }
                                        });
                                    }
                                });
                                window.location.reload();
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);
            };


            var LineEidt = ["$scope", "$modalInstance", "items", "ThermalControlService", "dialogService",
                function ($scope, $modalInstance, items, ThermalControlService, dialogService) {
                    $scope.$emit('navShow', 2);
                    $scope.sportLine = items;
                    $scope.sportTimes = [
                        {name: '15'},
                        {name: '30'},
                        {name: '45'},
                        {name: '60'}
                    ];
                    //
                    ThermalControlService.getSportSettingAllList($scope.vm).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.organisationList = data.result;
                            for (var i = 0; i < $scope.organisationList.length; i++) {
                                if ($scope.organisationList[i].id == $scope.sportLine.id) {
                                    $scope.organisationList.splice(i, 1);
                                    break;
                                }
                            }
                        }
                    });
                    ThermalControlService.getSportHead({id: $scope.sportLine.headId}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            $scope.sportLine.name = data.sportHead.name;
                        }
                    });
                    $scope.totalTime = 0;

                    $scope.doSave = function () {
                        if ($scope.sportLine.id == null) {
                            //新建Setting
                            ThermalControlService.createSportLine($scope.sportLine).success(function (data) {
                                if (data.errors === null ||
                                    data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    //返回id
                                    $scope.sportLine.id = data.id;
                                    //检查方案总时长并更新
                                    var headId = {headId: $scope.sportLine.headId};
                                    var totalTime = 0;
                                    ThermalControlService.getSportLineAllList(headId).success(function (allLineData) {
                                        if (allLineData.errors === null || allLineData.errors.length > 0) {
                                            dialogService.tip(allLineData.errors);
                                        } else {
                                            var allLineList = allLineData.result;

                                            for (var i = 0; i < allLineList.length; i++) {
                                                totalTime += allLineList[i].time;
                                            }
                                            $scope.totalTime = totalTime;
                                            var headInfo = {id: allLineData.result[0].headId, totalTime: totalTime};
                                            ThermalControlService.updateSportHead(headInfo).success(function (isSuccessResult) {
                                                if (isSuccessResult.errors === null || isSuccessResult.errors.length > 0) {
                                                    dialogService.tip(isSuccessResult.errors);
                                                } else {
                                                    dialogService.tip([
                                                        {"message": "保存成功！"}
                                                    ]);
                                                    //关闭
                                                    $modalInstance.close($scope.sportLine);
                                                    //清空数据
                                                    $scope.sportLine = {};
                                                    $scope.totalTime = 0;
                                                }
                                                window.location.reload();
                                            });
                                        }
                                    });
                                }
                            });

                        } else {
                            //编辑
                            ThermalControlService.updateSportLine($scope.sportLine).success(function (data) {

                                if (data.errors === null || data.errors.length > 0) {
                                    dialogService.tip(data.errors);
                                } else {
                                    //检查方案总时长并更新
                                    var headId = {headId: $scope.sportLine.headId};
                                    var totalTime = 0;
                                    ThermalControlService.getSportLineAllList(headId).success(function (allLineData) {
                                        if (allLineData.errors === null || allLineData.errors.length > 0) {
                                            dialogService.tip(allLineData.errors);
                                        } else {
                                            var allLineList = allLineData.result;

                                            for (var i = 0; i < allLineList.length; i++) {
                                                totalTime += allLineList[i].time;
                                            }
                                            $scope.totalTime = totalTime;
                                            var headInfo = {id: allLineData.result[0].headId, totalTime: totalTime};
                                            ThermalControlService.updateSportHead(headInfo).success(function (isSuccessResult) {
                                                if (isSuccessResult.errors === null || isSuccessResult.errors.length > 0) {
                                                    dialogService.tip(isSuccessResult.errors);
                                                } else {
                                                    dialogService.tip([
                                                        {"message": "保存成功！"}
                                                    ]);
                                                    //关闭
                                                    $modalInstance.close($scope.sportLine);
                                                    //清空数据
                                                    $scope.sportLine = {};
                                                    $scope.totalTime = 0;
                                                }
                                                window.location.reload();
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    };
                    $scope.clean = function () {
                        $scope.disease = {};
                        $modalInstance.dismiss('cancel');
                    };
                    $scope.closeAlert = function (index, form) {
                        form.splice(index, 1);
                    };
                }
            ];
        }
    ]);
    //一对多导入
    app.controller("SportHeadImportController", ["$scope", "$http", "$modal" ,  "$location","toolsService","ThermalControlService", "dialogService", function ($scope, $http, $modal, $location, toolsService,ThermalControlService, dialogService) {
        $scope.$emit('navShow', 2);
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
            ThermalControlService.apiSportHeadImport(file).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    if (data.errors.length > 10) {
                        data.errors = data.errors.slice(0, 9);
                    }
                    $scope.errorOpen(data.errors, data.url);
                } else {
                    dialogService.tip([
                        {"message": "导入成功！"}
                    ], "sportscheme");
                }
            });
        };
        $scope.downloadTemplate = function () {
            ThermalControlService.apiSportHeadTemplate().success(function (data) {
                if (data.errors == null || data.errors.length > 0) {
                    $scope.errorOpen(data.errors, data.url);
                } else {
                    window.open(data.url, "_self");
                }
            });
        };
    }
        ]);
    app.controller("SportLineImportController", ["$scope", "$http", "$modal" ,  "$location","toolsService","ThermalControlService", "dialogService", function ($scope, $http, $modal, $location, toolsService,ThermalControlService, dialogService) {
        $scope.$emit('navShow', 2);
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
            ThermalControlService.apiSportLineImport(file).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    if (data.errors.length > 10) {
                        data.errors = data.errors.slice(0, 9);
                    }
                    $scope.errorOpen(data.errors, data.url);
                } else {
                    dialogService.tip([
                        {"message": "导入成功！"}
                    ], "sportscheme");
                }
            });
        };
        $scope.downloadTemplate = function () {
            ThermalControlService.apiSportLineTemplate().success(function (data) {
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