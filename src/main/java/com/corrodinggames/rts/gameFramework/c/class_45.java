package com.corrodinggames.rts.gameFramework.c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.c.b
public strictfp class class_45 implements Runnable {
    Socket a;
    // $FF: synthetic field
    final class_39 b;

    public class_45(class_39 var1, Socket var2) {
        this.b = var1;
        this.a = var2;
    }

    public strictfp void run() {
        try {
            PrintWriter var1 = new PrintWriter(this.a.getOutputStream(), true);
            BufferedReader var2 = new BufferedReader(new InputStreamReader(this.a.getInputStream()));

            while(this.b.i) {
                String var3 = var2.readLine();
                if (var3 == null) {
                    break;
                }

                String var4 = class_39.a(var3);
                var1.print(var4);
                var1.flush();
            }
        } catch (IOException var13) {
            var13.printStackTrace();
        } finally {
            try {
                this.a.close();
            } catch (IOException var12) {
                var12.printStackTrace();
            }

        }

    }
}
