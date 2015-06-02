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

		//Front - Red
	    gl.glColor3f(1.0f, 0.0f, 0.0f);
	    gl.glVertex3f( 0.5f,  0.5f, - 0.5f);	   
	    gl.glVertex3f( 0.5f, - 0.5f, - 0.5f);
	    gl.glVertex3f(- 0.5f, - 0.5f, - 0.5f);
	    gl.glVertex3f(- 0.5f,  0.5f, - 0.5f);
		
	    // Back side - Yellow  
	    gl.glColor3f(1.0f,  1.0f, 0.0f);
		gl.glVertex3f(  0.5f, -0.5f, 0.5f );
		gl.glVertex3f( 0.5f,  0.5f, 0.5f );
		gl.glVertex3f( -0.5f,  0.5f, 0.5f );
		gl.glVertex3f( -0.5f, -0.5f, 0.5f );
		   
		// Right side - Purple
		gl.glColor3f(  1.0f,  0.0f,  1.0f );
		gl.glVertex3f( 0.5f, -0.5f, -0.5f );
		gl.glVertex3f( 0.5f,  0.5f, -0.5f );
		gl.glVertex3f( 0.5f,  0.5f,  0.5f );
		gl.glVertex3f( 0.5f, -0.5f,  0.5f );
		   
		// Left side - Green
		gl.glColor3f(   0.0f,  1.0f,  0.0f );
		gl.glVertex3f( -0.5f, -0.5f,  0.5f);
		gl.glVertex3f( -0.5f,  0.5f,  0.5f );
		gl.glVertex3f( -0.5f,  0.5f, -0.5f );
		gl.glVertex3f( -0.5f, -0.5f, -0.5f );
		   
		// Top side - Blue
		gl.glColor3f(   0.0f,  0.0f,  1.0f );
		gl.glVertex3f(  0.5f,  0.5f,  0.5f );
		gl.glVertex3f(  0.5f,  0.5f, -0.5f );
		gl.glVertex3f( -0.5f,  0.5f, -0.5f );
		gl.glVertex3f( -0.5f,  0.5f,  0.5f );
		 
		   
		// Bottom side - Black
		gl.glColor3f( 0.0f,  0.0f,  0.0f );
		gl.glVertex3f(  0.5f, -0.5f, -0.5f );
		gl.glVertex3f(  0.5f, -0.5f,  0.5f );
		gl.glVertex3f( -0.5f, -0.5f,  0.5f );
		gl.glVertex3f( -0.5f, -0.5f, -0.5f );
		
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
	    return "Cube In 3D";
	  }
	}

