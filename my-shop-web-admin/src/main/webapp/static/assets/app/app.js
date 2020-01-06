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
    var handlerDeleteMulti = function () {
        _idArray = new  Array();
        //将选中元素ID放入数组
        var _checkbox = this.getCheckbox();

        _checkbox.each(function () {
            var _id =$(this).attr("id");
            if(_id != null && _id && $(this).is(":checked")){
                _idArray.push(_id);
            }
        });

        if(idArray.length === 0){
            $("#modal-message").html("请至少选择一项");
        }
        else {
            $("#modal-message").html("确定要删除吗？");
        }

        $("#modal-default").modal("show");

        $("#btnOk").bind("click",function () {
            del(idArray,"/user/delete");
        });

        /**
         * 当前私有函数之私有函数
         */
        function del() {
            console.log("hello");
        }
    };
    
    return{
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
})