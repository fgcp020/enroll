myApp.controller('loginController', function ($rootScope, $scope, services, $window, $sce, $stateParams) {
    element_init = false;
    $scope.services = services;
    services["_load_Data"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/site/getIndexArticleList', param, "POST");
    };

    $rootScope.skipPage = {
        name: "home"
    };
    $window.sessionStorage.removeItem("_USERINFO");
    $window.sessionStorage.removeItem("_ALLMENU");
    $rootScope._ALLMENU = null;
    $rootScope._USERINFO = null;
    $rootScope.token = null;
    $.cookie("LOGINUSERINFO_TOKEN", "");
    $scope.loginInfo = {
        user_type: 2,
        user_name: null,
        user_pwd: null,
        checked: false
    };
    //检测是否有登录信息
    var uname = $.cookie("LOGINUSERINFO_NAME");
    var upass = $.cookie("LOGINUSERINFO_PASS");
    if (uname && uname != "" && upass && upass !== "") {
        $scope.loginInfo = {
            user_type: 2,
            user_name: uname,
            user_pwd: upass,
            checked: true
        }
    }
    layer.closeAll();
    $scope.mobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    if($scope.mobile) {
    	var mobileMeta = document.getElementById("mobilePort");
    	if(mobileMeta) {
    		mobileMeta.content = "width=device-width,initial-scale=1 user-scalable=0";
    	} else {
        	var mobileMeta1 = document.createElement('meta');
        	mobileMeta1.name="viewport";
        	mobileMeta1.id="mobilePort";
        	mobileMeta1.content="width=device-width,initial-scale=1 user-scalable=0";
        	document.head.appendChild(mobileMeta1);
    	}
    }
    /**
     * 登录
     * @private
     */

    $scope._singIn = function () {
        if ($scope.loginInfo.user_name && $scope.loginInfo.user_pwd) {
            $rootScope._login($scope.loginInfo, '', 'admin');
            //判断是否有保存密码
            if ($scope.loginInfo.checked) {
                $.cookie("LOGINUSERINFO_NAME", $scope.loginInfo.user_name);
                $.cookie("LOGINUSERINFO_PASS", $scope.loginInfo.user_pwd);
            }
            else {
                $.cookie("LOGINUSERINFO_NAME", "");
                $.cookie("LOGINUSERINFO_PASS", "");
            }
            $.cookie("LOGINSTARTPAGENAME", "")
        }
        else {
            layer.alert("请正确输入用户名和密码");
        }
    };
    $scope.data = {};
    $scope.load = function () {
        services._load_Data().success(function (res) {
            $scope.data = res.data
            $('#notice ul').empty();
            $.each($scope.data, function (index, item) {
                if (item.article_type == 2) {
                    $('#notice ul').append('<li><a href="' + item.article_content + '" target="_blank"> •  '+ item.article_title+'</a></li>')
                } else {
                    $('#notice ul').append('<li><a href="' + ctxPath + '/admin#/bell/detail/' + item.article_id + '"> •  '+ item.article_title+'</a></li>')
                }

            })
        });
        document.onkeydown = function (e) {
            var index = location.href;
            if (index.substring(index.lastIndexOf('/'), index.length) == '/login') {
                var ev = document.all ? window.event : e;
                if (ev.keyCode == 13) {
                    $scope._singIn()
                }
            }

        }
    };
    //$scope.load();

});