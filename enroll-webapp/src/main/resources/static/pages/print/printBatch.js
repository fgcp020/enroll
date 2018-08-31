/*myApp.controller('notifierBatchController', function ($scope) {
	
});*/
//模板
var printObj = {
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

//通过url参数拼接到模板对应参数
var dataArr = location.search.substring(1).split("&&");
$.each(dataArr, function(index, e) {
	printObj.paramList[index].objName = decodeURIComponent(e);
})

//清空页面，使其渲染整个页面
//$("body").empty();
//$("body").append('<div id="toPrint"></div>');

//屏幕自适应
suitScreen();			    
//组装页面
assembleHtml();

function suitScreen() {
    var effectiveHeight = findParam("#toPrint", "height") -30;
    var effectiveWidth = findParam("#toPrint","width");
	//var effectiveHeight = window.screen.height - 200;
	//var effectiveWidth = window.screen.width - 50;
    if(printObj.notifierObj.width/effectiveWidth > printObj.notifierObj.height/effectiveHeight) {
    	//取最接近的一个属性进行自适应，并适当调小一些
    	var suitTimes = printObj.notifierObj.width/effectiveWidth*1.2;
    } else {
    	var suitTimes = printObj.notifierObj.height/effectiveHeight*1.2;
    }
    printObj.notifierObj.width = printObj.notifierObj.width/suitTimes;
    printObj.notifierObj.height = printObj.notifierObj.height/suitTimes;
    for(i=0;i<printObj.paramList.length;i++) {
    	printObj.paramList[i].size = printObj.paramList[i].size/suitTimes;
    	printObj.paramList[i].left = printObj.paramList[i].left/suitTimes;
    	printObj.paramList[i].top = printObj.paramList[i].top/suitTimes;
    }
}

function assembleHtml() {
	var htmlStr = "<img src='" + printObj.notifierObj.url+"' style='width:"+printObj.notifierObj.width+"px;height:"+
		printObj.notifierObj.height+"px'>";
	for(i=0;i<printObj.paramList.length;i++) {
		var nowObj = printObj.paramList[i];
		if(nowObj.size < 12) {
			htmlStr += "<div style='font-size:"+nowObj.size+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
			//谷歌浏览器字体小于12px时会不再变小，使用-webkit-transform兼容，并设置已左上角作为变换原点
				"px;-webkit-transform:scale("+nowObj.size/12+","+nowObj.size/12+");transform-origin:0 0'>"+nowObj.objName+"</div>";
		} else {
			htmlStr += "<div style='font-size:"+nowObj.size+"px;top:"+nowObj.top+"px;left:"+nowObj.left+
				"px'>"+nowObj.objName+"</div>";
		}
	}
	$("#toPrint").css("margin-left", (0-printObj.notifierObj.width)/2+"px");
	$("#toPrint").css("margin-top", (0-printObj.notifierObj.height-60)/2+"px");
	$("#toPrint").css("height", printObj.notifierObj.height+"px");
	$("#toPrint").css("width", printObj.notifierObj.width+"px");
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