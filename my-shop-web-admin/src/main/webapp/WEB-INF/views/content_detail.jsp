<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>所属分类：</dt>
            <dd>${tbContentCategory.name}</dd>
            <br />

            <dt>标题：</dt>
            <dd>${tbContent.title}</dd>
            <br />

            <dt>子标题：</dt>
            <dd>${tbUser.phone}</dd>
            <br />
        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>创建时间：</dt>
            <dd><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />

            <dt>更新时间：</dt>
            <dd><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
        </dl>
    </div>
</div>