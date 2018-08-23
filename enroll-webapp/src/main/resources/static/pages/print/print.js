myApp.controller('notifierController', function ($rootScope, $scope, services, $sce, $stateParams, $state) {
    $scope.services = services;
    
    //查询录取通知书内容
    services["getApplyStatus"] = function (param) {
        return $rootScope.serverAction('/apply/queryDegreeApplyInfo', param, "GET");
    };
    
    //模板
    $scope.printObj = {
		notifierObj:{
			"url": "/res/img/notifications.png",
			"height": "631",
			"width": "942"
		},
		paramList:[{
				"objName":"黄小明",
				"left":"133",
				"top":"189",
				"size": "28"
			},{
				"objName":"SXXX小学",
				"left":"460",
				"top":"270",
				"size": "28"
			},{
				"objName":"2018",
				"left":"195",
				"top":"314",
				"size": "28"
			},{
				"objName":"8",
				"left":"325",
				"top":"314",
				"size": "28"
			},{
				"objName":"31",
				"left":"405",
				"top":"314",
				"size": "28"
			}]
    }
    
    services.getApplyStatus('token').success(function(res) {
		if ('OK' == res.result) {
			if(res.msg) {
				$scope.printObj.paramList[0].objName = res.msg.studentName;
				$scope.printObj.paramList[1].objName = res.msg.applySchoolName;
				
			    //屏幕自适应
			    suitScreen($scope);			    
			    //组装页面
			    assembleHtml($scope);			    
			    //打印
			    printNotifier();
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

function printNotifier() {   
	try{
        print.portrait = false;//横向打印 
    }catch(e){
        //alert("不支持此方法");
    }
    var HKEY_RootPath="HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
   /*try{
	   var WSc=new ActiveXObject("WScript.Shell"); 
	   HKEY_Key="header"; 
	   WSc.RegWrite(HKEY_RootPath+HKEY_Key,""); 
	   HKEY_Key="footer"; 
	   WSc.RegWrite(HKEY_RootPath+HKEY_Key,"");
  }catch(e){
	  
  }*/
	$("#printArea").jqprint();   
}

function suitScreen($scope) {
    var effectiveHeight = findParam("#toPrint", "height");
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
		htmlStr += "<div style='font-size:"+nowObj.size+"px;top:"+nowObj.top+"px;left:"+nowObj.left+"px'>"+nowObj.objName+"</div>";
	}
	$("#toPrint").css("margin-left", (0-$scope.printObj.notifierObj.width)/2+"px");
	$("#toPrint").css("margin-top", (0-$scope.printObj.notifierObj.height)/2+"px");
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