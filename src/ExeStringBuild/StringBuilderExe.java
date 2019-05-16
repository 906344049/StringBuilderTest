package ExeStringBuild;

import java.util.Scanner;

/**
 * 练习StringBuilder StringBuffer 多维数组 String部分函数
 * StringBuilder    线程不安全 效率较高 一般用这个
 * StringBuffer     线程安全   效率较低 一般不用
 */
public class StringBuilderExe {
    public static void main(String[] args) {
        System.out.println("abcdefg".contains("abc"));      //是否包含
        //indexof方法   若是没有查到，则返回-1   lastindexof  是从前往后找
        System.out.println("123456abc".indexOf('3'));
        System.out.println(("abc123456abc").indexOf("ab"));
        System.out.println("abc123456abc".indexOf("ab",2));   //fromindex是指从哪一个下标开始查找，即跨过了0  1 两个下标，从2开始寻找ab
        System.out.println("abc123456abc".indexOf('a',1));
        //判断字符串是否是纯数字     Character.IsDigit(str.charAt(i))  可以直接判断每一个下标对应的元素是不是数字
        Scanner input = new Scanner(System.in);
        String str = input.next();

        if(str.charAt(0)=='.' || str.charAt(str.length()-1) == '.'){
            System.out.println("输入的内容格式不对,小数点在始末位置");
            System.exit(0);
        }
        /*
        * 中间判断小数点是否只有一个的时候可以用String类里面的函数！
        * int temp = 0;
        * if (str.charAt(i) == '.'){
            temp++;
        }
        while(temp>1){
            System.out.println("输入的内容格式不对");
            System.exit(0);
        }
        * */

        for (int i =0;i<str.length();i++){
            if (!(str.contains(".") && str.indexOf(".") == str.lastIndexOf("."))){
                System.out.println("输入的格式不对！，小数点不只有一个！");
                System.exit(0);
            }
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i)!='.'){
                System.out.println("输入的内容不是纯数字！");
                System.exit(0);
            }
        }
        System.out.println("是纯数字");

        //substring  截取字符串  [beginindex,endindex)  包前不包后
        System.out.println(str.substring(1,3));     //从一到三
        System.out.println(str.substring(3));       //从三开始到最后

        //练习StringBuilder
        /*
        * String 不可变字符序列
        * StringBuilder 可变字符序列  继承了一个抽象类
        *
        * StringBuilder 可以动态扩容 扩大两倍+2 创建新数组，复制旧的内容再返回
        *
        * StringBuilder    线程不安全   效率较高   一般用它
        * StringBuffer     线程安全     效率较低   一般不用
        * */
        StringBuilder  stringBuilder = new StringBuilder();         //默认长度为16
        StringBuilder stringBuilder1 = new StringBuilder(32); //直接定义为32
        StringBuilder stringBuilder2 = new StringBuilder("abc");    //str.length()+16    value[]={'a','b','c',\u0000,\u0000,\u0000,...};  默认初始化
        stringBuilder2.append("acb").append('a').append(1).append(stringBuilder1).append(true).append(stringBuilder);  //方法链 通过return this形成方法链
        /*
        * 这种连接方法比 += 好，因为 += 要创建新对象！
        * */
        stringBuilder2.delete(1,3);          //删除stringBuilder里面的一些字符，包前不包后 和substring功能一样
        stringBuilder2.reverse();           //反转数组



    }
}
