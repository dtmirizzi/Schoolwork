
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(int argc, char **argv)
{
 printf("%f cels is in %f farh\n", atof(argv[1]), 9.0/5.0* atof(argv[1])+ 32.0);
  return 0; 
}
