package ex5;

import java.awt.Point;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import math.Vec;

import com.sun.opengl.util.FPSAnimator;

import ex5.models.IRenderable;

/**
 * An OpenGL model viewer 
 *
 */
public class Viewer implements GLEventListener {

	private double zoom = 0.0D;
	private boolean bWireframe = false;
	private boolean bAxis = true;
	private boolean isModelCamera = false;
	private boolean isModelInitialized = false;
	private Point mouseFrom, mouseTo;
	private IRenderable model;
	private FPSAnimator ani;
	private GLAutoDrawable m_drawable = null;


	private GLU glu = new GLU();
	private double[] rotation_matrix = { 1.0D, 0.0D, 0.0D, 0.0D, 
			0.0D, 1.0D, 0.0D, 0.0D, 
			0.0D, 0.0D, 1.0D, 0.0D, 
			0.0D, 0.0D, 0.0D, 1.0D };
	private int width;
	private int height;

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		if (!isModelInitialized) {
			model.init(gl);
			isModelInitialized = true;
		}

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		setupCamera(gl);
		if (bAxis) {
			renderAxes(gl);
		}
		model.render(gl, this.bWireframe, this.bAxis);
	}

	private void setupCamera(GL gl){
		if (!isModelCamera){
			gl.glLoadIdentity();

			if ((mouseFrom != null) && (mouseTo != null)){
				Vec vec_from = vecCalc(mouseFrom);
				Vec vec_to = vecCalc(mouseTo);
				Vec vec_axis = Vec.crossProd(vec_from, vec_to);
				//Normalize all 
				vec_from.normalize();
				vec_to.normalize();
				vec_axis.normalize();

				double angle = Math.toDegrees(Math.acos(vec_from.dotProd(vec_to)));
				gl.glRotated(angle, vec_axis.x, vec_axis.y, vec_axis.z);
			}
			gl.glMultMatrixd(rotation_matrix, 0);

			gl.glGetDoublev(2982, rotation_matrix, 0);

			gl.glLoadIdentity();
			gl.glTranslated(0.0D, 0.0D, -2.0D);
			gl.glTranslated(0.0D, 0.0D, -zoom);

			gl.glMultMatrixd(rotation_matrix, 0);

			mouseFrom = null;
			mouseTo = null;
		} else {
			gl.glLoadIdentity();
			model.setCamera(gl);
		}
	}
	
	private Vec vecCalc(Point point){
		double x = 2.0D * (point.x / (width - 1.0D)) - 1.0D;
		double y = 1.0D - 2.0D * (point.y / (height - 1.0D));
		double z = 2.0D - (x * x) - (y * y);
		
		//Check if z is negative
		if(z < 0.0D){
			z = 0.0D;
		}
		z = Math.sqrt(z);
		Vec vec = new Vec(x, y, z);
		vec.normalize();
		return vec;
	}
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}

	public void init(GLAutoDrawable drawable)
	{
		GL gl = drawable.getGL();
		drawable.setGL(new DebugGL(gl));

		gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);

		gl.glCullFace(GL.GL_BACK);
		gl.glEnable(2884);
		gl.glEnable(2977);
		gl.glShadeModel(7425);
		gl.glEnable(2929);

		ani = new FPSAnimator(30, true);
		ani.add(drawable);
		m_drawable = drawable;
		
		if (model.isAnimated()) {
			startAnimation();
		} else {
			stopAnimation();
		}
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL gl = drawable.getGL();

		this.width = width;
		this.height = height;
		double size = width / height;
		
		gl.glMatrixMode(5889);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0D, size, 0.1D, 1000.0D);
		gl.glMatrixMode(5888);
		gl.glLoadIdentity();
	}

	public void storeTrackball(Point from, Point to) {
		if (!isModelCamera){
			if (mouseFrom == null) {
				mouseFrom = from;
			}
			
			mouseTo = to;
			m_drawable.repaint();
		}
	}

	public void zoom(double s){
		if (!isModelCamera)
		{
			zoom += s * 0.1D;
			m_drawable.repaint();
		}
	}

	public void toggleRenderMode(){
		bWireframe = (!this.bWireframe);
		m_drawable.repaint();
	}

	public void toggleLightSpheres(){
		model.control(0, null);
		m_drawable.repaint();
	}

	public void toggleAxes(){
		bAxis = (!this.bAxis);
		m_drawable.repaint();
	}

	public void toggleModelCamera(){
		isModelCamera = (!isModelCamera);
		m_drawable.repaint();
	}

	public void startAnimation(){
		if (!ani.isAnimating()) {
			ani.start();
		}
	}

	public void stopAnimation(){
		if (ani.isAnimating()) {
			ani.stop();
		}
	}

	private void renderAxes(GL gl){
		gl.glLineWidth(2.0F);
		boolean flag = gl.glIsEnabled(2896);
		gl.glDisable(2896);
		gl.glBegin(1);
		gl.glColor3d(1.0D, 0.0D, 0.0D);
		gl.glVertex3d(0.0D, 0.0D, 0.0D);
		gl.glVertex3d(10.0D, 0.0D, 0.0D);

		gl.glColor3d(0.0D, 1.0D, 0.0D);
		gl.glVertex3d(0.0D, 0.0D, 0.0D);
		gl.glVertex3d(0.0D, 10.0D, 0.0D);

		gl.glColor3d(0.0D, 0.0D, 1.0D);
		gl.glVertex3d(0.0D, 0.0D, 0.0D);
		gl.glVertex3d(0.0D, 0.0D, 10.0D);

		gl.glEnd();
		if (flag) {
			gl.glEnable(2896);
		}
	}

	public void setModel(IRenderable model){
		this.model = model;
		this.isModelInitialized = false;
	}


}
