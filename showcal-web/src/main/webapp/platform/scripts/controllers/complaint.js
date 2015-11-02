(function () {
    "use strict";
    // 文章首页控制器
    var complaintIndexController = function ($scope, dialogService, $modal, toolsService, $location, ServiceService) {
        //显示不同的导航NAV的数值
        $scope.$emit('nav', 2);
        //每个导航对应的图标的高亮
        $scope.$emit('navShow', 4);
        $scope.complaints = [];
        $scope.vm = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0,
            isList:true
        };
        $scope.getList = function () {
            ServiceService.findComplatint($scope.vm).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.complaints = data.result;
                    $scope.vm.totalCount = data.totalCount;
                }
            });
        };
        $scope.getList();
        $scope.doFind = function () {
            $scope.getList();
        };
        $scope.show = function (id) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "check.html",
                size: "lg",
                resolve: {
                    id: function () {
                        return id;
                    }
                },
                controller: CheckController
            });
            modalInstance.result.then(function (article1) {
                $scope.articles[$scope.articles.indexOf(article)] = article1;
            })
        };
        $scope.doDelete = function (complaint) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定删除",
                headerText: "继续....?",
                bodyText: "您确定要删除此举报吗？",
                callback: function () {
                    ServiceService.deleteComplatint({id: complaint.sourceId}).success(function (data) {
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
        $scope.prohibit = function (complaint) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "prohibit.html",
                size: "lg",
                resolve: {
                    complaint: function () {
                        return complaint;
                    }
                },
                controller: ProhibitController
            });
            modalInstance.result.then(function (complaint1) {
                $scope.getList();
            })
        };
        $scope.clearProhibit = function (complaint) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定解禁",
                headerText: "继续....?",
                bodyText: "您确定要解禁吗？",
                callback: function () {
                    $scope.complaint=complaint;
                    $scope.complaint.clearProhibit=true;
                    ServiceService.updateComplatint( $scope.complaint).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors, null, null);
                        } else {
                            dialogService.tip([{"message": "解禁成功！"}],null);
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };
        $scope.clearSocked = function (complaint) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定解锁",
                headerText: "继续....?",
                bodyText: "您确定要解锁吗？",
                callback: function () {
                    $scope.complaint=complaint;
                    $scope.complaint.clearSocked=true;
                    ServiceService.updateComplatint( $scope.complaint).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors, null, null);
                        } else {
                            dialogService.tip([{"message": "解锁成功！"}],null);
                            $scope.getList();
                        }
                    });

                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);

        };
        $scope.socked = function (complaint) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定封锁",
                headerText: "继续....?",
                bodyText: "您确定要封锁吗？",
                callback: function () {
                    $scope.complaint=complaint;
                    $scope.complaint.socked=true;
                    ServiceService.updateComplatint( $scope.complaint).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors, null, null);
                        } else {
                            dialogService.tip([{"message": "封锁成功！"}],null);
                            $scope.getList();
                        }
                    });

                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);

        };

    };
    var ProhibitController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, ServiceService,complaint) {
        $scope.complaint=complaint;
        //弹出式日历触发函数
        $scope.openStart = function ($event) {
            $event.preventDefault();
            $event.stopPropagation();
            $scope.startDate = true;
        };
        $scope.sure = function () {
            $scope.complaint.prohibit=true;
            if ($scope.complaint.prohibitTime instanceof Date) {
                $scope.complaint.prohibitTime = $scope.complaint.prohibitTime.format("yyyy-MM-dd");
            }
            ServiceService.updateComplatint($scope.complaint).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "禁言成功！"}],null);
                    $modalInstance.close($scope.complaint);
                    $modalInstance.dismiss('cancel');
                }
            });

        };

        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    var CheckController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, CmsService,id) {
        $scope.article={};
        CmsService.getArticle({id:id}).success(function (data) {
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
    angular.module("xn.pl.complaint", [])
        .controller("ComplaintIndexController", ["$scope", "dialogService", "$modal", "toolsService", "$location", "ServiceService", complaintIndexController])
})
();