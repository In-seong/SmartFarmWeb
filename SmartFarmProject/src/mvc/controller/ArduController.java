package mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.model.HTDAO;
import mvc.model.HTDTO;

@WebServlet("*.do")
public class ArduController extends HttpServlet {
	 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 각 jsp로 뿌려주는것만 쓰겠다.
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		selHT(request);
		if(command.equals("/HTAction.do")) {
			selHT(request);
			request.getRequestDispatcher("/test.jsp").forward(request, response);
		}
		
	}
	
	public void selHT(HttpServletRequest request) {
		HTDAO dao = new HTDAO();
		HTDTO dto = dao.selectHT();
		System.out.println(dto.getHum()+"3");
		request.setAttribute("dto", dto);
	}

}
