package sg.edu.np.s10182489.game;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class TaskViewHolder extends RecyclerView.ViewHolder
{
    private TextView record;
    public View view;

    public TaskViewHolder(View v)
    {
        super(v);
        view = v;
        record = v.findViewById(R.id.scoreLabel);
    }

    public void setText(String s)
    {
        record.setText(s);
    }
}
