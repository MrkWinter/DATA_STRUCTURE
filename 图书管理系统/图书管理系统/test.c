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
	catalogue list = { 0 };//����һ��ͼ��Ŀ¼
	Initial_list(&list);//��ʼ��ͼ��Ŀ¼
	do
	{
		menu();
		scanf("%d", &input);
		switch (input)
		{
		case Add:
			Add_list(&list);//������Ϣ��ͼ��Ŀ¼
			break;
		case Delect:
			Delect_list(&list);//ɾ��ͼ��Ŀ¼��Ϣ
			break;
		case Search:
			Search_list(&list);//����ͼ����Ϣ
			break;
		case Modify:
			Modify_list(&list);//�޸�ͼ����Ϣ
			break;
		case Show:
			Show_list(&list);//չʾͼ����Ϣ
			break;
		case Sort:
			Sort_list(&list);//����ͼ����Ϣ
			break;
		case Save:
			Save_list(&list);//����ͼ��Ŀ¼��Ϣ
			break;
		case Exit:
			break;
		default:
			printf("ѡ�����\n");
			break;
		}
		if (input)
		{
			printf("�����������");
			getchar(); getchar();
			system("cls");
		}

	} while (input);
	free(list.arr);//�ͷ��ڴ�
	return 0;
}