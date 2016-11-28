package com.chemplace.view.model.beans;



import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/** Assumes UTF-8 encoding. JDK 7+. */
public class ReadWithScanner {
   static ArrayList<OutputAcidPlacementTbl> listdatOutputAcidPlacementTbl;
   
  static ArrayList<OutputAcidPenetrationTbl> listadatOutputAcidPenetrationTbl;
   
  static ArrayList<OutputPostStimulationSkinTbl> listdataOutputPostStimulationSkinTbl;
  
   static ArrayList<OutputPostStimulationProductionTbl> listdataOutputPostStimulationProductionTbl;

    public static void main(String[] args) throws IOException {
        /**
         *  My Name is Pankaj
         *  My website is journaldev.com
         *  Phone : 1234567890
         */
        String fileName = "C:/Users/wesmarty pc 2/Desktop/output file format/ChemPlace Output File Formate.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        
        //read file line by line
        scanner.useDelimiter(System.getProperty("line.separator"));
        
        int acidplacement=0;
        int acidpenetration=0;
        int poststimulation=0;
        int ProposedStimulationDesign=0;
        listdatOutputAcidPlacementTbl=new ArrayList<OutputAcidPlacementTbl>();
        listadatOutputAcidPenetrationTbl=new ArrayList<OutputAcidPenetrationTbl>();
        listdataOutputPostStimulationSkinTbl=new ArrayList<OutputPostStimulationSkinTbl>();
        while(scanner.hasNext()){
        	 String getrowdata=scanner.next();
        	 System.out.println("getrowdta ="+getrowdata);
            //System.out.println("Lines: "+scanner.next());
           if(getrowdata.toString().contains("Acid Placement"))
           {
        	   acidplacement=1;
           }
           
           if(getrowdata.toString().contains("Acid Penetration"))
           {
        	   acidpenetration=1;
           }
           
           if(getrowdata.toString().contains("Post Stimulation skin"))
           {
        	   poststimulation=1;
           }
           
           if(getrowdata.toString().contains("Proposed Stimulation Design"))
           {
        	   ProposedStimulationDesign=1;
           }
            
            
            if(getrowdata.toString().contains("-") && acidpenetration==0)
            {
            	/*String acidplane[]=getrowdata.split("%");
            	System.out.println("size ="+acidplane.length);
            	
            	for(int i=0; i<acidplane.length; i++)
            	{
            		
            		String[] values = acidplane[i].replaceAll("^[\\s]+", "").split("[-\\s]+");
            		OutputAcidPlacementTbl outputAcidPlacementTbl=new OutputAcidPlacementTbl();
            		System.out.println(values[0]);
            	    System.out.println(values[1]);
            	    System.out.println(values[2]);
            		outputAcidPlacementTbl.setAcidPlcmentDataNo(i);
            		outputAcidPlacementTbl.setDefthFtstart(Float.parseFloat(values[0].toString()));
            		outputAcidPlacementTbl.setDefthFtend(Float.parseFloat(values[1].toString()));
            		outputAcidPlacementTbl.setVolumeDataPercent(Float.parseFloat(values[2].toString()));
            		listdatOutputAcidPlacementTbl.add(outputAcidPlacementTbl);
            	}*/
            	if(acidplacement==1)
            	{
            	parseacidplacementdata(getrowdata);
            	acidplacement=0;
            	}
            	if(acidpenetration==1)
            	{
            		parsePenetrationdata(getrowdata);
            		acidpenetration=0;
            	}
            	 if(poststimulation==1)
            	 {
            		 parsepoststimulationdata(getrowdata);
            		 poststimulation=0;
            	 }
            	 if(ProposedStimulationDesign==1)
            	 {
            		parseProposedStimulationDesigndata(getrowdata);
            		ProposedStimulationDesign=0;
            		 
            	 }
            	
            	
            	
            }
            
            


          
        }
        scanner.close();
    }
    
    private static void parseProposedStimulationDesigndata(String getrowdata) {
		// TODO Auto-generated method stub
		
	}

