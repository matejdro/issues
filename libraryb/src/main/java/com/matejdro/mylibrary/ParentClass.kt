package com.matejdro.mylibrary

import javax.inject.Inject

class ParentClass: BaseClass() {
    @Inject
    lateinit var aListOfString: List<String>
}
