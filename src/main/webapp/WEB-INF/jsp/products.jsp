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
                <h2 class="title text-center">@ViewBag.Note</h2>
                @foreach (var item in Model)
                {
                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">

                                <img src="@item.link_anh" alt="@item.ten" style="display: inline; opacity: 1;"
                                     width="180" height="300">
                                <p>@item.ten</p>
                                <h2>@item.gia.GetValueOrDefault().ToString("N0") VNĐ</h2>

                                <a href="/Cart/AddItem/@item.id" class="btn btn-default add-to-cart"><i
                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <p>@item.ten</p>
                                    <h2>@item.gia.GetValueOrDefault().ToString("N0") VNĐ</h2>
                                    <p>Màn Hình: @item.manhinh innches</p>
                                    <p>CPU: @item.CPU</p>
                                    <p>RAM: @item.RAM GB, ROM: @item.ROM GB</p>
                                    <p>Camera: @item.camera_sau megapixels</p>
                                    <p>Selfie: @item.camera_truoc megapixels</p>
                                    <p>Pin: @item.pin mAh</p>
                                    <a href="/Cart/AddItem/@item.id" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                </div>
                            </div>
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                <li><a href="#"><i class="fa fa-plus-square"></i>Thêm vào yêu thích</a></li>
                                <li><a href="#"><i class="fa fa-plus-square"></i>Thêm để so sánh</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                }
            </div>
        </div>

    </div>
</section>