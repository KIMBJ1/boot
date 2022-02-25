package probono.view;

import java.util.ArrayList;

import probono.controller.ProbonoProjectController;
import probono.model.dto.ProbonoProjectDTO;

public class RunningStartView {
	
	public static void main(String [] args){
		System.out.println("***** ��� ����Ǵ� ���� Project �˻� *****");
		ArrayList<ProbonoProjectDTO> allProbonoProject = ProbonoProjectController.getAllProbonoProjects();
		RunningEndView.projectListView(allProbonoProject);			
		
		//��� ��� ����ڵ� �˻�
		System.out.println("\n***** ��� ��� ����� �˻� *****");
		RunningEndView.projectListView(ProbonoProjectController.getAllActivists());
		
		//Ư�� ���κ��� ���� �˻�
		System.out.println("\n***** Ư�� ���κ��� ���� �˻� *****");
		RunningEndView.allView(ProbonoProjectController.getProbono("schweitzer"));
		
		
		//���κ��� id�� ���κ��� ���� ����	
		//test data - id : schweitzer,  ���� : �ֿϵ������
		System.out.println("\n***** Ư�� ���κ��� ���� ������ �� �˻� *****");
		boolean result = ProbonoProjectController.updateProbono("schweitzer", "�ֿϵ������");
		RunningEndView.allView(ProbonoProjectController.getProbono("schweitzer"));
	}
	
}