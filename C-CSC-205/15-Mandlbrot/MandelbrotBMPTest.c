#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "BMPWriter.h"

int main(int argc, char **argv){
  if (argc!= 6){
    printf("usage: realmin, realmax, imagmin, imagmax\n");
    return 0;
  }
  float realmin=atof(argv[2]);
  float realmax=atof(argv[3]);
  float imagmin=atof(argv[4]);
  float imagmax=atof(argv[5]);
  int i, j;
  int h= 2160;
  int w= 3840;
  int **red,**green,**blue;
  red= makeMatrix(h,w);
  green= makeMatrix(h,w);
  blue= makeMatrix(h,w);
  float scaleI;
  float scaleR;

  scaleI=(imagmax-imagmin)/(w-1);
  scaleR=(realmax-realmin)/(h-1);

  for (i=0;i<h;++i){
    float cr =scaleR*i+realmin;
    for(j=0;j<w;++j){
      float ci =scaleI*j+imagmin;
      float zr=0;
      float zi=0;
      int  count=0;
      while ((count<255) && (zr*zr*zi*zi<4.0)){

      float temp =(zr*zr)-(zi*zi)+cr;
      zi=(2.0*zr*zi)+ci;
      zr=temp;
      ++count;
      }
      red[i][j]=count*count;
      green[i][j]=count*count;
      blue[i][j]=count*count;
    }
  }
    WriteBMP (argv[1], red, green, blue, h, w);
  for(i=0;i<h;++i){
    free(green[i]);
    free(red[i]);
    free(blue[i]);
  }
 free(red);
 free(blue);
 free(green);
  return 0;
}
