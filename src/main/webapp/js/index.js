    var region = 1;
    var regionVal = 1;
    var belongs = 1 ;
    var echarsArea = 1 ; //存放json数据
    var years = new Array();    //年份数组（实际用来盛放X轴坐标值）
    var nums = new Array();    //数据数组（实际用来盛放Y坐标值）
    var belongsVal = 1 ;
    var $selected1 = $('#region');
    var $selected2 = $('#belongs');
$(function($){

    selectData();

    selectChange();

});
function selectData() {
    var webPath = getCookie("webPath");
    $.ajax({
        type: "GET",
        url: webPath+"/areaByLevel.json?level=1",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            region = tmp;}
    });
    for(var i = 0; i < region.length; i++) {
        s = "<option value="+region[i].id+">"+region[i].name+"</option>"
        $("#region").append(s);
    }

    $.ajax({
        type: "GET",
        url: webPath+"/selectByTable.json?table=economic",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            belongs = tmp;}
    });
    for(var i = 0; i < belongs.length; i++) {
        a = "<option value="+belongs[i].field+">"+belongs[i].index+"</option>";
        $("#belongs").append(a);
    }
}
function selectChange() {

    $selected1.on('change', function() {
        regionVal = $('#region').find('option').eq(this.selectedIndex).val();
        InsertElement();
    });
    $selected2.on('change',function () {
        belongsVal = $('#belongs').find('option').eq(this.selectedIndex).val();
        InsertElement();
    });
}
//当任意一个select改变时，ajax发送请求。得到的数据分别放入数组
function InsertElement() {
    var webPath = getCookie("webPath");
    console.log(webPath);
    $.ajax({
        type: "GET",
        url: webPath+"/econSelectByArea.json",
        data:{areaCode:regionVal},
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量
        success : function(data) {
            var tmp = data;
            echarsArea = tmp;
        }
    });
    years.splice(0,years.length);//清空数组
    nums.splice(0,nums.length);

    for (var j = 0; j < echarsArea.length; j++) {
        years.push(echarsArea[j].year);
    }
    //根据选择的指标选择放入数组的字段
    if(belongsVal == "gdp"){
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].gdp);

        }
    }if(belongsVal == "primary"){
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].primary);
        }
    }if(belongsVal == "second"){
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].second);
        }
    }if(belongsVal == "third"){
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].third);
        }
    }if(belongsVal == "tax_revenue"){
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].taxRevenue);
        }
    }if(belongsVal == "disposable_income") {
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].disposableIncome);
        }
    }if(belongsVal == "gdp_rate") {
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].gdpRate);
        }
    }if(belongsVal == "primary_rate") {
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].primaryRate);
        }
    }if(belongsVal == "second_rate") {
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].secondRate);
        }
    }if(belongsVal == "third_rate") {
        for (var i = 0; i < echarsArea.length; i++) {
            nums.push(echarsArea[i].thirdRate);
        }
    }
    echart();
}

function echart() {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('tpl-echarts-A'),'dark');
    // 指定图表的配置项和数据
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                magicType: {show: true, type: ['line']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        xAxis: {
            data: years
        },
        yAxis: {
            type: 'value',
            axisLabel: {
                formatter: '{value}'
            }
        },
        series: [
            {
            type: 'bar',
            label:{
                normal: {
                    show: true,
                    position: 'top'
                }
            },
            data: nums
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function login() {
    var username = getCookie("name");
    if(username !== null & username !== undefined & username !== ""){
        window.location.href = "/graduation/jsp/user.jsp";
    }else{
        window.location.href = "/graduation/jsp/login.jsp";
    }
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