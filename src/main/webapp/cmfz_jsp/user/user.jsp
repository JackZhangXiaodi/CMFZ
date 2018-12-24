<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#userShowAll").edatagrid({
            fit:true,
            fitColumns:true,
            url:'${pageContext.request.contextPath}/user/findAll',
            updateUrl:'${pageContext.request.contextPath}/user/update',
            autoSave:true,
            toolbar:[{
                iconCls:'icon-save',
                text:'保存',
                handler:save
            }],
            columns:[[
                {field:'name',title:'用户名',align:'center',width:'10% '},
                {field:'password',title:'密码',width:'10% ',align:'center'},
                {field:'dharmaName',title:'法名',align:'center',width:'5% '},
                {field:'sex',title:'性别',align:'center',width:'5% '},
                {field:'province',title:'省',align:'center',width:'10% '},
                {field:'city',title:'市/区',align:'center',width:'10% '},
                {field:'autogroaph',title:'签名',align:'center',width:'10% '},
                {field:'userstatus',title:'状态',align:'center',width:'10% ',editor:{type:'validatebox',options:{required:true}}},
                {field:'phone',title:'手机号',align:'center',width:'10% '},
                {field:'salt',title:'盐值',align:'center',width:'10% '},
                {field:'registerTime',title:'注册时间',align:'center',width:'10% '}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="../cmfz_jsp/user/photo/' + rowData.photo+'" style="height:80px;"></td>' +
                    '<td style="border:0">' +
                    '<p>昵称: ' + rowData.name+ '</p>' +
                    '<p>用户状态: ' + rowData.userstatus + '</p>' +
                    '<p>签名: ' + rowData.autogroaph + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        })
    })
//点击保存刷新页面
    function save() {
        $("#userShowAll").edatagrid('reload');
    }
</script>
<%--展示所有的用户--%>
<table id="userShowAll"></table>
<%--添加对话框--%>
<div id="adduser"></div>
<%--修改对话框--%>
<div id="updateuser"></div>