package com.chemplace.view;

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

public class TestApp1 {

    public static void main(String[] args) throws Exception {
    	 ArrayList<ReservoirlethologyTbl> listdatareservoirlethologyTbl=null;
    	 ArrayList<AcidInjectionTbl>  acidinjectionDataList=null;
        try {

            /*Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/test","root","root");
            con.setAutoCommit(false);
            PreparedStatement pstm = null ;*/
            FileInputStream input = new FileInputStream("Data.xls");
            Workbook w=Workbook.getWorkbook(input);
            Sheet sheet = w.getSheet(0);
            
           
            
           
            listdatareservoirlethologyTbl=new ArrayList<ReservoirlethologyTbl>();
             acidinjectionDataList=new ArrayList<AcidInjectionTbl>();
            for (int i =7; i <=sheet.getRows(); i++) {
                Cell cell = sheet.getCell(1, 7);
                CellType type = cell.getType();
                 /**/
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
            
            for (int i =7; i <=sheet.getRows(); i++) {
                Cell cell = sheet.getCell(1, 7);
                CellType type = cell.getType();
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
            
           WelCompletionDataTbl welCompletionDataTbl=new WelCompletionDataTbl();
          // Cell cell = sheet.getCell(1, 7);
           
            
           welCompletionDataTbl.setWellType(sheet.getCell(22,7).getContents());
           welCompletionDataTbl.setCompletionType(sheet.getCell(24,7).getContents());
           welCompletionDataTbl.setWellDiaInch(new BigDecimal(sheet.getCell(22,8).getContents().toString()));
           welCompletionDataTbl.setPerfDiaInch(new BigDecimal(sheet.getCell(24,8).getContents().toString()));
           welCompletionDataTbl.setWellMdFt(new BigDecimal(sheet.getCell(22,9).getContents().toString()));
           welCompletionDataTbl.setWellTvdFt(new BigDecimal(sheet.getCell(24,9).getContents().toString()));
           welCompletionDataTbl.setLateralDefthFt(new BigDecimal(sheet.getCell(22,10).getContents().toString()));
           welCompletionDataTbl.setLateraDefthFt(new BigDecimal(sheet.getCell(24,10).getContents().toString()));
           
           System.out.println("welCompletionDataTbl"+welCompletionDataTbl.getWellType()+welCompletionDataTbl.getCompletionType()+
        		   welCompletionDataTbl.getWellDiaInch()+welCompletionDataTbl.getPerfDiaInch()+welCompletionDataTbl.getWellMdFt()+welCompletionDataTbl.getWellTvdFt()
        		   +welCompletionDataTbl.getLateralDefthFt()+welCompletionDataTbl.getLateralDefthFt());
           
           
           FluidPropertiesTbl fluidPropertiesTbl=new FluidPropertiesTbl();
           fluidPropertiesTbl.setAcidDensityKgM3(new BigDecimal(sheet.getCell(22,14).getContents().toString()));
           fluidPropertiesTbl.setAcidDissolvingPower(new BigDecimal(sheet.getCell(24,14).getContents().toString()));
           fluidPropertiesTbl.setResOilDensityKgM3(new BigDecimal(sheet.getCell(22,15).getContents().toString()));
           fluidPropertiesTbl.setResOilVisCp(new BigDecimal(sheet.getCell(24,15).getContents().toString()));
           fluidPropertiesTbl.setResGasDensityKgM3(new BigDecimal(sheet.getCell(22,16).getContents().toString()));
           fluidPropertiesTbl.setResGasVisCp(new BigDecimal(sheet.getCell(24,16).getContents().toString()));
           
           
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
           
           
           
           for(int i=0; i<acidinjectionDataList.size(); i++)
            {
            	System.out.println(acidinjectionDataList.size());
            }
            
            
           
           
           
            
            // POIFSFileSystem fs = new POIFSFileSystem(input);
            
           /*HSSFWorkbook wb = new HSSFWorkbook(fs);
             Sheet sheet = w.getSheet(0);
            
            ArrayList<ReservoirlethologyTbl> listdatareservoirlethologyTbl=new ArrayList<ReservoirlethologyTbl>();
            
            for(int i=8; i<=sheet.; i++){
            	
            	 Cell cell = sheet.getCell(1, i);
                 CellType type = cell.getType();
                 if (type == CellType.LABEL) {
                         System.out.println("I got a label "
                                         + cell.getContents());
                 }*/	
            	/*HSSFRow HSSFRow = sheet.getRow(i);
            	  HSSFRow row=sheet.getRow(i);
            	 
            	  
            	  HSSFCell cell=row.getCell(1);
            	  
            	  
            	  String fd=cell.getStringCellValue();
            	  System.out.println(fd);*/
            	 
                /* ReservoirlethologyTbl reservoirlethologyTbl=new ReservoirlethologyTbl();
                 System.out.println(((Row) row.getCell(0)).getPhysicalNumberOfCells());
                 String  fromFt=""+row.getCell(0).getNumericCellValue();
                 String toft=row.getCell(2).getStringCellValue();
                 String tvdft=row.getCell(3).getStringCellValue();		
                 String permMd=row.getCell(4).getStringCellValue();
                 String poro=row.getCell(5).getStringCellValue();
                 String ResPresspsi=row.getCell(6).getStringCellValue();
                 String prestimskin=row.getCell(7).getStringCellValue();
                 String resfluid=row.getCell(8).getStringCellValue();*/
                
                /* if(fromFt.equalsIgnoreCase("") && toft.equalsIgnoreCase("") && tvdft.equalsIgnoreCase("") && permMd.equalsIgnoreCase("") 
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
                 }*/
                 
                 
                
                /*String code = row.getCell(0).getStringCellValue();
                String desc = row.getCell(1).getStringCellValue();
                Date date = row.getCell(2).getDateCellValue();                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String Date = sdf.format(date);
                String callcode = row.getCell(3).getStringCellValue();
                Boolean status = row.getCell(4).getBooleanCellValue();
                String currency = row.getCell(5).getStringCellValue();*/
               /* String sql = "INSERT INTO Ocountry (OCCODE, OCDESC, OCDT, OCCALlCODE, OCINACTIVE, OCUCODE) VALUES('"+code+"','"+desc+"','"+date+"','"+callcode+"','"+status+"','"+currency+"')";
                pstm = (PreparedStatement) con.prepareStatement(sql);
                pstm.execute();*/
               /* System.out.println("Import rows "+i);*/
            
           /* con.commit();
            pstm.close();
            con.close();*/
            input.close();
            System.out.println("Success import excel to mysql table");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}