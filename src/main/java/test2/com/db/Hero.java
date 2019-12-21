package test2.com.db;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Hero implements Serializable,Comparable<Hero>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
    public AtomicInteger hp=new AtomicInteger();
        
    public int damage;
        
    public Hero(){
           
    }
       
    public Hero(String name) {
        this.name =name;
   
    }
       
    //初始化name,hp,damage的构造方法
    public Hero(String name,AtomicInteger hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
   
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1; 
        else
            return -1;
    }
   
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
    
    
    public  synchronized void recover() {
    	hp.getAndDecrement();
	}
    
    public void  hurt() {
    	synchronized (this) {
        	hp.getAndDecrement();
		}
	}
    
    
    
    
    public void attackHero(Hero h){
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	h.hp.addAndGet(0-damage);
    	System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
    	if(h.isDead())
            System.out.println(h.name +"死了！");
    	
    }
    
    public boolean isDead(){
    	return 0>=hp.intValue()?true:false;
    }
    
    
    public boolean isDead2(){
    	return 0>=hp.intValue()?true:false;
    }
}
