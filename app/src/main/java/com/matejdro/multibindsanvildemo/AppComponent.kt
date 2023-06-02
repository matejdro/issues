package com.matejdro.multibindsanvildemo

import com.matejdro.mylibrary.AppScope
import com.matejdro.mylibrary.BaseClass
import com.squareup.anvil.annotations.MergeComponent

@MergeComponent(AppScope::class)
interface AppComponent {
    fun provideMultibindsSet(): Set<BaseClass>
}
