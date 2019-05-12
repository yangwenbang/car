$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'car/teacher/list',
        datatype: "json",
        colModel: [			
			{ label: '手机号码', name: 'teacherMobile', index: 'teacher_mobile', width: 80 },
			{ label: '姓名', name: 'teacherName', index: 'teacher_name', width: 80 },
			{ label: '性别', name: 'sex', index: 'sex', width: 80,sortable: false, editable: false,formatter: changeSex},
			{ label: '所在城市', name: 'cityName', index: 'cityName', width: 80 },
			{ label: '教学特长(擅长科目)', name: 'teacherSpecial', index: 'teacher_special', width: 80 },
			{ label: '学历', name: 'education', index: 'education', width: 80 },
			/*{ label: '头像图片网址', name: 'headPictureUrl', index: 'head_picture_url', width: 80 }*/
            { label: '教师图片',name: 'headPictureUrl', index: 'headPictureUrl', width: 100, align: "center", sortable: false, editable: false,formatter: alarmFormatter }
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
function alarmFormatter(cellvalue, options, rowObject) {
    return '<img src='+rowObject.headPictureUrl+' style="width:50px;height:50px;" />';
}
function changeSex(cellvalue, options, rowObject){
    var sex = "女";
    if(rowObject.sex == "1"){
        sex = "男";
    }
    return '<span>'+sex+'</span>';
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		q: {
            teacherName:null
		},
		showList: true,
		title: null,
		teacher: {},
		cityList: {},
		subjectList: {},
		img :""
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
            var url = "car/teacher/load";
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.cityList = r.teacher.cityList;
                        co.subjectList = r.teacher.subjectList;
                        vm.cityList = co.cityList;
                        vm.subjectList = co.subjectList;
                        vm.teacher.cityId = vm.cityList[0].id;
                        vm.teacher.sex = '1';
                        vm.teacher.isFamous = '1';
                        vm.teacher.subjectName = vm.subjectList[0].id;
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
            var url = "car/teacher/load";
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.cityList = r.teacher.cityList;
                        co.subjectList = r.teacher.subjectList;
                        vm.cityList = co.cityList;
                        vm.subjectList = co.subjectList;
                    }else{
                        alert(r.msg);
                    }
                }
            });
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.teacher.id == null ? "car/teacher/save" : "car/teacher/update";
            var formData = new FormData();
            formData.append("teacher",$.toJSON(vm.teacher));
            formData.append("file",vm.img);
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: false,
                processData: false,
                data: formData,
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.teacher = {};
                            $("#fileup").val("");
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
				    url: baseURL + "car/teacher/delete",
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
			$.get(baseURL + "car/teacher/info/"+id, function(r){
                vm.teacher = r.teacher.teacherEntity;
                vm.teacher.cityName = r.teacher.cityEntity.id
                vm.teacher.subjectName = r.teacher.subjectEntity.id
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'teacherName': vm.q.teacherName},
                page:page
            }).trigger("reloadGrid");
		},
        fileChange: function (el) {
            if (!el.target.files[0].size) return;
            var file = $("#fileup")[0].files[0];
            var obj = new FormData();
            obj.append("file", file);
            var _this = this;
            _this.img=file;
        }
	}
});