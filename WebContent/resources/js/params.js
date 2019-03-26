/*
 * Created by Dyan at 2019/3/22 19:20
 */

var getParamsInTable = {
    structure: ["LoRa", "ZigBee", "RFID", "UWB"],
    timeDisplay: function(){

    },
    setTables: function(structure){
        let table_selected = $("#state_tables");
        table_selected.empty();
        for(let structure_i = 0;structure_i < structure.length;structure_i ++){
            table_selected.append(
                "<table class='table table-striped' id='" +
                structure[structure_i] + "_table'><caption>" +
                structure[structure_i] + "实时状态信息</caption><thead></thead><tbody></tbody></table>"
            );
        }
    },      //设置状态表格
    getParams: function (obj) {
        //alert(obj.lora[0].id);
        getParamsInTable.setTables(getParamsInTable.structure);
        dataset.length = 0;
        topo_data.length = 0;
        //LoRa表头
        $("#LoRa_table thead").empty().append(
            "<tr><th>" +
            "ID" + "</th><th>" +
            "RSSI" + "</th><th>" +
            "SNR" + "</th><th>" +
            "MSG" + "</th><th>" +
            "TIME" + "</th></tr>"
        );
        //右侧显示ZigBee实时参数
        $("#LoRa_table tbody").empty().append(
            "<tr><td>" +
            obj.lora[0].id + "</td><td>" +
            obj.lora[0].terminals[0].datas[0].rssi + "</td><td>" +
            obj.lora[0].terminals[0].datas[0].snr + "</td><td>" +
            obj.lora[0].terminals[0].datas[0].msg + "</td><td>" +
            obj.lora[0].terminals[0].datas[0].time + "</td></tr>"
        );
        dataset.push([obj.lora[0].x, obj.lora[0].y, "LoRa", 1]);
        //ZigBee表头
        $("#ZigBee_table thead").empty().append(
            "<tr><th>" +
            "ID" + "</th><th>" +
            "RSSI" + "</th><th>" +
            "DATA" + "</th><th>" +
            "TIME" + "</th></tr>"
        );
        let ZigBee_table_tbody = $("#ZigBee_table tbody");
        //提取ZigBee拓扑信息
        dataset.push([400, 300, "ZigBee-" + "0000", 0]);
        for(let topo_ZigBee = 0;topo_ZigBee < obj.zigbeeTopo.length;topo_ZigBee ++){
            topo_data.push([obj.zigbeeTopo[topo_ZigBee][0], obj.zigbeeTopo[topo_ZigBee][1], obj.zigbeeTopo[topo_ZigBee][0] === obj.zigbeeTopo[topo_ZigBee][1] ? 0 : 1]);
        }
        //对topo_data进行ID-DATA的转换
        for(let i = 0;i < topo_data.length;i++){
            for(let j = 0;j < topo_data[0].length;j++){
                if(topo_data[i][j] === "0000"){
                    topo_data[i][j] = [400, 300];
                }
            }
        }
        //右侧显示ZigBee实时参数
        ZigBee_table_tbody.empty();
        for(let ZigBee_i = 1;ZigBee_i < obj.zigbee.length;ZigBee_i ++){
            ZigBee_table_tbody.append(
                "<tr><td>" +
                obj.zigbee[ZigBee_i][0].sensor_id + "</td><td>" +
                obj.zigbee[ZigBee_i][0].rssi + "</td><td>" +
                obj.zigbee[ZigBee_i][0].data + "</td><td>" +
                obj.zigbee[ZigBee_i][0].time + "</td></tr>"
            );
            dataset.push([obj.zigbee[ZigBee_i][0].sensor.x, obj.zigbee[ZigBee_i][0].sensor.y, "ZigBee-" + obj.zigbee[ZigBee_i][0].sensor_id, ZigBee_i - 1]);
            //对topo_data进行ID-DATA的转换
            for(let i = 0;i < topo_data.length;i++){
                for(let j = 0;j < topo_data[0].length;j++){
                    if(topo_data[i][j] === obj.zigbee[ZigBee_i][0].sensor_id){
                        topo_data[i][j] = [obj.zigbee[ZigBee_i][0].sensor.x, obj.zigbee[ZigBee_i][0].sensor.y];
                    }
                }
            }
        }
        //补录终端位置
        dataset.push([x_par, y_par, "终端", 0]);
    },      //第一次处理数据
};

