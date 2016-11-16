package com.chemplace.view.model.dao;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.chemplace.view.model.dao.AcidInjectionPlan;

public class AcidInjectionPlanModel extends AbstractTableModel
{
    private final List<AcidInjectionPlan> acidInjectionPlan;
    
    private final String[] columnNames = new String[] { "No","Stage Name","Vol.(bbls)","Conc(%)","Vis(cP)","Pump Rate bmp ","Inj Press(Psi)","Inj Defth(FT)","Entry Fric"};
   
   
    
    private final Class[] columnClass = new Class[] {
        Integer.class,String.class, Double.class, Double.class, Double.class, Double.class,Double.class, Double.class, Double.class
    };

  
    public AcidInjectionPlanModel(List<AcidInjectionPlan> acidInjectionPlan)
    {
        this.acidInjectionPlan = acidInjectionPlan;
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
        return acidInjectionPlan.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        AcidInjectionPlan row = acidInjectionPlan.get(rowIndex);
         if(0 == columnIndex) {
            return row.getNo();
        }
        else if(1 == columnIndex) {
            return row.getStage();
        }
        else if(2 == columnIndex) {
            return row.getStavage_vol_bbls();
        }
        else if(3 == columnIndex) {
            return row.getConc();
        }
        else if(4 == columnIndex) {
            return row.getVise();
        }
        else if(5 == columnIndex) {
            return row.getPump_rate_bmp();
        }
        else if(6 == columnIndex) {
            return row.getInj_press_psi();
        }
        else if(7 == columnIndex) {
            return row.getInj_defth_ft();
        }
        else if(8 == columnIndex) {
            return row.getEntity_fric_loss();
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
        AcidInjectionPlan row = acidInjectionPlan.get(rowIndex);
        if(0 == columnIndex) {
            row.setNo((Integer) aValue);
        }
        else if(1 == columnIndex) {
            row.setStage((String) aValue);
        }
        else if(2 == columnIndex) {
            row.setStavage_vol_bbls((Double) aValue);
        } else if(3 == columnIndex) {
            row.setConc((Double) aValue);
        } else if(4 == columnIndex) {
            row.setVise((Double) aValue);
        } else if(5 == columnIndex) {
            row.setPump_rate_bmp((Double) aValue);
        }
        else if(6 == columnIndex) {
            row.setInj_press_psi((Double) aValue);
        }
        else if(7 == columnIndex) {
            row.setInj_defth_ft((Double) aValue);
        }
        else if(8 == columnIndex) {
            row.setEntity_fric_loss((Double) aValue);
        }
            
       
       }
    
}
