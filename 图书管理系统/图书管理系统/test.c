#define _CRT_SECURE_NO_WARNINGS 1
#include"library.h"
void menu()
{
	printf("******************************\n");
	printf("**** 1.Add    |  2.Delect ****\n");
	printf("**** 3.Search |  4.Modify ****\n");
	printf("**** 5.Show   |  6.Sort   ****\n");
	printf("**** 7.Save   |  0.Exit   ****\n");
	printf("******************************\n");
}
int main()
{
	int input;
	catalogue list = { 0 };//创建一个图书目录
	Initial_list(&list);//初始化图书目录
	do
	{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case Add:
			Add_list(&list);//增添信息到图书目录
			break;
		case Delect:
			Delect_list(&list);//删除图书目录信息
			break;
		case Search:
			Search_list(&list);//查找图书信息
			break;
		case Modify:
			Modify_list(&list);//修改图书信息
			break;
		case Show:
			Show_list(&list);//展示图书信息
			break;
		case Sort:
			Sort_list(&list);//排序图书信息
			break;
		case Save:
			Save_list(&list);//保存图书目录信息
			break;
		case Exit:
			break;
		default:
			printf("选择错误\n");
			break;
		}
		if (input)
		{
			printf("按任意键返回");
			getchar(); getchar();
			system("cls");
		}

	} while (input);
	free(list.arr);//释放内存
	return 0;
}