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
import androidx.navigation.fragment.navArgs
import com.example.goaltrack.R
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.viewmodel.UserViewModel

class UpdateGoalFragment : Fragment() {
    //Getting the agruments
    private val args by navArgs<UpdateGoalFragmentArgs>()
    //Creating the view model
    private lateinit var mUserViewModel : UserViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_goal, container, false)
        //Initializing the view model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //Getting the views and then using the args to set the values
        val title = view.findViewById(R.id.etTitleEdit) as EditText
        val description = view.findViewById(R.id.etDescEdit) as EditText
        val date = view.findViewById(R.id.etDateEdit) as EditText
        val btnUpdate = view.findViewById(R.id.btnEditGoal) as Button
        val btnCancel = view.findViewById(R.id.btnCancelGoal) as Button
        val btnDelete = view.findViewById(R.id.btnDeleteGoal) as Button

        //setting the EditTexts
        title.setText(args.currentGoal.goalTitle)
        description.setText(args.currentGoal.goalDesc)
        date.setText(args.currentGoal.goalDate)

        //Setting the onClickListeners for the buttons
        btnUpdate.setOnClickListener {
            updateGoal(title, description, date)
        }

        btnDelete.setOnClickListener {
            deleteCurrentGoal(title,description,date)
        }
        btnCancel.setOnClickListener {
            findNavController().navigate(R.id.action_updateGoalFragment_to_homePage)
        }

        return view
    }

    private fun updateGoal(title: EditText, description: EditText, date: EditText) {
        if(checkInputs(title,description,date)){
            //If this is the case, we update the user into the database
            val goal: GoalData = GoalData(args.currentGoal.goalID,title.text.toString(), description.text.toString(), date.text.toString())
            mUserViewModel.updateGoal(goal)
            Toast.makeText(requireContext(),"Successfully updated the goal ${title.text.toString()}!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateGoalFragment_to_homePage)
        }
        else{
            Toast.makeText(requireContext(),"Please fill all the fields!",Toast.LENGTH_LONG).show()
        }
    }

    //Function to check inputs
    private fun checkInputs(goalTitle: EditText, goalDesc: EditText, goalDate: EditText): Boolean {
        return !(goalTitle.text.toString().isEmpty() || goalDesc.text.toString().isEmpty() || goalDate.text.toString().isEmpty())
    }

    private fun deleteCurrentGoal(
        title: EditText,
        description: EditText,
        date: EditText
    ) {
        val goal: GoalData = GoalData(args.currentGoal.goalID,title.text.toString(), description.text.toString(), date.text.toString())
        mUserViewModel.deleteGoal(goal)
        Toast.makeText(requireContext(),"Deleted the goal ${title.text.toString()}!",Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_updateGoalFragment_to_homePage)
    }
}