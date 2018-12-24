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
        $("#albumShowAll").treegrid({
            url:'${pageContext.request.contextPath}/album/findAll',
            idField:'id',
            treeField :'name',
            fit : true,// 自动补全
            lines:true,
            animate:true,
            pagination:true,
            pageList:[4,10,20,30,40,50],
            toolbar:[
                {iconCls:'icon-filter',text:'专辑详情',handler:editAlbum},"-",
                {iconCls:'icon-add',text:'添加专辑',handler: addAblum},"-",
                {iconCls:'icon-add',text:'添加章节',handler:addChapter},"-",
                {iconCls:'icon-undo',text:'下载章节',handler:unloadChapter},
            ],
            columns:[[
                {field:'name',title:'章节名称',width:'22%',align:'center'},
                {field:'chapSize',title:'章节大小',width:'20%',align:'center'},
                {field:'chapUrl',title:'章节路径',width:'20%',align:'center'},
                {field:'duration',title:'章节时长',width:'20%',align:'center'},
                {field:'uploadDate',title:'章节时间',width:'20%',align:'center'},
            ]],

         })
        });
    //点击专辑详情展示
    function editAlbum() {
        var json = $("#albumShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.alert({
                title:'POLICE',
                msg:'请选中一行信息'
            })
        }else{
            $("#showAlbum").dialog({
                width:800,
                height:300,
                href:'${pageContext.request.contextPath}/cmfz_jsp/albumAndchapter/showAlbum.jsp?id='+json.id,
                buttons:[{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:c,
                }]
            })
        }

    }
//  点击关闭专辑详情对话框
    function c() {
        $("#showAlbum").dialog('close');
    }
//    点击添加专辑
    function addAblum() {
         $("#addAlbum").dialog({
             width:700,
             height: 500,
             title:'添加专辑',
             href:'${pageContext.request.contextPath}/cmfz_jsp/albumAndchapter/addAlbum.jsp',
             buttons: [{
                 iconCls:'icon-save',
                 text:'添加',
                 handler:adda,
             },{
                 iconCls:'icon-cancel',
                 text:'关闭',
                 handler:cc,
             }
             ]
         })
    }
//    点击添加按钮
    function adda() {
        $("#addbum").form('submit',{
            url:'${pageContext.request.contextPath}/album/add',
            success:function (result) {
                //将json字符串转化为json对象
                    //关闭对话框
                    cc();
                    //刷新页面
                    $("#albumShowAll").treegrid('reload');
                //提示消息
                $.messager.show({
                    title:'提示',
                    msg:'添加成功',
                })
                }
            })
    }
//    点击关闭对话框
    function cc() {
        $("#addAlbum").dialog('close');
    }
//    点击添加章节
    function addChapter() {
        var json = $("#albumShowAll").datagrid('getSelected');
        if(json==null){
            $.messager.alert({
                title:'POLICE',
                msg:'请选中一行信息'
            })
        }else{
            $("#addchapter").dialog({
                width:700,
                height: 500,
                title:'添加章节',
                href:'${pageContext.request.contextPath}/cmfz_jsp/albumAndchapter/addChapter.jsp?albumName='+json.name,
                buttons:[{
                    iconCls:'icon-save',
                    text:'保存',
                    handler:addc,
                },{
                    iconCls:'icon-cancel',
                    text:'关闭',
                    handler:ccc,
                }]
            })
        }
    }
//    点击addc
    function addc() {
        $("#addChapter").form('submit',{
            url:'${pageContext.request.contextPath}/chapter/add',
            success:function (result) {
                //将json字符串转化为json对象
                var json=$.parseJSON(result);
                if(json.success){
                    //关闭对话框
                    ccc();
                    //提示消息
                    $.messager.show({
                        title:'提示',
                        msg:json.message,
                    })
                    //刷新页面
                    tree();
                }
            }
        })
    }
//    刷新treegrid表格
    function tree(){
        //刷新页面
        $("#albumShowAll").treegrid('reload');
    }
    //    点击关闭对话框
    function ccc() {
        $("#addchapter").dialog('close');
    }
//    点击下载
    function unloadChapter() {
        var json= $("#albumShowAll").treegrid('getSelected');
        if(json.chapSize!=null){
            if(json==null){
                $.messager.confirm({
                    msg:'您未选中',
                })
            }else if(json.name==null){
                $.messager.confirm({
                    msg:'请选择章节',
                })
            }else if(json.id){
                location.href="${pageContext.request.contextPath}/chapter/uploadDown?name="+json.name;
            }
        }else{
            $.messager.confirm({
                msg:'请选择章节',
            })
        }

    }
</script>
<%--展示所有的轮播图信息--%>
<table id="albumShowAll"></table>
<%--展示专辑详情的--%>
<div id="showAlbum"></div>
<%--添加专辑的对话框--%>
<div id="addAlbum"></div>
<%--添加章节的对话框--%>
<div id="addchapter"></div>