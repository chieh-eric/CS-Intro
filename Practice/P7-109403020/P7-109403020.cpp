/*
    Practice 7
    Name : 王廷傑
    ID : 109403020
    Course : 2023-CE1004
*/
#include <iostream>
using namespace std;
class Species
{
private:
    const string name;
    string category;
    int number;

public:
    Species()
        : name("human"),
          category("Primates"),
          number(100) {}
    Species(const string n, const string c, int num)
        : name(n),
          category(c),
          number(num) {}
    ~Species()
    {
        cout << "species " << name << " is deleted" << endl;
    }
    string getName() const
    {
        return name;
    }
    string getCate() const
    {
        return category;
    }
    int getNum() const
    {
        return number;
    }
    void setCate(string c)
    {
        category = c;
    }
    void setNum(int n)
    {
        number = n;
    }
    void showInfo() const
    {
        cout << name << " " << category << " " << number << endl;
    }
};
int main()
{
    Species s1;
    int number;
    string act, name, category;
    cout << "please input species2 info(name/category/number)" << endl;
    cin >> name >> category >> number;
    Species s2(name, category, number);
    while (true)
    {
        string input;
        cout << "1.change species info 2.show all species info 3.exit" << endl;
        cin >> input;
        if (input == "1")
        {
            int nN;
            string nC, which;
            cout << "which species would you like to change(1/2)?" << endl;
            cin >> which;
            cout << "input new info (category/number)" << endl;

            if (which == "1")
            {
                cin >> nC >> nN;
                s1.setCate(nC);
                s1.setNum(nN);
            }
            else if (which == "2")
            {
                cin >> nC >> nN;
                s2.setCate(nC);
                s2.setNum(nN);
            }
        }
        else if (input == "2")
        {
            s1.showInfo();
            s2.showInfo();
        }
        else if (input == "3")
        {
            break;
        }
    }
}