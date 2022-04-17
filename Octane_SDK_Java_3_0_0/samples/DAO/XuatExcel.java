package DAO;
//
//import BUS.NhanVienBUS;
//import BUS.PhongBanBUS;
//import DTO.ChiTietNhanVienDTO;
//import DTO.NhanVienDTO;
//import DTO.PhongBanDTO;

import java.awt.Color;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class XuatExcel
{

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile()
    {
        fd.setFile("donxuat.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull"))
        {
            return null;
        }
        return url;
    }

    // Xuất file Excel 
    @SuppressWarnings("empty-statement")
    public void xuatFileExcelDonHang(ArrayList<String> a)
    {
        fd.setTitle("Xuất đơn hàng ra excel");
        String url = getFile();
        if (url == null)
        {
            return;
        }

        FileOutputStream outFile = null;
        try
        {
            //Create a Work Book
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Đơn Xuất");//Tên sheet

            HSSFCellStyle styleTitle = workbook.createCellStyle(); // Style cho Title
            styleTitle.setBorderTop(BorderStyle.THIN);
            styleTitle.setBorderBottom(BorderStyle.THIN);
            styleTitle.setBorderRight(BorderStyle.THIN);
            styleTitle.setBorderLeft(BorderStyle.THIN);
            styleTitle.setAlignment(HorizontalAlignment.CENTER);
            styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);

            Row rowTitle = sheet.createRow(1);
            rowTitle.setHeight((short) 800);
            HSSFCell cellTitleCell = (HSSFCell) rowTitle.createCell(1);
            cellTitleCell.setCellValue("PHIẾU XUẤT KHO");
            cellTitleCell.setCellStyle(styleTitle);
            CellRangeAddress cellRangeAddress = new CellRangeAddress(1, 1, 1, 10);
            rowTitle.getSheet().addMergedRegion(cellRangeAddress);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, cellRangeAddress, sheet);
            RegionUtil.setBorderBottom(BorderStyle.DOUBLE, cellRangeAddress, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, cellRangeAddress, sheet);
            RegionUtil.setBorderRight(BorderStyle.DOUBLE, cellRangeAddress, sheet);

            ////Style cho ng nhap
            HSSFCellStyle styleName = workbook.createCellStyle(); // Style cho Title
            styleName.setAlignment(HorizontalAlignment.LEFT);
            styleName.setVerticalAlignment(VerticalAlignment.CENTER);

            Row rowNhap = sheet.createRow(3);
            rowNhap.setHeight((short) 600);
            HSSFCell cellNhap = (HSSFCell) rowNhap.createCell(1);
            cellNhap.setCellValue("Người Lập Đơn: Lê Việt Hưng");
            cellNhap.setCellStyle(styleName);
            CellRangeAddress cellRangeAddress1 = new CellRangeAddress(3, 3, 1, 3);
            rowNhap.getSheet().addMergedRegion(cellRangeAddress1);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, cellRangeAddress1, sheet);
            RegionUtil.setBorderBottom(BorderStyle.DOUBLE, cellRangeAddress1, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, cellRangeAddress1, sheet);
            RegionUtil.setBorderRight(BorderStyle.DOUBLE, cellRangeAddress1, sheet);

            /// Style for Data
            HSSFCellStyle style = workbook.createCellStyle(); // Style cho Title
            style.setBorderTop(BorderStyle.THIN);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setVerticalAlignment(VerticalAlignment.CENTER);

            Row row = sheet.createRow(5);
            row.setHeight((short) 400);
            HSSFCell cell1 = (HSSFCell) row.createCell(1, CellType.NUMERIC);
            cell1.setCellValue("STT");
            cell1.setCellStyle(style);
            HSSFCell cell2 = (HSSFCell) row.createCell(2, CellType.STRING);
            cell2.setCellValue("Mã Đơn");
            cell2.setCellStyle(style);
            HSSFCell cell3 = (HSSFCell) row.createCell(3, CellType.STRING);
            cell3.setCellValue("Ngày Tạo Đơn");
            cell3.setCellStyle(style);
            HSSFCell cell4 = (HSSFCell) row.createCell(4, CellType.STRING);
            cell4.setCellValue("Trạng Thái");
            cell4.setCellStyle(style);
            HSSFCell cell5 = (HSSFCell) row.createCell(5, CellType.STRING);
            cell5.setCellValue("Mã Sản Phẩm");
            cell5.setCellStyle(style);
            HSSFCell cell6 = (HSSFCell) row.createCell(6, CellType.STRING);
            cell6.setCellValue("Tên Sản Phẩm");
            cell6.setCellStyle(style);
            HSSFCell cell7 = (HSSFCell) row.createCell(7, CellType.STRING);
            cell7.setCellValue("Số Lượng");
            cell7.setCellStyle(style);
            HSSFCell cell8 = (HSSFCell) row.createCell(8, CellType.STRING);
            cell8.setCellValue("Mã Tag");
            cell8.setCellStyle(style);
            HSSFCell cell9 = (HSSFCell) row.createCell(9, CellType.STRING);
            cell9.setCellValue("Cổng Xuất");
            cell9.setCellStyle(style);
            HSSFCell cell10 = (HSSFCell) row.createCell(10, CellType.STRING);
            cell10.setCellValue("Ngày Xuất");
            cell10.setCellStyle(style);

            for (int i = 1; i <= 10; ++i)
            {

                if (i == 6)
                {
                    sheet.setColumnWidth(i, 25 * 256);
                } else
                {
                    sheet.setColumnWidth(i, 25 * 150);
                }
            }

            
            // truyen dl cho row
            int count = 0, rowPrint = 6;
            String x = "";
            for (String k : a)
            {
//                if (x.equals(k)) {
//                    count++;
//                } else {
//                    x = k;
//                    count = 1;
//                }
                Row rowData = sheet.createRow(rowPrint);
                rowData.setHeight((short) 400);
                for (int j = 1; j <= 10; ++j)
                {
                    HSSFCell cellData = (HSSFCell) rowData.createCell(j);   
                }
                rowPrint++;
            }
