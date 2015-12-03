#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main( int argc, char **argv)
{
  char operator=argv[2][0];
  switch(operator){
  case '+':
    printf("%d\n",atoi(argv[1])+atoi(argv[3]));
    break;
  case '-':
    printf("%d\n",atoi(argv[1])-atoi(argv[3]));
    break;
  case'*':
    printf("%d\n",atoi(argv[1])*atoi(argv[3]));
    break;
  case '/':
    printf("%d\n",atoi(argv[1])/atoi(argv[3]));
    break;
  case'%':
    printf("%i\n",atoi(argv[1])%atoi(argv[3]));
    break; 
  default:
     break;
       }
return 0;
}
