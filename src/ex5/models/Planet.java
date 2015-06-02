package ex5.models;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.sun.opengl.util.texture.Texture;

public class Planet {

	public double r_orbit;
	public double r_planet;
	public double axial_tilt;
	public double incline;
	public double length;
	public double[] color;
	public boolean bWireFrame;
	public boolean bDrawAxis;
	public PlanetType planet_type;
	public Texture texture;

	public Planet(double r_orbit, double axial_tilt, PlanetType type, Texture texture, double[] color, boolean bWireFrame, double incline, double r_planet, boolean bDrawAxis)  {
		r_orbit = r_orbit;
		planet_type = type;
		axial_tilt = axial_tilt;
		ttexture = texture;
		color = ((double[])color.clone());
		bWireFrame = bWireFrame;
		incline = incline;
		r_planet = r_planet;
		bDrawAxis = bDrawAxis;
		length = (r_planet * 1.5D);
	}

	public void redering(GL gl, GLU glu){
		//Render orbit to all planets except the sun
		if (planet_type != PlanetType.SUN){
			renderOrbit(gl, glu);
		}
		renderPlanet(gl, glu);
	}

	private void renderPlanet(GL gl, GLU glu) {
		GLUquadric planet = glu.gluNewQuadric();
		gl.glPushMatrix();

		gl.glRotated(incline, 0.0D, 0.0D, 1.0D);
		orbitRotation(gl);
		gl.glTranslated(r_orbit, 0.0D, 0.0D);

		//Place the moon among the earth
		if (planet_type == PlanetType.EARTH)
		{
			renderMoon(gl, glu, planet);
		}

		gl.glRotated(axial_tilt, 0.0D, 0.0D, 1.0D);

		//Draw axis
		if (bDrawAxis) {
			Axis.rendering(gl, length);
		}
		//Add a ring to Saturn
		if (planet_type == PlanetType.SATURN) {
			renderRing(gl, glu, planet);
		}

		planetMatirial(gl);
		gl.glColor3d(color[0], color[1], color[2]);

		glu.gluQuadricDrawStyle(planet, 100012);
		glu.gluQuadricNormals(planet, 100001);
		glu.gluQuadricOrientation(planet, 100020);
		glu.gluSphere(planet, r_planet, 16, 16);

		glu.gluDeleteQuadric(planet);
		gl.glPopMatrix();
	}


	private void orbitRotation(GL gl){
		switch (planet_type){
		case SUN: 
			gl.glRotated(230.0D, 0.0D, 1.0D, 0.0D);
			break;
		case MERCURY: 
			gl.glRotated(-40.0D, 0.0D, 1.0D, 0.0D);
			break;
		case VENUS: 
			gl.glRotated(-40.0D, 0.0D, 1.0D, 0.0D);
			break;
		case EARTH: 
			break;
		case MARS: 
			gl.glRotated(30.0D, 0.0D, 1.0D, 0.0D);
			break;
		case JUPITER: 
			gl.glRotated(20.0D, 0.0D, 1.0D, 0.0D);
			break;
		case SATURN: 
			gl.glRotated(180.0D, 0.0D, 1.0D, 0.0D);
			break;
		case URANUS: 
			gl.glRotated(300.0D, 0.0D, 1.0D, 0.0D);
			break;
		case NEPTUNE: 
			gl.glRotated(-100.0D, 0.0D, 1.0D, 0.0D);
			break;
		case PLUTO: 
			gl.glRotated(-150.0D, 0.0D, 1.0D, 0.0D);
			break;

		}
	}

