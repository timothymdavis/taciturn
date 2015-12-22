# Taciturn

A contextual Java utility library intended to augment built-in objects, such as `Integer`, `Short`, `Long`,
`Float`, `Double`, `HashSet`, `ArrayList`, Arrays, and many others.

## Introduction

This library is targeted to Java 8 users who want to add some extra functionality to their favorite objects. You
will likely notice some similarities to notable Javascript libraries jQuery and Underscore. The goal of Taciturn
is to add what is missing, and make common, tedious operations more convenient.

It should be noted that Taciturn is very immature at this time. Keep in mind that the method signatures may
change over the coming weeks. Hopefully it will settle into a grove in the near future. Once we hit the `1.0.0`
version, I will be sure to deprecate anything that will disappear in an upcoming release. Until then, I hope
that you will be willing to put up with a small amount of chaos.

## Hello World

Once you have added the dependency, getting started with Taciturn is pretty straightforward. The only include
required is `import static io.taciturn.Utility.$;`. The snippet below shows the creation of a list of strings
from a raw array, which are then printed out to the console.

![alt text](site/image/hello-world.gif "Hello World")

## Working With `Comparable` Objects

`Comparable` objects can be acted upon in three slightly different ways: boolean, filter, and assert.

### Boolean Methods

All of the boolean methods in Taciturn start with "is" (e.g. `isLessThan`,) and return a boolean value.

### Filter Methods

Filter methods are built-in predicates, are declarative in nature (e.g. `lessThan`,) and return a reference to the
utility object.

### Assert Methods

All assert methods start with "must" (e.g. `mustBeLessThan`,) and return a reference to the utility object.

![alt text](https://github.com/timothymdavis/taciturn/raw/master/site/image/working-with-comparable.gif "Working with Comparable")


## Working With `Array` and `Collection` Objects

You can create either create an array beforehand and pass it into Taciturn, or you can create it on the
fly as shown below.

![alt text](https://github.com/timothymdavis/taciturn/raw/master/site/image/working-with-arrays.gif "Working with Arrays")

## Working With `null` values

You may have already noticed that `null` values are handled in a manner similar to `java.util.Optional`.
Indeed, Taciture uses `Optional` under the hood to achieve most of what it does. This means that you can do
things like

    String name = null;
    String lowerCaseName = $(name).map(String::toLowerCase).orElse(null);

without checking for `null`.

## More to Come

Eventually I'll add more details on `Date`, `Instant`, and other utility objects. I also plan to add more to
Taciturn. Expect to see utility objects for `InputStream`, `OutputStream`, and other common types. Right now, I want
to get a solid foundation to build on.
