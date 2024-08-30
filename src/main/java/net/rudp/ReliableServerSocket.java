package net.rudp;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReliableServerSocket extends ServerSocket {
    class_766 a;
    private DatagramSocket d;
    private int e;
    private int f;
    private boolean g;
    private ArrayList h;
    private HashMap i;
    private HashMap j;
    private HashMap k;
    long b;
    int c;
    private ReliableSocketStateListener l;

    public ReliableServerSocket() throws IOException {
        this(new DatagramSocket((SocketAddress)null), 0);
    }


    public ReliableServerSocket(int var1, int var2, InetAddress var3, boolean var4) throws IOException {
        super();
        DatagramSocket var5 = new DatagramSocket((SocketAddress)null);
        var5.setReuseAddress(var4);
        var5.bind(new InetSocketAddress(var3, var1));
        this.a(var5, var2);
    }


    public ReliableServerSocket(DatagramSocket var1, int var2) throws IOException {
        super();
        this.a(var1, var2);
    }

    public void a(DatagramSocket var1, int var2) {
        if (var1 == null) {
            throw new NullPointerException("sock");
        } else {
            this.d = var1;
            this.f = var2 <= 0 ? 50 : var2;
            this.h = new ArrayList(this.f);
            this.i = new HashMap();
            this.j = new HashMap();
            this.k = new HashMap();
            this.l = new class_769(this, (ReliableServerSocket$1)null);
            this.e = 0;
            this.g = false;
            (new class_765(this)).start();
        }
    }

    public void a(class_766 var1) {
        this.a = var1;
    }

    @SneakyThrows
    public Socket accept() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            synchronized(this.h) {
                do {
                    if (!this.h.isEmpty()) {
                        return (Socket)this.h.remove(0);
                    }

                    try {
                        if (this.e == 0) {
                            this.h.wait();
                        } else {
                            long var2 = System.currentTimeMillis();
                            this.h.wait((long)this.e);
                            if (System.currentTimeMillis() - var2 >= (long)this.e) {
                                throw new SocketTimeoutException();
                            }
                        }
                    } catch (InterruptedException var5) {
                        var5.printStackTrace();
                    }
                } while(!this.isClosed());

                throw new SocketException("Socket is closed");
            }
        }
    }

    public synchronized void bind(SocketAddress var1) {
        this.bind(var1, 0);
    }

    @SneakyThrows
    public synchronized void bind(SocketAddress var1, int var2) {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            this.d.setReuseAddress(true);
            this.d.bind(var1);
        }
    }

    public synchronized void close() {
        if (!this.isClosed()) {
            this.g = true;
            synchronized(this.h) {
                this.h.clear();
                this.h.notify();
            }

            synchronized(this.i) {
                if (this.i.isEmpty()) {
                    this.d.close();
                }

            }
        }
    }

    public InetAddress getInetAddress() {
        return this.d.getInetAddress();
    }

    public int getLocalPort() {
        return this.d.getLocalPort();
    }

    public SocketAddress getLocalSocketAddress() {
        return this.d.getLocalSocketAddress();
    }

    public boolean isBound() {
        return this.d.isBound();
    }

    public boolean isClosed() {
        return this.g;
    }

    public void setSoTimeout(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else {
            this.e = var1;
        }
    }

    public int getSoTimeout() {
        return this.e;
    }

    private void a(SocketAddress var1, class_663 var2) {
        synchronized(this.i) {
            var2.a((ReliableSocketStateListener)this.l);
            this.i.put(var1, var2);
        }
    }

    private class_663 a(SocketAddress var1) {
        synchronized(this.i) {
            class_663 var3 = (class_663)this.i.remove(var1);
            if (this.i.isEmpty() && this.isClosed()) {
                this.d.close();
            }

            return var3;
        }
    }

    private void a(String var1) {
        if (this.b + 5000L < System.currentTimeMillis()) {
            this.b = System.currentTimeMillis();
            this.c = 0;
        }

        if (this.c <= 20) {
            ++this.c;
            System.out.println(var1);
        }
    }

    // $FF: synthetic method
    static DatagramSocket a(ReliableServerSocket var0) {
        return var0.d;
    }

    // $FF: synthetic method
    static void a(ReliableServerSocket var0, String var1) {
        var0.a(var1);
    }

    // $FF: synthetic method
    static HashMap b(ReliableServerSocket var0) {
        return var0.i;
    }

    // $FF: synthetic method
    static HashMap c(ReliableServerSocket var0) {
        return var0.k;
    }

    // $FF: synthetic method
    static HashMap d(ReliableServerSocket var0) {
        return var0.j;
    }

    // $FF: synthetic method
    static void a(ReliableServerSocket var0, SocketAddress var1, class_663 var2) {
        var0.a(var1, var2);
    }

    // $FF: synthetic method
    static ArrayList e(ReliableServerSocket var0) {
        return var0.h;
    }

    // $FF: synthetic method
    static class_663 a(ReliableServerSocket var0, SocketAddress var1) {
        return var0.a(var1);
    }
}
