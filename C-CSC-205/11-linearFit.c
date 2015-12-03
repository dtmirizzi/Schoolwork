#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main(int argc, char **argv){
 // Usage error statement 
 if (argc!=2){
    printf( "usage: %s <File> \n", argv[0]);
    return 0; 
 }
 // file locaton statement
 FILE *ftpr;
  ftpr = fopen(argv[1],"r");
  if (ftpr==0){
    printf("cannot open file, terminiating\n");
    return 0;
  }
  //scanning loop varibles
  int arrayMax; 
  fscanf(ftpr,"%d",&arrayMax);
  float x[arrayMax];
  float y[arrayMax];
  int i;
  for(i=0;i<arrayMax-1;++i){
    fscanf(ftpr,"%f",&x[i]);
    fscanf(ftpr,"%f",&y[i]);
  }
  fclose(ftpr);
  float EXiYi=0;
  float EXi=0; 
  float EYi=0;
  float EX2i=0;
  float M=0;
  float b=0;
  for(i=0;i<arrayMax-1;++i){
    EXiYi= ((x[i]*y[i])-(1.0/arrayMax)) +EXiYi;
    EXi= x[i] +EXi; 
    EYi= EYi +y[i];
    EX2i= (x[i]*x[i]) + EX2i;
  }
  M=((EXiYi-((EXi*EYi)/arrayMax))/((EX2i)-((EXi*EXi)/arrayMax)));
  b=(EYi/arrayMax)-((EXi/arrayMax)*M);
  printf("y=%.3fx+(%.3f)\n",M,b);
  return 0;
}

