A simple "framework" to create animations

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
  <version>master-e3f2abdf38-1</version>
  <scope>provided</scope>
  
</dependency>
```

🎊 Gradle dependency
```gradle
dependencies {
  implementation 'com.github.Yuhtin:animations:master-e3f2abdf38-1'
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

        AnimationRegistry.registry(this, TestA.class);
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
