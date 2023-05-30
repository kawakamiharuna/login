package jp.co.aforce.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.admin.Admin;
import jp.co.aforce.data.Sarch;


/**
 * Servlet implementation class Login
 */
@WebServlet("/login/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/login.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		
		//入力データの値がない場合（ログイン失敗）
		Sarch sarch = new Sarch();
		Admin admin = sarch.check(userId , password);
		
		if(admin.isLoginOk()) {
			//成功
			System.out.println("ようこそ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/login-in.jsp");
			dispatcher.forward(request, response);
		} else {
			//失敗
			System.out.println("IDまたはパスワードが違います。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("../jsp/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
