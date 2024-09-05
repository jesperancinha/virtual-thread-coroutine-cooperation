plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "virtual-thread-coroutine-cooperation"
include("standalone-runnable-vt")
include("standalone-runnable-coroutines")
include("example-runnable-coroutines")
include("example-runnable-virtual-threads")
include("warehouse-service")
include("warehouse-fulfilment-mvc")
include("warehouse-fulfilment-webflux")
include("warehouse-fulfilment-coroutines")
include("warehouse-fulfilment-vt")
include("warehouse-fulfilment-vt-coroutines")
