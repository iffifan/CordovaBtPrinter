//var exec = require('cordova/exec');

var printer = {
    list: function(fnSuccess, fnError){
        exec(fnSuccess, fnError, "chbtprinter", "list", []);
    },
    open: function(fnSuccess, fnError, name){
        exec(fnSuccess, fnError, "chbtprinter", "open", [name]);
    },
    close: function(fnSuccess, fnError){
        exec(fnSuccess, fnError, "chbtprinter", "close", []);
    },
    print: function(fnSuccess, fnError, str){
        exec(fnSuccess, fnError, "chbtprinter", "print", [str]);
    }
};

module.exports = printer;