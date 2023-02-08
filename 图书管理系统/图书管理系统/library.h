#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<Windows.h>
#include<stdlib.h>
#include<assert.h>
#include<string.h>
#define START 5//定义初始容量
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
typedef struct book//每本书的信息
{
	char name[20];
	char id[20];
	int price;
}book;
typedef struct catalogue //图书管理系统的目录信息
{
	book* arr;
	int number;
	int capacity;
}catalogue;
//初始化图书目录
void Initial_list(catalogue* list);
//保存图书目录信息
void Save_list(catalogue* list);
//增添信息到图书目录
void Add_list(catalogue* list);
//展示图书信息
void Show_list(const catalogue* list);
//删除图书目录信息
void Delect_list(catalogue* list);
//查找图书信息
void Search_list(catalogue* list);
//修改图书信息
void Modify_list(catalogue* list);
//排序图书信息
void Sort_list(catalogue* list);
