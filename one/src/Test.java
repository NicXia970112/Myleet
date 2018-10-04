

import java.util.Scanner;

class Node {

    private int value;//1 0 判断是否有人

    private Node pre;//父节点

    private Integer mark;//特征值

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}


