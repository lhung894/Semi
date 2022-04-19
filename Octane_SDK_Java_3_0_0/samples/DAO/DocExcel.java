//package DAO;
//
////import BUS.BangPhongBanBUS;
////import BUS.ChiTietNhanVienBUS;
////import BUS.DangNhapHienHanh;
////import BUS.PhongBanBUS;
////import DTO.ChiTietNhanVienDTO;
////import DTO.NhanVienDTO;
////import DTO.PhongBanDTO;
//import java.awt.FileDialog;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.Iterator;
//import java.util.Vector;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
//public class DocExcel
//{
//
//    FileDialog fd = new FileDialog(new JFrame(), "Đọc excel", FileDialog.LOAD);
//    DefaultTableModel modelpb = new DefaultTableModel();
////    public DangNhapHienHanh dnhh = new DangNhapHienHanh();
//
//    public DocExcel()
//    {
//
//    }
//
//    private String getFile()
//    {
//        fd.setFile("*.xls");
//        fd.setVisible(true);
//        String url = fd.getDirectory() + fd.getFile();
//        if (url.equals("nullnull"))
//        {
//            return null;
//        }
//        return url;
//    }
//
//    //Đọc file excel Phòng Ban
//    public void docFileExcelPhongBan()
//    {
//        fd.setTitle("Nhập dữ liệu nhân viên từ excel");
//        String url = getFile();
//        if (url == null)
//        {
//            return;
//        }
//
//        FileInputStream inputStream = null;
//        try
//        {
//            inputStream = new FileInputStream(new File(url));
//
//            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Iterator<Row> rowIterator = sheet.iterator();
//            Row row1 = rowIterator.next();
////            sheet.getRow(0).getCell(0).getString
//            while (rowIterator.hasNext())
//            {
//                Row row = rowIterator.next();
////                System.out.println(row);
//                Iterator<Cell> cellIterator = row.cellIterator();
////                System.out.println(cellIterator);
//
//                while (cellIterator.hasNext())
//                {
//                    String ma = cellIterator.next().getStringCellValue();//cellIterator.next().getStringCellValue();
//                    System.out.println(ma);
//                    String ten = cellIterator.next().getStringCellValue();
//                    System.out.println(ten);
//                    double sdt = cellIterator.next().getNumericCellValue();
//                    System.out.println(sdt);
//                    String sdttemp = String.valueOf(sdt);
//                    PhongBanBUS pbBUS = new PhongBanBUS();
//                    pbBUS.insert(ma, ten, sdttemp);
//
//                    int temp = Integer.parseInt(ma.substring(2, ma.length()));
//                    int tempData = Integer.parseInt(dnhh.getPBLastinsert().substring(2, dnhh.getPBLastinsert().length()));
//                    if (temp > tempData)
//                    {
//                        dnhh.updatePB(ma);
//                    }
//                    System.out.println("Done");
//                }
//            }
//            JOptionPane.showMessageDialog(null, "Thêm thành công!");
//        } catch (Exception ex)
//        {
//            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
//        } finally
//        {
//            try
//            {
//                if (inputStream != null)
//                {
//                    inputStream.close();
//                }
//            } catch (IOException ex)
//            {
//                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
//            }
//        }
//    }
//}
