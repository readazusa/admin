package net.sunmingchun.www.file.service.impl;

import net.sunmingchun.www.file.dao.IUploadFileDao;
import net.sunmingchun.www.file.po.UploadFilePO;
import net.sunmingchun.www.file.service.UploadFileService;
import net.sunmingchun.www.util.DateFormatUtils;
import net.sunmingchun.www.util.FtpUtils;
import net.sunmingchun.www.util.UuidUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 念梓  on 2016/8/9.
 * Email:sunmch@163.com
 * TEL:13913534135
 * author: 念梓
 * des:
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Value("${img.url}")
    private String img_url;

    private static final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);

    @Resource
    private IUploadFileDao uploadFileDao;

    @Override
    public Map<String,String> uploadFtpFile(MultipartFile multipartFile) {

        String dir = DateFormatUtils.getFormatDate("yyyyMMdd");
        String name = multipartFile.getName();
        long size = multipartFile.getSize();
        String contentType = multipartFile.getContentType();
        String origName = multipartFile.getOriginalFilename();
        String subffix = origName.substring(origName.lastIndexOf("."));
        String uploadFtpFileName = UuidUtils.getUuid()+subffix;
        try {
            FtpUtils.getInstance().sendFile(dir,uploadFtpFileName,multipartFile.getInputStream());
        } catch (Exception e) {
            log.error("上传ftp文件失败,失败信息: ",e);
        }
        UploadFilePO uploadFilePO = new UploadFilePO();
        uploadFilePO.setContentType(contentType);
        StringBuffer sb = new StringBuffer(img_url).append(dir).append("/").append(uploadFtpFileName);
        String uploadFileUrl = sb.toString();
        uploadFilePO.setSize(size);
        uploadFilePO.setName(uploadFtpFileName);
        uploadFilePO.setOrigName(origName);
        uploadFilePO.setSubffix(subffix);
        uploadFilePO.setUrl(uploadFileUrl);
        save(uploadFilePO);
        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("url",uploadFileUrl);
        resultMap.put("id",uploadFilePO.getId());
        return resultMap;
    }

    @Override
    public List<Map<String,String>> uploadFtpFile(List<MultipartFile> multipartFiles) {
        return null;
    }

    /**
     * 保存数据库
     * @param uploadFilePO
     */
    public void save(UploadFilePO uploadFilePO){
        if(StringUtils.isBlank(uploadFilePO.getId())){
            uploadFilePO.setId(UuidUtils.getUuid());
            Date nowDate = new Date();
            uploadFilePO.setCreateTime(nowDate);
            uploadFilePO.setUpdateTime(nowDate);
        }
        uploadFileDao.save(uploadFilePO);

    }

}
