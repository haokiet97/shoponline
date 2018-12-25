<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<div class="col-sm-3">
    <div class="left-sidebar">
        <h2>Danh Mục</h2>
        <div class="panel-group category-products" id="accordian">
            <!--category-productsr-->
            <c:forEach items="${danhmuc}" var="item">
            <div class="panel panel-default">
                <div id="panel-heading" class="panel-heading">
                    <h4 class="panel-title"><a id="panel-title" href="/DanhMuc/${item.id}">${item.ten}</a>
                    </h4>
                </div>
            </div>
            </c:forEach>

        </div><!--/category-products-->

        <div class="brands_products">
            <!--brands_products-->
            <h2>Thương Hiệu</h2>
            <div class="brands-name">
                <ul class="nav nav-pills nav-stacked">
                    <c:forEach items="${nhasanxuat}" var="item">
                        <li><a id="brans-heading" href="/NhaSanXuat/${item.id}"> <span
                                class="pull-right">(0)</span>${item.ten}</a></li>
                    </c:forEach>

                </ul>
            </div>
        </div><!--/brands_products-->


        <div class="price-range">
            <!--price-range-->
            <h2>Price Range</h2>
            <div class="well text-center">
                <div class="slider slider-horizontal" style="width: 187px;">
                    <div class="slider-track">
                        <div class="slider-selection" style="left: 41.6667%; width: 33.3333%;"></div>
                        <div class="slider-handle round left-round" style="left: 41.6667%;"></div>
                        <div class="slider-handle round" style="left: 75%;"></div>
                    </div>
                    <div class="tooltip top" style="top: -30px; left: 76.0833px;">
                        <div class="tooltip-arrow"></div>
                        <div class="tooltip-inner">250 : 450</div>
                    </div>
                    <input class="span2" value="" data-slider-min="0" data-slider-max="600" data-slider-step="5"
                           data-slider-value="[250,450]" id="sl2" style="" type="text"></div>
                <br>
                <b class="pull-left">$ 0</b> <b class="pull-right">$ 600</b>
            </div>
        </div><!--/price-range-->

        <div class="shipping text-center">
            <!--shipping-->
            <img src="images/home/shipping.jpg" alt="">
        </div><!--/shipping-->

    </div>
</div>