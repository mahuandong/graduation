$(function($){
    var a=1 ;
    var s=1 ;
    $.ajax({
        type: "GET",
        url: "../monthlySelectAll.json",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            a = tmp;}
    });
    console.log(a);//打印服务端返回的数据(调试用)
    for(var i = 0; i < a.length; i++) {
        if(a[i].areaCode === '110000'){
            s = "<tr><td>北京市</td>";
        }if(a[i].areaCode === '120000'){
            s = "<tr><td>天津市</td>";
        }if(a[i].areaCode === '130000'){
            s = "<tr><td>河北省</td>";
        }if(a[i].areaCode === '140000'){
            s = "<tr><td>山西省</td>";
        }if(a[i].areaCode === '150000'){
            s = "<tr><td>内蒙古自治区</td>";
        }if(a[i].areaCode === '210000'){
            s = "<tr><td>辽宁省</td>";
        }if(a[i].areaCode === '220000'){
            s = "<tr><td>吉林省</td>";
        }if(a[i].areaCode === '230000'){
            s = "<tr><td>黑龙江省</td>";
        }if(a[i].areaCode === '310000'){
            s = "<tr><td>上海市</td>";
        }if(a[i].areaCode === '320000'){
            s = "<tr><td>江苏省</td>";
        }if(a[i].areaCode === '330000' ){
            s = "<tr><td>浙江省</td>";
        }if(a[i].areaCode === '340000'){
            s = "<tr><td>安徽省</td>";
        }if(a[i].areaCode === '350000'){
            s = "<tr><td>福建省</td>";
        }if(a[i].areaCode === '360000'){
            s = "<tr><td>江西省</td>";
        }if(a[i].areaCode === '370000'){
            s = "<tr><td>山东省</td>";
        }if(a[i].areaCode === '410000'){
            s = "<tr><td>河南省</td>";
        }if(a[i].areaCode === '420000'){
            s = "<tr><td>湖北省</td>";
        }if(a[i].areaCode === '430000'){
            s = "<tr><td>湖南省</td>";
        }if(a[i].areaCode === '440000'){
            s = "<tr><td>广东省</td>";
        }if(a[i].areaCode === '450000'){
            s = "<tr><td>广西壮族自治区</td>";
        }if(a[i].areaCode === '460000'){
            s = "<tr><td>海南省</td>";
        }if(a[i].areaCode === '500000'){
            s = "<tr><td>重庆市</td>";
        }if(a[i].areaCode === '510000'){
            s = "<tr><td>四川省</td>";
        }if(a[i].areaCode === '520000'){
            s = "<tr><td>贵州省</td>";
        }if(a[i].areaCode === '530000'){
            s = "<tr><td>云南省</td>";
        }if(a[i].areaCode === '540000'){
            s = "<tr><td>西藏自治区</td>";
        }if(a[i].areaCode === '610000'){
            s = "<tr><td>陕西省</td>";
        }if(a[i].areaCode === '620000'){
            s = "<tr><td>甘肃省</td>";
        }if(a[i].areaCode === '630000'){
            s = "<tr><td>青海省</td>";
        }if(a[i].areaCode === '640000'){
            s = "<tr><td>宁夏回族自治区</td>";
        }if(a[i].areaCode === '650000'){
            s = "<tr><td>新疆维吾尔自治区</td>";
        }if(a[i].areaCode === '710000'){
            s = "<tr><td>台湾</td>";
        }if(a[i].areaCode === '810000'){
            s = "<tr><td>香港特别行政区</td>";
        }if(a[i].areaCode === '820000'){
            s = "<tr><td>澳门特别行政区</td>";
        }
        s=s+"<td>"+a[i].year+"</td><td>"+a[i].one+"</td><td>"+a[i].feb+"</td><td>"+a[i].three+
            "</td><td>"+ a[i].four+ "</td><td>"+
            "<div class=\"tpl-table-black-operation\">"+
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-edit\"   onclick=\"edit("+a[i].id+ ")\">编辑</button>" +
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-delete\" onclick=\"del("+a[i].id+ ")\">删除</button>"+
            "</div></td></tr>"
        $("#monthlyList").append(s);
    }
    var name = getCookie("name")
    document.getElementById("welcomeName1").innerText = name;
    document.getElementById("welcomeName2").innerText = name;
});

//编辑按钮函数
function edit(id) {
    $.ajax({
        type: "GET",
        url: "../monthlySelectById.json",
        data:"id="+id,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            b = tmp;}
    });
    console.log(b);
    //为对应input填入值
    var userId = b.id;
    document.getElementById("year").value = b.year;
    document.getElementById("areaCode").value = b.areaCode;
    document.getElementById("one").value = b.one;
    document.getElementById("feb").value = b.feb;
    document.getElementById("three").value = b.three;
    document.getElementById("four").value = b.four;
    $('#my-prompt').modal({
        relatedTarget: this,
    });
    //监控提交与取消按钮click事件
    $("#submit").on("click", function(b) {
        $.ajax({
            type: "POST",
            url: "../monthlyUpdate.json",
            dataType: "json",
            data: "id="+userId+"&"+$('#happen').serialize(),
            async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                window.location.href = "/graduation/jsp/monthly.jsp";
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
        url: "../monthlyDelete.json",
        dataType: "json",
        data: "id="+id,
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            window.location.href = "/graduation/jsp/monthly.jsp";
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