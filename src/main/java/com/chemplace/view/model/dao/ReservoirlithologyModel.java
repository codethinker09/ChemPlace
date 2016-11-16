package com.chemplace.view.model.dao;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.chemplace.view.model.dao.Reservoirlithology;

public class ReservoirlithologyModel extends AbstractTableModel
{
    private final List<Reservoirlithology> reservoirlithology;
    
    private final String[] columnNames = new String[] {
             "No","From (FT)","To (FT)","Tvd (FT)","Perm (mD)","Poro (0-1)","Res. Press (PSI)","Pre Stim Skin","Res. Fluid Type"
                };
    private final Class[] columnClass = new Class[] {
        Integer.class, Double.class, Double.class, Double.class, Double.class,Double.class, Double.class, Double.class,String.class
    };

    public ReservoirlithologyModel(List<Reservoirlithology> reservoirlithology)
    {
        this.reservoirlithology = reservoirlithology;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public int getRowCount()
    {
        return reservoirlithology.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Reservoirlithology row = reservoirlithology.get(rowIndex);
        if(0 == columnIndex) {
            return row.getNo();
        }
        else if(1 == columnIndex) {
            return row.getForm_defth_ft();
        }
        else if(2 == columnIndex) {
            return row.getTo_defth_ft();
        }
        else if(3 == columnIndex) {
            return row.getTvd_ft();
        }
        else if(4 == columnIndex) {
            return row.getPerm_md();
        }
        
        else if(5 == columnIndex) {
            return row.getPoro();
        }
        else if(6 == columnIndex) {
            return row.getZone_press_psi();
        }
        else if(7 == columnIndex) {
            return row.getPre_stim_skin ();
        }
        else if(8== columnIndex) {
            return row.getFluid_in_place();
        }
        
       
        return null;
    }
   
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Reservoirlithology row = reservoirlithology.get(rowIndex);
        if(0 == columnIndex) {
            row.setNo((Integer) aValue);
        }
          else if(1 == columnIndex) {
            row.setForm_defth_ft((Double) aValue);
        } 
        else if(2 == columnIndex) {
            row.setTo_defth_ft((Double) aValue);
        }
        else if(3 == columnIndex) {
            row.setTvd_ft((Double) aValue);
        }
        else if(4 == columnIndex) {
            row.setPerm_md ((Double) aValue);
        }
        else if(5 == columnIndex) {
            row.setPoro((Double) aValue);
        }
        else if(6 == columnIndex) {
            row.setZone_press_psi((Double) aValue);
        }
        else if(7== columnIndex) {
            row.setPre_stim_skin((Double) aValue);
        }
        else if(8 == columnIndex) {
            row.setFluid_in_place((String) aValue);
        }
          
       }
    
}




