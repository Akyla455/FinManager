package com.example.finmanager.presentation.navigation.bottomNavigation

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finmanager.presentation.ui.theme.Thistle


@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    currentRoute: String?,
    items: List<Screen>,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Thistle
    ) {
        items.forEach { screen ->

            NavigationBarItem(
                modifier = modifier,
                selected = currentRoute == screen.route,
                label = { Text(screen.title) },
                onClick = {
                    if (currentRoute != screen.route) {
                        onNavigate(screen.route)
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(20.dp)
                    )
                })
        }
    }
}