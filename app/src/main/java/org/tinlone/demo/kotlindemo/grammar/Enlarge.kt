package org.tinlone.demo.kotlindemo.grammar

/**
 * 方法扩展
 */
object Enlarge {

    @JvmStatic
    fun main(args: Array<String>) {
        val lst = mutableListOf(1, 2, 3, 4, 5)
        lst.swap(2, 4)
        lst.lastIndex
        println(lst)
        MyClass.foo()
        C().caller(D())
    }

    private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    fun Any?.string(): String {
        if (this == null) return "null"
        return toString()
    }

    private val <T> List<T>.lastIndex: Int
        get() = size - 1

    class MyClass {
        companion object
    }

    private fun MyClass.Companion.foo() {
        println("hello")
    }

    class D{
        fun bar(){
            println("d.bar()")
        }

        override fun toString(): String {
            return "d.toString()"
        }
    }

    class C{
        private fun baz(){
            println("c.baz()")
        }

        private fun D.foo(){
            bar()
            baz()
        }
        fun D.string(){
            println(toString())
            println(this@C.toString())
        }

        fun caller(d:D){
            d.foo()
            d.string()
        }

        override fun toString(): String {
            return "c.toString()"
        }
    }

}