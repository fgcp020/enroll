myApp.controller('instructorController', function ($rootScope, $scope, services, $sce, $stateParams) {
    $scope.services = services;
    //列表集合-admin
    services["get_applay_list"] = function (param, role) {
    	if(4 == role || 5 == role) {
            return $rootScope.serverAction('/apply/queryApplyInfo', param, "GET");
    	} else {
    		return $rootScope.serverAction('/apply/queryApplyInfomation', 'token', "GET");
    	}
    };
    //查询未分配
    services["get_unset_list"] = function (param) {
        return $rootScope.serverAction('/apply/queryUnassignedStudent', param, "GET");
    };
    //列表-学校
    services["get_school_applay"] = function (param) {
        return $rootScope.serverAction('/apply/queryApplyInfomation', param, "GET");
    };
    
    //查询全部学校
    services["get_all_school"] = function (param) {
        return $rootScope.serverAction('/basic/school', "token", "GET");
    };
    
    //根据类型查询学校
    services["get_school_by_type"] = function (param) {
        return $rootScope.serverAction('/basic/schoolType', param, "GET");
    };
    
    //分配学校
    services["dist_school"] = function (param) {
        return $rootScope.serverAction('/apply/updateApplySchool', param, "PUT");
    };
    //审核
    services["audit_apply"] = function (param) {
        return $rootScope.serverAction('/apply/updateApplyStatus', param, "PUT");
    };
    //审核开关
    services["get_switch_case"] = function (param) {
        return $rootScope.serverAction('/basic/queryAuditStatu', param, "GET");
    };
    //切换审核开关
    services["toggle_switch_case"] = function (param) {
        return $rootScope.serverAction('/basic/updateAuditStatu', param, "PUT");
    };
    //发送短信
    services["send_msg"] = function (param) {
        return $rootScope.serverAction('/degree/sendConfirmSms', param, "POST");
    };
    
    $scope.superAdmin = false;
    $scope.switchStatus = false;
    $scope.toggleSwitch = function() {
    	var confirmTxt = $scope.switchStatus? '是否确认关闭审核功能？': '是否确认开启审核功能？';
    	layer.confirm(confirmTxt, {
            btn: ['确定', '取消'] 
        }, function () {
        	services.toggle_switch_case({'status':!$scope.switchStatus}).success(function (res) {
            	if ('OK' == res.result) {
            		layer.alert("操作成功");
            		getSwitchCase($scope);
            	} else {
            		layer.alert(res.msg);
            	}
            }).error(function (res) {
	        	layer.alert("操作失败");
	        });
        });
    };
    
    $scope.sendMsg = function() {
    	var toSendList = [];
    	var passList = [];
    	for(var i=0;i<$scope.tableControl.rows.length;i++) {
    		if($scope.tableControl.rows[i].select) {
    			toSendList.push($scope.tableControl.allData[i].applicant);
    			if(1 == $scope.tableControl.allData[i].applyStatus) {
    				passList.push($scope.tableControl.allData[i].applicant);
    			}
    		}
    	}
    	if(1 > toSendList.length) {
    		layer.alert("请选择需要发送短信的记录");
    		return;
    	}
    	if(toSendList.length != passList.length) {
    		layer.alert("只能对初步审核通过的记录进行短信批量发送");
    		return;
    	}
    	layer.confirm("是否确认发送短信？", {
            btn: ['确定', '取消'] 
        }, function () {
        	services.send_msg(toSendList).success(function (res) {
            	if ('OK' == res.result) {
            		layer.alert(res.msg);
            		$scope.reload();
            	} else {
            		layer.alert(res.msg);
            	}
            }).error(function (res) {
	        	layer.alert("发送失败");
	        });
        });
    }
    
    $scope.mobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    if($rootScope._USERINFO) {
        if(4 == $rootScope._USERINFO.role) {
        	$scope.searchCondition = true;
        	//admin
        	$rootScope._ALLMENU = [{
    			children: [{
    				res_name: "全部申请信息管理",
    				res_url: "#instruct",
    				res_id: "#instruct"
    			},{
    				res_name: "幼升小申请管理",
    				res_url: "#instruct#primary",
    				res_id: "#instruct#primary"
    			},{
    				res_name: "小升初申请管理",
    				res_url: "#instruct#junior",
    				res_id: "#instruct#junior"
    			}]
    		}];
        } else if(3 == $rootScope._USERINFO.role) {
        	$scope.searchCondition = false;
        	//学校
        	$rootScope._ALLMENU = [{
    			children: [{
    				res_name: "入学申请管理",
    				res_url: "#instruct#all",
    				res_id: "#instruct#all"
    			}]
    		}];
        } else if(5 == $rootScope._USERINFO.role) {
        	$scope.searchCondition = true;
        	//admin
        	$rootScope._ALLMENU = [{
    			children: [{
    				res_name: "全部申请信息管理",
    				res_url: "#instruct",
    				res_id: "#instruct"
    			},{
    				res_name: "幼升小申请管理",
    				res_url: "#instruct#primary",
    				res_id: "#instruct#primary"
    			},{
    				res_name: "小升初申请管理",
    				res_url: "#instruct#junior",
    				res_id: "#instruct#junior"
    			}]
    		}];
            $scope.switchText = "打开审核";
            $scope.superAdmin = true;
        	getSwitchCase($scope);
        }
    }
    
    $rootScope.setContent = function(url) {
    	$rootScope.curentSel = url;
    	if(-1 < url.indexOf("#primary")) {
        	//教育局-小学
    		$scope.school_type = 1;
        	$scope.tableControl.config.param.schoolType = 1;
        } else if(-1 < url.indexOf("#junior")) {
        	//教育局-初中
        	$scope.school_type = 2;
        	$scope.tableControl.config.param.schoolType = 2;
        } else if(-1 < url.indexOf("#all") || 3 == $rootScope._USERINFO.role) {
        	//学校
        	$scope.school_type = null;
        	$scope.tableControl.config.param.schoolType = null;
        } else {
        	$scope.school_type = "";
        	$scope.tableControl.config.param.schoolType = "";
        }
    	getAllSchool($scope);
    	$scope.param = {};
    	$scope.reload();
    }
    ///////权限和在线状态校验待
    var winUrl = window.location.href;
    if(-1 < winUrl.indexOf("#primary")) {
    	//教育局-小学
    	$scope.school_type = 1;
    	$rootScope.curentSel = "#instruct#primary";
    } else if(-1 < winUrl.indexOf("#junior")) {
    	//教育局-初中
    	$scope.school_type = 2;
    	$rootScope.curentSel = "#instruct#junior";
    } else if(-1 < winUrl.indexOf("#all") || 3 == $rootScope._USERINFO.role) {
    	//学校
    	$scope.school_type = null;
    	$rootScope.curentSel =  "#instruct#all";
    } else {
    	$scope.school_type = "";
    	$rootScope.curentSel =  "#instruct";
    }
    getAllSchool($scope);
    
    $scope.tableControl = {
        config: {
            check: true,
            param: {
                pages: 1,
                pageSize: 10,
                pageNum: 1,
            	schoolType: $scope.school_type,
            	//////
                total: 0,
                applyStatu: null,       
                schoolId: null, 
                IdCard: null,      
                studentName: null 
            },
            columns: [
                {field: 'studentName', title: "学生姓名", width: '180px'},
                //{field: 'sex', title: "性别"},
                //{field: 'certificates_type_name', title: "证件类型"},
                {field: 'idcard', title: "证件号码"},
                //{field: 'certificates_num', title: "手机号"},
                //{field: 'certificates_num', title: "毕业学校"},
                {field: 'applySchoolName', title: "申请学校"},
                {field: 'applyTime_text', title: "申请时间"},
                {field: 'studentType_text', title: "学生类型"},
                {field: 'schoolType_text', title: "学校类型"},
                {field: 'applyStatus_text', title: "审核状态"},
                {field: 'approverName', title: "审核人"},
                {field: 'approveTime_text', title: "审核时间"},
                {field: 'approveOpinion', title: "审核意见"},
                {field: 'tooltip', title: "备注", width: '180px'},
                {
                    field: 'action', title: "操作", formatter: function (value, row, index) {
                    	//先分配学校后审核
                    	if(4 == $rootScope._USERINFO.role) {
                    		if(row.applySchoolName) {
        	                    return "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(1, " + row.id + ")'>查看详情</a>" + 
        	                    "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(2, " + row.id + ")'>审核</a>" +
        	                    "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(3, " + row.id + ")' ng-if='null !== school_type'>分配学校</a>";
                    		} else {
                    			return "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(1, " + row.id + ")'>查看详情</a>" + 
        	                    "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(3, " + row.id + ")' ng-if='null !== school_type'>分配学校</a>";
                    		}
                    	} else if(3 == $rootScope._USERINFO.role) {
                    		if(row.applySchoolName) {
        	                    return "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(1, " + row.id + ")'>查看详情</a>" + 
        	                    "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(2, " + row.id + ")'>审核</a>";
                    		} else {
        	                    return "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(1, " + row.id + ")'>查看详情</a>";
                    		}
                    	} else if(5 == $rootScope._USERINFO.role) {
                    		return "<a style='text-decoration: none;margin-right:5px;' onclick='_audit(1, " + row.id + ")'>查看详情</a>";
                    	}
                    }
                }
            ]
        },
        reload: function (param) {
            services.get_applay_list(param, $rootScope._USERINFO.role).success(function (res) {
            	if ('OK' == res.result) {
            		$scope.allData = dealData(res.msg);
                    $scope.tableControl.loadData($scope.allData.slice(0, $scope.tableControl.config.param.pageSize), $scope.allData);
            	} else {
            		layer.alert(res.msg);
            	}
            }).error(function (res) {
	        	layer.alert("查询失败");
	        });
        }
    };
    
    $scope.selRow = {};
    $scope.param = {
    	applyStatu: null,	        
        //applySchoolName: null,	
    	schoolId: null,
        IdCard: null,		        //证件号码
        studentName: null	        //学生姓名
    };
    $scope.selSchool_name = '';
    $scope.selSchool = 0;
    $scope.allApplayStatus = [{'value':'unset','text':'未分配学校'},{'value':'0','text':'未审核'},{'value':'1','text':'初步审核通过'},{'value':'5','text':'审核通过'},{'value':'2','text':'审核失败'},
    	{'value':'3','text':'驳回补充材料'},{'value':'4','text':'注册时户口信息不完整'}];
    //清空
    $scope.causeData = [{'value':'1','text':'审核通过','select':false},{'value':'2','text':'审核失败','select':false},
    	{'value':'3','text':'驳回补充材料','select':false},{'value':'4','text':'注册时户口信息不完整','select':false}];
    $scope.form_empty = function () {
        $scope.param = {}
    }
    $scope.allData = [];
    //重新查询
    $scope.reload = function () {
    	$scope.tableControl.loadData([], []);
    	if("unset" == $scope.param.applyStatu) {
            //$scope.tableControl.config.param["applyStatu"] = $scope.param.applyStatu;
    		$scope.param.schoolId = null;
    		$scope.param.applySchoolName = null;
            $scope.tableControl.config.param["schoolId"] = $scope.param.schoolId;
            $scope.tableControl.config.param["IdCard"] = $scope.param.IdCard;
            $scope.tableControl.config.param["studentName"] = $scope.param.studentName;
            $scope.tableControl.config.param["pageNum"] = 1;
            services.get_unset_list($scope.tableControl.config.param).success(function (res) {
            	if ('OK' == res.result) {
            		$scope.allData = dealData(res.msg);
                    $scope.tableControl.loadData($scope.allData.slice(0, $scope.tableControl.config.param.pageSize), $scope.allData);
            	} else {
            		layer.alert(res.msg);
            	}
            }).error(function (res) {
	        	layer.alert("查询失败");
	        });
    	} else {
            $scope.tableControl.config.param["applyStatu"] = $scope.param.applyStatu;
            $scope.tableControl.config.param["schoolId"] = $scope.param.schoolId;
            $scope.tableControl.config.param["IdCard"] = $scope.param.IdCard;
            $scope.tableControl.config.param["studentName"] = $scope.param.studentName;
            $scope.tableControl.config.param["pageNum"] = 1;
            services.get_applay_list($scope.tableControl.config.param, $rootScope._USERINFO.role).success(function (res) {
            	if ('OK' == res.result) {
            		$scope.allData = dealData(res.msg);
                    $scope.tableControl.loadData($scope.allData.slice(0, $scope.tableControl.config.param.pageSize), $scope.allData);
            	} else {
            		layer.alert(res.msg);
            	}
            }).error(function (res) {
	        	layer.alert("查询失败");
	        });
    	}
    }
    
    $scope.setSelAudit = function(item) {
    	item.select = !item.select;
    	if(item.select) {
    		for(var i=0;i<$scope.causeData.length;i++) {
    			if(item.value == $scope.causeData[i].value) {
    				$scope.causeData[i].select = true;
    			} else {
    				$scope.causeData[i].select = false;
    			}
    		}
    		$scope.selAudit = item.value;
    	}
    }
    
    $scope.setSelSchool = function(item) {
    	$scope.selSchool_name = item.name;
        $scope.selSchool = item.id;
    }
    
    function dealData(msg) {
    	for(var i=0;i<msg.length;i++) {
        	if(msg[i].applyStatus || 0 == msg[i].applyStatus) {
        		//审核状态(0未审核、1审核通过、2审核失败、3驳回补充材料、4注册时户口信息不完整)
        		if(0 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "未审核";
        		} else if(1 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "初步审核通过";
        		} else if(2 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "审核失败";
        		} else if(3 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "驳回补充材料";
        		} else if(4 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "注册时户口信息不完整";
        		} else if(5 == msg[i].applyStatus) {
        			msg[i].applyStatus_text = "审核通过";
        		}
        		
        	}
        	msg[i].studentType_text = "";
        	if(msg[i].studentType) {
        		if(1 == msg[i].studentType) {
        			msg[i].studentType_text = "小学";
            	} else if(2 == msg[i].studentType) {
            		msg[i].studentType_text = "中学";
            	}
        	}
        	msg[i].schoolType_text = "";
        	if(msg[i].schoolType) {
        		if(1 == msg[i].schoolType) {
        			msg[i].schoolType_text = "小学";
            	} else if(2 == msg[i].schoolType) {
            		msg[i].schoolType_text = "中学";
            	}
        	}
        	
        	msg[i].applyTime_text = "";
        	if(msg[i].applyTime) {
        		var pt = new Date(msg[i].applyTime);
        		msg[i].applyTime_text = pt.toLocaleDateString().replace(/\//g, "-") + " " + pt.toTimeString().substr(0, 8);
        	}
        	
        	msg[i].approveTime_text = "";
        	if(msg[i].approveTime) {
        		var apt = new Date(msg[i].approveTime);
        		msg[i].approveTime_text = apt.toLocaleDateString().replace(/\//g, "-") + " " + apt.toTimeString().substr(0, 8);
        	}
    	}
    	
    	return msg;
    }
    
    function getSwitchCase(scope) {
    	services.get_switch_case('token').success(function (res) {
        	if ('OK' == res.result) {
                if(res.msg) {
                	scope.switchText = "关闭审核";
                	scope.switchStatus = true;
                } else {
                	scope.switchText = "打开审核";
                	scope.switchStatus = false;
                }
        	} else {
        		layer.alert(res.msg);
        	}
        });
    }
    
    function getAllSchool(scope) {
    	if(null === scope.school_type) {
    		//学校-不查
    	} else if("" === scope.school_type) {
    		//管理员初始化时，全部
    		services.get_all_school("").success(function (res) {
	        	if ('OK' == res.result) {
	                scope.allSchool = res.msg;
	        	} else {
	        		layer.alert(res.msg);
	        	}
	        });
    	} else if(1 === scope.school_type) {
    		//管理员，小学
    		services.get_school_by_type({'schoolType': scope.school_type}).success(function (res) {
	        	if ('OK' == res.result) {
	        		scope.allSchool = res.msg;
	        	} else {
	        		layer.alert(res.msg);
	        	}
	        });
    	} else if(2 === scope.school_type) {
    		//管理员，中学
    		services.get_school_by_type({'schoolType': scope.school_type}).success(function (res) {
	        	if ('OK' == res.result) {
	        		scope.allSchool = res.msg;
	        	} else {
	        		layer.alert(res.msg);
	        	}
	        });
    	}
    }
    
    //审核
    _audit = function (type, rowId) {
    	angular.forEach($scope.tableControl.data, function (item, index) {
            if (item.id == rowId) {
                $scope.selRow = $scope.tableControl.data[index];
            }
        });
    	if(1 == type) {
    		if($scope.mobile) {
        		window.open(encodeURI(encodeURI('/pages/index_mobile.html#/registers#review?id=' + $scope.selRow.applicant)));
    		} else {
        		window.open(encodeURI(encodeURI('/pages/index.html#/registers#review?id=' + $scope.selRow.applicant)));
    		}
    	} else if(3 == type) {
    		/*if(!$scope.switchStatus) {
    			layer.alert("该功能当前已被关闭");
    			return;
    		}*/
    		$scope.selSchool_name = "";
            $scope.selSchool = "";
    		layer.open({
    			type: 1,
                title: '分配学校',
                closeBtn: 1,
                shadeClose: true,
    			  area : ['350px' , '450px'],
    			  content: $('#schoolLayer'),
    			  btn: ['确定', '取消']
            	,yes: function(){
            		if('' == $scope.selSchool_name) {
            			layer.alert("请选择学校");
              			return;
            		}
            		var schoolObj = {
              				'applyId': $scope.selRow.id,
              				'userId': $scope.selRow.applicant,
              				'schoolId': $scope.selSchool
              		}
	                services.dist_school(schoolObj).success(function (res) {
	    	        	if ('OK' == res.result) {
	    	        		$scope.reload();
	    	        		layer.confirm('分配学校成功', {
	    	                    btn: ['确定'] 
	    	                }, function () {
	    	    	        	layer.closeAll();
	    	                });
	    	        	} else {
	    	        		layer.alert(res.msg, {}, function () {
	    	    	        	layer.closeAll();
	    	                });
	    	        	}
	    	        }).error(function (res) {
	    	        	layer.alert("分配学校失败");
	    	        });
	              }
              	,btn2: function(){
		               layer.closeAll();
		            }
    			 });
    	} else if(2 == type) {
    		/*if(!$scope.switchStatus) {
    			layer.alert("该功能当前已被关闭");
    			return;
    		}*/

      		angular.forEach($scope.causeData, function (cause) {
                cause.select = false;
            });
      		$scope.auditCause = '';
  			
    		layer.open({
    			type: 1,
                title: '审核',
                area: ["350px", "450px"],
                closeBtn: 1,
                shadeClose: true,
  			  content: $('#auditLayer'),
  			  btn: ['确定', '取消'] 
          	,yes: function(){
          		var causeChosen = false;
          		for(var i=0;i<$scope.causeData.length;i++) {
          			if($scope.causeData[i].select) {
          				causeChosen = true;
          			}
          		}
          		if(!causeChosen) {
          			layer.alert("请选择审核结论");
          			return;
          		}
          		var auditObj = {
          				'applyId': $scope.selRow.id,
          				'studentId': $scope.selRow.applicant,
          				'applyStatus': $scope.selAudit,
          				'approveOpinion': $scope.auditCause
          		}
          		services.audit_apply(auditObj).success(function (res) {
    	        	if ('OK' == res.result) {
    	        		$scope.reload();
    	        		layer.confirm('操作成功', {
    	                    btn: ['确定'] 
    	                }, function () {
    	    	        	layer.closeAll();
    	                });
    	        	} else {
    	        		layer.alert(res.msg, {}, function () {
    	    	        	layer.closeAll();
    	                });
    	        	}
    	        }).error(function (res) {
    	        	layer.alert("审核失败");
    	        });
              }
        	,btn2: function(){
                layer.closeAll();
              }
    		});
    	}
    };
    
    /*
     导出数据
     */
    $scope.derive = function () {
    	var toSendList = [];
    	var passList = [];
    	for(var i=0;i<$scope.tableControl.rows.length;i++) {
    		if($scope.tableControl.rows[i].select) {
    			toSendList.push($scope.tableControl.allData[i]);
    			//没有数据，原5，现先1
    			if(1 == $scope.tableControl.allData[i].applyStatus) {
    				passList.push($scope.tableControl.allData[i]);
    			}
    		}
    	}
    	if(1 > toSendList.length) {
    		layer.alert("请选择需要生成证书的记录");
    		return;
    	}
    	if(toSendList.length != passList.length) {
    		layer.alert("只能对审核通过的记录进行证书生成");
    		return;
    	}
    	layer.confirm("是否确认生成证书？", {
            btn: ['确定', '取消'] 
        }, function () {
        	$scope.progressTotal = toSendList.length;
        	$scope.doneNum = 0;
        	$scope.failedNum = 0;

    		layer.closeAll();
    		var maskLoad = layer.load(1, {shade: [0.8, '#393D49']});
        	//打开进度
        	$scope.curProgress = "0%";
        	$scope.progressShow = true;
        	$.each(toSendList, function(index, e){
        		var url = location.origin+"/pages/print/printBatch.html?"+encodeURIComponent(e.studentName)+"&&"+encodeURIComponent(e.applySchoolName);
            	//services.save_notifier(url).success(function (res) {
        		$.ajax({
					url: location.origin+'/basic/school',
					headers: {'token': $rootScope.token},
					type: 'get',
					dataType: 'json',
					contentType: 'application/json;charset=UTF-8',
					async: true,
				}).success(function (res) {
                	if ('OK' == res.result) {
                		$scope.doneNum++;
                	} else {
                		$scope.failedNum++;
                	}
                }).error(function (res) {
                	$scope.failedNum++;
    	        }).always(function () {
    	        	//刷新成功和失败数量
    	        	if(($scope.doneNum + $scope.failedNum) < $scope.progressTotal) {
        	        	//更新进度
    	        		//$scope.curProgress = Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%";
    	        		element.progress('notifierProgress', Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%")
    	        	} else {
    	        		//完成
    	        		$scope.curProgress = "100%";
    	        		////进度条渲染需要时间？？数据较少时执行完成还没渲染出来--改用定时器
    	        		var finishInterval = setInterval(function() {
    	        			if($(".layui-progress")[0]) {
    	    	        		element.progress('notifierProgress', "100%");
    	    	        		clearInterval(finishInterval);
    	        			}
    	        		}, 200);
    	        		$scope.progressDone = true;
    	        		//去掉转圈
    	        		$(".layui-layer-loading").hide();
    	        		//layer.closeAll();
    	        	}
				});
        	});
        	
        });
    }
    
    //方案2
    $scope.derive2 = function () {
    	//先单线程
    	var toSendList = [];
    	var passList = [];
    	for(var i=0;i<$scope.tableControl.rows.length;i++) {
    		if($scope.tableControl.rows[i].select) {
    			toSendList.push($scope.tableControl.allData[i]);
    			//没有数据，原5，现先1
    			if(1 == $scope.tableControl.allData[i].applyStatus) {
    				passList.push($scope.tableControl.allData[i]);
    			}
    		}
    	}
    	if(1 > toSendList.length) {
    		layer.alert("请选择需要生成证书的记录");
    		return;
    	}
    	if(toSendList.length != passList.length) {
    		layer.alert("只能对审核通过的记录进行证书生成");
    		return;
    	}
    	layer.confirm("是否确认生成证书？", {
            btn: ['确定', '取消'] 
        }, function () {
        	$scope.progressTotal = toSendList.length;
        	$scope.doneNum = 0;
        	$scope.failedNum = 0;

    		layer.closeAll();
    		var maskLoad = layer.load(1, {shade: [0.8, '#393D49']});
        	//打开进度
        	$scope.curProgress = "0%";
        	$scope.progressShow2 = true;
        	
        	//弹出隐藏绘图层
        	$("#printArea").remove();
        	$("body").append("<div id='printArea'><div id='toPrint'></div></div>");
        	
        	//绘制证书
        	suitScreen($scope);
        	var imgStr = "<img src='" + $scope.printObj.notifierObj.url+"' style='width:"+$scope.printObj.notifierObj.width+"px;height:"+
    		$scope.printObj.notifierObj.height+"px'><div id='textArea'></div>";
        	$("#toPrint").append(imgStr);
        	$("#toPrint").css("margin-top", (0-$scope.printObj.notifierObj.height-60)/2+"px");
        	$("#toPrint").css("height", $scope.printObj.notifierObj.height+"px");
        	$("#toPrint").css("width", $scope.printObj.notifierObj.width+"px");
        	
        	//填充文字
        	$.each(toSendList, function(index, e){
        		$("#textArea").empty();
        		$scope.printObj.paramList[0].objName = e.studentName;
        		$scope.printObj.paramList[1].objName = e.applySchoolName;
        		var htmlStr = "";
        		for(i=0;i<$scope.printObj.paramList.length;i++) {
            		var nowObj = $scope.printObj.paramList[i];
            		if(nowObj.fontSize < 12) {
            			htmlStr += "<div style='font-family:"+nowObj.fontFamily+";font-size:"+nowObj.fontSize+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
            			//谷歌浏览器字体小于12px时会不再变小，使用-webkit-transform兼容，并设置已左上角作为变换原点
            				"px;-webkit-transform:scale("+nowObj.fontSize/12+","+nowObj.fontSize/12+");transform-origin:0 0'>"+nowObj.objName+"</div>";
            		} else {
            			htmlStr += "<div style='font-family:"+nowObj.fontFamily+";font-size:"+nowObj.fontSize+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
            				"px'>"+nowObj.objName+"</div>";
            		}
            	}
            	//$("#toPrint").css("margin-left", (0-$scope.printObj.notifierObj.width)/2+"px");
            	$("#textArea").append(htmlStr);
            	
            	//保存
            	html2canvas(document.querySelector("#toPrint")).then(function(canvas) {
            		var type = 'png';//格式可以自定义
            		var imgData = canvas.toDataURL(type);
            		imgData = imgData.replace(_fixType(type),'image/octet-stream');
            		//文件名可以自定义
            		var filename = '录取通知书_' + e.studentName + '.' + type;
            		saveFile(imgData,filename);
            		$scope.doneNum++;
            		//刷新成功和失败数量
    	        	if(($scope.doneNum + $scope.failedNum) < $scope.progressTotal) {
        	        	//更新进度
    	        		//$scope.curProgress = Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%";
    	        		element.progress('notifierProgress2', Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%")
    	        	} else {
    	        		//完成
    	        		$scope.curProgress = "100%";
    	        		////进度条渲染需要时间？？数据较少时执行完成还没渲染出来--改用定时器
    	        		var finishInterval = setInterval(function() {
    	        			if($(".layui-progress")[0]) {
    	    	        		element.progress('notifierProgress2', "100%");
    	    	        		clearInterval(finishInterval);
    	        			}
    	        		}, 200);
    	        		$scope.progressDone2 = true;
    	        		//去掉转圈
    	        		$(".layui-layer-loading").hide();
    	        	}
            	});
        	});
        	
        });
    }
    
    //方案3
    $scope.derive3 = function () {
    	//先单线程
    	var toSendList = [];
    	var passList = [];
    	for(var i=0;i<$scope.tableControl.rows.length;i++) {
    		if($scope.tableControl.rows[i].select) {
    			toSendList.push($scope.tableControl.allData[i]);
    			//没有数据，原5，现先1
    			if(1 == $scope.tableControl.allData[i].applyStatus) {
    				passList.push($scope.tableControl.allData[i]);
    			}
    		}
    	}
    	if(1 > toSendList.length) {
    		layer.alert("请选择需要生成证书的记录");
    		return;
    	}
    	if(toSendList.length != passList.length) {
    		layer.alert("只能对审核通过的记录进行证书生成");
    		return;
    	}
    	layer.confirm("是否确认生成证书？", {
            btn: ['确定', '取消'] 
        }, function () {
        	$scope.progressTotal = toSendList.length;
        	$scope.doneNum = 0;
        	$scope.failedNum = 0;

    		layer.closeAll();
    		var maskLoad = layer.load(1, {shade: [0.8, '#393D49']});
        	//打开进度
        	$scope.curProgress = "0%";
        	$scope.progressShow3 = true;
        	
        	//弹出隐藏绘图层
        	$("#toPrint3").remove();
        	$("body").append("<div id='toPrint3'></div>");
        	
        	suitScreen($scope);

    		var allCanvas = $("canvas");
        	var zip = new JSZip();
    	    //zip.file("readme.txt", "证书\n");
    	    var img = zip.folder("images");

    	    //图片加载是异步，所有用递归来做，否则前边生成的都会被最后一个覆盖
        	(function loop(n) {
        		if (n>=toSendList.length) return;
        		
                var image = new Image();
                image.src = $scope.printObj.notifierObj.url;
                image.onload = function () { //为异步函数,所以将创建canvas放在onload中.

            		$("#toPrint3").empty();
            		$("#toPrint3").append("<canvas id='toPrint_' class='printCanvas'></canvas>");
            		$scope.printObj.paramList[0].objName = toSendList[n].studentName;
            		$scope.printObj.paramList[1].objName = toSendList[n].applySchoolName;
            		
                    
            		$("#toPrint_").css("margin-top", (0-$scope.printObj.notifierObj.height)/2+"px");
                	var canvas = document.getElementById("toPrint_");
                	canvas.width = $scope.printObj.notifierObj.width;
                	canvas.height = $scope.printObj.notifierObj.height;
                	var ctx = canvas.getContext("2d");
                	ctx.drawImage(image, 0, 0, $scope.printObj.notifierObj.width, $scope.printObj.notifierObj.height);
                	$.each($scope.printObj.paramList, function(index, e) {
            			//canvas的字体不会有12px的兼容性问题
            			ctx.font = "bold "+e.fontSize+"px "+e.fontFamily;
            			//canvas写字以字体的左下角为基准，因而要再加一个字体大小的高度
            			ctx.fillText(e.objName, e.left, e.top+e.fontSize);
            		});
                	img.file('录取通知书_' + toSendList[n].studentName + '.png', canvas.toDataURL().substring(22), {base64: true});
            		$scope.doneNum++;
            		//刷新成功和失败数量
    	        	if(($scope.doneNum + $scope.failedNum) < $scope.progressTotal) {
        	        	//更新进度
    	        		//$scope.curProgress = Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%";
    	        		element.progress('notifierProgress3', Math.round(($scope.doneNum + $scope.failedNum) / $scope.progressTotal * 100) + "%")
    	        	} else {
    	        		//完成
    	        		$scope.curProgress = "100%";
    	        		var finishInterval = setInterval(function() {
    	        			if($(".layui-progress")[0]) {
    	    	        		element.progress('notifierProgress3', "100%");
    	    	        		clearInterval(finishInterval);
    	        			}
    	        		}, 200);
    	        		$scope.progressDone3 = true;
    	        		//去掉转圈
    	        		$(".layui-layer-loading").hide();
    	        		
    	            	zip.generateAsync({type:"blob"}).then(function(content) {
    	        	        saveAs(content, "证书.zip");
    	        	    });
    	        	}
                	
                    loop(n+1);
                }
          })(0);


        });
    }
    
    $scope.closeProgress = function () {
    	$scope.progressShow = false;
    	$scope.progressDone = false;
    	$scope.progressShow2 = false;
    	$scope.progressDone2 = false;
    	$scope.progressShow3 = false;
    	$scope.progressDone3 = false;
    	layer.closeAll();
    }
    
  //模板
    $scope.printObj = {
		notifierObj:{
			"url": "/res/img/notifications.png",
			"height": "631",
			"width": "942"
		},
		paramList:[{
				"objName":"黄大明",
				"left":"133",
				"top":"191",
				"fontSize": "28",
				"fontFamily": "KaiTi"
			},{
				"objName":"SXXX小学",
				"left":"460",
				"top":"272",
				"fontSize": "28",
				"fontFamily": "KaiTi"
			},{
				"objName":"2018",
				"left":"195",
				"top":"312",
				"fontSize": "28",
				"fontFamily": "KaiTi"
			},{
				"objName":"8",
				"left":"325",
				"top":"312",
				"fontSize": "28",
				"fontFamily": "KaiTi"
			},{
				"objName":"31",
				"left":"405",
				"top":"312",
				"fontSize": "28",
				"fontFamily": "KaiTi"
			}]
    }
    
    function suitScreen($scope) {
    	//A4横向标准
    	var effectiveHeight = 1240;
    	var effectiveWidth = 1754;
        if($scope.printObj.notifierObj.width/effectiveWidth > $scope.printObj.notifierObj.height/effectiveHeight) {
        	//取最接近的一个属性进行自适应，并适当调小一些
        	var suitTimes = $scope.printObj.notifierObj.width/effectiveWidth*1.2;
        } else {
        	var suitTimes = $scope.printObj.notifierObj.height/effectiveHeight*1.2;
        }
        $scope.printObj.notifierObj.width = $scope.printObj.notifierObj.width/suitTimes;
        $scope.printObj.notifierObj.height = $scope.printObj.notifierObj.height/suitTimes;
        for(i=0;i<$scope.printObj.paramList.length;i++) {
        	$scope.printObj.paramList[i].fontSize = $scope.printObj.paramList[i].fontSize/suitTimes;
        	$scope.printObj.paramList[i].left = $scope.printObj.paramList[i].left/suitTimes;
        	$scope.printObj.paramList[i].top = $scope.printObj.paramList[i].top/suitTimes;
        }
    }
    
    function _fixType(type) {
    	//imgData是一串string，base64
        type = type.toLowerCase().replace(/jpg/i, 'jpeg');
        var r = type.match(/png|jpeg|bmp|gif/)[0];
        return 'image/' + r;
    }

    function saveFile(data, filename) {
    	var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
        save_link.href = data;
        save_link.download = filename;
       
        //下载
        var event = document.createEvent('MouseEvents');
        event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
        save_link.dispatchEvent(event);
    }
    
    //方案3使用canvas先画好，然后批量打包保存
    function drawNotifier($scope, id, img) {
    	//canvas需要先定位好，否则画好再动就清除了
    	//$("#toPrint").css("margin-left", (0-$scope.printObj.notifierObj.width)/2+"px");不可见元素，同样不考虑其左右缩进
    	$(id).css("margin-top", (0-$scope.printObj.notifierObj.height)/2+"px");
    	var canvas = document.getElementById(id.substring(1));
    	canvas.width = $scope.printObj.notifierObj.width;
    	canvas.height = $scope.printObj.notifierObj.height;
    	var ctx = canvas.getContext("2d");
    	var img=new Image();
    	img.src = $scope.printObj.notifierObj.url;
    	var deferred=$.Deferred();
    	var thisObj = $scope.printObj;
    	//img.onload=function() {
    	requestAnimationFrame(function() {
    		//需要onload方法接收，否则画不出
    		ctx.drawImage(img, 0, 0, thisObj.notifierObj.width, thisObj.notifierObj.height);
    		//写文字，且要在画好图片之后写，否则会被图片覆盖
    		$.each(thisObj.paramList, function(index, e) {
    			//canvas的字体不会有12px的兼容性问题
    			ctx.font = "bold "+e.fontSize+"px "+e.fontFamily;
    			//canvas写字以字体的左下角为基准，因而要再加一个字体大小的高度
    			ctx.fillText(e.objName, e.left, e.top+e.fontSize);
    		});
			deferred.resolve(canvas.toDataURL().substring(22));
    	})
    	//}
    	return deferred.promise();
    	
    }
});