/*
    Practice 6
    Name : 王廷傑
    ID : 109403020
    Course : 2023-CE1004
*/
#include <iostream>
#include <vector>
using namespace std;
class Transaction
{
public:
    Transaction(string n)
    {
        income = 0;
        pay = 0;
        name = n;
    }
    void setIncome(int i)
    {
        income = i;
    };
    void setPay(int p)
    {
        pay = p;
    };
    string getName()
    {
        return name;
    }
    int getIncome()
    {
        return income;
    }
    int getPay()
    {
        return pay;
    }

private:
    string name;
    int income;
    int pay;
};
int main()
{
    vector<Transaction> ts;
    while (true)
    {

        int input;
        cin >> input;

        if (input == 1)
        {
            string name;
            int income;
            cin >> name >> income;
            Transaction t(name);
            t.setIncome(income);
            ts.push_back(t);
        }
        else if (input == 2)
        {
            string name;
            int pay;
            cin >> name >> pay;
            Transaction t(name);
            t.setPay(pay);
            ts.push_back(t);
        }
        else if (input == 3)
        {
            int sum = 0;

            for (Transaction t : ts)
            {
                cout << t.getName() << " " << t.getIncome() << " " << t.getPay() << endl;
                sum += t.getIncome() - t.getPay();
            }
            cout << "Total: " << sum << "\n";
        }
        else if (input == 4)
        {
            break;
        }
        else
        {
            printf("Invalid Operation\n");
        }
    }
    cout << endl;
}