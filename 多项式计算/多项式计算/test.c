#define _CRT_SECURE_NO_WARNINGS 1
#include "polynomial.h"
void menu()
{
	printf("**********************\n");
	printf("*** 1.Add    2.Sub ***\n");
	printf("*** 3.Mul    4.Div ***\n");
	printf("*** 0.exit         ***\n");
	printf("**********************\n");

}

int main()
{
	
	
	int input;

	do
	{	
		polyno* p1 = (polyno*)malloc(sizeof(polyno));
	    polyno* p2 = (polyno*)malloc(sizeof(polyno));
		polyno* p3 = (polyno*)malloc(sizeof(polyno));
	    menu();
		printf("请输入选项：");
		scanf("%d", &input);
		if(input==1||input==2||input==3||input==4)
		Initial(p1, p2, p3);//初始化三个多项式函数
		switch (input)
		{
		case 1:
			Addpolyno(p1, p2, p3);//多项式相加函数
			Displaypolyno(p3);//显示相加后的多项式
			break;
		case 2:
			Subpolyno(p1, p2, p3);//多项式相减函数
			Displaypolyno(p3);//显示相加后的多项式
			break;
		case 3:
			break;
		case 4:
			break;
		case 0:
			break;
		default:
			printf("输入错误\n");
			break;
		}
		if (input != 0)
		{
			printf("输入任意键返回");
			getchar(); getchar();
			system("cls");
		}
		Destorypoly(p3);//销毁多项式
	} while (input);
	return 0;
}