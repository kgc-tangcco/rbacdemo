package cn.kgc.tangcco.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.service.MenuService;
import cn.kgc.tangcco.service.UserService;
import cn.kgc.tangcco.service.impl.MenuServiceImpl;
import cn.kgc.tangcco.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
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
		//���������������
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//���ղ�����ֵ
		String flag=request.getParameter("flag");
		UserService userService=new UserServiceImpl();
		if ("login".equals(flag)) {//�����¼����
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			Integer roleId=Integer.parseInt(request.getParameter("role"));
			
			User user=userService.login(userName, password,roleId);
			if (user!=null) {//��½�ɹ�
			   request.getSession().setAttribute("user", user);
			   MenuService menuService=new MenuServiceImpl();
			   List<Menu> menuList=menuService.findOneMenu(user.getId());
			   System.out.println("������"+menuList.size());
			   request.getSession().setAttribute("menuList", menuList);
			   response.sendRedirect("view/main.jsp");
			}else{//��½ʧ��
				request.setAttribute("mess", "����д���ʺŻ�������ɫ����ȷ");
				/*response.getWriter().println("<script type='text/javascript'>location.href='index.jsp'</script>");*/
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
		}else if("logout".equals(flag)){//�����˳�����
			request.getSession().removeAttribute("user");
			 response.sendRedirect("index.jsp");
		}
	}

}
