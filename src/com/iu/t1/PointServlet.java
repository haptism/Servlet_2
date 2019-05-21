package com.iu.t1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.action.ActionForward;

/**
 * Servlet implementation class PointServlet
 */
@WebServlet("/PointServlet")
public class PointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command=request.getPathInfo();
		String path="";
		boolean check=false;
		ActionForward actionForward = new ActionForward();
		if(command.equals("/pointList")) {
			String name="iu";
			request.setAttribute("n", name);
			actionForward.setPath("../pointList.jsp");
			actionForward.setCheck(true);
			
		}else if(command.equals("/pointWrite")) {
			String name="suji";
			request.setAttribute("name", name);
			actionForward.setPath("../WEB-INF/view/point/pointWrite.jsp");
			actionForward.setCheck(true);
			
		}else if(command.equals("/pointDelete")) {
			System.out.println("Delete");
			actionForward.setPath("./pointList");
			actionForward.setCheck(false);
		}
		
		//forward
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
