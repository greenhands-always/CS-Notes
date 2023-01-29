---
url: https://javakk.com/1767.html
title: Java 提示找不到或无法加载主类怎么解决? - 老 K 的 Java 博客
date: 2023-01-28 23:18:54
tag: java
summary: Java提示找不到或无法加载主类怎么解决?。

一旦您编写了一个 Java 程序，您需要使用`javac`命令来编译它，这将显示发生的编译时错误（如果有的话）。

一旦解析它们并成功编译程序，将在当前文件夹中生成一个与类名同名的可执行文件，扩展名为**.class**。

然后需要使用`java`命令执行它，如：

```
java class_name
```

在执行时，当 JVM 找不到具有指定名称的. class 文件时，会出现运行时错误，错误为 "**[Could not found or load main class](https://javakk.com/tag/could-not-found-or-load-main-class "查看更多关于 Could not found or load main class 的文章")**"，即找不到或加载主类：

```
D:\sample>java Example
Error: Could not find or load main class Example
Caused by: java.lang.ClassNotFoundException: Example
```

## 解决方案

要避免此错误，需要指定**当前目录中. class 文件的绝对（包括包）名称（仅为名称）**。

以下是可能发生此错误的情况：

1. **错误的类名**—您可能指定了错误的类名。

```
class Example {
   public static void main(String args[]){
      System.out.println("This is an example class");
   }
}
```

错误：

```
D:\>javac Example.java
D:\>java Exmple
Error: Could not find or load main class Exmple
Caused by: java.lang.ClassNotFoundException: Exmple
```

解决方案 - 在这个类名拼写错误，我们需要纠正它。

```
D:\>javac Example.java
D:\>java Example
This is an example class
```

2. **大小写错误** - 需要指定大小写相同的类的名称`Example.java`不同于`example.java`.

```
class Example {
   public static void main(String args[]){
      System.out.println("This is an example class");
   }
}
```

错误：

```
D:\>java EXAMPLE
Error: Could not find or load main class EXAMPLE
Caused by: java.lang.NoClassDefFoundError: Example (wrong name: EXAMPLE)
```

解决方案 - 在这种情况下，类名是错误的，它应该被修饰。

```
D:\>javac Example.java
D:\>java Example
This is an example class
```

3. **错误的包**—您可能在包中创建了. class 文件，并尝试在没有包名称或包名称错误的情况下执行。

```
package sample;
class Example {
   public static void main(String args[]){
      System.out.println("This is an example class");
   }
}
```

错误：

```
D:\>javac -d . Example.java
D:\>java samp.Example
Error: Could not find or load main class samp.Example
Caused by: java.lang.ClassNotFoundException: samp.Example
```

解决方案—在这个场景中，我们在执行时提到了错误的包名，我们需要指定正确的包名，其中. class 文件作为

```
D:\>javac -d . Example.java
D:\>java sample.Example
This is an example class
```

包含. class 扩展名—在执行文件时，无需在程序中包含. class 扩展名，只需指定类文件的名称。

错误：

```
D:\sample>java Example.class
Error: Could not find or load main class Example.class
Caused by: java.lang.ClassNotFoundException: Example.class
```

解决方案−执行程序时不需要`extension.class`

```
D:\sample>java Example
This is an example class
```