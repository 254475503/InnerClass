package com.sohu.yifanshi;



public class DefaultOutterClass {
    public String outPublicField = "outPublicField";
    private String outPrivateField = "outPrivateField";
    public void outPublicFun()
    {
        System.out.println(outPublicField);
    }
    public void outPrivateFun ()
    {
        System.out.println(outPrivateField);
    }
    public void printInnerX()
    {
        System.out.println(new InnerClass().x);//�ⲿ����Ҫͨ���ڲ���Ķ�������ڲ�������г�Ա����/������
    }
    class InnerClass extends TestStaticFatherClass{
        static final int x = 2;
        //static int a = 1;��Ա�ڲ���ֻ�ܳ���static�ĳ�����
        /*public void static say()
        {
            System.out.println();
        } ��Ա�ڲ��಻�ܳ���static���������ǿ��Լ̳���static�����ĸ���.��Ա�ڲ�������������Χ��ģ�
        ���ԣ�ֻ���ȴ�������Χ�������ܹ������ڲ������Ҳ�����������ԭ�򣬳�Ա�ڲ���Ҳ���ܺ��� static �ı����ͷ���*/
        public void print()
        {
            System.out.println(DefaultOutterClass.this.outPrivateField);//�ڳ�Ա�ڲ���ʹ���ⲿ�����ʱ��ʹ�� outer.this ����ʾ�ⲿ�����
            System.out.println(outPublicField);
            System.out.println(outPrivateField);//��Ա�ڲ������ֱ�ӷ����ⲿ������г�Ա�ͷ�������ʹ�� private �ģ�
            outPrivateFun();
            outPublicFun();
        }
        private void innerPrivatefun()
        {
            String method = Thread.currentThread() .getStackTrace()[1].getMethodName();
            System.out.println(method+"runed");
        }

    }


    //���ڲ��౻private���Σ���ô���ⲿ���У���Щ��ϵû���κ����𡣵����������ط�����Ҫ�����ⲿ����ڲ���Ļ�����Ҫ�����ڲ���Ķ���
    //�����ڲ���Ķ����Ѿ�����ͨ��60�еķ��������ˡ�ֻ�����ⲿ���У������ṩһ������ڲ���ķ�����
    public PrivateInnerClass getPrivateInnserClass()
    {
        return new PrivateInnerClass();
    }
    private class PrivateInnerClass extends TestStaticFatherClass{

    }




    public static void main(String[] args) {
        DefaultOutterClass defaultOutterClass = new DefaultOutterClass();
        DefaultOutterClass.InnerClass innerClass = new DefaultOutterClass().new InnerClass();//ֱ��ͨ���ⲿ������ڲ���ķ���������һ���ڲ��඼��
        //Ϊ����������Ϣ������������Ϊ˽�еġ�
        //��ͷ�� Out ��Ϊ�˱�����Ҫ���ɵ��ڲ���������ĸ��ⲿ�൱�У����������ⲿ��Ķ�����������ڲ���Ķ���
        PrivateInnerClass privateInnerClass = defaultOutterClass.getPrivateInnserClass();
        innerClass.say();
        innerClass.print();
        innerClass.innerPrivatefun();
    }
}
