package ex5.models;

import java.util.List;
import java.util.ArrayList;
import ex5.models.Planet;
import ex5.models.PlanetType;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class solarSystem  implements IRenderable {
	private boolean bLight = false;
	  
	  public void render(GL gl, boolean bWireFrame, boolean bAxis) {
		  
	    List<Planet> planets = new ArrayList();
	    GLU glu = new GLU();
	   
	    if (bWireFrame) {
	      gl.glPolygonMode(1032, 6913);
	    } else {
	      gl.glPolygonMode(1032, 6914);
	    }
	    
	    setLight(gl, glu);
	    createPlanets(planets, bWireFrame, bAxis);

	    //Render the planets
	    for (Planet p : planets) {
		      p.redering(gl, glu);
	    }
	  }
	  
	  private void setLight(GL gl, GLU glu) {
	    float[] amb = { 0.5F, 0.5F, 0.5F, 1.0F };
	    gl.glLightModelfv(2899, amb, 0);
	    
	 
	    float[] pos1 = { 0.0F, 1.0F, 0.5F, 1.0F};
	    float[] pos2 = { 0.0F, 1.0F, -1.0F, 1.0F};
	    float[] pos3 = { 0.0F, -1.0F, 0.5F, 1.0F};
	    
	    float[] spec1 = { 0.8F, 0.8F, 0.8F, 1.0F };
	    float[] diff1 = { 0.5F, 0.5F, 0.5F, 1.0F };
	    
	    float[] spec3 = { 1.0F, 0.0F, 0.0F, 1.0F };
	    float[] diff3 = { 1.0F, 0.0F, 0.0F, 1.0F };
	    
	    gl.glLightfv(16384, 4611, pos1, 0);
	    gl.glLightfv(16384, 4610, spec1, 0);
	    gl.glLightfv(16384, 4609, diff1, 0);
	    
	    gl.glLightfv(16385, 4611, pos2, 0);
	    gl.glLightfv(16385, 4610, spec1, 0);
	    gl.glLightfv(16385, 4609, diff1, 0);
	    
	    gl.glLightfv(16386, 4611, pos3, 0);
	    gl.glLightfv(16386, 4610, spec3, 0);
	    gl.glLightfv(16386, 4609, diff3, 0);
	    
	    gl.glEnable(16384);
	    gl.glEnable(16385);
	    gl.glEnable(16386);
	    gl.glEnable(2896);
	   
	    if (bLight){
	      float[] blackColor = { 0.0F, 0.0F, 0.0F };
	      float[] whiteColor = { 1.0F, 1.0F, 1.0F };
	      float[] red = { 1.0F, 0.0F, 0.0F };
	      
	      glu.gluQuadricDrawStyle(glu.gluNewQuadric(), 100012);
	      glu.gluQuadricNormals(glu.gluNewQuadric(), 100001);
	      glu.gluQuadricOrientation(glu.gluNewQuadric(), 100020);
	      
	      gl.glPushMatrix();
	      gl.glTranslated(pos1[0], pos1[1], pos1[2]);
	      
	      gl.glMaterialfv(1028, 4608, whiteColor, 0);
	      gl.glMaterialfv(1028, 4610, blackColor, 0);
	      gl.glMaterialfv(1028, 4609, blackColor, 0);
	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      
	      gl.glPushMatrix();
	      gl.glTranslated(pos2[0], pos2[1], pos2[2]);
	      
	      gl.glMaterialfv(1028, 4608, whiteColor, 0);
	      gl.glMaterialfv(1028, 4610, blackColor, 0);
	      gl.glMaterialfv(1028, 4609, blackColor, 0);
	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      gl.glPushMatrix();
	      gl.glTranslated(pos3[0], pos3[1], pos3[2]);
	      
	      gl.glMaterialfv(1028, 4608, red, 0);
	      gl.glMaterialfv(1028, 4610, blackColor, 0);
	      gl.glMaterialfv(1028, 4609, blackColor, 0);
	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      glu.gluDeleteQuadric(glu.gluNewQuadric());
	    }
	  }
	  
	  private void createPlanets(List<Planet> planets, boolean bWireFrame, boolean bAxis) {
	    double sun_loc = 0.1D;
	    double[] color = { 1.0D, 0.0D, 1.0D };
	    
	    planets.add(new Planet(0.0D, 0.0D, PlanetType.SUN, null, color, bWireFrame, 0.0D, sun_loc, bAxis));
	    planets.add(new Planet(sun_loc * 2.0D, 2.0D, PlanetType.MERCURY, null, color, bWireFrame, 7.0D, sun_loc * 0.1D, bAxis));
	    planets.add(new Planet(sun_loc * 3.0D, 2.0D, PlanetType.VENUS, null, color , bWireFrame, 3.39D, sun_loc * 0.3D, bAxis));
	    planets.add(new Planet(sun_loc * 4.0D, 23.45D, PlanetType.EARTH, null, color , bWireFrame, 0.0D, sun_loc * 0.2D, bAxis));
	    planets.add(new Planet(sun_loc * 5.0D, 24.0D, PlanetType.MARS, null, color , bWireFrame, 1.85D, sun_loc * 0.1D, bAxis));
	    planets.add(new Planet(sun_loc * 6.0D, 3.1D, PlanetType.JUPITER, null, color , bWireFrame, 1.3D, sun_loc * 0.7D, bAxis));
	    planets.add(new Planet(sun_loc * 8.0D, 26.7D, PlanetType.SATURN, null,color , bWireFrame, 2.49D, sun_loc * 0.6D, bAxis));
	    planets.add(new Planet(sun_loc * 9.0D, 97.9D, PlanetType.URANUS, null,color , bWireFrame, 0.77D, sun_loc * 0.4D, bAxis));
	    planets.add(new Planet(sun_loc * 10.0D, 28.8D, PlanetType.NEPTUNE, null, color, bWireFrame, 1.77D, sun_loc * 0.4D, bAxis));
	    planets.add(new Planet(sun_loc * 11.0D, 57.5D, PlanetType.PLUTO, null, color, bWireFrame, 17.2D, sun_loc * 0.1D, bAxis));
	  }
	  
	  public void init(GL gl) {}
	  
	  public void control(int type, Object params) {
	    if (type == 0) {
	      bLight = (!bLight);
	    }
	  }
	  
	  public boolean isAnimated() {
	    return false;
	  }
	  
	  public void setCamera(GL gl) {}
	  
	  public String toString() {
	    return "Solar System";
	  }
}
