package model.domain;

public class Employee {
	private String empno; //���
	private String ename; //��� �̸�
	private int deptno; //�μ� ��ȣ
	
	public Employee() {
		super();
	}

	public Employee(String empno, String ename, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
	}

	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", deptno=" + deptno + "]";
	}
	
	
}
