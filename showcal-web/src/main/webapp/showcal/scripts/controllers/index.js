(function () {
    "use strict";
    // 首页控制器
    var indexController = function ($scope, $sce, $timeout, PlatformService, ShowcalService, dialogService) {
        $scope.vm = {
            show: "showcal-slip-box-init",
            pageSize: 10,
            pageNumber: 1
        };
        $scope.repositoryParam = {
            pageSize: 0
        }
        $scope.replyquestion = [];
        $scope.questionusers = [];
        $scope.reply = function () {
            // 判断是否勾选
            $scope.keywordIds = [];
            $scope.tageIds = [];
            $scope.questionusers = [];
            $scope.replyquestion = [];
            if ($scope.questions.length > 0) {
                for (var i = 0; i < $scope.questions.length; i++) {
                    if ($scope.questions[i].check) {
                        $scope.replyquestion.push($scope.questions[i].id);
                        $scope.questionusers.push($scope.questions[i].questionUserId);
                        if ($scope.questions[i].keywordId) {
                            $scope.keywordIds.push($scope.questions[i].keywordId);
                        }
                        if ($scope.questions[i].tagId) {
                            $scope.tageIds.push($scope.questions[i].tagId);
                        }

                    }
                }
            }
            if ($scope.replyquestion.length > 0) {
                $scope.vm.show = $scope.vm.show == "showcal-slip-box-enter" ? "showcal-slip-box-leave" : "showcal-slip-box-enter";
            } else {
                dialogService.tip([
                    {"message": "请选择问题，回复！" }
                ]);
            }
            $scope.repositoryParam.keywords = $scope.keywordIds;
            $scope.repositoryParam.tageIds = $scope.tageIds;
            $scope.getRepository();
        }
        /*  $(".showcal-reply").siblings().bind("click",function(){
         $scope.$apply(function(){
         $scope.vm.show="showcal-slip-box-leave";
         });
         })*/
        //点击非当前滑动窗口地方 控制滑动消失 index页面加了一个id=showslide
        $(document).each(function () {
            $(this).bind("click", function () {
                $scope.$apply(function () {
                    $scope.vm.show = "showcal-slip-box-leave";
                });
            });
            $(".showcal-reply").bind("click", function (e) {
                return false;
            })
            $("#showslide").bind("click", function (e) {
                return false;
            })
        });
        //查询消息
        $scope.queryMessageByTag = function (tagId) {
            $scope.vm.isOther = false;
            $scope.vm.isNewUser = false;
            $scope.vm.questionTagId = tagId;
            $scope.vm.keywordId = null;
            $scope.getquestion();
        }
        $scope.doSearch = function () {
            $scope.vm.isOther = false;
            $scope.vm.isNewUser = false;
            $scope.vm.keywordId = null;
            $scope.vm.questionTagId = null;
            $scope.getquestion();
        }
        //查询keyword
        $scope.queryMessageBykeyword = function (keywordId) {
            $scope.vm.keywordId = keywordId;
            $scope.vm.questionTagId = null;
            $scope.vm.isOther = false;
            $scope.vm.isNewUser = false;
            $scope.getquestion();
        }

        $scope.queryOther = function () {
            $scope.vm.isOther = true;
            $scope.vm.isNewUser = false;
            $scope.vm.keywordId = null;
            $scope.vm.questionTagId = null;
            $scope.getquestion();
        }
        $scope.queryNewUser = function () {
            $scope.vm.isNewUser = true;
            $scope.vm.isOther = false;
            $scope.vm.keywordId = null;
            $scope.vm.questionTagId = null;
            $scope.getquestion();
        }
        $scope.selectRepository = function (repository) {
            $scope.markdownValue = repository;
        }
        $scope.send = function () {
            if ($scope.markdownValue == '') {
                dialogService.tip([
                    {"message": "请填写回答问题！" }
                ]);
                return;
            }
            $scope.answer = {};
            $scope.answer.content = $scope.markdownValue;
            $scope.answer.isAnswered = false;
            $scope.answer.questionIds = $scope.replyquestion;
            $scope.answer.userIds = $scope.questionusers;
            ShowcalService.sendAnswer($scope.answer).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.reply();
                    $scope.markdownValue = '';
                    $scope.getquestion();
                }
            });
        }
        $scope.sendandclose = function () {
            if ($scope.markdownValue == '') {
                dialogService.tip([
                    {"message": "请填写回答问题！" }
                ]);
                return;
            }
            $scope.answer = {};
            $scope.answer.content = $scope.markdownValue;
            $scope.answer.isAnswered = true;
            $scope.answer.questionIds = $scope.replyquestion;
            $scope.answer.userIds = $scope.questionusers;
            ShowcalService.sendAnswer($scope.answer).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.reply();
                    $scope.markdownValue = '';
                    $scope.getquestion();
                }
            });
        }
        $scope.all = false;
        $scope.questions = [];
        // 复选框部分
        $scope.allBox = function () {
            $scope.all = !$scope.all;
            if ($scope.questions.length > 0) {
                for (var i = 0; i < $scope.questions.length; i++) {
                    $scope.questions[i].check = $scope.all;
                }
            }
        }

        // 业务逻辑部分
        $scope.endtimes = [
            {id: 0, name: '已过期'},
            {id: 6, name: '6小时内过期'},
            {id: 12, name: '12小时内过期'},
            {id: 24, name: '24小时内过期'}
        ]
        PlatformService.getSettingUserTagAllList({}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.usertags = data.result;
            }
        });
        $scope.dochangeSelect = function (question) {
            var length = $scope.replyquestion.length;
            for (var i = 0; i < length; i++) {
                var id = $scope.replyquestion[i];
                if (question.id == id) {
                    $scope.replyquestion.splice(i, 1);
                }
            }
            if (question.check) {
                $scope.replyquestion.push(question.id);
            }
            console.log(question.id + question.check);
        }

        //获取所有等待我回答的问题信息
        $scope.getquestion = function () {
            ShowcalService.getMyWillAnswerQuestion($scope.vm).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.newUserQuestionCount = data.newUserQuestionCount;
                    $scope.questionTagList = data.questionTagList;
                    $scope.keyWordTagList = data.keyWordTagList;
                    $scope.totalCount = data.totalCount;
                    $scope.otherQuestionCount = data.otherQuestionCount;
                    $scope.questions = data.result;
                    if ($scope.questions && $scope.questions.length > 0) {
                        var length = $scope.questions.length;
                        for (var i = 0; i < length; i++) {
                            if ($scope.replyquestion.length > 0) {
                                for (var j = 0; j < $scope.replyquestion.length; j++) {
                                    var id = $scope.replyquestion[j];
                                    var question = $scope.questions[i];
                                    if (id == question.id) {
                                        $scope.questions[i].check = true;
                                    }
                                }
                            }
                            var keyword = $scope.questions[i].keyword;
                            if (keyword && keyword.length > 0) {
                                var length = $scope.questions[i].serviceMessages.length;
                                for (var k = 0; k < length; k++) {
                                    var str = $scope.questions[i].serviceMessages[k].content;
                                    $scope.questions[i].serviceMessages[k].content = str.replace(keyword, '<b style="color: #ff0000;">' + keyword + '</b>');
                                }
                            }
                        }
                    }
                }
            });
        }
        $scope.getquestion();
        $scope.dotime = function () {
            $timeout(function () {
                $scope.getquestion();
                $scope.dotime();
            }, 30000);
        }
        $scope.dotime();
        // 查询知识库
        $scope.vm.repositoryKeyword = '';

        $scope.getRepository = function () {
            // 循环根据关键字，标签，读取数据

            ShowcalService.getSystemRepository($scope.repositoryParam).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.sysRepository = data.result;
                }
            });
            ShowcalService.getMyRepository($scope.repositoryParam).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.myRepository = data.result;
                }
            });
        }
        $scope.getRepository();


        $scope.searchrepository = function () {
            $scope.repositoryParam.keywords = [];
            $scope.repositoryParam.tageIds = [];
            $scope.repositoryParam.keyword = $scope.vm.repositoryKeyword;
            $scope.getRepository();
        }

    };
    angular.module("xn.showcal.index", [])
        .controller("IndexController", ["$scope", "$sce", "$timeout", "PlatformService", "ShowcalService", "dialogService", indexController])
})();