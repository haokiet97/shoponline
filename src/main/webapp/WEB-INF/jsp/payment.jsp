<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="/Home/Index">Home</a></li>
                <li class="active">Check out</li>
            </ol>
        </div><!--/breadcrums-->

        <div class="review-payment">
            <h2>Danh sách sản phẩm</h2>
        </div>
        <div class="table-responsive cart_info">
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
                    <thead>
                    <tr class="cart_menu">
                        <td class="image">Sản Phẩm</td>
                        <td class="description">Thông Tin</td>
                        <td class="price">Đơn Giá</td>
                        <td class="quantity">Số Lượng</td>
                        <td class="total">Tổng Tiền</td>
                        <td></td>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach (var item in list)
                    {
                    <tr>
                        <td class="cart_product">
                            <a href=""><img src="@item.sanpham.link_anh" alt="sanpham.png" width="80" height="120"></a>
                        </td>
                        <td class="cart_description">
                            <h4><a href="#">@item.sanpham.ten</a></h4>
                            <p>ID: @item.sanpham.id</p>
                        </td>
                        <td class="cart_price">
                            <p>@item.sanpham.gia.GetValueOrDefault().ToString("N0") VNĐ</p>
                        </td>
                        <td class="cart_quantity">
                            <div class="cart_quantity_button">
                                <a class="cart_quantity_up" href="/Cart/AddItems?id=@item.sanpham.id&count=1"> + </a>
                                <input class="cart_quantity_input" name="quantity" value=@item.soluong autocomplete="off" size="2" type="text">
                                <a class="cart_quantity_down" href="/Cart/AddItems?id=@item.sanpham.id&count=-1"> - </a>
                            </div>
                        </td>
                        <td class="cart_total">
                            <p class="cart_total_price">@((item.sanpham.gia.GetValueOrDefault() * item.soluong).ToString("N0")) VNĐ</p>
                        </td>
                        <td class="cart_delete">
                            <a class="cart_quantity_delete" href="/Cart/Delete/@item.sanpham.id"><i class="fa fa-times">Xóa</i></a>
                        </td>
                    </tr>

                    }

                    </tbody>
                </table>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <div class="total_area">
                        <ul>
                            <li>Số Sản Phẩm: <span>@_sosanpham</span></li>
                            <li>Tổng Tiền: <span>@_tongtien.ToString("N0") VNĐ</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>



        <div class="register-req">
            <p>Vui lòng nhập đủ thông tin để được xác thực nhanh chóng. Xin cảm ơn quý khách!</p>
        </div><!--/register-req-->
        <div class="shopper-informations">
            <div class="row">

                <div class="col-sm-6">
                    <div class="shopper-info">
                        <form action="/Cart/Payment" method="post">

                            <p>Thông tin khách hàng</p>

                            <input name="Name" type="text" placeholder="Họ Tên" required>
                            <input name="PhoneNumber" type="text" placeholder="Số điện thoại" id="PhoneNumber" onkeypress="return isNumberKey(event)" maxlength="13" required>
                            <input name="Email" type="email" placeholder="E-mail">
                            <input name="Address" type="text" placeholder="Địa chỉ">
                            <input name="Address1" type="text" placeholder="Nơi Nhận Hàng" required>
                            <div class="order-message">
                                <p>Ghi chú</p>
                                <textarea name="Note" placeholder="Ghi một vài chi chú cho đơn hàng." rows="6"></textarea>
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary">Đặt Hàng</button>
                            </div>

                            <script>
                                function isNumberKey(evt) {
                                    var charCode = (evt.which) ? evt.which : evt.keyCode;
                                    if (charCode != 46 && charCode > 31
                                        && (charCode < 48 || charCode > 57))
                                        return false;
                                    return true;
                                }
                            </script>
                        </form>
                    </div>
                </div>



            </div>
        </div>


    </div>
</section> <!--/#cart_items-->
