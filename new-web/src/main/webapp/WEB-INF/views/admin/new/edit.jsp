<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api/admin/new"></c:url>

<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${not empty messageResponse}">
                        <div class="alert alert-block alert-${alert}">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                                ${messageResponse}
                        </div>
                    </c:if>
                    <form:form id="formSubmit" modelAttribute="model">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Thể loại bài viết</label>
                            <div class="col-sm-9">
                                <form:select path="categoryCode">
                                    <form:option value="" label="-- Chọn loại bài viết --"/>
                                    <form:options items="${categories}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                            <div class="col-sm-9">
                                <form:input path="title" cssClass="form-control" id="title"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                            <div class="col-sm-9">
                                <form:input path="content" id="content" cssStyle="width: 821px;height: 197px" />
                            </div>
                        </div>
                        <div></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                            <div class="col-sm-9">
                                <form:input path="shortDescription" id="shortDescription" cssStyle="width: 821px;height: 100px" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <c:if test="${not empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                                <c:if test="${empty model.id}">
                                    <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm mới bài viết" id="btnAddOrUpdateNew"/>
                                </c:if>
                            </div>
                        </div>
                        <form:hidden path="id" id="newId"/>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#btnAddOrUpdateNew').click(function (e) {
            e.preventDefault();
            var data = {};
            var formData = $('#formSubmit').serializeArray();
            $.each(formData, function (i, v) {
                data[""+v.name+""] = v.value;
            })

            var newId = $('#newId').val();
            if(newId == ""){
                addNew(data);
            }else{
                updateNew(data);
            }
        })
    });

    function addNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/new/edit?id="+result.id+"&message=insert_success'/>";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/new/edit?id="+result.id+"&message=error_system'/>";
            }
        });
    }

    function updateNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            data: JSON.stringify(data),
            contentType: 'application/json',
            dataType: 'json',
            success: function(result){
                window.location.href = "<c:url value='/admin/new/edit?id="+result.id+"&message=update_success'/>";
            },
            error: function(result){
                window.location.href = "<c:url value='/admin/new/edit?id="+result.id+"&message=error_system'/>";
            }
        });
    }
</script>
</body>
</html>
