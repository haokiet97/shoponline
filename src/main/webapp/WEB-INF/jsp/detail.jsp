<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> @ViewBag.Title | GTmobile-Điện thoại, tablet và các dịch vụ hỗ trợ</title>
    <spring:url value="/css/layout/bootstrap.css" var="springCss1"/>
    <link href="${springCss1}" rel="stylesheet">
    <spring:url value="/css/layout/font-awesome.min.css" var="springCss2"/>
    <link href="${springCss2}" rel="stylesheet">
    <spring:url value="/css/layout/prettyPhoto.css" var="springCss3"/>
    <link href="${springCss3}" rel="stylesheet">
    <spring:url value="/css/layout/price-range.css" var="springCss4"/>
    <link href="${springCss4}" rel="stylesheet">
    <spring:url value="/css/layout/animate.css" var="springCss5"/>
    <link href="${springCss5}" rel="stylesheet">
    <spring:url value="/css/layout/main.css" var="springCss6"/>
    <link href="${springCss6}" rel="stylesheet">
    <spring:url value="/css/layout/responsive.css" var="springCss7"/>
    <link href="${springCss7}" rel="stylesheet">
    <%--<spring:url value="/css/layout/main.css" var="springCss" />--%>
    <%--<link href="${springCss}" rel="stylesheet" />--%>
    <style>
        #panel-heading:hover {
            background-color: yellow;
        }
    </style>
    <style>
        #brans-heading:hover {
            background-color: yellow;
        }
    </style>

    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->
<body>
<header id="header">
    <!--header-->
    <div class="header_top">
        <!--header_top-->
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href=""><i class="fa fa-phone"></i> +84 1688 966 276</a></li>
                            <li><a href=""><i class="fa fa-envelope"></i> vanlahaokietxua@gmail.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header_top-->

    <div class="header-middle">
        <!--header-middle-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="logo pull-left">
                        <a href="#"><img src="/images/home/logo.png" alt="Logo.png"/></a>
                    </div>

                </div>
                <div class="col-sm-8">
                    <div class="shop-menu pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href=""><i class="fa fa-user"></i> Tài Khoản</a></li>
                            <li><a href=""><i class="fa fa-star"></i> Yêu Thích</a></li>
                            <li><a href=""><i class="fa fa-crosshairs"></i> Checkout</a></li>
                            <li><a href="/Cart/Index"><i class="fa fa-shopping-cart"></i> Giỏ
                                Hàng(@_count.ToString())</a></li>
                            <li><a href="/Admin/Login/Login"><i class="fa fa-lock"></i>Đăng Nhập</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/header-middle-->

    <div class="header-bottom" style="position: relative; display: block; background: #ffd800;">
        <!--header-bottom-->
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="mainmenu pull-left">
                        <ul class="nav navbar-nav collapse navbar-collapse">
                            <li><a href="/">Trang Chủ</a></li>
                            <li><a href="/Home/Category/?CategoryID=1">Điện Thoại</a></li>
                            <li><a href="/Home/Category/?CategoryID=2">Tablet</a></li>
                            <li><a href="/Home/Producer/?ProducerID=2">Iphone</a></li>
                            <li><a href="/Home/Producer/?ProducerID=1">Samsung</a></li>
                            <li><a href="/Home/Category/?CategoryID=3">Phụ Kiện</a></li>
                            <li><a href="/Home/Category/?CategoryID=4">Sửa Chữa</a></li>
                            <li><a href="/Home/Category/?CategoryID=5">Khuyến Mại</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3">
                    <form action="/Home/Search" method="get" class="searchform">
                        <input name="key" placeholder="Từ Khóa" type="text">
                        <button type="submit" class="btn btn-default"><img src="/images/layout/searchicon.png"/></button>

                    </form>
                </div>
            </div>
        </div>
    </div><!--/header-bottom-->
</header><!--/header-->


