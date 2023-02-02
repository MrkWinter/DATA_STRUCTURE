#define _CRT_SECURE_NO_WARNINGS 1
#include "polynomial.h"
void Initial(polyno* p1,polyno* p2,polyno* p3)//初始化三个多项式函数
{	assert(p1&&p2&&p3);
	int i,j;
	polyno* temp;
	polyno* pp1 = p1;
	polyno* pp2 = p2;
	p1->next = NULL;
	p2->next = NULL;
	p3->next = NULL;
	printf("请输入第一个多项式的项数：");
	scanf("%d", &i);
	for (j = 0; j < i; j++)
	{
		printf("请分别输入第%d项的系数和指数(指数递增)", j + 1);
		temp = (polyno*)malloc(sizeof(polyno));
		scanf("%d", &temp->date.coeff);
		scanf("%d", &temp->date.index);
		temp->next = pp1->next;
		pp1->next = temp;
		pp1 = temp;
	}
	printf("请输入第二个多项式的项数：");
	scanf("%d", &i);
	for (j = 0; j < i; j++)
	{
		printf("请分别输入第%d项的系数和指数(指数递增)", j + 1);
		temp = (polyno*)malloc(sizeof(polyno));
		scanf("%d", &temp->date.coeff);
		scanf("%d", &temp->date.index);
		temp->next = pp2->next;
		pp2->next = temp;
		pp2 = temp;
	}
}
void Destorypoly(polyno* p)
{
	assert(p);
	polyno* r=p;
	while (p)
	{
		r = p->next;
		free(p);
		p = r;
	}
}
void Addpolyno(polyno* p1, polyno* p2, polyno* p3)//多项式相加函数
{
	polyno* temp;
	polyno* pp1 = p1->next;
	free(p1);
	polyno* pp2 = p2->next;
	free(p2);
	polyno* pp3 = p3;
	while (pp1&&pp2)
	{
		if (pp1->date.index > pp2->date.index)
		{
			pp3->next = pp2;
			pp3 = pp2;
			pp2 = pp2->next;

		}
		else if(pp1->date.index < pp2->date.index)
		{
			pp3->next = pp1;
			pp3 = pp1;
			pp1 = pp1->next;
		}
		else
		{
			(pp1->date.coeff) += (pp2->date.coeff);
			if (pp1->date.coeff == 0)
			{
				temp = pp1;
				pp1 = pp1->next;
				free(temp);
				temp = pp2;
				pp2 = pp2->next;
				free(temp);
			}
			else
			{
				pp3->next = pp1;
				pp3 = pp1;
				pp1 = pp1->next;
				temp = pp2;
				pp2 = pp2->next;
				free(temp);
			}
		}
		pp3->next = pp1 ? pp1 : pp2;
	}

}
void Displaypolyno(polyno* p)//显示相加后的多项式
{
	p = p->next;
	printf("%dX^%d", p->date.coeff, p->date.index);
	p = p->next;
	while (p)
	{
		if (p->date.coeff > 0)
			printf("+%dX^%d", p->date.coeff, p->date.index);
		else
			printf("%dX^%d", p->date.coeff, p->date.index);
		p = p->next;
	}
	putchar('\n');
}
void Subpolyno(polyno* p1, polyno* p2, polyno* p3)//多项式相减函数
{
	polyno* temp;
	polyno* pp1 = p1->next;
	free(p1);
	polyno* pp2 = p2->next;
	free(p2);
	polyno* pp3 = p3;
	while (pp1&&pp2)
	{
		if (pp1->date.index > pp2->date.index)
		{
			pp3->next = pp2;
			pp3 = pp2;
			pp2 = pp2->next;

		}
		else if (pp1->date.index < pp2->date.index)
		{
			pp3->next = pp1;
			pp3 = pp1;
			pp1 = pp1->next;
		}
		else
		{
			(pp1->date.coeff) -= (pp2->date.coeff);
			if (pp1->date.coeff == 0)
			{
				temp = pp1;
				pp1 = pp1->next;
				free(temp);
				temp = pp2;
				pp2 = pp2->next;
				free(temp);
			}
			else
			{
				pp3->next = pp1;
				pp3 = pp1;
				pp1 = pp1->next;
				temp = pp2;
				pp2 = pp2->next;
				free(temp);
			}
		}
		pp3->next = pp1 ? pp1 : pp2;
	}
}