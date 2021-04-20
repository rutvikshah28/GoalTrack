package com.example.goaltrack.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.goaltrack.R
import com.example.goaltrack.database.model.GoalData
import com.example.goaltrack.database.viewmodel.UserViewModel

class RVListAdapter : RecyclerView.Adapter<RVListAdapter.RowViewHolder>() {

    //Creating an empty goal list
    private var goalList = emptyList<GoalData>()

    class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        //Here we return the ViewHolder and we inflate the custom row layout for goals that we made inside it
       return RowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.goal_row,parent,false))
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        //Creating current goal var
        var currentGoal = goalList[position]
        //Getting the row by findViewById
        var title = holder.itemView.findViewById(R.id.tvTitle) as TextView
        var dueDate = holder.itemView.findViewById(R.id.tvDate) as TextView
        var rowLayout = holder.itemView.findViewById(R.id.goalRowLayout) as ConstraintLayout
        //setting the text from current item
        title.text = currentGoal.goalTitle.toString()
        dueDate.text = currentGoal.goalDate.toString()
        //Setting the onClickListener for selected Goal to edit
        rowLayout.setOnClickListener{
            //We get the action into the actionToDO variable for the currentGoal and then user navigate for that action
            val actionToDo = HomePageDirections.actionHomePageToUpdateGoalFragment(currentGoal)
            holder.itemView.findNavController().navigate(actionToDo)
        }

    }

    override fun getItemCount(): Int {
        //Returning the size of the goal list
        return goalList.size
    }

    //Function to set the data
    fun setData(goals:List<GoalData>){
        //We set the goalList to goals and then notify that data has changed
        this.goalList = goals
        notifyDataSetChanged()
    }


}