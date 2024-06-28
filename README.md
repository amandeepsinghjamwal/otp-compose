# OTP View Library for Jetpack Compose

![License](https://img.shields.io/badge/license-MIT-blue.svg)

An Android library providing a customizable OTP (One Time Password) view using Jetpack Compose. This library simplifies the process of integrating OTP input functionality into your Jetpack Compose applications.

## Features

- Easy to integrate and use
- Customizable OTP length
- Support for different styles and themes
- Automatic focus change
- Two styles, Box and dashed options available 

## Installation

Add the following dependency to your `build.gradle` or `build.gradle.kts` file:

```groovy
<!-- Groovy -->
dependencies {
    implementation 'com.github.amandeepsinghjamwal:otp-compose:1.0.0'
}

<!-- Kotlin DSL-->
dependencies {
    implementation("com.github.amandeepsinghjamwal:otp-compose:1.0.0")
}
 ```

Also, don't forget to add jitpack inside `repositories` block in your `settings.gradle` or `settings.gradle.kts` file

```groovy
<!-- Groovy -->
maven { url 'https://jitpack.io' }

<!-- Kotlin DSL-->
maven {url = URI("https://jitpack.io") }
 ```

## Usage
### BoxOtpView
```kotlin
BoxOtpView(
    modifier = Modifier,
    inputLength = InputSizeOptions.INPUT_SIZE_FOUR,
    containerSize = 45.dp,
    containerSpacing = 10.dp,
    containerShape = AbsoluteRoundedCornerShape(10.dp),
    hideOtp = false,
    otpBoxColors = OtpBoxDefaults.otpBoxColors(),
    textStyle = TextStyle()
    ) { otp-> }
```
### DashedOtpView
```kotlin
DashedOtpView(
    modifier = Modifier,
    inputLength = InputSizeOptions.INPUT_SIZE_FOUR,
    textStyle = OtpViewDefaults.textStyle(color = Color.Black),
    dashSpacing = 12.dp,
    dashWidth = 40.dp,
    hideOtp = false,
    dashColors = OtpViewDefaults.dashedOtpColors()
    ) {otp-> }
```

## Contributing
We welcome contributions! Please feel free to contribute.
