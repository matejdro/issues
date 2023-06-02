package com.matejdro.multibindsanvildemo

import com.matejdro.anvildemo.AppScope
import com.matejdro.anvildemo.MyClass
import com.squareup.anvil.annotations.MergeComponent

@MergeComponent(AppScope::class)
interface AppComponent {
    fun provideMyClass(): MyClass
}
