package com.chemplace.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import com.chemplace.view.model.beans.AcidInjectionTbl;
import com.chemplace.view.model.beans.AdditionalInpuDataTbl;
import com.chemplace.view.model.beans.FluidPropertiesTbl;
import com.chemplace.view.model.beans.ReservoirlethologyTbl;
import com.chemplace.view.model.beans.SensitivityAnalysisTbl;
import com.chemplace.view.model.beans.WelCompletionDataTbl;

public class TestApp {
	
	
	public ArrayList<ReservoirlethologyTbl> getlistdatReservoirlethologyTbl(File file)
	{
		ArrayList<ReservoirlethologyTbl> listdatareservoirlethologyTbl=null;
		try
		{
		 FileInputStream input = new FileInputStream(file);
         Workbook w=Workbook.getWorkbook(input);
         Sheet sheet = w.getSheet(0);
         
        
         
         
          listdatareservoirlethologyTbl=new ArrayList<ReservoirlethologyTbl>();
          
         for (int i =7; i <=sheet.getRows(); i++) {
             Cell cell = sheet.getCell(1, 7);
             CellType type = cell.getType();
              
                      ReservoirlethologyTbl reservoirlethologyTbl=new ReservoirlethologyTbl();
                     
                    // System.out.println(sheet.getCell(1, i).getContents());
                     String  fromFt=sheet.getCell(1, i).getContents();
                     String toft=sheet.getCell(2, i).getContents();
                     String tvdft=sheet.getCell(3, i).getContents();		
                     String permMd=sheet.getCell(4, i).getContents();
                     String poro=sheet.getCell(5, i).getContents();
                     String ResPresspsi=sheet.getCell(6, i).getContents();
                     String prestimskin=sheet.getCell(7, i).getContents();
                     String resfluid=sheet.getCell(8, i).getContents();  
                     
                     
                     if(fromFt.equalsIgnoreCase("") && toft.equalsIgnoreCase("") && tvdft.equalsIgnoreCase("") && permMd.equalsIgnoreCase("") 
                    		 && poro.equalsIgnoreCase("") && ResPresspsi.equalsIgnoreCase("") && prestimskin.equalsIgnoreCase("") && resfluid.equalsIgnoreCase("") 
                    		 )
                     {
                     break;
                     }
                     else
                     {
                    	 reservoirlethologyTbl.setFormDefthFt(new BigDecimal(fromFt));
                       	 reservoirlethologyTbl.setToDefthFt(new BigDecimal(toft));
                       	 reservoirlethologyTbl.setTvdFt(new BigDecimal(tvdft));
                       	 reservoirlethologyTbl.setPermMd(new BigDecimal(permMd));
                       	 reservoirlethologyTbl.setPoro(new BigDecimal(poro));
                       	 reservoirlethologyTbl.setZonePressPsi(new BigDecimal(ResPresspsi));
                       	 reservoirlethologyTbl.setPreStimSkin(new BigDecimal(prestimskin));
                       	 reservoirlethologyTbl.setFluidInPlace(resfluid);
                       	 listdatareservoirlethologyTbl.add(reservoirlethologyTbl);
                     }
                     
             
         }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return listdatareservoirlethologyTbl;
	}
	
	
	public ArrayList<AcidInjectionTbl>	getListdatAcidInjectionTbl(File file)
	{
		ArrayList<AcidInjectionTbl>  acidinjectionDataList=new ArrayList<AcidInjectionTbl>();
		try{
		FileInputStream input = new FileInputStream(file);
         Workbook w=Workbook.getWorkbook(input);
         Sheet sheet = w.getSheet(0);
		  for (int i =7; i <=sheet.getRows(); i++) {
               
               /**/
                  AcidInjectionTbl acidInjectionPlan=new AcidInjectionTbl();
                      
                     // System.out.println(sheet.getCell(1, i).getContents());
                      String  stagename=sheet.getCell(11, i).getContents();
                      String volumebbls=sheet.getCell(12, i).getContents();
                      String conc=sheet.getCell(13, i).getContents();		
                      String vis=sheet.getCell(14, i).getContents();
                      String pumprate=sheet.getCell(15, i).getContents();
                      String pumpinperessurepsi=sheet.getCell(16, i).getContents();
                      String injectiondefth=sheet.getCell(17, i).getContents();
                      String enterpricpress=sheet.getCell(18, i).getContents();  
                      
                      
                      if(stagename.equalsIgnoreCase("") && volumebbls.equalsIgnoreCase("") && conc.equalsIgnoreCase("") && vis.equalsIgnoreCase("") 
                     		 && pumprate.equalsIgnoreCase("") && pumpinperessurepsi.equalsIgnoreCase("") && injectiondefth.equalsIgnoreCase("") && enterpricpress.equalsIgnoreCase("") 
                     		 )
                      {
                      break;
                      }
                      else
                      {
                      	  acidInjectionPlan.setStage(stagename);  
                      	  acidInjectionPlan.setStavageVolBbls((new BigDecimal(volumebbls)));
                       	  acidInjectionPlan.setConc((new BigDecimal(conc)));
                       	  acidInjectionPlan.setVise((new BigDecimal(vis)));
                       	  acidInjectionPlan.setPumpRateBmp((new BigDecimal(pumprate)));
                       	  acidInjectionPlan.setInjPressPsi((new BigDecimal(pumpinperessurepsi)));
                       	  acidInjectionPlan.setInjDefthFt((new BigDecimal(injectiondefth)));
                       	  acidInjectionPlan.setEntityFricLoss((new BigDecimal(enterpricpress)));
                       	  acidinjectionDataList.add(acidInjectionPlan);
                       	  
                       	 // acidInjectionPlan.setProjectTbl(projectTbl);
                      }
                      
              
          }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return acidinjectionDataList;
		 
	}
	
	
	public ArrayList<WelCompletionDataTbl>  getwelCompletionDataTbl(File file)
	{
		ArrayList<WelCompletionDataTbl> getlistdatwelCompletionDataTbl=new ArrayList<WelCompletionDataTbl>();
		
		WelCompletionDataTbl welCompletionDataTbl=new WelCompletionDataTbl();
        // Cell cell = sheet.getCell(1, 7);
		
		try
		{
			FileInputStream input = new FileInputStream(file);
	        Workbook w=Workbook.getWorkbook(input);
	        Sheet sheet = w.getSheet(0);
	          
	         welCompletionDataTbl.setWellType(sheet.getCell(22,7).getContents());
	         welCompletionDataTbl.setCompletionType(sheet.getCell(24,7).getContents());
	         welCompletionDataTbl.setWellDiaInch(new BigDecimal(sheet.getCell(22,8).getContents().toString()));
	         welCompletionDataTbl.setPerfDiaInch(new BigDecimal(sheet.getCell(24,8).getContents().toString()));
	         welCompletionDataTbl.setWellMdFt(new BigDecimal(sheet.getCell(22,9).getContents().toString()));
	         welCompletionDataTbl.setWellTvdFt(new BigDecimal(sheet.getCell(24,9).getContents().toString()));
	         welCompletionDataTbl.setLateralDefthFt(new BigDecimal(sheet.getCell(22,10).getContents().toString()));
	         welCompletionDataTbl.setLateraDefthFt(new BigDecimal(sheet.getCell(24,10).getContents().toString()));
	         getlistdatwelCompletionDataTbl.add(welCompletionDataTbl);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
         
         return getlistdatwelCompletionDataTbl;
		
	}
	
	
	
	public ArrayList<FluidPropertiesTbl> getFluidPropertiesTbl(File file)
	{
		
		ArrayList<FluidPropertiesTbl> getlistdataFluidPropertiesTbl=new ArrayList<FluidPropertiesTbl>();
		FluidPropertiesTbl fluidPropertiesTbl=new FluidPropertiesTbl();
		try
		{
			FileInputStream input = new FileInputStream(file);
	        Workbook w=Workbook.getWorkbook(input);
	        Sheet sheet = w.getSheet(0);
		
		
        fluidPropertiesTbl.setAcidDensityKgM3(new BigDecimal(sheet.getCell(22,14).getContents().toString()));
        fluidPropertiesTbl.setAcidDissolvingPower(new BigDecimal(sheet.getCell(24,14).getContents().toString()));
        fluidPropertiesTbl.setResOilDensityKgM3(new BigDecimal(sheet.getCell(22,15).getContents().toString()));
        fluidPropertiesTbl.setResOilVisCp(new BigDecimal(sheet.getCell(24,15).getContents().toString()));
        fluidPropertiesTbl.setResWaterDensityKgM3(new BigDecimal(sheet.getCell(22,16).getContents().toString()));
        fluidPropertiesTbl.setResWaterViscCp(new BigDecimal(sheet.getCell(24,16).getContents().toString()));
        fluidPropertiesTbl.setResGasDensityKgM3(new BigDecimal(sheet.getCell(22,17).getContents().toString()));
        fluidPropertiesTbl.setResGasVisCp(new BigDecimal(sheet.getCell(24,17).getContents().toString()));
        
        
        getlistdataFluidPropertiesTbl.add(fluidPropertiesTbl);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return getlistdataFluidPropertiesTbl;
        
	}
	
	
	public ArrayList<AdditionalInpuDataTbl> getAdditionalInpuDataTbl(File file)
	{
		ArrayList<AdditionalInpuDataTbl> getlistdataAdditionalInpuDataTbl=new ArrayList<AdditionalInpuDataTbl>();
		
		AdditionalInpuDataTbl additionalInpuDataTbl=new AdditionalInpuDataTbl();
        
		try
		{
		
			FileInputStream input = new FileInputStream(file);
	        Workbook w=Workbook.getWorkbook(input);
	        Sheet sheet = w.getSheet(0);	
			
		String simulationtype=sheet.getCell(22,21).getContents().toString();
        
        additionalInpuDataTbl.setStimulationType(sheet.getCell(22,21).getContents().toString());
        additionalInpuDataTbl.setJetDiaInch(new BigDecimal(sheet.getCell(24,21).getContents().toString()));
        additionalInpuDataTbl.setMaxPressPsi(new BigDecimal(sheet.getCell(22,22).getContents().toString()));
        additionalInpuDataTbl.setFracPressPsi(new BigDecimal(sheet.getCell(24,22).getContents().toString()));
        additionalInpuDataTbl.setTubFrictionCoff(new BigDecimal(sheet.getCell(22,23).getContents().toString()));
        additionalInpuDataTbl.setFormVolumeFactor(new BigDecimal(sheet.getCell(24,23).getContents().toString()));
        additionalInpuDataTbl.setDriverterConstK(new BigDecimal(sheet.getCell(22,24).getContents().toString()));
        additionalInpuDataTbl.setDiverterCosntN(new BigDecimal(sheet.getCell(24,24).getContents().toString()));
        additionalInpuDataTbl.setRockDensityKg(new BigDecimal(sheet.getCell(22,25).getContents().toString()));
        additionalInpuDataTbl.setFracLenthInch(new BigDecimal(sheet.getCell(24,25).getContents().toString()));
        additionalInpuDataTbl.setNoOfTimepsteps(new BigDecimal(sheet.getCell(22,26).getContents().toString()));
        additionalInpuDataTbl.setNoOfGrids(new BigDecimal(sheet.getCell(24,26).getContents().toString()));
        additionalInpuDataTbl.setPostProdBbls(new BigDecimal(sheet.getCell(22,27).getContents().toString()));
        additionalInpuDataTbl.setPostProdAtPressPsi(new BigDecimal(sheet.getCell(24,27).getContents().toString()));
        additionalInpuDataTbl.setFracAppertureFt(new BigDecimal(sheet.getCell(22,28).getContents().toString()));
        additionalInpuDataTbl.setFracLengthFt(new BigDecimal(sheet.getCell(24,28).getContents().toString()));
        getlistdataAdditionalInpuDataTbl.add(additionalInpuDataTbl);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return getlistdataAdditionalInpuDataTbl;
	}
	
	
	
	
	public ArrayList<SensitivityAnalysisTbl> getSensitivityAnalysisTbl(File file)
	{
		 ArrayList<SensitivityAnalysisTbl> listdataofSensitivityAnalysisTbls=new ArrayList<SensitivityAnalysisTbl>();
         
        try
        {
		 for(int i=36; i<42; i++)
         {
      	   SensitivityAnalysisTbl sensitivityAnalysisTbl=new SensitivityAnalysisTbl();
      	    FileInputStream input = new FileInputStream(file);
	        Workbook w=Workbook.getWorkbook(input);
	        Sheet sheet = w.getSheet(0);
      	  
      	   sensitivityAnalysisTbl.setSensitivityAnalysisName(sheet.getCell(21,i).getContents().toString());
      	   sensitivityAnalysisTbl.setCase1(new BigDecimal(sheet.getCell(22,i).getContents().toString()));
      	   sensitivityAnalysisTbl.setCase2(new BigDecimal(sheet.getCell(23,i).getContents().toString()));
      	   sensitivityAnalysisTbl.setCase3(new BigDecimal(sheet.getCell(24,i).getContents().toString()));
      	   listdataofSensitivityAnalysisTbls.add(sensitivityAnalysisTbl);
      	   
      	   //sensitivityAnalysisTbl.set
      	   
      	   
         }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		return listdataofSensitivityAnalysisTbls;
	}
	
	
	
           
           
         /* 
           System.out.println("welCompletionDataTbl"+fluidPropertiesTbl.getAcidDensityKgM3()+fluidPropertiesTbl.getAcidDissolvingPower()+fluidPropertiesTbl.getResOilDensityKgM3()
        		   +fluidPropertiesTbl.getResOilVisCp()+fluidPropertiesTbl.getResGasDensityKgM3()+fluidPropertiesTbl.getResGasVisCp()
        		   );
           
           
           AdditionalInpuDataTbl additionalInpuDataTbl=new AdditionalInpuDataTbl();
           String simulationtype=sheet.getCell(22,21).getContents().toString();
           
           additionalInpuDataTbl.setStimulationType(sheet.getCell(22,21).getContents().toString());
           additionalInpuDataTbl.setJetDiaInch(new BigDecimal(sheet.getCell(24,21).getContents().toString()));
           additionalInpuDataTbl.setMaxPressPsi(new BigDecimal(sheet.getCell(22,22).getContents().toString()));
           additionalInpuDataTbl.setFracPressPsi(new BigDecimal(sheet.getCell(24,22).getContents().toString()));
           additionalInpuDataTbl.setTubFrictionCoff(new BigDecimal(sheet.getCell(22,23).getContents().toString()));
           additionalInpuDataTbl.setFormVolumeFactor(new BigDecimal(sheet.getCell(24,23).getContents().toString()));
           additionalInpuDataTbl.setDriverterConstK(new BigDecimal(sheet.getCell(22,24).getContents().toString()));
           additionalInpuDataTbl.setDiverterCosntN(new BigDecimal(sheet.getCell(24,24).getContents().toString()));
           additionalInpuDataTbl.setRockDensityKg(new BigDecimal(sheet.getCell(22,25).getContents().toString()));
           additionalInpuDataTbl.setFracLenthInch(new BigDecimal(sheet.getCell(24,25).getContents().toString()));
           additionalInpuDataTbl.setNoOfTimepsteps(new BigDecimal(sheet.getCell(22,26).getContents().toString()));
           additionalInpuDataTbl.setNoOfGrids(new BigDecimal(sheet.getCell(24,26).getContents().toString()));
           additionalInpuDataTbl.setPostProdBbls(new BigDecimal(sheet.getCell(22,27).getContents().toString()));
           additionalInpuDataTbl.setPostProdAtPressPsi(new BigDecimal(sheet.getCell(24,27).getContents().toString()));
           additionalInpuDataTbl.setFracAppertureFt(new BigDecimal(sheet.getCell(22,28).getContents().toString()));
           additionalInpuDataTbl.setFracLengthFt(new BigDecimal(sheet.getCell(24,28).getContents().toString()));
           
           
         ArrayList<SensitivityAnalysisTbl> listdataofSensitivityAnalysisTbls=new ArrayList<SensitivityAnalysisTbl>();
           
           for(int i=36; i<43; i++)
           {
        	   SensitivityAnalysisTbl sensitivityAnalysisTbl=new SensitivityAnalysisTbl();
        	   
        	  
        	   sensitivityAnalysisTbl.setSensitivityAnalysisName(sheet.getCell(21,i).getContents().toString());
        	   sensitivityAnalysisTbl.setCase1(new BigDecimal(sheet.getCell(22,i).getContents().toString()));
        	   sensitivityAnalysisTbl.setCase2(new BigDecimal(sheet.getCell(23,i).getContents().toString()));
        	   sensitivityAnalysisTbl.setCase3(new BigDecimal(sheet.getCell(24,i).getContents().toString()));
        	   listdataofSensitivityAnalysisTbls.add(sensitivityAnalysisTbl);
        	   
        	   //sensitivityAnalysisTbl.set
        	   
        	   
           }
           
           
           
            
            input.close();
            System.out.println("Success import excel to mysql table");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

*/}