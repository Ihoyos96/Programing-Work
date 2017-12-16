#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <ctype.h>
#include <stdbool.h>

#define STRING_LENGTH 128

//-----------String type definition                                                           
typedef char String [STRING_LENGTH];



//-----------Main Person's Node Type Definition                                               
typedef struct listNode {
  String name;
  struct listNode* ally;
  struct listNode* next;
} node;

//-----------Add Function                                                                     
void add(node**head, String name){
  node * newNode = malloc(sizeof(node));
  strcpy(newNode->name, name);
  newNode->next = *head;
  *head = newNode;
}

node* find(node*head, String name){
  node * current = head;
  while(current != NULL && strcmp(current->name, name) != 0){
    current = current->next;
  }
  return current;
}


//-----------Main Function                                                                    
int main(void) {
  node* head = NULL;
  node* current = NULL;
  String person;
  String ally;

  while (true){
    printf("%s","Enter nation name : ");
    fgets(person, STRING_LENGTH, stdin);
    person[strlen(person) - 1] = 0;

    if(strlen(person) == 0){
      break;
    }

    add(&head, person);
  }

  current = head;

  while(current != NULL){

    strcpy(person, current->name);
    printf("%s %s","\nEnter best ally name for ", person);
    printf("%s", " : ");
    scanf("%s", ally);

    current->ally = find(head, ally);
    
    current = current->next;
  }

  return(EXIT_SUCCESS);
}


