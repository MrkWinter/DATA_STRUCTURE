#define _CRT_SECURE_NO_WARNINGS 1
#include"complex.h"
//1.���ݽṹ���о�����
//�������� ���Խṹ ���νṹ  �� �� ͼ
//���ݽṹ��һ���о�����ֵ����ĳ�������в��������Լ�����֮��Ĺ�ϵ�Ͳ�����ѧ��


//2.�������������
//1.2.1
//1)���� ���������������ܱ�����������ĸ��ַ��ŵļ��� ������ֵ���͵����ݺͷ���ֵ���͵�����
//  ����Ԫ�� �����ݵĻ�����λ���ڼ������ͨ����Ϊһ��������п��Ǻʹ��� Ҳ��Ԫ�أ���¼���ڵ�򶨵�
//  ������  ��������Ԫ�ز��ɷָ����С��λ
//  ���ݶ��� ������ͬ������Ԫ�صļ��� �����ݵ�һ���Ӽ�
//  �� ����Ԫ�������ݵ�Ԫ�� ���ݶ��������ݵ�һ���Ӽ� ������������Ԫ�ص��Ӽ�
//  �����������Ԫ�� ����Ԫ�ع�������  ���ݶ�����������ͬ������Ԫ�ع���
//1.2.2
//1)���ݽṹ ����Ԫ�ز��ǹ������ڵ� ����֮�����ĳ�ֹ�ϵ ����Ԫ���໥֮��Ĺ�ϵ��Ϊ�ṹ
//  ��ָ�໥֮�����һ�ֻ�����ض���ϵ������Ԫ�ؼ���
//  ���ݽṹ�Ǵ��ṹ������Ԫ�صļ���
//  ���ݶ����������Ԫ��֮��Ĺ�ϵ �������ݽṹ
//2)���ݽṹ�������������������
//  �߼��ṹ  �洢�ṹ���߼���ϵ��ӳ����Ԫ�ر�����ӳ�� 
//  �����ṹ(�洢�ṹ) �߼��ṹ�����ݽṹ�ĳ��� �洢�ṹ�����ݽṹ��ʵ��  �����к���������������Ԫ��֮��Ľṹ��ϵ
//  ���ݵ������ʵ��
//3)�߼��ṹ�Ļ��ַ��� (1)���Խṹ (2)�����Խṹ  /(1)���Ͻṹ (2)���Խṹ (3)���νṹ (4)ͼ״�ṹ����״�ṹ ��ǰ���ͺ�̲�ͬ��
//4)���ֻ����Ĵ洢�ṹ (1)˳��洢�ṹ (2)��ʽ�洢�ṹ (3)�����洢�ṹ (4)ɢ�д洢�ṹ
//1.2.3
//�������ͺͳ�����������
//1)�������Ͷ��壺�������� ����������һ��������ͬ��ֵ�ļ����Լ����������ֵ������һ��������ܳ�  ��������=ֵ�ļ���+ֵ�����ϵ�һ�����
//  c�����������ʹ��ڲ����õ���� ���ʾջ ���� �� ͼ��  ����ֱ����������������ʾ
//2)������������ Abstract Date Type ��ָһ����ѧģ���Լ������ڴ���ѧģ���ϵ�һ����� ���ҵ��������˳����һ���������� Ȼ�����ټ������ʵ�� �Ȼ�ͼֽ�󽨷���
//  ��ʽ���� D(���ݶ���) S(D�Ϲ�ϵ��) P(D�ϻ���������)
//  ADT ��������������{              
//
//	���ݶ���<>
//
//	���ݹ�ϵ<>
//
//	��������<>
//    (������) (��ʼ����)  (�������)
//
//  }ADT ��������������
//��
//  ADT Circle{
//
//  ���ݶ���D={r,x,y| r,x,y ��Ϊʵ��}
//
//  ���ݹ�ϵ��S={<r,x,y>|r�ǰ뾶��<x,y>��Բ������}
//
//  ����������
//
//  Circle(&C,r,x,y)
//  �������������һ��Բ
//
//  double Area(C)
//  ����������Բ����
//  ����������������
//
//  }ADT Circle

//3.�����������͵ı�ʾ��ʵ��
//�������������͸�����ʵ��

