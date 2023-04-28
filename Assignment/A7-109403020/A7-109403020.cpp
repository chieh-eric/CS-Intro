/*
    Assignment 7
    Name : 王廷傑
    ID : 109403020
    Course : 2023-CE1002
*/
#include <iostream>
#include <vector>
using namespace std;
class Behavior
{
public:
    Behavior(int f, string a)
    {
        feeding_habits = f;
        activity_time = a;
    }
    Behavior()
    {
        feeding_habits = 2;
        activity_time = "day";
    }
    void setFeeding(int s)
    {
    }
    void setAct(string s)
    {
    }
    int getFeed() const
    {
        return feeding_habits;
    }
    string getAct() const
    {
        return activity_time;
    }

private:
    string activity_time;
    int feeding_habits;
};
class Species
{
private:
    const string name;
    string category;
    Behavior behavior;
    int number;

public:
    Species()
        : name("human"),
          category("Primates"),
          number(100) {}
    Species(const string n, const string c, const Behavior &b, int num)
        : name(n),
          category(c),
          behavior(b),
          number(num) {}
    Species(const string n, const string c, const int f, const string a, const int num)
        : name(n),
          category(c),
          behavior(f, a),
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
    Behavior getBeh() const
    {
        return behavior;
    }
    int getNum() const
    {
        return number;
    }
    void setCate(string c)
    {
        category = c;
    }
    void setBeh(Behavior b)
    {
        behavior = b;
    }
    void setNum(int n)
    {
        number = n;
    }
    void showInfo() const
    {
        string fd;
        if (behavior.getFeed() == 0)
        {
            fd = "herbivorous";
        }
        else if (behavior.getFeed() == 1)
        {
            fd = "carnivorous";
        }
        else if (behavior.getFeed() == 2)
        {
            fd = "omnivorous";
        }
        cout << name << " " << category << " " << fd << " " << behavior.getAct() << " " << number << endl;
    }
};
int main()
{
    vector<Species> sps;
    Species s1;
    int feed, number;
    string act, name, category;
    cout << "please input behavior info (feeding_habits/activity_time)" << endl;
    cin >> feed >> act;
    Behavior b(feed, act);
    cout << "please input species2 info(name/category/number)" << endl;
    cin >> name >> category >> number;
    Species s2(name, category, b, number);
    cout << "please input species3 info(name/category/feeding_habits/activity_time/number)" << endl;
    cin >> name >> category >> feed >> act >> number;
    Species s3(name, category, feed, act, number);
    // sps.push_back(s1);
    // sps.push_back(s2);
    // sps.push_back(s3);
    while (true)
    {
        string input;
        cout << "1.change species info 2.show all species info 3.exit" << endl;
        cin >> input;
        if (input == "1")
        {
            int nF, nN;
            string nC, which, nA;
            cout << "which species would you like to change(1/2/3)?" << endl;
            cin >> which;
            cout << "input new info (category/feeding_habits/activity_time/number)" << endl;
            // cin >> nC >> nF >> nA >> nN;
            // Behavior tb(nF, nA);
            // sps[which - 1].setCate(nC);
            // sps[which - 1].setBeh(tb);
            // sps[which - 1].setNum(nN);
            if (which == "1")
            {
                cin >> nC >> nF >> nA >> nN;
                Behavior tb(nF, nA);
                s1.setCate(nC);
                s1.setBeh(tb);
                s1.setNum(nN);
            }
            else if (which == "2")
            {
                cin >> nC >> nF >> nA >> nN;
                Behavior tb(nF, nA);
                s2.setCate(nC);
                s2.setBeh(tb);
                s2.setNum(nN);
            }
            else if (which == "3")
            {
                cin >> nC >> nF >> nA >> nN;
                Behavior tb(nF, nA);
                s3.setCate(nC);
                s3.setBeh(tb);
                s3.setNum(nN);
            }
        }
        else if (input == "2")
        {
            s1.showInfo();
            s2.showInfo();
            s3.showInfo();
            // for (Species s : sps)
            // {
            //     s.showInfo();
            // }
        }
        else if (input == "3")
        {
            break;
        }
    }
}