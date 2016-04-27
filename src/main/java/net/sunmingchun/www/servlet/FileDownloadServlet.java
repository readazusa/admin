package net.sunmingchun.www.servlet;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ${PACKAGE_NAME}
 * Created by smc
 * date on 2016/4/7.
 * Email:sunmch@163.com
 */
@WebServlet(name = "FileDowloadServlet",value = "/api/download/file")
public class FileDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setHeader("Content-Disposition", "attachment; filename=123.mp4");
        File file = new File("E:"+ File.separator+"123.MKV");
        OutputStream outputStream = response.getOutputStream();
        FileUtils.copyFile(file,outputStream);
        outputStream.close();

    }
}
