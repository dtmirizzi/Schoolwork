#include <stdio.h>
#include <stdlib.h>
#include <math.h>
///*linear interpolation*///
int main(int argc, char **argv)
{
  /*usage error statement*/
  if (argc < 6){
    printf( " Usage: %s srcMin scrMax tgtMin tgtMax value\n", argv[0]);
    return 0;
  }
  /*usage variables*/ 
  float srcMin= atof(argv[1]);
  float srcMax= atof(argv[2]);
  float tgtMin= atof(argv[3]);
  float tgtMax= atof(argv[4]);
  float value= atof(argv[5]);
  float output; 
  /*undefined error*/
   if (fabs(srcMax-srcMin)<.0001){
    printf("Solution Is Undefined no Source Range\n");
    return 0;
    }  
/*target range*/ 
if (tgtMax<tgtMin){
  output= (((tgtMin-tgtMax)/(srcMax-srcMin))*(value-srcMin)+tgtMin);
  printf("%.3f\n Target Range Flipped\n", output);
    return 0;
    }
  /*sorce range */ 
 if ( srcMax<srcMin){
  output= (((tgtMax-tgtMin)/(srcMin-srcMax))*(value-srcMin)+tgtMin);
  printf("%.3f\n Source Range Flipped\n", output);
    return 0;
    }
 /*sorce min clamping statement*/ 
  if (value < srcMin){
  output= (((tgtMax-tgtMin)/(srcMax-srcMin))*(srcMin-srcMin)+tgtMin);
  printf("%.3f\n Value Clamped to Source Min\n", output);
    return 0;
    }
  /*sorce max claping statement*/
   if (value > srcMax){
     output= (((tgtMax-tgtMin)/(srcMax-srcMin))*(srcMax-srcMin)+tgtMin);
     printf("%.3f\n Value Clamped to Source Max\n", output);
    return 0;
    }
    /*regular output*/
  output= (((tgtMax-tgtMin)/(srcMax-srcMin))*(value-srcMin)+tgtMin);
  printf("%.3f\n", output);
  return 0;
}
