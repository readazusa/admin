/**
 * 验证表单的输入
 * @author 孙明春
 */

(function ($) {
    $.validateForm = {
        validate: function (formId) {
            var validateResultBool = true;
            $(formId).find("input").each(function (index) {
                var next = $(this).next();
                $(next).remove();
                var validateType = $(this).attr("validate");
                if ("required" == validateType) {
                    var value = $(this).val();
                    validateResultBool = $.validateForm.validateRequired(value);
                    if (!validateResultBool) {
                        $(this).after(message.required());
                    }
                } else if ("number" == validateType) {
                    var numberValidate = $.validateForm.validateNumber($(this).val());
                    if (!numberValidate) {
                        $(this).after(message.number());
                        if (validateResultBool) {
                            validateResultBool = numberValidate;
                        }
                    }
                } else if ("email" == validateType) {
                    var emailValidate = $.validateForm.validateEmail($(this).val());
                    if (!emailValidate) {
                        $(this).after(message.email());
                        if (validateResultBool) {
                            validateResultBool = emailValidate;
                        }
                    }
                } else if ("mobilenum" == validateType) {
                    var mobileValidate = $.validateForm.validateMobileNum($(this).val());
                    if (!mobileValidate) {
                        $(this).after(message.mobile());
                        if (validateResultBool) {
                            validateResultBool = mobileValidate;
                        }
                    }
                } else if ("length" == validateType) {
                    var minLength = $(this).attr("minLength");
                    var maxLength = $(this).attr("maxLength");
                    if (!minLength) {
                        minLength = 0;
                    }
                    if (!maxLength) {
                        maxLength = 100;    //默认最大长度100
                    }
                    var lengthValidate = $.validateForm.validateLength($(this).val(), minLength, maxLength);
                    if (!lengthValidate) {
                        $(this).after(message.length(minLength, maxLength));
                        if (validateResultBool) {
                            validateResultBool = lengthValidate;
                        }
                    }
                } else if ("equalTo" == validateType) {
                    var equalToObj = $(this).attr("equalTo");
                    var equalValidate = $.validateForm.validateEqual($(this).val(), $(equalToObj).val());
                    if (!equalValidate) {
                        $(this).after(message.equal());
                        if (validateResultBool) {
                            validateResultBool = equalValidate;
                        }
                    }
                }
            });
            return validateResultBool;
        },
        validateRequired: function (value) {   //要求验证

            if (!value) {
                return  false;
            } else {
                return true;
            }
        },
        validateNumber: function (value) {   //验证数字
            var pattern = /^(?:-?\d+|-?\d{1,3}(?:,\d{3})+)?(?:\.\d+)?$/;
            return pattern.test(value);
        },
        validateEmail: function (value) {  //验证邮箱
            var pattern = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
            return pattern.test(value);
        },
        validateMobileNum: function (value) {   //验证手机号码
            if (value) {
                if ("+86" == value.substr(0, 3)) {
                    value = value.substr(3);
                }
                var pattern = /^((1[3-8]{1})+\d{9})$/;
                return pattern.test(value);
            } else {
                return false;
            }
        },
        validateLength: function (value, minLenth, maxLength) {   //验证最大长度和最小长度
            if (value) {
                var length = value.length;
                return parseInt(minLenth) <= length && parseInt(maxLength) >= length;
            } else {
                return false;
            }
        },
        validateUrl: function (value) {
            var pattern = /^(?:(?:(?:https?|ftp):)?\/\/)(?:\S+(?::\S*)?@)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})).?)(?::\d{2,5})?(?:[/?#]\S*)?$/i;
            pattern.test(value);

        },
        validateEqual: function (target, source) {
            //alert("sd: "+ JSON.stringify(target));
            // console("验证两个值: target:  "+ typeof  target);
            var target = JSON.stringify(target);
            var source = JSON.stringify(source);
            var bool = false;
            if (target == source) {
                bool = true;
            }
            return bool;
        },
        validateVal: function (value, minVal, maxVal) {  //最大值  最小值 验证
            return  parseInt(minVal) <= parseInt(value) && parseInt(maxVal) >= parseInt(value);
        }

    }
})(jQuery);


var message = {
    required: function () {
        return "<span class='red'>该字段不能为空</span>";
    },
    length: function (minLength, maxLength) {
        return  "<span class='red'>该字段长度必须在 " + minLength + "至" + maxLength + "之间</span>";
    },
    email: function () {
        return "<span class='red'>该字段是无效的email</span>";
    },
    url: function () {
        return "<span class='red'>该字段是无效的url</span>"
    },
    value: function (minValue, maxValue) {
        return "<span class='red'>该字段数值必须在 " + minValue + "到" + maxValue + " 之间</span>";
    },
    mobile: function () {
        return "<span class='red'>该字段是无效的电话号码</span>";
    },
    equal: function () {
        return "<span class='red'>验证两值不相等</span>";
    },
    number: function () {
        return "<span class='red'>该字段是无效的数字</span>";
    }
}
