$(function($){
    var a=1 ;
    $.ajax({
        type: "GET",
        url: "../userSelectAll.json",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            a = tmp;}
    });
    console.log(a);//打印服务端返回的数据(调试用)
    for(var i = 0; i < a.length; i++) {
        s = "<tr><td>" + a[i].name + "</td><td>" + a[i].account + "</td><td>******</td><td>"
            +a[i].phone + "</td><td>";
        if(a[i].sex == 1){  //当值等于0时输出男，值等于1时输出女
            s = s + "女";
        }if(a[i].sex == 0){
            s = s + "男";
        }
        s =s+"</td><td>"+ a[i].email + "</td><td>" +
            "<div class=\"tpl-table-black-operation\">"+
            "<a href=\"javascript:;\">"+
            "<i class=\"am-icon-pencil\"></i> 编辑</a>"+
            "<a href=\"javascript:;\" class=\"tpl-table-black-operation-del\">"+
            "<i class=\"am-icon-trash\"></i> 删除 </a> </div>";
        $("#userList").append(s);
    }
});