//
//            for (int i = 0; i < 10; ++i)
//            {
//                rownum++;
//                row = sheet.createRow(rownum);
//                //Gọi các chi tiết khác từ class NhanVienBUS
////                NhanVienBUS nvBUS = new NhanVienBUS();
////                String hoNV = nvBUS.Timphantucot(String.valueOf(nv.getManhanvien()), 2);
////                String tenNV = nvBUS.Timphantucot(String.valueOf(nv.getManhanvien()), 3);
////                //
//                row.createCell(1, CellType.NUMERIC).setCellValue(i);
////                row.createCell(1, CellType.STRING).setCellValue(nv.getManhanvien());
////                row.createCell(2, CellType.STRING).setCellValue(hoNV);
////                row.createCell(3, CellType.STRING).setCellValue(tenNV);
////                row.createCell(4, CellType.STRING).setCellValue(String.valueOf(nv.getNgaysinh()));
////                row.createCell(5, CellType.STRING).setCellValue(nv.getGioitinh());
////                row.createCell(6, CellType.STRING).setCellValue(nv.getDiachi());
////                row.createCell(7, CellType.STRING).setCellValue(nv.getSodienthoai());
//            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally
        {
            try
            {
                if (outFile != null)
                {
                    outFile.close();
                    System.exit(0);
                }
            } catch (IOException ex)
            {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args)
    {
        XuatExcel xe = new XuatExcel();
        ArrayList<String> a = new ArrayList<>();
        a.add("1");
        a.add("1");
        a.add("1");
        a.add("2");
        a.add("2");
        a.add("3");
        xe.xuatFileExcelDonHang(a);
    }
}
