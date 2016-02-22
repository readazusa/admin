package net.sunmingchun.www.admin.user.controller;

import net.sunmingchun.admin.role.po.RolePO;
import net.sunmingchun.admin.role.service.IRoleService;
import net.sunmingchun.admin.user.po.UserPO;
import net.sunmingchun.admin.user.service.IUserService;
import net.sunmingchun.base.controller.BaseController;
import net.sunmingchun.base.log.LogFactory;
import net.sunmingchun.base.po.BasePagePO;
import net.sunmingchun.common.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.httpserver.HttpServerImpl;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by smc on 2015/11/19.
 */
@RequestMapping("user")
@Controller
public class UserController extends BaseController{

    private  static final Logger log = LogFactory.getLogger("UserController");

    @Resource
    private IUserService userService;



    @RequestMapping("index")
    public String index(){
        return "admin/user/index";
    }

    @RequestMapping("new")
    public String gotoNewPage(){
        return "admin/user/new";
    }

    @RequestMapping("edit")
    public String gotoEditPage(String id,ModelMap model){
        UserPO userPO = userService.queryObjectById(id);
        model.put("user",userPO);
        return "admin/user/edit";
    }

    @RequestMapping("view")
    public String gotoViewPage(String id,ModelMap model){
        UserPO userPO = userService.queryObjectById(id);
        model.put("user",userPO);
        return "admin/user/view";
    }
    @RequestMapping("delete")
    @ResponseBody
    public Result doDeleteUser(String id){
        Result result = new Result();
        try{
            userService.deleteById(id);
            result.setCode("SUCCESS");
            result.setMsg("删除用户成功");
        }catch (Exception ex){
            log.error("删除用户信息失败,失败信息如下： "+ ex);
            result.setCode("ERROR");
            result.setMsg("删除用户失败，失败信息： "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result doUpdate(UserPO userPO){
        Result result = new Result();
        try{
            userService.update(userPO);
            result.setMsg("更新用户成功");
            result.setCode("SUCCESS");
        }catch (Exception ex){
            log.error("更新用户信息失败,失败信息如下: ",ex);
            result.setCode("ERROR");
            result.setMsg("更新用户失败,失败信息: "+ ex.getMessage());
        }
        return result;
    }
    @RequestMapping("save")
    @ResponseBody
    public Result doAdd(UserPO user){
        Result result = new Result();
        try{
            userService.save(user);
            result.setCode(Result.SUCCESS);
            result.setMsg("保存成功");
        }catch (Exception ex){
            log.error("保存用户信息失败,失败信息如下: ",ex);
            result.setMsg("保存用户失败,失败信息："+ex.getMessage());
            result.setCode(Result.ERROR);
        }
        return result;
    }

    @RequestMapping("user_role")
    public String gotoUserRolePage(String id,ModelMap model){
        model.put("userId",id);
        List<RolePO> rolePOList = userService.queryRoleList(id);
        model.put("roles",rolePOList);
        return "admin/user/user_role";
    }


    @RequestMapping("add_user_role")
    @ResponseBody
    public Result addUserRole(String userId,String roleIds){
        Result result = new Result();
        try{
            userService.saveUserRole(userId,roleIds);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("保存用户角色关联关系错误，错误信息： ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("保存用户角色关联关系失败,失败信息： "+ ex.getMessage());
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
        BasePagePO basePagePO = userService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }




}
