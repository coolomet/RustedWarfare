package net.rudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.Map;
import net.rudp.p002a.ACKSegment;
import net.rudp.p002a.SYNSegment;
import net.rudp.p002a.Segment;

// $FF: renamed from: net.rudp.d
class class_765 extends Thread {
    // $FF: synthetic field
    final ReliableServerSocket a;

    public class_765(ReliableServerSocket var1) {
        super("ReliableServerSocket");
        this.a = var1;
        this.setDaemon(true);
    }

    public void run() {
        byte[] var1 = new byte['\uffff'];

        while(true) {
            DatagramPacket var2 = new DatagramPacket(var1, var1.length);
            class_663 var3 = null;
            SocketAddress var4 = null;

            try {
                try {
                    ReliableServerSocket.a(this.a).receive(var2);
                } catch (IOException var12) {
                    ReliableServerSocket.a(this.a, "IOException receiving packet:" + var12.getMessage() + " isConnected:" + ReliableServerSocket.a(this.a).isConnected());
                    if (!ReliableServerSocket.a(this.a).isConnected()) {
                        this.a.close();
                    }

                    throw new IOException(var12);
                }

                var4 = var2.getSocketAddress();
                synchronized(ReliableServerSocket.b(this.a)) {
                    class_711 var6 = (class_711)ReliableServerSocket.c(this.a).get(var4);
                    if (var6 != null) {
                        var6.a(var2.getData(), var2.getLength());
                        continue;
                    }
                }

                synchronized(ReliableServerSocket.b(this.a)) {
                    var3 = (class_663)ReliableServerSocket.b(this.a).get(var4);
                }

                if (var3 == null) {
                    class_766 var5 = this.a.a;
                    if (var5 != null && !var5.a(var4)) {
                        continue;
                    }
                }

                Segment var16 = Segment.parse(var2.getData(), 0, var2.getLength());
                if (!this.a.isClosed() && var3 == null) {
                    if (var16 instanceof SYNSegment) {
                        long var17 = System.currentTimeMillis();
                        if (ReliableServerSocket.d(this.a).size() > 0) {
                            short var8 = 10000;
                            if (ReliableServerSocket.d(this.a).size() > 20) {
                                var8 = 5000;
                            }

                            if (ReliableServerSocket.d(this.a).size() > 200) {
                                var8 = 3000;
                            }

                            Iterator var9 = ReliableServerSocket.d(this.a).entrySet().iterator();

                            while(var9.hasNext()) {
                                Map.Entry var10 = (Map.Entry)var9.next();
                                if (((class_768)var10.getValue()).a + (long)var8 < var17) {
                                    var9.remove();
                                }
                            }
                        }

                        class_768 var19 = (class_768)ReliableServerSocket.d(this.a).get(var4);
                        if (var19 != null) {
                            var19.b.a((SYNSegment)((SYNSegment)var16));
                        } else {
                            var19 = new class_768();
                            var19.a = var17;
                            var19.b = new class_663(this.a, ReliableServerSocket.a(this.a), var4);
                            var19.b.a((SYNSegment)((SYNSegment)var16));
                            ReliableServerSocket.d(this.a).put(var4, var19);
                        }
                    }

                    if (var16 instanceof ACKSegment) {
                        class_768 var18 = (class_768)ReliableServerSocket.d(this.a).get(var4);
                        if (var18 != null) {
                            class_663 var7 = var18.b;
                            if (!var7.b(var16)) {
                                ReliableServerSocket.a(this.a, "lightweight ack failed ack:" + var16.getAck());
                                continue;
                            }

                            ReliableServerSocket.a(this.a, var4, var7);
                            var3 = var7;
                            ReliableServerSocket.d(this.a).remove(var4);
                        }
                    }
                }

                if (var3 != null) {
                    var3.a(var16);
                }
                continue;
            } catch (IOException var14) {
                if (!this.a.isClosed()) {
                    ReliableServerSocket.a(this.a, "IOException client " + var4 + " - " + var14.getMessage());
                    continue;
                }
            } catch (IllegalArgumentException var15) {
                if (!this.a.isClosed()) {
                    ReliableServerSocket.a(this.a, "IllegalArgumentException " + var4 + " - " + var15.getMessage());
                    continue;
                }
            }

            return;
        }
    }
}
