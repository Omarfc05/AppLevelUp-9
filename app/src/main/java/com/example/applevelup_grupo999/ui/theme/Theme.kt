import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.applevelup_grupo999.ui.theme.Typography

// --- 1. Definición de Colores ---

// Colores por defecto para el Tema Claro
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6750A4), // Púrpura base (adaptar a tu marca)
    secondary = Color(0xFF625B71),
    tertiary = Color(0xFF7D5260),
    background = Color(0xFFFFFBFF),
    surface = Color(0xFFFFFBFF),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

// Colores por defecto para el Tema Oscuro
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFD0BCFF), // Púrpura claro
    secondary = Color(0xFFCCC2DC),
    tertiary = Color(0xFFEFB8C8),
    background = Color(0xFF1C1B1F),
    surface = Color(0xFF1C1B1F),
    onPrimary = Color(0xFF381E72),
    onSecondary = Color(0xFF332D41),
    onTertiary = Color(0xFF492532),
    onBackground = Color(0xFFE6E1E5),
    onSurface = Color(0xFFE6E1E5),
)

// --- 2. Función Composable del Tema ---

@Composable
fun ApiRestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desactivamos Dynamic Color para simplificar,
    // pero puedes habilitarlo si lo deseas (Android 12+)
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        // En un proyecto real, aquí se incluye el Dynamic Color
        // (requiere imports y lógica adicional para Build.VERSION.SDK_INT)
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // Configuración del color de la barra de estado y la barra de navegación
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.surface.toArgb() // Color de fondo del Scaffold
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // El componente MaterialTheme aplica todas las definiciones al 'content'
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Asumimos que también tienes un archivo Typography.kt
        content = content
    )
}

// Nota: Necesitarás añadir también los imports para 'Color' de androidx.compose.ui.graphics
// y las definiciones de colores estáticos si las usas (ej: Purple80, etc.)
// También necesitarás el archivo 'Typography.kt' y el archivo 'Color.kt'