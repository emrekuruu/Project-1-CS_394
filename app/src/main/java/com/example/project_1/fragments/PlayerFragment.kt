import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_1.R
import com.example.project_1.adapter.PlayerAdapter
import com.example.project_1.data.PlayerDataSource

class PlayerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_players, container, false)

        // Initialize the RecyclerView
        val recyclerView : RecyclerView = view.findViewById(R.id.playersRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val players = context?.let { PlayerDataSource(it).loadPlayers() }
        recyclerView.adapter = players?.let { PlayerAdapter(it) }

        // Return the inflated layout
        return view
    }




}

