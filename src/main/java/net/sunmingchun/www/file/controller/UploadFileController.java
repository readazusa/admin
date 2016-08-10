package net.sunmingchun.www.file.controller;

import net.sunmingchun.www.common.Result;
import net.sunmingchun.www.file.service.UploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des: 文件上传组件
 */
@RequestMapping("upload")
@Controller
public class UploadFileController {

    private static final Logger log = LoggerFactory.getLogger(UploadFileController.class);

    @Resource
    private UploadFileService uploadFileService;


    @RequestMapping("ftp")
    @ResponseBody
    public Object uploadFtp(MultipartRequest request){
        Result result = new Result();
        MultipartFile  multipartFile = request.getFile("file");
        try{
            Map<String,String> uploadFtpFileResult = uploadFileService.uploadFtpFile(multipartFile);
            result.setData(uploadFtpFileResult);
        }catch (Exception ex){
            log.error("上传文件到ftp出错，错误信息： ",ex);
        }
        return result;
    }

}
