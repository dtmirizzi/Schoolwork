#include <stdlib.h>
#include <stdio.h>
#include <math.h>
///*summations assignment: every summation is checked*///
int main(int argc, char **argv)
{
 // Usage error statement 
if (argc<=1){
    printf( "usage: %s <_> \n", argv[0]);
    return 0;
 }
 //variables defined
 int i;
 int summ=0;
 int N=atoi(argv[1]);
 int summ2; 
 float summf;
 float factorial;
 //summ of a C
 for(i=0;i<N; ++i){
   summ=6+summ;
 }
 printf("Expression 1: %d\t%d\n", summ, 6*N);

 //summ of i
for(i=1,summ=0;i<N+1;++i){
	summ+=i;
}
printf("Expression 2: %d\t%d\n",summ,(N*(N+1))/2);
 //summ of i^2
for(i=1,summ=0;i<N+1;++i){
  summ= (i*i)+summ;
}
 printf("Expression 3: %d\t%d\n",summ,((2*N*N*N)+(3*N*N)+N)/6);
 //summ of A^i
for(i=0,summ=0;i<N+1;++i){
  summ= pow(4,i)+summ;
}
 printf("Expression 4: %d\t%d\n",(int)summ,(int)(pow(4,N+1)-1)/(4-1));
 //summ i*2^i
for(i=1,summ=0;i<N+1;++i){
  summ= (i*pow(2,i))+summ;
}
 printf("Expression 5: %d\t%d\n",(int)summ,(int)((N-1)*pow(2,N+1)+2));
 // summ a + summ b
 for(i=1,summ=0,summ2=0;i<N+1;++i){
  summ= 4+summ;
  summ2=5+summ2;
}
 printf("Expression 6: %d\t%d\n",summ+summ2,4*N+5*N);
 //sum for 1/i
for(i=1,summf=0;i<N;++i){
  summf=(1/(float)i)+summf;
}
 printf("Expression 7: %.3f\t%.3f\n",summf,(log(N)+.57721566));
 // summ of log(1)
for(i=1,summf=0;i<N+1;++i){
  summf= log10((float)i)+summf;
}
 //N factorial for summ check
for(i=1,factorial=1;i<N+1;++i){
  factorial= ((float)i)*factorial;
  }
 printf("Expression 8: %.3f\t%.3f\n",summf,log10(factorial));
 return 0;
}
