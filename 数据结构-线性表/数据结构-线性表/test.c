#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//2.1线性表的定义和使用
//线性表是具有相同特性的数据元素的一个有限序列
//线性表中有一个线性起点(起始结点)和一个线性终点(终端结点)
//除起始结点和终端结点外每个数据元素(内部结点)都有一个直接前驱和一个直接后继
//每个数据元素都有一个下标 最后一个数据元素下标为n n为元素个数 n=0 时被称为空表
//线性表是一种典型的线性结构


//2.2案例引用
//2.2.1一元多项式的运算
//2.2.2稀疏多项式的运算
//2.2.3图书信息管理系统


//2.3线性表的类型定义
//ADT list{
//
//	数据对象： D={a_i |a <- elemset，（i=1,2,3,4...）}
//
//	数据关系： R={<a_i-1,a_i>|a_i-1,a_i属于D（i = 1,2,3,4...）}
//
//	基本操作：
//
//}ADT list
//基本操作有
//构造空的线性表 摧毁线性表 初始化线性表 检查是否为空表 返回线性表中数据元素个数 返回线性表中第i个数据元素 定位线性表中某个数据元素 
//返回一个数据元素的前驱 返回一个数据元素的后继 在位置i处插入一个数据元素 删除位置i处的数据元素 遍历整个线性表数据元素等


//2.4线性表的顺序表示和实现
//2.4.1线性表的顺序存储表示 (顺序存储结构/顺序映像)
//顺序存储结构 ： 把逻辑上相邻的数据元素存储在物理上相邻的存储单元中的存储顺序
//如何实现存储结构 以图书管理系统为例
//typedef struct book
//{
//	char name[20];
//	char date[10];
//	int day;
//}book;
//struct lirary
//{
//	book* arr;//数组动态分配 book arr[] 数组动态分配
//	int length;
//};
//定义一个结构体 元素包含一个结构体指针数组 还包含一个统计使用数组储存数据元素的整型 表示线性表的长度属性
//从而实现把线性表存储在结构体数组中(使用多少内存自己开辟) 
//并且实现线性表存储的特征 地址连续 依次存放 随机存取 类型相同 线性表长度可变
//函数结果状态代码
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
//Status 是函数的类型 其值是函数结果的状态代码
typedef int Status;
typedef char ElemType;
//线性表操作实例
// 1 初始化线性表
//Status InitList_Sq(Sqlist &L) //线性表初始化函数InitList_Sq 为函数名 Sqlist &L 为c++中结构体传参的引用
//{
//	L.elem = new ElemType[MAXSIZE];//new ElemType[MAXSIZE] new为c++中动态内存开辟函数 同 malloc ElemType为类型
//	if (!L.elem) exit(OVERDLOW); //开辟内存失败返回NULL报错警告 同strerror(errno);
//	L.Length = 0;
//	return OK;
//}
//2 顺序表查找 算法： 顺序查找法(遍历)  平均查找长度 期望 
//3 顺序表插入        将数据元素向后移动
//4 顺序表删除        将数据元素向前移动


//2.5线性表的链式表示和实现

//2.5.1链表概念 
//每个数据元素的存储映像称为结点 结点分为数据域和指针域 数据域存储数据 指针域存储下一个结点的指针
//n个结点由指针链组成一个链表， 它是线性表的链式储存映像， 称为线性表的链式存储结构
//链表分为单链表 双链表 和循环链表
//首元结点 是指链表中存储第一个数据元素的结点
//头结点 是在链表的首元结点之前附设的一个结点
//头结点的指针被称为头指针
//有头结点的链表判断是否为空表 头结点的指针域是否为空
//头结点的好处 
//1使所有元素的处理都一样 无需特殊处理 
//2空表和非空表的统一处理
//顺序表和链表
//顺序表的存储方式为顺序存储 随机存取
//链表的存储方式为非顺序存储 顺序存取

//2.5.2单(向)链表的定义和表示
//typedef struct
//{//数据域的定义
//	int age;
//	char name[10];
//	int score;
//}elemtype;
//typedef struct lnode
//{//结点的定义
//	elemtype date;//数据域
//	struct lnode * next;//指针域
//}lnode,*linklist;//linklist为结构体指针类型 == lnode* || struct londe *

