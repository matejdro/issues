package com.matejdro.multibindsanvildemo

import com.matejdro.mylibrary.AppScope
import com.matejdro.mylibrary.BaseClass
import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class AppMultibinds @Inject constructor(): BaseClass()
