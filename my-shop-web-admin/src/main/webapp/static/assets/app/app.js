var App = function () {
    /**
     * 私有方法，初始化
     */
    //iCheck
    var _masterCheckbox;
    var _checkbox;

    //存放ID数组
    var _idArray;

    var handlerInitCheckbox = function () {
        // 激活 iCheck
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });
        //获取主checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.check_master');
        //获取全部checkbox集合
        _checkbox = $('input[type="checkbox"].minimal');
    }
    /**
     * checkbox全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked",function (e) {
            //返回true 未选中
            if(e.target.checked){
                _checkbox.iCheck('uncheck')
            }
            //选中
            else{
                _checkbox.iCheck('check')
            }
        });

    }

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new  Array();
        //将选中元素ID放入数组
        _checkbox.each(function () {
            var _id =$(this).attr("id");
            if(_id != null && _id != "undefine" && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });

        //判断用户是否勾选
        if(_idArray.length === 0){
            $("#modal-message").html("请至少选择一项");
        }
        else {
            $("#modal-message").html("确定要删除吗？");
        }

        //点击删除按钮弹出模态框
        $("#modal-default").modal("show");

        //如果用户选择调用删除
        $("#btnOk").bind("click",function () {
            del();
        });

        /**
         * 当前私有函数之私有函数
         */
        function del() {

            //如果没有选择项处理
            if(_idArray.length === 0){
                $("#modal-default").modal("hide");
            }

            //删除
            else{
                setTimeout(function () {
                    $.ajax({
                        "url": url,
                        "type": "POST",
                        "async" : false,
                        "data": {"ids" : _idArray.toString()},
                        "dataType" : "JSON",
                        "success" : function (data) {
                            //请求成功后，无论成功失败弹出模态框提示
                            $("#btnOk").unbind("click");
                            //删除成功，刷新页面
                            if(data.status == 200){
                                $("#btnOk").bind("click",function () {
                                    window.location.reload();
                                });
                            }
                            //删除失败，确定按钮隐藏模态框
                            else {
                                $("#btnOk").bind("click",function () {
                                    $("#modal-default").modal("hide");
                                });
                            }
                            //模态框调用
                            $("#modal-message").html(data.message);
                            $("#modal-default").modal("show");
                        }
                    });
                },500);
            }
        }
    };

    /**
     * 初始化 DataTables
     */
    var handlerInitDataTables = function (url, columns) {
        var _dataTable = $("#dataTable").DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns": columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }
        });

        return _dataTable;
    };

    /**
     * 查看详情
     * @param url
     */
    var handlerShowDetail = function (url) {
        $.ajax({
            url : url,
            type : "get",
            dataType : "html",
            success : function (data) {
                $('#modal-detail').modal('show');
                $('#modal-detail-body').html(data);
            }
        })
    }
    
    return{
        /**
         *初始化复选框
         */
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        /**
         * 批量删除
         * @param url
         */
        deleteMulti : function (url) {
            handlerDeleteMulti(url);
        },

        /**
         * 初始化datatables
         * @param url
         * @param columns
         * @returns {jQuery}
         */
        initDataTables : function (url,columns) {
            return handlerInitDataTables(url,columns);
        },

        /**
         * 显示详情
         * @param url
         */
        showDetail :function (url) {
          handlerShowDetail(url);
        }
    }
}();

$(document).ready(function () {
    App.init();
})