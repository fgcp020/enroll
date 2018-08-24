myApp.controller('notifierController', function ($rootScope, $scope, services, $sce, $stateParams, $state) {
    $scope.services = services;
    
    //查询录取通知书内容
    services["getApplyStatus"] = function (param) {
        return $rootScope.serverAction('/apply/queryDegreeApplyInfo', param, "GET");
    };
    
    $scope.mobile = /Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent);
    if(1 == $rootScope._USERINFO.role || 2 == $rootScope._USERINFO.role) {
    	if($scope.mobile) {
        	$rootScope._ALLMENU = [{
    			children: [{
    				res_name: "查看审核状态",
    				res_url: "#status_mobile",
    				res_id: "#status_mobile"
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
    		//$rootScope.mobile_regstatus = true;
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
    $rootScope.curentSel = "#notifier";
    $rootScope.setContent = function(url) {
    	if($scope.mobile) {
        	$('#main-layout').removeClass('hide-side');
        	if(-1 < url.indexOf("#registerMsg")) {
        		window.open(encodeURI(encodeURI('/pages/index_mobile.html#/registers#review?id=' + $rootScope._USERINFO.id)));
        		window.location.href = "/pages/index_mobile.html#/home";
        		return;
        	} else {
        		$rootScope.curentSel = url;
        	}
    	} else {
        	if(-1 < url.indexOf("#registerMsg")) {
        		window.open(encodeURI(encodeURI('/pages/index.html#/registers#review?id=' + $rootScope._USERINFO.id)));
        		window.location.href = "/pages/index.html#/home";
        		return;
        	} else {
        		$rootScope.curentSel = url;
        	}
    	}
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
				"size": "28"
			},{
				"objName":"SXXX小学",
				"left":"460",
				"top":"272",
				"size": "28"
			},{
				"objName":"2018",
				"left":"195",
				"top":"312",
				"size": "28"
			},{
				"objName":"8",
				"left":"325",
				"top":"312",
				"size": "28"
			},{
				"objName":"31",
				"left":"405",
				"top":"312",
				"size": "28"
			}]
    }
    
    services.getApplyStatus('token').success(function(res) {
		if ('OK' == res.result) {
			if(res.msg) {
				userName = res.msg.studentName;
				$scope.printObj.paramList[0].objName = res.msg.studentName;
				$scope.printObj.paramList[1].objName = res.msg.applySchoolName;
				
			    //屏幕自适应
			    suitScreen($scope);			    
			    //组装页面
			    assembleHtml($scope);			    
			    //打印
			    //printNotifier();
			}
		} else {
			layer.alert(res.msg);
		}
	});
    
    //拖动
    /*$(document).on("mousedown","#toPrint",function(e){
        //webkit内核和火狐禁止文字被选中
        $('body').addClass('select')
        //ie浏览器禁止文字选中
        document.body.onselectstart=document.body.ondrag=function(){
            return false;
            }
        $scope.moveBegin = true;  
        $scope.mouseStartPoint = {"left":e.pageX,"top":  e.pageY};  
    });  
    $(document).on("mouseup",function(e){       
    	$scope.moveBegin = false;  
    }); 
    $(document).on("mousemove",function(e){
    	if(!$scope.moveBegin) {
    		return;
    	}
        $("#toPrint").css("margin-left", e.pageX - $scope.mouseStartPoint.left - 454 + "px");
        $("#toPrint").css("margin-top", e.pageY - $scope.mouseStartPoint.top - 315 + "px");
    });*/
});

var userName;

function saveNotifier() {
	//先转化为canvas,再转化为图片后保存
	html2canvas(document.querySelector("#toPrint")).then(canvas => {
	    //document.body.appendChild(canvas);
		var type = 'png';//格式可以自定义
		var imgData = canvas.toDataURL(type);
		// 加工image data，替换mime type
		imgData = imgData.replace(_fixType(type),'image/octet-stream');
		//可以直接用以下下载，但是下载的文件名没有后缀
		//window.location.href=image; // it will save locally
		//文件名可以自定义
		var filename = '录取通知书_' + userName + '.' + type;
		saveFile(imgData,filename);
	});
}

function _fixType(type) {
	//imgData是一串string，base64
    type = type.toLowerCase().replace(/jpg/i, 'jpeg');
    var r = type.match(/png|jpeg|bmp|gif/)[0];
    return 'image/' + r;
}

function saveFile(data, filename) {
	//命名空间
	var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
    save_link.href = data;
    save_link.download = filename;
   
    //window.location = save_link;//此方法可下载但是文件名无效
    //下载
    var event = document.createEvent('MouseEvents');
    event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
    save_link.dispatchEvent(event);
}

function convertCanvasToImage(canvas) {
    var image = new Image();
    image.src = canvas.toDataURL("image/png");
    return image;
}

function printNotifier() {   
	try{
        print.portrait = false;//横向打印 
    }catch(e){
        //alert("不支持此方法");
    }
	$("#printArea").jqprint();   
}

function suitScreen($scope) {
    var effectiveHeight = findParam("#toPrint", "height") -30;
    var effectiveWidth = findParam("#toPrint","width");
    if($scope.printObj.notifierObj.width/effectiveWidth > $scope.printObj.notifierObj.height/effectiveHeight) {
    	//取最接近的一个属性进行自适应，并适当调小一些
    	var suitTimes = $scope.printObj.notifierObj.width/effectiveWidth*1.2;
    } else {
    	var suitTimes = $scope.printObj.notifierObj.height/effectiveHeight*1.2;
    }
    $scope.printObj.notifierObj.width = $scope.printObj.notifierObj.width/suitTimes;
    $scope.printObj.notifierObj.height = $scope.printObj.notifierObj.height/suitTimes;
    for(i=0;i<$scope.printObj.paramList.length;i++) {
    	$scope.printObj.paramList[i].size = $scope.printObj.paramList[i].size/suitTimes;
    	$scope.printObj.paramList[i].left = $scope.printObj.paramList[i].left/suitTimes;
    	$scope.printObj.paramList[i].top = $scope.printObj.paramList[i].top/suitTimes;
    }
}

function assembleHtml($scope) {
	var htmlStr = "<img src='" + $scope.printObj.notifierObj.url+"' style='width:"+$scope.printObj.notifierObj.width+"px;height:"+
		$scope.printObj.notifierObj.height+"px'>";
	for(i=0;i<$scope.printObj.paramList.length;i++) {
		var nowObj = $scope.printObj.paramList[i];
		if(nowObj.size < 12) {
			htmlStr += "<div style='font-size:"+nowObj.size+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
			//谷歌浏览器字体小于12px时会不再变小，使用-webkit-transform兼容，并设置已左上角作为变换原点
				"px;-webkit-transform:scale("+nowObj.size/12+","+nowObj.size/12+");transform-origin:0 0'>"+nowObj.objName+"</div>";
		} else {
			htmlStr += "<div style='font-size:"+nowObj.size+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
				"px'>"+nowObj.objName+"</div>";
		}
	}
	$("#toPrint").css("margin-left", (0-$scope.printObj.notifierObj.width)/2+"px");
	$("#toPrint").css("margin-top", (0-$scope.printObj.notifierObj.height-60)/2+"px");
	$("#toPrint").css("height", $scope.printObj.notifierObj.height+"px");
	$("#toPrint").css("width", $scope.printObj.notifierObj.width+"px");
	$("#toPrint").append(htmlStr);
}

//获取有效区域
function findParam(targetObj, attribute) {
	//取数字
	if($(targetObj).css(attribute) && $(targetObj).css(attribute).replace(/[^0-9]/ig,"") != '0') {
		return $(targetObj).css(attribute).replace(/[^0-9]/ig,"");
	} else {
		//递归
		return findParam($(targetObj).parent(), attribute);
	}
}