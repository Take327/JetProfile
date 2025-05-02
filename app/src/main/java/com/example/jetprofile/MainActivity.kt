package com.example.jetprofile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

                }
            }
        }
    }
}

