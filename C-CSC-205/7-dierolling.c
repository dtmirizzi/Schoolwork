#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char **argv)
{
  srand(atoi(argv[1]));
  int Do = (rand() % 6) +1; 
  int rools =1;
  while ( Do !=6){
    Do =(rand()%6)+1;
    rools= rools+1;
  }
  printf("took %d to hit 6\n", rools);
  return 0;
}
