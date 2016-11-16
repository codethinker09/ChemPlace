package com.chemplace.view.model.dao;

public class AcidInjectionPlan
{
    private int no;
    private String stage;
    private double stavage_vol_bbls;
    private double  conc;
    private double vise;
    private double pump_rate_bmp;
    private double inj_press_psi;
    private double inj_defth_ft;
    private double  entity_fric_loss;
    
    public AcidInjectionPlan( int no,String stage,double stavage_vol_bbls,double conc,double vise,double pump_rate_bmp,double inj_press_psi,double inj_defth_ft,double  entity_fric_loss )
    {
               
        this.no=no;
        this.stage=stage;
        this.stavage_vol_bbls=stavage_vol_bbls;
        this.conc=conc;
         this.vise=vise;
         this.pump_rate_bmp=pump_rate_bmp;
         this.inj_press_psi=inj_press_psi;
         this.inj_defth_ft=inj_defth_ft;
         this.entity_fric_loss=entity_fric_loss;
        
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public double getStavage_vol_bbls() {
		return stavage_vol_bbls;
	}

	public void setStavage_vol_bbls(double stavage_vol_bbls) {
		this.stavage_vol_bbls = stavage_vol_bbls;
	}

	public double getConc() {
		return conc;
	}

	public void setConc(double conc) {
		this.conc = conc;
	}

	public double getVise() {
		return vise;
	}

	public void setVise(double vise) {
		this.vise = vise;
	}

	public double getPump_rate_bmp() {
		return pump_rate_bmp;
	}

	public void setPump_rate_bmp(double pump_rate_bmp) {
		this.pump_rate_bmp = pump_rate_bmp;
	}

	public double getInj_press_psi() {
		return inj_press_psi;
	}

	public void setInj_press_psi(double inj_press_psi) {
		this.inj_press_psi = inj_press_psi;
	}

	public double getInj_defth_ft() {
		return inj_defth_ft;
	}

	public void setInj_defth_ft(double inj_defth_ft) {
		this.inj_defth_ft = inj_defth_ft;
	}

	public double getEntity_fric_loss() {
		return entity_fric_loss;
	}

	public void setEntity_fric_loss(double entity_fric_loss) {
		this.entity_fric_loss = entity_fric_loss;
	}




}
