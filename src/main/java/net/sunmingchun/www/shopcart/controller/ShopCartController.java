package net.sunmingchun.www.shopcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:购物车
 */
@RequestMapping("shopcart")
@Controller
public class ShopCartController {

    @RequestMapping("index")
    public String index(){
        return null;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(){
        return null;
    }



}
