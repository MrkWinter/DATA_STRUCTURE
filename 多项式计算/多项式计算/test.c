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
		printf("������ѡ�");
		scanf("%d", &input);
		if(input==1||input==2||input==3||input==4)
		Initial(p1, p2, p3);//��ʼ����������ʽ����
		switch (input)
		{
		case 1:
			Addpolyno(p1, p2, p3);//����ʽ��Ӻ���
			Displaypolyno(p3);//��ʾ��Ӻ�Ķ���ʽ
			break;
		case 2:
			Subpolyno(p1, p2, p3);//����ʽ�������
			Displaypolyno(p3);//��ʾ��Ӻ�Ķ���ʽ
			break;
		case 3:
			break;
		case 4:
			break;
		case 0:
			break;
		default:
			printf("�������\n");
			break;
		}
		if (input != 0)
		{
			printf("�������������");
			getchar(); getchar();
			system("cls");
		}
		Destorypoly(p3);//���ٶ���ʽ
	} while (input);
	return 0;
}