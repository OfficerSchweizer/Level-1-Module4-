int birdX = 300;
int birdY = 450;
int pipeX = 800;
int pipeY = 600;
int yVelocity = 1;
int gravity = 1;
void setup() {
  size(900, 900);
}

void draw() {

  background(54, 160, 245);
  fill(249, 252, 59);
  stroke(249, 252, 59);
  ellipse(birdX, birdY, 100, 80);
  
  stroke(#000000);
  fill(#18AA2F);
  rect(pipeX,pipeY,100,400);
  
  gravity+= .1;
  yVelocity+= gravity;
  birdY += yVelocity;
  
  pipeX-= 10;
}

void mousePressed() {
  yVelocity =1;
  yVelocity -=20;
  gravity =1;
}

void teleportPipes() {
  if (pipeX < 10) {
    pipeX =800;
  }
}
