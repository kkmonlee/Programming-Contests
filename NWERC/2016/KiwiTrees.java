import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by aa on 28/03/17.
 */
public class KiwiTrees {
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.valueOf(in.readLine());
            Point2D.Double[] pt = new Point2D.Double[n];

            for (int i = 0; i < n; i++) {
                String[] xy = in.readLine().split(" ");
                pt[i] = new Point2D.Double(Double.valueOf(xy[0]) / 1000, Double.valueOf(xy[1]) / 1000);
            }

            // list of circles
            ArrayList<Point2D.Double> circles = new ArrayList<>();

            // Try to put circles between each pair of consecutive poles
            for (int i = 0; i < n; i++) {
                Point2D.Double A = pt[i];
                Point2D.Double B = pt[(i + 1) % n];
                Point2D.Double C = pt[(i + 2) % n];

                // inner angle of A-B-C
                double angleA = Math.atan2(A.x - B.x, A.y - B.y);
                double angle = angleA - Math.atan2(C.x - B.x, C.y - B.y);
                // distance from corner
                double distance = (4.0 + 1e-9) / Math.sin(angle / 2.0);

                double absAngle = angleA - angle / 2.0;
                Point2D.Double p = new Point2D.Double(B.x + Math.sin(absAngle) * distance, B.y + Math.cos(absAngle) * distance);
                // check if correct
                boolean isTrue = pointInPolygon(p, pt);

                for (int j = 0; isTrue && j < n; j++) {
                    if (linePointDistance(pt[j], pt[(j + 1) % n], p) < 4 - 1e-9) {
                        isTrue = false;
                    }
                }
                // if correct add to array list
                if (isTrue) {
                    circles.add(p);
                }
            }
            // brute force and match circles
            for (Point2D.Double a : circles) {
                for (Point2D.Double b : circles) {
                    if (a == b) {
                        break;
                    }
                    if (a.distance(b) >= 8) {
                        System.out.println("possible");
                        return;
                    }
                }
            }

            System.out.println("impossible");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double linePointDistance(Point2D.Double L1, Point2D.Double L2, Point2D.Double P) {
        double dist = cross(minus(L2, L1), minus(P, L1)) / L1.distance(L2);
        if (dot(minus(P, L2), minus(L2, L1)) > 0)
            return L2.distance(P);
        if (dot(minus(P, L1), minus(L1, L2)) > 0)
            return L1.distance(P);

        return Math.abs(dist);
    }

    private static boolean pointInPolygon(Point2D.Double P, Point2D.Double[] polygon) {
        int j = polygon.length - 1;
        int c = 0;
        for (int i = 0; i < polygon.length; j = i++) {
            if ((polygon[j].y <= P.y) && (P.y < polygon[i].y) && ((cross(minus(polygon[j], P), minus(polygon[i], P))) > 0))
                ++c;
            if ((polygon[i].y <= P.y) && (P.y < polygon[j].y) && ((cross(minus(polygon[j], P), minus(polygon[i], P))) < 0))
                --c;
        }
        return c != 0;
    }
    // cross product
    private static double cross(Point2D.Double A, Point2D.Double B) {
        return A.x * B.y - A.y * B.x;
    }
    // dot product
    private static double dot(Point2D.Double A, Point2D.Double B) {
        return A.x * B.x + A.y * B.y;
    }
    // x0 - x1, y0 - y1
    private static Point2D.Double minus(Point2D.Double A, Point2D.Double B) {
        return new Point2D.Double(A.x - B.x, A.y - B.y);
    }
}
