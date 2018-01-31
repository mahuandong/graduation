$(function($){
    var a=1 ;
    $.ajax({
        type: "GET",
        url: "../happenSelectAll.json",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            a = tmp;}
    });
    console.log(a);//打印服务端返回的数据(调试用)
    for(var i = 0; i < a.length; i++) {
        if (a[i].areaCode == 14){
            s = "<tr><td>山西省</td>";
        }
        s=s+"<td>"+a[i].year+"</td><td>"+a[i].population+"</td><td>"+a[i].laborForce+"</td><td>"+a[i].primary+
            "</td><td>"+ a[i].second+ "</td><td>"+ a[i].third+"</td><td>"+
            "<div class=\"tpl-table-black-operation\">"+
            "<a href=\"javascript:;\">"+
            "<i class=\"am-icon-pencil\"></i> 编辑</a>"+
            "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\">"+
            "<i class=\"am-icon-trash\"></i> 删除 </a> </div></td></tr>"
        $("#economicList").append(s);
    }
});