var initApp = function () {
    "use strict";
    var ref = [
    ];

    var app = angular.module("xn", ref);

    app.config(["$httpProvider", function ($httpProvider) {
        $httpProvider.interceptors.push("httpInterceptor");
    }]);
// 全局配置 form提交验证
    app.config(["xnValidatorProvider", function (xnValidatorProvider) {
        // 全局配置
        xnValidatorProvider.config({
            blurTrig: false,
            showError: false,
            removeError: false
        });
        xnValidatorProvider.setRules({
            description: {
                minLength: "字数太少！"
            },
            nickName: {
                required: "请输入姓名！"
            },
            mobilePhone:{
                required: "请输入手机号码！",
                pattern:"请输入正确的手机号码!"
            },
            itemName:{
                required: "商品名称不能为空！"
            },
            classId:{
                required: "类别不能为空！"
            },
            itemText:{
                required: "商品描述不能为空！"
            },
            clazzName:{
                required: "类别不能为空！"
            }

        });
    }]);
    app.controller("BodyController", ["$scope", "dialogService", function ($scope, dialogService) {
        //关闭错误
        $scope.closeAlert = function (index, form) {
            form.splice(index, 1);
        };
        $scope.$on('navShow', function (event, data) {
            $scope.navShow = data;
        });
        $scope.maxPageSize = 5;
    }]);
};