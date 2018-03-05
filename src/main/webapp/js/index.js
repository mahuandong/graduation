$(function($){
    var region = 1 ;
    var belongs = 1 ;
    var $selected1 = $('#region');
    var $selected2 = $('#belongs');
    $.ajax({
        type: "GET",
        url: "areaByLevel.json?level=1",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            region = tmp;}
    });
    console.log(region);//打印服务端返回的数据(调试用)
    for(var i = 0; i < region.length; i++) {
        s = "<option value="+region[i].id+">"+region[i].name+"</option>"
        $("#region").append(s);
    }

    $.ajax({
        type: "GET",
        url: "selectByTable.json?table=economic",
        dataType:"json",
        async: false, //同步传输，并添加返回值，返回值应为已定义的全局变量 如a
        success : function(data) {
            var tmp = data;
            belongs = tmp;}
    });
    console.log(belongs);//打印服务端返回的数据(调试用)
    for(var i = 0; i < belongs.length; i++) {
        a = "<option value="+belongs[i].field+">"+belongs[i].index+"</option>";
        $("#belongs").append(a);
    }

    $selected1.on('change', function() {
        region = $('#region').find('option').eq(this.selectedIndex).val();
        console.log(region);
    });
    $selected2.on('change',function () {
        belongs = $('#belongs').find('option').eq(this.selectedIndex).val();
        console.log(belongs);
    })

    // 指定图表的配置项和数据
    // var myChart = echarts.init(document.getElementById('tpl-echarts'),'dark');
    // 显示标题，图例和空的坐标轴
    // myChart.setOption({
    //     title: {
    //         text: '异步数据加载示例'
    //     },
    //     tooltip: {},
    //     legend: {
    //         data:[]
    //     },
    //     xAxis: {
    //         data: []
    //     },
    //     yAxis: {},
    //     series: [{
    //         name: '销量',
    //         type: 'bar',
    //         data: []
    //     }]
    // });
    // var areaCode = document.getElementById("#region").value();
    // console.log(areaCode);
    // 异步加载数据
    // $.get('data.json',{}).done(function (data) {
    //     // 填入数据
    //     myChart.setOption({
    //         xAxis: {
    //             data: data.categories
    //         },
    //         series: [{
    //             // 根据名字对应到相应的系列
    //             name: '销量',
    //             data: data.data
    //         }]
    //     });
    // });
});
