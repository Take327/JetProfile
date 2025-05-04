package com.example.jetprofile

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.example.jetprofile.components.CompanySection
import com.example.jetprofile.components.DetailSection
import com.example.jetprofile.ui.theme.JetProfileTheme

/**
 * アプリ起動時に最初に呼ばれる Activity。
 * ComponentActivity を継承し、Compose で UI を描画します。
 */
class MainActivity : ComponentActivity() {

    /**
     * onCreate(): Activity が生成された際に呼び出されるライフサイクルメソッド
     * - Compose の UI ツリーをセットアップします。
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 独自テーマを適用 (色・タイポグラフィ・形状設定など)
            JetProfileTheme {
                // ステータスバーの色とアイコン色を制御
                SystemUiController(
                    statusBarColor = Color.White,
                    useDarkIcons = true
                )
                // Surface: 背景色・影をもつコンテナ
                Surface(
                    modifier = Modifier.fillMaxSize(),                      // 画面全体を占有
                    color = MaterialTheme.colors.background                 // テーマの背景色を適用
                ) {
                    MainContent()  // メイン画面のコンテンツを描画
                }
            }
        }
    }
}

/**
 * メイン画面のコンテンツを描画するコンポーザブル。
 *
 * プロフィール画像、名前、職業、会社情報ボタン、詳細表示などを管理します。
 */
@Composable
fun MainContent() {
    // 詳細表示トグル状態を記憶 (初期は非表示)
    var isDetailShow by remember { mutableStateOf(false) }

    // 縦並びレイアウト、中央寄せ・余白付き
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp)
    ) {
        // プロフィール画像
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "プロフィール画像",
            modifier = Modifier
                .size(100.dp)                               // 100dp の正方形
                .clip(RoundedCornerShape(10.dp))            // 角を丸める
        )

        Spacer(modifier = Modifier.height(20.dp))           // 20dp の余白

        // 名前表示
        Text(
            text = "Take",
            color = Color.Gray,                            // グレー文字
            fontSize = 16.sp,                              // 16sp フォントサイズ
            fontWeight = FontWeight.ExtraBold              // 極太ウェイト
        )

        Spacer(modifier = Modifier.height(20.dp))           // 20dp の余白

        // 職業表示
        Text(
            text = "職業：エンジニア",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(modifier = Modifier.height(20.dp))           // 20dp の余白

        // 会社情報セクション（独自コンポーネント）
        CompanySection()

        Spacer(modifier = Modifier.height(20.dp))           // 20dp の余白

        // 詳細表示トグルボタン
        Button(
            onClick = { isDetailShow = !isDetailShow },     // 押すたび表示／非表示を切り替え
            modifier = Modifier.fillMaxWidth(),              // 横幅いっぱい
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFF85F6A)          // ボタン背景色
            )
        ) {
            Text(text = if (isDetailShow) "詳細を閉じる" else "詳細を表示", color = Color.White)
        }

        Spacer(modifier = Modifier.height(20.dp))           // 20dp の余白

        // 詳細セクションを条件付きで表示
        if (isDetailShow) {
            DetailSection()
        }
    }
}

/**
 * ステータスバーの背景色とアイコンの色を設定するコンポーザブル。
 *
 * @param statusBarColor ステータスバーの背景色 (Compose の Color)
 * @param useDarkIcons   true ならアイコンをダークモード (黒)，false ならライトモード (白)
 */
@Composable
fun SystemUiController(
    statusBarColor: Color,
    useDarkIcons: Boolean
) {
    // Compose ツリーに関連付けられた View を取得
    val view = LocalView.current

    SideEffect {
        // View の Context から Activity と Window を取り出す
        val window = (view.context as Activity).window
        // ステータスバーの背景色を設定 (toArgb で Int に変換)
        window.statusBarColor = statusBarColor.toArgb()
        // アイコン色の明暗を切り替え
        WindowCompat.getInsetsController(window, view)
            ?.isAppearanceLightStatusBars = useDarkIcons
    }
}
