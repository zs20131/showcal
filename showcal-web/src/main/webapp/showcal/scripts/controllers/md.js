/**
 * Created by xiniu on 9/25 0025.
 */
(function () {
    "use strict";
    var app = angular.module("sc.showcal.md", []);
    app.controller("MDIndexController", ["$scope", "$http", "ShowcalService", "dialogService",
        function ($scope, $http, ShowcalService, dialogService) {
            $scope.$emit('navShow', 5);
            //分页传入的数值
            $scope.vm = {
                pageNumber: 1,
                pageSize: 10,
                totalCount: 0
            };
            $scope.pagedResult = [];
            /**
             * 搜索欢迎语
             */
            $scope.getList = function () {

            };
            /**
             * 页面初始化加载数据
             */
            $scope.doSearch = function () {
                $scope.vm.pageNumber = 1;
                $scope.getList();
            };
            $scope.doSearch();
        }
    ]);
})();