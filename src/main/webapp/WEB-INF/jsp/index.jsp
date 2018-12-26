<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!--slider-->
<section id="slider">
    <!--slider-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#slider-carousel" data-slide-to="1"></li>
                        <li data-target="#slider-carousel" data-slide-to="2"></li>
                    </ol>

                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="col-sm-3">
                                <h1><span>GT</span>-Mobile</h1>
                                <h2>Bảo Hành 12 Tháng</h2>
                                <p></p>
                                <button type="button" class="btn btn-default get">Mua Ngay</button>
                            </div>
                            <div class="col-sm-8">
                                <br/>
                                <br/>
                                <a href="#">
                                    <img src="https://cdn.didongthongminh.vn/upload_images/2018/06/mi8-2.png"
                                         class="girl img-responsive" alt="" height="420"/>

                                </a>
                            </div>
                        </div>
                        <div class="item">
                            <div class="col-sm-3">
                                <h1><span>GT</span>-Mobile</h1>
                                <h2>Mua Hàng Dễ Dàng.</h2>
                                <p></p>
                                <button type="button" class="btn btn-default get">Mua Ngay</button>
                            </div>
                            <div class="col-sm-8">
                                <br/>
                                <br/>
                                <a href="#">
                                    <img src="https://cdn.didongthongminh.vn/upload_images/2018/06/xiaomi-redmi-note-5-pro.jpg"
                                         class="girl img-responsive" alt="" height="420"/>

                                </a>
                            </div>
                        </div>

                        <div class="item">
                            <div class="col-sm-3">
                                <h1><span>GT</span>-Mobile</h1>
                                <h2>Giao Hàng Miễn Phí.</h2>
                                <p></p>
                                <button type="button" class="btn btn-default get">Mua Ngay</button>
                            </div>
                            <div class="col-sm-8">
                                <br/>
                                <br/>
                                <a href="#">
                                    <img src="https://cdn.didongthongminh.vn/upload_images/2018/06/iphone8plus.png"
                                         class="girl img-responsive" alt="" height="420"/>

                                </a>

                            </div>
                        </div>

                    </div>

                    <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>

            </div>
        </div>
    </div>
</section>
<!--/slider-->

<section class="container">
    <br/>
    <div class="row">
        <!--_category.jsp-->
        <tiles:insertAttribute name="category"/>
        <!--main-->
        <div class="col-sm-9 padding-right">
            <div class="features_items">
                <h2 class="title text-center">Phổ Biến</h2>
                <c:forEach items="${sanpham}" var="item">
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">

                            <div class="single-products">
                                <div class="productinfo text-center">

                                    <img src="https://didongthongminh.vn/upload_images/2018/11/Xiaomi-Mi-Mix-3-Xanh-Ng%E1%BB%8Dc-b%C3%ADch.png"
                                         alt="${item.ten}" style="display: inline; opacity: 1;"
                                         height="330">
                                    <p>${item.ten}</p>
                                    <h2>${item.gia} VNĐ</h2>

                                    <a href="/Cart/addItem/${item.id}" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                </div>
                                <a href="/Detail/${item.id}">
                                    <div class="product-overlay">
                                        <div class="overlay-content">
                                            <p>${item.ten}</p>
                                            <h2>${item.gia} VNĐ</h2>
                                            <p>Màn Hình: ${item.manhinh} innches</p>
                                            <p>CPU: ${item.getCpu()}</p>
                                            <p>RAM: ${item.getRam()} GB, ROM: ${item.getRom()} GB</p>
                                            <p>Camera: ${item.getCameraSau()} megapixels</p>
                                            <p>Selfie: ${item.getCameraTruoc()} megapixels</p>
                                            <p>Pin: ${item.getPin()} mAh</p>
                                            <a href="/Cart/addItem/${item.id}" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>

                                        </div>
                                    </div>
                                </a>
                            </div>

                            <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Thêm vào yêu thích</a></li>
                                    <li><a href="/Detail/${item.id}"><i class="fa fa-plus-square"></i>Chi Tiết</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            @Html.PagedListPager(Model, page => Url.Action("Index", new { page }))

            <div class="category-tab">
                <!--_category.jsp-tab-->
                <div class="col-sm-12">
                    <ul class="nav nav-tabs">

                        @{
                        foreach (var _pItem in Producers)
                        {
                        if (_first)
                        {
                        <li class="active"><a href="#@_pItem.id" data-toggle="tab">@_pItem.ten</a></li>
                        }
                        else
                        {
                        <li><a href="#@_pItem.id" data-toggle="tab">@_pItem.ten</a></li>
                        }
                        _first = false;
                        }
                        _first = true;
                        }
                    </ul>
                </div>
                <div class="tab-content">
                    @{
                    foreach (var _pItem in Producers)
                    {
                    if (_first)
                    {
                    <div class="tab-pane fade active in" id="@_pItem.id">
                        @foreach (var item in (IEnumerable
                        <GTmobile_offical_area.FrameworkDb.tbl_sanpham>)Top4OfProducer[_pItem])
                            {
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="@item.link_anh" alt="photos.png">
                                            <h2>@(item.gia.GetValueOrDefault() > 0 ?
                                                item.gia.GetValueOrDefault().ToString("N0") + " Đ" : "Liên Hệ")</h2>
                                            <p>@item.ten</p>
                                            <a href="/Cart/addItem/@item.id" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm giỏ hàng</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            }
                    </div>
                    }
                    else
                    {
                    <div class="tab-pane fade" id="@_pItem.id">
                        @foreach (var item in (IEnumerable
                        <GTmobile_offical_area.FrameworkDb.tbl_sanpham>)Top4OfProducer[_pItem])
                            {
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="@item.link_anh" alt="photos.png">
                                            <h2>@(item.gia.GetValueOrDefault() > 0 ?
                                                item.gia.GetValueOrDefault().ToString("N0") + " Đ" : "Liên Hệ")</h2>
                                            <p>@item.ten</p>
                                            <a href="/Cart/addItem/@item.id" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm giỏ hàng</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            }
                    </div>
                    }
                    _first = false;
                    }
                    _first = true;
                    }


                </div>
            </div>

        </div>
    </div>

</section>