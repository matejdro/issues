package com.matejdro.mylibrary

import android.app.Activity
import javax.inject.Inject

abstract class BaseClass: Activity() {
    @Inject
    lateinit var aString: String

    @Inject
    lateinit var aSet: Set<String>

    val b: String = ""
}
