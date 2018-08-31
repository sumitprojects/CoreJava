#include<stdio.h>
void forloops(int low,int end,int loops,char name[],int inc)
{
    int i, l = low, e = end,count= 0;
    while(loops>0)
    {

        if(inc == 1)
        {
            for(i = low ; i < end; i++)
            {
                count++;
                printf("\tinc %c = %d loops = %d\t",name[loops-1],i,loops);
                if(loops > 2)
                    forloops(l,e,loops-1,name,inc);
                else if(loops > 1)
                    forloops(l,e,loops-1,name,0);

                printf("\n");
            }
            loops = 0;
        }
        else
        {
            for(i = end-1 ; i >= low; i--)
            {
                count++;
                printf("\tdec %c = %d loops = %d\t",name[loops-1],i,loops);
                if(loops>1)
                    forloops(l,e,loops-1,name,inc);

                printf("\n");
            }
            loops = 0;

        }
    }
    printf("count = %d",count);
}
int main()
{
    char name[3] = {'k','j','i'};
    forloops(0,3,3,name,1);
}
