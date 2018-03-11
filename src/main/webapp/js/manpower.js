var region = 1;
var regionVal = 1;
var echarsArea = 1 ; //存放要生成图表json数据
var population = new Array();    //数据数组（实际用来盛放人口）
var birth = new Array();    //数据数组（实际用来盛放出生率）
var death = new Array();    //数据数组（实际用来盛放死亡率）
var growth = new Array();   //数据数组（实际用来盛放自然增长率）
var year = new Array();    //数据数组（实际用来盛放年份）
var $selected1 = $('#region');
$(function($){

    selectData();

    selectChange();

});
//想select中添加option
function selectData() {
    var webPath = getCookie("webPath");
    //获得地区数据
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
        var s = "<option value="+region[i].id+">"+region[i].name+"</option>"
        $("#region").append(s);
    }
}
function selectChange() {

    $selected1.on('change', function() {
        regionVal = $('#region').find('option').eq(this.selectedIndex).val();
        InsertElement();
    });

}
//当select改变时，ajax发送请求。得到的数据放入数组
function InsertElement() {
    var webPath = getCookie("webPath");
    $.ajax({
        type: "GET",
        url: webPath+"/happenSelect.json",
        data:"areaCode="+regionVal,
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量
        success : function(data) {
            var tmp = data;
            echarsArea = tmp;
        }
    });
    year.splice(0,year.length);
    population.splice(0,population.length);
    birth.splice(0,birth.length);
    death.splice(0,death.length);
    growth.splice(0,growth.length);
    //根据选择的指标选择放入数组的字段
    for(var i = 0 ; i<echarsArea.length;i++ ){
        year.push(echarsArea[i].year);
        population.push(echarsArea[i].population);
        birth.push(echarsArea[i].birth);
        death.push(echarsArea[i].death);
        growth.push(echarsArea[i].growth);
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
                magicType: {show: true, type: ['bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['年末常住人口','出生率','死亡率','自然增长率']
        },
        xAxis: {
            type: 'category',
            data: year,
            axisPointer: {
                type:'shadow'
            }
        },
        yAxis: [
            {
                type: 'value',
                name: '年末常住人口（万人）',
                min: 200,
                axisLabel: {
                    formatter: '{value}'
                }
            },
            {
                type: 'value',
                min: 0,
                max: 15,
                axisLabel: {
                    formatter: '{value} ‰'
                }
            }
        ],
        series: [
            {
                name:'年末常住人口',
                type: 'bar',
                data: population
            },
            {
                name:'出生率',
                type: 'line',
                yAxisIndex: 1,
                data: birth
            },
            {
                name:'死亡率',
                type: 'line',
                yAxisIndex: 1,
                data: death
            },
            {
                name:'自然增长率',
                type: 'line',
                yAxisIndex: 1,
                data: growth
            }
        ]
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