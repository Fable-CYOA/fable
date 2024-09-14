package com.fable.scene

interface SceneContainer {
    val currentScene: Scene

    fun setScene(scene: Scene)
}

class DefaultSceneContainer : SceneContainer {
    override lateinit var currentScene: Scene

    override fun setScene(scene: Scene) {
        currentScene = scene
    }
}
