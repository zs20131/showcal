(function () {
    "use strict";
    angular.module("xn.mobile.service", [])
        .factory('MobileService', ['$http', function ($http) {
            var service = {};
            var url = "/mobile/api.do";
            service.getVerfiycode = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.mobile.verfiycode.get"}
                });
            };
            service.apiVelidateCode = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.mobile.code.velidate"}
                });
            };
            service.apiVelidateMobilePhone = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.mobile.mobile.velidate"}
                });
            };
            service.apiVelidateMobilePhoneExist = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.mobile.mobileexist.velidate"}
                });
            };
            service.register_step2 = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.mobile.register.step2"}
                });
            };
            return service;
        }

        ])

;
})();