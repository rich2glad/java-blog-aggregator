<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../layout/taglib.jsp" %>
    
    <table class="table table-bordered table-hover table-striped">
    <thead>
    	<tr>
    	<td>User Name</td>
    	</tr>
    
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
    		<tr>
    			<td>
    				<A href=<spring:url value="/users/${user.id}.html"/> > ${user.name}</A>
    				
    			</td>
    		</tr>
    	</c:forEach>
    
    </tbody>
    
    </table>

    
    