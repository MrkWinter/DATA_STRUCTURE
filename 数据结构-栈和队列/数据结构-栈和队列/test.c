#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//3.1ջ�Ͷ��еĶ�����ص�
//ջ�Ͷ��������ֳ��õģ���Ҫ�����ݽṹ
//ջ�Ͷ������޶������ɾ��ֻ���ڱ�Ķ˵���е����Ա�
//ջ�Ͷ��������Ա���Ӽ� �ǲ����ɾ��λ�����޵����Ա�
//ջ�Ĳ���ֻ���ڱ�β��ɾ��Ҳֻ���ڱ�β (����ȳ�)
//���еĲ���ֻ���ڱ�β,ɾ��ֻ���ڱ�ͷ (�Ƚ��ȳ�)

//3.1.1ջ�Ķ�����ص�stackջ
//ջΪ���Ա� ��ͷ��Ϊջ�� ��β��Ϊջ��
//����Ԫ�ص�ջ���Ĳ�����Ϊ��ջ(pushѹջ)
//ɾ��ջ��Ԫ�صĲ�����Ϊ��ջ(pop��ջ)
//�������Ϊ����ȳ� last in first out (LIFO�ṹ)
//ջ���ݴ洢�ṹ�ɷ�Ϊ˳��ջ����ջ

//3.1.2���еĶ�����ص�queue��
//����Ϊ���Ա� ��ͷ��Ϊ���� ��β��Ϊ��β
//����Ԫ�ص���β�Ĳ�����Ϊ���
//ɾ������Ԫ�صĲ�����Ϊ����
//�������Ϊ�Ƚ��ȳ� first in first out (FIFO�ṹ)
//���и��ݴ洢�ṹ�ɷ�Ϊ˳��Ӻ�����


//3.2��������
//ջ������
//1����ת�� 
//2����ƥ��ļ���
//3���ʽ��ֵ

//���е�����
//1�������


//3.3ջ�ı�ʾ�Ͳ���ʵ��
//3.3.1ջ�ĳ�����������
//ADT Stack{
//	
//	���ݶ���
//	D={ai| ai�� element, i = 1,2,3,...,n,n>0}
//	
//	���ݹ�ϵ��
//	R1 ={<ai-1,ai>|ai-1,ai�� D ,i= 2,...,n}
//    
//	������������ʼ�� ���� �ж�Ϊ��
//	�󳤶� ȡջ��Ԫ�� �ÿ� ��ջ ��ջ
//	��
//}ADT Stack

//3.3.2ջ��ʵ��
//������ topָ��ָ��ջ�� baseָ��ָ��ջ�� Stacksize ��ջ���������
//��ջ��� top== base
//��ջ top- base == Stacksize
//ջ����(overflow)����ջ�����������Ҫ��ջ һ�� ����
//ջ����(underflow)��Ԫ�ػ�Ҫ��ջ  һ�� ��Ϊһ�ֽ�������

//typedef struct sqstack
//{
//	int* base;//ջ��ָ��
//	int * top;//ջ��ָ��
//	int stacksize;//ջ�����������
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
//		perror("Initstack:");//����ʧ�ܷ��ش������
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
//		*s->top++ = i;//ÿ�δ洢һ��Ԫ�� topָ���һ
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
//	Initstack(&s);//˳��ջ�ĳ�ʼ������
//	Pushstack(&s);//˳��ջ��ѹջ
//	Printfstack(&s);//˳��ջ�Ĵ�ӡ
//	Popstack(&s, &a);//˳��ջ�ĳ�ջ
//	Destorystack(&s);//˳��ջ������
//	return 0;
//}
//3.3.3ջ���ı�ʾ��ʵ��
//�����ͷָ�����ջ�� ����Ҫͷ��� ��ջ�൱��ͷָ��ָ��� �����ɾ��ֻ��ջ������
//typedef struct elemtype
//{
//	int age;
//	char name[8];
//}elemtype;
//typedef struct stacknode
//{
//	elemtype date;//������
//	struct stacknode* next;//ָ����
//}stacknode;
//void Initstack(stacknode* S)
//{
//	S->next = NULL;//Ӧ����ͷָ��ֱ��ָ��NULL
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
//	stacknode S = { 0 };//����һ����ջ
//    Initstack(&S);//��ʼ����ջ
//	Pushstack(&S,&a);//��ջ
//	Popstack(&S, &a);//��ջ
//	return 0;
//}

//3.4ջ��ݹ�

