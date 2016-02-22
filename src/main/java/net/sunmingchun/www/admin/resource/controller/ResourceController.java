package net.sunmingchun.www.admin.resource.controller;

import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.resource.service.IResourceService;
import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by smc on 2015/11/19.
 */
@RequestMapping("resource")
@Controller
public class ResourceController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger("ResourceController");
    @Resource
    private IResourceService resourceService;

    @RequestMapping("index")
    public String index(){
        return "admin/resource/index";
    }

    @RequestMapping("new")
    public String gotoNewPage(){
        return "admin/resource/new";
    }

    @RequestMapping("edit")
    public String gotoEditPage(String id,ModelMap model){
        ResourcePO resourcePO = resourceService.queryObjectById(id);
        model.put("resource",resourcePO);
        return "admin/resource/edit";
    }

    @RequestMapping("view")
    public String gotoViewPage(String id,ModelMap model){
        ResourcePO resourcePO = resourceService.queryObjectById(id);
        model.put("resource",resourcePO);
        return "admin/resource/view";
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(ResourcePO resourcePO){
        Result result = new Result();
        try{
            resourceService.update(resourcePO);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("更新权限失败,失败信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("更新出错，错误信息： "+ex.getMessage() );
        }
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public Result add(ResourcePO resourcePO){
        Result result = new Result();
        try{
            resourceService.save(resourcePO);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("新增权限失败： 失败信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("信息失败，失败信息： "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result remove(String id){
        Result result = new Result();
        try{
            resourceService.deleteById(id);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("删除权限失败,失败信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("删除失败，失败信息： "+ ex.getMessage());
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
        BasePagePO basePagePO = resourceService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }


}
