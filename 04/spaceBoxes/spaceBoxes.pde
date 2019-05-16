int HALF_WIDTH;
int HALF_HEIGHT;

void setup() {
  size(500, 300, P3D);
  pixelDensity(2);
  frameRate(60);
  noFill();
  
  HALF_WIDTH   =    width / 2;
  HALF_HEIGHT  =   height / 2;
}

void draw() {
  background(23);
  float sx = sin(frameCount / 100.0) * 500;
  float sy = sin(frameCount / 100.0) * 300;
  camera(sx, sy, 120.0, 50.0, 50.0, 0.0, 
    0.0, 1.0, 1.0);  
  translate(50, 50, 0);
  stroke(noise(frameCount / 100.0)*200);
  box(45);
}
