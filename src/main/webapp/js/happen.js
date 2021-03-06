var a=1 ;
var s=1 ;
$(function($){
    $.ajax({
        type: "GET",
        url: "../happenAll.json",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            a = tmp;}
    });
    console.log(a);//打印服务端返回的数据(调试用)
    var pno = 1;
    goPage(pno);
    var name = getCookie("name")
    document.getElementById("welcomeName1").innerText = name;
    document.getElementById("welcomeName2").innerText = name;

});

/**
 * 分页函数
 * pno--页数
 * psize--每页显示记录数
 * 分页部分是从真实数据行开始，因而存在加减某个常数，以确定真正的记录数
 * 纯js分页实质是数据行全部加载，通过是否显示属性完成分页功能
 **/
function goPage(pno){
    var num = a.length;//表格所有行数(所有记录数)
    console.log(num);
    var totalPage = 0;//总页数
    var pageSize = 5;//每页显示行数
    //总共分几页
    if(num/pageSize > parseInt(num/pageSize)){
        totalPage=parseInt(num/pageSize)+1;
    }else{
        totalPage=parseInt(num/pageSize);
    }
    var currentPage = pno;//当前页数
    var startRow = (currentPage - 1) * pageSize;//开始显示的行  31
    var endRow = currentPage * pageSize;//结束显示的行   40
    endRow = (endRow > num)? num : endRow;    //40
    console.log(endRow);
    $("#happenList tbody").html("");//在遍历前清空表
    //遍历显示数据实现分页
    for(var i = startRow; i < endRow; i++) {
        if(a[i].areaCode === 110000){
            s = "<tr><td>北京市</td>";
        }if(a[i].areaCode === 120000){
            s = "<tr><td>天津市</td>";
        }if(a[i].areaCode === 130000){
            s = "<tr><td>河北省</td>";
        }if(a[i].areaCode === 140000){
            s = "<tr><td>山西省</td>";
        }if(a[i].areaCode === 150000){
            s = "<tr><td>内蒙古自治区</td>";
        }if(a[i].areaCode === 210000){
            s = "<tr><td>辽宁省</td>";
        }if(a[i].areaCode === 220000){
            s = "<tr><td>吉林省</td>";
        }if(a[i].areaCode === 230000){
            s = "<tr><td>黑龙江省</td>";
        }if(a[i].areaCode === 310000){
            s = "<tr><td>上海市</td>";
        }if(a[i].areaCode === 320000){
            s = "<tr><td>江苏省</td>";
        }if(a[i].areaCode === 330000 ){
            s = "<tr><td>浙江省</td>";
        }if(a[i].areaCode === 340000){
            s = "<tr><td>安徽省</td>";
        }if(a[i].areaCode === 350000){
            s = "<tr><td>福建省</td>";
        }if(a[i].areaCode === 360000){
            s = "<tr><td>江西省</td>";
        }if(a[i].areaCode === 370000){
            s = "<tr><td>山东省</td>";
        }if(a[i].areaCode === 410000){
            s = "<tr><td>河南省</td>";
        }if(a[i].areaCode === 420000){
            s = "<tr><td>湖北省</td>";
        }if(a[i].areaCode === 430000){
            s = "<tr><td>湖南省</td>";
        }if(a[i].areaCode === 440000){
            s = "<tr><td>广东省</td>";
        }if(a[i].areaCode === 450000){
            s = "<tr><td>广西壮族自治区</td>";
        }if(a[i].areaCode === 460000){
            s = "<tr><td>海南省</td>";
        }if(a[i].areaCode === 500000){
            s = "<tr><td>重庆市</td>";
        }if(a[i].areaCode === 510000){
            s = "<tr><td>四川省</td>";
        }if(a[i].areaCode === 520000){
            s = "<tr><td>贵州省</td>";
        }if(a[i].areaCode === 530000){
            s = "<tr><td>云南省</td>";
        }if(a[i].areaCode === 540000){
            s = "<tr><td>西藏自治区</td>";
        }if(a[i].areaCode === 610000){
            s = "<tr><td>陕西省</td>";
        }if(a[i].areaCode === 620000){
            s = "<tr><td>甘肃省</td>";
        }if(a[i].areaCode === 630000){
            s = "<tr><td>青海省</td>";
        }if(a[i].areaCode === 640000){
            s = "<tr><td>宁夏回族自治区</td>";
        }if(a[i].areaCode === 650000){
            s = "<tr><td>新疆维吾尔自治区</td>";
        }if(a[i].areaCode === 710000){
            s = "<tr><td>台湾</td>";
        }if(a[i].areaCode === 810000){
            s = "<tr><td>香港特别行政区</td>";
        }if(a[i].areaCode === 820000){
            s = "<tr><td>澳门特别行政区</td>";
        }
        s=s+"<td>"+a[i].year+"</td><td>"+a[i].population+"</td><td>"+a[i].birth+"</td><td>"+a[i].death+
            "</td><td>"+ a[i].growth+ "</td><td>"+
            "<div class=\"tpl-table-black-operation\">"+
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-edit\"   onclick=\"edit("+a[i].id+ ")\">编辑</button>" +
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-delete\" onclick=\"del("+a[i].id+ ")\">删除</button>"+
            "</div></td></tr>"
        $("#happenList").append(s);
    }
    $("#barcon li").remove();;//在遍历前清空
    var tempStr = "<li>共"+totalPage+"页</li>" +
        "<li><a href=\"#\" onclick='goPage(1)'>首页</a></li>";
    if (currentPage !== 1){
        tempStr += "<li><a href=\"#\" onclick='goPage(1)'>«</a></li>";
    }
    if (currentPage <= 3){
        for(var pageIndex= 1;pageIndex<6;pageIndex++){
            tempStr += "<li id="+pageIndex+"><a  href=\"#\"onclick=\" goPage("+pageIndex+")\">"+ pageIndex +"</a><li>";
        }
    }if (currentPage > 3 && currentPage < totalPage - 2 ){
        for(var pageIndex= currentPage-2 ; pageIndex<currentPage+3;pageIndex++){
            tempStr += "<li id="+pageIndex+"><a  href=\"#\"onclick=\" goPage("+pageIndex+")\">"+ pageIndex +"</a><li>";
        }
    }if (currentPage >= totalPage - 2){
        for(var pageIndex= totalPage - 4 ; pageIndex<=totalPage;pageIndex++){
            tempStr += "<li id="+pageIndex+"><a  href=\"#\"onclick=\" goPage("+pageIndex+")\">"+ pageIndex +"</a><li>";
        }
    }
    tempStr += "<li><a href=\"#\" onclick='goPage(1)'>»</a></li>";
    tempStr += "<li><a href=\"#\" onclick="+"goPage("+totalPage+")>尾页</a></li>";
    document.getElementById("barcon").innerHTML = tempStr;
    $("#"+pno).addClass("am-active");
}

