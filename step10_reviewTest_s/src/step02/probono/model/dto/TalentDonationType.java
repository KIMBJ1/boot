/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationType.java
 * DESC  :  재능기부 종류(Data)
 * 
 * @author  
 * @version 1.0
*/
package step02.probono.model.dto;

public class TalentDonationType {
	/** 재능 기부 타입(종류) */
	private String donationType;

	/** 재능 기부 활동 영역 */
	private String activityArea;

	/** 재능 기부 활동 예시 */
	private String activityDetails;

	public TalentDonationType() {}

	public TalentDonationType(String probonoId, String probonoName, String probonoPurpose) {
		super();
		this.donationType = probonoId;
		this.activityArea = probonoName;
		this.activityDetails = probonoPurpose;
	}

	public String getProbonoId() {
		return donationType;
	}

	public void setProbonoId(String probonoId) {
		this.donationType = probonoId;
	}

	public String getProbonoName() {
		return activityArea;
	}

	public void setProbonoName(String probonoName) {
		this.activityArea = probonoName;
	}

	public String getProbonoPurpose() {
		return activityDetails;
	}

	public void setProbonoPurpose(String probonoPurpose) {
		this.activityDetails = probonoPurpose;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("기부 타입 : ");
		builder.append(donationType);
		builder.append(", 기부 활동 영역 : ");
		builder.append(activityArea);
		builder.append(", 기부 활동 예시 : ");
		builder.append(activityDetails);
		return builder.toString();
	}
}
