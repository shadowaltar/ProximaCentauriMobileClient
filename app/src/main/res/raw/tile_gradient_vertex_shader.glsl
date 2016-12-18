uniform mat4 uMVPMatrix;

attribute vec4 position;
attribute vec4 color;

varying vec4 varyColor;

void main()
{
    varyColor = color;
    gl_Position = uMVPMatrix * position;
}