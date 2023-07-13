package com.matejdro.multibindsanvildemo

import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides

@Module
@ContributesTo(AppScope::class)
class AppModule {
    @Provides
    fun provideString(): String {
        return ""
    }

    @Provides
    fun provideList(): List<String> {
        return emptyList()
    }

    @Provides
    fun provideSet(): Set<String> {
        return emptySet()
    }
}
