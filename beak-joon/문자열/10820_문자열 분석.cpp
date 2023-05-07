#include <iostream>
#include <string>

using namespace std; 

int main()
{
  string str;

  while(getline(cin,str))
  {
    int lower = 0;
    int upper = 0;
    int num = 0;
    int space = 0;

    for(int i = 0; i < str.size(); i++)
    {
      if(str[i] >= 'a' && str[i] <= 'z')
      {
        lower += 1;
      }
      else if(str[i] >= 'A' && str[i] <= 'Z')
      {
        upper += 1;
      }
      else if(str[i] >= '0' && str[i] <= '9')
      {
        num += 1;
      }
      else if(str[i] == ' ')
      {
        space += 1;
      }
    }
    cout << lower << " " << upper << " " << num << " " << space << '\n';
  }

}