# RustedWarfare
Decompiled code of [Rusted Warfare](https://corrodinggames.com/rusted_warfare) 1.15. Some classes and methods are deobfuscated (renamed).
## Usage
This project uses the Maven build system. To build a jar, follow these steps:
1. Clone or fork this repository.
2. In *pom.xml*, you have to set the `path.rustedwarfare` property by specifying the path to the game folder (for example, `C:/Program Files (x86)/Steam/steamapps/common/Rusted Warfare`). If you don't have the game, you should buy it on [Steam](https://store.steampowered.com/app/647960/Rusted_Warfare__RTS/).
3. Use `mvn package` to compile and build a jar. It will appear as *game-lib-modded.jar* file in the game folder.
4. To run the modified jar, you can just replace the original *game-lib.jar* with the new one and run *Rusted Warfare - 64.exe* (don't forget to make a backup). But instead, I recommend using this batch script:
```bat
"%~dp0\jvm64\bin\java.exe" -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -cp game-lib-modded.jar;libs/* com.corrodinggames.rts.java.Main -log debug.log
```
Just create a *debug.bat* file in the game folder and paste that command. It also allows you to debug code ([Remote debug in IntelliJ IDEA](https://www.jetbrains.com/help/idea/tutorial-remote-debug.html)).
## Known issue...
There is an annoying runtime issue that I don't know how to fix yet. When watching replays or playing multiplayer games, desynchronization may occur (checksum mismatches). I guess it only happens during battles. This is especially noticeable when an artillery tank (or turret) fires at a moving unit (for some reason, the damage can differ between the server and the client). If you discover the solution, please make a pull request or contact me via Discord (@coolomet). 
## Thanks
- [Fernflower](https://github.com/fesh0r/fernflower) — decompiler.
- [TapeRTS](https://github.com/TapeRTS/Tape) — many mappings were borrowed from there.
