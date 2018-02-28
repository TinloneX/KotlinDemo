package org.tinlone.demo.kotlindemo.base

/**
 * @author Administrator on 2018/2/28 0028.
 */
class BaseGrammar {

    companion object {
        /**
         * 显式声明返回类型
         */
        fun sum(a: Int, b: Int): Int {
            return a + b
        }

        /**
         * 自检测返回类型
         */
        fun sum2(a: Int, b: Int) = a + b

        /**
         * 无意义类型
         */
        fun sum3(a: Int, b: Int): Unit {
            println("$a + $b = ${a + b}")
        }

        /**
         * 无意义类型Unit可以省略
         */
        fun sum4(a: Int, b: Int) {
            println("$a + $b = ${a + b}")
        }

        /**
         * 字符模版 类似于String.format()
         */
        fun textModel() {
            var a = 1
            // 模板中的简单名称：
            val s1 = "a is $a"
            a = 2
            // 模板中的任意表达式：
            val s2 = "${s1.replace("is", "was")}, but now is $a"
        }

        /**
         * 条件表达式
         */
        fun max(a: Int, b: Int) = if (a > b) a else b

        /**
         * 可空返回值
         */
        fun toStr(obj: Any): Int? {
            return 12
        }

        /**
         * 可空值的使用
         */
        fun canNull(arg1: Any?) {
            val a = arg1?.toString() + "" // obj?. 类似于 if(obj != null)

            val x = toStr(a)

//            print(x * 12)  // 直接使用会报错，因为x可能为空
            if (x == null) {
                return
            }  // 试试 Alt + Enter

            print(x * 12)     // 空检测后 x会自动转换为非空值
        }

        /**
         * 类型检测
         */
        fun getStringLength(obj: Any): Int? {
            if (obj is String) {
                // `obj` 在该条件分支内自动转换成 `String`
                return obj.length
            } else  // `obj` 在 `&&` 右边自动转换成 `String` 类型
                if (obj is String && obj.length > 0) {
                    return obj.length
                }
            // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
            return null
        }

        /**
         * for 循环
         */
        fun forList() {
            val items = listOf("apple", "banana", "kiwi")
            for (item in items) {
                println(item)
            }

            for (index in items.indices) {
                println("item at $index is ${items[index]}")
            }
        }

        /**
         * while 循环
         */
        fun whileList() {
            val items = listOf("apple", "banana", "kiwi")
            var index = 0
            while (index < items.size) {
                println("item at $index is ${items[index]}")
                index++
            }
        }

        /**
         * when 分支判断，类比：switch-case
         */
        fun whenCase(obj: Any): String =
                when (obj) {
                    1 -> "One"
                    "Hello" -> "Greeting"
                    is Long -> "Long"
                    !is String -> "Not a string"
                    else -> "Unknown"
                }

        /**
         * 区间  start..end
         */
        fun rangeUsed() {
            val x = 10
            // 判断在不在区间内
            if (x in 0..100) {
                println("$x in [0, 100]")
            }

            val list = listOf("a", "b", "c")
            // 判断在不在区间内
            if (-1 !in 0..list.lastIndex) {
                println("-1 is out of range")
            }
            // 判断在不在区间内
            if (list.size !in list.indices) {
                println("list size is out of valid list indices range too")
            }
            //区间迭代
            for (i in 1..5) {
                print(x)
            }
            println()
            // 数列等差迭代
            for (i in 1..5 step 2) {
                print(x)
            }
            println()
            // 降序数列等差迭代
            for (x in 9 downTo 0 step 3) {
                print(x)
            }
        }

        fun inUse() {
            //对集合进行迭代:
            val items = listOf("apple", "banana", "kiwi")
            for (item in items) {
                println(item)
            }
            //使用 in 运算符来判断集合内是否包含某实例：
            when {
                "orange" in items -> println("juicy")
                "apple" in items -> println("apple is fine too")
            }
            //使用 lambda 表达式来过滤（filter）和映射（map）集合：
            val fruits = listOf("banana", "avocado", "apple", "kiwi")
            fruits
                    .filter { it.startsWith("a") }
                    .sortedBy { it }
                    .map { it.toUpperCase() }
                    .forEach { println(it) }
        }


    }

}