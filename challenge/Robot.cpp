#include<bits/stdc++.h>
using namespace std;

class Robot{
    private :
    string name;
    int battery;
    int pos[2];


    public:
    Robot(string name,int battery){
        this->name=name;
        this->battery=battery;
        // this->pos=pos
        pos[0]=0;
        pos[1]=0;
    }
    void move(int dx,int dy){
        pos[0]+=dx,pos[1]+=dy;
       
    }
    Robot clone(){
        string newName=name+"_copy";
        Robot newRobot(newName,battery);
        newRobot.pos[0]=pos[0];
        newRobot.pos[1]=pos[1];
        //return deep copy of this robot
        return newRobot;
        
    }
    void show(){
        cout<<"Robot name :"<<name<<endl;
        cout<<"current battery level :"<<battery<<endl;
        cout<<"current position :"<<pos[0]<<" "<<pos[1]<<endl;
    }
};

int main(){

    Robot R2D2("R2D2",100);
    R2D2.move(5,5);
    Robot R2D2_copy=R2D2.clone();
    R2D2.move(-2,3);
    R2D2.show();
    R2D2_copy.show();

return 0;
}