package cn.kgc.tangcco.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.entity.Menu;
import cn.kgc.tangcco.entity.User;
import cn.kgc.tangcco.entity.UserRole;
import cn.kgc.tangcco.service.MenuService;
import cn.kgc.tangcco.service.UserRoleService;
import cn.kgc.tangcco.service.impl.MenuServiceImpl;
import cn.kgc.tangcco.service.impl.UserRoleServiceImpl;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
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
				//接收参数的值
				String flag=request.getParameter("flag");
				MenuService menuService=new MenuServiceImpl();
				if ("showsubMenu".equals(flag)) {
					Integer userId=((User)request.getSession().getAttribute("user")).getId();
					Integer parentId=Integer.parseInt(request.getParameter("parentId"));
					List<Menu> subMenuList=menuService.findTwoMenu(userId,parentId);
					request.setAttribute("subMenuList", subMenuList);
					JSON json=(JSON) JSON.toJSON(subMenuList);
					System.out.println(json);
					response.getWriter().print(json);
				}else if("addUserRole".equals(flag)){//添加用户角色
					String[] roles=request.getParameterValues("roles");
					String role=roles[0];
					String[] roleIds=role.split(",");
					//获取授权的用户id
					Integer userId=Integer.parseInt(request.getParameter("userId"));
					UserRoleService userRoleService=new UserRoleServiceImpl();
					for (String roleId : roleIds) {
						UserRole userRole=new UserRole(userId, Integer.parseInt(roleId));
						userRoleService.saveUserRole(userRole);
					}
					/*response.sendRedirect("view/main.jsp");*/
					response.getWriter().print("<script type='text/javascript'>alert('授权成功');history.back()</script>");
				}
	}

}
