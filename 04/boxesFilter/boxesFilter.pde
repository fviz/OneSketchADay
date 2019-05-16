/**
 * Blur Filter
 * 
 * Change the default shader to apply a simple, custom blur filter.
 * 
 * Press the mouse to switch between the custom and default shader.
 */

PShader blur;

int HALF_WIDTH;
int HALF_HEIGHT;
int cameraAngle;

void setup() {
  size(1280, 720, P3D);
  pixelDensity(2);
  blur = loadShader("blur.glsl"); 
  stroke(255, 0, 0);
  noFill();
  HALF_WIDTH   =    width / 2;
  HALF_HEIGHT  =   height / 2;
  rectMode(CENTER);
  cameraAngle = 1;

  background(0);
}

void draw() {

  filter(blur);  
  float sx = sin(frameCount / 100.0) * 500;
  float sy = sin(frameCount / 100.0) * 300;

  if (frameCount % 500 == 0) {
    cameraAngle = -cameraAngle;
  }

  switch (cameraAngle) {
  case -1:
    camera(sx, sy, 120.0, 50.0, 50.0, 0.0, 
      0.0, 1.0, 1.0);
    break;
  case 1:
    camera(sx/8, sy/8+200, -120.0, 50.0, 50.0, 0.0, 
      0.0, 1.0, 1.0);
    break;
  }


  translate(50, 50, 0);
  stroke(noise(frameCount / 100.0)*120);
  box(45);
  sphere(300);
}
