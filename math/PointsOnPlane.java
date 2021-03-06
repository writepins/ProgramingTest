package math;

import java.util.*; 

public class PointsOnPlane implements PointsOnAPlane{ 

	ArrayList<Point> points = new ArrayList<Point>(); 
	
	public static void main (String[] args){ 
		PointsOnPlane p = new PointsOnPlane(); 
		// (0, 1) (0, 2) (0, 3) (0, 4) (0, 5) 
		p.addPoint(new Point(0,1)); 
		p.addPoint(new Point(0,2)); 
		p.addPoint(new Point(0,3)); 
		p.addPoint(new Point(0,4)); 
		p.addPoint(new Point(0,5)); 

		ArrayList<Point> nearestPoints = p.findNearest(new Point(0, 0), 3) ; 

		for (Point point: nearestPoints){ 
			System.out.println((int)point.getX() + "," + (int)point.getY()); 
		} 
	}
	
	@Override 
	public void addPoint(Point point) { 
		points.add(point); 

	} 

	@Override 
	public ArrayList<Point> findNearest(Point center, int m) { 
		// TODO Auto-generated method stub 
		PriorityQueue<Point> q = new PriorityQueue<Point>(); 
		for (Point p : points){ 
			double dist = Math.pow((center.getX() - p.getX()),2) + Math.pow((center.getY() - p.getY()),2) ; 
			p.setDistFromCenter(dist); 
			q.add(p); 
		} 
		ArrayList<Point> nearestPoints = new ArrayList<Point>(); 
		for (int i = 0; i < m; i++){ 
			nearestPoints.add(q.poll()); 
		} 
		return nearestPoints; 
	}
}

class Point implements Comparable{ 
	double x; 
	double y; 
	Double distFromCenter = null; 

	public Double getDistFromCenter() { 
		return distFromCenter; 
	} 
	public void setDistFromCenter(double distFromCenter) { 
		this.distFromCenter = distFromCenter; 
	} 
	public Point(double x, double y) { 
		super(); 
		this.x = x; 
		this.y = y; 
	} 
	public double getX() { 
		return x; 
	} 
	public void setX(double x) { 
		this.x = x; 
	} 
	public double getY() { 
		return y; 
	} 
	public void setY(double y) { 
		this.y = y; 
	} 

	public int compareTo(Object y){ 
		Double y_distFromCenter = ((Point)y).getDistFromCenter(); 
		if (distFromCenter != null && y_distFromCenter != null){ 
			if (distFromCenter == y_distFromCenter){ 
				return 0; 
			}else if (distFromCenter > y_distFromCenter){ 
				return 1; 
			}else{ 
				return -1; 
			} 
		} 
		else 
			return 0; 
	} 
} 

interface PointsOnAPlane{
	void addPoint(Point point);
	Collection<Point> findNearest(Point center, int m);
}
