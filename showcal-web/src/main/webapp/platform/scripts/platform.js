var initApp = function () {
    "use strict";
    var ref = [
        "xn.directive.common",
        "xn.filter.common",
        "xn.service.common",
      /*  "xn.service.foundation",*/
        "xn.service.interceptor",
        // 平台keyword,usertag,questionTag,disease等
        "sc.pl.keyword",
        "sc.pl.usertag",
        "sc.pl.questionTag",
        "sc.pl.disease",
        "sc.pl.usermanager",
        "sc.pl.evaluate",
        "sc.pl.integral",
        "sc.pl.repository",
        "sc.pl.sportscheme",
        "sc.pl.sportSetting",
        "sc.pl.food",
        "xn.pl.md",
        "xn.pl.complaint",
        "xn.pl.article",
        "sc.pl.accountmanager",
        "sc.pl.foodCategory",
        "sc.pl.createFood",
        "sc.pl.editFood",
        "sc.pl.password",
        //end
        "xn.platform.filter",
        "xn.platform.service",
        "ui.bootstrap",
        "xn.markdown",
        "xn.directive.navigation",
        "xn.directive.loading",
        "xn.directive.attachment",
        "xn.directive.select",
        "xn.directive.form",
        "ngSanitize"
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
            step:{
                required:"请输入运动步骤",
                pattern :"运动步骤必须是数字"
            },
            sportTime:{
                required:"请选择运动时长"
            },
            sportContent:{
                required:"请选择运动内容"
            },
            startBmi:{
                required:"请输入BMI起始值"  ,
                pattern:"请输入整数!"
            },
            endBmi:{
                required:"请输入BMI结束值"  ,
                pattern:"请输入整数!"
            },
            description: {
                required:"内容不能为空",
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
                required: "内容不能为空！"
            },
            clazzName:{
                required: "类别不能为空！"
            },
            originalPrice:{
                required: "金额不能为空！",
                pattern :"请输入正确金额"
            },
            sendMessage:{
                required: "系统消息不能为空！"
            },
            burnHeat:{
                required: " 消耗热量不能为空！",
                pattern:"请输入正确的数字"
            },
            volume:{
                required: "体积不能为空！",
                pattern :"请输入正确的整数"
            },
            weight:{
                required: "重量不能为空！",
                pattern :"请输入正确的整数"
            }
        });
    }]);
    app.controller("BodyController", ["$scope", "dialogService", function ($scope, dialogService) {
        //关闭错误
        $scope.closeAlert = function (index,form) {
            form.splice(index,1);
        };
        $scope.$on('navShow', function (event, data) {
            $scope.navShow = data;
        });
        $scope.maxPageSize = 5;

        $scope.platformloginout = function () {
            var dialogDefaults = {
                size: "sm"
            };
            var dialogOptions = {
                closeButtonText: "取消",
                actionButtonText: "确定注销",
                headerText: "继续....?",
                bodyText: "您确定要注销吗？",
                callback: function () {
                window.location.href="/login";
                }
            };
            dialogService.confirm(dialogDefaults, dialogOptions);
        };
    }]);
};