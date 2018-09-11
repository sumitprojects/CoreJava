package Java8.deadlock;

import java.util.Scanner;

class Table{
  
  void printTable(int n){
    synchronized(this){//synchronized block
      
      if(Thread.currentThread().getPriority()>=5){
        for(int i=1;i<=5;i++){
          System.out.println(n*i);
          try{
            Thread.sleep(400);
          }catch(Exception e){System.out.println(e);}
        }
      }
    }
  }//end of the method
}

class MyThread1 extends Thread{
  Table t;
  MyThread1(Table t){
    this.t=t;
  }
  public void run(){
    System.out.println("priority:"+Thread.currentThread().getPriority());
    t.printTable(new Scanner(System.in).nextInt());
  }
  
}
class MyThread2 extends Thread{
  Table t;
  MyThread2(Table t){
    this.t=t;
  }
  public void run(){
    t.printTable(new Scanner(System.in).nextInt());
  }
}

class MyThread3 extends Thread{
  Table t;
  MyThread3(Table t){
    this.t=t;
  }
  public void run(){
    t.printTable(new Scanner(System.in).nextInt());
  }
}

public class demo1 {
  public static void main(String args[]){
    Table obj = new Table();//only one object
    MyThread1 t1=new MyThread1(obj);
    MyThread2 t2=new MyThread2(obj);
    MyThread3 t3=new MyThread3(obj);
    t1.setPriority(10);
    t2.setPriority(8);
    t3.setPriority(9);
  
    t1.start();
    try{
      Thread.sleep(3000);
    }catch(Exception e){System.out.println(e);}
    t2.start();
    try{
      Thread.sleep(3000);
    }catch(Exception e){System.out.println(e);}
    t3.start();
  }
}
