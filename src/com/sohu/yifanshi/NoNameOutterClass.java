package com.sohu.yifanshi;

public class NoNameOutterClass {
    public TestIntefaceClass testIntefaceClass;
    public TestAbstractClass testAbstractClass;

    public String testString(final String name,String city)//Ҳ����ֱ�ӵ����ڲ���ķ���
    {
        return new TestAbstractClass(name,city)
        {

            @Override
            void print() {
                System.out.println(name);
            }
            String returnName()
            {
                return name;
            }
        }.returnName();
    }

    public TestAbstractClass getTestAbstractClass(String name, final String city)
    {
        return this.testAbstractClass =  new TestAbstractClass(name,city) {//�����ڲ���;ֲ��ڲ���һ�������캯�����÷����ֲ���������Ҫfinal��������������
            //�õ��ֲ�������Ҫfinal
            //�����ڲ�������û�����֣�������û���Լ��Ĺ��캯����������������Ҫ����һ��������ô��ֻ���ñ���࿩������������ڲ���
            //����̳�һ�������ʵ��һ���ӿڵ�ԭ�򡣶��������ַ�����һ���������������ķ�����
            @Override
            void print() {

                //System.out.println(name);nameΪ����final����
                System.out.println(city);
                System.out.println("ccc");
            }
        };
    }

    public TestIntefaceClass getIntefaceClass(final String city)
    {
        return this.testIntefaceClass =  new TestIntefaceClass() {//ʵ�ֽӿڵ������ڲ���
            @Override
            public void print() {
                System.out.println(city);
            }
        };
    }

    public static void main(String[] args) {
        NoNameOutterClass noNameOutterClass = new NoNameOutterClass();
        noNameOutterClass.getIntefaceClass("beijing");
        noNameOutterClass.getTestAbstractClass("yifanshi","leping");
        noNameOutterClass.testIntefaceClass.print();
        noNameOutterClass.testAbstractClass.print();
        String str =  noNameOutterClass.testString("aaa","bbb");
    }
}
