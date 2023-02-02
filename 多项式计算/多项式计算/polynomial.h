#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>
#include<assert.h>
typedef struct element//定义数据域
{
	int coeff;
	int index;
}element;
typedef struct polyno//定义多项式结点
{
	element date;
	struct polyno* next;
}polyno;
void Initial(polyno* p1, polyno* p2, polyno* p3);//初始化三个多项式函数
void Destorypoly(polyno* p);//销毁多项式
void Addpolyno(polyno* p1, polyno* p2, polyno* p3);//多项式相加函数
void Displaypolyno(polyno* p);//显示相加后的多项式
void Subpolyno(polyno* p1, polyno* p2, polyno* p3);//多项式相减函数