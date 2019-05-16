import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class warpedTutorial extends PApplet {



Capture cam;
PShader myShader;

public void setup() {
    

    String[] cameras = Capture.list();

    cam = new Capture(this, cameras[0]);
    cam.start();

    myShader = loadShader("frag.glsl", "vert.glsl");

}

public void draw() {
    if (cam.available()) {
        cam.read();
    }

    shader(myShader);
    beginShape(QUADS);
    texture(cam);
    textureMode(NORMAL);
    vertex(50, 50, 0, 0);
    vertex(width-100, 100, 1, 0);
    vertex(width-50, height-150, 1, 1);
    vertex(100, height-50, 0, 1);

    endShape();
}
  public void settings() {  size(800, 600, P2D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "warpedTutorial" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
