#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class University
{
public:
    int school_code;
    string school_name;
    int department_code;
    string department_name;
    string day_or_night;
    string level;
    int student_count;
    int teacher_count;
    int graduates_last_year;
    string city_name;
    string system_type;

    void print()
    {
        cout << school_name << "\t" << department_name << "\t" << graduates_last_year << endl;
    }
};

int main()
{
    ifstream infile("input.txt");

    vector<University> universities;

    string line;
    while (getline(infile, line))
    {
        University university;

        stringstream ss(line);
        ss >> university.school_code >> university.school_name >> university.department_code >> university.department_name >> university.day_or_night >> university.level >> university.student_count >> university.teacher_count >> university.graduates_last_year >> university.city_name >> university.system_type;

        universities.push_back(university);
    }

    for (University i : universities)
    {
        i.print();
    }

    return 0;
}