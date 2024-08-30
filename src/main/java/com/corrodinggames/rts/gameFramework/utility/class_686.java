package com.corrodinggames.rts.gameFramework.utility;

import com.corrodinggames.rts.gameFramework.GameObject;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

// $FF: renamed from: com.corrodinggames.rts.gameFramework.utility.s
public final strictfp class class_686 extends AbstractList implements Serializable, Cloneable, RandomAccess {
    public static final GameObject[] a = new GameObject[0];
    int b;
    transient GameObject[] c;
    String d;

    public class_686(String var1) {
        this.c = a;
        this.d = var1;
    }

    public GameObject[] a() {
        return this.c;
    }

    public boolean a(GameObject var1) {
        GameObject[] var2 = this.c;
        int var3 = this.b;
        if (var3 == var2.length) {
            GameObject[] var4 = new GameObject[var3 + (var3 < 6 ? 12 : var3 >> 1)];
            System.arraycopy(var2, 0, var4, 0, var3);
            var2 = var4;
            this.c = var4;
        }

        var2[var3] = var1;
        this.b = var3 + 1;
        ++this.modCount;
        return true;
    }

    public void a(int var1, GameObject var2) {
        GameObject[] var3 = this.c;
        int var4 = this.b;
        if (var1 > var4 || var1 < 0) {
            a(var1, var4);
        }

        if (var4 < var3.length) {
            System.arraycopy(var3, var1, var3, var1 + 1, var4 - var1);
        } else {
            GameObject[] var5 = new GameObject[c(var4)];
            System.arraycopy(var3, 0, var5, 0, var1);
            System.arraycopy(var3, var1, var5, var1 + 1, var4 - var1);
            var3 = var5;
            this.c = var5;
        }

        var3[var1] = var2;
        this.b = var4 + 1;
        ++this.modCount;
    }

    private static int c(int var0) {
        int var1 = var0 < 6 ? 12 : var0 >> 1;
        return var0 + var1;
    }

    public boolean addAll(Collection var1) {
        GameObject[] var2 = (GameObject[])((GameObject[])var1.toArray());
        int var3 = var2.length;
        if (var3 == 0) {
            return false;
        } else {
            GameObject[] var4 = this.c;
            int var5 = this.b;
            int var6 = var5 + var3;
            if (var6 > var4.length) {
                int var7 = c(var6 - 1);
                GameObject[] var8 = new GameObject[var7];
                System.arraycopy(var4, 0, var8, 0, var5);
                var4 = var8;
                this.c = var8;
            }

            System.arraycopy(var2, 0, var4, var5, var3);
            this.b = var6;
            ++this.modCount;
            return true;
        }
    }

    public boolean addAll(int var1, Collection var2) {
        int var3 = this.b;
        if (var1 > var3 || var1 < 0) {
            a(var1, var3);
        }

        GameObject[] var4 = (GameObject[])((GameObject[])var2.toArray());
        int var5 = var4.length;
        if (var5 == 0) {
            return false;
        } else {
            GameObject[] var6 = this.c;
            int var7 = var3 + var5;
            if (var7 <= var6.length) {
                System.arraycopy(var6, var1, var6, var1 + var5, var3 - var1);
            } else {
                int var8 = c(var7 - 1);
                GameObject[] var9 = new GameObject[var8];
                System.arraycopy(var6, 0, var9, 0, var1);
                System.arraycopy(var6, var1, var9, var1 + var5, var3 - var1);
                var6 = var9;
                this.c = var9;
            }

            System.arraycopy(var4, 0, var6, var1, var5);
            this.b = var7;
            ++this.modCount;
            return true;
        }
    }

    static IndexOutOfBoundsException a(int var0, int var1) {
        throw new IndexOutOfBoundsException("Invalid index " + var0 + ", size is " + var1);
    }

    public void clear() {
        if (this.b != 0) {
            Arrays.fill(this.c, 0, this.b, (Object)null);
            this.b = 0;
            ++this.modCount;
        }

    }

    public void b() {
        if (this.b != 0) {
            this.b = 0;
            ++this.modCount;
        }

    }

    public Object clone() {
        try {
            class_686 var1 = (class_686)super.clone();
            var1.c = (GameObject[])this.c.clone();
            return var1;
        } catch (CloneNotSupportedException var2) {
            throw new AssertionError();
        }
    }

    public GameObject a(int var1) {
        if (var1 >= this.b) {
            a(var1, this.b);
        }

        return this.c[var1];
    }

    public int size() {
        return this.b;
    }

    public boolean isEmpty() {
        return this.b == 0;
    }

    public boolean contains(Object var1) {
        GameObject[] var2 = this.c;
        int var3 = this.b;
        int var4;
        if (var1 != null) {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var1.equals(var2[var4])) {
                    return true;
                }
            }
        } else {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == null) {
                    return true;
                }
            }
        }

        return false;
    }

    public int indexOf(Object var1) {
        GameObject[] var2 = this.c;
        int var3 = this.b;
        int var4;
        if (var1 != null) {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var1.equals(var2[var4])) {
                    return var4;
                }
            }
        } else {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == null) {
                    return var4;
                }
            }
        }

        return -1;
    }

    public int lastIndexOf(Object var1) {
        GameObject[] var2 = this.c;
        int var3;
        if (var1 != null) {
            for(var3 = this.b - 1; var3 >= 0; --var3) {
                if (var1.equals(var2[var3])) {
                    return var3;
                }
            }
        } else {
            for(var3 = this.b - 1; var3 >= 0; --var3) {
                if (var2[var3] == null) {
                    return var3;
                }
            }
        }

        return -1;
    }

    public GameObject b(int var1) {
        GameObject[] var2 = this.c;
        int var3 = this.b;
        if (var1 >= var3) {
            a(var1, var3);
        }

        GameObject var4 = (GameObject)var2[var1];
        int var10001 = var1 + 1;
        --var3;
        System.arraycopy(var2, var10001, var2, var1, var3 - var1);
        var2[var3] = null;
        this.b = var3;
        ++this.modCount;
        return var4;
    }

    public boolean remove(Object var1) {
        GameObject[] var2 = this.c;
        int var3 = this.b;
        int var10001;
        int var4;
        if (var1 != null) {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var1.equals(var2[var4])) {
                    var10001 = var4 + 1;
                    --var3;
                    System.arraycopy(var2, var10001, var2, var4, var3 - var4);
                    var2[var3] = null;
                    this.b = var3;
                    ++this.modCount;
                    return true;
                }
            }
        } else {
            for(var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == null) {
                    var10001 = var4 + 1;
                    --var3;
                    System.arraycopy(var2, var10001, var2, var4, var3 - var4);
                    var2[var3] = null;
                    this.b = var3;
                    ++this.modCount;
                    return true;
                }
            }
        }

        return false;
    }

    protected void removeRange(int var1, int var2) {
        if (var1 != var2) {
            GameObject[] var3 = this.c;
            int var4 = this.b;
            if (var1 >= var4) {
                throw new IndexOutOfBoundsException("fromIndex " + var1 + " >= size " + this.b);
            } else if (var2 > var4) {
                throw new IndexOutOfBoundsException("toIndex " + var2 + " > size " + this.b);
            } else if (var1 > var2) {
                throw new IndexOutOfBoundsException("fromIndex " + var1 + " > toIndex " + var2);
            } else {
                System.arraycopy(var3, var2, var3, var1, var4 - var2);
                int var5 = var2 - var1;
                Arrays.fill(var3, var4 - var5, var4, (Object)null);
                this.b = var4 - var5;
                ++this.modCount;
            }
        }
    }

    public GameObject b(int var1, GameObject var2) {
        GameObject[] var3 = this.c;
        if (var1 >= this.b) {
            a(var1, this.b);
        }

        GameObject var4 = (GameObject)var3[var1];
        var3[var1] = var2;
        return var4;
    }

    public Object[] toArray() {
        int var1 = this.b;
        Object[] var2 = new Object[var1];
        System.arraycopy(this.c, 0, var2, 0, var1);
        return var2;
    }

    public Object[] toArray(Object[] var1) {
        int var2 = this.b;
        if (var1.length < var2) {
            Object[] var3 = (Object[])((Object[])Array.newInstance(var1.getClass().getComponentType(), var2));
            var1 = var3;
        }

        System.arraycopy(this.c, 0, var1, 0, var2);
        if (var1.length > var2) {
            var1[var2] = null;
        }

        return var1;
    }

    public Iterator iterator() {
        return new class_687(this, (class_947)null);
    }

    public int hashCode() {
        GameObject[] var1 = this.c;
        int var2 = 1;
        int var3 = 0;

        for(int var4 = this.b; var3 < var4; ++var3) {
            GameObject var5 = var1[var3];
            var2 = 31 * var2 + (var5 == null ? 0 : var5.hashCode());
        }

        return var2;
    }

    public boolean equals(Object var1) {
        if (var1 == this) {
            return true;
        } else if (!(var1 instanceof List)) {
            return false;
        } else {
            List var2 = (List)var1;
            int var3 = this.b;
            if (var2.size() != var3) {
                return false;
            } else {
                GameObject[] var4 = this.c;
                if (!(var2 instanceof RandomAccess)) {
                    Iterator var9 = var2.iterator();

                    for(int var10 = 0; var10 < var3; ++var10) {
                        GameObject var11 = var4[var10];
                        Object var8 = var9.next();
                        if (var11 == null) {
                            if (var8 != null) {
                                return false;
                            }
                        } else if (!var11.equals(var8)) {
                            return false;
                        }
                    }

                    return true;
                } else {
                    int var5 = 0;

                    while(true) {
                        if (var5 >= var3) {
                            return true;
                        }

                        GameObject var6 = var4[var5];
                        Object var7 = var2.get(var5);
                        if (var6 == null) {
                            if (var7 != null) {
                                break;
                            }
                        } else if (!var6.equals(var7)) {
                            break;
                        }

                        ++var5;
                    }

                    return false;
                }
            }
        }
    }

    // $FF: synthetic method
    public Object remove(int var1) {
        return this.b(var1);
    }

    // $FF: synthetic method
    public void add(int var1, Object var2) {
        this.a(var1, (GameObject)var2);
    }

    // $FF: synthetic method
    public Object set(int var1, Object var2) {
        return this.b(var1, (GameObject)var2);
    }

    // $FF: synthetic method
    public Object get(int var1) {
        return this.a(var1);
    }

    // $FF: synthetic method
    public boolean add(Object var1) {
        return this.a((GameObject)var1);
    }

    // $FF: synthetic method
    static int a(class_686 var0) {
        return var0.modCount;
    }

    // $FF: synthetic method
    static int b(class_686 var0) {
        return var0.modCount;
    }

    // $FF: synthetic method
    static int c(class_686 var0) {
        return var0.modCount;
    }

    // $FF: synthetic method
    static int d(class_686 var0) {
        return var0.modCount;
    }

    // $FF: synthetic method
    static int e(class_686 var0) {
        return var0.modCount;
    }

    // $FF: synthetic method
    static int f(class_686 var0) {
        return ++var0.modCount;
    }
}
