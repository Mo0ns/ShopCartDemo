package entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {

    //��Ȼ�ǹ��ﳵ������Ӧ�û�����ɾ�Ĳ�����ͨ���ؼ��ֲ�ѯ�鼮������ʹ��LinkedHashMap����
    private static Map<String, Book> map = new LinkedHashMap<>();
    
    static {
        map.put("1",new Book("1", "java", "zhongfucheng", "����", 99));
        map.put("2",new Book("2", "javaweb", "ouzicheng", "���õ���", 44));
        map.put("3",new Book("3", "ajax", "xiaoming", "һ���", 66));
        map.put("4",new Book("4", "spring", "xiaohong", "����", 77));
    }

    public static Map<String, Book> getAll() {
        return map;
    }

}