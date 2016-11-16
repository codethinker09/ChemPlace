package com.chemplace.view.model.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the project_tbl database table.
 * 
 */
@Entity
@Table(name="project_tbl")
@NamedQuery(name="ProjectTbl.findAll", query="SELECT p FROM ProjectTbl p")
public class ProjectTbl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="project_id")
	private Integer projectId;

	@Column(name="chemical_name")
	private String chemicalName;

	@Column(name="company_name")
	private String companyName;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="field_name")
	private String fieldName;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	@Column(name="project_description")
	private String projectDescription;

	@Column(name="project_name")
	private String projectName;

	@Column(name="user_name")
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="project_place")
	private String projectPlace;

	@Column(name="user_note")
	private String userNote;

	//bi-directional many-to-one association to AcidInjectionTbl
	@OneToMany(mappedBy="projectTbl")
	private List<AcidInjectionTbl> acidInjectionTbls;

	//bi-directional many-to-one association to AdditionalInpuDataTbl
	@OneToMany(mappedBy="projectTbl")
	private List<AdditionalInpuDataTbl> additionalInpuDataTbls;

	//bi-directional many-to-one association to CalibrationTbl
	@OneToMany(mappedBy="projectTbl")
	private List<CalibrationTbl> calibrationTbls;

	//bi-directional many-to-one association to CompletionTbl
	@OneToMany(mappedBy="projectTbl")
	private List<CompletionTbl> completionTbls;

	//bi-directional many-to-one association to DtsDataTbl
	@OneToMany(mappedBy="projectTbl")
	private List<DtsDataTbl> dtsDataTbls;

	//bi-directional many-to-one association to FluidPropertiesTbl
	@OneToMany(mappedBy="projectTbl")
	private List<FluidPropertiesTbl> fluidPropertiesTbls;

	//bi-directional many-to-one association to LogTbl
	@OneToMany(mappedBy="projectTbl")
	private List<LogTbl> logTbls;

	//bi-directional many-to-one association to PressRateTbl
	@OneToMany(mappedBy="projectTbl")
	private List<PressRateTbl> pressRateTbls;

	//bi-directional many-to-one association to ModuleSubmoduleTbl
	@ManyToOne
	@JoinColumn(name="module_subm_id")
	private ModuleSubmoduleTbl moduleSubmoduleTbl;

	//bi-directional many-to-one association to UserTbl
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserTbl userTbl;

	//bi-directional many-to-one association to ReservoirlethologyTbl
	@OneToMany(mappedBy="projectTbl")
	private List<ReservoirlethologyTbl> reservoirlethologyTbls;

	//bi-directional many-to-one association to SensitivityAnalysisTbl
	@OneToMany(mappedBy="projectTbl")
	private List<SensitivityAnalysisTbl> sensitivityAnalysisTbls;

	//bi-directional many-to-one association to WelCompletionDataTbl
	@OneToMany(mappedBy="projectTbl")
	private List<WelCompletionDataTbl> welCompletionDataTbls;

	//bi-directional many-to-one association to WellLayersStageTbl
	@OneToMany(mappedBy="projectTbl")
	private List<WellLayersStageTbl> wellLayersStageTbls;

	//bi-directional many-to-one association to WoreHoleProfileTbl
	@OneToMany(mappedBy="projectTbl")
	private List<WoreHoleProfileTbl> woreHoleProfileTbls;

	public ProjectTbl() {
	}

	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getChemicalName() {
		return this.chemicalName;
	}

	public void setChemicalName(String chemicalName) {
		this.chemicalName = chemicalName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getProjectDescription() {
		return this.projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectPlace() {
		return this.projectPlace;
	}

	public void setProjectPlace(String projectPlace) {
		this.projectPlace = projectPlace;
	}

	public String getUserNote() {
		return this.userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public List<AcidInjectionTbl> getAcidInjectionTbls() {
		return this.acidInjectionTbls;
	}

	public void setAcidInjectionTbls(List<AcidInjectionTbl> acidInjectionTbls) {
		this.acidInjectionTbls = acidInjectionTbls;
	}

	public AcidInjectionTbl addAcidInjectionTbl(AcidInjectionTbl acidInjectionTbl) {
		getAcidInjectionTbls().add(acidInjectionTbl);
		acidInjectionTbl.setProjectTbl(this);

		return acidInjectionTbl;
	}

	public AcidInjectionTbl removeAcidInjectionTbl(AcidInjectionTbl acidInjectionTbl) {
		getAcidInjectionTbls().remove(acidInjectionTbl);
		acidInjectionTbl.setProjectTbl(null);

		return acidInjectionTbl;
	}

	public List<AdditionalInpuDataTbl> getAdditionalInpuDataTbls() {
		return this.additionalInpuDataTbls;
	}

	public void setAdditionalInpuDataTbls(List<AdditionalInpuDataTbl> additionalInpuDataTbls) {
		this.additionalInpuDataTbls = additionalInpuDataTbls;
	}

	public AdditionalInpuDataTbl addAdditionalInpuDataTbl(AdditionalInpuDataTbl additionalInpuDataTbl) {
		getAdditionalInpuDataTbls().add(additionalInpuDataTbl);
		additionalInpuDataTbl.setProjectTbl(this);

		return additionalInpuDataTbl;
	}

	public AdditionalInpuDataTbl removeAdditionalInpuDataTbl(AdditionalInpuDataTbl additionalInpuDataTbl) {
		getAdditionalInpuDataTbls().remove(additionalInpuDataTbl);
		additionalInpuDataTbl.setProjectTbl(null);

		return additionalInpuDataTbl;
	}

	public List<CalibrationTbl> getCalibrationTbls() {
		return this.calibrationTbls;
	}

	public void setCalibrationTbls(List<CalibrationTbl> calibrationTbls) {
		this.calibrationTbls = calibrationTbls;
	}

	public CalibrationTbl addCalibrationTbl(CalibrationTbl calibrationTbl) {
		getCalibrationTbls().add(calibrationTbl);
		calibrationTbl.setProjectTbl(this);

		return calibrationTbl;
	}

	public CalibrationTbl removeCalibrationTbl(CalibrationTbl calibrationTbl) {
		getCalibrationTbls().remove(calibrationTbl);
		calibrationTbl.setProjectTbl(null);

		return calibrationTbl;
	}

	public List<CompletionTbl> getCompletionTbls() {
		return this.completionTbls;
	}

	public void setCompletionTbls(List<CompletionTbl> completionTbls) {
		this.completionTbls = completionTbls;
	}

	public CompletionTbl addCompletionTbl(CompletionTbl completionTbl) {
		getCompletionTbls().add(completionTbl);
		completionTbl.setProjectTbl(this);

		return completionTbl;
	}

	public CompletionTbl removeCompletionTbl(CompletionTbl completionTbl) {
		getCompletionTbls().remove(completionTbl);
		completionTbl.setProjectTbl(null);

		return completionTbl;
	}

	public List<DtsDataTbl> getDtsDataTbls() {
		return this.dtsDataTbls;
	}

	public void setDtsDataTbls(List<DtsDataTbl> dtsDataTbls) {
		this.dtsDataTbls = dtsDataTbls;
	}

	public DtsDataTbl addDtsDataTbl(DtsDataTbl dtsDataTbl) {
		getDtsDataTbls().add(dtsDataTbl);
		dtsDataTbl.setProjectTbl(this);

		return dtsDataTbl;
	}

	public DtsDataTbl removeDtsDataTbl(DtsDataTbl dtsDataTbl) {
		getDtsDataTbls().remove(dtsDataTbl);
		dtsDataTbl.setProjectTbl(null);

		return dtsDataTbl;
	}

	public List<FluidPropertiesTbl> getFluidPropertiesTbls() {
		return this.fluidPropertiesTbls;
	}

	public void setFluidPropertiesTbls(List<FluidPropertiesTbl> fluidPropertiesTbls) {
		this.fluidPropertiesTbls = fluidPropertiesTbls;
	}

	public FluidPropertiesTbl addFluidPropertiesTbl(FluidPropertiesTbl fluidPropertiesTbl) {
		getFluidPropertiesTbls().add(fluidPropertiesTbl);
		fluidPropertiesTbl.setProjectTbl(this);

		return fluidPropertiesTbl;
	}

	public FluidPropertiesTbl removeFluidPropertiesTbl(FluidPropertiesTbl fluidPropertiesTbl) {
		getFluidPropertiesTbls().remove(fluidPropertiesTbl);
		fluidPropertiesTbl.setProjectTbl(null);

		return fluidPropertiesTbl;
	}

	public List<LogTbl> getLogTbls() {
		return this.logTbls;
	}

	public void setLogTbls(List<LogTbl> logTbls) {
		this.logTbls = logTbls;
	}

	public LogTbl addLogTbl(LogTbl logTbl) {
		getLogTbls().add(logTbl);
		logTbl.setProjectTbl(this);

		return logTbl;
	}

	public LogTbl removeLogTbl(LogTbl logTbl) {
		getLogTbls().remove(logTbl);
		logTbl.setProjectTbl(null);

		return logTbl;
	}

	public List<PressRateTbl> getPressRateTbls() {
		return this.pressRateTbls;
	}

	public void setPressRateTbls(List<PressRateTbl> pressRateTbls) {
		this.pressRateTbls = pressRateTbls;
	}

	public PressRateTbl addPressRateTbl(PressRateTbl pressRateTbl) {
		getPressRateTbls().add(pressRateTbl);
		pressRateTbl.setProjectTbl(this);

		return pressRateTbl;
	}

	public PressRateTbl removePressRateTbl(PressRateTbl pressRateTbl) {
		getPressRateTbls().remove(pressRateTbl);
		pressRateTbl.setProjectTbl(null);

		return pressRateTbl;
	}

	public ModuleSubmoduleTbl getModuleSubmoduleTbl() {
		return this.moduleSubmoduleTbl;
	}

	public void setModuleSubmoduleTbl(ModuleSubmoduleTbl moduleSubmoduleTbl) {
		this.moduleSubmoduleTbl = moduleSubmoduleTbl;
	}

	public UserTbl getUserTbl() {
		return this.userTbl;
	}

	public void setUserTbl(UserTbl userTbl) {
		this.userTbl = userTbl;
	}

	public List<ReservoirlethologyTbl> getReservoirlethologyTbls() {
		return this.reservoirlethologyTbls;
	}

	public void setReservoirlethologyTbls(List<ReservoirlethologyTbl> reservoirlethologyTbls) {
		this.reservoirlethologyTbls = reservoirlethologyTbls;
	}

	public ReservoirlethologyTbl addReservoirlethologyTbl(ReservoirlethologyTbl reservoirlethologyTbl) {
		getReservoirlethologyTbls().add(reservoirlethologyTbl);
		reservoirlethologyTbl.setProjectTbl(this);

		return reservoirlethologyTbl;
	}

	public ReservoirlethologyTbl removeReservoirlethologyTbl(ReservoirlethologyTbl reservoirlethologyTbl) {
		getReservoirlethologyTbls().remove(reservoirlethologyTbl);
		reservoirlethologyTbl.setProjectTbl(null);

		return reservoirlethologyTbl;
	}

	public List<SensitivityAnalysisTbl> getSensitivityAnalysisTbls() {
		return this.sensitivityAnalysisTbls;
	}

	public void setSensitivityAnalysisTbls(List<SensitivityAnalysisTbl> sensitivityAnalysisTbls) {
		this.sensitivityAnalysisTbls = sensitivityAnalysisTbls;
	}

	public SensitivityAnalysisTbl addSensitivityAnalysisTbl(SensitivityAnalysisTbl sensitivityAnalysisTbl) {
		getSensitivityAnalysisTbls().add(sensitivityAnalysisTbl);
		sensitivityAnalysisTbl.setProjectTbl(this);

		return sensitivityAnalysisTbl;
	}

	public SensitivityAnalysisTbl removeSensitivityAnalysisTbl(SensitivityAnalysisTbl sensitivityAnalysisTbl) {
		getSensitivityAnalysisTbls().remove(sensitivityAnalysisTbl);
		sensitivityAnalysisTbl.setProjectTbl(null);

		return sensitivityAnalysisTbl;
	}

	public List<WelCompletionDataTbl> getWelCompletionDataTbls() {
		return this.welCompletionDataTbls;
	}

	public void setWelCompletionDataTbls(List<WelCompletionDataTbl> welCompletionDataTbls) {
		this.welCompletionDataTbls = welCompletionDataTbls;
	}

	public WelCompletionDataTbl addWelCompletionDataTbl(WelCompletionDataTbl welCompletionDataTbl) {
		getWelCompletionDataTbls().add(welCompletionDataTbl);
		welCompletionDataTbl.setProjectTbl(this);

		return welCompletionDataTbl;
	}

	public WelCompletionDataTbl removeWelCompletionDataTbl(WelCompletionDataTbl welCompletionDataTbl) {
		getWelCompletionDataTbls().remove(welCompletionDataTbl);
		welCompletionDataTbl.setProjectTbl(null);

		return welCompletionDataTbl;
	}

	public List<WellLayersStageTbl> getWellLayersStageTbls() {
		return this.wellLayersStageTbls;
	}

	public void setWellLayersStageTbls(List<WellLayersStageTbl> wellLayersStageTbls) {
		this.wellLayersStageTbls = wellLayersStageTbls;
	}

	public WellLayersStageTbl addWellLayersStageTbl(WellLayersStageTbl wellLayersStageTbl) {
		getWellLayersStageTbls().add(wellLayersStageTbl);
		wellLayersStageTbl.setProjectTbl(this);

		return wellLayersStageTbl;
	}

	public WellLayersStageTbl removeWellLayersStageTbl(WellLayersStageTbl wellLayersStageTbl) {
		getWellLayersStageTbls().remove(wellLayersStageTbl);
		wellLayersStageTbl.setProjectTbl(null);

		return wellLayersStageTbl;
	}

	public List<WoreHoleProfileTbl> getWoreHoleProfileTbls() {
		return this.woreHoleProfileTbls;
	}

	public void setWoreHoleProfileTbls(List<WoreHoleProfileTbl> woreHoleProfileTbls) {
		this.woreHoleProfileTbls = woreHoleProfileTbls;
	}

	public WoreHoleProfileTbl addWoreHoleProfileTbl(WoreHoleProfileTbl woreHoleProfileTbl) {
		getWoreHoleProfileTbls().add(woreHoleProfileTbl);
		woreHoleProfileTbl.setProjectTbl(this);

		return woreHoleProfileTbl;
	}

	public WoreHoleProfileTbl removeWoreHoleProfileTbl(WoreHoleProfileTbl woreHoleProfileTbl) {
		getWoreHoleProfileTbls().remove(woreHoleProfileTbl);
		woreHoleProfileTbl.setProjectTbl(null);

		return woreHoleProfileTbl;
	}

}