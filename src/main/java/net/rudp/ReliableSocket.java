package net.rudp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import lombok.SneakyThrows;
import net.rudp.p002a.ACKSegment;
import net.rudp.p002a.DATSegment;
import net.rudp.p002a.EAKSegment;
import net.rudp.p002a.FINSegment;
import net.rudp.p002a.NULSegment;
import net.rudp.p002a.RSTSegment;
import net.rudp.p002a.SYNSegment;
import net.rudp.p002a.Segment;
import net.rudp.p002a.Timer;

public class ReliableSocket extends Socket {
    protected DatagramSocket c;
    protected SocketAddress d;
    protected ReliableSocketInputStream e;
    protected ReliableSocketOutputStream f;
    private byte[] a;
    private boolean b;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private Object q;
    private Object r;
    private ArrayList s;
    private ArrayList t;
    protected ReliableSocketProfile g;
    private ArrayList u;
    private ArrayList v;
    private ArrayList w;
    private Object x;
    private class_767 y;
    private Thread z;
    private int A;
    private int B;
    private int C;
    private int D;
    public boolean h;
    private Timer E;
    private Timer F;
    private Timer G;
    private Timer H;
    private static final boolean I = Boolean.getBoolean("net.rudp.debug");

    public ReliableSocket() throws SocketException {
        this(new ReliableSocketProfile());
    }

    public ReliableSocket(ReliableSocketProfile var1) throws SocketException {
        this(new DatagramSocket(), var1);
    }

    protected ReliableSocket(DatagramSocket var1) {
        this(var1, new ReliableSocketProfile());
    }

    protected ReliableSocket(DatagramSocket var1, ReliableSocketProfile var2) {
        this.b = false;
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = false;
        this.p = -1;
        this.q = new Object();
        this.r = new Object();
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.g = ReliableSocketProfile.a;
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.w = new ArrayList();
        this.x = new Object();
        this.y = new class_767();
        this.A = 32;
        this.B = 32;
        this.h = false;
        this.E = new Timer("rudp-NullSegmentTimer", new class_771(this, (ReliableSocket$1)null));
        this.F = new Timer("rudp-RetransmissionTimer", new class_774(this, (ReliableSocket$1)null));
        this.G = new Timer("rudp-CumulativeAckTimer", new class_773(this, (ReliableSocket$1)null));
        this.H = new Timer("rudp-KeepAliveTimer", new class_772(this, (ReliableSocket$1)null));
        if (var1 == null) {
            throw new NullPointerException("sock");
        } else {
            this.a(var1, var2);
        }
    }

    protected void a(DatagramSocket var1, ReliableSocketProfile var2) {
        this.c = var1;
        this.g = var2;
        this.C = (this.g.a() - 6) * 32;
        this.D = (this.g.a() - 6) * 32;
        if (this.z == null) {
            this.z = new class_770(this);
            this.z.start();
        }

    }

    @SneakyThrows
    public void bind(SocketAddress var1) {
        this.c.bind(var1);
    }

    public void connect(SocketAddress var1) {
        this.connect(var1, 0);
    }

