<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="addcarousel" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 100px;">
            <label for="asd">轮播图名称:</label>
            <input  class="easyui-textbox" type="text" name="carName" data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 10px;">
            <label for="name">上传图片:</label>
            <input id="name" class="easyui-filebox"  name="aa" data-options="required:true,width:240"/>
        </div>
        <div style="margin-top: 20px">
            <label for="asd">轮播图片状态:</label>
            <input  class="easyui-textbox" type="text" name="carStatus"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="carousel">轮播图的描述:</label>
            <input id="carousel" class="easyui-textbox" type="text" name="desca"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="time">轮播图上传时间:</label>
            <input id="time" class="easyui-datebox" name="crateTime"  data-options="required:true,width:240" />
        </div>
    </form>
</div>