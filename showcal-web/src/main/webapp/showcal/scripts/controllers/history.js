(function () {
    "use strict";
    // 首页控制器
    var historyIndexController = function ($scope, $sce, $timeout,PlatformService,ShowcalService, dialogService) {
        // 业务逻辑部分
        $scope.endtimes = [
            {id: 0, name: '已过期'},
            {id: 6, name: '6小时内过期'},
            {id: 12, name: '12小时内过期'},
            {id: 24, name: '24小时内过期'}
        ];
        $scope.vm = {
            pageNumber: 1,
            pageSize: 10,
            totalCount: 0
        };
        PlatformService.getSettingUserTagAllList({pageSize:0}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.usertags = data.result;
            }
        });
        PlatformService.getSettingKeywordAllList({pageSize:0}).success(function (data) {
            if (data.errors === null || data.errors.length > 0) {
                dialogService.tip(data.errors);
            } else {
                $scope.keywords = data.result;
            }
        });
        $scope.url={};
        $scope.userName={};
        $scope.allQuestion=[];
        $scope.getList=function(){
            ShowcalService.findHistoryQuestion($scope.vm).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    $scope.allQuestion = data.maps;
                    console.log(data.maps);
                }
            });
        };
        $scope.getList();
        $scope.query = function(){
            $scope.getList();
        };
        $scope.messages=[];
        $scope.showDialog=function(id,name){
            $scope.vm1 = {
                pageNumber: 1,
                pageSize: 0,
                totalCount: 0,
                showcalId:id
            };
            ShowcalService.getHistoryMessage($scope.vm1).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    console.log(data.result);
                    $scope.messages = data.result;
                    $scope.url=data.url;
                    console.log(data.url);
                    $scope.userName=data.name;
                    var obj = "";
                    for(var i=0;i<data.result.length;i++) {
                        var createTime="";
                        createTime = moment(Number(data.result[i].creationTime)).format("YYYY-MM-DD") + "\r\n" + moment(Number(data.result[i].creationTime)).format("HH:mm");
                        if(data.result[i].type=="QUESTION"){
                           obj += "<img class='chat-img' src='"+ $scope.messages[i].avatarurl+"'><span class='ml_10'>"+name+ " "+createTime+"</span>";
                            if($scope.messages[i].url != "" && $scope.messages[i].url != null){
                                obj += "<div class='left-message-img'><img src='" + $scope.messages[i].url +"'/></div></div><br/><div class='clearfix'></div>"
                            }else{
                                obj += "<div class='left-message'>"+$scope.messages[i].content+"</div></div><br/><div class='clearfix'></div>"
                            }
                       }
                        if(data.result[i].type=="ANSWER"){
                            obj += "<img class='chat-img-1' src='"+ $scope.url+"'><span class='f-right ml_10'>"+$scope.userName+ " "+createTime+"</span>";
                            obj += "<div class='clearfix'></div><div class=' right-message'><div class='arrow-right'></div>"+$scope.messages[i].content+"</div></div><br/><div class='clearfix'></div>"
                        }
                    }
                    $("#ChatContent").html(obj);
                }
            });
        }
        $scope.ChatSend=function(){
            var sendValue=$("textarea[name='ChatValue']").val();
            if(sendValue==null|| $.trim(sendValue)==""){
                dialogService.tip([{message: " 请输入回复信息"}]);
                 return false;
            }
            if($scope.messages.length==0){
                dialogService.tip([{message: " 请选择用户"}]);
                return false;
            }
            var question=[];
            for(var i=0;i<$scope.messages.length;i++){
                if($scope.messages[i].type=="QUESTION"){
                    question.push($scope.messages[i]);
                }
            }
            $scope.questionuserIds=[];
            $scope.questionuserIds.push(question[question.length-1].serviceId);
            $scope.questionuserUsers=[];
            $scope.questionuserUsers.push(question[question.length-1].fromUserId);
            $scope.answer = {};
            $scope.answer.content = sendValue;
            $scope.answer.isAnswered = false;
            $scope.answer.questionIds = $scope.questionuserIds;
            $scope.answer.userIds = $scope.questionusers;
            ShowcalService.sendAnswer($scope.answer).success(function (data) {
                if (data.errors === null || data.errors.length > 0) {
                    dialogService.tip(data.errors);
                } else {
                    var date="";
                    console.log(Date.parse(new Date()));
                     date= moment(Number(Date.parse(new Date()))).format("YYYY-MM-DD") + "\r\n" + moment(Number(Date.parse(new Date()))).format("HH:mm");
                    console.log(date);
                    $("textarea[name='ChatValue']").val("");
                    var value="";
                    value += "<img class='chat-img-1' src='"+ $scope.url+"'><span class='f-right ml_10'>"+$scope.userName+ " "+date+"</span>";
                    value += "<div class='clearfix'></div><div class=' right-message'><div class='arrow-right'></div>"+sendValue+"</div></div><br/><div class='clearfix'></div>"
                    $("#ChatContent").append(value);
                }
            });
        }
    };
    angular.module("xn.showcal.historymsg", [])
        .controller("HistoryMessageIndexController", ["$scope", "$sce", "$timeout", "PlatformService", "ShowcalService", "dialogService", historyIndexController])
})();