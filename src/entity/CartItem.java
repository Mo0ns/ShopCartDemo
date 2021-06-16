package entity;


/*�����������ǵ�ǰ�飬����ʾ��������˼���*/
public class CartItem {

    private Book book;
    private int quantity;

    //�ù������--��һ��ֻ��һ�����ļ�ǮӦ�õ����������*�۸�
    private double price;

    
    //��ļ�Ǯ*����
    public double getPrice() {
        return book.getPrice() * this.quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}

