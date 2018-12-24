<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function(){
       $("#guruShowAll").datagrid({
           fit:true,
           singleSelect:true,
           url:'${pageContext.request.contextPath}/guru/findAll',
           toolbar:[
               {iconCls:'icon-add', text:'ADD',handler:add},
               {iconCls:'icon-edit', text:'UPDATE',handler:updateguru},
               {iconCls:'icon-save', text:'SAVE'},
             ],
           columns:[[
               {field:'guruName',title:'上师名称',width:'25%',align:'center'},
               {field:'guruDescribe',title:'上师的描述',width:'25%',align:'center'},
               {field:'guruPhoto',title:'上师的头像',width:'25%',align:'center'},
               {field:'guruStatus',title:'状态',width:'25%',align:'center'},
           ]],
           onLoadSuccess:function(){
               $(".options").linkbutton();
           },
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="../cmfz_jsp/carousel/' + rowData.guruPhoto+'" style="height:80px;"></td>' +
                   '<td style="border:0">' +
                   '<p>上师名称: ' + rowData.guruName+ '</p>' +
                   '<p>上师状态: ' + rowData.guruStatus + '</p>' +
                   '<p>上师描述: ' + rowData.guruDescribe + '</p>' +
                   '</td>' +
                   '</tr></table>';
           }
       });
    });
//   点击添加按钮跳出对话框
    function add(){
        $("#addGuru").dialog({
            width:600,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz_jsp/guru/addGuru.jsp',
            buttons:[{
                iconCls: 'icon-save',
                text: 'ADD',
                handler:dd,
            },{
                iconCls:'icon-cancel',
                text:'CLOSE',
                handler:close,
            }
            ]
        });
    }
//    点击ADD提交form表单
    function dd(){
        $("#addguru").form('submit',{
            url:"${pageContext.request.contextPath}/guru/add",
            success:function (result) {
                //将JSON字符串转换为JSON对象格式
                var json= $.parseJSON(result);
                if(json.success){
                    //关闭对话框
                    $("#addGuru").dialog('close');
                    //弹出消息提示框
                    $.messager.show({
                        title:'ADD',
                        msg:json.message,
                    }),
                    //刷新数据表格
                    $("#guruShowAll").datagrid('reload');
                }
            }
        })
    }
//    点击关闭按钮直接关闭对话框
    function close() {
        $("#addGuru").dialog('close');
    }
//    点击删除
    /*function deleteguru(){
        var json = $("#guruShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.progress({
                title:'POLICE',
                msg:'请选中一行信息'
            })
        }
        $.messager.confirm({
            title:'Delete',
            msg:'ARE YOU SURE DELETE!',
            fn:function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/guru/delete",{"guruId":json.guruId},function (result) {
                        //将json字符串转为json对象
                       // var carousel=$.parseJSON(result);
                        if(result.success){
                            $.messager.show({
                                title:'REMIND',
                                msg:result.message
                            })
                            //刷新数据表格
                            $("#guruShowAll").datagrid('reload');
                        }
                    },"JSON")
                }
            }
        })
    }*/
//点击修改按钮
    function updateguru() {
        var json = $("#guruShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.alert({
                title:'POLIC',
                msg:'请选中一行信息'
            })
        }else{
            $("#updateGuru").dialog({
                width:600,
                height:500,
                href:'${pageContext.request.contextPath}/cmfz_jsp/guru/updateGuru.jsp?guruId='+json.guruId,
                buttons:[{
                    text:'UPDATE',
                    iconCls:'icon-edit',
                    handler:update
                },{
                    text:'close',
                    iconCls:'icon-cancel',
                    handler:closen,
                }]
            });
        }

    }
    //点击修改保存 提交form表单
    function update(){
        $("#updateguru").form('submit',{
            url:'${pageContext.request.contextPath}/guru/update',
            success:function (result) {
            //    将resultJSON字符串转化JSON对象
                var json = $.parseJSON(result);
                if(json.success){
                    //关闭对话框
                    closen();
                    //弹出消息框
                    $.messager.show({
                        title:'REMIND',
                        msg:json.message
                    })
                    //刷新数据表格
                    $("#guruShowAll").datagrid('reload');
                }
            }
        })
    }
    //点击close
    function closen(){
        $("#updateGuru").dialog('close');
    }
</script>
<%--展示所有的轮播图信息--%>
<table id="guruShowAll"></table>
<%--添加对话框--%>
<div id="addGuru"></div>
<%--修改对话框--%>
<div id="updateGuru"></div>