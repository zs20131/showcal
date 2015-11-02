/**
 * Created by xiniu on 9/24 0024.
 */
(function () {
    "use strict";
    var app = angular.module("sc.showcal.myuser", []);
        app.controller("MyUserIndexController", ["$scope","$modal", "$http","PlatformService", "ShowcalService", "dialogService",
        function ($scope,$modal, $http,PlatformService, ShowcalService, dialogService) {
            $scope.$emit('navShow', 2);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                totalCount:0
            };
            $scope.vmH = {
                pageNumber: 1,
                pageSize: 10,
                totalCount:0
            };
            $scope.sexs = [
                {key:"MALE", value:"男", state:false},
                {key:"FEMALE", value:"女", state:false}
            ];
            $scope.startDate = false;
            $scope.endDate = false;
            //监控userId是否获取
            $scope.passportId={};
            $scope.$watch(function () {
                return $scope.userId;
            }, function (newValue) {
                if (newValue) {
                    $scope.passportId=newValue;
                }
            });
            //弹出式日历触发函数
            $scope.openStartDate = function($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.startDate = true;
            };
            //弹出式日历触发函数
            $scope.openEndDate = function($event) {
                $event.preventDefault();
                $event.stopPropagation();
                $scope.endDate = true;
            };

            // 查询标签
            $scope.usertags = [];
            PlatformService.getSettingUserTagAllList({}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.usertags = data.result;
                }
            });

            $scope.pagedResult = [];
            /**
             * 搜索欢迎语
             */

            /**
             *  给用户贴标签
             * @param id
             */
            $scope.addTag = function(id){
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "openTag.html",
                    controller:OpenTag,
                    size:"",
                    resolve: {
                        items: function () {
                            return {
                                title: '贴标签',
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
             *  获取当前服务对象
             */
            $scope.getList = function () {
                $scope.vm.userTags = [];
                if ($scope.vm.usertag) {
                    $scope.vm.userTags.push($scope.vm.usertag);
                }
                ShowcalService.getMyServiceUser($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.pagedResult = data.result;
                        console.log($scope);
                        $scope.vm.totalCount = data.totalCount;
                        for (var i = 0; i < $scope.pagedResult.length; i++) {
                            $scope.pagedResult[i].check = false;
                        }
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
             *  获取历史服务对象
             */
            $scope.getHistoryList = function () {
                $scope.vm.userTags = [];
                if ($scope.vm.usertag) {
                    $scope.vm.userTags.push($scope.vm.usertag);
                }
                ShowcalService.getMyHistoryServiceUser($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.pagedHistoryResult = data.result;
                        console.log($scope);
                        $scope.vmH.totalCount = data.totalCount;
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
                if ($scope.vm.startDate instanceof Date) {
                    $scope.vm.startDate = $scope.vm.startDate.format("yyyy-MM-dd");
                }
                if ($scope.vm.endDate instanceof Date) {
                    $scope.vm.endDate = $scope.vm.endDate.format("yyyy-MM-dd");
                }
                if($scope.vm.sexsObj){
                    $scope.vm.sexs = [];
                    for(var j = 0; j < $scope.vm.sexsObj.list.length; j++){
                        $scope.vm.sexs.push($scope.vm.sexsObj.list[j].key);
                    }
                }
                $scope.getList();
                $scope.getHistoryList();
            };
            $scope.doSearch();

            $scope.showcal=function(user){
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "showcaldetail.html",
                    size: "lg",
                    resolve: {
                        user: function () {
                            return user;
                        }
                    },
                    controller: showcalDetailController
                });
                modalInstance.result.then(function () {

                })
            };

            $scope.all = false;
            $scope.allBox = function () {
                $scope.all = !$scope.all;
                if ($scope.pagedResult.length > 0) {
                    for (var i = 0; i < $scope.pagedResult.length; i++) {
                        $scope.pagedResult[i].check = $scope.all;
                    }
                }
            };
            $scope.changeBox = function (index) {
                $scope.pagedResult[index].check = !$scope.pagedResult[index].check;
            };

            /**
             * 帖子推送弹框
             */
            $scope.pushArticle = function () {
                $scope.userIds = [];
                for (var i = 0; i < $scope.pagedResult.length; i++) {
                    if ($scope.pagedResult[i].check) {
                        $scope.userIds.push($scope.pagedResult[i].id);
                    }
                }
                if ($scope.userIds.length == 0) {
                    dialogService.tip([{"message": "请选择需要推送帖子的用户！"}], null);
                    return false;
                }
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "choose.html",
                    size: "lg",
                    resolve: {
                        userIds: function () {
                            return $scope.userIds;
                        },
                        userId: function () {
                            return $scope.passportId;
                        },
                    },
                    controller: ChooseController
                });
                modalInstance.result.then(function () {

                })
            };
            /**
             * 系统消息
             */
            $scope.sendMessage = function () {
                $scope.userIds = [];
                for (var i = 0; i < $scope.pagedResult.length; i++) {
                    if ($scope.pagedResult[i].check) {
                        $scope.userIds.push($scope.pagedResult[i].id);
                    }
                }
                if ($scope.userIds.length == 0) {
                    dialogService.tip([{"message": "请选择用户！"}], null);
                    return false;
                }
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "send.html",
                    size: "lg",
                    resolve: {
                        userIds: function () {
                            return $scope.userIds;
                        }
                    },
                    controller: SendController
                });
                modalInstance.result.then(function () {

                })
            };
        }
    ]);

    /**
     * 贴标签维护弹出框控制器
     * @author zxl
     * @type {*[]}
     */
    var OpenTag = ["$scope","$modalInstance","items","dialogService","PlatformService","FoundationService", function ($scope,$modalInstance,items,dialogService,PlatformService,FoundationService) {
        $scope.window = {};
        $scope.window.title = items.title;

        $scope.cancel = function () {
            $scope.window = {};
            $modalInstance.dismiss('cancel');
        };

        $scope.usertags = [];
        PlatformService.getSettingUserTagAllList({}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.usertags = data.result;
            }
        });

        $scope.vm = {

        };

        // 贴标签
        $scope.doTag = function(){
            $scope.vm.userId = items.userId;
            $scope.vm.userTagId = $scope.vm.usertag;

            PlatformService.createSysUserTag($scope.vm).success(function(data){
                if (data.errors == null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }
                else {
                    dialogService.tip([{message: "贴标签成功"}]);
                    setTimeout(function(){
                        //关闭
                        $modalInstance.close($scope.window);
                        //清空数据
                        $scope.window={};
                    },300);
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

    var showcalDetailController =["$scope","$modalInstance","dialogService","$modal","toolsService","$location", "PlatformService", "user",function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService, user) {

        console.log(user);
        $scope.vm = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
        };
        $scope.user =  user
        var param = {
            userId:$scope.user.id,
            type:'WEIGHT'
        }
        $scope.firstWeight = 0;
        PlatformService.findSysUserCurve(param).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.weights = data.result;
                if(data.result.length > 0){
                    $scope.firstWeight = data.result[0];
                }
                $scope.weighttotalCount = data.totalCount;
            }
        })

        $scope.vm.color="color-gray"
        $scope.weightshow=function(){
            $scope.weight=true;
            $scope.back=false;
            $scope.hip=false;
            $scope.cal=false;
            $scope.sporttime=false;
            $scope.sportconsume=false;
            if($scope.weight){
                $scope.vm.color="color-gray"
                $scope.vm.color1="";
                $scope.vm.color2="";
                $scope.vm.color3="";
                $scope.vm.color4="";
                $scope.vm.color5=""
            }
            // 查询数据
            var param = {
                userId:$scope.user.id,
                type:'WEIGHT'
            }
            PlatformService.findSysUserCurve(param).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.weights = data.result;
                    $scope.weighttotalCount = data.totalCount;
                }
            })
        };

        $scope.backshow=function(){
            $scope.weight=false;
            $scope.back=true;
            $scope.hip=false;
            $scope.cal=false;
            $scope.sporttime=false;
            $scope.sportconsume=false;
            if($scope.back){
                $scope.vm.color1="color-gray";
                $scope.vm.color="";
                $scope.vm.color2="";
                $scope.vm.color3="";
                $scope.vm.color4="";
                $scope.vm.color5=""
            }
            var param = {
                userId:$scope.user.id,
                type:'WAISTLINE'
            }
            PlatformService.findSysUserCurve(param).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.waistlines = data.result;
                    $scope.waistlineCount = data.totalCount;
                }
            })
        };

        $scope.hipshow=function(){
            $scope.weight=false;
            $scope.back=false;
            $scope.hip=true;
            $scope.cal=false;
            $scope.sporttime=false;
            $scope.sportconsume=false;
            if($scope.hip){
                $scope.vm.color2="color-gray";
                $scope.vm.color="";
                $scope.vm.color1="";
                $scope.vm.color3="";
                $scope.vm.color4="";
                $scope.vm.color5=""
            }
            var param = {
                userId:$scope.user.id,
                type:'HIPLINE'
            }
            PlatformService.findSysUserCurve(param).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.hiplines  = data.result;
                    $scope.hiplineCount = data.totalCount;
                }
            })
        };
        $scope.calshow=function(){
            $scope.weight=false;
            $scope.back=false;
            $scope.hip=false;
            $scope.cal=true;
            $scope.sporttime=false;
            $scope.sportconsume=false;
            if($scope.cal){
                $scope.vm.color3="color-gray";
                $scope.vm.color="";
                $scope.vm.color1="";
                $scope.vm.color2="";
                $scope.vm.color4="";
                $scope.vm.color5=""
            }
        };
        $scope.sporttimeshow=function(){
            $scope.weight=false;
            $scope.back=false;
            $scope.hip=false;
            $scope.cal=false;
            $scope.sporttime=true;
            $scope.sportconsume=false;
            if($scope.sporttime){
                $scope.vm.color4="color-gray";
                $scope.vm.color="";
                $scope.vm.color1="";
                $scope.vm.color2="";
                $scope.vm.color3="";
                $scope.vm.color5=""
            }
        };
        $scope.sportconsumeshow=function(){
            $scope.weight=false;
            $scope.back=false;
            $scope.hip=false;
            $scope.cal=false;
            $scope.sporttime=false;
            $scope.sportconsume=true;
            if($scope.sportconsume){
                $scope.vm.color5="color-gray";
                $scope.vm.color="";
                $scope.vm.color1="";
                $scope.vm.color2="";
                $scope.vm.color3="";
                $scope.vm.color4=""

            }
        };


        /*    PlatformService.findSysUser({id:userId}).success(function (data) {
         if (data.errors === null || data.errors.length > 0) {
         dialogService.tip(data.errors, null, null);
         } else {

         }
         });*/
        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }];

    /**
     * 贴标签维护弹出框控制器
     * @author zxl
     * @type {*[]}
     */
    var ChooseController = ["$scope","$modalInstance","dialogService","$modal","toolsService","$location", "CmsService", "PlatformService", "userIds","userId", function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService, PlatformService, userIds,userId) {
        $scope.articles = [];
        console.log(userIds);
        $scope.vm1 = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0,
            submitUserId:userId
        };
        $scope.getAllArticle = function () {
            CmsService.findArticle($scope.vm1).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.articles = data.result;
                    $scope.vm1.totalCount = data.totalCount;
                    for (var i = 0; i < $scope.articles.length; i++) {
                        $scope.articles[i].check = false;
                    }
                }
            })
        };
        $scope.getAllArticle();
        $scope.doFind = function () {
            $scope.getAllArticle();
        };
        $scope.allArticle = false;
        $scope.allArticleBox = function () {
            $scope.allArticle = !$scope.allArticle;
            if ($scope.articles.length > 0) {
                for (var i = 0; i < $scope.articles.length; i++) {
                    $scope.articles[i].check = $scope.allArticle;
                }
            }
        };
        $scope.changeArticleBox = function (index) {
            $scope.articles[index].check = !$scope.articles[index].check;
        };
        $scope.create = function () {
            $scope.articleIds = [];
            for (var i = 0; i < $scope.articles.length; i++) {
                if ($scope.articles[i].check) {
                    $scope.articleIds.push($scope.articles[i].id);
                }
            }
            if ($scope.articleIds.length == 0) {
                $scope.validateForm.$errors.push("请选择需要推送的帖子");
                return false;
            }
            $scope.pushArticles = [];
            for (var i = 0; i < userIds.length; i++) {
                for (var j = 0; j< $scope.articleIds.length; j++) {
                    $scope.pushArticle = {
                        businessType: "ARTICLE",
                        businessId: $scope.articleIds[j],
                        receiptId: userIds[i]
                    };
                    $scope.pushArticles.push($scope.pushArticle);
                }
            }
            $scope.message = {
                sysMessageCreateRequestList: $scope.pushArticles
            };
            PlatformService.createMessage($scope.message).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "推送成功！"}], null);
                    $modalInstance.close();
                    $modalInstance.dismiss('cancel');
                }
            });

        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

    }];

    var SendController = ["$scope","$modalInstance","dialogService","$modal","toolsService","$location", "CmsService", "PlatformService", "userIds",function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService, userIds) {
        $scope.content;
        $scope.title;
        console.log(userIds);
        $scope.userIdss = [];
        $scope.send = function () {

            if($scope.content.length>15){
                $scope.title= $scope.content.substring(0,15);
            }
            else{
                $scope.title= $scope.content;
            }
            for (var i = 0; i < userIds.length; i++) {
                $scope.sendMessage = {
                    businessType: "SYSTEM",
                    receiptId: userIds[i],
                    messageTitle: $scope.title,
                    messageContent: $scope.content
                };
                $scope.sendMessages.push( $scope.sendMessage);
            }

            $scope.message = {
                sysMessageCreateRequestList: $scope.sendMessages
            };
            PlatformService.createMessage($scope.message).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "消息发送成功！"}], null);
                    $modalInstance.close();
                    $modalInstance.dismiss('cancel');
                }
            });

        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }];
})();