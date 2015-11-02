/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.usermanager", []);
    app.controller("UserManagerIndexController", ["$scope", "$http", "$modal", "PlatformService", "dialogService",
        function ($scope, $http, $modal, PlatformService, dialogService) {
            $scope.$emit('navShow', 4);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                sourceTypes: ["REGISTER", "PLATFORM"]
            };
            $scope.pagedResult = [];
            $scope.userTypes = [
                {key: "USER", value: "用户", state: false},
                {key: "SHOWCAL", value: "瘦咖", state: false},
                {key: "PLADMIN", value: "平台管理员", state: false}
            ];
            $scope.sexs = [
                {key: "MALE", value: "男", state: false},
                {key: "FEMALE", value: "女", state: false}
            ];
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
            $scope.usertags = [];
            PlatformService.getSettingUserTagAllList({}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.usertags = data.result;
                }
            });

            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                $scope.vm.usertags = [];
                if ($scope.vm.usertag) {
                    $scope.vm.usertags.push($scope.vm.usertag);
                }
                PlatformService.findSysUser($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.pagedResult = data.result;
                        for (var i = 0; i < $scope.pagedResult.length; i++) {
                            $scope.pagedResult[i].check = false;
                        }
                        console.log($scope);
                        $scope.vm.totalCount = data.totalCount;
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip([{"message": msg}], null, 400);
                    }
                });
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
             * 页面初始化加载数据
             */
            $scope.doSearch = function () {
                $scope.vm.pageNumber = 1;
                if ($scope.vm.usertypesObj) {
                    $scope.vm.usertypes = [];
                    for (var i = 0; i < $scope.vm.usertypesObj.list.length; i++) {
                        $scope.vm.usertypes.push($scope.vm.usertypesObj.list[i].key);
                    }
                }
                if ($scope.vm.sexsObj) {
                    $scope.vm.sexs = [];
                    for (var j = 0; j < $scope.vm.sexsObj.list.length; j++) {
                        $scope.vm.sexs.push($scope.vm.sexsObj.list[j].key);
                    }
                }

                if ($scope.vm.startDate instanceof Date) {
                    $scope.vm.startDate = $scope.vm.startDate.format("yyyy-MM-dd");
                }
                if ($scope.vm.endDate instanceof Date) {
                    $scope.vm.endDate = $scope.vm.endDate.format("yyyy-MM-dd");
                }
                /*if($scope.vm.usertag){
                 $scope.vm.usertags = [];
                 $scope.vm.usertags.push($scope.vm.usertag);
                 }*/
                $scope.getList();
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

            /**
             *  升级为瘦咖
             */
            $scope.toShowcal = function (id) {
                PlatformService.upSysUser({id: id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "成功升级为瘦咖！"}], "/platform/daily/usermanager");
                    }
                });
            };

            /**
             *  降级为会员
             */
            $scope.toUser = function (id) {
                PlatformService.downSysUser({id: id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "成功降级为会员！"}], "/platform/daily/usermanager");
                    }
                });
            };

            /**
             *  降级为会员
             */
            $scope.doDelete = function (id) {
                PlatformService.deleteSysUser({id: id}).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "成功删除！"}], "/platform/daily/usermanager");
                    }
                });
            };

            /**
             *  服务评价
             */
            $scope.comment = function (id) {
                // 弹出服务评价窗口
               var modalInstance = $modal.open({
                    templateUrl: "chooseComment.html",
                    size: "lg",
                    resolve: {
                        userId: function(){
                            return id;
                        }
                    },
                    controller: ChooseCommentController
                });
                modalInstance.result.then(function () {

                })
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
                    templateUrl: "chooseArticle.html",
                    size: "lg",
                    resolve: {
                        userIds: function () {
                            return $scope.userIds;
                        }
                    },
                    controller: ChooseArticleController
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
                    templateUrl: "sendMessage.html",
                    size: "lg",
                    resolve: {
                        userIds: function () {
                            return $scope.userIds;
                        }
                    },
                    controller: SendMessageController
                });
                modalInstance.result.then(function () {

                })
            };
        }
    ]);
    //创建用户
    app.controller("UserManagerCreateController", ["$scope", "$http", "PlatformService", "FoundationService", "dialogService",
        function ($scope, $http, PlatformService, FoundationService, dialogService) {
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
                            $scope.user.avatarurl = data.url;
                            $scope.user.avatarId = data.id;
                        }
                    });
                };
            };


            $scope.doSave = function () {
                console.log($scope.user);
                if ($scope.user.birthday instanceof  Date) {
                    $scope.user.birthday = $scope.user.birthday.format('yyyy-MM-dd');
                }
                PlatformService.createSysUser($scope.user).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        dialogService.tip([{"message": "用户创建成功！"}], "/platform/daily/usermanager");
                    }
                })
            }
        }
    ]);
    var showcalDetailController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService, user) {

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
        PlatformService.getSysUserCurveAllListbyUser(param).success(function (data) {
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
            PlatformService.getSysUserCurveAllListbyUser(param).success(function (data) {
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
            PlatformService.getSysUserCurveAllListbyUser(param).success(function (data) {
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
            PlatformService.getSysUserCurveAllListbyUser(param).success(function (data) {
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
    };


    var ChooseArticleController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService, PlatformService, userIds) {
        $scope.articles = [];
        console.log(userIds);
        $scope.vm1 = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
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
    };
    var SendMessageController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService, userIds) {
        $scope.content;
        $scope.title;
        console.log(userIds);
        $scope.userIds= [];
        $scope.sendMessages=[];
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
    };

    var ChooseCommentController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService, PlatformService, userId) {
        $scope.commentPosts = [];

        $scope.vm2 = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };

        $scope.changeCommentBox = function (index) {
            $scope.commentPosts[index].check = !$scope.commentPosts[index].check;
        };

        $scope.allCommentPost = false;
        $scope.allCommentBox = function(){
            $scope.allCommentPost = !$scope.allCommentPost;
            if($scope.commentPosts.length > 0){
                for(var i=0; i<$scope.commentPosts.length; i++){
                    $scope.commentPosts[i].check = $scope.allCommentPost;
                }
            }
        };

        $scope.delete = function(){
            $scope.commentPostIds = [];
            for(var i=0; i<$scope.commentPosts.length; i++){
                if($scope.commentPosts[i].check){
                    $scope.commentPostIds.push($scope.commentPosts[i].id);
                }
            }
            if($scope.commentPostIds.length == 0){
                return false;
            }
            PlatformService.deleteCommentPostBatch({ids:$scope.commentPostIds}).success(function(data){
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "删除成功！"}], null);
                    $modalInstance.close();
                    $modalInstance.dismiss('cancel');
                }
            });
        };

        $scope.getAllComment = function(){
            PlatformService.findComment({threadId : userId}).success(function(data){
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.commentPosts = data.result;
                    $scope.vm2.totalCount = data.totalCount;
                    for(var i=0; i<$scope.commentPosts.length; i++){
                        $scope.commentPosts[i].check = false;
                    }
                }
            });
        };

        $scope.getAllComment();
    };
})();