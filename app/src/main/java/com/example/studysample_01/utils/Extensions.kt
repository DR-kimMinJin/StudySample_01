package com.example.studysample_01.utils

import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY

object Extensions {

    @JvmStatic
    fun htmlToSting(text: String): String {
        return HtmlCompat.fromHtml(text, FROM_HTML_MODE_LEGACY).toString()
    }

}

