package com.sohu.yifanshi.InnerClassPractice.closure;
/*
* �հ��ֳƴʷ��հ�
�հ����綨��Ϊһ�ְ���<�����ɷ�>��<���Ƴɷ�>��ʵ��.
����һ���հ������������ɱ����ĺ�������������õı��������������һͬ���ڡ�
���Ͷ����հ��Ǻ�����������û�����ɵ�ʵ�塣
ע��<���ɱ���>�����˾ֲ���������������

����⣺�հ��ܹ���һ��������Ϊһ������ȥ�洢���������������ȥ��������������ɱ�����
��java�У�����Խ�һ��������������ȥ�洢�����������Ҫ�ܷ����������ɱ����Ļ�����ô���Ǻ����׾��뵽�ڲ���ĺ�������ֱ�ӷ���
�ⲿ������б����뺯���������java�еıհ���
�����������ñհ������������һ�����⡣Programmer�Ǹ����࣬����work������Teachable�Ǹ��ӿڣ���Ҳ��work��������ô�������һ������
Programmer����Teachable�ӿڵ����أ����ǲ���ֱ��ʵ�ֵ�ԭ����programmer��teachable��work����ͬ���ˡ���ô���ǾͿ����ñհ���˼�롣
��teachable��work���������������洢�����Ǵ��������У���Ȼǩ��������work����Ȼ�͸����˸���ķ�����Ȼ��teachable����Ҫ����һЩ����
���������еı���������ֻ��һ����ͨ�������еĺ����������������ġ����Ǿʹ���һ��ʵ����teachable�ӿڵ��ڲ��ࡣ����ڲ��������������
�հ��ˡ�����work���������ǵ��������洢�������У���������teach��������Ȼ���ڲ���Ҳ������ķ����ⲿ��ĳ�Ա��֮����������
�ص�����������ڲ����work��������ʵ����һ�������൱�ڹ�������work�����ˡ�
*/
public class TeachableProgrammer extends Programmer {
    public TeachableProgrammer()
    {
        super();
    }
    public TeachableProgrammer(String name)
    {
        super(name);
    }
    private void teach()
    {
        System.out.println(this.getName()+"���ڽ���");
    }

    private class Closure implements Teachable{
        public void work(){
            teach();
        }
    }

    public Teachable getCallBackReference()
    {
        return this.new Closure();
    }

    public static void main(String[] args) {
        TeachableProgrammer teachableProgrammer = new TeachableProgrammer("wang");
        teachableProgrammer.work();
        teachableProgrammer.getCallBackReference().work();
    }
}
