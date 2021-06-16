package entity;

import java.util.LinkedHashMap;
import java.util.Map;

/*���������ǹ��ﳵ*/
public class Cart {

    //�ؼ������鼮��id��ֵ����
    private Map<String, CartItem> bookMap = new LinkedHashMap<>();

    //�����Ź��ﳵ���ܼ�
    private double price;


    //�ѹ�����û����ݽ������鼮�����뵽���ﳵ���ȥ��ҲӦ���ǹ��ﳵ�Ĺ���
    public void addBook(Book book) {

        //��ȡ�õ�������
        CartItem cartItem = bookMap.get(book.getId());

        //�жϹ��ﳵ�Ƿ���ڸù�������������
        if (cartItem == null) {

            //����������������
            cartItem = new CartItem();

            //���û����ݹ������鼮��Ϊ������
            cartItem.setBook(book);

            //�Ѹù��������������Ϊ1
            cartItem.setQuantity(1);

            //�ѹ�������뵽���ﳵȥ
            bookMap.put(book.getId(), cartItem);
        } else {

            //������ڸù�����������������+1
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }

    //���ﳵ���ܼ۾������й�����ļ۸������
    public double getPrice() {

        double totalPrice = 0;

        for (Map.Entry<String, CartItem> me : bookMap.entrySet()) {

            //�õ�ÿ��������
            CartItem cartItem = me.getValue();

            //��ÿ���������Ǯ�����������ǹ��ﳵ���ܼ��ˣ�
            totalPrice += cartItem.getPrice();
        }

        return totalPrice;
    }


    public Map<String, CartItem> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, CartItem> bookMap) {
        this.bookMap = bookMap;
    }


    public void setPrice(double price) {
        this.price = price;
    }
}

