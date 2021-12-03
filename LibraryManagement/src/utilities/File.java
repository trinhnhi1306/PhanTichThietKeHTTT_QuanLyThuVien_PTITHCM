/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author TRINH
 */
public class File {
    
    public static void xuatFileExcel(String sheetName, DefaultTableModel model, String fileName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);
        XSSFRow row = null;
        Cell cell = null;
        row = sheet.createRow(0);
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("STT");
        int m = 1;
        
        int r = model.getRowCount();
        int c = model.getColumnCount();
        
        //Add header
        for (int i = 0; i < c; i++) {
            cell = row.createCell(m, CellType.STRING);
            cell.setCellValue(model.getColumnName(i));
            m++;
        }
        
        //Add STT and data
        for (int i = 0; i < r; i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(i + 1);
            for (int j = 0; j < c; j++) {
                cell = row.createCell(j + 1, CellType.STRING);
                cell.setCellValue(model.getValueAt(i, j).toString());
            }
        }
        
        //Lưu file
        java.io.File f = new java.io.File(fileName + ".xlsx");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void nhapFileExcel(String filePath, DefaultTableModel model) {
        
        int slCot = model.getColumnCount();
        try {
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for(Row row : sheet) {
                for (int i = 0; i < slCot; i++) {
                    if (!String.valueOf(row.getCell(i + 1)).equals(model.getColumnName(i))) {
                        JOptionPane.showMessageDialog(null, "Thứ tự cột file excel không đúng!");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Nhập file excel thành công!");
                break;
            }
            
            model.setNumRows(0);
            Vector vt = null;
            boolean ignore = true;
            
            for(Row row : sheet) {           
                if (ignore == true) {
                    ignore = false;
                    continue;
                }
                vt = new Vector();
                for (int i = 1; i <= slCot; i++){
                    vt.add(row.getCell(i));
                }
                model.addRow(vt);
            }
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void xuatFilePDF(String fileName, String title, String information, DefaultTableModel model) {
        Document document = new Document();
        java.io.File fontFile = new java.io.File("vuArial.ttf");
        int numRow = model.getRowCount();
        int numCol = model.getColumnCount();
        
        //Khởi tạo một table có numCol + 1 cột (STT) 
        PdfPTable table = new PdfPTable(numCol + 1);
        PdfPCell data;            
        
        try {
            PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
            BaseFont bf = BaseFont.createFont(fontFile.getAbsolutePath(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 15);
            Font catFont = new Font(bf, 18, Font.BOLD);
            
            //Add STT
            data = new PdfPCell(new Paragraph("STT", font));
            //Căn giữa cho header
            data.setHorizontalAlignment(Element.ALIGN_CENTER);
            //Thêm data vào bảng
            table.addCell(data);
            
            //Thêm tiêu đề cho table
            for (int i = 0; i < numCol; i++) {
                //Khởi tạo ô
                data = new PdfPCell(new Paragraph(model.getColumnName(i), font));
                //Căn giữa cho header
                data.setHorizontalAlignment(Element.ALIGN_CENTER);
                //Thêm data vào bảng
                table.addCell(data);
            }

            //Thêm dữ liệu cho table
            for (int i = 0; i < numRow; i++) {
                //Khởi tạo ô
                data = new PdfPCell(new Paragraph((i + 1) + ""));
                //Thêm STT vào bảng
                table.addCell(data);
                for (int j = 0; j < numCol; j++) {
                    //Khởi tạo ô
                    data = new PdfPCell(new Paragraph(model.getValueAt(i, j).toString(), font));
                    //Thêm data vào bảng
                    table.addCell(data);
                }
            }
            
            //Mở document để bắt đầu ghi
            document.open();
            
            //Add title vào
            Paragraph strTitle = new Paragraph(title, catFont);
            strTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(strTitle);
            
            //Add information vào
            document.add(new Paragraph(information, font));
            
            //Thêm vào một dòng trắng
            document.add(new Paragraph(" "));
            
            //Add table
            document.add(table);
            document.close();
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
