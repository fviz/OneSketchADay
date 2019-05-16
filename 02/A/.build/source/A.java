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

public class A extends PApplet {

ArrayList<Particle> particles;

public void setup() {
    
    particles = new ArrayList<Particle>();
}

public void draw() {
    background(255);

    particles.add(new Particle(new PVector(width/2,50)));

    Iterator<Particle> it = particles.iterator();
    while (it.hasNext()) {
        Particle p = it.next();
        p.run();
        if (p.isDead()) {
                it.remove();
        }
    }
}
class Particle {
    PVector location;
    PVector velocity;
    PVector acceleration;
    float lifespan;

    Particle(PVector initialLocation) {
        this.location = initialLocation;
        this.acceleration = new PVector();
        this.velocity = new PVector();
        this.lifespan = 255;
    }

    public void run() {
        this.update();
        this.display();
    }

    public void update() {
        this.velocity.add(this.acceleration);
        this.location.add(this.velocity);
        this.lifespan -= 2;
    }

    public void display() {
        stroke(0, lifespan);
        fill(0, lifespan);
        ellipse(this.location.x, this.location.y, 2, 2);
    }

    public boolean isDead() {
        if (lifespan < 0.0f) {
            return true;
        } else {
            return false;
        }
    }


}
  public void settings() {  size(640,360); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "A" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
