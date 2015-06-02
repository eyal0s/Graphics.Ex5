package ex5.models;

import java.awt.Color;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import ex5.models.Planet;
import ex5.models.PlanetType;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class solarSystem  implements IRenderable {
	
	private boolean isLight = false;
	
	private float[][] lightPosition = {{ 0.0F, 1.0F, 0.5F, 1.0F},
						{ 0.0F, 1.0F, -1.0F, 1.0F},
						{ 0.0F, -1.0F, 0.5F, 1.0F}};
	
	private float[][] lightSpecs = {{ 0.8F, 0.8F, 0.8F, 1.0F },
									{ 1.0F, 0.0F, 0.0F, 1.0F }};
	
	private float[][] lightDiff = {{ 0.5F, 0.5F, 0.5F, 1.0F },
									{ 1.0F, 0.0F, 0.0F, 1.0F }};
	
	private float[] blackAsFloatArray = { 0, 0, 0};
    private float[] whitAsFloatArray = { 1, 1, 1 };
    private float[] blueAsFloatArray = {0 ,0 ,1};
    private float[] redAsFloatArray = { 1, 0, 0 };
	
	 
	  public void render(GL gl, boolean wFrame, boolean isAxis) {
		  
	    List<Planet> planets = new ArrayList<Planet>();
	    GLU glu = new GLU();
	   
	    if (wFrame) {
	      gl.glPolygonMode(1032, 6913);
	    } else {
	      gl.glPolygonMode(1032, 6914);
	    }
	    
	    setLight(gl, glu);
	    createPlanets(planets, wFrame, isAxis);

	    //Render the planets
	    for (Planet p : planets) {
		      p.redering(gl, glu);
	    }
	  }
	  
	  private void setLight(GL gl, GLU glu) {
		  
	    float[] amb = { 0.8F, 0.5F, 0.4F, 1.0F };
	    
	    gl.glLightModelfv(2899, amb, 0);

	    gl.glLightfv(16384, 4611, lightPosition[0], 0);
	    gl.glLightfv(16384, 4610, lightSpecs[0], 0);
	    gl.glLightfv(16384, 4609, lightDiff[0], 0);
	    
	    gl.glLightfv(16385, 4611, lightPosition[1], 0);
	    gl.glLightfv(16385, 4610, lightSpecs[0], 0);
	    gl.glLightfv(16385, 4609, lightDiff[0], 0);
	    
	    gl.glLightfv(16386, 4611, lightPosition[2], 0);
	    gl.glLightfv(16386, 4610, lightSpecs[1], 0);
	    gl.glLightfv(16386, 4609, lightDiff[1], 0);
	    
	    gl.glEnable(16384);
	    gl.glEnable(16385);
	    gl.glEnable(16386);
	    gl.glEnable(2896);
	   
	    if (isLight){
	    	
	     
	      
	      glu.gluQuadricDrawStyle(glu.gluNewQuadric(), 100012);
	      glu.gluQuadricNormals(glu.gluNewQuadric(), 100001);
	      glu.gluQuadricOrientation(glu.gluNewQuadric(), 100020);
	      
	      gl.glPushMatrix();
	      gl.glTranslated(lightPosition[0][0], lightPosition[0][1], lightPosition[0][2]);
	      
	      gl.glMaterialfv(1028, 4608, whitAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4610, blackAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4609, blackAsFloatArray, 0);

	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      
	      gl.glPushMatrix();
	      gl.glTranslated(lightPosition[1][0], lightPosition[1][1], lightPosition[1][2]);
	      
	      gl.glMaterialfv(1028, 4608, whitAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4610, blackAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4609, blackAsFloatArray, 0);
	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      gl.glPushMatrix();
	      gl.glTranslated(lightPosition[2][0], lightPosition[2][1], lightPosition[2][2]);
	      
	      gl.glMaterialfv(1028, 4608, redAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4610, blackAsFloatArray, 0);
	      gl.glMaterialfv(1028, 4609, blackAsFloatArray, 0);
	      gl.glMaterialf(1028, 5633, 0.0F);
	      glu.gluSphere(glu.gluNewQuadric(), 0.05D, 16, 16);
	      
	      gl.glPopMatrix();
	      glu.gluDeleteQuadric(glu.gluNewQuadric());
	    }
	  }
	  
	  private double[] colorToDoubleArray(Colors colorToReturn)
	  {
		  double[] colorAsDoubleArray = new double[3];
		 switch (colorToReturn) {
		case Red:
			colorAsDoubleArray = new double[]{1 ,0 ,0};
			break;
		case Green:
			colorAsDoubleArray = new double[]{0 ,1 ,0};
			break;
		case Blue:
			colorAsDoubleArray = new double[]{0 ,0 ,1};
			break;
		case Cyan:
			colorAsDoubleArray = new double[]{0 ,1 ,1};
			break;
		case Orange:
			colorAsDoubleArray = new double[]{1 ,0.5D ,0};
			break;
		case Purple:
			colorAsDoubleArray = new double[]{1 ,0 ,1};
			break;
		case White:
			colorAsDoubleArray = new double[]{1 ,1 ,1};
		case Yellow:
			colorAsDoubleArray = new double[]{1 ,1 ,0};
		case GreenYellow:
			colorAsDoubleArray = new double[]{0.5D ,1 ,0};
			break;
		case Black:
			colorAsDoubleArray = new double[]{0 ,0 ,0};
			break;
		default: // white
			colorAsDoubleArray = new double[]{1 ,1 ,1};
			break;
		}
		 
		 return colorAsDoubleArray;
	  }
	  
	  
	  private void createPlanets(List<Planet> solarsPlanet, boolean wFrame, boolean isAxis) {
	      
		double sunOffsetLocation = 0.2D;
	    solarsPlanet.add(new Planet(0.0D, 0.0D, PlanetType.SUN, null, colorToDoubleArray(Colors.Yellow), wFrame, 0.0D, sunOffsetLocation + 0.1D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 4.0D, 2.0D, PlanetType.MERCURY, null, colorToDoubleArray(Colors.Cyan), wFrame, 7.0D, sunOffsetLocation * 0.1D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 6.0D, 2.0D, PlanetType.VENUS, null, colorToDoubleArray(Colors.Blue) , wFrame, 3.39D, sunOffsetLocation * 0.3D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 8.0D, 23.45D, PlanetType.EARTH, null, colorToDoubleArray(Colors.GreenYellow) , wFrame, 0.0D, sunOffsetLocation * 0.4D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 10.0D, 24.0D, PlanetType.MARS, null, colorToDoubleArray(Colors.Red) , wFrame, 1.85D, sunOffsetLocation * 0.1D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 12.0D, 3.1D, PlanetType.JUPITER, null, colorToDoubleArray(Colors.Purple) , wFrame, 1.3D, sunOffsetLocation * 1.4D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 16.0D, 26.7D, PlanetType.SATURN, null,colorToDoubleArray(Colors.Green) , wFrame, 2.49D, sunOffsetLocation * 1.2D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 18.0D, 97.9D, PlanetType.URANUS, null,colorToDoubleArray(Colors.White) , wFrame, 0.77D, sunOffsetLocation * 0.8D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 20.0D, 28.8D, PlanetType.NEPTUNE, null, colorToDoubleArray(Colors.Orange), wFrame, 1.77D, sunOffsetLocation * 0.8D, isAxis));
	    solarsPlanet.add(new Planet(sunOffsetLocation * 22.0D, 57.5D, PlanetType.PLUTO, null, colorToDoubleArray(Colors.Blue), wFrame, 17.2D, sunOffsetLocation * 0.2D, isAxis));
	  }
	  
	  public void init(GL gl) {}
	  
	  public void control(int type, Object params) {
	    if (type == 0) {
	      isLight = (!isLight);
	    }
	  }
	  
	  public boolean isAnimated() {
	    return false;
	  }
	  
	  public void setCamera(GL gl) {}
	  
	  public String toString() {
	    return "Solar System";
	  }
	  

	  public enum Colors{
		  
		  Red,
		  Green,
		  Blue,
		  Yellow,
		  Purple,
		  Cyan,
		  White,
		  Orange, 
		  GreenYellow,
		  Black
	}
	  
}
