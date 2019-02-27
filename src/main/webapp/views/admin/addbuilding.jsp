<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="APIurl" value="/api-admin-building"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="main-content">
    <h2>Thêm sản phẩm</h2>
    <form action="" id="formSubmit">

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
                <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Quận</label>
            <div class="col-sm-11">
                <select class="form-control" id="district" name="districtCode" ">
                    <c:if test="${empty model.districtCode}">
                        <option value="">Chọn quận</option>
                        <c:forEach var="item" items="${districts}">
                            <option value="${item.code}">${item.name}</option>
                        </c:forEach>
                    </c:if>

                    <c:if test="${not empty model.districtCode }">
                        <c:forEach var="item" items="${districts}">
                            <option value="${item.code}" <c:if test="${item.code == model.districtCode}">selected="selected"</c:if> >
                                    ${item.name}
                            </option>
                        </c:forEach>

                    </c:if>

                </select>

            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phường</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="ward" name="ward" value="${model.ward}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Đường</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="street" name="street" value="${model.street}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Kết cấu</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="structure" name="structure" value="${model.structure}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Số tầng hầm</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="numberOfBasement" name="numberOfBasement"
                       value="${model.numberOfBasement}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Diện tích sàn</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="buildingArea" name="buildingArea"
                       value="${model.buildingArea}"/>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Hướng</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="direction" name="direction" value="${model.direction}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Hạng</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="levelBuilding" name="levelBuilding" value="${model.levelBuilding}"/>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Diện tích thuê</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="rentArea" name="rentArea" value="${model.rentArea}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Mô tả S</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="areaDescription" name="areaDescription"
                       value="${model.areaDescription}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Giá thuê</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="costRent" name="costRent" value="${model.costRent}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Mô tả giá</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="costDescription" name="costDescription"
                       value="${model.costDescription}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí dịch vụ</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="serviceCost" name="serviceCost"
                       value="${model.serviceCost}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí ô tô</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="carCost" name="carCost" value="${model.carCost}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí xe máy</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="motorbikeCost" name="motorbikeCost"
                       value="${model.motorbikeCost}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí ngoài giờ</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="overtimeCost" name="overtimeCost"
                       value="${model.overtimeCost}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tiền điện</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="electricityCost" name="electricityCost"
                       value="${model.electricityCost}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Đặt cọc</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="deposit" name="deposit" value="${model.deposit}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Thanh toán</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="payment" name="payment" value="${model.payment}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Thời han thuê</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="timeContract" name="timeContract"
                       value="${model.timeContract}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Time trang trí</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="timeDecorator" name="timeDecorator"
                       value="${model.timeDecorator}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tên quản lý</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="managerName" name="managerName"
                       value="${model.managerName}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">SĐT quản lý</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="mamagerPhone" name="mamagerPhone"
                       value="${model.managerPhone}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Phí môi giới</label>
            <div class="col-sm-11">
                <input type="number" class="form-control" id="commission" name="commission" value="${model.commission}"/>
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--<label class="col-sm-1 control-label no-padding-right">Loại sản phẩm</label>--%>
            <%--<div class="col-sm-11">--%>
                <%--<c:forEach var="item" items="${buildingtypes}">--%>
                    <%--<div class="form-check">--%>

                            <%--<input type="checkbox" class="form-check-input"  name="buildingTypes"--%>
                                   <%--value="${item.buildingTypeId}">${item.name}--%>

                    <%--</div>--%>
                <%--</c:forEach>--%>

            <%--</div>--%>
        <%--</div>--%>


        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Ghí chú</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="note" name="note" value="${model.note}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Link sản phẩm</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="link" name="link" value="${model.link}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Vị trí</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="location" name="location" value="${model.location}"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-1 control-label no-padding-right">Tên ảnh</label>
            <div class="col-sm-11">
                <input type="text" class="form-control" id="image" name="image" value="${model.image}"/>
            </div>
        </div>

        <%--<div class="form-group">--%>
        <%--<label class="col-sm-1 control-label no-padding-right">Ảnh 64</label>--%>
        <%--<div class="col-sm-11">--%>
        <%--<input type="text" class="form-control" id="thumbnailBase64" name="thumbnailBase64" value="${model.thumbnailBase64}"/>--%>
        <%--</div>--%>
        <%--</div>--%>

        <button type="button" id="btnAddOrUpdate" class="btn btn-primary">Submit</button>
    </form>


</div>
<script>


    $('#btnAddOrUpdate').click(function (e) {


        e.preventDefault();    //ngắn chặn hành động mặc định của sự kiện
        var checkBoxValue = [];
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        $("input:checkbox[name=buildingTypes]:checked").each(function () {
            checkBoxValue.push($(this).val());
        });

        //data["buildingTypes"] = checkBoxValue;

        var data1 = JSON.stringify(data);

        console.log(data1);

        var id = $('#id').val();
        if (id === "") {
            addNew(data);
        } else {
            updateNew(data);
        }

    });

    function addNew(data1) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: data1,
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }
    function updateNew(data1) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                console.log(result);
            },
            error: function (error) {
                console.log(error);
            }
        });
    }

</script>

</body>
</html>
