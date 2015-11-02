/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.food", []);
    app.controller("FoodIndexController", ["$scope", "$http", "ThermalControlService", "dialogService",
        function ($scope, $http, ThermalControlService, dialogService) {
            $scope.$emit('navShow', 3);

            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                sourceTypes: ["SHOWCAL", "PLADMIN"]
            };

            $scope.doSearch = function () {
                $scope.foodActives = [
                    {sqlSave:'true',name:'已发布'},
                    {sqlSave:'false', name:'未发布'}
                ];

                ThermalControlService.findFood($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.searchResult = data.result;
                        $scope.vm.totalCount = data.totalCount;

                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip(msg);
                    }
                });

           /*     var thisParameter={};
                ThermalControlService.getFoodCategoryAllList(thisParameter).success(function(data){
                    if(data.errors === null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        $scope.foodCategoryList = data.result;
                        /!* for(var i=0;i<$scope.foodCategoryList.length;i++){
                         if($scope.foodCategoryList[i].id == $scope.id){
                         $scope.foodCategoryList.splice(i,1);
                         break;
                         }
                         }*!/
                    }
                });*/
            };

            $scope.doSearch();

            $scope.doFind = function () {
                $scope.searchResult={};
             /*   $scope.searchFood={};
                //复制
                angular.extend($scope.searchFood ,searchFood);*/
               /* var cols = [
                    { title:'类别', name:'foodLargeCategory' , align:'center',width:80},
                    { title:'名称', name:'name' , align:'center',width:80,lockDisplay:true},
                    {title: '重量',name:'weight', align: 'center',width:80},
                    { title:'热量', name:'heat' , align:'center',width:80,type: 'number'},
                    { title:'单位热量', name:'unitheat' , align:'center',width:80,type: 'number'},
                    { title:'蛋白质', name:'protein' , align:'center',width:80,type: 'number'},
                    { title:'脂肪', name:'fat' , align:'center',width:80,type: 'number'},
                    { title:'碳水化合物', name:'carbohydrate' , align:'center',width:80,type: 'number'},
                    { title:'膳食纤维', name:'df' , align:'center',width:80,type: 'number'},
                    { title:'交换份克数', name:'foodExchange' , align:'center',width:80,type: 'number'},
                    { title:'单位食用克数', name:'edubleUnit' ,align:'center',width:110, type: 'number'},
                    { title:'食物分类', name:'foodCategoryId' ,align:'center',width:100, type: 'number'},
                    { title:'减肥推荐', name:'isLose' ,align:'center',width:80, type: 'number'},
                    { title:'增肌推荐', name:'isAddMuscle' ,align:'center',width:80, type: 'number'},
                    { title:'最后修改时间', name:'lastUpdateTime' ,align:'center',width:80, type: 'number'},
                    { title:'最后修改人', name:'lastUpdateBy' ,align:'center',width:80, type: 'number'},
                    { title:'状态', name:'isActive' ,align:'center',width:80, type: 'number'}
                ];
                var mmg = jQuery('#table').mmGrid({
                    height: 500,
                    cols: cols,
                    url: '$tcContent.getURI("api.do?method=api.thermalcontrol.food.find")',
                    method: 'post',
                    remoteSort:true,
                    nowrap:true,
                    root:'result',
                    fullWidthRows: true,
                    loadErrorText:'数据加载异常...',
                    autoLoad: true,
                    indexCol:true,
                    indexColWidth:30,
                    plugins: [
                        $('#pg').mmPaginator({limitList:[10,20,30]})
                    ],
                    params: function(){
                        return {
                            data:$scope.searchF
                        }
                    }
                });*/



                ThermalControlService.findFood($scope.searchF).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.searchResult = data.result;
                        $scope.vm.totalCount = data.totalCount;
                        var cols = [
                            { title:'类别', name:'foodLargeCategory' , align:'center',width:80},
                            { title:'名称', name:'name' , align:'center',width:80,lockDisplay:true},
                            {title: '重量',name:'weight', align: 'center',width:80},
                            { title:'热量', name:'heat' , align:'center',width:80,type: 'number'},
                            { title:'单位热量', name:'unitheat' , align:'center',width:80,type: 'number'},
                            { title:'蛋白质', name:'protein' , align:'center',width:80,type: 'number'},
                            { title:'脂肪', name:'fat' , align:'center',width:80,type: 'number'},
                            { title:'碳水化合物', name:'carbohydrate' , align:'center',width:80,type: 'number'},
                            { title:'膳食纤维', name:'df' , align:'center',width:80,type: 'number'},
                            { title:'交换份克数', name:'foodExchange' , align:'center',width:80,type: 'number'},
                            { title:'单位食用克数', name:'edubleUnit' ,align:'center',width:110, type: 'number'},
                            { title:'食物分类', name:'foodCategoryId' ,align:'center',width:100, type: 'number'},
                            { title:'减肥推荐', name:'isLose' ,align:'center',width:80, type: 'number'},
                            { title:'增肌推荐', name:'isAddMuscle' ,align:'center',width:80, type: 'number'},
                            { title:'最后修改时间', name:'lastUpdateTime' ,align:'center',width:80, type: 'number'},
                            { title:'最后修改人', name:'lastUpdateBy' ,align:'center',width:80, type: 'number'},
                            { title:'状态', name:'isActive' ,align:'center',width:80, type: 'number'}
                        ];
                        var mmg = jQuery('#table').mmGrid({
                            height: 500,
                            cols: cols,
                            url: '$tcContent.getURI("api.do?method=api.thermalcontrol.food.find")',
                            method: 'post',
                            remoteSort:true,
                            nowrap:true,
                            root:'result',
                            fullWidthRows: true,
                            loadErrorText:'数据加载异常...',
                            autoLoad: true,
                            indexCol:true,
                            indexColWidth:30,
                            plugins: [
                                $('#pg').mmPaginator({limitList:[10,20,30]})
                            ],
                            params: function(){
                                return {
                                    data:searchF
                                }
                            }
                        });
                        mmg.removeRow();
                        mmg.addRow($scope.searchResult,undefined);
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip(msg);
                        $scope.searchF=null;
                    }
                });
            };

            /**
             *  发布
             */
            $scope.doActive = function (id) {
                ThermalControlService.activeFood({id: id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "发布成功！"}], "/platform/food/food");
                    }
                });
            };

            /**
             *  取消发布
             */
            $scope.cancelActive = function (id) {
                ThermalControlService.inactiveFood({id: id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "取消发布成功！"}], "/platform/food/food");
                    }
                });
            };

        }

    ]);
    // 批量导入数据
    app.controller("FoodImportController", ["$scope", "$http","$modal", "ThermalControlService", "dialogService",
        function ($scope, $http, $modal, ThermalControlService, dialogService) {
            $scope.$emit('navShow', 3);
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
                ThermalControlService.apiFoodImport(file).success(function(data){
                    if(data.errors == null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                            dialogService.tip([{"message": "导入成功！"}]);
                    }
                });
            };

            // 下载模版
            $scope.downloadTemplate=function(){
                ThermalControlService.apiFoodOutputTemplate().success(function(data){
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
    //创建用户
   /* app.controller("FoodIndexController", ["$scope", "$http","ThermalControlService","dialogService",
        function ($scope, $http, ThermalControlService,dialogService) {



            /!**
             *图片保存的功能
             *!/
   /!*         $scope.showPicture=function(){
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
            };


            $scope.doSave = function () {
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