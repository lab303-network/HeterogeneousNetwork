/*
 * Created by Dyan at 2019/3/20 21:13
 */

var json_test = {"lora":[{"id":1,"terminals":[{"datas":[{"id":242,"msg":"Hello","rssi":-22,"snr":7,"terminalId":1,"time":"2019-03-21 21:36:29"}],"id":1,"stationId":1}],"x":11,"y":5}],"zigbeeTopo":[["0000","0000"],["BB11","0000"]],"zigbee":[[],[{"data":"6211","id":0,"rssi":"-56","sensor":{"father_addr":"","id":0,"isLeave":0,"sensor_addr":"","sensor_id":"BB01","x":200,"y":30},"sensor_id":"BB01","time":"2019-03-25 11:35:09"}],[{"data":"120","id":0,"rssi":"-28","sensor":{"father_addr":"","id":0,"isLeave":0,"sensor_addr":"","sensor_id":"BB0B","x":30,"y":100},"sensor_id":"BB0B","time":"2019-03-25 11:35:51"}],[{"data":"323","id":0,"rssi":"-80","sensor":{"father_addr":"","id":0,"isLeave":0,"sensor_addr":"","sensor_id":"BB11","x":40,"y":70},"sensor_id":"BB11","time":"2019-03-25 14:06:46"}],[{"data":"40800","id":0,"rssi":"-55","sensor":{"father_addr":"","id":0,"isLeave":0,"sensor_addr":"","sensor_id":"BB12","x":0,"y":0},"sensor_id":"BB12","time":"2019-03-25 11:34:29"}]]};
var data_io = {
    getData: function(){
        NetWork.getTestData(getParamsInTable.getParams);
        // getParamsInTable.getParams(json_test);
        // setInterval(getParamsInTable.getParams(json_test), 3000);
        svg_render();
    },      //获取数据
};
