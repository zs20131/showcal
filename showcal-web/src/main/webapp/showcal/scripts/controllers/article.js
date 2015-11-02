(function () {
    "use strict";
    // 文章首页控制器
    var articleIndexController = function ($scope, dialogService, $modal, toolsService, $location, CmsService) {
        //显示不同的导航NAV的数值
        $scope.$emit('nav', 2);
        //每个导航对应的图标的高亮
        $scope.$emit('navShow', 4);
        $scope.articles = [];
        $scope.vm = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
        };
        //监控userId是否获取
        $scope.$watch(function () {
            return $scope.userId;
        }, function (newValue) {
            if (newValue) {
                $scope.vm.submitUserId=newValue;
                $scope.getList();
            }
        });
        //弹出式日历触发函数
        $scope.openStart = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.startDate = true;
        };
        $scope.checkboxlist = [
            {key: "save", value: "未发布", state: false, hide: false},
            {key: "submit", value: "已发布", state: false, hide: false},
        ];
        $scope.alreadySubmit = [0, 1];
        $scope.changeStatus = function (status) {
            $scope.selectedStatus = [];
            for (var i = 0; i < status.list.length; i++) {
                $scope.selectedStatus.push(status.list[i].key);
            }
            if (status.list.length == $scope.checkboxlist.length) {
                $scope.alreadySubmit = [0, 1];
            }
            else {
                for (var i = 0; i < $scope.selectedStatus.length; i++) {
                    if ($scope.selectedStatus[i] == "save") {
                        $scope.alreadySubmit = [];
                        $scope.alreadySubmit.push(0);
                    }
                    if ($scope.selectedStatus[i] == "submit") {
                        $scope.alreadySubmit = [];
                        $scope.alreadySubmit.push(1);
                    }
                }
            }
            if (status.list.length == 0) {
                $scope.alreadySubmit = [0, 1];
            }
        };
        $scope.changeOrder=function(article){
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "changeOrder.html",
                size: "sm",
                resolve: {
                    article: function () {
                        return article;
                    }
                },
                controller:ChangeOrderController
            });
            modalInstance.result.then(function () {
                $scope.getList();
            })
        };
        //弹出式日历触发函数
        $scope.openEnd = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.endDate = true;
        };
        $scope.getList = function () {
            $scope.vm.alreadySubmit = $scope.alreadySubmit;
            if ($scope.vm.startDate instanceof Date) {
                $scope.vm.approveStartTime = $scope.vm.startDate.format("yyyy-MM-dd");
            }
            if ($scope.vm.endDate instanceof Date) {
                $scope.vm.approveEndTime = $scope.vm.endDate.format("yyyy-MM-dd");
            }
            CmsService.findArticle($scope.vm).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.articles = data.result;
                    $scope.vm.totalCount = data.totalCount;
                }
            });
        };
        $scope.doFind = function () {
            $scope.getList();
        };
        $scope.doDelete = function (article) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定删除",
                headerText: "继续....?",
                bodyText: "您确定要删除此帖子吗？",
                callback: function () {
                    CmsService.deleteArticle({id: article.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "删除成功"}], null);
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };

        //管理所有评论
        $scope.checkComment = function (article) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "checkCommentPost.html",
                size: "lg",
                resolve: {
                    article: function () {
                        return article;
                    }
                },
                controller: CheckCommentpostController
            });
            modalInstance.result.then(function () {
                $scope.getList();
            })
        };

        $scope.doSuccess = function (article) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定升级",
                headerText: "继续....?",
                bodyText: "您确定要升级为成功案例吗？",
                callback: function () {
                    CmsService.successArticle({id: article.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "升级成功"}], null);
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };
        $scope.doUnSuccess = function (article) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定撤销",
                headerText: "继续....?",
                bodyText: "您确定要撤销成功案例吗？",
                callback: function () {
                    CmsService.unsuccessArticle({id: article.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "撤销成功"}], null);
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };
        $scope.approve = function (article) {
            var dialogDefaults = {
                size: "sm"
            };
            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定发布",
                headerText: "继续....?",
                bodyText: "您确定要发布吗？",
                callback: function () {
                    CmsService.approveArticle({id: article.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "发布成功"}], null);
                            //$scope.articles[$scope.articles.indexOf(article)].isApproved=true;
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };
        $scope.create = function () {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "create.html",
                size: "lg",
                controller: CreateController
            });
            modalInstance.result.then(function () {
                $scope.getList();
            })
        };
        $scope.check = function (article) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "check.html",
                size: "lg",
                resolve: {
                    article: function () {
                        return article;
                    }
                },
                controller: CheckController
            });
            modalInstance.result.then(function (article1) {
                $scope.articles[$scope.articles.indexOf(article)] = article1;
            })
        };

        $scope.cancel = function (item) {
            var dialogDefaults = {
                size: "sm"
            };
            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定取消发布",
                headerText: "继续....?",
                bodyText: "您确定要取消发布吗？",
                callback: function () {
                    CmsService.cancelArticle({id: item.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "取消成功"}], null);
                            //$scope.articles[$scope.articles.indexOf(article)].isApproved=true;
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };

        //升级

        //撤销升级
    };
    var CreateController =["$scope", "$modalInstance", "dialogService", "$modal", "toolsService","FoundationService", "$location", "CmsService",
        function ($scope, $modalInstance, dialogService, $modal, toolsService,FoundationService, $location, CmsService) {
        $scope.article={};
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
                        $scope.article.coverId = data.id;
                        $scope.article.url = data.url;
                    }
                });
            };
        };

        $scope.create = function () {
            $scope.article.categoryId="ARTICLE";
            CmsService.createArticle($scope.article).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
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
    var CheckController = ["$scope", "$modalInstance", "dialogService", "$modal", "toolsService", "$location", "CmsService","FoundationService","article",function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService,FoundationService,article) {
        $scope.article={};
        CmsService.getArticle({id:article.id,isMobile:false}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.article=data.article;
            }
        });
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
        $scope.sure = function () {
            CmsService.updateArticle($scope.article).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "更新成功！"}],null);
                    $modalInstance.close($scope.article);
                    $modalInstance.dismiss('cancel');
                }
            });

        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    }];
    var ChangeOrderController =["$scope", "$modalInstance", "dialogService", "$modal", "toolsService", "$location", "CmsService","article", function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService,article) {
        $scope.article={};
        CmsService.getArticle({id:article.id}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.article=data.article;
            }
        });
        $scope.sure = function () {
            CmsService.changeOrder($scope.article).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "更新成功！"}],null);
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
    var CheckCommentpostController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService,article) {
        $scope.comments = [];
        $scope.commentPost = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0,
            threadId: article.id
        };
        $scope.getListComment = function () {
            PlatformService.findCommentPost($scope.commentPost).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.comments = data.result;
                    $scope.commentPost.totalCount=data.totalCount;
                }

            });
        };
        $scope.getListComment();
        $scope.delete = function (comment) {
            PlatformService.deleteCommentPost({id: comment.id}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.comments.splice($scope.comments.indexOf(comment), 1);
                    $scope.getListComment();
                }
            });
        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.close();
            $modalInstance.dismiss('cancel');
        };
    };

    angular.module("xn.showcal.cms", [])
        .controller("ArticleIndexController", ["$scope", "dialogService", "$modal", "toolsService", "$location", "CmsService", articleIndexController])
})
();