(function () {
    "use strict";
    // 文章首页控制器
    var articleManageIndexController = function ($scope, dialogService, $modal, toolsService, $location, CmsService,PlatformService) {
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
        //弹出式日历触发函数
        $scope.openStart = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.startDate = true;
        };
        //弹出式日历触发函数
        $scope.openEnd = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.endDate = true;
        };
        $scope.getList = function () {
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
                    for(var i=0;i<data.result.length;i++){
                        if(data.result[i].countComment==null){
                            data.result[i].countComment=0;
                        }
                        if(data.result[i].countLink==null){
                            data.result[i].countLink=0;
                        }
                        if(data.result[i].countRead==null){
                            data.result[i].countRead=0;
                        }
                        if(data.result[i].weight==null){
                            data.result[i].weight=0;
                        }
                        $scope.articles[i].weigthScores= (data.result[i].countComment*5+data.result[i].countLink*2+data.result[i].countRead)*data.result[i].weight;
                        $scope.articles[i].edit = true;
                    }
                    $scope.vm.totalCount = data.totalCount;
                }
            });
        };
        $scope.edit = function (index) {
            $scope.articles[index].edit = false;
        };
        $scope.getList();
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
            modalInstance.result.then(function (article) {
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
        $scope.orderlink=false;
        $scope.orderCollection=false;
        $scope.orderComment=false;
        $scope.order=function(name,desc){
            $scope.vm.orderSort=name;
            $scope.vm.orderRule=desc;
            if(name=='COUNT_LINK'){
                if(desc=='DESC'){
                    $scope.orderlink=false;
                }
                if(desc=='ASC'){
                    $scope.orderlink=true;
                }

            } if(name=='COUNT_COMMENT'){
                if(desc=='DESC'){
                    $scope.orderComment=false;
                }
                if(desc=='ASC'){
                    $scope.orderComment=true;
                }
            }
            if(name=='COUNT_CONNECTION'){
                if(desc=='DESC'){
                    $scope.orderCollection=false;
                }
                if(desc=='ASC'){
                    $scope.orderCollection=true;
                }
            }
            $scope.getList();
        };
        $scope.save = function (article, index) {
            CmsService.updateArticle(article).success(function (data) {
                if (null == data.errors || 0 < data.errors.length) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.articles[index].edit = true;
                    $scope.getList();
                }
            })
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
        };
    };
    var CheckController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService,article) {
        $scope.article={};
        CmsService.getArticle({id:article.id}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.article=data.article;
            }
        });

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
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
        $scope.doDelete = function (comment) {
            PlatformService.deleteCommentPost({id: comment.id}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.comments.splice($scope.comments.indexOf(comment), 1);
                }
            });
        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    angular.module("xn.pl.article", [])
        .controller("ArticleManageIndexController", ["$scope", "dialogService", "$modal", "toolsService", "$location", "CmsService","PlatformService", articleManageIndexController])
})();