package com.team2898.engine.logic

import com.team2898.engine.async.AsyncLooper
import com.team2898.engine.async.util.go

abstract class Subsystem(val loopHz: Double, name: String) : ILooper, ISelfCheck {

    override val loop: AsyncLooper =
        AsyncLooper(loopHz) { onLoop() }

    //abstract val loopHz: Double
    override abstract val enableTimes: List<GamePeriods>

    init {
        LoopManager.register(this) // TODO: Figure out of the leaky 'this' is much of an issue
    }


    fun startLoop() {
        onStart()
    }

    fun stopLoop() {
        onStop()
    }

    override abstract fun onStart()
    abstract fun onLoop()
    override abstract fun onStop()

}