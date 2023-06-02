package com.matejdro.mylibrary

import com.squareup.anvil.annotations.ContributesMultibinding
import javax.inject.Inject

@ContributesMultibinding(AppScope::class)
class LibraryMultibinds @Inject constructor(): BaseClass()
