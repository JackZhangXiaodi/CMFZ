<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
	$(function(){
		$("#updatePassword").form('load','${pageContext.request.contextPath}/admin/findOne?adminId=${param.adminId}')
        $("#old").textbox({
            onChange:code,
		})
		$("#new2").textbox({
			onChange:aa,
		})
	});
	function code(){
	    var password = $("#old").val();
	    $.post("${pageContext.request.contextPath}/admin/old",{"password":password},
			function(result){
	        	if(!result.success){
					$("#h").html("<font style='color: deeppink'>"+result.message+"</font>");
				}else{
                    $("#h").html("");
				}
			},"JSON");

	}
   		function aa() {
            var new2 = $("#new2").val();
            var new1=$("#new").val();
            if(new2!=new1){
                $("#n").html("<font style='color: deeppink'>新密码不一致</font>")
            }else{
                $("#n").html("")
            }
        }

</script>


<div style="text-align: center;">
	<form id="updatePassword" class="easyui-form" method="post">
		<input  name="adminId" type="hidden"/>
		<div style="margin-top: 100px;">
			<label for="password">请输入旧密码:</label>
			<input id="old" class="easyui-textbox" type="password"  data-options="required:true,width:240" />
			<h4 id="h"></h4>
		</div>
		<div style="margin-top: 20px">
			<label for="password">新密码:</label>
			<input id="new" class="easyui-textbox" type="password"  data-options="required:true,width:240" />
		</div>
		<div style="margin-top: 20px">
			<label for="password">请再次输入新密码:</label>
			<input id= "new2"  class="easyui-textbox" type="password" name="pwa"  data-options="required:true,width:240" onblur="aa()"/>
			<h4 id="n"></h4>
		</div>
	</form>
</div>
