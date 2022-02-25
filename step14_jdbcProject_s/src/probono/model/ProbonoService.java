package probono.model;

import java.sql.SQLException;
import java.util.ArrayList;

import probono.exception.NotExistException;
import probono.model.dto.ActivistDTO;
import probono.model.dto.ProbonoDTO;
import probono.model.dto.ProbonoProjectDTO;
import probono.model.dto.RecipientDTO;

//서버 내부에서 하나의 객체수를 보장하면서 서비스하게 되는 singleton design 구조
/* 재능기부 프로젝트에
 * 1. 4개의 table
 * 2. 4개의 DTO
 * 3. 4개의 DAO
 * 4. ProbonoService는 4개의 현 app~의 모든 DAO를 일괄 관리하는 메니저급 클래스 
 */
public class ProbonoService {
	
	private static ProbonoService instance = new ProbonoService();
	
	private ProbonoService(){}
	
	public static ProbonoService getInstance(){
		return instance;
	}
	
		 
	//Probono - CRUD
	public static void notExistProbono(String probonoId) throws NotExistException, SQLException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하진 재능기부 정보가 없습니다.");
		}
	}
	
	//모든 probono 정보 반환
	public static ArrayList<ProbonoDTO> getAllProbonos() throws SQLException{
		return ProbonoDAO.getAllProbonos();
	}
	//probono id로 검색
	public static ProbonoDTO getProbono(String probonoId) throws SQLException, NotExistException{
		ProbonoDTO probono = ProbonoDAO.getProbono(probonoId);
		if(probono == null){
			throw new NotExistException("검색하신 재능기부 정보가 없습니다.");
		}
		return probono;
	}
	//새로운 probono 저장
	public static boolean addProbono(ProbonoDTO probono) throws SQLException{
		return ProbonoDAO.addProbono(probono);
	}
	//기존 probono 수정
	public static boolean updateProbono(String probonoId, String probonoPurpose) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.updateProbono(probonoId, probonoPurpose);
	}
	//probono 삭제
	public boolean deleteProbono(String probonoId) throws SQLException, NotExistException{
		notExistProbono(probonoId);
		return ProbonoDAO.deleteProbono(probonoId);
	}
		
	
	
	//Activist - CRUD
	public static void notExistActivist(String activistId) throws NotExistException, SQLException{
		ActivistDTO activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
	}
	public static boolean addActivist(ActivistDTO activist) throws SQLException{
		return ActivistDAO.addActivist(activist);	
	}
	public static boolean updateActivist(String activistId, String major) throws SQLException, NotExistException{
		notExistActivist(activistId);
		return ActivistDAO.updateActivist(activistId, major);
	}
	public boolean deleteActivist(String activistId) throws SQLException, NotExistException{
		notExistActivist(activistId);
		return ActivistDAO.deleteActivist(activistId);
	}
	public static ActivistDTO getActivist(String activistId) throws SQLException, NotExistException{
		ActivistDTO activist = ActivistDAO.getActivist(activistId);
		if(activist == null){
			throw new NotExistException("검색하는 재능 기부자가 미 존재합니다.");
		}
		return activist;
	}
	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException{
		return ActivistDAO.getAllActivists();
	}
	
	
	
	//Recipient - CRUD
	public static void notExistRecipient(String recipientId) throws NotExistException, SQLException{
		RecipientDTO recipient = RecipientDAO.getRecipient(recipientId);
		if(recipient == null){
			throw new NotExistException("검색하는 재능 수해자가 미 존재합니다.");
		}
	}
	public static boolean addRecipient(RecipientDTO recipient) throws SQLException{
		return RecipientDAO.addRecipient(recipient);
	}
	public static boolean updateRecipient(String recipientId, String receiveHopeContent) throws SQLException, NotExistException{
		notExistRecipient(recipientId);
		return RecipientDAO.updateRecipient(recipientId, receiveHopeContent);
	}
	public boolean deleteRecipient(String recipientId) throws SQLException, NotExistException{
		notExistRecipient(recipientId);
		return RecipientDAO.deleteRecipient(recipientId);
	}
	public static RecipientDTO getRecipient(String recipientId) throws SQLException{
		return RecipientDAO.getRecipient(recipientId);
	}
	public static ArrayList<RecipientDTO> getAllRecipients() throws SQLException{
		return RecipientDAO.getAllRecipients();
	}
	
	/*CREATE TABLE probono_user (
			   pro_user_Id                   NUMBER(5) PRIMARY KEY,
		       probono_id           VARCHAR2(50) NOT NULL,       
		       activist_id          VARCHAR2(20) NOT NULL,
		       receive_id           VARCHAR2(20) NOT NULL, 
		       project_content      VARCHAR2(100) NULL
		);*/
	//ProjectUserDAO - CRUD
	public static void notExistProbonoUser(int probonoUserId) throws NotExistException, SQLException{
		ProbonoProjectDTO probonoUser = ProbonoProjectDAO.getProbonoProject(probonoUserId);
		if(probonoUser == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
	}
	public static boolean addProbonoUser(ProbonoProjectDTO probonoUser) throws SQLException{
		return ProbonoProjectDAO.addProbonoProject(probonoUser);
	}
	public static boolean updateProbonoUserActivist(int probonoUserId, String activistId) throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.updateProbonoProjectActivist(probonoUserId, activistId);
	}
	public static boolean updateProbonoUserReceive(int probonoUserId, String  receiveId) 	throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.updateProbonoProjectReceive(probonoUserId, receiveId);
	}
	public static boolean deleteProbonoUser(int probonoUserId) throws SQLException, NotExistException{
		notExistProbonoUser(probonoUserId);
		return ProbonoProjectDAO.deleteProbonoProject(probonoUserId);
	}
	
	//프로보노프로젝트 id로 존재 유무 검색하는 메소드 
	public static ProbonoProjectDTO getProbonoUser(int probonoUserId) throws SQLException, NotExistException{
		ProbonoProjectDTO probonoUser = ProbonoProjectDAO.getProbonoProject(probonoUserId);
		if(probonoUser == null){
			throw new NotExistException("검색하는 재능기부 프로젝트가 미 존재합니다.");
		}
		return probonoUser;
	}
	
	public static ArrayList<ProbonoProjectDTO> getAllProbonoUsers() throws SQLException{
		return ProbonoProjectDAO.getAllProbonoProjects();
	}
	
	
}
