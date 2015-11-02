(function () {
    "use strict";
    angular.module("xn.showcal.service", [])
        .factory('ShowcalService', ['$http', function ($http) {
            var service = {};
            var url = "/service/api.do";
            service.createWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.create"}});
            };
            service.getWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.get"}});
            };
            service.updateWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.update"}});
            };
            service.deleteWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.delete"}});
            };
            service.inactiveWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.inactive"}});
            };
            service.activeWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.active"}});
            };
            service.getMyWelComeList = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myWelComeList.get"}});
            };
            service.getMyShowCalWelCome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myshowcalwelcome.get"}});
            };
            service.createServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.serviceUser.create"}});
            };
            service.deleteServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.serviceUser.delete"}});
            };
            service.getMyServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myServiceUser.get"}});
            };
            service.getMyHistoryServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryServiceUser.get"}});
            };
            service.getMyShowCal = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myShowCal.get"}});
            };
            service.getMyHistoryShowCal = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryShowCal.get"}});
            };
            service.findRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.find"}});
            };
            service.createRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.create"}});
            };
            service.updateRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.update"}});
            };
            service.deleteRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.delete"}});
            };
            service.activeRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.active"}});
            };
            service.inactiveRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.inactive"}});
            };
            service.getMyRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myRepository.get"}});
            };
            service.getSystemRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.systemRepository.get"}});
            };
            service.transferMyRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myRepository.transfer"}});
            };
            service.apiMyRepositoryOutputTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.my.repository.output.template"}
                });
            };
            service.apiMyRepositoryImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.service.my.repository.import");
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
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myAskHistoryQuestion.get"}});
            };
            service.getMyWillAnswerQuestion = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myWillAnswerQuestion.get"}});
            };
            service.getMyHistoryMessage = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryMessage.get"}});
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
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.create"}});
            };
            service.updateComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.update"}});
            };
            service.deleteComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.delete"}});
            };
            service.getComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.get"}});
            };
            service.findHistoryQuestion = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.question.history.find"}});
            };
            service.getHistoryMessage = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": " api.service.message.history.get"}});
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
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.inactive"}});
            };
            service.activeWelcome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.welcome.active"}});
            };
            service.getMyWelComeList = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myWelComeList.get"}});
            };
            service.getMyShowCalWelCome = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myShowCalWelCome.get"}});
            };
            service.createServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.serviceUser.create"}});
            };
            service.deleteServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.serviceUser.delete"}});
            };
            service.getMyServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myServiceUser.get"}});
            };
            service.getMyHistoryServiceUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryServiceUser.get"}});
            };
            service.getMyShowCal = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myShowCal.get"}});
            };
            service.getMyHistoryShowCal = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryShowCal.get"}});
            };
            service.findRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.find"}});
            };
            service.createRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.create"}});
            };
            service.updateRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.update"}});
            };
            service.deleteRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.delete"}});
            };
            service.activeRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.active"}});
            };
            service.inactiveRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.repository.inactive"}});
            };
            service.getMyRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myRepository.get"}});
            };
            service.transferMyRepository = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myRepository.transfer"}});
            };
            service.apiMyRepositoryOutputTemplate = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.service.my.repository.output.template"}
                });
            };
            service.apiMyRepositoryImport = function (file) {
                var fd = new FormData();
                fd.append("file",file);
                fd.append("method", "api.service.my.repository.import");
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
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myAskHistoryQuestion.get"}});
            };
            service.getMyWillAnswerQuestion = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myWillAnswerQuestion.get"}});
            };
            service.getMyHistoryMessage = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.myHistoryMessage.get"}});
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
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.create"}});
            };
            service.updateComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.update"}});
            };
            service.deleteComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.delete"}});
            };
            service.getComplatint = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.service.complatint.get"}});
            };
            return service;
        }])
        .factory('PlatformService', ['$http', function ($http) {
            var service = {};
            var url = "/platform/api.do";
            service.getSysUser = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sysUser.get"}});
            };
            service.deleteCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.delete"}
                });
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
            service.findCommentPost = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.comment.post.find"}
                });
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
            service.createSysUserTag = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.platform.sys.user.tag.create"}});
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
            service.createMessage = function (data) {
                return $http({
                    method: 'POST',
                    url: url,
                    data: data,
                    params: {"method": "api.platform.message.create"}
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
            return service;
        }])
        .factory('CmsService', ['$http', function ($http) {
            var service = {};
            var url = "/cms/api.do";
            service.findArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.find"}});
            };

            service.createArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.create"}});
            };
            service.deleteArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.delete"}});
            };
            service.getArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.get"}});
            };
            service.updateArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.update"}});
            };
            service.successArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.success"}});
            };
            service.unsuccessArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.unsuccess"}});

            };
            service.approveArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.approve"}});
            };
            service.cancelArticle = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.cancel"}});
            };
            service.changeOrder = function (data) {
                return $http({method: 'POST', url: url, data: data, params: {"method": "api.cms.article.order"}});
            };
            return service;
        }]);

})();