/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  EndView.java
 * DESC  : 재능 기부 정보 출력 클래스
 * 
 * @author  
 * @version 1.0
*/

package step02.probono.view;

import java.util.ArrayList;

import step02.probono.model.dto.TalentDonationProject;

public class EndView {

	// 진행중인 특정 프로젝트 출력
	public static void projectView(TalentDonationProject project) {
		if (project != null) {
			System.out.println(project);
		} else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}

	// TO DO
	// 진행중인 모든 프로젝트 출력
	public static void projectListView(ArrayList<TalentDonationProject> allProbonoProject) {
		int ii = allProbonoProject.size();
		for (int i = 0; i < ii; i++) {
			if (allProbonoProject.get(i) != null) {
				System.out.println(allProbonoProject.get(i));
			}
		}

	}

//	public static void projectListView(TalentDonationProject [] allProbonoProject){
//		for(TalentDonationProject t : allProbonoProject) {
//			if(t != null)
//				System.out.println(t);
//		}
//	}

}
