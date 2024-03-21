package it.thread;

public class ThreadFattoriale extends Thread {
    private long val, fatt = 1;

    ThreadFattoriale(long val, String name) {
        super(name);
        this.val = val;
    }

    public long getFatt() {
        return this.fatt;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 2; i <= this.val; i++) {
            this.fatt *= i;
        }
        System.out.println("Calcolo " + name + " completato");
    }

}
