/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdksamples;

import BUS.Utils;
import DTO.TagDTO;
import GUI.DanhSachXuatForm;
import GUI.Dashboard;
import GUI.NhapDlForm;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hyung
 */
public class MainRead implements TagReportListener
{

    public static HashMap<String, Tag> tagMap = new HashMap<>();
    public static int flag = 0;
    public static ArrayList<TagDTO> tagDTOsMR = new ArrayList<>();
    NhapDlForm inputForm;
    public static DanhSachXuatForm outputForm;
    TagDTO tagDTO;
    Utils ult = new Utils();

    @Override
    public void onTagReported(ImpinjReader reader, TagReport tr)
    {
        if (flag == 1)
        {
            List<Tag> tags = tr.getTags();
            for (Tag t : tags)
            {
                if (tagMap.put(t.getEpc().toString(), t) == null)
                {
                    tagDTO = new TagDTO();
                    tagDTO.setTagId(t.getEpc().toString());
//                    if (reader.getName() != null) {
//                        tagDTO.setTagGateIn(reader.getName());
//                    } else {
//                        tagDTO.setTagGateIn(reader.getAddress());
//                    }
                    tagDTO.setTagGateIn(String.valueOf(t.getAntennaPortNumber()));
//                    System.out.println("name: " + tagDTO.getTagGateIn());
                    tagDTO.setTagDateIn(ult.initDateNow());
                    inputForm.tagDTOs.add(tagDTO);
                    System.out.println("ok??????????????????????????");
                    inputForm.initTagAuto();
                }
            }
        } else if (flag == 2)
        {
            List<Tag> tags = tr.getTags();
            for (Tag t : tags)
            {
                if (tagMap.put(t.getEpc().toString(), t) == null)
                {
                    tagDTO = new TagDTO();
                    tagDTO.setTagId(t.getEpc().toString());
//                    if (reader.getName() != null) {
//                        tagDTO.setTagGateOut(reader.getName());
//                    } else {
//                        tagDTO.setTagGateOut(reader.getAddress());
//                    }
                    tagDTO.setTagGateOut(String.valueOf(t.getAntennaPortNumber()));
                    tagDTO.setTagDateOut(ult.initDateNow());
                    for (TagDTO dto : tagDTOsMR)
                    {
                        if (dto.getTagId().equals(tagDTO.getTagId()))
                        {
                            tagDTO.setProductId(dto.getProductId());
                            break;
                        }
                    }
                    outputForm.tagDTOs.add(tagDTO);
                    if (outputForm.detailScan.containsKey(tagDTO.getProductId()))
                    {
                        outputForm.detailScan.put(tagDTO.getProductId(), outputForm.detailScan.get(tagDTO.getProductId()) + 1);
                    } else
                    {
                        outputForm.detailScan.put(tagDTO.getProductId(), 1);
                    }
                    outputForm.checkScan(tagDTO.getProductId());
                    System.out.println("ok??????????????????????????");
//                    outputForm.initTagAuto();
                }
            }
        }
    }

//tag: 3500 0000 1000 0010 0000 1759
//tag: 00B0 7A14 2C2B 2848 0800 0166
//tag: 35E0 1700 4FF4 3406 0000 0673
//tag: 300F 4F57 3AD0 01C0 8369 A28F
//tag: 3008 33B2 DDD9 0140 0000 0009
//tag: 3500 0000 1000 0010 0000 1476
//tag: 0000 0000 0000 0000 0000 1314
//tag: 300F 4F57 3AD0 01C0 8369 A241
//tag: 300F 4F57 3AD0 01C0 8369 A230
//tag: 3039 6062 83B9 5D80 0012 9F61
//tag: 300F 4F57 3AD0 01C0 8369 A245
//tag: 3008 33B2 DDD9 06C0 0000 0000
//tag: 300F 4F57 3AD0 01C0 8369 A249
//tag: 3008 33B2 DDD9 0140 0000 002D
    public static void main(String[] args)
    {
//        List<String> tagsString = new ArrayList<String>();
//        tagsString.add("3500 0000 1000 0010 0000 1759");
//        tagsString.add("00B0 7A14 2C2B 2848 0800 0166");
//        tagsString.add("35E0 1700 4FF4 3406 0000 0673");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A28F");
//        tagsString.add("3008 33B2 DDD9 0140 0000 0009");
//        tagsString.add("3008 33B2 DDD9 0140 0000 0009");
//        tagsString.add("3008 33B2 DDD9 0140 0000 0009");
//        tagsString.add("3500 0000 1000 0010 0000 1476");
//        tagsString.add("0000 0000 0000 0000 0000 1314");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A241");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A230");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A230");
//        tagsString.add("3039 6062 83B9 5D80 0012 9F61");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A245");
//        tagsString.add("3008 33B2 DDD9 06C0 0000 0000");
//        tagsString.add("300F 4F57 3AD0 01C0 8369 A249");
//        tagsString.add("3008 33B2 DDD9 0140 0000 002D");
//        Set<String> temp = new HashSet<String>(tagsString);
//        NhapDlForm test = new NhapDlForm(temp);
//        System.out.println("ok");

//        HashMap<String, Integer> h = new HashMap<>();
//        for (String s : tagsString) {
//            if (h.containsKey(s)) {
//                h.put(s, h.get(s) + 1);
//            } else {
//                h.put(s, 1);
//            }
//        }
//        System.out.println("h: " + h);
        MainRead mread = new MainRead();
        Dashboard d = new Dashboard();
        mread.setInputForm(d.getInputTag());
        mread.setOutputForm(d.getListOrder());
    }

    public static void thucThi()
    {
        TagDTO test = new TagDTO();
        test.setTagId("abc");
        for (TagDTO dto : tagDTOsMR)
        {
            if (dto.getTagId().equals(test.getTagId()))
            {
                test.setProductId(dto.getProductId());
                break;
            }
        }
        outputForm.tagDTOs.add(test);
        if (outputForm.detailScan.containsKey(test.getProductId()))
        {
            outputForm.detailScan.put(test.getProductId(), outputForm.detailScan.get(test.getProductId()) + 1);
        } else
        {
            outputForm.detailScan.put(test.getProductId(), 1);
        }
        outputForm.checkScan(test.getProductId());
        test = new TagDTO();
        test.setTagId("def");
        for (TagDTO dto : tagDTOsMR)
        {
            if (dto.getTagId().equals(test.getTagId()))
            {
                test.setProductId(dto.getProductId());
                break;
            }
        }
        outputForm.tagDTOs.add(test);
        if (outputForm.detailScan.containsKey(test.getProductId()))
        {
            outputForm.detailScan.put(test.getProductId(), outputForm.detailScan.get(test.getProductId()) + 1);
        } else
        {
            outputForm.detailScan.put(test.getProductId(), 1);
        }
        outputForm.checkScan(test.getProductId());
    }

    public static HashMap<String, Tag> getTagMap()
    {
        return tagMap;
    }

    public static void setTagMap(HashMap<String, Tag> tagMap)
    {
        MainRead.tagMap = tagMap;
    }

    public static int getFlag()
    {
        return flag;
    }

    public static void setFlag(int flag)
    {
        MainRead.flag = flag;
    }

    public NhapDlForm getInputForm()
    {
        return inputForm;
    }

    public void setInputForm(NhapDlForm inputForm)
    {
        this.inputForm = inputForm;
    }

    public DanhSachXuatForm getOutputForm()
    {
        return outputForm;
    }

    public void setOutputForm(DanhSachXuatForm outputForm)
    {
        this.outputForm = outputForm;
    }

}
