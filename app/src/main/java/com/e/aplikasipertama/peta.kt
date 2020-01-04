package com.e.aplikasipertama

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class peta : Fragment(),OnMapReadyCallback, View.OnClickListener {
    lateinit var peta: LatLng

    lateinit var map: GoogleMap
    lateinit var mp: SupportMapFragment

    lateinit var normal:Button
    lateinit var satelit:Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_peta, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mp=childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mp.getMapAsync(this)

        normal=view.findViewById(R.id.button_normal)
        satelit=view.findViewById(R.id.button_satelit)

        normal.setOnClickListener(this)
        satelit.setOnClickListener(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        map=p0!!
//letak titik koordinat
        peta= LatLng(-7.7579177,110.4122818)
        map.addMarker((MarkerOptions().position(peta).title("Lawba techno indonesia")))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(peta,17F))

        val builder=LatLngBounds.Builder()
        builder.include(peta)
//  val bounds=builder.build()
//            map.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,5,5,5))
    }

    override fun onClick(p0: View?) {
        when (p0!!.id){
            R.id.button_normal ->{
                map.mapType= GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.button_satelit->{
                map.mapType=GoogleMap.MAP_TYPE_SATELLITE
            }
        }
    }
}
