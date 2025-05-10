# virtual-thread-coroutine-cooperation

## Introduction

Research into how coroutines can answer to today's problems with the help of virtual threads and how the opposite can
also be true

## Releases

| Version  - Git-Tag                                                                        | Git Hash                                                                                                                                                        | Purpose                                                                                                                                                                                                                                                          |
|-------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [1.0.0](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/1.0.0) | [d00c17e448a19c3653e3c86093161e508e35c06d](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/d00c17e448a19c3653e3c86093161e508e35c06d) | [Could Virtual Threads Cast Away the Usage of Kotlin Coroutines](https://www.scribd.com/presentation/768072685/Could-Virtual-Threads-Cast-Away-the-Usage-of-Kotlin-Coroutines). First version of the documentation on Scribd for LJC London 2025                 |
| [2.0.0](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/2.0.0) | [edfd0d882696f0b403cb7054387ed07d02d7a21e](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/edfd0d882696f0b403cb7054387ed07d02d7a21e) | Video Completion                                                                                                                                                                                                                                                 |
| [3.0.0](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/3.0.0) | [7dbec03e648a1643b59fc7f710357e202c3694da](https://github.com/jesperancinha/virtual-thread-coroutine-cooperation/tree/7dbec03e648a1643b59fc7f710357e202c3694da) | [Could Virtual Threads Cast Away the Usage of Kotlin Coroutines](https://www.scribd.com/presentation/859430026/Could-Virtual-Threads-Cast-Away-the-Usage-of-Kotlin-Coroutines-DevoxxUK2025). Second version of the the documentation on Scribd for DevoxxUK 2025 |                                                                                                                                                                                                                 |

* Note: All services do not have a converter implemented. This is intentional with the purpose to simplify code. In
  production environments, the DTO layer should be separated from the Domain and that separation should be very clear
  for purposes of readability, but also in some cases for safety concerns.

Projects for comparisons:

1. [warehouse-fulfilment-mvc](warehouse-fulfilment-mvc)
2. [warehouse-fulfilment-webflux](warehouse-fulfilment-webflux)
3. [warehouse-fulfilment-coroutines](warehouse-fulfilment-coroutines)
4. [warehouse-fulfilment-vt](warehouse-fulfilment-vt)

Only for version 1.0.0:

[warehouse-fulfilment-vt-coroutines](warehouse-fulfilment-vt-coroutines)

Experiments with non-blocking logs:

[warehouse-fulfilment-webflux-non-blocking](warehouse-fulfilment-webflux-non-blocking)

## Resources

### Online

- [Kotlin releases](https://kotlinlang.org/docs/releases.html)
- [JEP 491: Synchronize Virtual Threads without Pinning](https://openjdk.org/jeps/491)
- [Java 21 Virtual Threads - Dude, Where’s My Lock?](https://netflixtechblog.com/java-21-virtual-threads-dude-wheres-my-lock-3052540e231d)
- [Coroutines, Java Virtual Threads and Scoped Values](https://discuss.kotlinlang.org/t/coroutines-java-virtual-threads-and-scoped-values/28004/2)
- [Embracing Virtual Threads](https://spring.io/blog/2022/10/11/embracing-virtual-threads)
- [How to use virtual threads with Spring Boot](https://bell-sw.com/blog/a-guide-to-using-virtual-threads-with-spring-boot)
- [Context Switching Theory](https://www.ibm.com/docs/en/zvm/7.3?topic=exits-context-switching)
- [Thread Theory - DePaul University - Boston](https://condor.depaul.edu/glancast/443class/docs/lecFeb05.html)

### Related projects

- [Good story](https://github.com/jesperancinha/good-story/)
- [Kotlin Mysteries](https://github.com/jesperancinha/kotlin-mysteries)

> For more information about using the different JDK's using SDK-MAN please check the docs on my cloud project over at:
>
> https://github.com/jesperancinha/jeorg-cloud-test-drives/tree/main/docs
>
> https://github.com/jesperancinha/jeorg-cloud-test-drives/tree/main/docs/system/ubuntu
>
> https://jesperancinha.github.io/jeorg-cloud-test-drives/

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
