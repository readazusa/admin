package net.sunmingchun.www.shop.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.shop.po.ShopInfo;
import net.sunmingchun.www.shop.service.IShopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2016/8/11.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des: 店铺管理
 */
@RequestMapping("shop")
@Controller
public class ShopController extends BaseController{

    @Resource
    private IShopService shopService;

    @RequestMapping("index")
    public String index(){
        return "shop/index";
    }


    @RequestMapping("list")
    @ResponseBody
    public Object list(HttpServletRequest request){
        String searchValue = request.getParameter("search[value]");
        String orderColumnStr =  request.getParameter("order[0][column]");  //排序的列
        String orderName = this.getOrderName(request,orderColumnStr);
        String orderValue = request.getParameter("order[0][dir]");
        int pageSize = Integer.parseInt(request.getParameter("length"));
        int pageIndex = Integer.parseInt(request.getParameter("start"));
        int draw = Integer.parseInt(request.getParameter("draw"));
        BasePagePO<ShopInfo> basePagePO = shopService.getBasePagePO(pageIndex,pageSize,searchValue,orderColumnStr,orderValue,draw);
        return basePagePO;
    }


    @RequestMapping("new")
    public String newPage(){
        return "shop/new";
    }

}
