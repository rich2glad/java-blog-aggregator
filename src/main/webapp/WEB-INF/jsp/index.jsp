
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<h1>Latest news from the Java World</h1>

	<table class="table table-bordered table-hover table-striped">
    		<thead>
    			<tr>
    				<th>Date</th>
    				<th>Item</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:forEach items="${items }" var="item" >
    			<tr>
    				<td>
    					<c:out value="${item.publishDate}" />
					<br />
					<c:out value="${item.blog.name}" />
    				</td>
    				<td>
    					<strong>
    						<a href="<c:out value="${item.link }"/>"  target="_blank" >
    						<c:out value="${item.title }"/>
    						</a>
    					</strong>
    					<br/>
    					${item.description }
    				</td>
    			<tr>
    			</c:forEach>
    		</tbody>
    	
    	</table>
    