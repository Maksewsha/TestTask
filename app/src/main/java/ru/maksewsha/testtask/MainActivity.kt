package ru.maksewsha.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import ru.maksewsha.testtask.presentation.fragments.ListWindowFragment
import ru.maksewsha.testtask.presentation.viewmodels.CharacterViewModel
import ru.maksewsha.testtask.presentation.viewmodels.CharacterViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var charactersViewModel: CharacterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        charactersViewModel = ViewModelProvider(this, CharacterViewModelFactory())[CharacterViewModel::class.java]
        supportFragmentManager.beginTransaction().replace(R.id.main_activity_container, ListWindowFragment()).commit()
    }
}