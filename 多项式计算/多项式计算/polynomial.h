#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>
#include<assert.h>
typedef struct element//����������
{
	int coeff;
	int index;
}element;
typedef struct polyno//�������ʽ���
{
	element date;
	struct polyno* next;
}polyno;
void Initial(polyno* p1, polyno* p2, polyno* p3);//��ʼ����������ʽ����
void Destorypoly(polyno* p);//���ٶ���ʽ
void Addpolyno(polyno* p1, polyno* p2, polyno* p3);//����ʽ��Ӻ���
void Displaypolyno(polyno* p);//��ʾ��Ӻ�Ķ���ʽ
void Subpolyno(polyno* p1, polyno* p2, polyno* p3);//����ʽ�������