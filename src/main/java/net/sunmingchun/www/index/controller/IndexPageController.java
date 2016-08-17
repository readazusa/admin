package net.sunmingchun.www.index.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.index.po.IndexPageInfo;
import net.sunmingchun.www.index.service.IIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2016/8/17.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des: 首页不同位置显示的内容管理
 */
@RequestMapping("index")
@Controller
public class IndexPageController extends BaseController{

    public static final Logger log = LoggerFactory.getLogger(IndexPageController.class);

    @Resource
    private IIndexService indexService;

    /**
     *广告头的主页
     * @return
     */
    @RequestMapping("header")
    public String indexHeader(ModelMap model){
        model.put("type",0);
        model.put("flag","indexheader");
        return "index/index";
    }

    /**
     * 中间的图片
     * @return
     */
    @RequestMapping("middlepic")
    public String indexMiddlePic(ModelMap model){
        model.put("type",2);
        model.put("flag","indexmiddlepic");
        return "index/index";
    }

    /**
     * 中间广告提示
     * @return
     */
    @RequestMapping("middlets")
    public String indexMiddleTs(ModelMap model){
        model.put("type",1);
        model.put("flag","indexmiddlets");
        return "index/index";
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(String type, HttpServletRequest request){
        String searchValue = request.getParameter("search[value]");
        String orderColumnStr =  request.getParameter("order[0][column]");  //排序的列
        String orderName = this.getOrderName(request,orderColumnStr);
        String orderValue = request.getParameter("order[0][dir]");
        int pageSize = Integer.parseInt(request.getParameter("length"));
        int pageIndex = Integer.parseInt(request.getParameter("start"));
        int draw = Integer.parseInt(request.getParameter("draw"));
        BasePagePO<IndexPageInfo> basePagePO = indexService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw,type);
        return basePagePO;
    }

    @RequestMapping("new")
    public String newPage(String type,ModelMap model){
        model.put("type", type);
        return "index/new";
    }

    @RequestMapping("save")
    @ResponseBody
    public Object save(IndexPageInfo indexPageInfo){
        Result result = new Result();
        try{
            indexService.save(indexPageInfo);
            result.setCode(Result.SUCCESS);
            result.setMsg("操作成功");
        }catch(Exception ex){
            log.error("操作保存失败: ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("操作失败: "+ex.getMessage());
        }
        return result;
    }

    @RequestMapping("view")
    public String view(String id,ModelMap model){
        IndexPageInfo indexPageInfo = indexService.queryObjectById(id);
        model.put("indexPage",indexPageInfo);
        return "index/view";
    }

    @RequestMapping("edit")
    public String edit(String id,ModelMap model){
        IndexPageInfo indexPageInfo = indexService.queryObjectById(id);
        model.put("indexPage",indexPageInfo);
        return "index/edit";
    }

    @RequestMapping("update")
    @ResponseBody
    public Object update(IndexPageInfo indexPageInfo){
        Result result = new Result();
        try{
            indexService.update(indexPageInfo);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("更新失败: ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("更新失败: "+ ex.getMessage());
        }
        return result;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(String  id){
        Result result = new Result();
        try{
            indexService.deleteById(id);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("删除失败: ",ex);
            result.setCode(Result.ERROR);
            result.setMsg("删除失败: "+ ex.getMessage());
        }
        return result;
    }

}
