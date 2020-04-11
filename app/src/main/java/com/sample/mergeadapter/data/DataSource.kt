package com.sample.mergeadapter.data

import com.sample.mergeadapter.R
import com.sample.mergeadapter.models.Footer
import com.sample.mergeadapter.models.User

object DataSource
{
    fun getUser() = ArrayList<User>().apply {
        add(User(1, "User 1", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(2, "User 2", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(3, "User 3", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(3, "User 4", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(4, "User 5", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(5, "User 6", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(6, "User 7", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(7, "User 8", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(8, "User 9", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(9, "User 10", "https://i.ibb.co/DLcK2Zh/image.jpg"))
        add(User(10, "User 11", "https://i.ibb.co/DLcK2Zh/image.jpg"))

    }

    fun getFooter() = Footer("https://i.ibb.co/60kLQw6/5056179b42b174f.jpg")
}