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
        //��ȡ�õ����ݹ�����id
        String id = request.getParameter("bookid");

        //���û���Ҫ�����ŵ����ﳵ��
        //�û�������ֻ��һ����Ҫ�ù��ﳵ��ֻΪ��ǰ���û����񣬾���Ҫ�õ��Ự���ټ�����
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //�����ǰ�û���û�е�����������Ʒ����ô���û��Ĺ��ﳵ�ǿյ�
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }

        //����BussinessService�ķ�����ʵ�ֹ����ܣ�
        BusinessService businessService = new BusinessService();
        businessService.buyBook(id, cart);

        //��ת�����ﳵ��ʾ��ҳ����
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
