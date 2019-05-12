$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'car/course/list',
        datatype: "json",
        colModel: [			
			{ label: '课程名称', name: 'courseName', index: 'course_name', width: 80 },
            { label: '项目名称', name: 'projectName', index: 'project_name', width: 80 },
            { label: '分类名称', name: 'categoryName', index: 'category_name', width: 80 },
            { label: '学科名称', name: 'subjectName', index: 'subject_name', width: 80 },
            { label: '课时数', name: 'courseCount', index: 'course_count', width: 80 },
            { label: '价格', name: 'price', index: 'price', width: 80 },
            { label: '教师名称', name: 'teacherName', index: 'teacher_name', width: 80 },
            { label: '发布时间', name: 'replayDate', index: 'replay_date', width: 80 }
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
    laydate.render({
        elem: '#time', //指定元素
        choose: function(date){
            alert(date+"123");
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
        q:{
            courseName: null,
            categoryId: null,
            projectId :null
        },
		showList: true,
		title: null,
		course: {},
        projectList: {},
        subjectList: {},
        categoryList: {},
        teacherList: {},
        img:""
	},
	methods: {
       /* getCourseItem: function (event) {
                vm.menuList = menuList;
        },*/
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
            vm.course = {};
            $("#time").val("");
            var url = "car/course/addLoad";
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.projectList = r.course.projectList;
                        co.subjectList = r.course.subjectList;
                        co.categoryList = r.course.categoryList;
                        co.teacherList = r.course.teacherList;
                        vm.projectList = co.projectList;
                        vm.subjectList = co.subjectList;
                        vm.teacherList = co.teacherList;
                        vm.categoryList = co.categoryList;
                        vm.course.categoryId = vm.categoryList[0].id;
                        vm.course.teacherId = vm.teacherList[0].id;
                        vm.course.projectId = vm.projectList[0].id;
                        vm.course.subjectId = vm.subjectList[0].id;
                        vm.course.courseType = "0";
                        vm.course.effective = "0";
                        vm.course.isFamous = "0";
                    }else{
                        alert(r.msg);
                    }
                }
            });
		},
		update: function (course) {
			vm.showList = false;
            vm.title = "修改";
            var url = "car/course/updateLoad";
            $.ajax({
                type: "POST",
                data: JSON.stringify(course),
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.projectList = r.course.projectList;
                        co.subjectList = r.course.subjectList;
                        co.categoryList = r.course.categoryList;
                        co.teacherList = r.course.teacherList;
                        vm.projectList = co.projectList;
                        vm.subjectList = co.subjectList;
                        vm.categoryList = co.categoryList;
                        vm.teacherList = co.teacherList;

                        vm.course = course;
                        $("#time").val(course.replayDate);
                    }else{
                        alert(r.msg);
                    }
                }
            });
		},
        saveOrUpdate: function (event) {
            var formData = new FormData();
            vm.course.replayDate = $("#time").val();
            formData.append("course",$.toJSON(vm.course));
            formData.append("file",vm.img);
            var url = vm.course.id == null ? "car/course/save" : "car/course/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: false,
                processData: false,
                data: formData,
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(index){
                            vm.course = null;
                            $("#fileup").val("");
                            vm.img = "";
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
				    url: baseURL + "car/course/delete",
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
		getInfo: function(){
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
			$.get(baseURL + "car/course/info/"+id, function(r){
                r.course.pictureUrl = null;
			    vm.update(r.course);
            });
		},
		reload: function (event) {
            vm.showList = true;
            vm.before();
            if(vm.q.categoryId == "null"){
                vm.q.categoryId = null
            }
            if(vm.q.projectId == "null"){
                vm.q.projectId = null
            }
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'courseName': vm.q.courseName,'categoryId':vm.q.categoryId,'projectId':vm.q.projectId},
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
        },
        before: function(){
            var url = "car/course/selectLoad";
            $.ajax({
                type: "GET",
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.categoryList = r.course.categoryList;
                        co.projectList = r.course.projectList;
                        vm.course = co;
                        $("#fileup").val("");
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        addChangeProject: function(){
            var url = "car/course/categoryData";
            var projectId = vm.course.projectId;
            $.ajax({
                type: "GET",
                data: {"projectId":projectId},
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.categoryList = r.categoryList;
                        vm.categoryList = co.categoryList;
                        vm.subjectList = {};
                        if(vm.categoryList != null && vm.categoryList != ""){
                            vm.course.categoryId = vm.categoryList[0].id;
                            vm.addChangeCategory();
                        }

                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        addChangeCategory: function(){
            var subject = {}
            var url = "car/course/subjectData";
            subject.projectId = vm.course.projectId;
            subject.categoryId = vm.course.categoryId;
            $.ajax({
                type: "PSOT",
                data: JSON.stringify(subject),
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {};
                    if(r.code === 0){
                        co.subjectList = r.subjectList;
                        vm.subjectList = co.subjectList;
                        if(r.subjectList != null && r.subjectList != ""){
                            vm.course.subjectId = vm.subjectList[0].id;
                        }
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        listChangeProject: function(){
            var url = "car/course/categoryData";
            var projectId = vm.q.projectId;
            $.ajax({
                type: "GET",
                data: {projectId:projectId},
                url: baseURL + url,
                contentType: "application/json",
                success: function(r){
                    var co = {}
                    if(r.code === 0){
                        co.categoryList = r.categoryList;
                        vm.course.categoryList = co.categoryList;
                        vm.q.categoryId = "null"
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        deliveryIdName: function(){
            var id = getSelectedRow();
            if(id == null){
                return ;
            }
            var rowData = $("#jqGrid").jqGrid("getRowData",id);
            window.location.href="chapter.html?courseId="+id+"&courseName="+encodeURI(rowData.courseName);
        }
	},
    created: function(){
        var url = "car/course/selectLoad";
        $.ajax({
            type: "GET",
            url: baseURL + url,
            contentType: "application/json",
            success: function(r){
                var co = {}
                if(r.code === 0){
                    co.projectList = r.course.projectList;
                    co.categoryList = r.course.categoryList;
                    vm.course = co;
                }else{
                    alert(r.msg);
                }
            }
        });
    }
});

