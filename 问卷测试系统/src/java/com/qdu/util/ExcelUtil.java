package com.qdu.util;

import java.io.OutputStream;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ExcelUtil {
    
    public static void fillExcel(List<Object[]> list,Workbook wb,String[] hearders){
        int rowIndex=0;
        Sheet sheet=wb.createSheet();
        Row row=sheet.createRow(rowIndex++);
        for(int i=0;i<hearders.length;i++){
            row.createCell(i).setCellValue(hearders[i]);
        }
        for(Object[] obj:list){
            row=sheet.createRow(rowIndex++);
            for(int i=0;i<hearders.length;i++){
            row.createCell(i).setCellValue(obj[i].toString());
        }
        }
    }
    
    public static void export(Workbook wb,String fileName) throws Exception{
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.reset();
        response.setContentType("application/ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="
                  + new String(fileName.getBytes("gb2312"), "ISO8859-1")
                  + ".xls");
            wb.write(response.getOutputStream());
        } catch (Exception e) {
         e.printStackTrace();
        }
         FacesContext.getCurrentInstance().responseComplete();
    }
    
}
