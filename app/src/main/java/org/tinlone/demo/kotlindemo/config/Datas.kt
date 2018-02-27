package org.tinlone.demo.kotlindemo.config

import org.tinlone.demo.kotlindemo.bean.User

/**
 * @author Administrator on 2018/2/27 0027.
 */
class Datas {

    companion object {
        var USERS_ARRAY: Array<User> =
                arrayOf(User("Ford", "Andy", 18),
                        User("Stan", "Toma", 15),
                        User("Frank", "Flash", 22),
                        User("Hor", "Candy", 19),
                        User("San", "Wee", 25),
                        User("Jam", "Tony", 16)
                )
    }

}