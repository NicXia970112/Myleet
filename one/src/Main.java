import java.util.Scanner;

public class Main {

    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String mn = sc.nextLine();
        String []MN = mn.split("[,]");
        int M = Integer.parseInt(MN[0]);
        int N = Integer.parseInt(MN[1]);

        Node[][] nodes = new Node[M][N];
        int i,j;
        for(i = 0; i < M; i++) {
            String S[] = sc.nextLine().split("[,]");
            for(j = 0; j < S.length; j++) {
                nodes[i][j] = new Node();
                nodes[i][j].setValue(Integer.parseInt(S[j]));
            }
        }


        for(i = 0; i < nodes.length; i++) {
            for(j = 0; j < nodes[i].length; j++) {

                if(nodes[i][j].getMark() == null) {
                    nodes[i][j].setMark(i * 10 + j); //给每个点特征值，当有子节点指向这个点时，把这个特征值赋值给子节点的特征值，以此传递
                }

                if(nodes[i][j].getValue() == 1) {
                    if((i + 1 < nodes.length)) {
                        if(nodes[i + 1][j].getValue() == 1) {
                            if(nodes[i + 1][j].getValue() == 1 && nodes[i + 1][j].getPre() != null) {
                                nodes[i][j].setPre(nodes[i + 1][j]);
                            }
                            else {
                                nodes[i + 1][j].setPre(nodes[i][j]);
                            }
                        }
                    }
                    if((j + 1 < nodes[i].length)) {
                        if(nodes[i][j + 1].getValue() == 1) {
                            if(nodes[i][j + 1].getValue() == 1 && nodes[i][j + 1].getPre() != null) {
                                nodes[i][j].setPre(nodes[i][j + 1]);
                            }
                            else {
                                nodes[i][j + 1].setPre(nodes[i][j]);
                            }
                        }
                    }
                    if(i + 1 < nodes.length && j + 1 < nodes[i].length) {
                        if(nodes[i + 1][j + 1].getValue() == 1) {
                            if(nodes[i + 1][j + 1].getValue() == 1 && nodes[i + 1][j + 1].getPre() != null) {
                                nodes[i][j].setPre(nodes[i + 1][j + 1]);
                            }
                            else {
                                nodes[i + 1][j + 1].setPre(nodes[i][j]);
                            }
                        }
                    }
                    if(i + 1 < nodes.length && j - 1 >= 0) {
                        if(nodes[i + 1][j - 1].getValue() == 1) {
                            if(nodes[i + 1][j - 1].getValue() == 1 && nodes[i + 1][j - 1].getPre() != null) {
                                nodes[i][j].setPre(nodes[i + 1][j - 1]);
                            }
                            else {
                                nodes[i + 1][j - 1].setPre(nodes[i][j]);
                            }
                        }
                    }
                }
            }
        }


        int P = 0,Q = 0;
        for(i = 0; i < nodes.length; i++) {
            for(j = 0; j < nodes[i].length; j++) {
                if(nodes[i][j].getValue() == 1 && nodes[i][j].getPre() == null) {
                    P++;
                }
            }
        }

        System.out.print(P + "," +  Q);

    }

}
