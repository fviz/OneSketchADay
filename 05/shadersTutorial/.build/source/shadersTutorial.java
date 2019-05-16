import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class shadersTutorial extends PApplet {

PShader myShader;

public void setup() {
    
    frameRate(140);
    myShader = loadShader("frag.glsl", "vert.glsl");
}

public void draw() {
    surface.setTitle((float)round(frameRate) * 10 / 10 + "fps");
    shader(myShader);
    noStroke();
    beginShape();
    vertex(0,0);
    vertex(width, 0);
    vertex(width, height);
    vertex(0, height);
    endShape();
}
  public void settings() {  size(800, 800, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "shadersTutorial" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
