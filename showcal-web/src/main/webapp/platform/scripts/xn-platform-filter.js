(function () {
    "use strict";
    angular.module("xn.platform.filter", [])
        .filter("userType", [
            function () {
                return function (input) {
                    var type = "";
                    switch (input) {
                        case 'USER':
                            type = "普通会员";
                            break;
                        case 'SHOWCAL':
                            type = "瘦咖";
                            break;
                        case 'PLADMIN':
                            type = "平台管理员";
                            break;
                    }
                    return type;
                };
            }
        ])
        .filter("isRecommend", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case 1:
                            status = "早";
                            break;
                        case 2:
                            status = "中";
                            break;
                        case 3:
                            status = "晚";
                            break;
                    }
                    return status;
                };
            }
        ])
        .filter("integralType", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case "LOGIN":
                            status = "登陆";
                            break;
                        case "USERTC":
                            status = "热控";
                            break;
                        case "QUESTION":
                            status = "提问";
                            break;
                        case "REPLY":
                            status = "评论";
                            break;
                        case "FORWORD":
                            status = "转发";
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
        .filter("intensity", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case 'LOW':
                            status = "低";
                            break;
                        case 'MIDDLE':
                            status = "中";
                            break;
                        case 'HEIGHT':
                            status = "高";
                            break;
                    }
                    return status;
                };
            }
        ])
        .filter("address", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case 'HOME':
                            status = "住所";
                            break;
                        case 'OUTDOORS':
                            status = "户外";
                            break;
                        case 'GYM':
                            status = "健身房";
                            break;
                    }
                    return status;
                };
            }
        ])
        .filter("sportUrlType", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case 'URL':
                            status = "链接";
                            break;
                        case 'PICTURE':
                            status = "图片";
                            break;
                        case 'VIDEO':
                            status = "视频";
                            break;
                        case 'TEXT':
                            status = "文本";
                            break;
                    }
                    return status;
                };
            }
        ]).filter("evaluateType", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case '1':
                            status = "热量";
                            break;
                        case '2':
                            status = "脂肪";
                            break;
                        case '3':
                            status = "蛋白质";
                            break;
                        case '4':
                            status = "碳水";
                            break;
                    }
                    return status;
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
        .filter("types", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case '0':
                            status = "评论";
                            break;
                        case '1':
                            status = "建议";
                            break;
                    }
                    return status;
                };
            }
        ])
        .filter("repositoryType", [
            function () {
                return function (input) {
                    var status = "";
                    switch (input) {
                        case 'PLATFORM':
                            status = "系统";
                            break;
                        case 'SHOWCAL':
                            status = "瘦咖";
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
        ]);
})();