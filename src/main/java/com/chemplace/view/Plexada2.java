package com.chemplace.view;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.chemplace.view.model.beans.AcidInjectionTbl;
import com.chemplace.view.model.beans.ReservoirlethologyTbl;
import com.chemplace.view.model.beans.SensitivityAnalysisTbl;


public class Plexada2 {
  public static void main(String[] args) {
        	
        
        	try {
        		String yemi = "test.xls";
        	    FileOutputStream fileOut = new FileOutputStream(yemi);
        	    FileOutputStream fileOut1 = new FileOutputStream(yemi);
        	    
        		Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chemplaceproddb","postgres", "wsmrt12345");
               // Connection con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chemplaceproddb","postgres", "wsmrt12345");
                
                
                Statement st = con.createStatement();
                Statement st1 = con.createStatement();
                Statement st2 = con.createStatement();
                Statement st3 = con.createStatement();
                Statement st4 = con.createStatement();
                
                HSSFWorkbook workbook = new HSSFWorkbook();
        	    HSSFSheet sheet = workbook.createSheet("Chemplace_Input");
        	    HSSFRow rowhead = sheet.createRow((short) 0);
        	    
        	    //All Column Header name 	    
                rowhead.createCell((short) 0).setCellValue("ProjectName");
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
												
								
								
								
				    
        	   //well name and data completion data table 
        	    int i = 1;
        	    HSSFRow row = sheet.createRow((short) i);
        	    ResultSet rs = st.executeQuery("SELECT c. project_name,a.well_name,c.chemical_name,c.company_name,x.user_name,a.no_of_layers,a.no_of_stages,b.well_type,b.completion_type,b.well_dia_inch,b.perf_dia_inch,b.well_md_ft,b.well_tvd_ft,b.lateral_defth_ft,b.latera_defth_ft FROM well_layers_stage_tbl a,wel_completion_data_tbl b,project_tbl c, user_tbl x where c.project_id=a.project_id and c.project_id=b.project_id and x.user_id=c.user_id and c.project_id=166");
          	  
        	    while (rs.next()){
        	    	        	   
             	    row.createCell((short) 0).setCellValue(rs.getString("project_name"));
             	    row.createCell((short) 1).setCellValue(rs.getString("well_name"));
             	    row.createCell((short) 2).setCellValue(rs.getString("chemical_name"));
             	    row.createCell((short) 3).setCellValue(rs.getString("company_name"));
             	    row.createCell((short) 4).setCellValue(rs.getString("user_name"));
        	        row.createCell((short) 5).setCellValue(rs.getString("no_of_layers"));
        	        row.createCell((short) 6).setCellValue(rs.getString("no_of_stages"));
        	        row.createCell((short) 7).setCellValue(rs.getString("well_type"));
        	        row.createCell((short) 8).setCellValue(rs.getString("completion_type"));
        	        row.createCell((short) 9).setCellValue(rs.getString("well_dia_inch"));
        	        row.createCell((short) 10).setCellValue(rs.getString("perf_dia_inch"));
        	        row.createCell((short) 11).setCellValue(rs.getString("well_md_ft"));
        	        row.createCell((short) 12).setCellValue(rs.getString("well_tvd_ft"));
        	        row.createCell((short) 13).setCellValue(rs.getString("lateral_defth_ft"));
        	        row.createCell((short) 14).setCellValue(rs.getString("latera_defth_ft"));
        	    }
        	       
        	        //additional input and fluid properties and analysis case 
        	        ResultSet    rs3 = st3.executeQuery("Select h.acid_density_kg_m3,h.acid_dissolving_power,h.res_oil_density_kg_m3,h.res_oil_vis_cp,h.res_water_density_kg_m3,h.res_water_visc_cp,h.res_gas_density_kg_m3,h.res_gas_vis_cp,j.stimulation_type,j.jet_dia_inch,j.max_press_psi,j.frac_press_psi,j.tub_friction_coff,j.form_vol_factor,j.driverter_const_k,j.diverter_cosnt_n,j.rock_density_kg,j.frac_lenth_inch,j.no_of_timepsteps,j.no_of_grids,j.post_prod_bbls,j.post_prod_at_press_psi,j.frac_apperture_ft,j.frac_length_ft FROM fluid_properties_tbl h , additional_inpu_data_tbl j ,project_tbl i where h.project_id=i.project_id and j.project_id=i.project_id and i.project_id=166");
	                while (rs3.next()){
	             	    //fluid properties
	                	  row.createCell(31).setCellValue(rs3.getString("acid_density_kg_m3"));
            	    	  row.createCell(32).setCellValue(rs3.getString("acid_dissolving_power"));
            	    	  row.createCell(33).setCellValue(rs3.getString("res_oil_density_kg_m3"));
            	    	  row.createCell(34).setCellValue(rs3.getString("res_oil_vis_cp"));
            	    	  row.createCell(35).setCellValue(rs3.getString("res_water_density_kg_m3"));
            	    	  row.createCell(36).setCellValue(rs3.getString("res_water_visc_cp"));
            	    	  row.createCell(37).setCellValue(rs3.getString("res_gas_density_kg_m3"));
            	    	  row.createCell(38).setCellValue(rs3.getString("res_gas_vis_cp"));
            	   	      //additional data
            	    	  row.createCell(39).setCellValue(rs3.getString("stimulation_type"));
            	    	  row.createCell(40).setCellValue(rs3.getString("jet_dia_inch"));
            	    	  row.createCell(41).setCellValue(rs3.getString("max_press_psi"));
            	    	  row.createCell(42).setCellValue(rs3.getString("frac_press_psi"));
            	    	  row.createCell(43).setCellValue(rs3.getString("tub_friction_coff"));
            	    	  row.createCell(44).setCellValue(rs3.getString("form_vol_factor"));
            	    	  row.createCell(45).setCellValue(rs3.getString("driverter_const_k"));
            	    	  row.createCell(46).setCellValue(rs3.getString("diverter_cosnt_n"));    	   	  
            	    	  row.createCell(47).setCellValue(rs3.getString("rock_density_kg"));
            	    	  row.createCell(48).setCellValue(rs3.getString("frac_lenth_inch"));
            	    	  row.createCell(49).setCellValue(rs3.getString("no_of_timepsteps"));
            	    	  row.createCell(50).setCellValue(rs3.getString("no_of_grids"));
            	    	  row.createCell(51).setCellValue(rs3.getString("post_prod_bbls"));
            	    	  row.createCell(52).setCellValue(rs3.getString("post_prod_at_press_psi"));
            	    	  row.createCell(53).setCellValue(rs3.getString("frac_apperture_ft"));
            	    	  row.createCell(54).setCellValue(rs3.getString("frac_length_ft"));
            	   	   
        	    }
	                ResultSet   rs4 = st4.executeQuery("SELECT sensitivity_analysis_name,case1, case2, case3 FROM sensitivity_analysis_tbl k ,project_tbl l where l.project_id=k.project_id and l.project_id=166");
	                
	       	        ArrayList<SensitivityAnalysisTbl> listdatasensitvetable=new ArrayList<SensitivityAnalysisTbl>();
	       	    	 
	       	     while (rs4.next()){
	       	    	 SensitivityAnalysisTbl sensitivityAnalysisTbl1=new SensitivityAnalysisTbl(); 
	       	 	     sensitivityAnalysisTbl1.setSensitivityAnalysisName(rs4.getString("sensitivity_analysis_name"));
	       	    	 sensitivityAnalysisTbl1.setCase1(InputModuleAcid_Carbonate.getBigDecimal(rs4.getString("case1")));
	       	 	     sensitivityAnalysisTbl1.setCase2(InputModuleAcid_Carbonate.getBigDecimal(rs4.getString("case2")));
	       	 	     sensitivityAnalysisTbl1.setCase3(InputModuleAcid_Carbonate.getBigDecimal(rs4.getString("case3")));
	       	 	     
	       	 	      listdatasensitvetable.add(sensitivityAnalysisTbl1);
	       	    	 
	       	     }   
        	              	        
        	    //Reservior methology    
       	        ResultSet    rs1 = st1.executeQuery("select d.form_defth_ft,d.to_defth_ft,d.tvd_ft,d.perm_md,d.poro,d.zone_press_psi,d.pre_stim_skin,d.fluid_in_place FROM reservoirlethology_tbl d,project_tbl f where f.project_id=d.project_id and f.project_id=166");
               
       	        List<ReservoirlethologyTbl> listdatreservoirthology=new ArrayList<ReservoirlethologyTbl>();
       	        while (rs1.next()){
       	        ReservoirlethologyTbl reservoirlethologyTbl=new ReservoirlethologyTbl();
       	       reservoirlethologyTbl.setFormDefthFt(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("form_defth_ft")));
       	   	   reservoirlethologyTbl.setToDefthFt(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("to_defth_ft")));
       	   	   reservoirlethologyTbl.setTvdFt(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("tvd_ft")));
       	   	   reservoirlethologyTbl.setPermMd(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("perm_md")));
       	       reservoirlethologyTbl.setPoro(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("poro")));
       		   reservoirlethologyTbl.setZonePressPsi(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("zone_press_psi")));
        	   reservoirlethologyTbl.setPreStimSkin(InputModuleAcid_Carbonate.getBigDecimal(rs1.getString("pre_stim_skin")));
        	  reservoirlethologyTbl.setFluidInPlace(rs1.getString("fluid_in_place"));
        	  listdatreservoirthology.add(reservoirlethologyTbl);
       	   	   
       	   
       	   	 
       	      
       	     }
       	        ResultSet   rs2 = st2.executeQuery("select e.stage,e.stavage_vol_bbls,e.conc,e.vise,e.pump_rate_bmp,e.inj_press_psi,e.inj_defth_ft,e.entity_fric_loss  from acid_injection_tbl e,project_tbl f where f.project_id=e.project_id and f.project_id=166");
                   
                List<AcidInjectionTbl> tablelistdata=new ArrayList<AcidInjectionTbl>();
                while (rs2.next()){
                	AcidInjectionTbl acidInjectionTbl=new AcidInjectionTbl();
                	acidInjectionTbl.setStage(rs2.getString("stage"));
                	acidInjectionTbl.setStavageVolBbls(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("stavage_vol_bbls")));
                	acidInjectionTbl.setConc(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("conc")));
                	acidInjectionTbl.setVise(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("vise")));
                	acidInjectionTbl.setPumpRateBmp(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("pump_rate_bmp")));
                	acidInjectionTbl.setInjPressPsi(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("inj_press_psi")));
                	acidInjectionTbl.setInjDefthFt(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("inj_defth_ft")));
                	acidInjectionTbl.setEntityFricLoss(InputModuleAcid_Carbonate.getBigDecimal(rs2.getString("entity_fric_loss")));
                	
                	tablelistdata.add(acidInjectionTbl);
                	
                }
                int size=0;


                  
                if ( listdatreservoirthology.size() > tablelistdata.size() && listdatreservoirthology.size()  > listdatasensitvetable.size() )
                   size=listdatreservoirthology.size();
               else if (  tablelistdata.size() > listdatreservoirthology.size() && tablelistdata.size()  > listdatasensitvetable.size() )
                	 size=tablelistdata.size();
               else if ( listdatasensitvetable.size() > listdatreservoirthology.size() && listdatasensitvetable.size() > tablelistdata.size() )
                    size=listdatasensitvetable.size();
                    
       	         
       	        	 for(int k=0;k<size; k++)
       	        	 {
	             	      if(k<listdatreservoirthology.size())
	             	      {
       	        		  row.createCell(15).setCellValue(listdatreservoirthology.get(k).getFormDefthFt().toString());
            	    	  row.createCell(16).setCellValue(listdatreservoirthology.get(k).getToDefthFt().toString());
            	    	  row.createCell(17).setCellValue(listdatreservoirthology.get(k).getTvdFt().toString());
            	    	  row.createCell(18).setCellValue(listdatreservoirthology.get(k).getPermMd().toString());
            	    	  row.createCell(19).setCellValue(listdatreservoirthology.get(k).getPoro().toString());
            	    	  row.createCell(20).setCellValue(listdatreservoirthology.get(k).getZonePressPsi().toString());
            	    	  row.createCell(21).setCellValue(listdatreservoirthology.get(k).getPreStimSkin().toString());
            	    	  row.createCell(22).setCellValue(listdatreservoirthology.get(k).getFluidInPlace());
	             	      }
	             	      if(k<tablelistdata.size())
	             	      {
            	    	  row.createCell((short) 23).setCellValue(tablelistdata.get(k).getStage());
    	                  row.createCell((short) 24).setCellValue(tablelistdata.get(k).getStavageVolBbls().toString());
    	                  row.createCell((short) 25).setCellValue(tablelistdata.get(k).getConc().toString());
    	                  row.createCell((short) 26).setCellValue(tablelistdata.get(k).getVise().toString());
    	                  row.createCell((short) 27).setCellValue(tablelistdata.get(k).getPumpRateBmp().toString());
    	                  row.createCell((short) 28).setCellValue(tablelistdata.get(k).getInjPressPsi().toString());
    	                  row.createCell((short) 29).setCellValue(tablelistdata.get(k).getInjDefthFt().toString());
    	                  row.createCell((short) 30).setCellValue(tablelistdata.get(k).getEntityFricLoss().toString());
	             	      }
	             	      if(k<listdatasensitvetable.size())
	             	      {
	             	     row.createCell((short) 55).setCellValue(listdatasensitvetable.get(k).getSensitivityAnalysisName());
		                  row.createCell((short) 56).setCellValue(listdatasensitvetable.get(k).getCase1().toString());
		                  row.createCell((short) 57).setCellValue(listdatasensitvetable.get(k).getCase2().toString());
		                  row.createCell((short) 58).setCellValue(listdatasensitvetable.get(k).getCase3().toString());
	             	      }
            	         ++ i;
            	       row = sheet.createRow((short) i);  	 
       	        }
	             //acid injection plan
	                 /* int i2=3;
	                 ResultSet   rs2 = st2.executeQuery("select e.stage,e.stavage_vol_bbls,e.conc,e.vise,e.pump_rate_bmp,e.inj_press_psi,e.inj_defth_ft,e.entity_fric_loss  from acid_injection_tbl e,project_tbl f where f.project_id=e.project_id and f.project_id=166");
	               
	                 while (rs2.next()){
	                  row.createCell((short) 23).setCellValue(rs2.getString("stage"));
	                  row.createCell((short) 24).setCellValue(rs2.getString("stavage_vol_bbls"));
	                  row.createCell((short) 25).setCellValue(rs2.getString("conc"));
	                  row.createCell((short) 26).setCellValue(rs2.getString("vise"));
	                  row.createCell((short) 27).setCellValue(rs2.getString("pump_rate_bmp"));
	                  row.createCell((short) 28).setCellValue(rs2.getString("inj_press_psi"));
	                  row.createCell((short) 29).setCellValue(rs2.getString("inj_defth_ft"));
	                  row.createCell((short) 30).setCellValue(rs2.getString("entity_fric_loss"));
	                 ++ i2;
          	         row = sheet.createRow((short) i2);  	
	                } */
          	     
 	            
	         /*  int i3=3;
	                ResultSet   rs4 = st4.executeQuery("SELECT sensitivity_analysis_name,case1, case2, case3 FROM sensitivity_analysis_tbl k ,project_tbl l where l.project_id=k.project_id and l.project_id=166");
	                while (rs4.next()){
	                  row.createCell((short) 55).setCellValue(rs4.getString("sensitivity_analysis_name"));
	                  row.createCell((short) 56).setCellValue(rs4.getString("case1"));
	                  row.createCell((short) 57).setCellValue(rs4.getString("case2"));
	                  row.createCell((short) 58).setCellValue(rs4.getString("case3"));
	   
	                 i3++;
        	       row = sheet.createRow((short) i3);  	
	                }
	         	            */
        	   
        	    workbook.write(fileOut);
        	    fileOut.close();
        	    
        	    
        	}
        	    catch (ClassNotFoundException e1) {
        	       e1.printStackTrace();
        	    } catch (SQLException e1) {
        	        e1.printStackTrace();
        	    } catch (FileNotFoundException e1) {
        	        e1.printStackTrace();
        	    } catch (IOException e1) {
        	        e1.printStackTrace();
        	    }
             }
}
        