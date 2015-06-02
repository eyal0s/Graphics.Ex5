package ex5.models;

import javax.media.opengl.GL;

public class Axis {
	
	  public static void rendering(GL gl, double inputSize){
		boolean flag = gl.glIsEnabled(2896);
		
	    gl.glLineWidth(2.0F);
	    gl.glDisable(2896);
	    gl.glBegin(1);
	    gl.glColor3d(1.0D, 0.0D, 0.0D);
	    gl.glVertex3d(0.0D, 0.0D, 0.0D);
	    gl.glVertex3d(inputSize, 0.0D, 0.0D);
	    gl.glColor3d(0.0D, 1.0D, 0.0D);
	    gl.glVertex3d(0.0D, 0.0D, 0.0D);
	    gl.glVertex3d(0.0D, inputSize, 0.0D);
	    gl.glColor3d(0.0D, 0.0D, 1.0D);
	    gl.glVertex3d(0.0D, 0.0D, 0.0D);
	    gl.glVertex3d(0.0D, 0.0D, inputSize);
	    gl.glEnd();
	   
	    if (flag) 
	      gl.glEnable(2896);
	    
	  }
}
