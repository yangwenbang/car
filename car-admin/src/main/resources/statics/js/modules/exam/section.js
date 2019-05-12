$(function () {
    sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0]
    $("#jqGrid").jqGrid({
        url: baseURL + 'car/section/list',
        datatype: "json",
        postData: {sectionId:sectionId},
        colModel: [			
			{ label: '章名称', name: 'chapterId', index: 'chapter_id', width: 80,formatter: setChapterName},
			{ label: '节名称', name: 'sectionName', index: 'section_name', width: 80 }, 			
			{ label: '节长度', name: 'timeLength', index: 'time_length', width: 80 },
			{ label: '课件类型', name: 'sectionType', index: 'section_type', width: 80,formatter: setSectionType},
            { label: '试卷抬头', name: 'carTitle', index: 'car_title', width: 80 },
            { label: '题型模板', name: 'exerciseModel', index: 'exercise_model', width: 80 },
			{label: '课件内容网址', name: 'sectionUrl', index: 'section_url', width: 80 },
			{ label: '资料内容(html)', name: 'sectionContent', index: 'section_content', width: 80 }, 			
			{ label: '备注', name: 'remark', index: 'remark', width: 80 }, 			
			{ label: '是否免费(0不免费/1免费)', name: 'free', index: 'free', width: 80,formatter: setFreeName },
			{ label: '讲义', name: 'handout', index: 'handout', width: 80 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }

    });
});
function setFreeName(cellvalue, options, rowObject){
	var free = "不免费"
    if(rowObject.free == "1"){
        free = "免费"
	}
    return '<span>'+free+'</span>';
}
function setSectionType(cellvalue, options, rowObject){
    var type = "视频"
    if(rowObject.sectionType == "1"){
        type = "资料"
    }
    if(rowObject.sectionType == "2"){
        type = "试卷"
    }
    return '<span>'+type+'</span>';
}
function setChapterName(cellvalue, options, rowObject){
    var  getval = document.URL.split('?')[1];
    return '<span>'+decodeURI(getval.split("=")[2])+'</span>';
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
        find:"",
		title: null,
		section: {},
		chapterName: decodeURI(document.URL.split('?')[1].split("=")[2]),
        exerciseTypeList:{},
        editor:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.section = {};
            var url = "car/section/getExerciseModel";
            /*var E = window.wangEditor
            vm.editor = new E('#editor')
            vm.editor.create();*/
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    if(r.code === 0){
                        vm.exerciseTypeList = r.exerciseTypeList
						vm.section.sectionType = 0;
                        vm.section.free = 0;
                        vm.section.exerciseModel = r.exerciseTypeList[0].exerciseModel
                    }else{
                        alert(r.msg);
                    }
                }
            });
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            var url = "car/section/getExerciseModel";
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    if(r.code === 0){
                        vm.exerciseTypeList = r.exerciseTypeList
                        vm.getInfo(id);
                    }else{
                        alert(r.msg);
                    }
                }
            });
		},
		saveOrUpdate: function (event) {
			var url = vm.section.id == null ? "car/section/save" : "car/section/update";
            vm.section.chapterId = document.URL.split('?')[1].split("=")[1].split("&")[0];
            /*vm. = vm.editor.txt.getJSON()*/
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.section),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "car/section/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "car/section/info/"+id, function(r){
                vm.section = r.section;
            });
		},
		reload: function (event) {
			vm.showList = true;
            var sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0];
            if (vm.find == ""){
                vm.find = null;
            }
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'find': vm.find,"sectionId":sectionId},
                page:page
            }).trigger("reloadGrid");
		},
		deliveryIdName: function(){
            var id = getSelectedRow();
            if(id == null){
               return ;
            }
            var rowData = $("#jqGrid").jqGrid("getRowData",id);
            window.location.href="exercisecontent.html?sectionId="+id+"&sectionName="+encodeURI(rowData.sectionName);
        }
	},
});