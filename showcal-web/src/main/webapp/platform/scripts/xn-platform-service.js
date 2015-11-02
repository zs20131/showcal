(function () {
    "use strict";
    angular.module("xn.platform.service", [])
        .factory('PlatformService', ['$http', function ($http) {
            var service = {};
            var url = "/platform/api.do";
            service.getSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.get"}});
            };
            service.searchSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.search"}});
            };
            service.findSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.find"}});
            };
            service.createSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.create"}});
            };
            service.updateSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.update"}});
            };
            service.deleteSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.delete"}});
            };
            service.upSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.up"}});
            };
            service.downSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.down"}});
            };
            service.banSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.ban"}});
            };
            service.inbanSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.inban"}});
            };
            service.updateUserAvatar = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.userAvatar.update"}
                });
            };
            service.searchBySourceType = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.bySourceType.search"}
                });
            };
            service.inactiveUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.user.inactive"}});
            };
            service.activeUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.user.active"}});
            };
            service.findSysUserCurve = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysusercurve.find"}});
            };

            service.userExistByMobilePhone = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.existByMobilePhone.user"}
                });
            };
            service.login = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.ogin."}});
            };
            service.isResetableLoginPassword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.resetableLoginPassword.is"}
                });
            };
            service.modifyLoginPassword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.loginPassword.modify"}
                });
            };
            service.modifyLoginPasswordCheck = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.loginPassword.modify.check"}
                });
            };
            service.resetUserLoginPassword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.userLoginPassword.reset"}
                });
            };
            service.createVerificationCode = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.verificationCode.create"}
                });
            };
            service.checkValification = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.valification.check"}
                });
            };
            service.getPassport = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.passport.get"}});
            };
            service.getSettingDiseaseAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDiseaseAllList.get"}
                });
            };
            service.createSettingDisease = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDisease.create"}
                });
            };
            service.updateSettingDisease = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDisease.update"}
                });
            };
            service.deleteSettingDisease = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDisease.delete"}
                });
            };
            service.inactiveSettingDisease = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDisease.inactive"}
                });
            };
            service.activeSettingDisease = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingDisease.active"}
                });
            };
            service.getSettingKeywordAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeywordAllList.get"}
                });
            };
            service.createSettingKeyword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeyword.create"}
                });
            };
            service.updateSettingKeyword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeyword.update"}
                });
            };
            service.deleteSettingKeyword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeyword.delete"}
                });
            };
            service.inactiveSettingKeyword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeyword.inactive"}
                });
            };
            service.activeSettingKeyword = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingKeyword.active"}
                });
            };
            service.getSettingQuestionTagAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingQuestionTagAllList.get"}
                });
            };
            service.createSettingQuestionTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingQuestionTag.create"}
                });
            };
            service.updateSettingQuestionTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingQuestionTag.update"}
                });
            };
            service.deleteSettingQuestionTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingQuestionTag.delete"}
                });
            };
            service.inactiveSettingQuestionTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingQuestionTag.inactive"}
                });
            };
            service.findSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.find"}
                });
            };
            service.getSettingUserTagAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTagAllList.get"}
                });
            };
            service.createSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.create"}
                });
            };
            service.updateSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.update"}
                });
            };
            service.deleteSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.delete"}
                });
            };
            service.inactiveSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.inactive"}
                });
            };
            service.activeSettingUserTag = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.settingUserTag.active"}
                });
            };
            service.findSysUserCurve = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.sysUserCurve.find"}
                });
            };
            service.getSysUserCurveAllListbyUser = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.sysUserCurveAllListbyUser.get"}
                });
            };
            service.createSysUserCurve = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.sysUserCurve.create"}
                });
            };
            service.deleteSysUserCurve = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.sysUserCurve.delete"}
                });
            };
            service.createIntegralRule = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralRule.create"}
                });
            };
            service.updateIntegralRule = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralRule.update"}
                });
            };
            service.getIntegralRuleAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralRuleAllList.get"}
                });
            };
            service.deleteIntegralRule = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralRule.delete"}
                });
            };
            service.createIntegralDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralDetail.create"}
                });
            };
            service.findIntegralDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralDetail.find"}
                });
            };
            service.getMyIntegralDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.myIntegralDetail.get"}
                });
            };
            service.createSyncSql = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.syncSql.create"}});
            };
            service.getSyncIncrementSql = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.syncIncrementSql.get"}
                });
            };
            service.findCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.find"}
                });
            };
            service.createCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.create"}
                });
            };
            service.createListCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.create.list"}
                });
            };
            service.deleteCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.delete"}
                });
            };
            service.createMessage = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.message.create"}
                });
            };
            service.findIntegralrule = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralrule.find"}
                });
            };
            service.updateIntegralrule = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.integralrule.update"}
                });
            };
            service.findComment = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.comment.post.find"}});
            };

            service.deleteCommentPostBatch = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.comment.post.delete.batch"}});
            };

            return service;
        }

        ])
        .factory('ThermalControlService', ['$http', function ($http) {
            var service = {};
            var url = "/tc/api.do";
            service.getBaseHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.baseHeat.get"}
                });
            };
            service.findBaseHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.baseHeat.find"}
                });
            };
            service.apiSportHeadTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sport.head.template"}
                });
            };
            service.apiSportSettingTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sport.setting.template"}
                });
            };
            service.createBaseHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.baseHeat.create"}
                });
            };
            service.apiSportHeadImport = function (data) {
                var url = "/api/FileImport.do";
                var fd = new FormData();
                fd.append("file", data);
                fd.append("method", "api.sport.head.import");
                return $http({
                    method: 'POST',
                    url: url,
                    headers: {'Content-Type': undefined},
                    transformRequest: angular.identity,
                    data: fd
                });
            };
            service.updateBaseHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.baseHeat.update"}
                });
            };
            service.deleteBaseHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.baseHeat.delete"}
                });
            };
            service.getBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.get"}
                });
            };
            service.findBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.find"}
                });
            };
            service.createBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.create"}
                });
            };
            service.updateBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.update"}
                });
            };
            service.deleteBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.delete"}
                });
            };
            service.inactiveBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.inactive"}
                });
            };
            service.activeBmiFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.bmiFood.active"}
                });
            };
            service.findEvaluate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.evaluate.find"}
                });
            };
            service.createEvaluate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.evaluate.create"}
                });
            };
            service.updateEvaluate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.evaluate.update"}
                });
            };
            service.findFoodCategory = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodCategory.find"}
                });
            };
            service.getFoodCategoryAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodCategoryAllList.get"}
                });
            };
            service.createFoodCategory = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodCategory.create"}
                });
            };
            service.updateFoodCategory = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodCategory.update"}
                });
            };
            service.deleteFoodCategory = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodCategory.delete"}
                });
            };
            service.findFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.find"}
                });
            };
            service.getFoodExchangeAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchangeAllList.get"}
                });
            };
            service.createFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.create"}
                });
            };
            service.updateFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.update"}
                });
            };
            service.deleteFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.delete"}
                });
            };
            service.inactiveFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.inactive"}
                });
            };
            service.activeFoodExchange = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.foodExchange.active"}
                });
            };
            service.findFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.find"}
                });
            };
            service.createFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.create"}
                });
            };
            service.updateFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.update"}
                });
            };
            service.getFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.get"}
                });
            };
            service.deleteFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.delete"}
                });
            };
            service.inactiveFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.inactive"}
                });
            };
            service.activeFood = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.active"}
                });
            };
            service.apiFoodOutputTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.food.output.template"}
                });
            };
            service.apiSportLineTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sport.line.template"}
                });
            };

            service.apiFoodImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.thermalcontrol.food.import");
                return $http({
                    method : 'POST',
                    url : "/api/FileImport.do",
                    headers: {'Content-Type': undefined },
                    transformRequest: angular.identity,
                    data: fd
                });
            };
            service.apiSportSettingImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.thermalcontrol.sport.setting.import");
                return $http({
                    method : 'POST',
                    url : "/api/FileImport.do",
                    headers: {'Content-Type': undefined },
                    transformRequest: angular.identity,
                    data: fd
                });
            };
            service.apiSportLineImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.thermalcontrol.sport.line.import");
                return $http({
                    method : 'POST',
                    url : "/api/FileImport.do",
                    headers: {'Content-Type': undefined },
                    transformRequest: angular.identity,
                    data: fd
                });
            };
            service.getGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.get"}
                });
            };
            service.searchGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.search"}
                });
            };
            service.findGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.find"}
                });
            };
            service.getGradeWeightAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeightAllList.get"}
                });
            };
            service.createGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.create"}
                });
            };
            service.updateGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.update"}
                });
            };
            service.deleteGradeWeight = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.gradeWeight.delete"}
                });
            };
            service.getMeals = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.meals.get"}
                });
            };
            service.findMeals = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.meals.find"}
                });
            };
            service.createMeals = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.meals.create"}
                });
            };
            service.updateMeals = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.meals.update"}
                });
            };
            service.deleteMeals = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.meals.delete"}
                });
            };
            service.getNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.get"}
                });
            };
            service.searchNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.search"}
                });
            };
            service.findNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.find"}
                });
            };
            service.createNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.create"}
                });
            };
            service.updateNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.update"}
                });
            };
            service.deleteNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.delete"}
                });
            };
            service.inactiveNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.inactive"}
                });
            };
            service.activeNutritionalGoal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.nutritionalGoal.active"}
                });
            };
            service.getSportHead = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.get"}
                });
            };
            service.findSportHead = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.find"}
                });
            };
            service.createSportHead = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.create"}
                });
            };
            service.updateSportHead = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.update"}
                });
            };
            service.updateSportHeadTotalTime = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.updateTotalTime"}
                });
            };
            service.deleteSportHead = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportHead.delete"}
                });
            };
            service.getSportLineAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportLineAllList.get"}
                });
            };
            service.createSportLine = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportLine.create"}
                });
            };
            service.updateSportLine = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportLine.update"}
                });
            };
            service.deleteSportLine = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportLine.delete"}
                });
            };
            service.getSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.get"}
                });
            };
            service.searchSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.search"}
                });
            };
            service.findSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.find"}
                });
            };
            service.getSportSettingAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSettingAllList.get"}
                });
            };
            service.createSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.create"}
                });
            };
            service.updateSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.update"}
                });
            };
            service.deleteSportSetting = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.sportSetting.delete"}
                });
            };
            service.getSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.get"}
                });
            };
            service.searchSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.search"}
                });
            };
            service.findSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.find"}
                });
            };
            service.getSyncHeatDetailAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetailAllList.get"}
                });
            };
            service.createSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.create"}
                });
            };
            service.updateSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.update"}
                });
            };
            service.deleteSyncHeatDetail = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatDetail.delete"}
                });
            };
            service.getSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.get"}
                });
            };
            service.searchSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.search"}
                });
            };
            service.findSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.find"}
                });
            };
            service.getSyncHeatAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeatAllList.get"}
                });
            };
            service.createSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.create"}
                });
            };
            service.updateSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.update"}
                });
            };
            service.deleteSyncHeat = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncHeat.delete"}
                });
            };
            service.getSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.get"}
                });
            };
            service.searchSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.search"}
                });
            };
            service.findSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.find"}
                });
            };
            service.getSyncSportAllList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSportAllList.get"}
                });
            };
            service.createSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.create"}
                });
            };
            service.updateSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.update"}
                });
            };
            service.deleteSyncSport = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.thermalcontrol.syncSport.delete"}
                });
            };
            return service;
        }])
        .factory('ServiceService', ['$http', function ($http) {
            var service = {};
            var url = "/service/api.do";
            service.createWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.create"}});
            };
            service.updateWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.update"}});
            };
            service.deleteWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.delete"}});
            };
            service.inactiveWelcome = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.welcome.inactive"}
                });
            };
            service.activeWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.active"}});
            };
            service.getMyWelComeList = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myWelComeList.get"}
                });
            };
            service.getMyShowCalWelCome = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myShowCalWelCome.get"}
                });
            };
            service.createServiceUser = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.serviceUser.create"}
                });
            };
            service.deleteServiceUser = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.serviceUser.delete"}
                });
            };
            service.getMyServiceUser = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myServiceUser.get"}
                });
            };
            service.getMyHistoryServiceUser = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myHistoryServiceUser.get"}
                });
            };
            service.getMyShowCal = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myShowCal.get"}});
            };
            service.getMyHistoryShowCal = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myHistoryShowCal.get"}
                });
            };
            service.findRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.find"}});
            };
            service.createRepository = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.repository.create"}
                });
            };
            service.updateRepository = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.repository.update"}
                });
            };
            service.deleteRepository = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.repository.delete"}
                });
            };
            service.activeRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.active"}});
            };
            service.inactiveRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.inactive"}});
            };
            service.toPlatformRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.to.platform"}});
            };
            service.toShowcalRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.to.showcal"}});
            };
            service.getMyRepository = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myRepository.get"}
                });
            };
            service.transferMyRepository = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myRepository.transfer"}
                });
            };
            service.apiRepositoryOutputTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.repository.output.template"}
                });
            };
            service.apiRepositoryImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.service.repository.import");
                return $http({
                    method : 'POST',
                    url : "/api/FileImport.do",
                    headers: {'Content-Type': undefined },
                    transformRequest: angular.identity,
                    data: fd
                });
            };
            service.sendQuestion = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.question.send"}});
            };
            service.getMyAskHistoryQuestion = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myAskHistoryQuestion.get"}
                });
            };
            service.getMyWillAnswerQuestion = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myWillAnswerQuestion.get"}
                });
            };
            service.getMyHistoryMessage = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.myHistoryMessage.get"}
                });
            };
            service.sendAnswer = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.answer.send"}});
            };
            service.closeQuestions = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.questions.close"}});
            };
            service.findComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.find"}});
            };
            service.createComplatint = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.complatint.create"}
                });
            };
            service.updateComplatint = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.complatint.update"}
                });
            };
            service.deleteComplatint = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.complatint.delete"}
                });
            };
            service.getComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.get"}});
            };
            return service;
        }])
        .factory('CmsService', ['$http', function ($http) {
            var service = {};
            var url = "/cms/api.do";
            service.findArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.find"}});
            };
            service.getArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.get"}});
            };
            service.updateArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.update"}});
            };
            service.deleteArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.delete"}});
            };
            return service;
        }])
        .factory('MdService', ['$http', function ($http) {
            var service = {};
            var url = "/md/api.do";
            service.findItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.find"}});
            };
            service.createItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.create"}});
            };
            service.getItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.get"}});
            };
            service.deleteItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.delete"}});
            };
            service.updateItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.update"}});
            };
            service.approveItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.approve"}});
            };
            service.cancelItem = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.cancel"}});
            };
            service.createCategory = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.clazz.create.list"}});
            };
            service.changeSort = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.item.sort"}});
            };
            service.findCategory = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.clazz.find"}});
            };
            service.deleteCategory = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.clazz.delete"}});
            };
            service.updateCategory = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.md.clazz.update"}});
            };
            return service;
        }])
    ;
})();