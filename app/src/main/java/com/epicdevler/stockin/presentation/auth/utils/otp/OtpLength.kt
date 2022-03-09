package com.epicdevler.stockin.presentation.auth.utils.otp

sealed class OtpLength(val count: Int) {
    object Four : OtpLength(count = 4)
    object Six : OtpLength(count = 6)
    object Eight : OtpLength(count = 8)
}
