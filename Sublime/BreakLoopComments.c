#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLINE 1000
//-----------------------------------------------------------------------------
//----Remove trailing blanks and tabs
int main(void) {

    int Length;
    char Line[MAXLINE];

    fgets(Line,MAXLINE,stdin);   // parameters: fgets( theLineWeAreLookingfor???,theSizeofTheArray, theSourceFromWhereWeAreGettingThenputs)
    Line[strlen(Line)-1] = '\0';
    while ((Length = strlen(Line)) > 0) { // while the length of line is greater than zero.
        printf("Before cleaning \"%s\"\n",Line);
        while (--Length >= 0) {
            if (Line[Length] != ' ' && Line[Length] != '\t' &&
Line[Length] != '\n') { //making sure the last piece of line is not a space or tab or new line.
                break;
            }
        }
        Line[Length+1]='\0';
        printf("After cleaning  \"%s\"\n",Line);

        fgets(Line,MAXLINE,stdin);
        Line[strlen(Line)-1] = '\0';
    }

    return(EXIT_SUCCESS);
}
//-----------------------------------------------------------------------------