package org.tinlone.demo.kotlindemo.grammar

object ObjectiveClass {

    @JvmStatic
    fun main(args: Array<String>) {
        aoo()
    }

    private fun aoo() {
        val tom = Teacher("Tom")
        tom.gender = true
        tom.doSomething()
        tom.stop()
        val peter = Student("peter")
        peter.doSomething()
        peter.stop()
        var employee = Employee("Tom", "Cat")
        println(employee.name)
        employee.work()
        employee.stop()
        //验证Employee是否实现Person的stop行为
        (employee as Person).stop()
    }

    /**
     * person类，单参构造函数
     */
    open class People constructor(name: String) {
        open var gender: Boolean = false
    }

    /**
     * 接口
     */
    interface Movable {
        /**
         * 定义行为
         */
        fun doSomething()

        /**
         * 可选的方法体
         */
        fun stop() {
            println("stopped !")
        }
    }

    /**
     * 继承并默认实现父类构造器
     */
    class Teacher constructor(name: String) : People(name), Movable {
        //重写属性
        override var gender: Boolean = false

        /**
         * 定义二级构造器
         */
        constructor(name: String, age: Int) : this(name)

        /**
         * 实现行为
         */
        override fun doSomething() {
            println("Teacher teach")
        }

        /**
         * 重写行为
         */
        override fun stop() {
            println("Teacher sleep")
        }

    }

    /**
     * 继承属性，实现
     */
    class Student constructor(val name: String) : People(name), Movable {
        override fun doSomething() {
            println("${this.name} study")
        }
    }

    /**
     * 接口
     */
    interface Named {
        val name: String
    }

    /**
     * 接口继承
     */
    interface Person : Named {
        val firstName: String
        val lastName: String
        /**
         * 继承接口定义所缺少的实现
         */
        override val name: String
            get() = "$firstName $lastName"

        fun work() {
            println("worker")
        }

        fun stop()
    }

    interface Power {
        fun work() {
            println("working")
        }

        fun stop() {
            println("back home")
        }
    }

    /**
     * 父接口已实现name定义，此处不必实现name
     */
    class Employee(
            override val firstName: String,
            override val lastName: String
    ) : Person, Power {
        /**
         * 两个父级接口均有work，可选择继承和覆盖
         */
        override fun work() {
            super<Person>.work()
            super<Power>.work()
        }

        /**
         * 仅可覆盖B的stop
         * 问：有没有实现Person的stop方法
         */
        override fun stop() {
            super.stop()
        }

    }

}