//void menu()
//{
//	printf("*********************\n");
//	printf("****1.Add  2.Sub*****\n");
//	printf("****3.Mul  4.Div*****\n");
//	printf("****   0.Exit   *****\n");
//	printf("*********************\n");
//}
//void assign(complex* e1,complex* e2)
//{
//	printf("�������һ��������ʵ�����鲿��");
//	scanf("%d%d",&e1->realpart, &e1->imaqpart);
//	printf("������ڶ���������ʵ�����鲿��");
//	scanf("%d%d", &e2->realpart, &e2->imaqpart);
//}
//int main()
//{
//	int input;
//	do
//	{
//		menu();
//		complex e1 = { 0 };
//		complex e2 = { 0 };
//		printf("������ѡ�");
//		scanf("%d", &input);
//		switch(input)
//		{
//		case Add:
//			assign(&e1, &e2);
//			complex_add(&e1, &e2); // �����ӷ�
//			break;
//		case Sub:
//			assign(&e1, &e2);
//			complex_sub(&e1, &e2);// ��������
//			break;
//		case Mul:
//			assign(&e1, &e2);
//			complex_mul(&e1, &e2); //�����˷�
//			break;
//		case Div:
//			assign(&e1, &e2); 
//			complex_div(&e1, &e2); //��������
//			break;
//		case Exit:
//			printf("�˳�\n");
//			break;
//		default:
//			printf("����\n");
//		}
//		if (input != 0 && (e2.imaqpart != 0 || e2.realpart != 0))
//		{
//			printf("�������Ϊ%d + %di\n", e1.realpart, e1.imaqpart);
//		}	
//		system("pause");
//		system("cls");
//		
//	} while (input);
//	return 0;
//}

//4.�㷨���㷨���� 
//1)�㷨�Ķ��� ���ض�������ⷽ�������һ������������ָ����������С�
//  �㷨�ǽ�������һ�ַ�����һ�����̣���������ĳ�����Զ��㷨�ľ���ʵ��
//  ����=���ݽṹ+�㷨 ���ݽṹͨ���㷨ʵ�ֲ��� �㷨ͨ�����ݽṹ��Ƴ���
//2)�㷨���� ������ ȷ���� ������ ����(���п���) ���(Ҫ��)
//3)�㷨���Ҫ�� ��ȷ�� �ɶ��� ��׳��(³����) ��Ч��
//4)���㷨��֤��ȷ�� Ȼ�� �ǽ�׳�� �ɶ��Ժ�Ƚ��㷨�û���Ҫ�����㷨Ч�� ͨ���㷨Ч�������в�ͬ�㷨�����ӳ̶�
//  �㷨Ч����Ҫ���������濼�� 1.ʱ��Ч�� 2.�ռ�Ч��
//  �㷨���е�ʱ��  = E^ ÿ������Ƶ��*�����ִ��һ�����õ�ʱ��
//  ����ÿ�����ִ�е�ʱ�� �㷨��ʱ��Ч�ʿ���ÿ������Ƶ������������
//  �򵥱Ƚ����Ƶ�� ���� �㷨�Ľ���ʱ�临�Ӷ���˵ ֻ��Ƚ����ǵ�������
//  ��һ���㷨�������Ƶ��Ϊ 2*n^3+3*n^2+n   n-> 0����0 ʱ���㷨 �Ľ���ʱ�临�Ӷ�T(n) = O(n^3)  (OΪ�������ķ���)
//  �㷨���Ƶ������������ͨ�������㷨�л�������ظ�ִ�д�������� �ظ�ִ�д����������
//5)�����㷨ʱ�临�ӶȵĻ�������
//  1 �ҳ����Ƶ���������������Ϊ�������
//  2 �����������Ƶ�ȵõ������ģn��ĳ������ f(n) = (ִ�д���)  f(n)�ĺ�����ѭ��ִ��n�κ�������ִ�еĴ���  f(n)�ǹ���n�ĺ���
//  3 ȡ���������÷���"O" ����ʾ
//  �㷨��ʱ�临�Ӷ���ʱ������ݼ�������� һ������������ʱ�临�Ӷ� �� ƽ��ʱ�临�Ӷ�
//  ���ڸ��ӵ��㷨 ���Խ����Ƿֳɼ������׹���Ĳ��� Ȼ�����üӷ�����ͳ˷��������ʱ�临�Ӷ�
//  �ӷ����� ����T(n) = T1(n) + T2(n) ��ȡ����Ϊʱ�临�Ӷ�
//  �˷����� ����T(n) = T1(n) * T2(n) ��ȡ���ǵĳ˻�Ϊʱ�临�Ӷ�
//  ���㷨��ʱ��Ч�ʵ������С������  �㷨��ʱ�临�Ӷ���������������� 
//  ������ ������ ���Խ� ���Զ����� ƽ���� ������ K�η��� ָ����
//6)�����ռ临�Ӷ� �㷨����洢�ռ�Ķ��� ����S(n) =O(f(n)) nΪ����Ĺ�ģ�����С�� f(n) ��ʾ���ǹ����㷨ռ�ÿռ��С
//  �㷨ռ�õĿռ��������Ϊ 1 ����ռ�еĿռ� �������ָ�� ���� ���� �� 2 �㷨Ҫʹ�õĸ����ռ�
//  �㷨�Ŀռ临�Ӷ���ʱ��Ҫ����ʹ�õĸ����ռ�Ĵ�С