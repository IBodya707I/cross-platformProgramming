package com.example.testkmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.*
import com.example.testkmp.ui.shared_mobile.main.MainScreen
import org.jetbrains.compose.resources.stringResource
import testkmp.composeapp.generated.resources.*

data class WindowInfo(val windowName: String, val windowState: WindowState)

@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
    System.setProperty("sun.awt.noerasebackground", "true")
    var initialized by remember { mutableStateOf(false) }
    var initialWindowNumber by remember { mutableStateOf(1) }
    var windowCount by remember { mutableStateOf(2) }
    val windowList = remember { SnapshotStateList<WindowInfo>() }
    val windowsName = stringResource(Res.string.app_name) + " $initialWindowNumber"

    if (!initialized) {
        windowList.add(WindowInfo(windowsName, rememberWindowState()))
        initialized = true
    }

    windowList.forEachIndexed { i, _ ->
        val currentWindow = if (i < windowList.size) windowList[i] else null
        
        if (currentWindow != null) {
            Window(
                onCloseRequest = {
                    if (i < windowList.size) windowList.removeAt(i)
                    if (windowList.isEmpty()) exitApplication()
                },
                state = currentWindow.windowState,
                title = currentWindow.windowName
            ) {
                MenuBar {
                    Menu(stringResource(Res.string.file), mnemonic = 'F') {
                        val nextWindowState = rememberWindowState()
                        val newWindowName = stringResource(Res.string.app_name) + " $windowCount"
                        Item(
                            stringResource(Res.string.new), onClick = {
                                windowCount++
                                windowList.add(
                                    WindowInfo(
                                        windowName = newWindowName,
                                        nextWindowState
                                    )
                                )
                            }, shortcut = KeyShortcut(
                                Key.N, ctrl = true
                            )
                        )
                        Item(stringResource(Res.string.close), onClick = {
                            if (i < windowList.size) windowList.removeAt(i)
                            if (windowList.isEmpty()) exitApplication()
                        }, shortcut = KeyShortcut(Key.W, ctrl = true))
                        Separator()
                        Item(
                            stringResource(Res.string.exit),
                            onClick = { 
                                windowList.clear()
                                exitApplication()
                            },
                            shortcut = KeyShortcut(Key.Q, ctrl = true)
                        )
                    }
                    Menu("Edit", mnemonic = 'E') {
                        Item(
                            "Cut", onClick = { }, shortcut = KeyShortcut(
                                Key.X, ctrl = true
                            )
                        )
                        Item(
                            "Copy", onClick = { }, shortcut = KeyShortcut(
                                Key.C, ctrl = true
                            )
                        )
                        Item("Paste", onClick = { }, shortcut = KeyShortcut(Key.V, ctrl = true))
                    }
                }
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}
