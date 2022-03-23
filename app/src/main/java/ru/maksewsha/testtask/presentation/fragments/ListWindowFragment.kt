package ru.maksewsha.testtask.presentation.fragments

import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.maksewsha.testtask.R
import ru.maksewsha.testtask.presentation.elements.CharactersRecyclerAdapter
import ru.maksewsha.testtask.presentation.models.CharacterPresentation
import ru.maksewsha.testtask.presentation.viewmodels.CharacterViewModel

class ListWindowFragment : Fragment(R.layout.list_window_fragment) {
    private val viewModel by activityViewModels<CharacterViewModel>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var errorTextView: TextView
    private lateinit var loadingBar: ProgressBar
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = requireView().findViewById(R.id.list_recycler_view)
        errorTextView = requireView().findViewById(R.id.list_error_text)
        loadingBar = requireView().findViewById(R.id.list_progress_bar)
        recyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getAllCharacters()

        viewModel.characterList.observe(viewLifecycleOwner, object: Observer<List<CharacterPresentation>>{
            override fun onChanged(t: List<CharacterPresentation>?) {
                loadingBar.visibility = View.GONE
                recyclerView.adapter = CharactersRecyclerAdapter(t as List<CharacterPresentation>)
            }
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, object: Observer<String>{
            override fun onChanged(t: String?) {
                loadingBar.visibility = View.GONE
                errorTextView.text = t
            }

        })
    }
}