/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationProjectService.java
 * DESC  :  재능 기부 프로젝트를 저장, 수정, 삭제, 검색하는 서비스 로직
 * 
 * @author  
 * @version 1.0
*/

package step02.probono.service;

import java.util.ArrayList;
import java.util.Optional;

import step02.probono.exception.ProjectNameDuplicationException;
import step02.probono.exception.ProjectNotFoundException;
import step02.probono.model.dto.Beneficiary;
import step02.probono.model.dto.Donator;
import step02.probono.model.dto.TalentDonationProject;

public class TalentDonationProjectService {

	private static TalentDonationProjectService instance = new TalentDonationProjectService();

	private ArrayList<TalentDonationProject> donationProjectList = new ArrayList<TalentDonationProject>();

	private TalentDonationProjectService() {
	}

	public static TalentDonationProjectService getInstance() {
		return instance;
	}

	/**
	 * 모든 Project 검색
	 * 
	 * @return 모든 Project
	 */
	public ArrayList<TalentDonationProject> getDonationProjectsList() {
		return donationProjectList;
	}

	// TO DO
	/**
	 * Project 이름으로 검색 - 객체된 Project 반환하기
	 * 
	 * @param projectName 프로젝트 이름
	 * @return TalentDonationProject 검색된 프로젝트
	 */
	// 찾으려는 projectName 없으면 예외처리
	// 클래스 이름 ProjectNotFoundException.java 이름으로 검색시 없으면 예외 반환
	/*
	 * 없을 경우 ProjectNotFoundException 생성 및 반환 존재 할 경우 해당 proj. 반환 없을 경우
	 * ProjectNotFoundException 발생
	 * 
	 * 2차 개선 - EndView 직접 호출 - 단, 예외 처리 고려하지 않음
	 * 
	 * 3차 개선 - controller와 model로 구분 - controller 패키지 만들어서 정상응답 / 예외 발생 처리
	 */
//	public TalentDonationProject getDonationProject(String projectName) throws ProjectNotFoundException {
//		for (TalentDonationProject e : donationProjectList) {
//			if (e.getTalentDonationProjectName().equals(projectName)) {
//				return e;
//			}
//		}
//		throw new ProjectNotFoundException("TalentDonationProjectService : 요청한 " + projectName + " proj. 없음.");
//	}

	public TalentDonationProject getDonationProject(String projectName) throws ProjectNotFoundException {

		Optional<TalentDonationProject> project = donationProjectList.stream().filter(v -> v.getTalentDonationProjectName().equals(projectName)).findAny();
		
		if(!project.isPresent()) {
			throw new ProjectNotFoundException("요청하신 project는 존재하지 않습니다");
		};
		
		return project.get();
	}
	
	// TO DO
	/**
	 * 새로운 Project 추가
	 * 
	 * @param project 저장하고자 하는 새로운 프로젝트
	 */
	/*
	 * 혹시 같은 이름의 project 있으면 add 하면 안되지 개발 방식 1. 동일하지 않다 : 정상 저장 2. 동일하다 : 거부 - 예외
	 * 발생? *******************************************이걸로 함 - DB 사용시 중복 불허 기능이 예외 발생
	 * - 문자열 반환? - boolean 반환? - ...
	 */
	public void donationProjectInsert(TalentDonationProject project) throws ProjectNameDuplicationException {
		for (TalentDonationProject e : donationProjectList) {
			if (e.getTalentDonationProjectName().equals(project.getTalentDonationProjectName())) {
				throw new ProjectNameDuplicationException("TalentDonationProjectService : 이미 존재하는 proj.이므로 add할 수 없음");
			}
		}
		donationProjectList.add(project);
	}

	/**
	 * Project의 기부자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 기부자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      기부자
	 */
	/*
	 * 존재하는 proj. 한해서 수정 고려사항 경우의 수1 - project 존재할 경우 수정 경우의 수2 - roject 미존재할 경우 -
	 * 예외발생 - boolean 반환 **************************이걸로 함 - ...
	 * 
	 * boolean - boolean 값 획득하는 곳은 controller - false(update 실패)와 true(update 성공)에
	 * 따른 처리
	 */
	public boolean donationProjectUpdate(String projectName, Donator people) {
		for (TalentDonationProject project : donationProjectList) {
			if (project != null && project.getTalentDonationProjectName().equals(projectName)) {
				project.setProjectDonator(people);
				return true; // 메소드 자체가 종료
			}
		}
		return false;
	}

	// TO DO
	/**
	 * Project의 수혜자 수정 - 프로젝트 명으로 검색해서 해당 프로젝트의 수혜자 수정
	 * 
	 * @param projectName 프로젝트 이름
	 * @param people      수혜자
	 */

	// ? 갱신하려는 proj. 미존재시 ProjectNotFoundException 추가
	/*
	 * 존재하는 proj. : 성공 미존재 proj. : 예외 발생
	 * 
	 * 이 메소드 호출한 곳에서 어떻게 성공 여부 확인? - 미 존재할 경우 예외 처리 - 존재할 경우(예외 발생이 안될 경우) 수정
	 * 
	 */
	public void beneficiaryProjectUpdate(String projectName, Beneficiary people) throws ProjectNotFoundException {

		for (TalentDonationProject e : donationProjectList) {
			if (e != null && e.getTalentDonationProjectName().equals(projectName)) {
				e.setProjectBeneficiary(people);
				return; // return 뒤에 반환값이 없음 즉 void인 메소드 자체 종료시 return;으로 처리하기도 함
//				break;
			}
		}
		throw new ProjectNotFoundException("TalentDonationProjectService : 수혜자 정보를 수정하려는 proj. 없음");
	}

	// TO DO
	/**
	 * Project 삭제 - 프로젝트 명으로 해당 프로젝트 삭제
	 * 
	 * @param projectName 삭제하고자 하는 프로젝트 이름
	 */
	public boolean donationProjectDelete(String projectName) {
		TalentDonationProject project = null;
		int count = donationProjectList.size();

		for (int i = 0; i < count; i++) {
			project = donationProjectList.get(i);
			if (project.getTalentDonationProjectName().equals(projectName)) {
				donationProjectList.remove(i);
				return true;
			}
		}

		return false;
	}

	/**
	 * 진행중인 Project 총 개수 반환
	 * 
	 * @return 개수
	 */

	public int projectListSize() {
		return donationProjectList.size();
	}
}
