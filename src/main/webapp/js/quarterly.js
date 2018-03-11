var region = 1;
var regionVal = 1;
var echarsArea = 1 ; //存放json数据
var nums = new Array();    //数据数组（实际用来盛放Y坐标值）
var belongsVal = 1 ;
var $selected1 = $('#region');
var $selected2 = $('#date');
$(function($){

    selectData();

    selectChange();

});
//想select中添加option
function selectData() {
    var webPath = getCookie("webPath");

    $.ajax({
        type: "GET",
        url:  webPath+"/areaByLevel.json?level=1",
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
        url:webPath+"/monthlySelectByArea.json",
        data : "areaCode="+regionVal,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            region = tmp;}
    });
    for(var i = 2017; i > 2000; i--) {
        s = "<option value="+i+">"+i+"年"+"</option>"
        $("#date").append(s);
    }
}
function selectChange() {

    $selected1.on('change', function() {
        regionVal = $('#region').find('option').eq(this.selectedIndex).val();
        InsertElement();
    });

    $selected2.on('change',function () {
        belongsVal = $('#date').find('option').eq(this.selectedIndex).val();
        InsertElement();
    });

}
//当select改变时，ajax发送请求。得到的数据放入数组
function InsertElement() {
    var webPath = getCookie("webPath");
    $.ajax({
        type: "GET",
        url: webPath+"/monthlySelectByArea.json",
        data:"areaCode="+regionVal +"&year="+belongsVal,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量
        success : function(data) {
            var tmp = data;
            echarsArea = tmp;
        }
    });
    console.log(echarsArea[0]==null);

    nums.splice(0,nums.length);
    //根据选择的指标选择放入数组的字段
    for(var i = 0 ; i<echarsArea.length;i++ ){
        nums.push(echarsArea[i].one);
        nums.push(echarsArea[i].feb);
        nums.push(echarsArea[i].three);
        nums.push(echarsArea[i].four);
    }
    echart();

}

function echart() {

    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts-A'),'dark');
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
        legend: {
            data:['地区生产总值_累计值(亿元)']
        },
        xAxis: {
            type: 'category',
            data: ['第一季度', '第二季度', '第三季度', '第四季度']
        },
        yAxis: {},
        series: [{
            name:'地区生产总值_累计值(亿元)',
            type: 'bar',
            label:{
                normal: {
                    show: true,
                    position: 'top',
                    color:'#ffffff',
                    fontSize: 16
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
    if(username!=null){
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