#include<iostream>
#include<algorithm>
#include<vector>
#include<string>

using namespace std;

//Student 구조체 정의
struct Student
{
  string name; //이름
  int kor, eng, math; // 점수
};

vector<Student> arr; //학생 정보 저장 벡터

//정렬 함수에 사용할 함수
bool compare(Student &a, Student &b)
{
  if(a.kor == b.kor)
  {
    if(a.eng == b.eng)
    {
      if(a.math == b.math)
      {
        return a.name < b.name;
      }
      return a.math > b.math;
    }
    return a.eng < b.eng;
  }
  return a.kor > b.kor;
}

int main()
{
  int n;
  cin >> n;

  for(int i = 0; i < n; i++)
  {
    Student a;
    cin >> a.name >> a.kor >> a.eng >> a.math;
    arr.push_back(a); 
  }

  sort(arr.begin(), arr.end(), compare);
  
  for(int i = 0; i < n; i++)
  {
    cout << arr[i].name << '\n';
  }
  
  return 0;

}