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

void complex_add(complex* e1,complex* e2); // �����ӷ�
void complex_sub(complex* e1, complex* e2);// ��������
void complex_mul(complex* e1, complex* e2); //�����˷�
void complex_div(complex* e1, complex* e2); //��������