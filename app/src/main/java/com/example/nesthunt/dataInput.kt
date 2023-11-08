package com.example.nesthunt

object dataInput {
    private lateinit var dataList: ArrayList<dataclass>
    fun getData():ArrayList<dataclass>{
        dataList = ArrayList<dataclass>()
        dataList.add(dataclass(R.drawable.image1, "Muskan PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "Divyanshi PG", "Street No. 1"))
        dataList.add(dataclass(R.drawable.image3, "Urvashi PG", "Street No. 1"))
        dataList.add(dataclass(R.drawable.image1, "Tyagi PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "White House PG", "Opposite college "))
        dataList.add(dataclass(R.drawable.image3, "Muskan PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image1, "Tyagi PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "White House PG", "Opposite college "))
        dataList.add(dataclass(R.drawable.image3, "Muskan PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image1, "Tyagi PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "White House PG", "Opposite college "))
        dataList.add(dataclass(R.drawable.image3, "Muskan PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image1, "Tyagi PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "White House PG", "Opposite college "))
        dataList.add(dataclass(R.drawable.image3, "Muskan PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image1, "Tyagi PG", "Street No. 2"))
        dataList.add(dataclass(R.drawable.image2, "White House PG", "Opposite college "))
        dataList.add(dataclass(R.drawable.image3, "Muskan PG", "Street No. 2"))

        return dataList
    }
}