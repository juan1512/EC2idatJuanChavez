package com.juan.ec2_dam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.juan.ec2_dam2.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMapBinding
    private lateinit var googleMap : GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMap = supportFragmentManager.findFragmentById(R.id.fcv_map) as SupportMapFragment
        fragmentMap.getMapAsync(this)
    }
    override fun onMapReady(map: GoogleMap) {
        googleMap = map
        val CubosCentroLocation = LatLng(-12.056840887652125, -77.0383392415395 )
        val CubosNorteLocation = LatLng(-11.993794223475598, -77.06297614267609)
        val CubosSurLocation = LatLng(-12.127042558683364, -77.00003230348524)

        googleMap.addMarker(MarkerOptions().position(CubosCentroLocation).title("Tienda de Cubos Rubik de Lima Centro Perú"))
        googleMap.addMarker(MarkerOptions().position(CubosNorteLocation).title(" Tienda de Cubos mágicos de Rubik en Independencia Lima Perú"))
        googleMap.addMarker(MarkerOptions().position(CubosSurLocation).title(" Tienda de Cubos Rubik de Surco Lima  Perú"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(CubosCentroLocation))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(CubosNorteLocation))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(CubosSurLocation))

    }
}