package entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {

    //既然是购物车案例，应该会有增删的操作，通过关键字查询书籍，所以使用LinkedHashMap集合
    private static Map<String, Book> map = new LinkedHashMap<>();
    
    static {
        map.put("1",new Book("1", "java", "zhongfucheng", "好书", 99));
        map.put("2",new Book("2", "javaweb", "ouzicheng", "不好的书", 44));
        map.put("3",new Book("3", "ajax", "xiaoming", "一般般", 66));
        map.put("4",new Book("4", "spring", "xiaohong", "还行", 77));
    }

    public static Map<String, Book> getAll() {
        return map;
    }

}
