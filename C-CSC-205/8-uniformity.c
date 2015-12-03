 #include <stdio.h>
#include <stdlib.h>
#include <math.h>
///* Random # generator */// 
int main(int argc, char **argv)
{ 
  /* Usage error statement */
if (argc<=2){
    printf( "usage: %s <_> <_> \n", argv[0]);
    return 0;
 }
/*seed 1*/
 srand(atoi(argv[1]));
 /*mean varibles defined*/
  float rangerand=0;
  float sum=0;
  float mean;
  int count;
  /*mean calculation*/
 while (count != atoi(argv[2])){
   rangerand= ((float)rand()/(RAND_MAX));
   sum=  rangerand+sum;
   count= count +1;
 }
 mean= sum/atof(argv[2]);   
 /*mean print statement*/   
 printf("mean: %.3f\n", mean);
 /* std dev varibles */
       int count2=0;
       srand(atoi(argv[2]));
       float rangerand2=0;
       float sum2=0;
       float stddev=0;
 /*std dev calculation*/
 while (count2 != atoi(argv[2])){ 
   rangerand2= ((float)rand()/(RAND_MAX));
   sum2=  rangerand2 +sum2;
   stddev= (rangerand2-mean)*(rangerand2-mean);
   sqrt(stddev); 
   count2= count2 +1;
       }
 /*std dev print*/
 printf("standard deviation: %.3f \n", stddev);
       return 0;
       }
