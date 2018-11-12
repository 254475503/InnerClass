package com.sohu.yifanshi.InnerClassPractice.practice7;

public class Outer {
    private String name;
    private void printName()
    {
        System.out.println(this.name);
    }
    class Inner{
        private String innerPrivatefield = "";
        private void sayHi()
        {
            System.out.println("Hi I am Inner class");
        }
        void editAndPrint(String name)
        {
            Outer.this.name = name;
            Outer.this.printName();
        }
    }
    public void editAndPrintByInner(String name)
    {
        Outer.Inner inner = this.new Inner();
        inner.editAndPrint(name);
    }
    public void tryinnerPrivate()
    {
        System.out.println(this.new Inner().innerPrivatefield);
        this.new Inner().sayHi();
    }
    public void editAndPrintByNonameInner( String name)
    {//�������ҳ�����һ���������ڲ�����������������������Ĳ����ǲ�������Ϊfinal�ġ��������ǿ����Ʋ���������ڲ�����÷�����ֱ��
        //ʹ������㷽������Ĳ����������Ǹ��Ƶĸ�����ֻ�д��������ڲ���Ĳ������ǲ����Ĳ������ĸ��ơ�
        this.new Inner()
        {

        }.editAndPrint(name);

    }


    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.editAndPrintByInner("aaa");
        outer.editAndPrintByInner("bbb");
        outer.editAndPrintByNonameInner("ccc");
        outer.printName();
        outer.tryinnerPrivate();//��ʵ֤�����ⲿ���ǿ��Է����ڲ����private�����ͳ�Ա������
    }
}
