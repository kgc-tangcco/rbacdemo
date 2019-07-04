package cn.kgc.tangcco.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Role;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.entity.UserRole;
import cn.kgc.tangcco.service.RoleService;
import cn.kgc.tangcco.service.RoleServiceImpl;
import cn.kgc.tangcco.service.UserRoleService;
import cn.kgc.tangcco.service.UserService;
import cn.kgc.tangcco.service.impl.UserRoleServiceImpl;
import cn.kgc.tangcco.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShowAllUserServlet
 */
@WebServlet("/ShowAllUserServlet")
public class ShowAllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//接收参数
		Integer menuId=Integer.parseInt(request.getParameter("menuId"));
		System.out.println("哈哈哈"+menuId);
		Integer userId=((User)request.getSession().getAttribute("user")).getId();
		if (menuId==91) {//显示用户页面
			UserService userService=new UserServiceImpl();
		
			List<User> userList=userService.findAllUser();
			
			
			request.setAttribute("userList", userList);
			
			request.getRequestDispatcher("view/user/showUser.jsp").forward(request, response);;
		}
	}

}
