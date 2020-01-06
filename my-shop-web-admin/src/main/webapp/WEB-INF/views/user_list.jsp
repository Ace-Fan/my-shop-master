<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>罗霄山商城 | 用户管理</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>
    <jsp:include page="../includes/menu.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 后台首页</a></li>
                <li class="active">用户管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>
                    <!-- Horizontal Form -->
                    <div class="box">
                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header with-border">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                            <div class="box-body">
                                 <div class="row" style="margin-top: 20px">
                                     <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                                         <div class="row">
                                             <div class="col-xs-12">
                                             <div class="col-xs-12 col-sm-3">
                                                 <div class="form-group">
                                                     <label for="username" class="col-sm-4 control-label">姓名</label>

                                                     <div class="col-sm-8">
                                                         <form:input path="username" cssClass="form-control" placeholder="姓名"/>
                                                     </div>
                                                 </div>
                                             </div>
                                             <div class="col-xs-12 col-sm-3">
                                                 <div class="form-group">
                                                     <label for="username" class="col-sm-4 control-label">邮箱</label>

                                                     <div class="col-sm-8">
                                                         <form:input path="email" cssClass="form-control" placeholder="邮箱"/>
                                                     </div>
                                                 </div>
                                             </div>
                                             <div class="col-xs-12 col-sm-3">
                                                 <div class="form-group">
                                                     <label for="phone" class="col-sm-4 control-label">手机</label>

                                                     <div class="col-sm-8">
                                                         <form:input path="phone" cssClass="form-control" placeholder="手机"/>
                                                     </div>
                                                 </div>
                                             </div>
                                         </div>

                                         <div class="row" style="padding-right: 73px">
                                             <div class="col-xs-12">
                                                 <button type="submit" class="btn btn-info pull-right">高级搜索</button>
                                             </div>
                                         </div>
                                         </div>
                                     </form:form>
                    </div>
                    </div>
                    </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                            <div class="row" style="padding-top: 20px">
                                <div class="col-xs-12">
                                    <a href="/user/form" type="button" class="btn btn-default btn-sm"> <i class="fa fa-user-plus"></i> 新增</a>
                                    <a href="#" type="button" class="btn btn-default btn-sm" onclick="deleteMulti()"> <i class="fa fa-trash-o"></i> 删除</a>
                                    <a href="http://www.baidu.com" type="button" class="btn btn-default btn-sm"> <i class="fa fa-upload"></i> 导入</a>
                                    <a href="http://www.baidu.com" type="button" class="btn btn-default btn-sm"> <i class="fa fa-download"></i> 导出</a>
                                    <button type="button" class="btn btn-primary btn-sm" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')">
                                        <i class="fa fa-search"></i> 搜索</button>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal check_master" /></th>
                                    <th>ID号</th>
                                    <th>用户名</th>
                                    <th>手机号</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser">
                                <tr>
                                    <td><input id="${tbUser.id}" type="checkbox" class="minimal" /></td>
                                    <td>${tbUser.id}</td>
                                    <td>${tbUser.username}</td>
                                    <td>${tbUser.phone}</td>
                                    <td>${tbUser.email}</td>
                                    <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td>
                                        <a href="http://www.baidu.com" type="button" class="btn btn-info btn-sm" ><i class="fa fa-inbox"></i> 查看</a>
                                        <a href="http://www.baidu.com" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> 编辑</a>
                                        <a href="http://www.baidu.com" type="button" class="btn btn-danger btn-sm"> <i class="fa fa-remove"></i> 删除</a>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>

                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <jsp:include page="../includes/copyright.jsp"/>
</div>

<jsp:include page="../includes/footer.jsp"/>

<sys:modal/>

<script type="text/javascript">
    /**
     * 批量删除
     */
        //定义一个存放ID的数组
    var idArray = new Array();

    function deleteMulti() {

        //将选中元素ID放入数组
        var _checkbox = Check.getCheckbox();
        _checkbox.each(function () {
            var _id =$(this).attr("id");
            if(_id != null && _id && $(this).is(":checked")){
                idArray.push(_id);
            }
        });
        if(idArray.length === 0){
            $("#modal-message").html("请至少选择一项");
        }
        else {
            $("#modal-message").html("确定要删除吗？");
        }
        $("#modal-default").modal("show");
    }

    $(function () {
        $("#btnOk").bind("click",function () {
            del(idArray,"/user/delete");
        });

    function del(idArray,url) {
        if(idArray.length === 0){
            $("#modal-default").modal("hide");
    }
        else{
            $.ajax({
                "url": url,
                "type": "POST",
                "data": {"ids" : idArray.toString()},
                "dataType" : "JSON",
                "success" : function (data) {
                    console.log(data);
                }
            })
        }
    }

    });
</script>
</body>
</html>
