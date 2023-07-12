package com.dikamahard.gymify.ui.info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dikamahard.gymify.LoginActivity
import com.dikamahard.gymify.R
import com.dikamahard.gymify.databinding.FragmentInfoBinding
import com.dikamahard.gymify.helper.SessionPref

class InfoFragment : Fragment() {

    private var _binding: FragmentInfoBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val infoViewModel =
            ViewModelProvider(this).get(InfoViewModel::class.java)

        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val pref = SessionPref(requireContext())

//        val textView: TextView = binding.textInfo
//        infoViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//        val btnOut = view?.findViewById<Button>(R.id.btn_logout)

        val token = "Bearer " + pref.getUserData(SessionPref.TOKEN)

        binding.btnLogout.setOnClickListener {
            Log.d("LOGOUT", "onCreateView: LOGOUT press")
            infoViewModel.logoutUser(token)
            startActivity(Intent(activity, LoginActivity::class.java))
            activity?.finish()
        }

        infoViewModel.logoutUser.observe(viewLifecycleOwner) { logoutUser ->
//            if (logoutUser != null) {
//                if (logoutUser.error) {
//                    Log.d("LOGOUT", "onCreateView: LOGOUT done")
//                    startActivity(Intent(activity, LoginActivity::class.java))
//                    activity?.finish()
//                }
//            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}