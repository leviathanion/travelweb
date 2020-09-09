$(function () {
    var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
    var lineoption = {
        title : {
            text: '过去销量'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['月访问量','月销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} °C'
                }
            }
        ],
        series : [
            {
                name:'每月访问量',
                type:'line',
                data:[110, 110, 150, 130, 120, 130,120,180,190,90,110,130],
                markPoint : {
                    data : [
                        {type : 'max', name: '最高访问量'},
                        {type : 'min', name: '最低访问量'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均访问量'}
                    ]
                }
            },
	    {
                name:'每月销售量',
                type:'line',
                data:[50, 80, 80, 60, 70, 60, 80,90,30,60,80,70],
                markPoint : {
                    data : [
                        {type : 'max', name: '最高销售量'},
                        {type : 'min', name: '最低销售量'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均销售量'}
                    ]
                }
            }

            
        ]
    };
    lineChart.setOption(lineoption); 

    var barChart = echarts.init(document.getElementById("echarts-bar-chart"));
    var baroption = {
        title : {
            text: '产品月访问量及销售量统计情况'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['访问量','销售量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            {
                name:'访问量',
                type:'bar',
                data:[110, 110, 150, 130, 120, 130,120,180,190,90,110,130],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大访问量'},
                        {type : 'min', name: '最小访问量'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均访问量'}
                    ]
                }
            },
            {
                name:'销售量',
                type:'bar',
                data:[50, 80, 80, 60, 70, 60, 80,90,30,60,80,70],
                markPoint : {
                    data : [
                        {type : 'max',name : '最高销售量'},
                        {type : 'min',name : '最低销售量'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name : '平均销售量'}
                    ]
                }
            }
        ]
    };
    barChart.setOption(baroption); 
    
    
    var pieChart = echarts.init(document.getElementById("echarts-pie-chart1"));
    var pieoption = {
        title : {
            text: '该景点男女游客占比情况',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['男性游客','女性游客']
        },
        calculable : true,
        series : [
            {
                name:'游客性别',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:335, name:'男性游客'},
                    {value:310, name:'女性游客'}
                ]
            }
        ]
    };
    pieChart.setOption(pieoption); 


    var pieChart = echarts.init(document.getElementById("echarts-pie-chart2"));
    var pieoption = {
        title : {
            text: '该景点游客职业占比情况',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['学生','教师','医生','自由职业者','上班族']
        },
        calculable : true,
        series : [
            {
                name:'游客职业',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:335, name:'学生'},
                    {value:310, name:'教师'},
		    {value:210, name:'医生'},
		    {value:410, name:'自由职业者'},
		    {value:355, name:'上班族'},
                ]
            }
        ]
    };
    pieChart.setOption(pieoption); 
    
    
    var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
    var mapoption = {
        title : {
            text: '该产品销量',
            subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            x:'left',
            data:['该产品销量']
        },
        dataRange: {
            min: 0,
            max: 2500,
            x: 'left',
            y: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
        toolbox: {
            show: true,
            orient : 'vertical',
            x: 'right',
            y: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        roamController: {
            show: true,
            x: 'right',
            mapTypeControl: {
                'china': true
            }
        },
        series : [
            {
                name: '该产品销量',
                type: 'map',
                mapType: 'china',
                roam: false,
                itemStyle:{
                    normal:{label:{show:true}},
                    emphasis:{label:{show:true}}
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '重庆',value: Math.round(Math.random()*1000)},
                    {name: '河北',value: Math.round(Math.random()*1000)},
                    {name: '河南',value: Math.round(Math.random()*1000)},
                    {name: '云南',value: Math.round(Math.random()*1000)},
                    {name: '辽宁',value: Math.round(Math.random()*1000)},
                    {name: '黑龙江',value: Math.round(Math.random()*1000)},
                    {name: '湖南',value: Math.round(Math.random()*1000)},
                    {name: '安徽',value: Math.round(Math.random()*1000)},
                    {name: '山东',value: Math.round(Math.random()*1000)},
                    {name: '新疆',value: Math.round(Math.random()*1000)},
                    {name: '江苏',value: Math.round(Math.random()*1000)},
                    {name: '浙江',value: Math.round(Math.random()*1000)},
                    {name: '江西',value: Math.round(Math.random()*1000)},
                    {name: '湖北',value: Math.round(Math.random()*1000)},
                    {name: '广西',value: Math.round(Math.random()*1000)},
                    {name: '甘肃',value: Math.round(Math.random()*1000)},
                    {name: '山西',value: Math.round(Math.random()*1000)},
                    {name: '内蒙古',value: Math.round(Math.random()*1000)},
                    {name: '陕西',value: Math.round(Math.random()*1000)},
                    {name: '吉林',value: Math.round(Math.random()*1000)},
                    {name: '福建',value: Math.round(Math.random()*1000)},
                    {name: '贵州',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '青海',value: Math.round(Math.random()*1000)},
                    {name: '西藏',value: Math.round(Math.random()*1000)},
                    {name: '四川',value: Math.round(Math.random()*1000)},
                    {name: '宁夏',value: Math.round(Math.random()*1000)},
                    {name: '海南',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            }
        ]
    };
    mapChart.setOption(mapoption); 
    
    
 
    

    
    
    
});
