#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
#define START 5//�����ʼ����
enum object
{
	Exit,
	Add,
	Delect,
	Search,
	Modify,
	Show,
	Sort,
	Save,
};
typedef struct book//ÿ�������Ϣ
{
	char name[20];
	char id[20];
	int price;
}book;
typedef struct catalogue //ͼ�����ϵͳ��Ŀ¼��Ϣ
{
	book* arr;
	int number;
	int capacity;
}catalogue;
//��ʼ��ͼ��Ŀ¼
void Initial_list(catalogue* list);
//����ͼ��Ŀ¼��Ϣ
void Save_list(catalogue* list);
//������Ϣ��ͼ��Ŀ¼
void Add_list(catalogue* list);
//չʾͼ����Ϣ
void Show_list(const catalogue* list);
//ɾ��ͼ��Ŀ¼��Ϣ
void Delect_list(catalogue* list);
//����ͼ����Ϣ
void Search_list(catalogue* list);
//�޸�ͼ����Ϣ
void Modify_list(catalogue* list);
//����ͼ����Ϣ
void Sort_list(catalogue* list);
