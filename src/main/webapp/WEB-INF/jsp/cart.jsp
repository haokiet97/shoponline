<%@ page import="org.springframework.web.context.request.ServletRequestAttributes" %>
<%@ page import="org.springframework.web.context.request.RequestContextHolder" %>
<%@ page import="com.giap.shopoline.models.CartItem" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<CartItem> items = (List<CartItem>) session.getAttribute("items");
    int tongsanpham = 0;
    long tongtien = 0;
%>
<section id="cart_items">
    <div class="container">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="/">Trang Chủ</a></li>
                <li class="active">Giỏ Hàng</li>
            </ol>
        </div>
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
                <%
                    for (CartItem item : items) {


                %>
                <tr>
                    <td class="cart_product">
                        <a href=""><img src="@item.sanpham.link_anh" alt="sanpham.png" width="80" height="120"></a>
                    </td>
                    <td class="cart_description">
                        <h4><a href="#"><%=item.getSanPham().getTen()%>
                        </a></h4>
                        <p>ID: <%=item.getSanPham().getId()%>
                        </p>
                    </td>
                    <td class="cart_price">
                        <p><%=java.text.NumberFormat.getInstance().format(item.getSanPham().getGia())%> VNĐ</p>
                    </td>
                    <td class="cart_quantity">
                        <div class="cart_quantity_button">
                            <a class="cart_quantity_up" href="/Cart/AddItems/<%=item.getSanPham().getId()%>/1"> + </a>
                            <input class="cart_quantity_input" name="quantity"
                                   value=<%=item.getCount()%> autocomplete="off"
                                   size="2" type="text">
                            <a class="cart_quantity_down" href="/Cart/AddItems/<%=item.getSanPham().getId()%>/-1">
                                - </a>
                        </div>
                    </td>
                    <td class="cart_total">
                        <p class="cart_total_price"><%=java.text.NumberFormat.getInstance().format(item.getSanPham().getGia() * item.getCount())%>
                            VND</p>
                    </td>
                    <td class="cart_delete">
                        <a class="cart_quantity_delete" href="/Cart/Delete/<%=item.getSanPham().getId()%>"><i
                                class="fa fa-times">Xóa</i></a>
                    </td>
                </tr>
                <%
                        tongsanpham += item.getCount();
                        tongtien += item.getSanPham().getGia() * item.getCount();
                    }
                %>

                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <div class="total_area">
                    <ul>
                        <li>Số Sản Phẩm: <span><%=tongsanpham%></span></li>
                        <li>Tổng Tiền: <span><%=java.text.NumberFormat.getInstance().format(tongtien)%> VNĐ</span></li>
                    </ul>
                    <a class="btn btn-default check_out" href="/Cart/Payment">Đặt Hàng</a>
                    <a class="btn btn-default update" href="/Cart/DeleteAll">Xóa Giỏ Hàng</a>
                </div>
            </div>
        </div>
    </div>

</section>