#include "Base.h"
#include "Derive.h"
#include <iostream>

using namespace std;

int main (int argc, char** argv)
{
/*
  cout << "base objects" << endl;
  Base b;
  b.print();
  Base b1(6);
  b1.print();


  cout << "derive objects" << endl;
  Derive d;
  d.print();
  Derive d1(10);
  d1.print();
 */ 
  cout << "pointer objects" << endl;
//  Base *pb;
  Derive *pd;
  
//  pb = new Base(1);
  pd = new Derive(20);
  
  pd->print();
  
//  delete pb;
  delete pd;
  
  return 0;
}
