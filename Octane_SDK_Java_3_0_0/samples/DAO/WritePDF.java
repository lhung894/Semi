/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

//import DTO.NhanVienDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author nguye
 */
public class WritePDF
{

    Document document;
    FileOutputStream file;
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    FileDialog fd = new FileDialog(new JFrame(), "Xuất pdf", FileDialog.SAVE);

    public WritePDF()
    {
        try
        {
            fontData = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException ex)
        {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url)
    {
        try
        {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Khong tim thay duong dan file " + url);
        } catch (DocumentException ex)
        {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    public void setTitle(String title)
    {
        try
        {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex)
        {
            ex.printStackTrace();
        }
    }

    public void writeObject(String[] data)
    {
        Paragraph pdfData = new Paragraph();
        for (int i = 0; i < data.length; i++)
        {
            pdfData.add(data[i] + "  ");
        }
        try
        {
            document.add(pdfData);
        } catch (DocumentException ex)
        {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeTable(JTable _table)
    {
        PdfPTable pdfTable = new PdfPTable(_table.getColumnCount());
        for (int i = 0; i < _table.getRowCount(); i++)
        {
            for (int j = 0; j < _table.getColumnCount(); j++)
            {
                String data = String.valueOf(_table.getValueAt(i, j));
                PdfPCell cell = new PdfPCell(new Phrase(data, fontData));
                pdfTable.addCell(cell);
            }
        }
        try
        {
            document.add(pdfTable);
        } catch (DocumentException ex)
        {
            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
        }
    }

    private String getFile()
    {
        fd.setFile("untitled.pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull"))
        {
            return null;
        }
        return url;
    }

    public void writeDSPhongBan(String mapb, String tenpb, String sdtpb)
    {
        String url = "";
        try
        {
            fd.setTitle("In danh sách nhân viên");
            url = getFile();
            if (url == null)
            {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("Danh sách nhân viên");

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph paraMaPb = new Paragraph(new Phrase("Mã phòng ban: " + mapb, fontData));
            Paragraph paraTenPb = new Paragraph(new Phrase("Tên phòng ban: " + tenpb, fontData));
            Paragraph paraSđtPb = new Paragraph(new Phrase("Số điện thoại phòng ban: " + sdtpb, fontData));

            document.add(paraMaPb);
            document.add(paraTenPb);
            document.add(paraSđtPb);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table
            PdfPTable pdfTable = new PdfPTable(3);

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Mã nhân viên", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Họ nhân viên", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Tên nhân viên", fontHeader)));

            for (int i = 0; i < 3; i++)
            {
                pdfTable.addCell(new PdfPCell(new Phrase("")));
            }
//            ChiTietNhanVienDAO qlnv = new ChiTietNhanVienDAO();
//            ArrayList<ChiTietNhanVienDTO> list = qlnv.getDsctnv();
            //Truyen thong tin tung chi tiet vao table
//            NhanVienDAO dsnv = new NhanVienDAO();
//            ArrayList<NhanVienDTO> list = dsnv.getDsnv();
//            for (NhanVienDTO i : list)
//            {
//                if (i.getMaphongban().equals(mapb))
//                {
//                    String ma = i.getManhanvien();
//                    String ho = i.getHonhanvien();
//                    String ten = i.getTennhanvien();
//
//                    pdfTable.addCell(new PdfPCell(new Phrase(ma, fontData)));
//                    pdfTable.addCell(new PdfPCell(new Phrase(ho, fontData)));
//                    pdfTable.addCell(new PdfPCell(new Phrase(ten, fontData)));
//                }
//            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            document.close();

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + url);

        } catch (DocumentException | FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

    public void closeFile()
    {
        document.close();
    }
}
