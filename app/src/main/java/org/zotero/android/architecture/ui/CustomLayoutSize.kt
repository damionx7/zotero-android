package org.zotero.android.architecture.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.lang.Integer.min

object CustomLayoutSize {
    enum class LayoutType {
        big, medium, small;

        fun calculateTextSize(): TextUnit {
            return when (this) {
                big, medium -> 20.sp
                small -> 14.sp
            }
        }

        fun calculateTitleTextSize(): TextUnit {
            return when (this) {
                big, medium -> 26.sp
                small -> 20.sp
            }
        }

        fun calculatePadding(): Dp {
            return when (this) {
                big, medium -> 50.dp
                small -> 8.dp
            }
        }

    }

    @Composable
    fun calculateLayoutType(): LayoutType {
        val configuration = LocalConfiguration.current

        val screenWidth = configuration.screenWidthDp
        val screenHeight = configuration.screenHeightDp

        val size = min(screenWidth, screenHeight).dp
        if (size >= 834.dp) {
            return LayoutType.big
        } else if (size >= 768.dp) {
            return LayoutType.medium
        }
        return LayoutType.small
    }
}