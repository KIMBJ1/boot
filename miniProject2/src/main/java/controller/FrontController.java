package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Service;
import model.dto.SingerDTO;

@WebServlet("/song")
public class FrontController extends HttpServlet {
	public FrontController() {
		super();
	}

	// 수정-service로 합침
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		// command pattern
		String command = request.getParameter("command");

		// ?
		try {
			if (command.equals("songProjectAll")) {// 모든 song project 정보 검색
				songProjectAll(request, response);
			} else if (command.equals("singerAll")) {// 모든 가수 검색
				singerAll(request, response);
			} else if (command.equals("singer")) {// 특정 가수 정보 검색
				singer(request, response);
			} else if (command.equals("singerInsert")) {// 가수 추가 등록
				singerInsert(request, response);
			} else if (command.equals("singerUpdateReq")) {// 가수 정보 수정요청
				singerUpdateReq(request, response);
			} else if (command.equals("singerUpdate")) {// 가수 정보 수정
				singerUpdate(request, response);
			} else if (command.equals("singerDelete")) {// 가수 탈퇴[삭제]
				singerDelete(request, response);
			} else if (command.equals("fanclub")) {// 특정 팬클럽 조회
				fanclub(request, response);
			} else if (command.equals("fanclubUpdate")) {// 특정 팬클럽 조회
				fanclubUpdate(request, response);
			} else if (command.equals("fanclubUpdateReq")) {// 특정 팬클럽 조회
				fanclubUpdateReq(request, response);
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}

	// 모두 SongProject 검색 메소드
	public void songProjectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("songProjectAll", Service.getAllsongprojects());
			url = "songProjectList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 모든 가수 검색 - 검색된 데이터 출력 화면[singerList.jsp]
	public void singerAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("singerAll", Service.getAllSingers());
			url = "singerList.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 가수 상세사항 검색
	public void singer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("singer", Service.getSinger(request.getParameter("singer_id")));
			url = "singerDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 가수 입력 메소드
	protected void singerInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";

		String singer_id = request.getParameter("singer_id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String Company = request.getParameter("company");
		int debut_year = Integer.parseInt(request.getParameter("debut_year"));

		SingerDTO singer = new SingerDTO(singer_id, name, age, Company, debut_year);
		try {
			boolean result = Service.addSinger(singer);
			if (result) {
				request.setAttribute("singer", singer);
				request.setAttribute("successMsg", "가입 완료");
				url = "singerDetail.jsp";
			} else {
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 가수 수정 요구
	public void singerUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("singer", Service.getSinger(request.getParameter("singer_id")));
			url = "singerUpdate.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 가수 수정 - 상세정보 확인 jsp[singerDetail.jsp]
	public void singerUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String singer_id = request.getParameter("singer_id");
			String company = request.getParameter("company");
			Service.updateSinger(singer_id, company);
			request.setAttribute("singer", Service.getSinger(request.getParameter("singer_id")));
			url = "singerDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// ???
	// 가수 삭제
	public void singerDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String singer_id = request.getParameter("singer_id");
			if (Service.deleteSinger(singer_id)) {
				request.setAttribute("singerAll", Service.getAllSingers());
				url = "singerList.jsp";
			} else {
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		} catch (Exception s) {
			request.setAttribute("errorMsg", "진행중인 song Project가 있습니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팬클럽 상세사항 검색
	public void fanclub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("fanclub", Service.getFanclub(request.getParameter("fanclub_id")));
			url = "fanclubDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	// 팬클럽 수정 - 상세정보 확인 jsp[fanclubDetail.jsp]
	public void fanclubUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String fanclub_id = request.getParameter("fanclub_id");
			String fanclub_size = request.getParameter("fanclub_size");
			Service.updateFanclub(fanclub_id, fanclub_size);
			request.setAttribute("fanclub", Service.getFanclub(request.getParameter("fanclub_id")));
			url = "fanclubDetail.jsp";
		} catch (Exception s) {
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	// 팬클럽 수정 요구
		public void fanclubUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				request.setAttribute("fanclub", Service.getFanclub(request.getParameter("fanclub_id")));
				url = "fanclubUpdate.jsp";
			} catch (Exception s) {
				request.setAttribute("errorMsg", s.getMessage());
				s.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
		}

}
