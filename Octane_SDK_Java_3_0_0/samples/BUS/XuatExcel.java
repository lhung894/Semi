package BUS;
//
//import BUS.NhanVienBUS;
//import BUS.PhongBanBUS;
//import DTO.ChiTietNhanVienDTO;
//import DTO.NhanVienDTO;
//import DTO.PhongBanDTO;

import DTO.BaoCaoDTO;
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

public class XuatExcel {

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile() {
        fd.setFile("donxuat.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }

    // Xuất file Excel 
    @SuppressWarnings("empty-statement")
    public void xuatFileExcelDonHang(ArrayList<BaoCaoDTO> baoCaoDTOs) {
        fd.setTitle("Xuất đơn hàng ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
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
            CellRangeAddress cellRangeAddress = new CellRangeAddress(1, 1, 1, 9);
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
            HSSFCell cell2 = (HSSFCell) row.createCell(1, CellType.STRING);
            cell2.setCellValue("Mã Đơn");
            cell2.setCellStyle(style);
            HSSFCell cell3 = (HSSFCell) row.createCell(2, CellType.STRING);
            cell3.setCellValue("Ngày Tạo Đơn");
            cell3.setCellStyle(style);
            HSSFCell cell4 = (HSSFCell) row.createCell(3, CellType.STRING);
            cell4.setCellValue("Trạng Thái");
            cell4.setCellStyle(style);
            HSSFCell cell5 = (HSSFCell) row.createCell(4, CellType.STRING);
            cell5.setCellValue("Mã Sản Phẩm");
            cell5.setCellStyle(style);
            HSSFCell cell6 = (HSSFCell) row.createCell(5, CellType.STRING);
            cell6.setCellValue("Tên Sản Phẩm");
            cell6.setCellStyle(style);
            HSSFCell cell7 = (HSSFCell) row.createCell(6, CellType.STRING);
            cell7.setCellValue("Số Lượng");
            cell7.setCellStyle(style);
            HSSFCell cell8 = (HSSFCell) row.createCell(7, CellType.STRING);
            cell8.setCellValue("Mã Tag");
            cell8.setCellStyle(style);
            HSSFCell cell9 = (HSSFCell) row.createCell(8, CellType.STRING);
            cell9.setCellValue("Cổng Xuất");
            cell9.setCellStyle(style);
            HSSFCell cell10 = (HSSFCell) row.createCell(9, CellType.STRING);
            cell10.setCellValue("Ngày Xuất");
            cell10.setCellStyle(style);

            for (int i = 1; i <= 10; ++i) {

                if (i == 5 || i == 2 || i == 9) {
                    sheet.setColumnWidth(i, 25 * 256);
                } else if (i == 7) {
                    sheet.setColumnWidth(i, 25 * 350);
                } else {
                    sheet.setColumnWidth(i, 25 * 150);
                }
            }

            // truyen dl cho row
            int rowPrint = 6, beginOrder = 6, endOrder = 6, beginProduct = 6, endProduct = 6;
            String orderId = "", productId = "";
            for (BaoCaoDTO k : baoCaoDTOs)//row
            {
                Row rowData = sheet.createRow(rowPrint);
                rowData.setHeight((short) 400);
                if (!orderId.equals(k.getOrder_id())) {
                    orderId = k.getOrder_id();
                    if (endOrder > beginOrder) {
                        for (int u = 1; u <= 3; u++) {
                            CellRangeAddress cellRangeAddress2 = new CellRangeAddress(beginOrder, endOrder, u, u);
                            rowData.getSheet().addMergedRegion(cellRangeAddress2);
                        }
                    }
                    beginOrder = rowPrint;
                } else {
                    endOrder = rowPrint;
                }
                if (orderId.equals(k.getOrder_id()) && !productId.equals(k.getProduct_id())
                        || !orderId.equals(k.getOrder_id()) && !productId.equals(k.getProduct_id())) {
                    productId = k.getProduct_id();
                    if (endProduct > beginProduct) {
                        for (int u = 4; u <= 6; u++) {
                            CellRangeAddress cellRangeAddress3 = new CellRangeAddress(beginProduct, endProduct, u, u);
                            rowData.getSheet().addMergedRegion(cellRangeAddress3);
                        }
                    }
                    beginProduct = rowPrint;
                } else if (orderId.equals(k.getOrder_id()) && productId.equals(k.getProduct_id())) {
                    endProduct = rowPrint;
                } else if (!orderId.equals(k.getOrder_id()) && productId.equals(k.getProduct_id())) {
                    beginProduct = rowPrint;
                }
                for (int j = 1; j <= 9; ++j)//column
                {
                    HSSFCell cellData = (HSSFCell) rowData.createCell(j);
                    cellData.setCellStyle(style);
                    if (j == 1) {
                        cellData.setCellValue(k.getOrder_id());
                        cellData.setCellStyle(style);
                    } else if (j == 2) {
                        cellData.setCellValue(k.getOrder_date());
                        cellData.setCellStyle(style);
                    } else if (j == 3) {
                        if (k.getStatus() == 2) {
                            cellData.setCellValue("Chờ xuất");
                        } else {
                            cellData.setCellValue("Hoàn tất");
                        }
                        cellData.setCellStyle(style);
                    } else if (j == 4) {
                        cellData.setCellValue(k.getProduct_id());
                        cellData.setCellStyle(style);
                    } else if (j == 5) {
                        cellData.setCellValue(k.getProduct_name());
                        cellData.setCellStyle(style);
                    } else if (j == 6) {
                        cellData.setCellValue(k.getOrder_quantity());
                        cellData.setCellStyle(style);
                    } else if (j == 7) {
                        cellData.setCellValue(k.getTag_id());
                        cellData.setCellStyle(style);
                    } else if (j == 8) {
                        cellData.setCellValue(k.getTag_gate_out());
                        cellData.setCellStyle(style);
                    } else if (j == 9) {
                        cellData.setCellValue(k.getTag_date_out());
                        cellData.setCellStyle(style);
                    }
                }
                if (rowPrint - 5 == baoCaoDTOs.size()) {
                    if (endOrder > beginOrder) {
                        for (int u = 1; u <= 3; u++) {
                            CellRangeAddress cellRangeAddress4 = new CellRangeAddress(beginOrder, endOrder, u, u);
                            rowData.getSheet().addMergedRegion(cellRangeAddress4);
                        }
                    }
                    if (endProduct > beginProduct) {
                        for (int u = 4; u <= 6; u++) {
                            CellRangeAddress cellRangeAddress5 = new CellRangeAddress(beginProduct, endProduct, u, u);
                            rowData.getSheet().addMergedRegion(cellRangeAddress5);
                        }
                    }
                }
                rowPrint++;
            }
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
//                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
