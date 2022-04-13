/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdksamples;

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
    boolean flag = false;
    NhapDlForm inputForm;

    @Override
    public void onTagReported(ImpinjReader reader, TagReport tr)
    {
        List<Tag> tags = tr.getTags();
//        Set<String> epcSet = new HashSet<>();
        for (Tag t : tags)
        {
            if (tagMap.put(t.getEpc().toString(), t) == null)
            {
                System.out.println("ok??????????????????????????"); //ch?nh
                inputForm.initTagAuto();

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
        List<String> tagsString = new ArrayList<String>();
        tagsString.add("abc");
        tagsString.add("abc");
        tagsString.add("def");
        tagsString.add("abc");
        tagsString.add("def");
        tagsString.add("mno");
        tagsString.add("klj");
        tagsString.add("mno");
        tagsString.add("abc");
        Set<String> temp = new HashSet<String>(tagsString);
        NhapDlForm test = new NhapDlForm(temp);
        System.out.println("ok");
    }

    public static HashMap<String, Tag> getTagMap()
    {
        return tagMap;
    }

    public static void setTagMap(HashMap<String, Tag> tagMap)
    {
        MainRead.tagMap = tagMap;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public NhapDlForm getInputForm()
    {
        return inputForm;
    }

    public void setInputForm(NhapDlForm inputForm)
    {
        this.inputForm = inputForm;
    }

}
