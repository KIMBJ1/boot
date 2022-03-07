/*
CREATE TABLE probono (
       probono_id          	VARCHAR2(50) PRIMARY KEY,
       probono_name      VARCHAR2(50) NOT NULL,
       probono_purpose  	VARCHAR2(200) NOT NULL
);  */
package probono.model.dto;

public class ProbonoDTO {
	private String probonoId;
	private String probonoName;
	private String probonoPurpose;
	
	public ProbonoDTO() {}
		
	public ProbonoDTO(String probonoId, String probonoName, 	String probonoPurpose) {
		super();
		this.probonoId = probonoId;
		this.probonoName = probonoName;
		this.probonoPurpose = probonoPurpose;
	}
	
	public String getProbonoId() {
		return probonoId;
	}

	public void setProbonoId(String probonoId) {
		this.probonoId = probonoId;
	}

	public String getProbonoName() {
		return probonoName;
	}

	public void setProbonoName(String probonoName) {
		this.probonoName = probonoName;
	}

	public String getProbonoPurpose() {
		return probonoPurpose;
	}

	public void setProbonoPurpose(String probonoPurpose) {
		this.probonoPurpose = probonoPurpose;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("���κ��� ���� 1. ���κ��� ���̵� = ");
		builder.append(probonoId);
		builder.append("2. ���κ��� �̸� : ");
		builder.append(probonoName);
		builder.append("3. ���κ��� ���� : ");
		builder.append(probonoPurpose);
		return builder.toString();
	}
}
