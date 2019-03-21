/*
 * Created by Dyan on 2019/3/19 15:32
 */

/*父接口*/
var Interface = {
    /*
     * @param url
     * @param callback
     */
    gainJSON: function (url, callback) {
        $.getJSON(url, function (obj) {
            callback(obj);
        });
    },
    /*
     * @param url
     * @param jsonData
     * @param b_callback
     * @param s_callback
     * @param c_callback
     */
    sentJSON: function (url, jsonData, b_callback, s_callback, c_callback) {
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: url,
            data: jsonData,
            beforeSend: b_callback,
            success: s_callback,
            complete: c_callback
        });
    }
};

/*网络传输状态信息*/
var NetWork = {
    getTestData: function (callback) {
        Interface.gainJSON('getalldata.action?name=link', callback);
    },      //
    rName: function (Name, callback) {
        Interface.gainJSON('/Name?Name=' + Name, callback);
    },      //
    rResult: function (data) {
        Interface.sentJSON('/returnResult', data, App.beforex, App.xResult, util.voidFunction);
    },      //
};
