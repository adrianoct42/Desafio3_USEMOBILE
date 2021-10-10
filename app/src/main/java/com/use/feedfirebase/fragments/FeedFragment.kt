package com.use.feedfirebase.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.use.feedfirebase.FeedAdapter
import com.use.feedfirebase.Post
import com.use.feedfirebase.User
import com.use.feedfirebase.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    private val db = Firebase.firestore
    private val feedAdapter: FeedAdapter by lazy {
        FeedAdapter()
    }
    private lateinit var binding: FragmentFeedBinding
    private val ListaVazia: MutableList<Post> = mutableListOf()
    private val usuario1 = User("Adriano Chamon", 0, ListaVazia)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        buscaFirebase()

        var texto: String = ""
        var nome: String = usuario1.name

        binding.rvPosts.adapter = feedAdapter

        binding.btnPublicar.setOnClickListener {
            usuario1.numberPosts++
            texto = binding.postagem.text.toString()
            usuario1.post.add(Post(texto))
            feedAdapter.setList(usuario1.post)

            // Adicionando no Firebase

            db.collection("Postagens Do Usuário").add(usuario1).addOnSuccessListener {
                Log.d("FeedFragment", "Postagem feita com sucesso!!!")
            }.addOnFailureListener {
                Log.d("FeedFragment", "Erro! $it")
            }

        }
    }

    // Busca dados ja postados no Firebase:
    // No entanto, precisei comentar ela por apresentar o seguinte erro,
    // eu nao entender como resolvê-lo -->
    // java.lang.NullPointerException: null cannot be cast to non-null type kotlin.String

//    private fun buscaFirebase() {
//        db.collection("Postagens Do Usuário").get().addOnSuccessListener { posts ->
//            for (post in posts) {
//                Log.d("FeedFragment", post.data["text"] as String).toString()
//            }
//        }
//    }

    //        binding.postagem.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                texto = p0.toString()
//                usuario1.post.add(Post(texto))
//                FeedAdapter(usuario1.post)
//            }
//        })

}