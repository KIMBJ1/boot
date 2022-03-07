/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  Beneficiary.java
 * DESC  :  수혜자 정보(Data)
 * 
 * @author 
 * @version 1.0
*/
package step02.probono.model.dto;

public class Beneficiary {
	/** 수혜자 번호 */
	private int no;

	/** 수혜자 이름 */
	private String name;

	/** 수혜자 연락처 */
	private String contactInformation;

	/** 혜택받길 희망하는 기부 타입 */
	private String requestType;

	public Beneficiary() {
	}

	public Beneficiary(int no, String name, String contactInformation, String requestType) {
		super();
		this.no = no;
		this.name = name;
		this.contactInformation = contactInformation;
		this.requestType = requestType;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("수혜자 번호 : ");
		builder.append(no);
		builder.append(", 수혜자 이름 : ");
		builder.append(name);
		builder.append(", 수혜자 연락처 : ");
		builder.append(contactInformation);
		builder.append(", 수혜자가 희망하는 기부 내용 : ");
		builder.append(requestType);
		return builder.toString();
	}
}