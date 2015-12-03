#include <stdlib.h>
#include <stdio.h>
#include <math.h>
///*std dev: std method *///
int main(int argc, char **argv)
{
 // Usage error statement 
if (argc<=4){
    printf( "usage: %s <_> <_> <_> <_> \n", argv[0]);
    return 0;
 }
 srand(atoi(argv[1]));
// varibles def
 int  N=atoi(argv[2]);
 int i;
 float Min=atof(argv[3]);
 float Max=atof(argv[4]);
 float rangerand;
 float xrd=0;
 float x=0;
 float Meanxrd;
 float Meanx;
 float Meanxsquared;
 float stddev; 
 if (Min>Max){
   Min=atoi(argv[4]);
   Max=atoi(argv[3]);
 }
//std dev 
for(i=1;i<N;++i){
  rangerand=(((Max-Min)/(RAND_MAX))*((float)rand())+Min);
  xrd= (rangerand)*(rangerand)+xrd;
  x=rangerand+x;
}
 Meanxrd=xrd/N;
 Meanx=x/N;
 Meanxsquared=(Meanx)*(Meanx);
 stddev=sqrt(Meanxrd-Meanxsquared);
 printf("mean:%.3f\t stddev:%.3f\n",Meanx,stddev);
 return 0;
}
