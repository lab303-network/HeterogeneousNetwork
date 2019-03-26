/*
 * Created by Dyan at 2019/3/19 17:28
 */

var svg_container = $(".panel");        //取svg容器地址
var w = svg_container.width() - 40;     //svg宽
var h = svg_container.height() - 40;    //svg高
var x_par = 100;    //坐标初始位置_x
var y_par = 100;    //坐标初始位置_y

var dataset = [
    [5, 20, "设备1", 0], [480, 90, "设备2", 0],
    [85, 21, "终端", 0]
];      //连接状态矩阵[x, y, name, state]

var topo_data = [
    [[5, 20], [275, 44], 1]
];     //拓扑信息矩阵[x1, y1, x2, y2, topo_state]

var globalID = null;    //记录刷新渲染的进程ID
// let KeyFlag = 0;        //记录上一次生效按键

$(document).ready(function () {
    $("#action_start").on("click", function () {
        if(!globalID){
            globalID = requestAnimationFrame(animloop);
        }
    });
    $("#action_end").on("click", function () {
        if(globalID){
            cancelAnimationFrame(globalID);
            globalID = null;
        }
    });
});

//创建SVG
var svg = d3.select("#draw")
    .append("svg")
    .attr("width", w)
    .attr("height", h)
    .attr("fill", "yellow");

function draw_svg(dataset){
    let data_size = dataset.length;
    //绘制方块，并设置响应
    svg.selectAll("rect").remove();
    svg.selectAll("rect")
        .data(dataset)
        .enter()
        .append("rect")
        .attr("x", function(d) {
            return d[0] - 5;
        })
        .attr("y", function(d) {
            return d[1] - 5;
        })
        .attr("fill", "steelblue")
        .attr("width", 10)
        .attr("height", 10)
        .on("mouseover", function (d) {
            console.log(d[0]);
        })
        .on("mouseout", function (d) {
            console.log(d[1]);
        });
    //标注文本
    svg.selectAll("text").remove();
    svg.selectAll("text")
        .data(dataset)
        .enter()
        .append("text")
        .text(function(d) {
            return d[2];
        })
        .attr("x", function(d) {
            return d[0];
        })
        .attr("y", function(d) {
            return d[1];
        })
        .attr("font-family", "sans-serif")
        .attr("font-size", "14px")
        .attr("fill", "blue");
    //连线-基站与终端
    svg.selectAll("line").remove();
    svg.selectAll("line")
        .data(dataset)
        .enter()
        .append("line")
        .attr("x1", function(d) {
            return d[0];
        })
        .attr("y1", function(d) {
            return d[1];
        })
        .attr("x2", function(d) {
            if(d[3] === 0){
                return d[0];
            }
            return x_par;
        })
        .attr("y2", function(d) {
            if(d[3] === 0){
                return d[1];
            }
            return y_par;
        })
        .attr("stroke", "gray")
        .attr("stroke-dasharray", "8,4")
        .attr("stroke-width", 1);
    //连线-拓扑结构
    svg.selectAll("line").exit().remove()
        .data(topo_data)
        .enter()
        .append("line")
        .attr("x1", function(d) {
            return d[0][0];
        })
        .attr("y1", function(d) {
            return d[0][1];
        })
        .attr("x2", function(d) {
            if(d[2] === 0){
                return d[0][0];
            }
            return d[1][0];
        })
        .attr("y2", function(d) {
            if(d[2] === 0){
                return d[0][1];
            }
            return d[1][1];
        })
        .attr("stroke", "black")
        .attr("stroke-width", 2);
}       //SVG绘图

function animloop(){
    svg_render();
    globalID = requestAnimationFrame(animloop);
}       //刷新渲染

function svg_render() {
    x_par = rand(x_par, 0);
    y_par = rand(y_par, 1);
    dataset.pop();
    dataset.push([x_par, y_par, "终端", 0]);
    draw_svg(dataset);
}       //渲染方法

function rand(origin, flag){
    let plus = 5 * (Math.round(Math.random() * 2) - 1);
    let limit = w;
    if(flag){
        limit = h;
    }
    if(origin > 1 && origin < limit - 1){
        origin = origin + plus;
    }
    else{
        origin = 200;
    }
    // console.log(origin);
    return origin;
}       //get随机数


