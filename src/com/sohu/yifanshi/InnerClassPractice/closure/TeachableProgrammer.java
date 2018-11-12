package com.sohu.yifanshi.InnerClassPractice.closure;
/*
* 闭包又称词法闭包
闭包最早定义为一种包含<环境成分>和<控制成分>的实体.
解释一：闭包是引用了自由变量的函数，这个被引用的变量将和这个函数一同存在。
解释二：闭包是函数和相关引用环境组成的实体。
注：<自由变量>：除了局部变量的其他变量

简单理解：闭包能够将一个方法作为一个变量去存储，这个方法有能力去访问所在类的自由变量。
在java中，类可以将一个方法当作变量去存储。这个方法若要能访问所有自由变量的话，那么我们很容易就想到内部类的函数可以直接访问
外部类的所有变量与函数。这就是java中的闭包啦
在这里我们用闭包来解决了这样一个问题。Programmer是个父类，他又work方法。Teachable是个接口，他也有work方法。那么如何描述一个既是
Programmer又又Teachable接口的类呢？我们不能直接实现的原因是programmer与teachable的work方法同名了。那么我们就可以用闭包的思想。
将teachable的work方法当作变量，存储在我们创建的类中，当然签名不能是work，不然就覆盖了父类的方法。然后teachable可能要操作一些我们
创建的类中的变量，若他只是一个普通的在类中的函数，他是做不到的。我们就创建一个实现了teachable接口的内部类。这个内部类就是我们理解的
闭包了。他的work方法被我们当作变量存储在了类中（在这里是teach方法），然后内部类也能随意的访问外部类的成员。之后我们再用
回调来调用这个内部类的work方法，就实现了一个类中相当于共存两个work方法了。
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
        System.out.println(this.getName()+"正在讲课");
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
