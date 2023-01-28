#define _CRT_SECURE_NO_WARNINGS 1
#include"complex.h"
void complex_add(complex* e1, complex* e2) // 复数加法
{
	int temp1 ,temp2;
	temp1 = (e1->realpart) + (e2->realpart);
	temp2 = (e1->imaqpart) + (e2->imaqpart);
	e1->realpart = temp1;
	e1->imaqpart = temp2;
}
void complex_sub(complex* e1, complex* e2)// 复数减法
{
	int temp1, temp2;
	temp1 = (e1->realpart) - (e2->realpart);
	temp2 = (e1->imaqpart) - (e2->imaqpart);
	e1->realpart = temp1;
	e1->imaqpart = temp2;
}
void complex_mul(complex* e1, complex* e2) //复数乘法
{
	int temp1, temp2;
	temp1 = (e1->realpart)*(e2->realpart) - (e1->imaqpart)*(e2->imaqpart);
	temp2 = (e1->realpart)*(e2->imaqpart) + (e2->realpart)*(e1->imaqpart);
	e1->realpart = temp1;
	e1->imaqpart = temp2;
}
void complex_div(complex* e1, complex* e2) //复数除法
{
	int temp1, temp2, m;
	m = (e2->realpart)*(e2->realpart) + (e2->imaqpart)*(e2->imaqpart);
	if (m == 0)
	{
		printf("分母不能为0\n");
		return;
	}
	temp1 = (e1->realpart)*(e2->realpart) + (e1->imaqpart)*(e2->imaqpart);
	temp2 = (e1->realpart)*(-(e2->imaqpart)) + (e2->realpart)*(e1->imaqpart);
	e1->realpart = temp1/m;
	e1->imaqpart = temp2/m;
}