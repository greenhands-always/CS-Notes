class ConvertTest {
    public String s;

    public ConvertTest(String s) {
        this.s = new String(s);
    }

    public boolean equals(Object obj) {
        if (this.s == obj) {
            return true;
        }
        // 参考错误代码TupleDesc tdObj = (TupleDesc) o;
        ConvertTest StringObj = (ConvertTest) obj;
        if (this.s.equals(StringObj.s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ConvertTest t1 = new ConvertTest("hello"), t2 = new ConvertTest("hello");
        Object t3 = new Object();
        if (t3 instanceof ConvertTest) {
            ConvertTest testObj = (ConvertTest) t3;
            System.out.println("t1=t3: " + t1.equals(t3));
        } else {
            System.out.println("t3 is not a ConvertTest");
        }
        System.out.println("t1=t2: " + t1.equals(t2));
        System.out.println("--------------");
        // 实际上不用那么麻烦来测试,问题就出在强制类型转化上,直接模拟强制类型转化就可以了
        System.out.println("test for t3:");
        try {
            ConvertTest testObj = (ConvertTest) t3;
        } catch (Exception e) {
            // print exception messege
            System.out.println(e.getMessage());
        }
        System.out.println("test for t4:");
        Object t4 = new ConvertTest("hello");
        try {
            ConvertTest testObj = (ConvertTest) t4;
            System.out.println("success");
        } catch (Exception e) {
            // print exception messege
            System.out.println(e.getMessage());
        }
    }
}