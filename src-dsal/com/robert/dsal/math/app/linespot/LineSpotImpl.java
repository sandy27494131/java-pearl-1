package com.robert.dsal.math.app.linespot;

import com.robert.dsal.advance.optimumpath.Point;


public class LineSpotImpl implements LineSpot {

    public int spotLine(Point[] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    Point point1 = points[i];
                    Point point2 = points[j];
                    Point point3 = points[k];

                    // if ((point1.x - point2.x) / (point3.x - point2.x) ==
                    // (point1.y - point2.y) / (point3.y - point2.y)) {
                    if ((point1.x - point2.x) * (point3.y - point2.y) == (point1.y - point2.y) * (point3.x - point2.x)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
