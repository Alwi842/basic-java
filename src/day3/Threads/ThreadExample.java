package day3.Threads;
/*Thread(asynchronous) : untuk jalanin beberapa tugas secara bersamaan di latar belakang tanpa menggangu
* proses utama.*/
class MyThread extends Thread {
    //overwrite method run dari thread
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            //buat ngambil nama threadyang lagi jalan
            System.out.println(Thread.currentThread().getName()+" value : "+i);
            try{
                //menghentikan thread selama 1detik sebelum ke looping selanjutnya
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println(e.getMessage());
                System.out.println("Error : interrupted thread");
            }
        }
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start(); //thread pertama
        t1.interrupt(); //interupsi thread pertama ketika lagi jalan buat nunjukin error
        t2.start(); // thread kedua yang akan tetap jalan walawpun thread1 mati


    }
}
