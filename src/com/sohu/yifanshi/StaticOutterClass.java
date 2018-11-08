package com.sohu.yifanshi;

public class StaticOutterClass {
    private static String name = "aaa";
    private String age = "10";
    public String getAge()
    {
        return age;
    }
    public static String getName()
    {
        return name;
    }
    public void test()
    {
        new InnerClass().getId();//��Ȼ���Դ����ڲ����������䷽����
        new InnerClass().getStaticField();
        getName();
        getAge();
    }

    public static void staticTest()
    {
        new InnerClass().getId();//��Ȼ���Դ����ڲ����������䷽����
        new InnerClass().getStaticField();//�ⲿ�����ͨ���ڲ����������ڲ����ʵ����Ա����/������
        InnerClass.getStaticField();//�����ڲ���ľ�̬��/�������ⲿ�����ͨ���ڲ����������ʡ�
        getName();
        //getAge();static�����޷�ֱ�ӵ��÷�static����
        new StaticOutterClass().getAge();//���⻹������һ�����˵���ʵ��static�����У����ܵ��÷�static���������ǣ����Ե���һ���Ѿ�
        //ʵ�����˵Ķ����static������ԭ����static���������ڲ�ʹ��thisָ�������µ��ã�����ֱ�ӵ��ø���ķ�static��������Ҫ����thisָ��ġ�

    }
    static class InnerClass{//static�ڲ������ҽ��ܲ����ⲿ�౻static���εĳ�Ա�뷽��
        private String id = "ss";
        private static String staticField = "staticField";

        public static String getStaticField() {
            return staticField;
        }

        public static void setStaticField(String staticField) {
            InnerClass.staticField = staticField;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void print()
        {
            //System.out.println(StaticOutterClass.this.age); static�ڲ����޷���������ⲿ�����
            System.out.println(name);//��ֱ�ӷ���static���εĳ�Ա
            //System.out.println(age);���ܷ��ʷ�static�ĳ�Ա
            getName();//��ֱ�ӵ����ⲿstatic����

        }
    }

    public static void main(String[] args) {
        StaticOutterClass staticOutterClass = new StaticOutterClass();
        StaticOutterClass.InnerClass.getStaticField();
        InnerClass.getStaticField();//����ֱ��ͨ���������static�ڲ����е�static��Ա
        StaticOutterClass.InnerClass innerClass = new StaticOutterClass.InnerClass();//����Ҫͨ���ⲿ���������ڲ������,ӦΪstatic�ڲ�
        //����ⲿ��û��������ϵ��������ⲿ����Ȼֻ����������ڲ�������һ���ⲿ����ڲ���
        innerClass.getId();
    }
}
