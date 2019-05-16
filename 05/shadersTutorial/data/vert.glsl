uniform mat4 transform;
in vec4 position;

out vec2 colorPosition;

void main() {
    vec4 transformed = transform * position;
    colorPosition = vec2(transformed.x, transformed.y) / 2 + 0.5;
    gl_Position = transformed;
}
