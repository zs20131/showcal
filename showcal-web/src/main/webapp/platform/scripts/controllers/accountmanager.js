/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.accountmanager", []);
    app.controller("AccountManagerIndexController", ["$scope","$modal", "$http", "PlatformService", "dialogService",
        function ($scope,$modal, $http, PlatformService, dialogService) {
            $scope.$emit('navShow', 4);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                sourceTypes: ["REGISTER", "PLATFORM"]
            };
            $scope.pagedResult = [];

            $scope.checkboxlist = [
                {key:"BANNED", value:"禁言", state:false},
                {key:"BLOCK", value:"封锁", state:false},
                {key:"NORMAL", value:"正常", state:false}
            ];

            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                PlatformService.findSysUser($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.pagedResult = data.result;
                        console.log($scope);
                        $scope.vm.totalCount = data.totalCount;
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip([{"message":msg }],null,400);
                    }
                });
            };
            /**
             * 页面初始化加载数据
             */
            $scope.doSearch = function () {
                $scope.vm.pageNumber = 1;
                if($scope.vm.statusObj){
                    $scope.vm.status = [];
                    for(var i = 0 ; i < $scope.vm.statusObj.list.length; i++){
                        $scope.vm.status.push($scope.vm.statusObj.list[i].key);
                    }
                }
                $scope.getList();
            };
            $scope.doSearch();

            /**
             *  禁言用户
             * @param id
             */
            $scope.ban = function(id){
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "openBan.html",
                    controller:OpenBan,
                    size:"",
                    resolve: {
                        items: function () {
                            return {
                                title: '禁言',
                                userId: id
                            }
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();
                });
            };

            /**
             * 取消封锁
             * @param id
             */
            $scope.inBan = function(id){
                PlatformService.inbanSysUser({id:id}).success(function(data){
                    if(data.errors === null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        dialogService.tip([{"message":"解除禁言成功！" }],"/platform/daily/accountmanager");
                    }
                });
            };

            /**
             * 解除封锁
             * @param id
             */
            $scope.doActive = function(id){
                PlatformService.activeUser({id:id}).success(function(data){
                    if(data.errors === null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        dialogService.tip([{"message":"解除封锁成功！" }],"/platform/daily/accountmanager");
                    }
                });
            };

            /**
             * 封锁
             * @param id
             */
            $scope.doInActive = function(id){
                PlatformService.inactiveUser({id:id}).success(function(data){
                    if(data.errors === null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        dialogService.tip([{"message":"封锁成功！" }],"/platform/daily/accountmanager");
                    }
                });
            };

            /**
             * 重置密码
             * @param id
             */
            $scope.doResetPassword = function(id){
                PlatformService.resetUserLoginPassword({id:id}).success(function(data){
                    if(data.errors === null || data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        dialogService.tip([{"message":"重置密码成功！" }],"/platform/daily/accountmanager");
                    }
                });
            };
        }
    ]);

    /**
     * 禁言维护弹出框控制器
     * @author zxl
     * @type {*[]}
     */
    var OpenBan = ["$scope","$modalInstance","items","dialogService","PlatformService","FoundationService", function ($scope,$modalInstance,items,dialogService,PlatformService,FoundationService) {
        $scope.window = {};
        $scope.window.title = items.title;

        $scope.cancel = function () {
            $scope.window = {};
            $modalInstance.dismiss('cancel');
        };

        $scope.vm = {

        };

        // 根据ID查询用户
        PlatformService.getSysUser({id:items.userId}).success(function(data){
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.vm = data.sysUser;
            }
        });

        // 禁言
        $scope.doBan = function(){
            PlatformService.banSysUser($scope.vm).success(function(data){
                if (data.errors == null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }
                else {
                    dialogService.tip([{message: "禁言成功"}]);
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
})();