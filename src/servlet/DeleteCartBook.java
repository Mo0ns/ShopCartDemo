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

        //��ȡ�õ��û���Ҫɾ���ĸ��鱾��id
        String id = request.getParameter("bookid");

        //��ȡ���û����Ӧ�Ĺ��ﳵ����
        Cart cart = (Cart) request.getSession().getAttribute("cart");

        try {
            //ɾ�����ﳵ����Ʒ��ҲӦ������BusinessService���еĹ��ܣ����Ǻ��ֻص�BusinessService��д����
            BusinessService businessService = new BusinessService();
            businessService.deleteBook(id, cart);

            //ɾ�����ﳵ����Ʒ��ҲӦ��ֱ����ת��ȥ���ﳵ����ʾҳ����
            request.getRequestDispatcher("/listCart.jsp").forward(request, response);


        } catch (Exception e) {
            request.setAttribute("message", "���ﳵ���ˣ�");
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
