package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.BusinessService;
import entity.Cart;

/**
 * Servlet implementation class DeleteCartBook
 */
@WebServlet("/DeleteCartBook")
public class DeleteCartBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //获取得到用户想要删除哪个书本的id
        String id = request.getParameter("bookid");

        //获取该用户相对应的购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        try {
            //删除购物车的商品，也应该是在BusinessService中有的功能，于是乎又回到BusinessService中写代码
            BusinessService businessService = new BusinessService();
            businessService.deleteBook(id, cart);

            //删除购物车的商品后，也应该直接跳转回去购物车的显示页面中
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);


        } catch (Exception e) {
            request.setAttribute("message", "购物车空了！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);

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
