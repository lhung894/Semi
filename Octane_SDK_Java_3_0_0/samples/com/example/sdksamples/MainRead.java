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

//    @Override
//    public void onTagReported(ImpinjReader reader, TagReport tr)
//    {
//        tr.getTags().forEach(tag -> System.out.println("> " + tag.getEpc()));
//    }
    @Override
    public void onTagReported(ImpinjReader reader, TagReport tr)
    {
        List<Tag> tags = tr.getTags();
//        Set<String> epcSet = new HashSet<>();
        for (Tag t : tags)
        {
//            System.out.println("dl l?y dc la" + t.getEpc().toString());
//            epcSet.add(t.getEpc().toString());

            if (tagMap.put(t.getEpc().toString(), t) == null)
            {
                System.out.println("ok??????????????????????????");
                inputForm.initTagAuto();
//                try
//                {
//                    wait(2000);
//                } catch (InterruptedException ex)
//                {
//                    Logger.getLogger(MainRead.class.getName()).log(Level.SEVERE, null, ex);
//                }

            }
//            System.out.println("epc: " + t.getEpc().toString());
        }

//        if ()
    }

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
