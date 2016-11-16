package com.chemplace.view.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;

import com.chemplace.view.model.beans.AcidInjectionTbl;
import com.chemplace.view.model.beans.AdditionalInpuDataTbl;
import com.chemplace.view.model.beans.FluidPropertiesTbl;
import com.chemplace.view.model.beans.ProjectTbl;
import com.chemplace.view.model.beans.ReservoirlethologyTbl;
import com.chemplace.view.model.beans.SensitivityAnalysisTbl;
import com.chemplace.view.model.beans.WelCompletionDataTbl;
import com.chemplace.view.model.beans.WellLayersStageTbl;

public class InputFile {
	
	
	
public void createTXTXLSFile(ProjectTbl projectdetail,WellLayersStageTbl wellLayersStageTbl1,List<ReservoirlethologyTbl> listdatareservoirlethology1, List<AcidInjectionTbl> listacidinjectiontable1,
			ArrayList<SensitivityAnalysisTbl> listsensitiveanalysistbl1,WelCompletionDataTbl welCompletionDataTbl1,FluidPropertiesTbl fluidPropertiesTbl1,AdditionalInpuDataTbl additionalInpuDataTbl1)
	{
		   WellLayersStageTbl wellLayersStageTbl= wellLayersStageTbl1;
		   List<ReservoirlethologyTbl> listdatareservoirlethology= listdatareservoirlethology1;
		   List<AcidInjectionTbl> listacidinjectiontable=listacidinjectiontable1; 
		   ArrayList<SensitivityAnalysisTbl> listsensitiveanalysistbl=listsensitiveanalysistbl1;  
		   WelCompletionDataTbl welCompletionDataTbl=welCompletionDataTbl1;
		   FluidPropertiesTbl fluidPropertiesTbl=fluidPropertiesTbl1; 
		   AdditionalInpuDataTbl additionalInpuDataTbl=additionalInpuDataTbl1;
	
		   List<String> data = new ArrayList<String>();
			  data.add("ProjectName="+projectdetail.getProjectName());
          data.add("WellName="+wellLayersStageTbl.getWellName());
          data.add("ChemicalName="+"");
          data.add("CompanyName="+projectdetail.getCompanyName());	
		 data.add("UserName="+projectdetail.getUserName());
          data.add("NoofLayers="+wellLayersStageTbl.getNoOfLayers());
          data.add("NOofStages="+wellLayersStageTbl.getNoOfStages());
			   data.add("WellType="+welCompletionDataTbl.getWellType());	
			   data.add("CompletionType="+welCompletionDataTbl.getCompletionType());
          data.add("WellDiaInch="+welCompletionDataTbl.getWellDiaInch());
          data.add("PerfDiaInch="+welCompletionDataTbl.getPerfDiaInch());
          data.add("WellMDFT="+welCompletionDataTbl.getWellMdFt());	
			   data.add("WellTVDFT="+welCompletionDataTbl.getWellTvdFt());
          data.add("LateralDefthFT="+welCompletionDataTbl.getLateralDefthFt());
          data.add("LateraDefthFT="+welCompletionDataTbl.getLateraDefthFt());
          
          for(int i=0; i<listdatareservoirlethology.size(); i++)
          {
          data.add("FormDefthFT"+i+"="+listdatareservoirlethology.get(i).getFormDefthFt());
          data.add("ToDefthFT"+i+"="+listdatareservoirlethology.get(i).getToDefthFt());
          data.add("TVDFT"+i+"="+listdatareservoirlethology.get(i).getTvdFt());
          data.add("PermMD"+i+"="+listdatareservoirlethology.get(i).getPermMd());
			  data.add("Poro"+i+"="+listdatareservoirlethology.get(i).getPoro());
          data.add("ZonePressPSI"+i+"="+listdatareservoirlethology.get(i).getZonePressPsi());
          data.add("PreStimSkin"+i+"="+listdatareservoirlethology.get(i).getPreStimSkin());
          data.add("FluidInPlace"+i+"="+listdatareservoirlethology.get(i).getFluidInPlace());
          }
          for(int i=0; i<listacidinjectiontable.size(); i++)
          {
          data.add("Stage"+i+"="+listacidinjectiontable.get(i).getStage());
    	  data.add("StavageVolBbls"+i+"="+listacidinjectiontable.get(i).getStavageVolBbls());
    	  data.add("Conc"+i+"="+ listacidinjectiontable.get(i).getConc());
    	  data.add("Vise"+i+"="+ listacidinjectiontable.get(i).getVise());
    	  data.add("PumpRateBMP"+i+"="+listacidinjectiontable.get(i).getPumpRateBmp());
    	  data.add("InjPressPSI"+i+"="+listacidinjectiontable.get(i).getInjPressPsi());
    	  data.add("InjDefthFT"+i+"="+listacidinjectiontable.get(i).getInjDefthFt());
    	  data.add("EntityFricLoss"+i+"="+listacidinjectiontable.get(i).getEntityFricLoss());
          }
          
          //fluid properties
   	      data.add("AcidDensityKGM3="+fluidPropertiesTbl.getAcidDensityKgM3());
   	      data.add("AcidDissolvingPower="+fluidPropertiesTbl.getAcidDissolvingPower());
   	      data.add("ResOilDensityKGM3="+fluidPropertiesTbl.getResOilDensityKgM3());
   	      data.add("ResOilVisCP="+fluidPropertiesTbl.getResOilVisCp());
   	      data.add("ResWaterDensityKGM3="+fluidPropertiesTbl.getResWaterDensityKgM3()); 
   	      data.add("ResWaterViscCP="+fluidPropertiesTbl.getResWaterViscCp());
   	      data.add("ResGasDensityKGM3="+fluidPropertiesTbl.getResGasDensityKgM3());
   	  	  data.add("ResGasVisCP="+fluidPropertiesTbl.getResGasVisCp());
   	  	 //additional data
   	  	  data.add("StimulationType="+additionalInpuDataTbl.getStimulationType());
   	  	  data.add("JetDiaInch="+additionalInpuDataTbl.getJetDiaInch());
   	  	  data.add("MaxPressPSI="+additionalInpuDataTbl.getMaxPressPsi());
   	  	  data.add("FracPressPSI="+additionalInpuDataTbl.getFracPressPsi()); 
   	  	  data.add("TubFrictionCoff="+additionalInpuDataTbl.getTubFrictionCoff());
   	  	  data.add("FormVolFactor="+additionalInpuDataTbl.getFormVolumeFactor());
   	  	  data.add("DriverterConstK="+additionalInpuDataTbl.getDriverterConstK());
   	  	  data.add("DiverterCosntN="+additionalInpuDataTbl.getDiverterCosntN());
   	  	    data.add("RockDensityKG="+additionalInpuDataTbl.getRockDensityKg());
   	  		 data.add("FracLenthInch="+additionalInpuDataTbl.getFracLenthInch()); 
   	  		 data.add("NoOfTimepsteps="+additionalInpuDataTbl.getNoOfTimepsteps());
   	  		  data.add("NoOfGrids="+additionalInpuDataTbl.getNoOfGrids());
   	  	     data.add("PostProdBbls="+additionalInpuDataTbl.getPostProdBbls());
   	  	    data.add("PostProdAtPressPSI="+additionalInpuDataTbl.getPostProdAtPressPsi() );
   	  		 data.add("FracAppertureFT="+additionalInpuDataTbl.getFracAppertureFt()); 
   	  		 data.add("FracLengthFT="+additionalInpuDataTbl.getFracLengthFt());
   	  	 for(int i=0; i<listsensitiveanalysistbl.size(); i++)
         {  
   	  	data.add("SensitivityAnalysisName_"+i+"="+listsensitiveanalysistbl.get(i).getSensitivityAnalysisName());
  	    data.add("Case1_"+i+"="+listsensitiveanalysistbl.get(i).getCase1());
  	    data.add("Case2_"+i+"="+listsensitiveanalysistbl.get(i).getCase2());
  	    data.add("Case3_"+i+"="+listsensitiveanalysistbl.get(i).getCase3());
         } 
   	  	 
   	  	 
   	  	 
   	  	 
   	  	 
   	  	 try
   	  	 {
   	      writeToFile(data, "Chapmlaceinput.txt");
   	  	 }
   	  	 catch(Exception e)
   	  	 {
   	  		e.printStackTrace(); 
   	  	 }
			  
   	  	 try
   	  	 {
   	  	String yemi = "test.xls";
	    FileOutputStream fileOut = new FileOutputStream(yemi);
	    
	    HSSFWorkbook workbook = new HSSFWorkbook();
	    HSSFSheet sheet = workbook.createSheet("Chemplace_Input");
  	 
	    
    
	 HSSFCellStyle style = workbook.createCellStyle();
  style.setBorderBottom((short) 1);
  style.setBorderTop((short) 1); 
  style.setBorderLeft((short) 1); 
  style.setBorderRight((short) 1);
  style.setAlignment(CellStyle.ALIGN_CENTER);
  style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
  
  
  HSSFFont font = workbook.createFont();
  font.setFontName(HSSFFont.FONT_ARIAL);
  font.setFontHeightInPoints((short) 10);
  font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
 // font.setColor(HSSFColor.BLUE.index);
  style.setFont(font);	    

  // We also define the font that we are going to use for displaying the
  // data of the cell. We set the font to ARIAL with 20pt in size and
  // make it BOLD and give blue as the color.
  
	 HSSFCellStyle style1 = workbook.createCellStyle();
  style1.setBorderBottom((short) 1);
  style1.setBorderTop((short) 1); 
  style1.setBorderLeft((short) 1); 
  style1.setBorderRight((short) 1);
  style1.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
           
  HSSFFont font1 = workbook.createFont();
  font1.setFontName(HSSFFont.FONT_ARIAL);
  font1.setFontHeightInPoints((short) 10);
  //font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
 // font.setColor(HSSFColor.BLUE.index);
  style1.setFont(font1);	    

  
  
  HSSFCellStyle style2 = workbook.createCellStyle();
 /* style2.setBorderBottom((short) 1);
  style2.setBorderTop((short) 1); 
  style2.setBorderLeft((short) 1); 
  style2.setBorderRight((short) 1);*/
  style2.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
  
  
  HSSFFont font2 = workbook.createFont();
  font2.setFontName(HSSFFont.FONT_ARIAL);
  font2.setFontHeightInPoints((short) 10);
  font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
 // font.setColor(HSSFColor.BLUE.index);
  style2.setFont(font2);	
  
  
  

  
  //Row create position 0
  HSSFRow row = sheet.createRow((short) 0);
  HSSFCell cell = row.createCell(0);
  cell.setCellValue(new HSSFRichTextString("Project Name:"));
  cell.setCellStyle(style2);   
  sheet.autoSizeColumn((short) 0);
  
  HSSFCell cell1 = row.createCell(1);
  cell1.setCellValue(projectdetail.getProjectName());
  //cell1.setCellStyle(style);        
  sheet.autoSizeColumn((short) 1);
  
   //Row Create position 1
	    HSSFRow row1 = sheet.createRow((short) 1);
	     HSSFCell cell11 = row1.createCell(0);
     cell11.setCellValue(new HSSFRichTextString("User Name:"));
     cell11.setCellStyle(style2);   
     sheet.autoSizeColumn((short) 0);
      HSSFCell cell12 = row1.createCell(1);
     cell12.setCellValue(projectdetail.getUserName());
     sheet.autoSizeColumn((short) 1);
	    
	    //row creation position 2
     HSSFRow row2 = sheet.createRow((short) 2);
	     HSSFCell cell21 = row2.createCell(0);
    cell21.setCellValue(new HSSFRichTextString("Company Name:"));
    cell21.setCellStyle(style2);   
    sheet.autoSizeColumn((short) 0);
     HSSFCell cell22 = row2.createCell(1);
    cell22.setCellValue(projectdetail.getCompanyName());
    sheet.autoSizeColumn((short) 1);
	    
  //create row position 3
     HSSFRow row3 = sheet.createRow((short) 3);
	    HSSFCell cell31 = row3.createCell(0);
    cell31.setCellValue(new HSSFRichTextString("Date:"));
    cell31.setCellStyle(style2);   
    sheet.autoSizeColumn((short) 0);
    HSSFCell cell32 = row3.createCell(1);
    //cell32.setCellValue(projectdetail.get(0).getCreateDate());
    sheet.autoSizeColumn((short) 1);
             
    //create row position 4
    HSSFRow row4 = sheet.createRow((short) 4);
    
              
 //create row position 5
    HSSFRow row5 = sheet.createRow((short) 5);
    HSSFCell cell51 = row5.createCell(0);
   cell51.setCellValue(new HSSFRichTextString("Reservoir Lithology"));
  sheet.addMergedRegion(CellRangeAddress.valueOf("A6:I6"));
    cell51.setCellStyle(style);   
   sheet.autoSizeColumn((short) 0);
   
   HSSFCell cell52 = row5.createCell(1);
   cell52.setCellValue("");
   cell52.setCellStyle(style); 
   sheet.autoSizeColumn((short) 1);
    
   HSSFCell cell53 = row5.createCell(2);
   cell53.setCellValue("");
   cell53.setCellStyle(style); 
   sheet.autoSizeColumn((short) 2);
   
   HSSFCell cell54 = row5.createCell(3);
   cell54.setCellValue("");
   cell54.setCellStyle(style); 
   sheet.autoSizeColumn((short) 3);
   
   HSSFCell cell55 = row5.createCell(4);
   cell52.setCellValue("");
   cell55.setCellStyle(style); 
   sheet.autoSizeColumn((short) 4);
   
   HSSFCell cell56 = row5.createCell(5);
   cell52.setCellValue("");
   cell56.setCellStyle(style); 
   sheet.autoSizeColumn((short) 5);
   
   HSSFCell cell57 = row5.createCell(6);
   cell57.setCellValue("");
   cell57.setCellStyle(style); 
   sheet.autoSizeColumn((short) 6);
   
   
   HSSFCell cell58 = row5.createCell(7);
   cell58.setCellValue("");
   cell58.setCellStyle(style); 
   sheet.autoSizeColumn((short) 7);
   
   HSSFCell cell59 = row5.createCell(8);
   cell59.setCellValue("");
   cell59.setCellStyle(style); 
   sheet.autoSizeColumn((short) 8);
   
  // for Acid Injection Plan
      HSSFCell cell511 = row5.createCell(10);
     cell511.setCellValue("Acid Injection Plan");
     sheet.addMergedRegion(CellRangeAddress.valueOf("K6:S6"));
     cell511.setCellStyle(style); 
     sheet.autoSizeColumn((short) 10);
   

     HSSFCell cell512 = row5.createCell(11);
    cell512.setCellValue("");
    cell512.setCellStyle(style); 
    sheet.autoSizeColumn((short) 11);
   
    HSSFCell cell513 = row5.createCell(12);
    cell513.setCellValue("");
    cell513.setCellStyle(style); 
    sheet.autoSizeColumn((short) 12);
    

    HSSFCell cell514 = row5.createCell(13);
    cell514.setCellValue("");
    cell514.setCellStyle(style); 
    sheet.autoSizeColumn((short) 13);
    

    HSSFCell cell515 = row5.createCell(14);
    cell515.setCellValue("");
    cell515.setCellStyle(style); 
    sheet.autoSizeColumn((short) 14);
    

    HSSFCell cell516 = row5.createCell(15);
    cell516.setCellValue("");
    cell516.setCellStyle(style); 
    sheet.autoSizeColumn((short) 15);
    

    HSSFCell cell517 = row5.createCell(16);
    cell517.setCellValue("");
    cell517.setCellStyle(style); 
    sheet.autoSizeColumn((short) 16);
    

    HSSFCell cell518 = row5.createCell(17);
    cell518.setCellValue("");
    cell518.setCellStyle(style); 
    sheet.autoSizeColumn((short) 17);
    

    HSSFCell cell519 = row5.createCell(18);
    cell519.setCellValue("");
    cell519.setCellStyle(style); 
    sheet.autoSizeColumn((short) 18);
               	   
 //create row position 6
   HSSFRow row6 = sheet.createRow((short) 6);
   HSSFCell cell60 = row6.createCell(0);
  cell60.setCellValue(new HSSFRichTextString("No."));
  cell60.setCellStyle(style);   
  sheet.autoSizeColumn((short) 0);
  
  HSSFCell cell61 = row6.createCell(1);
  cell61.setCellValue(new HSSFRichTextString("From (FT)"));
  cell61.setCellStyle(style);   
  sheet.autoSizeColumn((short) 1);
  
  HSSFCell cell62 = row6.createCell(2);
  cell62.setCellValue(new HSSFRichTextString("To (FT)"));
  cell62.setCellStyle(style);   
  sheet.autoSizeColumn((short) 2);
  
  HSSFCell cell63 = row6.createCell(3);
  cell63.setCellValue(new HSSFRichTextString("TVD (FT)"));
  cell63.setCellStyle(style);   
  sheet.autoSizeColumn((short) 3);
  
   HSSFCell cell64 = row6.createCell(4);
  cell64.setCellValue(new HSSFRichTextString("Perm (mD)"));
  cell64.setCellStyle(style);   
  sheet.autoSizeColumn((short) 4);

  HSSFCell cell65 = row6.createCell(5);
  cell65.setCellValue(new HSSFRichTextString("Poro (0-1)"));
  cell65.setCellStyle(style);   
  sheet.autoSizeColumn((short) 5);
  
  HSSFCell cell66 = row6.createCell(6);
  cell66.setCellValue(new HSSFRichTextString("Res. Press(Psi)"));
  cell66.setCellStyle(style);   
  sheet.autoSizeColumn((short) 6);
  
  HSSFCell cell67= row6.createCell(7);
  cell67.setCellValue(new HSSFRichTextString("Pre-Stim Skin"));
  cell67.setCellStyle(style);   
  sheet.autoSizeColumn((short) 7);
  
  HSSFCell cell68 = row6.createCell(8);
  cell68.setCellValue(new HSSFRichTextString("Res. Fluid "));
  cell68.setCellStyle(style);   
  sheet.autoSizeColumn((short) 8);
  
  HSSFCell cell69 = row6.createCell(9);
  cell69.setCellValue(new HSSFRichTextString("_                             _"));
  //cell69.setCellStyle(style);   
  sheet.autoSizeColumn((short) 9);
  
  
           
  HSSFCell cell610 = row6.createCell(10);
  cell610.setCellValue(new HSSFRichTextString("No."));
  cell610.setCellStyle(style);   
  sheet.autoSizeColumn((short) 10);
           
  HSSFCell cell611 = row6.createCell(11);
  cell611.setCellValue(new HSSFRichTextString("STAGE NAME"));
  cell611.setCellStyle(style);   
  sheet.autoSizeColumn((short) 11);
  
  
  HSSFCell cell612 = row6.createCell(12);
  cell612.setCellValue(new HSSFRichTextString("VOLUME (BBLs"));
  cell612.setCellStyle(style);   
  sheet.autoSizeColumn((short) 12);
  
  HSSFCell cell613 = row6.createCell(13);
  cell613.setCellValue(new HSSFRichTextString("CONC.(%)"));
  cell613.setCellStyle(style);   
  sheet.autoSizeColumn((short) 13);
  
  HSSFCell cell614 = row6.createCell(14);
  cell614.setCellValue(new HSSFRichTextString("VIS ( CP)"));
  cell614.setCellStyle(style);   
  sheet.autoSizeColumn((short) 14);
  
  HSSFCell cell615 = row6.createCell(15);
  cell615.setCellValue(new HSSFRichTextString("PUMP RATE (BPM)"));
  cell615.setCellStyle(style);   
  sheet.autoSizeColumn((short) 15);

  HSSFCell cell616 = row6.createCell(16);
  cell616.setCellValue(new HSSFRichTextString("PUMPING PRESSURE (PSI)"));
  cell616.setCellStyle(style);   
  sheet.autoSizeColumn((short) 16);
  
  HSSFCell cell617 = row6.createCell(17);
  cell617.setCellValue(new HSSFRichTextString("INJ. DEPTH (FT)"));
  cell617.setCellStyle(style);   
  sheet.autoSizeColumn((short) 17);
  
  HSSFCell cell618 = row6.createCell(18);
  cell618.setCellValue(new HSSFRichTextString("ENTR FRIC PRESS(PSI)"));
  cell618.setCellStyle(style);   
  sheet.autoSizeColumn((short) 18);
	      	    
	   int k=7;
	   int j=1;
	    for(int i=0; i<50; i++)
	    {
	    	  
	    	HSSFRow dynamicrow = sheet.createRow((short)k);
	    
	    	
	    /*	 row.createCell(15).setCellValue(listdatareservoirlethology.get(k).getFormDefthFt().toString());
	    	  row.createCell(16).setCellValue(listdatareservoirlethology.get(k).getToDefthFt().toString());
	    	  row.createCell(17).setCellValue(listdatareservoirlethology.get(k).getTvdFt().toString());
	    	  row.createCell(18).setCellValue(listdatareservoirlethology.get(k).getPermMd().toString());
	    	  row.createCell(19).setCellValue(listdatareservoirlethology.get(k).getPoro().toString());
	    	  row.createCell(20).setCellValue(listdatareservoirlethology.get(k).getZonePressPsi().toString());
	    	  row.createCell(21).setCellValue(listdatareservoirlethology.get(k).getPreStimSkin().toString());
	    	  row.createCell(22).setCellValue(listdatareservoirlethology.get(k).getFluidInPlace());*/
	    	
	    	if(i<listdatareservoirlethology.size())
	    	{
	    	dynamicrow.createCell(0).setCellValue(j);
	    	dynamicrow.createCell(1).setCellValue(listdatareservoirlethology.get(i).getFormDefthFt().toString());
	    	dynamicrow.createCell(2).setCellValue(listdatareservoirlethology.get(i).getToDefthFt().toString());
	    	dynamicrow.createCell(3).setCellValue(listdatareservoirlethology.get(i).getTvdFt().toString());
	    	dynamicrow.createCell(4).setCellValue(listdatareservoirlethology.get(i).getPermMd().toString());
	    	dynamicrow.createCell(5).setCellValue(listdatareservoirlethology.get(i).getPoro().toString());
	    	dynamicrow.createCell(6).setCellValue(listdatareservoirlethology.get(i).getZonePressPsi().toString());
	    	dynamicrow.createCell(7).setCellValue(listdatareservoirlethology.get(i).getPreStimSkin().toString());
	    	dynamicrow.createCell(8).setCellValue(listdatareservoirlethology.get(i).getFluidInPlace());
	    	
	    	}
	    	dynamicrow.createCell(9).setCellValue("");
	    	 /*if(k<listacidinjectiontable.size())
  	      {
	    	  row.createCell((short) 23).setCellValue(listacidinjectiontable.get(k).getStage());
           row.createCell((short) 24).setCellValue(listacidinjectiontable.get(k).getStavageVolBbls().toString());
           row.createCell((short) 25).setCellValue(listacidinjectiontable.get(k).getConc().toString());
           row.createCell((short) 26).setCellValue(listacidinjectiontable.get(k).getVise().toString());
           row.createCell((short) 27).setCellValue(listacidinjectiontable.get(k).getPumpRateBmp().toString());
           row.createCell((short) 28).setCellValue(listacidinjectiontable.get(k).getInjPressPsi().toString());
           row.createCell((short) 29).setCellValue(listacidinjectiontable.get(k).getInjDefthFt().toString());
           row.createCell((short) 30).setCellValue(listacidinjectiontable.get(k).getEntityFricLoss().toString());
  	      }*/
	    	if(i<listacidinjectiontable.size()){   
	    	dynamicrow.createCell(10).setCellValue(j);
	    	dynamicrow.createCell(11).setCellValue(listacidinjectiontable.get(i).getStage());
	    	dynamicrow.createCell(12).setCellValue(listacidinjectiontable.get(i).getStavageVolBbls().toString());
	    	dynamicrow.createCell(13).setCellValue(listacidinjectiontable.get(i).getConc().toString());
	    	dynamicrow.createCell(14).setCellValue(listacidinjectiontable.get(i).getVise().toString());
	    	dynamicrow.createCell(15).setCellValue(listacidinjectiontable.get(i).getPumpRateBmp().toString());
	    	dynamicrow.createCell(16).setCellValue(listacidinjectiontable.get(i).getInjPressPsi().toString());
	    	dynamicrow.createCell(17).setCellValue(listacidinjectiontable.get(i).getInjDefthFt().toString());
	    	dynamicrow.createCell(18).setCellValue(listacidinjectiontable.get(i).getEntityFricLoss().toString());
	    	}
	    	
	    	dynamicrow.createCell(19).setCellValue("");
	    	dynamicrow.createCell(20).setCellValue("");
	    
	    	
	    	if(k==7)
	    	{
	         		
	    		HSSFCell dynamicrow100 = dynamicrow.createCell(20);
 	        dynamicrow100.setCellValue("");
 	        dynamicrow100.setCellStyle(style); 
            sheet.autoSizeColumn((short) 20);
	    		
          
            HSSFCell dynamicrow11 = dynamicrow.createCell(21);
   	        dynamicrow11.setCellValue("");
   	        dynamicrow11.setCellStyle(style); 
              sheet.autoSizeColumn((short) 21);
            
	    		  
            //dynamicrow.createCell(21).setCellValue("Well / Completion Design");
 		   HSSFCell dynamicrow1 = dynamicrow.createCell(22);
 		   dynamicrow1.setCellValue(new HSSFRichTextString("Well / Completion Design"));
 		// sheet.addMergedRegion(CellRangeAddress.valueOf("U8:Y8"));
 		   dynamicrow1.setCellStyle(style);   
 	        sheet.autoSizeColumn((short) 22);
 		
 	        HSSFCell dynamicrow10 = dynamicrow.createCell(23);
 	        dynamicrow10.setCellValue("");
 	        dynamicrow10.setCellStyle(style); 
            sheet.autoSizeColumn((short) 23);
 	        
        
    	        
            HSSFCell dynamicrow12 = dynamicrow.createCell(24);
	        dynamicrow12.setCellValue("");
	        dynamicrow12.setCellStyle(style); 
        sheet.autoSizeColumn((short) 24);
	        

       
	    		
	    	}
	    	else if(k==8)
	    	{
	    	/*	dynamicrow.createCell(20).setCellValue("1");
	    		dynamicrow.createCell(21).setCellValue("Well Type");
	    		dynamicrow.createCell(22).setCellValue(welCompletionDataTbl.getWellType());
	    		dynamicrow.createCell(23).setCellValue("Completion Type");
	    		dynamicrow.createCell(24).setCellValue(welCompletionDataTbl.getCompletionType());*/
	    		
	    		   HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("1  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Well Type");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(welCompletionDataTbl.getWellType());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Completion Type");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(welCompletionDataTbl.getCompletionType());
	    		   dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	else if(k==9)
	    	{
	       		
	    		
	    		   HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("2  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Well Dia (Inch)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(welCompletionDataTbl.getWellDiaInch()+"");
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Perf Dia (Inch)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(welCompletionDataTbl.getPerfDiaInch()+"");
	    		   dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    		
	    	}
	    	
	    	else if(k==10)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("3");
	    		dynamicrow.createCell(21).setCellValue("Well MD (FT)");
	    		dynamicrow.createCell(22).setCellValue(welCompletionDataTbl.getWellMdFt()+"");
	    		dynamicrow.createCell(23).setCellValue("Well TVD(FT)");
	    		dynamicrow.createCell(24).setCellValue(welCompletionDataTbl.getWellTvdFt()+"");
	    		    	    		*/

  		   HSSFCell dynamicrow20 = dynamicrow.createCell(20);
  		   dynamicrow20.setCellValue("3  ");
  		   dynamicrow20.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 20);
  	         
  	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
    		    dynamicrow21.setCellValue("Well MD (FT)");
    		  dynamicrow21.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 21);
    	         
    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
  		   dynamicrow22.setCellValue(welCompletionDataTbl.getWellMdFt()+"");
  		   dynamicrow22.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 22);
  	         
  	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
    		   dynamicrow23.setCellValue("Well TVD(FT)");
    		    dynamicrow23.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 23);
    	         
    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
  		   dynamicrow24.setCellValue(welCompletionDataTbl.getWellTvdFt()+"");
  		   dynamicrow24.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 24);
	    	
	    	
	    	}
	    	
	    	else if(k==11)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("4");
	    		dynamicrow.createCell(21).setCellValue("Lateral Depth (FT)");
	    		dynamicrow.createCell(22).setCellValue(welCompletionDataTbl.getLateralDefthFt()+"");
	    		dynamicrow.createCell(23).setCellValue("Later at Depth(FT)");
	    		dynamicrow.createCell(24).setCellValue(welCompletionDataTbl.getLateraDefthFt()+"");
	    		*/

   		   HSSFCell dynamicrow20 = dynamicrow.createCell(20);
   		   dynamicrow20.setCellValue("4  ");
   		   dynamicrow20.setCellStyle(style1);        
   	         sheet.autoSizeColumn((short) 20);
   	         
   	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Lateral Depth (FT)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
   		   dynamicrow22.setCellValue(welCompletionDataTbl.getLateralDefthFt()+"");
   		   dynamicrow22.setCellStyle(style1);        
   	         sheet.autoSizeColumn((short) 22);
   	         
   	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Later at Depth(FT)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
   		   dynamicrow24.setCellValue(welCompletionDataTbl.getLateraDefthFt()+"");
   		   dynamicrow24.setCellStyle(style1);        
   	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	
	    	
	    	else if(k==14)
	    	{
	    	    HSSFCell dynamicrow21 = dynamicrow.createCell(20);
   		   dynamicrow21.setCellValue(new HSSFRichTextString(""));
   		   dynamicrow21.setCellStyle(style);   
   	        sheet.autoSizeColumn((short) 20);
   	        
   	      HSSFCell dynamicrow22 = dynamicrow.createCell(21);
 		   dynamicrow22.setCellValue(new HSSFRichTextString(""));
 		   dynamicrow22.setCellStyle(style);   
 	        sheet.autoSizeColumn((short) 20);
	    		//dynamicrow.createCell(21).setCellValue("Fluid Properties");
	    		 HSSFCell dynamicrow2 = dynamicrow.createCell(22);
   		   dynamicrow2.setCellValue(new HSSFRichTextString("Fluid Properties"));
   		   dynamicrow2.setCellStyle(style);   
   	        sheet.autoSizeColumn((short) 22);
   	        
   	      HSSFCell dynamicrow23 = dynamicrow.createCell(23);
 		   dynamicrow23.setCellValue(new HSSFRichTextString(""));
 		   dynamicrow23.setCellStyle(style);   
 	        sheet.autoSizeColumn((short) 23);
 	        
 	        HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(new HSSFRichTextString(""));
	    		   dynamicrow24.setCellStyle(style);   
	    	        sheet.autoSizeColumn((short) 24);
   	        
   	         	}
	    	
	    	else if(k==15)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("1");
	    		dynamicrow.createCell(21).setCellValue("Acid Density (Kg/m3)");
	    		dynamicrow.createCell(22).setCellValue(fluidPropertiesTbl.getAcidDensityKgM3().toString());
	    		dynamicrow.createCell(23).setCellValue("Acid Dissolving Power ");
	    		dynamicrow.createCell(24).setCellValue(fluidPropertiesTbl.getAcidDissolvingPower().toString());
	    		*/
	    		
	    		  HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("1  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Acid Density (Kg/m3)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(fluidPropertiesTbl.getAcidDensityKgM3().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Acid Dissolving Power ");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(fluidPropertiesTbl.getAcidDissolvingPower().toString());
	    		   dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	
	    	else if(k==16)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("2");
	    		dynamicrow.createCell(21).setCellValue("Res. Oil Density");
	    		dynamicrow.createCell(22).setCellValue(fluidPropertiesTbl.getResOilDensityKgM3().toString());
	    		dynamicrow.createCell(23).setCellValue("Res. Oil Viscosity (cP)");
	    		dynamicrow.createCell(24).setCellValue(fluidPropertiesTbl.getResOilVisCp().toString());*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("2  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Res. Oil Density");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(fluidPropertiesTbl.getResOilDensityKgM3().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Res. Oil Viscosity (cP)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(fluidPropertiesTbl.getResOilVisCp().toString());
    		   dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    		
	    		
	    		
	    	}
	    	else if(k==17)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("3");
	    		dynamicrow.createCell(21).setCellValue("Res. Water Density(Kg/m3)");
	    		dynamicrow.createCell(22).setCellValue(fluidPropertiesTbl.getResWaterDensityKgM3().toString());
	    		dynamicrow.createCell(23).setCellValue("Res. Water Viscosity (cP)");
	    		dynamicrow.createCell(24).setCellValue(fluidPropertiesTbl.getResWaterDensityKgM3().toString());*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("3  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Res. Water Density(Kg/m3)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(fluidPropertiesTbl.getResWaterDensityKgM3().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Res. Water Viscosity (cP)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(fluidPropertiesTbl.getResWaterDensityKgM3().toString());
	    		   dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	else if(k==18)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("4");
	    		dynamicrow.createCell(21).setCellValue("Res. Gas Density (Kg/m3)");
	    		dynamicrow.createCell(22).setCellValue(fluidPropertiesTbl.getResGasDensityKgM3().toString());
	    		dynamicrow.createCell(23).setCellValue("Res. Gas Viscosity (cP)");
	    		dynamicrow.createCell(24).setCellValue(fluidPropertiesTbl.getResGasVisCp().toString());
	    		
	    		*/
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("4  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Res. Gas Density (Kg/m3)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(fluidPropertiesTbl.getResGasDensityKgM3().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Res. Gas Viscosity (cP)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(fluidPropertiesTbl.getResGasVisCp().toString());
    		   dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	else if(k==21)
	    	{
	    		
	    		 HSSFCell dynamicrow30 = dynamicrow.createCell(20);
   		   dynamicrow30.setCellValue(new HSSFRichTextString(""));
   		   dynamicrow30.setCellStyle(style);   
   	        sheet.autoSizeColumn((short) 20);
	    		  
	    	   	 HSSFCell dynamicrow31 = dynamicrow.createCell(21);
	    		   dynamicrow31.setCellValue(new HSSFRichTextString(""));
	    		   dynamicrow31.setCellStyle(style);   
	    	        sheet.autoSizeColumn((short) 21);
	    	        
	    	    	//dynamicrow.createCell(21).setCellValue("Additional Input Data");
 	    		 HSSFCell dynamicrow32 = dynamicrow.createCell(22);
	    		   dynamicrow32.setCellValue(new HSSFRichTextString("Additional Input Data"));
	    		   dynamicrow32.setCellStyle(style);   
	    	        sheet.autoSizeColumn((short) 22);
	    	        
	    	   	 HSSFCell dynamicrow33 = dynamicrow.createCell(23);
	    		   dynamicrow33.setCellValue(new HSSFRichTextString(""));
	    		   dynamicrow33.setCellStyle(style);   
	    	        sheet.autoSizeColumn((short) 23);
	    	        
	    	   	 HSSFCell dynamicrow34 = dynamicrow.createCell(24);
	    		   dynamicrow34.setCellValue(new HSSFRichTextString(""));
	    		   dynamicrow34.setCellStyle(style);   
	    	        sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	else if(k==22)
	    	{
	    	/*	dynamicrow.createCell(20).setCellValue("1");
	    		dynamicrow.createCell(21).setCellValue("Stimulation Type");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getStimulationType().toString());
	    		dynamicrow.createCell(23).setCellValue("Jet Dia (Inch)");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getJetDiaInch().toString());
	    		*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("1  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Stimulation Type");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getStimulationType().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Jet Dia (Inch)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getJetDiaInch().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	else if(k==23)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("2");
	    		dynamicrow.createCell(21).setCellValue("Max Allowable Pressure(Psi)");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getMaxPressPsi().toString());
	    		dynamicrow.createCell(23).setCellValue("Frac Pressure (Psi)");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getFracPressPsi().toString());
*/    	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("2  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Max Allowable Pressure(Psi)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getMaxPressPsi().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Frac Pressure (Psi)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getFracPressPsi().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	else if(k==24)
	    	{/*
	    		dynamicrow.createCell(20).setCellValue("3");
	    		dynamicrow.createCell(21).setCellValue("Tub Friction Coeff. ");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getTubFrictionCoff().toString());
	    		dynamicrow.createCell(23).setCellValue("Formation Volume Factor");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getFormVolumeFactor().toString());*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("3  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Tub Friction Coeff. ");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getTubFrictionCoff().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Formation Volume Factor");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getFormVolumeFactor().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	else if(k==25)
	    	{
	    	/*	dynamicrow.createCell(20).setCellValue("4");
	    		dynamicrow.createCell(21).setCellValue("Diverter Constant K");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getDriverterConstK().toString());
	    		dynamicrow.createCell(23).setCellValue("Diverter Const. n");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getDiverterCosntN().toString());*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("4  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Diverter Constant K");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getDriverterConstK().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Diverter Const. n");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getDiverterCosntN().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	else if(k==26)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("5");
	    		dynamicrow.createCell(21).setCellValue("Rock Density");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getRockDensityKg().toString());
	    		dynamicrow.createCell(23).setCellValue("Frac Lenth (Inch)");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getFracLenthInch().toString());
	    		
	    		*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("5  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Rock Density");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getRockDensityKg().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Frac Lenth (Inch)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getFracLenthInch().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	else if(k==22)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("6");
	    		dynamicrow.createCell(21).setCellValue("No. of Timestpes");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getNoOfTimepsteps().toString());
	    		dynamicrow.createCell(23).setCellValue("No. of Grids");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getNoOfGrids().toString());
	    		*/
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("6  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("No. of Timestpes");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getNoOfTimepsteps().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("No. of Grids");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getNoOfGrids().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	else if(k==27)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("7");
	    		dynamicrow.createCell(21).setCellValue("Post Production (Bbls/d)");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getPostProdBbls().toString());
	    		dynamicrow.createCell(23).setCellValue("Post Prod at Press (Psi)");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getPostProdAtPressPsi().toString());
	    		*/
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("7  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Post Production (Bbls/d)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getPostProdBbls().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Post Prod at Press (Psi)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getPostProdAtPressPsi().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    	}
	    	else if(k==28)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("8");
	    		dynamicrow.createCell(21).setCellValue("Frac Apperture (Ft)");
	    		dynamicrow.createCell(22).setCellValue(additionalInpuDataTbl.getFracAppertureFt().toString());
	    		dynamicrow.createCell(23).setCellValue("Frac Length (Inch)");
	    		dynamicrow.createCell(24).setCellValue(additionalInpuDataTbl.getFracLenthInch().toString());
	    		*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("8  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Frac Apperture (Ft)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(additionalInpuDataTbl.getFracAppertureFt().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue("Frac Length (Inch)");
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		   dynamicrow24.setCellValue(additionalInpuDataTbl.getFracLenthInch().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	
	    	else if(k==31)
	    	{
	    		HSSFCell dynamicrow40 = dynamicrow.createCell(20);
   		   dynamicrow40.setCellValue(new HSSFRichTextString(""));
   		   dynamicrow40.setCellStyle(style);   
   	        sheet.autoSizeColumn((short) 20);
   	        
   	      HSSFCell dynamicrow41 = dynamicrow.createCell(21);
  		   dynamicrow41.setCellValue(new HSSFRichTextString(""));
  		   dynamicrow41.setCellStyle(style);   
  	        sheet.autoSizeColumn((short) 21);
   	        
	    		//dynamicrow.createCell(21).setCellValue("Sensitivity Analysis");
	    		HSSFCell dynamicrow42 = dynamicrow.createCell(22);
  		   dynamicrow42.setCellValue(new HSSFRichTextString("Sensitivity Analysis"));
  		   dynamicrow42.setCellStyle(style);   
  	        sheet.autoSizeColumn((short) 22);
  	        
  	       HSSFCell dynamicrow43 = dynamicrow.createCell(23);
  		   dynamicrow43.setCellValue(new HSSFRichTextString(""));
  		   dynamicrow43.setCellStyle(style);   
  	        sheet.autoSizeColumn((short) 23);
   	        
  	       HSSFCell dynamicrow44 = dynamicrow.createCell(24);
  		   dynamicrow44.setCellValue(new HSSFRichTextString(""));
  		   dynamicrow44.setCellStyle(style);   
  	        sheet.autoSizeColumn((short) 24);
   	        
	    	}
	    	
	    	else if(k==32)
	    	{
	    		/*dynamicrow.createCell(21).setCellValue("Case I");
	    		dynamicrow.createCell(22).setCellValue("Case I");
	    		dynamicrow.createCell(23).setCellValue("Case II");
	    		dynamicrow.createCell(24).setCellValue("Case III");*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		 dynamicrow20.setCellValue(new HSSFRichTextString(" "));
	    		 dynamicrow20.setCellStyle(style);   
	             sheet.autoSizeColumn((short) 20);
	    		
	    		
	    		HSSFCell dynamicrow21 = dynamicrow.createCell(21);
	    		 dynamicrow21.setCellValue(new HSSFRichTextString(""));
	    		 dynamicrow21.setCellStyle(style);   
	             sheet.autoSizeColumn((short) 21);
	             
	             HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		 dynamicrow22.setCellValue(new HSSFRichTextString("Case I"));
	    		 dynamicrow22.setCellStyle(style);   
	             sheet.autoSizeColumn((short) 22);
	             
	             HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		 dynamicrow23.setCellValue(new HSSFRichTextString("Case II "));
	    		 dynamicrow23.setCellStyle(style);   
	             sheet.autoSizeColumn((short) 23);
	             
	             HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		 dynamicrow24.setCellValue(new HSSFRichTextString("Case III "));
	    		 dynamicrow24.setCellStyle(style);   
	             sheet.autoSizeColumn((short) 24);

	             
	    	}
	    	
	    	else if(k==33)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("1");
	    		dynamicrow.createCell(21).setCellValue("Diverter Vis (cP)");
	    		dynamicrow.createCell(22).setCellValue(listsensitiveanalysistbl.get(0).getCase1().toString());
	    		dynamicrow.createCell(23).setCellValue(listsensitiveanalysistbl.get(0).getCase2().toString());
	    		dynamicrow.createCell(24).setCellValue(listsensitiveanalysistbl.get(0).getCase3().toString());*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("1  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Diverter Vis (cP)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(0).getCase1().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(0).getCase2().toString());
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		   dynamicrow24.setCellValue(listsensitiveanalysistbl.get(0).getCase3().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    		
	    		
	    	}
	    	
	    	else if(k==34)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("2");
	    		dynamicrow.createCell(21).setCellValue("Pump Rate (BPM)");
	    		dynamicrow.createCell(22).setCellValue(listsensitiveanalysistbl.get(1).getCase1().toString());
	    		dynamicrow.createCell(23).setCellValue(listsensitiveanalysistbl.get(1).getCase2().toString());
	    		dynamicrow.createCell(24).setCellValue(listsensitiveanalysistbl.get(1).getCase3().toString());
	    		*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("2  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Pump Rate (BPM)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(1).getCase1().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(1).getCase2().toString());
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		     dynamicrow24.setCellValue(listsensitiveanalysistbl.get(1).getCase3().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    		
	    		
	    	}
	    	else if(k==35)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("3");
	    		dynamicrow.createCell(21).setCellValue("Acid Conc (%)");
	    		dynamicrow.createCell(22).setCellValue(listsensitiveanalysistbl.get(2).getCase1().toString());
	    		dynamicrow.createCell(23).setCellValue(listsensitiveanalysistbl.get(2).getCase2().toString());
	    		dynamicrow.createCell(24).setCellValue(listsensitiveanalysistbl.get(2).getCase3().toString());
	    		*/
	    		
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("3  ");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Acid Conc (%)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(2).getCase1().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(2).getCase2().toString());
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		     dynamicrow24.setCellValue(listsensitiveanalysistbl.get(2).getCase3().toString());
	    		  dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	else if(k==36)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("4");
	    		dynamicrow.createCell(21).setCellValue("Acid Volume (BBLs)");
	    		dynamicrow.createCell(22).setCellValue(listsensitiveanalysistbl.get(3).getCase1().toString());
	    		dynamicrow.createCell(23).setCellValue(listsensitiveanalysistbl.get(3).getCase2().toString());
	    		dynamicrow.createCell(24).setCellValue(listsensitiveanalysistbl.get(3).getCase3().toString());
	    		
	    		*/
	    		 HSSFCell dynamicrow20 = dynamicrow.createCell(20);
    		   dynamicrow20.setCellValue("4  ");
    		   dynamicrow20.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 20);
    	         
    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Acid Volume (BBLs)");
	    		  dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
    		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(3).getCase1().toString());
    		   dynamicrow22.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 22);
    	         
    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(3).getCase2().toString());
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
    		     dynamicrow24.setCellValue(listsensitiveanalysistbl.get(3).getCase3().toString());
	    		  dynamicrow24.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	else if(k==37)
	    	{
	    		/*dynamicrow.createCell(20).setCellValue("4");
	    		dynamicrow.createCell(21).setCellValue("Diverter ST Property ");
	    		dynamicrow.createCell(22).setCellValue(listsensitiveanalysistbl.get(4).getCase1().toString());
	    		dynamicrow.createCell(23).setCellValue(listsensitiveanalysistbl.get(4).getCase2().toString());
	    		dynamicrow.createCell(24).setCellValue(listsensitiveanalysistbl.get(4).getCase3().toString());*/
	    		
	    		   HSSFCell dynamicrow20 = dynamicrow.createCell(20);
	    		   dynamicrow20.setCellValue("5");
	    		   dynamicrow20.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 20);
	    	         
	    	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
	    		    dynamicrow21.setCellValue("Diverter ST Property K");
	    		   dynamicrow21.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 21);
	    	         
	    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
	    		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(4).getCase1().toString());
	    		   dynamicrow22.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 22);
	    	         
	    	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
	    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(4).getCase2().toString());
	    		    dynamicrow23.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 23);
	    	         
	    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
	    		     dynamicrow24.setCellValue(listsensitiveanalysistbl.get(4).getCase3().toString());
	    		     dynamicrow24.setCellStyle(style1);        
	    	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	else if(k==38)
	    	{
	    		HSSFCell dynamicrow20 = dynamicrow.createCell(20);
  		   dynamicrow20.setCellValue("6");
  		   dynamicrow20.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 20);
  	         
  	         HSSFCell dynamicrow21= dynamicrow.createCell(21);
    		     dynamicrow21.setCellValue("Diverter ST Property N");
    		     dynamicrow21.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 21);
    	         
    	       HSSFCell dynamicrow22 = dynamicrow.createCell(22);
  		   dynamicrow22.setCellValue(listsensitiveanalysistbl.get(5).getCase1().toString());
  		   dynamicrow22.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 22);
  	         
  	         HSSFCell dynamicrow23 = dynamicrow.createCell(23);
    		   dynamicrow23.setCellValue(listsensitiveanalysistbl.get(5).getCase2().toString());
    		    dynamicrow23.setCellStyle(style1);        
    	         sheet.autoSizeColumn((short) 23);
    	         
    	       HSSFCell dynamicrow24 = dynamicrow.createCell(24);
  		     dynamicrow24.setCellValue(listsensitiveanalysistbl.get(5).getCase3().toString());
    		     dynamicrow24.setCellStyle(style1);        
  	         sheet.autoSizeColumn((short) 24);
	    	}
	    	
	    	
	    	 
	    		
	    	
	    	k++;
	    	j++;
	    }
	    
	    
	    
	    
	    
	    //HSSFRow row1 = sheet.createRow((short) 1);
	   
	    
	   
	    //All Column Header name 	    
        /*rowhead.createCell((short) 0).setCellValue("ProjectName");
	       rowhead.createCell((short) 1).setCellValue("WellName");
	       rowhead.createCell((short) 2).setCellValue("ChemicalName");
	       rowhead.createCell((short) 3).setCellValue("CompanyName");
	       rowhead.createCell((short) 4).setCellValue("UserName");
	    
	        rowhead.createCell((short) 5).setCellValue("NoofLayers ");
	        rowhead.createCell((short) 6).setCellValue("NOofStages");
			rowhead.createCell((short) 7).setCellValue("WellType");
			rowhead.createCell((short) 8).setCellValue("CompletionType");
	         rowhead.createCell((short) 9).setCellValue("WellDiaInch");
			 rowhead.createCell((short) 10).setCellValue("PerfDiaInch");
			  rowhead.createCell((short) 11).setCellValue("WellMDFT");
			   rowhead.createCell((short) 12).setCellValue("WellTVDFT");
			  rowhead.createCell((short) 13).setCellValue("LateralDefthFT");
			    rowhead.createCell((short) 14).setCellValue("LateraDefthFT");
			   
			    //Reservior table column header
			     rowhead.createCell((short) 15).setCellValue("FromDefthFT");
     	    rowhead.createCell((short) 16).setCellValue("ToDefthFT");
     	    rowhead.createCell((short) 17).setCellValue("TVDFT");
				rowhead.createCell((short) 18).setCellValue("PermMD");
     	    rowhead.createCell((short) 19).setCellValue("PORO");
				 rowhead.createCell((short) 20).setCellValue("ZonePressPSI");
				  rowhead.createCell((short) 21).setCellValue("PreStimSkin");
				   rowhead.createCell((short) 22).setCellValue("FluidInPlace");
			   
				   //acid injection column header
				   rowhead.createCell((short) 23).setCellValue("Stage");
	         	    rowhead.createCell((short) 24).setCellValue("StavageVolBbls");
	         	    rowhead.createCell((short) 25).setCellValue("Conc");
					rowhead.createCell((short) 26).setCellValue("Vise");
					rowhead.createCell((short) 27).setCellValue("PumpRateDMP");
					rowhead.createCell((short) 28).setCellValue("InjPressPSI");
					rowhead.createCell((short) 29).setCellValue("InjDefthFT");
					rowhead.createCell((short) 30).setCellValue("Entity Fric Loss");
					
					// fluid property column header
					   rowhead.createCell((short) 31).setCellValue("ACIDDensityKGM3");
		        	    rowhead.createCell((short) 32).setCellValue("ACIDDisSolvingPower");
		        	    rowhead.createCell((short) 33).setCellValue("ResOilDensityK M3");
						rowhead.createCell((short) 34).setCellValue("ResOilVISCP");
						rowhead.createCell((short) 35).setCellValue("ResWaterDensity KG M3");
						rowhead.createCell((short) 36).setCellValue("ResWaterViscCP ");
						rowhead.createCell((short) 37).setCellValue("ResGasDensity KG M3");
						rowhead.createCell((short) 38).setCellValue("ResGasVISCP");
					
						//Additional input data table column header
						    rowhead.createCell((short) 39).setCellValue("StimulationType");
			        	    rowhead.createCell((short) 40).setCellValue("JetDiaInch");
			        	    rowhead.createCell((short) 41).setCellValue("MaxPressPSI");
							rowhead.createCell((short) 42).setCellValue("FracPressPSI");
							rowhead.createCell((short) 43).setCellValue("TubFrictionCoff");
							rowhead.createCell((short) 44).setCellValue("FormVolFaster");
							rowhead.createCell((short) 45).setCellValue("DriverterConstK");
							rowhead.createCell((short) 46).setCellValue("DriverterConstN");
			                rowhead.createCell((short) 47).setCellValue("RockDensityKG");
			        	    rowhead.createCell((short) 48).setCellValue("FracLengthInch");
							rowhead.createCell((short) 49).setCellValue("NoOfTimepSteps");
							rowhead.createCell((short) 50).setCellValue("NoOfGrids");
							rowhead.createCell((short) 51).setCellValue("PostProdBbls");
							rowhead.createCell((short) 52).setCellValue(" PostProdPressPSI");
							rowhead.createCell((short) 53).setCellValue("FracAppertureFT");
							rowhead.createCell((short) 54).setCellValue("FracLength_FT");
					
							// Sensivity Analysis column  header
							   rowhead.createCell((short) 55).setCellValue("SensitivityAnalysisName");
				        	    rowhead.createCell((short) 56).setCellValue("Case1");
				        	    rowhead.createCell((short) 57).setCellValue("Case2");
								rowhead.createCell((short) 58).setCellValue("Case3");
								int i = 1;
				        	    HSSFRow row = sheet.createRow((short) i);			
   	  		 
				        	    
				        	    data.add("ProjectName="+projectdetail.get(0).getProjectName());
				                  data.add("WellName="+wellLayersStageTbl.getWellName());
				                  data.add("ChemicalName="+"");
				                  data.add("CompanyName="+projectdetail.get(0).getCompanyName());	
								   data.add("UserName="+"Durgesh");
				                  data.add("NoofLayers="+wellLayersStageTbl.getNoOfLayers());
				                  data.add("NOofStages="+wellLayersStageTbl.getNoOfStages());
								   data.add("WellType="+welCompletionDataTbl.getWellType());	
								   data.add("CompletionType="+welCompletionDataTbl.getCompletionType());
				                  data.add("WellDiaInch="+welCompletionDataTbl.getWellDiaInch());
				                  data.add("PerfDiaInch="+welCompletionDataTbl.getPerfDiaInch());
				                  data.add("WellMDFT="+welCompletionDataTbl.getWellMdFt());	
								   data.add("WellTVDFT="+welCompletionDataTbl.getWellTvdFt());
				                  data.add("LateralDefthFT="+welCompletionDataTbl.getLateralDefthFt());
				                  data.add("LateraDefthFT="+welCompletionDataTbl.getLateraDefthFt());
				        	    
				        	    
								row.createCell((short) 0).setCellValue(projectdetail.get(0).getProjectName());
			             	    row.createCell((short) 1).setCellValue(wellLayersStageTbl.getWellName());
			             	    row.createCell((short) 2).setCellValue("");
			             	    row.createCell((short) 3).setCellValue(projectdetail.get(0).getCompanyName());
			             	    row.createCell((short) 4).setCellValue(usernamed);
			        	        row.createCell((short) 5).setCellValue(wellLayersStageTbl.getNoOfLayers());
			        	        row.createCell((short) 6).setCellValue(wellLayersStageTbl.getNoOfStages());
			        	        row.createCell((short) 7).setCellValue(welCompletionDataTbl.getWellType());
			        	        row.createCell((short) 8).setCellValue(welCompletionDataTbl.getCompletionType());
			        	        row.createCell((short) 9).setCellValue(welCompletionDataTbl.getWellDiaInch().toString());
			        	        row.createCell((short) 10).setCellValue(welCompletionDataTbl.getPerfDiaInch().toString());
			        	        row.createCell((short) 11).setCellValue(welCompletionDataTbl.getWellMdFt().toString());
			        	        row.createCell((short) 12).setCellValue(welCompletionDataTbl.getWellTvdFt().toString());
			        	        row.createCell((short) 13).setCellValue(welCompletionDataTbl.getLateralDefthFt().toString());
			        	        row.createCell((short) 14).setCellValue(welCompletionDataTbl.getLateraDefthFt().toString());
   	  		 
			        	        //fluid properties
			             	      data.add("AcidDensityKGM3="+fluidPropertiesTbl.getAcidDensityKgM3());
			             	      data.add("AcidDissolvingPower="+fluidPropertiesTbl.getAcidDissolvingPower());
			             	      data.add("ResOilDensityKGM3="+fluidPropertiesTbl.getResOilDensityKgM3());
			             	      data.add("ResOilVisCP="+fluidPropertiesTbl.getResOilVisCp());
			             	      data.add("ResWaterDensityKGM3="+fluidPropertiesTbl.getResWaterDensityKgM3()); 
			             	      data.add("ResWaterViscCP="+fluidPropertiesTbl.getResWaterViscCp());
			             	      data.add("ResGasDensityKGM3="+fluidPropertiesTbl.getResGasDensityKgM3());
			             	  	  data.add("ResGasVisCP="+fluidPropertiesTbl.getResGasVisCp());
			             	  	 //additional data
			             	  	  data.add("StimulationType="+additionalInpuDataTbl.getStimulationType());
			             	  	  data.add("JetDiaInch="+additionalInpuDataTbl.getJetDiaInch());
			             	  	  data.add("MaxPressPSI="+additionalInpuDataTbl.getMaxPressPsi());
			             	  	  data.add("FracPressPSI="+additionalInpuDataTbl.getFracPressPsi()); 
			             	  	  data.add("TubFrictionCoff="+additionalInpuDataTbl.getTubFrictionCoff());
			             	  	  data.add("FormVolFactor="+additionalInpuDataTbl.getFormVolumeFactor());
			             	  	  data.add("DriverterConstK="+additionalInpuDataTbl.getDriverterConstK());
			             	  	  data.add("DiverterCosntN="+additionalInpuDataTbl.getDiverterCosntN());
			             	  	    data.add("RockDensityKG="+additionalInpuDataTbl.getRockDensityKg());
			             	  		 data.add("FracLenthInch="+additionalInpuDataTbl.getFracLenthInch()); 
			             	  		 data.add("NoOfTimepsteps="+additionalInpuDataTbl.getNoOfTimepsteps());
			             	  		  data.add("NoOfGrids="+additionalInpuDataTbl.getNoOfGrids());
			             	  	     data.add("PostProdBbls="+additionalInpuDataTbl.getPostProdBbls());
			             	  	    data.add("PostProdAtPressPSI="+additionalInpuDataTbl.getPostProdAtPressPsi() );
			             	  		 data.add("FracAppertureFT="+additionalInpuDataTbl.getFracAppertureFt()); 
			             	  		 data.add("FracLengthFT="+additionalInpuDataTbl.getFracLengthFt());
			        	        
			        	        
			        	          row.createCell(31).setCellValue(fluidPropertiesTbl.getAcidDensityKgM3().toString());
		            	    	  row.createCell(32).setCellValue(fluidPropertiesTbl.getAcidDissolvingPower().toString());
		            	    	  row.createCell(33).setCellValue(fluidPropertiesTbl.getResOilDensityKgM3().toString());
		            	    	  row.createCell(34).setCellValue(fluidPropertiesTbl.getResOilVisCp().toString());
		            	    	  row.createCell(35).setCellValue(fluidPropertiesTbl.getResWaterDensityKgM3().toString());
		            	    	  row.createCell(36).setCellValue(fluidPropertiesTbl.getResWaterViscCp().toString());
		            	    	  row.createCell(37).setCellValue(fluidPropertiesTbl.getResGasDensityKgM3().toString());
		            	    	  row.createCell(38).setCellValue(fluidPropertiesTbl.getResGasVisCp().toString());
		            	   	      //additional data
		            	    	  row.createCell(39).setCellValue(additionalInpuDataTbl.getStimulationType().toString());
		            	    	  row.createCell(40).setCellValue(additionalInpuDataTbl.getJetDiaInch().toString());
		            	    	  row.createCell(41).setCellValue(additionalInpuDataTbl.getMaxPressPsi().toString());
		            	    	  row.createCell(42).setCellValue(additionalInpuDataTbl.getFracPressPsi().toString());
		            	    	  row.createCell(43).setCellValue(additionalInpuDataTbl.getTubFrictionCoff().toString());
		            	    	  row.createCell(44).setCellValue(additionalInpuDataTbl.getFormVolumeFactor().toString());
		            	    	  row.createCell(45).setCellValue(additionalInpuDataTbl.getDriverterConstK().toString());
		            	    	  row.createCell(46).setCellValue(additionalInpuDataTbl.getDiverterCosntN().toString());    	   	  
		            	    	  row.createCell(47).setCellValue(additionalInpuDataTbl.getRockDensityKg().toString());
		            	    	  row.createCell(48).setCellValue(additionalInpuDataTbl.getFracLenthInch().toString());
		            	    	  row.createCell(49).setCellValue(additionalInpuDataTbl.getNoOfTimepsteps().toString());
		            	    	  row.createCell(50).setCellValue(additionalInpuDataTbl.getNoOfGrids().toString());
		            	    	  row.createCell(51).setCellValue(additionalInpuDataTbl.getPostProdBbls().toString());
		            	    	  row.createCell(52).setCellValue(additionalInpuDataTbl.getPostProdAtPressPsi().toString());
		            	    	  row.createCell(53).setCellValue(additionalInpuDataTbl.getFracAppertureFt().toString());
		            	    	  row.createCell(54).setCellValue(additionalInpuDataTbl.getFracLengthFt().toString());
		            	    	  
		            	    	  int size=0;


		                          
		                          if ( listdatareservoirlethology.size() > listacidinjectiontable.size() && listdatareservoirlethology.size()  > listsensitiveanalysistbl.size() )
		                             size=listdatareservoirlethology.size();
		                         else if (  listacidinjectiontable.size() > listdatareservoirlethology.size() && listacidinjectiontable.size()  > listsensitiveanalysistbl.size() )
		                          	 size=listacidinjectiontable.size();
		                         else if ( listsensitiveanalysistbl.size() > listdatareservoirlethology.size() && listsensitiveanalysistbl.size() > listacidinjectiontable.size() )
		                              size=listsensitiveanalysistbl.size();
		            	    	  
		            	    	  
		            	    	  for(int k=0;k<size; k++)
		            	        	 {
		     	             	      if(k<listdatareservoirlethology.size())
		     	             	      {
		            	        	  row.createCell(15).setCellValue(listdatareservoirlethology.get(k).getFormDefthFt().toString());
		                 	    	  row.createCell(16).setCellValue(listdatareservoirlethology.get(k).getToDefthFt().toString());
		                 	    	  row.createCell(17).setCellValue(listdatareservoirlethology.get(k).getTvdFt().toString());
		                 	    	  row.createCell(18).setCellValue(listdatareservoirlethology.get(k).getPermMd().toString());
		                 	    	  row.createCell(19).setCellValue(listdatareservoirlethology.get(k).getPoro().toString());
		                 	    	  row.createCell(20).setCellValue(listdatareservoirlethology.get(k).getZonePressPsi().toString());
		                 	    	  row.createCell(21).setCellValue(listdatareservoirlethology.get(k).getPreStimSkin().toString());
		                 	    	  row.createCell(22).setCellValue(listdatareservoirlethology.get(k).getFluidInPlace());
		     	             	      }
		     	             	      if(k<listacidinjectiontable.size())
		     	             	      {
		                 	    	  row.createCell((short) 23).setCellValue(listacidinjectiontable.get(k).getStage());
		         	                  row.createCell((short) 24).setCellValue(listacidinjectiontable.get(k).getStavageVolBbls().toString());
		         	                  row.createCell((short) 25).setCellValue(listacidinjectiontable.get(k).getConc().toString());
		         	                  row.createCell((short) 26).setCellValue(listacidinjectiontable.get(k).getVise().toString());
		         	                  row.createCell((short) 27).setCellValue(listacidinjectiontable.get(k).getPumpRateBmp().toString());
		         	                  row.createCell((short) 28).setCellValue(listacidinjectiontable.get(k).getInjPressPsi().toString());
		         	                  row.createCell((short) 29).setCellValue(listacidinjectiontable.get(k).getInjDefthFt().toString());
		         	                  row.createCell((short) 30).setCellValue(listacidinjectiontable.get(k).getEntityFricLoss().toString());
		     	             	      }
		     	             	      if(k<listsensitiveanalysistbl.size())
		     	             	      {
		     	             	      row.createCell((short) 55).setCellValue(listsensitiveanalysistbl.get(k).getSensitivityAnalysisName());
		     		                  row.createCell((short) 56).setCellValue(listsensitiveanalysistbl.get(k).getCase1().toString());
		     		                  row.createCell((short) 57).setCellValue(listsensitiveanalysistbl.get(k).getCase2().toString());
		     		                  row.createCell((short) 58).setCellValue(listsensitiveanalysistbl.get(k).getCase3().toString());
		     	             	      }
		                 	         ++ i;
		                 	       row = sheet.createRow((short) i);  	*/ 
		            	        
		            	    	  
		            	    	
		            	    	  try
		            	    	  {
		            	    	  workbook.write(fileOut);
		                  	      fileOut.close();
		            	    	  }
		            	    	  catch(Exception e)
		            	    	  {
		            	    		  e.printStackTrace();
		            	    	  }

		            	    	  
   	  		 
   	  	 }
   	  	 catch(Exception e)
   	  	 {
   	  		 e.printStackTrace();
   	  	 }
	
	}
	
	
	private static void writeToFile(java.util.List<String> list, String path) {
	    BufferedWriter out = null;
	    try {
	            File file = new File(path);
	          
	            out = new BufferedWriter(new FileWriter(file, false));
	            for (String s : list) {
	                    out.write(s);
	                    out.flush();
	                    out.newLine();
	                  

	            }
	            out.close();
	    } catch (IOException e) {
	    }
	}

}
