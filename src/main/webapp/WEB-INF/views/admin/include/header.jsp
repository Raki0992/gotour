<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!-- 제공기능 로케일, 메시지, 숫자 문자 형식 등 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<header class="main-header">

    <!-- Logo -->
    <a href="/admin/admin_menu" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>A</b>LT</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>GoTour</b></span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <li class="dropdown messages-menu">
            <a href="#">최근접속시간 : [<fmt:formatDate value="${sessionScope.adminStatus.admin_visit_date }" pattern="yyyy-MM-dd hh:mm:ss"/>]</a>
          </li>
		</ul>
		
		<c:if test="${sessionScope.adminStatus != null }">
		<ul class="nav navbar-nav">
			<li class="dropdown messages-menu">
            <a href="/admin/logout">로그아웃</a>
       		</li>
        </ul>
        </c:if>
        
         <ul class="nav navbar-nav">
			<li class="dropdown messages-menu">
            <a href="/">[admin]</a>
       		</li>
        </ul>
      </div>
    </nav>
  </header>