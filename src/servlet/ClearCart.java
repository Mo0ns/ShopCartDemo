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

        //�õ��û����Ӧ�Ĺ��ﳵ
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        //�������ӦBusinessService�ķ���
        BusinessService businessService = new BusinessService();

        try {

            //��չ��ﳵ��ʵ���Ͼ�����չ��ﳵ��Map�����е�Ԫ�ء�
            businessService.clearCart(cart);

            //���ظ����ﳵ��ʾҳ��
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "���ﳵ�ǿյģ�");
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
