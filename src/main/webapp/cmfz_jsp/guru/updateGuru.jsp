
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#updateguru").form('load','${pageContext.request.contextPath}/guru/findOne?guruId=${param.guruId}');
    })

</script>
<div style="text-align: center;">
    <form id="updateguru" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 100px;">
            <label for="asd">上师ID:</label>
            <input  class="easyui-textbox" name="guruId" data-options="required:true,width:240,readonly:true" />
        </div>
        <div style="margin-top: 10px;">
            <label for="name">上师名称:</label>
            <input  class="easyui-textbox"  name="guruName" data-options="required:true,width:240,readonly:true" />
        </div>
        <div style="margin-top: 20px">
            <label for="desc">上师的描述:</label>
            <input  class="easyui-textbox" name="guruDescribe"  data-options="required:true,width:240,readonly:true" />
        </div>
        <div style="margin-top: 20px">
            <label for="status">上师状态:</label>
            <input  class="easyui-textbox" name="guruStatus"  data-options="required:true,width:240" />
        </div>
    </form>
</div>