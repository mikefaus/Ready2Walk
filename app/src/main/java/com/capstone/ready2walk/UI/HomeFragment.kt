package com.capstone.ready2walk.UI


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import com.capstone.ready2walk.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        trainingButton.setOnClickListener {
            // make training button go to the sampling fragment
            val action = HomeFragmentDirections.actionStartSampling()
            Navigation.findNavController(it).navigate(action)
        }
        filesButton.setOnClickListener {
            // make files button go to the files fragment
            val action = HomeFragmentDirections.actionHomeFragmentToFilesFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }

}
