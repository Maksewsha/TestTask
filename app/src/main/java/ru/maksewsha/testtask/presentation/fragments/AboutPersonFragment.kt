package ru.maksewsha.testtask.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import ru.maksewsha.testtask.R
import ru.maksewsha.testtask.presentation.models.CharacterPresentation
import ru.maksewsha.testtask.presentation.viewmodels.CharacterViewModel

class AboutPersonFragment(private val character: CharacterPresentation) : Fragment(R.layout.about_window_fragment) {
    private val viewModel by activityViewModels<CharacterViewModel>()

    private lateinit var nameTextView: TextView
    private lateinit var imgImageView: ImageView
    private lateinit var nicknameTextView: TextView
    private lateinit var birthdayTextView: TextView
    private lateinit var actorTextView: TextView
    private lateinit var statusTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nameTextView = view.findViewById(R.id.about_person_name)
        imgImageView = view.findViewById(R.id.about_person_image)
        nicknameTextView = view.findViewById(R.id.about_person_nickname)
        birthdayTextView = view.findViewById(R.id.about_person_birthday)
        actorTextView = view.findViewById(R.id.about_person_actor)
        statusTextView = view.findViewById(R.id.about_person_status)

        nameTextView.text = character.name
        Glide.with(view).load(character.img).override(512, 512).into(imgImageView)
        nicknameTextView.text = character.nickname
        birthdayTextView.text = "Birthday: ${character.birthday}"
        actorTextView.text = "Actor: ${character.portrayed}"
        statusTextView.text = "Now is ${character.status.lowercase()}"
        super.onViewCreated(view, savedInstanceState)
    }
}