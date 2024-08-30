package net.rudp.p002a;

public class Timer implements Runnable {
    boolean a;
    String b;
    private Runnable c;
    private long d;
    private long e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Object j = new Object();

    public Timer(String var1, Runnable var2) {
        this.b = var1;
        this.c = var2;
        this.d = 0L;
        this.e = 0L;
    }

    public void a() {
        this.a = true;
        Thread var1 = new Thread(this, this.b);
        var1.setDaemon(true);
        var1.start();
    }

    public void run() {
        label202:
        while(!this.i) {
            synchronized(this){}

            while(true) {
                boolean var12 = false;

                try {
                    var12 = true;
                    if (!this.g && !this.i) {
                        try {
                            this.wait();
                        } catch (InterruptedException var15) {
                            var15.printStackTrace();
                        }
                        continue;
                    }

                    if (this.i) {
                        var12 = false;
                        break label202;
                    }

                    var12 = false;
                } finally {
                    if (var12) {
                        ;
                    }
                }

                synchronized(this.j) {
                    this.h = false;
                    this.f = false;
                    if (this.d > 0L) {
                        try {
                            this.j.wait(this.d);
                        } catch (InterruptedException var14) {
                            var14.printStackTrace();
                        }
                    }

                    if (this.f) {
                        break;
                    }
                }

                if (!this.h) {
                    this.c.run();
                }

                if (this.e <= 0L) {
                    break;
                }

                while(true) {
                    while(true) {
                        synchronized(this.j) {
                            this.h = false;

                            try {
                                this.j.wait(this.e);
                            } catch (InterruptedException var13) {
                                var13.printStackTrace();
                            }

                            if (this.f) {
                                continue label202;
                            }

                            if (!this.h) {
                                break;
                            }
                        }
                    }

                    this.c.run();
                }
            }
        }

        if (this.i) {
            this.c = null;
        }

    }

    public synchronized void a(long var1) {
        this.a(var1, 0L);
    }

    public synchronized void a(long var1, long var3) {
        this.d = var1;
        this.e = var3;
        if (this.g) {
            throw new IllegalStateException("already scheduled");
        } else {
            this.g = true;
            this.notify();
            synchronized(this.j) {
                this.j.notify();
            }
        }
    }

    public synchronized boolean b() {
        return this.g;
    }

    public synchronized boolean c() {
        return !this.b();
    }

    public synchronized void d() {
        synchronized(this.j) {
            this.h = true;
            this.j.notify();
        }
    }

    public synchronized void e() {
        this.g = false;
        synchronized(this.j) {
            this.f = true;
            this.j.notify();
        }
    }

    public synchronized void f() {
        this.e();
        this.i = true;
        this.notify();
    }
}
