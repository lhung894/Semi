package com.example.sdksamples;

import GUI.NhapDlForm;
import com.impinj.octane.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Scanner;
import java.util.Set;

public class ReadTags
{

    public static void main(String[] args)
    {

        try
        {
//            String hostname = System.getProperty(SampleProperties.hostname);
            String hostname = "169.254.153.74";

            if (hostname == null)
            {
                throw new Exception("Must specify the '"
                        + SampleProperties.hostname + "' property");
            }

            ImpinjReader reader = new ImpinjReader();

            System.out.println("Connecting");
            reader.connect(hostname);

            Settings settings = reader.queryDefaultSettings();

            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(true);
            report.setMode(ReportMode.Individual);

            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments.
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader's configuration
            settings.setReaderMode(ReaderMode.AutoSetDenseReader);

            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            antennas.disableAll();
            antennas.enableById(new short[]
            {
                1
            });
            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
            antennas.getAntenna((short) 1).setTxPowerinDbm(30.0);
            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);

//            reader.setTagReportListener(new Vd());
            reader.setTagReportListener(new MyTagReportListener());

            System.out.println("Applying Settings");
            reader.applySettings(settings);

            System.out.println("Starting");
            reader.start();

            System.out.println("Press Enter to exit.");
            Scanner s = new Scanner(System.in);
            s.nextLine();

            reader.stop();
            reader.disconnect();
        } catch (OctaneSdkException ex)
        {
            System.out.println(ex.getMessage());
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}

//class Vd implements TagReportListener
//{
//
//    @Override
//    public void onTagReported(ImpinjReader reader, TagReport tr)
//    {
//        List<Tag> tags = tr.getTags();
//        for (Tag t : tags)
//        {
//            System.out.print(" EPC: " + t.getEpc().toString());
//        }
//    }
//
//}
class MyTagReportListener implements TagReportListener
{

    boolean flag = false;
//    @Override
//    public void onTagReported(ImpinjReader reader, TagReport tr)
//    {
//        tr.getTags().forEach(tag -> System.out.println("> " + tag.getEpc()));
//    }

    @Override
    public void onTagReported(ImpinjReader reader, TagReport tr)
    {
        List<Tag> tags = tr.getTags();
        Set<String> epcSet = new HashSet<>();
        for (Tag t : tags)
        {
            System.out.println("dl l?y dc la" + t.getEpc().toString());
            epcSet.add(t.getEpc().toString());
        }

        for (String epcString : epcSet)
        {
            if (!flag)
            {

            }
        }
    }

    public static void main(String[] args)
    {
        List<Integer> tagsIntegers = new ArrayList<Integer>();
        tagsIntegers.add(1);
        tagsIntegers.add(1);
        tagsIntegers.add(1);
        tagsIntegers.add(1);
        tagsIntegers.add(2);
        tagsIntegers.add(2);
        tagsIntegers.add(3);
        tagsIntegers.add(4);
        tagsIntegers.add(1);
        tagsIntegers.add(5);
        tagsIntegers.add(6);
        tagsIntegers.add(3);
        tagsIntegers.add(7);
        Set<Integer> temp = new HashSet<Integer>(tagsIntegers);

        for (Integer t : temp)
        {
//            if (!flag)
//            {
//                System.out.print(" EPC: " + t.getEpc().toString());
//                flag = true;
//
//            }
            System.out.println("t là " + t);
        }
        NhapDlForm test = new NhapDlForm();
        System.out.println("dsdsdsd");
    }
}
