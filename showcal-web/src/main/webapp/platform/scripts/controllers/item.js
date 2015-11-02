(function () {
    "use strict";
    // 商品首页控制器
    var itemIndexController = function ($scope, dialogService, $modal, toolsService, $location, MdService) {
        //显示不同的导航NAV的数值
        $scope.$emit('nav', 5);

        $scope.items = [];
        $scope.categories = [];
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
        $scope.categories = [];
        $scope.cate = {
            pageNumber: 1,
            pageSize: 0,
            totalCount: 0
        };
        MdService.findCategory($scope.cate).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.categories = data.result;

            }
        });
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
            MdService.findItem($scope.vm).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    $scope.items = data.result;
                    $scope.vm.totalCount = data.totalCount;
                }
            });
        };
        $scope.getList();
        $scope.doFind = function () {
            $scope.getList();
        };
        $scope.doDelete = function (item) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定删除",
                headerText: "继续....?",
                bodyText: "您确定要删除此商品吗？",
                callback: function () {
                    MdService.deleteItem({id: item.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "删除成功"}], null);
                            $scope.items.splice($scope.items.indexOf(item), 1);
                            $scope.vm.totalCount--;
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
        $scope.changeOrder = function (item) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "changeOrder.html",
                size: "sm",
                resolve: {
                    item: function () {
                        return item;
                    }
                },
                controller: ChangeOrderController
            });
            modalInstance.result.then(function () {
                $scope.getList();
            })
        };
        $scope.check = function (item) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "check.html",
                size: "lg",
                resolve: {
                    item: function () {
                        return item;
                    }
                },
                controller: CheckController
            });
            modalInstance.result.then(function () {
               $scope.getList();
            })
        };
        $scope.approve = function (item) {
            var dialogDefaults = {
                size: "sm"
            };
            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定发布",
                headerText: "继续....?",
                bodyText: "您确定要发布吗？",
                callback: function () {
                    MdService.approveItem({id: item.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "发布成功"}], null);
                            ////$scope.articles[$scope.articles.indexOf(article)].isApproved=true;
                            //window.location.reload();
                            $scope.getList();
                        }
                    });
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
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
                    MdService.cancelItem({id: item.id}).success(function (data) {
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


        $scope.createComment = function (item) {
            //弹出窗口
            var modalInstance = $modal.open({
                templateUrl: "createComment.html",
                size: "lg",
                resolve: {
                    id: function () {
                        return item.id;
                    }
                },
                controller: CreateCommentPostController
            });
            modalInstance.result.then(function () {

            })
        };
    };
    var CreateController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, MdService, FoundationService) {
        $scope.attachmentRequest = {};
        $scope.newId = {};
        $scope.attachment = {
            businessType: "EMPLOYEE",
            businessCategory: "COMMON",
            list: []
        };
        /* 用于存放附件的ID */
        $scope.attachmentRequest = {ids: []};
        for (var i = 0; i < $scope.attachment.list.length; i++) {
            $scope.attachmentRequest.ids.push($scope.attachment.list[i].id);
        }
        FoundationService.apiFoundationIdGet().success(function (data) {
            if (null == data.errors || 0 < data.errors.length)
                dialogService.tip(data.errors);
            else {
                $scope.newId = data.id;
                $scope.attachment.businessId=$scope.newId;
            }
        });
        $scope.categories = [];
        $scope.cate = {
            pageNumber: 1,
            pageSize: 0,
            totalCount: 0
        };
        MdService.findCategory($scope.cate).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.categories = data.result;
            }
        });
        $scope.item = {};
        $scope.itemDetail = {};
        $scope.itemEcommerce = {};
        $scope.itemPics = [];
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
                        $scope.item.pictureId = data.id;
                        $scope.item.avatarurl = data.url;
                    }
                });
            };
        };
        $scope.create = function () {
            for (var i = 0; i < $(".upload-img").length; i++) {
                $scope.itemPics.push({pictureId: $(".upload-img").eq(i).attr("name")});
            }
            $scope.item.id = $scope.newId;
            $scope.item.itemDetailCreateRequest = $scope.itemDetail;
            $scope.item.itemEcommerceCreateRequest = $scope.itemEcommerce;
            $scope.item.itemPictureCreateRequest = $scope.itemPics;
            MdService.createItem($scope.item).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "创建成功！"}], null);
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
    var CheckController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, MdService, item,FoundationService) {
        $scope.attachmentRequest = {};
        $scope.newId = {};
        $scope.attachment = {
            businessType: "EMPLOYEE",
            businessCategory: "COMMON",
            businessId: item.id,
            list: []
        };
        /* 用于存放附件的ID */
        $scope.attachmentRequest = {ids: []};
        for (var i = 0; i < $scope.attachment.list.length; i++) {
            $scope.attachmentRequest.ids.push($scope.attachment.list[i].id);
        }
        $scope.item = {};
        $scope.categories = [];
        $scope.cate = {
            pageNumber: 1,
            pageSize: 0,
            totalCount: 0
        };

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
                        $scope.item.pictureId = data.id;
                        $scope.item.avatarurl = data.url;
                    }
                });
            };
        };
        MdService.findCategory($scope.cate).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.categories = data.result;

            }
        });
        MdService.getItem({id: item.id}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.item = data.item;
            }
        });
        $scope.update = function () {
            $scope.item.update = true;
            MdService.updateItem($scope.item).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "更新成功！"}], null);
                    $modalInstance.close($scope.item);
                    $modalInstance.dismiss('cancel');
                }
            });

        };
        $scope.submitApprove = function (item) {
            MdService.approveItem({id: item.id}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    dialogService.tip([{"message": "发布成功"}], null);
                    $modalInstance.close($scope.item);
                    $modalInstance.dismiss('cancel');
                }
            });

        };
        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
    var ChangeOrderController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, MdService, item) {
        $scope.item = {};
        MdService.getItem({id: item.id}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.item = data.item;
            }
        });
        $scope.sure = function () {
            MdService.changeSort($scope.item).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors, null, null);
                } else {
                    dialogService.tip([{"message": "更新成功！"}], null);
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
    var categoryController = function ($scope, dialogService, $modal, toolsService, $location, MdService) {
        //每个导航对应的图标的高亮
        $scope.$emit('navShow', 5);
        $scope.categories = [];
        $scope.vm = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
        };
        $scope.maxPageSize = 5;
        $scope.getAll = function () {
            MdService.findCategory($scope.vm).success(function (data) {
                if (null == data.errors || 0 < data.errors.length) {
                    dialogService.tip(data.errors);
                } else {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors, null, null);
                    } else {
                        console.log(data);
                        $scope.categories = data.result;
                        $scope.vm.totalCount = data.totalCount;
                        for (var i = 0; i < data.result.length; i++) {
                            $scope.categories[i].edit = true;
                            $scope.categories[i].memoName = true
                        }

                    }
                }
            });
        };
        $scope.getAll();
        for (var i = 0; i < $scope.categories.length; i++) {
            $scope.showNumber[i] = true;
        }
        $scope.doDelete = function (category) {
            var dialogDefaults = {
                size: "sm"
            };

            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定删除",
                headerText: "继续....?",
                bodyText: "您确定要删除此目录吗？",
                callback: function () {
                    MdService.deleteCategory({id: category.id}).success(function (data) {
                        if (data.errors === null || data.errors.length > 0) {
                            dialogService.tip(data.errors);
                        } else {
                            dialogService.tip([{"message": "删除成功"}], null);
                            $scope.categories.splice($scope.categories.indexOf(category), 1);
                            $scope.vm.totalCount--;
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
                controller: CreateCategoryController
            });
            modalInstance.result.then(function () {
                $scope.getAll();
            })
        };
        $scope.edit = function (index) {
            $scope.categories[index].edit = false;
        };
        $scope.save = function (category, index) {
            MdService.updateCategory(category).success(function (data) {
                if (null == data.errors || 0 < data.errors.length) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.categories[index].edit = true;
                }
            })
        };
    };
    var CreateCategoryController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, MdService) {
        $scope.clazzs = [];
        $scope.create = function () {
            MdService.createCategory({clazzCreateRequests: $scope.clazzs}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    dialogService.tip([{"message": "保存成功！"}]);
                    $modalInstance.close();
                    $modalInstance.dismiss('cancel');
                }
            });
        };
        //添加行
        $scope.addLine = function (index) {
            var clazz = {};
            $scope.clazzs.splice(index + 1, 0, clazz);
        };
        $scope.addLine(0);
        //删除行
        $scope.removeLine = function (index) {
            if (1 == $scope.clazzs.length) {
                $scope.clazzs.splice(index, 1);
                dialogService.tip([{"message": "列表不能为空！新加一条空数据"}], null, 1000);
                //新加一条空数据
                $scope.addLine(0);
            } else {
                $scope.clazzs.splice(index, 1);
            }
        };


        // 关闭窗口
        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

    var CreateCommentPostController = function ($scope, $modalInstance, dialogService, $modal, toolsService, $location, PlatformService, id) {
        $scope.commentPosts = [];

        $scope.comment = {
            pageNumber: 1,
            pageSize: 0,
            threadId: id,
            totalCount: 0
        };
        $scope.usertypes = [];
        $scope.usertypes.push("SHOWCAL");
        //查询所有瘦咖
        $scope.users = [];
        $scope.itemInfoOptions = {
            pageSize: 10,
            pageNumber: 1,
            totalCount: 0,
            usertypes: $scope.usertypes,
            methodName: "findUser"
        };

        $scope.findUser = function () {

            PlatformService.findSysUser($scope.itemInfoOptions).success(function (data) {
                if (null == data.errors || 0 < data.errors.length) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.users.totalCount = data.totalCount;
                    $scope.users = data.result;
                }
            });
        };

        $scope.selectItemInfo = function (user, sysUser) {
            user.name = true;
            user.userId = sysUser.id;
            user.userName = sysUser.nickName;
        };
        //编辑行加上高亮
        $scope.selectMemo = function (user) {
            if (user.name) {
                user.name = false;
            }
            user.trCl = "editing-memo";
        };

        PlatformService.findCommentPost($scope.comment).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors, null, null);
            } else {
                $scope.commentPosts = data.result;
                $scope.comment.totalCount = data.totalCount;
                if (data.totalCount == 0) {
                    $scope.addLine(0);
                }
            }
        });
        //添加行
        $scope.addLine = function (index) {
            var commentPost = {threadId: id};
            $scope.commentPosts.splice(index + 1, 0, commentPost);
        };
        $scope.addLine(0);
        //删除行
        $scope.removeLine = function (index) {
            if (1 == $scope.commentPosts.length) {
                $scope.commentPosts.splice(index, 1);
                dialogService.tip([{"message": "列表不能为空！新加一条空数据"}], null, 1000);
                //新加一条空数据
                $scope.addLine(0);
            } else {
                $scope.commentPosts.splice(index, 1);
            }
        };
        $scope.create = function () {
            PlatformService.createListCommentPost({commentPostCreateRequestList: $scope.commentPosts}).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    dialogService.tip([{"message": "保存成功！"}]);
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

    angular.module("xn.pl.md", [])
        .controller("ItemIndexController", ["$scope", "dialogService", "$modal", "toolsService", "$location", "MdService", itemIndexController])
        .controller("CategoryController", ["$scope", "dialogService", "$modal", "toolsService", "$location", "MdService", categoryController])

})
();