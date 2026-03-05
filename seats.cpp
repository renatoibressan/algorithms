#include <iostream>
#define N 100
using namespace std;

int spacesCount(int seats);

int main() {
    int seats_per_row, spaces;
    while (true) {
        cin >> seats_per_row;
        if (seats_per_row >= 1 && N <= 100) break;
    }
    spaces = spacesCount(seats_per_row);
    cout << spaces << endl;
    return 0;
}

int spacesCount(int seats) {
    return (seats * seats) + (seats - 1);
}