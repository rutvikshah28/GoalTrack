package com.example.goaltrack.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goaltrack.R
import com.example.goaltrack.database.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomePage : Fragment() {
    //Creating the UserViewModel
    private lateinit var mUserViewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_home_page,container,false)

        //Initializing the UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //Setting a random quote from our quotes database here
        val quoteIndex = (0..19).random()
        //Getting the view for our quotes from home fragment
        val quoteView = view.findViewById(R.id.tvQuotes) as TextView
        //Getting the quotes from the database

        //Setting the random quote
        var quotes = listOf<String>("All our dreams can come true, if we have the courage to pursue them.",
            "The secret of getting ahead is getting started.",
            "The best time to plant a tree was 20 years ago. The second best time is now.",
            "It’s hard to beat a person who never gives up.",
            "If people are doubting how far you can go, go so far that you can’t hear them anymore.",
            "Whatever you are, be a good one.",
            "Do what you feel in your heart to be right – for you’ll be criticized anyway.",
            "Your passion is waiting for your courage to catch up.",
            "If something is important enough, even if the odds are stacked against you, you should still do it.",
            "Hold the vision, trust the process.",
            "Just another Magic Monday",
            "Invest in your dreams. Grind now. Shine later.",
            "Hustle in silence and let your success make the noise.",
            "If you hear a voice within you say ‘you cannot paint,’ then by all means paint and that voice will be silenced.",
            "Very often, a change of self is needed more than a change of scene.",
            "In a gentle way, you can shake the world.",
            "If opportunity doesn’t knock, build a door.",
            "Work hard, be kind, and amazing things will happen.",
            "In the middle of every difficulty lies opportunity.",
            "Start where you are. Use what you have. Do what you can.")
        //Changing a random quote
        quoteView.text = quotes[quoteIndex]

        //Initializing the Adapter
        val rvListAdapter = RVListAdapter()
        //Creating the recycler view
        val recyclerView = view.findViewById(R.id.rvGoals) as RecyclerView
        recyclerView.adapter = rvListAdapter
        //Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //Observing the goals and calling the setData function using our list adapter
        mUserViewModel.readGoals.observe(viewLifecycleOwner, Observer {
            goal -> rvListAdapter.setData(goal);
        })
        //Setting the onClickListener for our floating add button
        val addButton = view.findViewById(R.id.fabAddGoal) as FloatingActionButton
        addButton.setOnClickListener{
            //We simply navigate to add goal fragment
            findNavController().navigate(R.id.action_homePage_to_addGoal)
        }

        //Returning the inflated view
        return view
    }

}