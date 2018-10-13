package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: WeiCuicui
 * @data: 2018/10/13
 */
public class GitTest {
    public static void main(String[] args) {
        System.out.println("使用快捷键创建main函数和标准输出");
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        System.out.println(list);

        List<Object> transfer = Arrays.asList("a", "b", "c");
        System.out.println(transfer);
    }
}
