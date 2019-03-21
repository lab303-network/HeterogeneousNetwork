/*
 * Created by Dyan at 2019/3/20 21:13
 */

$(function () {
    function getData(){
        NetWork.getTestData(testFunc);
    }
    function testFunc(obj) {
        $("#test").append(
            "<a>" + obj.data.lora + "</a>"
        );
    }
    getData();
});


