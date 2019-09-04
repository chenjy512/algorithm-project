package com.cjy.recurrence

/**
  * 递归算法
  */
object recurrenceDemo1 {

  def main(args: Array[String]): Unit = {
    //    println(demo1(50))
    //    println(demo2(3))
    //    println(demo3(1))
    println("str".charAt(0)*2)
    println("str".substring(1,"str".length))
    println(product("Hello"))
  }

  /**
    * 题1：请使用递归的方式，求出斐波那契数 1,1,2,3,5,8,13...
    * 解析：当前数小于2 ，则是1
    * 当前数n大于二，则当前数是前两个数的和，n=(n-1)+(n-2)
    */
  def demo1(p: Int): Long = {
    if (p <= 2) {
      return 1
    } else {
      return demo1(p - 1) + demo1(p - 2)
    }
  }

  /**
    * 题2：已知 f(1)=3; f(n) = 2*f(n-1)+1; 递归求出f(n) 的值
    * 3、7、15、31
    */
  def demo2(n: Int): Int = {
    if (n == 1) {
      3
    } else {
      2 * demo2(n - 1) + 1
    }
  }

  /**
    * 题 3：猴子吃桃子问题
    * 有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！以后每天猴子都吃其中的一半，然后
    * 再多吃一个。当到第十天时，想再吃时（还没吃），发现只有 1 个桃子了。问题：最初共多少个桃
    * 子？
    * 结果：1534
    * 思路：
    * 首先求的结果是最初有多少桃，那么第十天则是递归终止条件，
    * 根据后一天的剩余数反推前一天，以此类推，通过第十天反推第九天，一直到第一天即可
    * 主要是将其公式梳理出来，通过反推方式即可
    */
  def demo3(p: Int): Int = {
    if (p >= 10) {
      1
    } else {
      //如第九天的剩余数应该是：day9 = （1+1）* 2
      (demo3(p + 1) + 1) * 2
    }
  }

  /**
    *题4：编写一个递归函数 product(str:String)，计算字符串中所有字母的Unicode代码的乘积
    * 题解：
    *     前一个字符串的unicode码值乘以后面字符串的unicode码值
    * 思路：
    *     既然让使用递归，那么终止条件就是判断当前字符长度是否为1，每次取出首字母乘以后面的字符串，后面的字符串递归调用
    *
    *   Hello=9415087488
    */
  def product(str: String): Long = {
    if (str.length == 1) {
      str.charAt(0)
    } else {
      str.charAt(0) * product(str.substring(1, str.length))
    }
  }
}
