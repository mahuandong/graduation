$(function($){
    var a=1 ; //用来存放所有用户
    var b=1 ;
    //ajax获取user列表填入表格
    $.ajax({
        type: "GET",
        url: "../userSelectAll.json",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            a = tmp;}
    });
    for(var i = 0; i < a.length; i++) {
        s = "<tr><td>" + a[i].name + "</td><td>" + a[i].account + "</td><td>******</td><td>"
            +a[i].phone + "</td><td>";
        if(a[i].sex == 1){  //当值等于0时输出男，值等于1时输出女
            s = s + "女";
        }if(a[i].sex == 0){
            s = s + "男";
        }
        var uptdate = a[i].updatetime;
        s =s+"</td><td>"+ a[i].email + "</td><td>" +
            timestampToTime(uptdate)+"</td><td>"+
            "<div class=\"tpl-table-black-operation\">"+
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-edit\"   onclick=\"edit("+a[i].id+ ")\">编辑</button>" +
            "<button type=\"button\" class=\"am-btn am-btn-success\" id=\"doc-prompt-delete\" onclick=\"del("+a[i].id+ ")\">删除</button>"+
            "</div></td></tr>";
        $("#userList").append(s);
    }
    //得到cookies里登录的用户
    var name = getCookie("name")
    document.getElementById("welcomeName1").innerText = name;
    document.getElementById("welcomeName2").innerText = name;
});
//编辑按钮函数
function edit(id) {
    $.ajax({
        type: "POST",
        url: "../userById.json",
        data:"id="+id,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            b = tmp;}
    });
    var userId = b.id
    //为对应input填入值
    document.getElementById("name").value = b.name;
    document.getElementById("account").value = b.account;
    document.getElementById("password").value = b.password;
    document.getElementById("phone").value = b.phone;

    if (b.sex == 0){
        $("input[name='sex'][value= '0' ]").attr("checked",true);
    }else {
        $("input[name='sex'][value= '1']").attr("checked",true);
    }
    document.getElementById("email").value = b.email;
    $('#my-prompt').modal({
        relatedTarget: this,
    });
    //监控提交与取消按钮click事件
    $("#submit").on("click", function(b) {
        $.ajax({
            type: "POST",
            url: "../userUpdate.json",
            dataType: "json",
            data: "id="+userId+"&"+$('#user').serialize(),
            async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
            success: function (data) {
                console.log(data);//打印服务端返回的数据(调试用)
                window.location.href = "/graduation/jsp/user.jsp";
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
        url: "../userDelete.json",
        dataType: "json",
        data: "id="+id,
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success: function (data) {
            console.log(data);//打印服务端返回的数据(调试用)
            window.location.href = "/graduation/jsp/user.jsp";
        }
    })
}
//时间戳转化时间函数
function timestampToTime(timestamp) {
    var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
    Y = date.getFullYear() + '-';
    M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
    D = date.getDate() + ' ';
    h = date.getHours() + ':';
    m = date.getMinutes() + ':';
    s = date.getSeconds();
    return Y+M+D+h+m+s;
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