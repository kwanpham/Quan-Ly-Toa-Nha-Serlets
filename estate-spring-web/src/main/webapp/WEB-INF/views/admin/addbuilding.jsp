<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api/admin/building"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <h2>Thêm sản phẩm</h2>
    <form:form action="/admin/building" id="formSubmit" method="post" modelAttribute="model">

        <c:if test="${not empty model.id}">
            <div class="form-group">
                <label class="col-sm-1 control-label no-padding-right">Mã tòa nhà</label>
                <div class="col-sm-11">
                    <input type="text" class="form-control" id="id" name="id" value="${model.id}" readonly="readonly"/>
                </div>
            </div>

        </c:if>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tên tòa nhà</label>
            <div class="col-sm-11">
                <form:input path="name" cssClass="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Quận</label>
            <div class="col-sm-11">
               <form:select path="district">
                   <form:option value="" label="--- Chọn tòa nha" />
                   <form:options items="${districts}" itemValue="code" itemLabel="name"/>
               </form:select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phường</label>
            <div class="col-sm-11">
               <form:input path="ward" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Đường</label>
            <div class="col-sm-11">
                <form:input  path="street" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Kết cấu</label>
            <div class="col-sm-11">
                <form:input path="structure" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Số tầng hầm</label>
            <div class="col-sm-11">
                <form:input path="numberOfBasement" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Diện tích sàn</label>
            <div class="col-sm-11">
                <form:input path="buildingArea" cssClass="form-control"/>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Hướng</label>
            <div class="col-sm-11">
                <form:input path="direction" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Hạng</label>
            <div class="col-sm-11">
                <form:input path="levelBuilding" cssClass="form-control"/>
            </div>
        </div>



        <div class="form-group" id="rentArea">
            <label class="col-sm-1 control-label no-padding-right">Diện tích thuê</label>
            <div class="col-sm-11">
                <form:input path="rentArea" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group" id="areaDescription">
            <label class="col-sm-1 control-label no-padding-right">Mô tả S</label>
            <div class="col-sm-11">
                <form:input path="areaDescription" cssClass="form-control"/>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Giá thuê</label>
            <div class="col-sm-11">
                <form:input path="costRent" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Mô tả giá</label>
            <div class="col-sm-11">
                <form:input path="costDescription" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí dịch vụ</label>
            <div class="col-sm-11">
                <form:input path="serviceCost" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí ô tô</label>
            <div class="col-sm-11">
                <form:input path="carCost" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí xe máy</label>
            <div class="col-sm-11">
                <form:input path="motorbikeCost" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí ngoài giờ</label>
            <div class="col-sm-11">
                <form:input path="overtimeCost" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tiền điện</label>
            <div class="col-sm-11">
                <form:input path="electricityCost" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Đặt cọc</label>
            <div class="col-sm-11">
                <form:input path="deposit" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Thanh toán</label>
            <div class="col-sm-11">
                <form:input path="payment" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Thời han thuê</label>
            <div class="col-sm-11">
                <form:input path="timeContract" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Time trang trí</label>
            <div class="col-sm-11">
                <form:input path="timeDecorator" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tên quản lý</label>
            <div class="col-sm-11">
                <form:input path="managerName" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">SĐT quản lý</label>
            <div class="col-sm-11">
                <form:input path="managerPhone" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí môi giới</label>
            <div class="col-sm-11">
                <form:input path="commission" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Loại sản phẩm</label>
            <div class="col-sm-11">

              <form:checkboxes path="buildingTypes" items="${BuildingStyleList}"/>

            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Ghí chú</label>
            <div class="col-sm-11">
                <form:input path="note" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Link sản phẩm</label>
            <div class="col-sm-11">
                <form:input path="link" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Vị trí</label>
            <div class="col-sm-11">
                <form:input path="location" cssClass="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tên ảnh</label>
            <div class="col-sm-11">
                <form:input path="image" cssClass="form-control"/>
            </div>
        </div>

        <%--<div class="form-group">--%>
        <%--<label class="col-sm-1 control-label no-padding-right">Ảnh 64</label>--%>
        <%--<div class="col-sm-11">--%>
        <%--<input type="text" class="form-control" id="thumbnailBase64" name="thumbnailBase64" value="${model.thumbnailBase64}"/>--%>
        <%--</div>--%>
        <%--</div>--%>

        <button type="submit" id="btnAddOrUpdate" class="btn btn-primary">Submit</button>
    </form:form>


</div>
<script>


    // $('#btnAddRentArea').click(function (e) {
    //     $('#RentAreaForm').append($('#rentArea').clone());
    //     $('#RentAreaForm').append($('#areaDescription').clone());
    //     $('#RentAreaForm').append($('#line').clone());
    //
    // })

    <%--$('#btnAddOrUpdate').click(function (e) {--%>


    <%--    e.preventDefault();    //ngắn chặn hành động mặc định của sự kiện--%>
    <%--    var rentArea = [];--%>
    <%--    var areaDescription = [];--%>
    <%--    var checkBoxValue = [];--%>
    <%--    var dataTemp = {};--%>
    <%--    var formData = $('#formSubmit').serializeArray();--%>
    <%--    $.each(formData, function (i, v) {--%>
    <%--        dataTemp["" + v.name + ""] = v.value;--%>
    <%--    });--%>

    <%--    $("input:checkbox[name=buildingTypes]:checked").each(function () {--%>
    <%--        checkBoxValue.push($(this).val());--%>
    <%--    });--%>

    <%--    $("input[name=rentArea]").each(function () {--%>
    <%--        rentArea.push($(this).val());--%>
    <%--    })--%>

    <%--    $("input[name=areaDescription]").each(function () {--%>
    <%--        areaDescription.push($(this).val());--%>
    <%--    })--%>

    <%--    dataTemp["buildingTypes"] = checkBoxValue;--%>
    <%--    dataTemp["rentArea"] = rentArea;--%>
    <%--    dataTemp["areaDescription"] = areaDescription;--%>

    <%--    var data = JSON.stringify(dataTemp);--%>

    <%--    console.log(data);--%>


    <%--    var id = $('#id').val();--%>
    <%--    if (id == "") {--%>
    <%--        //addBuilding(data);--%>
    <%--    } else {--%>
    <%--       // updateBuilding(data);--%>
    <%--    }--%>

    <%--});--%>

    <%--function addBuilding(data) {--%>
    <%--    $.ajax({--%>
    <%--        url: '${APIurl}',--%>
    <%--        type: 'POST',--%>
    <%--        contentType: 'application/json',--%>
    <%--        data: data,--%>
    <%--        dataType: 'json',--%>
    <%--        success: function (result) {--%>
    <%--            console.log(result);--%>
    <%--        },--%>
    <%--        error: function (error) {--%>
    <%--            console.log(error);--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>
    <%--function updateBuilding(data) {--%>
    <%--    $.ajax({--%>
    <%--        url: '${APIurl}',--%>
    <%--        type: 'PUT',--%>
    <%--        contentType: 'application/json',--%>
    <%--        data: data,--%>
    <%--        dataType: 'json',--%>
    <%--        success: function (result) {--%>
    <%--            console.log(result);--%>
    <%--        },--%>
    <%--        error: function (error) {--%>
    <%--            console.log(error);--%>
    <%--        }--%>
    <%--    });--%>
    <%--}--%>

</script>

</body>
</html>
