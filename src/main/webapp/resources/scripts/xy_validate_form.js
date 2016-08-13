(function($) {
    "use strict";
	$.xyValidateForm = function(form) {
		var validateBool = true;
		var validateBoolArray = new Array();
		var elements = form.elements
		for(var i = 0; i < elements.length; i++) {
			var obj = $(elements[i]);
			var middleValidateBool = doShowMsg(obj);
			validateBoolArray.push(middleValidateBool) ;
		}
		validateBoolArray.forEach(function(e){
			console.info("validate: "+ e);
			if(!e){
				validateBool = false;
			}
		});
		return validateBool; 
	}

	/**
	 * 给每个后面增加内容
	 * @param {Object} obj
	 */
	function doShowMsg(obj) {
		var validateFormBool = true;
		var validate = obj.attr("valid");
		var validateMsg = obj.attr("msg");
		var pattenRegex = obj.attr("regex");
		var value = obj.val();
		var regexVal = null;
		if(validate) {
			var validates = validate.split("|");
			var validateMsgs = validateMsg.split("|");
			for(var i = 0; i < validates.length; i++) {
				if("required" == validates[i]) {
					if(!value) {
						if(!obj.next().hasClass("del_xy")) {
							$("<span class='del_xy'>" + validateMsgs[i] + "</span>").insertAfter(obj);
						}
						addSJ(obj);
						validateFormBool= false;
						break;
					}
				} else {
					regexVal = XYRegex(validates[i]);
					if(!regexVal.test(value)) {
						if(!obj.next().hasClass("del_xy")) {
							$("<span class='del_xy'>" + validateMsgs[i] + "</span>").insertAfter(obj);
						}
						addSJ(obj);
						validateFormBool=false;
						break;
					}
				}
			}
		} else {
			if(pattenRegex) {
				regexVal = new RegExp(pattenRegex, "i");
				if(!regexVal.test(value)) {
					if(!obj.next().hasClass("del_xy")) {
						$("<span class='del_xy'>" + validateMsgs[i] + "</span>").insertAfter(obj);
					}
					addSJ(obj);
					validateFormBool= false;
				}
			}
		}
		return validateFormBool;
	}

	/**
	 * 给需要验证的属性增加事件，数据改变的时候删除错误提示
	 * @param {Object} obj
	 */
	function addSJ(obj) {
		//if(obj.is("select")) {
		//	obj.bind("change", function() {
		//		$(this).next(".del_xy").remove();
		//	})
		//} else if(obj.is(type = 'checkbox')) {
		//	obj.bind("change", function() {
		//		$(this).next(".del_xy").remove();
		//	});
		//} else if(obj.is(type = 'radio')) {
		//	obj.bind("change", function() {
		//		$(this).next(".del_xy").remove();
		//	});
		//} else {
		//	obj.bind("input", function() {
		//		$(this).next(".del_xy").remove();
		//	});
		//}
	}

	var XYRegex = function(type) {
		var regex = null;
		switch(type) {
			case "email":
				regex = /^[a-z0-9]{1,}\w*@[a-z0-9]{2,}\.[a-z0-9]{2,}\.?[a-z0-9]{0,}$/i;
				break;
			case "tel":
				regex = /^0?1[345678][0-9]{9}$/i
				break;
			case "phone":
				regex = /^[0-9]{3,4}-[0-9]{7,8}$/i
				break;
			case "number":
				regex = /^\d+$/i;
				break;
		}
		return regex;
	}

})($)