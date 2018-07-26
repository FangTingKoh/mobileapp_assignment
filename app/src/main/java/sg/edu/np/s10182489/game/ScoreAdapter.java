package sg.edu.np.s10182489.game;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<TaskViewHolder>
{
    private List<String> recordlist;
    private Context context;

    public ScoreAdapter(Context c, List<String> l)
    {
        context = c;
        recordlist = l;
    }

    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_scorelayout, parent , false );
        return new TaskViewHolder(item);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, final int position)
    {
        String s = recordlist.get(position);
        holder.setText(s);
    }

    public int getItemCount()
    {
        return recordlist.size();
    }
}