////1.单链表的初始化(空表)
//void Initlist_L(linklist L)
//{
//	L = (lnode*)malloc(sizeof(lnode));
//	L->next = NULL;
//}
//
////2.单链表的销毁
//void Delectlist_L(lnode *L)
//{
//	lnode* p;
//	while (L)//依次销毁结点
//	{
//		p = L->next;
//		free(L);
//		L = p;
//	}                                                                                                                                                     
//}
//
////3.单链表的清空
//void Clearlist_L(lnode* L)
//{
//	lnode* p= L->next;
//	lnode* d;
//	while (p)//重复销毁操作
//	{
//		d = p->next;
//		free(p);
//		p = d;
//	}
//	L->next = NULL;
//}
//
////求单链表表长函数
//int Lengthlist_L(lnode* L)
//{
//	int i = 0;
//	lnode* p = L->next;
//	while (p)
//	{
//		p = p->next;
//		i++;
//	}
//	return i;
//}
////得到单链表中元素
//void Getelemlist_L(lnode* L, int i, elemtype* s1)
//{
//	int j = 1;
//	lnode* p = L->next;
//	while (j < i && p)
//	{
//		p = p->next;
//		j++;
//	}
//	if (p == NULL || i <= 0)
//	{
//		printf("error");
//	}
//	else
//		*s1 = p->date;
//}
//
////查找单链表中元素
//int Searchlist_L(lnode* L, int age, elemtype* s2)
//{
//	int i = 1;
//	lnode* p=L->next;
//	while (p->date.age != age&&p)
//	{
//		p = p->next;
//		i++;
//	}
//	if (!p)
//	{
//		printf("nofind");
//		return 0;
//	}
//	else
//	{
//		*s2 = p->date;
//		return i;
//	}
//}
//
////插入单链表中数据
//void Instertlist_L(lnode* L, int i, elemtype* s3)
//{
//	int j = 0;
//	lnode* p=L;
//	while (j < i - 1 && p)
//	{
//		p = p->next;
//		j++;
//	}
//	if (!p || i <= 0)
//	{
//		printf("error");
//	}
//	else
//	{
//		lnode* s = (lnode*)malloc(sizeof(lnode));//创建新的结点
//		s->date = *s3;
//		s->next = p->next;
//		p->next = s;
//	}
//}
//
////删除单链表中元素函数
//void Removelist_L(lnode* L, int i, elemtype* s4)
//{
//	int j;
//	lnode* p = L;
//	for (j = 0; j < i - 1&&p; j++)
//	{
//		p = p->next;
//	}
//	if (!p || i <= 0)
//	{
//		printf("error");
//		return;
//	}
//	else
//	{
//		lnode* temp = p->next;
//		p->next = temp->next;
//		*s4 = temp->date;//保存多余结点数据
//		free(temp);//释放内存
//		temp = NULL;
//	}
//}
////头插法建立链表
//void Createlist_H(lnode* L, int n )
//{//已完成初始化建立空表
// //目标为创建三个结点的链表
//	int i;
//	elemtype s = {0};
//	lnode* p;
//	for (i = 0; i < n; i++)
//	{
//		printf("请依次输入数据：(年龄，姓名，分数)\n");
//		scanf("%d", &s.age);
//		getchar();
//		scanf("%s", &s.name);
//		getchar();
//		scanf("%d", &s.score);
//		getchar();
//		p = (lnode*)malloc(sizeof(lnode));
//		p->date = s;
//		p->next = L->next;
//		L->next = p;
//	}
//}
////尾插法建立链表函数
//Createlist_T(lnode* L, int n)
//{
//	int i;
//	elemtype s = { 0 };
//	lnode* r = L;
//	lnode* p;
//	for (i = 0; i < n; i++)
//	{
//		printf("请依次输入数据：(年龄，姓名，分数)\n");
//		scanf("%d", &s.age);
//		getchar();
//		scanf("%s", &s.name);
//		getchar();
//		scanf("%d", &s.score);
//		getchar();
//		p = (lnode*)malloc(sizeof(lnode));
//		p->date = s;           
//		p->next = NULL;
//		r->next = p;
//		r = p;

//	}
//}
//int main()
//{
//	lnode L = {0};//创建结构体变量
//	Initlist_L(&L);//单链表初始化函数
//	Createlist_H(&L,3);//头插法建立链表函数
//	Clearlist_L(&L);//清空单链表函数
//	Createlist_T(&L, 3);//尾插法建立链表函数
//	//Delectlist_L(&L);//单链表的销毁函数
//	Clearlist_L(&L);//清空单链表函数
//	Lengthlist_L(&L);//求单链表表长函数
//	elemtype s1;//定义返回元素
//	Getelemlist_L(&L,5,&s1);//得到单链表中元素函数(第五个结点)
//	elemtype s2;//定义返回元素
//	Searchlist_L(&L, 30, &s2);//查找单链表中元素函数(按年龄查找)
//	elemtype s3 = {12,"ailixiya",100};//定义插入元素
//	Instertlist_L(&L, 3, &s3);//插入单链表中数据函数(第二个结点后)
//	elemtype s4;//定义返回保留的删除元素
//	Removelist_L(&L, 3,&s4);//删除单链表中元素函数(删除第三个结点)
//
//	return 0;
//}

