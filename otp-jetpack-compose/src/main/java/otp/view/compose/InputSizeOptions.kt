package otp.view.compose

/**
 * [InputSizeOptions.INPUT_SIZE_FOUR] for four digit otp
 *
 * [InputSizeOptions.INPUT_SIZE_SIX] for six digit otp
 */
enum class InputSizeOptions(val size: Int) {
    INPUT_SIZE_FOUR(4),
    INPUT_SIZE_SIX(6)
}
