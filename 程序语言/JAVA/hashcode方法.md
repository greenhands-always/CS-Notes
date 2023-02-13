# 什么是 hashcode 方法
hashcode HashCode 就像是一个签名，当两个对象的 Hashcode 一样的时候，两个对象就可能一样，但如果 Hashcode 不一样，那么肯定不是同一个对象。相当于先确定一个大的范围，再用 equals 去比较。
一个对象的散列码，就是通过哈希算法算出来的一串数字，内存有关。
如果两个对象相同，就是适用于equals(Java.lang.Object) 方法，那么这两个对象的hashCode一定要相同；
# Hashcode 有什么用
加快查找效率。如果在内存中顺序查找，复杂度为 O（n），使用 hash 表结构查找复杂度为 O（1）
hashcode 可以减少 equals 比较的次数，提高运算效率。一般用 hashcode 来进行比较两个东西是不是一样的，可以很容易的排除许多不一样的东西。
# 什么时候需要重写？
一般的地方不需要重载 hashCode，只有当类需要放在 HashTable、HashMap、HashSet 等等哈希结构的集合时才会重载 hashCode。
# 如何重写 hashcode 方法
要求：
1. 如果两个对象相同，就是适用于 equals (Java. lang. Object) 方法，那么这两个对象的 hashCode 一定要相同
2. 如果对象的 equals 方法被重写，那么对象的 hashCode 也尽量重写，并且产生 hashCode 使用的对象，一定要和 equals 方法中使用的一致
3. 两个对象的 hashCode 相同，并不一定表示两个对象就相同，也就是不一定适用于 equals (java. lang. Object) 方法，只能够说明这两个对象在散列存储结构中
String 重写了 hashCode 和 equals 方法，所以我们可以非常愉快地使用 String 对象作为 key 来使用。
```java
public int hashCode() {
	String hash = ""+this.v1+this.v2+....;  
	return hash.hashCode();
}
```
## 不用 String 类的方法
**1. 把某个非零的常数值，保存在一个名为 result 的 int 类型的常量中**_
**2. 属性域 f 哈希码 c 的计算**_
- 如果是boolean类型，true为1，false为0
-  如果是byte、char、short和int类型，强制为int的值
- 如果是long类型，计算(int)(f^(f>>32))
- 如果是float类型，计算Float.floatToIntBits(f)
- 如果是double类型，计算Double.doubleToLongBits(f)，再按照long的方法进行计算
- 如果是引用类型，则调用其hashCode方法（假设其hashCode满足你的需求）

3.代入公式result = result * 31 + c

4.返回result
现在针对这 User 类来编写 hashCode 方法：
例子
```java
    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + name.hashCode();
        result = 37 * result + age;
        result = 37 * result + (int)(friendNumber^(friendNumber>>32));
        result = 37 * result + Float.floatToIntBits(cash);
        result = 37 * result + (int)(Double.doubleToLongBits(wealth)^(Double.doubleToLongBits(wealth)>>32));
        result = 37 * result + (isMarry ? 1 : 0);
        return result;
    }
```
