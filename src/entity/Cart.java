package entity;

import java.util.LinkedHashMap;
import java.util.Map;

/*该类代表的是购物车*/
public class Cart {

    //关键字是书籍的id，值是书
    private Map<String, CartItem> bookMap = new LinkedHashMap<>();

    //代表着购物车的总价
    private double price;


    //把购物项（用户传递进来的书籍）加入到购物车里边去，也应该是购物车的功能
    public void addBook(Book book) {

        //获取得到购物项
        CartItem cartItem = bookMap.get(book.getId());

        //判断购物车是否存在该购物项，如果不存在
        if (cartItem == null) {

            //创建这个购物项对象
            cartItem = new CartItem();

            //将用户传递过来的书籍作为购物项
            cartItem.setBook(book);

            //把该购物项的数量设置为1
            cartItem.setQuantity(1);

            //把购物项加入到购物车去
            bookMap.put(book.getId(), cartItem);
        } else {

            //如果存在该购物项，将购物项的数量+1
            cartItem.setQuantity(cartItem.getQuantity() + 1);
        }
    }

    //购物车的总价就是所有购物项的价格加起来
    public double getPrice() {

        double totalPrice = 0;

        for (Map.Entry<String, CartItem> me : bookMap.entrySet()) {

            //得到每个购物项
            CartItem cartItem = me.getValue();

            //将每个购物项的钱加起来，就是购物车的总价了！
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

