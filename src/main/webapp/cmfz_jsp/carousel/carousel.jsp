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
       $("#carouselShowAll").datagrid({
           fit:true,
           singleSelect:true,
           url:'${pageContext.request.contextPath}/carousel/findAll',
           toolbar:[
                     {iconCls:'icon-add', text:'ADD',handler:add},
               {iconCls:'icon-cancel', text:'DELETE',handler:deleteCarousel},
               {iconCls:'icon-edit', text:'UPDATE',handler:updateCarousel},
               {iconCls:'icon-save', text:'SAVE'},
             ],
           columns:[[
               {field:'carPicture',title:'图片',width:'15%',align:'center'},
               {field:'carName',title:'图片名称',width:'15%',align:'center'},
               {field:'carStatus',title:'状态',width:'15%',align:'center'},
               {field:'crateTime',title:'时间',width:'15%',align:'center'},
               {field:'desca',title:'描述',width:'15%',align:'center'},
               {field:'options',title:'操作',width:'25%',formatter:function (value,row,index) {
                       //将js对象转换成字符串的json
                        var json = JSON.stringify(row);
                        return "<div ><a href='javascript:;' onclick='deleteCarousel("+json+")' class='options' data-options=\"plain:true,iconCls:'icon-remove'\">DELETE</a>&nbsp;&nbsp;<a href='javascript:;' onclick='updateCarousel("+json+")' class='options' data-options=\"plain:true,iconCls:'icon-edit'\">UPDATE</a></div>"
               },align:'center'}
           ]],
           onLoadSuccess:function(){
               $(".options").linkbutton();
           },
           view: detailview,
           detailFormatter: function(rowIndex, rowData){
               return '<table><tr>' +
                   '<td rowspan=2 style="border:0"><img src="../cmfz_jsp/carousel/' + rowData.carPicture+'" style="height:80px;"></td>' +
                   '<td style="border:0">' +
                   '<p>图片名称: ' + rowData.carName+ '</p>' +
                   '<p>图片状态: ' + rowData.carStatus + '</p>' +
                   '<p>上传时间: ' + rowData.crateTime + '</p>' +
                   '</td>' +
                   '</tr></table>';
           }
       });
    });
//   点击添加按钮跳出对话框
    function add(){
        $("#addCarousel").dialog({
            width:600,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz_jsp/carousel/addCarousel.jsp',
            buttons:[{
                iconCls: 'icon-save',
                text: 'ADD',
                handler:pdd,
            },{
                iconCls:'icon-cancel',
                text:'CLOSE',
                handler:close,
            }
            ]
        });
    }
//    点击ADD提交form表单
    function pdd(){
        $("#addcarousel").form('submit',{
            url:"${pageContext.request.contextPath}/carousel/add",
            success:function (result) {
                //将JSON字符串转换为JSON对象格式
                var json= $.parseJSON(result);
                console.log(json);
                if(json.success){
                    //关闭对话框
                    $("#addCarousel").dialog('close');
                    //弹出消息提示框
                    $.messager.show({
                        title:'ADD',
                        msg:json.message,
                    }),
                    //刷新数据表格
                    $("#carouselShowAll").datagrid('reload');
                }
            }
        })
    }
//    点击关闭按钮直接关闭对话框
    function close() {
        $("#addCarousel").dialog('close');
    }
//    点击删除
    function deleteCarousel(){
        var json = $("#carouselShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.progress({
                title:'POLIC',
                msg:'请选中一行信息'
            })
        }
        $.messager.confirm({
            title:'Delete',
            msg:'ARE YOU SURE DELETE!',
            fn:function (r) {
                if(r){
                    $.post("${pageContext.request.contextPath}/carousel/delete",{"carId":json.carId},function (result) {
                        //将json字符串转为json对象
                       // var carousel=$.parseJSON(result);
                        if(result.success){
                            $.messager.show({
                                title:'REMIND',
                                msg:result.message
                            })
                            //刷新数据表格
                            $("#carouselShowAll").datagrid('reload');
                        }
                    },"JSON")
                }
            }
        })
    }
//点击修改按钮
    function updateCarousel() {
        var json = $("#carouselShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.progress({
                title:'POLIC',
                msg:'请选中一行信息'
            })
        }
        $("#updateCarouse").dialog({
            width:600,
            height:500,
            href:'${pageContext.request.contextPath}/cmfz_jsp/carousel/updateCarousel.jsp?carId='+json.carId,
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
    //点击修改保存 提交form表单
    function update(){
        $("#updateCarousel").form('submit',{
            url:'${pageContext.request.contextPath}/carousel/update',
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
                    $("#carouselShowAll").datagrid('reload');
                }
            }
        })
    }
    //点击close
    function closen(){
        $("#updateCarouse").dialog('close');
    }
</script>
<%--展示所有的轮播图信息--%>
<table id="carouselShowAll"></table>
<%--添加对话框--%>
<div id="addCarousel"></div>
<%--修改对话框--%>
<div id="updateCarouse"></div>