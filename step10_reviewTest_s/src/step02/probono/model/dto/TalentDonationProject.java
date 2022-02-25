/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProject.java
 * DESC  :  진행중인 프로젝트 정보(Data)
 * 
 * @author  
 * @version 1.0
*/
package step02.probono.model.dto;

public class TalentDonationProject {

	/** 프로젝트 고유 이름 */
	private String talentDonationProjectName;

	/** 기부자 */
	private Donator projectDonator;

	/** 수혜자 */
	private Beneficiary projectBeneficiary;

	/** 재능 기부 타입 */
	private TalentDonationType talentDonationType;

	/** 프로젝트 시작일 */
	private String startDate;

	/** 프로젝트 종료일 */
	private String endDate;

	/** 진행되는 project의 상세 내용 */
	private String talentDonationProjectDetail;

	public TalentDonationProject() {
		super();
	}
	public TalentDonationProject(String talentDonationProjectName, Donator projectDonator,
			Beneficiary projectBeneficiary, TalentDonationType talentDonationType, String startDate, String endDate,
			String talentDonationProjectDetail) {
		super();
		this.talentDonationProjectName = talentDonationProjectName;
		this.projectDonator = projectDonator;
		this.projectBeneficiary = projectBeneficiary;
		this.talentDonationType = talentDonationType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.talentDonationProjectDetail = talentDonationProjectDetail;
	}

	public String getTalentDonationProjectName() {
		return talentDonationProjectName;
	}

	public void setTalentDonationProjectName(String talentDonationProjectName) {
		this.talentDonationProjectName = talentDonationProjectName;
	}

	public Donator getProjectDonator() {
		return projectDonator;
	}

	public void setProjectDonator(Donator projectDonator) {
		this.projectDonator = projectDonator;
	}

	public Beneficiary getProjectBeneficiary() {
		return projectBeneficiary;
	}

	public void setProjectBeneficiary(Beneficiary projectBeneficiary) {
		this.projectBeneficiary = projectBeneficiary;
	}

	public TalentDonationType getTalentDonationType() {
		return talentDonationType;
	}

	public void setTalentDonationType(TalentDonationType talentDonationType) {
		this.talentDonationType = talentDonationType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getTalentDonationProjectDetail() {
		return talentDonationProjectDetail;
	}

	public void setTalentDonationProjectDetail(String talentDonationProjectDetail) {
		this.talentDonationProjectDetail = talentDonationProjectDetail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("프로젝트명 : ");
		builder.append(talentDonationProjectName);
		builder.append(", 기부자 : ");
		builder.append(projectDonator);
		builder.append(", 수혜자 : ");
		builder.append(projectBeneficiary);
		builder.append(", 진행되는 기부 타입 : ");
		builder.append(talentDonationType);
		builder.append(", 기부 시작일 : ");
		builder.append(startDate);
		builder.append(", 기부 종료일 : ");
		builder.append(endDate);
		builder.append(", 기부 상세 내용 : ");
		builder.append(talentDonationProjectDetail);
		return builder.toString();
	}
}