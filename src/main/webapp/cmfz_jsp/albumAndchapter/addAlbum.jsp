<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="addbum" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 80px;">
            <label for="asd">专辑名称:</label>
            <input  class="easyui-textbox" type="text" name="name" data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 10px;">
            <label for="name">专辑作者:</label>
            <input class="easyui-textbox"  name="albumAuthor" data-options="required:true,width:240"/>
        </div>
        <div style="margin-top: 20px">
            <label for="asd">播音:</label>
            <input  class="easyui-textbox" type="text" name="albumVoice"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">集数:</label>
            <input  class="easyui-textbox" type="text" name="season"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">发布时间:</label>
            <input  class="easyui-datebox" type="text" name="createdate"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">专辑封面:</label>
            <input  class="easyui-filebox" type="text" name="aa"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">专辑简介:</label>
            <input  class="easyui-textbox" type="text" name="content"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">专辑分数:</label>
            <input  class="easyui-textbox" type="text" name="score"  data-options="required:true,width:240" />
        </div>
    </form>
</div>