	private static void parsepoststimulationdata(String getrowdata) {

    	String acidplane[]=getrowdata.split("%");
    	System.out.println("size ="+acidplane.length);
    	
    	for(int i=0; i<acidplane.length; i++)
    	{
    		
    		String[] values = acidplane[i].replaceAll("^[\\s]+", "").split("[-\\s]+");
    		/*OutputPostStimulationSkinTbl outputPostStimulationSkinTbl=new OutputPostStimulationSkinTbl();
    		System.out.println(values[0]);
    	    System.out.println(values[1]);
    	    System.out.println(values[2]);
    	    outputPostStimulationSkinTbl.setPostStiSkinDataNo(i);
    	    outputPostStimulationSkinTbl.setDefthFtStart(Float.parseFloat(values[0].toString())); 
    	    outputPostStimulationSkinTbl.setDefthFtEnd(Float.parseFloat(values[1].toString()));
    	    outputPostStimulationSkinTbl.setSkinValue(Float.parseFloat(values[2].toString()));
     	    
    	    listdataOutputPostStimulationSkinTbl.add(outputPostStimulationSkinTbl);*/
    	}
    	
     	 
    	
    	
    
    }

	private static void parsePenetrationdata(String getrowdata) {

    	String acidplane[]=getrowdata.split("%");
    	System.out.println("size ="+acidplane.length);
    	
    	for(int i=0; i<acidplane.length; i++)
    	{
    		
    		String[] values = acidplane[i].replaceAll("^[\\s]+", "").split("[-\\s]+");
    		OutputAcidPenetrationTbl outAcidPenetrationTbl=new OutputAcidPenetrationTbl();
    		System.out.println(values[0]);
    	    System.out.println(values[1]);
    	    System.out.println(values[2]);
    	    
    	    outAcidPenetrationTbl.setAcid_penetration_data_no(i);
    	    outAcidPenetrationTbl.setDefthFtstart(Float.parseFloat(values[0].toString()));
    	    outAcidPenetrationTbl.setDefthFtend(Float.parseFloat(values[1].toString()));
    	    
    	    outAcidPenetrationTbl.setPenetrationLengthFt(Float.parseFloat(values[2].toString()));
    	    
     		listadatOutputAcidPenetrationTbl.add(outAcidPenetrationTbl);
    	}
    	
     	 
    	
    	
    
    }

	static void parseacidplacementdata(String data)
    {

    	String acidplane[]=data.split("%");
    	System.out.println("size ="+acidplane.length);
    	
    	for(int i=0; i<acidplane.length; i++)
    	{
    		
    		String[] values = acidplane[i].replaceAll("^[\\s]+", "").split("[-\\s]+");
    		OutputAcidPlacementTbl outputAcidPlacementTbl=new OutputAcidPlacementTbl();
    		System.out.println(values[0]);
    	    System.out.println(values[1]);
    	    System.out.println(values[2]);
    		outputAcidPlacementTbl.setAcidPlcmentDataNo(i);
    		outputAcidPlacementTbl.setDefthFtstart(Float.parseFloat(values[0].toString()));
    		outputAcidPlacementTbl.setDefthFtend(Float.parseFloat(values[1].toString()));
    		outputAcidPlacementTbl.setVolumeDataPercent(Float.parseFloat(values[2].toString()));
    		listdatOutputAcidPlacementTbl.add(outputAcidPlacementTbl);
    	}
    	
     	 
    	
    	
    
    }
}
        //read CSV Files and parse it to object array
        /**
         * Pankaj,28,Male
         * Lisa,30,Female
         * Mike,25,Male
         */
     /*   scanner = new Scanner(Paths.get("/Users/pankaj/data.csv"));
        scanner.useDelimiter(System.getProperty("line.separator"));
        while(scanner.hasNext()){
            //parse line to get Emp Object
            Employee emp = parseCSVLine(scanner.next());
            System.out.println(emp.toString());
        }
        scanner.close();
        
        //read from system input
        System.out.println("Read from system input:");
        scanner = new Scanner(System.in);
        System.out.println("Input first word: "+scanner.next());
    }*/
    
   /* private static Employee parseCSVLine(String line) {
         Scanner scanner = new Scanner(line);
         scanner.useDelimiter("\\s*,\\s*");
         String name = scanner.next();
         int age = scanner.nextInt();
         String gender = scanner.next();
         JavaFileScanner jfs = new JavaFileScanner();
         return jfs.new Employee(name, age, gender);
    }

    public class Employee{
        private String name;
        private int age;
        private String gender;
        
        public Employee(String n, int a, String gen){
            this.name = n;
            this.age = a;
            this.gender = gen;
        }
        
        @Override
        public String toString(){
            return "Name="+this.name+"::Age="+this.age+"::Gender="+this.gender;
        }
    }*/


