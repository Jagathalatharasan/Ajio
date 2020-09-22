package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderDetailsDao;
import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.dto.ProductDto;

@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		HttpSession se = request.getSession();
		if (button == null) {
			try {
				List<String> cList = ProductDao.getAllCategories();
				se.setAttribute("cList", cList);
				// System.out.println(cList);
				List<ProductDto> pList = ProductDao.getAllProducts();
				se.setAttribute("pList", pList);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			doPost(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String button = request.getParameter("bt");
		PrintWriter pw = response.getWriter();
		HttpSession se = request.getSession();
		if (button.equals("Register")) {
			String n = request.getParameter("t1");
			String e = request.getParameter("t2");
			String p = request.getParameter("t3");
			try {
				boolean check = UserDao.checkEmailExistsOrNot(e);
				if (check) {
					pw.println("Already Exists");
					// request.getRequestDispatcher("login.jsp").forward(request,
					// response);
				} else {
					boolean insert = UserDao.insertUserDetails(n, e, p);
					if (insert) {
						pw.println("Inserted Successfully");
						request.getRequestDispatcher("register.jsp").forward(request, response);
					} else {
						pw.println("Not Inserted");
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (button.equals("Login")) {
			String e = request.getParameter("f1");
			String p = request.getParameter("f2");

			try {
				boolean login = UserDao.checkLogin(e, p);
				String name = UserDao.getNameUsingEmail(e);
				int userId = UserDao.getUserIdByEmail(e);
				se.setAttribute("userId", userId);
				if (login) {
					se.setAttribute("name", name);
					request.getRequestDispatcher("loginhome.jsp").include(request, response);
				} else {
					pw.println("Incorrect Email and Password");
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (button.equals("Go")) {
			String c = request.getParameter("category");
			// System.out.println(c);

			try {
				List<ProductDto> pList = ProductDao.getCategoryValues(c);
				se.setAttribute("pList", pList);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("GO")) {
			String c = request.getParameter("category");
			// System.out.println(c);

			try {
				List<ProductDto> pList = ProductDao.getCategoryValues(c);
				se.setAttribute("pList", pList);
				request.getRequestDispatcher("loginhome.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (button.equals("Add To Cart")) {
			String pId[] = request.getParameterValues("id");
			String qty[] = request.getParameterValues("qty");
			List<ProductDto> selectedItemsList = new ArrayList<ProductDto>();
			List<String> qtyList = new ArrayList<String>();
			List<String> pIdList = new ArrayList<String>();
			ProductDto p = null;
			int totalPrice = 0;
			if (se.getAttribute("selectedItemsList") == null) {
				for (int i = 0; i < qty.length; i++) {

					try {
						if (Integer.parseInt(qty[i]) > 0) {
							p = ProductDao.getItemWithId(Integer.parseInt(pId[i]));
							totalPrice += (p.getPrice() * Integer.parseInt(qty[i]));
							selectedItemsList.add(p);
							// System.out.println(p.getName());
							qtyList.add(qty[i]);
						}
					} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				selectedItemsList = (List<ProductDto>) se.getAttribute("selectedItemsList");
				qtyList = (List<String>) se.getAttribute("qtyList");
				totalPrice = (int) se.getAttribute("totalPrice");
				for (int i = 0; i < qty.length; i++) {
					try {
						if (Integer.parseInt(qty[i]) > 0) {
							p = ProductDao.getItemWithId(Integer.parseInt(pId[i]));
							totalPrice += (p.getPrice() * Integer.parseInt(qty[i]));
							selectedItemsList.add(p);
							// System.out.println(p.getName());
							qtyList.add(qty[i]);
							pIdList.add(pId[i]);
						}
					} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			se.setAttribute("selectedItemsList", selectedItemsList);
			se.setAttribute("qtyList", qtyList);
			se.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("cart.jsp").include(request, response);
		} else if (button.equals("Continue")) {
			int userId = (int) se.getAttribute("userId");
			// System.out.println(userId);
			int totalPrice = (int) se.getAttribute("totalPrice");
			// System.out.println(totalPrice);
			Date d = new Date();
			Timestamp ts = new Timestamp(d.getTime());
			// System.out.println(ts);
			// String name = (String) se.getAttribute("name");
			List<ProductDto> selectedItemsList = (List<ProductDto>) se.getAttribute("selectedItemsList");
			List<String> qtyList = (List<String>) se.getAttribute("qtyList");
			int count = 0;
			try {
				boolean insert = OrdersDao.insertOrder(userId, totalPrice, ts);
				int orderId = OrdersDao.getOrderIdByUserIdAndTime(userId, ts);
				if (insert) {
					for (int i = 0; i < selectedItemsList.size(); i++) {
						boolean result = OrderDetailsDao.insertDetailsIntoTable(orderId,
								selectedItemsList.get(i).getId(), Integer.parseInt(qtyList.get(i)));
						if (result) {
							count++;
						}
					}
				}

				if (count == selectedItemsList.size()) {
					// System.out.println("Inserted Successfully");
					request.getRequestDispatcher("final.jsp").forward(request, response);
				} else {
					// System.out.println("Not Inserted");
					request.getRequestDispatcher("cart.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
