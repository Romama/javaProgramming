package practice;

/**
 * @author: WeiCuicui
 * @data: 2019/11/25
 * 枚举定义及使用
 */
public enum EnumExample {
    AAA(1, "NICE"),
    BBB(2, "GOOD"),
    CCC(3, "EXCELLENT");

    /**
     * 顺序 1,2,3
     */
    private int code;
    /**
     * 对应的文本内容
     */
    private String value;

    EnumExample(int code, String value){
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
