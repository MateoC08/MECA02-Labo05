package com.pmtaller2.mecados05

import android.hardware.Sensor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import android.content.Context
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun useSensor(sensorType: Int): FloatArray {
    val context = LocalContext.current
    val sensorValues = remember { mutableStateOf(FloatArray(3)) }

    DisposableEffect(sensorType) {
        val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val sensor = sensorManager.getDefaultSensor(sensorType)

        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues.value = it.copyOf()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL)

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues.value
}

@Composable
fun GyroscopeSensor() {
    val gyroscopeValues = useSensor(Sensor.TYPE_GYROSCOPE)

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Giroscopio", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "X: ${gyroscopeValues[0]}", fontSize = 18.sp)
            Text(text = "Y: ${gyroscopeValues[1]}", fontSize = 18.sp)
            Text(text = "Z: ${gyroscopeValues[2]}", fontSize = 18.sp)
        }
    }
}
