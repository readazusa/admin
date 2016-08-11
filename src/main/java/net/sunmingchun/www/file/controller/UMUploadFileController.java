package net.sunmingchun.www.file.controller;

import com.alibaba.fastjson.JSONObject;
import net.sunmingchun.www.util.DateFormatUtils;
import net.sunmingchun.www.util.FtpUtils;
import net.sunmingchun.www.util.UuidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by 念梓  on 2016/8/11.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:百度uedit-mini，上传控制值
 */
@RequestMapping("um")
@Controller
public class UMUploadFileController {

    private static final Logger log = LoggerFactory.getLogger(UMUploadFileController.class);

    @RequestMapping("upload")
    public void upload(MultipartRequest request,HttpServletResponse response){
        UMUplaod umUplaod = new UMUplaod();
        MultipartFile multipartFile = request.getFile("upfile");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            InputStream inputStream = multipartFile.getInputStream();
            String originName = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();
            String subffixName = this.getFileExt(originName);
            String newName = UuidUtils.getUpperUuid()+subffixName;
            log.debug("接收um端的数据............");
            String dir = "UM"+ DateFormatUtils.getFormatDate("yyyyMMdd");
            Boolean uploadFtpResult  = FtpUtils.getInstance().sendFile(dir,newName,inputStream);
            String url = dir+"/"+newName;
            umUplaod.setName(newName);
            umUplaod.setOriginalName(originName);
            umUplaod.setSize(size);
            umUplaod.setType(subffixName);
            umUplaod.setUrl(url);
            if(uploadFtpResult){
                umUplaod.setState("SUCCESS");
            }else{
                umUplaod.setState("上传文件失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String resultJsonStr = JSONObject.toJSONString(umUplaod);
        log.debug("um文件上传返回的json: {} ",resultJsonStr);
        try {
            response.getWriter().print( resultJsonStr );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取文件扩展名
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }


    class UMUplaod{

        private  String name;

        private String originalName;

        private long size;

        private String state;

        private String type;

        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public UMUplaod() {
        }

        public UMUplaod(String name, String originalName, long size, String state, String type, String url) {
            this.name = name;
            this.originalName = originalName;
            this.size = size;
            this.state = state;
            this.type = type;
            this.url = url;
        }
    }
}


