#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
//2.1���Ա�Ķ����ʹ��
//���Ա��Ǿ�����ͬ���Ե�����Ԫ�ص�һ����������
//���Ա�����һ���������(��ʼ���)��һ�������յ�(�ն˽��)
//����ʼ�����ն˽����ÿ������Ԫ��(�ڲ����)����һ��ֱ��ǰ����һ��ֱ�Ӻ��
//ÿ������Ԫ�ض���һ���±� ���һ������Ԫ���±�Ϊn nΪԪ�ظ��� n=0 ʱ����Ϊ�ձ�
//���Ա���һ�ֵ��͵����Խṹ


//2.2��������
//2.2.1һԪ����ʽ������
//2.2.2ϡ�����ʽ������
//2.2.3ͼ����Ϣ����ϵͳ


//2.3���Ա�����Ͷ���
//ADT list{
//
//	���ݶ��� D={a_i |a <- elemset����i=1,2,3,4...��}
//
//	���ݹ�ϵ�� R={<a_i-1,a_i>|a_i-1,a_i����D��i = 1,2,3,4...��}
//
//	����������
//
//}ADT list
//����������
//����յ����Ա� �ݻ����Ա� ��ʼ�����Ա� ����Ƿ�Ϊ�ձ� �������Ա�������Ԫ�ظ��� �������Ա��е�i������Ԫ�� ��λ���Ա���ĳ������Ԫ�� 
//����һ������Ԫ�ص�ǰ�� ����һ������Ԫ�صĺ�� ��λ��i������һ������Ԫ�� ɾ��λ��i��������Ԫ�� �����������Ա�����Ԫ�ص�


//2.4���Ա��˳���ʾ��ʵ��
//2.4.1���Ա��˳��洢��ʾ (˳��洢�ṹ/˳��ӳ��)
//˳��洢�ṹ �� ���߼������ڵ�����Ԫ�ش洢�����������ڵĴ洢��Ԫ�еĴ洢˳��
//���ʵ�ִ洢�ṹ ��ͼ�����ϵͳΪ��
//typedef struct book
//{
//	char name[20];
//	char date[10];
//	int day;
//}book;
//struct lirary
//{
//	book* arr;//���鶯̬���� book arr[] ���鶯̬����
//	int length;
//};
//����һ���ṹ�� Ԫ�ذ���һ���ṹ��ָ������ ������һ��ͳ��ʹ�����鴢������Ԫ�ص����� ��ʾ���Ա�ĳ�������
//�Ӷ�ʵ�ְ����Ա�洢�ڽṹ��������(ʹ�ö����ڴ��Լ�����) 
//����ʵ�����Ա�洢������ ��ַ���� ���δ�� �����ȡ ������ͬ ���Ա��ȿɱ�
//�������״̬����
#define TRUE 1
#define FALSE 0
#define OK 1
#define ERROR 0
#define INFEASIBLE -1
#define OVERFLOW -2
//Status �Ǻ��������� ��ֵ�Ǻ��������״̬����
typedef int Status;
typedef char ElemType;
//���Ա����ʵ��
// 1 ��ʼ�����Ա�
//Status InitList_Sq(Sqlist &L) //���Ա��ʼ������InitList_Sq Ϊ������ Sqlist &L Ϊc++�нṹ�崫�ε�����
//{
//	L.elem = new ElemType[MAXSIZE];//new ElemType[MAXSIZE] newΪc++�ж�̬�ڴ濪�ٺ��� ͬ malloc ElemTypeΪ����
//	if (!L.elem) exit(OVERDLOW); //�����ڴ�ʧ�ܷ���NULL������ ͬstrerror(errno);
//	L.Length = 0;
//	return OK;
//}
//2 ˳������ �㷨�� ˳����ҷ�(����)  ƽ�����ҳ��� ���� 
//3 ˳������        ������Ԫ������ƶ�
//4 ˳���ɾ��        ������Ԫ����ǰ�ƶ�


//2.5���Ա����ʽ��ʾ��ʵ��

//2.5.1������� 
//ÿ������Ԫ�صĴ洢ӳ���Ϊ��� ����Ϊ�������ָ���� ������洢���� ָ����洢��һ������ָ��
//n�������ָ�������һ������ �������Ա����ʽ����ӳ�� ��Ϊ���Ա����ʽ�洢�ṹ
//�����Ϊ������ ˫���� ��ѭ������
//��Ԫ��� ��ָ�����д洢��һ������Ԫ�صĽ��
//ͷ��� �����������Ԫ���֮ǰ�����һ�����
//ͷ����ָ�뱻��Ϊͷָ��
//��ͷ���������ж��Ƿ�Ϊ�ձ� ͷ����ָ�����Ƿ�Ϊ��
//ͷ���ĺô� 
//1ʹ����Ԫ�صĴ���һ�� �������⴦�� 
//2�ձ�ͷǿձ��ͳһ����
//˳��������
//˳���Ĵ洢��ʽΪ˳��洢 �����ȡ
//����Ĵ洢��ʽΪ��˳��洢 ˳���ȡ

