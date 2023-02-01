# Project Rules

This library is a collection of ideas from [this talk](https://www.youtube.com/watch?v=MIG2nwULff8&ab_channel=IT%27sTinkoff).

## Key Rules

1. Don't use unchecked exceptions
2. Don't use **null** value
3. Use "the wrap around" pattern

### Rule 1

1. Don't use exceptions
2. If this is not possible, use checked exceptions

### Rule 2

Use `Optional<T>` from `java.util`

### Rule 3

Use lambda expressions for wrapping around any code

### Transactor

Implement `com.itdoggz.projectrules.transactor.Transactor` interface
with Spring `@Service` and
`@Trancational(propagation = Propagation.REQUIRES_NEW)` to use transactions pointwise
