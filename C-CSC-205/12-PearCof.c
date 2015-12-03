#include <stdlib.h>
#include <stdio.h>
#include <math.h>
///*Pearson Correlation program *///

float *ReadDataSet (FILE *ftpr, int *n);
float PearsonCorrelation(float *data1, float *data2, int n);

int main(int argc, char **argv){
 // Usage error statement 
 if (argc!=3){
    printf( "usage: %s <File> <File> \n", argv[0]);
    return 0; 
 }
 //input file usage
  FILE *ftpr1;
  ftpr1 = fopen(argv[1],"r");
  if (ftpr1==0){
    printf("cannot open file %s, terminiating\n",argv[1]);
    return 0;
  }FILE *ftpr2;
  ftpr2 = fopen(argv[2],"r");
  if (ftpr2==0){
    printf("cannot open file %s, terminiating\n",argv[2]);
    return 0;
  }
  int rowcheck1;
  int rowcheck2;
  fscanf(ftpr1, "%d",&rowcheck1);
  fscanf(ftpr2, "%d",&rowcheck2);
  if (rowcheck1!=rowcheck2){
    printf("file counts are not similar, Terminating\n");
    return 0;
  }
  fclose(ftpr1);
  fclose(ftpr2);
 // file 1 locaton/array accolation statement
 FILE *ftpr3;
  ftpr3 = fopen(argv[1],"r");
  int N1;
  float *arrayX =ReadDataSet(ftpr3,&N1);
  fclose(ftpr3);
 // file 2 locaton/array accolation statement
 FILE *ftpr4;
  ftpr4 = fopen(argv[2],"r");
  int N2;
  float *arrayY=ReadDataSet(ftpr4,&N2);
  fclose(ftpr4);
  // function main 
  float Cof;
  Cof=PearsonCorrelation(arrayX,arrayY, N1);
  printf("The Pearson Correlation Coefficient is: %.3f\n", Cof);
  free(arrayX);
  free(arrayY);
  return 0;
}

//* read function *//
float *ReadDataSet (FILE *ftpr, int *n){
  fscanf(ftpr,"%d",n);
  float *x;
  x=(float *)malloc(n[0] * sizeof(float));
  int i;
  for(i=0;i<n[0];++i){
    fscanf(ftpr,"%f",&x[i]);
  }
  return x;
}

//*Calculation Function //
float PearsonCorrelation(float *data1, float *data2, int n){
  float Xmean=0;
  float Ymean=0; 
  int i;
  for(i=0; i<n; ++i){
    Xmean= Xmean+ data1[i];
    Ymean= Ymean+ data2[i];
  }
  Xmean= Xmean/n;
  Ymean= Ymean/n;
  float SumXY=0;
  float SumX=0;
  float SumY=0;
  float rxy=0;
  for(i=0;i<n;++i){
    SumXY=SumXY+ (data1[i]-Xmean)*(data2[i]-Ymean);
    SumX=SumX+((data1[i]-Xmean)*(data1[i]-Xmean));
    SumY=SumY+((data2[i]-Ymean)*(data2[i]-Ymean));
  }
  rxy=SumXY/sqrt(SumX*SumY); 
  return rxy;
  }
