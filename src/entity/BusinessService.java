package entity;

import java.util.Map;

public class BusinessService {

    BookDao bookDao = new BookDao();

    /*列出所有的书*/
    public Map getAll() {

        return bookDao.getAll();
    }

    /*根据书的id获取书*/
    public Book findBook(String id) {
        return bookDao.find(id);
    }



    /*
    * 在购买书籍的时候，我们发现需要将书籍添加到购物车上
    * 如果我们直接在Servlet上使用Cart实体对象的addBook()和BookDao对象的find()方法，是可以完成功能的
    * 
    * 但是，这样web层的程序就跟Dao层的耦合了，为了代码性的健壮性和解耦，我们在BusinessService中对他俩进行封装
    * 
    * 于是有了buyBook()这个方法！
    * */
    
    /*把用户想买的书籍添加到当前用户的购物车上*/
    public void buyBook(String id, Cart cart) {

        Book book = bookDao.find(id);
        cart.addBook(book);

    }
    
    

    /*用户要在购物车中删除某个购物项*/
    public void deleteBook(String id, Cart cart) throws Exception {

        //如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
        //告诉用户购物车是空的
        if (cart == null) {
            throw new Exception("购物车为空");
        }

        //把购物项移除出去集合就行了！
        cart.getBookMap().remove(id);
    }
    

    public void clearCart(Cart cart) throws Exception {

        //如果用户是直接访问DeleteCartBook的Servlet的，在session中是没有cart这个属性的！
        //告诉用户购物车是空的
        if (cart == null) {
            throw new Exception("购物车为空");
        }

        //清空所有的购物项
        cart.getBookMap().clear();


    }


}

