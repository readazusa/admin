MyObj={};
/**
 * 高德地图参数实体
 * @type {Object}
 */
MyObj.Map=new Object();
MyObj.Map.marker={
    offset : new AMap.Pixel(-8,-38)
}
MyObj.Map.placeSearchOptions = { //构造地点查询类
    pageSize: 1,
    pageIndex: 1
};

MyObj.page=function(url){

}



MyObj.submit= function(url,callback,data,method,dataType){
    var type = "get";
    if(method){
        type=method;
    }
    $.ajax({
        url:url,
        type:type,
        data:data,
        success:function(resp){
            callback(resp);
        },
        error:function(resp){
            console.info("提交ajax请求失败")
        }
    })
}