<%--section--%>
<section class="container">
    <br />
    <div class="row">

        <div class="product-details">
            <!--product-details-->
            <div class="col-sm-4">
                <div class="view-product">
                    <img src="@Model.link_anh" alt="Product.png" width="160">

                </div>
            </div>
            <div class="col-sm-8">
                <div class="product-information">
                    <!--/product-information-->
                    <img src="~/Resources/new.jpg" class="newarrival" alt="">
                    <h2>@item.ten</h2>
                    <p>Nhà Sản Xuất: @item.tbl_nhasanxuat.ten</p>
                    <img src="~/Resources/rating.png" alt="">
                    <span>
                        <span>Giá: @(item.gia.GetValueOrDefault() > 0 ? item.gia.Value.ToString("N0") + " Đ" : "Liên Hệ")</span>
                        <label>Số lượng:</label>
                        <input value="1" type="text" id="num-of-product">
                        <button type="button" class="btn btn-fefault cart" id="addtocart" onclick="additem()">
                            <i class="fa fa-shopping-cart"></i>
                            Thêm giỏ hàng
                        </button>
                    </span>
                    <p><b>Số lượng:</b> @(item.soluong.GetValueOrDefault() > 0 ? "Có " + item.soluong.Value.ToString() + " sản phẩm." : "Tạm hết hàng.")</p>
                    <p><b>Tình trạng:</b>Mới</p>
                    <p><b>Brand:</b> GT-mobile</p>
                    @*<a href=""><img src="images/product-details/share.png" class="share img-responsive" alt=""></a>*@
                </div><!--/product-information-->
            </div>
        </div><!--/product-details-->

        <div class="category-tab shop-details-tab">
            <!--category-tab-->
            <div class="col-sm-12">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#details" data-toggle="tab">Chi Tiết</a></li>
                    <li class=""><a href="#reviews" data-toggle="tab">Đánh Giá</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane active fade in" id="details">
                    <div class="row">
                        <h3>--Thông Số Kỹ Thuật</h3>
                        <hr />
                        <div class="col-sm-10">
                            <table class="table table-bordered table-striped table-hover">
                                <tr>
                                    <th>Tên</th>
                                    <td>@item.ten</td>
                                </tr>
                                <tr>
                                    <th>Nhà Sản Xuất</th>
                                    <td>@item.tbl_nhasanxuat.ten</td>
                                </tr>
                                <tr>
                                    <th>CPU</th>
                                    <td>@item.CPU</td>
                                </tr>
                                <tr>
                                    <th>ROM</th>
                                    <td>@item.ROM</td>
                                </tr>
                                <tr>
                                    <th>RAM</th>
                                    <td>@item.RAM</td>
                                </tr>
                                <tr>
                                    <th>Camera</th>
                                    <td>Trước: @item.camera_truoc.GetValueOrDefault() mpx, Sau: @item.camera_sau.GetValueOrDefault()</td>
                                <tr>
                                    <th>Màn Hình</th>
                                    <td>@item.manhinh.GetValueOrDefault() Inc</td>
                                </tr>
                                <tr>
                                    <th>Pin</th>
                                    <td>@item.pin.GetValueOrDefault() mAh</td>
                                </tr>

                            </table>
                        </div>
                    </div>
                </div>



                <div class="tab-pane fade" id="reviews">
                    <div class="col-sm-12">
                        <ul>
                            <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                            <li><a href=""><i class="fa fa-clock-o"></i>@DateTime.Now.ToShortTimeString()</a></li>
                            <li><a href=""><i class="fa fa-calendar-o"></i>@DateTime.Now.Date.ToShortDateString()</a></li>
                        </ul>
                        <p><b>Bình Luận</b></p>

                        <form action="#">
                            <span>
                                <input placeholder="Your Name" type="text">
                                <input placeholder="Email Address" type="email">
                            </span>
                            <textarea name=""></textarea>
                            <b>Rating: </b> <img src="images/product-details/rating.png" alt="">
                            <button type="button" class="btn btn-default pull-right">
                                Submit
                            </button>
                        </form>
                    </div>
                </div>

            </div>
        </div><!--/category-tab-->

        <div class="recommended_items">
            <!--recommended_items-->
            <h2 class="title text-center">Sản Phẩm Cùng Loại</h2>

            <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="item active">
                        @foreach (var r_item in listRC)
                        {
                        <div class="col-md-3">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="@r_item.link_anh" alt=""  height="260">
                                        <h2>@r_item.gia.GetValueOrDefault().ToString("N0") Đ</h2>
                                        <p>@r_item.ten</p>
                                        <a  class="btn btn-default add-to-cart"  href="/Cart/AddItem/@item.id"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        }


                    </div>
                    <div class="item">
                        @foreach (var r_item in listRC)
                        {
                        <div class="col-md-3">
                            <div class="product-image-wrapper">
                                <div class="single-products">
                                    <div class="productinfo text-center">
                                        <img src="@r_item.link_anh" alt="" height="260">
                                        <h2>@r_item.gia.GetValueOrDefault().ToString("N0") Đ</h2>
                                        <p>@r_item.ten</p>
                                        <a class="btn btn-default add-to-cart" href="/Cart/AddItem/@item.id"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        }

                    </div>
                </div>
                <a class="left recommended-item-control" href="#recommended-item-carousel" data-slide="prev">
                    <i class="fa fa-angle-left"></i>
                </a>
                <a class="right recommended-item-control" href="#recommended-item-carousel" data-slide="next">
                    <i class="fa fa-angle-right"></i>
                </a>
            </div>
        </div><!--/recommended_items-->
        <!--submit number of items to cart-->
        <script type="text/javascript" language="javascript">
            function additem() {
                var count = $('#num-of-product').val();
                if (count > 0) {
                    var ulr = "/Cart/AddItems/?id=" +@item.id.ToString() +'&' + "count=" + count;
                    window.location.href = ulr;
                }
            }

        </script>

    </div>
