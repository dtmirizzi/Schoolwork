#include <stdio.h>
#include <stdlib.h>
#include <math.h>
//* BMI Calculator *//
int main(int argc, char **argv)
{ /* float added for metric coverstion*/
  float Mass;
  float Hight; 
  /* English BMI Calculation */
  printf("English BMI: %.2f lbs/in2\n", (atof(argv[1])/(atof(argv[2])*atof(argv[2])))*703);
  /* Defined floating var Metric units*/ 
  Mass = atof(argv[1]) * 0.453592;
  Hight = atof(argv[2]) * 0.0254; 
  /* Metric BMI Calculation */
  printf("Metric BMI: %.2f kg/m2\n",(Mass/(Hight*Hight)));
  return 0; 
}
