package com.chemplace.view;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 
public class ReadExcel {
 
    public static void main( String [] args ) {
      Writer writer = null;
        try {
    
             InputStream input = new BufferedInputStream(
                        new FileInputStream("Output/Zone_2.xls"));
            POIFSFileSystem fs = new POIFSFileSystem( input );
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0); //sheet of excel
          
            File file = new File("writedatasamp.txt");  
            writer = new BufferedWriter(new FileWriter(file));
            Iterator rows = sheet.rowIterator(); 
            while( rows.hasNext() ) {   
                HSSFRow row = (HSSFRow) rows.next();
                System.out.println("\n");
                Iterator cells = row.cellIterator();
               
                   writer.write("insert into Emp values(");
                while( cells.hasNext() ) {
                     
                    HSSFCell cell = (HSSFCell) cells.next();
                    if(HSSFCell.CELL_TYPE_NUMERIC==cell.getCellType()) {
                    System.out.print( cell.getNumericCellValue()+"     "+cell.getColumnIndex() );
                    if(cell.getColumnIndex()==3)
                  writer.write(String.valueOf(cell.getNumericCellValue()));
                    else
                     writer.write(String.valueOf(cell.getNumericCellValue()+","));
                    }
                    else
                    if(HSSFCell.CELL_TYPE_STRING==cell.getCellType()) {
                        System.out.print( cell.getStringCellValue()+"     " );
                        writer.write("'"+cell.getStringCellValue()+"',");
                    }
                    else
                        if(HSSFCell.CELL_TYPE_BOOLEAN==cell.getCellType()) {
                        System.out.print( cell.getBooleanCellValue()+"     " );
                       writer.write("'"+String.valueOf(cell.getBooleanCellValue()+"',"));
                        }
                        else
                            if(HSSFCell.CELL_TYPE_BLANK==cell.getCellType())
                                System.out.print( "BLANK     " );
                                else
                            System.out.print("Unknown cell type");
              
                   
                }
                 
                writer.write(");"+"\n"); 
            }
            
             
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } finally {             try {                 if (writer != null) {                     writer.close();                 }             } catch (IOException e) {                 e.printStackTrace();             }         }
    }
     
}