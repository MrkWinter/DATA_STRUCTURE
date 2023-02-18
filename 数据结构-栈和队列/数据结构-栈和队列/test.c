#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//3.1栈和队列的定义和特点
//栈和队列是两种常用的，重要的数据结构
//栈和队列是限定插入和删除只能在表的端点进行的线性表
//栈和队列是线性表的子集 是插入和删除位置受限的线性表
//栈的插入只能在表尾，删除也只能在表尾 (后进先出)
//队列的插入只能在表尾,删除只能在表头 (先进先出)

//3.1.1栈的定义和特点stack栈
//栈为线性表 表头称为栈底 表尾称为栈顶
//插入元素到栈顶的操作称为入栈(push压栈)
//删除栈顶元素的操作称为出栈(pop弹栈)
//运算规则为后进先出 last in first out (LIFO结构)
//栈根据存储结构可分为顺序栈和链栈

//3.1.2队列的定义和特点queue队
//队列为线性表 表头称为队首 表尾称为队尾
//插入元素到队尾的操作称为入队
//删除对首元素的操作成为出队
//运算规则为先进先出 first in first out (FIFO结构)
//队列根据存储结构可分为顺序队和链队


//3.2案例引入
//栈的运用
//1进制转换 
//2括号匹配的检验
//3表达式求值

//队列的运用
//1舞伴问题


//3.3栈的表示和操作实现
//3.3.1栈的抽象数据类型
//ADT Stack{
//	
//	数据对象：
//	D={ai| ai《 element, i = 1,2,3,...,n,n>0}
//	
//	数据关系：
//	R1 ={<ai-1,ai>|ai-1,ai《 D ,i= 2,...,n}
//    
//	基本操作：初始化 销毁 判断为空
//	求长度 取栈顶元素 置空 入栈 出栈
//	等
//}ADT Stack

//3.3.2栈的实现
//用数组 top指针指向栈顶 base指针指向栈底 Stacksize 表栈的最大容量
//空栈情况 top== base
//满栈 top- base == Stacksize
//栈上溢(overflow)超过栈的最大容量还要入栈 一般 报错
//栈下溢(underflow)无元素还要出栈  一般 作为一种结束条件

//typedef struct sqstack
//{
//	int* base;//栈底指针
//	int * top;//栈顶指针
//	int stacksize;//栈可用最大容量
//}sqstack;
//void Destorystack(sqstack* s)
//{
//	free(s->base);
//	s->base = NULL;
//	s->top = NULL;
//	s->stacksize = 0;
//}
//void Initstack(sqstack* s)
//{
//	if (!(s->base = s->top = (int*)malloc(sizeof(int) * 5)))
//		perror("Initstack:");//分配失败返回错误代码
//	s->stacksize = 5;
//}
//void Pushstack(sqstack* s)
//{
//	int i;
//	for (i = 0; i < 6; i++)
//	{
//		if ((s->top) - (s->base) == s->stacksize)
//		{
//			printf("error:"); return;
//		}
//		*s->top++ = i;//每次存储一个元素 top指针加一
//	}
//}
//Printfstack(sqstack* s)
//{
//	int i;
//	for (i = 0; i < s->top - s->base; i++)
//	{
//		printf("%d", *(s->base + i));
//	}
//}
//void Popstack(sqstack* s, int* a)
//{
//	if (s->base == s->top)
//		return;
//	*a = *--s->top;
//}
//int main()
//{
//	int a;
//	sqstack s = { 0 };
//	Initstack(&s);//顺序栈的初始化函数
//	Pushstack(&s);//顺序栈的压栈
//	Printfstack(&s);//顺序栈的打印
//	Popstack(&s, &a);//顺序栈的出栈
//	Destorystack(&s);//顺序栈的销毁
//	return 0;
//}
//3.3.3栈链的表示和实现
//链表的头指针就是栈顶 不需要头结点 空栈相当于头指针指向空 插入和删除只在栈顶进行
//typedef struct elemtype
//{
//	int age;
//	char name[8];
//}elemtype;
//typedef struct stacknode
//{
//	elemtype date;//数据域
//	struct stacknode* next;//指针域
//}stacknode;
//void Initstack(stacknode* S)
//{
//	S->next = NULL;//应该是头指针直接指向NULL
//}
//void Pushstack(stacknode* S, elemtype* a)
//{
//	stacknode* p;
//	S->date = *a;
//	p = (stacknode*)malloc(sizeof(stacknode));
//	p->next = S;
//	p->date = *a;
//	S = p;
//}
//void Popstack(stacknode* S, elemtype* a)
//{
//	if (S == NULL)
//		return;
//	stacknode* p;
//	*a = S->date;
//	p = S;
//	S = S->next;
//	free(p);
//	
//}
//int main()
//{
//	elemtype a = { 13,"wangwei" };
//	stacknode S = { 0 };//定义一个链栈
//    Initstack(&S);//初始化链栈
//	Pushstack(&S,&a);//入栈
//	Popstack(&S, &a);//出栈
//	return 0;
//}

