package practice;

/**
 * @author: WeiCuicui
 * @data: 2019/7/18
 */
public class Hanoi {

    // 统计移动次数
    static int count = 0;

    public static void main(String[] args) {
        char a = 'A';
        char b = 'B';
        char c = 'C';
        int n = 3;
        Hanoi test = new Hanoi();
        test.recurse(n, a, b, c);
        System.out.println(count);
    }

    // 移动一次
    private void move(int n, char from, char to){
        count = count + 1;
        System.out.println("将圆盘" + n + "号, 从" + from + "移动到" + to);
    }

    // 递归
    private void recurse(int n, char a, char b, char c){
        // 递归结束条件：n == 1，只要一个盘子时
        if (n == 1){
            move(1, a, c);
        } else {
            recurse(n - 1, a, c, b);
            move(n, a, c);
            recurse(n - 1, b, a, c);
        }
    }
}
