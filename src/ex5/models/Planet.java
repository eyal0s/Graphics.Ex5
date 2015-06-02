package ex5.models;
 
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
 
import com.sun.opengl.util.texture.Texture;
 
public class Planet {
 
        public double rOrbit;
        public double rPlanet;
        public double axTilt;
        public double incline;
        public double length;
        public double[] color;
        public boolean bWireFrame;
        public boolean drawAxis;
        public PlanetType planetType;
        public Texture texture;
 
        public Planet(double rOrbit, double axTilt, PlanetType type, Texture texture, double[] color, boolean bWireFrame, double incline, double rPlanet, boolean drawAxis)  {
                this.rOrbit = rOrbit;
                this.planetType = type;
                this.axTilt = axTilt;
                this.texture = texture;
                this.color = ((double[])color.clone());
                this.bWireFrame = bWireFrame;
                this.incline = incline;
                this.rPlanet = rPlanet;
                this.drawAxis = drawAxis;
                this.length = (rPlanet * 1.5D);
        }
 
        public void rendering(GL gl, GLU glu){
                if (this.planetType != PlanetType.SUN){
                        renderOrbit(gl, glu);
                }
                renderPlanet(gl, glu);
        }
 
        private void renderPlanet(GL gl, GLU glu) {
                GLUquadric planet = glu.gluNewQuadric();
                gl.glPushMatrix();
 
                gl.glRotated(incline, 0.0D, 0.0D, 1.0D);
                orbitRotation(gl);
                gl.glTranslated(rOrbit, 0.0D, 0.0D);
                if (this.planetType == PlanetType.EARTH)
                {
                        renderMoon(gl, glu, planet);
                }
 
                gl.glRotated(this.axTilt, 0.0D, 0.0D, 1.0D);
                if (drawAxis) {
                        Axis.rendering(gl, this.length);
                }
                if (planetType == PlanetType.SATURN) {
                        renderRing(gl, glu, planet);
                }
                planetMaterial(gl);
                gl.glColor3d(color[0], color[1], color[2]);
                glu.gluQuadricDrawStyle(planet, 100012);
                glu.gluQuadricNormals(planet, 100001);
                glu.gluQuadricOrientation(planet, 100020);
                glu.gluSphere(planet, rPlanet, 16, 16);
                glu.gluDeleteQuadric(planet);
                gl.glPopMatrix();
        }
 
 
        private void orbitRotation(GL gl){
                switch (planetType){
		            case SUN:
		                    gl.glRotated(80.0D, 0.0D, 1.0D, 0.0D); // 230
		                    break;
		            case MERCURY:
		                    gl.glRotated(150.0D, 0.0D, 1.0D, 0.0D); // -40
		                    break;
		            case VENUS:
		                    gl.glRotated(200.0D, 0.0D, 1.0D, 0.0D); //-40
		                    break;
		            case EARTH:
		                    break;
		            case MARS:
		                    gl.glRotated(100.0D, 0.0D, 1.0D, 0.0D);//30
		                    break;
		            case JUPITER:
		                    gl.glRotated(-50.0D, 0.0D, 1.0D, 0.0D); // 20
		                    break;
		            case SATURN:
		                    gl.glRotated(300.0D, 0.0D, 1.0D, 0.0D); //                         
		                    break;
		            case URANUS:
		                    gl.glRotated(240.0D, 0.0D, 1.0D, 0.0D); // 300
		                    break;
		            case NEPTUNE:
		                    gl.glRotated(200.0D, 0.0D, 1.0D, 0.0D); // -100
		                    break;
		            case PLUTO:
		                    gl.glRotated(-50.0D, 0.0D, 1.0D, 0.0D); // -150
		                    break;
 
                }
        }
 
        private void planetMaterial(GL gl) {
                switch (planetType) {
                case SUN:
                        float[] ambientSun = { 0.0F, 1.0F, 1.0F, 1.0F };
                        float[] diffusiveSun = { 1.0F, 1.0F, 1.0F, 1.0F };
                        float[] specularSun = { 0.0F, 0.0F, 0.5F, 1.0F };
                        float shinenessSun = 10.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientSun, 0);
                        gl.glMaterialfv(1028, 4610, specularSun, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveSun, 0);
                        gl.glMaterialf(1028, 5633, shinenessSun);
                        break;
               
                case MERCURY:
                        float[] ambientMercury = { 0.35F, 0.15F, 0.45F, 1.0F };
                        float[] diffusiveMercury = { 0.42F, 0.55F, 0.7F, 1.0F };
                        float[] speculerMercury = { 0.34F, 0.45F, 0.59F, 1.0F };
                        float shinenessMercury = 80.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientMercury, 0);
                        gl.glMaterialfv(1028, 4610, speculerMercury, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveMercury, 0);
                        gl.glMaterialf(1028, 5633, shinenessMercury);
                        break;
 