    @SneakyThrows
    public void connect(SocketAddress var1, int var2) {
        if (var1 == null) {
            throw new IllegalArgumentException("connect: The address can't be null");
        } else if (var2 < 0) {
            throw new IllegalArgumentException("connect: timeout can't be negative");
        } else if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (this.isConnected()) {
            throw new SocketException("already connected");
        } else if (!(var1 instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Unsupported address type");
        } else {
            this.d = (InetSocketAddress)var1;
            this.f();
            this.l = 2;
            Random var3 = new Random(System.currentTimeMillis());
            SYNSegment var4 = new SYNSegment(this.y.a(var3.nextInt(255)), this.g.b(), this.g.a(), this.g.h(), this.g.i(), this.g.g(), this.g.c(), this.g.d(), this.g.e(), this.g.f());
            this.e((Segment)var4);
            boolean var5 = false;
            synchronized(this) {
                if (!this.isConnected()) {
                    try {
                        if (var2 == 0) {
                            this.wait();
                        } else {
                            long var7 = System.currentTimeMillis();
                            this.wait((long)var2);
                            if (System.currentTimeMillis() - var7 >= (long)var2) {
                                var5 = true;
                            }
                        }
                    } catch (InterruptedException var12) {
                        var12.printStackTrace();
                    }
                }
            }

            if (this.l != 3) {
                synchronized(this.u) {
                    this.u.clear();
                    this.u.notifyAll();
                }

                this.y.l();
                this.F.e();
                switch (this.l) {
                    case 0:
                    case 4:
                        this.l = 0;
                        throw new SocketException("Socket closed");
                    case 1:
                    case 3:
                    default:
                        return;
                    case 2:
                        this.k();
                        this.l = 0;
                        if (var5) {
                            throw new SocketTimeoutException();
                        } else {
                            throw new SocketException("Connection refused");
                        }
                }
            }
        }
    }

    public SocketChannel getChannel() {
        return null;
    }

    public InetAddress getInetAddress() {
        return !this.isConnected() ? null : ((InetSocketAddress)this.d).getAddress();
    }

    public int getPort() {
        return !this.isConnected() ? 0 : ((InetSocketAddress)this.d).getPort();
    }

    public SocketAddress getRemoteSocketAddress() {
        return !this.isConnected() ? null : new InetSocketAddress(this.getInetAddress(), this.getPort());
    }

    public SocketAddress c() {
        return this.d;
    }

    public InetAddress getLocalAddress() {
        return this.c.getLocalAddress();
    }

    public int getLocalPort() {
        return this.c.getLocalPort();
    }

    public SocketAddress getLocalSocketAddress() {
        return this.c.getLocalSocketAddress();
    }

    @SneakyThrows
    public synchronized InputStream getInputStream() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (this.isInputShutdown()) {
            throw new SocketException("Socket input is shutdown");
        } else {
            if (this.e == null) {
                this.e = new ReliableSocketInputStream(this);
            }

            return this.e;
        }
    }

