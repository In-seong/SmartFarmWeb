package mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String message = request.getParameter("message");
	    HttpSession session = request.getSession();
	    @SuppressWarnings("unchecked")
	    ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
	    if (messages == null) {
	      messages = new ArrayList<String>();
	      session.setAttribute("messages", messages);
	    }
	    messages.add(message);
	    response.sendRedirect("chat.jsp");
	  }

}
