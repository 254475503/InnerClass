package com.sohu.yifanshi.InnerClassPractice.ExtendsInnerClass;

public class ExtendsOuter1 extends  OuterClass1 {

    public class InnerClass extends OuterClass1.InnerClass{
        public InnerClass(){
            System.out.println("ExtendsOuter.Inner()");
        }

        public void f(){
            System.out.println("ExtendsOuter.Inner.f()");
        }

    }

    public ExtendsOuter1()
    {
        insertInner(new InnerClass());
    }

    public static void main(String[] args) {
        OuterClass1 oc1 = new ExtendsOuter1();//����˳��1.ʵ����ExtendsOuter1�ĸ��ࡣ���ֶθ�ֵ����ֵʱִ���˸���13�У����OuterClass1.InnerClass()
        //2.ִ�и��๹�캯�����new OuterClass1 3.ִ�б��๹�캯����insertInner��ջ��4.new InnerClass()��ջ�����innerclass�����࣬������Ҫ��ʵ�������ࡣ
        //5.ִ�и���innerclass���캯�����OuterClass1.InnerClass() 6.ִ�����๹�캯����� ExtendsOuter.Inner() newInnerclass��ջ��ִ��insert��insert��ջ��

        oc1.g();//7.ִ��oc1.g����Ⱥ������OuterClass1�����ã���Ӧִ�и����g�����������ٹ��캯���У����ǽ�һ�������inner��insert���˵�ǰ�Ķ�����������
        //ִ�е�������inner��inner.f()�������ExtendsOuter.Inner.f()

    }

}
