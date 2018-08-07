var myApp = angular.module('myApp', [
    'myDirectives',
    'myServices',
    'oc.lazyLoad',
    'ui.router']).run([
    '$rootScope',
    'services',
    function ($rootScope, services) {
        //路径前缀
    	///////////
        $rootScope.ctxPath = '/';
        $rootScope.servers = services;
        //禁用默认事件冒泡
        $rootScope.stopEvent = function ($event) {
            $event.stopPropagation();
        }
        //格式转字符
        $rootScope.getUnixDate = function (dateStr) {
            var regEx = new RegExp("\\-", "gi");
            return Math.round(Date.parse(dateStr.replace(regEx, "/")));
        }
        //字符转格式
        $rootScope.getLocalDate = function (unixdate, datatime) {
            if (null == unixdate || "" == unixdate) {
                var date = new Date();
                unixdate = date.getTime();
            }
            var t = new Date(parseInt(unixdate));
            return $rootScope.getDateStr(t, datatime);
        }
        //返回日期格式
        $rootScope.getDateStr = function (t, datatime) {
            var tm = t.getMonth() + 1;
            if (tm < 10) {
                tm = "0" + tm.toString();
            }
            var day = t.getDate();
            if (day < 10) {
                day = "0" + day.toString();
            }
            var t_hour = t.getHours();
            if (t_hour < 10) {
                t_hour = "0" + t_hour.toString();
            }
            var t_Minutes = t.getMinutes();
            if (t_Minutes < 10) {
                t_Minutes = "0" + t_Minutes.toString();
            }
            var t_Seconds = t.getSeconds();
            if (t_Seconds < 10) {
                t_Seconds = "0" + t_Seconds.toString();
            }
            if (datatime)
                return t.getFullYear() + "-" + tm + "-" + day + " " + t_hour + ":" + t_Minutes;
            else
                return t.getFullYear() + "-" + tm + "-" + day;
        }
    }
]);
myApp.factory('authInterceptor', function ($rootScope, $q, $window) {
    return {
        request: function (config) {
            config.headers = config.headers || {};
            if ($rootScope.token) {
                config.headers.token = $rootScope.token;
            }
            if (returnCitySN) {
                config.headers.IP = returnCitySN["cip"];
                config.headers.Address = encodeURI(returnCitySN["cname"]);
            }
            return config;
        },
        responseError: function (rejection) {
            if (rejection.status === 401) {
                $rootScope.sessionOut();
            }
            return $q.reject(rejection);
        },
        response: function (response) {
            //正常
            if (response.code == 600) {
                $rootScope.sessionOut();
            }
            return response;
        }
    };
});
myApp.config(function ($httpProvider) {
    $httpProvider.interceptors.push('authInterceptor');
});

/**
 * 总控制器
 */
myApp.controller('mainController', function ($rootScope, $scope, services, $sce, $window, $state, $stateParams) {
    $rootScope.sys_dateTime = getSyaDatetime();
    function getSyaDatetime() {
        var day = moment().format("d"), dtxt = "星期天";
        if (day == 1) {
            dtxt = "星期一";
        }
        else if (day == 2) {
            dtxt = "星期二";
        }
        else if (day == 3) {
            dtxt = "星期三";
        }
        else if (day == 4) {
            dtxt = "星期四";
        }
        else if (day == 5) {
            dtxt = "星期五";
        }
        else if (day == 6) {
            dtxt = "星期六";
        }
        setTimeout(function () {
            $rootScope.$apply(function () {
                $rootScope.sys_dateTime = getSyaDatetime();
            });
        }, 1000);
        return moment().format('YYYY年MM月DD日 ' + dtxt + ' HH:mm:ss');
    }

    $("body").delegate(".layui-form-select", "click", function () {
        $(".layui-form-select").not(this).removeClass("layui-form-selected");
        if (!$(".layui-select-title input", this).attr("disabled"))
            $(this).toggleClass("layui-form-selected");
        return false;
    })
    //下拉组件
    $("body").delegate(".dropdown", "click", function () {
        $(".dropdown").not(this).removeClass("open");
        $(this).toggleClass("open");
        return false;
    });
    $("body").bind("click", function () {
        $(".dropdown").removeClass("open");
        $(".layui-form-select").removeClass("layui-form-selected");
    });

    //图片预览
    $("body").delegate(".max_img_box", "click", function () {
        var url = this.src;
        if (url && url != "") {
            var parent = $('<div class="max_img_box_parent"></div>').appendTo("body");
            parent.click(function () {
                $(".max_img_box_parent").remove();
            })
            var p_img = $('<img src="' + url + '" />').appendTo(parent);
            $(p_img).draggable().click(function () {
                return false;
            });
            var rotate = 0;
            var action = $('<div class="max_img_action"></div>').appendTo(parent);
            action.click(function () {
                return false;
            })
            var action_left = $('<span class="left"></span>').appendTo(action);
            var action_right = $('<span class="right"></span>').appendTo(action);
            action_left.click(function () {
                rotate -= 90;
                if (rotate < -270) {
                    rotate = 0;
                }
                p_img[0].className = "rotate_" + rotate;
            })
            action_right.click(function () {
                rotate += 90;
                if (rotate > 270) {
                    rotate = 0;
                }
                p_img[0].className = "rotate_" + rotate;
            })
            $(parent).bind('mousewheel', function (event, delta, deltaX, deltaY) {
                mousewheel_update_size($("img", this), delta);
            });
            mousewheel_update_size(p_img, 0);
        }
        return false;
    });
    //改变图片大小
    function mousewheel_update_size(img, un) {
        var p_img = $(img);
        var w = p_img.width();
        var h = p_img.height();
        if (un > 0) {
            w = w + w * 0.1;
            h = h + h * 0.1;
        }
        else if (un < 0) {
            w = w - w * 0.1;
            h = h - h * 0.1;
        }
        if (un == 0) {
            var all_h = document.body.clientHeight ? document.body.clientHeight : document.documentElement.clientHeight;
            h = p_img.height();
            if(h > all_h * 0.85){
                h = all_h * 0.85;
            }
            p_img.css({
                "margin-top": -(h / 2),
                "height": h
            })
            w = p_img.width();
            p_img.css({
                "margin-left": -(w / 2),
                "width": w
            })
        }
        else {
            p_img.css({
                "margin-left": -(w / 2),
                "margin-top": -(h / 2),
                "width": w,
                "height": h
            })
        }
    }

    //退出图片预览
    $(document).keyup(function (e) {
        var ev = document.all ? window.event : e;
        if (ev.keyCode == 27) {
            $(".max_img_box_parent").remove();
        }
    });


    //用户登录信息
    $rootScope._USERINFO = null;
    //用户菜单信息
    $rootScope._ALLMENU = null;
    //token
    $rootScope.token = null;
    //默认首页
    $rootScope._HOME = null;
    /**
     * 执行用户登录
     * @private
     */
    $rootScope._login = function (param, token, flag) {
        if (param) {
        	var params = {
        			idCard: param.user_name,
        			pwd: param.user_pwd
        	};
        	
            services._login(params).success(function (res) {
            	if((flag == 'stu' && res.msg.role > 2) || flag == 'admin' && res.msg.role < 3) {
            		layer.alert("用户名或密码错误");
            		return;
            	}
                $rootScope._loginToParam(res);
            }).error(function (res) {
	        	layer.alert("登录失败");
	        });
        }
        else if (token) {
            services._login({
                token: token
            }).success(function (res) {
                $rootScope._loginToParam(res);
            });
        }
        else {
            var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
            if (LOGINSTARTPAGENAME) {
                $state.go("enrollParent");
            }
            else {
                $state.go("login");
            }
        }
    }
    $rootScope._loginToParam = function (res) {
        if (res.result == "OK") {
        	$rootScope.curentSel = '';
            $rootScope.token = res.token;
            $rootScope._USERINFO = res.msg;
            $.cookie("LOGINUSERINFO_TOKEN", res.token);
            sessionStorage.setItem("_USERINFO", JSON.stringify(res.msg));
            if(res.msg.username) {
                $rootScope._USERINFO['user_real_name'] = res.msg.username;
            }
            if(res.msg && (res.msg.role || 0 == res.msg.role)) {
            	//1小学，2中学，3学校管理员，4教育局,5超级管理员
            	if(1 == res.msg.role) {
            		$state.go("home");
            	} else if(2 == res.msg.role) {
            		$state.go("home");
            	} else if(3 == res.msg.role) {
            		$state.go("instruct");
            	} else if(4 == res.msg.role) {
            		$state.go("instruct");
            	} else if(5 == res.msg.role) {
            		$state.go("instruct");
            	} else {
            		$state.go("home");
            	}
            }
            /*services._menu().success(function (resMenu) {
                $rootScope._rloadSystemData(res.data, resMenu.data);
                if (!$rootScope.skipPage || $rootScope.skipPage.name == "login" || $rootScope.skipPage.name == "enrollParent" || $rootScope.skipPage.name == "bell.detail") {
                    $rootScope.skipPage = {
                        name: "home"
                    };
                }
                //判断如果没有系统设置权限
                if ($rootScope.skipPage.name == "home" && resMenu.data && resMenu.data.length > 0) {
                    var cfrist = true;
                    $.each(resMenu.data, function (m, mm) {
                        if (mm.res_key == "home") {
                            cfrist = false;
                        }
                    })
                    if (cfrist) {
                        $rootScope.skipPage = {
                            name: resMenu.data[0].res_key
                        };
                    }
                }
                try {
                    $state.go($rootScope.skipPage.name);
                }
                catch (er) {
                    console.log("target err to home")
                    $rootScope.skipPage = {
                        name: "home"
                    };
                    $state.go($rootScope.skipPage.name);
                }
                finally {
                    $("body").removeClass("un-login");
                }
            });*/
        }
        else {
            $("#sysLogin").attr("disabled", false).removeClass("layui-btn-disabled").html("登录");
            layer.alert(res.msg);
            var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
            if (LOGINSTARTPAGENAME) {
                $state.go("enrollParent");
            }
            else {
                $state.go("login");
            }
        }
    }
    /**
     * 注销用户
     */
    $rootScope.sessionOut = function () {
        $window.sessionStorage.removeItem("_USERINFO");
        $window.sessionStorage.removeItem("_ALLMENU");
        $rootScope.sessionReload = null;
        $rootScope._USERINFO = null;
        $rootScope._ALLMENU = null;
        if ($rootScope.skipPage.name != "login" || $rootScope.skipPage.name != "enrollParent" || $rootScope.skipPage.name != "404" || $rootScope.skipPage.name != "unauo") {
            $rootScope.skipPage = $state.current;
            $rootScope.skipPageParam = $stateParams;
            var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
            if (LOGINSTARTPAGENAME) {
                $state.go("enrollParent");
            }
            else {
                $state.go("login");
            }
        }
        else {
            $state.go($rootScope.nowPage);
        }
        $.cookie('LOGINUSERINFO_TOKEN', "");
    }

    /**
     * 装载数据
     * @private
     */
    $rootScope._rloadSystemData = function (userData, menuData) {
        //用户信息
        $rootScope._USERINFO = userData;
        $window.sessionStorage.setItem("_USERINFO", JSON.stringify(userData));
        //获取菜单信息
        $rootScope._ALLMENU = menuData;
        //默认第一个为首页
        menuData && ($rootScope._HOME = menuData[0].res_key);
        $window.sessionStorage.setItem("_ALLMENU", JSON.stringify(menuData));
        //保存token
        $.cookie("LOGINUSERINFO_TOKEN", userData.token);
        $rootScope.token = userData.token;

        //rootScope存储
        $rootScope.sessionReload = {
            userData: userData,
            menuData: menuData,
            tokenArray: {}
        };
        $rootScope.eachToken(menuData);
    }
    //获取权限
    $rootScope.eachToken = function (array) {
        angular.forEach(array, function (item) {
            if (item.res_key)
                $rootScope.sessionReload.tokenArray[item.res_key] = item;
            if (item.children) {
                $rootScope.eachToken(item.children);
            }
        })
    }
    //验证是否有权限
    $rootScope.getBtnToken = function (key) {
        if ($rootScope.sessionReload && $rootScope.sessionReload.tokenArray)
            return $rootScope.sessionReload.tokenArray[key];
        else
            return undefined;
    }
    //左侧显示菜单
    $rootScope.selectTopMenu = null;
    $rootScope.selectFirstMenu = null;
    $rootScope.selectSecondMenu = null;
    /**
     * 判断菜单选中项
     * @private
     */
    $rootScope._covertMenuSelect = function () {
        angular.forEach($rootScope._ALLMENU, function (top) {
            if (top.res_id == $rootScope.showMenu.res_id) {
                $rootScope.selectTopMenu = top;
            }
            else if (top.children && top.res_type == 1) {
                angular.forEach(top.children, function (first) {
                    if (first.res_id == $rootScope.showMenu.res_id) {
                        $rootScope.selectTopMenu = top;
                        $rootScope.selectFirstMenu = first;
                    }
                    else if (first.children && first.res_type == 1) {
                        angular.forEach(first.children, function (second) {
                            if (second.res_id == $rootScope.showMenu.res_id) {
                                $rootScope.selectTopMenu = top;
                                $rootScope.selectFirstMenu = first;
                                $rootScope.selectSecondMenu = second;
                            }
                            if (second.children) {
                                angular.forEach(second.children, function (three) {
                                    if (three.res_id == $rootScope.showMenu.res_id) {
                                        $rootScope.selectTopMenu = top;
                                        $rootScope.selectFirstMenu = first;
                                        $rootScope.selectSecondMenu = second;
                                    }
                                });
                            }
                        })
                    }
                })
            }
        });
    }
    /**
     * 格式化html
     * @param html
     * @returns {*}
     * @private
     */
    $rootScope._trustAsHtml = function (html) {
        return $sce.trustAsHtml(html);
    }
    /**
     * 根据key找到页面
     * @param key
     */
    $rootScope.getPageByKey = function (key, parent) {
        var page = null;

        angular.forEach(parent, function (item) {
            if (key == item.res_key) {

                page = item;
            }
            if (!page && item.children && item.res_type == 1) {
                page = $rootScope.getPageByKey(key, item.children);
            }
        })
        return page;
    }

    /**
     * 退出登录
     */
    $rootScope.loginup = function () {
        layer.confirm("你确定要退出系统吗?", function () {
            $(".parent_view").empty();
            $window.sessionStorage.removeItem("_USERINFO");
            $window.sessionStorage.removeItem("_ALLMENU");
            $rootScope._ALLMENU = null;
            $rootScope._USERINFO = null;
            $rootScope.token = null;
            $.cookie("LOGINUSERINFO_TOKEN", "");
            //登出

            ////services._logup();
            var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
            if (LOGINSTARTPAGENAME) {
                $state.go("enrollParent");
            }
            else {
                $state.go("login");
            }
            layer.closeAll();
        })
    }

    /**
     * 打开表单
     */
    $rootScope.formOpen = function () {
        $(".form_content").removeClass("fadeOutRightBig").removeClass("none").addClass("fadeInRightBig");
    }
    /**
     * 关闭表单
     */
    $rootScope.formClose = function () {
        $(".form_content").removeClass("fadeInRightBig").addClass("fadeOutRightBig");
    }


    $(function () {
        $("#publicMenu").mCustomScrollbar({
            theme: "minimal-dark",
            scrollInertia: 200
        });
    })
    /**
     * 修改密码
     */
    $scope.upPassword = function () {
        layer.open({
            type: 1,
            title: "修改密码",
            area: ["500px", "300px"],
            content: $("#upPassword")
        });
    }
    $scope.updatePassParam = {
        oldpwd: null,
        newpwd: null,
        newpwd_1: null
    }
    /**
     * 确认修改
     */
    $scope.cen_upPassword = function () {
        if (!$scope.updatePassParam.oldpwd) {
            layer.alert("请填写旧密码")
            return false;
        }
        if (!$scope.updatePassParam.newpwd || ($scope.updatePassParam.newpwd != $scope.updatePassParam.newpwd_1)) {
            layer.alert("请正确填写新密码")
            return false;
        }
        $rootScope._USERINFO["oldpwd"] = $scope.updatePassParam["oldpwd"];
        $rootScope._USERINFO["newpwd"] = $scope.updatePassParam["newpwd"];
        $rootScope._USERINFO["newpwd_1"] = $scope.updatePassParam["newpwd_1"];
        services._up_pass($rootScope._USERINFO).success(function (rees) {
            if (rees.code == 0) {
                layer.closeAll();
                layer.msg("密码修改成功,请重新登录!");

                $(".parent_view").empty();
                $window.sessionStorage.removeItem("_USERINFO");
                $window.sessionStorage.removeItem("_ALLMENU");
                $rootScope._ALLMENU = null;
                $rootScope._USERINFO = null;
                $rootScope.token = null;
                $.cookie("LOGINUSERINFO_TOKEN", "");
                //登出
                services._logup();
                var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
                if (LOGINSTARTPAGENAME) {
                    $state.go("enrollParent");
                }
                else {
                    $state.go("login");
                }
                $scope.updatePassParam = {
                    oldpwd: null,
                    newpwd: null,
                    newpwd_1: null
                }
            }
            else {
                layer.msg(rees.message)
            }
        })
    }
});

