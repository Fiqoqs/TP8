package com.example.tp7

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Login : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    // Fungsi untuk navigasi ke HomePagee dan mengirim data username
    private fun navigateToHome(username: String) {
        val intent = Intent(activity, HomePagee::class.java)
        intent.putExtra("USERNAME", username) // Mengirim username ke HomePagee
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Temukan EditText untuk input username
        val etUsername = view.findViewById<EditText>(R.id.et_username)

        // Temukan tombol Login di layout
        val btnLogin = view.findViewById<Button>(R.id.login)

        // Set OnClickListener untuk tombol Login
        btnLogin.setOnClickListener {
            // Ambil input username dari EditText
            val username = etUsername.text.toString().trim()

            // Navigasi ke HomePagee saat tombol Login diklik, dan kirimkan username
            if (username.isNotEmpty()) {
                navigateToHome(username)
            } else {
                etUsername.error = "Please enter a username"
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
