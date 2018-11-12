package com.sohu.yifanshi.InnerClassPractice.practice2;

public class TempClass {
    private String content;
    TempClass()
    {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }

    public static void main(String[] args) {
        TempClass[] tempClasses = new TempClass[5];
        Sequence sequence = new Sequence(tempClasses.length);
        for(int i = 0;i<tempClasses.length;i++)
        {
            tempClasses[i] = new TempClass();
            char v = (char) ('A'+i);
            tempClasses[i].setContent(String.valueOf(v));
            sequence.add(tempClasses[i]);
        }
        Selector selector = sequence.getSelector();
        for(int i = 0 ; i < tempClasses.length ; i++)
        {
            System.out.println(selector.current());
            selector.next();
        }

    }
}
