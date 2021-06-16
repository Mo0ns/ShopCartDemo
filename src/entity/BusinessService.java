package entity;

import java.util.Map;

public class BusinessService {

    BookDao bookDao = new BookDao();

    /*�г����е���*/
    public Map getAll() {

        return bookDao.getAll();
    }

    /*�������id��ȡ��*/
    public Book findBook(String id) {
        return bookDao.find(id);
    }



    /*
    * �ڹ����鼮��ʱ�����Ƿ�����Ҫ���鼮��ӵ����ﳵ��
    * �������ֱ����Servlet��ʹ��Cartʵ������addBook()��BookDao�����find()�������ǿ�����ɹ��ܵ�
    * 
    * ���ǣ�����web��ĳ���͸�Dao�������ˣ�Ϊ�˴����ԵĽ�׳�Ժͽ��������BusinessService�ж��������з�װ
    * 
    * ��������buyBook()���������
    * */
    
    /*���û�������鼮��ӵ���ǰ�û��Ĺ��ﳵ��*/
    public void buyBook(String id, Cart cart) {

        Book book = bookDao.find(id);
        cart.addBook(book);

    }
    
    

    /*�û�Ҫ�ڹ��ﳵ��ɾ��ĳ��������*/
    public void deleteBook(String id, Cart cart) throws Exception {

        //����û���ֱ�ӷ���DeleteCartBook��Servlet�ģ���session����û��cart������Եģ�
        //�����û����ﳵ�ǿյ�
        if (cart == null) {
            throw new Exception("���ﳵΪ��");
        }

        //�ѹ������Ƴ���ȥ���Ͼ����ˣ�
        cart.getBookMap().remove(id);
    }
    

    public void clearCart(Cart cart) throws Exception {

        //����û���ֱ�ӷ���DeleteCartBook��Servlet�ģ���session����û��cart������Եģ�
        //�����û����ﳵ�ǿյ�
        if (cart == null) {
            throw new Exception("���ﳵΪ��");
        }

        //������еĹ�����
        cart.getBookMap().clear();


    }


}

