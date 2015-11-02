(function () {
    "use strict";
    angular.module("xn.showcal.filter", [])
        .filter("memberType", [
            function () {
                return function (input) {
                    var type = "";
                    switch (input) {
                        case 'SENIOR':
                            type = "高级会员";
                            break;
                        case 'STANDARD':
                            type = "普通会员";
                            break;
                    }
                    return type;
                };
            }
        ])
        .filter("statusType", [
            function () {
                return function (input) {
                    var status = "";
                    var inputData = "";
                    switch (inputData) {
                        case "false":
                            status = "未发布";
                            break;
                        case "true":
                            status = "已发布";
                            break;

                    }
                    return status;
                };
            }
        ])
        .filter("isActive", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case false:
                            status = "未发布";
                            break;
                        case true:
                            status = "已发布";
                            break;

                    }
                    return status;
                };
            }
        ])
        .filter("timeReturnFormat", [
            function () {
                return function (input) {

                    if (input !=undefined ||  input==null) {
                        return;

                    } else {
                        if (input.indexOf(" ") == 10) {
                            var time;
                            time = input.substr(0, 10) + "\r\n" + input.substr(11, 5);
                            return time;
                        } else {
                            input = Number(input);
                            return input ? moment(input).format("YYYY-MM-DD") + "\r\n" + moment(input).format("HH:mm") : "";
                        }
                    }

                };
            }
        ])
        .filter("sexType", [
            function () {
                return function (input) {
                    var type = "未知";
                    switch (input) {
                        case 'FEMALE':
                            type = "女";
                            break;
                        case 'MALE':
                            type = "男";
                            break;
                    }
                    return type;
                };
            }
        ])
        .filter("serviceState", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case false:
                            status = "历史服务";
                            break;
                        case true:
                            status = "正在服务";
                            break;

                    }
                    return status;
                };
            }
        ])
        .filter("welcomeActive", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case false:
                            status = "非默认";
                            break;
                        case true:
                            status = "默认";
                            break;

                    }
                    return status;
                };
            }
        ])
        .filter("sexType", [
            function () {
                return function (input) {
                    var type = "";
                    switch (input) {
                        case 'FEMALE':
                            type = "女";
                            break;
                        case 'MALE':
                            type = "男";
                            break;
                    }
                    return type;
                };
            }
        ])
        .filter("serviceState", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case false:
                            status = "历史服务";
                            break;
                        case true:
                            status = "正在服务";
                            break;

                    }
                    return status;
                };
            }
        ])
        .filter('trustHtml', function ($sce) {
            return function (input,keyword) {
                console.log("--->"+keyword);
                return $sce.trustAsHtml(input);
            }
        });
})();