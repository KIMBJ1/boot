package step02.probono.controller;

import java.util.Optional;

import step02.probo.view.EndFailView;
import step02.probono.exception.ProjectNameDuplicationException;
import step02.probono.exception.ProjectNotFoundException;
import step02.probono.model.dto.Beneficiary;
import step02.probono.model.dto.Donator;
import step02.probono.model.dto.TalentDonationProject;
import step02.probono.service.TalentDonationProjectService;
import step02.probono.view.EndView;

public class TalentDonationProjectController {
	// singleton
	private static TalentDonationProjectController instance = new TalentDonationProjectController();

	private TalentDonationProjectService service = TalentDonationProjectService.getInstance();

	private TalentDonationProjectController() {
	}

	public static TalentDonationProjectController getInstance() {
		return instance;
	}

	public void getDonationProject(String projectName) {

		try {
			EndView.projectView(service.getDonationProject(projectName));
		} catch (ProjectNotFoundException e) {
			e.printStackTrace(); // 개발 및 관리자만 보는 콘솔창 메세지
			EndFailView.failView(e.getMessage()); // end user에게 출력하는 서비스 메세지
		}

	}

	/*
	 * service로부터 메소드 호출한 결과값 받아서 혹시 데이터 존재하나 검증 - 존재 : 출력 - 미존재 : 진행되는 프로젝트가 없음
	 * 
	 * 개발 방법 경우의 수1 : 요청 방식의 에러 : 에러 처리 화면 출력 경우의 수 2 : 요청 데이터가 : 없음 - 예외처리로 개발 - 단순
	 * 메세지 출력하는 개발
	 * 
	 */
	public void getDonationProjectsList() {
		EndView.projectListView(service.getDonationProjectsList());
	}

	/*
	 * 고려사항 1. client로부터 입력된 데이터가 없을 수도 있다는 것을 감안 : 입력된 데이터 존재 여부 검증 (우선) 2.
	 * service로부터 정상 저장 or 예외 발생
	 * 
	 */
	public void donationProjectInsert(TalentDonationProject project) {
		Optional<Object> optPro = Optional.ofNullable(project);
//		EndFailView.failView(project1.orElse("입력된 데이터 없음").toString());
		
		if(!optPro.isPresent()) {
			EndFailView.failView("입력된 데이터 없음");
		}
		
		optPro.ifPresent((data) ->{
			try {
				service.donationProjectInsert(project);
			} catch (ProjectNameDuplicationException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		});
//		if (project != null) {
//			try {
//				service.donationProjectInsert(project);
//			} catch (ProjectNameDuplicationException e) {
//				e.printStackTrace();
//				EndFailView.failView(e.getMessage());
//			}
//		} else {
//			EndFailView.failView("TalentDonationProjectController : 입력된 데이터 없음");
//		}
	}

	/*
	 * db에 있는 데이터 실제 갱신 및 검색 - 갱신 성공, db접속 문제, 인터넷 문제, sql 실행 문제 등 경우의 수 발생
	 * 
	 */
	// 이거 else문 수정임**********************************************************
	public void donationProjectUpdate(String projectName, Donator people) {
		
		Optional<Object> optPro = Optional.ofNullable(projectName);
		Optional<Object> optPro2 = Optional.ofNullable(people);
		
		if (!optPro.isPresent() || !optPro2.isPresent()) {
			EndFailView.failView("기부자 갱신 정보 제대로 입력하세요!");
		}else {
		
			boolean result = service.donationProjectUpdate(projectName, people);
			if (result) {
				try {
					EndView.projectView(service.getDonationProject(projectName));
				} catch (ProjectNotFoundException e) {
					e.printStackTrace();
					EndFailView.failView("기부자 갱신 후 검색 실패");
				}
			} else {
				EndFailView.failView("미 존재하는 프로젝트 수정 시도");
			}
		}


//		if (projectName != null && people != null) {
//
//			boolean result = service.donationProjectUpdate(projectName, people); // update
//			// if(result == true)
//			if (result) { // true인 경우 수정 성공
//				try {
//					EndView.projectView(service.getDonationProject(projectName)); // select
//				} catch (ProjectNotFoundException e) {
//					e.printStackTrace();
//					EndFailView.failView("TalentDonationProjectController : 기부자 갱신 후 검색 실패");
//				}
//			} else {
//				EndFailView.failView("TalentDonationProjectController : 존재하지 않는 proj. 수정 시도");
//			}
//		} else {
//			EndFailView.failView("TalentDonationProjectController : 갱신하고자 하는 기부자 정보(projectName, people) 제대로 입력 하세요");
//		}
	}

	// 있으면 수정, 없으면 예외 발생
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) {
		Optional<Object> optPro = Optional.ofNullable(projectName);
		Optional<Object> optPro2 = Optional.ofNullable(people);
		if (!optPro.isPresent() || !optPro2.isPresent()) {
			EndFailView.failView("갱신하고자 하는 수혜자 정보(projectName, people) 제대로 입력 하세요");
			
		}
			
		optPro.ifPresent((data) -> {
			try {
				service.beneficiaryProjectUpdate(projectName, people);
				EndView.successView("TalentDonationProjectController : 수혜자 정보 갱신 성공");
			} catch (ProjectNotFoundException e) {
				e.printStackTrace();
				EndFailView.failView(e.getMessage());
			}
		});
//		if (projectName != null && people != null) {
//			try {
//				service.beneficiaryProjectUpdate(projectName, people);
//				EndView.successView("TalentDonationProjectController : 수혜자 정보 갱신 성공");
//			} catch (ProjectNotFoundException e) {
//				e.printStackTrace();
//				EndFailView.failView(e.getMessage()); // 수혜자 정보를 수정하고자 하는 프로젝트가 없다는 정보 의미
//			}
//		} else {
//			EndFailView.failView("TalentDonationProjectController : 갱신하고자 하는 수혜자 정보(projectName, people) 제대로 입력 하세요");
//
//		}
	}

	// controller에서는 void
	// 참조 타입의 데이터 존재 여부 검증값 = null(참조하는 객체가 없다는 참조 타입의 기본값)
	public void donationProjectDelete(String projectName) {
		
		Optional<Object> optPro = Optional.ofNullable(projectName);
		if (!optPro.isPresent()) {
			EndFailView.failView("삭제하려는 프로젝트가 미 존재합니다.");
		}

		optPro.ifPresent((data) -> {
			boolean result = service.donationProjectDelete(projectName);

			if (result) {
				EndView.successView(projectName + "프로젝트 삭제 성공");
			} else {
				EndFailView.failView("삭제하려는 프로젝트가 미 존재합니다.");
			}
		});
		
//	Optional<Object> optdelete = Optional.ofNullable(projectName);
//	Optional<Object> result = Optional.ofNullable(service.donationProjectDelete(projectName));
//	
//	System.out.println(optdelete.orElse("삭제하려는 projectName 입력되지 않음"));
//	System.out.println(result.orElse("삭제하려는 proj.가 없다."));

//		if (projectName != null) {
//			boolean result = service.donationProjectDelete(projectName);
//			if (result) {
//				EndView.successView("TalentDonationProjectController : " + projectName + "proj. 삭제 성공");
//			} else {
//				EndFailView.failView("TalentDonationProjectController : 삭제하려는 proj.가 없다.");
//			}
//		} else {
//			EndFailView.failView("TalentDonationProjectController : 삭제하려는 projectName 입력되지 않음");
//		}
	}
	
	
	
	

}
