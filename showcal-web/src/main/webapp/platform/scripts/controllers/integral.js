/**
 * Created by xiniu on 9/22 0022.
 */
(function () {
    "use strict";
    var app = angular.module("sc.pl.integral", []);
    app.controller("IntegralIndexController", ["$scope", "$http", "PlatformService", "dialogService",
        function ($scope, $http, PlatformService, dialogService) {
            $scope.$emit('navShow', 1);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                totalCount:0
            };
            $scope.integrals = [
                {key: "增加", value: 1},
                {key: "消费", value: 0}
            ];
            $scope.rules = [];
            $scope.getList=function(){
            PlatformService.findIntegralrule($scope.vm).success(function (data) {
                if (data.errors && data.errors.length === 0) {
                    $scope.rules = data.result;
                    $scope.vm.totalCount = data.totalCount;
                    for (var i = 0; i < data.result.length; i++) {
                        $scope.rules[i].edit = true;
                    }
                } else {
                    var msg = "由于以下原因，未能取得数据\n";
                    for (var i = 0; i < data.errors.length; i++) {
                        msg += (i + 1) + "." + data.errors[i].message + "\n";
                    }
                    dialogService.tip(msg);
                }
            });
            }
            $scope.getList();
            $scope.edit = function (index) {
                $scope.rules[index].edit = false;
            };
            $scope.save = function (rule, index) {
                $scope.validateForm.$errors = [];
                $scope.rules[index].showColor = "";
                if (rule.value == null || rule.value == "") {
                    $scope.validateForm.$errors.push("第" + (index + 1) + "条积分值不能为空");
                    $scope.rules[index].showColor = "border-color:red";
                    return false;
                }
                PlatformService.updateIntegralrule(rule).success(function (data) {
                    if (null == data.errors || 0 < data.errors.length) {
                        dialogService.tip(data.errors);
                    } else {
                        $scope.getList();
                    }
                })
            };
        }
    ]);
})();