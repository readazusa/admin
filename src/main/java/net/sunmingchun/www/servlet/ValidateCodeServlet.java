package net.sunmingchun.www.servlet;

import net.sunmingchun.www.util.CodeConstantUtils;
import net.sunmingchun.www.util.ValidateCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ${PACKAGE_NAME}
 * Created by smc
 * date on 2016/3/29.
 * Email:sunmch@163.com
 *
 */
@WebServlet(name = "ValidateCodeServlet",value = "/api/validatecode")
public class ValidateCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doExecute(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doExecute(request, response);
    }

    private void doExecute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String validateCode = ValidateCodeUtils.getValidateCode(4);
        HttpSession session = request.getSession();
        session.setAttribute(CodeConstantUtils.VALIDATE_CODE,validateCode.toUpperCase());
        OutputStream out = response.getOutputStream();
        ValidateCodeUtils.outputImage(100,40,out,validateCode);
        out.flush();
        out.close();
    }
}
