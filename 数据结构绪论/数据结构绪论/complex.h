#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
typedef struct complex
{
	int realpart;
	int imaqpart;
}complex;

enum AB
{
	Exit,
	Add,
	Sub,
	Mul,
	Div,
};

void complex_add(complex* e1,complex* e2); // 复数加法
void complex_sub(complex* e1, complex* e2);// 复数减法
void complex_mul(complex* e1, complex* e2); //复数乘法
void complex_div(complex* e1, complex* e2); //复数除法