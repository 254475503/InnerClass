package com.sohu.yifanshi;

public class FiedOutClass {
    private int age = 12;
    public void printAge()
    {
        System.out.println(age);
    }
    public void testFunction(int X,final int Y)//��jdk1.8֮ǰ�ֲ��ڲ���ķ���(���캯������)��Ҫʹ���ⲿ����Ĳ���������Ҫ����������Ϊfinal��
    {
        class FieldInnerClass{
            private int a;
            private int b;
            public FieldInnerClass(int x,int y)
            {//�ֲ��ڲ���Ĺ��캯����Ҫʹ���ⲿ����X,Yû��Ҫ����Ϊfinal��
                this.a = X;
                this.b = Y;
            }
            public void printX()
            {
                System.out.println(X);//��jdk1.8֮ǰ������ᱨ��ԭ������Ϊ�ֲ��ڲ���;ֲ�������jvm������е��������ڲ�ͬ
                //���ȣ�����ֲ��ڲ���ķ������ڵ�����£��ض�Ҫ���ʾֲ�����X�����Ծֲ��ڲ�����Ȼ��������£����ķ���ʹ�õ���
                //�ֲ�����Ҳ���������ǰ�ᡣ��Ȼ����ֲ��ڲ��ཫʧȥ���塣������jvm�У��ֲ��������ŷ�����ִ�ж����������ŷ���
                //��ִ�н��������١����ǣ��ֲ��ڲ����������һ��������һ�δ�������ʱ�����أ���������Ҳ�������ã��ſ��ܻᱻGC�����ԣ�
                //�����Ϳ��ܴ��ھֲ��ڲ�����Ȼ���ڣ����Ǿֲ������Ѿ����ٵ������Ϊ�˱�������������������Ǿ���Ҫ���ֲ���������final��Ϊ
                //���������ڳ������С��������ֲ������������ⱻ���٣�Ҳ�Ͳ����������������
                System.out.println(Y);
                System.out.println(age);
                printAge();
            }
        }
        FieldInnerClass fieldInnerClass = new FieldInnerClass(X,Y);
        fieldInnerClass.printX();
    }

    public static void main(String[] args) {
        FiedOutClass fiedOutClass = new FiedOutClass();
        fiedOutClass.testFunction(10,20);
    }
}

