(function () {
    "use strict";

    var app= angular.module("sc.pl.keyword", []);


    app.controller("KeyWordIndexController",["$scope", "$http","$modal","PlatformService","dialogService",
        function ($scope, $http,$modal,PlatformService,dialogService) {
            $scope.$emit('navShow',1);
            //绑定页面的树
            $scope.trees=[];
            //整个树
            $scope.allTrees=[];
            $scope.collapsed=false;
            /**
             * 递归查找下一级
             * @param pid  父级id
             * @param orgList   查找的数组
             * @param level     层级数
             */
            var getChild = function(pid,keywordList,level){
                level ++;
                angular.forEach(keywordList,function(keyword){
                    if(keyword.parentId === pid){
                        keyword.level = level;
                        keyword.visable=false;
                        $scope.allTrees.push(keyword);
                        getChild(keyword.id,keywordList,level);
                    }
                });
            };
            var getParent = function(pId,keywordList){
                angular.forEach($scope.allTrees,function(keyword){
                    if(keyword.id === pId){
                        keywordList.push(keyword);
                        getParent(keyword.parentId,orgList);
                    }
                });
            };

            var countChild = function(pid,keywordList){
                angular.forEach($scope.allTrees,function(keyword){
                    if(keyword.parentId === pid){
                        keywordList.push(keyword);
                        countChild(org.id,keywordList);
                    }
                });
            };
            $scope.vm = {};
            PlatformService.getSettingKeywordAllList($scope.vm).success(function(data){

                if(data.errors === null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }else{
                    //组建新的树
                    if(data.result.length > 0){
                        var parentIndex=0;
                        angular.forEach(data.result,function(keyword){
                            if(keyword.parentId ==null){
                                if(parentIndex%2==0){
                                    keyword.color="color-blue";
                                }else{
                                    keyword.color="color-yellow";
                                }
                                parentIndex++;
                                keyword.level = 0;
                                keyword.visable=true;
                                $scope.allTrees.push(keyword);
                                getChild(keyword.id,data.result,0);
                            }
                        });

                        //新建状态及是否有子栏目
                        for( var i=0; i< $scope.allTrees.length-1;i++){
                            if($scope.allTrees[i].id == $scope.allTrees[i+1].parentId){
                                $scope.allTrees[i].childState=true;
                                $scope.allTrees[i].collapsed=true;
                            }else{
                                $scope.allTrees[i].childState=false;
                                $scope.allTrees[i].collapsed=false;
                            }
                        }
                        $scope.allTrees[$scope.allTrees.length-1].childState=false;
                        angular.extend($scope.trees,$scope.allTrees);
                    }
                }
            });

            $scope.collapseTree = function(tree,parent){
                angular.forEach(tree,function(keyword) {
                    if(keyword.parentId === parent.id){
                        keyword.visable = (!parent.collapsed && parent.visable);
                        $scope.collapseTree(tree,keyword);
                    }
                });
            };
            $scope.toggle = function(i) {
                $scope.trees[i].collapsed=! $scope.trees[i].collapsed;
                $scope.collapseTree($scope.trees,$scope.trees[i]);

            };

            //删除树
            $scope.delete = function(tree) {

                if(tree.childState){
                    dialogService.tip([{"message": "请先删除子关键字！"}]);
                    return;
                }

                var dialogDefaults = {
                    size:"sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除关键字吗？",
                    type:"delete",
                    callback: function () {
                        PlatformService.deleteSettingKeyword({id:tree.id}).success(function(data){
                            if(data.errors === null || data.errors.length > 0){
                                dialogService.tip(data.errors);
                            }else{
                                dialogService.tip([{"message":"删除成功！" }]);
                                window.location.reload();
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);

            };



            //树编辑
            $scope.edit = function (tree) {
                $scope.keyword={};
                //复制
                angular.extend($scope.keyword ,tree);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "treeEidt.html",
                    controller:TreeEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.keyword;
                        }
                    }
                });
                modalInstance.result.then(function (data){
                    window.location.reload();

                });
            };

            //新建子关键字
            $scope.addTree = function (tree) {

                $scope.keyword={};
                if(tree != null){
                    $scope.keyword = {
                        parentKeyword  :tree.keyword,
                        parentId :tree.id
                    };
                }else{
                    $scope.keyword = {
                        parentKeyword  :"",
                        parentId :""
                    };
                }
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "treeEidt.html",
                    controller:TreeEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.keyword;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    window.location.reload();
                });
            };
            $scope.clean = function(){
                $scope.organization = null;
            };
        }]);



    var TreeEidt = ["$scope","$modalInstance","items","PlatformService","dialogService",
        function ($scope, $modalInstance, items,PlatformService,dialogService) {
            $scope.$emit('navShow',1);
            $scope.keyword = items;

            if($scope.keyword.id == null){
                if(!$scope.keyword.parentId){
                    $scope.keyword.title = "增加关键字";
                }else{
                    $scope.keyword.title = $scope.keyword.parentKeyword +"新增二级关键字";
                }

            } else {
                $scope.keyword.title = "编辑关键字";
            }

            //移动标记
            var isMove=false;
            //鼠标位置
            var x,y;
            $scope.mousedown=function(e){
                isMove=true;
                var dialog=$(".modal-dialog");
                if(dialog.css("top")=="auto"){
                    x=e.pageX;
                    y=e.pageY;
                }else{
                    x=e.pageX-parseInt(dialog.css("left"));
                    y=e.pageY-parseInt(dialog.css("top"));
                }
            };
            $scope.mousemove=function(e){
                if(isMove){
                    var left=e.pageX-x;
                    var top=e.pageY-y;
                    $(".modal-dialog").css({top:top,left:left});
                }
            };
            $scope.mouseup=function(){
                isMove=false;
            };

            $scope.doSave = function() {
                console.log($scope.keyword);
                //数据提交
                    if($scope.keyword.id == null){
                        //新建
                        PlatformService.createSettingKeyword($scope.keyword).success(function(data){
                            $scope.validateForm.$errors = [];
                            if(data.errors === null || data.errors.length > 0){
                                for(var i=0;i<data.errors.length;i++){
                                    $scope.validateForm.$errors.push(data.errors[i].message);
                                }
                            }else{
                                //返回id
                                dialogService.tip([{"message": "保存成功！"}]);

                                //关闭
                                $modalInstance.close($scope.keyword);

                                //清空数据
                                $scope.keyword={};
                                location.reload();
                            }
                        }) ;
                    } else {
                        //编辑
                        PlatformService.updateSettingKeyword($scope.keyword).success(function(data){
                            $scope.validateForm.$errors = [];
                            if(data.errors === null || data.errors.length > 0){
                                for(var i=0;i<data.errors.length;i++){
                                    $scope.validateForm.$errors.push(data.errors[i].message);
                                }
                            }else{
                                dialogService.tip([{"message": "保存成功！"}]);
                                //关闭
                                $modalInstance.close($scope.org);
                                //清空数据
                                $scope.keyword={};
                                location.reload();
                            }
                        }) ;
                    }
            };



            $scope.clean = function () {
                $scope.keyword = {};
                $modalInstance.dismiss('cancel');
            };

            $scope.closeAlert = function (index,form) {
                form.splice(index,1);
            };
        }];

})();