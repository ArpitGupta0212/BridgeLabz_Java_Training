// Thread Life Cycle
// 1. New state=operating system se phle apne code ke through btana ki thread heap memory me bnanai hai jese ki yaha Thread t1=new Thread(e1);
// 2. Runnable state  after calling start this is runnable state
// 3. Running state  jab vo khud se  run method ko call krti hai
// 4. Terminated state jab run ka method ka poora instruction excute ho jaati hai tab vo terminated state me chli jaati hai then hum kabhi uss thread ko start nhi kr skte  
// 5. Blocked state yeh jab koi thread Critical section prlock lga do aur koi dusri thread usse access krna chaye to usse blocked state me daal diya jata hai
// 6. Waiting state iss state me thread jab jaati hai tab uss thread pr wait method call kia hota hai and normal state me jab jayegi tab uss pr notify method call krte hai 
// 7. Timed Wating state agr kisi state ko specific time ke liye wait krne ka method use hua ho to vo chli jaati hai iss state me vo methods hai sleep,join, wait, innsab me parameter time hoga

public class MultiThreading_Life_Cycle{
   public static void main(String[] args) {
    Thread mainThread=Thread.currentThread();
    // Thread New State 
    Thread t1=new Thread(()->{
        System.out.println("Name Of Current Thread is "+ Thread.currentThread().getName());
        System.out.println(mainThread.getState());
    });
    System.out.println(t1.getState());
    // Runnable Stage
    t1.start();
    System.out.println(t1.getState());
    // Terminated Stage
    try{
        Thread.sleep(2000);
    }
    catch(Exception e){

    }
    System.out.println(t1.getState());
   }

}