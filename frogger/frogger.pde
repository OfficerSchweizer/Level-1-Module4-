Car car1 = new Car(0, 50);
Car car2 = new Car(390, 150);
Car car3 = new Car(0, 250);


class Car {
  int carSize = (int) random(50, 100);
  int carSpeed = (int) random(2, 5);
  int carX;
  int carY;


  Car(int carX, int carY) {
    this.carX = carX;
    this.carY = carY;
  }

  int getX() {
    return carX;
  }

  int getY() {
    return carY;
  }

  void moveRight() {
    carX +=carSpeed;
    if (carX >= 425) {
      carX=-20;
      carSize = (int) random(50, 100);
      carSpeed = (int) random(2, 5);
      display();
    }
  }
  void moveLeft() {
    carX -=carSpeed;
    if (carX <= 0-carSize) {
      carX=390;
      carSize = (int) random(50, 100);
      carSpeed = (int) random(2, 5);
      display();
    }
  }

  void display() {
    fill(#3881DE);
    rect(carX, carY, carSize, 50);
    car1.intersects(car1);
    car2.intersects(car2);
    car3.intersects(car3);
    text(car1.getX(), 10, 50);
    text(car1.getY(), 50, 50);
  }

  void intersects (Car car) {
    if (frogY >= car.getY() && frogY <= car.getY() + 50 && frogX >= car.getX() && frogX <= car.getX() + carSize ) {
      frogX = 200;
      frogY = 350;
    }
  }
}

int frogX=200;
int frogY=350;

void setup() {
  size(400, 400);
}

void draw() {
  background(#3AC1E5);
  fill(#1AC944);
  ellipse(frogX, frogY, 50, 50);
  car1.display();
  car1.moveLeft();
  car2.display();
  car2.moveRight();
  car3.display();
  car3.moveLeft();
  fill(#000000);
  text(frogX, 10, 10);
  text(frogY, 40, 10);
  
  if(frogY == 25) {
    text("You win!", 200,200);
  }
}




void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP && frogY-25 >= 1) {
      frogY-=25;
    } else if (keyCode == DOWN && frogY+25 <=399) {
      frogY+=25;
    } else if (keyCode == RIGHT && frogX+25 <=399) {
      frogX+=25;
    } else if (keyCode == LEFT && frogX-25 >=1) {
      frogX-=25;
    }
  }
}