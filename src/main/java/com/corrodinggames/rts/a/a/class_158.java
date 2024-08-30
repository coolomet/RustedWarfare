package com.corrodinggames.rts.a.a;

import com.corrodinggames.rts.debug.test.AbstractScriptTest;
import com.corrodinggames.rts.game.PlayerData;
import com.corrodinggames.rts.game.units.Unit;
import com.corrodinggames.rts.game.units.OrderableUnit;
import com.corrodinggames.rts.game.units.custom.class_113;
import com.corrodinggames.rts.game.units.custom.class_585;
import com.corrodinggames.rts.game.units.custom.class_591;
import com.corrodinggames.rts.game.units.custom.logicBooleans.BooleanParseException;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBoolean$ReturnType;
import com.corrodinggames.rts.game.units.custom.logicBooleans.LogicBooleanLoader;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope;
import com.corrodinggames.rts.game.units.custom.logicBooleans.VariableScope$MemoryWriter;
import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.class_340;

// $FF: renamed from: com.corrodinggames.rts.a.a.c
public strictfp class class_158 extends AbstractScriptTest {
    public void a() {
        GameEngine.log("Logic boolean tests");
        class_591 var1 = class_591.b;
        this.a(var1, "number numA");
        this.a(var1, "number numB");
        this.a(var1, "number[] numArrayA");
        this.a(var1, "number[] numArrayB");
        this.a(var1, "bool[] boolArrayA");
        this.a(var1, "unit[] unitArrayA");
        class_113 var2 = class_591.a(false, var1);
        class_113 var3 = class_591.a(false, var1);
        var3.b(PlayerData.i);
        class_113 var4 = class_591.a(false, var1);
        var4.b(PlayerData.i);
        var4.health = 44.0F;
        this.a((Unit)var4, (String)"numA=5");
        this.a((Unit)var4, (String)"numB=7");
        this.a((Unit)var4, (String)"numArrayA[0]=1");
        this.a((Unit)var4, (String)"numArrayA[1]=2");
        this.a((Unit)var4, (String)"numArrayA[2]=15");
        this.a((Unit)var4, (String)"boolArrayA[0]=true");
        this.a((Unit)var4, (String)"unitArrayA[0]=self");
        this.a((Unit)var4, (String)"numArrayA[(5)]=5");
        this.a((Unit)var4, (String)"numArrayA[5+5]=10");
        this.a((Unit)var4, (String)"numArrayA[4+4]=8");
        this.a((Unit)var4, (String)"boolArrayA[10]=true");
        this.a((Unit)var4, (String)"unitArrayA[10]=self");
        GameEngine.log("string: " + this.d(var4, this.b("str(memory.numArrayA)")));
        this.a(var4, this.b("memory.numArrayA.get(5)"), 5.0F);
        this.a(var4, this.b("memory.numArrayA.get(10)"), 10.0F);
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.boolArrayA[10]"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.unitArrayA[10]==self"));
        this.a((Unit)var4, (String)"numArrayA[memory.numArrayA.get(2)]=98");
        this.a(var4, this.b("memory.numArrayA.get(15)"), 98.0F);
        this.a((Unit)var4, (String)"numArrayA[memory.numArrayA[2]]=99");
        this.a(var4, this.b("memory.numArrayA.get(15)"), 99.0F);
        this.a((Unit)var4, (String)"numArrayA[((((((((6))))))))]=99");
        this.a((Unit)var4, (String)"numArrayA[((((((((memory.numArrayA[2]))))))))]=88");
        this.a(var4, this.b("memory.numArrayA.get(15)"), 88.0F);
        this.b((Unit)var4, (String)"numArrayA[((((((((memory.numArrayA[2])())))))]=77");
        this.b((Unit)var4, (String)"numArrayA[((((((((memory.numArrayA[2])))[)))]]))]=66");
        this.b((Unit)var4, (String)"numArrayA[a]=1");
        this.b((Unit)var4, (String)"numArrayA[0]='a'");
        this.a((Unit)var4, (String)"numArrayA[9001]=5");
        this.a(var4, this.b("memory.numArrayA.size"), 9002.0F);
        this.a(var4, this.b("memory.numArrayA.length"), 9002.0F);
        this.a((Unit)var4, (String)"numArrayA[11000]=5");
        this.a((Unit)var4, (String)"numArrayA[10000]=5");
        this.a((Unit)var4, (String)"numArrayA[10001]=6");
        this.a((Unit)var4, (String)"numArrayA[9999]=42");
        this.a(var4, this.b("memory.numArrayA.get(11000)"), 0.0F);
        this.a(var4, this.b("memory.numArrayA.get(10000)"), 5.0F);
        this.a(var4, this.b("memory.numArrayA.get(10001)"), 0.0F);
        this.a(var4, this.b("memory.numArrayA.get(9999)"), 42.0F);
        this.a((Unit)var4, (String)"numArrayA[21]=21");
        this.a((Unit)var4, (String)"numArrayA[22]=memory.numArrayA[21]");
        this.a(var4, this.b("memory.numArrayA.get(22)"), 21.0F);
        this.a(var4, this.b("memory.numArrayA.get(0)"), 1.0F);
        this.a(var4, this.b("memory.numArrayA.get(1)"), 2.0F);
        this.a(var4, this.b("memory.numArrayA.get(5)"), 5.0F);
        this.a(var4, this.b("memory.numArrayA.get(500)"), 0.0F);
        this.a(var4, this.b("memory.numArrayA.get(9000)"), 0.0F);
        this.a("memory.numArrayA.get('A')");
        this.a(var4, this.b("memory.numArrayA[0]"), 1.0F);
        this.a(var4, this.b("memory.numArrayA[1]"), 2.0F);
        this.a(var4, this.b("memory.numArrayA[0]+memory.numArrayA[1]"), 3.0F);
        this.a(var4, this.b("memory.numArrayA[0]+(memory.numArrayA[1])"), 3.0F);
        this.a(var4, this.b("(memory.numArrayA[0]+(memory.numArrayA[1]))"), 3.0F);
        this.a(var4, this.b("memory.numArrayA[5]"), 5.0F);
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.numArrayA.contains(5)"));
        this.c(var4, this.b("memory.numArrayA.contains(777)"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.numArrayA.contains(memory.numArrayA[5])"));
        this.a("memory.numArrayA.contains('a')");
        this.a("memory.numArrayA.contains(true)");
        this.a("memory.numArrayA[5][5]");
        this.a("memory.numArrayA[5][5][60]");
        this.a("memory.numArrayA[5][5][[60]]");
        this.a("memory.numArrayA[5][[5]");
        this.a("memory.numArrayA[5]][5]");
        this.a("memory.numArrayA[5[]][5]");
        this.a("memory.numArrayA[[5[]][5]");
        class_113 var5 = class_591.a(false, var1);
        var5.b((PlayerData)PlayerData.i);
        var5.xCord = 10.0F;
        var5.health = 55.0F;
        var5.totalHealth = 500.0F;
        var4.bu = var5;
        this.a((Unit)var5, (String)"numA=309");
        this.a((Unit)var5, (String)"numB=409");
        class_113 var6 = class_591.a(false, var1);
        var6.b((PlayerData)PlayerData.i);
        var6.yCord = 5.0F;
        var6.health = 66.0F;
        var6.totalHealth = 1000.0F;
        var5.bv = var6;
        class_113 var7 = class_591.a(false, var1);
        var7.b((PlayerData)PlayerData.i);
        var7.xCord = 2.0F;
        this.a((Unit)var7, (String)"numA=99");
        this.a((Unit)var7, (String)"numB=88");
        class_113 var8 = class_591.a(false, var1);
        var8.b((PlayerData)PlayerData.i);
        var8.xCord = 3.0F;
        this.a((Unit)var8, (String)"numA=239");
        this.a((Unit)var8, (String)"numB=268");
        class_113 var9 = class_591.a(false, var1);
        var9.b((PlayerData)PlayerData.i);
        var9.xCord = 3.0F;
        var7.C(var8);
        var7.C(var9);
        class_113 var10 = class_591.a(false, var1);
        var10.b((PlayerData)PlayerData.i);
        var10.a(class_585.a("globalTag1, globalTag2"), false);
        var10.xCord = 2.0F;
        byte var11 = 50;
        GameEngine.log("=== logic boolean tests == (runs:" + var11 + ")");
        Long var12 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();

        for(int var13 = 0; var13 < var11; ++var13) {
            if (var13 == 1) {
            }

            this.b((OrderableUnit)var4, (LogicBoolean)this.b("true"));
            this.c(var4, this.b("false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("not false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("not not true"));
            this.a(var4, this.b("5"), 5.0F);
            this.a(var4, this.b("5+5"), 10.0F);
            this.a(var4, this.b("1+2+3"), 6.0F);
            this.a(var4, this.b("2.5+2.5"), 5.0F);
            this.a(var4, this.b("10-2"), 8.0F);
            this.a(var4, this.b("((5+5)-2)*3"), 24.0F);
            this.a(var4, this.b("10/2+10*2"), 25.0F);
            this.a(var4, this.b("-5"), -5.0F);
            this.a(var4, this.b("--5"), 5.0F);
            this.a(var4, this.b("9--5"), 14.0F);
            this.a(var4, this.b("-9--5"), -4.0F);
            this.a(var4, this.b("+5"), 5.0F);
            this.a(var4, this.b("+ 5"), 5.0F);
            this.a(var4, this.b(" + 5"), 5.0F);
            this.a(var4, this.b(" ++ 5"), 5.0F);
            this.a(var4, this.b("-+5"), -5.0F);
            this.a(var4, this.b("--+5"), 5.0F);
            this.a(var4, this.b("++-5"), -5.0F);
            this.a(var4, this.b(" - - +5"), 5.0F);
            this.a(var4, this.b("9++5"), 14.0F);
            this.a("5 - ");
            this.a("5 -- ");
            this.a("5 + ");
            this.a("5 ++ ");
            this.a("5 ** 9 ");
            this.a("5 -/ 9 ");
            this.a("5 * 5 -");
            this.a(" - ");
            this.a(" -- ");
            this.a(" + ");
            this.a(" ++ ");
            this.a(var4, this.b(" 'hello'"), (String)"hello");
            this.a(var4, this.b(" \"hello\" "), (String)"hello");
            this.a(var4, this.b("self.hp+1"), var4.health + 1.0F);
            this.a(var4, this.b("self.x+1"), var4.xCord + 1.0F);
            this.a(var4, this.b("self.y+1"), var4.yCord + 1.0F);
            this.a(var4, this.b("self.z+1"), var4.zCord + 1.0F);
            this.a(var4, this.b("int( 5.5+0.1 )"), 5.0F);
            this.a(var4, this.b("-5 * 5"), -25.0F);
            this.a(var4, this.b("-5 * self.hp"), -5.0F * var4.health);
            this.a(var4, this.b("self.hp + -5"), var4.health + -5.0F);
            this.a(var4, this.b("self.hp * -5"), -5.0F * var4.health);
            this.a(var4, this.b("(self.hp ) * -5 "), -5.0F * var4.health);
            this.a(var4, this.b("-self.hp * -5"), -5.0F * -var4.health);
            this.a(var4, this.b("-(self.hp ) * -5 "), -5.0F * -var4.health);
            this.a(var4, this.b("-5 * -self.hp"), -5.0F * -var4.health);
            this.a(var4, this.b("(-5 * -self.hp)/2"), -5.0F * -var4.health / 2.0F);
            this.a(var4, this.b("-(self.hp )"), -var4.health);
            this.a(var4, this.b("--(self.hp )"), var4.health);
            this.a(var4, this.b("-((self.hp ))"), -var4.health);
            this.a(var4, this.b("-self.hp"), -var4.health);
            this.a(var4, this.b("-0"), 0.0F);
            this.a(var4, this.b("-  1"), -1.0F);
            this.a(var4, this.b(" -  1"), -1.0F);
            this.a(var4, this.b("-0*-0"), 0.0F);
            this.a(var4, this.b("-2*2"), -4.0F);
            this.a(var4, this.b("-2-3-2"), -7.0F);
            this.c(var4, this.b("10>10"));
            this.c(var4, this.b("10<10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("10>=10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("10<=10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hello'=='hello'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hello'!='bye'"));
            this.a("'hello'<'bye'");
            this.a("'hello'>'bye'");
            this.a("'hello'<='bye'");
            this.a("'hello'>='bye'");
            this.a("'hello'55'bye'");
            this.a("'hello'><'bye'");
            this.a("6><8");
            this.c(var4, this.b("not (10>5 and true)"));
            this.c(var4, this.b("not true and false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("not false and true"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("not (false and true)"));
            this.c(var4, this.b("not (1>2 or 5>2)"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("(true and (false or true))"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" true and   (false   or   true  )"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("true and((false)or(true) )"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("100>50+20"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("100>50*1.5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("not (100<50*1.5)"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("5 < 10 < 15"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("false==false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("true==true"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("false==false==false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("true==true==true"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("false!=true!=false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("true!=false!=true"));
            this.c(var4, this.b("'test'==null"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'test'!=null"));
            this.c(var4, this.b("'test'==null==null"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'test'!=null!='test2'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("self!=null"));
            this.c(var4, this.b("self==null"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("10==10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("10.5==10.5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("1/3==1/3"));
            this.c(var4, this.b("10!=10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("10!=5"));
            this.a("true - true");
            this.a("true + true");
            this.a("true * true");
            this.a("true / true");
            this.a("true < 10");
            this.a("true == 10");
            this.a("true != 10");
            this.a("'text' == 10");
            this.a("10 == ");
            this.a("10 != ");
            this.a("10 > ");
            this.a("10 < ");
            this.a("10 >= ");
            this.a("10 <= ");
            this.a("10 ==");
            this.a("10 !=");
            this.a("10 >");
            this.a("10 <");
            this.a("10 >=");
            this.a("10 <=");
            this.a("==10");
            this.a("!=10");
            this.a(">10");
            this.a("<10");
            this.a(">=10");
            this.a("<=10");
            this.a("10.6.6");
            this.a(var4, this.b("select(true, 'A','B')"), (String)"A");
            this.a(var4, this.b("select(false, 'A','B')"), (String)"B");
            this.a(var4, this.b("str(5.5)"), (String)"5.5");
            this.a(var4, this.b("str(5)"), (String)"5");
            this.a(var4, this.b("lowercase('HELlo')"), (String)"hello");
            this.a(var4, this.b("uppercase('heLLo')"), (String)"HELLO");
            this.a(var4, this.b("lowercase(str('HELlo'))"), (String)"hello");
            this.a(var4, this.b("'hello'"), (String)"hello");
            this.a(var4, this.b("'hello'+' world'"), (String)"hello world");
            this.a(var4, this.b("'he(llo'+' world'"), (String)"he(llo world");
            this.a(var4, this.b("'he(llo'+' wor)ld'"), (String)"he(llo wor)ld");
            this.a("('hello'+' world'");
            this.a("'hello'+)' world'");
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.hp(lessThan=9999)"));
            this.a("self.hp(lessThan=9999, lessThan=9998)");
            this.a("self..hp(lessThan=9999)");
            this.a("self...hp(lessThan=9999)");
            this.b("game.nukesEnabled()");
            this.a("game.nukesEnabled(nukesEnabled=true)");
            this.a("game.nukesEnabled(nukesEnabled=false)");
            this.a("game.nukesEnabled()==0");
            this.a("game.nukesEnabled()!=0");
            this.a("game.nukesEnabled()<0");
            this.a("game.nukesEnabled()>0");
            this.a("game.nukesEnabled()=='true'");
            this.a("game.nukesEnabled()!='true'");
            this.a("self.nukesEnabled()");
            this.a("parent.nukesEnabled()");
            this.a("hp==44");
            this.a("5=44");
            if (var4 == PlayerData.i.s) {
                GameEngine.log("skipping for placeholderTeamUnit");
            } else {
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.hp==44"));
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.customTarget1.hp==55"));
                this.a("self.memory1.hp=55");
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.customTarget1.maxhp==500"));
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("customTarget1.hp==55"));
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.customTarget1.customTarget2.hp==66"));
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.customTarget1==self.customTarget1"));
                this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.customTarget1!=self"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.customTarget1==null"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.customTarget1!=self"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.parent==null"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.parent.customTarget1==null"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.parent.customTarget1==self.parent"));
                this.b((OrderableUnit)var3, (LogicBoolean)this.b("self.parent.customTarget1!=self"));
            }

            this.a(var4, this.b("self.getOffsetAbsolute(y=10).y"), var4.yCord + 10.0F);
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.getOffsetAbsolute(y=10).y==self.y+10"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("self.getOffsetRelative(y=10, height=5).height==self.height+5"));
            this.a(var4, this.b("self.getOffsetRelative(y=10, height=5).height"), var4.zCord + 5.0F);
            this.a(var4, this.b("self.getOffsetAbsolute(y=10).getOffsetAbsolute(y=10).y"), var4.yCord + 10.0F + 10.0F);
            this.a(var7, this.b("self.transporting().getOffsetAbsolute(x=5).x"), var8.xCord + 5.0F);
            this.a(var7, this.b("self.transporting(slot=1).getOffsetAbsolute(x=5).x"), var9.xCord + 5.0F);
            this.a(var7, this.b("self.transporting().parent.transporting().parent.id"), (float)var7.id);
            this.a(var7, this.b("self.transporting().getOffsetAbsolute(x=memory.numA).x-memory.numA"), var8.xCord);
            this.a(var7, this.b("self.transporting().getOffsetAbsolute(x=self.id).x-self.id"), var8.xCord);
            this.a(var7, this.b("self.transporting().parent.transporting().getOffsetAbsolute(x=self.id).x-self.id"), var8.xCord);
            this.a(var7, this.b("self.transporting().parent.transporting().getOffsetAbsolute(x=self.id).getOffsetAbsolute().x-self.id"), var8.xCord);
            this.a(var7, this.b("self.transporting().parent.transporting().getOffsetAbsolute(x=self.id).getOffsetAbsolute(x=self.id+1).x"), var8.xCord + (float)var7.id + (float)var7.id + 1.0F);
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("numberOfUnitsInTeam(greaterThan=-2)"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("NumberOfUnitsInTeam(greaterTHAN=-2)"));
            this.a((OrderableUnit)var4, (LogicBoolean)this.b("self.noUnitInTeam()"));
            this.a((OrderableUnit)var4, (LogicBoolean)this.b("self.hasUnitInTeam()"));
            this.a((OrderableUnit)var4, (LogicBoolean)this.b("self.hasUnitInTeam(neutralTeam=true)"));
            this.a((OrderableUnit)var4, (LogicBoolean)this.b("self.shield()+self.ammo()+self.hp()>-1"));
            this.a((OrderableUnit)var4, (LogicBoolean)this.b("parent.shield()+parent.ammo()+parent.hp()>-1"));
            this.a(var4, this.b("'hello'+'a'"), (String)"helloa");
            this.a(var4, this.b("'hello'+5"), (String)"hello5");
            this.a(var4, this.b("substring('hello',0,3)"), (String)"hel");
            this.a(var4, this.b("substring('hello',0,100)"), (String)"hello");
            this.a(var4, this.b("substring('HEllo',0,100)"), (String)"HEllo");
            this.a(var4, this.b("'HEllo'"), (String)"HEllo");
            this.a(var4, this.b("substring('aa',0,2)+substring('bb',0,2)"), (String)"aabb");
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" true AND true"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" true aNd true"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" true OR false"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" true OR TRUE"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" True OR  False "));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" True OR  (False) "));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" NOT FALSE "));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" NOT NOT NOT FALSE "));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" game.nukesEnabled "));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" GAME.NukesEnabled "));
            this.a(var4, this.b("squareRoot( 100 )"), 10.0F);
            this.a(var4, this.b("max(+1,2)"), 2.0F);
            this.a(var4, this.b("min(+1,2)"), 1.0F);
            this.a(var4, this.b("max(1,2)"), 2.0F);
            this.a(var4, this.b("min(1,2)"), 1.0F);
            this.a(var4, this.b("max( 1,2 )"), 2.0F);
            this.a(var4, this.b("min( 1,2 )"), 1.0F);
            this.a(var4, this.b("max(-1,2)"), 2.0F);
            this.a(var4, this.b("min(-1,2)"), -1.0F);
            this.a(var4, this.b("max( -1,2 )"), 2.0F);
            this.a(var4, this.b("min( -1,2 )"), -1.0F);
            this.a(var4, this.b("max( 3,1 )"), 3.0F);
            this.a(var4, this.b("min( 3,1 )"), 1.0F);
            this.a(var4, this.b("max( 3+3,4 )"), 6.0F);
            this.a(var4, this.b("min( 3+3,4 )"), 4.0F);
            this.a(var4, this.b("distanceSquared( 1,1,1,6 )"), 25.0F);
            this.a(var4, this.b("max(distanceSquared( 1,1,1,6 ), 4)"), 25.0F);
            this.a(var4, this.b("min(  distanceSquared( 1,1,1 , 6 )  , 4)"), 4.0F);
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("distanceSquared( 1,1,1,6 )>=5*5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("distanceSquared( 1,1,1,6 )>4*5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("distanceSquared( 1,1,6,1 )<6*5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("distance( 0,0,5,0 )==5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("distance( 0,1,0,6 )==5"));
            this.a(var4, this.b("customTarget1"), (Unit)var5);
            this.a(var4, this.b("customTarget1.self"), (Unit)var5);
            this.a(var4, this.b("self.customTarget1.self"), (Unit)var5);
            this.a(var4, this.b("customTarget1.customTarget2"), (Unit)var5.bv);
            this.a(var4, this.b(" distanceBetween(customTarget1.customTarget2, customTarget1 ) "), class_340.b(var5.xCord, var5.yCord, var6.xCord, var6.yCord));
            this.a(var4, this.b(" distanceBetweenSquared(customTarget1.customTarget2, customTarget1 ) "), class_340.a(var5.xCord, var5.yCord, var6.xCord, var6.yCord));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" distanceBetween(self, nullUnit ) == 0 "));
            this.a(var4, this.b(" distanceBetween(customTarget1.customTarget2, nullUnit ) "), 0.0F);
            this.a(var4, this.b(" distanceBetween(nullUnit, nullUnit ) "), 0.0F);
            this.a(var4, this.b(" distanceBetween( self.getOffsetAbsolute(x=5), self.getOffsetAbsolute(x=-5) ) "), 10.0F);
            this.a(var4, this.b(" distanceBetweenSquared( self.getOffsetAbsolute(x=5), self.getOffsetAbsolute(x=-5) ) "), 100.0F);
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" self.energy < 0.5 and customTarget2==nullUnit ", true));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" self.energy < 0.5 and customTarget2 == nullUnit ", true));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b(" self.energy < 0.5 and customTarget1 != nullUnit ", true));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("parent==nullUnit and customTarget1!= nullUnit ", true));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("parent == nullUnit and customTarget1!=nullUnit ", true));
            this.a("distanceBetween( self )");
            this.a("distanceBetween( self, 5 )");
            this.a("distanceBetween( self, nullUnit, nullUnit )");
            this.a("distanceBetween(  )");
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'and'=='and'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'and'!='and true'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hello.test'!='bye'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hel.lo.test'!='b.ye'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hel.lo.(test'!='b.ye'"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hel.\"lo.(test'!='b.ye \"and '"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("\"hel.lo.'(test2\"!='b.ye \"and '"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("5==5"));
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("'hel.lo.(test'!='b.ye' and 5==5"));
            this.a("distanceSquared(  )");
            this.a("distanceSquared( 1 )");
            this.a("distanceSquared( 1,1 )");
            this.a("distanceSquared( 1,1,1 )");
            this.a("distanceSquared( 1,1,1,'test' )");
            this.a("distanceSquared( 1,1,1,true )");
            this.a("distanceSquared( 1,1,1,null )");
            this.a("distanceSquared( 1,1,1, )");
            this.a("distanceSquared( 1,1,1,'test' )");
            this.a("distanceSquared( x1=1,1,1,'test' )");
            this.a("distanceSquared( 1,1,1,1, x1=1 )");
            this.a("distanceSquared( 1,1,1,1,1 )");
            this.a("distanceSquared( 1,1,1, x1=1 )");
            this.a("distanceSquared( 1,1,1, 1 ");
            this.a("distanceSquared( 1,1,1, 1 ))");
            this.b((OrderableUnit)var4, (LogicBoolean)this.b("SELF.HP(lessThan=9999)"));
            this.c(var4, this.b("Self.Parent.HP(lessThan=9999)"));
            this.a("self.hasFlag( id=35 )");
            this.a("self.hasFlag( 35 )");
            this.c(var4, this.b("self.hasFlag(id=30)"));
            this.c(var4, this.b("self.hasFlag(30)"));
            this.c(var4, this.b("self.hasFlag(15+15)"));
            this.c(var4, this.b("self.hasFlag(id=15*2)"));
        }

        Long var16 = com.corrodinggames.rts.gameFramework.Unit.loadAllUnitsTook();
        double var14 = com.corrodinggames.rts.gameFramework.Unit.a(var12, var16);
        GameEngine.log("Took: " + var14);
        GameEngine.log("=== logic boolean memory tests ==");
        this.a(var1, "unit testUnit1, float testFloat1");
        this.a(var1, "unit testUnit2, float testFloat2");
        this.a(var1, "bool testBool1");
        this.a(var1, "number testNumber1");
        this.a(var1, "float  testNumber2");
        this.a(var1, "String testString");
        this.a(var1, "String nullString");
        this.a((Unit)var4, (String)"testString='(,,((', testFloat1=5, testFloat2=8, testBool1=true, testUnit1=self");
        this.a((Unit)var4, (String)"nullString=null");
        this.b((Unit)var2, (String)"testNumber1=null");
        this.b((Unit)var2, (String)"testNumber2=null");
        this.b((Unit)var2, (String)"testBool1=null");
        this.b((Unit)var2, (String)"testNumber1=self");
        this.b((Unit)var2, (String)"testBool1=5");
        GameEngine.log(var4.bw.debugMemory(false, true));
        this.a(var4, this.b("memory.testFloat1"), 5.0F);
        this.a(var4, this.b("memory.testFloat2"), 8.0F);
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testFloat1==5"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testString=='(,,(('"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testBool1"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testBool1==true"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testUnit1==self"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testUnit1!=nullUnit"));
        this.a("memory.testUnit1==5", true);
        this.a(var4, this.b("self.readUnitMemory('testFloat1', type='float')"), 5.0F);
        this.a((Unit)var4, (String)"testFloat1=distance( 0,0,6,0 ), testFloat2=16");
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testFloat1==6"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("memory.testFloat2==16"));
        this.a((Unit)var4, (String)"testUnit1=self.getOffsetAbsolute(y=10), testUnit2=self.getOffsetAbsolute(y=-10)");
        GameEngine.log(var4.bw.debugMemory(false, true));
        this.a(var4, this.b("distanceBetween( memory.testUnit1, memory.testUnit2)"), 20.0F);
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("distanceBetweenSquared( memory.testUnit1, memory.testUnit2)==20*20"));
        this.a(var4, this.b("globalSearchForFirstUnit(withTag='globalTag1')"), (Unit)var10);
        this.a(var4, this.b("globalSearchForFirstUnit(withTag='globalTag2')"), (Unit)var10);
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("globalSearchForFirstUnit()!=null"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("globalSearchForFirstUnit(withTag='globalTag1', relation='enemy')==null"));
        this.b((OrderableUnit)var4, (LogicBoolean)this.b("globalSearchForFirstUnit(withTag='globalTagNo')==null"));
        this.a("globalSearchForFirstUnit(withTag='globalTag1', relation='XYZ')", true);
    }

    public void a(String var1) {
        this.a(var1, false);
    }

    public void a(String var1, boolean var2) {
        try {
            class_591 var3 = class_591.b;
            LogicBooleanLoader.parseBooleanBlock(var3, var1, false);
        } catch (RuntimeException var5) {
            if (var5.getClass() != RuntimeException.class && var5.getClass() != BooleanParseException.class) {
                throw new RuntimeException(var5);
            }

            if (var2) {
                GameEngine.d("assertCreateError: " + var1 + " error:" + var5.getMessage());
            }

            return;
        }

        throw new RuntimeException("assertCreateError got no error for: " + var1);
    }

    public void a(class_591 var1, String var2) {
        var1.r.defineVariables(var1, var2);
    }

    public void a(Unit var1, String var2) {
        try {
            class_113 var3 = (class_113)var1;
            VariableScope$MemoryWriter var4 = VariableScope.createMemoryWriter(var2, var3.x, "testsection", "testkey");
            var4.writeToUnit(var3);
        } catch (Exception var5) {
            throw new RuntimeException(var5);
        }
    }

    public void b(Unit var1, String var2) {
        try {
            class_113 var3 = (class_113)var1;
            VariableScope$MemoryWriter var4 = VariableScope.createMemoryWriter(var2, var3.x, "testsection", "testkey");
            var4.writeToUnit(var3);
        } catch (RuntimeException var5) {
            return;
        } catch (Exception var6) {
            return;
        }

        throw new RuntimeException("assertSetMemoryError got no error for: " + var2);
    }

    public LogicBoolean b(String var1) {
        return this.b(var1, false);
    }

    public LogicBoolean b(String var1, boolean var2) {
        try {
            class_591 var3 = class_591.b;
            LogicBoolean var4 = LogicBooleanLoader.parseBooleanBlock(var3, var1, var2);
            return var4;
        } catch (RuntimeException var5) {
            throw new RuntimeException("Error: " + var5.getMessage() + " parsing [" + var1 + "]", var5);
        }
    }

    public void a(OrderableUnit var1, LogicBoolean var2) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.bool) {
            throw new RuntimeException("Asset assertBooleanTrue type ==" + var2.getReturnType());
        } else {
            var2.read(var1);
        }
    }

    public void b(OrderableUnit var1, LogicBoolean var2) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.bool) {
            throw new RuntimeException("Asset assertBooleanTrue type ==" + var2.getReturnType());
        } else {
            boolean var3 = var2.read(var1);
            if (!var3) {
                throw new RuntimeException("Asset assertBooleanTrue failed, got false for: " + var2.getMatchFailReasonForPlayer(var1));
            }
        }
    }

    public void c(OrderableUnit var1, LogicBoolean var2) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.bool) {
            throw new RuntimeException("Asset assertBooleanFalse type ==" + var2.getReturnType());
        } else {
            class_650.b(var2.read(var1));
        }
    }

    public void a(OrderableUnit var1, LogicBoolean var2, float var3) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.number) {
            throw new RuntimeException("Asset assertBooleanNumber type ==" + var2.getReturnType());
        } else {
            float var4 = var2.readNumber(var1);
            if (class_340.c(var4 - var3) > 0.001F) {
                throw new RuntimeException("Asset failed (float):" + var4 + "!=" + var3 + " for: " + var2.getMatchFailReasonForPlayer(var1));
            }
        }
    }

    public String d(OrderableUnit var1, LogicBoolean var2) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.string) {
            throw new RuntimeException("Asset assertBooleanString type ==" + var2.getReturnType());
        } else {
            String var3 = var2.readString(var1);
            return var3;
        }
    }

    public void a(OrderableUnit var1, LogicBoolean var2, String var3) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.string) {
            throw new RuntimeException("Asset assertBooleanString type ==" + var2.getReturnType());
        } else {
            String var4 = var2.readString(var1);
            class_650.a(var4, var3);
        }
    }

    public void a(OrderableUnit var1, LogicBoolean var2, Unit var3) {
        if (var2.getReturnType() != LogicBoolean$ReturnType.unit) {
            throw new RuntimeException("Asset assertBooleanUnit type ==" + var2.getReturnType());
        } else {
            Unit var4 = var2.readUnit(var1);
            if (var4 != var3) {
                GameEngine.log("class: " + var2.getClass().getName());
                throw new RuntimeException("assertBooleanUnit failed:" + Unit.A(var4) + "!=" + Unit.A(var3) + " for: " + var2.getMatchFailReasonForPlayer(var1));
            }
        }
    }
}
