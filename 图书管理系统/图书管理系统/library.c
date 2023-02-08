#define _CRT_SECURE_NO_WARNINGS 1
#include"library.h"
void Capacitycheck(catalogue* list)
{
	if (list->capacity == list->number)
	{
		assert(list);
		book* str;
		if (!(str = (book*)realloc(list->arr, sizeof(book)*(list->capacity + START))))//容量不够，重新开辟
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
	list->number = 0;//初始图书信息数为0
	list->capacity = START;//初始目录容量为START
	list->arr = (book*)malloc(sizeof(book)*START);//开辟对应容量的内存
	//读取文件信息加载到内存
	if (!(cata = fopen("catalogue.txt", "rb")))
		perror("initial_list:");
	while (fread(&temp, sizeof(book), 1, cata))
	{
		Capacitycheck(list);//检测容量
		list->arr[list->number] = temp;//将读取的元素存入内存目录
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
	for (i = 0; i < list->number; i++)//每本书信息都以二进制的形式写入文件
		fwrite(&list->arr[i], sizeof(book), 1, cata);
	fclose(cata);
	cata = NULL;
	printf("保存成功 ");
}
void Add_list(catalogue* list)
{
	assert(list);
	Capacitycheck(list);
	printf("请输入信息：\n");
	printf("书名：");
	scanf("%s", list->arr[list->number].name);
	printf("书价：");
	scanf("%d", &list->arr[list->number].price);
	printf("id：");
	scanf("%s", list->arr[list->number].id);
	list->number++;
}
void Show_list(const catalogue* list)
{
	assert(list);
	int i;
	for (i = 0; i < list->number; i++)
	{
		printf("%d.书名：%-10s 书价：%-5d id：%-10s\n",
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
	printf("删除成功\n");
}
void Delect_list_order(catalogue* list)
{
	assert(list);
	int n;
	printf("请输入要删除数据的次序：(1~%d)", list->number);
	scanf("%d", &n);
	if (!(n < list->number &&n>0))
	{
		printf("输入错误");
		return;
	}
	Dele(n,list);
}
void Delect_list_name(catalogue* list)
{
	assert(list);
	int n;
	char temp[20] = { 0 };
	printf("请输入书名：");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			Dele(n+1, list);
			return;
		}
	}
	printf("未找到该数据\n");
	return;
}
void Delect_list_price(catalogue* list)
{
	assert(list);
	int n,price;
	printf("请输入书价：");
	scanf("%d",&price );
	for (n = 0; n < list->number; n++)
	{
		if (list->arr[n].price == price)
		{
			Dele(n + 1, list);
			return;
		}
	}
	printf("未找到该数据\n");
	return;
}
void Delect_list_id(catalogue* list)
{
	assert(list);
	int n;
	char temp[20] = { 0 };
	printf("请输入id：");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].id, temp))
		{
			Dele(n + 1, list);
			return;
		}
	}
	printf("未找到该数据\n");
	return;
}
void Delect_list(catalogue* list)
{
	assert(list);
	int i;
	if (list->number == 0)
	{
		printf("无数据\n");
		return;
	}
	printf("1.次序 2.书名 3.书价 4.id\n请输入删除依据：");
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
		printf("选择错误\n");
		return;
		break;
	}
	
}

void Search_list_name(catalogue* list)
{
	assert(list);
	int n ,i = 0;
	char temp[20] = { 0 };
	printf("请输入书名：");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			printf("书名：%-10s 书价：%-5d id：%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if(i == 0)
	printf("未找到该数据\n");
}
void Search_list_price(catalogue* list)
{
	assert(list);
	int n, i = 0;
	int j;
	printf("请输入书价：");
	scanf("%d", &j);
	for (n = 0; n < list->number; n++)
	{
		if (list->arr[n].price == j)
		{
			printf("书名：%-10s 书价：%-5d id：%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("未找到该数据\n");
}
void Search_list_id(catalogue* list)
{
	assert(list);
	int n, i = 0;
	char temp[20] = { 0 };
	printf("请输入id：");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].id, temp))
		{
			printf("书名：%-10s 书价：%-5d id：%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("未找到该数据\n");

}
void Search_list(catalogue* list)
{
	assert(list);
	int i;
	if (list->number == 0)
	{
		printf("无数据\n");
		return;
	}
	printf("1.书名 2.书价 3.id\n请输入查找依据：");
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
		printf("选择错误\n");
		return;
		break;
	}
}
void Modify_list(catalogue* list)
{

	assert(list);
	int n, i = 0;
	char temp[20] = { 0 };
	printf("请输入书名：");
	scanf("%s", temp);
	for (n = 0; n < list->number; n++)
	{
		if (!strcmp(list->arr[n].name, temp))
		{
			printf("现信息为：\n");
			printf("书名：%-10s 书价：%-5d id：%-10s\n",
				list->arr[n].name, list->arr[n].price, list->arr[n].id);
			printf("请输入要新修改的信息：\n");
			printf("书名：");
			scanf("%s", list->arr[n].name);
			printf("书价：");
			scanf("%d", &list->arr[n].price);
			printf("id：");
			scanf("%s", list->arr[n].id);
			i = 1;
		}
	}
	if (i == 0)
		printf("未找到该数据\n");
	else
		printf("修改完成\n");
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
	printf("1.书名 2.书价 3.id\n请选择排序依据：");
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
		printf("选择错误\n");
		break;
	}
	if (input == 1 || input == 2 || input == 3)
		printf("排序完成\n");
}