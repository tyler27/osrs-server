package com.osrs.application

import com.google.inject.name.Names
import com.osrs.common.map.MapSquares
import dev.misfitlabs.kotlinguice4.KotlinModule
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationEnvironment

class ApplicationModule(
    private val args: Array<String>
) : KotlinModule() {
    override fun configure() {
        bind<Array<String>>().annotatedWith(Names.named("args")).toInstance(args)
        // Guice seems to be silently ignoring @Singleton annotations when using the Provider<T> pattern.
        // We want to eagerly load this here, so it's always eagerly loaded in prod/dev.
        bind<Application>().toProvider<ApplicationProvider>().asEagerSingleton()
        bind<ApplicationEnvironment>().toProvider<ApplicationEnvironmentProvider>().asEagerSingleton()
        bind<MapSquares>().asEagerSingleton()
    }
}