//2.5.2��(��)����Ķ���ͱ�ʾ
//typedef struct
//{//������Ķ���
//	int age;
//	char name[10];
//	int score;
//}elemtype;
//typedef struct lnode
//{//���Ķ���
//	elemtype date;//������
//	struct lnode * next;//ָ����
//}lnode,*linklist;//linklistΪ�ṹ��ָ������ == lnode* || struct londe *

////1.������ĳ�ʼ��(�ձ�)
//void Initlist_L(linklist L)
//{
//	L = (lnode*)malloc(sizeof(lnode));
//	L->next = NULL;
//}
//
////2.�����������
//void Delectlist_L(lnode *L)
//{
//	lnode* p;
//	while (L)//�������ٽ��
//	{
//		p = L->next;
//		free(L);
//		L = p;
//	}                                                                                                                                                     
//}
//
////3.����������
//void Clearlist_L(lnode* L)
//{
//	lnode* p= L->next;
//	lnode* d;
//	while (p)//�ظ����ٲ���
//	{
//		d = p->next;
//		free(p);
//		p = d;
//	}
//	L->next = NULL;
//}
//
////�����������
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
////�õ���������Ԫ��
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
////���ҵ�������Ԫ��
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
////���뵥����������
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
//		lnode* s = (lnode*)malloc(sizeof(lnode));//�����µĽ��
//		s->date = *s3;
//		s->next = p->next;
//		p->next = s;
//	}
//}
//
////ɾ����������Ԫ�غ���
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
//		*s4 = temp->date;//�������������
//		free(temp);//�ͷ��ڴ�
//		temp = NULL;
//	}
//}
////ͷ�巨��������
//void Createlist_H(lnode* L, int n )
//{//����ɳ�ʼ�������ձ�
// //Ŀ��Ϊ����������������
//	int i;
//	elemtype s = {0};
//	lnode* p;
//	for (i = 0; i < n; i++)
//	{
//		printf("�������������ݣ�(���䣬����������)\n");
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
////β�巨����������
//Createlist_T(lnode* L, int n)
//{
//	int i;
//	elemtype s = { 0 };
//	lnode* r = L;
//	lnode* p;
//	for (i = 0; i < n; i++)
//	{
//		printf("�������������ݣ�(���䣬����������)\n");
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
//	lnode L = {0};//�����ṹ�����
//	Initlist_L(&L);//�������ʼ������
//	Createlist_H(&L,3);//ͷ�巨����������
//	Clearlist_L(&L);//��յ�������
//	Createlist_T(&L, 3);//β�巨����������
//	//Delectlist_L(&L);//����������ٺ���
//	Clearlist_L(&L);//��յ�������
//	Lengthlist_L(&L);//�����������
//	elemtype s1;//���巵��Ԫ��
//	Getelemlist_L(&L,5,&s1);//�õ���������Ԫ�غ���(��������)
//	elemtype s2;//���巵��Ԫ��
//	Searchlist_L(&L, 30, &s2);//���ҵ�������Ԫ�غ���(���������)
//	elemtype s3 = {12,"ailixiya",100};//�������Ԫ��
//	Instertlist_L(&L, 3, &s3);//���뵥���������ݺ���(�ڶ�������)
//	elemtype s4;//���巵�ر�����ɾ��Ԫ��
//	Removelist_L(&L, 3,&s4);//ɾ����������Ԫ�غ���(ɾ�����������)
//
//	return 0;
//}

//5.2.3����ѭ������
//ͷβ���������� �������һ������ָ����ָ��ͷ���
//�ӱ�������һ����������ҵ������������
//��βָ���ѭ�����������(βָ��ָ����ָ�����һ������ָ��)

//����βָ���ѭ������ϲ�(tb(β���) �ӵ� ta(β���) ��)
//1����ָ��p=ta->next 2�޸�ta->next = tb->next->next 3�ͷ�free(tb->next) 4�޸�tb->next = p

//��βָ���ѭ������ϲ�����
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
//	Connectlist(a.next,b.next);//��βָ���ѭ������ϲ�����
//	return 0;
//}

