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
 * Servlet implementation class ClearCart
 */
@WebServlet("/ClearCart")
public class ClearCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClearCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        //得到用户相对应的购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //调用相对应BusinessService的方法
        BusinessService businessService = new BusinessService();

        try {

            //清空购物车【实际上就是清空购物车的Map集合中的元素】
            businessService.clearCart(cart);

            //返回给购物车显示页面
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "购物车是空的！");
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
