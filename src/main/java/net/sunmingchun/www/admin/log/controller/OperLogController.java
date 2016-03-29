package net.sunmingchun.www.admin.log.controller;

import net.sunmingchun.www.admin.log.service.IOperLogService;
import net.sunmingchun.www.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * net.sunmingchun.www.admin.log.controller
 * Created by smc
 * date on 2016/3/28.
 * Email:sunmch@163.com
 * 查询操作日志
 */
@Controller
@RequestMapping("operlog")
public class OperLogController extends BaseController {

    @Resource
    private IOperLogService operLogService;

    @RequestMapping("index")
    public String  index(){
        return null;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(HttpServletRequest request){
        return null;
    }

}