	private void planetMatirial(GL gl) {
		switch (planet_type) {

		case SUN: 
			float[] amb1 = { 0.0F, 1.0F, 1.0F, 1.0F };
			float[] dif1 = { 1.0F, 1.0F, 1.0F, 1.0F };
			float[] spec1 = { 0.0F, 0.0F, 0.5F, 1.0F };
			float shine1 = 10.2F;
			gl.glMaterialfv(1028, 4608, amb1, 0);
			gl.glMaterialfv(1028, 4610, spec1, 0);
			gl.glMaterialfv(1028, 4609, dif1, 0);
			gl.glMaterialf(1028, 5633, shine1);
			break;
		
		case MERCURY: 
			float[] amb2 = { 0.35F, 0.15F, 0.45F, 1.0F };
			float[] dif2 = { 0.42F, 0.55F, 0.7F, 1.0F };
			float[] spec2 = { 0.34F, 0.45F, 0.59F, 1.0F };
			float shine2 = 80.2F;
			gl.glMaterialfv(1028, 4608, amb2, 0);
			gl.glMaterialfv(1028, 4610, spec2, 0);
			gl.glMaterialfv(1028, 4609, dif2, 0);
			gl.glMaterialf(1028, 5633, shine2);
			break;

		case VENUS: 
			float[] amb3 = { 0.25F, 0.20725F, 0.20725F, 0.922F };
			float[] dif3 = { 1.0F, 0.829F, 0.829F, 0.922F };
			float[] spec3 = { 0.296648F, 0.296648F, 0.296648F, 0.922F };
			float shine3 = 11.2F;
			gl.glMaterialfv(1028, 4608, amb3, 0);
			gl.glMaterialfv(1028, 4610, spec3, 0);
			gl.glMaterialfv(1028, 4609, dif3, 0);
			gl.glMaterialf(1028, 5633, shine3);
			break;

		case EARTH: 
			float[] amb4 = { 0.49F, 0.33F, 0.3F, 1.0F };
			float[] diff4 = { 1.5F, 1.5F, 1.5F, 1.5F };
			float[] spec4 = { 0.95F, 0.53F, 0.24F, 1.0F };
			float shine4 = 57.0F;

			gl.glMaterialfv(1028, 4608, amb4, 0);
			gl.glMaterialfv(1028, 4610, spec4, 0);
			gl.glMaterialfv(1028, 4609, diff4, 0);
			gl.glMaterialf(1028, 5633, shine4);
			break;

		case MARS: 
			float[] amb5 = { 0.24725F, 0.1995F, 0.0745F, 1.0F };
			float[] dif5 = { 0.75164F, 0.60648F, 0.22648F, 1.0F };
			float[] spec5 = { 0.628281F, 0.555802F, 0.366065F, 1.0F };
			float shine5 = 51.2F;
			gl.glMaterialfv(1028, 4608, amb5, 0);
			gl.glMaterialfv(1028, 4610, spec5, 0);
			gl.glMaterialfv(1028, 4609, dif5, 0);
			gl.glMaterialf(1028, 5633, shine5);
			break;

		case JUPITER: 
			float[] amb6 = { 0.25F, 0.25F, 0.25F, 1.0F };
			float[] diff6 = { 0.4F, 0.4F, 0.4F, 1.0F };
			float[] spec6 = { 0.774597F, 0.774597F, 0.774597F, 1.0F };
			float shine6 = 76.8F;
			gl.glMaterialfv(1028, 4608, amb6, 0);
			gl.glMaterialfv(1028, 4610, spec6, 0);
			gl.glMaterialfv(1028, 4609, diff6, 0);
			gl.glMaterialf(1028, 5633, shine6);
			break;

		case SATURN: 
			float[] amb7 = { 0.63F, 0.6F, 0.17F, 1.0F };
			float[] dif7 = { 0.69F, 0.64F, 0.29F, 1.0F };
			float[] spec7 = { 0.05F, 0.05F, 0.22F, 1.0F };
			float shine7 = 128.0F;
			gl.glMaterialfv(1028, 4608, amb7, 0);
			gl.glMaterialfv(1028, 4610, spec7, 0);
			gl.glMaterialfv(1028, 4609, dif7, 0);
			gl.glMaterialf(1028, 5633, shine7);
			break;

		case URANUS: 
			float[] amb8 = { 0.25F, 0.25F, 0.25F, 1.0F };
			float[] dif8 = { 0.4F, 0.4F, 0.4F, 1.0F };
			float[] spec8 = { 0.774597F, 0.774597F, 0.774597F, 1.0F };
			float shine8 = 76.8F;
			gl.glMaterialfv(1028, 4608, amb8, 0);
			gl.glMaterialfv(1028, 4610, spec8, 0);
			gl.glMaterialfv(1028, 4609, dif8, 0);
			gl.glMaterialf(1028, 5633, shine8);
			break;
			
		case NEPTUNE: 
			float[] amb9 = { 0.2295F, 0.08825F, 0.0275F, 1.0F };
			float[] dif9 = { 0.5508F, 0.2118F, 0.066F, 1.0F };
			float[] spec9 = { 0.580594F, 0.223257F, 0.0695701F, 1.0F };
			float shine9 = 51.2F;
			gl.glMaterialfv(1028, 4608, amb9, 0);
			gl.glMaterialfv(1028, 4610, spec9, 0);
			gl.glMaterialfv(1028, 4609, dif9, 0);
			gl.glMaterialf(1028, 5633, shine9);
			break;
			
		case PLUTO: 
			float[] amb10 = { 0.43F, 0.13F, 0.33F, 1.0F };
			float[] dif10 = { 0.25F, 0.07F, 0.29F, 1.0F };
			float[] spec10 = { 0.7F, 0.04F, 0.04F, 1.0F };
			float shine10 = 10.2F;
			gl.glMaterialfv(1028, 4608, amb10, 0);
			gl.glMaterialfv(1028, 4610, spec10, 0);
			gl.glMaterialfv(1028, 4609, dif10, 0);
			gl.glMaterialf(1028, 5633, shine10);
			break;

		}
	}