myApp.run(['$rootScope', '$state', '$window', function ($rootScope, $state, $window) {

	$rootScope.mobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    //开始加载新页面
    $rootScope.$on('$stateChangeStart', function (event, toState, fromState, fromParams) {
    	
    	/*var mobileMeta = document.getElementById("mobilePort");
    	if(mobileMeta) {
    		//document.head.removeChild(mobileMeta);
    		mobileMeta.content = "width=device-width,initial-scale=0 user-scalable=1";
    	}*/
    	if(!$rootScope.token && $.cookie("LOGINUSERINFO_TOKEN")) {
    		$rootScope.token = $.cookie("LOGINUSERINFO_TOKEN");
    	}
    	if(!$rootScope._USERINFO && sessionStorage.getItem("_USERINFO")) {
    		$rootScope._USERINFO = JSON.parse(sessionStorage.getItem("_USERINFO"));
    	}
        if (toState.name == "registers" || toState.name == "login" || toState.name == "enrollParent" || toState.name == "404" || toState.name == "unauo" || toState.name == "bell.detail") {
            $("body").addClass("un-login");
        }
        /*else if ($rootScope._USERINFO == null || !$rootScope._ALLMENU) {
            $("body").removeClass("un-login");
            $rootScope.skipPage = toState;
            var _USERINFO = $window.sessionStorage.getItem("_USERINFO");
            var _ALLMENU = $window.sessionStorage.getItem("_ALLMENU");
            var _userinfo = null, _allmenu = null;
            var token = $.cookie("LOGINUSERINFO_TOKEN");
            if (token) {
                $rootScope.token = token;
            }
            if (_USERINFO && _USERINFO != "" && _ALLMENU && _ALLMENU != "") {
                _userinfo = eval("(" + _USERINFO + ")");
                _allmenu = eval("(" + _ALLMENU + ")");
                $rootScope._rloadSystemData(_userinfo, _allmenu);
            }
            else if (token && token != "") {
                setTimeout(function () {
                    $rootScope._login(null, token);
                },500);
                event.preventDefault();
            }
            else {
                if ($rootScope.skipPage.name != "bell.detail") {
                    var LOGINSTARTPAGENAME = $.cookie("LOGINSTARTPAGENAME");
                    if (LOGINSTARTPAGENAME) {
                        $state.go("enrollParent");
                    }
                    else {
                        $state.go("login");
                    }
                    event.preventDefault();
                }
            }
        }*/
        else {
            $rootScope.skipPage = toState;
            $("body").removeClass("un-login");
        }
        /**
         * 循环处理layui加载情况
         */
        function unlayui() {
            if (!element || !layer || !form || !laypage) {
                setTimeout(unlayui, 500);
            }
            else if (!element_init) {
                element_init = true;
                $(".layui-nav-bar").remove();
                setTimeout(function () {
                    element.init();
                }, 500);
            }
            else if (toState.name == "registers" || toState.name == "login" || toState.name == "enrollParent" || toState.name == "404" || toState.name == "unauo") {
                element_init = false;
            }
        }

        unlayui();

        if ($rootScope._ALLMENU && $rootScope._ALLMENU.length > 0) {
            //设置默认选择第一个模块
            if (toState.name != "registers" && toState.name != "404" && toState.name != "login" && toState.name != "enrollParent") {
                $rootScope.selectTopMenu = null;
                $rootScope.selectFirstMenu = null;
                $rootScope.selectSecondMenu = null;
                $rootScope.showMenu = $rootScope.getPageByKey(toState.name, $rootScope._ALLMENU);
                //清除所有选中
                if ($rootScope.showMenu)
                    $rootScope._covertMenuSelect();
            }
        }
        if ($rootScope.sessionReload) {
            //权限判断
            var pName = $rootScope.sessionReload.tokenArray[toState.name];
            if (!pName && toState.name != "login" && toState.name != "enrollParent" && toState.name != "404" && toState.name != "unauo") {
                $state.go("unauo");
                event.preventDefault();
            }
        }
    });
    //页面加载成功
    $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {
        if (toState.name == "registers" || toState.name == "login" || toState.name == "enrollParent" || toState.name == "404" || toState.name == "unauo") {
            $(".center_main_content").addClass("login_main_content");
        }
        else {
            $(".center_main_content").removeClass("login_main_content");
        }
        if(sessionStorage.getItem("_USERINFO") && JSON.parse(sessionStorage.getItem("_USERINFO")).username) {
            $rootScope._USERINFO['user_real_name'] = JSON.parse(sessionStorage.getItem("_USERINFO")).username;
        }
        var hidInterval = setInterval(function() {
        	if($('#hideBtn')[0]) {
        	    $('#hideBtn').unbind("click").on('click', function() {
        			if(!$('#main-layout').hasClass('hide-side')) {
        				$('#main-layout').addClass('hide-side');
        			} else {
        				$('#main-layout').removeClass('hide-side');
        			}
        		});
        	    clearInterval(hidInterval);
        	}
        }, 1000);
        var mskInterval = setInterval(function() {
        	if($('.main-mask')[0]) {
        	    $('.main-mask').unbind("click").on('click', function() {
        	    	$('#main-layout').removeClass('hide-side');
        		});
        	    clearInterval(mskInterval);
        	}
        }, 1000);
    });
    //页面加载失败
    $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {

    });
}]);