//5.2.3单项循环链表
//头尾相连的链表 表中最后一个结点的指针域指向头结点
//从表中任意一点出发均可找到表中其他结点
//带尾指针的循环链表更常用(尾指针指的是指向最后一个结点的指针)

//将带尾指针的循环链表合并(tb(尾结点) 接到 ta(尾结点) 后)
//1定义指针p=ta->next 2修改ta->next = tb->next->next 3释放free(tb->next) 4修改tb->next = p

//带尾指针的循环链表合并函数
//lnode* Connectlist(lnode* Ta, lnode* Tb)
//{
//	lnode* p = Ta->next;
//	Ta->next = Tb->next->next;
//	free(Tb->next);
//	Tb->next = p;
//	return Tb;
//}
//int main()
//{
//	lnode a = { 0 };
//	lnode b = { 0 };
//	Connectlist(a.next,b.next);//带尾指针的循环链表合并函数
//	return 0;
//}

//5.2.4双向链表的定义和实现   
//typedef struct dlnode
//{
//	elemtype date;
//	struct dlnode* prior, *next;
//}dlnode,*dlinklist;
//
//dlnode* Getelemp(dlnode* L, int n)//查找链表中第n个元素(返回地址)
//{
//	int j = 0;
//	dlnode* p = L;
//	while (p->next != L && j < n)
//	{
//		p = p->next;
//	}
//	if (n <= 0 || (j < n && p->next == L))
//
//		return NULL;
//	else
//		return p;
//}
////双向链表插入元素函数
//void Insertlist(dlnode* L, int n, elemtype* s1)
//{
//	dlnode* p;
//	if (p = Getelemp(L, n))
//	{
//		dlnode* s = (dlnode*)malloc(sizeof(dlnode));
//		s->date = * s1;
//		s->prior = p->prior;
//		p->prior->next = s;	
//		s->next = p;
//		p->prior = s;
//	}	
//}
////双向链表删除函数
//void Delectlist(dlnode* L, int n,elemtype * s2)
//{
//	dlnode* p;
//	if (p = Getelemp(L, n))
//	{
//		*s2 = p->date;
//		p->prior->next = p->next;
//		p->next->prior = p->prior;
//		free(p);
//	}
//}
//int mian()
//{
//	dlnode L = { 0 };
//	elemtype s1 = { 16,"hutao",100 };//定义插入函数
//	Insertlist(&L, 3, &s1);//双向链表插入元素函数
//	elemtype s2;//要返回的删除元素
//	Delectlist(&L, 3, &s2);//双向链表删除函数
//	return 0;
//}
//双向循环链表(略)


//2.6顺序表和链表的比较 
//链式存储结构的优点：
//结点空间可以动态申请和释放
//插入和删除操作不需要移动额外的元素
//链式存储结构的缺点：
//存储密度小，每个结点需要指针域占用更大的空间
//非随机存储结构，对任意结点操作都需要从头指针依链查找到该结点，增加了算法的复杂度
//
//空间效率上 
//{
//	存储密度 顺序表>链表
//	存储空间开辟使用 链表>顺序表
//}
//时间效率上
//{
//	存取元素 顺序表>链表
//	插入删除 链表>顺序表
//}

//2.7线性表的应用  
//2.7.1线性表的合并
//以顺序表为例
//typedef struct score1
//{
//	int* score;
//	int order;
//}score1;
//typedef struct score2  //???删除一个结构体
//{
//	int* score;
//	int order;
//}score2;
//void Inist(score1* s1,score2* s2)
//{
//	int i;
//	s1->score = (int*)malloc(sizeof(int) * 5);
//	s2->score= (int*)malloc(sizeof(int) * 3);
//	s1->order = 5;
//	s2->order = 3;
//	for (i = 0; i < 5; i++)
//	{
//		*((s1->score)+i) = i;
//	}
//	int j = 0;
//	for (i = 4; i < 7; i++,j++)
//	{
//		*((s2->score) + j) = i;
//	}
//}
//int ifgetla(int n, score1* la)
//{
//	int i;
//	for (i = 0; i < la->order; i++)
//	{
//		if ((la->score)[i] == n)
//			return 0;
//	}
//	return 1;
//}
//union_L(score1* la, score2* lb)
//{
//	int i;
//	int la_len = la->order;//求表长
//	int lb_len = lb->order;
//	for (i = 0; i <=lb_len; i++)
//	{
//		if (ifgetla((lb->score)[i], la))//判断是否在la中含有元素(lb->score)[i]若无则在la后加上
//		{
//			int* p;
//			if (p = realloc(la->score , sizeof(int)*((la->order) + 1)))
//			{
//				la->score = p;
//				*((la->score) + la->order) = (lb->score)[i];
//				(la->order)++;
//			}
//			else
//				printf("error");
//		}
//	}
//}
//int main()
//{
//	score1 s1 = { 0 };
//	score2 s2 = { 0 };
//	Inist(&s1,&s2);//初始化两个顺序表
//	union_L(&s1, &s2);//合并两个顺序表
//	printf("%d", (s1.score)[6]);//合并后第七个元素为6
//	free(s1.score);
//	free(s2.score);
//	return 0;
//}

