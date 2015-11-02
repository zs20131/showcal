(function(){
    "use strict";

    /**
     * 修改密码
     * @author zxl
     * @param $scope
     */
    var passwordChangeController = function($scope,PlatformService,dialogService){
        // 保存新密码
        $scope.doChange = function(){

            if($scope.vm.loginPassword != $scope.vm.confirmPassword){
                alert("密码不一致");
                return;
            }

            PlatformService.modifyLoginPasswordCheck($scope.vm).success(function(data){
                if (data.errors == null || data.errors.length > 0){
                    dialogService.tip(data.errors);
                }else{
                    dialogService.tip([{message:"修改成功"}],"../")
                }
            });
        };
    };

    // 定义module,并指明依赖模块
    angular.module("sc.pl.password",[])
        .controller("PasswordChangeController",["$scope","PlatformService","dialogService",passwordChangeController]);
})();