	private void renderRing(GL gl, GLU glu, GLUquadric planet) {
		gl.glPushMatrix();

		float[] amb = { 1.0F, 1.0F, 0.0F, 1.0F };
		float[] diff = { 0.56F, 0.52F, 0.0F, 1.0F };
		float[] spec = { 0.56F, 0.52F, 0.0F, 1.0F };

		gl.glMaterialfv(1028, 4608, amb, 0);
		gl.glMaterialfv(1028, 4610, spec, 0);
		gl.glMaterialfv(1028, 4609, diff, 0);
		gl.glMaterialf(1028, 5633, 93.0F);
		glu.gluQuadricDrawStyle(planet, 100012);
		glu.gluQuadricNormals(planet, 100001);
		glu.gluQuadricOrientation(planet, 100020);

		gl.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
		glu.gluDisk(planet, r_planet * 1.2D, r_planet * 1.5D, 16, 16);
		gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
		glu.gluDisk(planet, r_planet * 1.2D,  r_planet * 1.5D, 16, 16);
		gl.glPopMatrix();
	}
	///asdadadadadad
	private void renderMoon(GL gl, GLU glu, GLUquadric planet){
		
		gl.glPushMatrix();
		float[] amb = { 0.25F, 0.20725F, 0.20725F, 0.922F };
		float[] dif = { 1.0F, 0.829F, 0.829F, 0.922F };
		float[] spec = { 0.296648F, 0.296648F, 0.296648F, 0.922F };
		
		gl.glMaterialfv(1028, 4608, amb, 0);
		gl.glMaterialfv(1028, 4610, spec, 0);
		gl.glMaterialfv(1028, 4609, dif, 0);
		gl.glMaterialf(1028, 5633, 11.2F);

		gl.glTranslated(r_planet * 1.4D, 0.0D, 0.0D);
		if (bDrawAxis) {
			Axis.rendering(gl, length);
		}
		glu.gluQuadricDrawStyle(planet, 100012);
		glu.gluQuadricNormals(planet, 100001);
		glu.gluQuadricOrientation(planet, 100020);
		glu.gluSphere(planet, r_planet * 0.3D, 16, 16);

		gl.glPopMatrix();
	}


	private void renderOrbit(GL gl, GLU glu){
		gl.glPushMatrix();
		gl.glRotated(incline, 0.0D, 0.0D, 1.0D);
		gl.glBegin(2);

		float[] color = { 0.5F, 0.5F, 1.0F };
		gl.glMaterialfv(1028, 4608, color, 0);
		gl.glMaterialfv(1028, 4609, color, 0);
		gl.glMaterialfv(1028, 4610, color, 0);
		gl.glMaterialf(1028, 5633, 0.0F);
		
		for (int i = 0; i < 361; i++) {
			gl.glVertex3d(r_orbit * Math.sin(i * 3.141592653589793D / 180.0D), 0.0D, r_orbit * Math.cos(i * 3.141592653589793D / 180.0D));
		}
		gl.glEnd();
		gl.glPopMatrix();
	}
	
	public enum PlanetType {
		SUN, MERCURY, VENUS, URANUS, NEPTUNE, PLUTO, EARTH, MARS, JUPITER, SATURN;	 
	}

}
