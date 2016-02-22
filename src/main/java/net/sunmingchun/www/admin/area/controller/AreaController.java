package net.sunmingchun.www.admin.area.controller;

import net.sunmingchun.www.admin.area.po.AreaPO;
import net.sunmingchun.www.admin.area.service.IAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by smc on 2016/1/11.
 */
@Controller
@RequestMapping("area")
public class AreaController {
    private static final Logger log = LoggerFactory.getLogger("AreaController");

    @Resource
    private IAreaService areaService;

    @RequestMapping("get/{id}.json")
    @ResponseBody
    public Object getAreaByParentId(@PathVariable("id") String id){
        int s = 0;

        Map<String,Object> map = new HashMap<>();
        try{
            List<AreaPO> list = areaService.getAreaByParentId(id);
            map.put("data",list);
            map.put("code","ok");
        }catch (Exception ex){
            map.put("code","error");
            log.error(" ",ex);
        }
        return map;
    }

}
