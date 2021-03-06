myApp.controller('homeController', function ($rootScope, $scope, services, $sce, $stateParams, $state) {
    $scope.services = services;
    services["_load_Data"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/listRelevantArticle', param, "POST");
    };
    //学位申报审核
    services["_declarationDegree"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/degreeApply/getAuditApplyNum', param, "POST");
    };
    //初中预录取学校
    services["Degree_getApply"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/degreeApply/getApply', param, "POST");
    };
    //小学预录取学校
    services["primary_getApply"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/primary/degreeApply/load', param, "POST");
    };
    //幼儿园预录取学校
    services["kindergarten_getApply"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/kindergartenapply/load', param, "POST");
    };
    //幼儿园待办业务
    services["kindergarten_getApplyNum"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/kindergartenapply/getAuditApplyNum', param, "POST");
    };
    //幼儿园网上注册资格审查
    services["kindergarten_QualificationExaminationNum"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/kindergarten/qualificationExamination/countTodo', param, "POST");
    };

    //时间节点
    services["_time_nodes"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/timeNode/queryByTypeCode', param, "POST");
    };
    $scope.can_view =false;
    $scope.data = {};
    //$scope.role_id = $rootScope._USERINFO.role_id;
    //////////
    $scope.role_id = 2;
    $scope.random = 90;
    $scope.declarationDegree_num = 0;
    $scope.qualificationExaminationNum = 0;
    $scope.declaration_num = 0;
    $scope.declara_num = 0;
    $scope.enter_school_name = null;//预录取学校
    $scope.audit_result=null;
    $scope.process_type=null;
    $scope.enter_school_type=null;
    $scope.tips=null;
    $scope.many_declara_num = 0;
    $scope.select_declara_num = 0;
    $scope.primary_apply_audit_num = 0;
    $scope.primary_select_audit_num = 0;

    $scope.immigrant_school_num = 0;
    $scope.reject_frequency = null;
    $scope.mobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    /*var hidInterval = setInterval(function() {
    	if($('#hideBtn')[0]) {
    	    $('#hideBtn').on('click', function() {
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
    	    $('.main-mask').on('click', function() {
    	    	$('#main-layout').removeClass('hide-side');
    		});
    	    clearInterval(mskInterval);
    	}
    }, 1000);*/
    if($rootScope._USERINFO) {
        if(3 == $rootScope._USERINFO.role || 4 == $rootScope._USERINFO.role) {
        	$rootScope._ALLMENU = [{
    			children: [{
    				res_name: "查看审核状态",
    				res_url: "#status",
    				res_id: "#status"
    			},{
    				res_name: "查看申请资料",
    				res_url: "#registerMsg",
    				res_id: ""
    			}]
    		}];
        } else if(1 == $rootScope._USERINFO.role || 2 == $rootScope._USERINFO.role) {
        	if($scope.mobile) {
            	/*$rootScope._ALLMENU = [{
        			children: [{
        				res_name: "查看审核状态",
        				res_url: "#status_mobile",
        				res_id: "#status_mobile"
        			}
        			,{
        				res_name: "查看修改申请资料",
        				res_url: "#registerMsg#review",
        				res_id: "#registerMsg#review"
        			},{
        				res_name: "打印录取通知书",
        				res_url: "#notifier",
        				res_id: "#notifier"
        			}
        			]
        		}];*/
        		$state.go("status_mobile");
        	} else {
            	$rootScope._ALLMENU = [{
        			children: [{
        				res_name: "查看审核状态",
        				res_url: "#status",
        				res_id: "#status"
        			},{
        				res_name: "查看修改申请资料",
        				res_url: "#registerMsg#review",
        				res_id: "#registerMsg#review"
        			},{
        				res_name: "打印录取通知书",
        				res_url: "#notifier",
        				res_id: "#notifier"
        			}]
        		}];
        	}
        }
    }
    $rootScope.curentSel = '';
    $rootScope.setContent = function(url) {
    	if($scope.mobile) {
        	$('#main-layout').removeClass('hide-side');
        	if(-1 < url.indexOf("#registerMsg")) {
        		window.open(encodeURI(encodeURI('/pages/index_mobile.html#/registers#review?id=' + $rootScope._USERINFO.id)));
        		window.location.href = "/pages/index_mobile.html#/home";
        		return;
        	} else {
        		$rootScope.curentSel = url;
        		if(-1 < url.indexOf("#notifier")) {
        			layer.alert("未到录取通知书打印时间");
        			window.location.href = "/pages/index_mobile.html#/home";
        			return;
        		}
        	}
    	} else {
        	if(-1 < url.indexOf("#registerMsg")) {
        		window.open(encodeURI(encodeURI('/pages/index.html#/registers#review?id=' + $rootScope._USERINFO.id)));
        		window.location.href = "/pages/index.html#/home";
        		return;
        	} else {
        		$rootScope.curentSel = url;
        		if(-1 < url.indexOf("#notifier")) {
        			layer.alert("未到录取通知书打印时间");
        			window.location.href = "/pages/index.html#/home";
        			return;
        		}
        	}
    	}
    }
    
});

