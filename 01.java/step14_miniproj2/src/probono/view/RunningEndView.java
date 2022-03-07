package probono.view;

import java.util.ArrayList;

import probono.model.dto.ProbonoProjectDTO;

public class RunningEndView {
	
	//��� ������Ʈ ���
	public static void projectListView(ArrayList allProbonoProject){
		//? ������ ���� ���
		//�ϴ� �ڵ� ���� ������ ���
		int length = allProbonoProject.size();
		if( length != 0 ){
			for(int index = 0; index < length; index++){			
				System.out.println("�˻����� " + (index+1) + " - " + allProbonoProject.get(index));
			}
		}
	}
		
	//Ư�� ������Ʈ ��� 
	public static void projectView(ProbonoProjectDTO project){
		System.out.println(project);		
	}
	
	//?? ��� DTO ���� ����ϴ� �޼ҵ�
	public static void allView(Object object){
		System.out.println(object);
	}
	
	
	//���� ��Ȳ ���
	public static void showError(String message){
		System.out.println(message);		
	}
}