    @SneakyThrows
    public synchronized OutputStream getOutputStream() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (this.isOutputShutdown()) {
            throw new SocketException("Socket output is shutdown");
        } else {
            if (this.f == null) {
                this.f = new ReliableSocketOutputStream(this);
            }

            return this.f;
        }
    }

    public void d() {
        this.b = true;
        this.l = 0;
        this.c.close();
    }

    public synchronized void close() {
        synchronized(this.q) {
            if (!this.isClosed()) {
                this.g();
                switch (this.l) {
                    case 0:
                        this.c.close();
                        break;
                    case 1:
                    case 3:
                    case 4:
                        this.a((Segment)(new FINSegment(this.y.a())));
                        this.e();
                        break;
                    case 2:
                        synchronized(this) {
                            this.notify();
                        }
                }

                if (this.l != 0) {
                    this.p = this.l;
                }

                this.b = true;
                this.l = 0;
                this.l();
                synchronized(this.u) {
                    this.u.notify();
                }

                synchronized(this.w) {
                    this.w.notify();
                }

            }
        }
    }

    public boolean isBound() {
        return this.c.isBound();
    }

    public boolean isConnected() {
        return this.i;
    }

    public boolean isClosed() {
        synchronized(this.q) {
            return this.b;
        }
    }

    public void setSoTimeout(int var1) {
        if (var1 < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else {
            this.m = var1;
        }
    }

    @SneakyThrows
    public synchronized void setSendBufferSize(int var1) {
        if (var1 <= 0) {
            throw new IllegalArgumentException("negative receive size");
        } else if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            this.C = var1;
        }
    }

    @SneakyThrows
    public synchronized int getSendBufferSize() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            return this.C;
        }
    }

    @SneakyThrows
    public synchronized void setReceiveBufferSize(int var1) {
        if (var1 <= 0) {
            throw new IllegalArgumentException("negative send size");
        } else if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            this.D = var1;
        }
    }

    @SneakyThrows
    public synchronized int getReceiveBufferSize() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            return this.D;
        }
    }

    public void setTcpNoDelay(boolean var1) {
    }

    public boolean getTcpNoDelay() {
        return false;
    }

    @SneakyThrows
    public synchronized void setKeepAlive(boolean var1) {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (this.k ^ var1) {
            this.k = var1;
            if (this.isConnected()) {
                if (this.k) {
                    this.H.a((long)(this.g.g() * 6), (long)(this.g.g() * 6));
                } else {
                    this.H.e();
                }
            }

        }
    }

    @SneakyThrows
    public synchronized boolean getKeepAlive() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else {
            return this.k;
        }
    }

    @SneakyThrows
    public void shutdownInput() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (this.isInputShutdown()) {
            throw new SocketException("Socket input is already shutdown");
        } else {
            this.n = true;
            synchronized(this.x) {
                this.x.notify();
            }
        }
    }

    @SneakyThrows
    public void shutdownOutput() {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (!this.isConnected()) {
            throw new SocketException("Socket is not connected");
        } else if (this.isOutputShutdown()) {
            throw new SocketException("Socket output is already shutdown");
        } else {
            this.o = true;
            synchronized(this.u) {
                this.u.notifyAll();
            }
        }
    }

    public boolean isInputShutdown() {
        return this.n;
    }

    public boolean isOutputShutdown() {
        return this.o;
    }

    protected void a(byte[] var1, int var2, int var3) {
        this.a(var1, var2, var3, false);
    }

    @SneakyThrows
    public void a(byte[] var1, int var2, int var3, boolean var4) {
        if (this.isClosed()) {
            throw new SocketException("Socket is closed");
        } else if (this.isOutputShutdown()) {
            throw new IOException("Socket output is shutdown");
        } else if (!this.isConnected()) {
            throw new SocketException("Connection reset");
        } else {
            int var5 = 0;

            while(var5 < var3) {
                synchronized(this.r) {
                    while(this.j) {
                        try {
                            this.r.wait();
                        } catch (InterruptedException var10) {
                            var10.printStackTrace();
                        }
                    }

                    int var7 = Math.min(this.g.a() - 6, var3 - var5);
                    DATSegment var8 = new DATSegment(this.y.a(), this.y.b(), var1, var2 + var5, var7);
                    this.e((Segment)var8);
                    if (var4) {
                        this.a((Segment)var8);
                    }

                    var5 += var7;
                }
            }

        }
    }

    @SneakyThrows
    protected int b(byte[] var1, int var2, int var3) {
        int var4 = 0;
        synchronized(this.x) {
            while(true) {
                while(!this.w.isEmpty()) {
                    Iterator var6 = this.w.iterator();

                    while(var6.hasNext()) {
                        Segment var7 = (Segment)var6.next();
                        if (var7 instanceof RSTSegment) {
                            var6.remove();
                            break;
                        }

                        if (var7 instanceof FINSegment) {
                            if (var4 <= 0) {
                                var6.remove();
                                return -1;
                            }
                            break;
                        }

                        if (var7 instanceof DATSegment) {
                            byte[] var8 = ((DATSegment)var7).c();
                            if (var8.length + var4 > var3) {
                                if (var4 <= 0) {
                                    throw new IOException("insufficient buffer space");
                                }
                                break;
                            }

                            System.arraycopy(var8, 0, var1, var2 + var4, var8.length);
                            var4 += var8.length;
                            var6.remove();
                        }
                    }

                    if (var4 > 0) {
                        return var4;
                    }
                }

                if (this.isClosed()) {
                    throw new SocketException("Socket is closed");
                }

                if (this.isInputShutdown()) {
                    throw new EOFException();
                }

                if (!this.isConnected()) {
                    throw new SocketException("Connection reset");
                }

                try {
                    if (this.m == 0) {
                        this.x.wait();
                    } else {
                        long var12 = System.currentTimeMillis();
                        this.x.wait((long)this.m);
                        if (System.currentTimeMillis() - var12 >= (long)this.m) {
                            throw new SocketTimeoutException();
                        }
                    }
                } catch (InterruptedException var10) {
                    if (I) {
                        var10.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(ReliableSocketStateListener var1) {
        if (var1 == null) {
            throw new NullPointerException("stateListener");
        } else {
            synchronized(this.t) {
                if (!this.t.contains(var1)) {
                    this.t.add(var1);
                }

            }
        }
    }

    private void a(Segment var1) {
        if (var1 instanceof DATSegment || var1 instanceof RSTSegment || var1 instanceof FINSegment || var1 instanceof NULSegment) {
            this.h(var1);
        }

        if (var1 instanceof DATSegment || var1 instanceof RSTSegment || var1 instanceof FINSegment) {
            this.E.d();
        }

        if (I) {
            this.a("sent " + var1);
        }

        this.d(var1);
    }

    private Segment i() {
        Segment var1;
        if ((var1 = this.a()) != null) {
            if (I) {
                this.a("recv " + var1);
            }

            if (var1 instanceof DATSegment || var1 instanceof NULSegment || var1 instanceof RSTSegment || var1 instanceof FINSegment || var1 instanceof SYNSegment) {
                this.y.c();
            }

            if (this.k) {
                this.H.d();
            }
        }

        return var1;
    }

    @SneakyThrows
    private void e(Segment var1) {
        synchronized(this.u) {
            while(this.u.size() >= this.A || this.y.j() > this.g.b()) {
                if (this.b) {
                    throw new SocketException("Socket is closed");
                }

                try {
                    this.u.wait(10000L);
                } catch (InterruptedException var8) {
                    var8.printStackTrace();
                }
            }

            this.y.i();
            this.u.add(var1);
        }

        if (this.b) {
            throw new SocketException("Socket is closed");
        } else {
            if (!(var1 instanceof EAKSegment) && !(var1 instanceof ACKSegment)) {
                synchronized(this.F) {
                    if (this.F.c()) {
                        this.F.a((long)this.g.h(), (long)this.g.h());
                    }
                }
            }

            this.a(var1);
            if (var1 instanceof DATSegment) {
                synchronized(this.s) {
                    Iterator var3 = this.s.iterator();

                    while(var3.hasNext()) {
                        class_23 var4 = (class_23)var3.next();
                        var4.a();
                    }
                }
            }

        }
    }

    private void f(Segment var1) {
        if (this.g.c() > 0) {
            var1.b(var1.getRetxCounter() + 1);
        }

        if (this.g.c() != 0 && var1.getRetxCounter() > this.g.c()) {
            this.m();
        } else {
            this.a(var1);
            if (var1 instanceof DATSegment) {
                synchronized(this.s) {
                    Iterator var3 = this.s.iterator();

                    while(var3.hasNext()) {
                        class_23 var4 = (class_23)var3.next();
                        var4.b();
                    }
                }
            }

        }
    }

    private void j() {
        if (this.isConnected()) {
            this.E.e();
            if (this.k) {
                this.H.e();
            }

            synchronized(this.r) {
                this.j = false;
                this.r.notify();
            }
        } else {
            synchronized(this) {
                this.f();
                this.i = true;
                this.l = 3;
                this.notify();
            }

            synchronized(this.t) {
                Iterator var2 = this.t.iterator();

                while(var2.hasNext()) {
                    ReliableSocketStateListener var3 = (ReliableSocketStateListener)var2.next();
                    var3.a(this);
                }
            }
        }

        this.E.a(0L, (long)this.g.g());
        if (this.k) {
            this.H.a((long)(this.g.g() * 6), (long)(this.g.g() * 6));
        }

    }

    private void k() {
        synchronized(this.t) {
            Iterator var2 = this.t.iterator();

            while(var2.hasNext()) {
                ReliableSocketStateListener var3 = (ReliableSocketStateListener)var2.next();
                var3.b(this);
            }

        }
    }

    private void l() {
        synchronized(this.t) {
            Iterator var2 = this.t.iterator();

            while(var2.hasNext()) {
                ReliableSocketStateListener var3 = (ReliableSocketStateListener)var2.next();
                var3.c(this);
            }

        }
    }

    private void m() {
        synchronized(this.q) {
            if (this.isClosed()) {
                return;
            }

            switch (this.l) {
                case 1:
                case 3:
                case 4:
                    this.i = false;
                    synchronized(this.u) {
                        this.u.notifyAll();
                    }

                    synchronized(this.x) {
                        this.x.notify();
                    }

                    this.e();
                    break;
                case 2:
                    synchronized(this) {
                        this.notify();
                    }
            }

            this.l = 0;
            this.b = true;
        }

        synchronized(this.t) {
            Iterator var2 = this.t.iterator();

            while(var2.hasNext()) {
                ReliableSocketStateListener var3 = (ReliableSocketStateListener)var2.next();
                var3.d(this);
            }

        }
    }

    private void n() {
        synchronized(this.t) {
            Iterator var2 = this.t.iterator();

            while(var2.hasNext()) {
                ReliableSocketStateListener var3 = (ReliableSocketStateListener)var2.next();
                var3.e(this);
            }

        }
    }

    protected void a(SYNSegment var1) {
        switch (this.l) {
            case 0:
                this.l = 1;
                this.g = new ReliableSocketProfile(this.A, this.B, var1.e(), var1.c(), var1.i(), var1.j(), var1.k(), var1.l(), var1.h(), var1.f(), var1.g());
                this.y.b(var1.m());
                Random var2 = new Random(System.currentTimeMillis());
                SYNSegment var9 = new SYNSegment(this.y.a(var2.nextInt(255)), this.g.b(), this.g.a(), this.g.h(), this.g.i(), this.g.g(), this.g.c(), this.g.d(), this.g.e(), this.g.f());
                var9.setAck(var1.m());
                this.e((Segment)var9);
                break;
            case 1:
                synchronized(this.u) {
                    Iterator var3 = this.u.iterator();

                    while(var3.hasNext()) {
                        Segment var4 = (Segment)var3.next();

                        try {
                            this.f(var4);
                        } catch (Exception var7) {
                            var7.printStackTrace();
                        }
                    }

                    return;
                }
            case 2:
                this.y.b(var1.m());
                this.l = 3;
                this.o();
                this.j();
        }

    }

    private void a(EAKSegment var1) {
        int[] var3 = var1.c();
        int var4 = var1.getAck();
        int var5 = var3[var3.length - 1];
        synchronized(this.u) {
            Iterator var2 = this.u.iterator();

            while(true) {
                Segment var7;
                while(var2.hasNext()) {
                    var7 = (Segment)var2.next();
                    if (this.a(var7.m(), var4) <= 0) {
                        var2.remove();
                    } else {
                        for(int var8 = 0; var8 < var3.length; ++var8) {
                            if (this.a(var7.m(), var3[var8]) == 0) {
                                var2.remove();
                                break;
                            }
                        }
                    }
                }

                var2 = this.u.iterator();

                while(var2.hasNext()) {
                    var7 = (Segment)var2.next();
                    if (this.a(var4, var7.m()) < 0 && this.a(var5, var7.m()) > 0) {
                        try {
                            this.f(var7);
                        } catch (Exception var10) {
                            var10.printStackTrace();
                        }
                    }
                }

                this.u.notifyAll();
                return;
            }
        }
    }

    private void g(Segment var1) {
        if (var1 instanceof RSTSegment) {
            synchronized(this.r) {
                this.j = true;
            }

            this.n();
        }

        if (var1 instanceof FINSegment) {
            switch (this.l) {
                case 0:
                    break;
                case 2:
                    synchronized(this) {
                        this.notify();
                        break;
                    }
                default:
                    this.l = 4;
            }
        }

        boolean var2 = false;
        synchronized(this.x) {
            if (this.a(var1.m(), this.y.b()) > 0) {
                if (this.a(var1.m(), b(this.y.b())) == 0) {
                    var2 = true;
                    if (this.w.size() == 0 || this.w.size() + this.v.size() < this.B) {
                        this.y.b(var1.m());
                        if (var1 instanceof DATSegment || var1 instanceof RSTSegment || var1 instanceof FINSegment) {
                            this.w.add(var1);
                        }

                        if (var1 instanceof DATSegment) {
                            synchronized(this.s) {
                                Iterator var5 = this.s.iterator();

                                while(var5.hasNext()) {
                                    class_23 var6 = (class_23)var5.next();
                                    var6.c();
                                }
                            }
                        }

                        this.r();
                    }
                } else if (this.w.size() + this.v.size() < this.B) {
                    boolean var4 = false;

                    for(int var17 = 0; var17 < this.v.size() && !var4; ++var17) {
                        Segment var18 = (Segment)this.v.get(var17);
                        int var7 = this.a(var1.m(), var18.m());
                        if (var7 == 0) {
                            var4 = true;
                        } else if (var7 < 0) {
                            this.v.add(var17, var1);
                            var4 = true;
                        }
                    }

                    if (!var4) {
                        this.v.add(var1);
                    }

                    this.y.f();
                    if (var1 instanceof DATSegment) {
                        synchronized(this.s) {
                            Iterator var19 = this.s.iterator();

                            while(var19.hasNext()) {
                                class_23 var20 = (class_23)var19.next();
                                var20.d();
                            }
                        }
                    }
                }
            }

            if (var2 && (var1 instanceof RSTSegment || var1 instanceof NULSegment || var1 instanceof FINSegment)) {
                this.o();
            } else if (this.y.g() <= 0 || this.g.e() != 0 && this.y.g() <= this.g.e()) {
                if (this.y.d() > 0 && (this.g.d() == 0 || this.y.d() > this.g.d())) {
                    this.q();
                } else {
                    synchronized(this.G) {
                        if (this.G.c()) {
                            this.G.a((long)this.g.i());
                        }
                    }
                }
            } else {
                this.p();
            }

        }
    }

    private void o() {
        synchronized(this.x) {
            if (!this.v.isEmpty()) {
                this.p();
            } else {
                this.q();
            }
        }
    }

    private void p() {
        synchronized(this.x) {
            if (!this.v.isEmpty()) {
                this.y.e();
                this.y.h();
                int[] var2 = new int[this.v.size()];

                int var3;
                for(var3 = 0; var3 < var2.length; ++var3) {
                    Segment var4 = (Segment)this.v.get(var3);
                    var2[var3] = var4.m();
                }

                try {
                    var3 = this.y.b();
                    this.a((Segment)(new EAKSegment(b(var3), var3, var2)));
                } catch (Exception var6) {
                    var6.printStackTrace();
                }

            }
        }
    }

    private void q() {
        if (this.y.e() != 0) {
            try {
                int var1 = this.y.b();
                this.a((Segment)(new ACKSegment(b(var1), var1)));
            } catch (Exception var2) {
                var2.printStackTrace();
            }

        }
    }

    private void h(Segment var1) {
        if (this.y.e() != 0) {
            var1.setAck(this.y.b());
        }
    }

    protected boolean b(Segment var1) {
        int var2 = var1.getAck();
        if (var2 < 0) {
            return false;
        } else {
            Iterator var3 = this.u.iterator();

            Segment var4;
            do {
                if (!var3.hasNext()) {
                    return false;
                }

                var4 = (Segment)var3.next();
            } while(this.a(var4.m(), var2) > 0);

            return true;
        }
    }

    protected void c(Segment var1) {
        int var2 = var1.getAck();
        if (var2 >= 0) {
            this.y.k();
            synchronized(this.u) {
                Iterator var4 = this.u.iterator();

                while(var4.hasNext()) {
                    Segment var5 = (Segment)var4.next();
                    if (this.a(var5.m(), var2) <= 0) {
                        var4.remove();
                    }
                }

                if (this.l == 1) {
                    boolean var9 = false;
                    if (!this.u.isEmpty()) {
                        Iterator var10 = this.u.iterator();

                        while(var10.hasNext()) {
                            Segment var6 = (Segment)var10.next();
                            if (var6 instanceof SYNSegment) {
                                var9 = true;
                            }
                        }
                    }

                    if (var9) {
                        this.a("Bad first ack: " + var2);
                        return;
                    }

                    this.l = 3;
                    this.j();
                }

                if (this.u.isEmpty()) {
                    this.F.e();
                }

                this.u.notifyAll();
            }
        }
    }

    private void r() {
        synchronized(this.x) {
            Iterator var2 = this.v.iterator();

            while(true) {
                Segment var3;
                do {
                    if (!var2.hasNext()) {
                        this.x.notify();
                        return;
                    }

                    var3 = (Segment)var2.next();
                } while(this.a(var3.m(), b(this.y.b())) != 0);

                this.y.b(var3.m());
                if (var3 instanceof DATSegment || var3 instanceof RSTSegment || var3 instanceof FINSegment) {
                    this.w.add(var3);
                }

                var2.remove();
            }
        }
    }

    protected void d(Segment var1) {
        try {
            DatagramPacket var2 = new DatagramPacket(var1.getBytes(), var1.b(), this.d);
            this.c.send(var2);
        } catch (IOException var3) {
            if (!this.isClosed()) {
                var3.printStackTrace();
            }
        }

    }

    protected Segment a() {
        try {
            if (this.a == null) {
                this.a = new byte['\uffff'];
            }

            DatagramPacket var1 = new DatagramPacket(this.a, this.a.length);
            this.c.receive(var1);
            return Segment.parse(var1.getData(), 0, var1.getLength());
        } catch (IOException var2) {
            if (!this.isClosed()) {
                var2.printStackTrace();
            }

            return null;
        }
    }

    protected void b() {
        this.c.close();
    }

    protected void e() {
        this.E.e();
        this.H.e();
        this.l = 4;
        ReliableSocket$1 var1 = new ReliableSocket$1(this);
        var1.setName("ReliableSocket-Closing");
        var1.setDaemon(true);
        var1.start();
    }

    protected synchronized void a(String var1) {
        System.out.println(this.getLocalPort() + ": " + var1);
    }

    private static int b(int var0) {
        return (var0 + 1) % 255;
    }

    private int a(int var1, int var2) {
        if (var1 == var2) {
            return 0;
        } else {
            return (var1 >= var2 || var2 - var1 <= 127) && (var1 <= var2 || var1 - var2 >= 127) ? -1 : 1;
        }
    }

    public synchronized void f() {
        if (!this.h) {
            this.h = true;
            this.E.a();
            this.F.a();
            this.G.a();
            this.H.a();
        }

    }

    public synchronized void g() {
        if (this.h) {
            this.h = false;
            this.F.f();
            this.G.f();
            this.H.f();
            this.E.f();
        }

    }

    // $FF: synthetic method
    static Timer a(ReliableSocket var0) {
        return var0.H;
    }

    // $FF: synthetic method
    static Timer b(ReliableSocket var0) {
        return var0.E;
    }

    // $FF: synthetic method
    static Timer c(ReliableSocket var0) {
        return var0.F;
    }

    // $FF: synthetic method
    static Timer d(ReliableSocket var0) {
        return var0.G;
    }

    // $FF: synthetic method
    static void e(ReliableSocket var0) {
        var0.l();
    }

    // $FF: synthetic method
    static int a(int var0) {
        return b(var0);
    }

    // $FF: synthetic method
    static Segment f(ReliableSocket var0) {
        return var0.i();
    }

    // $FF: synthetic method
    static void a(ReliableSocket var0, EAKSegment var1) {
        var0.a(var1);
    }

    // $FF: synthetic method
    static void a(ReliableSocket var0, Segment var1) {
        var0.g(var1);
    }

    // $FF: synthetic method
    static ArrayList g(ReliableSocket var0) {
        return var0.u;
    }

    // $FF: synthetic method
    static class_767 h(ReliableSocket var0) {
        return var0.y;
    }

    // $FF: synthetic method
    static void b(ReliableSocket var0, Segment var1) {
        var0.e(var1);
    }

    // $FF: synthetic method
    static boolean h() {
        return I;
    }

    // $FF: synthetic method
    static void c(ReliableSocket var0, Segment var1) {
        var0.f(var1);
    }

    // $FF: synthetic method
    static void i(ReliableSocket var0) {
        var0.o();
    }

    // $FF: synthetic method
    static void j(ReliableSocket var0) {
        var0.m();
    }
}
