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
 * Servlet implementation class BuyBookServlet
 */
@WebServlet("/BuyBookServlet")
public class BuyBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //获取得到传递过来的id
        String id = request.getParameter("bookid");

        //把用户想要买的书放到购物车上
        //用户不单单只有一个，要让购物车上只为当前的用户服务，就需要用到会话跟踪技术了
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //如果当前用户还没有点击过购买的商品，那么是用户的购物车是空的
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        //调用BussinessService的方法，实现购买功能！
        BusinessService businessService = new BusinessService();
        businessService.buyBook(id, cart);

        //跳转到购物车显示的页面上
        request.getRequestDispatcher("/listCart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
