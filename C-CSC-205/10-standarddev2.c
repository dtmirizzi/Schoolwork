#include <stdlib.h>
#include <stdio.h>
#include <math.h>
///*std dev: online method *///
int main(int argc, char **argv)
{
 // Usage error statement 
if (argc<=4){
    printf( "usage: %s <_> <_> <_> <_> \n", argv[0]);
    return 0;
 }
 srand(atoi(argv[1]));
 int i;
 int N=atoi(argv[2]);
 float Max=atof(argv[4]);
 float Min=atof(argv[3]);
 float M2;
 float delta;
 float mean;
 float xrange;
 float stddev;
 if (Min>Max){
   Min=atof(argv[4]);
   Max=atof(argv[3]);
 }
 for(i=1,mean=0,M2=0;N>i-1;++i){
   xrange=(((Max-Min)/(RAND_MAX))*((float)rand())+Min);
   delta=xrange-mean;
   mean=mean+(delta/i);
   M2=M2+delta*(xrange-mean);
 }
 stddev=sqrt(M2/(i-1));
 printf("mean:%.3f\tstddev:%.3f\n",mean, stddev);
 return 0;
}
	     
