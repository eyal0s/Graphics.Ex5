package math;

import java.util.Scanner;

public class Point3D {
	 public double x;
	  public double y;
	  public double z;
	  
	  public Point3D(String v)
	  {
	    Scanner s = new Scanner(v);
	    this.x = s.nextDouble();
	    this.y = s.nextDouble();
	    this.z = s.nextDouble();
	    s.close();
	  }
	  
	  public Point3D()
	  {
	    this.x = 0.0D;
	    this.y = 0.0D;
	    this.z = 0.0D;
	  }
	  
	  public Point3D(double i_x, double i_y, double i_z)
	  {
	    this.x = i_x;
	    this.y = i_y;
	    this.z = i_z;
	  }
	  
	  public Point3D(Point3D i_point)
	  {
	    this.x = i_point.x;
	    this.y = i_point.y;
	    this.z = i_point.z;
	  }
	  
	  public Vec GetVectorToPoint(Point3D i_point)
	  {
	    return new Vec(i_point.x - this.x, i_point.y - this.y, i_point.z - this.z);
	  }
	  
	  public Point3D addVector(Vec i_vector)
	  {
	    return new Point3D(this.x + i_vector.x, this.y + i_vector.y, this.z + i_vector.z);
	  }
	  
	  public Point3D subtractVector(Vec i_vector)
	  {
	    return addVector(Vec.negate(i_vector));
	  }
	  
	  public double distance(Point3D i_point)
	  {
	    return GetVectorToPoint(i_point).length();
	  }
	  
	  public boolean equals(Point3D i_point)
	  {
	    return (this.x == i_point.x) && (this.y == i_point.y) && (this.z == i_point.z);
	  }
}
