<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<section class="container">
    <br/>
    <div class="row">
        <!--_category.jsp-->
        <tiles:insertAttribute name="category"/>
        <div class="col-sm-9 padding-right">
            <div class="features_items">
                <h2 class="title text-center">Danh Sách Sản Phẩm</h2>
                <c:forEach items="${lstsanpham}" var="sp">
                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">

                                <img src="@item.link_anh" alt="${sp.getTen()}" style="display: inline; opacity: 1;"
                                     width="180" height="300">
                                <p>${sp.getTen()}</p>
                                <h2>${sp.getGia()} VNĐ</h2>

                                <a href="/Cart/AddItem/${sp.getId()}" class="btn btn-default add-to-cart"><i
                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <p>${sp.getTen()}</p>
                                    <h2>${sp.getGia()} VNĐ</h2>
                                    <p>Màn Hình: ${sp.getManhinh()} innches</p>
                                    <p>CPU: ${sp.getCpu()}</p>
                                    <p>RAM: ${sp.getRam()} GB, ROM: ${sp.getRom()} GB</p>
                                    <p>Camera: ${sp.getCameraSau()} megapixels</p>
                                    <p>Selfie: ${sp.getCameraTruoc()} megapixels</p>
                                    <p>Pin: ${sp.getPin()} mAh</p>
                                    <a href="/Cart/AddItem/${sp.getId()}" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                </div>
                            </div>
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="#"><i class="fa fa-plus-square"></i>Thêm vào yêu thích</a></li>
                                <li><a href="/Detail/${sp.getId()}"><i class="fa fa-plus-square"></i>Chi Tiết</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

    </div>
</section>