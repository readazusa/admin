package net.sunmingchun.www.shop.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.shop.po.ShopInfo;
import net.sunmingchun.www.shop.service.IShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    private static final Logger log = LoggerFactory.getLogger(ShopController.class);

    @Resource
    private IShopService shopService;

    @RequestMapping("index")
    public String index(ModelMap model){
        BasePagePO<ShopInfo> basePagePO = shopService.getBasePagePO(1,10,null);
        model.put("page",basePagePO);
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

    @RequestMapping("save")
    @ResponseBody
    public Object save(ShopInfo shopInfo){
        Result result = new Result();
        try{
            shopService.save(shopInfo);
            result.setCode(Result.SUCCESS);
            result.setMsg("保存店铺成功");
        }catch (Exception ex){
            log.error("保存店铺失败,失败信息如下:");
            result.setCode(Result.ERROR);
            result.setMsg("保存店铺失败,失败信息: "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("edit")
    public String edit(String id,ModelMap model){
        ShopInfo shopInfo = shopService.queryObjectById(id);
        model.put("shop",shopInfo);
        return "shop/edit";
    }


    @RequestMapping("update")
    @ResponseBody
    public Object update(ShopInfo shopInfo){
        Result result = new Result();
        try{
            shopService.update(shopInfo);
            result.setMsg("更新店铺信息成功");
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("更新店铺信息失败: ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("更新店铺信息失败,失败信息： "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("view")
    public String view(String id,ModelMap model){
        ShopInfo shopInfo = shopService.queryObjectById(id);
        model.put("shop",shopInfo);
        return "shop/view";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(String id){
        Result result = new Result();
        try{
            shopService.deleteById(id);
            result.setMsg("上传店铺成功");
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("删除店铺失败: ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("上传店铺失败: "+ ex.getMessage());
        }

        return result;
    }

    @RequestMapping("page")
    @ResponseBody
    public Object page(){
        return null;
    }

}
