/**
 * Created by Administrator on 2015/9/22.
 */
(function () {
    "use strict";
    var app= angular.module("sc.pl.disease",[]);
    //index
    app.controller("DiseaseIndexController",["$scope", "$http","$modal","PlatformService","dialogService",
        function ($scope, $http,$modal,PlatformService,dialogService) {
            $scope.$emit('navShow',1);
            //绑定页面的树
            $scope.trees=[];

            //整个树
            $scope.allTrees=[];

            $scope.collapsed=false;

            var parameter = {questiontag:''};
            $scope.search = function(){
                PlatformService.getSettingDiseaseAllList(parameter).success(function (data) {
                    if (data.errors === null || data.errors.length > 0) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.diseasetags = data.result;
                        $scope.diseasetags.totalCount = data.totalCount;
                    }
                });
            }
            $scope.search();
            /**
             * 递归查找下一级
             * @param pid  父级id
             * @param keywordList   查找的数组
             * @param level     层级数
             */
            var getChild = function(pid,diseaseList,level){
                level ++;
                angular.forEach(diseaseList,function(disease){
                    if(disease.parentId === pid){
                        disease.level = level;
                        disease.visable=false;
                        $scope.allTrees.push(disease);
                        getChild(disease.id,diseaseList,level);
                    }
                });
            };
            var getParent = function(pId,diseaseList){
                angular.forEach($scope.allTrees,function(disease){
                    if(disease.id === pId){
                        diseaseList.push(disease);
                        getParent(disease.parentId,diseaseList);
                    }
                });
            };

            var countChild = function(pid,diseaseList){
                angular.forEach($scope.allTrees,function(disease){
                    if(disease.parentId === pid){
                        diseaseList.push(disease);
                        countChild(disease.id,diseaseList);
                    }
                });
            };
            var parameter = {disease:''};
            PlatformService.getSettingDiseaseAllList(parameter).success(function(data){

                if(data.errors === null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }else{
                    //组建新的树
                    if(data.result.length > 0){
                        var parentIndex=0;
                        angular.forEach(data.result,function(organization){
                            if(organization.parentId ==null){
                                if(parentIndex%2==0){
                                    organization.color="color-blue";
                                }else{
                                    organization.color="color-yellow";
                                }
                                parentIndex++;
                                organization.level = 0;
                                organization.visable=true;
                                $scope.allTrees.push(organization);
                                getChild(organization.id,data.result,0);
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
                angular.forEach(tree,function(organization) {
                    if(organization.parentId === parent.id){
                        organization.visable = (!parent.collapsed && parent.visable);
                        $scope.collapseTree(tree,organization);
                    }
                });
            };
            $scope.toggle = function(i) {
                $scope.trees[i].collapsed=! $scope.trees[i].collapsed;
                $scope.collapseTree($scope.trees,$scope.trees[i]);

            };
            //停用
            $scope.stop = function(tree) {
                $scope.disease={};
                //复制
                angular.extend($scope.disease ,tree);
                $scope.disease.isActive = false;
                //新建
                PlatformService.updateSettingDisease($scope.disease).success(function(data){
                    if(data.errors === null ||
                        data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        //返回id
                        $scope.disease.id = data.id;
                        dialogService.tip([{"message": "停用成功！"}]);
                        //关闭
                        //$modalInstance.close($scope.disease);
                        //清空数据
                        $scope.disease={};
                         window.location.reload();
                    }
                }) ;
            };

            //启用
            $scope.start = function(tree) {
                $scope.disease={};
                //复制
                angular.extend($scope.disease ,tree);
                $scope.disease.isActive = true;
                //新建
                PlatformService.updateSettingDisease($scope.disease).success(function(data){
                    if(data.errors === null ||
                        data.errors.length > 0){
                        dialogService.tip(data.errors);
                    }else{
                        //返回id
                        $scope.disease.id = data.id;
                        dialogService.tip([{"message": "启用成功！"}]);
                        //关闭
                       // $modalInstance.close($scope.disease);
                        //清空数据
                        $scope.disease={};
                        window.location.reload();
                    }
                }) ;
            };


            //删除树
            $scope.delete = function(tree) {
                var dialogDefaults = {
                    size:"sm"
                };
                var dialogOptions = {
                    closeButtonText: "取消",
                    actionButtonText: "确定删除",
                    headerText: "温馨提示",
                    bodyText: "您确定要删除该情况吗？",
                    type:"delete",
                    callback: function () {
                        PlatformService.deleteSettingDisease({id:tree.id}).success(function(data){
                            if(data.errors === null || data.errors.length > 0){
                                dialogService.tip(data.errors);
                            }else{
                                /**
                                 * 获取树的值在数组中的位置
                                 * @param data 当前数据
                                 * @returns {number} 返回位置
                                 */
                                var location = function(data,dataList){
                                    for(var i=0; i < dataList.length; i++){
                                        if(dataList[i].id===data.id){
                                            return  i;
                                        }
                                    }
                                };

                                /**
                                 * 查找兄弟的个数
                                 * @param data       当前数据
                                 * @param dataList    查询的数组
                                 * @returns {number}  返回兄弟和自己的个数
                                 */

                                var brothers = function(data,dataList){
                                    var number = 0;
                                    for(var i=0; i < dataList.length; i++){
                                        if(dataList[i].parentId===data.parentId){
                                            number++;
                                        }
                                    }
                                    return number;
                                };

                                /**
                                 * 查找父级别位置
                                 * @param data
                                 * @param dataList
                                 * @returns {number}
                                 */

                                var locationParent = function(data,dataList){
                                    for(var i=0; i < dataList.length; i++){
                                        if(dataList[i].id ===data.parentId){
                                            return i;
                                        }
                                    }
                                };
                                if( brothers(tree,$scope.trees)===1){
                                    if(locationParent(tree,$scope.trees)!=null){
                                        $scope.trees[locationParent(tree,$scope.trees)].childState = false;
                                    }
                                }

                                if( brothers(tree,$scope.allTrees)===1){
                                    if(locationParent(tree,$scope.allTrees)!=null){
                                        $scope.allTrees[locationParent(tree,$scope.allTrees)].childState = false;
                                    }
                                }

                                $scope.trees.splice(location(tree,$scope.trees),1);
                                $scope.allTrees.splice(location(tree,$scope.allTrees),1);

                                var parentIndex=0;
                                angular.forEach($scope.trees,function(tree){
                                    if(tree.level == 0){
                                        if(parentIndex%2==0){
                                            tree.color="color-blue";
                                        }else{
                                            tree.color="color-yellow";
                                        }
                                        parentIndex++;
                                    }
                                });
                                dialogService.tip([{"message":"删除成功！" }]);
                            }
                        });
                    }
                };
                dialogService.confirm(dialogDefaults, dialogOptions);

            };



            //树编辑
            $scope.edit = function (tree) {
                $scope.disease={};
                //复制
                angular.extend($scope.disease ,tree);

                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "treeEidt.html",
                    controller:TreeEidt,
                    size:"",
                    resolve: {
                        items: function () {
                            return $scope.disease;
                        }
                    }
                });
                modalInstance.result.then(function (data){

                    window.location.reload();

                    /**
                     * 获取树的值在数组中的位置
                     * @param data 当前数据
                     * @returns {number} 返回位置
                     */
                    var location = function(data,dataList){
                        for(var i=0; i < dataList.length; i++){
                            if($scope.trees[i].id==data.id){
                                return i;
                            }
                        }
                    };

                    //数据替换
                    $scope.trees.splice(location(data,$scope.trees),1,data);
                    $scope.allTrees.splice(location(data,$scope.allTrees),1,data);
                });
            };

            //新建树节点
            $scope.addTree = function (tree) {

                $scope.disease={};
                if(tree != null){
                    $scope.disease = {
                        parentdisease :disease.name,
                        parentId :disease.id
                    };
                }else{
                    $scope.disease = {
                        parentdisease  :"",
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
                            return $scope.disease;
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    console.log(data);
                    //获取父级位置
                    var location = function(data,dataList){
                        for(var i=0; i < dataList.length; i++){
                            if(dataList[i].id==data.parentId){
                                return  i;
                            }
                        }
                    };
                    /**
                     * 获取 下一个父级位置
                     * @param data 当前数据
                     * @returns {number} 返回位置
                     */
                    /*  var locationNext = function(data,dataList){
                     var index = 0;
                     for(var i=0; i < dataList.length; i++){
                     index ++;
                     //data.parentId
                     if(dataList[i].id==data.parentId){
                     break;
                     }
                     }

                     for(var k = index ; k < dataList.length; k++){
                     //data.parentId
                     if(dataList[k].level===dataList[location(data,dataList)].level){
                     if(dataList[k].parentId===dataList[location(data,dataList)].parentId){
                     return k;
                     }
                     }
                     }
                     return dataList.length;
                     };*/
                    var locationEndChild=function(index,treeList){
                        for(var i=treeList.length-1;i>=0; i--){
                            if(treeList[index].id==treeList[i].parentId){
                                return locationEndChild(i,treeList);
                            }
                        }
                        return index;
                    };

                    if(data.parentId==""){
                        //增加顶级树
                        data.childState = false;
                        data.collapsed = false;
                        data.visable = true;
                        data.level=0;
                        $scope.trees.push(data);
                        $scope.allTrees.push(data);

                        var parentIndex=0;
                        angular.forEach($scope.trees,function(tree){
                            if(tree.level == 0){
                                if(parentIndex%2==0){
                                    tree.color="color-blue";
                                }else{
                                    tree.color="color-yellow";
                                }
                                parentIndex++;
                            }
                        });
                    }else{

                        //增加子级树
                        $scope.trees[location(data,$scope.trees)].childState = true;
                        $scope.trees[location(data,$scope.trees)].collapsed = false;

                        for(var i=0;i<$scope.trees.length; i++){
                            if($scope.trees[i].parentId===data.parentId){
                                $scope.trees[i].visable=true;
                            }
                        }

                        data.childState = false;
                        data.collapsed = false;
                        data.visable = true;
                        data.level =  $scope.trees[location(data,$scope.trees)].level+1;

                        $scope.trees.splice(locationEndChild(location(data,$scope.trees),$scope.trees)+1,0,data);
                        $scope.allTrees.splice(locationEndChild(location(data,$scope.allTrees),$scope.allTrees)+1,0,data);
                    }
                });
            };

            //树搜索
            $scope.treeSearch = function () {
                $scope.organizationSearch = [];
                if($scope.disease != null){
                    $scope.SearchName($scope.allTrees,$scope.disease);
                } else{
                    angular.extend($scope.organizationSearch,$scope.allTrees);
                }
                $scope.trees = $scope.organizationSearch;
            };
            $scope.SearchName = function (data,searchText) {
                console.log(data);
                var searchLength = searchText.length;
                var jsonArray = data;
                for(var i=0 ;i<jsonArray.length ; i++ ){
                    var jsonObject = jsonArray[i];
                    var name = jsonObject.name;
                    var nameLength = name.length;
                    var flag = false;
                    for(var temp=0;temp< (nameLength-searchLength+1);temp++){
                        if(searchText == name.substring(temp,temp+searchLength)){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        var j = 0 ;
                        if(jsonObject.parentId != null){
                            var parentList = [];
                            getParent(jsonObject.parentId,parentList)
                            for(j = parentList.length-1; j >= 0 ;j--){
                                parentList[j].collapsed = false;
                                parentList[j].visable = true;
                                $scope.organizationSearch.push(parentList[j]);
                            }
                        }
                        var tempObj = {};
                        angular.extend(tempObj,jsonObject);
                        var childList = [];
                        countChild(jsonObject.id,childList);
                        if(childList.length == 0){
                            tempObj.collapsed = false;
                            tempObj.visable = true;
                            $scope.organizationSearch.push(tempObj);
                        } else {
                            tempObj.collapsed = true;
                            tempObj.visable = true;
                            $scope.organizationSearch.push(tempObj);
                            for(j = 0; j < childList.length ;j++){
                                $scope.organizationSearch.push(childList[j]);
                            }
                            i =  i + childList.length;
                        }
                    }
                }
            };



            $scope.clean = function(){
                $scope.organization = null;
            };
        }]);
    /**
     * 导入组织时显示错误的控制器
     * @type {*[]}
     */
    var ErrorController =["$scope","$modalInstance","items",
        function ($scope, $modalInstance,items) {
            $scope.errors=items.errors;
            $scope.download=function(){
                $scope.url=items.url;
                window.open($scope.url,"_self");
                $modalInstance.dismiss('cancel');
            };
            $scope.cancel = function () {
                $modalInstance.dismiss('cancel');
            };
        }];



    var TreeEidt = ["$scope","$modalInstance","items","PlatformService","dialogService",
        function ($scope, $modalInstance, items,PlatformService,dialogService) {
            $scope.$emit('navShow',3);
            $scope.disease = items;
            if($scope.disease.id == null){
                if($scope.disease.parentId == ""){
                    $scope.disease.title = "增加特殊情况";
                }else{
                    $scope.disease.title =$scope.disease.parentdisease +"新增子组织";
                }

            } else {
                $scope.disease.title = "编辑特殊情况";
                /* PlatformService.getSettingDiseaseAllList().success(function(data){
                 if(data.errors === null || data.errors.length > 0){
                 dialogService.tip(data.errors);
                 }else{
                 $scope.organisationList = data.result
                 for(var i=0;i<$scope.organisationList.length;i++){
                 if($scope.organisationList[i].id == $scope.disease.id){
                 $scope.organisationList.splice(i,1);
                 break;
                 }
                 }
                 }
                 });*/
            }

            //数据加载
            $scope.getOwner=function(val){
                var searchParmeter = {
                    isActive : true,
                    disease : val,
                    pageSize : 10,
                    pageNumber : 1
                };
                //sensor: false
                PlatformService.getSettingDiseaseAllList(searchParmeter).then(function(res){

                    var owners = [];
                    console.log(res.data);
                    angular.forEach(res.data.result, function(item){
                        owners.push(item);
                    });
                    return owners;

                });
            };

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
                console.log($scope.disease);
                if($scope.disease.id == null){
                    //新建
                    PlatformService.createSettingDisease($scope.disease).success(function(data){

                        if(data.errors === null ||
                            data.errors.length > 0){
                            dialogService.tip(data.errors);
                        }else{
                            //返回id
                            $scope.disease.id = data.id;
                            dialogService.tip([{"message": "保存成功！"}]);
                            //关闭
                            $modalInstance.close($scope.disease);
                            //清空数据
                            $scope.disease={};
                            window.location.reload();
                        }
                    }) ;
                } else {
                    //编辑
                    PlatformService.updateSettingDisease($scope.disease).success(function(data){

                        if(data.errors === null || data.errors.length > 0){
                            dialogService.tip(data.errors);
                        }else{
                            dialogService.tip([{"message": "保存成功！"}]);
                            //关闭
                            $modalInstance.close($scope.disease);
                            //清空数据
                            $scope.disease={};
                            window.location.reload();
                        }
                    }) ;
                }

            };




            $scope.clean = function () {
                $scope.disease = {};
                $modalInstance.dismiss('cancel');
            };

            $scope.closeAlert = function (index,form) {
                form.splice(index,1);
            };
        }];

})();