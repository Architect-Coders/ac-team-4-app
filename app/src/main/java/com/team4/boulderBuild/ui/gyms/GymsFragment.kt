package com.team4.boulderBuild.ui.gyms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.team4.boulderBuild.R

class GymsFragment : Fragment() {

    private lateinit var gymsViewModel: GymsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gymsViewModel =
            ViewModelProviders.of(this).get(GymsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gyms, container, false)
        val textView: TextView = root.findViewById(R.id.text_gyms)
        gymsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}