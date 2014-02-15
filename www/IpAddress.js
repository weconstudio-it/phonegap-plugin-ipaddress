cordova.define("cordova/plugin/IpAddress", 
  function(require, exports, module) {
    var exec = require("cordova/exec");
    var IPAddress = function () {};
 
    var IPAddressError = function(code, message) {
        this.code = code || null;
        this.message = message || '';
    };
 
    IPAddressError.NO_IP_ADDRESS = 0;
 
    IPAddress.prototype.get = function(success,fail) {
        exec(success,fail,"IpAddress",
            "get",[]);
    };
 
    var ipAddress = new IPAddress();
    module.exports = ipAddress;
});
