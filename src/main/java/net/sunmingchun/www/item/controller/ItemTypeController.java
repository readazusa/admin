package net.sunmingchun.www.item.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.item.po.ItemTypeInfo;
import net.sunmingchun.www.item.service.IItemTypeService;
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
 * Created by 念梓  on 2016/8/5.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:商品类型管理
 */
@RequestMapping("itemtype")
@Controller
public class ItemTypeController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ItemTypeController.class);

    @Resource
    private IItemTypeService itemTypeService;

    @RequestMapping("index")
    public String index(){
        return "itemtype/index";
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
        BasePagePO basePagePO = itemTypeService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }

    @RequestMapping("type/list")
    @ResponseBody
    public Object getList(){
        Result result = new Result();
        try{
            List<ItemTypeInfo> itemTypeInfos = itemTypeService.queryList();
            result.setData(itemTypeInfos);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            result.setMsg("获取类型失败:"+ ex.getMessage());
            result.setCode(Result.ERROR);
        }
        return result;
    }


    @RequestMapping("new")
    public String newPage(){
        return "itemtype/new";
    }

    @RequestMapping("save")
    @ResponseBody
    public Object save(ItemTypeInfo itemTypeInfo){
        Result result = new Result();
        try{
            itemTypeService.save(itemTypeInfo);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("新增商品类型错误,错误信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("新增商品失败: "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("edit")
    public String edit(String id, ModelMap model){
        ItemTypeInfo itemTypeInfo = this.itemTypeService.queryObjectById(id);
        model.put("itemtype",itemTypeInfo);
        return "itemtype/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(ItemTypeInfo itemTypeInfo){
        Result result = new Result();
        try{
            itemTypeService.update(itemTypeInfo);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("更新商品类型错误,错误信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("更新商品失败: "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("view")
    public String view(String id,ModelMap model){
        ItemTypeInfo itemTypeInfo = this.itemTypeService.queryObjectById(id);
        model.put("itemtype",itemTypeInfo);
        return "itemtype/view";
    }


    @RequestMapping("del")
    @ResponseBody
    public Object remove(String id){
        Result result = new Result();
        try{
            itemTypeService.deleteById(id);
            result.setCode(Result.SUCCESS);
            result.setMsg("删除商品类型成功");
        }catch (Exception ex){
            result.setMsg("删除商品类型失败,失败信息: "+ex.getMessage());
            result.setCode(Result.ERROR);
        }
        return result;
    }
}
