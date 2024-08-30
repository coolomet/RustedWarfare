package com.corrodinggames.rts.gameFramework.net;

import com.corrodinggames.rts.gameFramework.GameEngine;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;

public strictfp class RelayForwardedSocket extends Socket {
    PlayerConnect a;
    int b;
    boolean c = false;
    RFSInStream d;
    RFSOutStream e;

    public void a(Packet var1) {
        this.a.a((Packet)(new Unk_Packet(this.b, var1)));
    }

    public RelayForwardedSocket(PlayerConnect var1, int var2) {
        this.a = var1;
        this.b = var2;
        this.d = new RFSInStream(this);
        this.e = new RFSOutStream(this);
    }

    public void bind(SocketAddress var1) {
        throw new RuntimeException("Not supported");
    }

    public synchronized void close() {
        if (!this.c) {
            this.c = true;
            GameEngine.log("Closing steam socket");
        }

        if (this.d != null) {
            this.d.a(new byte[0]);
        }

    }

    public void connect(SocketAddress var1, int var2) {
        throw new RuntimeException("Not supported");
    }

    public void connect(SocketAddress var1) {
        throw new RuntimeException("Not supported");
    }

    public SocketChannel getChannel() {
        throw new RuntimeException("Not supported");
    }

    public InetAddress getInetAddress() {
        return null;
    }

    public InetAddress getLocalAddress() {
        return null;
    }

    public SocketAddress getLocalSocketAddress() {
        return null;
    }

    public SocketAddress getRemoteSocketAddress() {
        return null;
    }

    public InputStream getInputStream() {
        return this.d;
    }

    public boolean getKeepAlive() {
        return true;
    }

    public int getLocalPort() {
        return 5555;
    }

    public boolean getOOBInline() {
        return false;
    }

    public OutputStream getOutputStream() {
        return this.e;
    }

    public int getPort() {
        return 5555;
    }

    public synchronized int getReceiveBufferSize() {
        return 512;
    }

    public boolean getReuseAddress() {
        return false;
    }

    public synchronized int getSendBufferSize() {
        return 512;
    }

    public int getSoLinger() {
        return 0;
    }

    public synchronized int getSoTimeout() {
        return 0;
    }

    public boolean getTcpNoDelay() {
        return true;
    }

    public int getTrafficClass() {
        return 0;
    }

    public boolean isBound() {
        return true;
    }

    public boolean isClosed() {
        return this.c;
    }

    public boolean isConnected() {
        return true;
    }

    public boolean isInputShutdown() {
        return this.d != null;
    }

    public boolean isOutputShutdown() {
        return this.e != null;
    }

    public void sendUrgentData(int var1) {
    }

    public void setKeepAlive(boolean var1) {
    }

    public void setOOBInline(boolean var1) {
    }

    public void setPerformancePreferences(int var1, int var2, int var3) {
    }

    public synchronized void setReceiveBufferSize(int var1) {
    }

    public void setReuseAddress(boolean var1) {
    }

    public synchronized void setSendBufferSize(int var1) {
    }

    public void setSoLinger(boolean var1, int var2) {
    }

    public synchronized void setSoTimeout(int var1) {
    }

    public void setTcpNoDelay(boolean var1) {
    }

    public void setTrafficClass(int var1) {
    }

    public void shutdownInput() {
    }

    public void shutdownOutput() {
    }

    public String toString() {
        return "<ForwardedSocket>";
    }
}
