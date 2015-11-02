(function(){
    "use strict";
    angular.module("xn.mobile.filter", [])
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
    .filter("timeReturnFormat", [
        function () {
            return function (input) {

                if (input) {
                    if (input.indexOf(" ") == 10) {
                        var time;
                        time = input.substr(0, 10) + "\r\n" + input.substr(11, 5);
                        return time;
                    } else {
                        input = Number(input);
                        return input ? moment(input).format("YYYY-MM-DD") + "\r\n" + moment(input).format("HH:mm") : "";
                    }
                } else {
                    return;
                }

            };
        }
    ]);
})();