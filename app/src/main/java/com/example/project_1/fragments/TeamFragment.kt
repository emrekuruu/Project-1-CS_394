import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.adapter.TeamAdapter
import com.example.project_1.data.TeamDataSource

class TeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_teams, container, false)

        // Initialize the RecyclerView
        val recyclerView : RecyclerView = view.findViewById(R.id.teamsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val teams = context?.let { TeamDataSource(it).loadTeams() }
        recyclerView.adapter = teams?.let { TeamAdapter(it) }

        // Return the inflated layout
        return view
    }




}

