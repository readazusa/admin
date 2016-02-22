package net.sunmingchun.www.admin.role.controller;

import javafx.print.PaperSource;
import jdk.nashorn.internal.ir.CatchNode;
import net.sunmingchun.www.admin.resource.dao.IResourceDao;
import net.sunmingchun.www.admin.resource.po.ResourcePO;
import net.sunmingchun.www.admin.resource.service.IResourceService;
import net.sunmingchun.www.admin.role.po.RolePO;
import net.sunmingchun.www.admin.role.service.IRoleService;
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
import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

/**
 * Created by smc on 2015/11/19.
 */
@RequestMapping("role")
@Controller
public class RoleController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger("RoleController");

    @Resource
    private IRoleService roleService;


    @RequestMapping("index")
    public String index(){
        return "admin/role/index";
    }


    @RequestMapping("new")
    public String gotoNewPage(){
        return "admin/role/new";
    }

    @RequestMapping("edit")
    public String gotoEditPage(String id,ModelMap model){
//        RolePO rolePO = roleService.queryObjectById(id);
//        model.put("role",rolePO);
        return "admin/role/edit";
    }

    @RequestMapping("view")
    public String gotoViewPage(String id,ModelMap model){
//        RolePO rolePO = roleService.queryObjectById(id);
        return "admin/role/view";
    }


    @RequestMapping("update")
    @ResponseBody
    public Result update(RolePO rolePO){
        Result result = new Result();
        try{
//            roleService.update(rolePO);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("更新失败，失败信息如下： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("更新失败，请重新从新操作");
        }
        return result;
    }

    @RequestMapping("save")
    @ResponseBody
    public Result add(RolePO rolePO){
        Result result = new Result();
        try{
//            roleService.save(rolePO);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("新增失败，失败信息如下： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("新增失败，请重新从新操作");
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result remove(String id){
        Result result = new Result();
        try{
//            roleService.deleteById(id);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            result.setCode(Result.ERROR);
            result.setMsg("删除角色失败，请重新操作");
        }
        return result;
    }

    @RequestMapping("role_res")
    public String gotoRoleResPage(String id,ModelMap model){
        model.put("roleId",id);
//        List<ResourcePO> resourcePOList = roleService.queryResourcePOByRoleId(id);
//        model.put("resources",resourcePOList);

        return "admin/role/role_res";
    }

    @RequestMapping("add_role_res")
    @ResponseBody
    public Result addRoleRes(String roleId,String resIds){
        Result result = new Result();
        try{
            roleService.saveRoleResource(roleId,resIds);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("保存角色权限信息错误，错误信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("保存角色权限信息错误，错误信息如下： "+ex.getMessage());
        }
        return result;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object queryPage(HttpServletRequest request){
        String searchValue = request.getParameter("search[value]");
        String orderColumnStr =  request.getParameter("order[0][column]");  //排序的列
        String orderName = this.getOrderName(request,orderColumnStr);
        String orderValue = request.getParameter("order[0][dir]");
        int pageSize = Integer.parseInt(request.getParameter("length"));
        int pageIndex = Integer.parseInt(request.getParameter("start"));
        int draw = Integer.parseInt(request.getParameter("draw"));
        BasePagePO<RolePO> page = roleService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return page;
    }


}
