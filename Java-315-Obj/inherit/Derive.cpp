#include "Derive.h"
#include <iostream>

using namespace std;

Derive::Derive()
{
  cout << "Derive constructor" << endl;
}

Derive::Derive(int x) : Base(x)
{
  cout << "Derive constructor " << x << endl;
}

Derive::~Derive()
{
  cout << "Derive destructor " << x << endl;
}

void Derive::print()
{
  cout << "Derive print " << x << endl;
}
