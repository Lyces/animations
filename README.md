## Animations framework

[![GitHub stars](https://img.shields.io/github/stars/Yuhtin/animations.svg)](https://github.com/Yuhtin/animations/stargazers)
[![](https://jitpack.io/v/Yuhtin/animations.svg)](https://jitpack.io/#Yuhtin/animations)
[![GitHub issues](https://img.shields.io/github/issues-raw/Yuhtin/animations.svg?label=issues)](https://github.com/Yuhtin/animations/issues)
[![GitHub last commit](https://img.shields.io/github/last-commit/Yuhtin/animations.svg)](https://github.com/Yuhtin/animations/commit)
[![MIT License](https://img.shields.io/badge/license-MIT-blue.svg?color=1bcc1b)](https://choosealicense.com/licenses/mit/)
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.png?v=103)](https://github.com/ellerbrock/open-source-badges/)
[![Discord](https://img.shields.io/discord/700673055982354472?label=Discord)](https://discord.gg/ShpKBgk)


A framework for creating animations easily

## 🌈 How to install

To install you can use maven or gradle

#### 🍕 Repository

Add this repository in your list:

🎇Maven repository
```xml
<repositories>
  ...
  <repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
  </repository>
  
</repositories>
```

🎊 Gradle repository
```gradle
repositories {
  ...
  maven { url 'https://jitpack.io' }
}
```

#### 🍔 Project dependency

Add the project dependency to your dependencies list:

🎇Maven dependency
```xml
<dependency>
 
  <groupId>com.github.Yuhtin</groupId>
  <artifactId>animations</artifactId>
  <version>dev-2fe03f3067-1</version>
  <scope>provided</scope>
  
</dependency>
```

🎊 Gradle dependency
```gradle
dependencies {
  implementation 'com.github.Yuhtin:animations:dev-2fe03f3067-1'
}
```

## 📄 Documentation

First, you need to put the main plugin on the server (you can find the jar in the versions of this project)

### 🎈 Create animation

You need to extend the Animation class and use the AnimationHandler annotation in the class

```java
@AnimationHandler(
        name = "test",
        description = "Test",
        state = AnimationHandler.AnimationVersion.RELEASE
)
public class TestA extends Animation {

    @Override
    public void execute(Player player) {

        runnableID = new BukkitRunnable() {

            @Override
            public void run() {
                // make something
            }

        }.getTaskId();

        ArmorStand stand = player.getLocation().getWorld().spawn(player.getLocation(), ArmorStand.class);
        hologramList.add(stand);

    }

    @Override
    public void stop() {
        hologramList.forEach(ArmorStand::remove);
        Bukkit.getScheduler().cancelTask(runnableID);
    }
}
```

### 🎫 Register animation

To register the animation, use the function AnimationRegistry#registry

```java
public final class AnimationTest extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        AnimationRegistry.registry(this.getName(), TestA.class);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
```

### 🧧 Execute animation

Use the command /animation in game

### 🎁 Project configuration

You need to put this information in your plugin.yml
```yaml
softdepend: [ Animations ]
```
