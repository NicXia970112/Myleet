import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]) {
        String s = "aaabbbpcccd";
        char []chars = s.toCharArray();
        List<Node> lists = new ArrayList<Node>();
        Method m = new Method();
        m.setLists(lists);

        for(int i = 0; i < chars.length; i++) {
            Node n = new Node();
            n.setC(chars[i]);
            m.add(n);
        }
        for(int i = 0; i < m.getLists().size(); i++) {
            if(m.getLists().get(i).getState() == 1) {
                System.out.println(++i);
                break;
            }
        }
    }
}

class Method {

    private List<Node> lists;

    public List<Node> getLists() {
        return lists;
    }

    public void setLists(List<Node> lists) {
        this.lists = lists;
    }

    public void add(Node n) {
        if(lists.size() == 0) {
            lists.add(n);
            return;
        }
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i).getC().equals(n.getC())) {
                lists.get(i).setState(0);
                n.setState(0);
            }
        }
        lists.add(n);
    }

}

class Node {

    private Character c;

    private int state = 1;

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}