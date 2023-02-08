#define _CRT_SECURE_NO_WARNINGS 1
#include"library.h"
void Capacitycheck(catalogue* list)
{
	if (list->capacity == list->number)
	{
		assert(list);
		book* str;
		if (!(str = (book*)realloc(list->arr, sizeof(book)*(list->capacity + START))))//�������������¿���
			perror("Capacitycheck:");
		list->arr = str;
		str = NULL;
		list->capacity += START;
	}
}
void Initial_list(catalogue* list)
{
	assert(list);
	book temp;
	FILE* cata;
	list->number = 0;//��ʼͼ����Ϣ��Ϊ0
	list->capacity = START;//��ʼĿ¼����ΪSTART
	list->arr = (book*)malloc(sizeof(book)*START);//���ٶ�Ӧ�������ڴ�
	//��ȡ�ļ���Ϣ���ص��ڴ�
	if (!(cata = fopen("catalogue.txt", "rb")))
		perror("initial_list:");
	while (fread(&temp, sizeof(book), 1, cata))
	{
		Capacitycheck(list);//�������
		list->arr[list->number] = temp;//����ȡ��Ԫ�ش����ڴ�Ŀ¼
		list->number++;
	}
	fclose(cata);
	cata = NULL;
}
void Save_list(catalogue* list)
{
	assert(list);
	int i = 0;
	FILE* cata = fopen("catalogue.txt", "wb");
	for (i = 0; i < list->number; i++)//ÿ������Ϣ���Զ����Ƶ���ʽд���ļ�
		fwrite(&list->arr[i], sizeof(book), 1, cata);
	fclose(cata);
	cata = NULL;
	printf("����ɹ� ");
}
void Add_list(catalogue* list)
{
	assert(list);
	Capacitycheck(list);
	printf("��������Ϣ��\n");
	printf("������");
	scanf("%s", list->arr[list->number].name);
	printf("��ۣ�");
	scanf("%d", &list->arr[list->number].price);
	printf("id��");
	scanf("%s", list->arr[list->number].id);
	list->number++;
}
void Show_list(const catalogue* list)
{
	assert(list);
	int i;
	for (i = 0; i < list->number; i++)
	{
		printf("%d.������%-10s ��ۣ�%-5d id��%-10s\n",
			i+1,list->arr[i].name, list->arr[i].price, list->arr[i].id);
	}
}
void Dele(int n, catalogue* list)
{
	assert(list);
	int i;
	for (i = n-1; i < list->number; i++)
	{
		list->arr[i] = list->arr[i + 1];
	}
	list->number--;
	printf("ɾ���ɹ�\n");
}
void Delect_list_order(catalogue* list)
{
	assert(list);
	int n;
	printf("������Ҫɾ�����ݵĴ���(1~%d)", list->number);
	scanf("%d", &n);
	if (!(n < list->number &&n>0))
	{
		printf("�������");
		return;
	}
	Dele(n,list);
}
void Delect_list_name(catalogue* list)
{
	assert(list);
	int n;
	char temp[20] = { 0 };
	printf("������������");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			Dele(n+1, list);
			return;
		}
	}
	printf("δ�ҵ�������\n");
	return;
}
void Delect_list_price(catalogue* list)
{
	assert(list);
	int n,price;
	printf("��������ۣ�");
	scanf("%d",&price );
	for (n = 0; n < list->number; n++)
	{
		if (list->arr[n].price == price)
		{
			Dele(n + 1, list);
			return;
		}
	}
	printf("δ�ҵ�������\n");
	return;
}
void Delect_list_id(catalogue* list)
{
	assert(list);
	int n;
	char temp[20] = { 0 };
	printf("������id��");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].id, temp))
		{
			Dele(n + 1, list);
			return;
		}
	}
	printf("δ�ҵ�������\n");
	return;
}
void Delect_list(catalogue* list)
{
	assert(list);
	int i;
	if (list->number == 0)
	{
		printf("������\n");
		return;
	}
	printf("1.���� 2.���� 3.��� 4.id\n������ɾ�����ݣ�");
	scanf("%d", &i);
	switch (i)
	{
	case 1:
		Delect_list_order(list);
		break;
	case 2:
		Delect_list_name(list);
		break;
	case 3:
		Delect_list_price(list);
		break;
	case 4:
		Delect_list_id(list);
		break;
	default:
		printf("ѡ�����\n");
		return;
		break;
	}
	
}

