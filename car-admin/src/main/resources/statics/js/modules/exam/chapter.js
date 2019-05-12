$(function () {
    var courseId = document.URL.split('?')[1].split("=")[1].split("&")[0];
    $("#jqGrid").jqGrid({
        url: baseURL + 'car/chapter/list',
        datatype: "json",
        postData: {courseId:courseId},
        colModel: [			
			{ label: '课程名称', name: courseId, index: 'course_id', width: 80 ,formatter: setCourseName},
			{ label: '章名称', name: 'chapterName', index: 'chapter_name', width: 80 }, 			
			{ label: '说明', name: 'description', index: 'description', width: 80 },
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
function setCourseName(cellvalue, options, rowObject){
    var  getval = document.URL.split('?')[1];
    return '<span>'+decodeURI(getval.split("=")[2])+'</span>';
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		find:"",
		showList: true,
		title: null,
        chapter: {},
        courseName: decodeURI(document.URL.split('?')[1].split("=")[2])
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.chapter = {};
            var  getval = document.URL.split('?')[1];
            vm.chapter.courseId = getval.split("=")[1].split("&")[0];
            vm.chapter.courseName = decodeURI(getval.split("=")[2])
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.chapter.id == null ? "car/chapter/save" : "car/chapter/update";
			vm.chapter.courseId = document.URL.split('?')[1].split("=")[1].split("&")[0];
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.chapter),
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
				    url: baseURL + "car/chapter/delete",
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
			$.get(baseURL + "car/chapter/info/"+id, function(r){
                vm.chapter = r.chapter;
            });
		},
		reload: function (event) {
            var courseId = document.URL.split('?')[1].split("=")[1].split("&")[0];
            if (vm.find == ""){
                vm.find = null;
			}
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'find': vm.find,"courseId":courseId},
                page:page
            }).trigger("reloadGrid");
		},
        deliveryIdName: function(){
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            var rowData = $("#jqGrid").jqGrid("getRowData",id);
            window.location.href="section.html?chapterId="+id+"&chapterName="+encodeURI(rowData.chapterName);
        }
	},
    created: function(){

	}
});