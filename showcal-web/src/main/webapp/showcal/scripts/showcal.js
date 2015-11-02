var initApp=function(){
    "use strict";
    var ref = [
        "xn.directive.common",
        "xn.filter.common",
        "xn.service.common",
        "xn.service.foundation",
        "xn.service.interceptor",
        "xn.showcal.cms",
        "sc.showcal.welcome",
        "sc.showcal.myuser",
        "sc.showcal.md",
        "sc.showcal.repository",
        "xn.showcal.index",
        "xn.showcal.filter",
        "xn.showcal.service",
        "xn.showcal.historymsg",
        "ui.bootstrap",
        "xn.directive.navigation",
        "xn.directive.loading",
        "xn.directive.attachment",
        "xn.directive.select",
        "xn.directive.form",
        "xn.markdown",
        "ngSanitize",
        "sc.pl.password" // 修改密码
    ];

    var app =angular.module("xn", ref);

    app.config(["$httpProvider", function ($httpProvider) {
        $httpProvider.interceptors.push("httpInterceptor");
    }]);
// 全局配置 form提交验证
    app.config(["xnValidatorProvider", function (xnValidatorProvider) {
        // 全局配置
        xnValidatorProvider.config({
            blurTrig   : false,
            showError  : false,
            removeError: false
        });
        xnValidatorProvider.setRules({
            description: {
                minLength: "字数太少！"
            },
            title: {
                required: "帖子名称不能为空！"
            },
            weight: {
                required: "权重不能为空！"
            }
        });
    }]);
    app.controller("BodyController",["$scope","dialogService", function($scope,dialogService) {
        //关闭错误
        $scope.closeAlert = function (index,form) {
            form.splice(index,1);
        };
        $scope.$on('navShow', function(event, data) {
            $scope.navShow = data;
        });
        $scope.maxPageSize=5;

        $scope.loginout = function () {
            var dialogDefaults = {
                size: "sm"
            };
            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定注销",
                headerText: "继续....?",
                bodyText: "您确定要注销吗？",
                callback: function () {
                    window.location.href="/loginout";
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };

    }]);
};