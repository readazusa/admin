package net.sunmingchun.www.admin.head.controller;

import net.sunmingchun.www.admin.head.po.NewHeadCoordinate;
import net.sunmingchun.www.admin.head.service.IHeadService;
import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.util.PathConstantUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smc on 2016/1/21.
 */
@RequestMapping("head")
@Controller
public class HeadController {

    private  static final Logger log = LoggerFactory.getLogger("HeadController");

    @Resource
    private IHeadService headService;

    @RequestMapping("heads")
    public String heads(){
        return "admin/head/heads";
    }

    @RequestMapping("upload")
    @ResponseBody
    public Object uploadHead(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        try{
            String ret = headService.upload(request);
            map.put("path",ret);
            map.put("code", Result.SUCCESS);
        }catch (Exception ex){
            log.error("自定义上传头像错误,错误信息： ",ex);
            map.put("code",Result.ERROR);
        }
        return map;
    }

    @RequestMapping("show")
    public void showHead(HttpServletRequest request,HttpServletResponse response,String path){
        try {
            OutputStream out = response.getOutputStream();
            FileInputStream inputStream = new FileInputStream(new File(PathConstantUtils.HEAD_UPLOAD_PATH+path));
            IOUtils.copy(inputStream,out);
            inputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("save")
    @ResponseBody
    public Object saveHead(NewHeadCoordinate headCoordinate){
            try{
                headService.saveNewHeadCoordinate(headCoordinate);
            }catch (Exception ex){

            }
        return null;
    }



}
