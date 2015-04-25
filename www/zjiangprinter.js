/*global cordova, module*/

module.exports = {
    list: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "zjiangprinter", "list", [name]);
    }
};