//3.4栈与递归

//递归函数
//1.递归定义的数学函数
//2.具有递归特性的数据结构
//3.可递归求解的问题
//例：求n的阶乘
//int longFalt(int a)
//{
//	if (a == 0)//基本项
//		return 1;
//	else//归纳项
//		return a * longFalt(a - 1);
//}
//int main()
//{
//	//求4的阶乘
//	printf("%d", longFalt(4));
//	return 0;
//}
//嵌套函数调用遵循 后调用先出
//递归优点 结构清晰 程序已读 缺点 入栈 出栈 时间开销大 一般可以递归转循环
//3.5队列的表示和操作实现

//3.5.1队列的抽象数据类型

//3.5.2顺序队列的实现(循环队列)
//typedef struct student
//{
//	char name[8];
//	int age;
//}student;
//typedef struct queeue
//{
//	student* base;//存放数据元素的起始指针
//	int front;//整数表示队首 下标
//	int rear;//整数表示队尾 下标
//	int max;//最大队列
//}queeue;
//
////队空队满的问题（少用一个元素） 队空时 front == rear 队满时 front == (rear+1)%max 
//void Initqueeue(queeue *q1)
//{
//	if(!(q1->base = (student*)malloc(sizeof(queeue) * (q1->max = 5))))
//		perror("Init:error");
//	q1->front = q1->rear = 0;
//}
//int Longthqueeue(queeue* q1)//求队列长度
//{
//	return ((q1->rear) - (q1->front) + q1->max) % q1->max;
//}
//void Pushqueeue(queeue* q1, const student* s1)//循环队列入队函数
//{
//	if ((q1->rear + 1) % q1->max == q1->front)
//	{
//		printf("队列满");
//		return;
//	}
//	q1->base[q1->rear] = *s1;
//	q1->rear = (q1->rear+1) % q1->max;
//}
//void Popqueeue(queeue* q1, student* s1)//循环队列出队函数
//{
//	if (q1->rear == q1->front)
//	{
//		printf("队列空");
//		return;
//	}
//	*s1 = q1->base[q1->front];
//	q1->front = (q1->front + 1) % q1->max;
//}
//void Destroy(queeue* q1)
//{
//	free(q1->base);
//	q1->base = NULL;
//}
//int main()
//{
//	queeue q1 = { 0 };
//	student s1 = { "lihuan",18 };
//	Initqueeue(&q1);//初始化队列
//	Longthqueeue(&q1);//求队列长度
//	Pushqueeue(&q1,&s1);//循环队列入队函数
//	Popqueeue(&q1, &s1);//循环队列出队函数
//  Destroyqueeue(&q1);//销毁队列
//
//}
//队列的链式表示和实现
//typedef struct student//定义链队结点的数据域
//{
//	char name[8];
//	int age;
//}student;
//typedef struct nodequeeue//定义链队结点
//{
//	student date;
//	struct nodequeeue *next;
//}nodequeeue;
//typedef struct linkqueeue//定义链队的队首指针和队尾指针
//{
//	nodequeeue* front;
//	nodequeeue* rear;
//}linkqueeue;
//void Initlinqueeue(linkqueeue* q1)//链队的初始化
//{
//	q1->front = q1->rear = (nodequeeue*)malloc(sizeof(nodequeeue));
//	q1->front->next = q1->rear->next = NULL;
//
//}
//void Destroylinqueeue(linkqueeue* q1)//链队的销毁
//{
//	nodequeeue* temp;
//	while(q1->front != NULL)
//	{
//		temp = q1->front->next;
//		free(q1->front);
//		q1->front = temp;
//	}
//}
//void Pushlinqueeue(linkqueeue* q1, student* s1)//链队的入队
//{
//	nodequeeue* temp;
//	if(!(temp = (nodequeeue*)sizeof(nodequeeue)))
//		perror("Pushlinqueeue:");
//	temp->date = *s1;
//	temp->next = NULL;
//	q1->rear->next = temp;
//	q1->rear = temp;
//}
//void Poplinqueeue(linkqueeue* q1, student* s1)//链队的出队
//{
//	if (q1->front == q1->rear)
//		return;
//	nodequeeue* temp;
//	temp = q1->front->next;
//	*s1 = temp->date;
//	q1->front->next = temp->next;
//	if (temp == q1->rear)//防止rear队尾指针指向最后一个元素但被释放 指向空的空间
//	{
//		q1->front = q1->rear;
//	}
//	free(temp);
//}
//int main()
//{
//    linkqueeue q1 = { 0 };
//	student s1 = { "xiao",19 };
//	Initlinqueeue(&q1);//链队的初始化
//	Pushlinqueeue(&q1,&s1);//链队的入队
//	Poplinqueeue(&q1, &s1);//链队的出队
//	Destroylinqueeue(&q1);//链队的销毁
//	return 0;
//}
//3.6案例分析和实现