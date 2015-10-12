<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../layout/taglib.jsp" %>
    
    <table class="table table-bordered table-hover table-striped">
    <thead>
    	<tr>
    	<td>User Name</td>
    	<td>Operations</td>
    	</tr>
    
    </thead>
    <tbody>
    	<c:forEach items="${users}" var="user">
    		<tr>
    			<td>
    				<A href=<spring:url value="/users/${user.id}.html"/> > <c:out value="${user.name}" /> </A>
    				
    			</td>
    			<td>
    				<A href=<spring:url value="/user/remove/${user.id}.html"/>  class="btn btn-danger triggerRemove"> Remove</A>
    				
    			</td>
    		</tr>
    	</c:forEach>
    
    </tbody>
    
    </table>
    
    <script type="text/javascript">
$(document).ready(function(){
	$(".triggerRemove").click(function(e){
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href",$(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

  <!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Remove Blog</h4>
      </div>
      <div class="modal-body">
        Really Remove ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <a href="" class= "btn btn-danger removeBtn">Remove</a>
      </div>
    </div>
  </div>
</div>  
    
    