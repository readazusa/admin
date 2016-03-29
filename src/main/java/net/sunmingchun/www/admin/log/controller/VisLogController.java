package net.sunmingchun.www.admin.log.controller;

import net.sunmingchun.www.admin.log.po.VisitLogPO;
import net.sunmingchun.www.admin.log.service.IVisLogService;
import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * net.sunmingchun.www.admin.log.controller
 * Created by smc
 * date on 2016/3/28.
 * Email:sunmch@163.com
 * 查询访问日志
 */
@Controller
@RequestMapping("vislog")
public class VisLogController extends BaseController {

    @Resource
    private IVisLogService visLogService;

    @RequestMapping("index")
    public String  index(){
        return "admin/log/vis/index";
    }

    @RequestMapping("view")
    public String gotoViewPage(String id,ModelMap model){
       VisitLogPO visitLogPO = visLogService.queryObjectById(id);
        model.put("visitLogPO",visitLogPO);
        return "admin/log/vis/view";
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
        BasePagePO basePagePO = visLogService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }
}