</section>
<%--/section--%>

<br/>
<br/>
<footer id="footer">
    <!--Footer-->
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="companyinfo">
                        <h2><span>GT</span>-mobile</h2>
                        <p>Ở đâu có điện thoại, ở đó có GT.</p>
                    </div>
                </div>
                <div class="col-sm-7">
                    <div class="col-sm-3">
                        <div class="single-widget">
                            <h2>Hỏi Đáp</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li>Mua hàng online.</li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-3">
                        <div class="single-widget">
                            <h2>Đổi Trả Hàng</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li>Dễ dàng lên đến 45 ngày.</li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-sm-3">
                        <div class="single-widget">
                            <h2>Miễn Phí</h2>
                            <ul class="nav nav-pills nav-stacked">
                                <li>Vận chuyển toàn quốc.</li>
                            </ul>
                        </div>
                    </div>


                </div>
                <div class="col-sm-3">
                    <div class="address">
                        <img src="images/home/map.png" alt=""/>
                        <p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer-widget">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Dịch Vụ</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="">Trợ Giúp Online</a></li>
                            <li><a href="">Liên hệ</a></li>
                            <li><a href="">Tình Trạng Đơn Hàng.</a></li>
                            <li><a href="">FAQ’s</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Chính Sách</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="">Bảo Hành</a></li>
                            <li><a href="">Đổi Trả</a></li>
                            <li><a href="">Mua Hàng Online</a></li>
                            <li><a href="">Phương Thức Thanh Toán</a></li>

                        </ul>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Thông Tin</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="">Giới thiệu công ty</a></li>
                            <li><a href="">Hệ thống cửa hàng</a></li>
                            <li><a href="">Tuyển dụng</a></li>
                            <li><a href="">Góp ý, khiếu nại</a></li>

                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-sm-offset-1">
                    <div class="single-widget">
                        <h2>About Shopper</h2>
                        <form action="" method="post" class="searchform">
                            <input type="text" placeholder="Địa chỉ e-mail"/>
                            <button type="submit" class="btn btn-default"><i class="fa fa-arrow-circle-o-right"></i>
                            </button>
                            <p>Nhận những thông tin cập nhật sớm nhất <br/>từ chúng tôi...</p>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <p class="pull-left">Copyright © 2018 GT-mobile Inc.</p>
                <p class="pull-right">thiết kế bởi <span>vn_l3h4ng</span></p>
            </div>
        </div>
    </div>

</footer><!--/Footer-->

<spring:url value="/js/layout/jquery.js" var="springJs1"/>
<script src="${springJs1}"></script>
<spring:url value="/js/layout/bootstrap.min.js" var="springJs2"/>
<script src="${springJs2}"></script>
<spring:url value="/js/layout/jquery.scrollUp.min.js" var="springJs3"/>
<script src="${springJs3}"></script>
<spring:url value="/js/layout/jquery.prettyPhoto.js" var="springJs4"/>
<script src="${springJs4}"></script>
<spring:url value="/js/layout/main.js" var="springJs5"/>
<script src="${springJs5}"></script>

</body>
</html>