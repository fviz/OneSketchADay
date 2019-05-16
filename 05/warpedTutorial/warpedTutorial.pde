import processing.video.*;

Capture cam;
PShader myShader;

void setup() {
    size(800, 600, P2D);

    String[] cameras = Capture.list();

    cam = new Capture(this, cameras[0]);
    cam.start();

    myShader = loadShader("frag.glsl", "vert.glsl");

}

void draw() {
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
