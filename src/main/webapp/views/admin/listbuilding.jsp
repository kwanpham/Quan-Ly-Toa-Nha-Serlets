<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách tòa nhà</title>


</head>
<body>
<div class="main-content">
    <form action="<c:url value='/admin-building'/>" id="formSubmit" method="get">

        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->

            </div>
            <div class="page-content">


                <form id="formSearch" method="get" action="/admin-building">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <label>Tên sản phẩm</label>
                                <input type="text" class="form-control" id="name" name="name"/>
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <label>Diện tích sàn</label>
                                <input type="text" class="form-control" id="buildingArea" name="buildingArea"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Quận hiện có</label>
                                <select class="form-control input sm">
                                    <option value="" selected>---Chọn quận---</option>
                                    <c:forEach var="item" items="${districts}">
                                        <option value="${item.code}">${item.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Phường</label>
                                <input type="text" id="ward" name="ward" class="form-control input-sm">
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Đường</label>
                                <input type="text" class="form-control" id="street" name="street"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Số tầng hầm</label>
                                <input type="number" class="form-control" id="numberOfBasement"
                                       name="numberOfBasement"/>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Hướng</label>
                                <input type="text" class="form-control" id="direction" name="direction"/>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Hạng</label>
                                <input type="text" class="form-control" id="levelBuilding" name="levelBuilding"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3 col-sm-3 col-md-3">
                            <div class="form-group">
                                <label>Diên tích từ</label>
                                <input type="number" class="form-control" id="rentAreaFrom"
                                       name="rentAreaFrom"/>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3">
                            <div class="form-group">
                                <label>Diên tích đến</label>
                                <input type="number" class="form-control" id="rentAreaTo" name="rentAreaTo"/>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3">
                            <div class="form-group">
                                <label>Giá thuê từ</label>
                                <input type="number" class="form-control" id="costRentFrom" name="costRentFrom"/>
                            </div>
                        </div>
                        <div class="col-xs-3 col-sm-3 col-md-3">
                            <div class="form-group">
                                <label>Giá thuê đến</label>
                                <input type="number" class="form-control" id="costRentTo" name="costRentTo"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Tên quản lý</label>
                                <input type="text" class="form-control" id="managerName" name="managerName"/>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Điện thoại quản lý</label>
                                <input type="text" class="form-control" id="managerPhone" name="managerPhone"/>
                            </div>
                        </div>
                        <div class="col-xs-4 col-sm-4 col-md-4">
                            <div class="form-group">
                                <label>Chọn nhân viên phụ trách</label>
                                <select class="form-control">
                                    <option value="" selected>---Chọn nhân viên phụ trách---</option>
                                    <c:forEach var="item" items="${EMPLOYEES}">
                                        <option value="${item.id}">${item.fullName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach var="type" items="${buildingTypes}">
                            <div class="col-xs-1 col-sm-1 col-md-1" style="width: 12.499999995%">
                                <div class="form-group">
                                    <input type="checkbox" class="form-check-input" name="buildingTypes"
                                           value="${type.key}">
                                    <label> ${type.value}</label>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row">
                        <div class="col-xs-2 col-sm-2 col-md-2">
                            <button id="btnSearch" type="button" class="btn btn-sm btn-success">
                                Tìm kiếm
                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                            </button>
                        </div>
                    </div>
                </form>


                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title='Thêm tòa nhà' href='<c:url value="/admin-building?type=edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                        <button id="btnDelete" type="button"
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
                                                data-toggle="tooltip" title='Xóa tòa nhà'
                                                disabled>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" id="checkAll"></th>
                                            <th>Ngày</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Địa chỉ</th>
                                            <th>Tên quản lý</th>
                                            <th>Số điện thoại</th>
                                            <th>D.T sàn</th>
                                            <th>D.T trống</th>
                                            <th>Giá thuê</th>
                                            <th>Phí dịch vụ</th>
                                            <th>Phí môi giới</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>

                                        <tbody id="tbBuilding">
                                        <c:forEach var="item" items="${model.listResult}">
                                            <tr>
                                                <td><input type="checkbox" class="check-action check-box-element"
                                                           id="checkbox_${item.id}" value="${item.id}"/></td>
                                                <td><fmt:formatDate value="${item.createdDate}"
                                                                    pattern="MM/dd/yyyy"/></td>
                                                <td>${item.name}</td>
                                                <td>${item.street}</td>
                                                <td>${item.managerName}</td>
                                                <td>${item.managerPhone}</td>
                                                <td>${item.buildingArea}</td>
                                                <td>${item.areaDescription}</td>
                                                <td>${item.costDescription}</td>
                                                <td>${item.serviceCost}</td>
                                                <td>${item.commission}</td>
                                                <td>
                                                    <c:url var="editURL" value="/admin-building">
                                                        <c:param name="ref" value="edit"/>
                                                        <c:param name="id" value="${item.id}"/>
                                                    </c:url>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhật bài viết" href='${editURL}'><i
                                                            class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>

                                                    <button type="button" class="btn btn-sm btn-primary"
                                                            data-toggle="modal"
                                                            value="${item.id}"
                                                            data-id="${item.id}"
                                                            onclick="openModalAssignBuilding(this)">
                                                        <span class="glyphicon glyphicon-user"></span>
                                                    </button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>


                                    <!-- The Modal -->
                                    <div class="modal fade" id="myModal" role="dialog">
                                        <div class="modal-dialog">
                                            <div class="modal-content">

                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Chọn nhân viên</h4>
                                                    <button type="button" class="close"
                                                            data-dismiss="modal">&times;
                                                    </button>
                                                </div>

                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                    <table class="table table-hover">
                                                        <thead>
                                                        <tr>
                                                            <th>Chọn nhân viên</th>

                                                            <th>Tên nhân viên</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody id="userAssignTable">

                                                        </tbody>
                                                    </table>
                                                </div>

                                                <!-- Modal footer -->
                                                <div class="modal-footer">
                                                    <button type="button" class="col-6 btn btn-danger"
                                                            data-dismiss="modal" id-data="" id="btnAssingUser"
                                                            onclick="assignUser(this)">
                                                        Phân công
                                                    </button>
                                                    <button type="button" class="col-6 btn btn-danger"
                                                            data-dismiss="modal">Đóng
                                                    </button>
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                    <%--end modal--%>

                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="ref" name="ref"/>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </form>
    <%--end form--%>
</div>
<!-- /.main-content -->


<script>


    $(document).ready(function () {
        enableOrDisableDeleteAll();
        autoCheckBoxAllChild();
        autoCheckBoxParent();

        $('#btnDelete').click(e => {
            confirm("Bạn có muốn xóa không ! ");
            let dataArray = $('tbody[id=tbBuilding] input[type=checkbox]:checked').map(function () {
                return $(this).val();
            }).get();
            let data = {};
            data['ids'] = dataArray;

            $.ajax({
                url: '/api-admin-building',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                success: function (res) {
                    window.location.href = "<c:url value='/admin-building?ref=list&page=1&sortName=name&sortBy=desc'/>";
                },
                error: function (res) {
                    console.log(res);
                    window.location.href = "<c:url value='/admin-building?ref=list&page=1&sortName=name&sortBy=desc'/>";
                }
            });
        });


    });

    // phân trnag
    var totalPages = ${model.totalPage};
    var currentPage = ${model.page};
    var limit = 5;    // tổng item trên 1 trang
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,       // tổng trang
            visiblePages: 5,              // số trang hiển thị trên thanh phân trang
            startPage: currentPage,       // trang hiện tại
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(totalPages);
                    $('#page').val(page);
                    $('#sortName').val('name');
                    $('#sortBy').val('desc');
                    $('#ref').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });

    // mở modal và load list user
    function openModalAssignBuilding(e) {
        $('#myModal').modal();
        let buildingId = e.getAttribute("data-id");
        loadUserAssignForBuilding(buildingId);
    };

    function loadUserAssignForBuilding(buildingId) {
        $('#btnAssingUser').attr('id-data', buildingId);
        $.ajax({
            url: '/api-admin-user?roleId=2&buildingId=' + buildingId,
            type: 'GET',
            dataType: 'json',
            success: function (result) {
                let row = '';
                $.each(result, function (index, user) {
                    row += '<tr>';
                    row += '<td class="text-center"><input type="checkbox" name="checkList" value=' + user.id + ' id="checkbox_' + user.id + '" class="check-box-element" ' + user.checked + '/></td>';
                    row += '<td class="text-center">' + user.fullName + '</td>';
                    row += '</tr>';
                });
                $('#userAssignTable').html(row);
            },
            error: function (res) {
                console.log(res);
            }
        });
    };

    function assignUser(e) {
        let data = {} ;
        let userIds = [];
        data['buildingId'] = e.getAttribute('id-data');
        $("input[name=checkList]:checked").each(function () {
            userIds.push($(this).val());
        });
        data['userIds'] = userIds;

        $.ajax({
            url : '/api-admin-assignment',
            type : 'POST' ,
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

    };


    function enableOrDisableDeleteAll() {
        $('tbody[id=tbBuilding] input[type=checkbox]').click(function () {
            if ($('tbody[id=tbBuilding] input[type=checkbox]:checked').length > 0) {
                $('#btnDelete').prop('disabled', false);
            } else {
                $('#btnDelete').prop('disabled', true);
            }
        })
    };

    function autoCheckBoxAllChild() {
        $('#checkAll').change(function (e) {

            if ($(this).prop('checked')) {
                $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', true);
                $('#btnDelete').prop('disabled', false);
            } else {
                $(this).closest('table').find('tbody input[type=checkbox]').prop('checked', false);
                $('btnDelete').prop('disabled', true);

            }
        })
    };

    function autoCheckBoxParent() {
        let toltalCheckBoxChild = $('tbody[id=tbBuilding] input[type=checkbox]').length;

        $('tbody[id=tbBuilding] input[type=checkbox]').each(function () {
            $(this).change(function () {
                let totalCheckBoxChecked = $('tbody[id=tbBuilding] input[type=checkbox]:checked').length;
                console.log(totalCheckBoxChecked);
                if (totalCheckBoxChecked == toltalCheckBoxChild) {
                    $('#checkAll').prop('checked', true);
                } else {
                    $('#checkAll').prop('checked', false);
                }
            });
        });
    };


    $('#btnSearch').click(function () {
        $('#maxPageItem').val(limit);
        $('#page').val(1);
        $('#ref').val('search');
        $('#formSubmit').submit();
    });


</script>
</body>
</html>
