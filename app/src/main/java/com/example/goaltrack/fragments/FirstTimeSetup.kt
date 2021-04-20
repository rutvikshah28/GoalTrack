package com.example.goaltrack.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.goaltrack.R
import com.example.goaltrack.database.model.UserData
import com.example.goaltrack.database.viewmodel.UserViewModel

class FirstTimeSetup : Fragment(){
    //Declaring the mUserViewModel that we will need to insert the user data into database
    private lateinit var mUserViewModel : UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_first_time_setup,container,false)

        //Setting the view model
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        //Checking if this is a first time setup or not
        if(mUserViewModel.readUsers.value.isNullOrEmpty()){
            //We are in the first time setup
            val submit = view.findViewById(R.id.btnSubmitUser) as Button
            submit.setOnClickListener {
                insertUserToDatabase()
                Log.d("FirstTimeSetup", "We have done it!")
                findNavController().navigate(R.id.action_firstTimeSetup_to_homePage)
            }


        }
        else{
            Log.d("FirstTimeSetup", "Shouldn't get here for the first time :(")
            findNavController().navigate(R.id.action_firstTimeSetup_to_homePage)
        }
        return view
    }




    private fun insertUserToDatabase() {
        //getting the values of the user from EditTexts and Radio Buttons
        val fName = view?.findViewById(R.id.tvFname) as EditText
        val lName = view?.findViewById(R.id.tvLname) as EditText
        val gender = view?.findViewById(R.id.rgGender) as RadioGroup
        val genderVal = view?.findViewById(gender.checkedRadioButtonId) as RadioButton
        val bDate = view?.findViewById(R.id.etDate) as EditText
        val age = view?.findViewById(R.id.etAge) as EditText

        if(checkAllInputs(fName.text.toString(), lName.text.toString(), gender.checkedRadioButtonId, bDate.text.toString(), age.text.toString())) {
            //If inputs are all filled, we create the user object to insert
            val user: UserData = UserData(
                0,
                fName.text.toString(),
                lName.text.toString(),
                age.text.toString().toInt(),
                genderVal.text.toString(),
                bDate.text.toString()
            )

            //Using the view model to add the user now
            mUserViewModel.insertUser(user)
            //Creating a toast on successful insertion
            Toast.makeText(requireContext(), "Successfully added ${fName.text.toString()}", Toast.LENGTH_LONG).show()

        }
        else{
            Toast.makeText(requireContext(),"Please fill all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkAllInputs(fName: String, lName: String, gender: Int, bDate: String, age: String) : Boolean {
        return !(fName.isEmpty() || lName.isEmpty() || gender == -1 || bDate.isEmpty() || age.isEmpty())
    }
}