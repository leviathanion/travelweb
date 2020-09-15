$(function () {
    
    var barChart = echarts.init(document.getElementById("echarts-bar-chart1"));
  
      // 新建productName与nums数组来接受数据，因为我们
      var Name = [];
      var nums = [];
      var datatemp = [];
      //AJAX接收数据主体
      $.ajax({
          type:"get",
          url:"/getProSum",
          dataType:"json",
          async:false,
          success:function (sales) {
              for (var i = 0; i < sales.length; i++){
                  Name.push(sales[i].product_name);
                  nums.push(sales[i].product_sum);
                  var ob = {name:"",value:""};
                  ob.name = sales[i].product_name;
                  ob.value = sales[i].product_sum;
                 datatemp.push(ob);
             }
 
         },
         error :function(errorMsg) {
             alert("获取后台数据失败！");
         }
     });
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
                data : Name
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
                data:nums,
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
    var Name = [];
      var nums = [];
      var datatemp = [];
      //AJAX接收数据主体
      $.ajax({
          type:"get",
          url:"/getProSum",
          dataType:"json",
          async:false,
          success:function (result) {
              for (var i = 0; i < result.length; i++){
                  Name.push(result[i].product_name);
                  nums.push(result[i].product_sum);
                  var ob = {name:"",value:""};
                  ob.name = result[i].product_name;
                  ob.value = result[i].product_sum;
                 datatemp.push(ob);
             }
 
         },
         error :function(errorMsg) {
             alert("获取后台数据失败！");
         }
     });
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
                data : Name
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
                data:nums,
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
    var Name = [];
      var nums = [];
      var datatemp = [];
      //AJAX接收数据主体
      $.ajax({
          type:"get",
          url:"/getProSum",
          dataType:"json",
          async:false,
          success:function (result) {
              for (var i = 0; i < result.length; i++){
                  Name.push(result[i].product_name);
                  nums.push(result[i].product_sum);
                  var ob = {name:"",value:""};
                  ob.name = result[i].product_name;
                  ob.value = result[i].product_sum;
                 datatemp.push(ob);
             }
 
         },
         error :function(errorMsg) {
             alert("获取后台数据失败！");
         }
     });
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
                data : Name
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
                data:nums,
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
    var Name = [];
      var nums = [];
      var datatemp = [];
      //AJAX接收数据主体
      $.ajax({
          type:"get",
          url:"/getProSum",
          dataType:"json",
          async:false,
          success:function (result) {
              for (var i = 0; i < result.length; i++){
                  Name.push(result[i].product_name);
                  nums.push(result[i].product_sum);
                  var ob = {name:"",value:""};
                  ob.name = result[i].product_name;
                  ob.value = result[i].product_sum;
                 datatemp.push(ob);
             }
 
         },
         error :function(errorMsg) {
             alert("获取后台数据失败！");
         }
     });
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
                data : Name
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
                data:nums,
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