//2.7.2有序表的合并
//顺序表有序表的合并
//typedef struct List
//{
//	int* date;
//	int num;
//}List;
//void Initial(List* la, List* lb)
//{
//	int i,j = 0;
//	la->date = (int*)malloc(sizeof(int) * 4);
//	la->num = 4;
//	for (i = 0; i < 4; i++)
//	{
//		la->date[i] = i;
//	}
//	lb->date = (int*)malloc(sizeof(int) * 3);
//	lb->num = 3;
//	for (i = 3; i < 6; i++)
//	{
//		lb->date[j] = i;
//		j++;
//	}
//}
//void Mergelist(List* la, List* lb,List*lc)
//{
//	int* pa = la->date;//指向第一个元素的指针
//	int* pb = lb->date;
//	int* pa_last = (la->date) + (la->num) - 1;//指向最后一个元素的指针
//	int* pb_last = (lb->date) + (lb->num) - 1;
//	int* pc;
//	lc->date = (int*)malloc(sizeof(int)*((la->num) + (lb->num)));//开辟新空间存储排序后的有序表
//	lc->num = (la->num) + (lb->num);
//	pc = lc->date;//指向新表第一个元素的指针
//	while (pa <= pa_last && pb <= pb_last)//依次选较大值放入新有序表中
//	{
//		if (*pa < *pb)
//		 *pc++ = *pa++;
//		else
//		 *pc++ = *pb++;
//	}
//	while (pa <= pa_last)//加入剩余元素
//		*pc++ = *pa++;
//	while (pb <= pb_last)
//		*pc++ = *pb++;
//}
//int main()
//{
//	List la = { 0 };
//	List lb = { 0 };
//	List lc = { 0 };//创建结构体来存储排序后的有序表
//	Initial(&la, &lb);//初始化成两个有序表
//	Mergelist(&la, &lb,&lc);//合并两个有序表
//	printf("%d", lc.date[6]);//合并后[6]为5
//	free(la.date);
//	free(lb.date);
//	free(lc.date);
//	return 0;
//}
//(单)链表有序表的合并
typedef struct link
{
	int date;
	struct link* next;
}link;
void Delectlist(link* l)
{
	link* p;
	while (l)
	{
		p = l->next;
		free(l);
		l = p;
	}
}
void Initial(link* la, link* lb)
{
	int i;
	la->next = NULL;
	lb->next = NULL;
	link* temp;
	link* p = la;
	for (i = 0; i < 4; i++)
	{
		temp = (link*)malloc(sizeof(link));
		temp->date = i;
		temp->next =NULL;
		p->next = temp;
		p = temp;
	}
	for (i = 5; i > 2; i--)
	{
		temp = (link*)malloc(sizeof(link));
		temp->date = i;
		temp->next = lb->next;
		lb->next = temp;
	}
}
void Mergelist(link* la, link* lb, link* *lc)
{
	link* pa = la->next;
	link* pb = lb->next;
	link* pc =*lc=la;
	while (pa&&pb)
	{
		if (pa->date < pb->date)
		{
			pc->next = pa;
			pc = pa;
			pa = pa->next;
		}
		else
		{
			pc->next = pb;
			pc = pb;
			pb = pb->next;
		}
	}
	pc->next = pa ? pa : pb;
	free(lb);//整个步骤等于是用lc将la和lb由小到大串起来最后释放一个其中链表的头结点 实际数据内存存储的位置不变
}
int main()
{
	link* la = (link*)malloc(sizeof(link));//开辟内存创建两个单链表的头指针
	link* lb = (link*)malloc(sizeof(link));
	link* lc = (link*)malloc(sizeof(link));//开辟内存创建一个存放合成链表的新表
	Initial(la, lb);//两个有序单链表的初始化
	Mergelist(la, lb, &lc);//和成链表
	printf("%d", lc->next->next->next->next->next->next->next->date);//第七个元素为5
	Delectlist(lc);
	return 0;
}

//2.8案例分析和实现
//多项式的运算
//稀疏多项式的运算
//图书管理系统