/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.showcal.welcome", []);
    app.controller("WelcomeIndexController", ["$scope", "$http","$modal", "ShowcalService", "dialogService",
        function ($scope, $http,$modal, ShowcalService, dialogService) {
            $scope.$emit('navShow', 6);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                totalCount:0
            };
            $scope.pagedResult = [];
            /**
             * 搜索欢迎语
             */
            $scope.getList = function () {
                ShowcalService.getMyWelComeList({}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.welcomes = data.result;
                        $scope.vm.totalCount = data.totalCount;
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

            /**
             *  新建欢迎语
             *
             */
            $scope.createWelcome = function(){
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "openCreate.html",
                    controller:OpenCreate,
                    size:"",
                    resolve: {
                        items: function () {
                            return {
                                title: '新建欢迎语'
                            }
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();
                });
            };

            /**
             *  新建欢迎语
             *
             */
            $scope.doEdit = function(id){
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "openEdit.html",
                    controller:OpenEdit,
                    size:"",
                    resolve: {
                        items: function () {
                            return {
                                title: '修改欢迎语',
                                id:id
                            }
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();
                });
            };

            $scope.doActive = function(id){
                ShowcalService.activeWelcome({id:id}).success(function(data){
                    if (data.errors == null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }
                    else {
                        dialogService.tip([{message: "默认成功"}]);
                        window.location.reload();
                    }
                });
            };

            // 删除
            $scope.doDelete = function(id){
                ShowcalService.deleteWelcome({id:id}).success(function(data){
                    if (data.errors == null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }
                    else {
                        dialogService.tip([{message: "删除成功"}]);
                        window.location.reload();
                    }
                });
            };
        }
    ]);

    /**
     * 新建欢迎语维护弹出框控制器
     * @author zxl
     * @type {*[]}
     */
    var OpenCreate = ["$scope","$modalInstance","items","dialogService","PlatformService","FoundationService","ShowcalService", function ($scope,$modalInstance,items,dialogService,PlatformService,FoundationService,ShowcalService) {
        $scope.window = {};
        $scope.window.title = items.title;

        $scope.cancel = function () {
            $scope.window = {};
            $modalInstance.dismiss('cancel');
        };

        $scope.vm = {

        };

        // 保存
        $scope.doSave = function(){
            ShowcalService.createWelcome($scope.vm).success(function(data){
                if (data.errors == null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }
                else {
                    dialogService.tip([{message: "创建成功"}]);
                    //关闭
                    $modalInstance.close($scope.window);
                    //清空数据
                    $scope.window={};
                }
            });
        };
    }];

    /**
     * 修改欢迎语维护弹出框控制器
     * @author zxl
     * @type {*[]}
     */
    var OpenEdit = ["$scope","$modalInstance","items","dialogService","PlatformService","FoundationService","ShowcalService", function ($scope,$modalInstance,items,dialogService,PlatformService,FoundationService,ShowcalService) {
        $scope.window = {};
        $scope.window.title = items.title;

        $scope.cancel = function () {
            $scope.window = {};
            $modalInstance.dismiss('cancel');
        };

        $scope.vm = {

        };

        //根据id获取会员信息
        ShowcalService.getWelcome({id:items.id}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.vm = data.welcome;
            }
        });

        // 保存修改
        $scope.doSave = function(){
            ShowcalService.updateWelcome($scope.vm).success(function(data){
                if (data.errors == null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }
                else {
                    dialogService.tip([{message: "创建成功"}]);
                    //关闭
                    $modalInstance.close($scope.window);
                    //清空数据
                    $scope.window={};
                }
            });
        };
    }];


    //创建用户
    app.controller("UserManagerCreateController", ["$scope", "$http", "PlatformService","FoundationService", "dialogService",
        function ($scope, $http, PlatformService,FoundationService,dialogService) {
            $scope.user = {sex: 'MALE'};
            $scope.userTypes = [
                {name: '普通用户', id: 'USER'},
                {name: '瘦咖', id: 'SHOWCAL'},
                {name: '平台管理员', id: 'PLADMIN'}
            ];
            //弹出式日历触发函数
            $scope.openData = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.openedDate = true;
            };
            /**
             *图片保存的功能
             */
            $scope.showPicture=function(){
                var fileId=document.getElementById("pictureFile");
                fileId.onchange=function(){
                    var fileList = document.getElementById("pictureFile").files;
                    var file = fileList[0];
                    var fileReader = new FileReader();
                    fileReader.readAsDataURL(file);
                    //头像上传
                    FoundationService.uploadLogo(file).success(function(data){
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
                PlatformService.createSysUser($scope.user).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message":"用户创建成功！" }],"/platform/daily/usermanager");
                    }
                })
            }
        }
    ]);
    app.controller("IntroduceIndexController", ["$scope", "$http", "CmsService","FoundationService", "dialogService",
        function ($scope, $http, CmsService,FoundationService, dialogService) {
            $scope.$emit('navShow', 6);
            $scope.article={};
            $scope.$watch(function () {
                return $scope.userId;
            }, function (newValue) {
                if (newValue) {
                    $scope.getList();
                }
            });

            $scope.vm = {
                pageNumber: 1,
                pageSize: 0,

                categoryId:"INTRODUCTION",
                totalCount:0
            };
            $scope.getList = function () {
                $scope.vm.submitUserId=$scope.userId;
                CmsService.findArticle($scope.vm).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors, null, null);
                    } else {
                        if(data.result.length>0) {
                            $scope.article = data.result[0];
                            $scope.vm.totalCount = data.totalCount;
                        }
                    }
                });
            };
            $scope.showPicture=function(){
                var fileId=document.getElementById("pictureFile");
                fileId.onchange=function(){
                    var fileList = document.getElementById("pictureFile").files;
                    var file = fileList[0];
                    var fileReader = new FileReader();
                    fileReader.readAsDataURL(file);
                    //头像上传
                    FoundationService.uploadLogo(file).success(function(data){
                        if(data.errors === null || data.errors.length > 0){
                            dialogService.tip(data.errors);
                        }else{
                            $scope.article.coverId = data.id;
                            $scope.article.avatarurl = data.url;
                        }
                    });
                };
            };
            $scope.doSave = function () {
                $scope.article.categoryId="INTRODUCTION";
                CmsService.createArticle($scope.article).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors, null, null);
                    } else {
                        dialogService.tip([{"message": "创建成功！"}],null);
                        $scope.getList();
                    }
                });
            };
            $scope.update = function () {
                CmsService.updateArticle($scope.article).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors, null, null);
                    } else {
                        dialogService.tip([{"message": "更新成功！"}],null);
                        $scope.getList();
                    }
                });
            }
        }
    ]);
})();