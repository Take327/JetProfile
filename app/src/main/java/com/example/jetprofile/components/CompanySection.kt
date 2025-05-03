package com.example.jetprofile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanySection() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {
        //会社名
        Text(
            text = "XXX株式会社",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold      // 太さも揃える
        )
        Spacer(
            modifier = Modifier.height(10.dp)      // dp は画面の密度に依存しないサイズ単位
        )
        //組織
        Text(
            text = "ITチーム",
            fontSize = 16.sp,
            color = Color.Gray,                    // 色は先と同じグレー
        )
        Spacer(
            modifier = Modifier.height(20.dp)      // dp は画面の密度に依存しないサイズ単位
        )
        //Email
        Label(icon = Icons.Default.Email, text = "Email")
        Spacer(
            modifier = Modifier.height(10.dp)      // dp は画面の密度に依存しないサイズ単位
        )
        Text(text = "example@xx.co.jp", fontSize = 16.sp)
        Spacer(
            modifier = Modifier.height(5.dp)      // dp は画面の密度に依存しないサイズ単位
        )
        Divider(
            modifier = Modifier.clip(RoundedCornerShape(1000.dp)),
            thickness = 2.dp,
        )
    }
}