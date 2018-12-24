<%--
  Created by IntelliJ IDEA.
  User: Jack
  Date: 2018/12/4
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<div style="text-align: center;">
    <form id="addguru" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 100px;">
            <label for="asd">上师名称:</label>
            <input  class="easyui-textbox" type="text" name="guruName" data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 10px;">
            <label for="name">上师的头像:</label>
            <input class="easyui-filebox"  name="aa" data-options="required:true,width:240"/>
        </div>
        <div style="margin-top: 20px">
            <label for="asd">上师的状态:</label>
            <input  class="easyui-textbox" type="text" name="guruStatus"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="asd">上师的的描述:</label>
            <input  class="easyui-textbox" type="text" name="guruDescribe"  data-options="required:true,width:240" />
        </div>

    </form>
</div>