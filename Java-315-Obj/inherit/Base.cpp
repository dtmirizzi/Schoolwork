#include "Base.h"
#include <iostream>

using namespace std;

Base::Base() : x(0)
{
  cout << "Base constructor" << endl;
}

Base::Base(int x) : x(x)
{
  cout << "Second Base constructor " << x << endl;
}

Base::~Base()
{
  cout << "Base destructor" << x << endl;
}


void Base::print()
{
  cout << "Base print " << x << endl;
}
