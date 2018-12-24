
<%@ page contentType="text/html; utf-8"  isELIgnored="false" pageEncoding="UTF-8" %>
<script>
    $(function () {
        $("#updateCarousel").form('load','${pageContext.request.contextPath}/carousel/findOne?carId=${param.carId}');
    })

</script>
<div style="text-align: center;">
    <form id="updateCarousel" class="easyui-form" method="post" enctype="multipart/form-data">
        <div style="margin-top: 100px;">
            <label for="asd">轮播图ID:</label>
            <input  class="easyui-textbox" type="text" name="carId" data-options="required:true,width:240,readonly:true" />
        </div>
        <div style="margin-top: 10px;">
            <label for="name">轮播图名称:</label>
            <input  class="easyui-textbox"  name="carName" data-options="required:true,width:240" />
        </div>

        <div style="margin-top: 20px">
            <label for="status">轮播图片状态:</label>
            <input  class="easyui-textbox" name="carStatus"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="desc">轮播图的描述:</label>
            <input  class="easyui-textbox" name="desca"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 20px">
            <label for="time">轮播图上传时间:</label>
            <input  class="easyui-datebox" name="crateTime"  data-options="required:true,width:240" />
        </div>
        <div style="margin-top: 10px;">
            <label for="picature">上传图片:</label>
            <input class="easyui-filebox"  name="aaa" data-options="required:true,width:240 ,"/>
        </div>
    </form>
</div>