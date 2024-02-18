package com.example.homework4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import com.example.homework4.databinding.FragmentYBinding
import com.google.android.material.snackbar.Snackbar

class YFragment : Fragment() {
    private lateinit var binding: FragmentYBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentYBinding.inflate(inflater, container, false)

        val backPress = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Snackbar.make(view!!,"Do you want to go back to the homepage?", Snackbar.LENGTH_SHORT)
                    .setAction("YES"){
                        isEnabled = false
                        Navigation.findNavController(requireView()).navigate(R.id.action_YFragment_to_homeFragment)
                    }
                    .show() }}
        requireActivity().onBackPressedDispatcher.addCallback ( viewLifecycleOwner, backPress)
        return binding.root
    }
}