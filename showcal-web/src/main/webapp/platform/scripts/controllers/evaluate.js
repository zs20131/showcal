/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.evaluate", []);
    app.controller("EvaluateIndexController", ["$scope", "$http", "ThermalControlService", "dialogService", "$modal",
        function ($scope, $http, ThermalControlService, dialogService, $modal) {
            $scope.$emit('navShow', 1);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                totalCount: 0
            };
            $scope.pagedResult = [];
            /**
             * 搜索用户列表
             */
            $scope.getList = function () {
                ThermalControlService.findEvaluate($scope.vm).success(function (data) {
                    if (data.errors && data.errors.length === 0) {
                        $scope.pagedResult = data.result;
                        $scope.vm.totalCount = data.totalCount;
                    } else {
                        var msg = "由于以下原因，未能取得数据\n";
                        for (var i = 0; i < data.errors.length; i++) {
                            msg += (i + 1) + "." + data.errors[i].message + "\n";
                        }
                        dialogService.tip(msg);
                    }
                });
            };
            $scope.getList();

            //编辑
            $scope.edit = function (evaluate) {
                //弹出窗口
                var modalInstance = $modal.open({
                    templateUrl: "evaluateEidt.html",
                    controller: SettingEidt,
                    size: "",
                    resolve: {
                        evaluate: function () {
                            return evaluate
                        }
                    }
                });
                modalInstance.result.then(function (data) {
                    $scope.getList();
                });
            };


            var SettingEidt = ["$scope", "$modalInstance", "evaluate", "ThermalControlService", "dialogService",
                function ($scope, $modalInstance, evaluate, ThermalControlService, dialogService) {
                    $scope.$emit('navShow', 2);
                    $scope.evaluate = evaluate;
                    console.log( $scope.evaluate);
                    // $scope.foodCategory.title = "新增知识库";
                    //$scope.evaluate = [
                    //    {key: "建议", value: "1"},
                    //    {key: "评价", value: "0"}
                    //];
                    $scope.types = [
                        {key: "热量", value: "1"},
                        {key: "蛋白质", value: "2"},
                        {key: "脂肪", value: "3"},
                        {key: "碳水", value: "4"}
                    ];
                    $scope.doSave = function () {
                        //编辑
                        ThermalControlService.updateEvaluate($scope.evaluate).success(function (data) {
                            if (data.errors === null || data.errors.length > 0) {
                                dialogService.tip(data.errors);
                            } else {
                                dialogService.tip([{"message": "保存成功！"}]);
                                //关闭
                                $modalInstance.close();
                                $modalInstance.dismiss('cancel');
                                //清空数据
                                $scope.evaluate = {};
                            }
                        });
                    };

                    $scope.clean = function () {
                        $modalInstance.close();
                        $modalInstance.dismiss('cancel');
                    };
                }
            ];

        }
    ]);
})();