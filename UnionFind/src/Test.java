public class Test {

    public static void main(String []args) {
        int [][]nums = {{1,1,0,0,0},{1,0,0,1,0},{1,1,0,1,0},{0,0,1,0,0}};
        Node [][]nodes = new Node[4][5];
        int i, j, count = 0;

        for(i = 0; i < nodes.length; i++) {
            for(j = 0; j < nodes[i].length; j++) {
                nodes[i][j] = new Node();
                nodes[i][j].setValue(nums[i][j]);
            }
        }

        for(i = 0; i < nodes.length; i++) {
            for(j = 0; j < nodes[i].length; j++) {
                if(nodes[i][j].getValue() == 1) {
                    if((i + 1 < nodes.length)) {
                        if(nodes[i + 1][j].getValue() == 1) {
                            nodes[i + 1][j].setPre(nodes[i][j]);
                        }
                    }
                    if((j + 1 < nodes[i].length)) {
                        if(nodes[i][j + 1].getValue() == 1) {
                            nodes[i][j + 1].setPre(nodes[i][j]);
                        }
                    }
                }
            }
        }

        for(i = 0; i < nodes.length; i++) {
            for(j = 0; j < nodes[i].length; j++) {
                if(nodes[i][j].getValue() == 1 && nodes[i][j].getPre() == null) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

}

