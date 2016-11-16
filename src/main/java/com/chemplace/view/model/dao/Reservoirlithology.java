package com.chemplace.view.model.dao;

public class Reservoirlithology
{
    private int no;
    private double    form_defth_ft;
    private double    to_defth_ft ;
    private double   tvd_ft ;
    private double    perm_md ;
    private double    poro;
    private double   zone_press_psi ;
    private   String  fluid_in_place ;
    private double   pre_stim_skin ;
    
       
    public Reservoirlithology( int no,double form_defth_ft,double to_defth_ft,double tvd_ft,double perm_md,double poro,double zone_press_psi,double pre_stim_skin,String  fluid_in_place)
    {
             
        this.no=no;
        this.form_defth_ft=form_defth_ft;
        this.to_defth_ft =to_defth_ft;
        this.tvd_ft=tvd_ft;
        this.perm_md =perm_md;
        this.poro=poro;
        this.zone_press_psi=zone_press_psi;
        this.pre_stim_skin =pre_stim_skin;
        this.fluid_in_place=fluid_in_place;
   
            
    }


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public double getForm_defth_ft() {
		return form_defth_ft;
	}


	public void setForm_defth_ft(double form_defth_ft) {
		this.form_defth_ft = form_defth_ft;
	}


	public double getTo_defth_ft() {
		return to_defth_ft;
	}


	public void setTo_defth_ft(double to_defth_ft) {
		this.to_defth_ft = to_defth_ft;
	}


	public double getTvd_ft() {
		return tvd_ft;
	}


	public void setTvd_ft(double tvd_ft) {
		this.tvd_ft = tvd_ft;
	}


	public double getPerm_md() {
		return perm_md;
	}


	public void setPerm_md(double perm_md) {
		this.perm_md = perm_md;
	}


	public double getPoro() {
		return poro;
	}


	public void setPoro(double poro) {
		this.poro = poro;
	}


	public double getZone_press_psi() {
		return zone_press_psi;
	}


	public void setZone_press_psi(double zone_press_psi) {
		this.zone_press_psi = zone_press_psi;
	}


	public String getFluid_in_place() {
		return fluid_in_place;
	}


	public void setFluid_in_place(String fluid_in_place) {
		this.fluid_in_place = fluid_in_place;
	}


	public double getPre_stim_skin() {
		return pre_stim_skin;
	}


	public void setPre_stim_skin(double pre_stim_skin) {
		this.pre_stim_skin = pre_stim_skin;
	}

	
   

}
