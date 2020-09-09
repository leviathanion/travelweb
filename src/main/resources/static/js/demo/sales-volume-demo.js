$(function () {
    
    var barChart = echarts.init(document.getElementById("echarts-bar-chart1"));
    var baroption = {
        title : {
            text: '销售量前十名'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['产品1','产品2','产品3','产品4','5','6','7','8','9','10']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售量',
                type:'bar',
                data:[210, 170, 150, 130, 120, 110,100,80,70,60],
                markLine : {
                    data : [
                        {type : 'average', name: '平均销售量'}
                    ]
                }
            }
        ]
    };
    barChart.setOption(baroption); 

    var barChart = echarts.init(document.getElementById("echarts-bar-chart2"));
    var baroption = {
        title : {
            text: '销售量前十名'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['产品1','产品2','产品3','产品4','5','6','7','8','9','10']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售量',
                type:'bar',
                data:[210, 170, 150, 130, 120, 110,100,80,70,60],
                markLine : {
                    data : [
                        {type : 'average', name: '平均销售量'}
                    ]
                }
            }
        ]
    };
    barChart.setOption(baroption); 
    
    var barChart = echarts.init(document.getElementById("echarts-bar-chart3"));
    var baroption = {
        title : {
            text: '销售量前十名'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['产品1','产品2','产品3','产品4','5','6','7','8','9','10']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售量',
                type:'bar',
                data:[210, 170, 150, 130, 120, 110,100,80,70,60],
                markLine : {
                    data : [
                        {type : 'average', name: '平均销售量'}
                    ]
                }
            }
        ]
    };
    barChart.setOption(baroption); 

    var barChart = echarts.init(document.getElementById("echarts-bar-chart4"));
    var baroption = {
        title : {
            text: '销售量前十名'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['产品1','产品2','产品3','产品4','5','6','7','8','9','10']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'销售量',
                type:'bar',
                data:[210, 170, 150, 130, 120, 110,100,80,70,60],
                markLine : {
                    data : [
                        {type : 'average', name: '平均销售量'}
                    ]
                }
            }
        ]
    };
    barChart.setOption(baroption); 
    

    
    
 
    

    
    
    
});
