var myDirectives = angular.module('myDirectives', [])
//列表插件
    .directive('gridTable', [function () {
        return {
            restrict: 'E',
            templateUrl: "/plugins/gridtable/main.html",
            scope: true,
            replace: true,
            link: function (scope, el, attr) {
                var control = scope[attr.control];
                control.unpager = attr.unpager;
                //数据加载
                control.loadData = function (data, allData) {
                	if(!data) {
                		return;
                	}
                    control.data = data;
                    control.allData = allData;
                    control.config.param["total"] = parseInt(allData.length);
                    //control.config.param["pages"] = parseInt(data.pages);
                    //control.config.param["pageNum"] = parseInt(data.pageNum)
                    if (!control.config.param["total"]) {
                        control.config.param["total"] = 0
                    }
                    if (!control.config.param["pages"]) {
                        control.config.param["pages"] = 0
                    }
                    /*if (!control.config.param["pageNum"]) {
                        control.config.param["pageNum"] = 1
                    }*/
                    //control.config.pagerNumCol = parseInt(data.pageNum);
                    control.rows = [];
                    control.config.selectAll = false;
                    angular.forEach(control.data, function (rowdata, rowindex) {
                        var row = [];
                        angular.forEach(control.config.columns, function (item, index) {

                            var filed = rowdata[item.field];
                            if (filed == null || filed == undefined) {
                                filed = "";
                            }
                            var col = {};
                            for (var i in item) {
                                col[i] = item[i];
                            }
                            if (item.formatter) {
                                filed = item.formatter(filed, rowdata, rowindex)
                            }
                            if (filed && filed.length > 100)
                                col.value = scope._trustAsHtml('<span class="langText">' + filed + '</span>');
                            else
                                col.value = scope._trustAsHtml('<span class="sortFiled">' + filed + '</span>');
                            row.push(col);
                        })
                        control.rows.push({
                            index: rowindex,
                            data: row,
                            select: false,
                            marked:rowdata._tableTrMarked //标记变色
                        });
                    })

                    if (control.config.param.pages > 1 || control.config.param.rows > 1) {
                        $("#public_table_pager", el).parent().find('>div').show();
                        $(".table_pager .layui-btn", el).unbind("click").bind("click", function () {
                            var did = $(this).attr("did");
                            $(".layui-btn", this.parentNode).addClass("layui-btn-primary");
                            $(this).removeClass("layui-btn-primary");
                            control.config.param.pageSize = parseInt(did);
                            control.config.param.pageNum = 1;
                            control.loadData(allData.slice(0, control.config.param.pageSize), allData);
                        });
                        control.config.param.pageSize = !control.config.param.pageSize ? 10 : control.config.param.pageSize;
                        //默认分页数
                        $(".table_pager .layui-btn[did='" + control.config.param.pageSize + "']", el).removeClass("layui-btn-primary");
                        
                        laypage({    
                            cont: 'public_table_pager',    
                            pages: Math.ceil(allData.length/control.config.param.pageSize), //总页数    
                            totalData:allData.length,//总数据量  
                            everyPage://function(){//每页数据量  
                            	control.config.param.pageSize,
                            curr: /*function(){ //通过url获取当前页，也可以同上（pages）方式获取    
                                var page = location.search.match(/page=(\d+)/);    
                                return page ? page[1] : 1;    
                            }(), */  
                            	control.config.param.pageNum,
                            skin: '#1E9FFF', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00    
                            groups: 7 ,//连续显示分页数    
                            skip: true, //是否开启跳页    
                            prev: '<', //若不显示，设置false即可    
                            next: '>', //若不显示，设置false即可    
                            jump: function(e, first){ //触发分页后的回调    
                                if(!first){ //一定要加此判断，否则初始时会无限刷新    
                                    control.config.param.pageNum = e.curr;
                                	control.loadData(allData.slice(((e.curr -1) *  control.config.param.pageSize), e.curr *  control.config.param.pageSize), allData);
                                }    
                            }    
                        });  
                    }
                    else if(control.rows.length > 0){
                        $("#public_table_pager", el).empty();
                        $("#public_table_pager", el).parent().find('>div').show();
                        $(".table_pager .layui-btn", el).unbind("click").bind("click", function () {
                            var did = $(this).attr("did");
                            $(".layui-btn", this.parentNode).addClass("layui-btn-primary");
                            $(this).removeClass("layui-btn-primary");
                            control.config.param.pageSize = parseInt(did);
                            control.config.param.pageNum = 1;
                            control.loadData(allData.slice(0, control.config.param.pageSize), allData);
                        });
                        control.config.param.pageSize = !control.config.param.pageSize ? 10 : control.config.param.pageSize;
                        //默认分页数
                        $(".table_pager .layui-btn[did='" + control.config.param.pageSize + "']", el).removeClass("layui-btn-primary");
                        
                        laypage({    
                            cont: 'public_table_pager',    
                            pages: Math.ceil(allData.length/control.config.param.pageSize), //总页数    
                            totalData:allData.length,//总数据量  
                            everyPage://function(){//每页数据量  
                            	control.config.param.pageSize,
                            curr: /*function(){ //通过url获取当前页，也可以同上（pages）方式获取    
                                var page = location.search.match(/page=(\d+)/);    
                                return page ? page[1] : 1;    
                            }(), */  
                            	control.config.param.pageNum,
                            skin: '#1E9FFF', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00    
                            groups: 7 ,//连续显示分页数    
                            skip: true, //是否开启跳页    
                            prev: '<', //若不显示，设置false即可    
                            next: '>', //若不显示，设置false即可    
                            jump: function(e, first){ //触发分页后的回调    
                                if(!first){ //一定要加此判断，否则初始时会无限刷新    
                                    control.config.param.pageNum = e.curr;
                                	control.loadData(allData.slice(((e.curr -1) *  control.config.param.pageSize), e.curr *  control.config.param.pageSize), allData);
                                }    
                            }    
                        });  
                    }
                    else {
                        $("#public_table_pager", el).empty();
                        $("#public_table_pager", el).parent().find('>div:not(:last)').hide();
                    }
                    if (control.callback) {
                        setTimeout(function () {
                            control.callback();
                        }, 50);
                    }
                }
                //自动初始化
                control.init = function () {
                    angular.forEach(control.config.columns, function (item, index) {
                        item.align = !item.align ? 'center' : item.align;
                        item.width = !item.width ? 'auto' : item.width;
                        item.orderType = !item.orderType ? 'desc' : item.orderType;
                    })
                    if (control.data) {
                        control.loadData(control.data);
                    }
                    else {
                        if (control.reload)
                            control.reload(control.config.param);
                    }
                }
                //排序
                control.orderBy = function (t) {
                    //if (t.order) {
                	if(t.field) {
                		var sortData = control.data.sort(sortObjList(t.field, t.orderType));
                        t.orderType = t.orderType == "desc" ? "asc" : "desc";
                        control.loadData(sortData, control.allData);
                	}
                }
                function sortObjList(prop, orderType) {
                    return function (obj1, obj2) {
                        var val1 = obj1[prop];
                        var val2 = obj2[prop];
                        if (!isNaN(Number(val1)) && !isNaN(Number(val2))) {
                            val1 = Number(val1);
                            val2 = Number(val2);
                        }
                        if("desc" == orderType) {
            	            if (val1 < val2) {
            	                return -1;
            	            } else if (val1 > val2) {
            	                return 1;
            	            } else {
            	                return 0;
            	            }    
        	            } else {
            	            if (val1 < val2) {
            	                return 1;
            	            } else if (val1 > val2) {
            	                return -1;
            	            } else {
            	                return 0;
            	            }    
        	            }           
                    } 
                }
                //全选
                control.unSelectAll = function () {
                    control.config.selectAll = !control.config.selectAll;
                    angular.forEach(control.rows, function (row) {
                        row.select = control.config.selectAll;
                    })
                }
                //行选择
                control.unSelectRow = function (row) {
                    row.select = !row.select;
                    var bool = true;
                    angular.forEach(control.rows, function (line) {
                        if (!line.select)
                            bool = false;
                    })
                    control.config.selectAll = bool;
                }
                scope.gridTableControl = control;
                scope.gridTableControl.init();
            }
        };
    }])
    //日历控件
    .directive('dateTimePicker', function () {
        return {
            restrict: 'ECA',
            link: function (scope, element, attr) {
                var _conf = {
                    lang: 'zh'
                };
                if (attr.step) {
                    _conf.step = parseInt(attr.step);
                }
                if (attr.plugintype == 'date') {
                    _conf.format = attr.format || 'Y-m-d H:i';
                    $(element).datetimepicker(_conf);
                } else if (attr.plugintype == 'datetime') {
                    _conf.format = attr.format || 'Y-m-d';
                    _conf.timepicker = false;
                    $(element).datetimepicker(_conf);
                } else if (attr.plugintype == 'time') {
                    _conf.format = attr.format || 'H:i:s';
                    _conf.datepicker = false;
                    $(element).datetimepicker(_conf);
                }
            }
        };
    })
    //排序
    .directive('sortControl', function () {
        return {
            restrict: 'ECA',
            link: function (scope, element, attr) {
                $(".layui-btn", element).bind("click", function () {
                    var input = $("input", this.parentNode);
                    var d = new Date();
                    input.val(d.getTime()).change();
                })
            }
        };
    })
    //机构选择
    .directive('selOrg', function () {
        return {
            restrict: 'ECA',
            //templateUrl: ctxPath + "/static/admin/plugin/selOrg/main.html",
            templateUrl: "/plugins/selOrg/main.html",
            replace: true,
            link: function (scope, element, attr) {
                var layer_org = null;
                var control = null;
                //机构列表
                scope.orgTableControl = {
                    config: {
                        check: attr.check,
                        param: {
                            pageNum: 1, //当前页
                            pageSize: 10, //每页条数
                            searchText: null
                        },
                        columns: [
                            {field: 'org_name', title: "机构名称", align: 'left'},
                            {field: 'extend_code', title: "机构编码"},
                            {field: 'project_name', title: "所属项目"}
                        ]
                    },
                    reload: function (param) {
                        scope.services._outfit_list(param).success(function (res) {
                            control.loadData(res.data);
                        })
                    }
                }
                control = scope.orgTableControl;
                scope.openOrg = function (callback) {
                    layer_org = layer.open({
                        type: 1,
                        title: "选择机构",
                        area: ["800px", "600px"],
                        content: $("#Select_Org")
                    });
                    control.callback = callback;
                }
                //确认
                control.config_btn = function () {
                    var array = [];
                    angular.forEach(control.rows, function (line) {
                        if (line.select)
                            array.push(line.source)
                    });
                    if (array.length > 0) {
                        layer.close(layer_org);
                        if (control.callback)
                            control.callback(array);
                    }
                    else {
                        layer.alert("你还未选择任何机构");
                    }
                }
                //取消
                control.df_btn = function () {
                    layer.close(layer_org);
                }
                //数据加载
                control.loadData = function (data) {
                    control.data = data.rows ? data.rows : data.children;
                    control.config.param["total"] = parseInt(data.total);
                    control.config.param["pages"] = parseInt(data.pages);
                    control.config.param["pageNum"] = parseInt(data.pageNum);
                    control.config.pagerNumCol = parseInt(data.pageNum);
                    control.rows = [];
                    control.config.selectAll = false;
                    angular.forEach(control.data, function (rowdata, rowindex) {
                        var row = [];
                        angular.forEach(control.config.columns, function (item, index) {
                            var filed = rowdata[item.field];
                            if (filed == null || filed == undefined) {
                                filed = "";
                            }
                            var col = {};
                            for (var i in item) {
                                col[i] = item[i];
                            }
                            if (item.formatter) {
                                filed = item.formatter(filed, rowdata, rowindex)
                            }
                            col.value = scope._trustAsHtml('<span>' + filed + '</span>');
                            row.push(col);
                        })
                        control.rows.push({
                            index: rowindex,
                            data: row,
                            select: false,
                            source: rowdata
                        });
                    })

                    if (control.config.param.pages > 1 || control.rows.length > 1) {
                        //处理分页
                        layui.laypage({
                            cont: "org_table_pager",
                            pages: control.config.param.pages,
                            curr: control.config.param.pageNum,
                            groups: 0,
                            first: false,
                            last: false,
                            jump: function (resPager) {
                                if (resPager.curr != control.config.param.pageNum) {
                                    control.config.param.pageNum = parseInt(resPager.curr);
                                    if (control.reload)
                                        control.reload(control.config.param);
                                }
                            }
                        });
                    }
                    else {
                        $("#org_table_pager").empty();
                    }
                }

                //自动初始化
                control.init = function () {
                    angular.forEach(control.config.columns, function (item, index) {
                        item.align = !item.align ? 'center' : item.align;
                        item.width = !item.width ? 'auto' : item.width;
                        item.orderType = !item.orderType ? 'desc' : item.orderType;
                    })
                    if (control.data) {
                        control.loadData(control.data);
                    }
                    else {
                        control.reload(control.config.param);
                    }
                }
                //重新查询
                control.reload_org = function () {
                    control.config.param["searchText"] = control.org_searchText;
                    control.config.param["pageNum"] = 1;
                    control.reload(control.config.param);
                }
                //排序
                control.orderBy = function (t) {
                    if (t.order) {
                        t.orderType = t.orderType == "desc" ? "asc" : "desc";
                        control.config.param.orderField = t.field;
                        control.config.param.orderType = t.orderType;
                        if (control.reload)
                            control.reload(control.config.param);
                    }
                }
                //全选
                control.unSelectAll = function () {
                    control.config.selectAll = !control.config.selectAll;
                    angular.forEach(control.rows, function (row) {
                        row.select = control.config.selectAll;
                    })
                }
                //行选择
                control.unSelectRow = function (row) {
                    row.select = !row.select;
                    if (control.config.check) {
                        var bool = true;
                        angular.forEach(control.rows, function (line) {
                            if (!line.select)
                                bool = false;
                        })
                        control.config.selectAll = bool;
                    }
                    else {
                        angular.forEach(control.rows, function (line) {
                            if (row != line) {
                                line.select = false;
                            }
                        })
                    }
                }
                control.init();
            }
        };
    })
    //设备列表
    .directive('selDevice', function () {
        return {
            restrict: 'ECA',
            //templateUrl: ctxPath + "/static/admin/plugin/selDevice/main.html",
            templateUrl: "/plugins/selDevice/main.html",
            replace: true,
            link: function (scope, element, attr) {
                var layer_org = null;
                var control = null;
                //设备列表
                scope.DeviceControl = {
                    config: {
                        check: attr.check,
                        param: {
                            pageNum: 1, //当前页
                            pageSize: 10, //每页条数
                        },
                        columns: [
                            {field: 'org_name', title: "机构", align: 'left'},
                            {field: 'device_code', title: "设备编号"},
                            {field: 'address', title: "地址"},
                            {field: 'location', title: "位置"},
                        ]
                    },
                    reload: function (param) {
                        //
                    }
                }
                control = scope.DeviceControl;
                scope.openOrg = function (callback) {
                    layer_org = layer.open({
                        type: 1,
                        title: "使用设备",
                        area: ["800px", "510px"],
                        content: $("#Select_Device")
                    });
                    control.callback = callback;
                }
                //数据加载
                control.loadData = function (data) {
                    control.data = data.rows ? data.rows : data.children;
                    control.config.param["total"] = parseInt(data.total);
                    control.config.param["pages"] = parseInt(data.pages);
                    control.config.param["pageNum"] = parseInt(data.pageNum);
                    control.config.pagerNumCol = parseInt(data.pageNum);
                    control.rows = [];
                    control.config.selectAll = false;
                    angular.forEach(control.data, function (rowdata, rowindex) {
                        var row = [];
                        angular.forEach(control.config.columns, function (item, index) {
                            var filed = rowdata[item.field];
                            if (filed == null || filed == undefined) {
                                filed = "";
                            }
                            var col = {};
                            for (var i in item) {
                                col[i] = item[i];
                            }
                            if (item.formatter) {
                                filed = item.formatter(filed, rowdata, rowindex)
                            }
                            col.value = scope._trustAsHtml('<span>' + filed + '</span>');
                            row.push(col);
                        })
                        control.rows.push({
                            index: rowindex,
                            data: row,
                            select: false,
                            source: rowdata
                        });
                    })
                    //删除
                    control.config_btn = function () {
                        var array = [];
                        angular.forEach(control.rows, function (line) {
                            if (line.select)
                                array.push(line.source)
                        });
                        if (array.length > 0) {
                            if (control.callback)
                                control.callback(array);
                        }
                        else {
                            layer.alert("你还未选择设备");
                        }
                    }
                    //取消
                    control.df_btn = function () {
                        layer.close(layer_org);
                    }
                    //处理分页
                    if (control.config.param.pages > 1 || control.rows.length > 1) {
                        //处理分页
                        layui.laypage({
                            cont: "device_table_pager",
                            pages: control.config.param.pages,
                            curr: control.config.param.pageNum,
                            groups: 0,
                            first: false,
                            last: false,
                            jump: function (resPager) {
                                if (resPager.curr != control.config.param.pageNum) {
                                    control.config.param.pageNum = parseInt(resPager.curr);
                                    if (control.reload)
                                        control.reload(control.config.param);
                                }
                            }
                        });
                    }
                    else {
                        $("#device_table_pager").empty();
                    }
                }

                //自动初始化
                control.init = function () {
                    angular.forEach(control.config.columns, function (item, index) {
                        item.align = !item.align ? 'center' : item.align;
                        item.width = !item.width ? 'auto' : item.width;
                        item.orderType = !item.orderType ? 'desc' : item.orderType;
                    })
                    if (control.data) {
                        control.loadData(control.data);
                    }
                    else {
                        control.reload(control.config.param);
                    }
                }
                //排序
                control.orderBy = function (t) {
                    if (t.order) {
                        t.orderType = t.orderType == "desc" ? "asc" : "desc";
                        control.config.param.orderField = t.field;
                        control.config.param.orderType = t.orderType;
                        if (control.reload)
                            control.reload(control.config.param);
                    }
                }
                //全选
                control.unSelectAll = function () {
                    control.config.selectAll = !control.config.selectAll;
                    angular.forEach(control.rows, function (row) {
                        row.select = control.config.selectAll;
                    })
                }
                //行选择
                control.unSelectRow = function (row) {
                    row.select = !row.select;
                    if (control.config.check) {
                        var bool = true;
                        angular.forEach(control.rows, function (line) {
                            if (!line.select)
                                bool = false;
                        })
                        control.config.selectAll = bool;
                    }
                    else {
                        angular.forEach(control.rows, function (line) {
                            if (row != line) {
                                line.select = false;
                            }
                        })
                    }
                }
                control.init();
            }
        };
    })
    // 小升初打印
    .directive('printTemplate', [function () {
        return {
            restrict: 'E',
            //templateUrl: ctxPath + "/static/admin/plugin/print/main.html",
            templateUrl: "/plugins/print/main.html",
            scope: true,
            replace: true,
            link: function (scope, el, attr) {
                var control = scope[attr.control];
                control.loadData = function (data) {
                    scope.printInfo = data
                    var qrcode = new QRCode(document.getElementById("qrcode"), {
                        width : 96,
                        height : 96
                    });
                    var bool=!!window.location.href.match('https://');
                    var url= bool && window.location.href.replace('https://','')||window.location.href.replace('http://','');
                    //////////////////
                    //qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+ctxPath+'/sweepNotification?type=student&id='+scope.printInfo.card_id);
                    qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+'/sweepNotification?type=student&id='+scope.printInfo.card_id);
                }
            }
        }
    }])
    // 幼儿园打印
    .directive('prePrintTemplate', [function () {
        return {
            restrict: 'E',
            //templateUrl: ctxPath + "/static/admin/plugin/kindergarten_print/main.html",
            templateUrl:  "/plugins/kindergarten_print/main.html",
            scope: true,
            replace: true,
            link: function (scope, el, attr) {
                var control = scope[attr.control];
                control.loadData = function (data) {
                    scope.printInfo = data;
                    console.log(data)
                    var qrcode = new QRCode(document.getElementById("qrcode"), {
                        width : 96,
                        height : 96
                    });
                    var bool=!!window.location.href.match('https://');
                    var url= bool && window.location.href.replace('https://','')||window.location.href.replace('http://','');
                    //qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+ctxPath+'/sweepNotification?type=kindergarten&id='+scope.printInfo.card_id);
                    qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+'/sweepNotification?type=kindergarten&id='+scope.printInfo.card_id);
                }
            }
        }
    }])
    // 幼升小打印
    .directive('smallPrintTemplate', [function () {
        return {
            restrict: 'E',
            //templateUrl: ctxPath + "/static/admin/plugin/primary_print/main.html",
            templateUrl: "/plugins/primary_print/main.html",
            scope: true,
            replace: true,
            link: function (scope, el, attr) {
                var control = scope[attr.control];
                control.loadData = function (data) {
                    scope.printInfo = data
                    var qrcode = new QRCode(document.getElementById("qrcode"), {
                        width : 96,
                        height : 96
                    });
                    var bool=!!window.location.href.match('https://');
                    var url= bool && window.location.href.replace('https://','')||window.location.href.replace('http://','');
                    //qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+ctxPath+'/sweepNotification?type=primary&id='+scope.printInfo.card_id);
                    qrcode.makeCode((bool && 'https://' || 'http://')+url.substring(0,url.indexOf('/'))+'/sweepNotification?type=primary&id='+scope.printInfo.card_id);
                }

            }
        }
    }]);
