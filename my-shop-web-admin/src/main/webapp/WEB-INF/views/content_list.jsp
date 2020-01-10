<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<html>
<head>
    <title>罗霄山商城 | 内容管理</title>
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
                内容管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 后台首页</a></li>
                <li class="active">内容管理</li>
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
                                <div class="row form-horizontal">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="title" class="col-sm-4 control-label">标题</label>
                                            <div class="col-sm-8">
                                                <input id="title" class="form-control" placeholder="标题"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="subTitle" class="col-sm-4 control-label">子标题</label>
                                            <div class="col-sm-8">
                                                <input id="subTitle" class="form-control" placeholder="子标题"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">
                                            <label for="titleDesc" class="col-sm-4 control-label">标题描述</label>
                                            <div class="col-sm-8">
                                                <input id="titleDesc" class="form-control" placeholder="标题描述"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                            </div>
                        </div>
                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/content/form" type="button" class="btn btn-default btn-sm"> <i
                                    class="fa fa-user-plus"></i> 新增</a>
                            <button type="button" class="btn btn-default btn-sm"
                                    onclick="App.deleteMulti('/content/delete')"><i class="fa fa-trash-o"></i> 删除
                            </button>
                            <button type="button" class="btn btn-primary btn-sm"
                                    onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')">
                                <i class="fa fa-search"></i> 搜索
                            </button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="dataTable" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal check_master"/></th>
                                    <th>ID号</th>
                                    <th>所属分类</th>
                                    <th>标题</th>
                                    <th>子标题</th>
                                    <th>标题描述</th>
                                    <th>链接</th>
                                    <th>图片1</th>
                                    <th>图片2</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
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

<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "id"},
            {"data": "tbContentCategory.name"},
            {"data": "title"},
            {"data": "subTitle"},
            {"data": "titleDesc"},
            {
                "data": function (row, type, val, meta) {
                    if(row.url == null||row.url ==''){
                        return '';
                    }
                    else {
                        return '<a href="'+row.url+'" target="_blank">查看</a>';
                    }
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if(row.pic == null||row.pic ==''){
                        return '';
                    }else {
                        return '<a href="' + row.pic + '" target="_blank">查看</a>';
                    }
                }
            },
            {
                "data": function (row, type, val, meta) {
                    if(row.pic2 == null||row.pic2 ==''){
                        return '';
                    }else{
                    return '<a href="'+row.pic2+'" target="_blank">查看</a>';
                    }
                }
            },
            {
                "data": function (row, type, val, meta) {
                    return DateTime.format(row.updated, "yyyy-MM-dd HH:mm:ss");
                }
            },
            {
                "data": function (row, type, val, meta) {
                    var detailUrl = "/content/detail?id=" + row.id;
                    return '<button type="button" class="btn btn-info btn-sm" onclick="App.showDetail(\'' + detailUrl + '\');"><i class="fa fa-inbox"></i> 查看</button>&nbsp;&nbsp;' +
                        '<a href="/content/form?id=' + row.id + '" type="button" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;' +
                        '<button  type="button" class="btn btn-danger btn-sm" onclick="App.deleteMulti(\'/user/delete\')"> <i class="fa fa-remove"></i> 删除</button>';
                }
            }
        ];

        _dataTable = App.initDataTables("/content/page", _columns);

    });

    //搜索
    function search() {
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var titleDesc = $("#titleDesc").val();
        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }
</script>
</body>
</html>
