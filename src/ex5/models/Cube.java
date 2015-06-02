package ex5.models;

import javax.media.opengl.GL;

public class Cube implements IRenderable {
	
	public void render(GL gl, boolean bWireFrame, boolean bAxis) {
	   
		if (bWireFrame) {
	      gl.glPolygonMode(1032, 6913);
	    } else {
	      gl.glPolygonMode(1032, 6914);
	    }
	    renderCube(gl);
	    gl.glFlush();
	  }
	  
	  private void renderCube(GL gl) {    
		gl.glDisable(2896);
		gl.glBegin(7);


		// painting the cube with various colors

		double currentSideOffset = 0.3;
		
		gl.glColor3d(1,0,1);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,+currentSideOffset);	
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,+currentSideOffset);	
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,+currentSideOffset);	
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,+currentSideOffset);
		
		gl.glColor3d(1,1,0);
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,+currentSideOffset);		
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,-currentSideOffset);
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,+currentSideOffset);
		
		gl.glColor3d(0,0,0.5);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,+currentSideOffset);
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,+currentSideOffset);
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,-currentSideOffset);

		gl.glColor3d(0.5,0.1,0);
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,-currentSideOffset);
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,-currentSideOffset);			
				
		gl.glColor3d(0.4,1,0);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,-currentSideOffset);
		gl.glVertex3d(+currentSideOffset,-currentSideOffset,+currentSideOffset);
		gl.glVertex3d(-currentSideOffset,-currentSideOffset,+currentSideOffset);
		
		gl.glColor3d(0,1,0.5);
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,+currentSideOffset);
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,+currentSideOffset);
		gl.glVertex3d(+currentSideOffset,+currentSideOffset,-currentSideOffset);
		gl.glVertex3d(-currentSideOffset,+currentSideOffset,-currentSideOffset);
		
		gl.glEnd();   
		gl.glFlush();  
	  }
	  
	  public void init(GL gl) {}
	  
	  public void control(int type, Object params) {}
	  
	  public boolean isAnimated() {
	    return false;
	  }
	  
	  public void setCamera(GL gl) {}
	  
	  public String toString() {
	    return "Cube";
	  }
	}

