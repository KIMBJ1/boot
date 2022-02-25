package probono.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.model.ActivistDAO;
import probono.model.ProbonoDAO;
import probono.model.ProbonoProjectDAO;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.view.RunningEndView;

//�� ���� : view.RunningStrartView���� ȣ�� 
public class ProbonoProjectController {
	
	
	//��� ������Ʈ �˻� ����
	public static ArrayList<ProbonoProjectDTO> getAllProbonoProjects(){
		ArrayList<ProbonoProjectDTO> allProject = null;
		try{			
			allProject = ProbonoProjectDAO.getAllProbonoProjects();			
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ �˻��� ���� �߻�");
		}
		return allProject;
	}
	
	//���ο� ������Ʈ ���� ����
	public static boolean addProbonoProject(ProbonoProjectDTO probonoProject) {
		boolean result = false;
	
		try{
			result = ProbonoProjectDAO.addProbonoProject(probonoProject);
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ������Ʈ ����� ���� �߻�");
		}
		return result;
	}
	
	//��� ������Ʈ �˻� ����
	public static ArrayList<ActivistDTO> getAllActivists(){
		ArrayList<ActivistDTO> allProject = null;
		try{
			allProject = ActivistDAO.getAllActivists();			
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("��� ��� ����� �˻��� ���� �߻�");
		}
		return allProject;
	}
	
	//���κ��� ���̵�� ���κ��� ���� ����
	public static boolean updateProbono(String probonoId, String probonoPurpose){
		boolean result = false;
		try{
			result = ProbonoDAO.updateProbono(probonoId, probonoPurpose);
		}catch(SQLException s){
			s.printStackTrace();
			RunningEndView.showError("���κ��� id�� ���κ��� ���� ���� ����");
		}
		return result;
	}
	
	//���κ��� ���� �˻�
	public static ProbonoDTO getProbono(String probonoId) {
		ProbonoDTO probono = null;
		try {
			probono = ProbonoDAO.getProbono(probonoId);
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���κ��� id�� �ش� ���κ��� �˻� ���� ");
		}
		return probono;
	}
}
