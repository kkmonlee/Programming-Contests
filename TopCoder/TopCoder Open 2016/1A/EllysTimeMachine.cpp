#include <vector>
#include <map>
#include <iomanip>

using namespace std;

class EllysTimeMachine {
    public:
        string getTime(string);
};

string EllysTimeMachine::getTime(string time) {
    int a, b;
    sscanf(time.c_str(), "%d:%d", &a, &b);
    char buffer[100];
    sprintf(buffer, "%02d:%02d", b == 0 ? 12 : b / 5, a == 12 ? 0 : a * 5);
    return string(buf);
}
