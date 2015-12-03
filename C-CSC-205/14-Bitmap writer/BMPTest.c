#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include "BMPWriter.h"

int main(int argc, char **argv){
  if (argc !=4){
    printf("usage: hight width\n");
    return 0;
  }
  int **red,**green,**blue;
  red= makeMatrix(atoi(argv[2]), atoi(argv[3]));
  green= makeMatrix(atoi(argv[2]), atoi(argv[3]));
  blue= makeMatrix(atoi(argv[2]), atoi(argv[3]));

  int i, j;
  int h= atoi(argv[2]);
  int w= atoi(argv[3]);
  for (i=0;i<h;++i){
    for(j=0;j<w;++j){
      red[i][j]=0;
      green[i][j]=j*j*j*i*i*i%256;
      blue[i][j]=j*j*j*i*i*i%256;
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
