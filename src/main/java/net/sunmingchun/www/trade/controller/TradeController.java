package net.sunmingchun.www.trade.controller;

import net.sunmingchun.www.base.controller.BaseController;
import net.sunmingchun.www.base.po.BasePagePO;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.trade.po.TradeInfo;
import net.sunmingchun.www.trade.service.ITradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 念梓  on 2016/8/15.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des: 订单
 */
@Controller
@RequestMapping("trade")
public class TradeController extends BaseController{

    private static final Logger log = LoggerFactory.getLogger(TradeController.class);

    @Resource
    private ITradeService tradeService;


    @RequestMapping("index")
    public String index(){
        return "trade/index";
    }
    /**
     * 编辑订单
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("edit")
    public String edit(String id, ModelMap model){
        TradeInfo tradeInfo = tradeService.queryObjectById(id);
        model.put("trade",tradeInfo);
        return "trade/edit";
    }

    /**
     * 发货及操作订单的过程
     * @param tradeInfo
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public Object update(TradeInfo tradeInfo){
        Result result = new Result();
        try{
            tradeService.update(tradeInfo);
            result.setCode(Result.SUCCESS);
        }catch (Exception ex){
            log.error("操作订单失败,失败信息: ",ex);
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
        BasePagePO<TradeInfo> basePagePO = tradeService.getBasePagePO(pageIndex,pageSize,searchValue,orderName,orderValue,draw);
        return basePagePO;
    }





}
