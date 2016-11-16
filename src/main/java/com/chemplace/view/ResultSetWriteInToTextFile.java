package com.chemplace.view;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class ResultSetWriteInToTextFile {
    public static void main(String[] args) {
    	List<String> data = new ArrayList<String>();
            List list;
            try {
                    
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/chemplaceproddb","postgres", "wsmrt12345");
                    Statement st = con.createStatement();
                    Statement st1 = con.createStatement();
                    Statement st2 = con.createStatement();
                    Statement st3 = con.createStatement();
                    Statement st4 = con.createStatement();
                    
                      ResultSet rs = st.executeQuery("SELECT c. project_name,a.well_name,c.chemical_name,c.company_name,x.user_name,a.no_of_layers,a.no_of_stages,b.well_type,b.completion_type,b.well_dia_inch,b.perf_dia_inch,b.well_md_ft,b.well_tvd_ft,b.lateral_defth_ft,b.latera_defth_ft FROM well_layers_stage_tbl a,wel_completion_data_tbl b,project_tbl c, user_tbl x where c.project_id=a.project_id and c.project_id=b.project_id and x.user_id=c.user_id and c.project_id=166");
                	  
                      //well name and data completion 
                    while (rs.next()) {
                           data.add("ProjectName="+rs.getString("project_name"));
                           data.add("WellName="+rs.getString("well_name"));
                           data.add("ChemicalName="+rs.getString("chemical_name"));
                           data.add("CompanyName="+rs.getString("company_name"));	
						   data.add("UserName="+rs.getString("user_name"));
                           data.add("NoofLayers="+rs.getString("no_of_layers"));
                           data.add("NOofStages="+rs.getString("no_of_stages"));
						   data.add("WellType="+rs.getString("well_type"));	
						   data.add("CompletionType="+rs.getString("completion_type"));
                           data.add("WellDiaInch="+rs.getString("well_dia_inch"));
                           data.add("PerfDiaInch="+rs.getString("perf_dia_inch"));
                           data.add("WellMDFT="+rs.getString("well_md_ft"));	
						   data.add("WellTVDFT="+rs.getString("well_tvd_ft"));
                           data.add("LateralDefthFT="+rs.getString("lateral_defth_ft"));
                           data.add("LateraDefthFT="+rs.getString("latera_defth_ft"));
                       }
                    
            	    //Reservior methology    
                    ResultSet    rs1 = st1.executeQuery("select d.form_defth_ft,d.to_defth_ft,d.tvd_ft,d.perm_md,d.poro,d.zone_press_psi,d.pre_stim_skin,d.fluid_in_place FROM reservoirlethology_tbl d,acid_injection_tbl e,project_tbl f where f.project_id=d.project_id and f.project_id=166");
                    int i=0;
                    while (rs1.next()){
	             	    data.add("FormDefthFT"+i+"="+rs1.getString("form_defth_ft"));
                        data.add("ToDefthFT"+i+"="+rs1.getString("to_defth_ft"));
                        data.add("TVDFT"+i+"="+rs1.getString("tvd_ft"));
                        data.add("PermMD"+i+"="+rs1.getString("perm_md"));
						data.add("Poro"+i+"="+rs1.getString("poro"));
                        data.add("ZonePressPSI"+i+"="+rs1.getString("zone_press_psi"));
                        data.add("PreStimSkin"+i+"="+rs1.getString("pre_stim_skin"));
                        data.add("FluidInPlace"+i+"="+rs1.getString("fluid_in_place"));
                       i++;            	     	 
        	    }
                    
                    
                    
                    //acid injection plan
                    ResultSet   rs2 = st2.executeQuery("select e.stage,e.stavage_vol_bbls,e.conc,e.vise,e.pump_rate_bmp,e.inj_press_psi,e.inj_defth_ft,e.entity_fric_loss  from acid_injection_tbl e,project_tbl f where f.project_id=e.project_id and f.project_id=166");
 	               int i1 = 0;
	                 while (rs2.next()){
	                	  data.add("Stage"+i1+"="+rs2.getString("stage"));
	                	  data.add("StavageVolBbls"+i1+"="+rs2.getString("stavage_vol_bbls"));
	                	  data.add("Conc"+i1+"="+rs2.getString("conc"));
	                	  data.add("Vise"+i1+"="+rs2.getString("vise"));
	                	  data.add("PumpRateBMP"+i1+"="+rs2.getString("pump_rate_bmp"));
	                	  data.add("InjPressPSI"+i1+"="+rs2.getString("inj_press_psi"));
	                	  data.add("InjDefthFT"+i1+"="+rs2.getString("inj_defth_ft"));
	                	  data.add("EntityFricLoss"+i1+"="+rs2.getString("entity_fric_loss"));  
	                	  i1++;
	                } 
                    
	                 //additional input and fluid properties and analysis case 
	        	           ResultSet    rs3 = st3.executeQuery("Select h.acid_density_kg_m3,h.acid_dissolving_power,h.res_oil_density_kg_m3,h.res_oil_vis_cp,h.res_water_density_kg_m3,h.res_water_visc_cp,h.res_gas_density_kg_m3,h.res_gas_vis_cp,j.stimulation_type,j.jet_dia_inch,j.max_press_psi,j.frac_press_psi,j.tub_friction_coff,j.form_vol_factor,j.driverter_const_k,j.diverter_cosnt_n,j.rock_density_kg,j.frac_lenth_inch,j.no_of_timepsteps,j.no_of_grids,j.post_prod_bbls,j.post_prod_at_press_psi,j.frac_apperture_ft,j.frac_length_ft FROM fluid_properties_tbl h , additional_inpu_data_tbl j ,project_tbl i where h.project_id=i.project_id and j.project_id=i.project_id and i.project_id=166");
		                   while (rs3.next()){
		             	    //fluid properties
		                	   data.add("AcidDensityKGM3="+rs3.getString("acid_density_kg_m3"));
		                	   data.add("AcidDissolvingPower="+rs3.getString("acid_dissolving_power"));
		                	    data.add("ResOilDensityKGM3="+rs3.getString("res_oil_density_kg_m3"));
		                	    data.add("ResOilVisCP="+rs3.getString("res_oil_vis_cp"));
		                	     data.add("ResWaterDensityKGM3="+rs3.getString("res_water_density_kg_m3")); 
		                	     data.add("ResWaterViscCP="+rs3.getString("res_water_visc_cp"));
		                	      data.add("ResGasDensityKGM3="+rs3.getString("res_gas_density_kg_m3"));
		                	  	 data.add("ResGasVisCP="+rs3.getString("res_gas_vis_cp"));
		                	  	 //additional data
		                	  	  data.add("StimulationType="+rs3.getString("stimulation_type"));
		                	  	   data.add("JetDiaInch="+rs3.getString("jet_dia_inch"));
		                	  	    data.add("MaxPressPSI="+rs3.getString("max_press_psi"));
		                	  		 data.add("FracPressPSI="+rs3.getString("frac_press_psi")); 
		                	  		 data.add("TubFrictionCoff="+rs3.getString("tub_friction_coff"));
		                	  		  data.add("FormVolFactor="+rs3.getString("form_vol_factor"));
		                	  		   data.add("DriverterConstK="+rs3.getString("driverter_const_k"));
		                	  	   data.add("DiverterCosntN="+rs3.getString("diverter_cosnt_n"));
		                	  	    data.add("RockDensityKG="+rs3.getString("rock_density_kg"));
		                	  		 data.add("FracLenthInch="+rs3.getString("frac_lenth_inch")); 
		                	  		 data.add("NoOfTimepsteps="+rs3.getString("no_of_timepsteps"));
		                	  		  data.add("NoOfGrids="+rs3.getString("no_of_grids"));
		                	  	     data.add("PostProdBbls="+rs3.getString("post_prod_bbls"));
		                	  	    data.add("PostProdAtPressPSI="+rs3.getString("post_prod_at_press_psi"));
		                	  		 data.add("FracAppertureFT="+rs3.getString("frac_apperture_ft")); 
		                	  		 data.add("FracLengthFT="+rs3.getString("frac_length_ft"));
	            	   	   
	        	    }
	                 
		                 //Sensivity analysis
			                 int i4=0;
			                ResultSet   rs4 = st4.executeQuery("SELECT sensitivity_analysis_name,case1, case2, case3 FROM sensitivity_analysis_tbl k ,project_tbl l where l.project_id=k.project_id and l.project_id=166");
			                while (rs4.next()){
			                 
			                	  data.add("SensitivityAnalysisName_"+i4+"="+rs4.getString("sensitivity_analysis_name"));
			                	  data.add("Case1_"+i4+"="+rs4.getString("case1"));
			                	  data.add("Case2_"+i4+"="+rs4.getString("case2"));
			                	  data.add("Case3_"+i4+"="+rs4.getString("case3"));
			                	 
			                  i4++;
		          	  	
			                }
			                
	                                     
                    writeToFile(data, "Chapmlaceinput.txt");
                
            } catch (Exception e) {
                    System.out.println(e);
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