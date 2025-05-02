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
                    // Surface の中に、Greeting コンポーザブルを配置
                    Greeting("Take")
                }
            }
        }
    }
}

// ────────────────────────────────────────────────────────────────
// @Composable アノテーション
// ・この関数が Compose の UI 部品（コンポーザブル）であることを示す。
// ・Compose のレンダリングエンジンが呼び出し・再実行を管理します。
// ・副作用がない純粋関数のように扱われ、状態変化に応じて再コンポーズされる。
// ────────────────────────────────────────────────────────────────
@Composable
fun Greeting(name: String) {
    // Text：文字列を画面に描画するコンポーザブル
    // text 引数に渡した文字列を表示
    Text(text = "Hello $name!")
}

// ────────────────────────────────────────────────────────────────
// @Preview アノテーション
// ・Android Studio のプレビュー画面にこの関数を表示するためのマーカー。
// ・showBackground = true で背景色が描画され、見やすくなるオプション。
// ・Preview 関数も @Composable である必要があります。
// ・引数なし、またはデフォルト引数のみのコンポーザブルがプレビューできます。
// ────────────────────────────────────────────────────────────────
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    // プレビューでも実際のテーマで見た目を確認できるように同じテーマを適用
    JetProfileTheme {
        Greeting("Android")
    }
}