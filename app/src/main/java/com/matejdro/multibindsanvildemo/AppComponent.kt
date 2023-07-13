package com.matejdro.multibindsanvildemo

import com.matejdro.mylibrary.BaseClass
import com.matejdro.mylibrary.ParentClass
import com.squareup.anvil.annotations.MergeComponent
import dagger.MembersInjector

@MergeComponent(AppScope::class)
interface AppComponent {
    fun getParentClassInjector(): MembersInjector<ParentClass>
}
