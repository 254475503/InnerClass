package com.sohu.yifanshi;

public class InheriteInner extends DefaultOutterClass.InnerClass {//�̳���һ���ڲ���֮���޲ι��캯��ʱ����ͨ������ġ���Ϊ��̳е�
    //��һ���ڲ��ࡣ�ڲ���Ĵ������������ⲿ��ġ��������Ǽ̳н����Ǽ̳е����ڲ��࣬�ⲿ�ಢû�м̳����������Ա����ֶ�����һ���ⲿ��
    //������г�ʼ��������ֱ�����޲ι��캯����newһ���ⲿ����������г�ʼ��
    InheriteInner()
    {
        new DefaultOutterClass().super();
    }
    InheriteInner(DefaultOutterClass defaultOutterClass)
    {
        defaultOutterClass.super();
    }

    public static void main(String[] args) {
        InheriteInner inheriteInner = new InheriteInner(new DefaultOutterClass());
    }
}
