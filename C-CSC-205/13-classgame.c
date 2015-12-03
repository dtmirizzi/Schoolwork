#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

float gravity = -9.8; // meters/second^2
float wind = 0.0;

float degreesToradians(float degrees);
void EulerForm (float dt, float *vx, float *vy, float *x, float *y);
void ClosedForm (float time, float velocity, float theta, float height, float *x, float *y);

int main (int argc, char **argv)
{
  if (argc != 1) {
    printf("usage: %s \n", argv[0]);
    return 0;
  }
  time_t sec;
  sec=time(NULL);
  float x = 0, y = 0; // -- current location of projectile, Closed form
  float ye = 0; // -- current location of projectile
  float dt = 0.1;
  float t = dt;
  float mom, angle;
  int check=0;
  srand(sec);
  int ranx=(200.0/RAND_MAX)*((int)rand());
  int rany=(200.0/RAND_MAX)*(int)rand();
  printf("The Cannon Game!\nyou are calculating the velocity to make the man shoot out of the cannon and hit the net!\n");
  do {
    t=0.1;
    x=0,y=0;
  printf("The net is at %d, %d\n",ranx, rany);
    printf("Momentum:");
    scanf("%f",&mom);
    printf("Angle(hint:less then 90):");
    scanf("%f",&angle);
    do{
    ClosedForm(t, mom, angle, ye,&x,&y);

    // printf("%f, %f, %f\n", t, x, y);//debug print
    t = t + dt;
    if((x>=ranx-5)&&(x<=ranx+5)){
      if((y>=rany-5)&&(y<=rany+5)){
      printf("You hit the Target!!\n");
      check=1;
      return 0;
      }
      if (y<rany){
	printf("You missed %.2f below your target\n",rany-y);
      }
      if (y>rany){
	printf("You missed %.2f above your target\n",y-rany);
      }
    }
    }while (y>0);
    if(x<ranx){
      printf("you came up %.2f short\n",ranx-x);
    }
    printf("Restarting in 5 seconds, OR Ctr+c to exit\n");
    sleep(5);
    system("clear");
  } while (check==0);
  
  return 0;
}
float degreesToradians(float degrees)
{
  return ((degrees / 180.0) * 3.14159);
}


void EulerForm (float dt, float *vx, float *vy, float *x, float *y)
{
  *x = *x + (*vx * dt);
  *y = *y + (*vy * dt) + (0.5 * gravity * dt * dt);
  *vx = *vx + (wind * dt);
  *vy = *vy + (gravity * dt);
}



void ClosedForm (float time, float velocity, float theta, float height,
		 float *x, float *y)
{
  float radians = degreesToradians(theta);

  *x = velocity * time * cos(radians);
  *y = height +
    (velocity * time * sin(radians)) +
    (0.5 * gravity * time * time);
}
