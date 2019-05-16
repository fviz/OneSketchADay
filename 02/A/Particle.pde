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

    void run() {
        this.update();
        this.display();
    }

    void update() {
        this.velocity.add(this.acceleration);
        this.location.add(this.velocity);
        this.lifespan -= 2;
    }

    void display() {
        stroke(0, lifespan);
        fill(0, lifespan);
        ellipse(this.location.x, this.location.y, 2, 2);
    }

    boolean isDead() {
        if (lifespan < 0.0) {
            return true;
        } else {
            return false;
        }
    }


}
