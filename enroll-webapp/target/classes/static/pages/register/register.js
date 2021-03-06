myApp.controller('registerController', function ($rootScope, $scope, services, $window, $sce, $stateParams) {
    element_init = false;
    $scope.services = services;
    //小升初，进入学位申报时查询
    services["Degree_getApply"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/degreeApply/getApply', param, "POST");
    };
    
    //时间节点
    services["_time_nodes"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/timeNode/queryByTypeCode', param, "POST");
    };

    //第一步判断"房产或不动产证号码"
    services["saveResideCode"] = function (param) {
        return $rootScope.serverAction(ctxPath + '/admin/degreeApply/saveResideCode', param, "POST");
    };
    
    //校验学籍号
    services["check_stu_code"] = function (param) {
        return $rootScope.serverAction('/basic/studentNumber', param, "GET");
    };
    
    //发送验证码
    services["send_sms_code"] = function (param) {
        return $rootScope.serverAction('/basic/sendSmsCode', param, "POST");
    };
    
    //校验验证码
    services["check_sms_code"] = function (param) {
        return $rootScope.serverAction('/basic/querySmsCode', param, "GET");
    };
    
    //查询证件类别
    services["get_card_type"] = function (param) {
        return $rootScope.serverAction('/basic/certifatesType', param, "GET");
    };
    
    //查询国籍
    services["get_country"] = function (param) {
        return $rootScope.serverAction('/basic/country', param, "GET");
    };
    
    //查询民族
    services["get_nation"] = function (param) {
        return $rootScope.serverAction('/basic/nation', param, "GET");
    };
    
    //查询学生关系
    services["get_relation"] = function (param) {
        return $rootScope.serverAction('/basic/relational', param, "GET");
    };

    //查询学生信息
    services["get_stu_info"] = function (param, role) {
    	if(role) {
    		param = 'token';
            return $rootScope.serverAction('/user/queryUserByToken', param, "GET");
    	} else {
            return $rootScope.serverAction('/user/queryStudentInfo', param, "GET");
    	}
    };
    
    //注册
    services["register_register"] = function (param) {
        return $rootScope.serverAction('/user/register', param, "POST");
    };
    
    //注册编辑
    services["register_update"] = function (param) {
        return $rootScope.serverAction('/user/update', param, "PUT");
    };
    
    //获取注册时间
    services["get_date_plan"] = function (param) {
        return $rootScope.serverAction('/basic/queryPlanTime', param, "GET");
    };
    
    //校验身份证
    services["checkStuCardNum"] = function (param) {
        return $rootScope.serverAction('/basic/validateIdCard', param, "GET");
    };
    
    $scope.toSignUp = 'primary';
    if(-1 < window.location.href.indexOf('junior')) {
    	$scope.toSignUp = 'junior';
    }
    
    $rootScope.mobile_review = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    
    //信息预览
    $scope.review = false;
    $scope.isStu = true;
    var winUrl = window.location.href;
    if(-1 < winUrl.indexOf("#review")) {
    	$scope.review = true;
    }
	$scope.userId = '';
    $scope.rootUrl = winUrl.substring(0, winUrl.indexOf('pages'));
    if($rootScope._USERINFO) {
        if(3 == $rootScope._USERINFO.role || 4 == $rootScope._USERINFO.role || 5 == $rootScope._USERINFO.role) {
        	$scope.isStu = false;
        } else if(1 == $rootScope._USERINFO.role || 2 == $rootScope._USERINFO.role) {
        	$scope.isStu = true;
        }
    }
    
    if($scope.review) {
    	$scope.pageTitle = '学生注册信息详情查看';
    } else if($scope.toSignUp == 'junior') {
    	$scope.pageTitle = '初中新生注册';
    } else if($scope.toSignUp == 'primary') {
        $scope.pageTitle = '小学新生注册';
    }
    
    var tempReg;
    var reg1 = /^\d{6}(20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/;
	var reg2 = /^\d{6}(19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/;
	var phoneReg1 = /^(\d3,4|\d{3,4}-)?\d{7,8}$/;
	var phoneReg2 = /^1[34578]\d{9}$/;
	var cities = {11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",
			36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",
			62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
	
    //密码校验
    $scope.passwordInvalid = false;
    $scope.repasswordInvalid = false;
    $scope.ageInvalid = false;
    $scope.idCard1Invalid = false;
    $scope.idCard2Invalid = false;
    $scope.idCard3Invalid = false;
    $scope.phone1Invalid = false;
    $scope.phone2Invalid = false;
    $scope.phone3Invalid = false;
    $scope.senBtnDisable = false;
    $scope.smsCodeValue = "获取验证码";
    $scope.smsCountDown = 60;
    //$scope.smsCode = '';
    $scope.smsCodeInvalid = true;
    $scope.pre_apply_begin_time = null;
    $scope.pre_apply_end_time = null;
    //学籍号校验通过flag,暂不考虑手动改库场景
    //$scope.stu_code_pass = false;

    $scope.allSex = [{label:'男',value:'1'}, {label:'女',value:'0'}];
    
    $scope.allHealth = [{label:'健康或良好',value:'1'},{label:'一般或较弱',value:'2'},{label:'有慢性病',value:'3'},
    	{label:'有生理缺陷',value:'4'},{label:'残疾',value:'5'}];
    $scope.enrollType = [{label:'一类',value:'1'},{label:'二类',value:'2'},{label:'三类',value:'3'}];
    $scope.toChoose = [{label:'是',value:true}, {label:'否',value:false}];
    
    $scope.photoObj1 = {};
	$scope.photoObj2 = {};
	$scope.photoObj3 = {};
	$scope.photoObj4 = {};
	$scope.photoObj5 = {};
	$scope.photoObj6 = {};
	$scope.photoObj7 = {};
	$scope.photoObj8 = {};
	$scope.photoObj9 = {};
	$scope.photoObj10 = {};
	$scope.photoObj11 = {};
	$scope.photoObj12 = {};
	$scope.photoObj13 = {};
    
    $scope.setCardType = function(num, item) {
    	if(0 == num) {
    		$scope.registerMsg.userExtendedInfo.idType_text = item.content;
    		$scope.registerMsg.userExtendedInfo.idType = item.id;
    	} else if(1 == num) {
    		$scope.registerMsg.userGuardianInfos[0].idType_text = item.content;
    		$scope.registerMsg.userGuardianInfos[0].idType = item.id;
    	} else if(2 == num) {
    		$scope.registerMsg.userGuardianInfos[1].idType_text = item.content;
    		$scope.registerMsg.userGuardianInfos[1].idType = item.id;
    	}
    	if(8 == $scope.registerMsg.userGuardianInfos[0].idType || 8 == $scope.registerMsg.userGuardianInfos[1].idType) {
    		$scope.no_soldier = false;
    	} else {
    		$scope.no_soldier = true;
    	}
    	if(1 == item.id) {
    		$scope.checkCardNum(num + 1);
    	} else {
    		$scope.idCard1Invalid = false;
    		$scope.idCard2Invalid = false;
    		$scope.idCard3Invalid = false;
    		$scope.ageInvalid = false;
    	}
    }
    
    $scope.set_popular_type = function(item) {
    	$scope.registerMsg.userHouseInfo.liveType_text = item.label;
    	$scope.registerMsg.userHouseInfo.liveType = item.value;
    }
    
    $scope.set_student_house_relation = function(item) {
    	$scope.registerMsg.userHouseInfo.houseOwnerType = item.id;
    	$scope.registerMsg.userHouseInfo.houseOwnerType_text = item.content;
    } 
    
    $scope.checkPhone = function(type) {
    	var toCheckPhone;
    	if(1 == type) {
    		toCheckPhone = $scope.registerMsg.user.phone;
    		if(0 == toCheckPhone.length) {
    			$scope.phone1Invalid = false;
        		$scope.smsCodeInvalid = true;
    			return;
    		} else if(11 > toCheckPhone.length) {
    			$scope.phone1Invalid = true;
        		$scope.smsCodeInvalid = true;
        		return;
    		} else if(11 == toCheckPhone.length) {
    			$scope.smsCodeInvalid = true;
    		}
        	//修改手机号后重新校验验证码
    	} else if(2 == type) {
    		toCheckPhone = $scope.registerMsg.userGuardianInfos[0].phone;
    		if(0 == toCheckPhone.length) {
    			$scope.phone2Invalid = false;
    			return;
    		}
    	} else if(3 == type) {
    		toCheckPhone = $scope.registerMsg.userGuardianInfos[1].phone;
    		if(0 == toCheckPhone.length) {
    			$scope.phone3Invalid = false;
    			return;
    		}
    	}
    	if(!phoneReg1.test(toCheckPhone) && !phoneReg2.test(toCheckPhone)) {
    		if(1 == type) {
    			$scope.phone1Invalid = true;
    		} else if(2 == type) {
    			$scope.phone2Invalid = true;
    		} else if(3 == type) {
    			$scope.phone3Invalid = true;
    		}
    	} else {
    		if(1 == type) {
    			if(phoneReg2.test(toCheckPhone)) {
        			$scope.phone1Invalid = false;
        			//手机校验通过后重新校验一次验证码，避免手机号重新填与原本相同、或不相同两种场景
        			checkSmsCode();
    			} else {
    				$scope.phone1Invalid = true;
    			}
    		} else if(2 == type) {
    			$scope.phone2Invalid = false;
    		} else if(3 == type) {
    			$scope.phone3Invalid = false;
    		}
    	}
    }
    
    $scope.checkPassword = function() {
    	var reg = /^[A-Za-z0-9]{6,16}$/;
    	if(!reg.test($scope.registerMsg.user.pwd)) {
    		$scope.passwordInvalid = true;
    		return;
    	} else {
    		$scope.passwordInvalid = false;
    	}
    	if(0 < $scope.registerMsg.user.repwd.length) {
    		if(!($scope.registerMsg.user.repwd == $scope.registerMsg.user.pwd)) {
    			$scope.repasswordInvalid = true;
    			return;
    		} else {
    			$scope.repasswordInvalid = false;
    		}
    	}
    }
    
    $scope.checkRePassword = function() {
    	if(0 < $scope.registerMsg.user.repwd.length) {
    		if(!($scope.registerMsg.user.repwd == $scope.registerMsg.user.pwd)) {
    			$scope.repasswordInvalid = true;
    			return;
    		} else {
    			$scope.repasswordInvalid = false;
    		}
    	}
    }
     
    $scope.checkCardNum = function(type) {
    	if(1 == type) {
    		if(0 < $scope.registerMsg.user.idCard.length && 1 == $scope.registerMsg.userExtendedInfo.idType) {
    			if(checkCard(1, $scope.registerMsg.user.idCard)) {
    				//预置true
    				//$scope.idCard1Invalid = false;
    				if(18 == $scope.registerMsg.user.idCard.length) {
        				if(20120901 > $scope.registerMsg.user.idCard.substring(6, 14)) {
        					$scope.ageInvalid = false;
            				$scope.idCard1Invalid = true;
            				checkStuCardNum($scope);
        				} else {
        					$scope.ageInvalid = true;
        				}
    				} else {
    					$scope.ageInvalid = false;
    				}
    			} else {
    				$scope.idCard1Invalid = true;
    			}
    		} else {
        		$scope.idCard1Invalid = false;
    		}
    	} else if(2 == type) {
    		if(0 < $scope.registerMsg.userGuardianInfos[0].idNumber.length && 1 == $scope.registerMsg.userGuardianInfos[0].idType) {
    			if(checkCard(2, $scope.registerMsg.userGuardianInfos[0].idNumber)) {
    				$scope.idCard2Invalid = false;
    			} else {
    				$scope.idCard2Invalid = true;
    			}
    		} else {
        		$scope.idCard2Invalid = false;
    		}
    	} else if(3 == type) {
    		if(0 < $scope.registerMsg.userGuardianInfos[1].idNumber.length && 1 == $scope.registerMsg.userGuardianInfos[1].idType) {
    			if(checkCard(2, $scope.registerMsg.userGuardianInfos[1].idNumber)) {
    				$scope.idCard3Invalid = false;
    			} else {
    				$scope.idCard3Invalid = true;
    			}
    		} else {
        		$scope.idCard3Invalid = false;
    		}
    	}
    }
    
    $scope.senSmsCode = function() {
    	if($scope.senBtnDisable) {
    		return;
    	}
    	if($scope.registerMsg.user.phone) {
    		services.send_sms_code({'phone':$scope.registerMsg.user.phone}).success(function (res) {
            	if ('OK' == res.result) {
            		layer.alert("验证码发送成功");
                	$scope.senBtnDisable = true;
                	$scope.smsCountDown = 120;
                	var smsInterval = setInterval(function(){
                		$scope.smsCountDown --;
                    	$scope.smsCodeValue = "获取验证码 " + $scope.smsCountDown;
                    	if(1 > $scope.smsCountDown) {
                    		$scope.smsCodeValue = "获取验证码";
                    		$scope.senBtnDisable = false;
                    		clearInterval(smsInterval);
                    	}
                	}, 1000);
                } else if(res.msg) {
                    layer.alert(res.msg);
                }
            }).error(function (res) {
	        	layer.alert("发送失败");
	        });
    	}
    }
    
    $scope.checkSmsCode = function() {
    	$scope.smsCodeInvalid = true;
    	if(6 == $scope.registerMsg.user.smsCode.length) {
    		services.check_sms_code({'phone':$scope.registerMsg.user.phone, 'smsCode':$scope.registerMsg.user.smsCode}).success(function (res) {
            	if ('OK' == res.result) {
            		$scope.smsCodeInvalid = false;
                } else if(res.msg) {
                    layer.alert(res.msg);
                }
            });
    	}
    	
    }
    
    $scope.reviewImg = function(obj) {
    	if(obj.photoUrl) {
    		window.open($scope.rootUrl + obj.photoUrl);
    	} else if(obj.base64){
    		//window.open(obj.base64);
    	} else {
    		return;
    	}
    }
    //删除数组内容
    $scope._rel_arr_item = function (arr, item) {
        arr.splice(arr.indexOf(item), 1);
    };
    ///////////注册信息
    $scope.registerMsg = {
    	  "user": {
    	    "applyStatus": true,
    	    "createTime": 0,
    	    "extendProperty": null,
    	    "username": "",
    	    "sex": null,
    	    "sex_text": "",
    	    "phone": "",
    	    //"id": 0,
    	    "idCard": "",
    	    "permanentAddress": "",// 学生的户口所在地(这个很重要)
    	    "permanentAddress0": "湖北省宜昌市当阳市",
    	    "pwd": "",
    	    "repwd": "",
    	    "role": $scope.toSignUp == 'primary'? 1: 2,//用户的类型，1小学，2中学，3学校管理员，4教育局(注册时填1或2)
    	    "type": 0,//用户的招生类型1一类，2二类，3三类
    	    "type_text": "",
    	    "smsCode": ""//验证码
    	  },
    	  "userExtendedInfo": {
    	    "country": null,
    	    "country_text": "",
    	    "createTime": 0,
    	    "disabilityType": null,
    	    "disabilityType_text": "",
    	    "healthCondition": null,
    	    "healthCondition_text": "",
    	    "extendProperty": "",
    	    "formerSchool": "",
    	    "homeplace": "",//出生地
    	    //"id": 0,
    	    "idNumber": "",
    	    "idType": null,
    	    "idType_text": "",
    	    "graduated": null,//是否上过幼儿园/小学
    	    "graduated_text": "",
    	    "leftBehindChildren": null,
    	    "leftBehindChildren_text": "",
    	    "nation": null,
    	    "nation_text": "",
    	    "nativePlace": "",//籍贯
    	    "noMainland": null,
    	    "noMainland_text": "",//港澳台外
    	    "oneChild": null,//是否独生子女
    	    "oneChild_text": "",
    	    "orphan": null,
    	    "orphan_text" : "",
    	    "schoolNumber": "",
    	    "updateTime": 0,
    	    "userId": null,
    	    "workToCity": null,
    	    "workToCity_text": ""
    	  },
    	  "userGuardianInfos": [
    		  {
		        //"id": 2, //记录的id（更新接口需要带上）
		        "extendProperty": null,
		        "name": "", //监护人姓名
		        "userRelationship": null, //监护人与学生的关系
		        "userRelationship_text": "",
		        "workUnit": "", //工作单位
		        "accountAddress": "", //户口地址
		        "phone": "", //电话
		        "guarder": null, //是否为法定监护人
		        "guarder_text": "",
		        "idType": null, //证件类型
		        "idType_text": "",
		        "idNumber": "", //证件号码
		        "duties": "", //职业
		        "education": "", //教育程度
		        "monitOrder": 1, //监护人的顺序如1，2,3
		        "userId": null, //对应的user的id
		        "createTime": 0,
		        "updateTime": 0
		      },{
		          //"id": 2, //记录的id（更新接口需要带上）
		          "extendProperty": null,
		          "name": "", //监护人姓名
		          "userRelationship": null, //监护人与学生的关系
		          "userRelationship_text": "",
		          "workUnit": "", //工作单位
		          "accountAddress": "", //户口地址
		          "phone": "", //电话
		          "guarder": null, //是否为法定监护人
		          "guarder_text": "",
		          "idType": null, //证件类型
		          "idType_text": "",
		          "idNumber": "", //证件号码
		          "duties": "", //职业
		          "education": "", //教育程度
		          "monitOrder": 2, //监护人的顺序如1，2,3
		          "userId": null, //对应的user的id
		          "createTime": 0,
		          "updateTime": 0
		        }
    	  ],
    	  "userHouseInfo": {
    	      //"id": 2, //记录的id（更新接口需要带上）
    	      "extendProperty": null,
    	      "houseAddress": "",   //房产地址
    	      "houseType": null,   //房产类型 产权房，租赁
    	      "houseType_text": "",
    	      "houseNumber": "", //房产证编号
    	      "liveType": null,  //户口性质 农业 非农
    	      "liveType_text": "",
    	      "houseOwner": "", //房屋所有者
    	      "houseOwnerType": null, //房主与学生的关系，本人，父母 ，对应关系表
    	      "houseOwnerType_text": "",
    	      "userId": null,  //对应的user的id
    	      "createTime": 0,
    	      "updateTime": 0
    	    },
    	    "userPhotoInfos": [
    	        /*{
    	          //"id": 2,   //记录的id（更新接口需要带上）
    	          "extendProperty": null,
    	          "photoPath": "",
    	          "photoUrl": "", //照片的预览路径
    	          //"userId": 2, //对应的user的id
    	          "createTime": 0,
    	          "photoType": 12,
    	          "updateTime": 0,
    	          "base64": ""  //图片的base64编码
    	  	}*/
    	      ]
	};
    
    if(8 == $scope.registerMsg.userGuardianInfos[0].idType || 8 == $scope.registerMsg.userGuardianInfos[1].idType) {
		$scope.no_soldier = false;
	} else {
		$scope.no_soldier = true;
	}
    
    $scope.student_relationList = [     //与学生的关系集合
        {
            text: '本人或父母',
            code: 1
        },
        {
            text: '祖父母或曾祖父母',
            code: 2
        },
        {
            text: '其他法定监护人',
            code: 4
        },
        {
            text: '租住',
            code: 5
        }
    ];

    $scope.housing_typeList = [         //房产类型集合
        {
            text: '产权房',
            code: 1
        },
        {
            text: '租赁房',
            code: 2
        },
        {
            text: '无',
            code: 0
        }

    ];
    $scope.img_url_code = null;
    //设置与学生关系
    $scope.set_student_relation = function (num, v) {
    	if(1 == num) {
            $scope.registerMsg.userGuardianInfos[0].userRelationship_text = v.content;
            $scope.registerMsg.userGuardianInfos[0].userRelationship = v.id;
            //////////////$scope._rest();
    	} else if(2 == num) {
    		$scope.registerMsg.userGuardianInfos[1].userRelationship_text = v.content;
            $scope.registerMsg.userGuardianInfos[1].userRelationship = v.id;
    	}
    };
    //房产类型
    $scope.set_housing_type = function (v) {
        $scope.registerMsg.userHouseInfo.houseType_text = v.text;
        $scope.registerMsg.userHouseInfo.houseType = v.code;
        ////////////////$scope._rest();
    };
    
    $scope.uploading = function () {
    	if(!$scope.isStu) {
    		return;
    	}
    	//input重置
    	document.getElementById("img1").value = "";
    	$('#img1').click();
    };
    
    $('#img1').off().on('change', function () {
    	var reader = new FileReader();
        var AllowImgFileSize = 2100000; //上传图片最大值(单位字节)（ 2 M = 2097152 B ）超过2M上传失败
        var file = $("#img1")[0].files[0];
        var imgUrlBase64;
        if (file) {
            //将文件以Data URL形式读入页面  
            imgUrlBase64 = reader.readAsDataURL(file);
            reader.onload = function (e) {
              //var ImgFileSize = reader.result.substring(reader.result.indexOf(",") + 1).length;//截取base64码部分（可选可不选，需要与后台沟通）
              if (AllowImgFileSize != 0 && AllowImgFileSize < reader.result.length) {
                    alert( '上传失败，请上传不大于2M的图片！');
                    return;
                }else{
                    //执行上传操作
                    //alert(reader.result);
                	var tempPhoto;
                	for(var i=0;i<$scope.registerMsg.userPhotoInfos.length;i++) {
                		//其他允许多张，否则只允许一张
                		if($scope.img_url_code == $scope.registerMsg.userPhotoInfos[i].photoType
                				//&& 12 != $scope.registerMsg.userPhotoInfos[i].photoType
                				) {
                			tempPhoto = $scope.registerMsg.userPhotoInfos[i];
                			$scope.registerMsg.userPhotoInfos.splice(i, 1);
                			break;
                		}
                	}
                	if(tempPhoto) {
                		/*if(tempPhoto.photoName) {
                			tempPhoto.photoName = $("#img1")[0].files[0].name;
                		} else if(!$scope.review) {
                			tempPhoto['photoName'] = $("#img1")[0].files[0].name;
                		}*/
                		tempPhoto.photoUrl = "";
                		tempPhoto.base64 = reader.result; 
                    	$scope.registerMsg.userPhotoInfos.push(tempPhoto);
                	} else {
                    	$scope.registerMsg.userPhotoInfos.push({
                  	          "id": '',   //记录的id（更新接口需要带上）
                  	          "extendProperty": null,
                  	          "photoPath": "",
                  	          "photoUrl": "", //照片的预览路径
                  	          "userId": $scope.userId, //对应的user的id
                  	          "createTime": 0,
                  	          "photoType": $scope.img_url_code,
                  	          "updateTime": 0,
                  	          //"photoName": $("#img1")[0].files[0].name,
                  	          "base64": reader.result  //图片的base64编码
                  	  	})
                	}

                	for(var b=0;b<$scope.registerMsg.userPhotoInfos.length;b++) {
                		if(1 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj1 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(2 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj2 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(3 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj3 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(4 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj4 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(5 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj5 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(6 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj6 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(7 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj7 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(8 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj8 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(9 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj9 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(10 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj10 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(11 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj11 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(12 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj12 = $scope.registerMsg.userPhotoInfos[b];
                		} else if(13 == $scope.registerMsg.userPhotoInfos[b].photoType) {
                			$scope.photoObj13 = $scope.registerMsg.userPhotoInfos[b];
                		}
                	}
                }
            }
         }
    });
   
    
    $scope.formSubmit = function () {
    	if('' === $scope.registerMsg.user.username || null === $scope.registerMsg.user.username || undefined === $scope.registerMsg.user.username) {
    		layer.alert("请填写学生姓名");
    		return;
    	}
    	if('' === $scope.registerMsg.user.sex || null === $scope.registerMsg.user.sex || undefined === $scope.registerMsg.user.sex) {
    		layer.alert("请选择学生性别");
    		return;
    	}
    	if('' === $scope.registerMsg.user.phone || null === $scope.registerMsg.user.phone || undefined === $scope.registerMsg.user.phone) {
    		layer.alert("请填写手机号");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.nativePlace || null === $scope.registerMsg.userExtendedInfo.nativePlace || undefined === $scope.registerMsg.userExtendedInfo.nativePlace) {
    		layer.alert("请填写学生籍贯");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.nation || null === $scope.registerMsg.userExtendedInfo.nation || undefined === $scope.registerMsg.userExtendedInfo.nation) {
    		layer.alert("请选择学生民族");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.noMainland || null === $scope.registerMsg.userExtendedInfo.noMainland || undefined === $scope.registerMsg.userExtendedInfo.noMainland) {
    		layer.alert("请选择是否侨居");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.country || null === $scope.registerMsg.userExtendedInfo.country || undefined === $scope.registerMsg.userExtendedInfo.country) {
    		layer.alert("请选择学生国籍");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.idType || null === $scope.registerMsg.userExtendedInfo.idType || undefined === $scope.registerMsg.userExtendedInfo.idType) {
    		layer.alert("请选择学生证件类型");
    		return;
    	}
    	$scope.registerMsg.userExtendedInfo.idNumber = $scope.registerMsg.user.idCard;
    	if('' === $scope.registerMsg.userExtendedInfo.idNumber || null === $scope.registerMsg.userExtendedInfo.idNumber || undefined === $scope.registerMsg.userExtendedInfo.idNumber) {
    		layer.alert("请填写学生证件号码");
    		return;
    	}
    	if('' === $scope.registerMsg.user.permanentAddress || null === $scope.registerMsg.user.permanentAddress || undefined === $scope.registerMsg.user.permanentAddress) {
    		layer.alert("请填写学生户口所在地");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.homeplace || null === $scope.registerMsg.userExtendedInfo.homeplace || undefined === $scope.registerMsg.userExtendedInfo.homeplace) {
    		layer.alert("请填写学生出生所在地");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.healthCondition || null === $scope.registerMsg.userExtendedInfo.healthCondition || undefined === $scope.registerMsg.userExtendedInfo.healthCondition) {
    		layer.alert("请选择学生健康状况");
    		return;
    	}
    	/*if('' === $scope.registerMsg.user.type || null === $scope.registerMsg.user.type || undefined === $scope.registerMsg.user.type) {
    		layer.alert("请选择招生类型");
    		return;
    	}*/
    	/*if('' === $scope.registerMsg.userExtendedInfo.oneChild || null === $scope.registerMsg.userExtendedInfo.oneChild || undefined === $scope.registerMsg.userExtendedInfo.oneChild) {
    		layer.alert("请选择是否独生子女");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userExtendedInfo.graduated || null === $scope.registerMsg.userExtendedInfo.graduated || undefined === $scope.registerMsg.userExtendedInfo.graduated) {
    		if('primary' == $scope.toSignUp) {
        		layer.alert("请选择是否上过幼儿园");
    		} else if('junior' == $scope.toSignUp) {
        		layer.alert("请选择是否上过小学");
    		}
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.formerSchool || null === $scope.registerMsg.userExtendedInfo.formerSchool || undefined === $scope.registerMsg.userExtendedInfo.formerSchool) {
    		if($scope.registerMsg.userExtendedInfo.graduated) {
    			if('primary' == $scope.toSignUp) {
    	    		layer.alert("请填写幼儿园名称");
    	    		return;
    			} else if('junior' == $scope.toSignUp) {
    				layer.alert("请填写小学名称");
    	    		return;
    			}
    		}
    	}
    	
		if($scope.registerMsg.userExtendedInfo.graduated) {
			if('junior' == $scope.toSignUp) {
				if('' === $scope.registerMsg.userExtendedInfo.schoolNumber || null === $scope.registerMsg.userExtendedInfo.schoolNumber || undefined === $scope.registerMsg.userExtendedInfo.schoolNumber) {
		    		layer.alert("请填写学籍号");
		    		return;
				} else if(!$scope.stu_code_pass) {
					layer.alert("学籍号与学生和学校不匹配");
		    		return;
				}
			}
		}
    	/*if('' === $scope.registerMsg.userExtendedInfo.leftBehindChildren || null === $scope.registerMsg.userExtendedInfo.leftBehindChildren || undefined === $scope.registerMsg.userExtendedInfo.leftBehindChildren) {
    		layer.alert("请选择是否留守儿童");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.workToCity || null === $scope.registerMsg.userExtendedInfo.workToCity || undefined === $scope.registerMsg.userExtendedInfo.workToCity) {
    		layer.alert("请选择是否进城务工子女");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.orphan || null === $scope.registerMsg.userExtendedInfo.orphan || undefined === $scope.registerMsg.userExtendedInfo.orphan) {
    		layer.alert("请选择是否孤儿");
    		return;
    	}
    	if('' === $scope.registerMsg.userExtendedInfo.disabilityType || null === $scope.registerMsg.userExtendedInfo.disabilityType || undefined === $scope.registerMsg.userExtendedInfo.disabilityType) {
    		layer.alert("请填写是否残疾");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].name || null === $scope.registerMsg.userGuardianInfos[0].name || undefined === $scope.registerMsg.userGuardianInfos[0].name) {
    		layer.alert("请填写法定监护人一姓名");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].name || null === $scope.registerMsg.userGuardianInfos[1].name || undefined === $scope.registerMsg.userGuardianInfos[1].name) {
    		layer.alert("请填写法定监护人二姓名");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].userRelationship || null === $scope.registerMsg.userGuardianInfos[0].userRelationship || undefined === $scope.registerMsg.userGuardianInfos[0].userRelationship) {
    		layer.alert("请选择法定监护人一与学生关系");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].userRelationship || null === $scope.registerMsg.userGuardianInfos[1].userRelationship || undefined === $scope.registerMsg.userGuardianInfos[1].userRelationship) {
    		layer.alert("请选择法定监护人二与学生关系");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].workUnit || null === $scope.registerMsg.userGuardianInfos[0].workUnit || undefined === $scope.registerMsg.userGuardianInfos[0].workUnit) {
    		layer.alert("请填写法定监护人一工作单位");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].workUnit || null === $scope.registerMsg.userGuardianInfos[1].workUnit || undefined === $scope.registerMsg.userGuardianInfos[1].workUnit) {
    		layer.alert("请填写法定监护人二工作单位");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].accountAddress || null === $scope.registerMsg.userGuardianInfos[0].accountAddress || undefined === $scope.registerMsg.userGuardianInfos[0].accountAddress) {
    		layer.alert("请填写法定监护人一户口所在地");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].accountAddress || null === $scope.registerMsg.userGuardianInfos[1].accountAddress || undefined === $scope.registerMsg.userGuardianInfos[1].accountAddress) {
    		layer.alert("请填写法定监护人二户口所在地");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].phone || null === $scope.registerMsg.userGuardianInfos[0].phone || undefined === $scope.registerMsg.userGuardianInfos[0].phone) {
    		layer.alert("请填写法定监护人一电话");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].phone || null === $scope.registerMsg.userGuardianInfos[1].phone || undefined === $scope.registerMsg.userGuardianInfos[1].phone) {
    		layer.alert("请填写法定监护人二电话");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].guarder || null === $scope.registerMsg.userGuardianInfos[0].guarder || undefined === $scope.registerMsg.userGuardianInfos[0].guarder) {
    		layer.alert("请选择是否为法定监护人");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].guarder || null === $scope.registerMsg.userGuardianInfos[1].guarder || undefined === $scope.registerMsg.userGuardianInfos[1].guarder) {
    		layer.alert("请选择是否为法定监护人");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].idType || null === $scope.registerMsg.userGuardianInfos[0].idType || undefined === $scope.registerMsg.userGuardianInfos[0].idType) {
    		layer.alert("请选择法定监护人一证件类型");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].idType || null === $scope.registerMsg.userGuardianInfos[1].idType || undefined === $scope.registerMsg.userGuardianInfos[1].idType) {
    		layer.alert("请选择法定监护人二证件类型");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].idNumber || null === $scope.registerMsg.userGuardianInfos[0].idNumber || undefined === $scope.registerMsg.userGuardianInfos[0].idNumber) {
    		layer.alert("请填写法定监护人一证件号");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].idNumber || null === $scope.registerMsg.userGuardianInfos[1].idNumber || undefined === $scope.registerMsg.userGuardianInfos[1].idNumber) {
    		layer.alert("请填写法定监护人二证件号");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].duties || null === $scope.registerMsg.userGuardianInfos[0].duties || undefined === $scope.registerMsg.userGuardianInfos[0].duties) {
    		layer.alert("请填写法定监护人一职务");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].duties || null === $scope.registerMsg.userGuardianInfos[1].duties || undefined === $scope.registerMsg.userGuardianInfos[1].duties) {
    		layer.alert("请填写法定监护人二职务");
    		return;
    	}*/
    	if('' === $scope.registerMsg.userGuardianInfos[0].education || null === $scope.registerMsg.userGuardianInfos[0].education || undefined === $scope.registerMsg.userGuardianInfos[0].education) {
    		layer.alert("请填写法定监护人一学历");
    		return;
    	}
    	/*if('' === $scope.registerMsg.userGuardianInfos[1].education || null === $scope.registerMsg.userGuardianInfos[1].education || undefined === $scope.registerMsg.userGuardianInfos[1].education) {
    		layer.alert("请填写法定监护人二学历");
    		return;
    	}*/
    	//if($scope.no_soldier) {
        	if('' === $scope.registerMsg.userHouseInfo.houseAddress || null === $scope.registerMsg.userHouseInfo.houseAddress || undefined === $scope.registerMsg.userHouseInfo.houseAddress) {
        		layer.alert("请填写房产或租住地址");
        		return;
        	}
        	if('' === $scope.registerMsg.userHouseInfo.houseType || null === $scope.registerMsg.userHouseInfo.houseType || undefined === $scope.registerMsg.userHouseInfo.houseType) {
        		layer.alert("请选择房产类型");
        		return;
        	}
        	if(0 != $scope.registerMsg.userHouseInfo.houseType) {
            	if('' === $scope.registerMsg.userHouseInfo.houseNumber || null === $scope.registerMsg.userHouseInfo.houseNumber || undefined === $scope.registerMsg.userHouseInfo.houseNumber) {
            		layer.alert("请填写房产证编号/备案号");
            		return;
            	}
            	if('' === $scope.registerMsg.userHouseInfo.liveType || null === $scope.registerMsg.userHouseInfo.liveType || undefined === $scope.registerMsg.userHouseInfo.liveType) {
            		layer.alert("请选择户口性质");
            		return;
            	}
            	if('' === $scope.registerMsg.userHouseInfo.houseOwner || null === $scope.registerMsg.userHouseInfo.houseOwner || undefined === $scope.registerMsg.userHouseInfo.houseOwner) {
            		layer.alert("请填写房产所有人姓名");
            		return;
            	}
            	if('' === $scope.registerMsg.userHouseInfo.houseOwnerType || null === $scope.registerMsg.userHouseInfo.houseOwnerType || undefined === $scope.registerMsg.userHouseInfo.houseOwnerType) {
            		layer.alert("请选择房主与学生关系");
            		return;
            	}
        	}
    	//}
    	if($scope.idCard1Invalid) {
    		layer.alert("学生身份证号有误");
    		return;
    	}
    	if($scope.ageInvalid) {
    		layer.alert("学生年龄不符合要求");
    		return;
    	}
    	if($scope.idCard2Invalid) {
    		layer.alert("监护人一身份证号有误");
    		return;
    	}
    	if($scope.idCard3Invalid) {
    		layer.alert("监护人二身份证号有误");
    		return;
    	}
    	if($scope.phone1Invalid) {
    		layer.alert("手机号格式有误");
    		return;
    	}
    	if($scope.phone2Invalid) {
    		layer.alert("监护人一联系电话格式有误");
    		return;
    	}
    	if($scope.phone3Invalid) {
    		layer.alert("监护人二联系电话格式有误");
    		return;
    	}
    	if(!($scope.photoObj1 && ($scope.photoObj1.base64 || $scope.photoObj1.photoUrl) && $scope.photoObj2 && ($scope.photoObj2.base64 || $scope.photoObj2.photoUrl))) {
    		layer.alert("请上传户口本照片");
    		return;
    	}
    	if(!($scope.photoObj3 && ($scope.photoObj3.base64 || $scope.photoObj3.photoUrl))) {
    		layer.alert("请上传学生出生医学证明照片");
    		return;
    	}
    	if(($scope.passwordInvalid || $scope.repasswordInvalid) || (!$scope.review && 6 > $scope.registerMsg.user.pwd.length)) {
    		layer.alert("请设置正确密码");
    		return;
    	}
    	layer.confirm('是否确认继续操作？', {
            btn: ['确定', '取消'] 
        }, function () {
        	if($scope.review) {
                services.register_update($scope.registerMsg).success(function (res) {
                	if ('OK' == res.result) {
                        layer.confirm('修改成功，是否关闭本页面？', {
                            btn: ['确定', '取消'] 
                        }, function () {
                        	window.close();
                        });
                    } else if(res.msg) {
                        layer.alert(res.msg);
                    }
                }).error(function (res) {
    	        	layer.alert("编辑失败");
    	        });
        	} else {
                services.register_register($scope.registerMsg).success(function (res) {
                	if ('OK' == res.result) {
                        layer.confirm('注册成功，是否回到首页？', {
                            btn: ['确定', '取消'] 
                        }, function () {
                        	window.location.href = "/pages/index.html";
                        });
                    } else if(res.msg) {
                        layer.alert(res.msg);
                    }
                }).error(function (res) {
    	        	layer.alert("注册失败");
    	        });
        	}
        });
    };

    $scope.rest_reside_code = function () {
        $scope.selRow.reside_code = null;
    }
    //加载
    $scope.load = function () {
        
    	services.get_card_type('').success(function(res) {
    		if ('OK' == res.result) {
    			if(res.msg) {
    				$scope.allCard = res.msg;
    			}
    		} else if(res.msg) {
				layer.alert(res.msg);
			}
    	});
    	
    	services.get_country('').success(function(res) {
    		if ('OK' == res.result) {
    			if(res.msg) {
    				$scope.allCountry = res.msg;
    			}
    		} else if(res.msg) {
				layer.alert(res.msg);
			}
    	});
    	
    	services.get_nation('').success(function(res) {
    		if ('OK' == res.result) {
    			if(res.msg) {
    				$scope.allNation = res.msg;
    			}
    		} else if(res.msg) {
				layer.alert(res.msg);
			}
    	});
    	
    	services.get_relation('').success(function(res) {
    		if ('OK' == res.result) {
    			if(res.msg) {
    				$scope.student_relationList = res.msg;
    			}
    		} else if(res.msg) {
				layer.alert(res.msg);
			}
    	});
    	
    	if($scope.review && winUrl) {
    		var userId = winUrl.substring(winUrl.indexOf('id=') + 3, winUrl.length);
    		$scope.userId = userId;
    		services.get_stu_info({'studentId':userId}, $scope.isStu).success(function(res) {
        		if ('OK' == res.result) {
        			if(res.msg) {
        				$scope.registerMsg = res.msg;
        			}
        			if($scope.registerMsg.user.role) {
        				if(1 == $scope.registerMsg.user.role) {
        					$scope.toSignUp = 'primary';
            			} else if(2 == $scope.registerMsg.user.role) {
            				$scope.toSignUp = 'junior';
            				$scope.stu_code_pass = true;
            			}
        			}
        			for(var b=0;b<$scope.registerMsg.userPhotoInfos.length;b++) {
        				if(1 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj1 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(2 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj2 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(3 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj3 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(4 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj4 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(5 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj5 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(6 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj6 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(7 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj7 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(8 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj8 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(9 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj9 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(10 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj10 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(11 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj11 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(12 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj12 = $scope.registerMsg.userPhotoInfos[b];
        				} else if(13 == $scope.registerMsg.userPhotoInfos[b].photoType) {
        					$scope.photoObj13 = $scope.registerMsg.userPhotoInfos[b];
        				}
        			}
        			$scope.registerMsg.user.permanentAddress0 = "湖北省宜昌市当阳市";
        			var countrySet = false;
        			var nationSet = false;
        			var relationSet = false;
        			var cardSet = false;
        			var reviewInterval = setInterval(function() {
        				//证件类型
        				if($scope.allCard) {
        					for(var i=0;i<$scope.allCard.length;i++) {
        						if($scope.allCard[i].id == $scope.registerMsg.userExtendedInfo.idType) {
        							$scope.registerMsg.userExtendedInfo.idType_text = $scope.allCard[i].content;
        						}
        						if($scope.allCard[i].id == $scope.registerMsg.userGuardianInfos[0].idType) {
        							$scope.registerMsg.userGuardianInfos[0].idType_text = $scope.allCard[i].content;
        						}
        						if($scope.allCard[i].id == $scope.registerMsg.userGuardianInfos[1].idType) {
        							$scope.registerMsg.userGuardianInfos[1].idType_text = $scope.allCard[i].content;
        						}
        						if(8 == $scope.registerMsg.userGuardianInfos[0].idType || 8 == $scope.registerMsg.userGuardianInfos[1].idType) {
        				    		$scope.no_soldier = false;
        				    	} else {
        				    		$scope.no_soldier = true;
        				    	}
        					}
        					cardSet = true;
        				}
        				//关系
        				if($scope.student_relationList) {
        					for(var j=0;j<$scope.student_relationList.length;j++) {
        						if($scope.student_relationList[j].id == $scope.registerMsg.userGuardianInfos[0].userRelationship) {
        							$scope.registerMsg.userGuardianInfos[0].userRelationship_text = $scope.student_relationList[j].content;
        						}
        						if($scope.student_relationList[j].id == $scope.registerMsg.userGuardianInfos[1].userRelationship) {
        							$scope.registerMsg.userGuardianInfos[1].userRelationship_text = $scope.student_relationList[j].content;
        						}
        						if($scope.student_relationList[j].id == $scope.registerMsg.userHouseInfo.houseOwnerType) {
        							$scope.registerMsg.userHouseInfo.houseOwnerType_text = $scope.student_relationList[j].content;
        						}
        					}
        					relationSet = true;
        				}
        				//国家
        				if($scope.allCountry) {
        					for(var m=0;m<$scope.allCountry.length;m++) {
        						if($scope.allCountry[m].id == $scope.registerMsg.userExtendedInfo.country) {
        							$scope.registerMsg.userExtendedInfo.country_text = $scope.allCountry[m].content;
        							break;
        						}
        					}
        					countrySet = true;
        				}
        				//民族
        				if($scope.allNation) {
        					for(var n=0;n<$scope.allCountry.length;n++) {
        						if($scope.allNation[n].id == $scope.registerMsg.userExtendedInfo.nation) {
        							$scope.registerMsg.userExtendedInfo.nation_text = $scope.allNation[n].content;
        							break;
        						}
        					}
        					nationSet = true;
        				}
        				//招生类别
        				if('1' == $scope.registerMsg.user.type) {
        					$scope.registerMsg.user.type_text = '一类';
        				} else if('2' == $scope.registerMsg.user.type) {
        					$scope.registerMsg.user.type_text = '二类';
        				} else if('3' == $scope.registerMsg.user.type) {
        					$scope.registerMsg.user.type_text = '三类';
        				}
        				//性别
        				if('1' == $scope.registerMsg.user.sex) {
        					$scope.registerMsg.user.sex_text = '男';
        				} else if('0' == $scope.registerMsg.user.sex) {
        					$scope.registerMsg.user.sex_text = '女';
        				}
        				//港澳台
        				if(!$scope.registerMsg.userExtendedInfo.noMainland) {
            				$scope.registerMsg.userExtendedInfo.noMainland_text = '否';
        				} else {
        					$scope.registerMsg.userExtendedInfo.noMainland_text = '是';
        				}
        				//健康状况
        				if($scope.allHealth) {
        					for(var o=0;o<$scope.allHealth.length;o++) {
        						if($scope.allHealth[o].value == $scope.registerMsg.userExtendedInfo.healthCondition) {
        							$scope.registerMsg.userExtendedInfo.healthCondition_text = $scope.allHealth[o].label;
        							break;
        						}
        					}
        				}
        				//是否独生
        				if(null != $scope.registerMsg.userExtendedInfo.oneChild) {
            				if(!$scope.registerMsg.userExtendedInfo.oneChild) {
                				$scope.registerMsg.userExtendedInfo.oneChild_text = '否';
            				} else {
            					$scope.registerMsg.userExtendedInfo.oneChild_text = '是';
            				}
        				}
        				//是否上过小学/幼儿园
        				if(!$scope.registerMsg.userExtendedInfo.graduated) {
            				$scope.registerMsg.userExtendedInfo.graduated_text = '否';
        				} else {
        					$scope.registerMsg.userExtendedInfo.graduated_text = '是';
        				}
        				//是否留守
        				if(null != $scope.registerMsg.userExtendedInfo.leftBehindChildren) {
            				if(!$scope.registerMsg.userExtendedInfo.leftBehindChildren) {
                				$scope.registerMsg.userExtendedInfo.leftBehindChildren_text = '否';
            				} else {
            					$scope.registerMsg.userExtendedInfo.leftBehindChildren_text = '是';
            				}
        				}
        				//是否进城
        				if(null != $scope.registerMsg.userExtendedInfo.workToCity) {
            				if(!$scope.registerMsg.userExtendedInfo.workToCity) {
                				$scope.registerMsg.userExtendedInfo.workToCity_text = '否';
            				} else {
            					$scope.registerMsg.userExtendedInfo.workToCity_text = '是';
            				}
        				}
        				//是否孤儿
        				if(null != $scope.registerMsg.userExtendedInfo.orphan) {
            				if(!$scope.registerMsg.userExtendedInfo.orphan) {
                				$scope.registerMsg.userExtendedInfo.orphan_text = '否';
            				} else {
            					$scope.registerMsg.userExtendedInfo.orphan_text = '是';
            				}
        				}
        				//是否残疾
        				if(null != $scope.registerMsg.userExtendedInfo.disabilityType) {
            				if('0' == $scope.registerMsg.userExtendedInfo.disabilityType) {
                				$scope.registerMsg.userExtendedInfo.disabilityType_text = '否';
            				} else {
            					$scope.registerMsg.userExtendedInfo.disabilityType_text = '是';
            				}
        				}
        				//是否法定监护人222
        				if(null != $scope.registerMsg.userGuardianInfos[0].guarder) {
            				if(!$scope.registerMsg.userGuardianInfos[0].guarder) {
            					$scope.registerMsg.userGuardianInfos[0].guarder_text = '否';
            				} else {
            					$scope.registerMsg.userGuardianInfos[0].guarder_text = '是';
            				}
        				}
        				if(null != $scope.registerMsg.userGuardianInfos[1].guarder) {
            				if(!$scope.registerMsg.userGuardianInfos[1].guarder) {
            					$scope.registerMsg.userGuardianInfos[1].guarder_text = '否';
            				} else {
            					$scope.registerMsg.userGuardianInfos[1].guarder_text = '是';
            				}
        				}
        				//房产类型
    			        if(1 == $scope.registerMsg.userHouseInfo.houseType) {
            				$scope.registerMsg.userHouseInfo.houseType_text = '产权房';
        				} else if(2 == $scope.registerMsg.userHouseInfo.houseType) {
        					$scope.registerMsg.userHouseInfo.houseType_text = '租赁房';
        				} else if(0 == $scope.registerMsg.userHouseInfo.houseType) {
        					$scope.registerMsg.userHouseInfo.houseType_text = '无';
        				}
        				//户口性质
    			        if(0 == $scope.registerMsg.userHouseInfo.liveType) {
    			        	$scope.registerMsg.userHouseInfo.liveType_text = '农村';
        				} else if(1 == $scope.registerMsg.userHouseInfo.liveType) {
        					$scope.registerMsg.userHouseInfo.liveType_text = '城镇';
        				}
        				if(nationSet && countrySet && relationSet && cardSet) {
        					clearInterval(reviewInterval);
        				}
        			}, 500);
        		} else if(res.msg) {
    				layer.alert(res.msg);
    			}
        	});
    	} else if(!$scope.review) {
    		//校验注册时间
    		services.get_date_plan().success(function(resp) {
    			if ('OK' == resp.result) {
    				if(resp.msg) {
    					var nowDate = new Date().getTime();
    					if(resp.msg.registerStartTime && nowDate < resp.msg.registerStartTime) {
    						layer.confirm('不在注册时间内', {
                                btn: ['确定'] 
                            }, function () {
                            	window.location.href = "/pages/index.html";
                            });
    						var goHomeTimeOut = setTimeout(function() {
    							window.location.href = "/pages/index.html";
    						}, 3000);
    					} else if(resp.msg.registerEndTime && nowDate > resp.msg.registerEndTime) {
    						layer.confirm('不在注册时间内', {
                                btn: ['确定'] 
                            }, function () {
                            	window.location.href = "/pages/index.html";
                            });
    						var goHomeTimeOut = setTimeout(function() {
    							window.location.href = "/pages/index.html";
    						}, 3000);
    					}
    				}
    			}
    		})
    	}

    };

    $scope.load();
    
    $scope.checkStuCode = function() {
    	if(!('junior' == $scope.toSignUp && $scope.registerMsg.userExtendedInfo.graduated)) {
    		return;
    	}
    	$scope.stu_code_pass = false;
    	if($scope.registerMsg.userExtendedInfo.schoolNumber && $scope.registerMsg.userExtendedInfo.formerSchool && $scope.registerMsg.user.username) {
    		services.check_stu_code({'studentNumber':$scope.registerMsg.userExtendedInfo.schoolNumber}).success(function(resp) {
    			if ('OK' == resp.result) {
    				if(resp.msg && resp.msg.studentName && resp.msg.school && resp.msg.studentName == $scope.registerMsg.user.username && $scope.registerMsg.userExtendedInfo.formerSchool == resp.msg.school) {
        				$scope.stu_code_pass = true;
    				}
    			}
    		})
    	}
    }
    
    function checkStuCardNum(scope) {
    	services.checkStuCardNum({"idCard":scope.registerMsg.user.idCard}).success(function(resp) {
			if ("OK" == resp.result) {
				scope.idCard1Invalid = false;
			} else {
				scope.idCard1Invalid = true;
			}
		})
    }
    
    function checkCard(type, num) {
    	if(1 == type) {
    		tempReg = reg1;
    	} else if(2 == type) {
    		tempReg = reg2;
    	}

		if(!tempReg.test(num)) {
			return false;
		} else if(!cities[num.substr(0,2)]){
			return false;
		} else {
			if(num.length == 18){
				num = num.split('');
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = num[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                var last = parity[sum % 11];
                if(parity[sum % 11] != num[17]){
                    return false;
                } else {
                	return true;
                }
            } else {
            	return false;
            }
		}
    }
});