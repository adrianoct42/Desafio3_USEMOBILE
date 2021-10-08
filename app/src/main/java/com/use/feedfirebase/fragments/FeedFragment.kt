package com.use.feedfirebase.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.use.feedfirebase.Post
import com.use.feedfirebase.User
import com.use.feedfirebase.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    val db = Firebase.firestore
    private lateinit var binding: FragmentFeedBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Firebase.firestore
        val ListaVazia = ArrayList<Post>()
        val usuario1 = User("Adriano Chamon", 0, ListaVazia)

        fun publica(text: String) {
            db.collection("Postagens").add(usuario1).addOnSuccessListener {
                Log.d("FeedFragment", "Post realizado com sucesso!")
            }.addOnFailureListener {
                Log.d("FeedFragment", "Erro! $it")
            }
        }

    }



//    companion object {
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            FeedFragment().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
}