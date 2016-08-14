package net.sunmingchun.www.test.contrller;

import net.sunmingchun.www.common.Result;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 念梓  on 2016/8/14.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Controller
@RequestMapping("jsonp")
public class JsonpController {

    @RequestMapping("index")
    @ResponseBody
    public  JSONPObject index(String callback){

        Result result  = new Result();
        result.setCode(Result.ERROR);
        result.setData("213");
        result.setMsg("springmvc jsonp的编写");
        return   new JSONPObject(callback,result);
    }
}
