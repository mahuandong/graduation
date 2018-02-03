function CheckUserDataValid() {
    var username = $("#textUserName").val();
    var password = $("#textPassWord").val();
    if (username == "") {
        document.getElementById("errorMsg2").innerText = "用户名不能为空！";
        document.getElementById("textUserName").focus();
        return;
    }   else{
        document.getElementById("errorMsg2").innerText = "";
    }
    if (password == "") {
        document.getElementById("errorMsg2").innerText = "密码不能为空！";
        document.getElementById("textPassWord").focus();
        return;
    }   else{
        document.getElementById("errorMsg2").innerText = "";
    }
    $.ajax({
        type: "POST",
        url: "../login.json",
        dataType:"json",
        data: $('#iform').serialize(),
        success: function(result){
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.name != "") {
                window.location.href="/graduation/jsp/index.jsp";
            };
        },
        error:function() {
            // alert("用户名或密码错误");
            document.getElementById("errorMsg2").innerText = "用户名或密码错误";
        }
        });
}

function Registered() {
    window.location.href="/graduation/jsp/economic.jsp";
}