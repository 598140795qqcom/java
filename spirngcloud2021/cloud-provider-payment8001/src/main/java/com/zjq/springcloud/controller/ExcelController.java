package com.zjq.springcloud.controller;

import com.zjq.springcloud.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author Administrator
 * @title: ExcelController
 * @projectName NODECloud
 * @description: TODO
 * @date 2021/8/25 15:17
 */
@RestController
public class ExcelController {

    /**
     * 导出报表
     * @return
     */
    @GetMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        //List<PageData> list = userService.serviceList();

        //excel标题
        String[] title = {"用户ID", "用户名称", "用户密码", "用户手机","创建时间"};

        //excel文件名
        String fileName = "用户信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "用户信息表";

        String [][] content = new String[3][5];

        for (int i = 0; i < 3; i++) {
            content[i] = new String[title.length];
            content[i][0] = "第一行"+i;
            content[i][1] = "第二行"+i;
            content[i][2] = "第三行"+i;
            content[i][3] = "第四行"+i;
            content[i][4] = "第五行"+i;
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtils.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送响应流方法
     */
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