void Search_list_name(catalogue* list)
{
	assert(list);
	int n ,i = 0;
	char temp[20] = { 0 };
	printf("������������");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			printf("������%-10s ��ۣ�%-5d id��%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if(i == 0)
	printf("δ�ҵ�������\n");
}
void Search_list_price(catalogue* list)
{
	assert(list);
	int n, i = 0;
	int j;
	printf("��������ۣ�");
	scanf("%d", &j);
	for (n = 0; n < list->number; n++)
	{
		if (list->arr[n].price == j)
		{
			printf("������%-10s ��ۣ�%-5d id��%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("δ�ҵ�������\n");
}
void Search_list_id(catalogue* list)
{
	assert(list);
	int n, i = 0;
	char temp[20] = { 0 };
	printf("������id��");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].id, temp))
		{
			printf("������%-10s ��ۣ�%-5d id��%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("δ�ҵ�������\n");

}
void Search_list(catalogue* list)
{
	assert(list);
	int i;
	if (list->number == 0)
	{
		printf("������\n");
		return;
	}
	printf("1.���� 2.��� 3.id\n������������ݣ�");
	scanf("%d", &i);
	switch (i)
	{
	case 1:
		Search_list_name(list);
		break;
	case 2:
		Search_list_price(list);
		break;
	case 3:
		Search_list_id(list);
		break;
	default:
		printf("ѡ�����\n");
		return;
		break;
	}
}
void Modify_list(catalogue* list)
{

	assert(list);
	int n, i = 0;
	char temp[20] = { 0 };
	printf("������������");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			printf("����ϢΪ��\n");
			printf("������%-10s ��ۣ�%-5d id��%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			printf("������Ҫ���޸ĵ���Ϣ��\n");
			printf("������");
			scanf("%s", list->arr[n].name);
			printf("��ۣ�");
			scanf("%d", &list->arr[n].price);
			printf("id��");
			scanf("%s", list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("δ�ҵ�������\n");
	else
		printf("�޸����\n");
}
int strsort(const void* e1, const void* e2)
{
	return strcmp((char*)e1, (char*)e2);
}
int pricesort(const void* e1,const void* e2)
{
	return *(int*)e1 - *(int*)e2;
}
void swap(char* e1, char* e2, int width)
{
	int i;
	char temp;
	for (i = 0; i < width; i++)
	{
		temp = *e1;
		*e1++ = *e2;
		*e2++ = temp;
	}
	
}
void* my_qsort(void* base, size_t num, size_t width, int(*cmp)(const void*, const void*),const void* based)
{

	int i, j;
	void* ret = base;
	for (i = 0; i < (int)num - 1; i++)
	{
		for (j = 0; j < (int)num - i - 1; j++)
		{
			if(cmp((char*)base+(width)*j,(char*)base+(width)*(j+1))>0)
				swap((char*)based + (width)*j, (char*)based + (width)*(j + 1),width);
		}
	}
	return ret;
}
void Sort_list(catalogue* list)
{
	int input;
	int(*arr[2])(const void*, const void*) = { strsort,pricesort };
	printf("1.���� 2.��� 3.id\n��ѡ���������ݣ�");
	scanf("%d", &input);
	switch (input)
	{
	case 1:
		my_qsort((void*)list->arr[0].name,list->number, sizeof(book), arr[0], (void*)list->arr[0].name);
		break;
	case 2:
		my_qsort((void*)(&list->arr[0].price),list->number, sizeof(book), arr[1], (void*)list->arr[0].name);
		break;
	case 3:
        my_qsort((void*)(list->arr[0].id),list->number, sizeof(book), arr[0], (void*)list->arr[0].name);
		break;
	default:
		printf("ѡ�����\n");
		break;
	}
	if (input == 1 || input == 2 || input == 3)
		printf("�������\n");
}