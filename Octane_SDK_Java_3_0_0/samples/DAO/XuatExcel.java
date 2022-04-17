package DAO;
//
//import BUS.NhanVienBUS;
//import BUS.PhongBanBUS;
//import DTO.ChiTietNhanVienDTO;
//import DTO.NhanVienDTO;
//import DTO.PhongBanDTO;

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
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class XuatExcel
{

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);
//    NhanVienDTO ctnv = new NhanVienDTO();

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
    public void xuatFileExcelNhanVien()
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
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Đơn Hàng");//Tên sheet
//
//            ChiTietNhanVienDAO qlnv = new ChiTietNhanVienDAO();
//            ArrayList<ChiTietNhanVienDTO> list = qlnv.getDsctnv();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Họ nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(4, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(5, CellType.STRING).setCellValue("Giới tính");
            row.createCell(6, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(7, CellType.STRING).setCellValue("Số điện thoại");
//
//            for (ChiTietNhanVienDTO nv : list)
//            {
//                rownum++;
//                row = sheet.createRow(rownum);
//                //Gọi các chi tiết khác từ class NhanVienBUS
//                NhanVienBUS nvBUS = new NhanVienBUS();
//                String hoNV = nvBUS.Timphantucot(String.valueOf(nv.getManhanvien()), 2);
//                String tenNV = nvBUS.Timphantucot(String.valueOf(nv.getManhanvien()), 3);
//                //
//                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
//                row.createCell(1, CellType.STRING).setCellValue(nv.getManhanvien());
//                row.createCell(2, CellType.STRING).setCellValue(hoNV);
//                row.createCell(3, CellType.STRING).setCellValue(tenNV);
//                row.createCell(4, CellType.STRING).setCellValue(String.valueOf(nv.getNgaysinh()));
//                row.createCell(5, CellType.STRING).setCellValue(nv.getGioitinh());
//                row.createCell(6, CellType.STRING).setCellValue(nv.getDiachi());
//                row.createCell(7, CellType.STRING).setCellValue(nv.getSodienthoai());
//            }
            for (int i = 0; i < rownum; i++)
            {
                sheet.autoSizeColumn(i);
            }

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
                }
            } catch (IOException ex)
            {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Phòng Ban
    public void xuatFileExcelPhongBan()
    {
        fd.setTitle("Xuất dữ liệu danh sách phòng ban ra excel");
        String url = getFile();
        if (url == null)
        {
            return;
        }

        FileOutputStream outFile = null;
        try
        {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Phòng Ban");//Tên sheet

//            PhongBanDAO qlpb = new PhongBanDAO();
//            ArrayList<PhongBanDTO> list = qlpb.getDspb();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã phòng ban");
            row.createCell(2, CellType.STRING).setCellValue("Tên phòng ban");
            row.createCell(3, CellType.STRING).setCellValue("Sđt phòng ban");

//            for (PhongBanDTO pb : list)
//            {
//                rownum++;
//                row = sheet.createRow(rownum);
//                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
//                row.createCell(1, CellType.STRING).setCellValue(pb.getMaphongban());
//                row.createCell(2, CellType.STRING).setCellValue(pb.getTenphongban());
//                row.createCell(3, CellType.STRING).setCellValue(pb.getSdtphongban());
//            }
            for (int i = 0; i < rownum; i++)
            {
                sheet.autoSizeColumn(i);
            }

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
                }
            } catch (IOException ex)
            {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//    private String getTime() {
//        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//    }
}
