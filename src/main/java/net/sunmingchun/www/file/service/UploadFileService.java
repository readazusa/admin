package net.sunmingchun.www.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
public interface UploadFileService {

    /**
     * 通过springmvc进行文件上传，本地上传到ftp服务器
     * @param multipartFile
     */
    public Map<String,String> uploadFtpFile(MultipartFile multipartFile);

    public List<Map<String,String>> uploadFtpFile(List<MultipartFile> multipartFiles);



}
