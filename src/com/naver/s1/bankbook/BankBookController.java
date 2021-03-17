package com.naver.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.s1.util.ActionForward;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BankBookService bankBookService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	 //컨트롤러 객체생성 후 자동 호출되는 초기화 메서드
    	bankBookService = new BankBookService();
    	BankBookDAO bankBookDAO = new BankBookDAO();
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//   /WebFullStac_21/bankbook/bankbookList.do
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/"); // 슬러시의 인덱스번호찾기
		uri = uri.substring(index+1); //bankbookList.do 의 첫 시작 인덱스
		ActionForward actionForward = null;
		
		try {
		if(uri.equals("bankbookList.do")) {
		actionForward = backBookService.getList(request);
		//actionforward 안에 패스정보, 트루폴스 정보있음
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//forward or redirect 
		if(actionForward.isCheck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
			
		}else {
			response.sendRedirect(actionForward.getPath());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