                case VENUS:
                        float[] ambientVenus = { 0.25F, 0.20725F, 0.20725F, 0.922F };
                        float[] diffusiveVenus = { 1.0F, 0.829F, 0.829F, 0.922F };
                        float[] specularVenus = { 0.296648F, 0.296648F, 0.296648F, 0.922F };
                        float shinenessVenus = 11.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientVenus, 0);
                        gl.glMaterialfv(1028, 4610, specularVenus, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveVenus, 0);
                        gl.glMaterialf(1028, 5633, shinenessVenus);
                        break;
 
                case EARTH:
                        float[] ambientEarth = { 0.49F, 0.33F, 0.3F, 1.0F };
                        float[] diffusiveEarth = { 1.5F, 1.5F, 1.5F, 1.5F };
                        float[] specularEarth = { 0.95F, 0.53F, 0.24F, 1.0F };
                        float shinenessEarth = 57.0F;
 
                        gl.glMaterialfv(1028, 4608, ambientEarth, 0);
                        gl.glMaterialfv(1028, 4610, specularEarth, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveEarth, 0);
                        gl.glMaterialf(1028, 5633, shinenessEarth);
                        break;
 
                case MARS:
                        float[] ambientMars = { 0.24725F, 0.1995F, 0.0745F, 1.0F };
                        float[] diffusiveMars = { 0.75164F, 0.60648F, 0.22648F, 1.0F };
                        float[] specularMars = { 0.628281F, 0.555802F, 0.366065F, 1.0F };
                        float shinenessMars = 51.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientMars, 0);
                        gl.glMaterialfv(1028, 4610, specularMars, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveMars, 0);
                        gl.glMaterialf(1028, 5633, shinenessMars);
                        break;
 
                case JUPITER:
                        float[] ambientJupiter = { 0.25F, 0.25F, 0.25F, 1.0F };
                        float[] diffusiveJupiter = { 0.4F, 0.4F, 0.4F, 1.0F };
                        float[] specularJupiter = { 0.774597F, 0.774597F, 0.774597F, 1.0F };
                        float shinenessJupiter = 76.8F;
                       
                        gl.glMaterialfv(1028, 4608, ambientJupiter, 0);
                        gl.glMaterialfv(1028, 4610, specularJupiter, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveJupiter, 0);
                        gl.glMaterialf(1028, 5633, shinenessJupiter);
                        break;
 
                case SATURN:
                        float[] ambientSaturn = { 0.63F, 0.6F, 0.17F, 1.0F };
                        float[] diffusiveSaturn = { 0.69F, 0.64F, 0.29F, 1.0F };
                        float[] specularSaturn = { 0.05F, 0.05F, 0.22F, 1.0F };
                        float shinenessSaturn = 128.0F;
                       
                        gl.glMaterialfv(1028, 4608, ambientSaturn, 0);
                        gl.glMaterialfv(1028, 4610, specularSaturn, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveSaturn, 0);
                        gl.glMaterialf(1028, 5633, shinenessSaturn);
                        break;
 
                case URANUS:
                        float[] ambientUranus = { 0.25F, 0.25F, 0.25F, 1.0F };
                        float[] diffusiveUranus = { 0.4F, 0.4F, 0.4F, 1.0F };
                        float[] specularUranus = { 0.774597F, 0.774597F, 0.774597F, 1.0F };
                        float shinenessUranus = 76.8F;
                       
                        gl.glMaterialfv(1028, 4608, ambientUranus, 0);
                        gl.glMaterialfv(1028, 4610, specularUranus, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveUranus, 0);
                        gl.glMaterialf(1028, 5633, shinenessUranus);
                        break;
                       
                case NEPTUNE:
                        float[] ambientNeptune = { 0.2295F, 0.08825F, 0.0275F, 1.0F };
                        float[] diffusiveNeptune = { 0.5508F, 0.2118F, 0.066F, 1.0F };
                        float[] specularNeptune = { 0.580594F, 0.223257F, 0.0695701F, 1.0F };
                        float shinenessNeptune = 51.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientNeptune, 0);
                        gl.glMaterialfv(1028, 4610, specularNeptune, 0);
                        gl.glMaterialfv(1028, 4609, diffusiveNeptune, 0);
                        gl.glMaterialf(1028, 5633, shinenessNeptune);
                        break;
                       
                case PLUTO:
                        float[] ambientPluto = { 0.43F, 0.13F, 0.33F, 1.0F };
                        float[] diffusivePluto = { 0.25F, 0.07F, 0.29F, 1.0F };
                        float[] specularPluto = { 0.7F, 0.04F, 0.04F, 1.0F };
                        float shinenessPluto = 10.2F;
                       
                        gl.glMaterialfv(1028, 4608, ambientPluto, 0);
                        gl.glMaterialfv(1028, 4610, specularPluto, 0);
                        gl.glMaterialfv(1028, 4609, diffusivePluto, 0);
                        gl.glMaterialf(1028, 5633, shinenessPluto);
                        break;
                }
        }
 
        private void renderRing(GL gl, GLU glu, GLUquadric planet) {
                gl.glPushMatrix();
 
                float[] ambient = { 1.0F, 1.0F, 0.0F, 1.0F };
                float[] specular = { 0.56F, 0.52F, 0.0F, 1.0F };
                float[] diffusive = { 0.56F, 0.52F, 0.0F, 1.0F };
 
                gl.glMaterialfv(1028, 4608, ambient, 0);
                gl.glMaterialfv(1028, 4610, specular, 0);
                gl.glMaterialfv(1028, 4609, diffusive, 0);
                gl.glMaterialf(1028, 5633, 93.0F);
                glu.gluQuadricDrawStyle(planet, 100012);
                glu.gluQuadricNormals(planet, 100001);
                glu.gluQuadricOrientation(planet, 100020);
 
                gl.glRotated(90.0D, 1.0D, 0.0D, 0.0D);
                glu.gluDisk(planet, rPlanet * 1.2D, rPlanet * 1.5D, 16, 16);
                gl.glRotated(180.0D, 1.0D, 0.0D, 0.0D);
                glu.gluDisk(planet, rPlanet * 1.2D,  rPlanet * 1.5D, 16, 16);
                gl.glPopMatrix();
        }
 
        private void renderMoon(GL gl, GLU glu, GLUquadric planet){
               
                gl.glPushMatrix();
                float[] ambient = { 0.25F, 0.20725F, 0.20725F, 0.922F };
                float[] diffusive = { 1.0F, 0.829F, 0.829F, 0.922F };
                float[] specular = { 0.296648F, 0.296648F, 0.296648F, 0.922F };
               
                gl.glMaterialfv(1028, 4608, ambient, 0);
                gl.glMaterialfv(1028, 4610, specular, 0);
                gl.glMaterialfv(1028, 4609, diffusive, 0);
                gl.glMaterialf(1028, 5633, 11.2F);
 
                gl.glTranslated(rPlanet * 1.4D, 0.0D, 0.0D);
                if (drawAxis) {
                        Axis.rendering(gl, length);
                }
                glu.gluQuadricDrawStyle(planet, 100012);
                glu.gluQuadricNormals(planet, 100001);
                glu.gluQuadricOrientation(planet, 100020);
                glu.gluSphere(planet, rPlanet * 0.3D, 16, 16);
 
                gl.glPopMatrix();
        }
 
 
        private void renderOrbit(GL gl, GLU glu){
                gl.glPushMatrix();
                gl.glRotated(incline, 0.0D, 0.0D, 1.0D);
                gl.glBegin(2);

                gl.glMaterialfv(1028, 4608, new float[] {0.5F, 0.5F, 1.0F}, 0);
                gl.glMaterialfv(1028, 4609, new float[] {0.5F, 0.5F, 1.0F}, 0);
                gl.glMaterialfv(1028, 4610, new float[] {0.5F, 0.5F, 1.0F}, 0);
                gl.glMaterialf(1028, 5633, 0.0F);
               
                for (int i = 0; i < 361; i++) {
                        gl.glVertex3d(rOrbit * Math.sin(i * 3.141592653589793D / 180.0D), 0.0D, rOrbit * Math.cos(i * 3.141592653589793D / 180.0D));
                }
                gl.glEnd();
                gl.glPopMatrix();
        }
       
        public enum PlanetType {
                SUN, MERCURY, VENUS, URANUS, NEPTUNE, PLUTO, EARTH, MARS, JUPITER, SATURN;       
        }
 
}