$(function () {
    var sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0];
    $("#jqGrid").jqGrid({
        url: baseURL + 'car/exercisecontent/list',
        datatype: "json",
        postData: {sectionId:sectionId},
        colModel: [
            { label: '课程名称', name: "courseName", index: 'course_id', width: 80},
            { label: '课章名称', name: "chapterName", index: 'course_id', width: 80},
            { label: '课节名称', name: sectionId, index: 'course_id', width: 80,formatter: setSectionName},
			{ label: '题型', name: 'exerciseName', index: 'exercise_type_id', width: 80 },
			{ label: '题目内容', name: 'exerciseContent', index: 'exercise_content', width: 80 },
			{ label: '候选项', name: 'optionss', index: 'optionss', width: 80 },
			{ label: '正确答案', name: 'rightAnswer', index: 'right_answer', width: 80 }, 			
			{ label: '分数', name: 'score', index: 'score', width: 80 },
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
    var id = document.URL.split('?')[1].split("=")[1].split("&")[0]
    new AjaxUpload('#upload', {
        action: baseURL + "car/exercisecontent/upload/"+id,
        name: 'file',
        autoSubmit:true,
        responseType:"json",
        onSubmit:function(file, extension){
            if (!(extension && /^(xls|xlsx)$/.test(extension.toLowerCase()))){
                alert('只支持.xls格式的文件！');
                return false;
            }
        },
        onComplete : function(file, r){
            if(r.code == 0){
                alert(r.msg);
                vm.reload();
            }else{
                alert(r.msg);
            }
        }
    });
});
function setSectionName(cellvalue, options, rowObject){
    var  getval = document.URL.split('?')[1];
    return '<span>'+decodeURI(getval.split("=")[2])+'</span>';
}
var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		exerciseContent: {},
        contentImg:"",
        answerImg:"",
        exerciseTypeList:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
            vm.title = "新增";
			vm.exerciseContent = {};
            var sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0]
			console.log(sectionId+"sectionId")
            var url = "car/exercisecontent/listExerciseType/"+sectionId;
            $.ajax({
                type: "GET",
                url: baseURL + url,
                success: function(r){
                    if(r.code === 0){
                        vm.exerciseTypeList = r.exerciseTypeList
                        vm.exerciseContent.exerciseTypeId = r.exerciseTypeList[0].id
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
            var sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0]
            console.log(sectionId+"sectionId")
            var url = "car/exercisecontent/listExerciseType/"+sectionId;
            $.ajax({
                type: "GET",
                url: baseURL + url,
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
            var formData = new FormData();
            vm.exerciseContent.sectionId = document.URL.split('?')[1].split("=")[1].split("&")[0];
            formData.append("exerciseContent",$.toJSON(vm.exerciseContent));
            formData.append("contentImg",vm.contentImg);
            formData.append("answerImg",vm.answerImg);
			var url = vm.exerciseContent.id == null ? "car/exercisecontent/save" : "car/exercisecontent/update";
			$.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: false,
                processData: false,
                data: formData,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
                            $("#fileupContent").val("");
                            vm.contentImg = "";
                            $("#fileupAnswer").val("");
                            vm.answerImg = "";
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
				    url: baseURL + "car/exercisecontent/delete",
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
			$.get(baseURL + "car/exercisecontent/info/"+id, function(r){
                vm.exerciseContent = r.exerciseContent;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        exportExcel: function (){
            var url = baseURL + "model/car.xls";
            window.location.href = url;
        },
        fileAnswerChange: function (el) {
            if (!el.target.files[0].size) return;
            var file = $("#fileupAnswer")[0].files[0];
            vm.answerImg = file;
        },
        fileContentChange: function (el) {
            if (!el.target.files[0].size) return;
            var file = $("#fileupContent")[0].files[0];
            vm.contentImg = file
        }
	}
});