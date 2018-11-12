package com.sohu.yifanshi.InnerClassPractice.practice6.package3;

import com.sohu.yifanshi.InnerClassPractice.practice6.package1.defaultInterface;
import com.sohu.yifanshi.InnerClassPractice.practice6.package2.Outer;

public class extendsClass extends Outer {
    defaultInterface getInner()
    {
        return this.new Inner();
    }
}
