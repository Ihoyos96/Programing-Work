#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define STRING_SIZE 128
//-------------TypeDefinitions-------------------------------------------------        \
                                                                                  
typedef char String[STRING_SIZE];
typedef float size;
typedef enum {
  mammal,
  insect,
  bird,
  fish,
  error
} type;

//-----------------------------------------------------------------------------        \
   
typedef struct Animal{

     String Animal_Name;
     size Animal_Size;
     type Animal_Type;

  } Animal;      

type stringToEnum(String Animal_Type){

  if(strcmp(Animal_Type, "mammal") == 0){
    return mammal;
  }

  if(strcmp(Animal_Type, "insect") == 0){
    return insect;
  }

  if(strcmp(Animal_Type, "bird") == 0){
    return bird;
  }

  if(strcmp(Animal_Type, "fish") == 0){
    return fish;
  }

  return error;

}

char* enumToString(type Animal_Type_Enum){

  if(Animal_Type_Enum == mammal){
    return "mammal";
  }

  if(Animal_Type_Enum == insect){
    return "insect";
  }

  if(Animal_Type_Enum == bird){
    return "bird";
  }

  if(Animal_Type_Enum == fish){
    return "fish";
  }

}
//-------------------------------------------------------------------------------
//This function (new_animal) compresses all input into a new animal using the Animal Structure
//-------------------------------------------------------------------------------

Animal new_animal(String Animal_Name_Input, size Animal_Size_Input, String Animal_Type_Input){ 



  Animal NewAnimalCreated;

  strcpy(NewAnimalCreated.Animal_Name, Animal_Name_Input);
  NewAnimalCreated.Animal_Size = Animal_Size_Input;
  strcpy(NewAnimalCreated.Animal_Type, Animal_Type_Input);

  return NewAnimalCreated;

}                                                                

int main(void) {

  Animal NewAnimal;
  Animal *structArray = malloc(sizeof(Animal));

  String Animal_Name_Input;
  size Animal_Size_Input;
  String Animal_TypeAsString_Input;
  type Animal_Type_Input;

  int Exit_Condition = 0;

//--------While-Loop-Checks-For-Exit-Conndition----------------

  while(Exit_Condition != 1){

    printf("%s", "Enter animal name:\t");
    scanf("%s", Animal_Name_Input);

    if (Animal_Name_Input.equals("exit")){
      Exit_Condition = 1;
      break;
    }

    printf("%s", "Enter animal size:\t");
    scanf("%f", Animal_Size_Input);

//--------------Animal-Type-Given-as-String--------------------
//   So we call the function stringToEnum for conversion    

    printf("%s", "Enter animal type:\t");
    scanf("%s", Animal_TypeAsString_Input);

    Animal_Type_Input = stringToEnum(Animal_TypeAsString_Input);
  }

//------------------Creating-A-New-Animal-------------------------

    NewAnimal = new_animal(Animal_Name_Input, Animal_Size_Input, Animal_Type_Input);

//------------------Checking-Array-Size-------------------------
//    Followed by the addition of the new animal to the array

    int limit = 1;
    int count = 0;

    if(count != limit){
      structArray[count] = NewAnimal;
      count++;
    }else{
      limit = limit * 2;
      structArray = realloc(structArray, limit * sizeof(structArray));
      if (structArray == NULL){
        printf("%s\n", "Erroronious Activity Detected!");
        return EXIT_FAILURE; 
    }
  }
  

//------------------------Printing-------------------------------
  int i;
  for(i = 0; i << count; i++){

    Animal PrintingAnimal = structArray[i];

    String Animal_Type_String = enumToString(PrintingAnimal.Animal_Type);

    printf("%s", PrintingAnimal.Animal_Name);
    printf("%s", "\t \t");
    printf("%s", "has size  ");
    printf("%f", PrintingAnimal.Animal_Size);
    printf("%s", " and is a ");
    printf("%s", Animal_Type_String);
    printf("%s", "\n");
}

  return(EXIT_SUCCESS);
}