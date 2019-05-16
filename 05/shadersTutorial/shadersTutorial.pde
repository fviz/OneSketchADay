PShader myShader;

void setup() {
    size(800, 800, P2D);
    frameRate(140);
    myShader = loadShader("frag.glsl", "vert.glsl");
}

void draw() {
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
