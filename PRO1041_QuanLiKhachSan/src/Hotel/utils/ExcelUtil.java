
package Hotel.utils;


import Hotel.dao.ThongKeDAO;
import Hotel.entity.HoaDonThanhToan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
/**
 *
 * @author Phạm Thị Thuý Huyền
 */
public class ExcelUtil {
public static Workbook printDoanhThuphongToExcel(javax.swing.JTable tblPhong, 
        javax.swing.JComboBox<String> cboNgayNam, ThongKeDAO tkDAO) throws FileNotFoundException, IOException {
 
        HSSFWorkbook workbook = new HSSFWorkbook();
        String sheetName = "Thống kê " + ((String) cboNgayNam.getSelectedItem()).replace("/", "-");
        HSSFSheet sheet = workbook.createSheet(sheetName);    
        try {
        
   
            HoaDonThanhToan hd = (HoaDonThanhToan) cboNgayNam.getSelectedItem();
            Date ngayLap = hd.getNgayLap();

            // Convertir la date en entiers (jour, mois, année)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(ngayLap);
            int thang = calendar.get(Calendar.DAY_OF_MONTH);
            int nam = calendar.get(Calendar.MONTH) + 1; // Ajouter 1 car les mois dans Calendar commencent à 0

        // Appeler la méthode avec les entiers correspondants
        List<Object[]> list = tkDAO.getDoanhThuPhong(thang, nam);
        
        int rownum = 0; 
        Cell cell;         Row row;
        
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        cell = row.createCell(0,CellType.NUMERIC);
        cell.setCellValue("STT");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã phòng");
        cell.setCellStyle(style);
        
        cell = row.createCell(2,CellType.NUMERIC);
        cell.setCellValue("Phụ Thu");
        cell.setCellStyle(style);
        

        cell = row.createCell(3,CellType.NUMERIC);
        cell.setCellValue("Thành Tiền");
        cell.setCellStyle(style);
         System.out.println("danh sách" + list);
      //  DATA 
for (int i = 0; i < list.size(); i++) {
    rownum++;
    row = sheet.createRow(rownum);

    cell = row.createCell(0, CellType.NUMERIC);
    cell.setCellValue(i + 1); // Use the correct index for STT

    cell = row.createCell(1, CellType.STRING);
    cell.setCellValue((String) list.get(i)[1]); // Use the correct index for Mã phòng

    cell = row.createCell(2, CellType.NUMERIC);
    cell.setCellValue((Double) list.get(i)[2]); // Use the correct index for Phụ Thu

    cell = row.createCell(3, CellType.NUMERIC);
    cell.setCellValue((Double) list.get(i)[3]); // Use the correct index for Thành Tiền
}
 } catch (Exception e) {
    }
    return workbook;
}
public static Workbook printDoanhThuDVToExcel(javax.swing.JTable tblDichVu, 
        javax.swing.JComboBox<String> cboNgayNam, ThongKeDAO tkDAO) throws FileNotFoundException, IOException {
    
        HSSFWorkbook workbook = new HSSFWorkbook();
        String sheetName2 = "Thống kê " + ((String) cboNgayNam.getSelectedItem()).replace("/", "-");
        HSSFSheet sheet = workbook.createSheet(sheetName2);    
        try {
       
        HoaDonThanhToan hd = (HoaDonThanhToan) cboNgayNam.getSelectedItem();
        Date ngayLap = hd.getNgayLap();

        // Convertir la date en entiers (jour, mois, année)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ngayLap);
        int jour = calendar.get(Calendar.DAY_OF_MONTH);
        int mois = calendar.get(Calendar.MONTH) + 1; // Ajouter 1 car les mois dans Calendar commencent à 0

        // Appeler la méthode avec les entiers correspondants
        List<Object[]> list = tkDAO.getDoanhThuPhong(jour, mois);
        
        int rownum = 0; 
        Cell cell; 
        Row row;
        
        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        cell = row.createCell(0,CellType.NUMERIC);
        cell.setCellValue("STT");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Mã dịch vụ");
        cell.setCellStyle(style);
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Tên dịch vụ");
        cell.setCellStyle(style);
        
        cell = row.createCell(3,CellType.NUMERIC);
        cell.setCellValue("Số Lượng");
        cell.setCellStyle(style);
        
        cell = row.createCell(4,CellType.NUMERIC);
        cell.setCellValue("Đơn giá");
        cell.setCellStyle(style);
        
         cell = row.createCell(5,CellType.NUMERIC);
        cell.setCellValue("Thành tiền");
        cell.setCellStyle(style);
        
        //DATA 
        for (int i = 0; i < list.size(); i++) {
    rownum++;
    row = sheet.createRow(rownum);

    cell = row.createCell(0, CellType.NUMERIC);
    cell.setCellValue(i + 1); // Use the correct index for STT

    cell = row.createCell(1, CellType.STRING);
    cell.setCellValue((String) list.get(i)[1]); // Use the correct index for Mã dịch vụ

    cell = row.createCell(2, CellType.STRING);
    cell.setCellValue((String) list.get(i)[2]); // Use the correct index for Tên dịch vụ

    cell = row.createCell(3, CellType.NUMERIC);
    cell.setCellValue((Integer) list.get(i)[3]); // Use the correct index for Số Lượng

    cell = row.createCell(4, CellType.NUMERIC);
    cell.setCellValue((Double) list.get(i)[4]); // Use the correct index for Đơn giá

    cell = row.createCell(5, CellType.NUMERIC);
    cell.setCellValue((Double) list.get(i)[5]); // Use the correct index for Thành tiền
        } 
        } catch (Exception e) {
    }
    return workbook;
}
    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

}
