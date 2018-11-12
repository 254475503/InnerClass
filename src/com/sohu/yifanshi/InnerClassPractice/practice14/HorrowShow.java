package com.sohu.yifanshi.InnerClassPractice.practice14;

public class HorrowShow {
    static void u(Monster monster){monster.menace();}
    static void v(DangerousMonster dangerousMonster){
        dangerousMonster.destroy();
        dangerousMonster.menace();
    }
    static void w(Lethal lethal){lethal.kill();}

    public DangerousMonster getDangerousMonster(){
        return  new DangerousMonster() {
            @Override
            public void destroy() {
                System.out.println("destroyyyyyyy!");
            }

            @Override
            public void menace() {
                System.out.println("menace...");
            }
        };
    }

    public Vampire getVampire()
    {
        return new Vampire() {
            @Override
            public void drinkBlood() {
                System.out.println("delicious blood~");
            }

            @Override
            public void destroy() {
                System.out.println("destroy elegantly");
            }

            @Override
            public void kill() {
                System.out.println("drink out of your blood");
            }

            @Override
            public void menace() {
                System.out.println("laugh out loud");
            }
        };
    }

    public static void main(String[] args) {
        HorrowShow horrowShow = new HorrowShow();
        DangerousMonster dangerousMonster = horrowShow.getDangerousMonster();
        Vampire fulajimier = horrowShow.getVampire();
    }
}
