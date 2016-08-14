package net.sunmingchun.www.item.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.log.LogFactory;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.file.po.UploadFilePO;
import net.sunmingchun.www.item.po.ItemInfo;
import net.sunmingchun.www.item.service.IItemService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * net.sunmingchun.www.item.controller
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
@Controller
@RequestMapping("item")
public class ItemController extends BaseController {

    private  static final Logger log = LogFactory.getLogger(ItemController.class);

    @Resource
    private IItemService itemService;

    @RequestMapping("index")
    public String index(Model model){
        BasePagePO<ItemInfo> basePagePO = itemService.getBasePagePO(1,10,null);
        model.addAttribute("pages",basePagePO);
        return "item/index";
    }

    @RequestMapping("new")
    public String gotoNewPage(){
        return "item/new";
    }

    @RequestMapping("edit")
    public String gotoEditPage(String id,ModelMap model){
        ItemInfo itemInfo = itemService.queryObjectById(id);
        List<UploadFilePO> uploadFilePOList = itemService.getUploadFileListByItemId(itemInfo.getUid());
        model.put("item",itemInfo);
        model.put("files",uploadFilePOList);
        StringBuffer fileIds = new StringBuffer();
        uploadFilePOList.forEach(e->{
            fileIds.append(e.getId()).append("&&");
        });
        model.put("fileIds",fileIds.toString());
        return "item/edit";
    }

    @RequestMapping("view")
    public String gotoViewPage(String id,ModelMap model){
        ItemInfo itemInfo = itemService.queryObjectById(id);
        List<UploadFilePO> uploadFilePOList = itemService.getUploadFileListByItemId(itemInfo.getUid());
        model.put("files",uploadFilePOList);
        model.put("item",itemInfo);
        return "item/view";
    }

    @RequestMapping("save")
    @ResponseBody
    public Result doAdd(ItemInfo itemInfo){
        Result result = new Result();
        try{
            itemService.save(itemInfo);
            result.setCode(Result.SUCCESS);
            result.setMsg("保存成功");
        }catch (Exception ex){
            log.error("保存商品信息失败,失败信息如下: ",ex);
            result.setMsg("保存商品失败,失败信息："+ex.getMessage());
            result.setCode(Result.ERROR);
        }
        return result;
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
        BasePagePO basePagePO = itemService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(ItemInfo itemInfo){
        Result result =  new Result();
        try{
            itemService.update(itemInfo);
            result.setCode(Result.SUCCESS);
            result.setMsg("更新商品成功");
        }catch (Exception ex){
            result.setCode(Result.ERROR);
            result.setMsg(ex.getMessage());
            log.error("修改宝贝信息错误，错误信息如下： ",ex);
        }
        return result;
    }



    @RequestMapping("page")
    @ResponseBody
   public Object page(){
       return null;
   }


}
