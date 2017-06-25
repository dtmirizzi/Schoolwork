#pragma once

class Base
{

 public:
  Base();
  Base(int x);
  virtual ~Base();

  void print();
  
  protected:
  int x;
};
