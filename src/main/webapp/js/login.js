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

            if (result.name != "") {
                setCookie("id",result.id);
                setCookie("name",result.name);
                setCookie("account",result.account);
                setCookie("password",result.password);
                window.location.href="/graduation/jsp/user.jsp";
            };
        },
        error:function() {
            // alert("用户名或密码错误");
            document.getElementById("errorMsg2").innerText = "用户名或密码错误";
        }
        });
}
function setCookie(name,value)
{
    document.cookie = name + "=" + value + "; " ;
}