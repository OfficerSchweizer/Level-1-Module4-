int birdX = 300;
int birdY = 450;
int pipeX = 900;
int pipeY = 600;
int topPipeHeight = (int) random(-200, 0);
int pipeGap = (int) random(0, 100);
int pipeLength = 100;
int yVelocity = 1;
int gravity = 1;
int score = 0;
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
  rect(pipeX, topPipeHeight-pipeGap+800, pipeLength, 800);
  rect(pipeX, topPipeHeight, pipeLength, 500);

  stroke(#000000);
  fill(#955705);
  rect(0, 850, 900, 300);

  gravity+= .1;
  yVelocity+= gravity;
  birdY += yVelocity;
  pipeX-= 10;

  if (birdY >= 900) {
    endGame();
  }

  if ( pipeX <= -150) {
    teleportPipes();
  }

  intersectsPipe();

  text(score, 100, 100);
  
  score();
}

void teleportPipes() {
  pipeX =900;
  pipeGap = (int) random(-100, 100);
  topPipeHeight = (int) random(-500, 0);
}

void mousePressed() {
  yVelocity =1;
  yVelocity -=20;
  gravity =1;
}

void intersectsPipe() {
  if (birdX >= pipeX-35 && birdX <= pipeX + pipeLength && birdY >= topPipeHeight && birdY <= topPipeHeight+530) {
    gravity =10;
    endGame();
  } else if (birdX>= pipeX-35 && birdX <=pipeX + pipeLength && birdY>= topPipeHeight-pipeGap+730) {
    gravity =10;
    endGame();
  }
}

void score() {
  if (birdX == pipeX ) {
    score +=1;
  }
}

void endGame() {

  text("Game Over", 450, 450);
}