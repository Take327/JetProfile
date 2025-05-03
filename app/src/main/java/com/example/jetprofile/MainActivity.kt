package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetprofile.ui.theme.JetProfileTheme

// ────────────────────────────────────────────────────────────────
// MainActivity：アプリ起動時に最初に表示されるエントリポイント
// ComponentActivity を継承することで、Compose を直接使えるようになります。
// ────────────────────────────────────────────────────────────────
class MainActivity : ComponentActivity() {

    // onCreate：Activity が生成されたときに呼ばれるライフサイクルメソッド
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent { … } ブロック内が Compose で描画される UI ツリーになります
        setContent {
            // 自作テーマを適用。内部で MaterialTheme をラップしています
            JetProfileTheme {
                // Surface：背景色や影を管理するコンテナ
                Surface(
                    modifier = Modifier.fillMaxSize(),                      // 画面全体を占有
                    color = MaterialTheme.colors.background                 // テーマで定義された背景色を使用
                ) {
                    // Column: 子コンポーザブルを縦方向に並べるレイアウト
                    // horizontalAlignment = Alignment.CenterHorizontally で列内を横方向に中央揃え
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        //プロフィール画像
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "プロフィール",
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp))
                        )
                        // Spacer: 空白領域を挿入。ここでは下方向に20dpの余白を確保
                        Spacer(
                            modifier = Modifier.height(20.dp)      // dp は画面の密度に依存しないサイズ単位
                        )
                        // 1行目のテキスト
                        Text(
                            text = "Take",                         // 表示する文字列
                            color = Color.Gray,                    // テキストの色をグレーに
                            fontSize = 16.sp,                      // フォントサイズを16spに（sp は文字に最適化された単位）
                            fontWeight = FontWeight.ExtraBold      // 太字の中でも極太を指定
                        )

                        // Spacer: 空白領域を挿入。ここでは下方向に20dpの余白を確保
                        Spacer(
                            modifier = Modifier.height(20.dp)      // dp は画面の密度に依存しないサイズ単位
                        )

                        // 2行目のテキスト
                        Text(
                            text = "職業：エンジニア",             // 日本語テキストも同様に表示可能
                            color = Color.Gray,                    // 色は先と同じグレー
                            fontSize = 16.sp,                      // サイズも揃える
                            fontWeight = FontWeight.ExtraBold      // 太さも揃える
                        )

                        Spacer(
                            modifier = Modifier.height(20.dp)      // dp は画面の密度に依存しないサイズ単位
                        )

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
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription = "email",
                                )
                                Spacer(
                                    modifier = Modifier.width(10.dp)      // dp は画面の密度に依存しないサイズ単位
                                )
                                Text(text = "Email", fontSize = 14.sp, fontWeight = FontWeight.Bold)

                            }
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

                }
            }
        }
    }

}

