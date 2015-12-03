#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdint.h>

#define DWORD uint32_t
#define LONG int32_t
#define WORD uint16_t

typedef struct tagBITMAPINFOHEADER {
  DWORD biSize;
  LONG  biWidth;
  LONG  biHeight;
  WORD  biPlanes;
  WORD  biBitCount;
  DWORD biCompression;
  DWORD biSizeImage;
  LONG  biXPelsPerMeter;
  LONG  biYPelsPerMeter;
  DWORD biClrUsed;
  DWORD biClrImportant;
} BITMAPINFOHEADER;


typedef struct tagBITMAPFILEHEADER {
  WORD  bfType;
  DWORD bfSize;
  WORD  bfReserved1;
  WORD  bfReserved2;
  DWORD bfOffBits;
} BITMAPFILEHEADER, *PBITMAPFILEHEADER;


int WriteBMP (char *_filename, int **_red, int **_grn, int **_blu, int _height, int _width);
int **makeMatrix (int h, int w);
