package com.example.goaltrack.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.goaltrack.R
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.viewmodel.UserViewModel

class AddGoal : Fragment() {
    //Creating the view model
    private lateinit var mUserViewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_goal, container, false)

        //Initializing the UserViewModel here
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val addGoalButton = view.findViewById(R.id.btnAddGoal) as Button
        //Setting the onClickListener for our add button
        addGoalButton.setOnClickListener {
            //Calling the insertGoalToDatabase function to insert the goal into our database
            insertGoalToDatabase()
        }
        //Returning the inflated view
        return view
    }

    //Function to insert a goal into the database
    private fun insertGoalToDatabase() {
        //Getting the views needed to insert the goal into the database
        val goalTitle = view?.findViewById(R.id.etTitleAdd) as EditText
        val goalDate = view?.findViewById(R.id.etDateAdd) as EditText
        val goalDesc = view?.findViewById(R.id.etDescAdd) as EditText

        if(checkInputs(goalTitle, goalDesc, goalDate)){
            //If all fields are filled, then we add the goal to database
            val goal: GoalData = GoalData(0,goalTitle.text.toString(), goalDesc.text.toString(), goalDate.text.toString())
            //Inserting the goal to our database
            mUserViewModel.insertGoal(goal)
            //Once done we notify the user with an appropriate toast
            Toast.makeText(requireContext(),"Successfully added a goal ${goalTitle.text.toString()}", Toast.LENGTH_LONG).show()
            // We now navigate back to the home fragment
            findNavController().navigate(R.id.action_addGoal_to_homePage)
        }
        else{
            //If input check fails we display and appropriate toast
            Toast.makeText(requireContext(),"Please fill all fields!",Toast.LENGTH_LONG).show()
        }
    }
    //Function to check all the inputs
    private fun checkInputs(
        goalTitle: EditText,
        goalDesc: EditText,
        goalDate: EditText,
    ): Boolean {
        return !(goalTitle.text.toString().isEmpty() || goalDesc.text.toString().isEmpty() || goalDate.text.toString().isEmpty())
    }

}