package com.example.applevelup_grupo999

import ApiRestTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.applevelup_grupo999.ui.screens.PostScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite que la app dibuje contenido debajo de las barras del sistema
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Aquí inicia Jetpack Compose
        setContent {
            // Aplicamos el tema Material 3
            ApiRestTheme {
                // Inyectamos el ViewModel
                val postViewModel: com.example.applevelup_grupo999.viewmodel.PostViewModel = viewModel()

                // Llamamos a la pantalla principal y pasamos el ViewModel
                PostScreen(viewModel = postViewModel)
            }
        }
    }
}