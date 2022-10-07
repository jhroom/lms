<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="${pageContext.request.contextPath}/index" class="brand-link">
      <img src="${pageContext.request.contextPath}/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">LMS 5000</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
         <%-- <div class="image">
          <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div> --%>
        <div class="info">
          <a href="${pageContext.request.contextPath}/index/mypage" class="d-block">
          <c:choose>
          	<c:when test="${loginUser.userName != null}">
          		 ${loginUser.userName}님
	        		<c:choose>
	        			<c:when test="${loginUser == null }">
	        				<span><a href="${pageContext.request.contextPath}/index/login">로그인</a></span>	
	        			</c:when>
	        			<c:otherwise>
	        				<span><a href="${pageContext.request.contextPath}/index/logout">로그아웃</a>	</span>
	        			</c:otherwise>
	        		</c:choose>
          	</c:when>
          	<c:otherwise>
          		Guest님
          	</c:otherwise>
          </c:choose>
         
          </a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
    
      <!-- 템플릿 -->
      <!-- 
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library 
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Starter Pages__운영자
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Active Page</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Inactive Page</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Simple Link
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
        </ul>
        <!-- 템플릿 
         -->

		<!-- 사이드바 ul 시작 -->
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

         <c:if test="${loginUser.userLevel eq 1||loginUser.userLevel eq 4}">
         <!-- 운영자 사이드바 -->
         <!-- 제작 -->
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                운영자_학교 운영
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/lmsSemester/SemesterList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>학기 리스트</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/lmsMajor/MajorList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>학과 리스트</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/lmsSubject/SubjectList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>과목 리스트</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/lmsLecture/LectureList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>강좌 리스트</p>
                </a>
              </li>
	               <li class="nav-item">
	                <a href="${pageContext.request.contextPath}/user/userList" class="nav-link">
	                  <i class="far fa-circle nav-icon"></i>
	                	<p>유저 리스트</p>
	                </a>
	              </li>
            
            </ul>
          </li>
          <!-- end 제작 -->
          
          <!-- 관리 -->
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                운영자_학생 관리
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/sign/SignListForAdmin" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>수강신청 관리</p>
                </a>
              </li>

            </ul>
          </li>
          <!-- end 관리 -->

        <!-- end 운영자 사이드바 -->
        </c:if>
        

      <!-- 교수 사이드바 -->
      <c:if test="${loginUser.userLevel eq 2}">
        
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                교수_
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Active Page</p>
                </a>
              </li>

            </ul>
          </li>

		</c:if>
        <!-- end 교수 사이드바 -->
        
      <!-- 학생 사이드바 -->
      <c:if test="${loginUser.userLevel eq 3}">
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                학생_
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/sign/stDash" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>수강신청</p>
                </a>
              </li>

            </ul>
          </li>
		</c:if>

         <!-- end 학생 사이드바 -->
         
         <!-- 일반 링크 -->
         <!-- lms 공지사항 -->
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/lmsNotice/LmsNoticeList" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                LMS 공지사항

              </p>
            </a>
          </li>
          
          <!-- 메세지 -->
 <%--            <a onclick="window.open('${pageContext.request.contextPath}/user/messageList'
				, '새창', 'width=300px, height=500px' , 'location=no' , 'toolbar=yes'); return false" class="nav-link">
              <i class="nav-icon fas fa-th"></i> --%>
		 <li class="nav-item has-treeview menu">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                메시지
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/user/messageList" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>메일함</p>
                </a>
                <a href="${pageContext.request.contextPath}/user/message" class="nav-link">
                	<i class="far fa-circle nav-icon"></i>
                  	<p>메시지 보내기</p>
                </a>
                <a href="${pageContext.request.contextPath}/user/sendmessageList" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                  <p>보낸 메일함</p>
                </a>
                <a href="${pageContext.request.contextPath}/user/receivemessageList" class="nav-link">
                <i class="far fa-circle nav-icon"></i>
                  <p>받은 메일함</p>
                </a>
              </li>

            </ul>
          </li>  
              
     <%--       <a href="${pageContext.request.contextPath}/user/messageList" class="nav-link">
              <p>
                메세지
              </p>
            </a>
          </li> --%>
          
          <!-- 마이페이지 -->
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/index/mypage" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                마이페이지

              </p>
            </a>
          </li>
          
          <!-- end 일반 링크 -->
         
        </ul>
		<!-- end 사이드바 ul -->
        
        	<div style=" position:fixed; bottom: 15px; left:15px;">
        		<c:choose>
        			<c:when test="${loginUser == null }">
        				<a href="${pageContext.request.contextPath}/index/login">로그인</a><br>		
        			</c:when>
        			<c:otherwise>
        				<a href="${pageContext.request.contextPath}/index/logout">로그아웃</a>		
        			</c:otherwise>
        		</c:choose>
        	</div>
        	
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
