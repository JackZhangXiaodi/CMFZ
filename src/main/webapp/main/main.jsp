<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../js/jquery.etree.js"></script>

    <script type="text/javascript">
	<!--菜单处理-->
    $(function(){
        //发送Ajax请求
        $.post("${pageContext.request.contextPath}/menu/findAll",function(result){
            //一级分类
            $.each(result,function(i,menu){
                var content="<div style='text-align: center'>"
                //添加孩子分类
                $.each(menu.children,function (j,child) {
                    //将字符串转化为js对象
                    var json = JSON.stringify(child);
                    content+="<div style='margin-top: 5px'><a onclick='addTabs("+json+")' href='javascript:;' class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconcls+"'\" style='margin-top: 10px ;color: deeppink;width:95%'>"+child.title+"</a></div>";
                }),
                //添加父分类
               $("#menu").accordion('add',{
                   title:menu.title,
                   iconCls:menu.iconcls,
                   content:content
               })
            });
        },"JSON")
    });
	//点击孩子标签添加选项卡
    function addTabs(json){
        if(!$("#tt").tabs('exists',json.title)){
            $("#tt").tabs('add',{
                title:json.title,
                iconCls:json.iconcls,
                closable:true,
                href:'${pageContext.request.contextPath}'+json.href
            })
        }else{
            $("#tt").tabs('select',json.title);
        }

    }
    //点击修改密码
	function updatePassword(){
        $("#updatepassword").dialog({
            width:700,
            height:400,
            title:"UPDATE PASSWORD",
            href:"${pageContext.request.contextPath}/updatePassword.jsp?adminId=${sessionScope.admin.adminId}",
            buttons:[{
                text:'UPDATE',
                iconCls:'icon-edit',
                handler:update,
            }, {
                text:'CLOSE',
                iconCls:'icon-cancel',
                handler:close,
                }],
        });
    }
//    点击保存
    function update() {
        $("#updatePassword").form('submit',{
            url:'${pageContext.request.contextPath}/admin/update',
            success:function(result) {
                //将json格式字符串转换为js对象
                var admin=$.parseJSON(result);
                var timer1=null;
                if(admin.success){
                    //关闭对话框
                    $("#updatepassword").dialog('close');
                    $.messager.show({
                        title:'UPDATE',
                        msg:admin.message
                    })
                    if(timer1!=null){
                        clearTimeout(timer1);
                    }
                    timer1:setTimeout(function(){
                        login();
                    },3000
                );
                }
            }
        });
    }
//    点击关闭
    function close() {
        //关闭对话框
        $("#updatepassword").dialog('close');
    }
//    修改密码后重新登陆后台管理系统
    function login(){
        location.href='${pageContext.request.contextPath}/admin/out';
    }
</script>

</head>
<body class="easyui-layout" data-options="split:false">
    <div data-options="region:'north'" style="height:100px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:<shiro:principal></shiro:principal> &nbsp;
            <div style="font-size: 16px"><a href="javascript:;"  onClick="updatePassword()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/admin/out" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
        </div>
        </div>
    <div data-options="region:'south'" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单'" style="width:220px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
            <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-home',"  style="background-image:url(image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
<%--添加修改密码对话框--%>
    <div id="updatepassword"></div>
</body>

</html>