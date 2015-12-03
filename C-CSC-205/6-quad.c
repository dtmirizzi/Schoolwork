#include <stdio.h>
#include <stdlib.h>
#include <math.h>
///* quadratic formula calculator */// 
int main(int argc, char **argv)
{
  /*usage error statement*/
  if (argc<=3){
    printf( "usage: %s <a> <b> <c>\n", argv[0]);
    return 0;
  }
  /* defining varibles */
  float a=atof(argv[1]) ;
  float b=atof(argv[2]) ;
  float c=atof(argv[3]) ;
  float outpos;  
  float outneg;
  float real;
  float imag;
 /* linear solutions when a = 0*/
 if(fabs(a)<.0001){
   /*-- when b and a = 0 --*/  
 if (fabs(b)<.0001){
     printf("eq. is linear w/o a solution\n");
     return 0;
   }
   printf("%.02f\n", (-c/b));
   return 0;
 } 
 /* det pos = 2 real roots*/  
if(((b*b)-(4*a*c))>0){
  outpos= ((-b+sqrt((b*b)-(4*a*c)))/(2*a));
  outneg= ((-b-sqrt((b*b)-(4*a*c)))/(2*a));
  printf(" %.2f \t %.2f\n", outpos, outneg);
  return 0; 
  }
/* det == 0 = 1 real root*/
 if(fabs((b*b)-(4*a*c))<.0001){
   outpos= ((-1*b)/(2*a));
   printf("%.2f\n", outpos);
   return 0;
  }
 /* det neg = 2 complex roots*/
 if(((b*b)-(4*a*c))<0){
   real= ((-1*b)/(2*a));
   imag= (sqrt(fabs(((b*b)-(4*a*c))))/(2*a));
     printf("%.2f + %.3f i \n%.2f - %.3f i\n", real, imag, real, imag);
  }
}
