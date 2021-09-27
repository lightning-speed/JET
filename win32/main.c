
#include "run.h"
#include <stdio.h>
#include <stdlib.h>

char * addC(char * first,char *second);
int main(int argv,char ** argc)
{
    char * arguments = malloc(2048);
    arguments[0]=0;
    int i = 1;
    for(;i<argv;i++){
     strcat(arguments,argc[i]);
     strcat(arguments," ");
    }
    char * data = getData();
    FILE * fPtr;
    char * fileName=malloc(2048);
    fileName[0]=0;
    strcat(fileName,getenv("HOMEDRIVE"));
    strcat(fileName,getenv("HOMEPATH"));
    strcat(fileName,"\\bat.bat ");
    fPtr = fopen(fileName, "w");
    fputs(data, fPtr);
    fclose(fPtr);
    char * total = malloc(4096);
    int j = 0;
    for(;j<2048;j++){
    	total[j]=0;
    }
    total[0]=0;
    strcat(total,fileName);
    strcat(total," ");
    strcat(total,arguments);
    system(total);
    remove(fileName);
    return 0;
}