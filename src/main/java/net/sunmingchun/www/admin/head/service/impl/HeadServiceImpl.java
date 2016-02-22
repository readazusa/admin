package net.sunmingchun.www.admin.head.service.impl;

import net.coobird.thumbnailator.Thumbnails;
import net.sunmingchun.www.admin.head.po.NewHeadCoordinate;
import net.sunmingchun.www.admin.head.service.IHeadService;
import net.sunmingchun.www.util.DateFormatUtils;
import net.sunmingchun.www.util.PathConstantUtils;
import net.sunmingchun.www.util.UuidUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by smc on 2016/1/22.
 */
@Service
public class HeadServiceImpl implements  IHeadService {

    @Override
    public String upload(HttpServletRequest request) {
        String ret="";
        MultipartHttpServletRequest  multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartHttpServletRequest.getFile("headFile");
        if(null != multipartFile){
            String contentType = multipartFile.getContentType();
            String fileName = multipartFile.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            ret= DateFormatUtils.getFormatDate("yyyMMdd")+"/"+ UuidUtils.getUuid()+suffix; // 生成的目标路径
            File targetFile = new File(PathConstantUtils.HEAD_UPLOAD_PATH+ret);
            try {
                InputStream inputStream = multipartFile.getInputStream();
                FileUtils.copyInputStreamToFile(inputStream,targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    @Override
    public void saveNewHeadCoordinate(NewHeadCoordinate newHeadCoordinate) {
        File sourceFile = new File(PathConstantUtils.HEAD_UPLOAD_PATH+newHeadCoordinate.getPath());
        String suffix = newHeadCoordinate.getPath().substring( newHeadCoordinate.getPath().lastIndexOf("."));
        String newPath = DateFormatUtils.getFormatDate("yyyyMMdd")+"/"+UuidUtils.getUuid()+suffix;
        File targetFile = new File(PathConstantUtils.HEAD_UPLOAD_PATH+newPath);
        try {
            Thumbnails.of(sourceFile).sourceRegion(newHeadCoordinate.getX1(),newHeadCoordinate.getY1(),newHeadCoordinate.getX2(),newHeadCoordinate.getY2()).size(newHeadCoordinate.getWidth(),newHeadCoordinate.getHeight()).toFile(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
