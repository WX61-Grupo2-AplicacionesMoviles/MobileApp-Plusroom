package com.example.mobileapp_plusroom

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.bottomnavigation.BottomNavigationView

class CustomBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BottomNavigationView(context, attrs, defStyleAttr) {

    init {
        // Desactivar la escucha de insets para evitar el espacio adicional
        setOnApplyWindowInsetsListener(null)
        // Establecer padding a 0
        setPadding(0, 0, 0, 0)
    }
}
