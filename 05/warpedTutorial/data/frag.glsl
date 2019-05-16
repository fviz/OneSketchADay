uniform sampler2D texture;

in vec2 vertTexCoord;

void main() {
    gl_FragColor = vec4(texture2D(texture, vertTexCoord), 0,0,1);
}
