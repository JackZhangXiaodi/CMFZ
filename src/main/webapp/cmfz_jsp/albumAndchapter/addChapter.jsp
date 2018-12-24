<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="addChapter" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 20px">
            <label for="asd">专辑名称:</label>
            <input  class="easyui-textbox" type="text" name="albumName" value="${param.albumName}" data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">下载路径:</label>
            <input  class="easyui-filebox" type="text" name="aa"  data-options="required:true,width:240" />
        </div>
    </form>
</div>