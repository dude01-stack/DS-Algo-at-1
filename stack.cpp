#include<iostream>
#include<string.h>
using namespace std;
struct node{
char data;
node *next;

node(){
char data=0;
next=NULL;
}

node(char x){
data=x;
next=NULL;}
};
node*push(node *head,char n){
node*temp=head,*newNode;
newNode=new node(n);
newNode->next=head;
return newNode;
}
int isEmpty(node*head)
{
    return head == NULL;
}

int printStack(node *head){
    int count=0;
    cout<<endl;
node *temp=head;
if(head==NULL){
    cout<<"Empty"<<endl;
    return 0;
}else{
    cout<<"The modified string is :"<<endl;
while(temp!=NULL){
        count++;
    cout<<temp->data<<" ";
    temp=temp->next;
}
cout<<endl<<endl<<"The number of elements are :"<<count<<endl<<endl;
return count;
}
}
 node* pop(node*head){
    node*temp2=head;
    node*temp=head->next;
    delete(temp2);
    return temp;
}
 char top(node*head){
    return head->data;
}


int main()
{
    
}