//编辑按钮函数
function edit(id) {
    $.ajax({
        type: "GET",
        url: "../happenById.json",
        data:"id="+id,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            b = tmp;}
    });
    console.log(b);
    //为对应input填入值
    var userId = b[0].id;
    document.getElementById("year").value = b[0].year;
    document.getElementById("areaCode").value = b[0].areaCode;
    document.getElementById("population").value = b[0].population;
    document.getElementById("birth").value = b[0].birth;
    document.getElementById("death").value = b[0].death;
    document.getElementById("growth").value = b[0].growth;
    $('#my-prompt').modal({
        relatedTarget: this,
    });
    //监控提交与取消按钮click事件
    $("#submit").on("click", function(b) {
        $.ajax({
            type: "POST",
            url: "../happenUpdate.json",
            dataType: "json",
            data: "id="+userId+"&"+$('#happen').serialize(),
            async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                window.location.href = "/graduation/jsp/happen.jsp";
            }
        })
    });
    $("#cancel").on("click", function(b) {
        $("#my-prompt").modal('close');//关闭Modal
    });
}
//删除按钮函数
function del(id) {
    $.ajax({
        type: "POST",
        url: "../happenDelete.json",
        dataType: "json",
        data: "id="+id,
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            window.location.href = "/graduation/jsp/happen.jsp";
        }
    })
}
function getCookie(name)
{
    var name = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}