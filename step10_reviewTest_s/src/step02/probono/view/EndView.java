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
import java.util.Optional;

import step02.probono.model.dto.TalentDonationProject;

public class EndView {

	
	// 진행중인 특정 프로젝트 출력
	public static void projectView(TalentDonationProject project) {
		
		/* if의 else문장처럼 orElse() 호출
		 * 문제가 발생
		 * 	객체 존재 여부 타입 - TalentDonationProject 로 처리시 orElse()의 parameter도 TalentDonationProject여야 함
		 * 	
		 * 해결책 - 다형성Object 타입으로 제네릭 표현
		 */
//		Optional<TalentDonationProject> project1 = Optional.ofNullable(project);
		Optional<Object> project1 = Optional.ofNullable(project);
		System.out.println(project1.orElse("해당 proj.는 존재하지 않습니다."));
//		if (project != null) {
//			System.out.println(project);
//		} else {
//			System.out.println("해당 프로젝트는 존재하지 않습니다.");
//		}
	}

	// TO DO
	// 진행중인 모든 프로젝트 출력
//	public static void projectListView(ArrayList<TalentDonationProject> allProbonoProject) {
//		
//		Optional<Object> optPro = Optional.ofNullable(allProbonoProject);
//		if(!optPro.isPresent()) {
//			System.out.println("현 진행중인 proj.는 미존재");
//		}
//		
//		optPro.ifPresent((data) -> {
//			int projectsize = allProbonoProject.size();
//			for(int index = 0; index < projectsize; index++) {
//				if(allProbonoProject.get(index) != null) {
//					System.out.println("[진행중인 proj " + (index + 1) +"] " + allProbonoProject.get(index));
//				}
//			}
//		});
//	}
	
	//참고 코드 2 - EndView.java : project counting은 차후에 브라우저 화면단에서 고려하세요
		public static void projectListView(ArrayList<TalentDonationProject> allProbonoProject){
			Optional<Object> datas = Optional.ofNullable(allProbonoProject);
			
			allProbonoProject.stream().forEach(v -> {
				System.out.println("[진행 중인 project] " + v);
			});
			
			datas.orElse("현 진행중인 project는 미존재합니다");		
		}

		
//		int ii = allProbonoProject.size();
//		for (int i = 0; i < ii; i++) {
//			if (allProbonoProject.get(i) != null) {
//				System.out.println(allProbonoProject.get(i));
//			} else {
//				System.out.println("현 진행중인 proj.는 미존재");
//			}
//		}
//	}
//
	public static void successView(String message) {
		System.out.println("EndView.successView : " + message);
	}

//	public static void projectListView(TalentDonationProject [] allProbonoProject){
//		for(TalentDonationProject t : allProbonoProject) {
//			if(t != null)
//				System.out.println(t);
//		}
//	}

}