//5.2.4˫������Ķ����ʵ��   
//typedef struct dlnode
//{
//	elemtype date;
//	struct dlnode* prior, *next;
//}dlnode,*dlinklist;
//
//dlnode* Getelemp(dlnode* L, int n)//���������е�n��Ԫ��(���ص�ַ)
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
////˫���������Ԫ�غ���
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
////˫������ɾ������
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
//	elemtype s1 = { 16,"hutao",100 };//������뺯��
//	Insertlist(&L, 3, &s1);//˫���������Ԫ�غ���
//	elemtype s2;//Ҫ���ص�ɾ��Ԫ��
//	Delectlist(&L, 3, &s2);//˫������ɾ������
//	return 0;
//}
//˫��ѭ������(��)


//2.6˳��������ıȽ� 
//��ʽ�洢�ṹ���ŵ㣺
//���ռ���Զ�̬������ͷ�
//�����ɾ����������Ҫ�ƶ������Ԫ��
//��ʽ�洢�ṹ��ȱ�㣺
//�洢�ܶ�С��ÿ�������Ҫָ����ռ�ø���Ŀռ�
//������洢�ṹ�����������������Ҫ��ͷָ���������ҵ��ý�㣬�������㷨�ĸ��Ӷ�
//
//�ռ�Ч���� 
//{
//	�洢�ܶ� ˳���>����
//	�洢�ռ俪��ʹ�� ����>˳���
//}
//ʱ��Ч����
//{
//	��ȡԪ�� ˳���>����
//	����ɾ�� ����>˳���
//}

//2.7���Ա��Ӧ��  
//2.7.1���Ա�ĺϲ�
//��˳���Ϊ��
//typedef struct score1
//{
//	int* score;
//	int order;
//}score1;
//typedef struct score2  //???ɾ��һ���ṹ��
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
//	int la_len = la->order;//���
//	int lb_len = lb->order;
//	for (i = 0; i <=lb_len; i++)
//	{
//		if (ifgetla((lb->score)[i], la))//�ж��Ƿ���la�к���Ԫ��(lb->score)[i]��������la�����
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
//	Inist(&s1,&s2);//��ʼ������˳���
//	union_L(&s1, &s2);//�ϲ�����˳���
//	printf("%d", (s1.score)[6]);//�ϲ�����߸�Ԫ��Ϊ6
//	free(s1.score);
//	free(s2.score);
//	return 0;
//}

//2.7.2�����ĺϲ�
//˳��������ĺϲ�
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
//	int* pa = la->date;//ָ���һ��Ԫ�ص�ָ��
//	int* pb = lb->date;
//	int* pa_last = (la->date) + (la->num) - 1;//ָ�����һ��Ԫ�ص�ָ��
//	int* pb_last = (lb->date) + (lb->num) - 1;
//	int* pc;
//	lc->date = (int*)malloc(sizeof(int)*((la->num) + (lb->num)));//�����¿ռ�洢�����������
//	lc->num = (la->num) + (lb->num);
//	pc = lc->date;//ָ���±��һ��Ԫ�ص�ָ��
//	while (pa <= pa_last && pb <= pb_last)//����ѡ�ϴ�ֵ�������������
//	{
//		if (*pa < *pb)
//		 *pc++ = *pa++;
//		else
//		 *pc++ = *pb++;
//	}
//	while (pa <= pa_last)//����ʣ��Ԫ��
//		*pc++ = *pa++;
//	while (pb <= pb_last)
//		*pc++ = *pb++;
//}
//int main()
//{
//	List la = { 0 };
//	List lb = { 0 };
//	List lc = { 0 };//�����ṹ�����洢�����������
//	Initial(&la, &lb);//��ʼ�������������
//	Mergelist(&la, &lb,&lc);//�ϲ����������
//	printf("%d", lc.date[6]);//�ϲ���[6]Ϊ5
//	free(la.date);
//	free(lb.date);
//	free(lc.date);
//	return 0;
//}
//(��)���������ĺϲ�
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
	free(lb);//���������������lc��la��lb��С������������ͷ�һ�����������ͷ��� ʵ�������ڴ�洢��λ�ò���
}
int main()
{
	link* la = (link*)malloc(sizeof(link));//�����ڴ洴�������������ͷָ��
	link* lb = (link*)malloc(sizeof(link));
	link* lc = (link*)malloc(sizeof(link));//�����ڴ洴��һ����źϳ�������±�
	Initial(la, lb);//������������ĳ�ʼ��
	Mergelist(la, lb, &lc);//�ͳ�����
	printf("%d", lc->next->next->next->next->next->next->next->date);//���߸�Ԫ��Ϊ5
	Delectlist(lc);
	return 0;
}

//2.8����������ʵ��
//����ʽ������
//ϡ�����ʽ������
//ͼ�����ϵͳ