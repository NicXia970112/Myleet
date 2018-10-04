
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int pointNum = Integer.parseInt(scn.nextLine());
        Point []points = new Point[pointNum];
        for(int i = 0; i < pointNum; i++) {
            points[i] = new Point();
            String in = scn.nextLine();
            String []input = in.split("[,]");
            points[i].x = Integer.parseInt(input[0]);
            points[i].y = Integer.parseInt(input[1]);
        }
        method.visit = new Point[points.length];
        method.dfs(0, points);
        int min = method.results.get(0);
        for(int a: method.results) {
            if(a < min) {
                min = a;
            }
        }
        System.out.println(min);
    }


}

class Point {

    public int x;

    public int y;

    public boolean isVisted = false;

}

class method {

    public static Point []visit;

    public static List<Integer> results = new ArrayList<>();

    public static void dfs(int n, Point[] points) {
        if(n == points.length) {
            int sum = 0;
            for(int i = 1; i < visit.length; i++) {
                sum += (Math.abs((visit[i].x - visit[i - 1].x)) + Math.abs(visit[i].y - visit[i - 1].y));
            }
            sum += (visit[0].x + visit[0].y);
            sum += (visit[visit.length - 1].x + visit[visit.length - 1].y);
            results.add(sum);
        }
        for(Point p: points) {
            if(!p.isVisted) {
                p.isVisted = true;
                visit[n] = p;
                dfs(n + 1, points);
                p.isVisted = false;
            }
        }
    }

}
