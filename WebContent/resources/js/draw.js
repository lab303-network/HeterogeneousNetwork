/*
 * Created by Dyan at 2019/3/19 17:28
 */

//高宽
var svg_container = $(".panel");        //svg容器
var w = svg_container.width() - 40;     //svg宽
var h = svg_container.height() - 40;    //svg高
var x_par = 100;    //坐标初始位置_x
var y_par = 100;    //坐标初始位置_y

var dataset = [
    [5, 20, 0], [480, 90, 0], [250, 50, 1], [100, 33, 1], [330, 95, 1],
    [410, 12, 1], [275, 44, 1], [25, 67, 1], [85, 21, 1], [220, 88, 1],
    [x_par, y_par, 0]
];

//创建SVG
var svg = d3.select("#draw")
    .append("svg")
    .attr("width", w)
    .attr("height", h);

draw_svg(dataset);

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
        .text(function(d, i) {
            if(i < data_size - 1){
                return "网络节点" + d[0];
            }
            else{
                return "小车";
            }
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
            if(d[2] === 0){
                return d[0];
            }
            return x_par;
        })
        .attr("y2", function(d) {
            if(d[2] === 0){
                return d[1];
            }
            return y_par;
        })
        .attr("stroke", "gray")
        .attr("stroke-dasharray", "8,4")
        .attr("stroke-width", 1);
    //连线-拓扑结构
    svg.selectAll("line").exit().remove()
        .data([[5, 20, 480, 90, 1]])
        .enter()
        .append("line")
        .attr("x1", function(d) {
            return d[0];
        })
        .attr("y1", function(d) {
            return d[1];
        })
        .attr("x2", function(d) {
            if(d[4] === 0){
                return d[0];
            }
            return d[2];
        })
        .attr("y2", function(d) {
            if(d[4] === 0){
                return d[1];
            }
            return d[3];
        })
        .attr("stroke", "black")
        .attr("stroke-width", 3);
}

function render(time) {
    x_par = rand(x_par);
    y_par = rand(y_par);
    dataset.pop();
    dataset.push([x_par, y_par, 0]);
    console.log("line:" + time);
    draw_svg(dataset);
}

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
    console.log(origin);
    return origin;
}

var globalID = null;
var ti = 0;
function animloop(){
    render(ti ++);
    globalID = requestAnimationFrame(animloop);
}       //刷新渲染
let KeyFlag = 0;
document.onkeydown=function(e){	//对整个页面文档监听
    if(e.keyCode === 49 && KeyFlag!== e.keyCode){
        KeyFlag = e.keyCode;
        globalID = requestAnimationFrame(animloop);
    }
    if(e.keyCode === 50 && KeyFlag!== e.keyCode){
        KeyFlag = e.keyCode;
        cancelAnimationFrame(globalID);
    }
};