# Pix
Pix is an application that consumes the [PixabayApi]() and retrieves the pictures and videos. The app is built using MVVM design pattern to allow separation of concers. The App can work offline with the use cache strategy using Room.

## Architecture
This Application is built following the Clean Architecture principles and  [MVVM]() Architecture. Clean Architecture attracts various advantages while building android apps which inlude:

* Ease in Testability
* The UI can change easily, without changing the rest of the system.
* Separations of business logic(concerns) from the ui.
* User-friendly package structure

See the graphical representation of the architecture
![alt text](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

## Tech stack
 * [Retrofit](https://github.com/square/retrofit)- is a type-safe REST client for Android, Java and Kotlin, built as a powerful framework for consuming APIs
 * [Kotlin](https://kotlinlang.org/docs/reference/) - Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise

* [Room](https://developer.android.com/topic/libraries/architecture/room.html) -  a persistence library provides an abstraction layer over SQLite for cache

* [Dagger-Hilt](https://dagger.dev/hilt/)- a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project

* [Navigation Components](https://developer.android.com/guide/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app.


* [Coroutines](https://developer.android.com/kotlin/coroutines) - a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
* [Flow](https://developer.android.com/kotlin/flow)- In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.

* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html) - A lifecycle-aware data holder with the observer pattern

* [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel)-  store and manage UI-related data in a lifecycle conscious way.

* [Lifecycle]( https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.

* [Glide](https://github.com/bumptech/glide) - Image Loader library.

  ## Data source
  
  Sign up to Pixabay to get the api key and in detail documentation [https://pixabay.com/api/docs/](https://pixabay.com/api/docs/)

## Screenshhots
<img src="/screenshots/home.png" width="320">&emsp;
<img src="/screenshots/details.png" width="320">&emsp;
<img src="/screenshots/videos.png" width="320">


## Demo

## Author
Felix Kariuki

Twitter - [@felixkariuki_](https://twitter.com/felixkariuki_)

LinkedIn - [Felix Kariuki](https://www.linkedin.com/in/felix-kariuki/)

## License and Copyright

[MIT LICENSE](LICENSE)
```
MIT License

Copyright (c) Year Felix m Kariuki

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

```
