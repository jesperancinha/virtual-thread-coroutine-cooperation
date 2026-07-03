---
name: annotations
description: Conventions for using annotations in all tests using Jupiter
---

## 1. Make sure to use `@param:Value` eveywhere @Value is declared for Kotlin classes and files only

Remember to run tests after replacing all of them

## 2. Make sure to use interpolation prefixes for the `@Value` annotation in Kotlin classes and files only

### Example 1

Replace this:

```kotlin
class VirtualThreadsDemoApplication(
    val taskService: TaskService,
    @param:Value("\${org.jesperancinha.vtcc.tasks}") private val tasks: Int,
)
```

with this:

```kotlin
class VirtualThreadsDemoApplication(
    val taskService: TaskService,
    @param:Value($$"${org.jesperancinha.vtcc.tasks}") private val tasks: Int,
) 
```

## 3. Checklist

[] Make sure there is no more use of `@Value` annotation being used directly
[] Make sure no `@param:Value` has been changed in a Java file
[] Check that all `@param:Value` annotations are used correctly