myApp.config(function ($stateProvider, $urlRouterProvider, $controllerProvider, $compileProvider, $filterProvider, $provide) {
    myApp.controller = $controllerProvider.register;
    myApp.directive = $compileProvider.directive;
    myApp.filter = $filterProvider.register;
    myApp.factory = $provide.factory;
    myApp.service = $provide.service;
    myApp.constant = $provide.constant;

    //注册
    //$urlRouterProvider.when('register', '/register');
    //默认页面
    $urlRouterProvider.when('', '/enrollParent');
    //公告-默认
    $urlRouterProvider.when('/bell', '/bell/detail/0');
    //不规则页面
    $urlRouterProvider.otherwise('/404');
    
    //注册
    $stateProvider.state("registers", {
        url: "/registers",
        //templateUrl: "/pages/login/page.html",
        templateUrl: "/pages/register/register.html",
        controller: 'registerController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/register/register.css', '/pages/register/register.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    
    //查看审核状态
    $stateProvider.state("status", {
        url: "/status",
        //templateUrl: "/pages/login/page.html",
        templateUrl: "/pages/register/registerStatus/registerStatus.html",
        controller: 'registerStatusController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/register/register.css', '/pages/register/registerStatus/registerStatus.js'])
            }]
        }
    });
    
  //查看审核状态
    $stateProvider.state("status_mobile", {
        url: "/status_mobile",
        //templateUrl: "/pages/login/page.html",
        templateUrl: "/pages/register/registerStatus/registerStatus_mobile.html",
        controller: 'registerStatusController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/register/register.css', '/pages/register/registerStatus/registerStatus.js'])
            }]
        }
    });
    
    //查看申请资料
    $stateProvider.state("registerMsg", {
        url: "/registerMsg",
        //templateUrl: "/pages/login/page.html",
        /*templateUrl: "/pages/register/register.html",
        controller: 'registerController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/register/register.css', '/pages/register/register.js', '/plugins/cityData/city.data-3.js'])
            }]
        }*/
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    
    //通知书打印
    $stateProvider.state("notifier", {
        url: "/notifier",
        //templateUrl: "/pages/login/page.html",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });

    //登录(管理员)
    $stateProvider.state("login", {
        url: "/login",
        //templateUrl: "/pages/login/page.html",
        templateUrl: "/pages/login/page.html",
        controller: 'loginController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/login/page.css', '/pages/login/page.js'])
            }]
        }
    });
    //登录(家长)
    $stateProvider.state("enrollParent", {
        url: "/enrollParent",
        //templateUrl: "/pages/enrollParent/page.html",
        templateUrl: "/pages/enrollParent/page.html",
        controller: 'enrollParentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/enrollParent/page.css', '/pages/enrollParent/page.js'])
            }]
        }
    });

    //首页
    $stateProvider.state("home", {
        url: "/home",
        //templateUrl: "/pages/home/page.html",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    
    //管理员页面（校管理员，教育局）
    $stateProvider.state("instruct", {
        url: "/instruct",
        //templateUrl: "/pages/home/page.html",
        templateUrl: "/pages/instructor/instructor.html",
        controller: 'instructorController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/instructor/instructor.css', '/pages/instructor/instructor.js'])
            }]
        }
    });
    //统计分析
    /*$stateProvider.state("statistics", {
        url: "/statistics",
        //templateUrl: "/pages/home/page.html",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //学生来源情况统计
    $stateProvider.state("studentSource", {
        url: "/studentSource",
        //templateUrl: "/pages/statistics/studentSource/page.html",
        templateUrl: "/pages/statistics/studentSource/page.html",
        controller: 'studentSourceController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/studentSource/page.css', '/pages/statistics/studentSource/page.js'])
            }]
        }
    });
    // 新生来源情况统计
    $stateProvider.state("newStudentSource", {
        url: "/newStudentSource",
        //templateUrl: "/pages/statistics/newStudentSource/page.html",
        templateUrl: "/pages/statistics/newStudentSource/page.html",
        controller: 'newStudentSourceController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/newStudentSource/page.css', '/pages/statistics/newStudentSource/page.js'])
            }]
        }
    });
    //小学特殊学生统计
    $stateProvider.state("primarySpecialStudent", {
        url: "/primarySpecialStudent",
        //templateUrl: "/pages/statistics/primarySpecialStudent/page.html",
        templateUrl: "/pages/statistics/primarySpecialStudent/page.html",
        controller: 'primarySpecialStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/primarySpecialStudent/page.css', '/pages/statistics/primarySpecialStudent/page.js'])
            }]
        }
    });
    //小学特殊学生统计(教育局)
    $stateProvider.state("primarySpecialStudentBureau", {
        url: "/primarySpecialStudentBureau",
        //templateUrl: "/pages/statistics/primarySpecialStudentBureau/page.html",
        templateUrl: "/pages/statistics/primarySpecialStudentBureau/page.html",
        controller: 'primarySpecialStudentBureauController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/primarySpecialStudentBureau/page.css', '/pages/statistics/primarySpecialStudentBureau/page.js'])
            }]
        }
    });
    //小学毕业生流向统计
    $stateProvider.state("primaryFlow", {
        url: "/primaryFlow",
        templateUrl: "/pages/statistics/primaryFlow/page.html",
        controller: 'primaryFlowController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/primaryFlow/page.css', '/pages/statistics/primaryFlow/page.js', '/plugins/chart/echarts.min.js'])
            }]
        }
    });
    //小学毕业生流向统计
    $stateProvider.state("primaryFlowBureau", {
        url: "/primaryFlowBureau",
        templateUrl: "/pages/statistics/primaryFlowBureau/page.html",
        controller: 'primaryFlowBureauController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/primaryFlowBureau/page.css', '/pages/statistics/primaryFlowBureau/page.js', '/plugins/chart/echarts.min.js'])
            }]
        }
    });
    //毕业生录取情况统计
    $stateProvider.state("graduateEnroll", {
        url: "/graduateEnroll",
        templateUrl: "/pages/statistics/graduateEnroll/page.html",
        controller: 'graduateEnrollController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/graduateEnroll/page.css', '/pages/statistics/graduateEnroll/page.js'])
            }]
        }
    });
    //特殊学生统计
    $stateProvider.state("specialStudent", {
        url: "/specialStudent",
        templateUrl: "/pages/statistics/specialStudent/page.html",
        controller: 'specialStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/specialStudent/page.css', '/pages/statistics/specialStudent/page.js'])
            }]
        }
    });

    //小学学位申报情况统计
    $stateProvider.state("newStudentCount", {
        url: "/newStudentCount",
        templateUrl: "/pages/statistics/newStudentCount/page.html",
        controller: 'newStudentCountController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/statistics/newStudentCount/page.css', '/pages/statistics/newStudentCount/page.js'])
            }]
        }
    });

    //资源中心
    $stateProvider.state("resCenter", {
        url: "/resCenter",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //毕业生学籍导入（1）
    $stateProvider.state("graduateImport", {
        url: "/graduateImport",
        templateUrl: "/pages/primaryJunior/graduateImport/page.html",
        controller: 'graduateImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/primaryJunior/graduateImport/page.css',
                    '/pages/primaryJunior/graduateImport/page.js'
                ])
            }]
        }
    });
    //毕业生学籍导入（2）
    $stateProvider.state("graduateImport.import", {
        url: "/import/:id",
        templateUrl: "/pages/primaryJunior/graduateImport/import.html",
        controller: 'graduateImportImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/primaryJunior/graduateImport/import.css',
                    '/pages/primaryJunior/graduateImport/import.js'
                ])
            }]
        }
    });
    //毕业生学籍信息
    $stateProvider.state("studentRecords", {
        url: "/studentRecords",
        templateUrl: "/pages/primaryJunior/studentRecords/page.html",
        controller: 'studentRecordsController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/studentRecords/page.css', '/pages/primaryJunior/studentRecords/page.js'])
            }]
        }
    });
    //小升初
    $stateProvider.state("primaryJunior", {
        url: "/primaryJunior",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //短信群发(栏)
    $stateProvider.state("messageGroupSend", {
        url: "/messageGroupSend",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //短信群发
    $stateProvider.state("messageSend", {
        url: "/messageSend",
        templateUrl: "/pages/messageGroupSend/messageSend/page.html",
        controller: 'messageSendController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/messageGroupSend/messageSend/page.css', '/pages/messageGroupSend/messageSend/page.js'])
            }]
        }
    });
    //幼儿园
    $stateProvider.state("kindergarten", {
        url: "/kindergarten",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //幼升小
    $stateProvider.state("primary", {
        url: "/primary",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //我的志愿管理(幼儿园)
    $stateProvider.state("ourVolunteerManage", {
        url: "/ourVolunteerManage",
        templateUrl: "/pages/kindergarten/ourVolunteerManage/page.html",
        controller: 'ourVolunteerManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/ourVolunteerManage/page.css', '/pages/kindergarten/ourVolunteerManage/page.js'])
            }]
        }
    });
    //各园招生情况预览
    $stateProvider.state("preGardenEnrollmentPreview", {
        url: "/preGardenEnrollmentPreview",
        templateUrl: "/pages/kindergarten/preGardenEnrollmentPreview/page.html",
        controller: 'preGardenEnrollmentPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preGardenEnrollmentPreview/page.css', '/pages/kindergarten/preGardenEnrollmentPreview/page.js'])
            }]
        }
    });
    //多校划片招生(幼儿园,教育局)
    $stateProvider.state("preManySchoolScribing", {
        url: "/preManySchoolScribing",
        templateUrl: "/pages/kindergarten/preManySchoolScribing/page.html",
        controller: 'preManySchoolScribingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preManySchoolScribing/page.css', '/pages/kindergarten/preManySchoolScribing/page.js'])
            }]
        }
    });
    //划片管理(幼儿园,教育局)
    $stateProvider.state("preManySchoolScribingImport", {
        url: "/preManySchoolScribingImport",
        templateUrl: "/pages/kindergarten/preManySchoolScribingImport/page.html",
        controller: 'preManySchoolScribingImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preManySchoolScribingImport/page.css', '/pages/kindergarten/preManySchoolScribingImport/page.js'])
            }]
        }
    });

    //片区对应管理(幼儿园,教育局)
    $stateProvider.state("preDegreeFinalAudit", {
        url: "/preDegreeFinalAudit",
        templateUrl: "/pages/kindergarten/preDegreeFinalAudit/page.html",
        controller: 'preDegreeFinalAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preDegreeFinalAudit/page.css', '/pages/kindergarten/preDegreeFinalAudit/page.js'])
            }]
        }
    });
    //各园招生情况(幼儿园,教育局)
    $stateProvider.state("preEachAreaEnroll", {
        url: "/preEachAreaEnroll",
        templateUrl: "/pages/kindergarten/preEachAreaEnroll/page.html",
        controller: 'preEachAreaEnrollController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preEachAreaEnroll/page.css', '/pages/kindergarten/preEachAreaEnroll/page.js'])
            }]
        }
    });
    //多校划片管理(幼儿园,)
    $stateProvider.state("preManySchoolStudent", {
        url: "/preManySchoolStudent",
        templateUrl: "/pages/kindergarten/preManySchoolStudent/page.html",
        controller: 'preManySchoolStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preManySchoolStudent/page.css', '/pages/kindergarten/preManySchoolStudent/page.js'])
            }]
        }
    });
    //片区对应管理(幼儿园,)
    $stateProvider.state("preExamination", {
        url: "/preExamination",
        templateUrl: "/pages/kindergarten/preExamination/page.html",
        controller: 'preExaminationController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preExamination/page.css', '/pages/kindergarten/preExamination/page.js'])
            }]
        }
    });

    //资格审查(幼儿园,)
    $stateProvider.state("preAreaManage", {
        url: "/preAreaManage",
        templateUrl: "/pages/kindergarten/preAreaManage/page.html",
        controller: 'preAreaManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preAreaManage/page.css', '/pages/kindergarten/preAreaManage/page.js'])
            }]
        }
    });

    //申报学位(幼儿园)
    $stateProvider.state("preDeclarationDegree", {
        url: "/preDeclarationDegree",
        templateUrl: "/pages/kindergarten/preDeclarationDegree/page.html",
        controller: 'preDeclarationDegreeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preDeclarationDegree/page.css', '/pages/kindergarten/preDeclarationDegree/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //申请学位(新)(幼儿园)
    $stateProvider.state("preDeclareDegree", {
        url: "/preDeclareDegree",
        templateUrl: "/pages/kindergarten/preDeclareDegree/page.html",
        controller: 'preDeclareDegreeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preDeclareDegree/page.css', '/pages/kindergarten/preDeclareDegree/page.js'])
            }]
        }
    });
    //幼儿园招生时间设置幼儿园)
    $stateProvider.state("preEnrollmentTimeSetting", {
        url: "/preEnrollmentTimeSetting",
        templateUrl: "/pages/kindergarten/preEnrollmentTimeSetting/page.html",
        controller: 'preEnrollmentTimeSettingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preEnrollmentTimeSetting/page.css', '/pages/kindergarten/preEnrollmentTimeSetting/page.js'])
            }]
        }
    });
    //时间节点设置（幼儿园)
    $stateProvider.state("preTimeNode", {
        url: "/preTimeNode",
        templateUrl: "/pages/kindergarten/preTimeNode/page.html",
        controller: 'preTimeNodeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preTimeNode/page.css', '/pages/kindergarten/preTimeNode/page.js'])
            }]
        }
    });


    //招生计划设置(幼儿园)
    $stateProvider.state("preScope", {
        url: "/preScope",
        templateUrl: "/pages/kindergarten/preScope/page.html",
        controller: 'preScopeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preScope/page.css', '/pages/kindergarten/preScope/page.js'])
            }]
        }
    });
    //(新)招生报名时间设置(幼儿园)
    $stateProvider.state("preNewEnrollmentTimeSetting", {
        url: "/preNewEnrollmentTimeSetting",
        templateUrl: "/pages/kindergarten/preNewEnrollmentTimeSetting/page.html",
        controller: 'preNewEnrollmentTimeSettingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preNewEnrollmentTimeSetting/page.css', '/pages/kindergarten/preNewEnrollmentTimeSetting/page.js'])
            }]
        }
    });

    //新生报到确认(幼儿园)
    $stateProvider.state("preNewStudentConfirm", {
        url: "/preNewStudentConfirm",
        templateUrl: "/pages/kindergarten/preNewStudentConfirm/page.html",
        controller: 'preNewStudentConfirmController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preNewStudentConfirm/page.css', '/pages/kindergarten/preNewStudentConfirm/page.js'])
            }]
        }
    });
    //打印录取通知书(幼儿园，新生报到)
    $stateProvider.state("preNewlyPreview", {
        url: "/preNewlyPreview",
        templateUrl: "/pages/kindergarten/preNewlyPreview/page.html",
        controller: 'preNewlyPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preNewlyPreview/page.css', '/pages/kindergarten/preNewlyPreview/page.js', '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });
    //招生计划预览(幼儿园)
    $stateProvider.state("prePlanPreview", {
        url: "/prePlanPreview",
        templateUrl: "/pages/kindergarten/prePlanPreview/page.html",
        controller: 'prePlanPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/prePlanPreview/page.css', '/pages/kindergarten/prePlanPreview/page.js'])
            }]
        }
    });
    //家长可填报志愿数设置
    $stateProvider.state("preApplicationSettings", {
        url: "/preApplicationSettings",
        templateUrl: "/pages/kindergarten/preApplicationSettings/page.html",
        controller: 'preApplicationSettingsController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preApplicationSettings/page.css', '/pages/kindergarten/preApplicationSettings/page.js'])
            }]
        }
    });
    //民办学生信息到入(幼儿园)
    $stateProvider.state("preDegreeImport", {
        url: "/preDegreeImport",
        templateUrl: "/pages/kindergarten/preDegreeImport/page.html",
        controller: 'preDegreeImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preDegreeImport/page.css', '/pages/kindergarten/preDegreeImport/page.js'])
            }]
        }
    });
    //民办学生信息到入二级页面(幼儿园)
    $stateProvider.state("preDegreeImportTwo", {
        url: "/preDegreeImportTwo",
        templateUrl: "/pages/kindergarten/preDegreeImportTwo/page.html",
        controller: 'preDegreeImportTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preDegreeImportTwo/page.css', '/pages/kindergarten/preDegreeImportTwo/page.js'])
            }]
        }
    });
    //新生预览（幼儿园)
    $stateProvider.state("preNewPublicPreview", {
        url: "/preNewPublicPreview",
        templateUrl: "/pages/kindergarten/preNewPublicPreview/page.html",
        controller: 'preNewPublicPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preNewPublicPreview/page.css', '/pages/kindergarten/preNewPublicPreview/page.js'])
            }]
        }
    });
    //拟录取新生预览（幼儿园)
    $stateProvider.state("preAdmissionPreview", {
        url: "/preAdmissionPreview",
        templateUrl: "/pages/kindergarten/preAdmissionPreview/page.html",
        controller: 'preAdmissionPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preAdmissionPreview/page.css', '/pages/kindergarten/preAdmissionPreview/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //录取新生预览（教育局)
    $stateProvider.state("preAdmittdePreview", {
        url: "/preAdmittdePreview",
        templateUrl: "/pages/kindergarten/preAdmittdePreview/page.html",
        controller: 'preAdmittdePreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preAdmittdePreview/page.css', '/pages/kindergarten/preAdmittdePreview/page.js'])
            }]
        }
    });
    //拟录取新生预览（教育局)
    $stateProvider.state("preEnrollmentPreview", {
        url: "/preEnrollmentPreview",
        templateUrl: "/pages/kindergarten/preEnrollmentPreview/page.html",
        controller: 'preEnrollmentPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preEnrollmentPreview/page.css', '/pages/kindergarten/preEnrollmentPreview/page.js'])
            }]
        }
    });
    //打印录取通知书（家长）
    $stateProvider.state("prePrintAdmissionNotice", {
        url: "/prePrintAdmissionNotice",
        templateUrl: "/pages/kindergarten/prePrintAdmissionNotice/page.html",
        controller: 'prePrintAdmissionNoticeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/prePrintAdmissionNotice/page.css', '/pages/kindergarten/prePrintAdmissionNotice/page.js', '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });
    //多校划片审核
    $stateProvider.state("preSchoolAudit", {
        url: "/preSchoolAudit",
        templateUrl: "/pages/kindergarten/preSchoolAudit/page.html",
        controller: 'preSchoolAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preSchoolAudit/page.css', '/pages/kindergarten/preSchoolAudit/page.js'])
            }]
        }
    });
    //信息补录（幼儿园）
    $stateProvider.state("preInformationCollection", {
        url: "/preInformationCollection",
        templateUrl: "/pages/kindergarten/preInformationCollection/page.html",
        controller: 'preInformationCollectionController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/preInformationCollection/page.css', '/pages/kindergarten/preInformationCollection/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //完全匹配的用户，查询
    $stateProvider.state("adminAuditUser", {
        url: "/adminAuditUser",
        templateUrl: "/pages/kindergarten/adminAuditUser/page.html",
        controller: 'adminAuditUserController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/adminAuditUser/page.css', '/pages/kindergarten/adminAuditUser/page.js'])
            }]
        }
    });

    //小升初对口设置
    $stateProvider.state("primary_DKSZ", {
        url: "/primary_DKSZ",
        templateUrl: "/pages/primaryJunior/primary_DKSZ/page.html",
        controller: 'primary_DKSZController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/primary_DKSZ/page.css', '/pages/primaryJunior/primary_DKSZ/page.js'])
            }]
        }
    });
    //预申报学位
    $stateProvider.state("declarationDegree", {
        url: "/declarationDegree",
        templateUrl: "/pages/primaryJunior/declarationDegree/page.html",
        controller: 'declarationDegreeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/declarationDegree/page.css', '/pages/primaryJunior/declarationDegree/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //划片/择校招生
    $stateProvider.state("dicingSelectSchool", {
        url: "/dicingSelectSchool",
        templateUrl: "/pages/primaryJunior/dicingSelectSchool/page.html",
        controller: 'dicingSelectSchoolController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/dicingSelectSchool/page.css', '/pages/primaryJunior/dicingSelectSchool/page.js'])
            }]
        }
    });
    //多校划片招生
    $stateProvider.state("manySchoolScribing", {
        url: "/manySchoolScribing",
        templateUrl: "/pages/primaryJunior/manySchoolScribing/page.html",
        controller: 'manySchoolScribingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/manySchoolScribing/page.css', '/pages/primaryJunior/manySchoolScribing/page.js'])
            }]
        }
    });
    //划片管理
    $stateProvider.state("manySchoolScribingImport", {
        url: "/manySchoolScribingImport",
        templateUrl: "/pages/primaryJunior/manySchoolScribingImport/page.html",
        controller: 'manySchoolScribingImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/manySchoolScribingImport/page.css', '/pages/primaryJunior/manySchoolScribingImport/page.js'])
            }]
        }
    });
    //择校招生管理
    $stateProvider.state("selectSchoolStudent", {
        url: "/selectSchoolStudent",
        templateUrl: "/pages/primaryJunior/selectSchoolStudent/page.html",
        controller: 'selectSchoolStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/selectSchoolStudent/page.css', '/pages/primaryJunior/selectSchoolStudent/page.js'])
            }]
        }
    });
    //择校招生
    $stateProvider.state("selectSchoolManage", {
        url: "/selectSchoolManage",
        templateUrl: "/pages/primaryJunior/selectSchoolManage/page.html",
        controller: 'selectSchoolManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/selectSchoolManage/page.css', '/pages/primaryJunior/selectSchoolManage/page.js'])
            }]
        }
    });
    //区外初中就读管理
    $stateProvider.state("outAttendMessage", {
        url: "/outAttendMessage",
        templateUrl: "/pages/primaryJunior/outAttendMessage/page.html",
        controller: 'outAttendMessageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/outAttendMessage/page.css', '/pages/primaryJunior/outAttendMessage/page.js'])
            }]
        }
    });
    //调剂管理
    $stateProvider.state("adjust_manage", {
        url: "/adjust_manage",
        templateUrl: "/pages/primaryJunior/adjust_manage/page.html",
        controller: 'adjust_manageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/adjust_manage/page.css', '/pages/primaryJunior/adjust_manage/page.js'])
            }]
        }
    });
    //毕业生录取情况预览（教育局）
    $stateProvider.state("graduateAdmissionsPreview", {
        url: "/graduateAdmissionsPreview",
        templateUrl: "/pages/primaryJunior/graduateAdmissionsPreview/page.html",
        controller: 'graduateAdmissionsPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/graduateAdmissionsPreview/page.css', '/pages/primaryJunior/graduateAdmissionsPreview/page.js'])
            }]
        }
    });
    //毕业生录取情况预览（公办学校）
    $stateProvider.state("publicGraduateAdmissionsPreview", {
        url: "/publicGraduateAdmissionsPreview",
        templateUrl: "/pages/primaryJunior/publicGraduateAdmissionsPreview/page.html",
        controller: 'publicGraduateAdmissionsPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/publicGraduateAdmissionsPreview/page.css', '/pages/primaryJunior/publicGraduateAdmissionsPreview/page.js'])
            }]
        }
    });
    //学位申报审核
    $stateProvider.state("degreeApplyAudit", {
        url: "/degreeApplyAudit",
        templateUrl: "/pages/primaryJunior/degreeApplyAudit/page.html",
        controller: 'degreeApplyAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeApplyAudit/page.css', '/pages/primaryJunior/degreeApplyAudit/page.js'])
            }]
        }
    });
    //学位申报面审
    $stateProvider.state("degreeFaceAudit", {
        url: "/degreeFaceAudit",
        templateUrl: "/pages/primaryJunior/degreeFaceAudit/page.html",
        controller: 'degreeFaceAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeFaceAudit/page.css', '/pages/primaryJunior/degreeFaceAudit/page.js'])
            }]
        }
    });
    //学位申报终审
    $stateProvider.state("degreeFinalAudit", {
        url: "/degreeFinalAudit",
        templateUrl: "/pages/primaryJunior/degreeFinalAudit/page.html",
        controller: 'degreeFinalAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeFinalAudit/page.css', '/pages/primaryJunior/degreeFinalAudit/page.js'])
            }]
        }
    });
    //随迁招生名单导入
    $stateProvider.state("TrailingEnrollmentImport", {
        url: "/TrailingEnrollmentImport",
        templateUrl: "/pages/primaryJunior/TrailingEnrollmentImport/page.html",
        controller: 'TrailingEnrollmentImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/TrailingEnrollmentImport/page.css', '/pages/primaryJunior/TrailingEnrollmentImport/page.js'])
            }]
        }
    });
    $stateProvider.state("TrailingEnrollmentImportTwo", {
        url: "/TrailingEnrollmentImportTwo",
        templateUrl: "/pages/primaryJunior/TrailingEnrollmentImportTwo/page.html",
        controller: 'TrailingEnrollmentImportTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/TrailingEnrollmentImportTwo/page.css', '/pages/primaryJunior/TrailingEnrollmentImportTwo/page.js'])
            }]
        }
    });


    //打印录取通知书(小升初)
    $stateProvider.state("parentsAdmissionNotice", {
        url: "/parentsAdmissionNotice",
        templateUrl: "/pages/primaryJunior/parentsAdmissionNotice/page.html",
        controller: 'parentsAdmissionNoticeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/parentsAdmissionNotice/page.css',
                    '/pages/primaryJunior/parentsAdmissionNotice/page.js',
                    '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });
    //设置报到时间（小升初）
    $stateProvider.state("settingSchoolTime", {
        url: "/settingSchoolTime",
        templateUrl: "/pages/primaryJunior/settingSchoolTime/page.html",
        controller: 'settingSchoolTimeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/settingSchoolTime/page.css', '/pages/primaryJunior/settingSchoolTime/page.js',])
            }]
        }
    });
    //我的志愿管理
    $stateProvider.state("volunteerManagement", {
        url: "/volunteerManagement",
        templateUrl: "/pages/primaryJunior/volunteerManagement/page.html",
        controller: 'volunteerManagementController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/volunteerManagement/page.css', '/pages/primaryJunior/volunteerManagement/page.js'])
            }]
        }
    });
    //信息补录
    $stateProvider.state("informationCollection", {
        url: "/informationCollection",
        templateUrl: "/pages/primaryJunior/informationCollection/page.html",
        controller: 'informationCollectionController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/informationCollection/page.css', '/pages/primaryJunior/informationCollection/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //新生预览
    $stateProvider.state("newlyPreview", {
        url: "/newlyPreview",
        templateUrl: "/pages/primaryJunior/newlyPreview/page.html",
        controller: 'newlyPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/newlyPreview/page.css', '/pages/primaryJunior/newlyPreview/page.js', '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });
    //计划范围设置
    $stateProvider.state("scope", {
        url: "/scope",
        templateUrl: "/pages/primaryJunior/scope/page.html",
        controller: 'scopeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/scope/page.css', '/pages/primaryJunior/scope/page.js',])
            }]
        }
    });
    //招生范围设置
    $stateProvider.state("recruitScope", {
        url: "/recruitScope",
        templateUrl: "/pages/primaryJunior/recruitScope/page.html",
        controller: 'recruitScopeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/recruitScope/page.css', '/pages/primaryJunior/recruitScope/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //招生计划预览
    $stateProvider.state("planPreview", {
        url: "/planPreview",
        templateUrl: "/pages/primaryJunior/planPreview/page.html",
        controller: 'planPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/planPreview/page.css', '/pages/primaryJunior/planPreview/page.js'])
            }]
        }
    });
    //毕业生学籍导入
    $stateProvider.state("degreeImport", {
        url: "/degreeImport",
        templateUrl: "/pages/primaryJunior/degreeImport/page.html",
        controller: 'degreeImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeImport/page.css', '/pages/primaryJunior/degreeImport/page.js',])
            }]
        }
    });
    //毕业生学籍导入二级页面
    $stateProvider.state("degreeImportTwo", {
        url: "/degreeImportTwo",
        templateUrl: "/pages/primaryJunior/degreeImportTwo/page.html",
        controller: 'degreeImportTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeImportTwo/page.css', '/pages/primaryJunior/degreeImportTwo/page.js',])
            }]
        }
    });

    //小学招生范围设置
    $stateProvider.state("primaryRecruitScope", {
        url: "/primaryRecruitScope",
        templateUrl: "/pages/primary/primaryRecruitScope/page.html",
        controller: 'primaryRecruitScopeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/primaryRecruitScope/page.css', '/pages/primary/primaryRecruitScope/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //小学学校设置学生报到时间
    $stateProvider.state("smaSettingSchoolTime", {
        url: "/smaSettingSchoolTime",
        templateUrl: "/pages/primary/smaSettingSchoolTime/page.html",
        controller: 'smaSettingSchoolTimeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaSettingSchoolTime/page.css', '/pages/primary/smaSettingSchoolTime/page.js'])
            }]
        }
    });
    //民办初中录入结果
    $stateProvider.state("inputResults", {
        url: "/inputResults",
        templateUrl: "/pages/primaryJunior/inputResults/page.html",
        controller: 'inputResultsController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/inputResults/page.css', '/pages/primaryJunior/inputResults/page.js'])
            }]
        }
    });
    //民办初中录入结果二级页面
    $stateProvider.state("inputResultsTwo", {
        url: "/inputResultsTwo",
        templateUrl: "/pages/primaryJunior/inputResultsTwo/page.html",
        controller: 'inputResultsTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/inputResultsTwo/page.css', '/pages/primaryJunior/inputResultsTwo/page.js'])
            }]
        }
    });
    //招生范围预览
    $stateProvider.state("recruitScopeView", {
        url: "/recruitScopeView",
        templateUrl: "/pages/primaryJunior/recruitScopeView/page.html",
        controller: 'recruitScopeViewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/recruitScopeView/page.css', '/pages/primaryJunior/recruitScopeView/page.js'])
            }]
        }
    });
    //小升初注册的用户
    $stateProvider.state("juniorUser", {
        url: "/juniorUser",
        templateUrl: "/pages/primaryJunior/juniorUser/page.html",
        controller: 'juniorUserController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/juniorUser/page.css', '/pages/primaryJunior/juniorUser/page.js'])
            }]
        }
    });
    //幼儿园注册的用户
    $stateProvider.state("kindergartenUser", {
        url: "/kindergartenUser",
        templateUrl: "/pages/kindergarten/kindergartenUser/page.html",
        controller: 'kindergartenUserController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/kindergarten/kindergartenUser/page.css', '/pages/kindergarten/kindergartenUser/page.js'])
            }]
        }
    });

    //小升初择校招生管理 --教育局管理员菜单
    $stateProvider.state("schoolStudentManager", {
        url: "/schoolStudentManager",
        templateUrl: "/pages/primaryJunior/schoolStudentManager/page.html",
        controller: 'schoolStudentManagerController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/schoolStudentManager/page.css', '/pages/primaryJunior/schoolStudentManager/page.js'])
            }]
        }
    });

    //小升初多校划片管理 --教育局管理员菜单
    $stateProvider.state("manySchoolStudent", {
        url: "/manySchoolStudent",
        templateUrl: "/pages/primaryJunior/manySchoolStudent/page.html",
        controller: 'manySchoolStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/manySchoolStudent/page.css', '/pages/primaryJunior/manySchoolStudent/page.js'])
            }]
        }
    });

    //小升初跨区交换审核 --教育局管理员菜单
    $stateProvider.state("degreeRegionalAudit", {
        url: "/degreeRegionalAudit",
        templateUrl: "/pages/primaryJunior/degreeRegionalAudit/page.html",
        controller: 'degreeRegionalAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/degreeRegionalAudit/page.css', '/pages/primaryJunior/degreeRegionalAudit/page.js'])
            }]
        }
    });
    //拟录取新生预览（教育局）
    $stateProvider.state("enrollmentPreview", {
        url: "/enrollmentPreview",
        templateUrl: "/pages/primaryJunior/enrollmentPreview/page.html",
        controller: 'enrollmentPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/enrollmentPreview/page.css', '/pages/primaryJunior/enrollmentPreview/page.js'])
            }]
        }
    });
    //拟录取新生预览（公办）
    $stateProvider.state("businessPreview", {
        url: "/businessPreview",
        templateUrl: "/pages/primaryJunior/businessPreview/page.html",
        controller: 'businessPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/businessPreview/page.css', '/pages/primaryJunior/businessPreview/page.js'])
            }]
        }
    });
    //新生预览（公办）
    $stateProvider.state("newPublicPreview", {
        url: "/newPublicPreview",
        templateUrl: "/pages/primaryJunior/newPublicPreview/page.html",
        controller: 'newPublicPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/newPublicPreview/page.css', '/pages/primaryJunior/newPublicPreview/page.js'])
            }]
        }
    });


    //录取新生预览（教育局）
    $stateProvider.state("admittdePreview", {
        url: "/admittdePreview",
        templateUrl: "/pages/primaryJunior/admittdePreview/page.html",
        controller: 'admittdePreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/admittdePreview/page.css', '/pages/primaryJunior/admittdePreview/page.js'])
            }]
        }
    });
    //新生报到确认（公办初中）
    $stateProvider.state("newStudentConfirm", {
        url: "/newStudentConfirm",
        templateUrl: "/pages/primaryJunior/newStudentConfirm/page.html",
        controller: 'newStudentConfirmController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/newStudentConfirm/page.css', '/pages/primaryJunior/newStudentConfirm/page.js'])
            }]
        }
    });

    //导入班级信息（学生列表）
    $stateProvider.state("studentClassInfo", {
        url: "/studentClassInfo",
        templateUrl: "/pages/primaryJunior/studentClassInfo/page.html",
        controller: 'studentClassInfoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/studentClassInfo/page.css', '/pages/primaryJunior/studentClassInfo/page.js'])
            }]
        }
    });
    //导入班级信息（导入文件列表）
    $stateProvider.state("studentClassImport", {
        url: "/studentClassImport",
        templateUrl: "/pages/primaryJunior/studentClassImport/page.html",
        controller: 'studentClassImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/studentClassImport/page.css', '/pages/primaryJunior/studentClassImport/page.js'])
            }]
        }
    });
//多校划片管理(教育局,幼升小)
    $stateProvider.state("smaSchoolStudent", {
        url: "/smaSchoolStudent",
        templateUrl: "/pages/primary/smaSchoolStudent/page.html",
        controller: 'smaSchoolStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaSchoolStudent/page.css', '/pages/primary/smaSchoolStudent/page.js'])
            }]
        }
    });
    //片区对应管理(教育局,幼升小)
    $stateProvider.state("smaAreaManage", {
        url: "/smaAreaManage",
        templateUrl: "/pages/primary/smaAreaManage/page.html",
        controller: 'smaAreaManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaAreaManage/page.css', '/pages/primary/smaAreaManage/page.js'])
            }]
        }
    });
    //划片招生设置(教育局,幼升小)
    $stateProvider.state("smaSelectSchool", {
        url: "/smaSelectSchool",
        templateUrl: "/pages/primary/smaSelectSchool/page.html",
        controller: 'smaSelectSchoolController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaSelectSchool/page.css', '/pages/primary/smaSelectSchool/page.js'])
            }]
        }
    });
    //时间节点设置(幼升小,教育局,系统时间节点控制)
    $stateProvider.state("smaTimeNode", {
        url: "/smaTimeNode",
        templateUrl: "/pages/primary/smaTimeNode/page.html",
        controller: 'smaTimeNodeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaTimeNode/page.css', '/pages/primary/smaTimeNode/page.js'])
            }]
        }
    });
    //多校划片管理(幼升小,招生管理)
    $stateProvider.state("smaManySchoolStudent", {
        url: "/smaManySchoolStudent",
        templateUrl: "/pages/primary/smaManySchoolStudent/page.html",
        controller: 'smaManySchoolStudentController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaManySchoolStudent/page.css', '/pages/primary/smaManySchoolStudent/page.js'])
            }]
        }
    });
    //片区对应网审(幼升小,公办小学,招生管理)
    $stateProvider.state("smaDegreeApplyAudit", {
        url: "/smaDegreeApplyAudit",
        templateUrl: "/pages/primary/smaDegreeApplyAudit/page.html",
        controller: 'smaDegreeApplyAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaDegreeApplyAudit/page.css', '/pages/primary/smaDegreeApplyAudit/page.js'])
            }]
        }
    });
    //片区对应面审(幼升小,公办小学,招生管理)
    $stateProvider.state("smaDegreeFaceAudit", {
        url: "/smaDegreeFaceAudit",
        templateUrl: "/pages/primary/smaDegreeFaceAudit/page.html",
        controller: 'smaDegreeFaceAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaDegreeFaceAudit/page.css', '/pages/primary/smaDegreeFaceAudit/page.js'])
            }]
        }
    });
    //注册用户管理幼升小
    $stateProvider.state("smaJuniorUser", {
        url: "/smaJuniorUser",
        templateUrl: "/pages/primary/smaJuniorUser/page.html",
        controller: 'smaJuniorUserController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaJuniorUser/page.css', '/pages/primary/smaJuniorUser/page.js'])
            }]
        }
    });
    //终端配置
    $stateProvider.state("terminal", {
        url: "/terminal",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });

    //终端配置
    $stateProvider.state("member", {
        url: "/member",
        templateUrl: "/pages/home/page.html",
        controller: 'homeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/home/page.css', '/pages/home/page.js'])
            }]
        }
    });
    //小学页面配置
    //家长—我的志愿管理
    $stateProvider.state("smaVolunteerManagement", {
        url: "/smaVolunteerManagement",
        templateUrl: "/pages/primary/smaVolunteerManagement/page.html",
        controller: 'smaVolunteerManagementController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaVolunteerManagement/page.css', '/pages/primary/smaVolunteerManagement/page.js'])
            }]
        }
    })
    //幼升小第三类招生设置
    $stateProvider.state("youngUpSmaSeting", {
        url: "/youngUpSmaSeting",
        templateUrl: "/pages/primary/	youngUpSmaSeting/page.html",
        controller: 'youngUpSmaSetingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/youngUpSmaSeting/page.css', '/pages/primary/youngUpSmaSeting/page.js'])
            }]
        }
    })
    //小升初第三类招生设置
    $stateProvider.state("smaUpJuniorSeting", {
        url: "/smaUpJuniorSeting",
        templateUrl: "/pages/primaryJunior/smaUpJuniorSeting/page.html",
        controller: 'smaUpJuniorSetingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/smaUpJuniorSeting/page.css', '/pages/primaryJunior/smaUpJuniorSeting/page.js'])
            }]
        }
    })
    //招生管理-录入多校划片名单（一级）
    $stateProvider.state("smaManySchoolScribing", {
        url: "/smaManySchoolScribing",
        templateUrl: "/pages/primary/smaManySchoolScribing/page.html",
        controller: 'smaManySchoolScribingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaManySchoolScribing/page.css', '/pages/primary/smaManySchoolScribing/page.js'])
            }]
        }
    })
    //招生管理-录入多校划片名单（二级）
    $stateProvider.state("smaManySchoolScribingTwo", {
        url: "/smaManySchoolScribingTwo",
        templateUrl: "/pages/primary/smaManySchoolScribingTwo/page.html",
        controller: 'smaManySchoolScribingTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaManySchoolScribingTwo/page.css', '/pages/primary/smaManySchoolScribingTwo/page.js'])
            }]
        }
    })
    //计划范围管理-招生计划设置
    $stateProvider.state("smaScope", {
        url: "/smaScope",
        templateUrl: "/pages/primary/smaScope/page.html",
        controller: 'smaScopeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaScope/page.css', '/pages/primary/smaScope/page.js'])
            }]
        }
    });
    //计划范围预览-招生计划预览
    $stateProvider.state("smaPlanPreview", {
        url: "/smaPlanPreview",
        templateUrl: "/pages/primary/smaPlanPreview/page.html",
        controller: 'smaPlanPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaPlanPreview/page.css', '/pages/primary/smaPlanPreview/page.js'])
            }]
        }
    })
    //招生情况预览-拟录取新生预览（教育局）
    $stateProvider.state("smaEnrollmentPreview", {
        url: "/smaEnrollmentPreview",
        templateUrl: "/pages/primary/smaEnrollmentPreview/page.html",
        controller: 'smaEnrollmentPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaEnrollmentPreview/page.css', '/pages/primary/smaEnrollmentPreview/page.js'])
            }]
        }
    })
    //招生情况预览-录取新生预览（教育局）
    $stateProvider.state("smaAdmittdePreview", {
        url: "/smaAdmittdePreview",
        templateUrl: "/pages/primary/smaAdmittdePreview/page.html",
        controller: 'smaAdmittdePreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaAdmittdePreview/page.css', '/pages/primary/smaAdmittdePreview/page.js'])
            }]
        }
    })
    //新生预览——拟录取新生预览（公办学校）
    $stateProvider.state("smaAdmissionPreview", {
        url: "/smaAdmissionPreview",
        templateUrl: "/pages/primary/smaAdmissionPreview/page.html",
        controller: 'smaAdmissionPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaAdmissionPreview/page.css', '/pages/primary/smaAdmissionPreview/page.js'])
            }]
        }
    })
    //新生预览——新生预览（公办）
    $stateProvider.state("smaNewPublicPreview", {
        url: "/smaNewPublicPreview",
        templateUrl: "/pages/primary/smaNewPublicPreview/page.html",
        controller: 'smaNewPublicPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaNewPublicPreview/page.css', '/pages/primary/smaNewPublicPreview/page.js'])
            }]
        }
    })
    //新生报到——新生报到确认
    $stateProvider.state("smaNewStudentConfirm", {
        url: "/smaNewStudentConfirm",
        templateUrl: "/pages/primary/smaNewStudentConfirm/page.html",
        controller: 'smaNewStudentConfirmController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaNewStudentConfirm/page.css', '/pages/primary/smaNewStudentConfirm/page.js'])
            }]
        }
    })
    //新生报到-导入班级信息
    $stateProvider.state("smaDegreeImport", {
        url: "/smaDegreeImport",
        templateUrl: "/pages/primary/smaDegreeImport/page.html",
        controller: 'smaDegreeImportController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaDegreeImport/page.css', '/pages/primary/smaDegreeImport/page.js'])
            }]
        }
    })
    //新生报到-导入班级信息二级
    $stateProvider.state("smaDegreeImportTwo", {
        url: "/smaDegreeImportTwo",
        templateUrl: "/pages/primary/smaDegreeImportTwo/page.html",
        controller: 'smaDegreeImportTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaDegreeImportTwo/page.css', '/pages/primary/smaDegreeImportTwo/page.js'])
            }]
        }
    })
    //计划范围预览——招生范围预览
    $stateProvider.state("smaRecruitScopeView", {
        url: "/smaRecruitScopeView",
        templateUrl: "/pages/primary/smaRecruitScopeView/page.html",
        controller: 'smaRecruitScopeViewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaRecruitScopeView/page.css', '/pages/primary/smaRecruitScopeView/page.js'])
            }]
        }
    })
    //民办小学——招生结果录入
    $stateProvider.state("smaInputResults", {
        url: "/smaInputResults",
        templateUrl: "/pages/primary/smaInputResults/page.html",
        controller: 'smaInputResultsController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaInputResults/page.css', '/pages/primary/smaInputResults/page.js'])
            }]
        }
    })
    //民办小学——招生结果录入（二级）
    $stateProvider.state("smaInputResultsTwo", {
        url: "/smaInputResultsTwo",
        templateUrl: "/pages/primary/smaInputResultsTwo/page.html",
        controller: 'smaInputResultsTwoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaInputResultsTwo/page.css', '/pages/primary/smaInputResultsTwo/page.js'])
            }]
        }
    })
    //404
    $stateProvider.state("404", {
        url: "/404",
        templateUrl: "/pages/404/page.html",
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/404/page.css'])
            }]
        }
    });
    //没有权限
    $stateProvider.state("unauo", {
        url: "/unauo",
        templateUrl: "/pages/unauo/page.html",
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/unauo/page.css'])
            }]
        }
    });
    //资源管理
    $stateProvider.state("resource", {
        url: "/resource",
        templateUrl: "/pages/sysManage/resource/page.html",
        controller: 'resourceController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/resource/page.css', '/pages/sysManage/resource/page.js'])
            }]
        }
    });
    //用户管理
    $stateProvider.state("user", {
        url: "/user",
        templateUrl: "/pages/sysManage/user/page.html",
        controller: 'userController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/user/page.css', '/pages/sysManage/user/page.js'])
            }]
        }
    });
    //时间节点设置
    $stateProvider.state("time_Node", {
        url: "/time_Node",
        templateUrl: "/pages/primaryJunior/time_Node/page.html",
        controller: 'time_NodeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/time_Node/page.css', '/pages/primaryJunior/time_Node/page.js'])
            }]
        }
    });
    //区外招生设置
    $stateProvider.state("areaRecruitSeting", {
        url: "/areaRecruitSeting",
        templateUrl: "/pages/primaryJunior/areaRecruitSeting/page.html",
        controller: 'areaRecruitSetingController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/areaRecruitSeting/page.css', '/pages/primaryJunior/areaRecruitSeting/page.js'])
            }]
        }
    });
    //角色管理
    $stateProvider.state("role", {
        url: "/role",
        templateUrl: "/pages/sysManage/role/page.html",
        controller: 'roleController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/role/page.css', '/pages/sysManage/role/page.js'])
            }]
        }
    });
    //组织管理
    $stateProvider.state("org", {
        url: "/org",
        templateUrl: "/pages/sysManage/org/page.html",
        controller: 'orgController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/org/page.css', '/pages/sysManage/org/page.js'])
            }]
        }
    });
    //机构管理
    $stateProvider.state("outfit", {
        url: "/outfit",
        templateUrl: "/pages/sysManage/outfit/page.html",
        controller: 'outfitController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/outfit/page.css', '/pages/sysManage/outfit/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //项目管理
    $stateProvider.state("project", {
        url: "/project",
        templateUrl: "/pages/sysManage/project/page.html",
        controller: 'projectController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/project/page.css', '/pages/sysManage/project/page.js'])
            }]
        }
    });
    //权限管理
    $stateProvider.state("authority", {
        url: "/authority",
        templateUrl: "/pages/sysManage/authority/page.html",
        controller: 'authorityController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/sysManage/authority/page.css', '/pages/sysManage/authority/page.js'])
            }]
        }
    });
    //操作日志
    $stateProvider.state("actionLog", {
        url: "/actionLog",
        templateUrl: "/pages/logManage/actionLog/page.html",
        controller: 'actionLogController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/logManage/actionLog/page.css', '/pages/logManage/actionLog/page.js'])
            }]
        }
    });
    //系统日志
    $stateProvider.state("sysLog", {
        url: "/sysLog",
        templateUrl: "/pages/logManage/sysLog/page.html",
        controller: 'sysLogController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/logManage/sysLog/page.css', '/pages/logManage/sysLog/page.js'])
            }]
        }
    });

    *//**
     * 资源中心
     *//*
        //音频分类
    $stateProvider.state("audioClassify", {
        url: "/audioClassify",
        templateUrl: "/pages/resourceCenter/audioClassify/page.html",
        controller: 'audioClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/audioClassify/page.css', '/pages/resourceCenter/audioClassify/page.js'])
            }]
        }
    });
    //音频管理
    $stateProvider.state("audioManage", {
        url: "/audioManage",
        templateUrl: "/pages/resourceCenter/audioManage/page.html",
        controller: 'audioManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/audioManage/page.css', '/pages/resourceCenter/audioManage/page.js'])
            }]
        }
    });
    //图书仓库
    $stateProvider.state("bookEntrepot", {
        url: "/bookEntrepot",
        templateUrl: "/pages/resourceCenter/bookEntrepot/page.html",
        controller: 'bookEntrepotController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/bookEntrepot/page.css', '/pages/resourceCenter/bookEntrepot/page.js'])
            }]
        }
    });
    //标签管理
    $stateProvider.state("bookTab", {
        url: "/bookTab",
        templateUrl: "/pages/resourceCenter/bookTab/page.html",
        controller: 'bookTabController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/bookTab/page.css', '/pages/resourceCenter/bookTab/page.js'])
            }]
        }
    });
    //数据包
    $stateProvider.state("dataPackage", {
        url: "/dataPackage",
        templateUrl: "/pages/resourceCenter/dataPackage/page.html",
        controller: 'dataPackageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/dataPackage/page.css', '/pages/resourceCenter/dataPackage/page.js'])
            }]
        }
    });
    //数据包详情
    $stateProvider.state("dataPackageDetail", {
        url: "/dataPackageDetail/:id&:name",
        templateUrl: "/pages/resourceCenter/dataPackageInfo/page.html",
        controller: 'dataPackageInfoController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/dataPackageInfo/page.css', '/pages/resourceCenter/dataPackageInfo/page.js'])
            }]
        }
    });

    //图书分类
    $stateProvider.state("bookClassify", {
        url: "/bookClassify",
        templateUrl: "/pages/resourceCenter/bookClassify/page.html",
        controller: 'bookClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/bookClassify/page.css', '/pages/resourceCenter/bookClassify/page.js'])
            }]
        }
    });
    //图书管理
    $stateProvider.state("bookManage", {
        url: "/bookManage",
        templateUrl: "/pages/resourceCenter/bookManage/page.html",
        controller: 'bookManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/bookManage/page.css', '/pages/resourceCenter/bookManage/page.js'])
            }]
        }
    });
    //图书离线管理
    $stateProvider.state("bookOffLine", {
        url: "/bookOffLine",
        templateUrl: "/pages/resourceCenter/bookOffLine/page.html",
        controller: 'bookOffLineController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/bookOffLine/page.css', '/pages/resourceCenter/bookOffLine/page.js'])
            }]
        }
    });
    //资讯
    $stateProvider.state("bell", {
        url: "/bell",
        templateUrl: "/pages/bell/page.html",
        controller: 'bellController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/bell/page.css',
                    '/pages/bell/page.js'
                ])
            }]
        }
    });
    //资讯详情
    $stateProvider.state("bell.detail", {
        url: "/detail/:id",
        templateUrl: "/pages/bell/detail.html",
        controller: 'bellDetailController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/bell/detail.css',
                    '/pages/bell/detail.js'
                ])
            }]
        }
    });
    //资讯分类
    $stateProvider.state("cmsClassify", {
        url: "/cmsClassify",
        templateUrl: "/pages/resourceCenter/cmsClassify/page.html",
        controller: 'cmsClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/cmsClassify/page.css', '/pages/resourceCenter/cmsClassify/page.js'])
            }]
        }
    });
    //资讯管理
    $stateProvider.state("cmsManage", {
        url: "/cmsManage",
        templateUrl: "/pages/resourceCenter/cmsManage/page.html",
        controller: 'cmsManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/resourceCenter/cmsManage/page.css',
                    '/pages/resourceCenter/cmsManage/page.js'
                ])
            }]
        }
    });
    //资讯模版
    $stateProvider.state("cmsTemplate", {
        url: "/cmsTemplate",
        templateUrl: "/pages/resourceCenter/cmsTemplate/page.html",
        controller: 'cmsTemplateController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/cmsTemplate/page.css', '/pages/resourceCenter/cmsTemplate/page.js'])
            }]
        }
    });
    //报纸分类
    $stateProvider.state("newspaperClassify", {
        url: "/newspaperClassify",
        templateUrl: "/pages/resourceCenter/newspaperClassify/page.html",
        controller: 'newspaperClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/newspaperClassify/page.css', '/pages/resourceCenter/newspaperClassify/page.js'])
            }]
        }
    });
    //报纸管理
    $stateProvider.state("newspaperManage", {
        url: "/newspaperManage",
        templateUrl: "/pages/resourceCenter/newspaperManage/page.html",
        controller: 'newspaperManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/newspaperManage/page.css', '/pages/resourceCenter/newspaperManage/page.js'])
            }]
        }
    });
    //外链分类
    $stateProvider.state("outerClassify", {
        url: "/outerClassify",
        templateUrl: "/pages/resourceCenter/outerClassify/page.html",
        controller: 'outerClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/outerClassify/page.css', '/pages/resourceCenter/outerClassify/page.js'])
            }]
        }
    });
    //外链管理
    $stateProvider.state("outerManage", {
        url: "/outerManage",
        templateUrl: "/pages/resourceCenter/outerManage/page.html",
        controller: 'outerManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/outerManage/page.css', '/pages/resourceCenter/outerManage/page.js'])
            }]
        }
    });
    //期刊分类
    $stateProvider.state("journalClassify", {
        url: "/journalClassify",
        templateUrl: "/pages/resourceCenter/journalClassify/page.html",
        controller: 'journalClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/journalClassify/page.css', '/pages/resourceCenter/journalClassify/page.js'])
            }]
        }
    });
    //期刊管理
    $stateProvider.state("journalManage", {
        url: "/journalManage",
        templateUrl: "/pages/resourceCenter/journalManage/page.html",
        controller: 'journalManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/journalManage/page.css', '/pages/resourceCenter/journalManage/page.js'])
            }]
        }
    });
    //视频分类
    $stateProvider.state("videoClassify", {
        url: "/videoClassify",
        templateUrl: "/pages/resourceCenter/videoClassify/page.html",
        controller: 'videoClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/videoClassify/page.css', '/pages/resourceCenter/videoClassify/page.js'])
            }]
        }
    });
    //视频管理
    $stateProvider.state("videoManage", {
        url: "/videoManage",
        templateUrl: "/pages/resourceCenter/videoManage/page.html",
        controller: 'videoManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/videoManage/page.css', '/pages/resourceCenter/videoManage/page.js'])
            }]
        }
    });
    //文件管理
    $stateProvider.state("fileManage", {
        url: "/fileManage",
        templateUrl: "/pages/resourceCenter/fileManage/page.html",
        controller: 'fileManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/fileManage/page.css', '/pages/resourceCenter/fileManage/page.js'])
            }]
        }
    });
    //广告管理
    $stateProvider.state("advManage", {
        url: "/advManage",
        templateUrl: "/pages/resourceCenter/advManage/page.html",
        controller: 'advManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load([
                    '/pages/resourceCenter/advManage/page.css',
                    '/pages/resourceCenter/advManage/page.js'
                ])
            }]
        }
    });
    //广告分类
    $stateProvider.state("advClassify", {
        url: "/advClassify",
        templateUrl: "/pages/resourceCenter/advClassify/page.html",
        controller: 'advClassifyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/resourceCenter/advClassify/page.css', '/pages/resourceCenter/advClassify/page.js'])
            }]
        }
    });

    *//**
     * 终端管理
     *//*
        //大屏导航
    $stateProvider.state("largeMenu", {
        url: "/largeMenu",
        templateUrl: "/pages/terminalManage/largeMenu/page.html",
        controller: 'largeMenuController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/largeMenu/page.css', '/pages/terminalManage/largeMenu/page.js'])
            }]
        }
    });
    //大屏版本
    $stateProvider.state("largeVersion", {
        url: "/largeVersion",
        templateUrl: "/pages/terminalManage/largeVersion/page.html",
        controller: 'largeVersionController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/largeVersion/page.css', '/pages/terminalManage/largeVersion/page.js'])
            }]
        }
    });
    //大屏配置
    $stateProvider.state("largeConfig", {
        url: "/largeConfig",
        templateUrl: "/pages/terminalManage/largeConfig/page.html",
        controller: 'largeConfigController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/largeConfig/page.css', '/pages/terminalManage/largeConfig/page.js'])
            }]
        }
    });

    //意见反馈
    $stateProvider.state("coupleBack", {
        url: "/coupleBack",
        templateUrl: "/pages/terminalManage/coupleBack/page.html",
        controller: 'coupleBackController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/coupleBack/page.css', '/pages/terminalManage/coupleBack/page.js'])
            }]
        }
    });
    //版本管理
    $stateProvider.state("editionManage", {
        url: "/editionManage",
        templateUrl: "/pages/terminalManage/editionManage/page.html",
        controller: 'editionManageController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/editionManage/page.css', '/pages/terminalManage/editionManage/page.js'])
            }]
        }
    });

    //设备审核
    $stateProvider.state("facilityAudit", {
        url: "/facilityAudit",
        templateUrl: "/pages/terminalManage/facilityAudit/page.html",
        controller: 'facilityAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/facilityAudit/page.css', '/pages/terminalManage/facilityAudit/page.js'])
            }]
        }
    });
    //设备列表
    $stateProvider.state("facilityList", {
        url: "/facilityList",
        templateUrl: "/pages/terminalManage/facilityList/page.html",
        controller: 'facilityListController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/facilityList/page.css', '/pages/terminalManage/facilityList/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //设备监控
    $stateProvider.state("facilityMonitor", {
        url: "/facilityMonitor",
        templateUrl: "/pages/terminalManage/facilityMonitor/page.html",
        controller: 'facilityMonitorController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/facilityMonitor/page.css', '/pages/terminalManage/facilityMonitor/page.js'])
            }]
        }
    });
    //搜索关键词
    $stateProvider.state("searchKey", {
        url: "/searchKey",
        templateUrl: "/pages/terminalManage/searchKey/page.html",
        controller: 'searchKeyController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/terminalManage/searchKey/page.css', '/pages/terminalManage/searchKey/page.js'])
            }]
        }
    });
    //图书统计
    $stateProvider.state("bookSta", {
        url: "/bookSta",
        templateUrl: "/pages/staManage/bookSta/page.html",
        controller: 'bookStaController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/staManage/bookSta/page.css', '/pages/staManage/bookSta/page.js'])
            }]
        }
    });
    //资讯统计
    $stateProvider.state("newSta", {
        url: "/newSta",
        templateUrl: "/pages/staManage/newSta/page.html",
        controller: 'newStaController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/staManage/newSta/page.css', '/pages/staManage/newSta/page.js'])
            }]
        }
    });
    //机构统计
    $stateProvider.state("orgSta", {
        url: "/orgSta",
        templateUrl: "/pages/staManage/orgSta/page.html",
        controller: 'orgStaController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/staManage/orgSta/page.css', '/pages/staManage/orgSta/page.js'])
            }]
        }
    });
    //设备统计
    $stateProvider.state("facilitySta", {
        url: "/facilitySta",
        templateUrl: "/pages/staManage/facilitySta/page.html",
        controller: 'facilityStaController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/staManage/facilitySta/page.css', '/pages/staManage/facilitySta/page.js'])
            }]
        }
    });

    *//**
     * 会员中心
     *//*
    $stateProvider.state("memberList", {
        url: "/memberList",
        templateUrl: "/pages/member/memberList/page.html",
        controller: 'memberListController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/member/memberList/page.css', '/pages/member/memberList/page.js'])
            }]
        }
    });

    //幼升小，学位申报
    $stateProvider.state("primaryDegree", {
        url: "/primaryDegree",
        templateUrl: "/pages/primary/primaryDegree/page.html",
        controller: 'primaryDegreeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/primaryDegree/page.css', '/pages/primary/primaryDegree/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });

    //幼升小，信息补录
    $stateProvider.state("smaInformationCollection", {
        url: "/smaInformationCollection",
        templateUrl: "/pages/primary/smaInformationCollection/page.html",
        controller: 'smaInformationCollectionController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaInformationCollection/page.css', '/pages/primary/smaInformationCollection/page.js', '/plugins/cityData/city.data-3.js'])
            }]
        }
    });
    //打印录取通知书(幼升小)
    $stateProvider.state("smaParentsAdmissionNotice", {
        url: "/smaParentsAdmissionNotice",
        templateUrl: "/pages/primary/smaParentsAdmissionNotice/page.html",
        controller: 'smaParentsAdmissionNoticeController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaParentsAdmissionNotice/page.css', '/pages/primary/smaParentsAdmissionNotice/page.js', '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });
    //打印录取通知书(幼升小，新生报到)
    $stateProvider.state("smaNewlyPreview", {
        url: "/smaNewlyPreview",
        templateUrl: "/pages/primary/smaNewlyPreview/page.html",
        controller: 'smaNewlyPreviewController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaNewlyPreview/page.css', '/pages/primary/smaNewlyPreview/page.js', '/plugins/jquery/jquery.jqprint.js'])
            }]
        }
    });

    //小升初，随迁审核
    $stateProvider.state("immigrantAudit", {
        url: "/immigrantAudit",
        templateUrl: "/pages/primaryJunior/immigrantAudit/page.html",
        controller: 'immigrantAuditController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/immigrantAudit/page.css', '/pages/primaryJunior/immigrantAudit/page.js'])
            }]
        }
    });

    //幼升小，被驳回调剂管理
    $stateProvider.state("primaryAdjust", {
        url: "/primaryAdjust",
        templateUrl: "/pages/primary/primaryAdjust/page.html",
        controller: 'primaryAdjustController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/primaryAdjust/page.css', '/pages/primary/primaryAdjust/page.js'])
            }]
        }
    });


    //教育局加随迁招生名单
    $stateProvider.state("smaManySchoolScribingEdu", {
        url: "/smaManySchoolScribingEdu",
        templateUrl: "/pages/primary/smaManySchoolScribingEdu/page.html",
        controller: 'smaManySchoolScribingEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaManySchoolScribingEdu/page.css', '/pages/primary/smaManySchoolScribingEdu/page.js'])
            }]
        }
    });


    //教育局加随迁招生名单导入
    $stateProvider.state("smaManySchoolScribingTwoEdu", {
        url: "/smaManySchoolScribingTwoEdu",
        templateUrl: "/pages/primary/smaManySchoolScribingTwoEdu/page.html",
        controller: 'smaManySchoolScribingTwoEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaManySchoolScribingTwoEdu/page.css', '/pages/primary/smaManySchoolScribingTwoEdu/page.js'])
            }]
        }
    });


    //教育局小升初加随迁招生、多校划片、择校招生名单
    $stateProvider.state("manySchoolScribingEdu", {
        url: "/manySchoolScribingEdu",
        templateUrl: "/pages/primaryJunior/manySchoolScribingEdu/page.html",
        controller: 'manySchoolScribingEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/manySchoolScribingEdu/page.css', '/pages/primaryJunior/manySchoolScribingEdu/page.js'])
            }]
        }
    });

    //教育局小升初新增随迁名单
    $stateProvider.state("manySchoolScribingImportEdu", {
        url: "/manySchoolScribingImportEdu",
        templateUrl: "/pages/primaryJunior/manySchoolScribingImportEdu/page.html",
        controller: 'manySchoolScribingImportEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/manySchoolScribingImportEdu/page.css', '/pages/primaryJunior/manySchoolScribingImportEdu/page.js'])
            }]
        }
    });

    //民办小学——招生结果管理
    $stateProvider.state("smaInputResultsEdu", {
        url: "/smaInputResultsEdu",
        templateUrl: "/pages/primary/smaInputResultsEdu/page.html",
        controller: 'smaInputResultsEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaInputResultsEdu/page.css', '/pages/primary/smaInputResultsEdu/page.js'])
            }]
        }
    })

    //新生预览(小学)
    $stateProvider.state("smaNewStudentEdu", {
        url: "/smaNewStudentEdu",
        templateUrl: "/pages/primary/smaNewStudentEdu/page.html",
        controller: 'smaNewStudentEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primary/smaNewStudentEdu/page.css', '/pages/primary/smaNewStudentEdu/page.js'])
            }]
        }
    })

    //新生报到确认（公办初中）
    $stateProvider.state("newStudentEdu", {
        url: "/newStudentEdu",
        templateUrl: "/pages/primaryJunior/newStudentEdu/page.html",
        controller: 'newStudentEduController',
        resolve: {
            loadMyCtrl: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(['/pages/primaryJunior/newStudentEdu/page.css', '/pages/primaryJunior/newStudentEdu/page.js'])
            }]
        }
    });*/

});