//�ݹ麯��
//1.�ݹ鶨�����ѧ����
//2.���еݹ����Ե����ݽṹ
//3.�ɵݹ���������
//������n�Ľ׳�
//int longFalt(int a)
//{
//	if (a == 0)//������
//		return 1;
//	else//������
//		return a * longFalt(a - 1);
//}
//int main()
//{
//	//��4�Ľ׳�
//	printf("%d", longFalt(4));
//	return 0;
//}
//Ƕ�׺���������ѭ ������ȳ�
//�ݹ��ŵ� �ṹ���� �����Ѷ� ȱ�� ��ջ ��ջ ʱ�俪���� һ����Եݹ�תѭ��
//3.5���еı�ʾ�Ͳ���ʵ��

//3.5.1���еĳ�����������

//3.5.2˳����е�ʵ��(ѭ������)
//typedef struct student
//{
//	char name[8];
//	int age;
//}student;
//typedef struct queeue
//{
//	student* base;//�������Ԫ�ص���ʼָ��
//	int front;//������ʾ���� �±�
//	int rear;//������ʾ��β �±�
//	int max;//������
//}queeue;
//
////�ӿն��������⣨����һ��Ԫ�أ� �ӿ�ʱ front == rear ����ʱ front == (rear+1)%max 
//void Initqueeue(queeue *q1)
//{
//	if(!(q1->base = (student*)malloc(sizeof(queeue) * (q1->max = 5))))
//		perror("Init:error");
//	q1->front = q1->rear = 0;
//}
//int Longthqueeue(queeue* q1)//����г���
//{
//	return ((q1->rear) - (q1->front) + q1->max) % q1->max;
//}
//void Pushqueeue(queeue* q1, const student* s1)//ѭ��������Ӻ���
//{
//	if ((q1->rear + 1) % q1->max == q1->front)
//	{
//		printf("������");
//		return;
//	}
//	q1->base[q1->rear] = *s1;
//	q1->rear = (q1->rear+1) % q1->max;
//}
//void Popqueeue(queeue* q1, student* s1)//ѭ�����г��Ӻ���
//{
//	if (q1->rear == q1->front)
//	{
//		printf("���п�");
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
//	Initqueeue(&q1);//��ʼ������
//	Longthqueeue(&q1);//����г���
//	Pushqueeue(&q1,&s1);//ѭ��������Ӻ���
//	Popqueeue(&q1, &s1);//ѭ�����г��Ӻ���
//  Destroyqueeue(&q1);//���ٶ���
//
//}
//���е���ʽ��ʾ��ʵ��
//typedef struct student//�������ӽ���������
//{
//	char name[8];
//	int age;
//}student;
//typedef struct nodequeeue//�������ӽ��
//{
//	student date;
//	struct nodequeeue *next;
//}nodequeeue;
//typedef struct linkqueeue//�������ӵĶ���ָ��Ͷ�βָ��
//{
//	nodequeeue* front;
//	nodequeeue* rear;
//}linkqueeue;
//void Initlinqueeue(linkqueeue* q1)//���ӵĳ�ʼ��
//{
//	q1->front = q1->rear = (nodequeeue*)malloc(sizeof(nodequeeue));
//	q1->front->next = q1->rear->next = NULL;
//
//}
//void Destroylinqueeue(linkqueeue* q1)//���ӵ�����
//{
//	nodequeeue* temp;
//	while(q1->front != NULL)
//	{
//		temp = q1->front->next;
//		free(q1->front);
//		q1->front = temp;
//	}
//}
//void Pushlinqueeue(linkqueeue* q1, student* s1)//���ӵ����
//{
//	nodequeeue* temp;
//	if(!(temp = (nodequeeue*)sizeof(nodequeeue)))
//		perror("Pushlinqueeue:");
//	temp->date = *s1;
//	temp->next = NULL;
//	q1->rear->next = temp;
//	q1->rear = temp;
//}
//void Poplinqueeue(linkqueeue* q1, student* s1)//���ӵĳ���
//{
//	if (q1->front == q1->rear)
//		return;
//	nodequeeue* temp;
//	temp = q1->front->next;
//	*s1 = temp->date;
//	q1->front->next = temp->next;
//	if (temp == q1->rear)//��ֹrear��βָ��ָ�����һ��Ԫ�ص����ͷ� ָ��յĿռ�
//	{
//		q1->front = q1->rear;
//	}
//	free(temp);
//}
//int main()
//{
//    linkqueeue q1 = { 0 };
//	student s1 = { "xiao",19 };
//	Initlinqueeue(&q1);//���ӵĳ�ʼ��
//	Pushlinqueeue(&q1,&s1);//���ӵ����
//	Poplinqueeue(&q1, &s1);//���ӵĳ���
//	Destroylinqueeue(&q1);//���ӵ�����
//	return 0;
//}
//3.6����������ʵ��