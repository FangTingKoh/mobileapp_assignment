package sg.edu.np.s10182489.game;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class listview extends AppCompatActivity
{
    ArrayList<String> data = new ArrayList<String>();
    RecyclerView rv;
    ScoreAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        rv = findViewById(R.id.rvScore);
        sa = new ScoreAdapter(this, data);//creating the adapter
        LinearLayoutManager mLayout = new LinearLayoutManager(this);//These 2 lines is to clean the layout for multiple rows and column
        rv.setLayoutManager(mLayout);
        rv.setItemAnimator(new DefaultItemAnimator());// populate the recyclerview with animations and allows us to put in animations.
        rv.setAdapter(sa);

    }
    public void add(View v)
    {

    }
}
