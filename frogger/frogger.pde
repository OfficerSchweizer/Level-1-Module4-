class Car {
  int carX=200;
  int carY=200;
  int carSize = (int) random(50, 100);

  void draw() {
    display();
  }
  
  void display() {
    fill(0, 255, 0);
    rect(carX, carY, carSize, 50);
  }
}


int frogX=200;
int frogY=300;

void setup() {

  size(400, 400);
}

void draw() {
  background(#3AC1E5);
  fill(#1AC944);
  ellipse(frogX, frogY, 50, 50);
}

void keyPressed()
{
  if (key == CODED) {
    if (keyCode == UP)
    {
      frogY-=50;
    } else if (keyCode == DOWN)
    {
      frogY+=50;
    } else if (keyCode == RIGHT)
    {
      frogX+=50;
    } else if (keyCode == LEFT)
    {
      frogX-=50;
    }
  }
}